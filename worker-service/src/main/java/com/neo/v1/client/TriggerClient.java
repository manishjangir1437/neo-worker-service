package com.neo.v1.client;

import com.neo.v1.model.trigger.model.CloseItemUpdateRequest;
import com.neo.v1.model.trigger.model.FailItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerItemResponse;
import com.neo.v1.model.trigger.model.TriggerItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerOperationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(name = "TriggerFeignClient", url = "${rewards.worker.trigger.service.base.url}")
public interface TriggerClient {

    @GetMapping(path = "/externalId", produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<TriggerItemResponse> getTriggerExternalId(@RequestParam String externalId,
                                                             @RequestParam String type);

    @GetMapping(path = "/{id}")
    ResponseEntity<TriggerItemResponse> getTriggerById(Long id);

    @PutMapping
    ResponseEntity<com.neo.v1.model.trigger.model.TriggerOperationResponse> putTrigger(@RequestBody TriggerItemUpdateRequest triggerItemUpdateRequest);

    @PostMapping(path = "/fail")
    ResponseEntity<com.neo.v1.model.trigger.model.TriggerOperationResponse> postTriggerFail(@RequestBody FailItemUpdateRequest failItemUpdateRequest);

    @PostMapping(path = "/close")
    ResponseEntity<TriggerOperationResponse> postTriggerClose(@RequestBody CloseItemUpdateRequest closeItemUpdateRequest);
}
