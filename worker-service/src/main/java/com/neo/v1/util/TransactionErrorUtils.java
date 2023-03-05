package com.neo.v1.util;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Slf4j
public final class TransactionErrorUtils {

    private TransactionErrorUtils() {
    }

    public static void parseError(String methodKey, Response response) {
        printRequestResponse(methodKey, response);
        String errorResponse = EMPTY;
        try {
            errorResponse = IOUtils.toString(response.body().asInputStream());
        } catch (IOException ioException) {
            log.error("unable to parse error response", ioException);
        }
        log.error("Error response received : [{}]", errorResponse);
    }

    private static void printRequestResponse(String methodKey, Response response) {
        log.error("Http Status : [{}]", response.status());
        log.error("request headers: [{}]", response.request().headers());
        log.error("response headers: [{}]", response.headers());
        log.error("error occurred while executing: [{}] on request url: [{}]", methodKey, response.request().url());
    }
}
