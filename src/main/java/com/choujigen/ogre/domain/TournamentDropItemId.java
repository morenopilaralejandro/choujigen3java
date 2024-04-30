package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TournamentDropItemId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "tournament_rank_id")
	private Long tournamentRankId;

	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "amount")
	private Long amountId;

	public TournamentDropItemId() {

	}

	public TournamentDropItemId(Long tournamentRankId, Long itemId, Long amountId) {
		super();
		this.tournamentRankId = tournamentRankId;
		this.itemId = itemId;
		this.amountId = amountId;
	}

	public Long getTournamentRankId() {
		return tournamentRankId;
	}

	public void setTournamentRankId(Long tournamentRankId) {
		this.tournamentRankId = tournamentRankId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getAmountId() {
		return amountId;
	}

	public void setAmountId(Long amountId) {
		this.amountId = amountId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountId, itemId, tournamentRankId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentDropItemId other = (TournamentDropItemId) obj;
		return Objects.equals(amountId, other.amountId) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(tournamentRankId, other.tournamentRankId);
	}

	@Override
	public String toString() {
		return "TournamentDropItemId [tournamentRankId=" + tournamentRankId + ", itemId=" + itemId + ", amountId="
				+ amountId + "]";
	}

}
