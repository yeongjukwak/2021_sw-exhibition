package com.caerang.sw_exhibition.service.member;

import com.caerang.sw_exhibition.dto.member.MemberDto;
import com.caerang.sw_exhibition.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Override
    public List<MemberDto> teamMemberList(String team) {
        List<MemberDto> memberDtoList = memberMapper.teamMemberList(team);

        return memberDtoList;
    }

    @Override
    public List<MemberDto> projectMemberList(String title) {
        List<MemberDto> memberDtoList = memberMapper.projectMemberList(title);

        return memberDtoList;
    }
}
