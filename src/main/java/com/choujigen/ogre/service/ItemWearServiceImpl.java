package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemWear;
import com.choujigen.ogre.exception.ItemWearNotFoundException;
import com.choujigen.ogre.repository.ItemWearRepository;

@Service
public class ItemWearServiceImpl implements ItemWearService {
	@Autowired
	private ItemWearRepository itemWearRepository;

	@Override
	public List<ItemWear> all() {
		return itemWearRepository.findAll();
	}

	@Override
	public ItemWear one(Long id) {
		return itemWearRepository.findById(id).orElseThrow(() -> new ItemWearNotFoundException(id));
	}

	@Override
	public ItemWear insert(ItemWear newObj) {
		return itemWearRepository.save(newObj);
	}

	@Override
	public ItemWear replace(ItemWear newObj, Long id) {
		return itemWearRepository.findById(id).map(oldObj -> {
			oldObj.setItemWearHex(newObj.getItemWearHex());
			return itemWearRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemWearRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemWearRepository.deleteById(id);
	}
}
