package com.dulsystems.mta.bean;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

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
	private UserBean ub;
	private UserRoleBean urb;
	private List<String> roles;
	private List<GrantedAuthority> rolesFromAuthentication;
	
	
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
	/*public List<QuoteDetailBean> getLqdb() {
		return lqdb;
	}
	public void setLqdb(List<QuoteDetailBean> lqdb) {
		this.lqdb = lqdb;
	}*/
	public UserBean getUb() {
		return ub;
	}
	public void setUb(UserBean ub) {
		this.ub = ub;
	}
	public UserRoleBean getUrb() {
		return urb;
	}
	public void setUrb(UserRoleBean urb) {
		this.urb = urb;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List<GrantedAuthority> getRolesFromAuthentication() {
		return rolesFromAuthentication;
	}
	public void setRolesFromAuthentication(List<GrantedAuthority> rolesFromAuthentication) {
		this.rolesFromAuthentication = rolesFromAuthentication;
	}
	
}
