package com.choujigen.ogre.exception;

public class ItemHissatsuNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemHissatsuNotFoundException(Long id) {
		super("Could not find ItemHissatsu " + id);
	}

}
