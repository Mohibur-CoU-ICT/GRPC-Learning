package com.mohibur.sec02;

import com.mohibur.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(final String[] args) {

        // create person
        var person1 = createPerson();

        // create another instance with same values
        var person2 = createPerson();

        // compare
        log.info("Equals {}", person1.equals(person2));
        log.info("== {}", person1 == person2);

        // mutable? No
        // person1.setName() // because set method is not available

        // create another instance with diff values
        Person person3 = person1.toBuilder().setName("Mosiur").build();

        // compare
        log.info("Equals {}", person1.equals(person3));
        log.info("== {}", person1 == person3);

        // null?
//        var person4 = person1.toBuilder().setName(null).build(); // will throw null pointer exception
        var person4 = person1.toBuilder().clearName().build();
        log.info("person4 {}", person4);
    }

    private static Person createPerson() {
        return Person.newBuilder().setName("Mohibur").setAge(28).build();
    }
}
