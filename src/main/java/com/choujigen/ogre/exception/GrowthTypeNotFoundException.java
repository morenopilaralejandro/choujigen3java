package com.choujigen.ogre.exception;

public class GrowthTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GrowthTypeNotFoundException(Long id) {
		super("Could not find GrowthType " + id);
	}

}
