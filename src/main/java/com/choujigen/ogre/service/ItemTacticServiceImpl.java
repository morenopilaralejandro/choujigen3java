package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ItemTactic;
import com.choujigen.ogre.exception.ItemTacticNotFoundException;
import com.choujigen.ogre.repository.ItemTacticRepository;

@Service
public class ItemTacticServiceImpl implements ItemTacticService {
	@Autowired
	private ItemTacticRepository itemTacticRepository;

	@Override
	public List<ItemTactic> all() {
		return itemTacticRepository.findAll();
	}

	@Override
	public ItemTactic one(Long id) {
		return itemTacticRepository.findById(id).orElseThrow(() -> new ItemTacticNotFoundException(id));
	}

	@Override
	public ItemTactic insert(ItemTactic newObj) {
		return itemTacticRepository.save(newObj);
	}

	@Override
	public ItemTactic replace(ItemTactic newObj, Long id) {
		return itemTacticRepository.findById(id).map(oldObj -> {
			oldObj.setItemTacticTtp(newObj.getItemTacticTtp());
			oldObj.setItemTacticEffectJa(newObj.getItemTacticEffectJa());
			oldObj.setItemTacticEffectEn(newObj.getItemTacticEffectEn());
			oldObj.setItemTacticEffectEs(newObj.getItemTacticEffectEs());
			oldObj.setTacticType(newObj.getTacticType());
			oldObj.setTacticSide(newObj.getTacticSide());
			return itemTacticRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return itemTacticRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		itemTacticRepository.deleteById(id);
	}
}
