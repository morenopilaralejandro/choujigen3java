package com.choujigen.ogre.exception;

public class HissatsuTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuTypeNotFoundException(Long id) {
		super("Could not find HissatsuType " + id);
	}

}
