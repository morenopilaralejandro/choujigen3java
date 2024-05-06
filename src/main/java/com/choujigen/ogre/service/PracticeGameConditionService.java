package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PracticeGameCondition;

public interface PracticeGameConditionService {
	List<PracticeGameCondition> all();

	PracticeGameCondition one(Long id);

	PracticeGameCondition insert(PracticeGameCondition newObj);

	PracticeGameCondition replace(PracticeGameCondition newObj, Long id);

	void delete(Long id);
}
