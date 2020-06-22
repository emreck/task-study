package com.emreck.taskstudy.service.impl;

import com.emreck.taskstudy.dto.IslerDto;
import com.emreck.taskstudy.entity.Isler;
import com.emreck.taskstudy.repository.IsRepository;
import com.emreck.taskstudy.service.IsService;
import com.emreck.taskstudy.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class IslerServiceImpl implements IsService {

    /*@Autowired
    private IsReposiyorty isgecmisi; buda olabilirdi ama tercih edilmiyor.
   */

    //Üste taşımak için ÖNERİLEN.
    private final IsRepository isRepository;
    private final ModelMapper modelMapper;

    //constracture ile artısı : final tanımlamasıyla o nesnenin run time da değişmesini engellemiş oluyorsun. atama yapmayı engelliyor.
    //güvenli hale geliyor.
    public IslerServiceImpl(IsRepository islerIsRepository,ModelMapper modelMapper) {
        this.isRepository = islerIsRepository;
        this.modelMapper =modelMapper;
    }

    @Override
    public IslerDto save(IslerDto is) {
        if (is.getDate() == null) {
            throw new IllegalArgumentException("issue Date cannot be null");
        }
        Isler islerdb= modelMapper.map(is,Isler.class);//isdto yu isler classıyla eşleştirip geriye döndürüyor.propertyleri eşleştirerek yapıyor.
        islerdb= isRepository.save(islerdb);
       return modelMapper.map(islerdb,IslerDto.class);//tersini yaptık.
        //bunun sıkıntısı entitiy yerine bir değişiklik yapıldığında bu sefer heryerde yapılacak.problem oluşacak.
        //amaç dtolarla dışarda çalışmak içerde neyle çalışıyorsan çalış(entitiyle mi sql lemi neyse)

    }

    @Override
    public IslerDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IslerDto> getAllPageable(Pageable pageable) {//amaç dtoya dönüştürüp geri vermek.
        Page<Isler> data = isRepository.findAll(pageable);
        TPage page = new TPage<IslerDto>();
      IslerDto[] dtos = modelMapper.map(data.getContent(),IslerDto[].class);
         page.setStat(data, Arrays.asList(dtos));
         return page;
    }

    @Override
    public Boolean delete(IslerDto isler) {
        return null;
    }
}
