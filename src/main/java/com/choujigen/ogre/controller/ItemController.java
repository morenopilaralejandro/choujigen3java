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

import com.choujigen.ogre.domain.EquipmentType;
import com.choujigen.ogre.domain.ExtraBattleRoute;
import com.choujigen.ogre.domain.FormationOrganizedAsPositi;
import com.choujigen.ogre.domain.Item;
import com.choujigen.ogre.domain.ItemEquipment;
import com.choujigen.ogre.domain.ItemFormation;
import com.choujigen.ogre.domain.ItemRewardPlayer;
import com.choujigen.ogre.domain.ItemTactic;
import com.choujigen.ogre.domain.ItemType;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.PlayerIsPartOfTeam;
import com.choujigen.ogre.domain.Positi;
import com.choujigen.ogre.domain.PracticeGame;
import com.choujigen.ogre.domain.Team;
import com.choujigen.ogre.domain.TournamentDisputedByTeam;
import com.choujigen.ogre.service.EquipmentTypeService;
import com.choujigen.ogre.service.ItemEquipmentService;
import com.choujigen.ogre.service.ItemRewardPlayerService;
import com.choujigen.ogre.service.ItemService;
import com.choujigen.ogre.service.ItemTypeService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemTypeService itemTypeService;

	@Autowired
	private HissatsuController hissatsuController;
	
	@Autowired
	private ItemEquipmentService itemEquipmentService;
	
	@Autowired
	private EquipmentTypeService equipmentTypeService;
	
	@Autowired
	private ItemRewardPlayerService itemRewardPlayerService;


	@Autowired
	private TacticController tacticController;

	@Autowired
	private PlayerController playerController;

	@Autowired
	private FormationController formationController;

	@RequestMapping(value = { "/item", "/item/" })
	public String item(Model model) {
		/*
		 * 装備品 シューズ グローブ アクセサリ マップチケット 鍵 対戦チケット 回復 さいごのノート ウェア
		 * 
		 */
		Locale locale = LocaleContextHolder.getLocale();
		List<ItemType> types = itemTypeService.all();
		List<ItemType> typesShown = new ArrayList<ItemType>();
		List<String> urls = new ArrayList<String>();
		typesShown.add(types.get(1));
		typesShown.add(types.get(4));
		typesShown.add(types.get(5));
		typesShown.add(types.get(6));
		typesShown.add(types.get(7));
		typesShown.add(types.get(8));
		typesShown.add(types.get(9));
		
		urls.add("/item/equipment");
		urls.add("/item/map-ticket");
		urls.add("/item/key");
		urls.add("/item/vscard");
		urls.add("/item/recovery");
		urls.add("/item/saigo");
		urls.add("/item/wear");
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("typesShown", typesShown);
		model.addAttribute("urls", urls);
		return "/item";
	}

	@RequestMapping(value = { "/item/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String routeView(Model model, @PathVariable(name = "id", required = false) Long id) {
		/*
		 * (1, '必殺技', 'Hissatsu Technique', 'Supertécnicas'), (2, '装備品', 'Equipment',
		 * 'Equipación'), (3, '通貨', 'Currency', 'Divisa'), (4, '報酬 選手', 'Reward Player',
		 * 'Jugador Recompensa'), (5, 'マップチケット', 'Map', 'Mapa'), (6, '鍵', 'Key',
		 * 'Llave'), (7, '対戦チケット', 'VS Card', 'Tarjeta VS'), (8, '回復', 'Recovery',
		 * 'Recuperación'), (9, 'さいごのノート', 'Ultimate Note', 'Cuaderno Definitivo'), (10,
		 * 'ウェア', 'Uniform', 'Uniforme'), (11, '必殺タクティクス', 'Hissatsu tactics',
		 * 'Supertácticas'), (12, 'フォーメーション', 'Formation', 'Formación');
		 */
		Locale locale = LocaleContextHolder.getLocale();
		Item item = new Item();
		try {
			item = itemService.one(id);
		} catch (Exception e) {
			return item(model);
		}

		switch (item.getItemType().getItemTypeId().intValue()) {
		case 1: // 必殺技
			return hissatsuController.hissatsu(model, id);
		case 2: // 装備品
			return equipmentView(model, id);
		//case 3: 通貨 Currency
		case 4: // 報酬 選手
			ItemRewardPlayer itemRewardPlayer = itemRewardPlayerService.one(id);  
			return playerController.player(model, itemRewardPlayer.getPlayer().getPlayerId());
		case 5: // マップチケット
		case 6: // 鍵
		case 7: // 対戦チケット
		case 8: // 回復
		case 9: // さいごのノート
		case 10: // ウェア
		case 11: // 必殺タクティクス
			return tacticController.tactics(model, id);
		case 12: // フォーメーション
			return formationController.formation(model, id);
		default:
			List<String> inOtherLanguages = new ArrayList<String>();
			inOtherLanguages.add(item.getItemNameJa());
			inOtherLanguages.add(item.getItemNameEn());
			inOtherLanguages.add(item.getItemNameEs());

			model.addAttribute("url", null);
			model.addAttribute("currentLang", locale.getLanguage());
			model.addAttribute("inOtherLanguages", inOtherLanguages);
			model.addAttribute("item", item);
			return "/item-default";
		}
	}
	
	@RequestMapping(value = { "/item/equipment", "/item/equipment/" })
	public String equipment(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		List<EquipmentType> types = equipmentTypeService.all();
		List<String> typesId = new ArrayList<String>();
		List<ItemEquipment> equipments = itemEquipmentService.all();
		List<ItemEquipment> shoes = new ArrayList<ItemEquipment>();
		List<ItemEquipment> gloves = new ArrayList<ItemEquipment>();
		List<ItemEquipment> accessories = new ArrayList<ItemEquipment>();
		List<ItemEquipment> out = new ArrayList<ItemEquipment>();
		
		/* jimina hadena dohadena */
		out.add(itemEquipmentService.one(532L));
		out.add(itemEquipmentService.one(533L));
		out.add(itemEquipmentService.one(534L));

		typesId.add("shoes");
		typesId.add("gloves");
		typesId.add("accessories");
		for (ItemEquipment equipment : equipments) {
			switch (equipment.getEquipmentType().getEquipmentTypeId().intValue()) {
			case 1: 
				shoes.add(equipment);
				break;
			case 2: 
				gloves.add(equipment);
				break;
			case 3: 
				accessories.add(equipment);
				break;
			}
		}
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("types", types);
		model.addAttribute("typesId", typesId);
		model.addAttribute("shoes", shoes);
		model.addAttribute("gloves", gloves);
		model.addAttribute("accessories", accessories);
		model.addAttribute("out", out);
		return "/equipment";
	}
	
	@RequestMapping(value = { "/item/equipment/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String equipmentView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemEquipment itemEquipment = new ItemEquipment();
		try {
			itemEquipment = itemEquipmentService.one(id);
		} catch (Exception e) {
			return equipment(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemEquipment.getItemNameJa());
		inOtherLanguages.add(itemEquipment.getItemNameEn());
		inOtherLanguages.add(itemEquipment.getItemNameEs());


		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemEquipment", itemEquipment);
	
		return "/equipment-view";
	}
}
