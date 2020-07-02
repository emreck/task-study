package com.emreck.taskstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciDto {
    private Long id;
    private String nameSurname;
}
