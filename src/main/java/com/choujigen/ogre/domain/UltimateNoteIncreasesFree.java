package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "ultimate_note_increases_free")
public class UltimateNoteIncreasesFree {
	@EmbeddedId
	private UltimateNoteIncreasesFreeId id;

	@ManyToOne
	@MapsId("itemUltimateNoteId")
	@JoinColumn(name = "item_ultimate_note_id")
	private ItemUltimateNote itemUltimateNote;

	@ManyToOne
	@MapsId("positiId")
	@JoinColumn(name = "positi_id")
	private Positi positi;

	@ManyToOne
	@MapsId("attriId")
	@JoinColumn(name = "attri_id")
	private Attri attri;

	public UltimateNoteIncreasesFree() {
	}

	public UltimateNoteIncreasesFree(UltimateNoteIncreasesFreeId id, ItemUltimateNote itemUltimateNote, Positi positi,
			Attri attri) {
		super();
		this.id = id;
		this.itemUltimateNote = itemUltimateNote;
		this.positi = positi;
		this.attri = attri;
	}

	public UltimateNoteIncreasesFree(Long itemUltimateNoteId, Long positiId, Long attriId,
			ItemUltimateNote itemUltimateNote, Positi positi, Attri attri) {
		super();
		this.id = new UltimateNoteIncreasesFreeId(itemUltimateNoteId, positiId, attriId);
		this.itemUltimateNote = itemUltimateNote;
		this.positi = positi;
		this.attri = attri;
	}

	public UltimateNoteIncreasesFreeId getId() {
		return id;
	}

	public void setId(UltimateNoteIncreasesFreeId id) {
		this.id = id;
	}

	public ItemUltimateNote getItemUltimateNote() {
		return itemUltimateNote;
	}

	public void setItemUltimateNote(ItemUltimateNote itemUltimateNote) {
		this.itemUltimateNote = itemUltimateNote;
	}

	public Positi getPositi() {
		return positi;
	}

	public void setPositi(Positi positi) {
		this.positi = positi;
	}

	public Attri getAttri() {
		return attri;
	}

	public void setAttri(Attri attri) {
		this.attri = attri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attri, id, itemUltimateNote, positi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UltimateNoteIncreasesFree other = (UltimateNoteIncreasesFree) obj;
		return Objects.equals(attri, other.attri) && Objects.equals(id, other.id)
				&& Objects.equals(itemUltimateNote, other.itemUltimateNote) && Objects.equals(positi, other.positi);
	}

	@Override
	public String toString() {
		return "UltimateNoteIncreasesFree [id=" + id + ", itemUltimateNote=" + itemUltimateNote + ", positi=" + positi
				+ ", attri=" + attri + "]";
	}

}
