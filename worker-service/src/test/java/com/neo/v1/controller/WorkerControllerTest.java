package com.neo.v1.controller;

import com.neo.v1.worker.model.HelloWorldResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class WorkerControllerTest {

    private static final String EXPECTED_RESPONSE = "Hello World from worker!!!";
    @Autowired
    private WorkerController workerController;

    @Test
    void getWorkerHello() {
        ResponseEntity<HelloWorldResponse> responseEntity = workerController.getWorkerHello();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(EXPECTED_RESPONSE, responseEntity.getBody().getMessage());
    }
}