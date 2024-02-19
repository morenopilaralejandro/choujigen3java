package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.HissatsuEvolves;
import com.choujigen.ogre.domain.HissatsuEvolvesId;

public interface HissatsuEvolvesRepository extends JpaRepository<HissatsuEvolves, Long> {

	Optional<HissatsuEvolves> findById(HissatsuEvolvesId hissatsuEvolvesId);

	void deleteById(HissatsuEvolvesId hissatsuEvolvesId);

}
