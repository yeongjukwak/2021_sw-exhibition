package com.caerang.sw_exhibition.service.member;

import com.caerang.sw_exhibition.dto.member.MemberOfProjectDto;
import com.caerang.sw_exhibition.dto.member.MemberOfTeamDto;

import java.util.List;

public interface MemberService {
    public List<MemberOfTeamDto> memberListOfTeam(String team);
    public List<MemberOfProjectDto> memberListOfProject(String title);
}
