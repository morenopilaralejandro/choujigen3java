package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "HissatsuEvolves")
public class HissatsuEvolves {
	@EmbeddedId
	private HissatsuEvolvesId id;

	@ManyToOne
	@MapsId("itemHissatsuId")
	@JoinColumn(name = "item_hissatsu_id")
	private ItemHissatsu itemHissatsu;

	@ManyToOne
	@MapsId("growthTypeId")
	@JoinColumn(name = "growth_type_id")
	private GrowthType growthType;

	@ManyToOne
	@MapsId("growthRateId")
	@JoinColumn(name = "growth_rate_id")
	private GrowthRate growthRate;

	public HissatsuEvolves() {
	}

	public HissatsuEvolves(ItemHissatsu itemHissatsu, GrowthType growthType, GrowthRate growthRate) {
		super();
		this.id = new HissatsuEvolvesId(itemHissatsu.getItemId(), growthType.getGrowthTypeId(),
				growthRate.getGrowthRateId());
		this.itemHissatsu = itemHissatsu;
		this.growthType = growthType;
		this.growthRate = growthRate;
	}

	public HissatsuEvolvesId getId() {
		return id;
	}

	public void setId(HissatsuEvolvesId id) {
		this.id = id;
	}

	public ItemHissatsu getItemHissatsu() {
		return itemHissatsu;
	}

	public void setItemHissatsu(ItemHissatsu itemHissatsu) {
		this.itemHissatsu = itemHissatsu;
	}

	public GrowthType getGrowthType() {
		return growthType;
	}

	public void setGrowthType(GrowthType growthType) {
		this.growthType = growthType;
	}

	public GrowthRate getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(GrowthRate growthRate) {
		this.growthRate = growthRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(growthRate, growthType, id, itemHissatsu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HissatsuEvolves other = (HissatsuEvolves) obj;
		return Objects.equals(growthRate, other.growthRate) && Objects.equals(growthType, other.growthType)
				&& Objects.equals(id, other.id) && Objects.equals(itemHissatsu, other.itemHissatsu);
	}

	@Override
	public String toString() {
		return "HissatsuEvolves [id=" + id + ", itemHissatsu=" + itemHissatsu + ", growthType=" + growthType
				+ ", growthRate=" + growthRate + "]";
	}

}
