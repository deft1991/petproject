package com.deft.grpc.grpc;

import com.deft.grpc.ProfileDescriptorOuterClass;
import com.deft.grpc.ProfileServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

/**
 * @author Sergey Golitsyn
 * created on 6/28/21
 */

@Slf4j
@GRpcService
public class GrpcProfileService extends ProfileServiceGrpc.ProfileServiceImplBase {

    @Override
    public void getCurrentProfile(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        System.out.println("getCurrentProfile");
        responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                .newBuilder()
                .setProfileId(1)
                .setName("test")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCurrentProfile(Empty request, StreamObserver<Empty> responseObserver) {
        System.out.println("getCurrentProfile");
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> clientStream(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<>() {

            @Override
            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                log.info("ProfileDescriptor from client. Profile id: {}", profileDescriptor.getProfileId());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void serverStream(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        for (int i = 0; i < 5; i++) {
            responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                    .newBuilder()
                    .setProfileId(i)
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> biDirectionalStream(
            StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {

        return new StreamObserver<>() {
            int pointCount = 0;

            @Override
            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                log.info("biDirectionalStream, pointCount {}", pointCount);
                responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setProfileId(pointCount++)
                        .build());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
