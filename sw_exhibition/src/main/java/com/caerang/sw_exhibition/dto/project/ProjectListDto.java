package com.caerang.sw_exhibition.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Alias("ProjectListDto")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListDto {
    @NotNull private String proj_name;
    @NotNull private String proj_developField;
}
