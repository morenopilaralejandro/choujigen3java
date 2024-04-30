package com.choujigen.ogre.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.TournamentDisputedByTeam;
import com.choujigen.ogre.domain.TournamentDropItem;
import com.choujigen.ogre.domain.TournamentName;
import com.choujigen.ogre.domain.TournamentRank;
import com.choujigen.ogre.service.TournamentRankService;

@Controller
public class TournamentController {

	@Autowired
	private TournamentRankService tournamentRankService;

	@RequestMapping(value = { "/tournament", "/tournament/" })
	public String tournament(Model model) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		List<TournamentRank> ranks = tournamentRankService.all();
		List<Player> rankPlus1 = ranks.get(13).getPlayers();
		List<Player> rankPlus2 = ranks.get(14).getPlayers();
		List<Player> rankPlus3 = ranks.get(15).getPlayers();

		/* do */

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ranks", ranks);
		model.addAttribute("rankPlus1", rankPlus1);
		model.addAttribute("rankPlus2", rankPlus2);
		model.addAttribute("rankPlus3", rankPlus3);
		return "/tournament";
	}

	@RequestMapping(value = { "/tournament/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String tournamentRank(Model model, @PathVariable(name = "id", required = false) Long id) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		TournamentRank rank = new TournamentRank();
		try {
			rank = tournamentRankService.one(id);
		} catch (Exception e) {
			return tournament(model);
		}

		List<TournamentName> names = rank.getNames();
		List<Player> players = rank.getPlayers();
		List<TournamentDisputedByTeam> tdt = rank.getTournamentDisputedByTeam();
		List<TournamentDropItem> tdi = rank.getTournamentDropItem();

		/* do */

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());

		model.addAttribute("rank", rank);
		model.addAttribute("names", names);
		model.addAttribute("players", players);
		model.addAttribute("tdt", tdt);
		model.addAttribute("tdi", tdi);

		return "/tournament-rank";
	}

}
