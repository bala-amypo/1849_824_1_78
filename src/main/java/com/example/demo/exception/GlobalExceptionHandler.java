// // package com.example.demo.exception;

// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.ExceptionHandler;
// // import org.springframework.web.bind.annotation.RestControllerAdvice;

// // import java.time.LocalDateTime;
// // import java.util.HashMap;
// // import java.util.Map;

// // @RestControllerAdvice
// // public class GlobalExceptionHandler {

// //     @ExceptionHandler(BadRequestException.class)
// //     public ResponseEntity<Map<String, Object>> handleBadRequest(
// //             BadRequestException ex) {

// //         Map<String, Object> body = new HashMap<>();
// //         body.put("timestamp", LocalDateTime.now());
// //         body.put("status", HttpStatus.BAD_REQUEST.value());
// //         body.put("error", "Bad Request");
// //         body.put("message", ex.getMessage());

// //         return ResponseEntity
// //                 .status(HttpStatus.BAD_REQUEST)
// //                 .body(body);
// //     }

// //     @ExceptionHandler(ResourceNotFoundException.class)
// //     public ResponseEntity<Map<String, Object>> handleNotFound(
// //             ResourceNotFoundException ex) {

// //         Map<String, Object> body = new HashMap<>();
// //         body.put("timestamp", LocalDateTime.now());
// //         body.put("status", HttpStatus.NOT_FOUND.value());
// //         body.put("error", "Not Found");
// //         body.put("message", ex.getMessage());

// //         return ResponseEntity
// //                 .status(HttpStatus.NOT_FOUND)
// //                 .body(body);
// //     }
// // }
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(BadRequestException.class)
//     public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleGeneralException(Exception ex) {
//         return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(BadRequestException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", "Something went wrong");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
