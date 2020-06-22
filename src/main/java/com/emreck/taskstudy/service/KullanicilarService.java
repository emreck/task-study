package com.emreck.taskstudy.service;

import com.emreck.taskstudy.entity.IsGecmisi;
import com.emreck.taskstudy.entity.Isler;
import com.emreck.taskstudy.entity.Kullanicilar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KullanicilarService {

    Kullanicilar save(Kullanicilar kullanicilar);
    Kullanicilar getById(Long id);
    Page<Kullanicilar> getAllPageable(Pageable pageable);

    Kullanicilar getByUserName(String username);//repositorysindeki metod böyleydi.

}
