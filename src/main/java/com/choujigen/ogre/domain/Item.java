package com.choujigen.ogre.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Column(name = "item_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemId;
	@Column(name = "item_name_ja")
	private String itemNameJa;
	@Column(name = "item_name_en")
	private String itemNameEn;
	@Column(name = "item_name_es")
	private String itemNameEs;
	@Column(name = "item_price_buy")
	private Long itemPriceBuy;
	@Column(name = "item_price_sell")
	private Long itemPriceSell;
	@Column(name = "item_type_id")
	private Long itemTypeId;
}
