package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PracticeGame;
import com.choujigen.ogre.exception.PracticeGameNotFoundException;
import com.choujigen.ogre.repository.PracticeGameRepository;

@Service
public class PracticeGameServiceImpl implements PracticeGameService {
	@Autowired
	private PracticeGameRepository practiceGameRepository;

	@Override
	public List<PracticeGame> all() {
		return practiceGameRepository.findAll();
	}

	@Override
	public PracticeGame one(Long id) {
		return practiceGameRepository.findById(id).orElseThrow(() -> new PracticeGameNotFoundException(id));
	}

	@Override
	public PracticeGame insert(PracticeGame newObj) {
		return practiceGameRepository.save(newObj);
	}

	@Override
	public PracticeGame replace(PracticeGame newObj, Long id) {
		return practiceGameRepository.findById(id).map(oldObj -> {
			oldObj.setPracticeGameOrder(newObj.getPracticeGameOrder());
			oldObj.setRoutePath(newObj.getRoutePath());
			oldObj.setTeam(newObj.getTeam());
			oldObj.setPracticeGameCondition(newObj.getPracticeGameCondition());
			return practiceGameRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPracticeGameId(id);
			return practiceGameRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		practiceGameRepository.deleteById(id);
	}
}
