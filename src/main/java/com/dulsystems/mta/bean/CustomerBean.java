package com.dulsystems.mta.bean;

public class CustomerBean {
	
	private Integer customerId;
	private String name;
	private Boolean privateEnterprise;
	private String reference;
	private String rfcKey;
	private String cp;
	private String email;
	private String phoneNumber;
	private String stateNameFk;
	private String municipalityNameFk;
	private Integer stateIdFk;
	private Integer municipalityIdFk;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getPrivateEnterprise() {
		return privateEnterprise;
	}
	public void setPrivateEnterprise(Boolean privateEnterprise) {
		this.privateEnterprise = privateEnterprise;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getRfcKey() {
		return rfcKey;
	}
	public void setRfcKey(String rfcKey) {
		this.rfcKey = rfcKey;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStateNameFk() {
		return stateNameFk;
	}
	public void setStateNameFk(String stateNameFk) {
		this.stateNameFk = stateNameFk;
	}
	public String getMunicipalityNameFk() {
		return municipalityNameFk;
	}
	public void setMunicipalityNameFk(String municipalityNameFk) {
		this.municipalityNameFk = municipalityNameFk;
	}
	public Integer getStateIdFk() {
		return stateIdFk;
	}
	public void setStateIdFk(Integer stateIdFk) {
		this.stateIdFk = stateIdFk;
	}
	public Integer getMunicipalityIdFk() {
		return municipalityIdFk;
	}
	public void setMunicipalityIdFk(Integer municipalityIdFk) {
		this.municipalityIdFk = municipalityIdFk;
	}
	
}
