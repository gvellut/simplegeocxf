package com.vellut.simplegeocxf.server.model;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.vellut.simplegeocxf.server.model.MapService;
import com.vellut.simplegeocxf.server.model.MapServiceConfiguration;

import static org.junit.Assert.*;

public class MapServiceConfigurationTests {
	MapServiceConfiguration mapServiceConfiguration;
	
	@Before
	public void setUp(){
		mapServiceConfiguration = new MapServiceConfiguration();
	}
	
	@Test
	public void testMapServices(){
		Map<String,MapService> mapServices = new HashMap<String, MapService>();
		MapService mapService = new MapService();
		String name = "Sample Service";
		mapServices.put(name, mapService);
		mapServiceConfiguration.setMapServices(mapServices);
		assertSame(mapService,mapServiceConfiguration.getMapServices().get(name));
	}
	
	
}
