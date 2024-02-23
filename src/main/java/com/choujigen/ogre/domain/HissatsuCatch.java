package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "hissatsu_catch")
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class HissatsuCatch extends ItemHissatsu {

	@Column(name = "hissatsu_catch_power")
	private Long hissatsuCatchPower;

	@Column(name = "hissatsu_catch_tp")
	private Long hissatsuCatchTp;

	@Column(name = "hissatsu_catch_participants")
	private Long hissatsuCatchParticipants;

	@ManyToOne
	@JoinColumn(name = "catch_type_id", referencedColumnName = "catch_type_id")
	private CatchType catchType;

	public HissatsuCatch() {
	}

	public HissatsuCatch(Long hissatsuCatchPower, Long hissatsuCatchTp, Long hissatsuCatchParticipants,
			CatchType catchType) {
		super();
		this.hissatsuCatchPower = hissatsuCatchPower;
		this.hissatsuCatchTp = hissatsuCatchTp;
		this.hissatsuCatchParticipants = hissatsuCatchParticipants;
		this.catchType = catchType;
	}

	public Long getHissatsuCatchAdditionalPower() {
		List<GrowthTypeAchieveGrowthRate> achieveList = getHissatsuEvolves().get(0).getGrowthType()
				.getGrowthTypeAchieveGrowthRate();
		GrowthType growthType = getHissatsuEvolves().get(0).getGrowthType();
		GrowthRate growthRate = getHissatsuEvolves().get(0).getGrowthRate();
		for (GrowthTypeAchieveGrowthRate a : achieveList) {
			if (a.getGrowthType().equals(growthType) && a.getGrowthRate().equals(growthRate)) {
				return a.getAdditionalPower();
			}
		}
		return 0L;
	}

	public Long getHissatsuCatchMaxPower() {
		return getHissatsuCatchPower() + getHissatsuCatchAdditionalPower();
	}

	public Long getHissatsuCatchPower() {
		return hissatsuCatchPower;
	}

	public void setHissatsuCatchPower(Long hissatsuCatchPower) {
		this.hissatsuCatchPower = hissatsuCatchPower;
	}

	public Long getHissatsuCatchTp() {
		return hissatsuCatchTp;
	}

	public void setHissatsuCatchTp(Long hissatsuCatchTp) {
		this.hissatsuCatchTp = hissatsuCatchTp;
	}

	public Long getHissatsuCatchParticipants() {
		return hissatsuCatchParticipants;
	}

	public void setHissatsuCatchParticipants(Long hissatsuCatchParticipants) {
		this.hissatsuCatchParticipants = hissatsuCatchParticipants;
	}

	public CatchType getCatchType() {
		return catchType;
	}

	public void setCatchType(CatchType catchType) {
		this.catchType = catchType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(catchType, hissatsuCatchParticipants, hissatsuCatchPower, hissatsuCatchTp);
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
		HissatsuCatch other = (HissatsuCatch) obj;
		return Objects.equals(catchType, other.catchType)
				&& Objects.equals(hissatsuCatchParticipants, other.hissatsuCatchParticipants)
				&& Objects.equals(hissatsuCatchPower, other.hissatsuCatchPower)
				&& Objects.equals(hissatsuCatchTp, other.hissatsuCatchTp);
	}

	@Override
	public String toString() {
		return "HissatsuCatch [hissatsuCatchPower=" + hissatsuCatchPower + ", hissatsuCatchTp=" + hissatsuCatchTp
				+ ", hissatsuCatchParticipants=" + hissatsuCatchParticipants + ", catchType=" + catchType + "]";
	}

}
