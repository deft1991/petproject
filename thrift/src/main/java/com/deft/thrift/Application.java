package com.deft.thrift;

import org.apache.thrift.transport.TTransportException;
/**
 * @author Sergey Golitsyn
 * created on 06.10.2020
 */

public class Application {

    public static void main(String[] args) throws TTransportException {
        CrossPlatformServiceServer server = new CrossPlatformServiceServer();
        server.start();
    }
}
