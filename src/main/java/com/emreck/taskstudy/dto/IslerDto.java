package com.emreck.taskstudy.dto;

import com.emreck.taskstudy.entity.IsDurum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IslerDto {


    /*bu propertyler frontrendde gösterilicek

    jsonda göstermemek için @JsonIgnore Kullanılabilirdi.*/



    private Long id;
    private String description;
    private String details;
    private Date date;
    private IsDurum isdurum;
    private KullaniciDto assignee;
    private ProjelerDto proje;


}
