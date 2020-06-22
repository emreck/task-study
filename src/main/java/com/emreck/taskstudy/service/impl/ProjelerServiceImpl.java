package com.emreck.taskstudy.service.impl;

import com.emreck.taskstudy.entity.Projeler;
import com.emreck.taskstudy.repository.ProjelerRepository;
import com.emreck.taskstudy.service.ProjelerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjelerServiceImpl implements ProjelerService {

    private final ProjelerRepository projelerRepository;
     public ProjelerServiceImpl(ProjelerRepository projelerRepository){
       this.projelerRepository= projelerRepository;
   }
    @Override
    public Projeler save(Projeler projeler) {
       if (projeler.getProjectCode()==null){
           throw new IllegalArgumentException("Project code cannot be null");
       }
        projeler = projelerRepository.save(projeler);
        return projeler ;
    }

    @Override
    public Projeler getById(Long id) {
        return projelerRepository.getOne(id);
    }

    @Override
    public List<Projeler> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Projeler> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Projeler> getAllPageable(Pageable pageable) {
        return projelerRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Projeler projeler) {
        return null;
    }
}
