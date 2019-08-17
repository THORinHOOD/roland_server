package ru.roland.server.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
public class MainConfig {

    @Value("${roland.tcp.host}")
    private String host;

    @Value("${roland.tcp.port}")
    private Integer port;

}
