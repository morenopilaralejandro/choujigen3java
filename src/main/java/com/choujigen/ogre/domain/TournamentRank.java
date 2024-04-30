package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament_rank")
public class TournamentRank {
	@Column(name = "tournament_rank_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long tournamentRankId;
	@Column(name = "tournament_rank_lv_range")
	private String tournamentRankLvRange;

	@OneToMany(mappedBy = "tournamentRank")
	private List<TournamentName> names;
	
	@ManyToMany
	@JoinTable(name = "tournament_rank_requires_player", joinColumns = @JoinColumn(name = "tournament_rank_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
	private List<Player> players;
	
	@OneToMany(mappedBy = "tournamentRank")
	private List<TournamentDisputedByTeam> tournamentDisputedByTeam;
	
	@OneToMany(mappedBy = "tournamentRank")
	private List<TournamentDropItem> tournamentDropItem;
	
	public TournamentRank() {
	}

	public TournamentRank(Long tournamentRankId, String tournamentRankLvRange) {
		super();
		this.tournamentRankId = tournamentRankId;
		this.tournamentRankLvRange = tournamentRankLvRange;
	}

	public Long getTournamentRankId() {
		return tournamentRankId;
	}

	public void setTournamentRankId(Long tournamentRankId) {
		this.tournamentRankId = tournamentRankId;
	}

	public String getTournamentRankLvRange() {
		return tournamentRankLvRange;
	}

	public void setTournamentRankLvRange(String tournamentRankLvRange) {
		this.tournamentRankLvRange = tournamentRankLvRange;
	}

	public List<TournamentName> getNames() {
		return names;
	}

	public void setNames(List<TournamentName> names) {
		this.names = names;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<TournamentDisputedByTeam> getTournamentDisputedByTeam() {
		return tournamentDisputedByTeam;
	}

	public void setTournamentDisputedByTeam(List<TournamentDisputedByTeam> tournamentDisputedByTeam) {
		this.tournamentDisputedByTeam = tournamentDisputedByTeam;
	}

	public List<TournamentDropItem> getTournamentDropItem() {
		return tournamentDropItem;
	}

	public void setTournamentDropItem(List<TournamentDropItem> tournamentDropItem) {
		this.tournamentDropItem = tournamentDropItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tournamentRankId, tournamentRankLvRange);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentRank other = (TournamentRank) obj;
		return Objects.equals(tournamentRankId, other.tournamentRankId)
				&& Objects.equals(tournamentRankLvRange, other.tournamentRankLvRange);
	}

	@Override
	public String toString() {
		return "TournamentRank [tournamentRankId=" + tournamentRankId + ", tournamentRankLvRange="
				+ tournamentRankLvRange + "]";
	}

}
