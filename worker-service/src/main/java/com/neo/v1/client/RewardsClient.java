package com.neo.v1.client;

import com.neo.v1.rewards.model.RewardsWorkerRequest;
import com.neo.v1.rewards.model.RewardsWorkerResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RewardsFeignClient", url = "${rewards.worker.rewards.service.base.url}")
public interface RewardsClient {

    @PutMapping("/worker")
    RewardsWorkerResponses putRewardsWorker(@RequestBody RewardsWorkerRequest request);


}



