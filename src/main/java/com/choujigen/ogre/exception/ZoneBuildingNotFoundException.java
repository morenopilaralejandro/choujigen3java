package com.choujigen.ogre.exception;

public class ZoneBuildingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneBuildingNotFoundException(Long id) {
		super("Could not find ZoneBuilding " + id);
	}

}
