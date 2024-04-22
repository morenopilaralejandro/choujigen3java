package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.form.PlayerSearch;
import com.choujigen.ogre.service.AttriService;
import com.choujigen.ogre.service.GenderService;
import com.choujigen.ogre.service.ItemHissatsuService;

import jakarta.validation.Valid;

@Controller
public class FormController {
	/*	
	@Autowired
	private PlayerService playerService;
	*/
	
	@Autowired
	private AttriService attriService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private ItemHissatsuService itemHissatsuService;
	
	@RequestMapping(value = { "/player-search", "/player-search/" })
	public String tacticsList(Model model, PlayerSearch playerSearch) {
		Locale locale = LocaleContextHolder.getLocale();
		
		/* default checked*/
		playerSearch.setAttri(0L);
		playerSearch.setGender(0L);

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("attris", attriService.all());
		model.addAttribute("genders", genderService.all());
		model.addAttribute("hissatsus", itemHissatsuService.all());

		return "/player-search";
	}
	
	@PostMapping(value = { "/player-search", "/player-search/" }, params = "searchPlayer")
	public String checkPersonInfo(Model model, @Valid PlayerSearch playerSearch, 
			BindingResult bindingResult) {
		Locale locale = LocaleContextHolder.getLocale();
		List<Player> players = new ArrayList<Player>();
		
		if (!bindingResult.hasErrors()) {
			players = new ArrayList<Player>(); //change value filter
		}
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("attris", attriService.all());
		model.addAttribute("genders", genderService.all());
		model.addAttribute("hissatsus", itemHissatsuService.all());
		model.addAttribute("players", players);

		return "/player-search";
	}
}
