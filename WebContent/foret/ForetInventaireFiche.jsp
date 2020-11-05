<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

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

<f:subview id="inventairefiche">

    <a4j:form  enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES INVENTAIRES EN FORET" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Inventaire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.autorisationDocument}">
                    <h:panelGrid width="100%" id="idPanGlobal">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesSerieUserItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value="Chantier:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idChantier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvChantier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvId!=0}">
                                            <f:selectItem itemLabel="Sélectionnez chantier" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesLieuxItem}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.selectionChantier}" reRender="idPanGlobal,panelBoutonLigne,panelLigne"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Marteau:" style="text-decoration:underline"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvMarteau}" style="width:100%" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Région:" style="text-decoration:underline"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvRegion}" style="width:100%" disabled="true"/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value="Agent saisie:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idAgent" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvIdCommercial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvId!=0}">
                                            <f:selectItem itemLabel="Sélectionnez Agent" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesUsersItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idResponsable" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvIdResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvId!=0}">
                                            <f:selectItem itemLabel="Sélectionnez Responsable" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesPersonnelsItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Equipe:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idEquipe" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvIdEquipe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvId!=0}">
                                            <f:selectItem itemLabel="Sélectionnez Equipe" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesEquipeItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Nb arbre:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvTotArbre}" style="text-align:right;width:100%"  readonly="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Cubage:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvTotCub}" style="text-align:right;width:100%"  readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="3" maxFractionDigits="3"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_mod}">
                                <h:panelGrid  columns="13" width="100%" id="panelLigne1">
                                    <h:column>
                                        <h:outputText value="Essence:"/>
                                        <h:selectOneMenu tabindex="1" style="width:100px" id="idEssence" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruEssence}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesEssencesItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="N° arbre:"/>
                                        <h:inputText tabindex="2" id="idArbre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruArbre}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.verifUnicite}" reRender="idArbre"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="N° RFID:"/>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruRfidInv}"></h:inputText>
                                    </h:column>
                                     <h:column>
                                        <h:outputText value="Classement:"/>
                                        <h:selectOneMenu tabindex="4" style="width:70px" id="idClassement" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruClasInv}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesClassementsItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Diam. base:"/>
                                        <h:inputText tabindex="5" id="idDB" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruDiamBasInv}" style="width:90%;text-align:right">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.calculCubage}" reRender="idDB,idDH,idDM,idCUB"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Diam. Haut:"/>
                                        <h:inputText tabindex="6" id="idDH" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruDiamHauInv}" style="width:90%;text-align:right">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.calculCubage}" reRender="idDB,idDH,idDM,idCUB"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Diam. moy.:"/>
                                        <h:inputText tabindex="7" id="idDM" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruDiamMoyInv}" style="width:90%;text-align:right" disabled="true">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.calculCubage}" reRender="idDB,idDH,idDM,idCUB"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Hauteur:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruLongInv}" style="width:90%;text-align:right">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.calculCubage}" reRender="idDB,idDH,idDM,idCUB"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Cubage:"/>
                                        <h:inputText tabindex="9" id="idCUB" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruCubInv}" disabled="true" style="width:90%;text-align:right">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="3" maxFractionDigits="3"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Géo. Loc.(X/Y):"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruLocX}" style="width:90%;text-align:right"/>&nbsp;&nbsp;
                                        <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretGrume.gruLocY}" style="width:90%;text-align:right"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Photo:"/>
                                        <a4j:commandButton tabindex="12" id="idPj" image="/images/mail_pj.png" style="height:28px;width:28px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.ouvrirPj}" reRender="panelPJ,panalAjoutFile"/>
                                    </h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton  tabindex="13" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.datamodelGrume}" var="doclig">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Essence"/></f:facet>
                                        <h:outputText value="#{doclig.gruEssence}" style="#{doclig.styleLigne}"/><br>
                                    </rich:column>
                                    <rich:column sortable="false" width="9%">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{doclig.gruArbre}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="9%">
                                        <f:facet name="header"><h:outputText  value="RFID"/></f:facet>
                                        <h:outputText value="#{doclig.gruRfidInv}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%">
                                        <f:facet name="header"><h:outputText  value="Clas."/></f:facet>
                                        <h:outputText value="#{doclig.gruClasInv}" style="#{doclig.styleLigne}"/><br>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="10%" >
                                        <f:facet name="header"><h:outputText  value="D. base"/></f:facet>
                                        <h:outputText value="#{doclig.gruDiamBasInv}" rendered="#{doclig.gruDiamBasInv!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="9%" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="D. Haut"/></f:facet>
                                        <h:outputText value="#{doclig.gruDiamHauInv}" rendered="#{doclig.gruDiamHauInv!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="9%">
                                        <f:facet name="header"><h:outputText  value="D. moy."/></f:facet>
                                        <h:outputText value="#{doclig.gruDiamMoyInv}" rendered="#{doclig.gruDiamMoyInv!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="9%">
                                        <f:facet name="header"><h:outputText  value="Long"/></f:facet>
                                        <h:outputText value="#{doclig.gruLongInv}" rendered="#{doclig.gruLongInv!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="9%">
                                        <f:facet name="header"><h:outputText value="Cub."  /></f:facet>
                                        <h:outputText value="#{doclig.gruCubInv}" rendered="#{doclig.gruCubInv!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="3" maxFractionDigits="3"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:left;" width="10%">
                                        <f:facet name="header"><h:outputText value="Géo. Loc"  /></f:facet>
                                        <h:outputText value="#{doclig.gruLocX}/#{doclig.gruLocY}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="5%">
                                        <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                                        <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/arbre#{doclig.anneeInv}/#{doclig.photo}" alt="pho" height="30px" width="30px" style="text-align:center" rendered="#{doclig.gruPhoto}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.autorisationImputation}">
                    <jsp:include flush="true" page="/foret/ForetInventaireCommun.jsp" />

                </rich:tab>

                <rich:tab label="Géo-locatisation" id="tabGeoloc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_acc_imputation}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.calculGeloc}" reRender="idLieuGps"/>
                    <jsp:include flush="true" page="/foret/ForetInventaireCommun.jsp" />
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
                                center: [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.origine}],
                                zoom: 13
                            });
                            //on affiche des marqueurs à la position de nos points GPS, indiquant leur numéros et recentrant la carte sur eux au clic.
                            var coords = [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.coordonnees}]; // starting position [lng, lat]
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

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.autorisationComplement}">
                    <jsp:include flush="true" page="/foret/ForetInventaireCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_acc_habilitation}">
                    <jsp:include flush="true" page="/foret/ForetInventaireCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.autorisationEtat}">
                    <jsp:include flush="true" page="/foret/ForetInventaireCommun.jsp"/>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID du document:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.nomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvUserCreat}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.nomModification}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvUserModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat==3)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.annuleDocument}" reRender="idSubView"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_aff_action}"/>
                </center>
                <center>
                    <h:outputText id="outptpanelTiers" style="color:red;" value="la date et le choix du chantier sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelPJ}" var="pie">
            <f:facet name="header"><h:outputText value="Pièce jointe"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.modePj==2}">
                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.reInitPj}"/>
                    </h:column>&nbsp;&nbsp;
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.modePj==2}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fermerPj}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <h:form id="formPJ" enctype="multipart/form-data">
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.modePj==2}" var="pjvisu">
                    <h:panelGrid width="100%">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.typeFichier==0}" var="sc1">
                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.urlphotoProd}" width="100%" height="800px"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.typeFichier==1}" var="sc2">
                            <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fichierMine}" width="100%" height="550">
                                <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fichierUrl}"></a>
                            </object>
                        </c:if>
                    </h:panelGrid>
                </c:if>
            </h:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="900" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelAjoutPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelAjoutPJ}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PIECES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fermerPj}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil" id="panDoc1">
                    <t:inputFileUpload id="idDoc" storage="file" accept=".jpg, .JPG" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.uploadedFile}"/>
                    <br>
                    <h:panelGroup>
                        <center>
                            <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.validerPj}"/>
                        </center>
                    </h:panelGroup>
                    <br>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
