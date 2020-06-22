package com.emreck.taskstudy.repository;

import com.emreck.taskstudy.entity.Projeler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface ProjelerRepository extends JpaRepository<Projeler,Long> {
 // List<Projeler> getAllByProjectCode(String projectCode);
  //yukarda yapılan şu : get le getirilecek olduğu, All hepsi , neyi ,ProjectCode. bunu Projeler classında arıyor. property ismi veritabanı değil
    //ve verilen procetCode parametresine göre arıyor. yani project codu where conditiona koyuyor.select çekiyor.
 // List<Projeler> getAllByProjectCodeAndIdNotNull(String projectCode);
    // şöylede olabilirdi.
   // List<Projeler> getAllByProjectCodeAndIdNotNull(String projectCode); id null olamyacak ve proje koduda parametre alan olan.
 // List<Projeler> getAllByProjectCodeAndProjectNameContains(String projectCode,String name);//Proje kodu şu ve proje namede name parametresini içerecek.

  List<Projeler> getByprojectCode(String projectCode);
  List<Projeler> getByprojectCodeContains(String projectCode);
  Page<Projeler> findAll(Pageable pageable);
  List<Projeler> findAll(Sort sort); // sıralamaya yarıyor.

  /* Pageable interfacesi içerisinde tablolardan kayıtları çekerken sayfalama yapması anlamına geliyor.
  * static Pageable unpaged() {
        return Unpaged.INSTANCE;
    }

    default boolean isPaged() {
        return true;
    }

    default boolean isUnpaged() {
        return !this.isPaged();
    }

    int getPageNumber(); şuanki sayfa numarası kaç

    int getPageSize(); sayfayı kaçarlı getirsin.

    long getOffset(); kaçıncı kayıttan başlasın

    Sort getSort(); sıralama yapsın mı

    default Sort getSortOr(Sort sort) {
        Assert.notNull(sort, "Fallback Sort must not be null!");
        return this.getSort().isSorted() ? this.getSort() : sort;
    }

    Pageable next();

    Pageable previousOrFirst();

    Pageable first();

    boolean hasPrevious();
  *
  *
  * */

}
