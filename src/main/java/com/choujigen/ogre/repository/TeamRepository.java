package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
