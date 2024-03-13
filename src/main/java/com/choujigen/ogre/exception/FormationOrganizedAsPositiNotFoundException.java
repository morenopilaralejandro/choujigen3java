package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.FormationOrganizedAsPositiId;

public class FormationOrganizedAsPositiNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormationOrganizedAsPositiNotFoundException(FormationOrganizedAsPositiId formationOrganizedAsPositiId) {
		super("Could not find FormationOrganizedAsPositi composite key(itemFormationId, positiId) ("
				+ formationOrganizedAsPositiId.getItemFormationId() + ", " + formationOrganizedAsPositiId.getPositiId()
				+ ")");
	}

}
