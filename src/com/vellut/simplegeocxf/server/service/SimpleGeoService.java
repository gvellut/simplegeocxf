package com.vellut.simplegeocxf.server.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.vellut.simplegeocxf.server.service.model.MapSize;

@WebService
public interface SimpleGeoService {
	public byte[] getMapImage(@WebParam(name = "mapServiceName")
	String mapServiceName, @WebParam(name="mapSize") MapSize mapSize, @WebParam(name = "format")
	String format);
}
