package com.emreck.taskstudy.service;

import com.emreck.taskstudy.dto.IslerDto;
import com.emreck.taskstudy.entity.Isler;
import com.emreck.taskstudy.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IsService {

    /*Buradaki amaç servisin dto nesneleri alması ve dto olarak geri döndürebilme emrini oluşturmak.(Controller entityle değil dto ile
    işlem yapıyor.) */

    IslerDto save(IslerDto is); // veritabanına kaydetmek için kaydetme metodu işler tipinde bi parametre alıp o kaydı geri döndü.
    IslerDto getById(Long id);//Verilen id 'ye göre dto döndürecek.
    TPage<IslerDto> getAllPageable(Pageable pageable);//arayüzde sayfaları göstermek için kullanıcam.

    Boolean delete(Long isler);

    IslerDto update(Long id, IslerDto project);
}
