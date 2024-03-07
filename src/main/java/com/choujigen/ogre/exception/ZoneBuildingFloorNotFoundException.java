package com.choujigen.ogre.exception;

public class ZoneBuildingFloorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneBuildingFloorNotFoundException(Long id) {
		super("Could not find ZoneBuildingFloor " + id);
	}

}
