package com.emreck.taskstudy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity// tablo olacak. orm nesnesidir. veritabanında tabloya karşılık gelecek.
@Table(name ="isler") //koymazsak class adında oluşturur. büyük i olarak yazarsa sıkıntı olur.
@Data //getter setter getiriyor.
@NoArgsConstructor//boş constrocture yaratır.
@AllArgsConstructor//tüm constrocturelere oluşturuyor.
@ToString//tanımlamaların to stringini eziyor.
@EqualsAndHashCode // hascode eziyor.
public class Isler extends BaseEntity {

    @Id//classın bir entity olmasını sağlayan minimum özellik diğer anatasyonlar olmasada olur.
    @GeneratedValue(strategy = GenerationType.AUTO) //id lerin otomatik oluşması.
    private Long id; // id'si olmak zorunda

    @Column(name = "description",length = 400)
    private String description; // açıklaması

    @Column(name = "details",length =400 )
    private String details;//ayrıntılar

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date; //ne zaman açılmış.

    @Column(name = "isdurum")
    @Enumerated(EnumType.STRING)/*Enum tipindeki fieldlerde kullanılır. özellikleri değiştirilebilir.
    Enumtype.ORDİNAL Olursa enum classındaki veriler yukardan aşağı 1.2.3.. gibi sıralanır daha az yer kaplar ancak
    enum classına daha sonradan biri ekleme yaparsa indisler bozulacağından eski veriler bozulur
    string olursa normal string olarak tutar biraz daha yer kaplar.*/
    private IsDurum isdurum;

    @JoinColumn(name ="assignee_user_id" )//baglantili tablonun adi.
    @ManyToOne(optional = true,fetch = FetchType.LAZY)//ilişkilendirme yani bir çok iş(mevcut classtan bahsediyor)
   /* bir Kullanıcıya bağlı. optional=true -- yani işi kullanıcıya atamasanda olur null kalabilir
    lazy ise isler tablosuna select atılırken kullanıcı tablosunada atılıp getirilsin mi diyor.
    ihtiyaç duyulduğunda lazy EAGER olursa her zaman getirir.*/
    private Kullanicilar kullanicilar;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Projeler projeler;





}
