package com.neo.v1.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.neo.core.serialization.CustomLocalDateTimeDeserializer;
import com.neo.core.serialization.CustomLocalDateTimeSerializer;
import com.neo.v1.model.trigger.type.TriggerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentMessageRequest {
    private Long version;

    @Size(max = 256)
    private String type;

    private TriggerStatus status;

    private Long retries;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime nextExecutionDate;

    @NotNull
    private Long id;

    @Size(max = 256)
    private String failure;

    @Size(max = 128)
    private String externalId;

    @Size(max = 512)
    private String context;
}
