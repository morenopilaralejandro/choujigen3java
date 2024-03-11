package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_found_at_zone")
public class PlayerFoundAtZone {
	@Column(name = "player_id")
	private @Id Long playerId;

	@ManyToOne
	@MapsId("playerId")
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "zone_id")
	private Zone zone;

	@Column(name = "is_random")
	private boolean isRandom;

	@Column(name = "hint_ja")
	private String hintJa;

	@Column(name = "hint_en")
	private String hintEn;

	@Column(name = "hint_es")
	private String hintEs;

	public PlayerFoundAtZone() {
	}

	public PlayerFoundAtZone(Long playerId, Player player, Zone zone, boolean isRandom, String hintJa, String hintEn,
			String hintEs) {
		super();
		this.playerId = playerId;
		this.player = player;
		this.zone = zone;
		this.isRandom = isRandom;
		this.hintJa = hintJa;
		this.hintEn = hintEn;
		this.hintEs = hintEs;
	}
	
	public String getHintByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.hintJa;
		case "en":
			return this.hintEn;
		case "es":
			return this.hintEs;
		default:
			return this.hintEn;
		}
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public boolean isRandom() {
		return isRandom;
	}

	public void setRandom(boolean isRandom) {
		this.isRandom = isRandom;
	}

	public String getHintJa() {
		return hintJa;
	}

	public void setHintJa(String hintJa) {
		this.hintJa = hintJa;
	}

	public String getHintEn() {
		return hintEn;
	}

	public void setHintEn(String hintEn) {
		this.hintEn = hintEn;
	}

	public String getHintEs() {
		return hintEs;
	}

	public void setHintEs(String hintEs) {
		this.hintEs = hintEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hintEn, hintEs, hintJa, isRandom, player, playerId, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerFoundAtZone other = (PlayerFoundAtZone) obj;
		return Objects.equals(hintEn, other.hintEn) && Objects.equals(hintEs, other.hintEs)
				&& Objects.equals(hintJa, other.hintJa) && isRandom == other.isRandom
				&& Objects.equals(player, other.player) && Objects.equals(playerId, other.playerId)
				&& Objects.equals(zone, other.zone);
	}

	@Override
	public String toString() {
		return "PlayerFoundAtZone [playerId=" + playerId + ", player=" + player + ", zone=" + zone + ", isRandom="
				+ isRandom + ", hintJa=" + hintJa + ", hintEn=" + hintEn + ", hintEs=" + hintEs + "]";
	}

}
