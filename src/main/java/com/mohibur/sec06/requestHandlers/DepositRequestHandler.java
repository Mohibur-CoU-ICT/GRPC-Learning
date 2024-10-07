package com.mohibur.sec06.requestHandlers;

import com.mohibur.models.sec06.DepositRequest;
import io.grpc.stub.StreamObserver;

public class DepositRequestHandler implements StreamObserver<DepositRequest> {
    @Override
    public void onNext(DepositRequest depositRequest) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
}
