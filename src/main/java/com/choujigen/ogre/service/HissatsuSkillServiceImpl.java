package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.HissatsuSkill;
import com.choujigen.ogre.exception.HissatsuSkillNotFoundException;
import com.choujigen.ogre.repository.HissatsuSkillRepository;

@Service
public class HissatsuSkillServiceImpl implements HissatsuSkillService {
	@Autowired
	private HissatsuSkillRepository hissatsuSkillRepository;

	@Override
	public List<HissatsuSkill> all() {
		return hissatsuSkillRepository.findAll();
	}

	@Override
	public HissatsuSkill one(Long id) {
		return hissatsuSkillRepository.findById(id).orElseThrow(() -> new HissatsuSkillNotFoundException(id));
	}

	@Override
	public HissatsuSkill insert(HissatsuSkill newObj) {
		return hissatsuSkillRepository.save(newObj);
	}

	@Override
	public HissatsuSkill replace(HissatsuSkill newObj, Long id) {
		return hissatsuSkillRepository.findById(id).map(oldObj -> {
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameEs(newObj.getItemNameEs());
			oldObj.setItemPriceBuy(newObj.getItemPriceBuy());
			oldObj.setItemPriceSell(newObj.getItemPriceSell());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setHissatsuType(newObj.getHissatsuType());
			oldObj.setHissatsuSkillEffectJa(newObj.getHissatsuSkillEffectJa());
			oldObj.setHissatsuSkillEffectEn(newObj.getHissatsuSkillEffectEn());
			oldObj.setHissatsuSkillEffectEs(newObj.getHissatsuSkillEffectEs());
			return hissatsuSkillRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return hissatsuSkillRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		hissatsuSkillRepository.deleteById(id);
	}
}
