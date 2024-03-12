package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.EquipmentStrengthensStat;
import com.choujigen.ogre.domain.EquipmentStrengthensStatId;

public interface EquipmentStrengthensStatRepository extends JpaRepository<EquipmentStrengthensStat, Long> {
	Optional<EquipmentStrengthensStat> findById(EquipmentStrengthensStatId equipmentStrengthensStatId);

	void deleteById(EquipmentStrengthensStatId equipmentStrengthensStatId);
}
