package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.UtcSessionDrops;
import com.choujigen.ogre.domain.UtcSessionDropsId;

public interface UtcSessionDropsRepository extends JpaRepository<UtcSessionDrops, UtcSessionDropsId> {
	Optional<UtcSessionDrops> findById(UtcSessionDropsId utcSessionDropsId);

	void deleteById(UtcSessionDropsId utcSessionDropsId);
}
