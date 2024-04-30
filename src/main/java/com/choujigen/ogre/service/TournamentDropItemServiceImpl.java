package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TournamentDropItem;
import com.choujigen.ogre.domain.TournamentDropItemId;
import com.choujigen.ogre.exception.TournamentDropItemNotFoundException;
import com.choujigen.ogre.repository.TournamentDropItemRepository;

@Service
public class TournamentDropItemServiceImpl implements TournamentDropItemService {
	@Autowired
	private TournamentDropItemRepository tournamentDropItemRepository;

	@Override
	public List<TournamentDropItem> all() {
		return tournamentDropItemRepository.findAll();
	}

	@Override
	public TournamentDropItem one(TournamentDropItemId tournamentDropItemId) {
		return tournamentDropItemRepository.findById(tournamentDropItemId)
				.orElseThrow(() -> new TournamentDropItemNotFoundException(tournamentDropItemId));
	}

	@Override
	public TournamentDropItem insert(TournamentDropItem newObj) {
		return tournamentDropItemRepository.save(newObj);
	}

	@Override
	public TournamentDropItem replace(TournamentDropItem newObj, TournamentDropItemId tournamentDropItemId) {
		return tournamentDropItemRepository.findById(tournamentDropItemId).map(oldObj -> {
			oldObj.setTournamentRank(newObj.getTournamentRank());
			oldObj.setItem(newObj.getItem());
			oldObj.setSelectionRate(newObj.getSelectionRate());
			oldObj.setDropRate(newObj.getDropRate());
			oldObj.setNoRecoverRate(newObj.getNoRecoverRate());
			return tournamentDropItemRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(tournamentDropItemId);
			return tournamentDropItemRepository.save(newObj);
		});
	}

	@Override
	public void delete(TournamentDropItemId tournamentDropItemId) {
		tournamentDropItemRepository.deleteById(tournamentDropItemId);
	}

}
