package com.choujigen.ogre.exception;

public class PlayerObtentionMethodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerObtentionMethodNotFoundException(Long id) {
		super("Could not find PlayerObtentionMethod " + id);
	}

}
