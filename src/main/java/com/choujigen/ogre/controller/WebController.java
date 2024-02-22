package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choujigen.ogre.domain.HissatsuBlock;
import com.choujigen.ogre.domain.HissatsuCatch;
import com.choujigen.ogre.domain.HissatsuDribble;
import com.choujigen.ogre.domain.HissatsuShoot;
import com.choujigen.ogre.domain.HissatsuSkill;
import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.service.HissatsuBlockService;
import com.choujigen.ogre.service.HissatsuCatchService;
import com.choujigen.ogre.service.HissatsuDribbleService;
import com.choujigen.ogre.service.HissatsuShootService;
import com.choujigen.ogre.service.HissatsuSkillService;
import com.choujigen.ogre.service.ItemHissatsuService;

@Controller
public class WebController {
	@Autowired
	private ItemHissatsuService itemHissatsuService;

	@Autowired
	private HissatsuShootService hissatsuShootService;
	
	@Autowired
	private HissatsuDribbleService hissatsuDribbleService;
	
	@Autowired
	private HissatsuBlockService hissatsuBlockService;
	
	@Autowired
	private HissatsuCatchService hissatsuCatchService;
	
	@Autowired
	private HissatsuSkillService hissatsuSkillService;

	@RequestMapping(value = "/")
	public String index(Model model) {
		return "/index";
	}

	@RequestMapping(value = "/hissatsu-list")
	public String hissatsuList(Model model) {
		List<HissatsuShoot> shootAll = hissatsuShootService.all();
		List<HissatsuDribble> dribbleAll = hissatsuDribbleService.all();
		List<HissatsuBlock> blockAll = hissatsuBlockService.all();
		List<HissatsuCatch> catchAll = hissatsuCatchService.all();
		List<HissatsuSkill> skillAll = hissatsuSkillService.all(); 

		List<HissatsuShoot> shootWind = new ArrayList<HissatsuShoot>();
		List<HissatsuShoot> shootWood = new ArrayList<HissatsuShoot>();
		List<HissatsuShoot> shootFire = new ArrayList<HissatsuShoot>();
		List<HissatsuShoot> shootEarth = new ArrayList<HissatsuShoot>();

		List<HissatsuDribble> dribbleWind = new ArrayList<HissatsuDribble>();
		List<HissatsuDribble> dribbleWood = new ArrayList<HissatsuDribble>();
		List<HissatsuDribble> dribbleFire = new ArrayList<HissatsuDribble>();
		List<HissatsuDribble> dribbleEarth = new ArrayList<HissatsuDribble>();

		List<HissatsuBlock> blockWind = new ArrayList<HissatsuBlock>();
		List<HissatsuBlock> blockWood = new ArrayList<HissatsuBlock>();
		List<HissatsuBlock> blockFire = new ArrayList<HissatsuBlock>();
		List<HissatsuBlock> blockEarth = new ArrayList<HissatsuBlock>();

		List<HissatsuCatch> catchWind = new ArrayList<HissatsuCatch>();
		List<HissatsuCatch> catchWood = new ArrayList<HissatsuCatch>();
		List<HissatsuCatch> catchFire = new ArrayList<HissatsuCatch>();
		List<HissatsuCatch> catchEarth = new ArrayList<HissatsuCatch>();
		
		for (HissatsuShoot h : shootAll) {
			switch(h.getAttri().get(0).getAttriId().intValue()) {
			case 1:
				shootWind.add(h);
				break;
			case 2:
				shootWood.add(h);
				break;
			case 3:
				shootFire.add(h);
				break;
			case 4:
				shootEarth.add(h);
				break;
			}
		}
		
		for (HissatsuDribble h : dribbleAll) {
			switch(h.getAttri().get(0).getAttriId().intValue()) {
			case 1:
				dribbleWind.add(h);
				break;
			case 2:
				dribbleWood.add(h);
				break;
			case 3:
				dribbleFire.add(h);
				break;
			case 4:
				dribbleEarth.add(h);
				break;
			}
		}
		
		for (HissatsuBlock h : blockAll) {
			switch(h.getAttri().get(0).getAttriId().intValue()) {
			case 1:
				blockWind.add(h);
				break;
			case 2:
				blockWood.add(h);
				break;
			case 3:
				blockFire.add(h);
				break;
			case 4:
				blockEarth.add(h);
				break;
			}
		}
		
		for (HissatsuCatch h : catchAll) {
			switch(h.getAttri().get(0).getAttriId().intValue()) {
			case 1:
				catchWind.add(h);
				break;
			case 2:
				catchWood.add(h);
				break;
			case 3:
				catchFire.add(h);
				break;
			case 4:
				catchEarth.add(h);
				break;
			}
		}
		
		shootWind.sort(Comparator.comparing(HissatsuShoot::getHissatsuShootMaxPower));
		shootWood.sort(Comparator.comparing(HissatsuShoot::getHissatsuShootMaxPower));
		shootFire.sort(Comparator.comparing(HissatsuShoot::getHissatsuShootMaxPower));
		shootEarth.sort(Comparator.comparing(HissatsuShoot::getHissatsuShootMaxPower));

		model.addAttribute("shootWind", shootWind);
		model.addAttribute("shootWood", shootWood);
		model.addAttribute("shootFire", shootFire);
		model.addAttribute("shootEarth", shootEarth);
		model.addAttribute("dribbleWind", dribbleWind);
		model.addAttribute("dribbleWood", dribbleWood);
		model.addAttribute("dribbleFire", dribbleFire);
		model.addAttribute("dribbleEarth", dribbleEarth);
		model.addAttribute("blockWind", blockWind);
		model.addAttribute("blockWood", blockWood);
		model.addAttribute("blockFire", blockFire);
		model.addAttribute("blockEarth", blockEarth);
		model.addAttribute("catchWind", catchWind);
		model.addAttribute("catchWood", catchWood);
		model.addAttribute("catchFire", catchFire);
		model.addAttribute("catchEarth", catchEarth);
		model.addAttribute("skillAll", skillAll);
		return "/hissatsu-list";
	}
}
