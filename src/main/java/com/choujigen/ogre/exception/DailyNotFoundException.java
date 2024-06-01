package com.choujigen.ogre.exception;

public class DailyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DailyNotFoundException(Long id) {
		super("Could not find Daily " + id);
	}

}
