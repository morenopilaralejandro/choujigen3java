package com.choujigen.ogre.exception;

public class GenreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenreNotFoundException(Long id) {
		super("Could not find Genre " + id);
	}

}
