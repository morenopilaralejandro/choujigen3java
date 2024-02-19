package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
