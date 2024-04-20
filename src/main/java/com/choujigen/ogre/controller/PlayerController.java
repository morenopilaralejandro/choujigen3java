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

import com.choujigen.ogre.domain.HissatsuBlock;
import com.choujigen.ogre.domain.HissatsuCatch;
import com.choujigen.ogre.domain.HissatsuDribble;
import com.choujigen.ogre.domain.HissatsuShoot;
import com.choujigen.ogre.domain.HissatsuSkill;
import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.PlayerLearnsHissatsu;
import com.choujigen.ogre.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/player/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String player(Model model, @PathVariable("id") Long id) {
		/* declare */
		/* general */
		Locale locale = LocaleContextHolder.getLocale();
		List<String> inOtherLanguages = new ArrayList<String>();
		Player player = new Player();
		try {
			player = playerService.one(id);
		} catch (Exception e) {
			return binder(model);
		}
		player.updatePlayerStats();
		/* versions */
		List<Player> versions = new ArrayList<Player>();
		/* hissatsu */
		List<PlayerLearnsHissatsu> playerLearnsHissatsu = player.getPlayerLearnsHissatsu();
		playerLearnsHissatsu.sort(Comparator.comparing(PlayerLearnsHissatsu::getLearnOrder));
		int arrayLength = playerLearnsHissatsu.size();
		ItemHissatsu auxHissatsu = null;
		HissatsuShoot[] shootArray = new HissatsuShoot[arrayLength];
		HissatsuDribble[] dribbleArray = new HissatsuDribble[arrayLength];
		HissatsuBlock[] blockArray = new HissatsuBlock[arrayLength];
		HissatsuCatch[] catchArray = new HissatsuCatch[arrayLength];
		HissatsuSkill[] skillArray = new HissatsuSkill[arrayLength];

		/* do */
		/* versions */
		if (player.getOriginalVersion() == null) {
			if (!player.getAltVersion().isEmpty()) {
				versions = player.getAltVersion();
			}
		} else {
			/* exclude current player */
			versions.add(player.getOriginalVersion());
			for (Player p : player.getOriginalVersion().getAltVersion()) {
				if (p.getPlayerId() != player.getPlayerId()) {
					versions.add(p);
				}
			}
		}

		/* hissatsu */
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

		/* model-add */
		/* general */
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("inOtherLanguages", inOtherLanguages);
		model.addAttribute("player", player);
		/* versions */
		model.addAttribute("versions", versions);
		/* hissatsu */
		model.addAttribute("playerLearnsHissatsu", playerLearnsHissatsu);
		model.addAttribute("shootArray", shootArray);
		model.addAttribute("dribbleArray", dribbleArray);
		model.addAttribute("blockArray", blockArray);
		model.addAttribute("catchArray", catchArray);
		model.addAttribute("skillArray", skillArray);
		return "/player";
	}

	@RequestMapping(value = { "/player-binder", "/player-binder/" })
	public String binder(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		switch (locale.getLanguage()) {
		case "ja":
			return "/binder/binder-ja";
		default:
			return "/binder/binder-en";
		}
	}
	/* player-binder-ja */
	@RequestMapping(value = { "/player-binder/a", "/player-binder/a/" })
	public String binderA(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		Player aoi = playerService.one(2293L);
		List<Player> oAux = new ArrayList<Player>();

		List<Player> a = playerService.findByPlayerIdBetween(1L, 79L);
		List<Player> i = playerService.findByPlayerIdBetween(80L, 162L);
		List<Player> u = playerService.findByPlayerIdBetween(163L, 201L);
		List<Player> e = playerService.findByPlayerIdBetween(202L, 220L);
		List<Player> o = playerService.findByPlayerIdBetween(221L, 289L);

		oAux.add(aoi);
		oAux.addAll(o);

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("a", a);
		model.addAttribute("i", i);
		model.addAttribute("u", u);
		model.addAttribute("e", e);
		model.addAttribute("o", oAux);

		return "/binder/binder-ja-a";
	}

	@RequestMapping(value = { "/player-binder/ka", "/player-binder/ka/" })
	public String binderKa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ka", playerService.findByPlayerIdBetween(290L, 401L));
		model.addAttribute("ki", playerService.findByPlayerIdBetween(402L, 437L));
		model.addAttribute("ku", playerService.findByPlayerIdBetween(438L, 486L));
		model.addAttribute("ke", playerService.findByPlayerIdBetween(487L, 498L));
		model.addAttribute("ko", playerService.findByPlayerIdBetween(499L, 557L));

		return "/binder/binder-ja-ka";
	}

	@RequestMapping(value = { "/player-binder/sa", "/player-binder/sa/" })
	public String binderSa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("sa", playerService.findByPlayerIdBetween(558L, 624L));
		model.addAttribute("shi", playerService.findByPlayerIdBetween(625L, 720L));
		model.addAttribute("su", playerService.findByPlayerIdBetween(721L, 750L));
		model.addAttribute("se", playerService.findByPlayerIdBetween(751L, 770L));
		model.addAttribute("so", playerService.findByPlayerIdBetween(771L, 793L));
		
		return "/binder/binder-ja-sa";
	}
	
	@RequestMapping(value = { "/player-binder/ta", "/player-binder/ta/" })
	public String binderTa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ta", playerService.findByPlayerIdBetween(794L, 878L));
		model.addAttribute("chi", playerService.findByPlayerIdBetween(879L, 899L));
		model.addAttribute("tsu", playerService.findByPlayerIdBetween(900L, 914L));
		model.addAttribute("te", playerService.findByPlayerIdBetween(915L, 939L));
		model.addAttribute("to", playerService.findByPlayerIdBetween(940L, 988L));
		
		return "/binder/binder-ja-ta";
	}
	
	@RequestMapping(value = { "/player-binder/na", "/player-binder/na/" })
	public String binderNa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("na", playerService.findByPlayerIdBetween(989L, 1050L));
		model.addAttribute("ni", playerService.findByPlayerIdBetween(1051L, 1071L));
		model.addAttribute("nu", playerService.findByPlayerIdBetween(1072L, 1078L));
		model.addAttribute("ne", playerService.findByPlayerIdBetween(1079L, 1088L));
		model.addAttribute("no", playerService.findByPlayerIdBetween(1089L, 1102L));
		
		return "/binder/binder-ja-na";
	}
	
	@RequestMapping(value = { "/player-binder/ha", "/player-binder/ha/" })
	public String binderHa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ha", playerService.findByPlayerIdBetween(1103L, 1163L));
		model.addAttribute("hi", playerService.findByPlayerIdBetween(1164L, 1221L));
		model.addAttribute("fu", playerService.findByPlayerIdBetween(1222L, 1285L));
		model.addAttribute("he", playerService.findByPlayerIdBetween(1286L, 1292L));
		model.addAttribute("ho", playerService.findByPlayerIdBetween(1293L, 1319L));
		
		return "/binder/binder-ja-ha";
	}
	
	@RequestMapping(value = { "/player-binder/ma", "/player-binder/ma/" })
	public String binderMa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ma", playerService.findByPlayerIdBetween(1320L, 1374L));
		model.addAttribute("mi", playerService.findByPlayerIdBetween(1375L, 1413L));
		model.addAttribute("mu", playerService.findByPlayerIdBetween(1414L, 1424L));
		model.addAttribute("me", playerService.findByPlayerIdBetween(1425L, 1434L));
		model.addAttribute("mo", playerService.findByPlayerIdBetween(1435L, 1452L));
		
		return "/binder/binder-ja-ma";
	}
	
	@RequestMapping(value = { "/player-binder/ya", "/player-binder/ya/" })
	public String binderYa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ya", playerService.findByPlayerIdBetween(1453L, 1487L));
		model.addAttribute("yu", playerService.findByPlayerIdBetween(1488L, 1509L));
		model.addAttribute("yo", playerService.findByPlayerIdBetween(1510L, 1534L));
		
		return "/binder/binder-ja-ya";
	}
	
	@RequestMapping(value = { "/player-binder/ra", "/player-binder/ra/" })
	public String binderRa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("ra", playerService.findByPlayerIdBetween(1535L, 1551L));
		model.addAttribute("ri", playerService.findByPlayerIdBetween(1552L, 1568L));
		model.addAttribute("ru", playerService.findByPlayerIdBetween(1569L, 1571L));
		model.addAttribute("re", playerService.findByPlayerIdBetween(1572L, 1583L));
		model.addAttribute("ro", playerService.findByPlayerIdBetween(1584L, 1592L));
		
		return "/binder/binder-ja-ra";
	}	
	
	@RequestMapping(value = { "/player-binder/wa", "/player-binder/wa/" })
	public String binderWa(Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		model.addAttribute("wa", playerService.findByPlayerIdBetween(1593L, 1607L));
		
		return "/binder/binder-ja-wa";
	}	
	/* player-binder-en 
	 * abc
	 * def
	 * ghi
	 * jkl
	 * mno
	 * pqrs
	 * tuv
	 * wxyz
	 * */
	@RequestMapping(value = { "/player-binder/abc", "/player-binder/abc/" })
	public String binderAbc(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "ABC";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = null;
		String prevUrl = null;
		String nextText = "def";
		String nextUrl = "/player-binder/def";
		
		subtitles.add("a");
		subtitles.add("b");
		subtitles.add("c");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("a"));
		sections.add(playerService.findByInitialEn("b"));
		sections.add(playerService.findByInitialEn("c"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}		
	
	@RequestMapping(value = { "/player-binder/def", "/player-binder/def/" })
	public String binderDef(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "DEF";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "abc";
		String prevUrl = "/player-binder/abc";
		String nextText = "ghi";
		String nextUrl = "/player-binder/ghi";
		
		subtitles.add("d");
		subtitles.add("e");
		subtitles.add("f");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("d"));
		sections.add(playerService.findByInitialEn("e"));
		
		Player aoi = playerService.one(2293L);
		List<Player> fAux = new ArrayList<Player>();
		List<Player> f = playerService.findByInitialEn("f");
		fAux.add(aoi);
		fAux.addAll(f);
		fAux.sort(Comparator.comparing(Player::getPlayerNameEn));
		sections.add(fAux);

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}
	
	@RequestMapping(value = { "/player-binder/ghi", "/player-binder/ghi/" })
	public String binderGhi(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "GHI";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "def";
		String prevUrl = "/player-binder/def";
		String nextText = "jkl";
		String nextUrl = "/player-binder/jkl";
		
		subtitles.add("g");
		subtitles.add("h");
		subtitles.add("i");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("g"));
		sections.add(playerService.findByInitialEn("h"));
		sections.add(playerService.findByInitialEn("i"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}
	
	@RequestMapping(value = { "/player-binder/jkl", "/player-binder/jkl/" })
	public String binderJkl(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "JKL";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "ghi";
		String prevUrl = "/player-binder/ghi";
		String nextText = "mno";
		String nextUrl = "/player-binder/mno";
		
		subtitles.add("j");
		subtitles.add("k");
		subtitles.add("l");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("j"));
		sections.add(playerService.findByInitialEn("k"));
		sections.add(playerService.findByInitialEn("l"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}
	
	@RequestMapping(value = { "/player-binder/mno", "/player-binder/mno/" })
	public String binderMno(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "MNO";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "jkl";
		String prevUrl = "/player-binder/jkl";
		String nextText = "pqrs";
		String nextUrl = "/player-binder/pqrs";
		
		subtitles.add("m");
		subtitles.add("n");
		subtitles.add("o");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("m"));
		sections.add(playerService.findByInitialEn("n"));
		sections.add(playerService.findByInitialEn("o"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}
	
	@RequestMapping(value = { "/player-binder/pqrs", "/player-binder/pqrs/" })
	public String binderPqrs(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "PQRS";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "mno";
		String prevUrl = "/player-binder/mno";
		String nextText = "tuv";
		String nextUrl = "/player-binder/tuv";
		
		subtitles.add("p");
		subtitles.add("q");
		subtitles.add("r");
		subtitles.add("s");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("p"));
		sections.add(playerService.findByInitialEn("q"));
		sections.add(playerService.findByInitialEn("r"));
		sections.add(playerService.findByInitialEn("s"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}
	
	@RequestMapping(value = { "/player-binder/tuv", "/player-binder/tuv/" })
	public String binderTuv(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "TUV";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "pqrs";
		String prevUrl = "/player-binder/pqrs";
		String nextText = "wxyz";
		String nextUrl = "/player-binder/wxyz";
		
		subtitles.add("t");
		subtitles.add("u");
		subtitles.add("v");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("t"));
		sections.add(playerService.findByInitialEn("u"));
		sections.add(playerService.findByInitialEn("v"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}
	
	@RequestMapping(value = { "/player-binder/wxyz", "/player-binder/wxyz/" })
	public String binderWxyz(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String title = "WXYZ";
		List<String> subtitles = new ArrayList<String>();
		int sourceNumber = 0;
		List<List<Player>> sections = new ArrayList<List<Player>>();
		String prevText = "tuv";
		String prevUrl = "/player-binder/tuv";
		String nextText = null;
		String nextUrl = null;
		
		subtitles.add("w");
		subtitles.add("x");
		subtitles.add("y");
		subtitles.add("z");
		sourceNumber = subtitles.size() + 1;
		
		sections.add(playerService.findByInitialEn("w"));
		sections.add(playerService.findByInitialEn("x"));
		sections.add(playerService.findByInitialEn("y"));
		sections.add(playerService.findByInitialEn("z"));

		model.addAttribute("url", null);
		model.addAttribute("currentLang", locale.getLanguage());
		
		model.addAttribute("title", title);
		model.addAttribute("subtitles", subtitles);
		model.addAttribute("sourceNumber", sourceNumber);
		model.addAttribute("sections", sections);
		model.addAttribute("prevText", prevText);
		model.addAttribute("prevUrl", prevUrl);
		model.addAttribute("nextText", nextText);
		model.addAttribute("nextUrl", nextUrl);
		
		return "/binder/binder-en-view";
	}

}
