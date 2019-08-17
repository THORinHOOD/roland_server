package ru.roland.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.roland.server.configs.MainConfig;

@SpringBootApplication
@Import({MainConfig.class})
public class RolandMain {
    public static void main(String[] args) {
        SpringApplication.run(RolandMain.class, args);
    }
}
