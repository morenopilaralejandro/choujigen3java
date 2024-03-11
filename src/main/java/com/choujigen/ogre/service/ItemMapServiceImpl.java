package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemMap;
import com.choujigen.ogre.exception.ItemMapNotFoundException;
import com.choujigen.ogre.repository.ItemMapRepository;

@Service
public class ItemMapServiceImpl implements ItemMapService {
	@Autowired
	private ItemMapRepository itemMapRepository;

	@Override
	public List<ItemMap> all() {
		return itemMapRepository.findAll();
	}

	@Override
	public ItemMap one(Long id) {
		return itemMapRepository.findById(id).orElseThrow(() -> new ItemMapNotFoundException(id));
	}

	@Override
	public ItemMap insert(ItemMap newObj) {
		return itemMapRepository.save(newObj);
	}

	@Override
	public ItemMap replace(ItemMap newObj, Long id) {
		return itemMapRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setZone(newObj.getZone());
			return itemMapRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemMapRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemMapRepository.deleteById(id);
	}
}
