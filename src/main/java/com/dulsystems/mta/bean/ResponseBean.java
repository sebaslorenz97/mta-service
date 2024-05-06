package com.dulsystems.mta.bean;

import java.util.List;

public class ResponseBean {

	private String code;
	private String message;
	private CustomerBean cb;
	private StateBean sb;
	private MunicipalityBean mb;
	private VehicleBean vb;
	private VehicleLineBean vlb;
	private VehicleModelBean vmb;
	private VehicleYearBean vyb;
	private QuoteBean qb;
	private List<QuoteDetailBean> lqdb;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomerBean getCb() {
		return cb;
	}
	public void setCb(CustomerBean cb) {
		this.cb = cb;
	}
	public VehicleBean getVb() {
		return vb;
	}
	public void setVb(VehicleBean vb) {
		this.vb = vb;
	}
	public StateBean getSb() {
		return sb;
	}
	public void setSb(StateBean sb) {
		this.sb = sb;
	}
	public MunicipalityBean getMb() {
		return mb;
	}
	public void setMb(MunicipalityBean mb) {
		this.mb = mb;
	}
	public VehicleLineBean getVlb() {
		return vlb;
	}
	public void setVlb(VehicleLineBean vlb) {
		this.vlb = vlb;
	}
	public VehicleModelBean getVmb() {
		return vmb;
	}
	public void setVmb(VehicleModelBean vmb) {
		this.vmb = vmb;
	}
	public VehicleYearBean getVyb() {
		return vyb;
	}
	public void setVyb(VehicleYearBean vyb) {
		this.vyb = vyb;
	}
	public QuoteBean getQb() {
		return qb;
	}
	public void setQb(QuoteBean qb) {
		this.qb = qb;
	}
	public List<QuoteDetailBean> getLQdb() {
		return lqdb;
	}
	public void setLQdb(List<QuoteDetailBean> lqdb) {
		this.lqdb = lqdb;
	}
	
}
