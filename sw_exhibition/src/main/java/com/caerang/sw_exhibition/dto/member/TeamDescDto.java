package com.caerang.sw_exhibition.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("TeamDescDto")
@NoArgsConstructor
@AllArgsConstructor
public class TeamDescDto {
    private String teamName;
    private String teamDesc;
    private String teamLeader;
}
