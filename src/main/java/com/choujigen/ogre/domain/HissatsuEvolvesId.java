package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HissatsuEvolvesId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "item_hissatsu_id")
	private Long itemHissatsuId;

	@Column(name = "growth_type_id")
	private Long growthTypeId;

	@Column(name = "growth_rate_id")
	private Long growthRateId;

	public HissatsuEvolvesId() {

	}

	public HissatsuEvolvesId(Long itemHissatsuId, Long growthTypeId, Long growthRateId) {
		super();
		this.itemHissatsuId = itemHissatsuId;
		this.growthTypeId = growthTypeId;
		this.growthRateId = growthRateId;
	}

	public Long getItemHissatsuId() {
		return itemHissatsuId;
	}

	public void setItemHissatsuId(Long itemHissatsuId) {
		this.itemHissatsuId = itemHissatsuId;
	}

	public Long getGrowthTypeId() {
		return growthTypeId;
	}

	public void setGrowthTypeId(Long growthTypeId) {
		this.growthTypeId = growthTypeId;
	}

	public Long getGrowthRateId() {
		return growthRateId;
	}

	public void setGrowthRateId(Long growthRateId) {
		this.growthRateId = growthRateId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(growthRateId, growthTypeId, itemHissatsuId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HissatsuEvolvesId other = (HissatsuEvolvesId) obj;
		return Objects.equals(growthRateId, other.growthRateId) && Objects.equals(growthTypeId, other.growthTypeId)
				&& Objects.equals(itemHissatsuId, other.itemHissatsuId);
	}

	@Override
	public String toString() {
		return "HissatsuEvolvesId [itemHissatsuId=" + itemHissatsuId + ", growthTypeId=" + growthTypeId
				+ ", growthRateId=" + growthRateId + "]";
	}

}
