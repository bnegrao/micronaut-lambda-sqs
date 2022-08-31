package com.perch;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;
public class FunctionLambdaRuntime extends AbstractMicronautLambdaRuntime<SQSEvent, Void, SQSEvent, Void>
{
    public static void main(String[] args) {
        try {
            new FunctionLambdaRuntime().run(args);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<SQSEvent, Void> createRequestHandler(String... args) {
        return new FunctionRequestHandler();
    }
}
