package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlayerIsPartOfTeamId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "player_id")
	private Long playerId;

	@Column(name = "team_id")
	private Long teamId;

	public PlayerIsPartOfTeamId() {

	}

	public PlayerIsPartOfTeamId(Long playerId, Long teamId) {
		super();
		this.playerId = playerId;
		this.teamId = teamId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerId, teamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerIsPartOfTeamId other = (PlayerIsPartOfTeamId) obj;
		return Objects.equals(playerId, other.playerId) && Objects.equals(teamId, other.teamId);
	}

	@Override
	public String toString() {
		return "PlayerIsPartOfTeamId [playerId=" + playerId + ", teamId=" + teamId + "]";
	}

}
