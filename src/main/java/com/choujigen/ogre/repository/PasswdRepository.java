package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Passwd;

public interface PasswdRepository extends JpaRepository<Passwd, Long> {

}
