package org.halebop.gwt.leaflet.client.polar.map;

import org.discotools.gwt.leaflet.client.jsobject.JSObject;

public class PolarMapImpl
{
	public static native JSObject create(String name, JSObject options) /*-{

		// Verify map place holder element exists
		var div = $doc.getElementById(name);
		if(typeof(div) === 'undefined' || div === null) {
			throw "Element '"+name+"' does not exist";
		}

		// Initialize maps array?
		if($wnd.gwtl === undefined) {
			$wnd.gwtl = [];
			$wnd.gwtl.maps = [];
		}

		// 'name' is also used by third-party javascript, rename to prevent mangling.
		var _name = name;

		// Initialize the map on the "name" div with a given center and zoom
		var map = $wnd.L.PolarMap.map(name, options);

		// Set gwt attributes
		map.gwt = [];
		map.gwt.name = _name;

		// Associate map instance with given name
		$wnd.gwtl.maps[_name] = map;

		// Finished
		return map;
	}-*/;
}
