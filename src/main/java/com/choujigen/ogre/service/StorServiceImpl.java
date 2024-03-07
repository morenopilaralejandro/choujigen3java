package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Stor;
import com.choujigen.ogre.exception.StorNotFoundException;
import com.choujigen.ogre.repository.StorRepository;

@Service
public class StorServiceImpl implements StorService {
	@Autowired
	private StorRepository storRepository;

	@Override
	public List<Stor> all() {
		return storRepository.findAll();
	}

	@Override
	public Stor one(Long id) {
		return storRepository.findById(id).orElseThrow(() -> new StorNotFoundException(id));
	}

	@Override
	public Stor insert(Stor newObj) {
		return storRepository.save(newObj);
	}

	@Override
	public Stor replace(Stor newObj, Long id) {
		return storRepository.findById(id).map(oldObj -> {
			oldObj.setStorType(newObj.getStorType());
			oldObj.setZone(newObj.getZone());
			return storRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setStorId(id);
			return storRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		storRepository.deleteById(id);
	}
}
