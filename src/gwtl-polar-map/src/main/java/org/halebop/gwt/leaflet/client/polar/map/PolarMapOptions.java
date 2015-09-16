package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.map.MapOptions;
import org.discotools.gwt.leaflet.client.types.LatLng;

public class PolarMapOptions extends
		MapOptions
{

	@Override
	public PolarMapOptions setCenter(
			LatLng latlng ) {
		return (PolarMapOptions) super.setCenter(latlng);
	}

	@Override
	public PolarMapOptions setZoom(
			int zoom ) {
		return (PolarMapOptions) super.setZoom(zoom);
	}

	@Override
	public PolarMapOptions setMinZoom(
			int zoom ) {
		return (PolarMapOptions) super.setMinZoom(zoom);
	}

	@Override
	public PolarMapOptions setMaxZoom(
			int zoom ) {
		return (PolarMapOptions) super.setMaxZoom(zoom);
	}

	public PolarMapOptions setBaseLayer(
			TileLayer baseLayer ) {
		return (PolarMapOptions) setProperty(
				"baseLayer",
				baseLayer);
	}

	public PolarMapOptions setChangingMap(
			boolean changingMap ) {
		return (PolarMapOptions) setProperty(
				"changingMap",
				changingMap);
	}

	public PolarMapOptions setFadeAnimation(
			boolean fadeAnimation ) {
		return (PolarMapOptions) setProperty(
				"fadeAnimation",
				fadeAnimation);
	}

	public PolarMapOptions setTrackResize(
			boolean trackResize ) {
		return (PolarMapOptions) setProperty(
				"trackResize",
				trackResize);
	}

	public PolarMapOptions setMarkerZoomAnimation(
			boolean markerZoomAnimation ) {
		return (PolarMapOptions) setProperty(
				"markerZoomAnimation",
				markerZoomAnimation);
	}
}
