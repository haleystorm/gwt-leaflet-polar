/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.halebop.gwt.leaflet.client.example;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.controls.ControlOptions;
import org.discotools.gwt.leaflet.client.controls.Position;
import org.discotools.gwt.leaflet.client.controls.layers.Layers;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.layers.ILayer;
import org.discotools.gwt.leaflet.client.layers.others.LayerGroup;
import org.discotools.gwt.leaflet.client.layers.others.LayerGroup.LayerHandler;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.marker.Marker;
import org.discotools.gwt.leaflet.client.marker.MarkerOptions;
import org.discotools.gwt.leaflet.client.types.LatLng;
import org.discotools.gwt.leaflet.client.widget.MapWidget;
import org.halebop.gwt.leaflet.client.polar.map.Layer3571;
import org.halebop.gwt.leaflet.client.polar.map.Layer3572;
import org.halebop.gwt.leaflet.client.polar.map.Layer3573;
import org.halebop.gwt.leaflet.client.polar.map.Layer3574;
import org.halebop.gwt.leaflet.client.polar.map.Layer3575;
import org.halebop.gwt.leaflet.client.polar.map.Layer3576;
import org.halebop.gwt.leaflet.client.polar.map.PolarMap;
import org.halebop.gwt.leaflet.client.polar.map.PolarMapOptions;
import org.halebop.gwt.leaflet.client.polar.map.TileLayer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Example implements
		EntryPoint
{

	Map map;

	public class MyLayerHandler implements
			LayerHandler
	{
		public int countOfEditedLayers = 0;

		@Override
		public void handle(
				ILayer layer ) {
			countOfEditedLayers++;
		}
	}

	public void onModuleLoad() {

		// Fit MapWidget to device screen
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Body");
		MapWidget mapWidget = new MapWidget(
				"map");
		rootPanel.add(mapWidget);
		mapWidget.setHeight("");
		mapWidget.setStyleName("gwt-Map");

		// Create Map instance
		PolarMapOptions loptions = new PolarMapOptions();
		TileLayer baseLayer = new Layer3573();
		loptions.setBaseLayer(baseLayer);

		map = new PolarMap(
				"map",
				loptions);
		LatLng center = new LatLng(
				baseLayer.getOptions().getProperty(
						"center"));

		double zoom = baseLayer.getOptions().getPropertyAsDouble(
				"zoom");
		map.setView(
				center,
				zoom,
				true);

		// Create layer switcher control
		Options bases = new Options();
		bases.setProperty(
				"Arctic Connect: EPSG:3571",
				new Layer3571());
		bases.setProperty(
				"Arctic Connect: EPSG:3572",
				new Layer3572());
		bases.setProperty(
				"Arctic Connect: EPSG:3573",
				new Layer3573());
		bases.setProperty(
				"Arctic Connect: EPSG:3574",
				new Layer3574());
		bases.setProperty(
				"Arctic Connect: EPSG:3575",
				new Layer3575());
		bases.setProperty(
				"Arctic Connect: EPSG:3576",
				new Layer3576());
		Options tileOptions = new Options();
		tileOptions.setProperty(
				"name",
				"opencyclemap@EPSG:3857");
		tileOptions.setProperty(
				"crs",
				"EPSG:3857");
		tileOptions.setProperty(
				"minZoom",
				0);
		tileOptions.setProperty(
				"maxZoom",
				18);
		tileOptions.setProperty(
				"tms",
				false);
		tileOptions.setProperty(
				"center",
				new LatLng(
						51.080126,
						-114.13380900));
		tileOptions.setProperty(
				"attribution",
				"&copy; <a href=\"http://osm.org/copyright\">OpenStreetMap</a> contributors");
		bases.setProperty(
				"OSM: EPSG:3857",
				new TileLayer(
						"http://{s}.tile.osm.org/{z}/{x}/{y}.png",
						tileOptions));

		// Add layers control to map
		Options overlays = new Options();
		ControlOptions controlOptions = new ControlOptions();
		controlOptions.setPosition(Position.TOP_RIGHT);
		Layers control = new Layers(
				bases,
				overlays,
				controlOptions);
		control.addTo(map);

		// Add markers to map
		MarkerOptions opt1 = new MarkerOptions();
		opt1.setTitle("marker1");
		MarkerOptions opt2 = new MarkerOptions();
		opt2.setTitle("marker2");
		MarkerOptions opt3 = new MarkerOptions();
		opt3.setTitle("marker3");
		Marker marker1 = new Marker(
				new LatLng(
						51.080126,
						-114.13380900),
				opt1);
		Marker marker2 = new Marker(
				new LatLng(
						61.636,
						8.3135),
				opt2);
		Marker marker3 = new Marker(
				new LatLng(
						90,
						100),
				opt3);

		Marker[] markers = new Marker[] {
			marker1,
			marker2,
			marker3
		};
		LayerGroup groupMarkers = new LayerGroup(
				markers);
		groupMarkers.addTo(map);
	}
}