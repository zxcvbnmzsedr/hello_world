package com.ztianzeng.learn.workflow.camunda.service;

import com.ztianzeng.learn.workflow.camunda.model.CreateTaskParam;
import com.ztianzeng.learn.workflow.camunda.utils.JacksonUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhaotianzeng
 * @date 2019-08-01 11:22
 * @version V1.0
 */
public class TenantProcessServiceTest {

    @Test
    public void createProcess() throws IOException {
        String depString = "{\"name\":\"发起人\",\"type\":\"START\",\"nodeId\":\"start\",\"prevId\":\"start\",\"childNode\":{\"name\":\"审批人\",\"type\":\"APPROVER\",\"nodeId\":\"APPROVERdfd7cl5u\",\"prevId\":\"start\",\"childNode\":{\"name\":\"抄送人\",\"type\":\"NOTIFIER\",\"nodeId\":\"notifier\",\"prevId\":\"APPROVERdfd7cl5u\",\"childNode\":{\"name\":\"结束\",\"type\":\"END\",\"prevId\":\"notifier\",\"nodeId\":\"end\"},\"properties\":{\"edit\":true,\"type\":\"NOTIFIER\"}},\"properties\":{\"type\":\"APPROVER\",\"actionerRule\":{\"type\":\"target_select\",\"multi\":0,\"range\":{\"type\":\"1\"}}}},\"properties\":{\"type\":\"START\"}}";
        CreateTaskParam createTaskParam = JacksonUtils.defaultMapper().readValue(depString, CreateTaskParam.class);
        new TenantProcessService().createProcess("1", "defKey", createTaskParam);
    }

}