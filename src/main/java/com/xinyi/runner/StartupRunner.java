package com.xinyi.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(1)
public class StartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("startup runner");
//        DataConsumer dataConsumer = new DataConsumer(Constant.KAFKA_MOTORVEHICLE_TOPIC);
//        Thread thread1 = new Thread(dataConsumer);
//        thread1.start();
        logger.info("start kafka consumer listening over ");
    }
}
