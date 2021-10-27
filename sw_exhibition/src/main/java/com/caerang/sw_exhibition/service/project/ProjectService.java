package com.caerang.sw_exhibition.service.project;

import com.caerang.sw_exhibition.dto.project.ProjectDto;

import java.util.List;

public interface ProjectService {
    public List<String> projectList(String field);
    public ProjectDto projectDetail(String field, String title);
}
