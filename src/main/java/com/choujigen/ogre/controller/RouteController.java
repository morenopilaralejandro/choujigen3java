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

import com.choujigen.ogre.domain.ExtraBattleRoute;
import com.choujigen.ogre.service.ExtraBattleRouteService;

@Controller
public class RouteController {

	@Autowired
	private ExtraBattleRouteService extraBattleRouteService;

	@RequestMapping(value = { "/taisen-route", "/taisen-route/" })
	public String route(Model model) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		List<ExtraBattleRoute> routes = extraBattleRouteService.all();

		/* do */

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("routes", routes);

		return "/taisen-route";
	}

	@RequestMapping(value = { "/taisen-route/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String routeView(Model model, @PathVariable(name = "id", required = false) Long id) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		ExtraBattleRoute route = new ExtraBattleRoute();
		try {
			route = extraBattleRouteService.one(id);
		} catch (Exception e) {
			return route(model);
		}

		/* do */

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());

		model.addAttribute("route", route);
		model.addAttribute("pathSize", route.getPaths().size());

		return "/taisen-route-view";
	}

}
