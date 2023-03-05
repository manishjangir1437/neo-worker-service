package com.neo.v1.model.trigger;

import com.neo.core.model.ResponseMeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TriggerOperationResponse {

    private ResponseMeta meta;

}
