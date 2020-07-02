package com.emreck.taskstudy.repository;

import com.emreck.taskstudy.entity.Isler;
import org.springframework.data.jpa.repository.JpaRepository;

// Bu interface aracılığıyla classlar veritabanında Crud işlemler yapabilecek.
//jpareposry interfacesi bir class alıyor ve id türünü istiyor. aşağıdaki örnektede özellikleri bulunuyor.
//ilk parametre hangi tabloya hizmet edeceği ikincisi id veri türü.
//amaç hiç sql sorgusu yazmadan veritabanı işlemleri yapabilme.
public interface IsRepository extends JpaRepository<Isler,Long> {

   /*

   Örnekler :

   List<T> findAll();// tüm kayıtları getir.

    List<T> findAll(Sort var1); tüm kayıtları getir ama sıralama yap id si küçülen vs.

    List<T> findAllById(Iterable<ID> var1); id listesine ait kayıtları getir.

    <S extends T> List<S> saveAll(Iterable<S> var1); bi çok kaydı kaydetsin.

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1); 1 tanesini getirsin

    <S extends T> List<S> findAll(Example<S> var1); verdiğim kriterlere göre getirsin.

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);*/
}
