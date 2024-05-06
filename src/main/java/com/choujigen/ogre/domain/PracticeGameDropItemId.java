package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PracticeGameDropItemId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "practice_game_id")
	private Long practiceGameId;

	@Column(name = "item_id")
	private Long itemId;

	public PracticeGameDropItemId() {

	}

	public PracticeGameDropItemId(Long practiceGameId, Long itemId) {
		super();
		this.practiceGameId = practiceGameId;
		this.itemId = itemId;
	}

	public Long getPracticeGameId() {
		return practiceGameId;
	}

	public void setPracticeGameId(Long practiceGameId) {
		this.practiceGameId = practiceGameId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, practiceGameId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PracticeGameDropItemId other = (PracticeGameDropItemId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(practiceGameId, other.practiceGameId);
	}

	@Override
	public String toString() {
		return "PracticeGameDropItemId [practiceGameId=" + practiceGameId + ", itemId=" + itemId + "]";
	}

}
