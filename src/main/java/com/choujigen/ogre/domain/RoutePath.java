package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "route_path")
public class RoutePath {
	@Column(name = "route_path_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long routePathId;
	@Column(name = "route_path_order")
	private Long routePathOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "extra_battle_route_id", referencedColumnName = "extra_battle_route_id")
	private ExtraBattleRoute extraBattleRoute;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reward_n", referencedColumnName = "item_id")
	private Item rewardN;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reward_s", referencedColumnName = "item_id")
	private Item rewardS;
	
	@OneToMany(mappedBy = "routePath", fetch = FetchType.LAZY)
	private List<PracticeGame> practiceGames;

	public RoutePath() {
	}

	public RoutePath(Long routePathId, Long routePathOrder, ExtraBattleRoute extraBattleRoute, Item rewardN,
			Item rewardS) {
		super();
		this.routePathId = routePathId;
		this.routePathOrder = routePathOrder;
		this.extraBattleRoute = extraBattleRoute;
		this.rewardN = rewardN;
		this.rewardS = rewardS;
	}

	public Long getRoutePathId() {
		return routePathId;
	}

	public void setRoutePathId(Long routePathId) {
		this.routePathId = routePathId;
	}

	public Long getRoutePathOrder() {
		return routePathOrder;
	}

	public void setRoutePathOrder(Long routePathOrder) {
		this.routePathOrder = routePathOrder;
	}

	public ExtraBattleRoute getExtraBattleRoute() {
		return extraBattleRoute;
	}

	public void setExtraBattleRoute(ExtraBattleRoute extraBattleRoute) {
		this.extraBattleRoute = extraBattleRoute;
	}

	public Item getRewardN() {
		return rewardN;
	}

	public void setRewardN(Item rewardN) {
		this.rewardN = rewardN;
	}

	public Item getRewardS() {
		return rewardS;
	}

	public void setRewardS(Item rewardS) {
		this.rewardS = rewardS;
	}

	public List<PracticeGame> getPracticeGames() {
		return practiceGames;
	}

	public void setPracticeGames(List<PracticeGame> practiceGames) {
		this.practiceGames = practiceGames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(extraBattleRoute, rewardN, rewardS, routePathId, routePathOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoutePath other = (RoutePath) obj;
		return Objects.equals(extraBattleRoute, other.extraBattleRoute) && Objects.equals(rewardN, other.rewardN)
				&& Objects.equals(rewardS, other.rewardS) && Objects.equals(routePathId, other.routePathId)
				&& Objects.equals(routePathOrder, other.routePathOrder);
	}

	@Override
	public String toString() {
		return "RoutePath [routePathId=" + routePathId + ", routePathOrder=" + routePathOrder + ", extraBattleRoute="
				+ extraBattleRoute + ", rewardN=" + rewardN + ", rewardS=" + rewardS + "]";
	}

}
