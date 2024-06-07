package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.UtcSession;

public interface UtcSessionService {
	List<UtcSession> all();

	UtcSession one(Long id);

	UtcSession insert(UtcSession newObj);

	UtcSession replace(UtcSession newObj, Long id);

	void delete(Long id);
}
