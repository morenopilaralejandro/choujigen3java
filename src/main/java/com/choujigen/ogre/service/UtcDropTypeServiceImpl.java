package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.UtcDropType;
import com.choujigen.ogre.exception.UtcDropTypeNotFoundException;
import com.choujigen.ogre.repository.UtcDropTypeRepository;

@Service
public class UtcDropTypeServiceImpl implements UtcDropTypeService {
	@Autowired
	private UtcDropTypeRepository utcDropTypeRepository;

	@Override
	public List<UtcDropType> all() {
		return utcDropTypeRepository.findAll();
	}

	@Override
	public UtcDropType one(Long id) {
		return utcDropTypeRepository.findById(id).orElseThrow(() -> new UtcDropTypeNotFoundException(id));
	}

	@Override
	public UtcDropType insert(UtcDropType newObj) {
		return utcDropTypeRepository.save(newObj);
	}

	@Override
	public UtcDropType replace(UtcDropType newObj, Long id) {
		return utcDropTypeRepository.findById(id).map(oldObj -> {
			oldObj.setUtcDropTypeNameJa(newObj.getUtcDropTypeNameJa());
			oldObj.setUtcDropTypeNameEn(newObj.getUtcDropTypeNameEn());
			oldObj.setUtcDropTypeNameEs(newObj.getUtcDropTypeNameEs());
			return utcDropTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setUtcDropTypeId(id);
			return utcDropTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		utcDropTypeRepository.deleteById(id);
	}
}
