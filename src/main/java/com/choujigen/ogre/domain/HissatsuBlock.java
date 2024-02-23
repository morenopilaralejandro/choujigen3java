package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "hissatsu_block")
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class HissatsuBlock extends ItemHissatsu {

	@Column(name = "hissatsu_block_power")
	private Long hissatsuBlockPower;

	@Column(name = "hissatsu_block_tp")
	private Long hissatsuBlockTp;

	@Column(name = "hissatsu_block_participants")
	private Long hissatsuBlockParticipants;

	@Column(name = "hissatsu_block_foul")
	private Long hissatsuBlockFoul;

	@Column(name = "hissatsu_block_is_block")
	private boolean hissatsuBlockIsBlock;

	public HissatsuBlock() {
	}

	public HissatsuBlock(Long hissatsuBlockPower, Long hissatsuBlockTp, Long hissatsuBlockParticipants,
			Long hissatsuBlockFoul, boolean hissatsuBlockIsBlock) {
		super();
		this.hissatsuBlockPower = hissatsuBlockPower;
		this.hissatsuBlockTp = hissatsuBlockTp;
		this.hissatsuBlockParticipants = hissatsuBlockParticipants;
		this.hissatsuBlockFoul = hissatsuBlockFoul;
		this.hissatsuBlockIsBlock = hissatsuBlockIsBlock;
	}

	public Long getHissatsuBlockAdditionalPower() {
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

	public Long getHissatsuBlockMaxPower() {
		return getHissatsuBlockPower() + getHissatsuBlockAdditionalPower();
	}

	public Long getHissatsuBlockPower() {
		return hissatsuBlockPower;
	}

	public void setHissatsuBlockPower(Long hissatsuBlockPower) {
		this.hissatsuBlockPower = hissatsuBlockPower;
	}

	public Long getHissatsuBlockTp() {
		return hissatsuBlockTp;
	}

	public void setHissatsuBlockTp(Long hissatsuBlockTp) {
		this.hissatsuBlockTp = hissatsuBlockTp;
	}

	public Long getHissatsuBlockParticipants() {
		return hissatsuBlockParticipants;
	}

	public void setHissatsuBlockParticipants(Long hissatsuBlockParticipants) {
		this.hissatsuBlockParticipants = hissatsuBlockParticipants;
	}

	public Long getHissatsuBlockFoul() {
		return hissatsuBlockFoul;
	}

	public void setHissatsuBlockFoul(Long hissatsuBlockFoul) {
		this.hissatsuBlockFoul = hissatsuBlockFoul;
	}

	public boolean isHissatsuBlockIsBlock() {
		return hissatsuBlockIsBlock;
	}

	public void setHissatsuBlockIsBlock(boolean hissatsuBlockIsBlock) {
		this.hissatsuBlockIsBlock = hissatsuBlockIsBlock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hissatsuBlockFoul, hissatsuBlockIsBlock, hissatsuBlockParticipants,
				hissatsuBlockPower, hissatsuBlockTp);
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
		HissatsuBlock other = (HissatsuBlock) obj;
		return Objects.equals(hissatsuBlockFoul, other.hissatsuBlockFoul)
				&& hissatsuBlockIsBlock == other.hissatsuBlockIsBlock
				&& Objects.equals(hissatsuBlockParticipants, other.hissatsuBlockParticipants)
				&& Objects.equals(hissatsuBlockPower, other.hissatsuBlockPower)
				&& Objects.equals(hissatsuBlockTp, other.hissatsuBlockTp);
	}

	@Override
	public String toString() {
		return "HissatsuBlock [hissatsuBlockPower=" + hissatsuBlockPower + ", hissatsuBlockTp=" + hissatsuBlockTp
				+ ", hissatsuBlockParticipants=" + hissatsuBlockParticipants + ", hissatsuBlockFoul="
				+ hissatsuBlockFoul + ", hissatsuBlockIsBlock=" + hissatsuBlockIsBlock + "]";
	}

}
