package com.mohibur.sec03;

import com.mohibur.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setLastName("Mohibur")
//                .setAge(28)
                .setEmail("mohibur@gmail.com")
                .setEmployed(true)
                .setSalary(10000.50)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        log.info("{}", person);
    }
}
