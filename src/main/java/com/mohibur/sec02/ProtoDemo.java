package com.mohibur.sec02;

import com.mohibur.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(final String[] args) {

        var person = Person.newBuilder().setName("Mohibur from sec 02").setAge(28).build();

        log.info("{}", person);

    }
}
