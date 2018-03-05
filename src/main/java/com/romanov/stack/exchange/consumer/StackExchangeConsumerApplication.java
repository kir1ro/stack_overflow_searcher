package com.romanov.stack.exchange.consumer;

import com.romanov.stack.exchange.consumer.configuration.RestTemplateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RestTemplateConfig.class)
public class StackExchangeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackExchangeConsumerApplication.class, args);
    }
}
