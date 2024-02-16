package com.choujigen.ogre.exception;

public class ShootSpecialPropertyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShootSpecialPropertyNotFoundException(Long id) {
		super("Could not find ShootSpecialProperty " + id);
	}

}
