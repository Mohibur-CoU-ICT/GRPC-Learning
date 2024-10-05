package com.mohibur.common;

import com.mohibur.sec06.BankService;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
