package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.CatchType;
import com.choujigen.ogre.exception.CatchTypeNotFoundException;
import com.choujigen.ogre.repository.CatchTypeRepository;

@Service
public class CatchTypeServiceImpl implements CatchTypeService {
	@Autowired
	private CatchTypeRepository catchTypeRepository;

	@Override
	public List<CatchType> all() {
		return catchTypeRepository.findAll();
	}

	@Override
	public CatchType one(Long id) {
		return catchTypeRepository.findById(id).orElseThrow(() -> new CatchTypeNotFoundException(id));
	}

	@Override
	public CatchType insert(CatchType newObj) {
		return catchTypeRepository.save(newObj);
	}

	@Override
	public CatchType replace(CatchType newObj, Long id) {
		return catchTypeRepository.findById(id).map(oldObj -> {
			oldObj.setCatchTypeNameJa(newObj.getCatchTypeNameJa());
			oldObj.setCatchTypeNameEn(newObj.getCatchTypeNameEn());
			oldObj.setCatchTypeNameEs(newObj.getCatchTypeNameEs());
			return catchTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setCatchTypeId(id);
			return catchTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		catchTypeRepository.deleteById(id);
	}
}
