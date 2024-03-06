package com.choujigen.ogre.exception;

public class ItemTacticNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemTacticNotFoundException(Long id) {
		super("Could not find ItemTactic " + id);
	}

}
