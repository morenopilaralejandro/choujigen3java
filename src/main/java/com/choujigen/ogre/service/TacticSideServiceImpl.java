package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TacticSide;
import com.choujigen.ogre.exception.TacticSideNotFoundException;
import com.choujigen.ogre.repository.TacticSideRepository;

@Service
public class TacticSideServiceImpl implements TacticSideService {
	@Autowired
	private TacticSideRepository tacticSideRepository;

	@Override
	public List<TacticSide> all() {
		return tacticSideRepository.findAll();
	}

	@Override
	public TacticSide one(Long id) {
		return tacticSideRepository.findById(id).orElseThrow(() -> new TacticSideNotFoundException(id));
	}

	@Override
	public TacticSide insert(TacticSide newObj) {
		return tacticSideRepository.save(newObj);
	}

	@Override
	public TacticSide replace(TacticSide newObj, Long id) {
		return tacticSideRepository.findById(id).map(oldObj -> {
			oldObj.setTacticSideNameJa(newObj.getTacticSideNameJa());
			oldObj.setTacticSideNameEn(newObj.getTacticSideNameEn());
			oldObj.setTacticSideNameEs(newObj.getTacticSideNameEs());
			return tacticSideRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTacticSideId(id);
			return tacticSideRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		tacticSideRepository.deleteById(id);
	}
}
