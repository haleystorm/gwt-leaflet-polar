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

import org.discotools.gwt.leaflet.client.layers.ILayer;
import org.discotools.gwt.leaflet.client.layers.others.LayerGroup.LayerHandler;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.types.LatLng;
import org.discotools.gwt.leaflet.client.widget.MapWidget;
import org.halebop.gwt.leaflet.client.polar.map.Layer3573;
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
	}
}