package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_formation")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_formation_id")
public class ItemFormation extends Item {

	@ManyToOne
	@JoinColumn(name = "formation_type_id", referencedColumnName = "formation_type_id")
	private FormationType formationType;

	@ManyToOne
	@JoinColumn(name = "formation_scheme_id", referencedColumnName = "formation_scheme_id")
	private FormationScheme formationScheme;

	@ManyToOne
	@JoinColumn(name = "original_version", referencedColumnName = "item_formation_id")
	private ItemFormation originalVersion;

	public ItemFormation() {
	}

	public ItemFormation(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, FormationType formationType, FormationScheme formationScheme,
			ItemFormation originalVersion) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.formationType = formationType;
		this.formationScheme = formationScheme;
		this.originalVersion = originalVersion;
	}

	public FormationType getFormationType() {
		return formationType;
	}

	public void setFormationType(FormationType formationType) {
		this.formationType = formationType;
	}

	public FormationScheme getFormationScheme() {
		return formationScheme;
	}

	public void setFormationScheme(FormationScheme formationScheme) {
		this.formationScheme = formationScheme;
	}

	public ItemFormation getOriginalVersion() {
		return originalVersion;
	}

	public void setOriginalVersion(ItemFormation originalVersion) {
		this.originalVersion = originalVersion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(formationScheme, formationType, originalVersion);
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
		ItemFormation other = (ItemFormation) obj;
		return Objects.equals(formationScheme, other.formationScheme)
				&& Objects.equals(formationType, other.formationType)
				&& Objects.equals(originalVersion, other.originalVersion);
	}

	@Override
	public String toString() {
		return "ItemFormation [formationType=" + formationType + ", formationScheme=" + formationScheme
				+ ", originalVersion=" + originalVersion + "]";
	}

}
