package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
	@Column(name = "genre_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long genreId;
	@Column(name = "genre_name_ja")
	private String genreNameJa;
	@Column(name = "genre_name_en")
	private String genreNameEn;
	@Column(name = "genre_name_es")
	private String genreNameEs;
	@Column(name = "genre_symbol")
	private String genreSymbol;

	@ManyToMany(mappedBy = "restricGenre")
	private List<ItemHissatsu> itemHissatsuAll;

	public Genre() {
	}

	public Genre(Long genreId, String genreNameJa, String genreNameEn, String genreNameEs, String genreSymbol) {
		super();
		this.genreId = genreId;
		this.genreNameJa = genreNameJa;
		this.genreNameEn = genreNameEn;
		this.genreNameEs = genreNameEs;
		this.genreSymbol = genreSymbol;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getGenreNameJa();
		case "en":
			return this.getGenreNameEn();
		case "es":
			return this.getGenreNameEs();
		default:
			return this.getGenreNameEn();
		}
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreNameJa() {
		return genreNameJa;
	}

	public void setGenreNameJa(String genreNameJa) {
		this.genreNameJa = genreNameJa;
	}

	public String getGenreNameEn() {
		return genreNameEn;
	}

	public void setGenreNameEn(String genreNameEn) {
		this.genreNameEn = genreNameEn;
	}

	public String getGenreNameEs() {
		return genreNameEs;
	}

	public void setGenreNameEs(String genreNameEs) {
		this.genreNameEs = genreNameEs;
	}

	public String getGenreSymbol() {
		return genreSymbol;
	}

	public void setGenreSymbol(String genreSymbol) {
		this.genreSymbol = genreSymbol;
	}

	public List<ItemHissatsu> getItemHissatsuAll() {
		return itemHissatsuAll;
	}

	public void setItemHissatsuAll(List<ItemHissatsu> itemHissatsuAll) {
		this.itemHissatsuAll = itemHissatsuAll;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genreId, genreNameEn, genreNameEs, genreNameJa, genreSymbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(genreId, other.genreId) && Objects.equals(genreNameEn, other.genreNameEn)
				&& Objects.equals(genreNameEs, other.genreNameEs) && Objects.equals(genreNameJa, other.genreNameJa)
				&& Objects.equals(genreSymbol, other.genreSymbol);
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreNameJa=" + genreNameJa + ", genreNameEn=" + genreNameEn
				+ ", genreNameEs=" + genreNameEs + ", genreSymbol=" + genreSymbol + "]";
	}

}
