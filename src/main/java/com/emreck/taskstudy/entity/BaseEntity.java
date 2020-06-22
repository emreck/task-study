package com.emreck.taskstudy.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

//hibernatede orm nesnesi olacağı için bunların seriazeble edilmesi lazım.
//networkten taşınması veya diske yazılabilmesi gibi işlemlerin bu sınıfta kullanılması için.
//@Data//@Getter + @Setter işlemlerini ve bunun yanında toString ve EqualsAndHashCode methodların yaptığı işlemleri yapar.
@MappedSuperclass//JPA'dan gelen ve bütün tablolarda ortak olmasını sağlıyor. extend edilebilir hale getiriyor.
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
    //Tüm tabloda olacak özelliklerin bulunduğu classtır.
    //bu classı extend eden
    //ayrı ayrı her field için @getter @setter kullanılabilirdi.
    @Column(name = "created_at") //kolonların her bir özelliğini veritabanı üzerinde detaylandırıyoruz.
    @Temporal(TemporalType.TIMESTAMP)// ne tarzda tarih tutacağım.
    private Date createdAt; //Kaydı ne zaman ekledi.

    @Column(name = "created_by",length = 100)
    private String createdBy;

    @Column(name = "updated_at")//Kim Ekledi.
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_at")//Kaydı ne zaman güncelledi.
    private String updatedBy;

    @Column(name = "status")//Kim güncelledi.
    private Boolean status; // kayıt aktifmi durumu


    //bu classın bazı özelliklerini override edebilmek ve bu classta metod boddysi bulundurmak istediğimizden
    //abstract yapıyoruz.

}
