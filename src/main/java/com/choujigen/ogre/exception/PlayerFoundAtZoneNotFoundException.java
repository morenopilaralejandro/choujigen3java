package com.choujigen.ogre.exception;

public class PlayerFoundAtZoneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerFoundAtZoneNotFoundException(Long id) {
		super("Could not find PlayerFoundAtZone " + id);
	}

}
