package com.neo.v1.service;

import com.neo.core.exception.ServiceException;
import com.neo.v1.client.TriggerClient;
import com.neo.v1.mapper.TriggerRequestMapper;
import com.neo.v1.model.trigger.model.CloseItemUpdateRequest;
import com.neo.v1.model.trigger.model.FailItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerItem;
import com.neo.v1.model.trigger.model.TriggerItemResponse;
import com.neo.v1.model.trigger.model.TriggerItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerOperationResponse;
import com.neo.v1.reader.PropertyReader;
import feign.RetryableException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.neo.v1.enums.WorkerServiceKeyMapping.TRIGGER_SERVICE_UNAVAILABLE;

@Service
@AllArgsConstructor
public class TriggerService {

    private final TriggerClient triggerClient;
    private final PropertyReader propertyReader;
    private final TriggerRequestMapper triggerRequestMapper;

    public TriggerItemResponse getTriggerByExternalId(String externalId,String type) {
        try {
            return triggerClient.getTriggerExternalId(externalId, type).getBody();
        } catch (RetryableException exception) {
            throw new ServiceException(TRIGGER_SERVICE_UNAVAILABLE, exception);
        }
    }

    public TriggerOperationResponse updateTriggerItem(TriggerItemUpdateRequest triggerItemUpdateRequest) {
        try {
            return triggerClient.putTrigger(triggerItemUpdateRequest).getBody();
        } catch (RetryableException exception) {
            throw new ServiceException(TRIGGER_SERVICE_UNAVAILABLE, exception);
        }
    }

    public void postFailure(FailItemUpdateRequest request) {
        try {
            triggerClient.postTriggerFail(request);
        } catch (RetryableException e) {
            throw new ServiceException(TRIGGER_SERVICE_UNAVAILABLE, e);
        }
    }

    public void closeTrigger(TriggerItem triggerItem) {
        try {
            CloseItemUpdateRequest request = triggerRequestMapper.mapCloseItemRequest(triggerItem);
            triggerClient.postTriggerClose(request);
        } catch (RetryableException e) {
            throw new ServiceException(TRIGGER_SERVICE_UNAVAILABLE, e);
        }
    }
}
