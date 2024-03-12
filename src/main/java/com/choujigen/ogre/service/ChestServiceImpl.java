package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Chest;
import com.choujigen.ogre.exception.ChestNotFoundException;
import com.choujigen.ogre.repository.ChestRepository;

@Service
public class ChestServiceImpl implements ChestService {
	@Autowired
	private ChestRepository chestRepository;

	@Override
	public List<Chest> all() {
		return chestRepository.findAll();
	}

	@Override
	public Chest one(Long id) {
		return chestRepository.findById(id).orElseThrow(() -> new ChestNotFoundException(id));
	}

	@Override
	public Chest insert(Chest newObj) {
		return chestRepository.save(newObj);
	}

	@Override
	public Chest replace(Chest newObj, Long id) {
		return chestRepository.findById(id).map(oldObj -> {
			oldObj.setChestHintJa(newObj.getChestHintJa());
			oldObj.setChestHintEn(newObj.getChestHintEn());
			oldObj.setChestHintEs(newObj.getChestHintEs());
			oldObj.setZone(newObj.getZone());
			oldObj.setItem(newObj.getItem());
			return chestRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setChestId(id);
			return chestRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		chestRepository.deleteById(id);
	}
}
