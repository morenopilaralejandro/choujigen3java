package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TrainingMethod;

public interface TrainingMethodService {
	List<TrainingMethod> all();

	TrainingMethod one(Long id);

	TrainingMethod insert(TrainingMethod newObj);

	TrainingMethod replace(TrainingMethod newObj, Long id);

	void delete(Long id);
}
