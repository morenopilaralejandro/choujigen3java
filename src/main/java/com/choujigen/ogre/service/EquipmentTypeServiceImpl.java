package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.EquipmentType;
import com.choujigen.ogre.exception.EquipmentTypeNotFoundException;
import com.choujigen.ogre.repository.EquipmentTypeRepository;

@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {
	@Autowired
	private EquipmentTypeRepository equipmentTypeRepository;

	@Override
	public List<EquipmentType> all() {
		return equipmentTypeRepository.findAll();
	}

	@Override
	public EquipmentType one(Long id) {
		return equipmentTypeRepository.findById(id).orElseThrow(() -> new EquipmentTypeNotFoundException(id));
	}

	@Override
	public EquipmentType insert(EquipmentType newObj) {
		return equipmentTypeRepository.save(newObj);
	}

	@Override
	public EquipmentType replace(EquipmentType newObj, Long id) {
		return equipmentTypeRepository.findById(id).map(oldObj -> {
			oldObj.setEquipmentTypeNameJa(newObj.getEquipmentTypeNameJa());
			oldObj.setEquipmentTypeNameEn(newObj.getEquipmentTypeNameEn());
			oldObj.setEquipmentTypeNameEs(newObj.getEquipmentTypeNameEs());
			return equipmentTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setEquipmentTypeId(id);
			return equipmentTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		equipmentTypeRepository.deleteById(id);
	}
}
