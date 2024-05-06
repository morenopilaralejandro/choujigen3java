package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemVscard;
import com.choujigen.ogre.exception.ItemVscardNotFoundException;
import com.choujigen.ogre.repository.ItemVscardRepository;

@Service
public class ItemVscardServiceImpl implements ItemVscardService {
	@Autowired
	private ItemVscardRepository itemVscardRepository;

	@Override
	public List<ItemVscard> all() {
		return itemVscardRepository.findAll();
	}

	@Override
	public ItemVscard one(Long id) {
		return itemVscardRepository.findById(id).orElseThrow(() -> new ItemVscardNotFoundException(id));
	}

	@Override
	public ItemVscard insert(ItemVscard newObj) {
		return itemVscardRepository.save(newObj);
	}

	@Override
	public ItemVscard replace(ItemVscard newObj, Long id) {
		return itemVscardRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setPracticeGame(newObj.getPracticeGame());
			return itemVscardRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemVscardRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemVscardRepository.deleteById(id);
	}
}
