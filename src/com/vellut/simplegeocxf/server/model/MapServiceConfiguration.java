package com.vellut.simplegeocxf.server.model;

import java.util.Map;

public class MapServiceConfiguration {
	private Map<String,MapService> mapServices;

	public void setMapServices(Map<String, MapService> mapServices) {
		this.mapServices = mapServices;
	}

	public Map<String, MapService> getMapServices() {
		return mapServices;
	}

}
