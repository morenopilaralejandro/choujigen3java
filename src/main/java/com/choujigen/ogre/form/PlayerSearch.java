package com.choujigen.ogre.form;

import jakarta.validation.constraints.Max;

public class PlayerSearch {
	@Max(32)
	private String playerName;
	
	private Long attri;
	
	private Long gender;
	
	@Max(32)
	private String hissatsu1;
	
	@Max(32)
	private String hissatsu2;
	
	@Max(32)
	private String hissatsu3;
	
	@Max(32)
	private String hissatsu4;

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

	@Override
	public String toString() {
		return "PlayerSearch [playerName=" + playerName + ", attri=" + attri + ", gender=" + gender + ", hissatsu1="
				+ hissatsu1 + ", hissatsu2=" + hissatsu2 + ", hissatsu3=" + hissatsu3 + ", hissatsu4=" + hissatsu4
				+ "]";
	}

}
