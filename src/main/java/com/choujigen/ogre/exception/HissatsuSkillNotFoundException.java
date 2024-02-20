package com.choujigen.ogre.exception;

public class HissatsuSkillNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HissatsuSkillNotFoundException(Long id) {
		super("Could not find HissatsuSkill " + id);
	}

}
