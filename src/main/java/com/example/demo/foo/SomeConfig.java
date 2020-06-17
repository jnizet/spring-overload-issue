package com.example.demo.foo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeConfig {
    @Bean(name = "other")
    public SomeOtherBean foo() {
        System.out.println("constructing SomeOtherBean");
        return new SomeOtherBean();
    }

    @Bean(name = "foo")
    public SomeBean foo(@Qualifier("other") SomeOtherBean other) {
        System.out.println("constructing SomeBean");
        return new SomeBean(other);
    }
}
