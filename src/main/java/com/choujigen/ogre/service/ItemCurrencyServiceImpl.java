package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemCurrency;
import com.choujigen.ogre.exception.ItemCurrencyNotFoundException;
import com.choujigen.ogre.repository.ItemCurrencyRepository;

@Service
public class ItemCurrencyServiceImpl implements ItemCurrencyService {
	@Autowired
	private ItemCurrencyRepository itemCurrencyRepository;

	@Override
	public List<ItemCurrency> all() {
		return itemCurrencyRepository.findAll();
	}

	@Override
	public ItemCurrency one(Long id) {
		return itemCurrencyRepository.findById(id).orElseThrow(() -> new ItemCurrencyNotFoundException(id));
	}

	@Override
	public ItemCurrency insert(ItemCurrency newObj) {
		return itemCurrencyRepository.save(newObj);
	}

	@Override
	public ItemCurrency replace(ItemCurrency newObj, Long id) {
		return itemCurrencyRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setItemCurrencyCarryLimit(newObj.getItemCurrencyCarryLimit());
			return itemCurrencyRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemCurrencyRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemCurrencyRepository.deleteById(id);
	}
}
