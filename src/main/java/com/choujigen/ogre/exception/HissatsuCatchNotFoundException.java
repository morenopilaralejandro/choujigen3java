package com.choujigen.ogre.exception;

public class HissatsuCatchNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuCatchNotFoundException(Long id) {
		super("Could not find HissatsuCatch " + id);
	}

}
