package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_type")
public class EquipmentType {
	@Column(name = "equipment_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long equipmentTypeId;
	@Column(name = "equipment_type_name_ja")
	private String equipmentTypeNameJa;
	@Column(name = "equipment_type_name_en")
	private String equipmentTypeNameEn;
	@Column(name = "equipment_type_name_es")
	private String equipmentTypeNameEs;

	public EquipmentType() {
	}

	public EquipmentType(Long equipmentTypeId, String equipmentTypeNameJa, String equipmentTypeNameEn, String equipmentTypeNameEs) {
		super();
		this.equipmentTypeId = equipmentTypeId;
		this.equipmentTypeNameJa = equipmentTypeNameJa;
		this.equipmentTypeNameEn = equipmentTypeNameEn;
		this.equipmentTypeNameEs = equipmentTypeNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getEquipmentTypeNameJa();
		case "en":
			return this.getEquipmentTypeNameEn();
		case "es":
			return this.getEquipmentTypeNameEs();
		default:
			return this.getEquipmentTypeNameEn();
		}
	}

	public Long getEquipmentTypeId() {
		return equipmentTypeId;
	}

	public void setEquipmentTypeId(Long equipmentTypeId) {
		this.equipmentTypeId = equipmentTypeId;
	}

	public String getEquipmentTypeNameJa() {
		return equipmentTypeNameJa;
	}

	public void setEquipmentTypeNameJa(String equipmentTypeNameJa) {
		this.equipmentTypeNameJa = equipmentTypeNameJa;
	}

	public String getEquipmentTypeNameEn() {
		return equipmentTypeNameEn;
	}

	public void setEquipmentTypeNameEn(String equipmentTypeNameEn) {
		this.equipmentTypeNameEn = equipmentTypeNameEn;
	}

	public String getEquipmentTypeNameEs() {
		return equipmentTypeNameEs;
	}

	public void setEquipmentTypeNameEs(String equipmentTypeNameEs) {
		this.equipmentTypeNameEs = equipmentTypeNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipmentTypeId, equipmentTypeNameEn, equipmentTypeNameEs, equipmentTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentType other = (EquipmentType) obj;
		return Objects.equals(equipmentTypeId, other.equipmentTypeId) && Objects.equals(equipmentTypeNameEn, other.equipmentTypeNameEn)
				&& Objects.equals(equipmentTypeNameEs, other.equipmentTypeNameEs)
				&& Objects.equals(equipmentTypeNameJa, other.equipmentTypeNameJa);
	}

	@Override
	public String toString() {
		return "EquipmentType [equipmentTypeId=" + equipmentTypeId + ", equipmentTypeNameJa=" + equipmentTypeNameJa + ", equipmentTypeNameEn="
				+ equipmentTypeNameEn + ", equipmentTypeNameEs=" + equipmentTypeNameEs + "]";
	}
}
