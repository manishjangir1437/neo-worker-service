package com.neo.v1.controller;

import com.neo.v1.worker.api.NeoServiceV1Api;
import com.neo.v1.worker.model.HelloWorldResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import com.neo.core.model.ApiError;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api
@Slf4j
@RestController
@RequestMapping("/api/v1/worker")
@Validated
@AllArgsConstructor
@ApiResponses({
        @ApiResponse(code = 400, message = "BadRequest", response = ApiError.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiError.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
})
public class WorkerController implements NeoServiceV1Api {

    @Override
    @GetMapping("/hello")
    public ResponseEntity<HelloWorldResponse> getWorkerHello() {
        return ResponseEntity.ok(new HelloWorldResponse("Hello World from worker!!!"));
    }
}