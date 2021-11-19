package com.caerang.sw_exhibition.mapper.member;

import com.caerang.sw_exhibition.dto.member.MemberOfProjectDto;
import com.caerang.sw_exhibition.dto.member.MemberOfTeamDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    public List<MemberOfTeamDto> memberListOfTeam(String team);
    public List<MemberOfProjectDto> memberListOfProject(String title);
}
