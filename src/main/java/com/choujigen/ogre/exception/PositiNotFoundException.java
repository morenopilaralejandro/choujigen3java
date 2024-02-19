package com.choujigen.ogre.exception;

public class PositiNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PositiNotFoundException(Long id) {
		super("Could not find Positi " + id);
	}

}
