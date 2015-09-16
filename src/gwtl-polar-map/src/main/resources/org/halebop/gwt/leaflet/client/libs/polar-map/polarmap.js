/*
 PolarMap.js 1.0.1 (5fec1bc)
 (c) 2014-2015 Arctic Connect, Geo Sensor Web Lab
*/
!function(t,e,a,o){"undefined"==typeof a&&(a={}),a.PolarMap={version:"1.0.1",Control:{},Util:{}},"object"==typeof module&&"object"==typeof module.exports?module.exports=a.PolarMap:"function"==typeof define&&define.amd&&define(a.PolarMap),a.PolarMap.Control.Rotation=a.Control.extend({options:{position:"topright",cwText:"&orarr;",cwTitle:"Rotate Clockwise",ccwText:"&olarr;",ccwTitle:"Rotate Counter-Clockwise"},onAdd:function(){var t="leaflet-control-rotation",e=a.DomUtil.create("div",t+" leaflet-bar"),o=this.options;return this._cwButton=this._createButton(o.cwText,o.cwTitle,t+"-cw",e,this._rotateCW),this._ccwButton=this._createButton(o.ccwText,o.ccwTitle,t+"-ccw",e,this._rotateCCW),e},_rotateCW:function(){this.options.onRotateCW&&this.options.onRotateCW()},_rotateCCW:function(){this.options.onRotateCCW&&this.options.onRotateCCW()},_createButton:function(t,e,o,n,i){var s=a.DomUtil.create("a",o,n);return s.innerHTML=t,s.href="#",s.title=e,a.DomEvent.on(s,"mousedown dblclick",a.DomEvent.stopPropagation).on(s,"click",a.DomEvent.stop).on(s,"click",i,this).on(s,"click",this._refocusOnMap,this),s}}),a.PolarMap.Control.rotation=function(t){return new a.PolarMap.Control.Rotation(t)},a.PolarMap.TileLayer=a.TileLayer.extend({}),a.PolarMap.tileLayer=function(t,e){return new a.PolarMap.TileLayer(t,e)};var n=20037509.762000002;a.PolarMap.LAEATileLayer=a.PolarMap.TileLayer.extend({options:{name:null,crs:null,minZoom:0,maxZoom:18,tms:!1,origin:[-n,n],maxResolution:(n- -n)/256,projectedBounds:a.bounds(a.point(-n,n),a.point(n,-n)),center:[90,0],zoom:4,continuousWorld:!1,noWrap:!0,attribution:'Map &copy; <a href="http://arcticconnect.org">ArcticConnect</a>. Data &copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'}}),a.PolarMap.laeaTileLayer=function(t,e){return new a.PolarMap.LAEATileLayer(t,e)},a.PolarMap.layer3571=a.PolarMap.laeaTileLayer("http://{s}.tiles.arcticconnect.org/osm_3571/{z}/{x}/{y}.png",{name:"ac_3571",crs:"EPSG:3571",proj4def:"+proj=laea +lat_0=90 +lon_0=180 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs"}),a.PolarMap.layer3572=a.PolarMap.laeaTileLayer("http://{s}.tiles.arcticconnect.org/osm_3572/{z}/{x}/{y}.png",{name:"ac_3572",crs:"EPSG:3572",proj4def:"+proj=laea +lat_0=90 +lon_0=-150 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs"}),a.PolarMap.layer3573=a.PolarMap.laeaTileLayer("http://{s}.tiles.arcticconnect.org/osm_3573/{z}/{x}/{y}.png",{name:"ac_3573",crs:"EPSG:3573",proj4def:"+proj=laea +lat_0=90 +lon_0=-100 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs"}),a.PolarMap.layer3574=a.PolarMap.laeaTileLayer("http://{s}.tiles.arcticconnect.org/osm_3574/{z}/{x}/{y}.png",{name:"ac_3574",crs:"EPSG:3574",proj4def:"+proj=laea +lat_0=90 +lon_0=-40 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs"}),a.PolarMap.layer3575=a.PolarMap.laeaTileLayer("http://{s}.tiles.arcticconnect.org/osm_3575/{z}/{x}/{y}.png",{name:"ac_3575",crs:"EPSG:3575",proj4def:"+proj=laea +lat_0=90 +lon_0=10 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs"}),a.PolarMap.layer3576=a.PolarMap.laeaTileLayer("http://{s}.tiles.arcticconnect.org/osm_3576/{z}/{x}/{y}.png",{name:"ac_3576",crs:"EPSG:3576",proj4def:"+proj=laea +lat_0=90 +lon_0=90 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs"}),a.PolarMap.Util.Hash=a.Class.extend({options:{map:null,lastHash:null,movingMap:!1,changeDefer:100,changeTimeout:null,isListening:!1,hashChangeInterval:null,getBaseLayer:null,setBaseLayer:null},initialize:function(e,n){n=a.setOptions(this,n),this.HAS_HASHCHANGE=function(){var e=t.documentMode;return"onhashchange"in t&&(e===o||e>7)}(),this.onHashChange=a.Util.bind(this.onHashChange,this),this.map=e,this.options.lastHash=null,this.onHashChange(),this.options.isListening||this.startListening()},formatHash:function(t){var e=[],a=t.getCenter(),o=t.getZoom(),n=Math.max(0,Math.ceil(Math.log(o)/Math.LN2));return null!==this.options.getBaseLayer&&e.push(this.options.getBaseLayer()),e.push(o,a.lat.toFixed(n),a.lng.toFixed(n)),"#"+e.join("/")},onHashChange:function(){if(!this.options.changeTimeout){var t=this;this.options.changeTimeout=setTimeout(function(){t.update(),t.options.changeTimeout=null},this.options.changeDefer)}},onMapMove:function(){if(this.options.movingMap||!this.map._loaded)return!1;var t=this.formatHash(this.map);this.options.lastHash!=t&&(location.replace(t),this.options.lastHash=t)},parseHash:function(t){0===t.indexOf("#")&&(t=t.substr(1));var e,o,n,i=t.split("/");if(4===i.length){var s=i[0];return e=parseInt(i[1],10),o=parseFloat(i[2]),n=parseFloat(i[3]),""===s||isNaN(e)||isNaN(o)||isNaN(n)?!1:{baseLayer:s,center:new a.LatLng(o,n),zoom:e}}return 3===i.length?(e=parseInt(i[0],10),o=parseFloat(i[1]),n=parseFloat(i[2]),isNaN(e)||isNaN(o)||isNaN(n)?!1:{center:new a.LatLng(o,n),zoom:e}):!1},removeFrom:function(){this.options.changeTimeout&&clearTimeout(this.options.changeTimeout),this.options.isListening&&this.stopListening(),this.map=null},startListening:function(){this.map.on("moveend",this.onMapMove,this),this.HAS_HASHCHANGE?a.DomEvent.addListener(t,"hashchange",this.onHashChange):(clearInterval(this.options.hashChangeInterval),this.options.hashChangeInterval=setInterval(this.onHashChange,50)),this.options.isListening=!0},stopListening:function(){this.map.off("moveend",this.onMapMove,this),this.HAS_HASHCHANGE?a.DomEvent.removeListener(t,"hashchange",this.onHashChange):clearInterval(this.options.hashChangeInterval),this.options.isListening=!1},update:function(){var t=location.hash;if(t!==this.options.lastHash){var e=this.parseHash(t);e?(this.options.movingMap=!0,e.baseLayer!==o&&this.options.setBaseLayer(e.baseLayer),this.map.setView(e.center,e.zoom),this.options.movingMap=!1):this.onMapMove(this.map)}}}),a.PolarMap.Util.hash=function(t,e){return new a.PolarMap.Util.Hash(t,e)},a.PolarMap.Map=a.Map.extend({options:{changingMap:!1,fadeAnimation:!0,trackResize:!0,markerZoomAnimation:!0,center:a.latLng([90,0]),zoom:1},initialize:function(t,e){e=a.setOptions(this,e),this._initContainer(t),this._initLayout(),this._onResize=a.bind(this._onResize,this),this._initEvents(),e.maxBounds&&this.setMaxBounds(e.maxBounds),e.center&&e.zoom!==o&&this.setView(a.latLng(e.center),e.zoom,{reset:!0}),this._handlers=[],this._layers={},this._zoomBoundLayers={},this.callInitHooks(),this.on("baselayerchange",function(t){this._update(t.layer)}),this._update(e.baseLayer)},loadTileProjection:function(t){return this.options.changingMap?!1:void(this._usingTileProjection(t)?console.log("That tile layer is already active."):(this._dropTileLayers(),this._update(t)))},remove:function(){for(var t in this._layers)this.removeLayer(this._layers[t]);return a.Map.prototype.remove.call(this),this},_defineMapCRS:function(t,e){for(var o=[],n=e.minZoom;n<=e.maxZoom;n++)o.push(e.maxResolution/Math.pow(2,n));return new a.Proj.CRS(t,e.proj4def,{origin:e.origin,resolutions:o,bounds:e.projectedBounds})},_dropTileLayers:function(){var t=this;t.eachLayer(function(e){e instanceof a.TileLayer&&t.removeLayer(e)})},_setMapCRS:function(t,e){switch(t){case"EPSG:3857":return a.CRS.EPSG3857;case"EPSG:3395":return a.CRS.EPSG3395;case"EPSG:4326":return a.CRS.EPSG4326;default:return this._defineMapCRS(t,e)}},_update:function(t){if(this.options.changingMap)return!1;this.options.changingMap=!0;var e=this.getCenter(),a=this.getZoom();this._updateCRSAndLayers(t.options),this.addLayer(t,!0),this.setView(e,a,{reset:!0}),this.setMaxBounds(t.options.bounds),this.options.changingMap=!1},_updateAllLayers:function(t){var e=this;t.eachLayer?t.eachLayer(function(t){e._updateAllLayers(t)}):t.redraw?t.redraw():t.update?t.update():console.log("Don't know how to update",t)},_updateCRSAndLayers:function(t){this.options.crs=this._setMapCRS(t.crs,t),this._updateAllLayers(this)},_usingTileProjection:function(t){var e=!1,a=this._layers;for(var o in a)if(a.hasOwnProperty(o)&&(e=a[o]===t))break;return e}}),a.PolarMap.map=function(t,e){return new a.PolarMap.Map(t,e)};for(var i={tileHeader:"Arctic Connect: ",attribution:'Map &copy; <a href="http://arcticconnect.org">ArcticConnect</a>. Data &copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',locationDetectionError:"Location detection error: "},s={"Arctic Connect: EPSG:3571":a.PolarMap.layer3571,"Arctic Connect: EPSG:3572":a.PolarMap.layer3572,"Arctic Connect: EPSG:3573":a.PolarMap.layer3573,"Arctic Connect: EPSG:3574":a.PolarMap.layer3574,"Arctic Connect: EPSG:3575":a.PolarMap.layer3575,"Arctic Connect: EPSG:3576":a.PolarMap.layer3576},r=0;6>r;r++){var l=0===r?5:r-1,h=5===r?0:r+1,c=s[i.tileHeader+"EPSG:"+(3571+r)];c.prev=s[i.tileHeader+"EPSG:"+(3571+l)],c.next=s[i.tileHeader+"EPSG:"+(3571+h)]}t.PolarMap=a.Class.extend({options:{geosearch:!1,locate:!1,permalink:!0},statics:{VERSION:a.PolarMap.version},initialize:function(t,e){var o=this;a.Util.setOptions(this,e),this.tiles=s,this.layersControl=a.control.layers(this.tiles,null),this.rotationControls=a.PolarMap.Control.rotation({onRotateCW:function(){o.map.loadTileProjection(o.getBaseLayer().next)},onRotateCCW:function(){o.map.loadTileProjection(o.getBaseLayer().prev)}}),this.map=a.PolarMap.map(t,{baseLayer:this.tiles[i.tileHeader+"EPSG:3573"],center:[90,0],zoom:4}),this.layersControl.addTo(this.map),this.rotationControls.addTo(this.map),this.options.geosearch&&this._initGeosearch(),this.options.locate&&this._initLocate(),this.options.permalink&&this._initPermalink()},addLayer:function(t,e){this.map.addLayer(t),"undefined"!=typeof e&&e.switcher&&this.layersControl.addOverlay(t,e.name)},getBaseLayer:function(){var t=null;for(var e in this.tiles)this.tiles.hasOwnProperty(e)&&this.map.hasLayer(this.tiles[e])&&(t=this.tiles[e]);return t},_initGeosearch:function(){new a.Control.GeoSearch({provider:new a.GeoSearch.Provider.OpenStreetMap,showMarker:!1}).addTo(this.map)},_initLocate:function(){var t=this,e=a.circle();this.map.on("locationfound",function(a){e.setLatLng(a.latlng),e.setRadius(a.accuracy),t.map.hasLayer(e)||e.addTo(t.map),t._setProjectionForLongitude(a.longitude)}),this.map.on("locationerror",function(t){console.warn(i.locationDetectionError,t)}),this.map.locate()},_initPermalink:function(){var t=this;this.hash=a.PolarMap.Util.hash(this.map,{getBaseLayer:function(){return t.getBaseLayer().options.name},setBaseLayer:function(e){t._setBaseLayer(e)}})},_setBaseLayer:function(t){var e=this;for(var a in this.tiles)this.tiles.hasOwnProperty(a)&&this.tiles[a].options.name===t&&e.map.loadTileProjection(this.tiles[a])},_setProjectionForLongitude:function(t){var e;e=t>=-180&&-165>=t?"EPSG:3571":t>-165&&-125>=t?"EPSG:3572":t>-125&&-70>=t?"EPSG:3573":t>-70&&-15>=t?"EPSG:3574":t>-15&&50>=t?"EPSG:3575":t>50&&135>=t?"EPSG:3576":"EPSG:3571",this.map.loadTileProjection(this.tiles[i.tileHeader+e])}}),t.polarMap=function(e,a){return new t.PolarMap(e,a)}}(window,document,L);