package com.choujigen.ogre.exception;

public class RegionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegionNotFoundException(Long id) {
		super("Could not find Region " + id);
	}

}
