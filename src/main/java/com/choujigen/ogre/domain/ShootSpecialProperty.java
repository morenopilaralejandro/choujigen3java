package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoot_special_property")
public class ShootSpecialProperty {
	@Column(name = "shoot_special_property_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long shootSpecialPropertyId;
	@Column(name = "shoot_special_property_name_ja")
	private String shootSpecialPropertyNameJa;
	@Column(name = "shoot_special_property_name_en")
	private String shootSpecialPropertyNameEn;
	@Column(name = "shoot_special_property_name_es")
	private String shootSpecialPropertyNameEs;

	public ShootSpecialProperty() {
	}

	public ShootSpecialProperty(Long shootSpecialPropertyId, String shootSpecialPropertyNameJa,
			String shootSpecialPropertyNameEn, String shootSpecialPropertyNameEs) {
		super();
		this.shootSpecialPropertyId = shootSpecialPropertyId;
		this.shootSpecialPropertyNameJa = shootSpecialPropertyNameJa;
		this.shootSpecialPropertyNameEn = shootSpecialPropertyNameEn;
		this.shootSpecialPropertyNameEs = shootSpecialPropertyNameEs;
	}

	public Long getShootSpecialPropertyId() {
		return shootSpecialPropertyId;
	}

	public void setShootSpecialPropertyId(Long shootSpecialPropertyId) {
		this.shootSpecialPropertyId = shootSpecialPropertyId;
	}

	public String getShootSpecialPropertyNameJa() {
		return shootSpecialPropertyNameJa;
	}

	public void setShootSpecialPropertyNameJa(String shootSpecialPropertyNameJa) {
		this.shootSpecialPropertyNameJa = shootSpecialPropertyNameJa;
	}

	public String getShootSpecialPropertyNameEn() {
		return shootSpecialPropertyNameEn;
	}

	public void setShootSpecialPropertyNameEn(String shootSpecialPropertyNameEn) {
		this.shootSpecialPropertyNameEn = shootSpecialPropertyNameEn;
	}

	public String getShootSpecialPropertyNameEs() {
		return shootSpecialPropertyNameEs;
	}

	public void setShootSpecialPropertyNameEs(String shootSpecialPropertyNameEs) {
		this.shootSpecialPropertyNameEs = shootSpecialPropertyNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shootSpecialPropertyId, shootSpecialPropertyNameEn, shootSpecialPropertyNameEs,
				shootSpecialPropertyNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShootSpecialProperty other = (ShootSpecialProperty) obj;
		return Objects.equals(shootSpecialPropertyId, other.shootSpecialPropertyId)
				&& Objects.equals(shootSpecialPropertyNameEn, other.shootSpecialPropertyNameEn)
				&& Objects.equals(shootSpecialPropertyNameEs, other.shootSpecialPropertyNameEs)
				&& Objects.equals(shootSpecialPropertyNameJa, other.shootSpecialPropertyNameJa);
	}

	@Override
	public String toString() {
		return "ShootSpecialProperty [shootSpecialPropertyId=" + shootSpecialPropertyId
				+ ", shootSpecialPropertyNameJa=" + shootSpecialPropertyNameJa + ", shootSpecialPropertyNameEn="
				+ shootSpecialPropertyNameEn + ", shootSpecialPropertyNameEs=" + shootSpecialPropertyNameEs + "]";
	}

}
