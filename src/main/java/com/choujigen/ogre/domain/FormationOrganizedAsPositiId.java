package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FormationOrganizedAsPositiId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "item_formation_id")
	private Long itemFormationId;

	@Column(name = "positi_id")
	private Long positiId;

	@Column(name = "place")
	private Long placeId;

	public FormationOrganizedAsPositiId() {

	}

	public FormationOrganizedAsPositiId(Long itemFormationId, Long positiId, Long placeId) {
		super();
		this.itemFormationId = itemFormationId;
		this.positiId = positiId;
		this.placeId = placeId;
	}

	public Long getItemFormationId() {
		return itemFormationId;
	}

	public void setItemFormationId(Long itemFormationId) {
		this.itemFormationId = itemFormationId;
	}

	public Long getPositiId() {
		return positiId;
	}

	public void setPositiId(Long positiId) {
		this.positiId = positiId;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemFormationId, placeId, positiId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormationOrganizedAsPositiId other = (FormationOrganizedAsPositiId) obj;
		return Objects.equals(itemFormationId, other.itemFormationId) && Objects.equals(placeId, other.placeId)
				&& Objects.equals(positiId, other.positiId);
	}

	@Override
	public String toString() {
		return "FormationOrganizedAsPositiId [itemFormationId=" + itemFormationId + ", positiId=" + positiId
				+ ", placeId=" + placeId + "]";
	}

}
