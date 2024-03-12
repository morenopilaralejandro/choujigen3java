package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlayerLearnsHissatsuId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "player_id")
	private Long playerId;

	@Column(name = "item_hissatsu_id")
	private Long itemHissatsuId;

	public PlayerLearnsHissatsuId() {

	}

	public PlayerLearnsHissatsuId(Long playerId, Long itemHissatsuId) {
		super();
		this.playerId = playerId;
		this.itemHissatsuId = itemHissatsuId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getItemHissatsuId() {
		return itemHissatsuId;
	}

	public void setItemHissatsuId(Long itemHissatsuId) {
		this.itemHissatsuId = itemHissatsuId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemHissatsuId, playerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerLearnsHissatsuId other = (PlayerLearnsHissatsuId) obj;
		return Objects.equals(itemHissatsuId, other.itemHissatsuId) && Objects.equals(playerId, other.playerId);
	}

	@Override
	public String toString() {
		return "PlayerLearnsHissatsuId [playerId=" + playerId + ", itemHissatsuId=" + itemHissatsuId + "]";
	}

}
