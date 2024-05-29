package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;

public interface IAddressCatalogsDao {
	
	//DAO FOR STATE
	StateBean searchStateById(Integer id);
	StateBean searchStateByState(String state);
	boolean executeSaveState(RequestBean request);
	boolean executeUpdateStateByState(RequestBean request);
	boolean removeStateByState(String state);
	
	//DAO FOR MUNICIPALITY
	MunicipalityBean searchMunicipalityById(Integer id);
	MunicipalityBean searchMunicipalityByMunicipality(String municipality);
	boolean executeSaveMunicipality(RequestBean request, StateBean sb);
	boolean executeUpdateMunicipalityByMunicipality(RequestBean request, StateBean sb);
	boolean removeMunicipalityByMunicipality(String municipality);

}
