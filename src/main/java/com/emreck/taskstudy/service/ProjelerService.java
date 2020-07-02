package com.emreck.taskstudy.service;

import com.emreck.taskstudy.dto.ProjelerDto;
import com.emreck.taskstudy.entity.Isler;
import com.emreck.taskstudy.entity.Kullanicilar;
import com.emreck.taskstudy.entity.Projeler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjelerService {

    ProjelerDto save(ProjelerDto projeler);

    ProjelerDto getById(Long id);

    ProjelerDto getByProjectCode(String projectCode);

    List<ProjelerDto> getByProjectCodeContains(String projectCode);

    Page<Projeler> getAllPageable(Pageable pageable);

    Boolean delete(ProjelerDto projeler);

    ProjelerDto update(Long id, ProjelerDto project);
}
