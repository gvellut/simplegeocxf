package com.vellut.simplegeocxf.server.utils;

import java.io.StringReader;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.styling.SLDParser;
import org.geotools.styling.Style;

public class SLDStyleBuilder {
	private static SLDParser parser =  new SLDParser(CommonFactoryFinder.getStyleFactory(null));
	
	public static Style createStyle(String xml){
	    parser.setInput(new StringReader(xml));
	    return parser.readXML()[0];
	}
	
}
