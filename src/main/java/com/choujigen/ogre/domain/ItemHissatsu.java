package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_hissatsu")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class ItemHissatsu extends Item {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hissatsu_type_id", referencedColumnName = "hissatsu_type_id")
	private HissatsuType hissatsuType;

	@OneToMany(mappedBy = "itemHissatsu", fetch = FetchType.LAZY)
	private List<HissatsuEvolves> HissatsuEvolves;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_limited_by_gender", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "gender_id"))
	private List<Gender> restricGender;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_constrained_by_body_type", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "body_type_id"))
	private List<BodyType> restricBodyType;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_available_for_positi", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "positi_id"))
	private List<Positi> restricPositi;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_designed_for_attri", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "attri_id"))
	private List<Attri> restricAttriUser;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_helped_by_attri", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "attri_id"))
	private List<Attri> restricAttriHelper;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_combined_with_hissatsu", joinColumns = @JoinColumn(name = "item_hissatsu_id_base"), inverseJoinColumns = @JoinColumn(name = "item_hissatsu_id_combined"))
	private List<ItemHissatsu> restricHissatsu;

	@ManyToMany(mappedBy = "restricHissatsu", fetch = FetchType.LAZY)
	private List<ItemHissatsu> itemHissatsuRestric;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hissatsu_evokes_attri", joinColumns = @JoinColumn(name = "item_hissatsu_id"), inverseJoinColumns = @JoinColumn(name = "attri_id"))
	private List<Attri> attri;
	
	@OneToMany(mappedBy = "itemHissatsu", fetch = FetchType.LAZY)
	private List<PlayerLearnsHissatsu> playerLearnsHissatsu;

	public ItemHissatsu() {
	}

	public ItemHissatsu(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, HissatsuType hissatsuType) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.hissatsuType = hissatsuType;
	}

	public HissatsuType getHissatsuType() {
		return hissatsuType;
	}

	public void setHissatsuType(HissatsuType hissatsuType) {
		this.hissatsuType = hissatsuType;
	}

	public List<HissatsuEvolves> getHissatsuEvolves() {
		return HissatsuEvolves;
	}

	public void setHissatsuEvolves(List<HissatsuEvolves> hissatsuEvolves) {
		HissatsuEvolves = hissatsuEvolves;
	}

	public List<Gender> getRestricGender() {
		return restricGender;
	}

	public void setRestricGender(List<Gender> restricGender) {
		this.restricGender = restricGender;
	}

	public List<BodyType> getRestricBodyType() {
		return restricBodyType;
	}

	public void setRestricBodyType(List<BodyType> restricBodyType) {
		this.restricBodyType = restricBodyType;
	}

	public List<Positi> getRestricPositi() {
		return restricPositi;
	}

	public void setRestricPositi(List<Positi> restricPositi) {
		this.restricPositi = restricPositi;
	}

	public List<Attri> getRestricAttriUser() {
		return restricAttriUser;
	}

	public void setRestricAttriUser(List<Attri> restricAttriUser) {
		this.restricAttriUser = restricAttriUser;
	}

	public List<Attri> getRestricAttriHelper() {
		return restricAttriHelper;
	}

	public void setRestricAttriHelper(List<Attri> restricAttriHelper) {
		this.restricAttriHelper = restricAttriHelper;
	}

	public List<ItemHissatsu> getRestricHissatsu() {
		return restricHissatsu;
	}

	public void setRestricHissatsu(List<ItemHissatsu> restricHissatsu) {
		this.restricHissatsu = restricHissatsu;
	}

	public List<ItemHissatsu> getItemHissatsuRestric() {
		return itemHissatsuRestric;
	}

	public void setItemHissatsuRestric(List<ItemHissatsu> itemHissatsuRestric) {
		this.itemHissatsuRestric = itemHissatsuRestric;
	}

	public List<Attri> getAttri() {
		return attri;
	}

	public void setAttri(List<Attri> attri) {
		this.attri = attri;
	}

	public List<PlayerLearnsHissatsu> getPlayerLearnsHissatsu() {
		return playerLearnsHissatsu;
	}

	public void setPlayerLearnsHissatsu(List<PlayerLearnsHissatsu> playerLearnsHissatsu) {
		this.playerLearnsHissatsu = playerLearnsHissatsu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hissatsuType);
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
		ItemHissatsu other = (ItemHissatsu) obj;
		return Objects.equals(hissatsuType, other.hissatsuType);
	}

	@Override
	public String toString() {
		return "ItemHissatsu [hissatsuType=" + hissatsuType + "]";
	}

}
