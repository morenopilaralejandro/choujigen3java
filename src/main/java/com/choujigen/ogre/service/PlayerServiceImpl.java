package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.exception.PlayerNotFoundException;
import com.choujigen.ogre.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<Player> all() {
		return playerRepository.findAll();
	}
	
	@Override
	public List<Player> findByPlayerIdBetween(Long startId, Long endId) {
		return playerRepository.findByPlayerIdBetween(startId, endId);
	}
	@Override
	public List<Player> findByInitialEn(String initial) {
		return playerRepository.findByInitialEn(initial);
	}

	@Override
	public Player one(Long id) {
		return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
	}

	@Override
	public Player insert(Player newObj) {
		return playerRepository.save(newObj);
	}

	@Override
	public Player replace(Player newObj, Long id) {
		return playerRepository.findById(id).map(oldObj -> {
			oldObj.setPlayerNameJa(newObj.getPlayerNameJa());
			oldObj.setPlayerNameHiragana(newObj.getPlayerNameHiragana());
			oldObj.setPlayerNameKanji(newObj.getPlayerNameKanji());
			oldObj.setPlayerNameRomanji(newObj.getPlayerNameRomanji());
			oldObj.setPlayerNameEn(newObj.getPlayerNameEn());
			oldObj.setPlayerNameEnFull(newObj.getPlayerNameEnFull());
			oldObj.setPlayerInitialLv(newObj.getPlayerInitialLv());
			oldObj.setPlayerGp99(newObj.getPlayerGp99());
			oldObj.setPlayerTp99(newObj.getPlayerTp99());
			oldObj.setPlayerKick99(newObj.getPlayerKick99());
			oldObj.setPlayerBody99(newObj.getPlayerBody99());
			oldObj.setPlayerControl99(newObj.getPlayerControl99());
			oldObj.setPlayerGuard99(newObj.getPlayerGuard99());
			oldObj.setPlayerSpeed99(newObj.getPlayerSpeed99());
			oldObj.setPlayerStamina99(newObj.getPlayerStamina99());
			oldObj.setPlayerGuts99(newObj.getPlayerGuts99());
			oldObj.setPlayerFreedom99(newObj.getPlayerFreedom99());
			oldObj.updatePlayerStats();
			oldObj.setAttri(newObj.getAttri());
			oldObj.setPositi(newObj.getPositi());
			oldObj.setGender(newObj.getGender());
			oldObj.setBodyType(newObj.getBodyType());
			oldObj.setPlayerObtentionMethod(newObj.getPlayerObtentionMethod());
			oldObj.setOriginalVersion(newObj.getOriginalVersion());
			return playerRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPlayerId(id);
			newObj.updatePlayerStats();
			return playerRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		playerRepository.deleteById(id);
	}
}
