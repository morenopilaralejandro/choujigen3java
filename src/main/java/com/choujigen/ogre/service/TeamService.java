package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Team;

public interface TeamService {
	List<Team> all();

	Team one(Long id);

	Team insert(Team newObj);

	Team replace(Team newObj, Long id);

	void delete(Long id);
}
