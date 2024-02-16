package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_hissatsu")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class ItemHissatsu extends Item {
	@Column(name = "item_hissatsu_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemHissatsuId;
	@ManyToOne
	@JoinColumn(name = "hissatsu_type_id", referencedColumnName = "hissatsu_type_id")
	private HissatsuType hissatsuType;

	public ItemHissatsu() {
	}

	public ItemHissatsu(Long itemHissatsuId, HissatsuType hissatsuType) {
		super();
		this.itemHissatsuId = itemHissatsuId;
		this.hissatsuType = hissatsuType;
	}

	public Long getItemHissatsuId() {
		return itemHissatsuId;
	}

	public void setItemHissatsuId(Long itemHissatsuId) {
		this.itemHissatsuId = itemHissatsuId;
	}

	public HissatsuType getHissatsuType() {
		return hissatsuType;
	}

	public void setHissatsuType(HissatsuType hissatsuType) {
		this.hissatsuType = hissatsuType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hissatsuType, itemHissatsuId);
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
		return Objects.equals(hissatsuType, other.hissatsuType) && Objects.equals(itemHissatsuId, other.itemHissatsuId);
	}

	@Override
	public String toString() {
		return "ItemHissatsu [itemHissatsuId=" + itemHissatsuId + ", hissatsuType=" + hissatsuType + "]";
	}
}
