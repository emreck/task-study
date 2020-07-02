package com.emreck.taskstudy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "projeler")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Projeler extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "projectCode", unique = true)//bir tane proje kodu olabilir.
    private String projectCode;
    @Column(name = "projectName", length = 10000)
    private String projectName;
    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private  Kullanicilar manager;
}
