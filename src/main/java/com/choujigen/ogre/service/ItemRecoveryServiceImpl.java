package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemRecovery;
import com.choujigen.ogre.exception.ItemRecoveryNotFoundException;
import com.choujigen.ogre.repository.ItemRecoveryRepository;

@Service
public class ItemRecoveryServiceImpl implements ItemRecoveryService {
	@Autowired
	private ItemRecoveryRepository itemRecoveryRepository;

	@Override
	public List<ItemRecovery> all() {
		return itemRecoveryRepository.findAll();
	}

	@Override
	public ItemRecovery one(Long id) {
		return itemRecoveryRepository.findById(id).orElseThrow(() -> new ItemRecoveryNotFoundException(id));
	}

	@Override
	public ItemRecovery insert(ItemRecovery newObj) {
		return itemRecoveryRepository.save(newObj);
	}

	@Override
	public ItemRecovery replace(ItemRecovery newObj, Long id) {
		return itemRecoveryRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setItemRecoveryGp(newObj.getItemRecoveryGp());
			oldObj.setItemRecoveryTp(newObj.getItemRecoveryTp());
			return itemRecoveryRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemRecoveryRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemRecoveryRepository.deleteById(id);
	}
}
