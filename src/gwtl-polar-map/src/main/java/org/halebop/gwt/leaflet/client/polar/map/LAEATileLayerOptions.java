package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.crs.CRS;

public class LAEATileLayerOptions extends
		Options
{

	public LAEATileLayerOptions setName(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}

	public LAEATileLayerOptions setCRS(
			CRS crs ) {
		return (LAEATileLayerOptions) setProperty(
				"crs",
				crs);
	}

	public LAEATileLayerOptions setMinZoom(
			int zoom ) {
		return (LAEATileLayerOptions) setProperty(
				"minZoom",
				zoom);
	}

	public LAEATileLayerOptions setMaxZoom(
			int zoom ) {
		return (LAEATileLayerOptions) setProperty(
				"maxZoom",
				zoom);
	}

	public LAEATileLayerOptions setTMS(
			boolean tms ) {
		return (LAEATileLayerOptions) setProperty(
				"tms",
				tms);
	}

//	public LAEATileLayerOptions setOrigin(
//			String name ) {
//		return (LAEATileLayerOptions) setProperty(
//				"name",
//				name);
//	}

	public LAEATileLayerOptions setMaxResolution(
			double zoom ) {
		return (LAEATileLayerOptions) setProperty(
				"maxResolution",
				zoom);
	}

	public LAEATileLayerOptions setProjectedBounds(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}

	public LAEATileLayerOptions setCenter(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}

	public LAEATileLayerOptions setZoom(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}

	public LAEATileLayerOptions setContinuousWorld(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}

	public LAEATileLayerOptions setNoWrap(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}

	public LAEATileLayerOptions setAttribution(
			String name ) {
		return (LAEATileLayerOptions) setProperty(
				"name",
				name);
	}
}
