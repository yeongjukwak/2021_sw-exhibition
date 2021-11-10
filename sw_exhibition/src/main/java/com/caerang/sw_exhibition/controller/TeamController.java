package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.member.MemberOfTeamDto;
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

        /* 팀명 설정 */
        String teamName;
        if(!team.equals("core"))
            teamName = "core";
        else if(!team.equals("raon"))
            teamName = "raon";
        else if(!team.equals("latte"))
            teamName = "latte";
        else if(!team.equals("deeplearning"))
            teamName = "deeplearning";
        else
            teamName = "none";

        model.addAttribute("teamName", teamName);
        model.addAttribute("memberList", memberList);
        return "team";
    }
}
