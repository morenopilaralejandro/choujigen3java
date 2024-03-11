package com.choujigen.ogre.exception;

public class ItemUltimateNoteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemUltimateNoteNotFoundException(Long id) {
		super("Could not find ItemUltimateNote " + id);
	}

}
