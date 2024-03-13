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
@Table(name = "item_formation_organized_as_positi")
public class FormationOrganizedAsPositi {
	@EmbeddedId
	private FormationOrganizedAsPositiId id;

	@ManyToOne
	@MapsId("itemFormationId")
	@JoinColumn(name = "item_formation_id")
	private ItemFormation itemFormation;

	@ManyToOne
	@MapsId("positiId")
	@JoinColumn(name = "positi_id")
	private Positi positi;

	@Column(name = "place")
	private Long place;

	public FormationOrganizedAsPositi() {
	}

	public FormationOrganizedAsPositi(FormationOrganizedAsPositiId id, ItemFormation itemFormation, Positi positi,
			Long place) {
		super();
		this.id = id;
		this.itemFormation = itemFormation;
		this.positi = positi;
		this.place = place;
	}

	public FormationOrganizedAsPositi(Long itemFormationId, Long positiId, ItemFormation itemFormation, Positi positi,
			Long place) {
		super();
		this.id = new FormationOrganizedAsPositiId(itemFormationId, positiId);
		this.itemFormation = itemFormation;
		this.positi = positi;
		this.place = place;
	}

	public FormationOrganizedAsPositiId getId() {
		return id;
	}

	public void setId(FormationOrganizedAsPositiId id) {
		this.id = id;
	}

	public ItemFormation getItemFormation() {
		return itemFormation;
	}

	public void setItemFormation(ItemFormation itemFormation) {
		this.itemFormation = itemFormation;
	}

	public Positi getPositi() {
		return positi;
	}

	public void setPositi(Positi positi) {
		this.positi = positi;
	}

	public Long getPlace() {
		return place;
	}

	public void setPlace(Long place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemFormation, place, positi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormationOrganizedAsPositi other = (FormationOrganizedAsPositi) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemFormation, other.itemFormation)
				&& Objects.equals(place, other.place) && Objects.equals(positi, other.positi);
	}

	@Override
	public String toString() {
		return "FormationOrganizedAsPositi [id=" + id + ", itemFormation=" + itemFormation + ", positi=" + positi
				+ ", place=" + place + "]";
	}

}
