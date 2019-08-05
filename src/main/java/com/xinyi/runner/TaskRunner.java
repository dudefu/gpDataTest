package com.xinyi.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;

/**
 * 功能说明:
 * author: haonan.bian
 * date: 2018/10/15 15:33
 * Copyright (C)1997-2018 深圳信义科技 All rights reserved.
 */
public class TaskRunner implements ApplicationRunner, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(TaskRunner.class);

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("task runner");
    }

}
