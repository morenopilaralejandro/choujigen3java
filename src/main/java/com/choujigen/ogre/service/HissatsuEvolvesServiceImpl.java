package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuEvolves;
import com.choujigen.ogre.domain.HissatsuEvolvesId;
import com.choujigen.ogre.exception.HissatsuEvolvesNotFoundException;
import com.choujigen.ogre.repository.HissatsuEvolvesRepository;

@Service
public class HissatsuEvolvesServiceImpl implements HissatsuEvolvesService {
	@Autowired
	private HissatsuEvolvesRepository hissatsuEvolvesRepository;

	@Override
	public List<HissatsuEvolves> all() {
		return hissatsuEvolvesRepository.findAll();
	}

	@Override
	public HissatsuEvolves one(Long itemHissatsuId, Long growthTypeId, Long growthRateId) {
		return hissatsuEvolvesRepository.findById(new HissatsuEvolvesId(itemHissatsuId, growthTypeId, growthRateId))
				.orElseThrow(() -> new HissatsuEvolvesNotFoundException(itemHissatsuId, growthTypeId, growthRateId));
	}

	@Override
	public HissatsuEvolves insert(HissatsuEvolves newObj) {
		return hissatsuEvolvesRepository.save(newObj);
	}

	@Override
	public HissatsuEvolves replace(HissatsuEvolves newObj, Long itemHissatsuId, Long growthTypeId, Long growthRateId) {
		return hissatsuEvolvesRepository.findById(new HissatsuEvolvesId(itemHissatsuId, growthTypeId, growthRateId))
				.map(oldObj -> {
					;
					return hissatsuEvolvesRepository.save(oldObj);
				}).orElseGet(() -> {
					newObj.setId(new HissatsuEvolvesId(itemHissatsuId, growthTypeId, growthRateId));
					return hissatsuEvolvesRepository.save(newObj);
				});
	}

	@Override
	public void delete(Long itemHissatsuId, Long growthTypeId, Long growthRateId) {
		hissatsuEvolvesRepository.deleteById(new HissatsuEvolvesId(itemHissatsuId, growthTypeId, growthRateId));
	}
}
