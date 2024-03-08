package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passwd")
public class Passwd {
	@Column(name = "passwd_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long passwdId;
	@Column(name = "passwd_ja")
	private String passwdJa;
	@Column(name = "passwd_en")
	private String passwdEn;
	@Column(name = "passwd_es")
	private String passwdEs;

	public Passwd() {
	}

	public Passwd(Long passwdId, String passwdJa, String passwdEn, String passwdEs) {
		super();
		this.passwdId = passwdId;
		this.passwdJa = passwdJa;
		this.passwdEn = passwdEn;
		this.passwdEs = passwdEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getPasswdJa();
		case "en":
			return this.getPasswdEn();
		case "es":
			return this.getPasswdEs();
		default:
			return this.getPasswdEn();
		}
	}

	public Long getPasswdId() {
		return passwdId;
	}

	public void setPasswdId(Long passwdId) {
		this.passwdId = passwdId;
	}

	public String getPasswdJa() {
		return passwdJa;
	}

	public void setPasswdJa(String passwdJa) {
		this.passwdJa = passwdJa;
	}

	public String getPasswdEn() {
		return passwdEn;
	}

	public void setPasswdEn(String passwdEn) {
		this.passwdEn = passwdEn;
	}

	public String getPasswdEs() {
		return passwdEs;
	}

	public void setPasswdEs(String passwdEs) {
		this.passwdEs = passwdEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(passwdEn, passwdEs, passwdId, passwdJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passwd other = (Passwd) obj;
		return Objects.equals(passwdEn, other.passwdEn) && Objects.equals(passwdEs, other.passwdEs)
				&& Objects.equals(passwdId, other.passwdId) && Objects.equals(passwdJa, other.passwdJa);
	}

	@Override
	public String toString() {
		return "Passwd [passwdId=" + passwdId + ", passwdJa=" + passwdJa + ", passwdEn=" + passwdEn + ", passwdEs="
				+ passwdEs + "]";
	}

}
