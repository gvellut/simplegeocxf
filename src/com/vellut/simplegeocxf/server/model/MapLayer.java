package com.vellut.simplegeocxf.server.model;

import org.geotools.data.DataStore;
import org.geotools.styling.Style;

public class MapLayer {
	private String name;
	//TODO pass this as connection property and build the DataStore as init callback
	private DataStore dataStore;
	private Style style;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	public DataStore getDataStore() {
		return dataStore;
	}


	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}


}
