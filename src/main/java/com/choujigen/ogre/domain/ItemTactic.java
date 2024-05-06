package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_tactic")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_tactic_id")
public class ItemTactic extends Item {
	@Column(name = "item_tactic_ttp")
	private Long itemTacticTtp;

	@Column(name = "item_tactic_power")
	private Long itemTacticPower;

	@Column(name = "item_tactic_effect_ja")
	private String itemTacticEffectJa;

	@Column(name = "item_tactic_effect_en")
	private String itemTacticEffectEn;

	@Column(name = "item_tactic_effect_es")
	private String itemTacticEffectEs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tactic_type_id", referencedColumnName = "tactic_type_id")
	private TacticType tacticType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tactic_side_id", referencedColumnName = "tactic_side_id")
	private TacticSide tacticSide;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tactic_executed_by_team", joinColumns = @JoinColumn(name = "item_tactic_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
	private List<Team> teams;

	public ItemTactic() {
	}

	public ItemTactic(Long itemTacticTtp, Long itemTacticPower, String itemTacticEffectJa, String itemTacticEffectEn,
			String itemTacticEffectEs, TacticType tacticType, TacticSide tacticSide) {
		super();
		this.itemTacticTtp = itemTacticTtp;
		this.itemTacticPower = itemTacticPower;
		this.itemTacticEffectJa = itemTacticEffectJa;
		this.itemTacticEffectEn = itemTacticEffectEn;
		this.itemTacticEffectEs = itemTacticEffectEs;
		this.tacticType = tacticType;
		this.tacticSide = tacticSide;
	}

	public String getEffectByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.itemTacticEffectJa;
		case "en":
			return this.itemTacticEffectEn;
		case "es":
			return this.itemTacticEffectEs;
		default:
			return this.itemTacticEffectEn;
		}
	}

	public Long getItemTacticTtp() {
		return itemTacticTtp;
	}

	public void setItemTacticTtp(Long itemTacticTtp) {
		this.itemTacticTtp = itemTacticTtp;
	}

	public Long getItemTacticPower() {
		return itemTacticPower;
	}

	public void setItemTacticPower(Long itemTacticPower) {
		this.itemTacticPower = itemTacticPower;
	}

	public String getItemTacticEffectJa() {
		return itemTacticEffectJa;
	}

	public void setItemTacticEffectJa(String itemTacticEffectJa) {
		this.itemTacticEffectJa = itemTacticEffectJa;
	}

	public String getItemTacticEffectEn() {
		return itemTacticEffectEn;
	}

	public void setItemTacticEffectEn(String itemTacticEffectEn) {
		this.itemTacticEffectEn = itemTacticEffectEn;
	}

	public String getItemTacticEffectEs() {
		return itemTacticEffectEs;
	}

	public void setItemTacticEffectEs(String itemTacticEffectEs) {
		this.itemTacticEffectEs = itemTacticEffectEs;
	}

	public TacticType getTacticType() {
		return tacticType;
	}

	public void setTacticType(TacticType tacticType) {
		this.tacticType = tacticType;
	}

	public TacticSide getTacticSide() {
		return tacticSide;
	}

	public void setTacticSide(TacticSide tacticSide) {
		this.tacticSide = tacticSide;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemTacticEffectEn, itemTacticEffectEs, itemTacticEffectJa,
				itemTacticPower, itemTacticTtp, tacticSide, tacticType);
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
		ItemTactic other = (ItemTactic) obj;
		return Objects.equals(itemTacticEffectEn, other.itemTacticEffectEn)
				&& Objects.equals(itemTacticEffectEs, other.itemTacticEffectEs)
				&& Objects.equals(itemTacticEffectJa, other.itemTacticEffectJa)
				&& Objects.equals(itemTacticPower, other.itemTacticPower)
				&& Objects.equals(itemTacticTtp, other.itemTacticTtp) && Objects.equals(tacticSide, other.tacticSide)
				&& Objects.equals(tacticType, other.tacticType);
	}

	@Override
	public String toString() {
		return "ItemTactic [itemTacticTtp=" + itemTacticTtp + ", itemTacticPower=" + itemTacticPower
				+ ", itemTacticEffectJa=" + itemTacticEffectJa + ", itemTacticEffectEn=" + itemTacticEffectEn
				+ ", itemTacticEffectEs=" + itemTacticEffectEs + ", tacticType=" + tacticType + ", tacticSide="
				+ tacticSide + "]";
	}

}
