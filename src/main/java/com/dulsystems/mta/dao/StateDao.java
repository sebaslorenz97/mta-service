package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.mapper.StateMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class StateDao implements IStateDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public StateBean searchStateById(Integer id) {
		try {
			StateBean sb = jdbcTemplate.queryForObject(Queries.Q_STATES_SEARCH_BY_ID, new StateMapper(), id);
			return sb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public StateBean searchStateByState(String state) {
		try {
			StateBean sb = jdbcTemplate.queryForObject(Queries.Q_STATES_SEARCH_BY_STATE, new StateMapper(), state);
			return sb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveState(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_STATES_SAVE, new Object[] { request.getStateName() });
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateStateByState(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_STATES_UPDATE_BY_STATE, new Object[] { request.getNewStateName(), request.getStateName() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeStateByState(String state) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_STATES_REMOVE_BY_STATE, state);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
 