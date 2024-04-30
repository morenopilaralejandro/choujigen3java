package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament_rank_disputed_by_team")
public class TournamentDisputedByTeam {
	@EmbeddedId
	private TournamentDisputedByTeamId id;

	@ManyToOne
	@MapsId("tournamentRankId")
	@JoinColumn(name = "tournament_rank_id")
	private TournamentRank tournamentRank;

	@ManyToOne
	@MapsId("teamId")
	@JoinColumn(name = "team_id")
	private Team team;

	@Column(name = "team_lv")
	private Long teamLv;

	public TournamentDisputedByTeam() {
	}

	public TournamentDisputedByTeam(TournamentDisputedByTeamId id, TournamentRank tournamentRank, Team team,
			Long teamLv) {
		super();
		this.id = id;
		this.tournamentRank = tournamentRank;
		this.team = team;
		this.teamLv = teamLv;
	}

	public TournamentDisputedByTeam(Long tournamentRankId, Long teamId, TournamentRank tournamentRank, Team team,
			Long teamLv) {
		super();
		this.id = new TournamentDisputedByTeamId(tournamentRankId, teamId);
		this.tournamentRank = tournamentRank;
		this.team = team;
		this.teamLv = teamLv;
	}

	public TournamentDisputedByTeamId getId() {
		return id;
	}

	public void setId(TournamentDisputedByTeamId id) {
		this.id = id;
	}

	public TournamentRank getTournamentRank() {
		return tournamentRank;
	}

	public void setTournamentRank(TournamentRank tournamentRank) {
		this.tournamentRank = tournamentRank;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getTeamLv() {
		return teamLv;
	}

	public void setTeamLv(Long teamLv) {
		this.teamLv = teamLv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, team, teamLv, tournamentRank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentDisputedByTeam other = (TournamentDisputedByTeam) obj;
		return Objects.equals(id, other.id) && Objects.equals(team, other.team) && Objects.equals(teamLv, other.teamLv)
				&& Objects.equals(tournamentRank, other.tournamentRank);
	}

	@Override
	public String toString() {
		return "TournamentDisputedByTeam [id=" + id + ", tournamentRank=" + tournamentRank + ", team=" + team
				+ ", teamLv=" + teamLv + "]";
	}

}
