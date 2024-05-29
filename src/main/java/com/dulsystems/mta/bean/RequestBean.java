package com.dulsystems.mta.bean;

import java.util.List;

public class RequestBean {

	//REQUEST FIELDS FOR CUSTOMER
	private Integer customerId;	
	private String customerName;
	private Boolean customerParticularEmpresa;
	private String customerReference;
	private String customerRfc;
	private String customerCp;
	private String customerEmail;
	private String customerPhoneNumber;
	
	//REQUEST FIELDS FOR STATE
	private Integer stateId;
	private String stateName;
	private String newStateName;
	
	//REQUEST FIELDS FOR MUNICIPALITY
	private Integer municipalityId;
	private String municipalityName;
	private String newMunicipalityName;
	
	//REQUEST FIELDS FOR VEHICLE
	private Integer vehicleId;
	private String vehiclePlate;
	private String newVehiclePlate;
	private String vehicleColor;
	private Integer vehicleMillage;
	
	//REQUEST FIELDS FOR VEHICLE LINE
	private Integer vehicleLineId;
	private String vehicleLine;
	private String newVehicleLine;
	
	//REQUEST FIELDS FOR VEHICLE YEAR
	private Integer vehicleYearId;
	private Integer vehicleYearValue;
	private Integer newVehicleYearValue;
	
	//REQUEST FIELDS FOR VEHICLE MODEL
	private Integer vehicleModelId;
	private String vehicleModel;
	private String newVehicleModel;
	
	//REQUEST FIELDS FOR QUOTE
	private Integer quoteId;
	private String quoteOrderDate;
	private String quoteDeadline;
	private String quoteStatusVehicle;
	private Boolean quotePaymentMethod;
	private Boolean quotePaymentStatus;
	private Integer quoteAdvancePayment;
	private Boolean quoteRequireInvoice;
	
	//REQUEST FIELDS FOR QUOTE DETAIL
	private Integer quoteDetailIdl;
	private Integer quoteDetailMecId;
	private String quoteDetailLabour;
	private Integer quoteDetailAmount;
	
	//REQUEST FIELDS FOR QUOTE DETAILS LIST
	private List<QuoteDetailBean> lqdb;
	
	//FKs FOR CUSTOMER ONLY
	private String municipalityNameFk;
	private Integer municipalityIdFk;
	//FKs FOR CUSTOMER & MUNICIPALITY
	private String stateNameFk;
	private Integer stateIdFk;
	//FKs FOR VEHICLE ONLY
	private String customerNameFk;
	private Integer customerIdFk;
	private String vehicleModelNameFk;
	private Integer vehicleModelIdFk;
	private Integer vehicleYearValueFk;
	private Integer vehicleYearIdFk;
	//FKs FOR VEHICLE & VEHICLE MODEL
	private String vehicleLineNameFk;
	private Integer vehicleLineIdFk;
	//FKs FOR QUOTE
	private Integer vehicleIdFk;
	//FKs FOR QUOTE DETAILS
	private Integer quoteIdFk;
	
	
	
	//GETTERS AND SETTERS FOR CUSTOMER FIELDS
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Boolean getCustomerParticularEmpresa() {
		return customerParticularEmpresa;
	}
	public void setCustomerParticularEmpresa(Boolean customerParticularEmpresa) {
		this.customerParticularEmpresa = customerParticularEmpresa;
	}
	public String getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	public String getCustomerRfc() {
		return customerRfc;
	}
	public void setCustomerRfc(String customerRfc) {
		this.customerRfc = customerRfc;
	}
	public String getCustomerCp() {
		return customerCp;
	}
	public void setCustomerCp(String customerCp) {
		this.customerCp = customerCp;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	//GETTERS AND SETTERS FOR STATE FIELDS
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getNewStateName() {
		return newStateName;
	}
	public void setNewStateName(String newStateName) {
		this.newStateName = newStateName;
	}
	
	//GETTERS AND SETTERS FOR MUNICIPALITY FIELDS
	public Integer getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(Integer municipalityId) {
		this.municipalityId = municipalityId;
	}
	public String getMunicipalityName() {
		return municipalityName;
	}
	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
	}
	public String getNewMunicipalityName() {
		return newMunicipalityName;
	}
	public void setNewMunicipalityName(String newMunicipalityName) {
		this.newMunicipalityName = newMunicipalityName;
	}
	
	//GETTERS AND SETTERS FOR VEHICLE FIELDS
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getVehiclePlate() {
		return vehiclePlate;
	}
	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}
	public String getNewVehiclePlate() {
		return newVehiclePlate;
	}
	public void setNewVehiclePlate(String newVehiclePlate) {
		this.newVehiclePlate = newVehiclePlate;
	}
	public Integer getVehicleMillage() {
		return vehicleMillage;
	}
	public void setVehicleMillage(Integer vehicleMillage) {
		this.vehicleMillage = vehicleMillage;
	}
	
	//GETTERS AND SETTERS FOR VEHICLE LINE FIELDS
	public Integer getVehicleLineId() {
		return vehicleLineId;
	}
	public void setVehicleLineId(Integer vehicleLineId) {
		this.vehicleLineId = vehicleLineId;
	}
	public String getVehicleLine() {
		return vehicleLine;
	}
	public void setVehicleLine(String vehicleLine) {
		this.vehicleLine = vehicleLine;
	}
	public String getNewVehicleLine() {
		return newVehicleLine;
	}
	public void setNewVehicleLine(String newVehicleLine) {
		this.newVehicleLine = newVehicleLine;
	}
	
	//GETTERS AND SETTERS FOR VEHICLE YEAR FIELDS
	public Integer getVehicleYearId() {
		return vehicleYearId;
	}
	public void setVehicleYearId(Integer vehicleYearId) {
		this.vehicleYearId = vehicleYearId;
	}
	public Integer getVehicleYearValue() {
		return vehicleYearValue;
	}
	public void setVehicleYearValue(Integer vehicleYearValue) {
		this.vehicleYearValue = vehicleYearValue;
	}
	public Integer getNewVehicleYearValue() {
		return newVehicleYearValue;
	}
	public void setNewVehicleYearValue(Integer newVehicleYearValue) {
		this.newVehicleYearValue = newVehicleYearValue;
	}
	
	//GETTERS AND SETTERS FOR VEHICLE MODEL FIELDS
	public Integer getVehicleModelId() {
		return vehicleModelId;
	}
	public void setVehicleModelId(Integer vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getNewVehicleModel() {
		return newVehicleModel;
	}
	public void setNewVehicleModel(String newVehicleModel) {
		this.newVehicleModel = newVehicleModel;
	}
	
	//REQUEST FIELDS FOR QUOTE
	public Integer getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}
	public String getQuoteOrderDate() {
		return quoteOrderDate;
	}
	public void setQuoteOrderDate(String quoteOrderDate) {
		this.quoteOrderDate = quoteOrderDate;
	}
	public String getQuoteDeadline() {
		return quoteDeadline;
	}
	public void setQuoteDeadline(String quoteDeadline) {
		this.quoteDeadline = quoteDeadline;
	}
	public String getQuoteStatusVehicle() {
		return quoteStatusVehicle;
	}
	public void setQuoteStatusVehicle(String quoteStatusVehicle) {
		this.quoteStatusVehicle = quoteStatusVehicle;
	}
	public Boolean getQuotePaymentMethod() {
		return quotePaymentMethod;
	}
	public void setQuotePaymentMethod(Boolean quotePaymentMethod) {
		this.quotePaymentMethod = quotePaymentMethod;
	}
	public Boolean getQuotePaymentStatus() {
		return quotePaymentStatus;
	}
	public void setQuotePaymentStatus(Boolean quotePaymentStatus) {
		this.quotePaymentStatus = quotePaymentStatus;
	}
	public Integer getQuoteAdvancePayment() {
		return quoteAdvancePayment;
	}
	public void setQuoteAdvancePayment(Integer quoteAdvancePayment) {
		this.quoteAdvancePayment = quoteAdvancePayment;
	}
	public Boolean getQuoteRequireInvoice() {
		return quoteRequireInvoice;
	}
	public void setQuoteRequireInvoice(Boolean quoteRequireInvoice) {
		this.quoteRequireInvoice = quoteRequireInvoice;
	}
	
	//REQUEST FIELDS FOR QUOTE DETAILS
	public Integer getQuoteDetailIdl() {
		return quoteDetailIdl;
	}
	public void setQuoteDetailIdl(Integer quoteDetailIdl) {
		this.quoteDetailIdl = quoteDetailIdl;
	}
	public Integer getQuoteDetailMecId() {
		return quoteDetailMecId;
	}
	public void setQuoteDetailMecId(Integer quoteDetailMecId) {
		this.quoteDetailMecId = quoteDetailMecId;
	}
	public String getQuoteDetailLabour() {
		return quoteDetailLabour;
	}
	public void setQuoteDetailLabour(String quoteDetailLabour) {
		this.quoteDetailLabour = quoteDetailLabour;
	}
	public Integer getQuoteDetailAmount() {
		return quoteDetailAmount;
	}
	public void setQuoteDetailAmount(Integer quoteDetailAmount) {
		this.quoteDetailAmount = quoteDetailAmount;
	}
	
	//REQUEST FIELDS FOR QUOTE DETAILS LIST
	public List<QuoteDetailBean> getLqdb() {
		return lqdb;
	}
	public void setLqdb(List<QuoteDetailBean> lqdb) {
		this.lqdb = lqdb;
	}
	
	//GETTERS AND SETTERS FOR CUSTOMER ONLY FKs FIELDS
	public String getMunicipalityNameFk() {
		return municipalityNameFk;
	}
	public void setMunicipalityNameFk(String municipalityNameFk) {
		this.municipalityNameFk = municipalityNameFk;
	}
	public Integer getMunicipalityIdFk() {
		return municipalityIdFk;
	}
	public void setMunicipalityIdFk(Integer municipalityIdFk) {
		this.municipalityIdFk = municipalityIdFk;
	}
	//GETTERS AND SETTERS FOR CUSTOMER & MUNICIPALITY FKs FIELDS
	public String getStateNameFk() {
		return stateNameFk;
	}
	public void setStateNameFk(String stateNameFk) {
		this.stateNameFk = stateNameFk;
	}
	public Integer getStateIdFk() {
		return stateIdFk;
	}
	public void setStateIdFk(Integer stateIdFk) {
		this.stateIdFk = stateIdFk;
	}
	//GETTERS AND SETTERS FOR VEHICLE ONLY FKs FIELDS
	public String getCustomerNameFk() {
		return customerNameFk;
	}
	public void setCustomerNameFk(String customerNameFk) {
		this.customerNameFk = customerNameFk;
	}
	public Integer getCustomerIdFk() {
		return customerIdFk;
	}
	public void setCustomerIdFk(Integer customerIdFk) {
		this.customerIdFk = customerIdFk;
	}
	public String getVehicleModelNameFk() {
		return vehicleModelNameFk;
	}
	public void setVehicleModelNameFk(String vehicleModelNameFk) {
		this.vehicleModelNameFk = vehicleModelNameFk;
	}
	public Integer getVehicleModelIdFk() {
		return vehicleModelIdFk;
	}
	public void setVehicleModelIdFk(Integer vehicleModelIdFk) {
		this.vehicleModelIdFk = vehicleModelIdFk;
	}
	public Integer getVehicleYearValueFk() {
		return vehicleYearValueFk;
	}
	public void setVehicleYearValueFk(Integer vehicleYearValueFk) {
		this.vehicleYearValueFk = vehicleYearValueFk;
	}
	public Integer getVehicleYearIdFk() {
		return vehicleYearIdFk;
	}
	public void setVehicleYearIdFk(Integer vehicleYearIdFk) {
		this.vehicleYearIdFk = vehicleYearIdFk;
	}
	//GETTERS AND SETTERS FOR VEHICLE & VEHICLE MODEL FKs FIELDS
	public String getVehicleLineNameFk() {
		return vehicleLineNameFk;
	}
	public void setVehicleLineNameFk(String vehicleLineNameFk) {
		this.vehicleLineNameFk = vehicleLineNameFk;
	}
	public Integer getVehicleLineIdFk() {
		return vehicleLineIdFk;
	}
	public void setVehicleLineIdFk(Integer vehicleLineIdFk) {
		this.vehicleLineIdFk = vehicleLineIdFk;
	}
	//GETTERS AND SETTERS FOR QUOTE FKs FIELDS
	public Integer getVehicleIdFk() {
		return vehicleIdFk;
	}
	public void setVehicleIdFk(Integer vehicleIdFk) {
		this.vehicleIdFk = vehicleIdFk;
	}
	//GETTERS AND SETTERS FOR QUOTE DETAILS FKs FIELDS
	public Integer getQuoteIdFk() {
		return quoteIdFk;
	}
	public void setQuoteIdFk(Integer quoteIdFk) {
		this.quoteIdFk = quoteIdFk;
	}
	
}