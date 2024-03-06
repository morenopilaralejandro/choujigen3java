package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemFormation;
import com.choujigen.ogre.exception.ItemFormationNotFoundException;
import com.choujigen.ogre.repository.ItemFormationRepository;

@Service
public class ItemFormationServiceImpl implements ItemFormationService {
	@Autowired
	private ItemFormationRepository itemFormationRepository;

	@Override
	public List<ItemFormation> all() {
		return itemFormationRepository.findAll();
	}

	@Override
	public ItemFormation one(Long id) {
		return itemFormationRepository.findById(id).orElseThrow(() -> new ItemFormationNotFoundException(id));
	}

	@Override
	public ItemFormation insert(ItemFormation newObj) {
		return itemFormationRepository.save(newObj);
	}

	@Override
	public ItemFormation replace(ItemFormation newObj, Long id) {
		return itemFormationRepository.findById(id).map(oldObj -> {
			oldObj.setFormationType(newObj.getFormationType());
			oldObj.setFormationScheme(newObj.getFormationScheme());
			oldObj.setOriginalVersion(newObj.getOriginalVersion());
			return itemFormationRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemFormationRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemFormationRepository.deleteById(id);
	}
}
