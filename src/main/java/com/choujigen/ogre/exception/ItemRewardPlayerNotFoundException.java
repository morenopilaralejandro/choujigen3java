package com.choujigen.ogre.exception;

public class ItemRewardPlayerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemRewardPlayerNotFoundException(Long id) {
		super("Could not find ItemRewardPlayer " + id);
	}

}
