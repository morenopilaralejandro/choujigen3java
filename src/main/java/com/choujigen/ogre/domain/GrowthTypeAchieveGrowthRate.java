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
@Table(name = "growth_type_can_achieve_growth_rate")
public class GrowthTypeAchieveGrowthRate {
	@EmbeddedId
	private GrowthTypeAchieveGrowthRateId id;

	@ManyToOne
	@MapsId("growthTypeId")
	@JoinColumn(name = "growth_type_id")
	private GrowthType growthType;

	@ManyToOne
	@MapsId("growthRateId")
	@JoinColumn(name = "growth_rate_id")
	private GrowthRate growthRate;

	@Column(name = "additional_power")
	private Long additionalPower;

	@Column(name = "number_of_uses")
	private Long numberOfUses;

	public GrowthTypeAchieveGrowthRate() {
	}

	public GrowthTypeAchieveGrowthRate(GrowthType growthType, GrowthRate growthRate, Long additionalPower,
			Long numberOfUses) {
		super();
		this.id = new GrowthTypeAchieveGrowthRateId(growthType.getGrowthTypeId(), growthRate.getGrowthRateId());
		this.growthType = growthType;
		this.growthRate = growthRate;
		this.additionalPower = additionalPower;
		this.numberOfUses = numberOfUses;
	}

	public GrowthTypeAchieveGrowthRateId getId() {
		return id;
	}

	public void setId(GrowthTypeAchieveGrowthRateId id) {
		this.id = id;
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

	public Long getAdditionalPower() {
		return additionalPower;
	}

	public void setAdditionalPower(Long additionalPower) {
		this.additionalPower = additionalPower;
	}

	public Long getNumberOfUses() {
		return numberOfUses;
	}

	public void setNumberOfUses(Long numberOfUses) {
		this.numberOfUses = numberOfUses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalPower, growthRate, growthType, id, numberOfUses);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrowthTypeAchieveGrowthRate other = (GrowthTypeAchieveGrowthRate) obj;
		return Objects.equals(additionalPower, other.additionalPower) && Objects.equals(growthRate, other.growthRate)
				&& Objects.equals(growthType, other.growthType) && Objects.equals(id, other.id)
				&& Objects.equals(numberOfUses, other.numberOfUses);
	}

	@Override
	public String toString() {
		return "GrowthTypeAchieveGrowthRate [id=" + id + ", growthType=" + growthType + ", growthRate=" + growthRate
				+ ", additionalPower=" + additionalPower + ", numberOfUses=" + numberOfUses + "]";
	}

}
