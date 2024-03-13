package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.FormationOrganizedAsPositi;
import com.choujigen.ogre.domain.FormationOrganizedAsPositiId;

public interface FormationOrganizedAsPositiService {
	List<FormationOrganizedAsPositi> all();

	FormationOrganizedAsPositi one(FormationOrganizedAsPositiId formationOrganizedAsPositiId);

	FormationOrganizedAsPositi insert(FormationOrganizedAsPositi newObj);

	FormationOrganizedAsPositi replace(FormationOrganizedAsPositi newObj,
			FormationOrganizedAsPositiId formationOrganizedAsPositiId);

	void delete(FormationOrganizedAsPositiId formationOrganizedAsPositiId);
}
