package org.apache.geode_examples.repo;

import org.apache.geode_examples.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    Customer findByName(String name);
}
