package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formation_scheme")
public class FormationScheme {
	@Column(name = "formation_scheme_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long formationSchemeId;
	@Column(name = "formation_scheme_name")
	private String formationSchemeName;

	public FormationScheme() {
	}

	public FormationScheme(Long formationSchemeId, String formationSchemeName) {
		super();
		this.formationSchemeId = formationSchemeId;
		this.formationSchemeName = formationSchemeName;
	}

	public Long getFormationSchemeId() {
		return formationSchemeId;
	}

	public void setFormationSchemeId(Long formationSchemeId) {
		this.formationSchemeId = formationSchemeId;
	}

	public String getFormationSchemeName() {
		return formationSchemeName;
	}

	public void setFormationSchemeName(String formationSchemeName) {
		this.formationSchemeName = formationSchemeName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formationSchemeId, formationSchemeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormationScheme other = (FormationScheme) obj;
		return Objects.equals(formationSchemeId, other.formationSchemeId)
				&& Objects.equals(formationSchemeName, other.formationSchemeName);
	}

	@Override
	public String toString() {
		return "FormationScheme [formationSchemeId=" + formationSchemeId + ", formationSchemeName="
				+ formationSchemeName + "]";
	}

}
