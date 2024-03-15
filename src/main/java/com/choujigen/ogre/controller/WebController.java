package com.choujigen.ogre.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choujigen.ogre.domain.Attri;
import com.choujigen.ogre.domain.BodyType;
import com.choujigen.ogre.domain.Gender;
import com.choujigen.ogre.domain.GrowthRate;
import com.choujigen.ogre.domain.GrowthType;
import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRate;
import com.choujigen.ogre.domain.HissatsuBlock;
import com.choujigen.ogre.domain.HissatsuCatch;
import com.choujigen.ogre.domain.HissatsuDribble;
import com.choujigen.ogre.domain.HissatsuShoot;
import com.choujigen.ogre.domain.HissatsuSkill;
import com.choujigen.ogre.domain.HissatsuType;
import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.PlayerLearnsHissatsu;
import com.choujigen.ogre.domain.Positi;
import com.choujigen.ogre.service.GrowthRateService;
import com.choujigen.ogre.service.GrowthTypeService;
import com.choujigen.ogre.service.HissatsuBlockService;
import com.choujigen.ogre.service.HissatsuCatchService;
import com.choujigen.ogre.service.HissatsuDribbleService;
import com.choujigen.ogre.service.HissatsuShootService;
import com.choujigen.ogre.service.HissatsuSkillService;
import com.choujigen.ogre.service.ItemHissatsuService;
import com.choujigen.ogre.service.PlayerService;

@Controller
public class WebController {
	@Autowired
	private ItemHissatsuService itemHissatsuService;

	@Autowired
	private GrowthTypeService growthTypeService;

	@Autowired
	private GrowthRateService growthRateService;

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

	@Autowired
	private PlayerService playerService;

	/*
	 * @Autowired private TeamService teamService;
	 * 
	 * @Autowired private ItemTacticService itemTacticService;
	 */
	@RequestMapping(value = "/")
	public String index(Model model) {
		return "/index";
	}

	@RequestMapping(value = "/hissatsu-list")
	public String hissatsuList(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<GrowthType> growthTypeAll = growthTypeService.all();
		List<GrowthRate> growthRateAll = growthRateService.all();

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
			switch (h.getAttri().get(0).getAttriId().intValue()) {
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
			switch (h.getAttri().get(0).getAttriId().intValue()) {
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
			switch (h.getAttri().get(0).getAttriId().intValue()) {
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
			switch (h.getAttri().get(0).getAttriId().intValue()) {
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

		dribbleWind.sort(Comparator.comparing(HissatsuDribble::getHissatsuDribbleMaxPower));
		dribbleWood.sort(Comparator.comparing(HissatsuDribble::getHissatsuDribbleMaxPower));
		dribbleFire.sort(Comparator.comparing(HissatsuDribble::getHissatsuDribbleMaxPower));
		dribbleEarth.sort(Comparator.comparing(HissatsuDribble::getHissatsuDribbleMaxPower));

		blockWind.sort(Comparator.comparing(HissatsuBlock::getHissatsuBlockMaxPower));
		blockWood.sort(Comparator.comparing(HissatsuBlock::getHissatsuBlockMaxPower));
		blockFire.sort(Comparator.comparing(HissatsuBlock::getHissatsuBlockMaxPower));
		blockEarth.sort(Comparator.comparing(HissatsuBlock::getHissatsuBlockMaxPower));

		catchWind.sort(Comparator.comparing(HissatsuCatch::getHissatsuCatchMaxPower));
		catchWood.sort(Comparator.comparing(HissatsuCatch::getHissatsuCatchMaxPower));
		catchFire.sort(Comparator.comparing(HissatsuCatch::getHissatsuCatchMaxPower));
		catchEarth.sort(Comparator.comparing(HissatsuCatch::getHissatsuCatchMaxPower));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("growthTypeAll", growthTypeAll);
		model.addAttribute("growthRateAll", growthRateAll);
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

	@RequestMapping(value = "/hissatsu/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String hissatsu(Model model, @PathVariable("id") Long id) {
		Locale locale = LocaleContextHolder.getLocale();

		ItemHissatsu itemHissatsu = itemHissatsuService.one(id);
		int hissatsuTypeId = itemHissatsu.getHissatsuType().getHissatsuTypeId().intValue();

		boolean showRestric = true;
		List<Gender> restricGender = itemHissatsu.getRestricGender();
		List<BodyType> restricBodyType = itemHissatsu.getRestricBodyType();
		List<Positi> restricPositi = itemHissatsu.getRestricPositi();
		List<Attri> restricAttriUser = itemHissatsu.getRestricAttriUser();
		List<Attri> restricAttriHelper = itemHissatsu.getRestricAttriHelper();
		List<ItemHissatsu> restricHissatsu = itemHissatsu.getRestricHissatsu();
		if (restricGender.isEmpty() && restricBodyType.isEmpty() && restricPositi.isEmpty()
				&& restricAttriUser.isEmpty() && restricAttriHelper.isEmpty() && restricHissatsu.isEmpty()) {
			showRestric = false;
		}

		String anchor = null;
		if (hissatsuTypeId == 5) {
			anchor = "skills";
		} else {
			String hissatsuTypeNameEn = itemHissatsu.getHissatsuType().getHissatsuTypeNameEn();
			String hissatsuTypeAttriNameEn = itemHissatsu.getAttri().get(0).getAttriNameEn();
			anchor = hissatsuTypeNameEn + "-" + hissatsuTypeAttriNameEn;
			anchor = anchor.toLowerCase();
		}

		Attri attri = null;
		HissatsuType hissatsuType = itemHissatsu.getHissatsuType();
		String name = itemHissatsu.getNameByLang();
		int tp = 0;
		int basePower = 0;
		int maxPower = 0;
		int participants = 0;
		int foul = 0;
		boolean isBlock = false;
		String shootSpecialPropertyName = null;
		String catchTypeName = null;
		String effect = null;
		String growthTypeName = null;
		String growthRateName = null;
		int additionalPower = 0;
		int numberOfUses = 0;
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemHissatsu.getItemNameEn());
		inOtherLanguages.add(itemHissatsu.getItemNameJa());
		inOtherLanguages.add(itemHissatsu.getItemNameEs());

		switch (hissatsuTypeId) {
		case 1:
			HissatsuShoot hissatsuShoot = hissatsuShootService.one(id);
			tp = hissatsuShoot.getHissatsuShootTp().intValue();
			basePower = hissatsuShoot.getHissatsuShootPower().intValue();
			maxPower = hissatsuShoot.getHissatsuShootMaxPower().intValue();
			participants = hissatsuShoot.getHissatsuShootParticipants().intValue();
			if (!hissatsuShoot.getShootSpecialProperty().isEmpty()) {
				shootSpecialPropertyName = hissatsuShoot.getShootSpecialProperty().get(0).getNameByLang();
			}
			break;
		case 2:
			HissatsuDribble hissatsuDribble = hissatsuDribbleService.one(id);
			tp = hissatsuDribble.getHissatsuDribbleTp().intValue();
			basePower = hissatsuDribble.getHissatsuDribblePower().intValue();
			maxPower = hissatsuDribble.getHissatsuDribbleMaxPower().intValue();
			participants = hissatsuDribble.getHissatsuDribbleParticipants().intValue();
			foul = hissatsuDribble.getHissatsuDribbleFoul().intValue();
			break;
		case 3:
			HissatsuBlock hissatsuBlock = hissatsuBlockService.one(id);
			tp = hissatsuBlock.getHissatsuBlockTp().intValue();
			basePower = hissatsuBlock.getHissatsuBlockPower().intValue();
			maxPower = hissatsuBlock.getHissatsuBlockMaxPower().intValue();
			participants = hissatsuBlock.getHissatsuBlockParticipants().intValue();
			foul = hissatsuBlock.getHissatsuBlockFoul().intValue();
			isBlock = hissatsuBlock.isHissatsuBlockIsBlock();
			break;
		case 4:
			HissatsuCatch hissatsuCatch = hissatsuCatchService.one(id);
			tp = hissatsuCatch.getHissatsuCatchTp().intValue();
			basePower = hissatsuCatch.getHissatsuCatchPower().intValue();
			maxPower = hissatsuCatch.getHissatsuCatchMaxPower().intValue();
			participants = hissatsuCatch.getHissatsuCatchParticipants().intValue();
			catchTypeName = hissatsuCatch.getCatchType().getNameByLang();
			break;
		case 5:
			HissatsuSkill hissatsuSkill = hissatsuSkillService.one(id);
			effect = hissatsuSkill.getEffectByLang();
		}

		if (hissatsuTypeId != 5) {
			attri = itemHissatsu.getAttri().get(0);

			List<GrowthTypeAchieveGrowthRate> achieveList = itemHissatsu.getHissatsuEvolves().get(0).getGrowthType()
					.getGrowthTypeAchieveGrowthRate();
			GrowthType growthType = itemHissatsu.getHissatsuEvolves().get(0).getGrowthType();
			GrowthRate growthRate = itemHissatsu.getHissatsuEvolves().get(0).getGrowthRate();
			growthTypeName = growthType.getSymbolByLang();
			growthRateName = growthRate.getNameByLang();
			for (GrowthTypeAchieveGrowthRate a : achieveList) {
				if (a.getGrowthType().equals(growthType) && a.getGrowthRate().equals(growthRate)) {
					additionalPower = a.getAdditionalPower().intValue();
					numberOfUses = a.getNumberOfUses().intValue();
				}
			}
		}

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("anchor", anchor);

		model.addAttribute("itemHissatsu", itemHissatsu);
		model.addAttribute("attri", attri);
		model.addAttribute("hissatsuType", hissatsuType);
		model.addAttribute("hissatsuTypeId", hissatsuTypeId);
		model.addAttribute("name", name);
		model.addAttribute("tp", tp);
		model.addAttribute("basePower", basePower);
		model.addAttribute("maxPower", maxPower);
		model.addAttribute("participants", participants);
		model.addAttribute("foul", foul);
		model.addAttribute("isBlock", isBlock);
		model.addAttribute("shootSpecialPropertyName", shootSpecialPropertyName);
		model.addAttribute("catchTypeName", catchTypeName);
		model.addAttribute("effect", effect);
		model.addAttribute("growthTypeName", growthTypeName);
		model.addAttribute("growthRateName", growthRateName);
		model.addAttribute("additionalPower", additionalPower);
		model.addAttribute("numberOfUses", numberOfUses);

		model.addAttribute("showRestric", showRestric);
		model.addAttribute("restricGender", restricGender);
		model.addAttribute("restricBodyType", restricBodyType);
		model.addAttribute("restricPositi", restricPositi);
		model.addAttribute("restricAttriUser", restricAttriUser);
		model.addAttribute("restricAttriHelper", restricAttriHelper);
		model.addAttribute("restricHissatsu", restricHissatsu);

		model.addAttribute("inOtherLanguages", inOtherLanguages);
		return "/hissatsu";
	}

	@RequestMapping(value = "/player/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String player(Model model, @PathVariable("id") Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		List<String> inOtherLanguages = new ArrayList<String>();
		Player player = playerService.one(id);
		player.updatePlayerStats();

		List<PlayerLearnsHissatsu> playerLearnsHissatsu = player.getPlayerLearnsHissatsu();
		playerLearnsHissatsu.sort(Comparator.comparing(PlayerLearnsHissatsu::getLearnOrder));

		int arrayLength = playerLearnsHissatsu.size();
		ItemHissatsu auxHissatsu = null;

		HissatsuShoot[] shootArray = new HissatsuShoot[arrayLength];
		HissatsuDribble[] dribbleArray = new HissatsuDribble[arrayLength];
		HissatsuBlock[] blockArray = new HissatsuBlock[arrayLength];
		HissatsuCatch[] catchArray = new HissatsuCatch[arrayLength];
		HissatsuSkill[] skillArray = new HissatsuSkill[arrayLength];

		for (int i = 0; i < playerLearnsHissatsu.size(); i++) {
			auxHissatsu = playerLearnsHissatsu.get(i).getItemHissatsu();
			switch (auxHissatsu.getHissatsuType().getHissatsuTypeId().intValue()) {
			case 1:
				shootArray[i] = (HissatsuShoot) auxHissatsu;
				break;
			case 2:
				dribbleArray[i] = (HissatsuDribble) auxHissatsu;
				break;
			case 3:
				blockArray[i] = (HissatsuBlock) auxHissatsu;
				break;
			case 4:
				catchArray[i] = (HissatsuCatch) auxHissatsu;
				break;
			case 5:
				skillArray[i] = (HissatsuSkill) auxHissatsu;
				break;
			}

		}

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("player", player);
		model.addAttribute("playerLearnsHissatsu", playerLearnsHissatsu);
		model.addAttribute("shootArray", shootArray);
		model.addAttribute("dribbleArray", dribbleArray);
		model.addAttribute("blockArray", blockArray);
		model.addAttribute("catchArray", catchArray);
		model.addAttribute("skillArray", skillArray);
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		return "/player";
	}
}
