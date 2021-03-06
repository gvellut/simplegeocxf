package com.vellut.simplegeocxf.server.model;

import org.geotools.data.DataStore;
import org.geotools.styling.Style;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.vellut.simplegeocxf.server.model.*;

import static org.junit.Assert.*;

@RunWith(JMock.class)
public class MapLayerTests {
	MapLayer mapLayer;
	Mockery context = new JUnit4Mockery();
	
	@Before
	public void setUp(){
		mapLayer = new MapLayer();
	}
	
	@Test
	public void testName() {
		String name = "Layer 1";
		mapLayer.setName(name);
		assertEquals(name,mapLayer.getName());
	}
	
	@Test
	public void testDataStore() {
		DataStore dataStore = context.mock(DataStore.class);
		mapLayer.setDataStore(dataStore);
		assertSame(dataStore,mapLayer.getDataStore());
	}
	
	
	@Test
	public void testStyle(){
		Style style = context.mock(Style.class);
		mapLayer.setStyle(style);
		assertSame(style,mapLayer.getStyle());
	}
	
	
}
