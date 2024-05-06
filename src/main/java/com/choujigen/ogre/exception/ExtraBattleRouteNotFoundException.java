package com.choujigen.ogre.exception;

public class ExtraBattleRouteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExtraBattleRouteNotFoundException(Long id) {
		super("Could not find ExtraBattleRoute " + id);
	}

}
