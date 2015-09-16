package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;

public class TileLayer extends
		org.discotools.gwt.leaflet.client.layers.raster.TileLayer
{

	protected TileLayer(
			JSObject element ) {
		super(
				element);
	}

	public TileLayer(
			String url,
			Options options ) {
		this(
				TileLayerImpl.create(
						url,
						options.getJSObject()));
	}
}
