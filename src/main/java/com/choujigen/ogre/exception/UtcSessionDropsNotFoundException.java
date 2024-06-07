package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.UtcSessionDropsId;

public class UtcSessionDropsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UtcSessionDropsNotFoundException(UtcSessionDropsId utcSessionDropsId) {
		super("Could not find UtcSessionDrops composite key(utcSessionId, itemId) ("
				+ utcSessionDropsId.getUtcSessionId() + ", " + utcSessionDropsId.getItemId() + ")");
	}

}
