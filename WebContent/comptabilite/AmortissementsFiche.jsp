<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

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

<f:subview id="ficamortis">

    <center>
        <a4j:form enctype="multipart/form-data">

            <center> <h2><h:outputText value="GESTION DES IMMOBILISATIONS" styleClass="titre"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true"  style="width:100%;border:0px;" id="panGlob">

                <rich:tab label="Description du bien">
                    <h:panelGrid id="pgrdajt1" width="100%" >
                        <h:panelGrid id="f1" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="N° ordre:" /></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNum}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Amortissement inactif:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.inactif}"/></h:column>
                            <h:column><h:outputText value="Libellé du bien:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoLibelle}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.controleSave}" reRender="panGlob,prgtpAjt,outptlibachat"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nature du bien:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" id="natureajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <f:selectItem itemLabel="Immobilier" itemValue="0"/>
                                    <f:selectItem itemLabel="Mobilier" itemValue="1"/>
                                    <f:selectItem itemLabel="Autre" itemValue="2"/>
                                    <f:selectItem itemLabel="Caution" itemValue="3"/>
                                    <f:selectItem itemLabel="Frais de constitution" itemValue="4"/>
                                    <a4j:support event="onchange" reRender="panGlob,pgrdmod2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date d'achat:" /></h:column>
                            <h:column>
                                <rich:calendar style=" background-color:white"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoDateAchat}"    inputSize="8" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.zoneInterdite}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panGlob,prgtpAjt,outptlibachat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.controleSave}"/>
                                </rich:calendar>
                            </h:column>
                            <h:column><h:outputText value="Date mise en service:" /></h:column>
                            <h:column>
                                <rich:calendar style=" background-color:white;"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoDateService}"    inputSize="8" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.zoneInterdite}"/>
                            </h:column>
                            <h:column><h:outputText value="Valeur d'achat:"/></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoValeurAchat}" style="text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.zoneInterdite}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange"  reRender="panGlob,prgtpAjt,f1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.controleSave}"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="" /></h:column>
                            <h:column><h:outputText value="" /></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="correction" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Amort. antérieur correctif:" /></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoAnterieur}"  style="text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;
                                <rich:calendar style=" background-color:white;"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoDateAnterieur}"   inputSize="8" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            </h:column>
                            <h:column><h:outputText value="Dotation corrective:" rendered="false"/></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoValeurReevalue}"  style="text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"  rendered="false">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;
                                <rich:calendar style=" background-color:white;"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoDateReevalue}"   inputSize="8" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"  rendered="false"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="f2" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                            <h:column><h:outputText value="Taux TVA:" /></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTvaTaux}"  style=";text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <a4j:support eventsQueue="maQueue" event="onchange"  reRender="f2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculMontTva}"/>
                                </h:inputText>
                            </h:column>
                            <h:column> <h:outputText value="Montant TVA:" /></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTvaTotal}"  style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taux Amort. comptable:" /></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTauxComptable}" style="text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.zoneInterdite}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur"  reRender="panGlob,prgtpAjt,nbanneajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculNbreAnCmptble}"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb. années comptable:" /></h:column>
                            <h:column>
                                <h:inputText size="20" id="nbanneajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNbAnneeCpte}" style="text-align:right;" readonly="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taux Amort. fiscal:"/></h:column>
                            <h:column>
                                <h:inputText size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTauxFiscal}" style="text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur"  reRender="nbanneeajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculNbreAnFix}"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText  value="Nb. années fiscal:" /></h:column>
                            <h:column>
                                <h:inputText size="20" id="nbanneeajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNbAnneeFiscal}" style="text-align:right;" readonly="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="f3" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Mode calcul:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoMode}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.zoneInterdite}">
                                    <f:selectItem itemLabel="Linéaire" itemValue="0"/>
                                    <f:selectItem itemLabel="Accéléré" itemValue="1" itemDisabled="true"/>
                                    <f:selectItem itemLabel="Dégressif" itemValue="2" itemDisabled="true"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mode Financement:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoFinancement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <f:selectItem itemLabel="Sans" itemValue="0"/>
                                    <f:selectItem itemLabel="CMT" itemValue="1"/>
                                    <f:selectItem itemLabel="Crédit" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Info. complémentaires:" /></h:column>
                            <h:column><h:inputText style="width:100%" id="infcplajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoInfosCpl}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Origine du bien:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoOrigine}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <f:selectItem itemLabel="NP" itemValue="0"/>
                                    <f:selectItem itemLabel="Pays" itemValue="1"/>
                                    <f:selectItem itemLabel="Zone" itemValue="2"/>
                                    <f:selectItem itemLabel="Extérieur" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.presenceParc}"><h:outputText value="Nature catégorie:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.presenceParc}">
                                <h:selectOneMenu style="width:100%" id="idNature" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.natureDetail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <f:selectItem itemLabel="Non renseigné" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.mesNatureDetail}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Affectations/Imputations">
                    <h:panelGrid width="100%" id="pgrdmod2" columns="2" columnClasses="clos50g,clos50g">
                        <h:panelGrid id="idComptes" columns="2" style="width:100%;" columnClasses="clos25,clos75" styleClass="fichefournisseur">
                            <h:outputText value="Modèle amortissement:" style="color:red;text-decoration:underline;"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoModele}" style="width:100%;color:red" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez un modèle" itemValue=""/>
                                <f:selectItem itemLabel="Charger les comptes par défaut" itemValue="XXX"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.mesModelesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculeModele}" reRender="idComptes"/>
                            </h:selectOneMenu>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=4}" value="Compte d'immobilisation:" style="text-decoration:underline;" />
                            <h:selectOneMenu id="idCpteImmobilisation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=4}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.compte_immo}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez un compte" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesplanComptablesCmptImoItems}"/>
                            </h:selectOneMenu>
                            <h:outputText id="idCpteAmortissement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature==4}" value="Compte d'amortissement:" style="text-decoration:underline;" />
                            <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature==4}"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.compte_amo}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez un compte" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesplanComptablesCmptAmoItems}"/>
                            </h:selectOneMenu>
                            <h:outputText id="idCpteDotation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature==4}" value="Compte de dotation:" style="text-decoration:underline;" />
                            <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature==4}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.compte_dot}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez un compte" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesplanComptablesCmptDotItems}"/>
                            </h:selectOneMenu>
                            <h:outputText id="idCpteCession" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=2}" value="Compte de cession:" style="text-decoration:underline;" />
                            <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature<=2}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.compte_ces}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez un compte" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesplanComptablesCmptCesItems}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="width:100%;" columnClasses="clos25,clos75" styleClass="fichefournisseur1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature!=3}">
                            <h:outputText value="Référence du bien:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoReference}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            <h:outputText value="N°Série ou Chassis:"/>
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoChassis}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            <h:outputText value="N°Facture achat:" />
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoFactureAchat}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            <h:outputText value="Pièce d'achat:" />
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoPieceAchat}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            <h:outputText value="Fournisseur:" />
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.compte_fournisseur}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez un fournisseur" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesplanComptablesFournisseursItems}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid border="0" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:outputText value="Localisation du bien:" style="text-decoration:underline;"/>
                        <h:column>
                            <h:selectOneMenu id="idLocalisation" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoLocalisation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sans Localisation" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.meslocalisationsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.decoupageActivite}">
                            <h:selectOneMenu id="idActivite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.activite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.decoupageActivite}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dataModelDecoupageActivtes}" var="saisieAnal">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.selectionAnalytique}"/>
                                    <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.decoupageActivite}">
                                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneActivite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.laColonne1Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.valideColonne1}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.decoupageActivite}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.laColonne2Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.valideColonne2}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.decoupageActivite}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.laColonne3Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.valideColonne3}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="%"  width="15%" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                        <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.controleEcartAnalytique}" reRender="idTableAnal" />
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action!=3}">
                                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.supprimerAnalytique}" reRender="idTableAnal"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  border="0" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:outputText  value="Site:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testsite}" />
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testsite}">
                            <h:selectOneMenu id="idSite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.site}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesSitesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.chargerDepartement}"  reRender="dept"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Département:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testdept}"/>
                        <h:panelGroup id="dept"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testdept}">
                            <h:selectOneMenu id="idDepatement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dept}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesdepartements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.chargerService}"  reRender="serv"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Service:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testservice}"/>
                        <h:panelGroup id="serv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testservice}">
                            <h:selectOneMenu id="idService" style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.service}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesServices}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Région:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testreg}"/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testreg}">
                            <h:selectOneMenu id="idRegion" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.region}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesRegionsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.chargerSecteur}"  reRender="secteur"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Secteur:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testsecteur}"/>
                        <h:panelGroup id="secteur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testsecteur}">
                            <h:selectOneMenu id="idSecteur" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.secteur}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesSecteur}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.chargerSecteur}"  reRender="pdv"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="PDV:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testPVD}"/>
                        <h:panelGroup id="pdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testPVD}">
                            <h:selectOneMenu id="idPdv" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.pdv}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesPointDeVente}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Dossier:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testDossier==1}"/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testDossier==1}">
                            <h:selectOneMenu id="idDossier" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dossier}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesDossiersItems}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Parc:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testParc}"/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testParc}">
                            <h:selectOneMenu id="idParc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.parc}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesParcsItems}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Agent:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testagent}"/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testagent}">
                            <h:selectOneMenu id="idAgent" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.agent}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesAgentsItems}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Clé:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.optionComptabilite.analytique}"/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.optionComptabilite.analytique}">
                            <h:selectOneMenu id="idCle" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.cle1}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesClesItems}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Budget:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.optionComptabilite.budget}"/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.optionComptabilite.budget}">
                            <h:selectOneMenu id="idBudget" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.budget}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesBudgetsItems}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" styleClass="closCarte50,closCarte50">
                        <h:panelGrid id="panPhoto" columns="2" style="height:250px" width="100%" styleClass="top" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Photo du produit"/></f:facet>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoPhoto==null}">
                                <t:inputFileUpload id="file" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.uploadedFile}"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                                </h:commandButton>
                                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup  id="grp3" >
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoPhoto!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.urlphotoProd}" width="150px" height="150px"/>&nbsp;
                                    <h:panelGrid columns="2" width="150px">
                                        <h:commandButton image="/images/supprimer.png" title="supprimer photo" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                                    </h:panelGrid>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoPhoto==null}">
                                    <img alt="" src="images/no_image.jpeg" width="150px" height="150px" />
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="panPdf" columns="2" style="height:250px" width="100%" styleClass="top" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="PDF Scan de la facture d'achat"/></f:facet>
                            <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_affFicPdf}">
                                <t:inputFileUpload id="filePdf" accept=".pdf,.PDF" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.uploadedPDFFile}"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <a4j:support eventsQueue="maQueue"  immediate="true"/>
                                </h:commandButton>
                                <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_affFicPdf}">
                                <h:outputText value="Nom:"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoScan}" />&nbsp;&nbsp;&nbsp;
                                <h:commandButton value="Lire le ficher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.readPdfFile}" />&nbsp;&nbsp;&nbsp;
                                <h:commandButton image="/images/supprimer.png" title="supprimer PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Rebut / Cession" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature!=3}">
                    <h:panelGrid id="cession" style="width:100%;">
                        <h:panelGrid id="pgrdmod3" columns="2"  style="width:100%;" columnClasses="clos50g,clos50g">
                            <h:panelGrid columns="2" style="width:100%;" id="idetat" columnClasses="clos25,clos75" styleClass="fichefournisseur">
                                <h:outputText  value="Mode " />
                                <h:selectOneMenu id="modemod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTypeSortie}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Cession" itemValue="1"/>
                                    <f:selectItem itemLabel="Rebut" itemValue="2"/>
                                    <f:selectItem itemLabel="Amortis" itemValue="3"/>
                                    <f:selectItem itemLabel="Désactive (Gelé)" itemValue="4"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="cession,idetat" />
                                </h:selectOneMenu>
                                <h:outputText  value="Valeur cession:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoValeurCession}"  style="width:80%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:outputText value="Client:"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNomClient}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                                <h:outputText value="N°Pièce comptable:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoPieceCession}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                                <h:outputText value="Net à payer:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNetAPayer}"  style="width:80%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange"  reRender="soldemod" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculValeurCession}"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos25,clos75" styleClass="fichefournisseur1">
                                <h:outputText value="Date de sortie:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTypeSortie==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <rich:calendar rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTypeSortie==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoDateSortie}" style=" background-color:white;width:45" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <a4j:support eventsQueue="maqueue" event="onchanged" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculValeurCession}" reRender="idetat"/>
                                </rich:calendar>
                                <h:outputText value="Frais annexes:"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoFraisAnnexe}"  style="width:80%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:outputText value="N°Facture vente:"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoFactureCession}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                                <h:outputText value="TVA résiduelle:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoTvaResiduelle}"  style="width:80%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:outputText value="Reinvestissement:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                <h:selectBooleanCheckbox rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.reinvestissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid id="grdlistepmt" styleClass="fichefournisseur" columns="1" style="width:100%;" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}">
                            <f:facet name="header"><h:outputText value="Liste des paiements"/></f:facet>
                            <h:panelGroup id="outgrptttte">
                                <center>
                                    <h:panelGrid id="pangrpVisbtModReg" width="150px" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                        <h:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.ajouterReglement}"/>
                                        <h:commandButton image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.modifierReglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.visibiliteAmortReg}"/>
                                        <h:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.supprimerReglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.visibiliteAmortReg}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                                    </h:panelGrid>
                                    <br>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  border="0" activeClass="active-row" noDataLabel=" " footerClass="bard"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dataModelReglement}" var="amortreg" id="tableamortregmod" rowClasses="rows1,rows2,rowsd"  height="100px" width="340px">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.selectionReglement}"  reRender="pangrpVisbtModReg"/>
                                            <rich:column  width="150px" style="text-align:center" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}">
                                                <f:facet name="header"> <h:outputText  value="Payé le"/></f:facet>
                                                <h:outputText  value="#{amortreg.amoregDateReg}">
                                                    <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column  width="150px" style="text-align:center" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}">
                                                <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                                                <h:outputText  value="#{amortreg.amoregMontant}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                    <h:panelGrid id="grdsoldemod" columns="2" style="width:340px" columnClasses="clos25,clos75">
                                        <h:outputText value="Solde:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}"/>
                                        <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testMode}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoSolde}" style="text-align:right;width:100%;" readonly="true">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGrid>
                                </center>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Tableau d'amortissement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoNature!=3}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.calculeTableauInit}" reRender="tabletab,total"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" enableContextMenu="true" activeClass="active-row" noDataLabel=" " footerClass="bard"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.datamodelTableau}" var="amorttab" id="tabletab" rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.selectionDotation}"/>
                            <rich:column  width="10%" style="text-align:center" sortOrder="ASCENDING" sortBy="#{amorttab.amotabDateDeb}">
                                <f:facet name="header"> <h:outputText  value="Date début"/></f:facet>
                                <h:outputText  value="#{amorttab.amotabDateDeb}">
                                    <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="10%" style="text-align:center" >
                                <f:facet name="header"> <h:outputText  value="Date fin"/></f:facet>
                                <h:outputText  value="#{amorttab.amotabDateFin}">
                                    <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="130px" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Dotation théo."/></f:facet>
                                <h:outputText  value="#{amorttab.amotabMontant}" rendered="#{amorttab.amotabDateTrf!=null}" style="text-align:right;width:120px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                                <h:inputText  value="#{amorttab.amotabMontant}" rendered="#{amorttab.amotabDateTrf==null}" style="text-align:right;width:120px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.recalculDotationligne}" reRender="tabletab,total"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column  width="10%" style="text-align:center" >
                                <f:facet name="header"> <h:outputText  value="Date Trf."/></f:facet>
                                <h:outputText  value="#{amorttab.amotabDateTrf}">
                                    <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="130px" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Dotation trf."/></f:facet>
                                <h:outputText  value="#{amorttab.amotabValeur}" rendered="#{amorttab.amotabValeur!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="10%" style="text-align:center" >
                                <f:facet name="header"> <h:outputText  value="Date Sortie"/></f:facet>
                                <h:outputText  value="#{amorttab.amotabDateSortie}">
                                    <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="130px" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Cession"/></f:facet>
                                <h:outputText  value="#{amorttab.amotabValeurCession}" rendered="#{amorttab.amotabValeurCession!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="130px" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="V.N.C."/></f:facet>
                                <h:outputText  value="#{amorttab.amotabVnc}" rendered="#{amorttab.amotabVnc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid id="total" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:outputText value="Valeur achat:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoValeurAchat}" style="text-align:right;width:100%;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="Total dotation:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.tot_dot_theo}" style="text-align:right;width:100%;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="Dotation trf.:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.tot_dot_trf}" style="text-align:right;width:100%;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="Ecart dotation:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.ecart_dot}" style="text-align:right;width:100%;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Inventaire">
                    <h:panelGrid width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  border="0" activeClass="active-row" noDataLabel=" " footerClass="bard"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dataModelInventaire}" var="amortinv" id="tableinventaire" rowClasses="rows1,rows2,rowsd" style="max-height:100%;" width="100%">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.selectionInventaire}"/>
                                <rich:column  width="150px" style="text-align:center">
                                    <f:facet name="header"> <h:outputText value="Inventaire"/></f:facet>
                                    <h:outputText value="#{amortinv.amoinvDateCreat}">
                                        <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column  width="200px">
                                    <f:facet name="header"><h:outputText  value="Agent"/></f:facet>
                                    <h:outputText value="#{amortinv.libelleAgent}"/>
                                </rich:column>
                                <rich:column  width="100px">
                                    <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                    <h:outputText value="#{amortinv.libelleEtat}"/>
                                </rich:column>
                                <rich:column  width="400px">
                                    <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                    <h:outputText value="#{amortinv.amoinvObs}"/>
                                </rich:column>
                                <rich:column  width="150px">
                                    <f:facet name="header"><h:outputText  value="Photo"/></f:facet>
                                    <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/amortissement/inventaire/#{amortinv.amoinvPhoto}" alt="pho" height="30px" width="30px" style="text-align:center" rendered="#{amortinv.amoinvPhoto!=null}"/>
                                </rich:column>
                                <rich:column  width="100px">
                                    <f:facet name="header"><h:outputText  value="Longitude"/></f:facet>
                                    <h:outputText value="#{amortinv.amoinvLongitude}"/>
                                </rich:column>
                                <rich:column  width="100px">
                                    <f:facet name="header"><h:outputText  value="Latitude"/></f:facet>
                                    <h:outputText value="#{amortinv.amoinvLatitude}"/>
                                </rich:column>
                                <rich:column  width="100px" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="MapBox"/></f:facet>
                                    <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/googlemaps.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.caluleMapBien}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelMapbox,idLieuGps,map1" rendered="#{amortinv.amoinvLongitude!=0&&amortinv.amoinvLatitude!=0}"></a4j:commandButton>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.annulerSaisie}"/>&nbsp;&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.saveAmortissements}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_action<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.bttvalider}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
                <center>
                    <h:outputText  id="outptlibachat" style="color:black;" value="La saisie de la valeur d'achat, du libellé et de la date d'achat sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.bttvalider}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panelreg" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="450" height="280" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.shoModalPanelReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.shoModalPanelReglement}" var="reg">
            <f:facet name="header"><h:outputText value="GESTION REGLEMENT D'AMORTISSEMENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.annuleReg}" image="/images/close.gif" styleClass="hidelink" id="hidelinkclsregf"/>
                    <rich:componentControl for="panelreg" attachTo="hidelinkclsregf" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="form1ajtreg"style="width:100%;">
                    <h:panelGrid columns="2"  style="width:100%;" columnClasses="clos25,clos75">
                        <h:outputText value="Date paiement:" />
                        <rich:calendar locale="fr"  enableManualInput="true" datePattern="dd/MM/yyyy"   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissementReg.amoregDateReg}" style=" background-color:white;"/>
                        <h:outputText value="Montant payé:" />
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissementReg.amoregMontant}" style="text-align:right;" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:panelGrid>
                    <center>
                        <br> <br>
                        <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.saveAmoReg}"/>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelMapbox" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="600" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.shoModalPanelMapbox}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.shoModalPanelMapbox}" var="mpb">
            <f:facet name="header"><h:outputText value="LOCALISATION MAPBOX"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.annuleMapbox}" image="/images/close.gif" styleClass="hidelink" id="hidelinkclmapbox" reRender="panelMapbox"/>
                    <rich:componentControl for="panelMapbox" attachTo="hidelinkclmapbox" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGroup id="idLieuGps">
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
                            center: [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.origine}],
                            zoom: 13
                        });
                        //on affiche des marqueurs à la position de nos points GPS, indiquant leur numéros et recentrant la carte sur eux au clic.
                        var coords = [${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.coordonnees}]; // starting position [lng, lat]
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
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
