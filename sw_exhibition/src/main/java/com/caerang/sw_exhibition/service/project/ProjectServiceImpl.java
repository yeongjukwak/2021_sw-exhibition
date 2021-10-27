package com.caerang.sw_exhibition.service.project;

import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.mapper.project.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectMapper projectMapper;

    @Override
    public List<String> projectList(String field) {
        List<String> list = projectMapper.projectList(field);

        return list;
    }

    @Override
    public ProjectDto projectDetail(String field, String title) {
        Map<String, String> map = new HashMap<>();
        map.put("field", field);
        map.put("title", title);

        ProjectDto projectDto = projectMapper.projectDetail(map);
        return projectDto;
    }


}
