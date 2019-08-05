package com.xinyi;

import com.xinyi.runner.StartupRunner;
import com.xinyi.runner.TaskRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public StartupRunner startupRunner(){
        return new StartupRunner();
    }

    @Bean
    public TaskRunner taskRunner(){
        return new TaskRunner();
    }

}
