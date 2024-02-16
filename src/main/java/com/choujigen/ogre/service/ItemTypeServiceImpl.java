package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemType;
import com.choujigen.ogre.exception.ItemTypeNotFoundException;
import com.choujigen.ogre.repository.ItemTypeRepository;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {
	@Autowired
	private ItemTypeRepository itemTypeRepository;

	@Override
	public List<ItemType> all() {
		return itemTypeRepository.findAll();
	}

	@Override
	public ItemType one(Long id) {
		return itemTypeRepository.findById(id).orElseThrow(() -> new ItemTypeNotFoundException(id));
	}

	@Override
	public ItemType insert(ItemType newObj) {
		return itemTypeRepository.save(newObj);
	}

	@Override
	public ItemType replace(ItemType newObj, Long id) {
		return itemTypeRepository.findById(id).map(oldObj -> {
			oldObj.setItemTypeNameJa(newObj.getItemTypeNameJa());
			oldObj.setItemTypeNameEn(newObj.getItemTypeNameEn());
			oldObj.setItemTypeNameEs(newObj.getItemTypeNameEs());
			return itemTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemTypeId(id);
			return itemTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemTypeRepository.deleteById(id);
	}
}
