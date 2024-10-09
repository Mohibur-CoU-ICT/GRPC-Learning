package com.mohibur.test.sec06;

import com.google.common.util.concurrent.Uninterruptibles;
import com.mohibur.models.sec06.AccountBalance;
import com.mohibur.models.sec06.DepositRequest;
import com.mohibur.models.sec06.Money;
import com.mohibur.test.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Lec04ClientStreamingTest extends AbstractTest {

    @Test
    public void depositTest() {
        var responseObserver = ResponseObserver.<AccountBalance>create();
        var requestObserver = this.bankStub.deposit(responseObserver);

        // initial message - account number
        requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(5).build());
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        requestObserver.onError(new RuntimeException());

        // sending stream of money
        IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Money.newBuilder().setAmount(10).build())
                .map(m -> DepositRequest.newBuilder().setMoney(m).build())
                .forEach(requestObserver::onNext);
        // notifying the server that we are done
        requestObserver.onCompleted();

        // at this point our response observer should receive a response
        responseObserver.await();

        Assertions.assertEquals(1, responseObserver.getItems().size());
        Assertions.assertEquals(200, responseObserver.getItems().getFirst().getBalance());
        Assertions.assertNull(responseObserver.getThrowable());
    }
}
