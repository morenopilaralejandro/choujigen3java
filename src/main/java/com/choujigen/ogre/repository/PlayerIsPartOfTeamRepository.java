package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.PlayerIsPartOfTeam;
import com.choujigen.ogre.domain.PlayerIsPartOfTeamId;

public interface PlayerIsPartOfTeamRepository extends JpaRepository<PlayerIsPartOfTeam, Long> {
	Optional<PlayerIsPartOfTeam> findById(PlayerIsPartOfTeamId playerIsPartOfTeamId);

	void deleteById(PlayerIsPartOfTeamId playerIsPartOfTeamId);
}
