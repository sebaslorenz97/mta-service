package com.dulsystems.mta.bean;

public class QuoteBean {
	
	private Integer quoteId;
	private String quoteOrderDate;
	private String quoteDeadline;
	private String quoteStatusVehicle;
	private Boolean quotePaymentMethod;
	private Boolean quotePaymentStatus;
	private Integer quoteAdvancePayment;
	private Boolean quoteRequireInvoice;
	private Integer vehicleIdFk;
	private String vehicleNameFk;
	
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
	public Integer getVehicleIdFk() {
		return vehicleIdFk;
	}
	public void setVehicleIdFk(Integer vehicleIdFk) {
		this.vehicleIdFk = vehicleIdFk;
	}
	public String getVehicleNameFk() {
		return vehicleNameFk;
	}
	public void setVehicleNameFk(String vehicleNameFk) {
		this.vehicleNameFk = vehicleNameFk;
	}

}
