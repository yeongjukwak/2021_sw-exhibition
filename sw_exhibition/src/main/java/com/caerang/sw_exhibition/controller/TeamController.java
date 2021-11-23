package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.member.MemberOfTeamDto;
import com.caerang.sw_exhibition.dto.member.TeamDescDto;
import com.caerang.sw_exhibition.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final MemberService memberService;

    /* 소속팀별 팀원 리스트 */
    @GetMapping("/{teamName}")
    public String memberListOfTeam(@PathVariable("teamName") String team, Model model) {
        log.info("[GET] uri=/team/{}", team);

        List<MemberOfTeamDto> memberList = memberService.memberListOfTeam(team);

        if(memberList.isEmpty()){ // not found
            log.error("[404] url=/team/{}", team);

            return "/error/404";
        }

        /* 팀 설명 */
        TeamDescDto teamDescDto = new TeamDescDto();
        if(team.equals("core"))
            teamDescDto = new TeamDescDto("Core", "아두이노, 라즈베리파이를 이용한 임베디드를 중점으로 학습", "빅데이터 2학년 나영훈");
        else if(team.equals("raon"))
            teamDescDto = new TeamDescDto("Raon", "DirectX, 서버 등을 이용한 게임 프로그래밍 학습", "콘텐츠IT 2학년 구준휘");
        else if(team.equals("latte"))
            teamDescDto = new TeamDescDto("Latte", "안드로이드를 이용한 모바일 프로그래밍 학습", "스마트IoT 2학년 윤태영");
        else if(team.equals("tensor"))
            teamDescDto = new TeamDescDto("Tensor", "파이썬 라이브러리를 이용한 인공지능 학습", "빅데이터 3학년 박서정");
        else
            teamDescDto = new TeamDescDto("none", "none", "none");

        model.addAttribute("team_info", teamDescDto);
        model.addAttribute("mem_list", memberList);
        return "member";
    }
}
