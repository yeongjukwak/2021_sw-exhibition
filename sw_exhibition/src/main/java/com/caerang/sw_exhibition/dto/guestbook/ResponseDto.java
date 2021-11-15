package com.caerang.sw_exhibition.dto.guestbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("ResponseDto")
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String status;
    private Object data;
}
