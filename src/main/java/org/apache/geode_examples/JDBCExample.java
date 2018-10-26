package org.apache.geode_examples;

import org.apache.geode_examples.model.Customer;
import org.apache.geode_examples.repo.CustomerRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;


@SpringBootApplication
@EnableClusterConfiguration(useHttp = true)
@EnableEntityDefinedRegions(basePackageClasses = Customer.class)
public class JDBCExample {

    public static void main(String[] args) {
        SpringApplication.run(JDBCExample.class, args);
    }

    @Bean
    ApplicationRunner runner(CustomerRepo customerRepo) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                Customer customer = new Customer("name");
                customer.setOrganization("org" + i);
                customer.setEmail("cust" + i + "@org" + i + ".com");
                customerRepo.save(new Customer("cust" + i));
            }
        };
    }
}
