package com.choujigen.ogre.form;

import com.choujigen.ogre.domain.Attri;
import com.choujigen.ogre.domain.Gender;
import com.choujigen.ogre.domain.ItemHissatsu;
import com.choujigen.ogre.domain.Positi;

import jakarta.validation.constraints.Size;

public class PlayerSearch {
	@Size(max = 32)
	private String playerName;

	private Long attri;

	private Long positi;

	private Long gender;

	private Attri attriObj;

	private Positi positiObj;

	private Gender genderObj;

	@Size(max = 32)
	@HissatsuNameConstraint
	private String hissatsu1;

	@Size(max = 32)
	@HissatsuNameConstraint
	private String hissatsu2;

	@Size(max = 32)
	@HissatsuNameConstraint
	private String hissatsu3;

	@Size(max = 32)
	@HissatsuNameConstraint
	private String hissatsu4;

	private ItemHissatsu[] hissatsuArray;
	
	public Attri getAttriObj() {
		return attriObj;
	}

	public void setAttriObj(Attri attriObj) {
		this.attriObj = attriObj;
	}

	public Positi getPositiObj() {
		return positiObj;
	}

	public void setPositiObj(Positi positiObj) {
		this.positiObj = positiObj;
	}

	public Gender getGenderObj() {
		return genderObj;
	}

	public void setGenderObj(Gender genderObj) {
		this.genderObj = genderObj;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getAttri() {
		return attri;
	}

	public void setAttri(Long attri) {
		this.attri = attri;
	}

	public Long getPositi() {
		return positi;
	}

	public void setPositi(Long positi) {
		this.positi = positi;
	}

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getHissatsu1() {
		return hissatsu1;
	}

	public void setHissatsu1(String hissatsu1) {
		this.hissatsu1 = hissatsu1;
	}

	public String getHissatsu2() {
		return hissatsu2;
	}

	public void setHissatsu2(String hissatsu2) {
		this.hissatsu2 = hissatsu2;
	}

	public String getHissatsu3() {
		return hissatsu3;
	}

	public void setHissatsu3(String hissatsu3) {
		this.hissatsu3 = hissatsu3;
	}

	public String getHissatsu4() {
		return hissatsu4;
	}

	public void setHissatsu4(String hissatsu4) {
		this.hissatsu4 = hissatsu4;
	}

	public ItemHissatsu[] getHissatsuArray() {
		return hissatsuArray;
	}

	public void setHissatsuArray(ItemHissatsu[] hissatsuArray) {
		this.hissatsuArray = hissatsuArray;
	}

}
