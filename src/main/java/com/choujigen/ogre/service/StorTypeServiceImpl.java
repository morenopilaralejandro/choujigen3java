package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.StorType;
import com.choujigen.ogre.exception.StorTypeNotFoundException;
import com.choujigen.ogre.repository.StorTypeRepository;

@Service
public class StorTypeServiceImpl implements StorTypeService {
	@Autowired
	private StorTypeRepository storTypeRepository;

	@Override
	public List<StorType> all() {
		return storTypeRepository.findAll();
	}

	@Override
	public StorType one(Long id) {
		return storTypeRepository.findById(id).orElseThrow(() -> new StorTypeNotFoundException(id));
	}

	@Override
	public StorType insert(StorType newObj) {
		return storTypeRepository.save(newObj);
	}

	@Override
	public StorType replace(StorType newObj, Long id) {
		return storTypeRepository.findById(id).map(oldObj -> {
			oldObj.setStorTypeNameJa(newObj.getStorTypeNameJa());
			oldObj.setStorTypeNameEn(newObj.getStorTypeNameEn());
			oldObj.setStorTypeNameEs(newObj.getStorTypeNameEs());
			return storTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setStorTypeId(id);
			return storTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		storTypeRepository.deleteById(id);
	}
}
