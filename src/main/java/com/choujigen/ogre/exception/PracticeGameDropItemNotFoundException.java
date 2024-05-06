package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.PracticeGameDropItemId;

public class PracticeGameDropItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PracticeGameDropItemNotFoundException(PracticeGameDropItemId practiceGameDropItemId) {
		super("Could not find PracticeGameDropItem composite key(practiceGameId, itemId) ("
				+ practiceGameDropItemId.getPracticeGameId() + ", " + practiceGameDropItemId.getItemId() + ")");
	}

}
