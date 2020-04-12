package com.personal.content_center.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApolloContentConfig {

    @Value("${user.name}")
    private String name ;
}
