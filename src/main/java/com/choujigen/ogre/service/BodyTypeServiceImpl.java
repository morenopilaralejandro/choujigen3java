package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.BodyType;
import com.choujigen.ogre.exception.BodyTypeNotFoundException;
import com.choujigen.ogre.repository.BodyTypeRepository;

@Service
public class BodyTypeServiceImpl implements BodyTypeService {
	@Autowired
	private BodyTypeRepository bodyTypeRepository;

	@Override
	public List<BodyType> all() {
		return bodyTypeRepository.findAll();
	}

	@Override
	public BodyType one(Long id) {
		return bodyTypeRepository.findById(id).orElseThrow(() -> new BodyTypeNotFoundException(id));
	}

	@Override
	public BodyType insert(BodyType newObj) {
		return bodyTypeRepository.save(newObj);
	}

	@Override
	public BodyType replace(BodyType newObj, Long id) {
		return bodyTypeRepository.findById(id).map(oldObj -> {
			oldObj.setBodyTypeNameJa(newObj.getBodyTypeNameJa());
			oldObj.setBodyTypeNameEn(newObj.getBodyTypeNameEn());
			oldObj.setBodyTypeNameEs(newObj.getBodyTypeNameEs());
			return bodyTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setBodyTypeId(id);
			return bodyTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		bodyTypeRepository.deleteById(id);
	}
}
