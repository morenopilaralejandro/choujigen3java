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
@Table(name = "npc")
public class Npc {
	@Column(name = "npc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long npcId;
	
	@Column(name = "npc_name_ja")
	private String npcNameJa;
	
	@Column(name = "npc_name_En")
	private String npcNameEn;
	
	@ManyToOne
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
	private Zone zone;
	
	public Npc() {
	}

	public Npc(Long npcId, String npcNameJa, String npcNameEn, Zone zone) {
		super();
		this.npcId = npcId;
		this.npcNameJa = npcNameJa;
		this.npcNameEn = npcNameEn;
		this.zone = zone;
	}
	
	public String getHintByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.npcNameJa;
		default:
			return this.npcNameEn;
		}
	}

	public Long getNpcId() {
		return npcId;
	}

	public void setNpcId(Long npcId) {
		this.npcId = npcId;
	}

	public String getNpcNameJa() {
		return npcNameJa;
	}

	public void setNpcNameJa(String npcNameJa) {
		this.npcNameJa = npcNameJa;
	}

	public String getNpcNameEn() {
		return npcNameEn;
	}

	public void setNpcNameEn(String npcNameEn) {
		this.npcNameEn = npcNameEn;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(npcId, npcNameEn, npcNameJa, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Npc other = (Npc) obj;
		return Objects.equals(npcId, other.npcId) && Objects.equals(npcNameEn, other.npcNameEn)
				&& Objects.equals(npcNameJa, other.npcNameJa) && Objects.equals(zone, other.zone);
	}

	@Override
	public String toString() {
		return "Npc [npcId=" + npcId + ", npcNameJa=" + npcNameJa + ", npcNameEn=" + npcNameEn + ", zone=" + zone + "]";
	}

}
