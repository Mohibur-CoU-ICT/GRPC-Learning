package com.mohibur.test.sec06;

import com.mohibur.common.GrpcServer;
import com.mohibur.models.sec06.BankServiceGrpc;
import com.mohibur.models.sec06.TransferServiceGrpc;
import com.mohibur.sec06.BankService;
import com.mohibur.sec06.TransferService;
import com.mohibur.test.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest extends AbstractChannelTest {
    private final GrpcServer grpcServer = GrpcServer.create(new BankService(), new TransferService());
    protected BankServiceGrpc.BankServiceStub bankStub;
    protected BankServiceGrpc.BankServiceBlockingStub bankBlockingStub;
    protected TransferServiceGrpc.TransferServiceStub transferStub;

    @BeforeAll
    public void setup() {
        this.grpcServer.start();
        this.bankStub = BankServiceGrpc.newStub(channel);
        this.bankBlockingStub = BankServiceGrpc.newBlockingStub(channel);
        this.transferStub = TransferServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop() {
        this.grpcServer.stop();
    }
}
