package com.vellut.simplegeocxf.server.service.model;

import java.io.Serializable;

public class MapSize implements Serializable{
	private static final long serialVersionUID = 1L;
	private int width, height;
	
	public MapSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
