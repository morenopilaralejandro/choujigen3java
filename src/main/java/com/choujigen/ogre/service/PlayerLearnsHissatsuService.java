package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PlayerLearnsHissatsu;
import com.choujigen.ogre.domain.PlayerLearnsHissatsuId;

public interface PlayerLearnsHissatsuService {
	List<PlayerLearnsHissatsu> all();

	PlayerLearnsHissatsu one(PlayerLearnsHissatsuId playerLearnsHissatsuId);

	PlayerLearnsHissatsu insert(PlayerLearnsHissatsu newObj);

	PlayerLearnsHissatsu replace(PlayerLearnsHissatsu newObj, PlayerLearnsHissatsuId playerLearnsHissatsuId);

	void delete(PlayerLearnsHissatsuId playerLearnsHissatsuId);
}
