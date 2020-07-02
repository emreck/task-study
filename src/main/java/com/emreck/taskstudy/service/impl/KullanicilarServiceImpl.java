package com.emreck.taskstudy.service.impl;

import com.emreck.taskstudy.entity.Kullanicilar;
import com.emreck.taskstudy.repository.KullanicilarRepository;
import com.emreck.taskstudy.service.KullanicilarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KullanicilarServiceImpl implements KullanicilarService {

    private final KullanicilarRepository kullanicilarRepository;

    public KullanicilarServiceImpl(KullanicilarRepository kullanicilarRepository){
        this.kullanicilarRepository=kullanicilarRepository;
    }

    @Override
    public Kullanicilar save(Kullanicilar kullanicilar) {
        if (kullanicilar.getEmail()==null){

        throw new IllegalArgumentException("username cannot be null");
        }
        kullanicilar=kullanicilarRepository.save(kullanicilar);
        return kullanicilar;
    }

    @Override
    public Kullanicilar getById(Long id) {
        return kullanicilarRepository.getOne(id);
    }

    @Override
    public Page<Kullanicilar> getAllPageable(Pageable pageable) {
        return kullanicilarRepository.findAll(pageable);
    }

    @Override
    public Kullanicilar getByUserName(String username) {
        return kullanicilarRepository.findByUsername(username);
    }
}
