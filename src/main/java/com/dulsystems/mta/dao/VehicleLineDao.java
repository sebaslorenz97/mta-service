package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.dao.mapper.StateMapper;
import com.dulsystems.mta.dao.mapper.VehicleLineMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class VehicleLineDao implements IVehicleLineDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public VehicleLineBean searchVehicleLineByLine(String vehicleLine) {
		try {
			VehicleLineBean vlb = jdbcTemplate.queryForObject(Queries.Q_VEHICLES_LINE_SEARCH_BY_LINE, new VehicleLineMapper(), vehicleLine);
			return vlb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveVehicleLine(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_LINE_SAVE, new Object[] { request.getVehicleLine() });
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateVehicleLineByLine(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_LINE_UPDATE_BY_LINE, new Object[] { request.getNewVehicleLine(), request.getVehicleLine() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeVehicleLineByLine(String vehicleLine) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_LINE_REMOVE_BY_LINE, vehicleLine);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
