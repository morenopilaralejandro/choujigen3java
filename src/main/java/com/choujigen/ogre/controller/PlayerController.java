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
		Player player = playerService.one(id);
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

}
