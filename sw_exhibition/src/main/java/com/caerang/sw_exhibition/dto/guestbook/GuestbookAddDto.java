package com.caerang.sw_exhibition.dto.guestbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Alias("GuestbookAddDto")
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookAddDto {
    @NotNull @Length(min=1, max=12, message = "닉네임은 1 ~ 12자 사이입니다.") private String guest_writer;
    @NotNull @Length(min=1, max=98, message = "방명록 내용은 1 ~ 98자 사이입니다.") private String guest_content;
}
