package org.apache.geode_examples.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.util.concurrent.atomic.AtomicLong;


@Data
@Region("Customers")
public class Customer {

    private static AtomicLong COUNTER = new AtomicLong();

    @Id
    private Long id;
    private String name;
    private String organization;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(String name) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
    }
}
