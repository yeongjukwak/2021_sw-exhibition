package com.caerang.sw_exhibition.controller.advice;

import com.caerang.sw_exhibition.dto.guestbook.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    /* 방명록 글자 수 제한 예외처리 */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseDto> validException(MethodArgumentNotValidException ex) {
        log.info("[MethodArgumentNotValidException] MESSAGE = {}", ex.getMessage());

        BindingResult bindingResult = ex.getBindingResult();
        String message = bindingResult.getFieldError().getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("400", message));
    }
}
