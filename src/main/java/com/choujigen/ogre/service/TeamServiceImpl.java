package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Team;
import com.choujigen.ogre.exception.TeamNotFoundException;
import com.choujigen.ogre.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public List<Team> all() {
		return teamRepository.findAll();
	}

	@Override
	public Team one(Long id) {
		return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
	}

	@Override
	public Team insert(Team newObj) {
		return teamRepository.save(newObj);
	}

	@Override
	public Team replace(Team newObj, Long id) {
		return teamRepository.findById(id).map(oldObj -> {
			oldObj.setTeamNameJa(newObj.getTeamNameJa());
			oldObj.setTeamNameEn(newObj.getTeamNameEn());
			oldObj.setTeamNameEs(newObj.getTeamNameEs());
			oldObj.setItemFormation(newObj.getItemFormation());
			oldObj.setItemWear(newObj.getItemWear());
			return teamRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTeamId(id);
			return teamRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		teamRepository.deleteById(id);
	}
}
