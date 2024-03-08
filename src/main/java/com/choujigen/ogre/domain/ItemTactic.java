package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
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

	@Column(name = "item_tactic_effect_ja")
	private String itemTacticEffectJa;

	@Column(name = "item_tactic_effect_en")
	private String itemTacticEffectEn;

	@Column(name = "item_tactic_effect_es")
	private String itemTacticEffectEs;

	@ManyToOne
	@JoinColumn(name = "tactic_type_id", referencedColumnName = "tactic_type_id")
	private TacticType tacticType;

	@ManyToOne
	@JoinColumn(name = "tactic_side_id", referencedColumnName = "tactic_side_id")
	private TacticSide tacticSide;

	public ItemTactic() {
	}

	public ItemTactic(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, Long itemTacticTtp, String itemTacticEffectJa,
			String itemTacticEffectEn, String itemTacticEffectEs, TacticType tacticType, TacticSide tacticSide) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.itemTacticTtp = itemTacticTtp;
		this.itemTacticEffectJa = itemTacticEffectJa;
		this.itemTacticEffectEn = itemTacticEffectEn;
		this.itemTacticEffectEs = itemTacticEffectEs;
		this.tacticType = tacticType;
		this.tacticSide = tacticSide;
	}

	public Long getItemTacticTtp() {
		return itemTacticTtp;
	}

	public void setItemTacticTtp(Long itemTacticTtp) {
		this.itemTacticTtp = itemTacticTtp;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemTacticEffectEn, itemTacticEffectEs, itemTacticEffectJa,
				itemTacticTtp, tacticSide, tacticType);
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
				&& Objects.equals(itemTacticTtp, other.itemTacticTtp) && Objects.equals(tacticSide, other.tacticSide)
				&& Objects.equals(tacticType, other.tacticType);
	}

	@Override
	public String toString() {
		return "ItemTactic [itemTacticTtp=" + itemTacticTtp + ", itemTacticEffectJa=" + itemTacticEffectJa
				+ ", itemTacticEffectEn=" + itemTacticEffectEn + ", itemTacticEffectEs=" + itemTacticEffectEs
				+ ", tacticType=" + tacticType + ", tacticSide=" + tacticSide + "]";
	}

}
