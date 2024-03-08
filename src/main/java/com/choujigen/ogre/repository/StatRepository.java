package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Stat;

public interface StatRepository extends JpaRepository<Stat, Long> {

}
