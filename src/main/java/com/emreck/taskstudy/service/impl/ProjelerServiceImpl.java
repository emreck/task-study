package com.emreck.taskstudy.service.impl;

import com.emreck.taskstudy.dto.ProjelerDto;
import com.emreck.taskstudy.entity.Projeler;
import com.emreck.taskstudy.repository.ProjelerRepository;
import com.emreck.taskstudy.service.ProjelerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjelerServiceImpl implements ProjelerService {

    private final ProjelerRepository projelerRepository;
    private final ModelMapper modelMapper;

    public ProjelerServiceImpl(ProjelerRepository projelerRepository, ModelMapper modelMapper) {
        this.projelerRepository = projelerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjelerDto save(ProjelerDto projeler) {

        Projeler projeCheck = projelerRepository.getByprojectCode(projeler.getProjectCode());
        if (projeCheck != null)
            throw new IllegalArgumentException("project code Already exist.");
        Projeler p = modelMapper.map(projeler, Projeler.class);
        p = projelerRepository.save(p);
        projeler.setId(p.getId());
        return projeler;
    }

    @Override
    public ProjelerDto getById(Long id) {
        Projeler p = projelerRepository.getOne(id);
        return modelMapper.map(p, ProjelerDto.class);

    }

    @Override
    public ProjelerDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjelerDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Projeler> getAllPageable(Pageable pageable) {
        return projelerRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(ProjelerDto projeler) {
        return null;
    }

    public Boolean delete(Long id) {
        projelerRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjelerDto update(Long id, ProjelerDto project) {
        Projeler projectDdb = projelerRepository.getOne(id);
        if (projectDdb == null)
            throw new IllegalArgumentException("project Does not exist ID :" + id);


        Projeler projeCheck = projelerRepository.getByprojectCodeAndIdNot(project.getProjectCode(),id);
        if (projeCheck != null)
            throw new IllegalArgumentException("project code Already exist.");

        projectDdb.setProjectCode(project.getProjectCode());
        projectDdb.setProjectName(project.getProjectName());
        projelerRepository.save(projectDdb);
        return modelMapper.map(projectDdb, ProjelerDto.class);
    }

}
