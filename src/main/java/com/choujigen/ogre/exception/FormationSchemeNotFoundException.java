package com.choujigen.ogre.exception;

public class FormationSchemeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormationSchemeNotFoundException(Long id) {
		super("Could not find FormationScheme " + id);
	}

}
