package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Item;
import com.choujigen.ogre.exception.ItemNotFoundException;
import com.choujigen.ogre.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> all() {
		return itemRepository.findAll();
	}

	@Override
	public Item one(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	@Override
	public Item insert(Item newObj) {
		return itemRepository.save(newObj);
	}

	@Override
	public Item replace(Item newObj, Long id) {
		return itemRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			return itemRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
}
