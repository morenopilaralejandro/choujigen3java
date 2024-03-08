package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemEquipment;
import com.choujigen.ogre.exception.ItemEquipmentNotFoundException;
import com.choujigen.ogre.repository.ItemEquipmentRepository;

@Service
public class ItemEquipmentServiceImpl implements ItemEquipmentService {
	@Autowired
	private ItemEquipmentRepository itemEquipmentRepository;

	@Override
	public List<ItemEquipment> all() {
		return itemEquipmentRepository.findAll();
	}

	@Override
	public ItemEquipment one(Long id) {
		return itemEquipmentRepository.findById(id).orElseThrow(() -> new ItemEquipmentNotFoundException(id));
	}

	@Override
	public ItemEquipment insert(ItemEquipment newObj) {
		return itemEquipmentRepository.save(newObj);
	}

	@Override
	public ItemEquipment replace(ItemEquipment newObj, Long id) {
		return itemEquipmentRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setEquipmentType(newObj.getEquipmentType());
			return itemEquipmentRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemEquipmentRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemEquipmentRepository.deleteById(id);
	}
}
