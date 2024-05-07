package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UltimateNoteIncreasesFreeId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "item_ultimate_note_id")
	private Long itemUltimateNoteId;

	@Column(name = "positi_id")
	private Long positiId;
	
	@Column(name = "attri_id")
	private Long attriId;

	public UltimateNoteIncreasesFreeId() {

	}

	public UltimateNoteIncreasesFreeId(Long itemUltimateNoteId, Long positiId, Long attriId) {
		super();
		this.itemUltimateNoteId = itemUltimateNoteId;
		this.positiId = positiId;
		this.attriId = attriId;
	}

	public Long getItemUltimateNoteId() {
		return itemUltimateNoteId;
	}

	public void setItemUltimateNoteId(Long itemUltimateNoteId) {
		this.itemUltimateNoteId = itemUltimateNoteId;
	}

	public Long getPositiId() {
		return positiId;
	}

	public void setPositiId(Long positiId) {
		this.positiId = positiId;
	}

	public Long getAttriId() {
		return attriId;
	}

	public void setAttriId(Long attriId) {
		this.attriId = attriId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attriId, itemUltimateNoteId, positiId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UltimateNoteIncreasesFreeId other = (UltimateNoteIncreasesFreeId) obj;
		return Objects.equals(attriId, other.attriId) && Objects.equals(itemUltimateNoteId, other.itemUltimateNoteId)
				&& Objects.equals(positiId, other.positiId);
	}

	@Override
	public String toString() {
		return "UltimateNoteIncreasesFreeId [itemUltimateNoteId=" + itemUltimateNoteId + ", positiId=" + positiId
				+ ", attriId=" + attriId + "]";
	}
	
}
