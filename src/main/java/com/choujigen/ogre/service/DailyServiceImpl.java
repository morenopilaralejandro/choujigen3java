package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Daily;
import com.choujigen.ogre.exception.DailyNotFoundException;
import com.choujigen.ogre.repository.DailyRepository;

@Service
public class DailyServiceImpl implements DailyService {
	@Autowired
	private DailyRepository dailyRepository;

	@Override
	public List<Daily> all() {
		return dailyRepository.findAll();
	}

	@Override
	public Daily one(Long id) {
		return dailyRepository.findById(id).orElseThrow(() -> new DailyNotFoundException(id));
	}

	@Override
	public Daily insert(Daily newObj) {
		return dailyRepository.save(newObj);
	}

	@Override
	public Daily replace(Daily newObj, Long id) {
		return dailyRepository.findById(id).map(oldObj -> {
			oldObj.setPlayer(newObj.getPlayer());
			oldObj.setViews(newObj.getViews());
			return dailyRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setDailyId(id);
			return dailyRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		dailyRepository.deleteById(id);
	}
}
