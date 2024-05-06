package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.mapper.MunicipalityMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class MunicipalityDao implements IMunicipalityDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public MunicipalityBean searchMunicipalityById(Integer id) {
		try {
			MunicipalityBean sb = jdbcTemplate.queryForObject(Queries.Q_MUNICIPALITIES_SEARCH_BY_ID, new MunicipalityMapper(), id);
			return sb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public MunicipalityBean searchMunicipalityByMunicipality(String municipality) {
		try {
			MunicipalityBean mb = jdbcTemplate.queryForObject(Queries.Q_MUNICIPALITIES_SEARCH_BY_MUNICIPALITY, new MunicipalityMapper(), municipality);
			System.out.println(mb);
			return mb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveMunicipality(RequestBean request, StateBean sb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_MUNICIPALITIES_SAVE, new Object[] { sb.getStateId(), request.getMunicipalityName() });
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateMunicipalityByMunicipality(RequestBean request, StateBean sb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_MUNICIPALITIES_UPDATE_BY_MUNICIPALITY, new Object[] { sb.getStateId(), request.getNewMunicipalityName(), request.getMunicipalityName() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeMunicipalityByMunicipality(String municipality) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_MUNICIPALITIES_REMOVE_BY_MUNICIPALITY, municipality);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
