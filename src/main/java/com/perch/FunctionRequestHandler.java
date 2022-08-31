package com.perch;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
public class FunctionRequestHandler extends MicronautRequestHandler<SQSEvent, Void> {
    @Inject
    ObjectMapper objectMapper;

    @Override
    public Void execute(SQSEvent sqsEvent) {
        if (sqsEvent == null){
            throw new RuntimeException("sqsEvent cannot be null");
        }
        System.out.println(sqsEvent);
        if (sqsEvent.getRecords() == null) {
            throw new RuntimeException("getRecords() cannot return null");
        }
        if (sqsEvent.getRecords().isEmpty()){
            throw new RuntimeException("getRecords() cannot return an empty list");
        }
        for (SQSEvent.SQSMessage sqsMessage: sqsEvent.getRecords()){
            System.out.println(sqsMessage);
        }
        return null;
    }
}
