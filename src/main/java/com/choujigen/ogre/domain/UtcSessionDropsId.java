package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UtcSessionDropsId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "utc_session_id")
	private Long utcSessionId;

	@Column(name = "item_id")
	private Long itemId;

	public UtcSessionDropsId() {

	}

	public UtcSessionDropsId(Long utcSessionId, Long itemId) {
		super();
		this.utcSessionId = utcSessionId;
		this.itemId = itemId;
	}

	public Long getUtcSessionId() {
		return utcSessionId;
	}

	public void setUtcSessionId(Long utcSessionId) {
		this.utcSessionId = utcSessionId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, utcSessionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtcSessionDropsId other = (UtcSessionDropsId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(utcSessionId, other.utcSessionId);
	}

	@Override
	public String toString() {
		return "UtcSessionDropsId [utcSessionId=" + utcSessionId + ", itemId=" + itemId + "]";
	}

}
