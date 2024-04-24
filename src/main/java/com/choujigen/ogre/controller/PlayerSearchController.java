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

import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.form.PlayerSearch;
import com.choujigen.ogre.service.AttriService;
import com.choujigen.ogre.service.GenderService;
import com.choujigen.ogre.service.ItemHissatsuService;
import com.choujigen.ogre.service.PlayerService;
import com.choujigen.ogre.service.PositiService;

import jakarta.validation.Valid;

@Controller
public class PlayerSearchController {
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private AttriService attriService;
	
	@Autowired
	private PositiService positiService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private ItemHissatsuService itemHissatsuService;
	
	@RequestMapping(value = { "/player-search", "/player-search/" })
	public String tacticsList(Model model, PlayerSearch playerSearch) {
		Locale locale = LocaleContextHolder.getLocale();
		
		/* default checked*/
		playerSearch.setAttri(0L);
		playerSearch.setPositi(0L);
		playerSearch.setGender(0L);

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("attris", attriService.all());
		model.addAttribute("positis", positiService.all());
		model.addAttribute("genders", genderService.all());
		model.addAttribute("hissatsus", itemHissatsuService.all());
		model.addAttribute("players", new ArrayList<Player>());

		return "/player-search";
	}
	
	@PostMapping(value = { "/player-search", "/player-search/" }, params = "searchPlayer")
	public String checkPersonInfo(Model model, @Valid PlayerSearch playerSearch, 
			BindingResult bindingResult) {
		Locale locale = LocaleContextHolder.getLocale();
		List<Player> players = new ArrayList<Player>();
		List<ItemHissatsu> itemHissatsuAux = new ArrayList<ItemHissatsu>();
		String[] hissatsuNameArray = new String[4];
		ItemHissatsu[] hissatsuObjArray = new ItemHissatsu[4];
		
		if (!bindingResult.hasErrors()) {
			try {
				if(playerSearch.getAttri() > 0) {
					playerSearch.setAttriObj(attriService.one(playerSearch.getAttri()));
				}
				if(playerSearch.getPositi() > 0) {
					playerSearch.setPositiObj(positiService.one(playerSearch.getPositi()));
				}
				if(playerSearch.getGender() > 0) {
					playerSearch.setGenderObj(genderService.one(playerSearch.getGender()));	
				}
				/*already validated with @HissatsuNameConstraint*/
				hissatsuNameArray[0] = playerSearch.getHissatsu1();
				hissatsuNameArray[1] = playerSearch.getHissatsu2();
				hissatsuNameArray[2] = playerSearch.getHissatsu3();
				hissatsuNameArray[3] = playerSearch.getHissatsu4();
				for (int i = 0; i < hissatsuNameArray.length; i++) {
					if(!hissatsuNameArray[i].isEmpty()) {
						switch (locale.getLanguage()) {
						case "ja":
							itemHissatsuAux = itemHissatsuService.findByItemNameJa(hissatsuNameArray[i]);
							break;
						case "en":
							itemHissatsuAux = itemHissatsuService.findByItemNameEn(hissatsuNameArray[i]);
							break;
						case "es":
							itemHissatsuAux = itemHissatsuService.findByItemNameEs(hissatsuNameArray[i]);
							break;
						default:
							itemHissatsuAux = itemHissatsuService.findByItemNameEn(hissatsuNameArray[i]);
						}
						if(!itemHissatsuAux.isEmpty()) {
							hissatsuObjArray[i] = itemHissatsuAux.get(0);	
						}
					} else {
						hissatsuObjArray[i] = null;
					}
				}
				playerSearch.setHissatsuArray(hissatsuObjArray);
				players = playerService.findByCriteriaPlayerSearch(playerSearch, locale.getLanguage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//System.out.println(bindingResult.toString());
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("attris", attriService.all());
		model.addAttribute("positis", positiService.all());
		model.addAttribute("genders", genderService.all());
		model.addAttribute("hissatsus", itemHissatsuService.all());
		model.addAttribute("players", players);

		return "/player-search";
	}
}
