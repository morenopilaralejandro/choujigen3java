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
@Table(name = "item_vscard")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_vscard_id")
public class ItemVscard extends Item {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "practice_game_id", referencedColumnName = "practice_game_id")
	private PracticeGame practiceGame;

	public ItemVscard() {
	}

	public ItemVscard(PracticeGame practiceGame) {
		super();
		this.practiceGame = practiceGame;
	}

	public ItemVscard(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, PracticeGame practiceGame) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.practiceGame = practiceGame;
	}

	public PracticeGame getPracticeGame() {
		return practiceGame;
	}

	public void setPracticeGame(PracticeGame practiceGame) {
		this.practiceGame = practiceGame;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(practiceGame);
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
		ItemVscard other = (ItemVscard) obj;
		return Objects.equals(practiceGame, other.practiceGame);
	}

	@Override
	public String toString() {
		return "ItemVscard [practiceGame=" + practiceGame + "]";
	}

}
