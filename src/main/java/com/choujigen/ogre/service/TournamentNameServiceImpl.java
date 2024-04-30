package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TournamentName;
import com.choujigen.ogre.exception.TournamentNameNotFoundException;
import com.choujigen.ogre.repository.TournamentNameRepository;

@Service
public class TournamentNameServiceImpl implements TournamentNameService {
	@Autowired
	private TournamentNameRepository tournamentNameRepository;

	@Override
	public List<TournamentName> all() {
		return tournamentNameRepository.findAll();
	}

	@Override
	public TournamentName one(Long id) {
		return tournamentNameRepository.findById(id).orElseThrow(() -> new TournamentNameNotFoundException(id));
	}

	@Override
	public TournamentName insert(TournamentName newObj) {
		return tournamentNameRepository.save(newObj);
	}

	@Override
	public TournamentName replace(TournamentName newObj, Long id) {
		return tournamentNameRepository.findById(id).map(oldObj -> {
			oldObj.setTournamentNameJa(newObj.getTournamentNameJa());
			oldObj.setTournamentNameEn(newObj.getTournamentNameEn());
			oldObj.setTournamentNameEs(newObj.getTournamentNameEs());
			oldObj.setTournamentRank(newObj.getTournamentRank());
			return tournamentNameRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTournamentNameId(id);
			return tournamentNameRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		tournamentNameRepository.deleteById(id);
	}
}
