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
@Table(name = "player_is_part_of_team")
public class PlayerIsPartOfTeam {
	@EmbeddedId
	private PlayerIsPartOfTeamId id;

	@ManyToOne
	@MapsId("playerId")
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@MapsId("teamId")
	@JoinColumn(name = "team_id")
	private Team team;

	@Column(name = "place")
	private Long place;

	public PlayerIsPartOfTeam() {
	}

	public PlayerIsPartOfTeam(PlayerIsPartOfTeamId id, Player player, Team team, Long place) {
		super();
		this.id = id;
		this.player = player;
		this.team = team;
		this.place = place;
	}

	public PlayerIsPartOfTeam(Long playerId, Long teamId, Player player, Team team, Long place) {
		super();
		this.id = new PlayerIsPartOfTeamId(playerId, teamId);
		this.player = player;
		this.team = team;
		this.place = place;
	}

	public PlayerIsPartOfTeamId getId() {
		return id;
	}

	public void setId(PlayerIsPartOfTeamId id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getPlace() {
		return place;
	}

	public void setPlace(Long place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, place, player, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerIsPartOfTeam other = (PlayerIsPartOfTeam) obj;
		return Objects.equals(id, other.id) && Objects.equals(place, other.place)
				&& Objects.equals(player, other.player) && Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "PlayerIsPartOfTeam [id=" + id + ", player=" + player + ", team=" + team + ", place=" + place + "]";
	}

}
