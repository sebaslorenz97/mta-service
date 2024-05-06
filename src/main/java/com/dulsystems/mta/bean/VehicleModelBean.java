package com.dulsystems.mta.bean;

public class VehicleModelBean {
	
	private Integer vehicleModelId;
	private String vehicleModelName;
	private String vehicleLineNameFk;
	private Integer vehicleLineIdFk;
	
	public Integer getVehicleModelId() {
		return vehicleModelId;
	}
	public void setVehicleModelId(Integer vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}
	public String getVehicleModelName() {
		return vehicleModelName;
	}
	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}
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

}
