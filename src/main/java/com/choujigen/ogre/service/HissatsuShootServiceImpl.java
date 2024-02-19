package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuShoot;
import com.choujigen.ogre.exception.HissatsuShootNotFoundException;
import com.choujigen.ogre.repository.HissatsuShootRepository;

@Service
public class HissatsuShootServiceImpl implements HissatsuShootService {
	@Autowired
	private HissatsuShootRepository hissatsuShootRepository;

	@Override
	public List<HissatsuShoot> all() {
		return hissatsuShootRepository.findAll();
	}

	@Override
	public HissatsuShoot one(Long id) {
		return hissatsuShootRepository.findById(id).orElseThrow(() -> new HissatsuShootNotFoundException(id));
	}

	@Override
	public HissatsuShoot insert(HissatsuShoot newObj) {
		return hissatsuShootRepository.save(newObj);
	}

	@Override
	public HissatsuShoot replace(HissatsuShoot newObj, Long id) {
		return hissatsuShootRepository.findById(id).map(oldObj -> {
			oldObj.setHissatsuShootPower(newObj.getHissatsuShootPower());
			oldObj.setHissatsuShootTp(newObj.getHissatsuShootTp());
			oldObj.setHissatsuShootParticipants(newObj.getHissatsuShootParticipants());
			oldObj.setShootSpecialProperty(newObj.getShootSpecialProperty());
			return hissatsuShootRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return hissatsuShootRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		hissatsuShootRepository.deleteById(id);
	}
}
