package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choujigen.ogre.domain.Daily;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.service.DailyService;

@Controller
public class WebController {
	
	@Autowired
	private DailyService dailyService;

	@RequestMapping(value = "/")
	public String index(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		ArrayList<Player> players = new ArrayList<Player>();
		Daily daily = dailyService.one(1L); 
		
		players.add(daily.getPlayer());
		daily.setViews(daily.getViews()+1);
		dailyService.replace(daily, daily.getDailyId());
		
		model.addAttribute("players", players);
		model.addAttribute("currentLang", locale.getLanguage());
		return "/index";
	}

}
