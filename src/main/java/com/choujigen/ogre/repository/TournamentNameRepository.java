package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.TournamentName;

public interface TournamentNameRepository extends JpaRepository<TournamentName, Long> {

}
