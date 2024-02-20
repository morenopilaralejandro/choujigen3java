package com.choujigen.ogre.exception;

public class HissatsuDribbleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuDribbleNotFoundException(Long id) {
		super("Could not find HissatsuDribble " + id);
	}

}
