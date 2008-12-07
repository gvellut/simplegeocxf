package com.vellut.simplegeocxf.server.model;

import java.awt.Color;
import java.util.ArrayList;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vellut.simplegeocxf.server.model.MapLayer;
import com.vellut.simplegeocxf.server.model.MapService;


import static org.junit.Assert.*;

@RunWith(JMock.class)
public class MapServiceTests {
	MapService mapService;
	Mockery context = new JUnit4Mockery();

	@Before
	public void setUp(){
		mapService = new MapService();
	}
	
	@Test
	public void testMapLayers() throws Exception {
		MapLayer mapLayer = new MapLayer();
		ArrayList<MapLayer> mapLayers = new ArrayList<MapLayer>();
		mapLayers.add(mapLayer);
		mapService.setMapLayers(mapLayers);
		assertSame(mapLayer,mapService.getMapLayers().get(0));	
	}
	
	@Test
	public void testName() throws Exception {
		String name = "Sample Service";
		mapService.setName(name);
		assertSame(name,mapService.getName());
	}
	
	@Test
	public void testCrs() throws Exception {
		CoordinateReferenceSystem crs = context.mock(CoordinateReferenceSystem.class);
		mapService.setCrs(crs);
		assertSame(crs,mapService.getCrs());
	}
	
	@Test
	public void testBackground() throws Exception {
		Color color = Color.BLACK;
		mapService.setBackground(color);
		assertSame(color,mapService.getBackground());
	}
	
	
}
