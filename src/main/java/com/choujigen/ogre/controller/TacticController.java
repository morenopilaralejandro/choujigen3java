package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choujigen.ogre.domain.ItemTactic;
import com.choujigen.ogre.service.ItemTacticService;

@Controller
public class TacticController {

	@Autowired
	private ItemTacticService itemTacticService;

	@RequestMapping(value = { "/tactics-list", "/tactics-list/" })
	public String tacticsList(Model model) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		List<ItemTactic> itemTacticAll = itemTacticService.all();

		/* do */

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("itemTacticAll", itemTacticAll);
		return "/tactics-list";
	}

	@RequestMapping(value = { "/tactics", "/tactics/", "/tactics/{id}" }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public String tactics(Model model, @PathVariable(name = "id", required = false) Long id) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		ItemTactic itemTactic = new ItemTactic();
		try {
			itemTactic = itemTacticService.one(id);
		} catch (Exception e) {
			return tacticsList(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemTactic.getItemNameJa());
		inOtherLanguages.add(itemTactic.getItemNameEn());
		inOtherLanguages.add(itemTactic.getItemNameEs());

		/* do */

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemTactic", itemTactic);
		model.addAttribute("effect", itemTactic.getEffectByLang());
		model.addAttribute("teams", itemTactic.getTeams());

		return "/tactics";
	}

}
