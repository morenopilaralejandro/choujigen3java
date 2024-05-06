package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_reward_player")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_reward_player_id")
public class ItemRewardPlayer extends Item {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player player;

	public ItemRewardPlayer() {
	}

	public ItemRewardPlayer(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, Player player) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(player);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemRewardPlayer other = (ItemRewardPlayer) obj;
		return Objects.equals(player, other.player);
	}

	@Override
	public String toString() {
		return "ItemRewardPlayer [player=" + player + "]";
	}

}
