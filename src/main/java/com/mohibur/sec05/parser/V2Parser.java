package com.mohibur.sec05.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mohibur.models.sec05.v2.Television;
import com.mohibur.sec05.V1VersionCompatibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2Parser {
    private static final Logger log = LoggerFactory.getLogger(V2Parser.class);

    public static void parse(byte[] bytes) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(bytes);
        log.info("brand: {}", tv.getBrand());
        log.info("model: {}", tv.getModel());
        log.info("type: {}", tv.getType());
    }
}
