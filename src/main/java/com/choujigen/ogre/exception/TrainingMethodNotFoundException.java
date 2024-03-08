package com.choujigen.ogre.exception;

public class TrainingMethodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TrainingMethodNotFoundException(Long id) {
		super("Could not find TrainingMethod " + id);
	}

}
