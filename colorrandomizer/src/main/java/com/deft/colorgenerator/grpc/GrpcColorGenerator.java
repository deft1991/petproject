package com.deft.colorgenerator.grpc;

import com.deft.colorgenerator.service.ColorGenerator;
import com.deft.grpc.ColorGeneratorGrpc;
import com.deft.grpc.ColorGeneratorService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

import java.util.Random;

/**
 * @author Sergey Golitsyn
 * created on 7/27/21
 */

@Slf4j
@GRpcService
@RequiredArgsConstructor
public class GrpcColorGenerator extends ColorGeneratorGrpc.ColorGeneratorImplBase {

    private final ColorGenerator colorGenerator;

    @Override
    public void getRandomColor(ColorGeneratorService.CurrentColor request, StreamObserver<ColorGeneratorService.NewColor> responseObserver) {
        // create random object - reuse this as often as possible
        Random random = new Random();

        // create a big random number - maximum is ffffff (hex) = 16777215 (dez)
        int nextInt = random.nextInt(0xffffff + 1);

        // format it as hexadecimal string (with hashtag and leading zeros)
        String randomColor = String.format("#%06x", nextInt);
        responseObserver.onNext(ColorGeneratorService.NewColor.newBuilder().setColor(randomColor).build());
        responseObserver.onCompleted();
    }
}
