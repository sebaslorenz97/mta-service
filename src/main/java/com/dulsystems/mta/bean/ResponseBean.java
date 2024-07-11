package com.dulsystems.mta.bean;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class ResponseBean {

	private String code;
	private String message;
	private String customer;
	private String vehicle;
	private String quote;
	private CustomerBean cb;
	private StateBean sb;
	private MunicipalityBean mb;
	private VehicleBean vb;
	private VehicleLineBean vlb;
	private VehicleModelBean vmb;
	private VehicleYearBean vyb;
	private QuoteBean qb;
	private List<QuoteDetailBean> lqdb;
	private List<VehicleBean> lvb;
	private List<QuoteBean> lqb;
	private UserBean ub;
	private UserRoleBean urb;//
	private List<String> lines;
	private List<String> models;
	private List<String> years;
	private List<String> roles;
	private List<String> vl;
	private List<String> cl;
	private String roleAssignmentOperationResult;
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
	public List<VehicleBean> getLvb() {
		return lvb;
	}
	public void setLvb(List<VehicleBean> lvb) {
		this.lvb = lvb;
	}
	public List<QuoteBean> getLqb() {
		return lqb;
	}
	public void setLqb(List<QuoteBean> lqb) {
		this.lqb = lqb;
	}
	public String getRoleAssignmentOperationResult() {
		return roleAssignmentOperationResult;
	}
	public void setRoleAssignmentOperationResult(String roleAssignmentOperationResult) {
		this.roleAssignmentOperationResult = roleAssignmentOperationResult;
	}
	public List<String> getVl() {
		return vl;
	}
	public void setVl(List<String> vl) {
		this.vl = vl;
	}
	public List<String> getCl() {
		return cl;
	}
	public void setCl(List<String> cl) {
		this.cl = cl;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public List<String> getLines() {
		return lines;
	}
	public void setLines(List<String> lines) {
		this.lines = lines;
	}
	public List<String> getModels() {
		return models;
	}
	public void setModels(List<String> models) {
		this.models = models;
	}
	public List<String> getYears() {
		return years;
	}
	public void setYears(List<String> years) {
		this.years = years;
	}
	
}
