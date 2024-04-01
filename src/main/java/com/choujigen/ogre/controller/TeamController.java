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
import com.choujigen.ogre.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = { "/team-list", "/team-list/" })
	public String teamList(Model model) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		List<Team> teams = teamService.all();
		/* list */
		int auxId;
		List<Team> ff = new ArrayList<Team>();
		List<Team> national = new ArrayList<Team>();
		List<Team> aliea = new ArrayList<Team>();
		List<Team> other = new ArrayList<Team>();
		List<Team> ffi1 = new ArrayList<Team>();
		List<Team> ffi2 = new ArrayList<Team>();
		List<Team> noBinder = new ArrayList<Team>();

		/* do */
		/* list */
		for (Team team : teams) {
			auxId = team.getTeamId().intValue();
			if (auxId >= 1 && auxId <= 10) {
				ff.add(team);
			} else if (auxId >= 11 && auxId <= 16) {
				national.add(team);
			} else if (auxId >= 17 && auxId <= 25) {
				aliea.add(team);
			} else if (auxId >= 26 && auxId <= 31) {
				other.add(team);
			} else if (auxId >= 32 && auxId <= 43) {
				ffi1.add(team);
			} else if (auxId >= 44 && auxId <= 51) {
				ffi2.add(team);
			} else {
				noBinder.add(team);
			}
		}
		noBinder.sort(Comparator.comparing(Team::getTeamNameJa));

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		/* list */
		model.addAttribute("ff", ff);
		model.addAttribute("national", national);
		model.addAttribute("aliea", aliea);
		model.addAttribute("other", other);
		model.addAttribute("ffi1", ffi1);
		model.addAttribute("ffi2", ffi2);
		model.addAttribute("noBinder", noBinder);
		return "/team-list";
	}

	@RequestMapping(value = { "/team", "/team/", "/team/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String team(Model model, @PathVariable(name = "id", required = false) Long id) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		Team team = new Team();
		try {
			team = teamService.one(id);
		} catch (Exception e) {
			return teamList(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(team.getTeamNameJa());
		inOtherLanguages.add(team.getTeamNameEn());
		inOtherLanguages.add(team.getTeamNameEs());
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
		return "/team";
	}
}
