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
@Table(name = "player_learns_hissatsu")
public class PlayerLearnsHissatsu {
	@EmbeddedId
	private PlayerLearnsHissatsuId id;

	@ManyToOne
	@MapsId("playerId")
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@MapsId("itemHissatsuId")
	@JoinColumn(name = "item_hissatsu_id")
	private ItemHissatsu itemHissatsu;

	@Column(name = "learn_lv")
	private Long learnLv;

	@Column(name = "learn_order")
	private Long learnOrder;

	public PlayerLearnsHissatsu() {
	}

	public PlayerLearnsHissatsu(PlayerLearnsHissatsuId id, Player player, ItemHissatsu itemHissatsu, Long learnLv,
			Long learnOrder) {
		super();
		this.id = id;
		this.player = player;
		this.itemHissatsu = itemHissatsu;
		this.learnLv = learnLv;
		this.learnOrder = learnOrder;
	}

	public PlayerLearnsHissatsu(Long playerId, Long itemHissatsuId, Player player, ItemHissatsu itemHissatsu,
			Long learnLv, Long learnOrder) {
		super();
		this.id = new PlayerLearnsHissatsuId(playerId, itemHissatsuId);
		this.player = player;
		this.itemHissatsu = itemHissatsu;
		this.learnLv = learnLv;
		this.learnOrder = learnOrder;
	}

	public PlayerLearnsHissatsuId getId() {
		return id;
	}

	public void setId(PlayerLearnsHissatsuId id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ItemHissatsu getItemHissatsu() {
		return itemHissatsu;
	}

	public void setItemHissatsu(ItemHissatsu itemHissatsu) {
		this.itemHissatsu = itemHissatsu;
	}

	public Long getLearnLv() {
		return learnLv;
	}

	public void setLearnLv(Long learnLv) {
		this.learnLv = learnLv;
	}

	public Long getLearnOrder() {
		return learnOrder;
	}

	public void setLearnOrder(Long learnOrder) {
		this.learnOrder = learnOrder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemHissatsu, learnLv, learnOrder, player);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerLearnsHissatsu other = (PlayerLearnsHissatsu) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemHissatsu, other.itemHissatsu)
				&& Objects.equals(learnLv, other.learnLv) && Objects.equals(learnOrder, other.learnOrder)
				&& Objects.equals(player, other.player);
	}

	@Override
	public String toString() {
		return "PlayerLearnsHissatsu [id=" + id + ", player=" + player + ", itemHissatsu=" + itemHissatsu + ", learnLv="
				+ learnLv + ", learnOrder=" + learnOrder + "]";
	}

}
