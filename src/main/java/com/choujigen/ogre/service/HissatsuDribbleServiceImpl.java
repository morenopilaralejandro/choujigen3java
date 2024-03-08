package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuDribble;
import com.choujigen.ogre.exception.HissatsuDribbleNotFoundException;
import com.choujigen.ogre.repository.HissatsuDribbleRepository;

@Service
public class HissatsuDribbleServiceImpl implements HissatsuDribbleService {
	@Autowired
	private HissatsuDribbleRepository hissatsuDribbleRepository;

	@Override
	public List<HissatsuDribble> all() {
		return hissatsuDribbleRepository.findAll();
	}

	@Override
	public HissatsuDribble one(Long id) {
		return hissatsuDribbleRepository.findById(id).orElseThrow(() -> new HissatsuDribbleNotFoundException(id));
	}

	@Override
	public HissatsuDribble insert(HissatsuDribble newObj) {
		return hissatsuDribbleRepository.save(newObj);
	}

	@Override
	public HissatsuDribble replace(HissatsuDribble newObj, Long id) {
		return hissatsuDribbleRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setHissatsuType(newObj.getHissatsuType());
			oldObj.setHissatsuDribblePower(newObj.getHissatsuDribblePower());
			oldObj.setHissatsuDribbleTp(newObj.getHissatsuDribbleTp());
			oldObj.setHissatsuDribbleParticipants(newObj.getHissatsuDribbleParticipants());
			oldObj.setHissatsuDribbleFoul(newObj.getHissatsuDribbleFoul());
			return hissatsuDribbleRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return hissatsuDribbleRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		hissatsuDribbleRepository.deleteById(id);
	}
}
