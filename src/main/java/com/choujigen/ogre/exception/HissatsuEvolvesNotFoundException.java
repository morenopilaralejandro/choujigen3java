package com.choujigen.ogre.exception;

public class HissatsuEvolvesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuEvolvesNotFoundException(Long itemHissatsuId, Long growthTypeId, Long growthRateId) {
		super("Could not find HissatsuEvolves composite key(itemHissatsuId, growthTypeId, growthRateId) (" + itemHissatsuId + ", " + growthTypeId + ", " + growthRateId + ")");
	}

}
