package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PlayerIsPartOfTeam;
import com.choujigen.ogre.domain.PlayerIsPartOfTeamId;
import com.choujigen.ogre.exception.PlayerIsPartOfTeamNotFoundException;
import com.choujigen.ogre.repository.PlayerIsPartOfTeamRepository;

@Service
public class PlayerIsPartOfTeamServiceImpl implements PlayerIsPartOfTeamService {
	@Autowired
	private PlayerIsPartOfTeamRepository playerIsPartOfTeamRepository;

	@Override
	public List<PlayerIsPartOfTeam> all() {
		return playerIsPartOfTeamRepository.findAll();
	}

	@Override
	public PlayerIsPartOfTeam one(PlayerIsPartOfTeamId playerIsPartOfTeamId) {
		return playerIsPartOfTeamRepository.findById(playerIsPartOfTeamId)
				.orElseThrow(() -> new PlayerIsPartOfTeamNotFoundException(playerIsPartOfTeamId));
	}

	@Override
	public PlayerIsPartOfTeam insert(PlayerIsPartOfTeam newObj) {
		return playerIsPartOfTeamRepository.save(newObj);
	}

	@Override
	public PlayerIsPartOfTeam replace(PlayerIsPartOfTeam newObj, PlayerIsPartOfTeamId playerIsPartOfTeamId) {
		return playerIsPartOfTeamRepository.findById(playerIsPartOfTeamId).map(oldObj -> {
			oldObj.setPlace(newObj.getPlace());
			return playerIsPartOfTeamRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(playerIsPartOfTeamId);
			return playerIsPartOfTeamRepository.save(newObj);
		});
	}

	@Override
	public void delete(PlayerIsPartOfTeamId playerIsPartOfTeamId) {
		playerIsPartOfTeamRepository.deleteById(playerIsPartOfTeamId);
	}

}
