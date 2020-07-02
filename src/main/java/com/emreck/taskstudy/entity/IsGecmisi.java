package com.emreck.taskstudy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

//her iş geçmişi işler tablosundaki kaydı gösterecek.
//önce açıldı sonnra şu kişiye atandı vs.

@Entity
@Table(name = "is_gecmisi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IsGecmisi extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "isdurum")
    @Enumerated(EnumType.STRING)
    private IsDurum isdurum;

    @Column(name = "details",length = 40000)
    private String details;

    @JoinColumn(name = "is_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Isler isler;




    @JoinColumn(name = "assiagne_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Kullanicilar atama;
}
