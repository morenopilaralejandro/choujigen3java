package com.choujigen.ogre.exception;

public class TacticSideNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TacticSideNotFoundException(Long id) {
		super("Could not find TacticSide " + id);
	}

}
