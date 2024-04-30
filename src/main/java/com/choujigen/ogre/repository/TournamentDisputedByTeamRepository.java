package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.TournamentDisputedByTeam;
import com.choujigen.ogre.domain.TournamentDisputedByTeamId;

public interface TournamentDisputedByTeamRepository
		extends JpaRepository<TournamentDisputedByTeam, TournamentDisputedByTeamId> {

}
