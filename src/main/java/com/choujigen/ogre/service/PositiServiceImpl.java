package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Positi;
import com.choujigen.ogre.exception.PositiNotFoundException;
import com.choujigen.ogre.repository.PositiRepository;

@Service
public class PositiServiceImpl implements PositiService {
	@Autowired
	private PositiRepository positiRepository;

	@Override
	public List<Positi> all() {
		return positiRepository.findAll();
	}

	@Override
	public Positi one(Long id) {
		return positiRepository.findById(id).orElseThrow(() -> new PositiNotFoundException(id));
	}

	@Override
	public Positi insert(Positi newObj) {
		return positiRepository.save(newObj);
	}

	@Override
	public Positi replace(Positi newObj, Long id) {
		return positiRepository.findById(id).map(oldObj -> {
			oldObj.setPositiNameJa(newObj.getPositiNameJa());
			oldObj.setPositiNameEn(newObj.getPositiNameEn());
			oldObj.setPositiNameEs(newObj.getPositiNameEs());
			return positiRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPositiId(id);
			return positiRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		positiRepository.deleteById(id);
	}
}
