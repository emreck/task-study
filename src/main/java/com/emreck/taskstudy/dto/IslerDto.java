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

    //cliente gönderirken id gönderebilirim.
    //bunlar frontrendde gösterilicek
    //diğer entitiy kısmında bunlarıda eklersem kullanıcıların şifrleri falanda gelir
    //jsonda göstermemek için @JsonIgnore Kullanılabilirdi.
    //bu sınıfla dışarıyla konuşucaz


    private Long id;
    private String description;
    private String details;
    private Date date;
    private IsDurum isdurum;
    private KullaniciDto assignee;
    private ProjelerDto proje;


}
