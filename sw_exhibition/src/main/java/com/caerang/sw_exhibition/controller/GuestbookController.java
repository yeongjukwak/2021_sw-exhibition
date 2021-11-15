package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.guestbook.GuestbookAddDto;
import com.caerang.sw_exhibition.dto.guestbook.GuestbookDto;
import com.caerang.sw_exhibition.dto.guestbook.ResponseDto;
import com.caerang.sw_exhibition.service.guestbook.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return ResponseEntity.ok().body(new ResponseDto("200", "none"));
        }

        return ResponseEntity.ok().body(new ResponseDto("200", guestbookDtoList));
    }

    /* 방명록 등록 */
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addGuestbook(@RequestBody GuestbookAddDto guestbookAddDto) {
        log.info("[POST] URI = /guestbook/add");

        guestbookService.addGuestbook(guestbookAddDto);

        return ResponseEntity.ok().body(new ResponseDto("200", "none"));
    }
//    /* 방명록 등록 */
//    @PostMapping("/guestbook/add")
//
//
//
//    /* 페이징 */ // 페이지 번호, 방명록 개수 parameter  // result 총 페이징 수
//    @GetMapping("/guestbook")
//    public ResponseEntity<Object> guestbookList(@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
//                                                @RequestParam(value = "contentCnt", defaultValue = "9", required = false) int contentCnt) {
//        log.info("[GET] url=/guestbook?pageNum={}&contentCnt={}", pageNum, contentCnt);
//
//        List<GuestbookDto> guestbookDtoList = guestbookService.guestbookList(pageNum, contentCnt);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("data", guestbookDtoList);
//        map.put("status", 200);
//
//        return ResponseEntity.ok().body(map);
//    }
}
