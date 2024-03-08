package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuCatch;
import com.choujigen.ogre.exception.HissatsuCatchNotFoundException;
import com.choujigen.ogre.repository.HissatsuCatchRepository;

@Service
public class HissatsuCatchServiceImpl implements HissatsuCatchService {
	@Autowired
	private HissatsuCatchRepository hissatsuCatchRepository;

	@Override
	public List<HissatsuCatch> all() {
		return hissatsuCatchRepository.findAll();
	}

	@Override
	public HissatsuCatch one(Long id) {
		return hissatsuCatchRepository.findById(id).orElseThrow(() -> new HissatsuCatchNotFoundException(id));
	}

	@Override
	public HissatsuCatch insert(HissatsuCatch newObj) {
		return hissatsuCatchRepository.save(newObj);
	}

	@Override
	public HissatsuCatch replace(HissatsuCatch newObj, Long id) {
		return hissatsuCatchRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setHissatsuType(newObj.getHissatsuType());
			oldObj.setHissatsuCatchPower(newObj.getHissatsuCatchPower());
			oldObj.setHissatsuCatchTp(newObj.getHissatsuCatchTp());
			oldObj.setHissatsuCatchParticipants(newObj.getHissatsuCatchParticipants());
			oldObj.setCatchType(newObj.getCatchType());
			return hissatsuCatchRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return hissatsuCatchRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		hissatsuCatchRepository.deleteById(id);
	}
}
