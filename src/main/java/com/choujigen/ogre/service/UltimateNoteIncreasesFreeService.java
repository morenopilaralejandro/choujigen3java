package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.UltimateNoteIncreasesFree;
import com.choujigen.ogre.domain.UltimateNoteIncreasesFreeId;

public interface UltimateNoteIncreasesFreeService {
	List<UltimateNoteIncreasesFree> all();

	UltimateNoteIncreasesFree one(UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId);

	UltimateNoteIncreasesFree insert(UltimateNoteIncreasesFree newObj);

	UltimateNoteIncreasesFree replace(UltimateNoteIncreasesFree newObj, UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId);

	void delete(UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId);
}
