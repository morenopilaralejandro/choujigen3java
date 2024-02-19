package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_hissatsu")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class ItemHissatsu extends Item {
	@ManyToOne
	@JoinColumn(name = "hissatsu_type_id", referencedColumnName = "hissatsu_type_id")
	private HissatsuType hissatsuType;

	@OneToMany(mappedBy = "itemHissatsu")
	private List<HissatsuEvolves> HissatsuEvolves;

	public ItemHissatsu() {
	}

	public ItemHissatsu(HissatsuType hissatsuType) {
		super();
		this.hissatsuType = hissatsuType;
	}

	public HissatsuType getHissatsuType() {
		return hissatsuType;
	}

	public void setHissatsuType(HissatsuType hissatsuType) {
		this.hissatsuType = hissatsuType;
	}

	public List<HissatsuEvolves> getHissatsuEvolves() {
		return HissatsuEvolves;
	}

	public void setHissatsuEvolves(List<HissatsuEvolves> hissatsuEvolves) {
		HissatsuEvolves = hissatsuEvolves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hissatsuType);
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
		ItemHissatsu other = (ItemHissatsu) obj;
		return Objects.equals(hissatsuType, other.hissatsuType);
	}

	@Override
	public String toString() {
		return "ItemHissatsu [hissatsuType=" + hissatsuType + "]";
	}

}
