package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemRecovery;

public interface ItemRecoveryService {
	List<ItemRecovery> all();

	ItemRecovery one(Long id);

	ItemRecovery insert(ItemRecovery newObj);

	ItemRecovery replace(ItemRecovery newObj, Long id);

	void delete(Long id);
}
