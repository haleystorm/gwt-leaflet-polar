package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.jsobject.JSObject;

/**
 * L.PolarMap.TileLayer is used for tile layers with custom CRS support.
 *
 * @author haley
 *
 */
public class TileLayerImpl
{

	public static native JSObject create(String url, JSObject options)/*-{
		return new $wnd.L.PolarMap.tileLayer(url, options);
	}-*/;

}
