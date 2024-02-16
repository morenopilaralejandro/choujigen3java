package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GrowthTypeAchieveGrowthRateId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "growth_type_id")
	private Long growthTypeId;

	@Column(name = "growth_rate_id")
	private Long growthRateId;

	public GrowthTypeAchieveGrowthRateId() {

	}

	public GrowthTypeAchieveGrowthRateId(Long growthTypeId, Long growthRateId) {
		super();
		this.growthTypeId = growthTypeId;
		this.growthRateId = growthRateId;
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
		return Objects.hash(growthRateId, growthTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrowthTypeAchieveGrowthRateId other = (GrowthTypeAchieveGrowthRateId) obj;
		return Objects.equals(growthRateId, other.growthRateId) && Objects.equals(growthTypeId, other.growthTypeId);
	}

	@Override
	public String toString() {
		return "GrowthTypeAchieveGrowthRateId [growthTypeId=" + growthTypeId + ", growthRateId=" + growthRateId + "]";
	}

}
