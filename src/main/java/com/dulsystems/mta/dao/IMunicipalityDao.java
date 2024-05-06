package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;

public interface IMunicipalityDao {
	
	MunicipalityBean searchMunicipalityById(Integer id);
	
	MunicipalityBean searchMunicipalityByMunicipality(String municipality);
	
	boolean executeSaveMunicipality(RequestBean request, StateBean sb);
	
	boolean executeUpdateMunicipalityByMunicipality(RequestBean request, StateBean sb);
	
	boolean removeMunicipalityByMunicipality(String municipality);

}
