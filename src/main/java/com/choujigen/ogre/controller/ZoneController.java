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

import com.choujigen.ogre.domain.Region;
import com.choujigen.ogre.domain.ZoneOuter;
import com.choujigen.ogre.service.RegionService;
import com.choujigen.ogre.service.ZoneOuterService;

@Controller
public class ZoneController {
	@Autowired
	private RegionService regionService;

	@Autowired
	private ZoneOuterService zoneOuterService;

	@RequestMapping(value = { "/map", "/map/" })
	public String map(Model model) {
		/* don't include caravan */
		Locale locale = LocaleContextHolder.getLocale();

		List<Region> regions = regionService.all();
		regions.remove(regions.size() - 1);

		List<ZoneOuter> zoneOuters = zoneOuterService.all();
		List<ZoneOuter> japan = new ArrayList<ZoneOuter>();
		List<ZoneOuter> liocott = new ArrayList<ZoneOuter>();
		List<ZoneOuter> future = new ArrayList<ZoneOuter>();
		List<String> hrefIds = new ArrayList<String>();
		List<List<ZoneOuter>> regionZones = new ArrayList<List<ZoneOuter>>();

		hrefIds.add("japan");
		hrefIds.add("liocott");
		hrefIds.add("future");

		for (ZoneOuter zoneOuter : zoneOuters) {
			switch (zoneOuter.getRegion().getRegionId().intValue()) {
			case 1:
				japan.add(zoneOuter);
				break;
			case 2:
				liocott.add(zoneOuter);
				break;
			case 3:
				future.add(zoneOuter);
				break;
			}
		}

		regionZones.add(japan);
		regionZones.add(liocott);
		regionZones.add(future);

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("regions", regions);
		model.addAttribute("hrefIds", hrefIds);
		model.addAttribute("regionZones", regionZones);

		return "/map";
	}

	@RequestMapping(value = { "/map/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String mapView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ZoneOuter zoneOuter = new ZoneOuter();
		try {
			zoneOuter = zoneOuterService.one(id);
		} catch (Exception e) {
			return map(model);
		}

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("zoneOuter", zoneOuter);
		zoneOuter.getZoneInners();

		return "/map-view";
	}

}
