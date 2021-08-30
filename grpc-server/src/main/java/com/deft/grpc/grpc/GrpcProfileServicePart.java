//package com.deft.grpc.grpc;
//
//import com.deft.grpc.ProfileDescriptorOuterClass;
//import com.deft.grpc.ProfileServiceGrpc;
//import com.google.protobuf.Any;
//import com.google.protobuf.Empty;
//import io.grpc.stub.StreamObserver;
//import org.lognet.springboot.grpc.GRpcService;
//
///**
// * @author Sergey Golitsyn
// * created on 17.08.2021
// */
//
//@GRpcService
//public class GrpcProfileServicePart extends ProfileServiceGrpc.ProfileServiceImplBase {
//
//    @Override
//    public void getCurrentProfile(Any request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
//        try {
//            ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor = ProfileDescriptorOuterClass.ProfileDescriptor
//                    .newBuilder()
//                    .setProfileId(1L)
//                    .setName("Test")
//                    .build();
//            responseObserver.onNext(profileDescriptor);
//            responseObserver.onCompleted();
//        } catch (Exception ex) {
//            responseObserver.onError(ex);
//        }
//    }
//
//    @Override
//    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> clientStream(StreamObserver<Empty> responseObserver) {
//        return new StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor>() {
//            @Override
//            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor value) {
//                // values from client
//                System.out.println("ProfileDescriptor id = " + value.getProfileId() + " , name = " +  value.getName());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                //
//            }
//
//            @Override
//            public void onCompleted() {
//                responseObserver.onCompleted();
//            }
//        };
//    }
//
//    @Override
//    public void serverStream(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
//        for (int i = 0; i < 100; i++){
//            ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor = ProfileDescriptorOuterClass.ProfileDescriptor
//                    .newBuilder()
//                    .setProfileId(i)
//                    .setName("Profile Name " + i)
//                    .build();
//            responseObserver.onNext(profileDescriptor);
//        }
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> biDirectionalStream(StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
//        return new StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor>() {
//            @Override
//            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor value) {
//                // values from client
//                System.out.println("ProfileDescriptor id = " + value.getProfileId() + " , name = " +  value.getName());
//                ProfileDescriptorOuterClass.ProfileDescriptor dto = ProfileDescriptorOuterClass.ProfileDescriptor
//                        .newBuilder()
//                        .setProfileId(value.getProfileId())
//                        .setName("From Server: " + value.getName())
//                        .build();
//                responseObserver.onNext(dto);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                //
//            }
//
//            @Override
//            public void onCompleted() {
//                responseObserver.onCompleted();
//            }
//        };
//    }
//}
