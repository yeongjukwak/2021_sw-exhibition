package com.caerang.sw_exhibition.service.guestbook;

import com.caerang.sw_exhibition.dto.guestbook.GuestbookAddDto;
import com.caerang.sw_exhibition.dto.guestbook.GuestbookDto;
import com.caerang.sw_exhibition.mapper.guestbook.GuestbookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {
    private final GuestbookMapper guestbookMapper;

    @Override
    public List<GuestbookDto> guestbookList() {

        List<GuestbookDto> guestbookDtoList = guestbookMapper.guestbookList();
        return guestbookDtoList;
    }

    @Override
    public void addGuestbook(GuestbookAddDto guestbookAddDto) {

        guestbookMapper.addGuestbook(guestbookAddDto);
    }
}
