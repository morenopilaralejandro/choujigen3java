package com.choujigen.ogre.exception;

public class HissatsuBlockNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuBlockNotFoundException(Long id) {
		super("Could not find HissatsuBlock " + id);
	}

}
