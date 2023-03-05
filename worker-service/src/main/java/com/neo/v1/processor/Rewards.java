package com.neo.v1.processor;

import com.neo.v1.exception.TaskExecutionException;
import com.neo.v1.model.trigger.model.TriggerItem;

import java.io.IOException;

public interface Rewards<T extends DocumentStateData> {

    default void execute(TriggerItem triggerItem) {
        try {
            getStateData().setTriggerItem(triggerItem);
            preProcess(triggerItem);
            process(getStateData());
            postSuccess(getStateData());
        } catch (Exception exception) {
            exception.printStackTrace();
            fail(getStateData(), new TaskExecutionException(exception.getMessage(), exception));
        }
    }

    void preProcess(TriggerItem triggerItem);

    void process(T stateData) throws IOException;

    void postSuccess(T stateData);

    void fail(T stateData, TaskExecutionException exception);

    T getStateData();
}
