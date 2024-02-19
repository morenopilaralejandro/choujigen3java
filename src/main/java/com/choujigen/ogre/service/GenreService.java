package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Genre;

public interface GenreService {
	List<Genre> all();

	Genre one(Long id);

	Genre insert(Genre newObj);

	Genre replace(Genre newObj, Long id);

	void delete(Long id);
}
