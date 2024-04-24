package com.choujigen.ogre.spec;

import org.springframework.data.jpa.domain.Specification;

import com.choujigen.ogre.domain.Attri;
import com.choujigen.ogre.domain.Gender;
import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.Positi;
import com.choujigen.ogre.form.PlayerSearch;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class PlayerSpec {
	public static final String ID = "playerId";
	public static final String NAME_JA = "playerNameJa";
	public static final String NAME_HIRA = "playerNameHiragana";
	public static final String NAME_KANJI = "playerNameKanji";
	public static final String NAME_ENG = "playerNameEn";
	public static final String NAME_ENG_FULL = "playerNameEnFull";
	public static final String ATTRI = "attri";
	public static final String POSITI = "positi";
	public static final String GENDER = "gender";
	public static final String HISSATSU = "playerLearnsHissatsu";

	private PlayerSpec() {
	}

	private static Specification<Player> notReal() {
		return ((root, query, cb) -> cb.not(cb.between(root.get(ID), 2305L, 2320L)));
	}

	private static Specification<Player> hasNameEng(String name) {
		return ((root, query, cb) -> name == null || name.isEmpty() ? cb.conjunction()
				: cb.or(cb.like(root.get(NAME_ENG), name + '%'), cb.like(root.get(NAME_ENG_FULL), name + '%')));
	}

	private static Specification<Player> hasNameJa(String name) {
		return ((root, query, cb) -> name == null || name.isEmpty() ? cb.conjunction()
				: cb.or(cb.like(root.get(NAME_JA), name + '%'), cb.like(root.get(NAME_HIRA), name + '%'),
						cb.like(root.get(NAME_KANJI), name + '%')));
	}

	private static Specification<Player> hasAttri(Attri attri) {
		return ((root, query, cb) -> attri == null ? cb.conjunction() : cb.equal(root.get(ATTRI), attri));
	}

	private static Specification<Player> hasPositi(Positi positi) {
		return ((root, query, cb) -> positi == null ? cb.conjunction() : cb.equal(root.get(POSITI), positi));
	}

	private static Specification<Player> hasGender(Gender gender) {
		return ((root, query, cb) -> gender == null ? cb.conjunction() : cb.equal(root.get(GENDER), gender));
	}

	/* jpa criteria join many to many */
	static Specification<Player> hasHissatsu(ItemHissatsu hissatsu) {
		return (root, query, cb) -> {
			if (hissatsu == null) {
				return cb.conjunction();
			}
			final Subquery<Long> queryPlayer = query.subquery(Long.class);
			final Root<Player> player = queryPlayer.from(Player.class);
			/* join on playerLearnsHissatsu */
			final Join<Player, ItemHissatsu> joinPlayerHissatsu = player.join(HISSATSU);
			/* select playerLearnsHissatsu.player as the result of the query */
			queryPlayer.select(joinPlayerHissatsu.<Long>get("player"));
			/* where condition is -> playerLearnsHissatsu.itemHissatsu = itemHissatsu */
			queryPlayer.where(cb.equal(joinPlayerHissatsu.<ItemHissatsu>get("itemHissatsu"), hissatsu));
			/*
			 * only show players whose id was found in the query result java->
			 * in(column).value(data set) sql -> column in (data set)
			 */
			return cb.in(root.get(ID)).value(queryPlayer);
		};
	}

	public static Specification<Player> search(PlayerSearch playerSearch, String currentLang) {
		switch (currentLang) {
		case "ja":
			return Specification.where(notReal())
					.and(hasNameJa(playerSearch.getPlayerName())
							.and(hasAttri(playerSearch.getAttriObj()).and(hasPositi(playerSearch.getPositiObj()))
									.and(hasGender(playerSearch.getGenderObj())
											.and(hasHissatsu(playerSearch.getHissatsuArray()[0]))
											.and(hasHissatsu(playerSearch.getHissatsuArray()[1]))
											.and(hasHissatsu(playerSearch.getHissatsuArray()[2]))
											.and(hasHissatsu(playerSearch.getHissatsuArray()[3])))));
		default:
			return Specification.where(notReal())
					.and(hasNameEng(playerSearch.getPlayerName())
							.and(hasAttri(playerSearch.getAttriObj()).and(hasPositi(playerSearch.getPositiObj()))
									.and(hasGender(playerSearch.getGenderObj())
											.and(hasHissatsu(playerSearch.getHissatsuArray()[0]))
											.and(hasHissatsu(playerSearch.getHissatsuArray()[1]))
											.and(hasHissatsu(playerSearch.getHissatsuArray()[2]))
											.and(hasHissatsu(playerSearch.getHissatsuArray()[3])))));
		}
	}
}
