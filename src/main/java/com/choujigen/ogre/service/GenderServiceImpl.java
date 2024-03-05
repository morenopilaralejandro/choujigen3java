package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Gender;
import com.choujigen.ogre.exception.GenderNotFoundException;
import com.choujigen.ogre.repository.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService {
	@Autowired
	private GenderRepository genderRepository;

	@Override
	public List<Gender> all() {
		return genderRepository.findAll();
	}

	@Override
	public Gender one(Long id) {
		return genderRepository.findById(id).orElseThrow(() -> new GenderNotFoundException(id));
	}

	@Override
	public Gender insert(Gender newObj) {
		return genderRepository.save(newObj);
	}

	@Override
	public Gender replace(Gender newObj, Long id) {
		return genderRepository.findById(id).map(oldObj -> {
			oldObj.setGenderNameJa(newObj.getGenderNameJa());
			oldObj.setGenderNameEn(newObj.getGenderNameEn());
			oldObj.setGenderNameEs(newObj.getGenderNameEs());
			oldObj.setGenderSymbol(newObj.getGenderSymbol());
			return genderRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGenderId(id);
			return genderRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		genderRepository.deleteById(id);
	}
}
