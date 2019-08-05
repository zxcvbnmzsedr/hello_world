package com.ztianzeng.learn.workflow.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaotianzeng
 * @date 2019-07-31 13:26
 * @version V1.0
 */
@SpringBootApplication
@EnableProcessApplication
public class WebappExampleProcessApplication {


    public static void main(String... args) {
        SpringApplication.run(WebappExampleProcessApplication.class, args);
    }

}