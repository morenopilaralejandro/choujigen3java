package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemRewardPlayer;
import com.choujigen.ogre.exception.ItemRewardPlayerNotFoundException;
import com.choujigen.ogre.repository.ItemRewardPlayerRepository;

@Service
public class ItemRewardPlayerServiceImpl implements ItemRewardPlayerService {
	@Autowired
	private ItemRewardPlayerRepository itemRewardPlayerRepository;

	@Override
	public List<ItemRewardPlayer> all() {
		return itemRewardPlayerRepository.findAll();
	}

	@Override
	public ItemRewardPlayer one(Long id) {
		return itemRewardPlayerRepository.findById(id).orElseThrow(() -> new ItemRewardPlayerNotFoundException(id));
	}

	@Override
	public ItemRewardPlayer insert(ItemRewardPlayer newObj) {
		return itemRewardPlayerRepository.save(newObj);
	}

	@Override
	public ItemRewardPlayer replace(ItemRewardPlayer newObj, Long id) {
		return itemRewardPlayerRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setPlayer(newObj.getPlayer());
			return itemRewardPlayerRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemRewardPlayerRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemRewardPlayerRepository.deleteById(id);
	}
}
