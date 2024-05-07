package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	@Column(name = "team_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long teamId;
	@Column(name = "team_name_ja")
	private String teamNameJa;
	@Column(name = "team_name_en")
	private String teamNameEn;
	@Column(name = "team_name_es")
	private String teamNameEs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_formation_id", referencedColumnName = "item_formation_id")
	private ItemFormation itemFormation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_wear_id", referencedColumnName = "item_wear_id")
	private ItemWear itemWear;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<PlayerIsPartOfTeam> players;

	@ManyToMany(mappedBy = "storyTeam", fetch = FetchType.LAZY)
	private List<Player> storyPlayers;

	@ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
	private List<ItemTactic> tactics;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<TournamentDisputedByTeam> tournamentDisputedByTeam;
	
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<PracticeGame> practiceGames;

	public Team() {
	}

	public Team(Long teamId, String teamNameJa, String teamNameEn, String teamNameEs, ItemFormation itemFormation,
			ItemWear itemWear) {
		super();
		this.teamId = teamId;
		this.teamNameJa = teamNameJa;
		this.teamNameEn = teamNameEn;
		this.teamNameEs = teamNameEs;
		this.itemFormation = itemFormation;
		this.itemWear = itemWear;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getTeamNameJa();
		case "en":
			return this.getTeamNameEn();
		case "es":
			return this.getTeamNameEs();
		default:
			return this.getTeamNameEn();
		}
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamNameJa() {
		return teamNameJa;
	}

	public void setTeamNameJa(String teamNameJa) {
		this.teamNameJa = teamNameJa;
	}

	public String getTeamNameEn() {
		return teamNameEn;
	}

	public void setTeamNameEn(String teamNameEn) {
		this.teamNameEn = teamNameEn;
	}

	public String getTeamNameEs() {
		return teamNameEs;
	}

	public void setTeamNameEs(String teamNameEs) {
		this.teamNameEs = teamNameEs;
	}

	public ItemFormation getItemFormation() {
		return itemFormation;
	}

	public void setItemFormation(ItemFormation itemFormation) {
		this.itemFormation = itemFormation;
	}

	public ItemWear getItemWear() {
		return itemWear;
	}

	public void setItemWear(ItemWear itemWear) {
		this.itemWear = itemWear;
	}

	public List<PlayerIsPartOfTeam> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerIsPartOfTeam> players) {
		this.players = players;
	}

	public List<Player> getStoryPlayers() {
		return storyPlayers;
	}

	public void setStoryPlayers(List<Player> storyPlayers) {
		this.storyPlayers = storyPlayers;
	}

	public List<ItemTactic> getTactics() {
		return tactics;
	}

	public void setTactics(List<ItemTactic> tactics) {
		this.tactics = tactics;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemFormation, itemWear, teamId, teamNameEn, teamNameEs, teamNameJa);
	}

	public List<TournamentDisputedByTeam> getTournamentDisputedByTeam() {
		return tournamentDisputedByTeam;
	}

	public void setTournamentDisputedByTeam(List<TournamentDisputedByTeam> tournamentDisputedByTeam) {
		this.tournamentDisputedByTeam = tournamentDisputedByTeam;
	}

	public List<PracticeGame> getPracticeGames() {
		return practiceGames;
	}

	public void setPracticeGames(List<PracticeGame> practiceGames) {
		this.practiceGames = practiceGames;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(itemFormation, other.itemFormation) && Objects.equals(itemWear, other.itemWear)
				&& Objects.equals(teamId, other.teamId) && Objects.equals(teamNameEn, other.teamNameEn)
				&& Objects.equals(teamNameEs, other.teamNameEs) && Objects.equals(teamNameJa, other.teamNameJa);
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamNameJa=" + teamNameJa + ", teamNameEn=" + teamNameEn + ", teamNameEs="
				+ teamNameEs + ", itemFormation=" + itemFormation + ", itemWear=" + itemWear + "]";
	}

}
