package com.mohibur.sec03;

import com.mohibur.models.sec03.Address;
import com.mohibur.models.sec03.School;
import com.mohibur.models.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {
    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);

    public static void main(String[] args) {
        // create student
        var address = Address.newBuilder()
                .setStreet("123 main st")
                .setCity("atlanto")
                .setState("GA")
                .build();
        var student = Student.newBuilder()
                .setName("sam")
                .setAddress(address)
                .build();
        // crate a school
        var school = School.newBuilder()
                .setId(1)
                .setName("high school")
                .setAddress(address.toBuilder().setStreet("234 main st"))
                .build();

        log.info("school: {}", school);
        log.info("student: {}", student);
    }

}
