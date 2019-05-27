package com.accenture.tasks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TasksExceptionController {

    @ExceptionHandler()

    public ResponseEntity<Object> exception(Exception exception) {
        if (exception instanceof TaskDeleteFailedException) {
            return new ResponseEntity<>("Delete process failed - task not found", HttpStatus.NOT_FOUND);
        } else {
            if (exception instanceof TaskUpdateFailedException) {
                return new ResponseEntity<>("Update process failed - task not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Something bad happened with API - general error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

