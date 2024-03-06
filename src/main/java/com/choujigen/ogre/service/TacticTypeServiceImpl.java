package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TacticType;
import com.choujigen.ogre.exception.TacticTypeNotFoundException;
import com.choujigen.ogre.repository.TacticTypeRepository;

@Service
public class TacticTypeServiceImpl implements TacticTypeService {
	@Autowired
	private TacticTypeRepository tacticTypeRepository;

	@Override
	public List<TacticType> all() {
		return tacticTypeRepository.findAll();
	}

	@Override
	public TacticType one(Long id) {
		return tacticTypeRepository.findById(id).orElseThrow(() -> new TacticTypeNotFoundException(id));
	}

	@Override
	public TacticType insert(TacticType newObj) {
		return tacticTypeRepository.save(newObj);
	}

	@Override
	public TacticType replace(TacticType newObj, Long id) {
		return tacticTypeRepository.findById(id).map(oldObj -> {
			oldObj.setTacticTypeNameJa(newObj.getTacticTypeNameJa());
			oldObj.setTacticTypeNameEn(newObj.getTacticTypeNameEn());
			oldObj.setTacticTypeNameEs(newObj.getTacticTypeNameEs());
			return tacticTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTacticTypeId(id);
			return tacticTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		tacticTypeRepository.deleteById(id);
	}
}
