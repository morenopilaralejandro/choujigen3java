package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_obtention_method")
public class PlayerObtentionMethod {
	@Column(name = "player_obtention_method_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long playerObtentionMethodId;
	@Column(name = "player_obtention_method_desc_ja")
	private String playerObtentionMethodDescJa;
	@Column(name = "player_obtention_method_desc_en")
	private String playerObtentionMethodDescEn;
	@Column(name = "player_obtention_method_desc_es")
	private String playerObtentionMethodDescEs;

	public PlayerObtentionMethod() {
	}

	public PlayerObtentionMethod(Long playerObtentionMethodId, String playerObtentionMethodDescJa,
			String playerObtentionMethodDescEn, String playerObtentionMethodDescEs) {
		super();
		this.playerObtentionMethodId = playerObtentionMethodId;
		this.playerObtentionMethodDescJa = playerObtentionMethodDescJa;
		this.playerObtentionMethodDescEn = playerObtentionMethodDescEn;
		this.playerObtentionMethodDescEs = playerObtentionMethodDescEs;
	}

	public String getDescByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getPlayerObtentionMethodDescJa();
		case "en":
			return this.getPlayerObtentionMethodDescEn();
		case "es":
			return this.getPlayerObtentionMethodDescEs();
		default:
			return this.getPlayerObtentionMethodDescEn();
		}
	}

	public Long getPlayerObtentionMethodId() {
		return playerObtentionMethodId;
	}

	public void setPlayerObtentionMethodId(Long playerObtentionMethodId) {
		this.playerObtentionMethodId = playerObtentionMethodId;
	}

	public String getPlayerObtentionMethodDescJa() {
		return playerObtentionMethodDescJa;
	}

	public void setPlayerObtentionMethodDescJa(String playerObtentionMethodDescJa) {
		this.playerObtentionMethodDescJa = playerObtentionMethodDescJa;
	}

	public String getPlayerObtentionMethodDescEn() {
		return playerObtentionMethodDescEn;
	}

	public void setPlayerObtentionMethodDescEn(String playerObtentionMethodDescEn) {
		this.playerObtentionMethodDescEn = playerObtentionMethodDescEn;
	}

	public String getPlayerObtentionMethodDescEs() {
		return playerObtentionMethodDescEs;
	}

	public void setPlayerObtentionMethodDescEs(String playerObtentionMethodDescEs) {
		this.playerObtentionMethodDescEs = playerObtentionMethodDescEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerObtentionMethodDescEn, playerObtentionMethodDescEs, playerObtentionMethodDescJa,
				playerObtentionMethodId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerObtentionMethod other = (PlayerObtentionMethod) obj;
		return Objects.equals(playerObtentionMethodDescEn, other.playerObtentionMethodDescEn)
				&& Objects.equals(playerObtentionMethodDescEs, other.playerObtentionMethodDescEs)
				&& Objects.equals(playerObtentionMethodDescJa, other.playerObtentionMethodDescJa)
				&& Objects.equals(playerObtentionMethodId, other.playerObtentionMethodId);
	}

	@Override
	public String toString() {
		return "PlayerObtentionMethod [playerObtentionMethodId=" + playerObtentionMethodId
				+ ", playerObtentionMethodDescJa=" + playerObtentionMethodDescJa + ", playerObtentionMethodDescEn="
				+ playerObtentionMethodDescEn + ", playerObtentionMethodDescEs=" + playerObtentionMethodDescEs + "]";
	}

}
