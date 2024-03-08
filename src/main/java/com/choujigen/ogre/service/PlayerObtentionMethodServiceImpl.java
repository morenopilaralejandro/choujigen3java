package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PlayerObtentionMethod;
import com.choujigen.ogre.exception.PlayerObtentionMethodNotFoundException;
import com.choujigen.ogre.repository.PlayerObtentionMethodRepository;

@Service
public class PlayerObtentionMethodServiceImpl implements PlayerObtentionMethodService {
	@Autowired
	private PlayerObtentionMethodRepository playerObtentionMethodRepository;

	@Override
	public List<PlayerObtentionMethod> all() {
		return playerObtentionMethodRepository.findAll();
	}

	@Override
	public PlayerObtentionMethod one(Long id) {
		return playerObtentionMethodRepository.findById(id).orElseThrow(() -> new PlayerObtentionMethodNotFoundException(id));
	}

	@Override
	public PlayerObtentionMethod insert(PlayerObtentionMethod newObj) {
		return playerObtentionMethodRepository.save(newObj);
	}

	@Override
	public PlayerObtentionMethod replace(PlayerObtentionMethod newObj, Long id) {
		return playerObtentionMethodRepository.findById(id).map(oldObj -> {
			oldObj.setPlayerObtentionMethodDescJa(newObj.getPlayerObtentionMethodDescJa());
			oldObj.setPlayerObtentionMethodDescEn(newObj.getPlayerObtentionMethodDescEn());
			oldObj.setPlayerObtentionMethodDescEs(newObj.getPlayerObtentionMethodDescEs());
			return playerObtentionMethodRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPlayerObtentionMethodId(id);
			return playerObtentionMethodRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		playerObtentionMethodRepository.deleteById(id);
	}
}
