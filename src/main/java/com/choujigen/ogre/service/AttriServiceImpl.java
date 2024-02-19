package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Attri;
import com.choujigen.ogre.exception.AttriNotFoundException;
import com.choujigen.ogre.repository.AttriRepository;

@Service
public class AttriServiceImpl implements AttriService {
	@Autowired
	private AttriRepository attriRepository;

	@Override
	public List<Attri> all() {
		return attriRepository.findAll();
	}

	@Override
	public Attri one(Long id) {
		return attriRepository.findById(id).orElseThrow(() -> new AttriNotFoundException(id));
	}

	@Override
	public Attri insert(Attri newObj) {
		return attriRepository.save(newObj);
	}

	@Override
	public Attri replace(Attri newObj, Long id) {
		return attriRepository.findById(id).map(oldObj -> {
			oldObj.setAttriNameJa(newObj.getAttriNameJa());
			oldObj.setAttriNameEn(newObj.getAttriNameEn());
			oldObj.setAttriNameEs(newObj.getAttriNameEs());
			return attriRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setAttriId(id);
			return attriRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		attriRepository.deleteById(id);
	}
}
