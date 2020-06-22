package com.emreck.taskstudy.service.impl;

import com.emreck.taskstudy.entity.IsGecmisi;
import com.emreck.taskstudy.repository.IsGecmisiRepository;
import com.emreck.taskstudy.service.IsGecmisiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service//servis olduğunu belirten ve singleton instance olduğunu belirten annotation
//repositoryden sonra yaratılan nesne
public class IsGecmisiServiceImpl  implements IsGecmisiService {
    private final IsGecmisiRepository isGecmisiRepository;

    public IsGecmisiServiceImpl(IsGecmisiRepository isGecmisiRepository){
        this.isGecmisiRepository = isGecmisiRepository;
    }

    @Override
    public IsGecmisi save(IsGecmisi isGecmisi) {
        if (isGecmisi.getDate()==null){
            throw new IllegalArgumentException("issue cannot be null");
        }
        isGecmisi = isGecmisiRepository.save(isGecmisi);
        return isGecmisi;
    }

    @Override
    public IsGecmisi getById(Long id) {
        return isGecmisiRepository.getOne(id);
    }

    @Override
    public Page<IsGecmisi> getAllPageable(Pageable pageable) {
        return isGecmisiRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IsGecmisi isGecmisi) {
        isGecmisiRepository.delete(isGecmisi);
        return Boolean.TRUE;
    }
}
