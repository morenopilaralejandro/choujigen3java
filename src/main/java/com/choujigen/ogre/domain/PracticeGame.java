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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "practice_game")
public class PracticeGame {
	@Column(name = "practice_game_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long practiceGameId;
	@Column(name = "practice_game_order")
	private Long practiceGameOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_path_id", referencedColumnName = "route_path_id")
	private RoutePath routePath;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
	private Team team;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "practice_game_condition_id", referencedColumnName = "practice_game_condition_id")
	private PracticeGameCondition practiceGameCondition;
	
	@OneToMany(mappedBy = "practiceGame", fetch = FetchType.LAZY)
	private List<ItemVscard> itemVscard;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "practice_game_initiated_by_npc", joinColumns = @JoinColumn(name = "practice_game_id"), inverseJoinColumns = @JoinColumn(name = "npc_id"))
	private List<Npc> npc;
	
	@OneToMany(mappedBy = "practiceGame", fetch = FetchType.LAZY)
	private List<PracticeGameDropItem> practiceGameDropItem;

	public PracticeGame() {
	}

	public PracticeGame(Long practiceGameId, Long practiceGameOrder, RoutePath routePath, Team team,
			PracticeGameCondition practiceGameCondition) {
		super();
		this.practiceGameId = practiceGameId;
		this.practiceGameOrder = practiceGameOrder;
		this.routePath = routePath;
		this.team = team;
		this.practiceGameCondition = practiceGameCondition;
	}

	public Long getPracticeGameId() {
		return practiceGameId;
	}

	public void setPracticeGameId(Long practiceGameId) {
		this.practiceGameId = practiceGameId;
	}

	public Long getPracticeGameOrder() {
		return practiceGameOrder;
	}

	public void setPracticeGameOrder(Long practiceGameOrder) {
		this.practiceGameOrder = practiceGameOrder;
	}

	public RoutePath getRoutePath() {
		return routePath;
	}

	public void setRoutePath(RoutePath routePath) {
		this.routePath = routePath;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public PracticeGameCondition getPracticeGameCondition() {
		return practiceGameCondition;
	}

	public void setPracticeGameCondition(PracticeGameCondition practiceGameCondition) {
		this.practiceGameCondition = practiceGameCondition;
	}

	public List<ItemVscard> getItemVscard() {
		return itemVscard;
	}

	public void setItemVscard(List<ItemVscard> itemVscard) {
		this.itemVscard = itemVscard;
	}

	public List<Npc> getNpc() {
		return npc;
	}

	public void setNpc(List<Npc> npc) {
		this.npc = npc;
	}

	public List<PracticeGameDropItem> getPracticeGameDropItem() {
		return practiceGameDropItem;
	}

	public void setPracticeGameDropItem(List<PracticeGameDropItem> practiceGameDropItem) {
		this.practiceGameDropItem = practiceGameDropItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(practiceGameCondition, practiceGameId, practiceGameOrder, routePath, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PracticeGame other = (PracticeGame) obj;
		return Objects.equals(practiceGameCondition, other.practiceGameCondition)
				&& Objects.equals(practiceGameId, other.practiceGameId)
				&& Objects.equals(practiceGameOrder, other.practiceGameOrder)
				&& Objects.equals(routePath, other.routePath) && Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "PracticeGame [practiceGameId=" + practiceGameId + ", practiceGameOrder=" + practiceGameOrder
				+ ", routePath=" + routePath + ", team=" + team + ", practiceGameCondition=" + practiceGameCondition
				+ "]";
	}

}
