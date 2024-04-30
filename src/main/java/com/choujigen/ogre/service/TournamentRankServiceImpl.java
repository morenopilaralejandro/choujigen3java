package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TournamentRank;
import com.choujigen.ogre.exception.TournamentRankNotFoundException;
import com.choujigen.ogre.repository.TournamentRankRepository;

@Service
public class TournamentRankServiceImpl implements TournamentRankService {
	@Autowired
	private TournamentRankRepository tournamentRankRepository;

	@Override
	public List<TournamentRank> all() {
		return tournamentRankRepository.findAll();
	}

	@Override
	public TournamentRank one(Long id) {
		return tournamentRankRepository.findById(id).orElseThrow(() -> new TournamentRankNotFoundException(id));
	}

	@Override
	public TournamentRank insert(TournamentRank newObj) {
		return tournamentRankRepository.save(newObj);
	}

	@Override
	public TournamentRank replace(TournamentRank newObj, Long id) {
		return tournamentRankRepository.findById(id).map(oldObj -> {
			oldObj.setTournamentRankLvRange(newObj.getTournamentRankLvRange());
			return tournamentRankRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTournamentRankId(id);
			return tournamentRankRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		tournamentRankRepository.deleteById(id);
	}
}
