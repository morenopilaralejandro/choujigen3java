package com.choujigen.ogre.exception;

public class PasswdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PasswdNotFoundException(Long id) {
		super("Could not find Passwd " + id);
	}

}
