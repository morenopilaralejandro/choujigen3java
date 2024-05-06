package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ExtraBattleRoute;
import com.choujigen.ogre.exception.ExtraBattleRouteNotFoundException;
import com.choujigen.ogre.repository.ExtraBattleRouteRepository;

@Service
public class ExtraBattleRouteServiceImpl implements ExtraBattleRouteService {
	@Autowired
	private ExtraBattleRouteRepository extraBattleRouteRepository;

	@Override
	public List<ExtraBattleRoute> all() {
		return extraBattleRouteRepository.findAll();
	}

	@Override
	public ExtraBattleRoute one(Long id) {
		return extraBattleRouteRepository.findById(id).orElseThrow(() -> new ExtraBattleRouteNotFoundException(id));
	}

	@Override
	public ExtraBattleRoute insert(ExtraBattleRoute newObj) {
		return extraBattleRouteRepository.save(newObj);
	}

	@Override
	public ExtraBattleRoute replace(ExtraBattleRoute newObj, Long id) {
		return extraBattleRouteRepository.findById(id).map(oldObj -> {
			oldObj.setExtraBattleRouteNameJa(newObj.getExtraBattleRouteNameJa());
			oldObj.setExtraBattleRouteNameEn(newObj.getExtraBattleRouteNameEn());
			oldObj.setExtraBattleRouteNameEs(newObj.getExtraBattleRouteNameEs());
			oldObj.setNpc(newObj.getNpc());
			return extraBattleRouteRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setExtraBattleRouteId(id);
			return extraBattleRouteRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		extraBattleRouteRepository.deleteById(id);
	}
}
