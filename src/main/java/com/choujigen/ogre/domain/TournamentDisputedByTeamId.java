package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TournamentDisputedByTeamId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "tournament_rank_id")
	private Long tournamentRankId;

	@Column(name = "team_id")
	private Long teamId;

	public TournamentDisputedByTeamId() {

	}

	public TournamentDisputedByTeamId(Long tournamentRankId, Long teamId) {
		super();
		this.tournamentRankId = tournamentRankId;
		this.teamId = teamId;
	}

	public Long getTournamentRankId() {
		return tournamentRankId;
	}

	public void setTournamentRankId(Long tournamentRankId) {
		this.tournamentRankId = tournamentRankId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamId, tournamentRankId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentDisputedByTeamId other = (TournamentDisputedByTeamId) obj;
		return Objects.equals(teamId, other.teamId) && Objects.equals(tournamentRankId, other.tournamentRankId);
	}

	@Override
	public String toString() {
		return "TournamentDisputedByTeamId [tournamentRankId=" + tournamentRankId + ", teamId=" + teamId + "]";
	}

}
