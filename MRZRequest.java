package com.parking.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MRZRequest {
	
	 private String subType;
	 private String givenNames;
	 private String surNames;
	 private String birthYear;
	 private String birthMonth;
	 private String birthDate;
	 private String sex;
	 private String issuer;
	 private String expireYear;
	 private String expireMonth;
	 private String expireDate;
	 private String passportNum;
	 private String personalNum;
	 private String nationality;
	 
	 
	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getGivenNames() {
		return givenNames;
	}

	public void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}

	public String getSurNames() {
		return surNames;
	}

	public void setSurNames(String surNames) {
		this.surNames = surNames;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public String getPersonalNum() {
		return personalNum;
	}

	public void setPersonalNum(String personalNum) {
		this.personalNum = personalNum;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	 
		
    @Override
    public String toString() {
        return "subType: "+subType
                +"\ngivenNames: "+givenNames
                +"\nsurNames: "+surNames
                +"\nbirthYear: "+birthYear
                +"\nbirthMonth: "+birthMonth
                +"\nbirthDate: "+birthDate
                +"\nsex: "+sex
                +"\nissuer: "+issuer
                +"\nexpireYear: "+expireYear
                +"\nexpireMonth: "+expireMonth
                +"\nexpireDate: "+expireDate
                +"\npassportNum: "+passportNum
                +"\npersonalNum: "+personalNum
                +"\nnationality: "+nationality;
    }
}
