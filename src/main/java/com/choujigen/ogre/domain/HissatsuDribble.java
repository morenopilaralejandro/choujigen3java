package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "hissatsu_dribble")
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class HissatsuDribble extends ItemHissatsu {

	@Column(name = "hissatsu_dribble_power")
	private Long hissatsuDribblePower;

	@Column(name = "hissatsu_dribble_tp")
	private Long hissatsuDribbleTp;

	@Column(name = "hissatsu_dribble_participants")
	private Long hissatsuDribbleParticipants;

	@Column(name = "hissatsu_dribble_foul")
	private Long hissatsuDribbleFoul;

	public HissatsuDribble() {
	}

	public HissatsuDribble(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, HissatsuType hissatsuType, Long hissatsuDribblePower,
			Long hissatsuDribbleTp, Long hissatsuDribbleParticipants, Long hissatsuDribbleFoul) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType, hissatsuType);
		this.hissatsuDribblePower = hissatsuDribblePower;
		this.hissatsuDribbleTp = hissatsuDribbleTp;
		this.hissatsuDribbleParticipants = hissatsuDribbleParticipants;
		this.hissatsuDribbleFoul = hissatsuDribbleFoul;
	}

	public Long getHissatsuDribbleAdditionalPower() {
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

	public Long getHissatsuDribbleMaxPower() {
		return getHissatsuDribblePower() + getHissatsuDribbleAdditionalPower();
	}

	public Long getHissatsuDribblePower() {
		return hissatsuDribblePower;
	}

	public void setHissatsuDribblePower(Long hissatsuDribblePower) {
		this.hissatsuDribblePower = hissatsuDribblePower;
	}

	public Long getHissatsuDribbleTp() {
		return hissatsuDribbleTp;
	}

	public void setHissatsuDribbleTp(Long hissatsuDribbleTp) {
		this.hissatsuDribbleTp = hissatsuDribbleTp;
	}

	public Long getHissatsuDribbleParticipants() {
		return hissatsuDribbleParticipants;
	}

	public void setHissatsuDribbleParticipants(Long hissatsuDribbleParticipants) {
		this.hissatsuDribbleParticipants = hissatsuDribbleParticipants;
	}

	public Long getHissatsuDribbleFoul() {
		return hissatsuDribbleFoul;
	}

	public void setHissatsuDribbleFoul(Long hissatsuDribbleFoul) {
		this.hissatsuDribbleFoul = hissatsuDribbleFoul;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hissatsuDribbleFoul, hissatsuDribbleParticipants, hissatsuDribblePower,
				hissatsuDribbleTp);
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
		HissatsuDribble other = (HissatsuDribble) obj;
		return Objects.equals(hissatsuDribbleFoul, other.hissatsuDribbleFoul)
				&& Objects.equals(hissatsuDribbleParticipants, other.hissatsuDribbleParticipants)
				&& Objects.equals(hissatsuDribblePower, other.hissatsuDribblePower)
				&& Objects.equals(hissatsuDribbleTp, other.hissatsuDribbleTp);
	}

	@Override
	public String toString() {
		return "HissatsuDribble [hissatsuDribblePower=" + hissatsuDribblePower + ", hissatsuDribbleTp="
				+ hissatsuDribbleTp + ", hissatsuDribbleParticipants=" + hissatsuDribbleParticipants
				+ ", hissatsuDribbleFoul=" + hissatsuDribbleFoul + "]";
	}

}
