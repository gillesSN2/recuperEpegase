<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<script type="text/javascript" src='https://api.tiles.mapbox.com/mapbox.js/v2.2.4/mapbox.js'></script>
<link href='https://api.tiles.mapbox.com/mapbox.js/v2.2.4/mapbox.css' rel='stylesheet' />
<style>
    body { margin:0; padding:0; }
    .map { position:absolute; top:0; bottom:0; width:100%; }
</style>


<f:subview id="listelocalisation">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES LOCALISATIONS GPS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="8" styleClass="recherche"  width="100%" id="panelRecherche">
            <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.moreSearch}" reRender="panelRecherche" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_more_search}"/>
            <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.moreSearch}" reRender="panelRecherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_more_search}"/>
            <h:column><h:outputText value="Balise:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_balise_rec}" style="width:100px"/></h:column>
            <h:column>
                <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_immat_rec}">
                    <f:selectItem itemLabel="Tous parcs" itemValue=""/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.mesParcsItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_famille_rec}">
                    <f:selectItem itemLabel="Toutes familles" itemValue=""/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.mesFamilleItems_rec}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_service_rec}">
                    <f:selectItem itemLabel="Tous Services" itemValue=""/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.mesServiceItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_more_search}">
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.periode}" style="width:150px;">
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesPeriodesItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_more_search}">
                <h:column><h:outputText value="Du"/></h:column>&nbsp;
                <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>&nbsp;&nbsp;&nbsp;
                <h:column><h:outputText value="Au"/></h:column>&nbsp;
                <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
            </h:column>
            <h:column>
                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.rechercherLocalisation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,scrollTable,boutonParc,tableParc"/>
                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
            </h:column>
        </h:panelGrid>

        <h:panelGrid  id="boutonParc" columns="8" width="300px" style="height:34px">
            <a4j:commandButton title="Importer Géolocalisation" image="/images/download.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.ouvrirImportation}" reRender="panelImportation"/>
            <a4j:commandButton title="Ajouter un nouvelle position" image="/images/ajouter.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.ajouterLocalisation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier la position sélectionnée" image="/images/modifier.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.modifierLocalisation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter la position sélectionnée" image="/images/detail.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.consulterLocalisation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer la position sélectionnée" image="/images/supprimer.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.supprimerLocalisation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_affiche_mapper&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Mapper MAPBOX" image="/images/googlemaps.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_affiche_mapper&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.caluleRoute}" reRender="panelMap,formModalMap"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.pageIndex}" reRender="tableParc" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.var_nb_max}" border="0" enableContextMenu="true" id="tableParc" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="110%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.dataModelocalisation}" var="parc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.selectionLocalisation}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.visualisationLigne}" reRender="idSubView,boutonParc"/>
                        <rich:column label="Immatriculation ou identification" sortable="true" width="200px" sortOrder="#{parc.parc.prcImmatriculation}">
                            <f:facet name="header"><h:outputText  value="Immatriculation" /></f:facet>
                            <h:outputText value="#{parc.parc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Balise" sortable="true" width="200px" sortOrder="#{parc.locgpsBalise}">
                            <f:facet name="header"><h:outputText  value="Balise" /></f:facet>
                            <h:outputText value="#{parc.locgpsBalise}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{parc.locgpsDate}" width="200px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{parc.locgpsDate}">
                                <f:convertDateTime pattern="dd/MM/yyyy HH:mm " locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Longitude" sortable="true" sortOrder="#{parc.locgpsLongitude}" width="200px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Longitude" /></f:facet>
                            <h:outputText value="#{parc.locgpsLongitude}" style="text-align:right;"/>
                        </rich:column>
                        <rich:column label="Latitude" sortable="true" sortOrder="#{parc.locgpsLatitude}" width="200px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Latitude" /></f:facet>
                            <h:outputText value="#{parc.locgpsLatitude}" style="text-align:right;"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.showModalPanelPrint}">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.nomModeleListe}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelMap" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="600" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.showModalPanelMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.showModalPanelMap}" var="grp">
            <f:facet name="header"><h:outputText value="LOCALISATION MAPBOX"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.fermerMapper}" image="/images/close.gif" styleClass="hidelink" reRender="panelMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalMap">
                <h:panelGrid  width="100%">
                    <div id='map-trace' class='map'></div>
                </h:panelGrid>

                <script type="text/javascript" language="Javascript">
                    L.mapbox.accessToken = 'pk.eyJ1IjoiZ2lsbGVzc24iLCJhIjoiY2lxMmNnZmlqMDA0bmh4bmQ2bXIwa3lidCJ9.pR2MN2vbR-dwHUW4vJN9qA';
                    var geojson = [
                        {
                            "type": "FeatureCollection",
                            "features": [
                                {
                                    "type": "Feature",
                                    "geometry": {
                                        "type": "LineString",
                                        "coordinates": [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.coordonnees}]
                                    },
                                    "properties": {
                                        "stroke": "#fa946e",
                                        "stroke-opacity": 1,
                                        "stroke-width": 6
                                    }
                                }
                            ]
                        }

                    ];
                    var map = L.mapbox.map('map-trace', 'mapbox.streets', {
                        scrollWheelZoom: true
                        });
                    var myLayer = L.mapbox.featureLayer().addTo(map);
                    myLayer.setGeoJSON(geojson);
                    map.legendControl.addLegend('<strong>${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formLocalisationGps.legende}</strong>');
                </script>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImportation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.showModalPanelImportation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.showModalPanelImportation}" var="imp">
            <f:facet name="header"><h:outputText value="IMPORTATION GEOLOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.fermerImportation}" image="/images/close.gif" styleClass="hidelink" reRender="panelImportation"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <br>
                <br>
                <br>
                <h:panelGroup id="grid">
                    <center>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.var_choix_importation}">
                                <f:selectItem itemLabel="Choissisez le mode d'importation..." itemValue="0"/>
                                <f:selectItem itemLabel="Importation par fichier texte (CSV)" itemValue="1"/>
                                <f:selectItem itemLabel="Importation via serveur FTP" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="grid"/>
                            </h:selectOneMenu>
                        </h:column>
                        <br>
                        <br>
                        <a4j:commandButton value="Information sur l'importation" title="Information" oncomplete="javascript:Richfaces.showModalPanel('panelInfo');" reRender="panelInfo" />
                        <br>
                        <br>
                        <br>

                        <rich:fileUpload id="upload" acceptedTypes="csv, CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.listener}" allowFlash="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.var_choix_importation==1}" >
                            <a4j:support event="onuploadcomplete" reRender="panelImportation"/>
                        </rich:fileUpload>

                        <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à  partir d'un site ftp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.importFtp}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.var_choix_importation==2}"/>

                    </center>
                </h:panelGroup>
                <br>
                <br>
                <br>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelInfo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="600" height="600">
        <center>
            <f:facet name="header"><h:outputText value="Information sur l'importation" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkInfo"/>
                    <rich:componentControl for="panelInfo" attachTo="hidelinkInfo" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalInfo" >

                <div style="text-align:center;text-decoration:underline;">Le format CSV (comma-separated-values) ?
                </div>
                <br>
                <div style="text-align:justify;">Le format CSV (comma-separated-values) est un format de communication qui respecte la norme CSV décrite sous la référence <A target="_blank" HREF="http://tools.ietf.org/html/rfc4180" TITLE="description" style="color:blue;"> RFC 4180 </A>.
                    Le format de communication est donc le CSV et voici le détail de la structure du fichier. Chaque champ est séparé par une virgule et chaque enregistrement est terminé par un point-virgule puis par un retour chariot (car13).<br><br>
                </div>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabEcr" label="Importation géolocalisation">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 4 colonnes :<br>
                                <b></b> <br>
                                - colonne 01 : code de la balise ou immatriculation (20 caractères) <br>
                                - colonne 02 : date de l'événement (JJ-MM-AA HH:MM) <br>
                                - colonne 03 : longitude (20 caractères maximun) <br>
                                - colonne 04 : latitude (20 caractères maximun) <br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
