package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ShootSpecialProperty;
import com.choujigen.ogre.exception.ShootSpecialPropertyNotFoundException;
import com.choujigen.ogre.repository.ShootSpecialPropertyRepository;

@Service
public class ShootSpecialPropertyServiceImpl implements ShootSpecialPropertyService {
	@Autowired
	private ShootSpecialPropertyRepository shootSpecialPropertyRepository;

	@Override
	public List<ShootSpecialProperty> all() {
		return shootSpecialPropertyRepository.findAll();
	}

	@Override
	public ShootSpecialProperty one(Long id) {
		return shootSpecialPropertyRepository.findById(id)
				.orElseThrow(() -> new ShootSpecialPropertyNotFoundException(id));
	}

	@Override
	public ShootSpecialProperty insert(ShootSpecialProperty newObj) {
		return shootSpecialPropertyRepository.save(newObj);
	}

	@Override
	public ShootSpecialProperty replace(ShootSpecialProperty newObj, Long id) {
		return shootSpecialPropertyRepository.findById(id).map(oldObj -> {
			oldObj.setShootSpecialPropertyNameJa(newObj.getShootSpecialPropertyNameJa());
			oldObj.setShootSpecialPropertyNameEn(newObj.getShootSpecialPropertyNameEn());
			oldObj.setShootSpecialPropertyNameEs(newObj.getShootSpecialPropertyNameEs());
			return shootSpecialPropertyRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setShootSpecialPropertyId(id);
			return shootSpecialPropertyRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		shootSpecialPropertyRepository.deleteById(id);
	}
}
