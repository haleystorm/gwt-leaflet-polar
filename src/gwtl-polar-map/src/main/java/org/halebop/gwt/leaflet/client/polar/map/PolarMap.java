package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.map.Map;

public class PolarMap extends
		Map
{
	protected PolarMap(
			JSObject jsObject ) {
		super(
				jsObject);
	}

	public PolarMap(
			String name,
			PolarMapOptions options ) {
		this(
				PolarMapImpl.create(
						name,
						options.getJSObject()));
	}

}
