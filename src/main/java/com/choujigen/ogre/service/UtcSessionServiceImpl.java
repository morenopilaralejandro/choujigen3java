package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.UtcSession;
import com.choujigen.ogre.exception.UtcSessionNotFoundException;
import com.choujigen.ogre.repository.UtcSessionRepository;

@Service
public class UtcSessionServiceImpl implements UtcSessionService {
	@Autowired
	private UtcSessionRepository utcSessionRepository;

	@Override
	public List<UtcSession> all() {
		return utcSessionRepository.findAll();
	}

	@Override
	public UtcSession one(Long id) {
		return utcSessionRepository.findById(id).orElseThrow(() -> new UtcSessionNotFoundException(id));
	}

	@Override
	public UtcSession insert(UtcSession newObj) {
		return utcSessionRepository.save(newObj);
	}

	@Override
	public UtcSession replace(UtcSession newObj, Long id) {
		return utcSessionRepository.findById(id).map(oldObj -> {
			oldObj.setUtcSessionNameJa(newObj.getUtcSessionNameJa());
			oldObj.setUtcSessionNameEn(newObj.getUtcSessionNameEn());
			oldObj.setUtcSessionNameEs(newObj.getUtcSessionNameEs());
			return utcSessionRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setUtcSessionId(id);
			return utcSessionRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		utcSessionRepository.deleteById(id);
	}
}
