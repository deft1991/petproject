package com.deft.grpcclient.grpc.impl;

import com.deft.grpc.ProfileDescriptorOuterClass;
import com.deft.grpc.ProfileServiceGrpc;
import com.deft.grpcclient.grpc.GrpcProfileClient;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergey Golitsyn
 * created on 6/28/21
 */

@Slf4j
public class GrpcProfileClientImpl implements GrpcProfileClient {

    private static final String HOST = "localhost";
    private static final int PORT = 7777;
    private static final String TARGET = HOST + ":" + PORT;


    private final ProfileServiceGrpc.ProfileServiceBlockingStub blockingStub;
    private final ProfileServiceGrpc.ProfileServiceStub asyncStub;

    public GrpcProfileClientImpl() {
        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(TARGET)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        blockingStub = ProfileServiceGrpc.newBlockingStub(channel);
        asyncStub = ProfileServiceGrpc.newStub(channel);
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    public GrpcProfileClientImpl(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = ProfileServiceGrpc.newBlockingStub(channel);
        asyncStub = ProfileServiceGrpc.newStub(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build());
    }


    @Override
    public void getCurrentProfile() {
        try {
            log.info("Will try to getCurrentProfile");
            Empty request = Empty.newBuilder().build();
            ProfileDescriptorOuterClass.ProfileDescriptor currentProfile = blockingStub.getCurrentProfile(request);
            log.info("Current profile: " + currentProfile.getName());
        } catch (StatusRuntimeException ex) {
            log.error("RPC failed: {}", ex.getStatus());
            // do what you want with exception
        }
    }

    @SneakyThrows
    @Override
    public void clientStream(int times) {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty profileDescriptor) {
                log.info("Finished responseObserver.clientStream");
            }

            @Override
            public void onError(Throwable t) {
                Status status = Status.fromThrowable(t);
                log.warn("ClientStream Failed: {}", status);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("Finished ClientStream");
                finishLatch.countDown();
            }
        };

        StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> requestObserver = asyncStub.clientStream(responseObserver);
        try {
            // Send numPoints points randomly selected from the features list.
            Random rand = new Random();
            for (int i = 0; i < times; ++i) {
                ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor = ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setName("Client Profile")
                        .setProfileId(i)
                        .build();
                requestObserver.onNext(profileDescriptor);
                // Sleep for a bit before sending the next one.
                Thread.sleep(rand.nextInt(1000) + 500);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return;
                }
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        finishLatch.await(1, TimeUnit.MINUTES);
    }

    /**
     * Если использовать blockingStub, то мы дожидаемся всех ответов от сервера и потом выводим их на экран
     */
    @Override
    public void serverStreamBlockingStub() {
        Iterator<ProfileDescriptorOuterClass.ProfileDescriptor> profiles = Collections.emptyIterator();
        try {
            profiles = blockingStub.serverStream(Empty.newBuilder().build());
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }

        profiles.forEachRemaining(profileDescriptor -> log.info("Profile from server: {}",
                profileDescriptor.getProfileId()));
    }

    @SneakyThrows
    @Override
    public void serverStreamAsyncStub() {
        log.info("*** ServerStreamAsyncStub");

        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> requestObserver =
                asyncStub.biDirectionalStream(new StreamObserver<>() {
                    @Override
                    public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                        log.info("Got message Profile Id {}", profileDescriptor.getProfileId());
                    }

                    @Override
                    public void onError(Throwable t) {
                        log.warn("ServerStreamAsyncStub Failed: {}", Status.fromThrowable(t));
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        log.info("Finished ServerStreamAsyncStub");
                        finishLatch.countDown();
                    }
                });

        asyncStub.serverStream(Empty.newBuilder().build(), requestObserver);

        // Receiving happens asynchronously
        finishLatch.await(1, TimeUnit.MINUTES);
    }


    @SneakyThrows
    @Override
    public void biDirectionalStream() {
        log.info("*** BiDirectionalStream");

        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> requestObserver =
                asyncStub.biDirectionalStream(new StreamObserver<>() {
                    @Override
                    public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                        log.info("Got message Profile Id {}", profileDescriptor.getProfileId());
                    }

                    @Override
                    public void onError(Throwable t) {
                        log.warn("BiDirectionalStream Failed: {}", Status.fromThrowable(t));
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        log.info("Finished BiDirectionalStream");
                        finishLatch.countDown();
                    }
                });

        try {
            for (int i = 0; i < 5; i++) {
                ProfileDescriptorOuterClass.ProfileDescriptor build = ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setProfileId(i)
                        .build();
                requestObserver.onNext(build);

            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        finishLatch.await(1, TimeUnit.MINUTES);
    }
}
