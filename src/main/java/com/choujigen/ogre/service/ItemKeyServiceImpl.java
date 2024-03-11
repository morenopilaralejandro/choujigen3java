package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemKey;
import com.choujigen.ogre.exception.ItemKeyNotFoundException;
import com.choujigen.ogre.repository.ItemKeyRepository;

@Service
public class ItemKeyServiceImpl implements ItemKeyService {
	@Autowired
	private ItemKeyRepository itemKeyRepository;

	@Override
	public List<ItemKey> all() {
		return itemKeyRepository.findAll();
	}

	@Override
	public ItemKey one(Long id) {
		return itemKeyRepository.findById(id).orElseThrow(() -> new ItemKeyNotFoundException(id));
	}

	@Override
	public ItemKey insert(ItemKey newObj) {
		return itemKeyRepository.save(newObj);
	}

	@Override
	public ItemKey replace(ItemKey newObj, Long id) {
		return itemKeyRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setZone(newObj.getZone());
			return itemKeyRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemKeyRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemKeyRepository.deleteById(id);
	}
}
