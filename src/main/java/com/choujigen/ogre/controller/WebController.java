package com.choujigen.ogre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.service.ItemHissatsuService;

@Controller
public class WebController {
    @Autowired
    private ItemHissatsuService itemHissatsuService;
	
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "/index";
    }
    
    @RequestMapping(value = "/hissatsu-list")
    public String hissatsuList(Model model) {
    	ItemHissatsu itemHissatsu = itemHissatsuService.one(1L);
    	model.addAttribute("aux", itemHissatsu.getHissatsuEvolves().get(0).getGrowthType().getGrowthTypeAchieveGrowthRate().get(1).getAdditionalPower());
        return "/hissatsu-list";
    }
}
