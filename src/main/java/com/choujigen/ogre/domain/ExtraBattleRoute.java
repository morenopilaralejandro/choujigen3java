package com.choujigen.ogre.domain;

import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "extra_battle_route")
public class ExtraBattleRoute {
	@Column(name = "extra_battle_route_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long extraBattleRouteId;
	@Column(name = "extra_battle_route_name_ja")
	private String extraBattleRouteNameJa;
	@Column(name = "extra_battle_route_name_en")
	private String extraBattleRouteNameEn;
	@Column(name = "extra_battle_route_name_es")
	private String extraBattleRouteNameEs;

	@ManyToOne
	@JoinColumn(name = "npc_id", referencedColumnName = "npc_id")
	private Npc npc;
	
	@OneToMany(mappedBy = "extraBattleRoute")
	private List<RoutePath> paths;

	public ExtraBattleRoute() {
	}

	public ExtraBattleRoute(Long extraBattleRouteId, String extraBattleRouteNameJa, String extraBattleRouteNameEn,
			String extraBattleRouteNameEs, Npc npc) {
		super();
		this.extraBattleRouteId = extraBattleRouteId;
		this.extraBattleRouteNameJa = extraBattleRouteNameJa;
		this.extraBattleRouteNameEn = extraBattleRouteNameEn;
		this.extraBattleRouteNameEs = extraBattleRouteNameEs;
		this.npc = npc;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.extraBattleRouteNameJa;
		case "en":
			return this.extraBattleRouteNameEn;
		case "es":
			return this.extraBattleRouteNameEs;
		default:
			return this.extraBattleRouteNameEn;
		}
	}

	public Long getExtraBattleRouteId() {
		return extraBattleRouteId;
	}

	public void setExtraBattleRouteId(Long extraBattleRouteId) {
		this.extraBattleRouteId = extraBattleRouteId;
	}

	public String getExtraBattleRouteNameJa() {
		return extraBattleRouteNameJa;
	}

	public void setExtraBattleRouteNameJa(String extraBattleRouteNameJa) {
		this.extraBattleRouteNameJa = extraBattleRouteNameJa;
	}

	public String getExtraBattleRouteNameEn() {
		return extraBattleRouteNameEn;
	}

	public void setExtraBattleRouteNameEn(String extraBattleRouteNameEn) {
		this.extraBattleRouteNameEn = extraBattleRouteNameEn;
	}

	public String getExtraBattleRouteNameEs() {
		return extraBattleRouteNameEs;
	}

	public void setExtraBattleRouteNameEs(String extraBattleRouteNameEs) {
		this.extraBattleRouteNameEs = extraBattleRouteNameEs;
	}

	public Npc getNpc() {
		return npc;
	}

	public void setNpc(Npc npc) {
		this.npc = npc;
	}

	public List<RoutePath> getPaths() {
		return paths;
	}

	public void setPaths(List<RoutePath> paths) {
		this.paths = paths;
	}

	@Override
	public int hashCode() {
		return Objects.hash(extraBattleRouteId, extraBattleRouteNameEn, extraBattleRouteNameEs, extraBattleRouteNameJa,
				npc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtraBattleRoute other = (ExtraBattleRoute) obj;
		return Objects.equals(extraBattleRouteId, other.extraBattleRouteId)
				&& Objects.equals(extraBattleRouteNameEn, other.extraBattleRouteNameEn)
				&& Objects.equals(extraBattleRouteNameEs, other.extraBattleRouteNameEs)
				&& Objects.equals(extraBattleRouteNameJa, other.extraBattleRouteNameJa)
				&& Objects.equals(npc, other.npc);
	}

	@Override
	public String toString() {
		return "ExtraBattleRoute [extraBattleRouteId=" + extraBattleRouteId + ", extraBattleRouteNameJa="
				+ extraBattleRouteNameJa + ", extraBattleRouteNameEn=" + extraBattleRouteNameEn
				+ ", extraBattleRouteNameEs=" + extraBattleRouteNameEs + ", npc=" + npc + "]";
	}

}
