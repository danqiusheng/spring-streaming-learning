package com.moa;

import com.moa.kafka.ShopChannel;
import com.moa.kafka.Sink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ShopChannel.class)
@SpringBootApplication
public class SpringStreamingLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStreamingLearningApplication.class, args);
    }
}
