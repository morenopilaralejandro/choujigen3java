package com.choujigen.ogre.domain;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utc_session")
public class UtcSession {
	@Column(name = "utc_session_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long utcSessionId;
	@Column(name = "utc_session_name_ja")
	private String utcSessionNameJa;
	@Column(name = "utc_session_name_en")
	private String utcSessionNameEn;
	@Column(name = "utc_session_name_es")
	private String utcSessionNameEs;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utc_session_develops_stat", joinColumns = @JoinColumn(name = "utc_session_id"), inverseJoinColumns = @JoinColumn(name = "stat_id"))
	private List<Stat> stats;
	
	@OneToMany(mappedBy = "utcSession")
	private List<UtcSessionDrops> utcSessionDrops;

	public UtcSession() {
	}

	public UtcSession(Long utcSessionId, String utcSessionNameJa, String utcSessionNameEn, String utcSessionNameEs) {
		super();
		this.utcSessionId = utcSessionId;
		this.utcSessionNameJa = utcSessionNameJa;
		this.utcSessionNameEn = utcSessionNameEn;
		this.utcSessionNameEs = utcSessionNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.utcSessionNameJa;
		case "en":
			return this.utcSessionNameEn;
		case "es":
			return this.utcSessionNameEs;
		default:
			return this.utcSessionNameEn;
		}
	}

	public Long getUtcSessionId() {
		return utcSessionId;
	}

	public void setUtcSessionId(Long utcSessionId) {
		this.utcSessionId = utcSessionId;
	}

	public String getUtcSessionNameJa() {
		return utcSessionNameJa;
	}

	public void setUtcSessionNameJa(String utcSessionNameJa) {
		this.utcSessionNameJa = utcSessionNameJa;
	}

	public String getUtcSessionNameEn() {
		return utcSessionNameEn;
	}

	public void setUtcSessionNameEn(String utcSessionNameEn) {
		this.utcSessionNameEn = utcSessionNameEn;
	}

	public String getUtcSessionNameEs() {
		return utcSessionNameEs;
	}

	public void setUtcSessionNameEs(String utcSessionNameEs) {
		this.utcSessionNameEs = utcSessionNameEs;
	}

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public List<UtcSessionDrops> getUtcSessionDrops() {
		return utcSessionDrops;
	}

	public void setUtcSessionDrops(List<UtcSessionDrops> utcSessionDrops) {
		this.utcSessionDrops = utcSessionDrops;
	}

	@Override
	public int hashCode() {
		return Objects.hash(utcSessionId, utcSessionNameEn, utcSessionNameEs, utcSessionNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtcSession other = (UtcSession) obj;
		return Objects.equals(utcSessionId, other.utcSessionId)
				&& Objects.equals(utcSessionNameEn, other.utcSessionNameEn)
				&& Objects.equals(utcSessionNameEs, other.utcSessionNameEs)
				&& Objects.equals(utcSessionNameJa, other.utcSessionNameJa);
	}

	@Override
	public String toString() {
		return "UtcSession [utcSessionId=" + utcSessionId + ", utcSessionNameJa=" + utcSessionNameJa
				+ ", utcSessionNameEn=" + utcSessionNameEn + ", utcSessionNameEs=" + utcSessionNameEs + "]";
	}

}
