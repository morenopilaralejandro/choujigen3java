package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PracticeGameDropItem;
import com.choujigen.ogre.domain.PracticeGameDropItemId;
import com.choujigen.ogre.exception.PracticeGameDropItemNotFoundException;
import com.choujigen.ogre.repository.PracticeGameDropItemRepository;

@Service
public class PracticeGameDropItemServiceImpl implements PracticeGameDropItemService {
	@Autowired
	private PracticeGameDropItemRepository practiceGameDropItemRepository;

	@Override
	public List<PracticeGameDropItem> all() {
		return practiceGameDropItemRepository.findAll();
	}

	@Override
	public PracticeGameDropItem one(PracticeGameDropItemId practiceGameDropItemId) {
		return practiceGameDropItemRepository.findById(practiceGameDropItemId)
				.orElseThrow(() -> new PracticeGameDropItemNotFoundException(practiceGameDropItemId));
	}

	@Override
	public PracticeGameDropItem insert(PracticeGameDropItem newObj) {
		return practiceGameDropItemRepository.save(newObj);
	}

	@Override
	public PracticeGameDropItem replace(PracticeGameDropItem newObj, PracticeGameDropItemId practiceGameDropItemId) {
		return practiceGameDropItemRepository.findById(practiceGameDropItemId).map(oldObj -> {
			oldObj.setPracticeGame(newObj.getPracticeGame());
			oldObj.setDropRate(newObj.getDropRate());
			return practiceGameDropItemRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(practiceGameDropItemId);
			return practiceGameDropItemRepository.save(newObj);
		});
	}

	@Override
	public void delete(PracticeGameDropItemId practiceGameDropItemId) {
		practiceGameDropItemRepository.deleteById(practiceGameDropItemId);
	}

}
