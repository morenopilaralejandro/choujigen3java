package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.FormationScheme;
import com.choujigen.ogre.exception.FormationSchemeNotFoundException;
import com.choujigen.ogre.repository.FormationSchemeRepository;

@Service
public class FormationSchemeServiceImpl implements FormationSchemeService {
	@Autowired
	private FormationSchemeRepository formationSchemeRepository;

	@Override
	public List<FormationScheme> all() {
		return formationSchemeRepository.findAll();
	}

	@Override
	public FormationScheme one(Long id) {
		return formationSchemeRepository.findById(id).orElseThrow(() -> new FormationSchemeNotFoundException(id));
	}

	@Override
	public FormationScheme insert(FormationScheme newObj) {
		return formationSchemeRepository.save(newObj);
	}

	@Override
	public FormationScheme replace(FormationScheme newObj, Long id) {
		return formationSchemeRepository.findById(id).map(oldObj -> {
			oldObj.setFormationSchemeName(newObj.getFormationSchemeName());
			return formationSchemeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setFormationSchemeId(id);
			return formationSchemeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		formationSchemeRepository.deleteById(id);
	}
}
