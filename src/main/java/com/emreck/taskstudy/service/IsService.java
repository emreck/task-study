package com.emreck.taskstudy.service;

import com.emreck.taskstudy.dto.IslerDto;
import com.emreck.taskstudy.entity.Isler;
import com.emreck.taskstudy.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IsService {
    //sadece metod imzası taşıyacak.
//yani burda benim servisime dto olarak nesne verilsin ve serviste dto olarak döndürsün ama servis entityle çalışsın
    IslerDto save(IslerDto is); // veritabanına kaydetmek için kaydetme metodu işler tipinde bi parametre alıp o kaydı geri döndü.
    IslerDto getById(Long id);//id verdim kaydı getirdi.
    TPage<IslerDto> getAllPageable(Pageable pageable);//arayüzde 3. 5. sayfayı vs göster diye kullanıcam.

    Boolean delete(IslerDto isler);

}
