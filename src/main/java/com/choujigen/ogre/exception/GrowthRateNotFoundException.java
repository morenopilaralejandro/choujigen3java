package com.choujigen.ogre.exception;

public class GrowthRateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GrowthRateNotFoundException(Long id) {
		super("Could not find GrowthRate " + id);
	}

}
