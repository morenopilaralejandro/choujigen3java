package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.FormationOrganizedAsPositi;
import com.choujigen.ogre.domain.FormationOrganizedAsPositiId;
import com.choujigen.ogre.exception.FormationOrganizedAsPositiNotFoundException;
import com.choujigen.ogre.repository.FormationOrganizedAsPositiRepository;

@Service
public class FormationOrganizedAsPositiServiceImpl implements FormationOrganizedAsPositiService {
	@Autowired
	private FormationOrganizedAsPositiRepository formationOrganizedAsPositiRepository;

	@Override
	public List<FormationOrganizedAsPositi> all() {
		return formationOrganizedAsPositiRepository.findAll();
	}

	@Override
	public FormationOrganizedAsPositi one(FormationOrganizedAsPositiId formationOrganizedAsPositiId) {
		return formationOrganizedAsPositiRepository.findById(formationOrganizedAsPositiId)
				.orElseThrow(() -> new FormationOrganizedAsPositiNotFoundException(formationOrganizedAsPositiId));
	}

	@Override
	public FormationOrganizedAsPositi insert(FormationOrganizedAsPositi newObj) {
		return formationOrganizedAsPositiRepository.save(newObj);
	}

	@Override
	public FormationOrganizedAsPositi replace(FormationOrganizedAsPositi newObj,
			FormationOrganizedAsPositiId formationOrganizedAsPositiId) {
		return formationOrganizedAsPositiRepository.findById(formationOrganizedAsPositiId).map(oldObj -> {
			oldObj.setPlace(newObj.getPlace());
			return formationOrganizedAsPositiRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(formationOrganizedAsPositiId);
			return formationOrganizedAsPositiRepository.save(newObj);
		});
	}

	@Override
	public void delete(FormationOrganizedAsPositiId formationOrganizedAsPositiId) {
		formationOrganizedAsPositiRepository.deleteById(formationOrganizedAsPositiId);
	}

}
