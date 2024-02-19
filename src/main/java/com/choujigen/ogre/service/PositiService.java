package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Positi;

public interface PositiService {
	List<Positi> all();

	Positi one(Long id);

	Positi insert(Positi newObj);

	Positi replace(Positi newObj, Long id);

	void delete(Long id);
}
