package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemRewardPlayer;

public interface ItemRewardPlayerService {
	List<ItemRewardPlayer> all();

	ItemRewardPlayer one(Long id);

	ItemRewardPlayer insert(ItemRewardPlayer newObj);

	ItemRewardPlayer replace(ItemRewardPlayer newObj, Long id);

	void delete(Long id);
}
