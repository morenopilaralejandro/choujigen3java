package com.choujigen.ogre.exception;

public class RoutePathNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoutePathNotFoundException(Long id) {
		super("Could not find RoutePath " + id);
	}

}
