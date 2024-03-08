package com.choujigen.ogre.exception;

public class ItemEquipmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemEquipmentNotFoundException(Long id) {
		super("Could not find ItemEquipment " + id);
	}

}
