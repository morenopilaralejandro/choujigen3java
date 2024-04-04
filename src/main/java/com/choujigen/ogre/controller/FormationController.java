package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choujigen.ogre.domain.FormationOrganizedAsPositi;
import com.choujigen.ogre.domain.ItemFormation;
import com.choujigen.ogre.domain.ItemTactic;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.PlayerIsPartOfTeam;
import com.choujigen.ogre.domain.Positi;
import com.choujigen.ogre.domain.Team;
import com.choujigen.ogre.service.ItemFormationService;
import com.choujigen.ogre.service.PlayerService;
import com.choujigen.ogre.service.TeamService;

@Controller
public class FormationController {
	@Autowired
	private ItemFormationService itemFormationService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = { "/formation-list", "/formation-list/" })
	public String formationList(Model model) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		/* list */
		List<ItemFormation> formations = itemFormationService.all();
		List<Team> teamArray = new ArrayList<Team>();
		ArrayList<String> anchorsMatch = new ArrayList<String>();
		ArrayList<String> anchorsBattle = new ArrayList<String>();
		List<PlayerIsPartOfTeam> pptAux = new ArrayList<PlayerIsPartOfTeam>();
		ArrayList<List<PlayerIsPartOfTeam>> pptArray = new ArrayList<>();
		ArrayList<Positi[]> popArray = new ArrayList<>();
		List<Player> battlePlayers = new ArrayList<Player>();

		/* F-ベーシック, F-ブランゼル */
		teamArray.add(teamService.one(11L));
		anchorsMatch.add("basic");
		/*
		 * F-デスゾーン、F-デスゾーン２、F-ダブルドッグ、F-イージス、F-パンデモニウム、
		 * F-ジェミニ、F-ジェネシス、F-カオス、F-KAGE、F-オルフェウス、F-オーガ
		 */
		teamArray.add(teamService.one(6L));
		anchorsMatch.add("desuzon");
		/* F-ゴーストダンス */
		teamArray.add(teamService.one(2L));
		anchorsMatch.add("ghost");
		/* F-ワイルドパーク */
		teamArray.add(teamService.one(3L));
		anchorsMatch.add("wild");
		/* F-GRID442、F-パンテオン、F-ブリッツ */
		teamArray.add(teamService.one(4L));
		anchorsMatch.add("grid");
		/* F-かくよくのじん */
		teamArray.add(teamService.one(7L));
		anchorsMatch.add("kakuyoku");
		/* F-スーパー☆5 */
		teamArray.add(teamService.one(5L));
		anchorsMatch.add("super");
		/* F-むげんのかべ */
		teamArray.add(teamService.one(8L));
		anchorsMatch.add("mugen");
		/* F-ムカタマーチ、F-スリートップ、F-キングダム、F-Fドラゴン */
		teamArray.add(teamService.one(9L));
		anchorsMatch.add("mukata");
		/* F-フェニックス */
		teamArray.add(teamService.one(156L));
		anchorsMatch.add("phoenix");
		/* F-バタフライ */
		teamArray.add(teamService.one(167L));
		anchorsMatch.add("butterfly");
		/* F-ヘブンズゲート、F-マタドール */
		teamArray.add(teamService.one(10L));
		anchorsMatch.add("heaven");
		/* F-ファランクス、F-イプシロン */
		teamArray.add(teamService.one(136L));
		anchorsMatch.add("phalanx");
		/* F-ドットプリズン */
		teamArray.add(teamService.one(102L));
		anchorsMatch.add("dot");
		/* F-ボー＆アロー */
		teamArray.add(teamService.one(170L));
		anchorsMatch.add("bow");
		/* F-ミドルブロック */
		teamArray.add(teamService.one(185L));
		anchorsMatch.add("middle");
		/* F-NEO、F-ブレッド */
		teamArray.add(teamService.one(35L));
		anchorsMatch.add("neo");

		anchorsBattle.add("bbasic");
		anchorsBattle.add("bflat");
		anchorsBattle.add("battacker");
		anchorsBattle.add("bbreak");
		anchorsBattle.add("bpressure");
		anchorsBattle.add("bslash");
		anchorsBattle.add("bright");
		anchorsBattle.add("btrain");
		anchorsBattle.add("btriangle");
		anchorsBattle.add("blance");

		battlePlayers.add(playerService.one(220L));
		battlePlayers.add(playerService.one(1217L));
		battlePlayers.add(playerService.one(1265L));
		battlePlayers.add(playerService.one(501L));

		/* do */
		/* list */
		for (int i = 0; i < teamArray.size(); i++) {
			pptAux = teamArray.get(i).getPlayers();
			pptAux.sort(Comparator.comparing(PlayerIsPartOfTeam::getPlace));
			pptArray.add(pptAux);

			popArray.add(teamArray.get(i).getItemFormation().getPositiOrderByPlace());
		}

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		/* list */
		model.addAttribute("formations", formations);
		model.addAttribute("teamArray", teamArray);
		model.addAttribute("anchorsMatch", anchorsMatch);
		model.addAttribute("anchorsBattle", anchorsBattle);
		model.addAttribute("pptArray", pptArray);
		model.addAttribute("popArray", popArray);
		model.addAttribute("battlePlayers", battlePlayers);

		return "/formation-list";
	}

	@RequestMapping(value = { "/formation", "/formation/", "/formation/{id}" }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public String formation(Model model, @PathVariable(name = "id", required = false) Long id) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		ItemFormation itemFormation = new ItemFormation();
		try {
			itemFormation = itemFormationService.one(id);
		} catch (Exception e) {
			return formationList(model);
		}
		Team team = new Team();
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemFormation.getItemNameJa());
		inOtherLanguages.add(itemFormation.getItemNameEn());
		inOtherLanguages.add(itemFormation.getItemNameEs());
		/* players */
		List<PlayerIsPartOfTeam> playerIsPartOfTeam = team.getPlayers();
		playerIsPartOfTeam.sort(Comparator.comparing(PlayerIsPartOfTeam::getPlace));
		List<Player> players = new ArrayList<Player>();
		/* formation */
		ItemFormation formation = team.getItemFormation();
		ItemFormation originalFormation;
		List<FormationOrganizedAsPositi> formationOrganizedAsPositi;
		Positi[] positiOrderByPlace = new Positi[11];
		int auxPlace;
		/* tactics */
		List<ItemTactic> tactics = team.getTactics();

		/* do */
		/* players */
		for (PlayerIsPartOfTeam ppt : playerIsPartOfTeam) {
			players.add(ppt.getPlayer());
		}
		/* formation */
		if (formation.getOriginalVersion() == null) {
			originalFormation = formation;
		} else {
			originalFormation = formation.getOriginalVersion();
		}
		formationOrganizedAsPositi = originalFormation.getFormationOrganizedAsPositi();
		for (int i = 0; i < formationOrganizedAsPositi.size(); i++) {
			auxPlace = formationOrganizedAsPositi.get(i).getId().getPlaceId().intValue();
			positiOrderByPlace[auxPlace - 1] = formationOrganizedAsPositi.get(i).getPositi();
		}

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("team", team);
		/* players */
		model.addAttribute("players", players);
		model.addAttribute("playerIsPartOfTeam", playerIsPartOfTeam);
		/* formation */
		model.addAttribute("formation", formation);
		model.addAttribute("positiOrderByPlace", positiOrderByPlace);
		model.addAttribute("originalFormation", originalFormation);
		/* tactics */
		model.addAttribute("tactics", tactics);
		return "/formation";
	}
}
