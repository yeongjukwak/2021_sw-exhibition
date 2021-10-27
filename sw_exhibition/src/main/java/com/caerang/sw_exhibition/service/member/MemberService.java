package com.caerang.sw_exhibition.service.member;

import com.caerang.sw_exhibition.dto.member.MemberDto;

import java.util.List;

public interface MemberService {
    public List<MemberDto> teamMemberList(String team);
    public List<MemberDto> projectMemberList(String title);
}
