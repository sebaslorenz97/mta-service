package com.dulsystems.mta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.mapper.VehicleLineMapper;
import com.dulsystems.mta.dao.mapper.VehicleModelMapper;
import com.dulsystems.mta.dao.mapper.VehicleYearMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class VehicleCatalogDao implements IVehicleCatalogsDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> searchVehicleLines() {
		try {
			List<String> lines = jdbcTemplate.queryForList(Queries.Q_VEHICLE_LINES_SEARCH_ALL, String.class);
			return lines;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<String> searchVehicleModels() {
		try {
			List<String> models = jdbcTemplate.queryForList(Queries.Q_VEHICLE_MODELS_SEARCH_ALL, String.class);
			return models;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<String> searchVehicleYears() {
		try {
			List<String> years = jdbcTemplate.queryForList(Queries.Q_VEHICLE_YEARS_SEARCH_ALL, String.class);
			return years;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	//DAO FOR VEHICLE LINE
	@Override
	public VehicleLineBean searchVehicleLineByLine(String vehicleLine) {
		try {
			VehicleLineBean vlb = null;
			vlb = jdbcTemplate.queryForObject(Queries.Q_VEHICLES_LINE_SEARCH_BY_LINE, new VehicleLineMapper(), vehicleLine);
			return vlb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public VehicleLineBean searchVehicleLineById(Integer vehicleId) {
		try {
			VehicleLineBean vlb = null;
			vlb = jdbcTemplate.queryForObject(Queries.Q_VEHICLES_LINE_SEARCH_BY_ID, new VehicleLineMapper(), vehicleId);
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
	
	//DAO FOR VEHICLE MODEL
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
		
	//DAO FOR VEHICLE YEAR
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
