package com.choujigen.ogre.exception;

public class ItemCurrencyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemCurrencyNotFoundException(Long id) {
		super("Could not find ItemCurrency " + id);
	}

}
