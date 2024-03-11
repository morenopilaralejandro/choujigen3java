package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemUltimateNote;
import com.choujigen.ogre.exception.ItemUltimateNoteNotFoundException;
import com.choujigen.ogre.repository.ItemUltimateNoteRepository;

@Service
public class ItemUltimateNoteServiceImpl implements ItemUltimateNoteService {
	@Autowired
	private ItemUltimateNoteRepository itemUltimateNoteRepository;

	@Override
	public List<ItemUltimateNote> all() {
		return itemUltimateNoteRepository.findAll();
	}

	@Override
	public ItemUltimateNote one(Long id) {
		return itemUltimateNoteRepository.findById(id).orElseThrow(() -> new ItemUltimateNoteNotFoundException(id));
	}

	@Override
	public ItemUltimateNote insert(ItemUltimateNote newObj) {
		return itemUltimateNoteRepository.save(newObj);
	}

	@Override
	public ItemUltimateNote replace(ItemUltimateNote newObj, Long id) {
		return itemUltimateNoteRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setItemUltimateNoteOrder(newObj.getItemUltimateNoteOrder());
			return itemUltimateNoteRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemUltimateNoteRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemUltimateNoteRepository.deleteById(id);
	}
}
