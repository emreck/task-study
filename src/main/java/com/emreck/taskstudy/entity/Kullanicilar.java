package com.emreck.taskstudy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "kullanici")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Kullanicilar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100,unique = true)//Buna dikkat etmek gerekir.
    private String username;

    @Column(name = "pwd",length =200 )
    private String password;

    @Column(name = "name_surname",length =200 )
    private String nameSurname;

    @Column(name = "email",length =100 )
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)//bir tane kullanıcıya bir çok iş bağlanabilir.
    private List<Isler> islers;//Eğer bu kullancıya select ettiğimde ona ait işleri görmek istersem





}
