package com.caerang.sw_exhibition.mapper.member;

import com.caerang.sw_exhibition.dto.member.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    public List<MemberDto> teamMemberList(String team);
    public List<MemberDto> projectMemberList(String title);
}
