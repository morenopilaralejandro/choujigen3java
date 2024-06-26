package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_formation")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_formation_id")
public class ItemFormation extends Item {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formation_type_id", referencedColumnName = "formation_type_id")
	private FormationType formationType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formation_scheme_id", referencedColumnName = "formation_scheme_id")
	private FormationScheme formationScheme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "original_version", referencedColumnName = "item_formation_id")
	private ItemFormation originalVersion;
	
	@OneToMany(mappedBy = "itemFormation", fetch = FetchType.LAZY)
	private List<FormationOrganizedAsPositi> formationOrganizedAsPositi;
	
	@OneToMany(mappedBy = "itemFormation", fetch = FetchType.LAZY)
	private List<Team> teams;

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
	
	public Positi[] getPositiOrderByPlace() {
		Positi[] positiOrderByPlace = new Positi[11];
		for (int i = 0; i < this.formationOrganizedAsPositi.size(); i++) {
			int auxPlace = this.formationOrganizedAsPositi.get(i).getId().getPlaceId().intValue();
			positiOrderByPlace[auxPlace - 1] = this.formationOrganizedAsPositi.get(i).getPositi();
		}
		return positiOrderByPlace;
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

	public List<FormationOrganizedAsPositi> getFormationOrganizedAsPositi() {
		return formationOrganizedAsPositi;
	}

	public void setFormationOrganizedAsPositi(List<FormationOrganizedAsPositi> formationOrganizedAsPositi) {
		this.formationOrganizedAsPositi = formationOrganizedAsPositi;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
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
