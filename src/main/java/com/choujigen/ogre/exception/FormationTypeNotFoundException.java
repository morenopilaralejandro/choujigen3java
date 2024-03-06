package com.choujigen.ogre.exception;

public class FormationTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormationTypeNotFoundException(Long id) {
		super("Could not find FormationType " + id);
	}

}
