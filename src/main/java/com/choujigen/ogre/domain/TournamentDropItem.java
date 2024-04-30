package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament_rank_may_drop_item")
public class TournamentDropItem {
	@EmbeddedId
	private TournamentDropItemId id;

	@ManyToOne
	@MapsId("tournamentRankId")
	@JoinColumn(name = "tournament_rank_id")
	private TournamentRank tournamentRank;

	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "selection_rate")
	private Long selectionRate;

	@Column(name = "drop_rate")
	private Long dropRate;

	@Column(name = "no_recover_rate")
	private Long noRecoverRate;

	public TournamentDropItem() {
	}

	public TournamentDropItem(TournamentDropItemId id, TournamentRank tournamentRank, Item item, Long selectionRate,
			Long dropRate, Long noRecoverRate) {
		super();
		this.id = id;
		this.tournamentRank = tournamentRank;
		this.item = item;
		this.selectionRate = selectionRate;
		this.dropRate = dropRate;
		this.noRecoverRate = noRecoverRate;
	}

	public TournamentDropItem(Long tournamentRankId, Long itemId, Long amountId, TournamentRank tournamentRank,
			Item item, Long selectionRate, Long dropRate, Long noRecoverRate) {
		super();
		this.id = new TournamentDropItemId(tournamentRankId, itemId, amountId);
		this.tournamentRank = tournamentRank;
		this.item = item;
		this.selectionRate = selectionRate;
		this.dropRate = dropRate;
		this.noRecoverRate = noRecoverRate;
	}

	public TournamentDropItemId getId() {
		return id;
	}

	public void setId(TournamentDropItemId id) {
		this.id = id;
	}

	public TournamentRank getTournamentRank() {
		return tournamentRank;
	}

	public void setTournamentRank(TournamentRank tournamentRank) {
		this.tournamentRank = tournamentRank;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getSelectionRate() {
		return selectionRate;
	}

	public void setSelectionRate(Long selectionRate) {
		this.selectionRate = selectionRate;
	}

	public Long getDropRate() {
		return dropRate;
	}

	public void setDropRate(Long dropRate) {
		this.dropRate = dropRate;
	}

	public Long getNoRecoverRate() {
		return noRecoverRate;
	}

	public void setNoRecoverRate(Long noRecoverRate) {
		this.noRecoverRate = noRecoverRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dropRate, id, item, noRecoverRate, selectionRate, tournamentRank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentDropItem other = (TournamentDropItem) obj;
		return Objects.equals(dropRate, other.dropRate) && Objects.equals(id, other.id)
				&& Objects.equals(item, other.item) && Objects.equals(noRecoverRate, other.noRecoverRate)
				&& Objects.equals(selectionRate, other.selectionRate)
				&& Objects.equals(tournamentRank, other.tournamentRank);
	}

	@Override
	public String toString() {
		return "TournamentDropItem [id=" + id + ", tournamentRank=" + tournamentRank + ", item=" + item
				+ ", selectionRate=" + selectionRate + ", dropRate=" + dropRate + ", noRecoverRate=" + noRecoverRate
				+ "]";
	}

}
