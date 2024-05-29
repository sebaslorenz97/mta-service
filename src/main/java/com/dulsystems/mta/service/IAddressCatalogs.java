package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IAddressCatalogs {
	
	//SERVICES FOR STATES
	ResponseBean searchStateByState(String state);
	ResponseBean executeSaveState(RequestBean request);
	ResponseBean executeUpdateStateByState(RequestBean request);
	ResponseBean removeStateByState(String state);
	
	//SERVICES FOR MUNICIPALITIES
	ResponseBean searchMunicipalityByMunicipality(String municipality);
	ResponseBean executeSaveMunicipality(RequestBean request);
	ResponseBean executeUpdateMunicipalityByMunicipality(RequestBean request);
	ResponseBean removeMunicipalityByMunicipality(String municipality);
}
