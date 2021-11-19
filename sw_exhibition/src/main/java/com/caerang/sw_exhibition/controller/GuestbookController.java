package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.guestbook.GuestbookAddDto;
import com.caerang.sw_exhibition.dto.guestbook.GuestbookDto;
import com.caerang.sw_exhibition.dto.guestbook.ResponseDto;
import com.caerang.sw_exhibition.service.guestbook.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/guestbook")
public class GuestbookController {
    private final GuestbookService guestbookService;

    /* 방명록 리스트 */
    @GetMapping("/list")
    public ResponseEntity<ResponseDto> guestbookList() {
        log.info("[GET] URI = /guestbook/list");

        List<GuestbookDto> guestbookDtoList = guestbookService.guestbookList();

        // 방명록이 존재하지 않는 경우
        if(guestbookDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("404", "none"));
        }

        return ResponseEntity.ok().body(new ResponseDto("200", guestbookDtoList));
    }

    /* 방명록 등록 */
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addGuestbook(@Validated @RequestBody GuestbookAddDto guestbookAddDto) {
        log.info("[POST] URI = /guestbook/add");

        guestbookService.addGuestbook(guestbookAddDto);

        return ResponseEntity.ok().body(new ResponseDto("200", "none"));
    }
}
