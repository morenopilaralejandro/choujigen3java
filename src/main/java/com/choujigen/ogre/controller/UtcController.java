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

import com.choujigen.ogre.domain.Passwd;
import com.choujigen.ogre.domain.UtcSession;
import com.choujigen.ogre.domain.UtcSessionDrops;
import com.choujigen.ogre.service.PasswdService;
import com.choujigen.ogre.service.UtcSessionService;

@Controller
public class UtcController {

	@Autowired
	private UtcSessionService utcSessionService;
	
	@Autowired
	private PasswdService passwdService;

	@RequestMapping(value = { "/underground", "/underground/" })
	public String utc(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<UtcSession> utcSessions = utcSessionService.all();
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("utcSessions", utcSessions);
		
		return "/utc";
	}

	@RequestMapping(value = { "/underground/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String utcView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		UtcSession utcSession = new UtcSession();
		List<UtcSessionDrops> dropsChest = new ArrayList<UtcSessionDrops>();
		List<UtcSessionDrops> dropsBoss = new ArrayList<UtcSessionDrops>();
		Passwd passwdSuperExp = passwdService.one(22L);
		boolean showStat = false;
		boolean showPasswd = false;
		int tocLength = 3;
		
		try {
			utcSession = utcSessionService.one(id);
		} catch (Exception e) {
			return utc(model);
		}
		
		for (UtcSessionDrops usd : utcSession.getUtcSessionDrops()) {
			if (usd.getUtcDropType().getUtcDropTypeId().intValue() == 1) {
				dropsChest.add(usd);
			} else {
				dropsBoss.add(usd);
			}
		}
		
		if (utcSession.getUtcSessionId().intValue() != 7 &&
				utcSession.getUtcSessionId().intValue() != 8) {
			showStat = true;
			tocLength++;
		}
		
		if (utcSession.getUtcSessionId().intValue() == 8) {
			showPasswd = true;
			tocLength++;
		}

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());

		model.addAttribute("utcSession", utcSession);
		model.addAttribute("dropsChest", dropsChest);
		model.addAttribute("dropsBoss", dropsBoss);
		model.addAttribute("passwdSuperExp", passwdSuperExp);
		model.addAttribute("showStat", showStat);
		model.addAttribute("showPasswd", showPasswd);
		model.addAttribute("tocLength", tocLength);
		
		return "/utc-view";
	}

}
