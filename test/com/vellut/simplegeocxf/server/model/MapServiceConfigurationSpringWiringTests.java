package com.vellut.simplegeocxf.server.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vellut.simplegeocxf.server.model.MapLayer;
import com.vellut.simplegeocxf.server.model.MapService;
import com.vellut.simplegeocxf.server.model.MapServiceConfiguration;
import com.vellut.simplegeocxf.server.service.SimpleGeoServiceImpl;
import com.vellut.simplegeocxf.server.service.model.MapSize;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/vellut/opengeoreports/server/model/context.xml",
		"classpath:com/vellut/opengeoreports/server/model/sample-service.xml" })
public class MapServiceConfigurationSpringWiringTests {
	private MapServiceConfiguration mapServiceConfiguration;

	@Autowired
	public void setMapServiceConfiguration(
			MapServiceConfiguration mapServiceconfiguration) {
		this.mapServiceConfiguration = mapServiceconfiguration;
	}

	@Test
	public void testMapServiceConfiguration() {
		assertNotNull(mapServiceConfiguration);
		assertEquals(1, mapServiceConfiguration.getMapServices().size());
		assertNotNull(mapServiceConfiguration.getMapServices().get(
				"sample-service"));
	}

	@Test
	public void testMapService() {
		MapService mapService = mapServiceConfiguration.getMapServices().get(
				"sample-service");
		assertNotNull(mapService.getBackground());
		assertEquals(255, mapService.getBackground().getAlpha());
		assertEquals(150, mapService.getBackground().getRed());
		assertEquals(200, mapService.getBackground().getGreen());
		assertEquals(255, mapService.getBackground().getBlue());

		assertNotNull(mapService.getCrs());
		assertEquals("WGS 84", mapService.getCrs().getName().getCode());

		assertEquals(3, mapService.getMapLayers().size());
	}

	@Test
	public void testMapLayer() {
		MapService mapService = mapServiceConfiguration.getMapServices().get(
				"sample-service");
		MapLayer mapLayer1 = mapService.getMapLayers().get(0);
		assertEquals("Layer 1", mapLayer1.getName());
		assertNotNull(mapLayer1.getStyle());
	}

	@Test
	public void testDraw() {
		SimpleGeoServiceImpl openGeoreports = new SimpleGeoServiceImpl();
		openGeoreports.setMapServiceConfiguration(mapServiceConfiguration);
		byte[] mapImage = openGeoreports.getMapImage("sample-service", new MapSize(500,500), "png");
		assertNotNull(mapImage);
		assertTrue(mapImage.length > 0);
	}

}
