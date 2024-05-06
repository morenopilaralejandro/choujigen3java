package com.choujigen.ogre.exception;

public class PracticeGameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PracticeGameNotFoundException(Long id) {
		super("Could not find PracticeGame " + id);
	}

}
