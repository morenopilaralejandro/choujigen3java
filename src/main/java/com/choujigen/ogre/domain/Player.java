package com.choujigen.ogre.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

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
import jakarta.persistence.Transient;

@Entity
@Table(name = "player")
public class Player {
	@Column(name = "player_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long playerId;
	@Column(name = "player_name_ja")
	private String playerNameJa;
	@Column(name = "player_name_hiragana")
	private String playerNameHiragana;
	@Column(name = "player_name_kanji")
	private String playerNameKanji;
	@Column(name = "player_name_romanji")
	private String playerNameRomanji;
	@Column(name = "player_name_en")
	private String playerNameEn;
	@Column(name = "player_name_en_full")
	private String playerNameEnFull;
	@Column(name = "player_initial_lv")
	private String playerInitialLv;
	@Column(name = "player_gp_99")
	private Long playerGp99;
	@Column(name = "player_tp_99")
	private Long playerTp99;
	@Column(name = "player_kick_99")
	private Long playerKick99;
	@Column(name = "player_body_99")
	private Long playerBody99;
	@Column(name = "player_control_99")
	private Long playerControl99;
	@Column(name = "player_guard_99")
	private Long playerGuard99;
	@Column(name = "player_speed_99")
	private Long playerSpeed99;
	@Column(name = "player_stamina_99")
	private Long playerStamina99;
	@Column(name = "player_guts_99")
	private Long playerGuts99;
	@Column(name = "player_freedom_99")
	private Long playerFreedom99;
	@Transient
	private List<Long> playerStats;

	@ManyToOne
	@JoinColumn(name = "attri_id", referencedColumnName = "attri_id")
	private Attri attri;

	@ManyToOne
	@JoinColumn(name = "positi_id", referencedColumnName = "positi_id")
	private Positi positi;

	@ManyToOne
	@JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "body_type_id", referencedColumnName = "body_type_id")
	private BodyType bodyType;

	@ManyToOne
	@JoinColumn(name = "player_obtention_method_id", referencedColumnName = "player_obtention_method_id")
	private PlayerObtentionMethod playerObtentionMethod;

	@ManyToOne
	@JoinColumn(name = "original_version", referencedColumnName = "player_id")
	private Player originalVersion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "originalVersion")
	private List<Player> altVersion;

	@OneToMany(mappedBy = "player")
	private List<PlayerLearnsHissatsu> playerLearnsHissatsu;

	@ManyToMany
	@JoinTable(name = "player_has_recommended_slot_hissatsu", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "item_hissatsu_id"))
	private List<ItemHissatsu> playerRecommendedHissatsu;

	@ManyToMany
	@JoinTable(name = "player_has_recommended_gear_equipment", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "item_equipment_id"))
	private List<ItemEquipment> playerRecommendedEquipment;

	@ManyToMany
	@JoinTable(name = "player_has_recommended_routine_tm", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "training_method_id"))
	private List<TrainingMethod> playerRecommendedRoutine;

	@ManyToMany
	@JoinTable(name = "player_decrypted_with_passwd", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "passwd_id"))
	private List<Passwd> playerPasswd;

	@OneToMany(mappedBy = "player")
	private List<PlayerIsPartOfTeam> teams;

	@ManyToMany
	@JoinTable(name = "player_plays_during_story_team", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
	private List<Team> storyTeam;

	public Player() {
	}

	public Player(Long playerId, String playerNameJa, String playerNameHiragana, String playerNameKanji,
			String playerNameRomanji, String playerNameEn, String playerNameEnFull, String playerInitialLv,
			Long playerGp99, Long playerTp99, Long playerKick99, Long playerBody99, Long playerControl99,
			Long playerGuard99, Long playerSpeed99, Long playerStamina99, Long playerGuts99, Long playerFreedom99,
			Attri attri, Positi positi, Gender gender, BodyType bodyType, PlayerObtentionMethod playerObtentionMethod,
			Player originalVersion) {
		super();
		this.playerId = playerId;
		this.playerNameJa = playerNameJa;
		this.playerNameHiragana = playerNameHiragana;
		this.playerNameKanji = playerNameKanji;
		this.playerNameRomanji = playerNameRomanji;
		this.playerNameEn = playerNameEn;
		this.playerNameEnFull = playerNameEnFull;
		this.playerInitialLv = playerInitialLv;
		this.playerGp99 = playerGp99;
		this.playerTp99 = playerTp99;
		this.playerKick99 = playerKick99;
		this.playerBody99 = playerBody99;
		this.playerControl99 = playerControl99;
		this.playerGuard99 = playerGuard99;
		this.playerSpeed99 = playerSpeed99;
		this.playerStamina99 = playerStamina99;
		this.playerGuts99 = playerGuts99;
		this.playerFreedom99 = playerFreedom99;

		updatePlayerStats();

		this.attri = attri;
		this.positi = positi;
		this.gender = gender;
		this.bodyType = bodyType;
		this.playerObtentionMethod = playerObtentionMethod;
		this.originalVersion = originalVersion;
	}

	public String getPlayerNameRomanjiCapitalize() {
		return this.playerNameRomanji.substring(0, 1).toUpperCase() + this.playerNameRomanji.substring(1);
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.playerNameJa;
		default:
			return this.playerNameEn;
		}
	}
	
	public String[] getHiraganaSplited() {
		String[] splited = this.playerNameHiragana.split("\\s+");
		return splited;
	}
	
	public String[] getKanjiSplited() {
		if (!this.playerNameKanji.isEmpty()) {
			return this.playerNameKanji.split("\\s+");			
		}
		return null;
	}

	public void updatePlayerStats() {
		if (this.playerStats == null) {
			this.playerStats = new ArrayList<Long>();
		} else {
			this.playerStats.clear();
		}
		this.playerStats.add(playerGp99);
		this.playerStats.add(playerTp99);
		this.playerStats.add(playerKick99);
		this.playerStats.add(playerBody99);
		this.playerStats.add(playerControl99);
		this.playerStats.add(playerGuard99);
		this.playerStats.add(playerSpeed99);
		this.playerStats.add(playerStamina99);
		this.playerStats.add(playerGuts99);
		this.playerStats.add(playerFreedom99);
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerNameJa() {
		return playerNameJa;
	}

	public void setPlayerNameJa(String playerNameJa) {
		this.playerNameJa = playerNameJa;
	}

	public String getPlayerNameHiragana() {
		return playerNameHiragana;
	}

	public void setPlayerNameHiragana(String playerNameHiragana) {
		this.playerNameHiragana = playerNameHiragana;
	}

	public String getPlayerNameKanji() {
		return playerNameKanji;
	}

	public void setPlayerNameKanji(String playerNameKanji) {
		this.playerNameKanji = playerNameKanji;
	}

	public String getPlayerNameRomanji() {
		return playerNameRomanji;
	}

	public void setPlayerNameRomanji(String playerNameRomanji) {
		this.playerNameRomanji = playerNameRomanji;
	}

	public String getPlayerNameEn() {
		return playerNameEn;
	}

	public void setPlayerNameEn(String playerNameEn) {
		this.playerNameEn = playerNameEn;
	}

	public String getPlayerNameEnFull() {
		return playerNameEnFull;
	}

	public void setPlayerNameEnFull(String playerNameEnFull) {
		this.playerNameEnFull = playerNameEnFull;
	}

	public String getPlayerInitialLv() {
		return playerInitialLv;
	}

	public void setPlayerInitialLv(String playerInitialLv) {
		this.playerInitialLv = playerInitialLv;
	}

	public Long getPlayerGp99() {
		return playerGp99;
	}

	public void setPlayerGp99(Long playerGp99) {
		this.playerGp99 = playerGp99;
	}

	public Long getPlayerTp99() {
		return playerTp99;
	}

	public void setPlayerTp99(Long playerTp99) {
		this.playerTp99 = playerTp99;
	}

	public Long getPlayerKick99() {
		return playerKick99;
	}

	public void setPlayerKick99(Long playerKick99) {
		this.playerKick99 = playerKick99;
	}

	public Long getPlayerBody99() {
		return playerBody99;
	}

	public void setPlayerBody99(Long playerBody99) {
		this.playerBody99 = playerBody99;
	}

	public Long getPlayerControl99() {
		return playerControl99;
	}

	public void setPlayerControl99(Long playerControl99) {
		this.playerControl99 = playerControl99;
	}

	public Long getPlayerGuard99() {
		return playerGuard99;
	}

	public void setPlayerGuard99(Long playerGuard99) {
		this.playerGuard99 = playerGuard99;
	}

	public Long getPlayerSpeed99() {
		return playerSpeed99;
	}

	public void setPlayerSpeed99(Long playerSpeed99) {
		this.playerSpeed99 = playerSpeed99;
	}

	public Long getPlayerStamina99() {
		return playerStamina99;
	}

	public void setPlayerStamina99(Long playerStamina99) {
		this.playerStamina99 = playerStamina99;
	}

	public Long getPlayerGuts99() {
		return playerGuts99;
	}

	public void setPlayerGuts99(Long playerGuts99) {
		this.playerGuts99 = playerGuts99;
	}

	public Long getPlayerFreedom99() {
		return playerFreedom99;
	}

	public void setPlayerFreedom99(Long playerFreedom99) {
		this.playerFreedom99 = playerFreedom99;
	}

	public List<Long> getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(List<Long> playerStats) {
		this.playerStats = playerStats;
	}

	public Attri getAttri() {
		return attri;
	}

	public void setAttri(Attri attri) {
		this.attri = attri;
	}

	public Positi getPositi() {
		return positi;
	}

	public void setPositi(Positi positi) {
		this.positi = positi;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public PlayerObtentionMethod getPlayerObtentionMethod() {
		return playerObtentionMethod;
	}

	public void setPlayerObtentionMethod(PlayerObtentionMethod playerObtentionMethod) {
		this.playerObtentionMethod = playerObtentionMethod;
	}

	public Player getOriginalVersion() {
		return originalVersion;
	}

	public void setOriginalVersion(Player originalVersion) {
		this.originalVersion = originalVersion;
	}

	public List<Player> getAltVersion() {
		return altVersion;
	}

	public void setAltVersion(List<Player> altVersion) {
		this.altVersion = altVersion;
	}

	public List<PlayerLearnsHissatsu> getPlayerLearnsHissatsu() {
		return playerLearnsHissatsu;
	}

	public void setPlayerLearnsHissatsu(List<PlayerLearnsHissatsu> playerLearnsHissatsu) {
		this.playerLearnsHissatsu = playerLearnsHissatsu;
	}

	public List<ItemHissatsu> getPlayerRecommendedHissatsu() {
		return playerRecommendedHissatsu;
	}

	public void setPlayerRecommendedHissatsu(List<ItemHissatsu> playerRecommendedHissatsu) {
		this.playerRecommendedHissatsu = playerRecommendedHissatsu;
	}

	public List<ItemEquipment> getPlayerRecommendedEquipment() {
		return playerRecommendedEquipment;
	}

	public void setPlayerRecommendedEquipment(List<ItemEquipment> playerRecommendedEquipment) {
		this.playerRecommendedEquipment = playerRecommendedEquipment;
	}

	public List<TrainingMethod> getPlayerRecommendedRoutine() {
		return playerRecommendedRoutine;
	}

	public void setPlayerRecommendedRoutine(List<TrainingMethod> playerRecommendedRoutine) {
		this.playerRecommendedRoutine = playerRecommendedRoutine;
	}

	public List<Passwd> getPlayerPasswd() {
		return playerPasswd;
	}

	public void setPlayerPasswd(List<Passwd> playerPasswd) {
		this.playerPasswd = playerPasswd;
	}

	public List<PlayerIsPartOfTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<PlayerIsPartOfTeam> teams) {
		this.teams = teams;
	}

	public List<Team> getStoryTeam() {
		return storyTeam;
	}

	public void setStoryTeam(List<Team> storyTeam) {
		this.storyTeam = storyTeam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attri, bodyType, gender, originalVersion, playerBody99, playerControl99, playerFreedom99,
				playerGp99, playerGuard99, playerGuts99, playerId, playerInitialLv, playerKick99, playerNameEn,
				playerNameEnFull, playerNameHiragana, playerNameJa, playerNameKanji, playerNameRomanji,
				playerObtentionMethod, playerSpeed99, playerStamina99, playerStats, playerTp99, positi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(attri, other.attri) && Objects.equals(bodyType, other.bodyType)
				&& Objects.equals(gender, other.gender) && Objects.equals(originalVersion, other.originalVersion)
				&& Objects.equals(playerBody99, other.playerBody99)
				&& Objects.equals(playerControl99, other.playerControl99)
				&& Objects.equals(playerFreedom99, other.playerFreedom99)
				&& Objects.equals(playerGp99, other.playerGp99) && Objects.equals(playerGuard99, other.playerGuard99)
				&& Objects.equals(playerGuts99, other.playerGuts99) && Objects.equals(playerId, other.playerId)
				&& Objects.equals(playerInitialLv, other.playerInitialLv)
				&& Objects.equals(playerKick99, other.playerKick99) && Objects.equals(playerNameEn, other.playerNameEn)
				&& Objects.equals(playerNameEnFull, other.playerNameEnFull)
				&& Objects.equals(playerNameHiragana, other.playerNameHiragana)
				&& Objects.equals(playerNameJa, other.playerNameJa)
				&& Objects.equals(playerNameKanji, other.playerNameKanji)
				&& Objects.equals(playerNameRomanji, other.playerNameRomanji)
				&& Objects.equals(playerObtentionMethod, other.playerObtentionMethod)
				&& Objects.equals(playerSpeed99, other.playerSpeed99)
				&& Objects.equals(playerStamina99, other.playerStamina99)
				&& Objects.equals(playerStats, other.playerStats) && Objects.equals(playerTp99, other.playerTp99)
				&& Objects.equals(positi, other.positi);
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerNameJa=" + playerNameJa + ", playerNameHiragana="
				+ playerNameHiragana + ", playerNameKanji=" + playerNameKanji + ", playerNameRomanji="
				+ playerNameRomanji + ", playerNameEn=" + playerNameEn + ", playerNameEnFull=" + playerNameEnFull
				+ ", playerInitialLv=" + playerInitialLv + ", playerGp99=" + playerGp99 + ", playerTp99=" + playerTp99
				+ ", playerKick99=" + playerKick99 + ", playerBody99=" + playerBody99 + ", playerControl99="
				+ playerControl99 + ", playerGuard99=" + playerGuard99 + ", playerSpeed99=" + playerSpeed99
				+ ", playerStamina99=" + playerStamina99 + ", playerGuts99=" + playerGuts99 + ", playerFreedom99="
				+ playerFreedom99 + ", playerStats=" + playerStats + ", attri=" + attri + ", positi=" + positi
				+ ", gender=" + gender + ", bodyType=" + bodyType + ", playerObtentionMethod=" + playerObtentionMethod
				+ ", originalVersion=" + originalVersion + "]";
	}

}
