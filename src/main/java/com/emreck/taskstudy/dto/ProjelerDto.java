package com.emreck.taskstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjelerDto {
    private Long id;
    private String projectName;
    private String projectCode;
}
