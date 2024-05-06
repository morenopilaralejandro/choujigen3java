package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PracticeGameCondition;
import com.choujigen.ogre.exception.PracticeGameConditionNotFoundException;
import com.choujigen.ogre.repository.PracticeGameConditionRepository;

@Service
public class PracticeGameConditionServiceImpl implements PracticeGameConditionService {
	@Autowired
	private PracticeGameConditionRepository practiceGameConditionRepository;

	@Override
	public List<PracticeGameCondition> all() {
		return practiceGameConditionRepository.findAll();
	}

	@Override
	public PracticeGameCondition one(Long id) {
		return practiceGameConditionRepository.findById(id).orElseThrow(() -> new PracticeGameConditionNotFoundException(id));
	}

	@Override
	public PracticeGameCondition insert(PracticeGameCondition newObj) {
		return practiceGameConditionRepository.save(newObj);
	}

	@Override
	public PracticeGameCondition replace(PracticeGameCondition newObj, Long id) {
		return practiceGameConditionRepository.findById(id).map(oldObj -> {
			oldObj.setPracticeGameConditionDescJa(newObj.getPracticeGameConditionDescJa());
			oldObj.setPracticeGameConditionDescEn(newObj.getPracticeGameConditionDescEn());
			oldObj.setPracticeGameConditionDescEs(newObj.getPracticeGameConditionDescEs());
			return practiceGameConditionRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPracticeGameConditionId(id);
			return practiceGameConditionRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		practiceGameConditionRepository.deleteById(id);
	}
}
