package com.choujigen.ogre.controller;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping(value = "/")
	public String index(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		model.addAttribute("currentLang", locale.getLanguage());
		return "/index";
	}

}
