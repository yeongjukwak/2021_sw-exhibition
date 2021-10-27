package com.caerang.sw_exhibition.mapper.project;

import com.caerang.sw_exhibition.dto.project.ProjectDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProjectMapper {
    public List<String> projectList(String field);
    public ProjectDto projectDetail(Map map);
}
