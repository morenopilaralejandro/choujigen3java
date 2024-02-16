package com.choujigen.ogre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choujigen.ogre.domain.ItemType;
import com.choujigen.ogre.service.ItemTypeService;

@Controller
public class WebController {
    @Autowired
    private ItemTypeService itemTypeService;
	
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "/index";
    }
    
    @RequestMapping(value = "/hissatsu-list")
    public String hissatsuList(Model model) {
    	ItemType itemType = itemTypeService.one(1L);
    	model.addAttribute("itemType", itemType);
        return "/hissatsu-list";
    }
}
