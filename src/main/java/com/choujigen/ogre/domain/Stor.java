package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stor")
public class Stor {
	@Column(name = "stor_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long storId;

	@ManyToOne
	@JoinColumn(name = "stor_type_id", referencedColumnName = "stor_type_id")
	private StorType storType;

	@ManyToOne
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
	private Zone zone;
	
	@ManyToMany(mappedBy = "stors")
	private List<Item> items;

	public Stor() {}
	public Stor(Long storId, StorType storType, Zone zone) {
		super();
		this.storId = storId;
		this.storType = storType;
		this.zone = zone;
	}
	
	public String getDisplayName() {
		String res = "";
		ZoneBuildingFloor auxBuildingFloor;
		
		res += this.getStorType().getNameByLang();
		/*sweet shop*/
		if (this.getStorType().getStorTypeId().intValue() != 7) {
			res += " - ";
			if (this.getZone().getZoneType().getZoneTypeId().intValue() == 5) {
				auxBuildingFloor = (ZoneBuildingFloor) this.getZone();
				res += auxBuildingFloor.getZoneBuilding().getNameByLang();
				res += " ";	
				res += auxBuildingFloor.getNameByLang();
			} else {
				res += this.getZone().getNameByLang();
			}
		}
		return res;
	}
	
	public String getHref() {
		String res = "/map/";
		res += this.getZone().getOuterId();
		res += "#stor";
		res += this.getStorId();
		return res;
	}

	public Long getStorId() {
		return storId;
	}

	public void setStorId(Long storId) {
		this.storId = storId;
	}

	public StorType getStorType() {
		return storType;
	}

	public void setStorType(StorType storType) {
		this.storType = storType;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public int hashCode() {
		return Objects.hash(storId, storType, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stor other = (Stor) obj;
		return Objects.equals(storId, other.storId) && Objects.equals(storType, other.storType)
				&& Objects.equals(zone, other.zone);
	}

	@Override
	public String toString() {
		return "Stor [storId=" + storId + ", storType=" + storType + ", zone=" + zone + "]";
	}

}
