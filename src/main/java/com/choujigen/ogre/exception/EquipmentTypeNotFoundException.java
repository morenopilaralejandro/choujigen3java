package com.choujigen.ogre.exception;

public class EquipmentTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EquipmentTypeNotFoundException(Long id) {
		super("Could not find EquipmentType " + id);
	}

}
