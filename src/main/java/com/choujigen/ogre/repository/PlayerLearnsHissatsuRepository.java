package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.PlayerLearnsHissatsu;
import com.choujigen.ogre.domain.PlayerLearnsHissatsuId;

public interface PlayerLearnsHissatsuRepository extends JpaRepository<PlayerLearnsHissatsu, Long> {
	Optional<PlayerLearnsHissatsu> findById(PlayerLearnsHissatsuId playerLearnsHissatsuId);

	void deleteById(PlayerLearnsHissatsuId playerLearnsHissatsuId);
}
