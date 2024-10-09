package com.mohibur.sec06;

import com.mohibur.models.sec06.TransferRequest;
import com.mohibur.models.sec06.TransferResponse;
import com.mohibur.models.sec06.TransferServiceGrpc;
import io.grpc.stub.StreamObserver;

public class TransferService extends TransferServiceGrpc.TransferServiceImplBase {
    @Override
    public StreamObserver<TransferRequest> transfer(StreamObserver<TransferResponse> responseObserver) {
        return super.transfer(responseObserver);
    }
}
