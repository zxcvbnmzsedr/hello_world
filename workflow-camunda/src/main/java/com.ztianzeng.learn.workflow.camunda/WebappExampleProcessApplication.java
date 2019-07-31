package com.ztianzeng.learn.workflow.camunda;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

/**
 * @author zhaotianzeng
 * @date 2019-07-31 13:26
 * @version V1.0
 */


@SpringBootApplication
@EnableProcessApplication
public class WebappExampleProcessApplication {
    @Autowired
    private RuntimeService runtimeService;

    public static void main(String... args) {
        SpringApplication.run(WebappExampleProcessApplication.class, args);
    }

    @EventListener
    private void processPostDeploy(PostDeployEvent event) {
        runtimeService.startProcessInstanceByKey("loanApproval");
    }
}