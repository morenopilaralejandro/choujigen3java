package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.choujigen.ogre.service.TeamService;

@Controller
public class FormationController {
	@Autowired
	private ItemFormationService itemFormationService;
	
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = { "/formation-list", "/formation-list/" })
	public String formationList(Model model) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		/* list */
		List<ItemFormation> formations = itemFormationService.all();
		List<Team> teamArray = new ArrayList<Team>();
		List<PlayerIsPartOfTeam> pptAux = new ArrayList<PlayerIsPartOfTeam>();
		ArrayList<List<PlayerIsPartOfTeam>> pptArray = new ArrayList<>();
		ArrayList<Positi[]> popArray = new ArrayList<>();
		/* F-ベーシック, F-ブランゼル */
		teamArray.add(teamService.one(11L));
		/* F-デスゾーン、F-デスゾーン２、F-ダブルドッグ、F-イージス、F-パンデモニウム、
		 * 		F-ジェミニ、F-ジェネシス、F-カオス、F-KAGE、F-オルフェウス、F-オーガ */
		teamArray.add(teamService.one(6L));
		/* F-ゴーストダンス */
		teamArray.add(teamService.one(2L));
		/* F-ワイルドパーク */
		teamArray.add(teamService.one(3L));
		/* F-GRID442、F-パンテオン、F-ブリッツ */
		teamArray.add(teamService.one(4L));
		/* F-かくよくのじん */
		teamArray.add(teamService.one(7L));
		/* F-スーパー☆5 */
		teamArray.add(teamService.one(5L));
		/* F-むげんのかべ */
		teamArray.add(teamService.one(8L));
		/* F-ムカタマーチ、F-スリートップ、F-キングダム、F-Fドラゴン */
		teamArray.add(teamService.one(9L));
		/* F-フェニックス */
		teamArray.add(teamService.one(156L));
		/* F-バタフライ */
		teamArray.add(teamService.one(167L));
		/* F-ヘブンズゲート、F-マタドール */
		teamArray.add(teamService.one(10L));
		/* F-ファランクス、F-イプシロン */
		teamArray.add(teamService.one(136L));
		/* F-ドットプリズン */
		teamArray.add(teamService.one(102L));
		/* F-ボー＆アロー */
		teamArray.add(teamService.one(170L));
		/* F-ミドルブロック */
		teamArray.add(teamService.one(185L));
		/* F-NEO、F-ブレッド */
		teamArray.add(teamService.one(35L));
		
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
		model.addAttribute("pptArray", pptArray);
		model.addAttribute("popArray", popArray);

		return "/formation-list";
	}

	@RequestMapping(value = { "/formation", "/formation/", "/formation/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
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
