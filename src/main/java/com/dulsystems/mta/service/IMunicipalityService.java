package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IMunicipalityService {
	
	ResponseBean searchMunicipalityByMunicipality(String municipality);
	
	ResponseBean executeSaveMunicipality(RequestBean request);
	
	ResponseBean executeUpdateMunicipalityByMunicipality(RequestBean request);
	
	ResponseBean removeMunicipalityByMunicipality(String municipality);

}
