package com.mohibur.sec03;

import com.mohibur.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {
        var person = Person.newBuilder()
                .setLastName("Mohibur")
                .setAge(28)
                .setEmail("mohibur@gmail.com")
                .setEmployed(true)
                .setSalary(10000.50)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        log.info("{}", person);
        serialize(person);
        log.info("{}", deserialize());
        log.info("equals : {}", person.equals(deserialize()));
        log.info("bytes length : {}", person.toByteArray().length);
    }

    public static void serialize(Person person) throws IOException {
        person.writeTo(Files.newOutputStream(PATH));
    }

    public static Person deserialize() throws IOException {
        return Person.parseFrom(Files.newInputStream(PATH));
    }
}
