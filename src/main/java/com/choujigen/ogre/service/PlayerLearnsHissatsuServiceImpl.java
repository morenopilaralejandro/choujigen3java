package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PlayerLearnsHissatsu;
import com.choujigen.ogre.domain.PlayerLearnsHissatsuId;
import com.choujigen.ogre.exception.PlayerLearnsHissatsuNotFoundException;
import com.choujigen.ogre.repository.PlayerLearnsHissatsuRepository;

@Service
public class PlayerLearnsHissatsuServiceImpl implements PlayerLearnsHissatsuService {
	@Autowired
	private PlayerLearnsHissatsuRepository playerLearnsHissatsuRepository;

	@Override
	public List<PlayerLearnsHissatsu> all() {
		return playerLearnsHissatsuRepository.findAll();
	}

	@Override
	public PlayerLearnsHissatsu one(PlayerLearnsHissatsuId playerLearnsHissatsuId) {
		return playerLearnsHissatsuRepository.findById(playerLearnsHissatsuId)
				.orElseThrow(() -> new PlayerLearnsHissatsuNotFoundException(playerLearnsHissatsuId));
	}

	@Override
	public PlayerLearnsHissatsu insert(PlayerLearnsHissatsu newObj) {
		return playerLearnsHissatsuRepository.save(newObj);
	}

	@Override
	public PlayerLearnsHissatsu replace(PlayerLearnsHissatsu newObj, PlayerLearnsHissatsuId playerLearnsHissatsuId) {
		return playerLearnsHissatsuRepository.findById(playerLearnsHissatsuId).map(oldObj -> {
			oldObj.setLearnLv(newObj.getLearnLv());
			oldObj.setLearnOrder(newObj.getLearnOrder());
			return playerLearnsHissatsuRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(playerLearnsHissatsuId);
			return playerLearnsHissatsuRepository.save(newObj);
		});
	}

	@Override
	public void delete(PlayerLearnsHissatsuId playerLearnsHissatsuId) {
		playerLearnsHissatsuRepository.deleteById(playerLearnsHissatsuId);
	}

}
