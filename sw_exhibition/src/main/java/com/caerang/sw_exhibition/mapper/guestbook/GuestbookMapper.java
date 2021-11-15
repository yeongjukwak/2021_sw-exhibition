package com.caerang.sw_exhibition.mapper.guestbook;

import com.caerang.sw_exhibition.dto.guestbook.GuestbookAddDto;
import com.caerang.sw_exhibition.dto.guestbook.GuestbookDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GuestbookMapper {
    public List<GuestbookDto> guestbookList();
    public void addGuestbook(GuestbookAddDto guestbookAddDto);
}
