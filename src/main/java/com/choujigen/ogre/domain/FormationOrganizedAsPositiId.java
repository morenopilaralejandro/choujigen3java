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

	public FormationOrganizedAsPositiId() {

	}

	public FormationOrganizedAsPositiId(Long itemFormationId, Long positiId) {
		super();
		this.itemFormationId = itemFormationId;
		this.positiId = positiId;
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

	@Override
	public int hashCode() {
		return Objects.hash(itemFormationId, positiId);
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
		return Objects.equals(itemFormationId, other.itemFormationId) && Objects.equals(positiId, other.positiId);
	}

	@Override
	public String toString() {
		return "FormationOrganizedAsPositiId [itemFormationId=" + itemFormationId + ", positiId=" + positiId + "]";
	}

}
