package com.neo.v1.client.decoder;

import com.neo.v1.exception.TriggerException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static com.neo.v1.util.TransactionErrorUtils.parseError;

public class RewardsClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        parseError(methodKey, response);
        return new TriggerException("Error occurred in trigger service");
    }
}
