package com.vellut.simplegeocxf.server;

import java.awt.Color;
import java.io.StringReader;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.styling.SLDParser;
import org.geotools.styling.Style;
import org.junit.Test;
import static org.junit.Assert.*;

public class GeoToolsSpikes {

	@Test
	public void testColor() throws Exception {
			Color color = new Color(0xFFFFFFFF,true);
			assertEquals(255,color.getAlpha());
			assertEquals(255,color.getRed());
			assertEquals(255,color.getBlue());
			assertEquals(255,color.getGreen());
	}

}
