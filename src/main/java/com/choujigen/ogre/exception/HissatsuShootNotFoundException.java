package com.choujigen.ogre.exception;

public class HissatsuShootNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuShootNotFoundException(Long id) {
		super("Could not find HissatsuShoot " + id);
	}

}
