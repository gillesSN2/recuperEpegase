<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
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

<f:subview id="noteFiche">

    <a4j:form id="noteAjout" enctype="multipart/form-data">

        <center> <h2><h:outputText styleClass="titre" value="GESTION DES NOTES EXTERNES" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true" style="border:0px;">
            <rich:tab label="Descriptif Note">
                <h:panelGrid styleClass="fichefournisseur1" id="loyerPG" border="0" width="100%" columns="2">
                    <h:panelGrid  border="0" width="100%" columns="2" columnClasses="clos25,clos75">
                        <h:column><h:outputText value="Type de note:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}">
                                <f:selectItem itemLabel="Note de frais" itemValue="0"/>
                                <f:selectItem itemLabel="Pièce externe" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotCategorie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}">
                                <f:selectItem itemLabel="Carburant" itemValue="0"/>
                                <f:selectItem itemLabel="Amende" itemValue="1"/>
                                <f:selectItem itemLabel="Péage" itemValue="2"/>
                                <f:selectItem itemLabel="Taxi" itemValue="3"/>
                                <f:selectItem itemLabel="Transport Urbain" itemValue="4"/>
                                <f:selectItem itemLabel="Restaurant Seul" itemValue="5"/>
                                <f:selectItem itemLabel="Restaurant avec client" itemValue="6"/>
                                <f:selectItem itemLabel="Hébergement" itemValue="7"/>
                                <f:selectItem itemLabel="Entretien véhicule" itemValue="8"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date note:"/></h:column>
                        <h:column><rich:calendar style="background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotDate}" locale="FR" enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Id note:"/></h:column>
                        <h:column><h:inputText disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId}"/></h:column>
                        <h:column><h:outputText value="Numéro interne:"/></h:column>
                        <h:column><h:inputText disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotNum}"/></h:column>
                        <h:column><h:outputText value="Référence pièce:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotPiece}" maxlength="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Libellé note:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotLibelle}" maxlength="100" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Montant facture:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotMontant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Scan Note" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0}">
                <jsp:include flush="true" page="/comptabilite/NotesExternesCommun.jsp" />
                <h:panelGrid style="width:100%;">
                    <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotScanFacture==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.uploadedFile}" accept="image/*"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action==3}">
                                <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup  id="grp3" style="tex-align:center">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotScanFacture!=null}">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.typeFichier==0}" var="sc1">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.urlphotoProd}" width="100%" height="800px"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.typeFichier==1}" var="sc2">
                                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.fichierMine}" width="100%" height="550">
                                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.fichierUrl}"></a>
                                    </object>
                                </c:if>
                                <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.reInitPhoto}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action<2}"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotScanFacture==null}">
                                <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                            </c:if>
                        </h:panelGroup>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Ecritures Comptables" style="height:550px" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0}">
                <jsp:include flush="true" page="/comptabilite/NotesExternesCommun.jsp" />
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.calculeEcritureTheo}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idEcritures"/>
                <h:panelGroup id="idEcritures">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.pageIndex}" reRender="tableEcritures" id="scrollTable" maxPages="20"align="left" for="tableEcritures"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " sortMode="multi" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.dataModelLesEcritures}" var="table" id="tableEcritures"  width="100%"  style="max-height:100%;" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.selectionEcriture}" reRender="pnSaisie,libNumcpte,alerteM,fermer"/>
                            <rich:column label="Etat" width="3%" sortable="true" sortBy="#{table.ecrEtat}"  >
                                <f:facet name="header"><h:outputText  value="E."/></f:facet>
                                <h:outputText value="#{table.lib_etat}" style="width:10px;color:#{table.couleur};"/>
                            </rich:column>
                            <rich:column label="Jour" width="3%" sortable="true" sortBy="#{table.ecrJour}"  >
                                <f:facet name="header"><h:outputText  value="J."/></f:facet>
                                <h:outputText value="#{table.ecrJour}" style="width:10px;color:#{table.couleur};"/>
                            </rich:column>
                            <rich:column label="Compte" width="8%" sortable="true" sortBy="#{table.ecrCompte}" >
                                <f:facet name="header"><h:outputText  value="N° compte" /></f:facet>
                                <h:outputText value="#{table.ecrCompte}" style="color:#{table.couleur}" title="#{table.ecrCompte}"/>
                            </rich:column>
                            <rich:column label="Ititulé du Compte" width="8%" sortable="true" sortBy="#{table.ecrLibCompte}" >
                                <f:facet name="header"><h:outputText  value="Intitulé" /></f:facet>
                                <h:outputText value="#{table.ecrLibCompte}" style="color:#{table.couleur}" title="#{table.ecrLibCompte}"/>
                            </rich:column>
                            <rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{table.ecrPiece}" sortOrder="DESCENDING" >
                                <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
                                <h:outputText value="#{table.ecrPiece}" style="color:#{table.couleur}" title="#{table.ecrPiece}"/>
                            </rich:column>
                            <rich:column label="Référence N°1"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" >
                                <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
                                <h:outputText value="#{table.ecrReference1}" style="color:#{table.couleur}" title="#{table.ecrReference1}"/>
                            </rich:column>
                            <rich:column label="Montant débit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitSaisie}" >
                                <f:facet name="header"><h:outputText  value="Débit"/></f:facet>
                                <h:outputText value="#{table.ecrDebitSaisie}" rendered="#{table.ecrDebitSaisie!=0}" style="color:#{table.couleur}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant crédit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditSaisie}" >
                                <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                                <h:outputText value="#{table.ecrCreditSaisie}" rendered="#{table.ecrCreditSaisie!=0}" style="color:#{table.couleur}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Libellé écriture"  width="20%"sortable="true" sortBy="#{table.ecrLibelle}"  >
                                <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                                <h:outputText value="#{table.ecrLibelle}" style="width:100px;color:#{table.couleur};" title="#{table.ecrLibelle}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGroup>
            </rich:tab>

            <rich:tab label="LOCALISATION MAPBOX" style="height:550px" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0}">
                <jsp:include flush="true" page="/comptabilite/NotesExternesCommun.jsp" />
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.caluleMapRdv}" reRender="idLieuGpsRdv"/>
                <h:panelGroup id="idLieuGpsRdv">
                    <h:panelGroup>
                        <div id="map" style="width:100%;height:520px;border:solid 0px black"></div>
                        <div id='menu'>
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
                            container: 'map',
                            style: 'mapbox://styles/mapbox/streets-v9',
                            center: [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.origine}],
                            zoom: 13
                        });
                        //on affiche des marqueurs à la position de nos points GPS, indiquant leur numéros et recentrant la carte sur eux au clic.
                        var coords = [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.coordonnees}]; // starting position [lng, lat]
                        var markers = [];
                        //pour chaque point GPS dans coords
                        coords.forEach(function (coord, index) {
                            //creation d'un div avec la classe 'marker' pour l'affichage du marker
                            var el = document.createElement('div');
                            el.className = 'marker';
                            el.setAttribute('data-index', index);//on stocke son numéro pour l'utilisation au click
                            //creer un élément pour indiquer le numéro du marquer dans celui-ci
                            var content = document.createTextNode(index);
                            el.appendChild(content);
                            //on ajoute les marquers sur notre carte
                            markers[index] = new mapboxgl.Marker({element: el}).setLngLat([coord[0], coord[1]]).addTo(map);
                            //au clic sur chacun d'eux on recentre la carte sur sa position
                            el.addEventListener("click", function (e) {
                                map.flyTo({center: markers[e.target.dataset.index].getLngLat()});
                            });
                        });
                        // changement visuel
                        var layerList = document.getElementById('menu');
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
            </rich:tab>

            <rich:tab label="Etat" style="height:550px" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0}">
                <jsp:include flush="true" page="/comptabilite/NotesExternesCommun.jsp" />
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.caluleEtat}" reRender="idPanEtat"/>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                    <h:column><h:outputText value="ID NOTE:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId}" size="20" readonly="true"/></h:column>
                    <h:column><h:outputText value="Créateur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.nomCreateur}" size="100" readonly="true"/></h:column>
                    <h:column><h:outputText value="ID créateur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotUserCreat}" size="20" readonly="true"/></h:column>
                    <h:column><h:outputText value="Date de création:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotDateCreat}" readonly="true">
                            <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Modificateur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.nomModif}" size="100" readonly="true"/></h:column>
                    <h:column><h:outputText value="ID modificateur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotUserModif}" size="20" readonly="true"/></h:column>
                    <h:column><h:outputText value="Date de modification:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotDateModif}" readonly="true">
                            <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Date traitement comptable:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotDateTransfert}" readonly="true">
                            <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Etat:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotEtat}" disabled="true">
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Validé" itemValue="1"/>
                            <f:selectItem itemLabel="Gelé" itemValue="2"/>
                            <f:selectItem itemLabel="Annulé" itemValue="3"/>
                            <f:selectItem itemLabel="Traité" itemValue="4"/>
                        </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.reactiverDocument}" reRender="idPanEtat"/>
                    </h:column>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup>
            <center>
                <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.annulerSaisie}"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.saveNotes}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action<=2}"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>