package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PracticeGameDropItem;
import com.choujigen.ogre.domain.PracticeGameDropItemId;

public interface PracticeGameDropItemService {
	List<PracticeGameDropItem> all();

	PracticeGameDropItem one(PracticeGameDropItemId formationOrganizedAsPositiId);

	PracticeGameDropItem insert(PracticeGameDropItem newObj);

	PracticeGameDropItem replace(PracticeGameDropItem newObj, PracticeGameDropItemId formationOrganizedAsPositiId);

	void delete(PracticeGameDropItemId formationOrganizedAsPositiId);
}
