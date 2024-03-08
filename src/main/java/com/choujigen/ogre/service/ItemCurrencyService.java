package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemCurrency;

public interface ItemCurrencyService {
	List<ItemCurrency> all();

	ItemCurrency one(Long id);

	ItemCurrency insert(ItemCurrency newObj);

	ItemCurrency replace(ItemCurrency newObj, Long id);

	void delete(Long id);
}
