package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.FormationOrganizedAsPositi;
import com.choujigen.ogre.domain.FormationOrganizedAsPositiId;

public interface FormationOrganizedAsPositiRepository extends JpaRepository<FormationOrganizedAsPositi, Long> {
	Optional<FormationOrganizedAsPositi> findById(FormationOrganizedAsPositiId formationOrganizedAsPositiId);

	void deleteById(FormationOrganizedAsPositiId formationOrganizedAsPositiId);
}
