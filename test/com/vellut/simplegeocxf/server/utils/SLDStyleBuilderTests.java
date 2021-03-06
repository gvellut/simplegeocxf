package com.vellut.simplegeocxf.server.utils;

import org.geotools.styling.Style;
import org.junit.Test;

import com.vellut.simplegeocxf.server.utils.SLDStyleBuilder;

import static org.junit.Assert.*;

public class SLDStyleBuilderTests {
	
	@Test
	public void testCreateStyle() throws Exception {
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
	   Style style = SLDStyleBuilder.createStyle(xml);
	   assertNotNull(style);
	   assertEquals(1,style.getFeatureTypeStyles().length);
	}
	
}
