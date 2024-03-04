package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Gender;

public interface GenreRepository extends JpaRepository<Gender, Long> {

}
