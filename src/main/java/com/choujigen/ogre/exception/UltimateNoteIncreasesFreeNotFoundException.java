package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.UltimateNoteIncreasesFreeId;

public class UltimateNoteIncreasesFreeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UltimateNoteIncreasesFreeNotFoundException(UltimateNoteIncreasesFreeId ultimateNoteIncreasesFreeId) {
		super("Could not find EquipmentStrengthensStat composite key(itemUltimateNoteId, positiId, attriId) ("
				+ ultimateNoteIncreasesFreeId.getItemUltimateNoteId() + ", " + ultimateNoteIncreasesFreeId.getPositiId()
				+ ", " + ultimateNoteIncreasesFreeId.getAttriId() + ")");
	}

}
