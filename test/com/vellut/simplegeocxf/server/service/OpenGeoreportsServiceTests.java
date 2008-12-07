package com.vellut.simplegeocxf.server.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.referencing.CRS;
import org.geotools.styling.Style;
import org.junit.Test;

import com.vellut.simplegeocxf.server.model.MapLayer;
import com.vellut.simplegeocxf.server.model.MapService;
import com.vellut.simplegeocxf.server.model.MapServiceConfiguration;
import com.vellut.simplegeocxf.server.service.SimpleGeoServiceImpl;
import com.vellut.simplegeocxf.server.service.model.MapSize;
import com.vellut.simplegeocxf.server.utils.SLDStyleBuilder;

import static org.junit.Assert.*;

public class OpenGeoreportsServiceTests {
	
	@Test
	public void testMapServiceConfiguration(){
		SimpleGeoServiceImpl openGeoreports = new SimpleGeoServiceImpl();
		MapServiceConfiguration mapServiceConfiguration = new MapServiceConfiguration();
		openGeoreports.setMapServiceConfiguration(mapServiceConfiguration);
		assertSame(mapServiceConfiguration,openGeoreports.getMapServiceConfiguration());
	}

	@Test
	public void testImageGeneration() throws Exception {
		SimpleGeoServiceImpl openGeoreports = new SimpleGeoServiceImpl();
		MapServiceConfiguration mapServiceConfiguration = new MapServiceConfiguration();
		Map<String, MapService> mapServices = new HashMap<String, MapService>();
		MapService mapService = new MapService();
		String mapServiceName = "sample-service";
		mapService.setName(mapServiceName);
		ArrayList<MapLayer> mapLayers = new ArrayList<MapLayer>();
		MapLayer mapLayer = new MapLayer();
		Map<String, String> params = new HashMap<String, String>();
		params.put("url", "file:build/classes/com/gaiadyne/opengeoreports/server/data/bc_border.shp");
		mapLayer.setDataStore(DataStoreFinder.getDataStore(params));
		mapLayer.setName("bc_border");
		mapLayer.setStyle(createLineStyle());
		mapLayers.add(mapLayer);
		mapService.setMapLayers(mapLayers);
		//TODO set a background default in initialization callback
		mapService.setBackground(Color.WHITE);
		mapService.setCrs(CRS.decode("EPSG:4326"));
		mapServices.put(mapService.getName(), mapService);
		mapServiceConfiguration.setMapServices(mapServices);
		openGeoreports.setMapServiceConfiguration(mapServiceConfiguration);
		
		byte[] mapImage = openGeoreports.getMapImage(mapServiceName,new MapSize(500,500), "png");
		assertNotNull(mapImage);
		assertTrue(mapImage.length > 0);
	}
	
	private Style createLineStyle(){
		String xml = "  <UserStyle>"
	           + " <FeatureTypeStyle>"
	           + "  <Rule>"
	           + "   <LineSymbolizer>"
	           + "    <Stroke>"
	           + "     <CssParameter name=\"stroke\">#ff00ff</CssParameter>"
	           + "     <CssParameter name=\"width\">3.0</CssParameter>"
	           + "    </Stroke>"
	           + "   </LineSymbolizer>"
	           + "  </Rule>"
	           + "  <Rule>"
	           + "   <LineSymbolizer>"
	           + "    <Stroke>"
	           + "     <CssParameter name=\"stroke\">#ffffff</CssParameter>"
	           + "     <CssParameter name=\"width\">1.5</CssParameter>"
	           + "    </Stroke>"
	           + "   </LineSymbolizer>"
	           + "  </Rule>"
	           + " </FeatureTypeStyle>"
	           + "</UserStyle>";
		   return SLDStyleBuilder.createStyle(xml);
	}
	
}
