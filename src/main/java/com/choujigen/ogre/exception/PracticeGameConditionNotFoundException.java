package com.choujigen.ogre.exception;

public class PracticeGameConditionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PracticeGameConditionNotFoundException(Long id) {
		super("Could not find PracticeGameCondition " + id);
	}

}
