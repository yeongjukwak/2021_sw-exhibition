package com.caerang.sw_exhibition.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Alias("MemberOfProjectDto")
@NoArgsConstructor
@AllArgsConstructor
public class MemberOfProjectDto {
    @NotNull private String mem_name;
    @NotNull private String mem_team;
    @NotNull private int mem_grade;
    @NotNull private String mem_major;
}
