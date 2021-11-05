package com.caerang.sw_exhibition.service.guestbook;

import com.caerang.sw_exhibition.dto.guestbook.GuestbookDto;

import java.util.List;

public interface GuestbookService {
    public List<GuestbookDto> guestbookList();
    public void addGuestbook(String writer, String content);
}
