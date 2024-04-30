package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament_name")
public class TournamentName {
	@Column(name = "tournament_name_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long tournamentNameId;
	@Column(name = "tournament_name_ja")
	private String tournamentNameJa;
	@Column(name = "tournament_name_en")
	private String tournamentNameEn;
	@Column(name = "tournament_name_es")
	private String tournamentNameEs;

	@ManyToOne
	@JoinColumn(name = "tournament_rank_id", referencedColumnName = "tournament_rank_id")
	private TournamentRank tournamentRank;

	public TournamentName() {
	}

	public TournamentName(Long tournamentNameId, String tournamentNameJa, String tournamentNameEn,
			String tournamentNameEs, TournamentRank tournamentRank) {
		super();
		this.tournamentNameId = tournamentNameId;
		this.tournamentNameJa = tournamentNameJa;
		this.tournamentNameEn = tournamentNameEn;
		this.tournamentNameEs = tournamentNameEs;
		this.tournamentRank = tournamentRank;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.tournamentNameJa;
		case "en":
			return this.tournamentNameEn;
		case "es":
			return this.tournamentNameEs;
		default:
			return this.tournamentNameEn;
		}
	}

	public Long getTournamentNameId() {
		return tournamentNameId;
	}

	public void setTournamentNameId(Long tournamentNameId) {
		this.tournamentNameId = tournamentNameId;
	}

	public String getTournamentNameJa() {
		return tournamentNameJa;
	}

	public void setTournamentNameJa(String tournamentNameJa) {
		this.tournamentNameJa = tournamentNameJa;
	}

	public String getTournamentNameEn() {
		return tournamentNameEn;
	}

	public void setTournamentNameEn(String tournamentNameEn) {
		this.tournamentNameEn = tournamentNameEn;
	}

	public String getTournamentNameEs() {
		return tournamentNameEs;
	}

	public void setTournamentNameEs(String tournamentNameEs) {
		this.tournamentNameEs = tournamentNameEs;
	}

	public TournamentRank getTournamentRank() {
		return tournamentRank;
	}

	public void setTournamentRank(TournamentRank tournamentRank) {
		this.tournamentRank = tournamentRank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tournamentNameEn, tournamentNameEs, tournamentNameId, tournamentNameJa, tournamentRank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentName other = (TournamentName) obj;
		return Objects.equals(tournamentNameEn, other.tournamentNameEn)
				&& Objects.equals(tournamentNameEs, other.tournamentNameEs)
				&& Objects.equals(tournamentNameId, other.tournamentNameId)
				&& Objects.equals(tournamentNameJa, other.tournamentNameJa)
				&& Objects.equals(tournamentRank, other.tournamentRank);
	}

	@Override
	public String toString() {
		return "TournamentName [tournamentNameId=" + tournamentNameId + ", tournamentNameJa=" + tournamentNameJa
				+ ", tournamentNameEn=" + tournamentNameEn + ", tournamentNameEs=" + tournamentNameEs
				+ ", tournamentRank=" + tournamentRank + "]";
	}

}
