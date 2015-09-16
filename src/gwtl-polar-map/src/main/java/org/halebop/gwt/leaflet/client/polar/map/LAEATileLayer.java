package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.jsobject.JSObject;

public class LAEATileLayer extends TileLayer
{

	public static final String LAYER_3571 = "layer3571";
	public static final String LAYER_3572 = "layer3572";
	public static final String LAYER_3573 = "layer3573";
	public static final String LAYER_3574 = "layer3574";
	public static final String LAYER_3575 = "layer3575";
	public static final String LAYER_3576 = "layer3576";

	protected LAEATileLayer(
			JSObject element ) {
		super(
				element);
	}

	protected LAEATileLayer(String code) {
		super(LAEATileLayerImpl.create(code));
	}

}
