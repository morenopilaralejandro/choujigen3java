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
@Table(name = "practice_game_can_drop_item")
public class PracticeGameDropItem {
	@EmbeddedId
	private PracticeGameDropItemId id;

	@ManyToOne
	@MapsId("practiceGameId")
	@JoinColumn(name = "practice_game_id")
	private PracticeGame practiceGame;

	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "drop_rate")
	private Long dropRate;

	public PracticeGameDropItem() {
	}

	public PracticeGameDropItem(PracticeGameDropItemId id, PracticeGame practiceGame, Item item, Long dropRate) {
		super();
		this.id = id;
		this.practiceGame = practiceGame;
		this.item = item;
		this.dropRate = dropRate;
	}

	public PracticeGameDropItem(Long practiceGameId, Long itemId, PracticeGame practiceGame, Item item, Long dropRate) {
		super();
		this.id = new PracticeGameDropItemId(practiceGameId, itemId);
		this.practiceGame = practiceGame;
		this.item = item;
		this.dropRate = dropRate;
	}

	public PracticeGameDropItemId getId() {
		return id;
	}

	public void setId(PracticeGameDropItemId id) {
		this.id = id;
	}

	public PracticeGame getPracticeGame() {
		return practiceGame;
	}

	public void setPracticeGame(PracticeGame practiceGame) {
		this.practiceGame = practiceGame;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getDropRate() {
		return dropRate;
	}

	public void setDropRate(Long dropRate) {
		this.dropRate = dropRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dropRate, id, item, practiceGame);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PracticeGameDropItem other = (PracticeGameDropItem) obj;
		return Objects.equals(dropRate, other.dropRate) && Objects.equals(id, other.id)
				&& Objects.equals(item, other.item) && Objects.equals(practiceGame, other.practiceGame);
	}

	@Override
	public String toString() {
		return "PracticeGameDropItem [id=" + id + ", practiceGame=" + practiceGame + ", item=" + item + ", dropRate="
				+ dropRate + "]";
	}

}
