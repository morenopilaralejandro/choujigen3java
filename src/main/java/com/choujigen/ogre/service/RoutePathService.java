package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.RoutePath;

public interface RoutePathService {
	List<RoutePath> all();

	RoutePath one(Long id);

	RoutePath insert(RoutePath newObj);

	RoutePath replace(RoutePath newObj, Long id);

	void delete(Long id);
}
