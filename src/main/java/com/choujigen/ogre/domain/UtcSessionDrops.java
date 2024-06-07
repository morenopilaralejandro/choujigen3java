package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "utc_session_drops")
public class UtcSessionDrops {
	@EmbeddedId
	private UtcSessionDropsId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("utcSessionId")
	@JoinColumn(name = "utc_session_id")
	private UtcSession utcSession;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utc_drop_type_id", referencedColumnName = "utc_drop_type_id")
	private UtcDropType utcDropType;

	@Column(name = "drop_rate")
	private Long dropRate;

	public UtcSessionDrops() {
	}

	public UtcSessionDrops(UtcSessionDropsId id, UtcSession utcSession, Item item, UtcDropType utcDropType,
			Long dropRate) {
		super();
		this.id = id;
		this.utcSession = utcSession;
		this.item = item;
		this.utcDropType = utcDropType;
		this.dropRate = dropRate;
	}
	
	public UtcSessionDrops(Long utcSessionId, Long itemId, UtcSession utcSession, Item item, UtcDropType utcDropType,
			Long dropRate) {
		super();
		this.id = new UtcSessionDropsId(utcSessionId, itemId);
		this.utcSession = utcSession;
		this.item = item;
		this.utcDropType = utcDropType;
		this.dropRate = dropRate;
	}

	public UtcSessionDropsId getId() {
		return id;
	}

	public void setId(UtcSessionDropsId id) {
		this.id = id;
	}

	public UtcSession getUtcSession() {
		return utcSession;
	}

	public void setUtcSession(UtcSession utcSession) {
		this.utcSession = utcSession;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public UtcDropType getUtcDropType() {
		return utcDropType;
	}

	public void setUtcDropType(UtcDropType utcDropType) {
		this.utcDropType = utcDropType;
	}

	public Long getDropRate() {
		return dropRate;
	}

	public void setDropRate(Long dropRate) {
		this.dropRate = dropRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dropRate, id, item, utcDropType, utcSession);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtcSessionDrops other = (UtcSessionDrops) obj;
		return Objects.equals(dropRate, other.dropRate) && Objects.equals(id, other.id)
				&& Objects.equals(item, other.item) && Objects.equals(utcDropType, other.utcDropType)
				&& Objects.equals(utcSession, other.utcSession);
	}

	@Override
	public String toString() {
		return "UtcSessionDrops [id=" + id + ", utcSession=" + utcSession + ", item=" + item + ", utcDropType="
				+ utcDropType + ", dropRate=" + dropRate + "]";
	}
	
}
