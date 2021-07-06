package com.deft.grpcclient.grpc;

/**
 * @author Sergey Golitsyn
 * created on 7/5/21
 */
public interface GrpcProfileClient {

    void getCurrentProfile();

    void deleteCurrentProfile();

    void clientStream(int times);

    void serverStreamBlockingStub();

    void serverStreamAsyncStub();

    void biDirectionalStream();
}
