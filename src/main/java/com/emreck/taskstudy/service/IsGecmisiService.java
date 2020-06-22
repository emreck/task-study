package com.emreck.taskstudy.service;

import com.emreck.taskstudy.entity.IsGecmisi;
import com.emreck.taskstudy.entity.Isler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IsGecmisiService {
    IsGecmisi save(IsGecmisi isGecmisi);
    IsGecmisi getById(Long id);
    Page<IsGecmisi> getAllPageable(Pageable pageable);
    Boolean delete(IsGecmisi isGecmisi);

}
