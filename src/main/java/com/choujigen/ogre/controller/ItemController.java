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

import com.choujigen.ogre.domain.EquipmentType;
import com.choujigen.ogre.domain.Item;
import com.choujigen.ogre.domain.ItemEquipment;
import com.choujigen.ogre.domain.ItemKey;
import com.choujigen.ogre.domain.ItemMap;
import com.choujigen.ogre.domain.ItemRecovery;
import com.choujigen.ogre.domain.ItemRewardPlayer;
import com.choujigen.ogre.domain.ItemType;
import com.choujigen.ogre.domain.ItemUltimateNote;
import com.choujigen.ogre.domain.ItemVscard;
import com.choujigen.ogre.domain.ItemWear;
import com.choujigen.ogre.service.EquipmentTypeService;
import com.choujigen.ogre.service.ItemEquipmentService;
import com.choujigen.ogre.service.ItemKeyService;
import com.choujigen.ogre.service.ItemMapService;
import com.choujigen.ogre.service.ItemRecoveryService;
import com.choujigen.ogre.service.ItemRewardPlayerService;
import com.choujigen.ogre.service.ItemService;
import com.choujigen.ogre.service.ItemTypeService;
import com.choujigen.ogre.service.ItemUltimateNoteService;
import com.choujigen.ogre.service.ItemVscardService;
import com.choujigen.ogre.service.ItemWearService;

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
	private ItemMapService itemMapService;

	@Autowired
	private ItemKeyService itemKeyService;
	
	@Autowired
	private ItemVscardService itemVscardService;
	
	@Autowired
	private ItemRecoveryService itemRecoveryService;
	
	@Autowired
	private ItemUltimateNoteService itemUltimateNoteService;
	
	@Autowired
	private ItemWearService itemWearService;
	
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
		return "/item/item";
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
		// case 3: 通貨 Currency
		case 4: // 報酬 選手
			ItemRewardPlayer itemRewardPlayer = itemRewardPlayerService.one(id);
			return playerController.player(model, itemRewardPlayer.getPlayer().getPlayerId());
		case 5: // マップチケット
			return mapTicketView(model, id);
		case 6: // 鍵
			return keyView(model, id);
		case 7: // 対戦チケット
			return vscardView(model, id);
		case 8: // 回復
			return recoveryView(model, id);
		case 9: // さいごのノート
			return ultimateNoteView(model, id);
		case 10: // ウェア
			return wearView(model, id);
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
			return "/item/item-default";
		}
	}

	/* ------------------------------- */

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
		return "/item/equipment";
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

		return "/item/equipment-view";
	}

	/* ------------------------------- */

	@RequestMapping(value = { "/item/map-ticket", "/item/map-ticket/" })
	public String mapTicket(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<ItemMap> maps = itemMapService.all();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("maps", maps);
		return "/item/map-ticket";
	}

	@RequestMapping(value = { "/item/map-ticket/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String mapTicketView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemMap itemMap = new ItemMap();
		try {
			itemMap = itemMapService.one(id);
		} catch (Exception e) {
			return mapTicket(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemMap.getItemNameJa());
		inOtherLanguages.add(itemMap.getItemNameEn());
		inOtherLanguages.add(itemMap.getItemNameEs());

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemMap", itemMap);

		return "/item/map-ticket-view";
	}

	/* ------------------------------- */

	@RequestMapping(value = { "/item/key", "/item/key/" })
	public String key(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<ItemKey> keys = itemKeyService.all();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("keys", keys);
		return "/item/key";
	}

	@RequestMapping(value = { "/item/key/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String keyView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemKey itemKey = new ItemKey();
		try {
			itemKey = itemKeyService.one(id);
		} catch (Exception e) {
			return key(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemKey.getItemNameJa());
		inOtherLanguages.add(itemKey.getItemNameEn());
		inOtherLanguages.add(itemKey.getItemNameEs());

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemKey", itemKey);

		return "/item/key-view";
	}
	
	/* ------------------------------- */

	@RequestMapping(value = { "/item/vscard", "/item/vscard/" })
	public String vscard(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<ItemVscard> vscards = itemVscardService.all();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("vscards", vscards);
		return "/item/vscard";
	}

	@RequestMapping(value = { "/item/vscard/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String vscardView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemVscard itemVscard = new ItemVscard();
		try {
			itemVscard = itemVscardService.one(id);
		} catch (Exception e) {
			return vscard(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemVscard.getItemNameJa());
		inOtherLanguages.add(itemVscard.getItemNameEn());
		inOtherLanguages.add(itemVscard.getItemNameEs());

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemVscard", itemVscard);

		return "/item/vscard-view";
	}
	
	/* ------------------------------- */

	@RequestMapping(value = { "/item/recovery", "/item/recovery/" })
	public String recovery(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<ItemRecovery> recoveries = itemRecoveryService.all();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("recoveries", recoveries);
		return "/item/recovery";
	}

	@RequestMapping(value = { "/item/recovery/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String recoveryView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemRecovery itemRecovery = new ItemRecovery();
		List <ItemRecovery> recoveries = new ArrayList<ItemRecovery>();
		try {
			itemRecovery = itemRecoveryService.one(id);
		} catch (Exception e) {
			return recovery(model);
		}
		recoveries.add(itemRecovery);
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemRecovery.getItemNameJa());
		inOtherLanguages.add(itemRecovery.getItemNameEn());
		inOtherLanguages.add(itemRecovery.getItemNameEs());

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemRecovery", itemRecovery);
		model.addAttribute("recoveries", recoveries);

		return "/item/recovery-view";
	}
	
	/* ------------------------------- */

	@RequestMapping(value = { "/item/saigo", "/item/saigo/" })
	public String ultimateNote(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<ItemUltimateNote> notes = itemUltimateNoteService.all();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("notes", notes);
		return "/item/saigo";
	}

	@RequestMapping(value = { "/item/saigo/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String ultimateNoteView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemUltimateNote itemUltimateNote = new ItemUltimateNote();
		List <ItemUltimateNote> notes = new ArrayList<ItemUltimateNote>();
		try {
			itemUltimateNote = itemUltimateNoteService.one(id);
		} catch (Exception e) {
			return ultimateNote(model);
		}
		notes.add(itemUltimateNote);
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemUltimateNote.getItemNameJa());
		inOtherLanguages.add(itemUltimateNote.getItemNameEn());
		inOtherLanguages.add(itemUltimateNote.getItemNameEs());

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemUltimateNote", itemUltimateNote);
		model.addAttribute("notes", notes);
		
		return "/item/saigo-view";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* ------------------------------- */
	
	@RequestMapping(value = { "/item/wear", "/item/wear/" })
	public String wear(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<ItemWear> wears = itemWearService.all();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("wears", wears);
		return "/item/wear";
	}
	
	@RequestMapping(value = { "/item/wear/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String wearView(Model model, @PathVariable(name = "id", required = false) Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		ItemWear itemWear = new ItemWear();
		try {
			itemWear = itemWearService.one(id);
		} catch (Exception e) {
			return equipment(model);
		}
		List<String> inOtherLanguages = new ArrayList<String>();
		inOtherLanguages.add(itemWear.getItemNameJa());
		inOtherLanguages.add(itemWear.getItemNameEn());
		inOtherLanguages.add(itemWear.getItemNameEs());

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("itemWear", itemWear);

		return "/item/wear-view";
	}
}
