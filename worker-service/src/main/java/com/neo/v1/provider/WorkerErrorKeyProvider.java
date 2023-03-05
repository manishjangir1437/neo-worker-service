package com.neo.v1.provider;

import com.neo.core.provider.ErrorKeyMapping;
import com.neo.core.provider.ErrorKeyProvider;
import com.neo.v1.enums.WorkerErrorKeyMapping;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

@Primary
@Component
public class WorkerErrorKeyProvider implements ErrorKeyProvider {

    private static final Map<String, WorkerErrorKeyMapping> ERROR_CODE_MESSAGE_MAPPING_BY_CODE =
            of(WorkerErrorKeyMapping.values()).collect(toMap(WorkerErrorKeyMapping::getCode, identity()));

    @Override
    public ErrorKeyMapping findByCode(String code) {
        return ERROR_CODE_MESSAGE_MAPPING_BY_CODE.get(code);
    }
}