package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily")
public class Daily {
	@Column(name = "daily_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long dailyId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player player;
	
	@Column(name = "views")
	private Long views;
	
	public Daily() {
	}

	public Daily(Long dailyId, Player player, Long views) {
		super();
		this.dailyId = dailyId;
		this.player = player;
		this.views = views;
	}

	public Long getDailyId() {
		return dailyId;
	}

	public void setDailyId(Long dailyId) {
		this.dailyId = dailyId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dailyId, player, views);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Daily other = (Daily) obj;
		return Objects.equals(dailyId, other.dailyId) && Objects.equals(player, other.player)
				&& Objects.equals(views, other.views);
	}

	@Override
	public String toString() {
		return "Daily [dailyId=" + dailyId + ", player=" + player + ", views=" + views + "]";
	}
	
}
