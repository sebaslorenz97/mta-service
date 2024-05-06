package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.mapper.VehicleLineMapper;
import com.dulsystems.mta.dao.mapper.VehicleYearMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class VehicleYearDao implements IVehicleYearDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public VehicleYearBean searchVehicleYearByYear(Integer vehicleYear) {
		try {
			System.out.println("YEAR -----> "+vehicleYear);
			VehicleYearBean vyb = jdbcTemplate.queryForObject(Queries.Q_VEHICLES_YEAR_SEARCH_BY_YEAR, new VehicleYearMapper(), vehicleYear);
			System.out.println(vyb);
			return vyb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveVehicleYear(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_YEAR_SAVE, new Object[] { request.getVehicleYearValue() });
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateVehicleYearByYear(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_YEAR_UPDATE_BY_YEAR, new Object[] { request.getNewVehicleYearValue(), request.getVehicleYearValue() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeVehicleYearByYear(Integer vehicleYear) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_YEAR_REMOVE_BY_YEAR, vehicleYear);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
