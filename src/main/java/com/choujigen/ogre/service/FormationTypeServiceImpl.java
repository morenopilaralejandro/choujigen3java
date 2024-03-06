package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.FormationType;
import com.choujigen.ogre.exception.FormationTypeNotFoundException;
import com.choujigen.ogre.repository.FormationTypeRepository;

@Service
public class FormationTypeServiceImpl implements FormationTypeService {
	@Autowired
	private FormationTypeRepository formationTypeRepository;

	@Override
	public List<FormationType> all() {
		return formationTypeRepository.findAll();
	}

	@Override
	public FormationType one(Long id) {
		return formationTypeRepository.findById(id).orElseThrow(() -> new FormationTypeNotFoundException(id));
	}

	@Override
	public FormationType insert(FormationType newObj) {
		return formationTypeRepository.save(newObj);
	}

	@Override
	public FormationType replace(FormationType newObj, Long id) {
		return formationTypeRepository.findById(id).map(oldObj -> {
			oldObj.setFormationTypeNameJa(newObj.getFormationTypeNameJa());
			oldObj.setFormationTypeNameEn(newObj.getFormationTypeNameEn());
			oldObj.setFormationTypeNameEs(newObj.getFormationTypeNameEs());
			return formationTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setFormationTypeId(id);
			return formationTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		formationTypeRepository.deleteById(id);
	}
}
