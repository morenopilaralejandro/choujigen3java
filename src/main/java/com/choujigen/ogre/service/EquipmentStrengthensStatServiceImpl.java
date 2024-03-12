package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.EquipmentStrengthensStat;
import com.choujigen.ogre.domain.EquipmentStrengthensStatId;
import com.choujigen.ogre.exception.EquipmentStrengthensStatNotFoundException;
import com.choujigen.ogre.repository.EquipmentStrengthensStatRepository;

@Service
public class EquipmentStrengthensStatServiceImpl implements EquipmentStrengthensStatService {
	@Autowired
	private EquipmentStrengthensStatRepository equipmentStrengthensStatRepository;

	@Override
	public List<EquipmentStrengthensStat> all() {
		return equipmentStrengthensStatRepository.findAll();
	}

	@Override
	public EquipmentStrengthensStat one(EquipmentStrengthensStatId equipmentStrengthensStatId) {
		return equipmentStrengthensStatRepository.findById(equipmentStrengthensStatId)
				.orElseThrow(() -> new EquipmentStrengthensStatNotFoundException(equipmentStrengthensStatId));
	}

	@Override
	public EquipmentStrengthensStat insert(EquipmentStrengthensStat newObj) {
		return equipmentStrengthensStatRepository.save(newObj);
	}

	@Override
	public EquipmentStrengthensStat replace(EquipmentStrengthensStat newObj,
			EquipmentStrengthensStatId equipmentStrengthensStatId) {
		return equipmentStrengthensStatRepository.findById(equipmentStrengthensStatId).map(oldObj -> {
			oldObj.setAmount(newObj.getAmount());
			return equipmentStrengthensStatRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(equipmentStrengthensStatId);
			return equipmentStrengthensStatRepository.save(newObj);
		});
	}

	@Override
	public void delete(EquipmentStrengthensStatId equipmentStrengthensStatId) {
		equipmentStrengthensStatRepository.deleteById(equipmentStrengthensStatId);
	}

}
