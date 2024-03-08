package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TrainingMethod;
import com.choujigen.ogre.exception.TrainingMethodNotFoundException;
import com.choujigen.ogre.repository.TrainingMethodRepository;

@Service
public class TrainingMethodServiceImpl implements TrainingMethodService {
	@Autowired
	private TrainingMethodRepository trainingMethodRepository;

	@Override
	public List<TrainingMethod> all() {
		return trainingMethodRepository.findAll();
	}

	@Override
	public TrainingMethod one(Long id) {
		return trainingMethodRepository.findById(id).orElseThrow(() -> new TrainingMethodNotFoundException(id));
	}

	@Override
	public TrainingMethod insert(TrainingMethod newObj) {
		return trainingMethodRepository.save(newObj);
	}

	@Override
	public TrainingMethod replace(TrainingMethod newObj, Long id) {
		return trainingMethodRepository.findById(id).map(oldObj -> {
			oldObj.setTrainingMethodNameJa(newObj.getTrainingMethodNameJa());
			oldObj.setTrainingMethodNameEn(newObj.getTrainingMethodNameEn());
			oldObj.setTrainingMethodNameEs(newObj.getTrainingMethodNameEs());
			oldObj.setTrainingMethodDescJa(newObj.getTrainingMethodDescJa());
			oldObj.setTrainingMethodDescEn(newObj.getTrainingMethodDescEn());
			oldObj.setTrainingMethodDescEs(newObj.getTrainingMethodDescEs());
			return trainingMethodRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTrainingMethodId(id);
			return trainingMethodRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		trainingMethodRepository.deleteById(id);
	}
}
