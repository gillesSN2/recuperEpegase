<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<script type="text/javascript" src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.js'></script>
<link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.css' rel='stylesheet' />
<style type="text/css">
    body { margin:0; padding:0; }
    .marker {background: #888;width: 22px;height: 22px;border-radius: 50%;text-align: center;color:#fff;}
    .marker:hover{background: #ff0;color:#000;}
    #map {top:0; bottom:0; width:100%;height:520px}
    #menu {
        position: absolute;
        background: #fff;
        padding: 10px;
        font-family: 'Open Sans', sans-serif;
    }
    .mapboxgl-popup {
        max-width: 400px;
        font: 12px/20px 'Helvetica Neue', Arial, Helvetica, sans-serif;
    }
</style>

<f:subview id="map">

    <center><h2><h:outputText value="MAP BOX" style="color:green;"/></h2></center>

    <a4j:form id="formGoogleMap">

        <h:panelGrid width="100%" id="panMap" border="0">
            <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.caluleMap}" reRender="idLieuGps"/>
            <h:panelGroup id="idLieuGps">
                <h:panelGroup>
                    <div id="map1" style="width:100%;height:520px;border:solid 0px black"></div>
                    <div id='menu1'>
                        <input id='basic' type='radio' name='rtoggle' value='basic' checked='checked'>
                        <label for='basic'>basic</label>
                        <input id='streets' type='radio' name='rtoggle' value='streets'>
                        <label for='streets'>streets</label>
                        <input id='bright' type='radio' name='rtoggle' value='bright'>
                        <label for='bright'>bright</label>
                        <input id='light' type='radio' name='rtoggle' value='light'>
                        <label for='light'>light</label>
                        <input id='dark' type='radio' name='rtoggle' value='dark'>
                        <label for='dark'>dark</label>
                        <input id='satellite' type='radio' name='rtoggle' value='satellite'>
                        <label for='satellite'>satellite</label>
                    </div>
                </h:panelGroup>

                <script type="text/javascript" language="Javascript">
                    // initialise api
                    mapboxgl.accessToken = 'pk.eyJ1IjoiZ2lsbGVzc24iLCJhIjoiY2lxMmNnZmlqMDA0bmh4bmQ2bXIwa3lidCJ9.pR2MN2vbR-dwHUW4vJN9qA';
                    var map = new mapboxgl.Map({
                        container: 'map1',
                        style: 'mapbox://styles/mapbox/streets-v9',
                        zoom: 13
                    });
                    // changement visuel
                    var layerList = document.getElementById('menu1');
                    var inputs = layerList.getElementsByTagName('input');
                    function switchLayer(layer) {
                        var layerId = layer.target.id;
                        map.setStyle('mapbox://styles/mapbox/' + layerId + '-v9');
                    }
                    for (var i = 0; i < inputs.length; i++) {
                        inputs[i].onclick = switchLayer;
                    }
                    // zoom map
                    map.addControl(new mapboxgl.FullscreenControl());
                    // Add geolocate control to the map.
                    map.addControl(new mapboxgl.GeolocateControl({
                        positionOptions: {
                            enableHighAccuracy: true
                        },
                        trackUserLocation: true
                    }));
                    //
                </script>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>
