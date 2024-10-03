package com.mohibur.sec01;

import com.mohibur.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {
    private static Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(final String[] args) {

        var person = PersonOuterClass.Person.newBuilder().setName("Mohibur").setAge(28).build();

        log.info("{}", person);

    }
}
