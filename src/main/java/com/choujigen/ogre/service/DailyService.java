package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Daily;

public interface DailyService {
	List<Daily> all();

	Daily one(Long id);

	Daily insert(Daily newObj);

	Daily replace(Daily newObj, Long id);

	void delete(Long id);
}
