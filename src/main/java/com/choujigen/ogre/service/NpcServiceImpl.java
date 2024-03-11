package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Npc;
import com.choujigen.ogre.exception.NpcNotFoundException;
import com.choujigen.ogre.repository.NpcRepository;

@Service
public class NpcServiceImpl implements NpcService {
	@Autowired
	private NpcRepository npcRepository;

	@Override
	public List<Npc> all() {
		return npcRepository.findAll();
	}

	@Override
	public Npc one(Long id) {
		return npcRepository.findById(id).orElseThrow(() -> new NpcNotFoundException(id));
	}

	@Override
	public Npc insert(Npc newObj) {
		return npcRepository.save(newObj);
	}

	@Override
	public Npc replace(Npc newObj, Long id) {
		return npcRepository.findById(id).map(oldObj -> {
			oldObj.setNpcNameJa(newObj.getNpcNameJa());
			oldObj.setNpcNameEn(newObj.getNpcNameEn());
			oldObj.setZone(newObj.getZone());
			return npcRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setNpcId(id);
			return npcRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		npcRepository.deleteById(id);
	}
}
