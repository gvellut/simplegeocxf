package com.vellut.simplegeocxf.server.model;

import java.awt.Color;
import java.util.ArrayList;

import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class MapService {
	private ArrayList<MapLayer> mapLayers;
	private String name;
	private CoordinateReferenceSystem crs;
	private Color background;
	
	public ArrayList<MapLayer> getMapLayers() {
		return mapLayers;
	}

	public void setMapLayers(ArrayList<MapLayer> mapLayers) {
		this.mapLayers = mapLayers;
	}

	public void setName(String name) {
		this.name =	name;
	}

	public String getName() {
		return name;
	}

	public CoordinateReferenceSystem getCrs() {
		return crs;
	}

	public void setCrs(CoordinateReferenceSystem crs) {
		this.crs = crs;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}
	
}
