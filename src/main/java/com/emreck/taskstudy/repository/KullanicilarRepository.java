package com.emreck.taskstudy.repository;


import com.emreck.taskstudy.entity.Kullanicilar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KullanicilarRepository extends JpaRepository<Kullanicilar, Long> {
 Kullanicilar findByUsername(String username);
}
