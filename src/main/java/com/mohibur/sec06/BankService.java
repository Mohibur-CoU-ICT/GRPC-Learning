package com.mohibur.sec06;

import com.mohibur.models.sec06.AccountBalance;
import com.mohibur.models.sec06.BalanceCheckRequest;
import com.mohibur.models.sec06.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        super.getAccountBalance(request, responseObserver);
    }
}
