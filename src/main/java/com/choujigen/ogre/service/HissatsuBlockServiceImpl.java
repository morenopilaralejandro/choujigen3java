package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuBlock;
import com.choujigen.ogre.exception.HissatsuBlockNotFoundException;
import com.choujigen.ogre.repository.HissatsuBlockRepository;

@Service
public class HissatsuBlockServiceImpl implements HissatsuBlockService {
	@Autowired
	private HissatsuBlockRepository hissatsuBlockRepository;

	@Override
	public List<HissatsuBlock> all() {
		return hissatsuBlockRepository.findAll();
	}

	@Override
	public HissatsuBlock one(Long id) {
		return hissatsuBlockRepository.findById(id).orElseThrow(() -> new HissatsuBlockNotFoundException(id));
	}

	@Override
	public HissatsuBlock insert(HissatsuBlock newObj) {
		return hissatsuBlockRepository.save(newObj);
	}

	@Override
	public HissatsuBlock replace(HissatsuBlock newObj, Long id) {
		return hissatsuBlockRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setHissatsuType(newObj.getHissatsuType());
			oldObj.setHissatsuBlockPower(newObj.getHissatsuBlockPower());
			oldObj.setHissatsuBlockTp(newObj.getHissatsuBlockTp());
			oldObj.setHissatsuBlockParticipants(newObj.getHissatsuBlockParticipants());
			oldObj.setHissatsuBlockFoul(newObj.getHissatsuBlockFoul());
			oldObj.setHissatsuBlockIsBlock(newObj.isHissatsuBlockIsBlock());
			return hissatsuBlockRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return hissatsuBlockRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		hissatsuBlockRepository.deleteById(id);
	}
}
