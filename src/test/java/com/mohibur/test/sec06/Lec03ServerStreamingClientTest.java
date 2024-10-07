package com.mohibur.test.sec06;

import com.mohibur.models.sec06.WithdrawRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec03ServerStreamingClientTest extends AbstractTest {
    public static final Logger log = LoggerFactory.getLogger(Lec03ServerStreamingClientTest.class);

    @Test
    public void blockingClintWithdrawTest() {
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(2)
                .setAmount(20)
                .build();
        var iterator = this.blockingStub.withdraw(request);
        int count = 0;
        while (iterator.hasNext()) {
            log.info("received money: {}", iterator.next());
            count++;
        }
        Assertions.assertEquals(2, count);
    }
}
