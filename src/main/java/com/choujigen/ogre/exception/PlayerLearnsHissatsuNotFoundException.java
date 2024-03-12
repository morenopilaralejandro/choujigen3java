package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.PlayerLearnsHissatsuId;

public class PlayerLearnsHissatsuNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerLearnsHissatsuNotFoundException(PlayerLearnsHissatsuId playerLearnsHissatsuId) {
		super("Could not find PlayerLearnsHissatsu composite key(playerId, itemHissatsuId) ("
				+ playerLearnsHissatsuId.getPlayerId() + ", " + playerLearnsHissatsuId.getItemHissatsuId() + ")");
	}

}
