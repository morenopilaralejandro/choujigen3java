package com.choujigen.ogre.form;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.service.ItemHissatsuService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HissatsuNameValidator implements ConstraintValidator<HissatsuNameConstraint, String> {
	@Autowired
	private ItemHissatsuService itemHissatsuService;
	
	@Override
	public void initialize(HissatsuNameConstraint hissatsuNameConstraint) {
	}

	@Override
	public boolean isValid(String hissatsuName, ConstraintValidatorContext cxt) {
		List<ItemHissatsu> itemHissatsuAux;
		if(hissatsuName == null || hissatsuName.isEmpty()) {
			return true;
		} else {
			try{
				Locale locale = LocaleContextHolder.getLocale();
				switch (locale.getLanguage()) {
				case "ja":
					itemHissatsuAux = itemHissatsuService.findByItemNameJa(hissatsuName);
					break;
				case "en":
					itemHissatsuAux = itemHissatsuService.findByItemNameEn(hissatsuName);
					break;
				case "es":
					itemHissatsuAux = itemHissatsuService.findByItemNameEs(hissatsuName);
					break;
				default:
					itemHissatsuAux = itemHissatsuService.findByItemNameEn(hissatsuName);
				}
				if(itemHissatsuAux.isEmpty()) {
					return false;
				} else {
					return true;
				}
			}catch (Exception e) {
				return false;
			}			
		}
	}
}
