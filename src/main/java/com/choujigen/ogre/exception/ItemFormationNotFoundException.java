package com.choujigen.ogre.exception;

public class ItemFormationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemFormationNotFoundException(Long id) {
		super("Could not find ItemFormation " + id);
	}

}
