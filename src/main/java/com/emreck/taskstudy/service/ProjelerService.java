package com.emreck.taskstudy.service;

import com.emreck.taskstudy.entity.Isler;
import com.emreck.taskstudy.entity.Kullanicilar;
import com.emreck.taskstudy.entity.Projeler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjelerService {

    Projeler save(Projeler projeler);
    Projeler getById(Long id);
    List<Projeler> getByProjectCode(String projectCode);
    List<Projeler> getByProjectCodeContains(String projectCode);
    Page<Projeler> getAllPageable(Pageable pageable);
    Boolean delete(Projeler projeler);
}
