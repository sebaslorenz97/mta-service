package com.dulsystems.mta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.mapper.CustomerVehiclesMapper;
import com.dulsystems.mta.dao.mapper.QuoteDetailMapper;
import com.dulsystems.mta.dao.mapper.VehicleMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class VehicleDao implements IVehicleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public VehicleBean searchVehicleByPlate(String plate) {
		try {
			VehicleBean vb = jdbcTemplate.queryForObject(Queries.Q_VEHICLES_SEARCH_BY_PLATE, new VehicleMapper(), plate);
			return vb;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<VehicleBean> searchCustomerVehiclesByCustomerName(Integer customerId){
		try {
			List<VehicleBean> lvb = jdbcTemplate.query(Queries.Q_VEHICLES_SEARCH_CUSTOMER_VEHICLES,  new CustomerVehiclesMapper(), customerId);
			System.out.println(lvb);
			return lvb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		
	}
	
	@Override
	public List<String> searchVehicleByStringPlate(String string){
		try {
			StringBuilder stringB = new StringBuilder();
			stringB.append("%");
			stringB.append(string);
			stringB.append("%");
			List<String> vl = jdbcTemplate.queryForList(Queries.Q_VEHICLES_SEARCH_CONTAINS,  String.class, stringB.toString());
			return vl;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		
	}
	
	@Override
	public boolean executeSaveVehicle(RequestBean request, CustomerBean cb, VehicleLineBean vlb, VehicleModelBean vmb, VehicleYearBean vyb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_SAVE, new Object[] { cb.getCustomerId(), vlb.getVehicleLineId(), vmb.getVehicleModelId(), vyb.getVehicleYearId(), request.getVehicleColor(), request.getVehiclePlate(), request.getVehicleMillage() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateVehicleByPlate(RequestBean request, CustomerBean cb, VehicleLineBean vlb, VehicleModelBean vmb, VehicleYearBean vyb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_UPDATE_BY_PLATE, new Object[] { cb.getCustomerId(), vlb.getVehicleLineId(), vmb.getVehicleModelId(), vyb.getVehicleYearId(), request.getVehicleColor(), request.getNewVehiclePlate(), request.getVehicleMillage(), request.getVehiclePlate() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeVehicleByPlate(String plate) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_REMOVE_BY_PLATE, plate);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
