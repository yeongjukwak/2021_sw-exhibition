package com.caerang.sw_exhibition.service.member;

import com.caerang.sw_exhibition.dto.member.MemberOfProjectDto;
import com.caerang.sw_exhibition.dto.member.MemberOfTeamDto;
import com.caerang.sw_exhibition.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public List<MemberOfTeamDto> memberListOfTeam(String team) {
        List<MemberOfTeamDto> memberList = memberMapper.memberListOfTeam(team);

        return memberList;
    }

    @Override
    public List<MemberOfProjectDto> memberListOfProject(String title) {
        List<MemberOfProjectDto> memberList = memberMapper.memberListOfProject(title);

        return memberList;
    }
}
