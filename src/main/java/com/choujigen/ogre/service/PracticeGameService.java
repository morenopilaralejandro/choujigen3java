package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PracticeGame;

public interface PracticeGameService {
	List<PracticeGame> all();

	PracticeGame one(Long id);

	PracticeGame insert(PracticeGame newObj);

	PracticeGame replace(PracticeGame newObj, Long id);

	void delete(Long id);
}
