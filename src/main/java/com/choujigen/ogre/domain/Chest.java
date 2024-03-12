package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chest")
public class Chest {
	@Column(name = "chest_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long chestId;

	@Column(name = "chest_hint_ja")
	private String chestHintJa;

	@Column(name = "chest_hint_en")
	private String chestHintEn;

	@Column(name = "chest_hint_es")
	private String chestHintEs;

	@ManyToOne
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
	private Zone zone;

	@ManyToOne
	@JoinColumn(name = "item_id", referencedColumnName = "item_id")
	private Item item;

	public Chest() {
	}

	public Chest(Long chestId, String chestHintJa, String chestHintEn, String chestHintEs, Zone zone, Item item) {
		super();
		this.chestId = chestId;
		this.chestHintJa = chestHintJa;
		this.chestHintEn = chestHintEn;
		this.chestHintEs = chestHintEs;
		this.zone = zone;
		this.item = item;
	}

	public String getHintByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.chestHintJa;
		case "en":
			return this.chestHintEn;
		case "es":
			return this.chestHintEs;
		default:
			return this.chestHintEn;
		}
	}

	public Long getChestId() {
		return chestId;
	}

	public void setChestId(Long chestId) {
		this.chestId = chestId;
	}

	public String getChestHintJa() {
		return chestHintJa;
	}

	public void setChestHintJa(String chestHintJa) {
		this.chestHintJa = chestHintJa;
	}

	public String getChestHintEn() {
		return chestHintEn;
	}

	public void setChestHintEn(String chestHintEn) {
		this.chestHintEn = chestHintEn;
	}

	public String getChestHintEs() {
		return chestHintEs;
	}

	public void setChestHintEs(String chestHintEs) {
		this.chestHintEs = chestHintEs;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chestHintEn, chestHintEs, chestHintJa, chestId, item, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chest other = (Chest) obj;
		return Objects.equals(chestHintEn, other.chestHintEn) && Objects.equals(chestHintEs, other.chestHintEs)
				&& Objects.equals(chestHintJa, other.chestHintJa) && Objects.equals(chestId, other.chestId)
				&& Objects.equals(item, other.item) && Objects.equals(zone, other.zone);
	}

	@Override
	public String toString() {
		return "Chest [chestId=" + chestId + ", chestHintJa=" + chestHintJa + ", chestHintEn=" + chestHintEn
				+ ", chestHintEs=" + chestHintEs + ", zone=" + zone + ", item=" + item + "]";
	}

}
