package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.UltimateNoteIncreasesFree;
import com.choujigen.ogre.domain.UltimateNoteIncreasesFreeId;
import com.choujigen.ogre.exception.UltimateNoteIncreasesFreeNotFoundException;
import com.choujigen.ogre.repository.UltimateNoteIncreasesFreeRepository;

@Service
public class UltimateNoteIncreasesFreeServiceImpl implements UltimateNoteIncreasesFreeService {
	@Autowired
	private UltimateNoteIncreasesFreeRepository ultimateNoteIncreasesFreeRepository;

	@Override
	public List<UltimateNoteIncreasesFree> all() {
		return ultimateNoteIncreasesFreeRepository.findAll();
	}

	@Override
	public UltimateNoteIncreasesFree one(UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId) {
		return ultimateNoteIncreasesFreeRepository.findById(ultimateNoteIncreasesFreeId)
				.orElseThrow(() -> new UltimateNoteIncreasesFreeNotFoundException(ultimateNoteIncreasesFreeId));
	}

	@Override
	public UltimateNoteIncreasesFree insert(UltimateNoteIncreasesFree newObj) {
		return ultimateNoteIncreasesFreeRepository.save(newObj);
	}

	@Override
	public UltimateNoteIncreasesFree replace(UltimateNoteIncreasesFree newObj, UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId) {
		return ultimateNoteIncreasesFreeRepository.findById(ultimateNoteIncreasesFreeId).map(oldObj -> {
			oldObj.setItemUltimateNote(newObj.getItemUltimateNote());
			oldObj.setPositi(newObj.getPositi());
			oldObj.setAttri(newObj.getAttri());
			return ultimateNoteIncreasesFreeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(ultimateNoteIncreasesFreeId);
			return ultimateNoteIncreasesFreeRepository.save(newObj);
		});
	}

	@Override
	public void delete(UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId) {
		ultimateNoteIncreasesFreeRepository.deleteById(ultimateNoteIncreasesFreeId);
	}

}
