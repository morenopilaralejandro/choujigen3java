package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "hissatsu_shoot")
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class HissatsuShoot extends ItemHissatsu {

	@Column(name = "hissatsu_shoot_power")
	private Long hissatsuShootPower;

	@Column(name = "hissatsu_shoot_tp")
	private Long hissatsuShootTp;

	@Column(name = "hissatsu_shoot_participants")
	private Long hissatsuShootParticipants;

	@ManyToMany
	@JoinTable(name = "hissatsu_shoot_can_have_shoot_special_property", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "shoot_special_property_id"))
	private List<ShootSpecialProperty> shootSpecialProperty;

	public HissatsuShoot() {
	}

	public HissatsuShoot(Long hissatsuShootPower, Long hissatsuShootTp, Long hissatsuShootParticipants,
			List<ShootSpecialProperty> shootSpecialProperty) {
		super();
		this.hissatsuShootPower = hissatsuShootPower;
		this.hissatsuShootTp = hissatsuShootTp;
		this.hissatsuShootParticipants = hissatsuShootParticipants;
		this.shootSpecialProperty = shootSpecialProperty;
	}

	public Long getHissatsuShootAdditionalPower() {
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

	public Long getHissatsuShootMaxPower() {
		return getHissatsuShootPower() + getHissatsuShootAdditionalPower();
	}

	public Long getHissatsuShootPower() {
		return hissatsuShootPower;
	}

	public void setHissatsuShootPower(Long hissatsuShootPower) {
		this.hissatsuShootPower = hissatsuShootPower;
	}

	public Long getHissatsuShootTp() {
		return hissatsuShootTp;
	}

	public void setHissatsuShootTp(Long hissatsuShootTp) {
		this.hissatsuShootTp = hissatsuShootTp;
	}

	public Long getHissatsuShootParticipants() {
		return hissatsuShootParticipants;
	}

	public void setHissatsuShootParticipants(Long hissatsuShootParticipants) {
		this.hissatsuShootParticipants = hissatsuShootParticipants;
	}

	public List<ShootSpecialProperty> getShootSpecialProperty() {
		return shootSpecialProperty;
	}

	public void setShootSpecialProperty(List<ShootSpecialProperty> shootSpecialProperty) {
		this.shootSpecialProperty = shootSpecialProperty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(hissatsuShootParticipants, hissatsuShootPower, hissatsuShootTp, shootSpecialProperty);
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
		HissatsuShoot other = (HissatsuShoot) obj;
		return Objects.equals(hissatsuShootParticipants, other.hissatsuShootParticipants)
				&& Objects.equals(hissatsuShootPower, other.hissatsuShootPower)
				&& Objects.equals(hissatsuShootTp, other.hissatsuShootTp)
				&& Objects.equals(shootSpecialProperty, other.shootSpecialProperty);
	}

	@Override
	public String toString() {
		return "HissatsuShoot [hissatsuShootPower=" + hissatsuShootPower + ", hissatsuShootTp=" + hissatsuShootTp
				+ ", hissatsuShootParticipants=" + hissatsuShootParticipants + ", shootSpecialProperty="
				+ shootSpecialProperty + "]";
	}

}
