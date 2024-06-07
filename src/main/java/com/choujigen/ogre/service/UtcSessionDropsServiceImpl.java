package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.UtcSessionDrops;
import com.choujigen.ogre.domain.UtcSessionDropsId;
import com.choujigen.ogre.exception.UtcSessionDropsNotFoundException;
import com.choujigen.ogre.repository.UtcSessionDropsRepository;

@Service
public class UtcSessionDropsServiceImpl implements UtcSessionDropsService {
	@Autowired
	private UtcSessionDropsRepository utcSessionDropsRepository;

	@Override
	public List<UtcSessionDrops> all() {
		return utcSessionDropsRepository.findAll();
	}

	@Override
	public UtcSessionDrops one(UtcSessionDropsId utcSessionDropsId) {
		return utcSessionDropsRepository.findById(utcSessionDropsId)
				.orElseThrow(() -> new UtcSessionDropsNotFoundException(utcSessionDropsId));
	}

	@Override
	public UtcSessionDrops insert(UtcSessionDrops newObj) {
		return utcSessionDropsRepository.save(newObj);
	}

	@Override
	public UtcSessionDrops replace(UtcSessionDrops newObj, UtcSessionDropsId utcSessionDropsId) {
		return utcSessionDropsRepository.findById(utcSessionDropsId).map(oldObj -> {
			oldObj.setUtcDropType(newObj.getUtcDropType());
			oldObj.setDropRate(newObj.getDropRate());
			return utcSessionDropsRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(utcSessionDropsId);
			return utcSessionDropsRepository.save(newObj);
		});
	}

	@Override
	public void delete(UtcSessionDropsId utcSessionDropsId) {
		utcSessionDropsRepository.deleteById(utcSessionDropsId);
	}

}
