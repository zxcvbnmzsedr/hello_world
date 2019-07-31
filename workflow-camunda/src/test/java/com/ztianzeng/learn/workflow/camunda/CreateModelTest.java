package com.ztianzeng.learn.workflow.camunda;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.*;
import org.camunda.bpm.model.bpmn.instance.Process;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


/**
 * @author zhaotianzeng
 * @date 2019-07-31 14:20
 * @version V1.0
 */
public class CreateModelTest {
    @Test
    public void test() throws IOException {
        // create an empty model
        BpmnModelInstance modelInstance = Bpmn.createEmptyModel();
        Definitions definitions = modelInstance.newInstance(Definitions.class);
        definitions.setTargetNamespace("http://camunda.org/examples");
        modelInstance.setDefinitions(definitions);

        // create the process
        Process process = createElement(modelInstance, definitions, "process-with-one-task", Process.class);

        // create start event, user task and end event
        StartEvent startEvent = createElement(modelInstance, process, "start", StartEvent.class);
        UserTask task1 = createElement(modelInstance, process, "task1", UserTask.class);
        task1.setName("User Task");
        EndEvent endEvent = createElement(modelInstance, process, "end", EndEvent.class);

        // create the connections between the elements
        createSequenceFlow(modelInstance, process, startEvent, task1);
        createSequenceFlow(modelInstance, process, task1, endEvent);

        // validate and write model to file
        Bpmn.validateModel(modelInstance);
        File file = File.createTempFile("bpmn-model-api-", ".bpmn");
        Bpmn.writeModelToFile(file, modelInstance);
    }

    protected <T extends BpmnModelElementInstance> T createElement(BpmnModelInstance modelInstance,
                                                                   BpmnModelElementInstance parentElement,
                                                                   String id,
                                                                   Class<T> elementClass) {
        T element = modelInstance.newInstance(elementClass);
        element.setAttributeValue("id", id, true);
        parentElement.addChildElement(element);
        return element;
    }

    public SequenceFlow createSequenceFlow(BpmnModelInstance modelInstance, Process process, FlowNode from, FlowNode to) {
        String identifier = from.getId() + "-" + to.getId();
        SequenceFlow sequenceFlow = createElement(modelInstance, process, identifier, SequenceFlow.class);
        process.addChildElement(sequenceFlow);
        sequenceFlow.setSource(from);
        from.getOutgoing().add(sequenceFlow);
        sequenceFlow.setTarget(to);
        to.getIncoming().add(sequenceFlow);
        return sequenceFlow;
    }
}