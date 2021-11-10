package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.guestbook.GuestbookDto;
import com.caerang.sw_exhibition.dto.member.MemberOfProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectListDto;
import com.caerang.sw_exhibition.service.guestbook.GuestbookService;
import com.caerang.sw_exhibition.service.member.MemberService;
import com.caerang.sw_exhibition.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;
    private final MemberService memberService;
    private final GuestbookService guestbookService;

    /* 메인 페이지 */
    @GetMapping("/")
    public String home() {
        log.info("[GET] URI = /");

        return "index";
    }

    /* 팀 리스트 페이지 */
//    @GetMapping("/team")
//    public String teamList() {
//        log.info("[GET] URI = /team");
//
//        return "team";
//    }

    /* 개발 분야별 프로젝트 리스트 또는 프로젝트 상세보기 */
    @GetMapping("/project")
    public String projectList(@RequestParam(value = "title", defaultValue = "", required = false) String title, Model model) {
        if(title.equals("")) { // 프로젝트 리스트
            log.info("[GET] URI = /project");

            List<ProjectListDto> projectListDtoList = projectService.projectList();

            if(projectListDtoList.isEmpty()) { // not found
                log.error("[404] URI = /project");
                return "/error/404";
            }

            model.addAttribute("projectList", projectListDtoList);
            return "project";

        }else { // 프로젝트 상세보기
            log.info("[GET] URI = /project?title={}", title);

            ProjectDto projectDto = projectService.projectDetail(title);

            if(Objects.isNull(projectDto)) { // not found
                log.error("[404] URI = /project?title={}", title);
                return "/error/404";
            }

            List<MemberOfProjectDto> memberOfProjectDtoList = memberService.memberListOfProject(title);

            model.addAttribute("projectInfo", projectDto);
            model.addAttribute("memberList", memberOfProjectDtoList);

            return "detail";
        }
    }

    /* 방명록 페이지 */
//    @GetMapping("/guestbook")
//    public String guestbookList(Model model) {
//        log.info("[GET] URI = /Guestbook");
//
//        List<GuestbookDto> guestbookDtoList = guestbookService.guestbookList();
//        model.addAttribute("guestbookList", guestbookDtoList);
//
//        return "guestbook";
//    }

    /* 방명록 등록 */
//    @PostMapping("/guestbook")
//    public String addGuestbook(HttpServletRequest request) {
//        log.info("[POST] URI = /Guestbook");
//
//        String writer = request.getParameter("writer");
//        String content = request.getParameter("content");
//
//        guestbookService.addGuestbook(writer, content);
//
//        return "redirect:/guestbook";
//    }
}
