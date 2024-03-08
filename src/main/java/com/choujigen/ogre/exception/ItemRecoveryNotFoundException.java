package com.choujigen.ogre.exception;

public class ItemRecoveryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemRecoveryNotFoundException(Long id) {
		super("Could not find ItemRecovery " + id);
	}

}
