package com.emreck.taskstudy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjelerDto {
    private Long id;
    @NotNull
    private String projectName;
    @NotNull
    private String projectCode;
}
