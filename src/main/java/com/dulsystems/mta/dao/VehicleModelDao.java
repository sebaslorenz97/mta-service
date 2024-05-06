package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.dao.mapper.VehicleLineMapper;
import com.dulsystems.mta.dao.mapper.VehicleModelMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class VehicleModelDao implements IVehicleModelDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public VehicleModelBean searchVehicleModelByModel(String vehicleModel) {
		try {
			VehicleModelBean vmb = jdbcTemplate.queryForObject(Queries.Q_VEHICLES_MODEL_SEARCH_BY_MODEL, new VehicleModelMapper(), vehicleModel);
			return vmb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveVehicleModel(RequestBean request, VehicleLineBean vlb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_MODEL_SAVE, new Object[] { vlb.getVehicleLineId(), request.getVehicleModel() });
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateVehicleModelByModel(RequestBean request, VehicleLineBean vlb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_MODEL_UPDATE_BY_MODEL, new Object[] { vlb.getVehicleLineId(), request.getNewVehicleModel(), request.getVehicleModel() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeVehicleModelByModel(String vehicleModel) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_VEHICLES_MODEL_REMOVE_BY_MODEL, vehicleModel);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
