package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuType;
import com.choujigen.ogre.exception.HissatsuTypeNotFoundException;
import com.choujigen.ogre.repository.HissatsuTypeRepository;

@Service
public class HissatsuTypeServiceImpl implements HissatsuTypeService {
	@Autowired
	private HissatsuTypeRepository hissatsuTypeRepository;

	@Override
	public List<HissatsuType> all() {
		return hissatsuTypeRepository.findAll();
	}

	@Override
	public HissatsuType one(Long id) {
		return hissatsuTypeRepository.findById(id).orElseThrow(() -> new HissatsuTypeNotFoundException(id));
	}

	@Override
	public HissatsuType insert(HissatsuType newObj) {
		return hissatsuTypeRepository.save(newObj);
	}

	@Override
	public HissatsuType replace(HissatsuType newObj, Long id) {
		return hissatsuTypeRepository.findById(id).map(oldObj -> {
			oldObj.setHissatsuTypeNameJa(newObj.getHissatsuTypeNameJa());
			oldObj.setHissatsuTypeNameEn(newObj.getHissatsuTypeNameEn());
			oldObj.setHissatsuTypeNameEs(newObj.getHissatsuTypeNameEs());
			return hissatsuTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setHissatsuTypeId(id);
			return hissatsuTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		hissatsuTypeRepository.deleteById(id);
	}
}
