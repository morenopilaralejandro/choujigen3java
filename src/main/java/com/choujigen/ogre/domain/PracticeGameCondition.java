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
@Table(name = "practice_game_condition")
public class PracticeGameCondition {
	@Column(name = "practice_game_condition_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long practiceGameConditionId;
	@Column(name = "practice_game_condition_desc_ja")
	private String practiceGameConditionDescJa;
	@Column(name = "practice_game_condition_desc_En")
	private String practiceGameConditionDescEn;
	@Column(name = "practice_game_condition_desc_Es")
	private String practiceGameConditionDescEs;

	public PracticeGameCondition() {
	}

	public PracticeGameCondition(Long practiceGameConditionId, String practiceGameConditionDescJa,
			String practiceGameConditionDescEn, String practiceGameConditionDescEs) {
		super();
		this.practiceGameConditionId = practiceGameConditionId;
		this.practiceGameConditionDescJa = practiceGameConditionDescJa;
		this.practiceGameConditionDescEn = practiceGameConditionDescEn;
		this.practiceGameConditionDescEs = practiceGameConditionDescEs;
	}
	
	public String getDescByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.practiceGameConditionDescJa;
		case "en":
			return this.practiceGameConditionDescEn;
		case "es":
			return this.practiceGameConditionDescEs;
		default:
			return this.practiceGameConditionDescEn;
		}
	}

	public Long getPracticeGameConditionId() {
		return practiceGameConditionId;
	}

	public void setPracticeGameConditionId(Long practiceGameConditionId) {
		this.practiceGameConditionId = practiceGameConditionId;
	}

	public String getPracticeGameConditionDescJa() {
		return practiceGameConditionDescJa;
	}

	public void setPracticeGameConditionDescJa(String practiceGameConditionDescJa) {
		this.practiceGameConditionDescJa = practiceGameConditionDescJa;
	}

	public String getPracticeGameConditionDescEn() {
		return practiceGameConditionDescEn;
	}

	public void setPracticeGameConditionDescEn(String practiceGameConditionDescEn) {
		this.practiceGameConditionDescEn = practiceGameConditionDescEn;
	}

	public String getPracticeGameConditionDescEs() {
		return practiceGameConditionDescEs;
	}

	public void setPracticeGameConditionDescEs(String practiceGameConditionDescEs) {
		this.practiceGameConditionDescEs = practiceGameConditionDescEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(practiceGameConditionDescEn, practiceGameConditionDescEs, practiceGameConditionDescJa,
				practiceGameConditionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PracticeGameCondition other = (PracticeGameCondition) obj;
		return Objects.equals(practiceGameConditionDescEn, other.practiceGameConditionDescEn)
				&& Objects.equals(practiceGameConditionDescEs, other.practiceGameConditionDescEs)
				&& Objects.equals(practiceGameConditionDescJa, other.practiceGameConditionDescJa)
				&& Objects.equals(practiceGameConditionId, other.practiceGameConditionId);
	}

	@Override
	public String toString() {
		return "PracticeGameCondition [practiceGameConditionId=" + practiceGameConditionId
				+ ", practiceGameConditionDescJa=" + practiceGameConditionDescJa + ", practiceGameConditionDescEn="
				+ practiceGameConditionDescEn + ", practiceGameConditionDescEs=" + practiceGameConditionDescEs + "]";
	}

}
