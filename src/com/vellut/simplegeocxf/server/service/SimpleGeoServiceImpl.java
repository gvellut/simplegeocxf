package com.vellut.simplegeocxf.server.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.feature.FeatureType;
import org.geotools.map.DefaultMapContext;
import org.geotools.map.MapContext;
import org.geotools.referencing.CRS;
import org.geotools.renderer.GTRenderer;
import org.geotools.renderer.lite.StreamingRenderer;
import org.geotools.styling.FeatureTypeStyle;
import org.geotools.styling.Rule;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.styling.StyleFactory;
import org.geotools.styling.Symbolizer;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vellut.simplegeocxf.server.model.MapLayer;
import com.vellut.simplegeocxf.server.model.MapService;
import com.vellut.simplegeocxf.server.model.MapServiceConfiguration;
import com.vellut.simplegeocxf.server.service.model.MapSize;

@WebService(endpointInterface = "com.vellut.simplegeocxf.server.service.SimpleGeoService", serviceName = "geoToolsOpenGeoreportsService")
public class SimpleGeoServiceImpl implements SimpleGeoService {
	private MapServiceConfiguration mapServiceConfiguration;

	private final static Log log = LogFactory
			.getLog(SimpleGeoServiceImpl.class);

	public byte[] getMapImage(String mapServiceName, MapSize mapSize, String format) {
		MapService mapService = mapServiceConfiguration.getMapServices().get(
				mapServiceName);
		byte[] imageData = null;
		if (mapService != null) {
			try {
				MapContext map = new DefaultMapContext(mapService.getCrs());
				for (MapLayer mapLayer : mapService.getMapLayers()) {
					DataStore dataStore = mapLayer.getDataStore();
					FeatureSource featureSource = dataStore
							.getFeatureSource(dataStore.getTypeNames()[0]);
					map.addLayer(featureSource, mapLayer.getStyle());
				}
				GTRenderer draw = new StreamingRenderer();
				draw.setContext(map);
				int width = mapSize.getWidth();
				int height = mapSize.getHeight();
				int pixelType = BufferedImage.TYPE_INT_RGB;
				if(mapService.getBackground().getAlpha() != 255)
					pixelType = BufferedImage.TYPE_INT_ARGB; 
				BufferedImage bI = new BufferedImage(width,height,pixelType);
				Graphics2D g2d = bI.createGraphics();
				g2d.setBackground(mapService.getBackground());
				g2d.clearRect(0, 0, width, height);
				draw.paint(g2d, new Rectangle(width,height), map.getLayerBounds() );
				g2d.dispose();
				ByteArrayOutputStream oS = new ByteArrayOutputStream();
				ImageIO.write(bI, format, oS);
				ImageIO.write(bI, "png", new File("imageLayers.png"));
				imageData = oS.toByteArray();
			} catch (IOException io) {
				log.error("Error IO", io);
			}
		}
		return imageData;
	}

	public void setMapServiceConfiguration(
			MapServiceConfiguration mapServiceConfiguration) {
		this.mapServiceConfiguration = mapServiceConfiguration;
	}

	public MapServiceConfiguration getMapServiceConfiguration() {
		return mapServiceConfiguration;
	}

}
