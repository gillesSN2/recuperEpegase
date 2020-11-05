<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<f:subview id="officeRdvMono">
    
    <a4j:form>

        <center> <h2><h:outputText value="Mon planning" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  id="p1"  tabClass="text" width="100%" style="height:400px;margin-top:0px;border:0;">

            <rich:tab name="mois" label="Par Mois">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modeMois}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Mois précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvByMoisPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;text-align:center" id="idDateMois" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.parMois}" datePattern="MM/yyyy" inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Mois suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvByMoisSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column> <h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.valNatMois}"  >
                            <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.mesNaturesRdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvByMois}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Mois" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.initImpression}"/>&nbsp;&nbsp;
                </h:panelGrid><br>
                <rich:dataTable style="max-height:100%" styleClass="bg" id="tableRdv1" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.datamodelLesRdvParMois}" var="rdv">
                    <rich:column  width="2%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                        <h:outputText value="#{rdv.num_sem}"/>
                    </rich:column>
                    <rich:column  width="14%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Lundi"/></f:facet>
                        <h:outputText value="#{rdv.lundi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol01}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdv.lundi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelLundi}" var="rdvlundi" id="idrdvlundi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol01}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvlundi.rdvHrDe}:#{rdvlundi.rdvMnDe}" style="#{rdvlundi.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvlundi.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvlundi.texteAffiche}" style="#{rdvlundi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol01}" reRender="idrdvlundi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdvlundi.rdvEtat==0&&rdvlundi.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvlundi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvlundi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvlundi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;" sortable="false">
                        <f:facet name="header" ><h:outputText value="Mardi"/></f:facet>
                        <h:outputText value="#{rdv.mardi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol02}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdv.mardi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMardi}" var="rdvmardi" id="idrdvmardi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol02}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmardi.rdvHrDe}:#{rdvmardi.rdvMnDe}" style="#{rdvmardi.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvmardi.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmardi.texteAffiche}" style="#{rdvmardi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol02}" reRender="idrdvmardi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdvmardi.rdvEtat==0&&rdvmardi.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvmardi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvmardi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvmardi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi"/></f:facet>
                        <h:outputText value="#{rdv.mercredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol03}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdv.mercredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMercredi}" var="rdvmercredi" id="idrdvmercredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol03}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmercredi.rdvHrDe}:#{rdvmercredi.rdvMnDe}" style="#{rdvmercredi.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvmercredi.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmercredi.texteAffiche}" style="#{rdvmercredi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol03}" reRender="idrdvmercredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdvmercredi.rdvEtat==0&&rdvmercredi.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvmercredi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvmercredi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvmercredi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi"/></f:facet>
                        <h:outputText value="#{rdv.jeudi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol04}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdv.jeudi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelJeudi}" var="rdvjeudi" id="idrdvjeudi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol04}" reRender="panelEvent"/>
                            <rich:column width="20%">
                                <h:outputText value="#{rdvjeudi.rdvHrDe}:#{rdvjeudi.rdvMnDe}" style="#{rdvjeudi.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvjeudi.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column width="70%">
                                <h:outputText value="#{rdvjeudi.texteAffiche}" style="#{rdvjeudi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol04}" reRender="idrdvjeudi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdvjeudi.rdvEtat==0&&rdvjeudi.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvjeudi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvjeudi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvjeudi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi"/></f:facet>
                        <h:outputText value="#{rdv.vendredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol05}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdv.vendredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelVendredi}" var="rdvvendredi" id="idrdvvendredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol05}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvvendredi.rdvHrDe}:#{rdvvendredi.rdvMnDe}" style="#{rdvvendredi.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvvendredi.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvvendredi.texteAffiche}" style="#{rdvvendredi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol05}" reRender="idrdvvendredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdvvendredi.rdvEtat==0&&rdvvendredi.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvvendredi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvvendredi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvvendredi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.samedi}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol06}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdv.samedi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelSamedi}" var="rdvsamedi" id="idrdvsamedi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol06}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvsamedi.rdvHrDe}:#{rdvsamedi.rdvMnDe}" style="#{rdvsamedi.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvsamedi.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvsamedi.texteAffiche}" style="#{rdvsamedi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol06}" reRender="idrdvsamedi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdvsamedi.rdvEtat==0&&rdvsamedi.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvsamedi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvsamedi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvsamedi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.dimanche}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol07}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07&&rdv.dimanche!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelDimanche}" var="rdvdimanche" id="idrdvdimanche" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdvCol07}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvdimanche.rdvHrDe}:#{rdvdimanche.rdvMnDe}" style="#{rdvdimanche.color}"/><br>
                                <h:outputText value="ERREUR" rendered="#{rdvdimanche.rdvErreur==true}" style="color:red"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvdimanche.texteAffiche}" style="#{rdvdimanche.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol07}" reRender="idrdvdimanche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07&&rdvdimanche.rdvEtat==0&&rdvdimanche.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvdimanche.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvdimanche.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvdimanche.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="semaine" label="Par Semaine">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modeSemaine}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Semaine précédente" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvBySemainePrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateSemaine" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.parSemaine}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Semaine suivante" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvBySemaineSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.valNatSemaine}"  >
                            <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.mesNaturesRdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvBySemaine}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer la Semaine" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.initImpression}"/>&nbsp;&nbsp;
                </h:panelGrid> <br>
                <rich:dataTable style="max-height:100%"  styleClass="bg" id="tableRdv2" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.datamodelLesRdvParSemaine}" var="rdv" >
                    <rich:column  width="9%"    sortable="false" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                        <h:outputText value="#{rdv.heure}" style="font-weight:bold;"/>
                    </rich:column>
                    <rich:column  width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Lundi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateLun}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol01Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01}"/>&nbsp;
                        <h:outputText value="#{rdv.lundi}"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol01Semaine}" reRender="idrdvlundi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01Sup&&rdv.rdvEtatLundi==0&&rdv.rdvUsrLundi==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatLundi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatLundi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatLundi==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurLundi==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false" id="idMardiSemaine">
                        <f:facet name="header" ><h:outputText value="Mardi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateMar}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol02Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02}"/>&nbsp;
                        <h:outputText value="#{rdv.mardi}"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol02Semaine}" reRender="idMardiSemaine" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02Sup&&rdv.rdvEtatMardi==0&&rdv.rdvUsrMardi==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatMardi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatMardi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatMardi==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurMardi==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateMer}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol03Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03}"/>&nbsp;
                        <h:outputText value="#{rdv.mercredi}"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol03Semaine}" reRender="idrdvmercredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03Sup&&rdv.rdvEtatMercredi==0&&rdv.rdvUsrMercredi==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatMercredi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatMercredi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatMercredi==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurMercredi==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateJeu}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol04Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04}"/>&nbsp;
                        <h:outputText value="#{rdv.jeudi}"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol04Semaine}" reRender="idrdvjeudi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04Sup&&rdv.rdvEtatJeudi==0&&rdv.rdvUsrJeudi==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatJeudi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatJeudi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatJeudi==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurJeudi==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateVen}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol05Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05}"/>&nbsp;
                        <h:outputText value="#{rdv.vendredi}"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol05Semaine}" reRender="idrdvvendredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05Sup&&rdv.rdvEtatVendredi==0&&rdv.rdvUsrVendredi==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatVendredi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatVendredi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatVendredi==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurVendredi==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateSam}" style="color:red;"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol06Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06}"/>&nbsp;
                        <h:outputText value="#{rdv.samedi}" style="color:red;"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol06Semaine}" reRender="idrdvsamedi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06Sup&&rdv.rdvEtatSamedi==0&&rdv.rdvUsrSamedi==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatSamedi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatSamedi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatSamedi==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurSamedi==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateDim}" style="color:red;"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdvCol07Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07}"/>&nbsp;
                        <h:outputText value="#{rdv.dimanche}" style="color:red;"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdvCol07Semaine}" reRender="idrdvdimanche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07Sup&&rdv.rdvEtatDimanche==0&&rdv.rdvUsrDimanche==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatDimanche==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatDimanche==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatDimanche==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreurDimanche==true}" style="color:red"/>
                        </h:column>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="jour" label="Par Jour">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modeJour}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Jour précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvByJourPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateJour" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.parJour}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Jour suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvByJourSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.valNatJour}"  >
                            <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.mesNaturesRdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdvByJour}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Jour" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.initImpression}"/>&nbsp;&nbsp;
                </h:panelGrid> <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" enableContextMenu="false" styleClass="bg" id="tableRdv3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.datamodelLesRdvParJour}" var="rdv" >
                        <rich:column width="120px" sortable="false" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                            <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}" style="font-weight:bold;"/>&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdv}" reRender="idrdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.rdvEtat==0&&rdv.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtat==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtat==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtat==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreur==true}" style="color:red"/>
                        </rich:column>
                        <rich:column width="15%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{rdv.libNature}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{rdv.nomTiers}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Tache"/></f:facet>
                            <h:outputText value="#{rdv.rdvTache}"/>
                        </rich:column>
                        <rich:column width="35%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Sujet"/></f:facet>
                            <h:outputText value="#{rdv.rdvSujet}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab name="parliste" label="Par Liste">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modeListe}"/>
                <h:panelGrid columns="2">
                    <h:panelGrid id="pngBouton" columns="3" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.ajouterRdv}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier Evènement sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modifierRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.afficheRdv}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer Evènement sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.afficheRdv}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" reRender="pngBouton,tableRdv4"/>
                    </h:panelGrid>
                    <h:panelGrid columns="12">
                        <h:outputText value="Du"/>
                        <rich:calendar style="background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.jourDeb}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:outputText value="Au"/>
                        <rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.jourFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:column> <h:outputText value="Nature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.valNatListe}"  >
                                <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.mesNaturesRdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>&nbsp;&nbsp;
                        <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.chargerLesRdv}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv4"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Imprimer la Liste" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.initImpression}"/>&nbsp;&nbsp;
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" enableContextMenu="false" styleClass="bg" id="tableRdv4" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.datamodelRdv}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.selectionRdv}" reRender="pngBouton"/>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.libNature}">
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{rdv.libNature}"/>&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.supprimerRdv}" reRender="idrdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.rdvEtat==0&&rdv.rdvUsrDe==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.userSelectionne.usrid}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtat==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtat==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtat==3}" style="text-align:center"/>
                            <h:outputText value="ERREUR" rendered="#{rdv.rdvErreur==true}" style="color:red"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.rdvDteDe} #{rdv.rdvHrDe}:#{rdv.rdvMnDe}" sortOrder="DESCENDING">
                            <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                            <h:outputText value="#{rdv.rdvDteDe}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>&nbsp;
                            <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{rdv.nomTiers}" >
                            <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{rdv.nomTiers}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.rdvTache}" >
                            <f:facet name="header" ><h:outputText value="Tache"/></f:facet>
                            <h:outputText value="#{rdv.rdvTache}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="true"  sortBy="#{rdv.rdvSujet}">
                            <f:facet name="header" ><h:outputText value="Sujet"/></f:facet>
                            <h:outputText value="#{rdv.rdvSujet}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true"  sortBy="#{rdv.rdvSujet}">
                            <f:facet name="header" ><h:outputText value="Statut"/></f:facet>
                            <h:outputText value="#{rdv.libEtat}  #{rdv.rdvCr}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab name="parMap" label="LOCALISATION MAPBOX" style="height:550px">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.caluleMap}" reRender="idLieuGps"/>
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
                            center: [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.origine}],
                            zoom: 13
                        });
                        //on affiche des marqueurs à la position de nos points GPS, indiquant leur numéros et recentrant la carte sur eux au clic.
                        var coords = [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.coordonnees}]; // starting position [lng, lat]
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
            </rich:tab>

            <rich:tab name="googleAgenda" label="Google Agenda" rendered="false">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="idAgenda"/>
                <h:panelGrid id="idAgenda" width="100%">
                    <iframe src="https://www.google.com/calendar/embed?showCalendars=0&amp;showTz=0&amp;height=600&amp;wkst=2&amp;bgcolor=%23FFFFFF&amp;src=${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMail}&amp;color=%232F6309&amp;src=%23contacts%40group.v.calendar.google.com&amp;color=%232952A3&amp;ctz=Africa%2FAbidjan" style="border:solid 1px #777" width="1000" height="600" frameborder="0" scrolling="no"></iframe>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Rdv" style="color:#0000FF;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Visite" style="color:#173B0B"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Intervention" style="color:#FAAC58;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Appel" style="color:#01A9DB;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Rappel" style="color:#000000;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="ToDo" style="color:#B404AE;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Post-it" style="color:#FA58F4;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Emploi du temps" style="color:#610B0B;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Pointage" style="color:#FF8000;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Réunion" style="color:#FF0040;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Message" style="color:#585858;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Rondes" style="color:#585858;"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>
        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES ICONES:"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/ajouter.png" alt="Ajouter" height="15px" width="15px" title="Ajouter évènement"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/supprimer.png" alt="Supprimer" height="15px" width="15px" title="Suppression possible"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/valider.png" alt="Traité" height="15px" width="15px" title="Traité"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/transferer.png" alt="Reporté" height="15px" width="15px" title="Reporté"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/annuler.gif" alt="Annulé" height="15px" width="15px" title="Annulé"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelEvent" width="900" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelRdv}" var="event" >
            <f:facet name="header"><h:outputText value="GESTION DES EVENEMENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.annule}" image="/images/close.gif" styleClass="hidelink" reRender="panelEvent"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormEvent">

                <h:panelGrid  width="100%" id="panelRdvGrid">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabEvent" label="Evènement">
                            <h:panelGrid  width="100%" id="panelRdvGrid1" headerClass="headerTab" styleClass="panneau_accueil" >
                                <h:panelGrid style="width:100%;">
                                    <h:panelGrid  style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                                        <h:column><h:outputText value="Nature:" /></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.mesNaturesRdvItems}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.choixTypeRdv}" reRender="panelGlobal,panelRdvGrid1,tabMail,tabCollaborateur,tabCr"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGroup id="tiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv!=8}" >
                                        <h:panelGrid  style="width:100%;" id="idTierC" columnClasses="clos20,clos80"  columns="2">
                                            <h:column><h:outputText style="text-decoration:underline" value="Collaborateur:" /></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.refCollaborateur}" disabled="true" readonly="true">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesCollaborateurItems}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                        </h:panelGrid>
                                        <h:panelGrid style="width:100%;" id="idTierTier" columnClasses="clos20,clos80" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv!=9}">
                                            <h:column><h:outputText style="text-decoration:underline"  value="Tiers:" /></h:column>
                                            <h:column>
                                                <h:inputText id="cltajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                                    <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients" style="background-color:#FFF8D4;"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,cltajt,panelListeTiers,formModalListeTiers,tableContact,tableHistorique"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.gestionPatient}"><h:outputText style="text-decoration:underline"  value="Patient:" /></h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.gestionPatient}">
                                                <h:inputText id="idPatient" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNomPat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                                    <rich:toolTip id="tooladdPat" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les patients" style="background-color:#FFF8D4;"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.recherchePatients}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPatient,panelListePatients,formModalListePatients,tableHistorique"/>
                                                </h:inputText>
                                            </h:column>
                                        </h:panelGrid>
                                    </h:panelGroup>
                                    <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!=10}">
                                        <h:column><h:outputText value="Date début:" /></h:column>
                                        <h:column>
                                            <rich:calendar style="background-color:green;color:white;" id="idDteDebut" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvDteDe}" locale="FR" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateVerrouillee}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton title="Reporter l'évènement" value="Reporter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.reporterRdv}" reRender="panelReport" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvEtat==0}"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGroup id="heure" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv!=8&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv!=9}" >
                                        <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" >
                                            <h:column><h:outputText value="Heure de début:" /></h:column>
                                            <h:column>
                                                <h:panelGrid  columns="4">
                                                    <h:column>
                                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvHrDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                        </h:selectOneMenu>
                                                    </h:column>
                                                    <h:column>h</h:column>
                                                    <h:column>
                                                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvMnDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                                        </h:selectOneMenu>
                                                    </h:column>
                                                    <h:column>mn</h:column>
                                                </h:panelGrid>
                                            </h:column>
                                        </h:panelGrid>
                                    </h:panelGroup>
                                    <h:panelGroup id="date" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0}" >
                                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                                            <h:column><h:outputText value="Date fin" /></h:column>
                                            <h:column><rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvDteFi}" locale="FR" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}"/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                                            <h:column><h:outputText value="Heure fin:" /></h:column>
                                            <h:column>
                                                <h:panelGrid  columns="4">
                                                    <h:column>
                                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvHrFi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                        </h:selectOneMenu></h:column>
                                                    <h:column>h</h:column>
                                                    <h:column>
                                                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvMnFi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                                        </h:selectOneMenu>
                                                    </h:column>
                                                    <h:column>mn</h:column>
                                                </h:panelGrid>
                                            </h:column>
                                        </h:panelGrid>
                                        <h:panelGrid style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                                            <h:column><h:outputText value="Durée:" /></h:column>
                                            <h:column>
                                                <h:panelGrid  columns="4"><h:column>
                                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvHrDuree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                        </h:selectOneMenu>
                                                    </h:column>
                                                    <h:column>h</h:column>
                                                    <h:column>
                                                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvMnDuree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                                        </h:selectOneMenu>
                                                    </h:column>
                                                    <h:column>mn</h:column>
                                                </h:panelGrid>
                                            </h:column>
                                        </h:panelGrid>
                                    </h:panelGroup>
                                    <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                        <h:column><h:outputText value="Sujet:" /></h:column>
                                        <h:column>
                                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvSujet}" maxlength="100" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.sujetRdv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}"/>
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvSujet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.sujetRdv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas de sujet" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesSujetsItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Description:" /></h:column>
                                        <h:column><h:inputTextarea id="idTexte" cols="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvDescript}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.actionRdv}"><h:outputText style="text-decoration:underline"  value="Tache à faire:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.actionRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.choixTache}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemValue="pas de tache" itemLabel="Pas de tache"/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesTachesItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lieuxRdv}"> <h:outputText value="Lieu concerné:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lieuxRdv}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvLieu}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0}"><h:outputText value="Mode:" /></h:column>
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvMode}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.typeRdv==0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                            <f:selectItem itemLabel="Non renseigné" itemValue="Non renseigné"/>
                                            <f:selectItem itemLabel="Téléphone" itemValue="Téléphone"/>
                                            <f:selectItem itemLabel="Mailing" itemValue="Mail"/>
                                            <f:selectItem itemLabel="Démarchage" itemValue="Déplacement"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabMail" label="Contacts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.optionTiers.ongletContact=='0'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='8')}">
                            <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableContact" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dataModelContacts}" var="con" >
                                <rich:column width="40%">
                                    <f:facet name="header" ><h:outputText value="Nom et prénom"/></f:facet>
                                    <h:outputText value="#{con.conpatronyme}"/>
                                </rich:column>
                                <rich:column width="40%">
                                    <f:facet name="header" ><h:outputText value="Mail"/></f:facet>
                                    <h:outputText value="#{con.mailCumul}"/>
                                </rich:column>
                                <rich:column width="20%" style="text-align:center;">
                                    <f:facet name="header" ><h:outputText value="Sélectionné(e)" style="text-align:center;"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{con.select}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}" style="text-align:center;"/>
                                </rich:column>
                            </rich:extendedDataTable>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvErreur}"><h:outputText value="ERREUR ENVOI:" style="color:red"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvErreur}"><h:inputText style="width:100%;color:red;" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvStatut}"/></h:column>
                        </rich:tab>

                        <rich:tab id="tabCollaborateur" label="Collaborateurs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.optionTiers.ongletColaborateur=='0'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='8')}">
                            <rich:extendedDataTable enableContextMenu="false" styleClass="bg" id="tableCollaborateur" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dataModelCollaborateur}" var="col" >
                                <rich:column width="40%">
                                    <f:facet name="header" ><h:outputText value="Nom et prénom"/></f:facet>
                                    <h:outputText value="#{col.usrPatronyme}"/>
                                </rich:column>
                                <rich:column width="30%">
                                    <f:facet name="header" ><h:outputText value="Fonction"/></f:facet>
                                    <h:outputText value="#{col.usrFonction}"/>
                                </rich:column>
                                <rich:column width="20%">
                                    <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                                    <h:outputText value="#{col.usrService}"/>
                                </rich:column>
                                <rich:column width="10%" style="text-align:center;">
                                    <f:facet name="header" ><h:outputText value="Sélectionné(e)" style="text-align:center;"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{col.selectUser}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}" style="text-align:center;"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </rich:tab>

                        <rich:tab id="tabHistorique" label="Historiques" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!='3'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!='7'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!='8'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!='9'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!='11'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature!='14')}">
                            <rich:extendedDataTable enableContextMenu="false" styleClass="bg" id="tableHistorique" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dataModelHistorique}" var="his" >
                                <rich:column width="10%" sortable="true" >
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{his.libNature}" />
                                </rich:column>
                                <rich:column width="10%">
                                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{his.rdvDteDe}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="5%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                                    <h:outputText value="#{his.rdvHrDe}:#{his.rdvMnDe}" />
                                </rich:column>
                                <rich:column width="20%">
                                    <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                                    <h:outputText value="#{his.rdvSujet}" title="#{his.rdvSujet}"/>
                                </rich:column>
                                <rich:column width="25%">
                                    <f:facet name="header" ><h:outputText value="Description"/></f:facet>
                                    <h:outputText value="#{his.rdvDescript}" title="#{his.rdvDescript}"/>
                                </rich:column>
                                <rich:column width="30%">
                                    <f:facet name="header" ><h:outputText value="Compte rendu"/></f:facet>
                                    <h:outputText value="#{his.rdvCr}" title="#{his.rdvCr}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </rich:tab>

                        <rich:tab id="tabCr" label="Compte rendu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='6'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='13'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.compteRendu}">
                            <h:panelGrid  width="100%" headerClass="headerTab" styleClass="panneau_accueil" >
                                <h:panelGrid style="width:100%;">
                                    <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='1'}"><h:outputText value="Etat:" /></h:column>
                                        <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvNature=='1'}" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                                            <f:selectItem itemLabel="Traité" itemValue="1"/>
                                            <f:selectItem itemLabel="Reporté" itemValue="2"/>
                                            <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                        </h:selectOneMenu>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lieuxRdv}"><h:outputText value="Produit visité:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lieuxRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas de produit" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesLieuxItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.budgetRdv}"><h:outputText value="Budget:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.budgetRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvBudget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas de budget" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesBudgetItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.apportRdv}"><h:outputText value="Apport:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.apportRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvApport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas d`apport" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesApportItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modeFinRdv}"><h:outputText value="Mode financement:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.modeFinRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvModeFin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas de mode de financement" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesModeFinItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.delaisRdv}"><h:outputText value="Délais d`exécution:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.delaisRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvDelais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas de délais d`exécution" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesDelaisItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.actionRdv}"><h:outputText style="text-decoration:underline"  value="Prochaine action:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.actionRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvTache}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas d`action" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesActionItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.actionRdv}"><h:outputText value="Date prochaine action:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.actionRdv}">
                                            <script type="text/javascript" language="Javascript">
                                                function dayEnabledStart(day){
                                                    maDate = new Date()
                                                    maDate.setDate(maDate.getDate()-1)
                                                    if (maDate > day.date) {
                                                        return false;
                                                    } else {
                                                        return true;
                                                    }
                                                }
                                                function disabledStyle(day){
                                                    if (!dayEnabledStart(day)) return 'rich-calendar-boundary-dates disabledDay';
                                                }
                                            </script>
                                            <rich:calendar style="background-color:green;color:white;" id="idDteProc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvDateProchaine}" locale="FR" inputSize="8" datePattern="dd/MM/yyyy" enableManualInput="false" immediate="true" isDayEnabled="dayEnabledStart" dayStyleClass="disabledStyle" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                            </rich:calendar>
                                        </h:column>
                                    </h:panelGrid>
                                    <br>
                                    <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.conclusionRdv}"><h:outputText style="text-decoration:underline"  value="Concusion vendeur:" /></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.conclusionRdv}">
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvConclusion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                                                <f:selectItem itemLabel="pas de conclusion" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.lesConclusionItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Compte rendu:" /></h:column>
                                        <h:column><h:inputTextarea rows="15" cols="80" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvCr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}"/></h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabLieu" label="LOCALISATION MAPBOX" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdv.rdvX!=0}">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.caluleMapRdv}" reRender="idLieuGpsRdv"/>
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
                                        center: [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.origine}],
                                        zoom: 13
                                    });
                                    //on affiche des marqueurs à la position de nos points GPS, indiquant leur numéros et recentrant la carte sur eux au clic.
                                    var coords = [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.coordonnees}]; // starting position [lng, lat]
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

                    </rich:tabPanel>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup  id="buttEvent" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails}">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.saveEvent}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.rdvdetails||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.compteRendu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEvent,pngBouton,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelReport" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelReport}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelReport}" var="report" >
            <f:facet name="header"><h:outputText value="REPORT EVENEMENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.fermerReportRdv}" image="/images/close.gif" styleClass="hidelink" reRender="panelReport"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormReport">

                <h:panelGrid  width="100%" id="panelRdvGrid" headerClass="headerTab" styleClass="panneau_accueil" >
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Date report:" /></h:column>
                            <h:column>
                                <rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.dateReport}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" />
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="heure">
                            <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" >
                                <h:column><h:outputText value="Heure de début:" /></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.heureReport}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.minuteReport}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Motif report:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.motifReport}" maxlength="20"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup  id="buttReport">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.validerReport}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEvent,panelReport,pngBouton,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="950" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelTiers}" var="tiers" >
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.datamodelTiers}"  var="tiers">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.selectionTiers}"/>
                        <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="12%">
                            <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                            <h:outputText value="#{tiers.tiecategorie}" title="#{tiers.tiecategorie}"/>
                        </rich:column>
                        <rich:column label="Sigle" sortable="true" sortBy="#{tiers.tiesigle}" width="12%">
                            <f:facet name="header"><h:outputText  value="sigle" /></f:facet>
                            <h:outputText value="#{tiers.tiesigle}" title="#{tiers.tiesigle}"/>
                        </rich:column>
                        <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="26%">
                            <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                            <h:outputText value="#{tiers.tieraisonsocialenom}" title="#{tiers.tieraisonsocialenom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{tiers.tieprenom}" title="#{tiers.tieprenom}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{tiers.tiecivilite}" title="#{tiers.tiecivilite}"/>
                        </rich:column>
                        <rich:column label="Téléphone" sortable="true" sortBy="#{tiers.tieburtel1}" width="10%">
                            <f:facet name="header"><h:outputText  value="Téléphone" /></f:facet>
                            <h:outputText value="#{tiers.tieburtel1}" title="#{tiers.tieburtel1}"/>
                        </rich:column>
                        <rich:column label="Mail" sortable="true" sortBy="#{tiers.tiemail1}" width="10%">
                            <f:facet name="header"><h:outputText  value="Mail" /></f:facet>
                            <h:outputText value="#{tiers.tiemail1}" title="#{tiers.tiemail1}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valtiers">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.annuleTiers}" reRender="panelListeTiers,tiers,tableContact,tableHistorique,tableHistorique"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.calculeTiers}" reRender="panelListeTiers,tiers,tableContact;tableHistorique,tableHistorique"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListePatients" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelPatients}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelPatients}" var="patients" >
            <f:facet name="header"><h:outputText value="Sélection du patient"/></f:facet>
            <a4j:form id="formModalListePatients">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tablePatients" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.datamodelPatients}"  var="pat">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.selectionPatients}"/>
                        <rich:column label="Civilité" sortable="true" sortBy="#{pat.patCivilite}" width="15%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{pat.patCivilite}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{pat.patNom}" width="55%">
                            <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                            <h:outputText value="#{pat.patNom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{pat.patPrenom}" width="20%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{pat.patPrenom}"/>
                        </rich:column>
                        <rich:column label="Né(e)" sortable="true" sortBy="#{pat.patDateNaissance}" width="10%">
                            <f:facet name="header"><h:outputText  value="Né(e)" /></f:facet>
                            <h:outputText value="#{pat.patDateNaissance}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valpatients">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.annulePatients}" reRender="panelListePatients,tiers,tableHistorique"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.calculePatients}" reRender="panelListePatients,tiers,tableHistorique"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.nomModeleDocument}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.listeImpressionsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formPlanning.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
