package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.exception.ItemHissatsuNotFoundException;
import com.choujigen.ogre.repository.ItemHissatsuRepository;

@Service
public class ItemHissatsuServiceImpl implements ItemHissatsuService {
	@Autowired
	private ItemHissatsuRepository itemRepository;

	@Override
	public List<ItemHissatsu> all() {
		return itemRepository.findAll();
	}

	@Override
	public ItemHissatsu one(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new ItemHissatsuNotFoundException(id));
	}

	@Override
	public ItemHissatsu insert(ItemHissatsu newObj) {
		return itemRepository.save(newObj);
	}

	@Override
	public ItemHissatsu replace(ItemHissatsu newObj, Long id) {
		return itemRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setHissatsuType(newObj.getHissatsuType());
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

	@Override
	public List<ItemHissatsu> findByItemNameJa(String itemNameJa) {
		return itemRepository.findByItemNameJa(itemNameJa);
	}
	
	@Override
	public List<ItemHissatsu> findByItemNameEn(String itemNameEn) {
		return itemRepository.findByItemNameEn(itemNameEn);
	}
	
	@Override
	public List<ItemHissatsu> findByItemNameEs(String itemNameEs) {
		return itemRepository.findByItemNameEs(itemNameEs);
	}
}
