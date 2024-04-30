package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.TournamentDisputedByTeam;
import com.choujigen.ogre.domain.TournamentDisputedByTeamId;
import com.choujigen.ogre.exception.TournamentDisputedByTeamNotFoundException;
import com.choujigen.ogre.repository.TournamentDisputedByTeamRepository;

@Service
public class TournamentDisputedByTeamServiceImpl implements TournamentDisputedByTeamService {
	@Autowired
	private TournamentDisputedByTeamRepository tournamentDisputedByTeamRepository;

	@Override
	public List<TournamentDisputedByTeam> all() {
		return tournamentDisputedByTeamRepository.findAll();
	}

	@Override
	public TournamentDisputedByTeam one(TournamentDisputedByTeamId id) {
		return tournamentDisputedByTeamRepository.findById(id).orElseThrow(() -> new TournamentDisputedByTeamNotFoundException(id));
	}

	@Override
	public TournamentDisputedByTeam insert(TournamentDisputedByTeam newObj) {
		return tournamentDisputedByTeamRepository.save(newObj);
	}

	@Override
	public TournamentDisputedByTeam replace(TournamentDisputedByTeam newObj, TournamentDisputedByTeamId id) {
		return tournamentDisputedByTeamRepository.findById(id).map(oldObj -> {
			oldObj.setTournamentRank(newObj.getTournamentRank());
			oldObj.setTeam(newObj.getTeam());
			oldObj.setTeamLv(newObj.getTeamLv());
			return tournamentDisputedByTeamRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(id);
			return tournamentDisputedByTeamRepository.save(newObj);
		});
	}

	@Override
	public void delete(TournamentDisputedByTeamId id) {
		tournamentDisputedByTeamRepository.deleteById(id);
	}
}
