<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionventes">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS DES VENTES" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3"  id="panGlob">

            <rich:column width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.recupererNomrep}" reRender="tableNomEtat,richPFiltre,panPrint,panLigne,panDocument"/>
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.recupererNomfich}" reRender="richPFiltre,panPrint,panLigne"/>
                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Sélection modèle" /></f:facet>
                            <h:outputText  value="#{rapport}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column >

            <rich:column id="richPFiltre"  width="100%" >
                <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                    <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panFiltre">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Période:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.periode}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesPeriodesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.calculeDates}" reRender="idD1,idD2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_echeancier'}"><h:outputText value="Du:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_echeancier'}"><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                        <h:column><h:outputText value="Au:" /></h:column>
                        <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;" /></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument}"><h:outputText value="Sociétés:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument}">
                            <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomTiers}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument}"><h:outputText value="Sigle/Appartenance:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomSigle}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeContact==1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Contact:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeContact==1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomDestinataire}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeContact==2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeContact==2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomDestinataire}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeDestinataire"/>
                            </h:inputText>
                        </h:column>

                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire=='entete_commission'}"><h:outputText value="Nb Jours:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire=='entete_commission'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nbJours}"/></h:column>

                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeContact==2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Groupe:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeContact==2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idGroupe" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomGroupe}" >
                                <f:selectItem itemLabel="Sans groupe" itemValue=""/>
                                <f:selectItem itemLabel="Tous groupes" itemValue="*"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesGroupes}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_commission'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection état:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='entete_commission'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idEtat" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.etat}" >
                                <f:selectItem itemLabel="Tous états" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesEtatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Activités:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idActivite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.activite}" >
                                <f:selectItem itemLabel="Toutes les activités" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idCol1" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_colonne1}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.laColonne1Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idCol2" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_colonne2}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.laColonne2Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idCol3" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_colonne3}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.laColonne3Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_dossier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection dossier/affaire:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_dossier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:inputText style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.dossier}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.moduleParc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection parc:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.moduleParc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:inputText id="idParc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.parc}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeParc" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.moduleParc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection marque:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.moduleParc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idMarque" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.marque}" >
                                <f:selectItem itemLabel="Toutes marques" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesMarquesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_region&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection région:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_region&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.region}" >
                                <f:selectItem itemLabel="Toutes régions" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesRegionsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_secteur&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection secteurs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_secteur&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.secteur}" >
                                <f:selectItem itemLabel="Tous secteurs" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesSecteursItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.chargerPdv}" reRender="panFiltre,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_pdv&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection points de vente:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_pdv&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.pdv}" >
                                <f:selectItem itemLabel="Tous points de vente" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesPdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}" var="srv1">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_site&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection site:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_site&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                                <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.site}" >
                                    <f:selectItem itemLabel="Tous sites" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_departement&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection département:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_departement&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.departement}" >
                                    <f:selectItem itemLabel="Tous départements" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.chargerService}" reRender="panFiltre,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_service&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection service:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_service&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.service}" >
                                    <f:selectItem itemLabel="Tous services" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==1}" var="srv2">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_service}"><h:outputText value="Sélection service:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_anal_service}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.service}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection catégorie:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idCategorie" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.categorie}" >
                                <f:selectItem itemLabel="Toutes catégories" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection séries:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idSerie" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.mesSeriesItems}"/>
                                <f:selectItem itemLabel="Toutes séries" itemValue="100" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==1}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection responsable:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idResponsable" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.responsable}" >
                                <f:selectItem itemLabel="Tous responsables" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesResponsablesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.optionVentes.responsable!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection commercial:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.optionVentes.responsable!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idCommercial" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.commercial}" >
                                <f:selectItem itemLabel="Tous commerciaux" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCommerciauxItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection créateur:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idCreateur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.createur}" >
                                <f:selectItem itemLabel="Tous créateurs" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCreateursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}"><h:outputText value="Sélection source:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idSource" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.source}" >
                                <f:selectItem itemLabel="Toutes sources" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panDocument" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheDocument}">
                        <h:column><h:outputText value="Devis:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_devis}"/></h:column>
                        <h:column><h:outputText value="Bon commande:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_bc}"/></h:column>
                        <h:column><h:outputText value="Bon livraison:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_bl}"/></h:column>
                        <h:column><h:outputText value="Bon retour:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_br}"/></h:column>
                        <h:column><h:outputText value="Facture:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_facture}"/></h:column>
                        <h:column><h:outputText value="Note de débit:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_noteDebit}"/></h:column>
                        <h:column><h:outputText value="Avoir:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_avoir}"/></h:column>
                        <h:column><h:outputText value="Bon sortie:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_bs}"/></h:column>
                        <h:column><h:outputText value="Bon entrée:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_be}"/></h:column>
                        <h:column><h:outputText value="Cession sortie:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_cessionOut}"/></h:column>
                        <h:column><h:outputText value="Cession entrée:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.var_cessionIn}"/></h:column>
                    </h:panelGrid>

                    <h:panelGrid id="panLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.testafficheLigne}" columns="2" columnClasses="clos50d,clos50g"  width="100%">
                        <h:column><h:outputText value="Du produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdDeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.produitDebut}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.rechercheProduitsDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Au produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdFin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.produitFin}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.rechercheProduitsFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Sélection familles:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idFamille" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.famille}" >
                                <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamillesVentesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection dépôts:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idDepot" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.depot}" >
                                <f:selectItem itemLabel="Tous dépôts" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesDepotItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.datamodelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.selectionligneTiers}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                        <h:outputText value="#{tiers.tiecategorie}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="55%">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{tiers.tieprenom}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{tiers.tiecivilite}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.annuleTiers}" reRender="idTiers,panelListeTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.calculeTiers}" reRender="idTiers,panelListeTiers"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeDestinataire" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelDestinataire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelDestinataire}" var="dst">
            <f:facet name="header"><h:outputText value="Sélection du destinataire"/></f:facet>
            <a4j:form id="formModalListeDestinataire">
                <rich:extendedDataTable id="tableDest" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.datamodelDestinataire}"  var="dest">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.selectionligneDestinataire}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Nom" sortable="true" sortBy="#{dest.anaNomFr}" width="50%">
                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                        <h:outputText value="#{dest.anaNomFr}"/>
                    </rich:column>
                    <rich:column label="Téléphone" sortable="true" sortBy="#{dest.anaTiersTelephone}" width="20%">
                        <f:facet name="header"><h:outputText  value="Téléphone" /></f:facet>
                        <h:outputText value="#{dest.anaTiersTelephone}"/>
                    </rich:column>
                    <rich:column label="Adresse" sortable="true" sortBy="#{dest.anaTiersAdresse}" width="30%">
                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                        <h:outputText value="#{dest.anaTiersAdresse}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valdest">
                    <center>
                        <a4j:commandButton id="idCanDest" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.annuleDestinataire}" reRender="panelListeDestinataire,idDestinataire"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDest" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.calculeDestinataire}" reRender="panelListeDestinataire,idDestinataire"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanDest')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValDest')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.datamodelProduits}" var="prd">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.selectionProduits}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{prd.proCode}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                        <h:outputText value="#{prd.proLibClient}"/>
                    </rich:column>
                    <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                        <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                        <h:outputText value="#{prd.proVteLib}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton id="idCanProd" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.annuleProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValProd" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.calculeProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanProd')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValProd')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeParc" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelParc}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.showModalPanelParc}" var="prc">
            <f:facet name="header"><h:outputText value="Sélection du parc"/></f:facet>
            <a4j:form id="formModalListeParc">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableParc" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.datamodelParc}"  var="prc">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.selectionParc}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Immatriculation" sortable="true" sortBy="#{prc.prcImmatriculation}" width="20%">
                            <f:facet name="header"><h:outputText  value="Immatriculation" /></f:facet>
                            <h:outputText value="#{prc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" sortBy="#{prc.prcLibNature}" width="20%">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{prc.prcLibNature}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{prc.prcLibFamille}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prc.prcLibFamille}"/>
                        </rich:column>
                        <rich:column label="Sous Famille" sortable="true" sortBy="#{prc.prcLibSousFamille}" width="20%">
                            <f:facet name="header"><h:outputText  value="Sous Famille" /></f:facet>
                            <h:outputText value="#{prc.prcLibSousFamille}"/>
                        </rich:column>
                        <rich:column label="Marque" sortable="true" sortBy="#{prc.prcMarque}" width="20%">
                            <f:facet name="header"><h:outputText  value="Marque" /></f:facet>
                            <h:outputText value="#{prc.prcMarque}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprc">
                    <center>
                        <a4j:commandButton id="idCanParc" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.annuleParc}" reRender="panelListeParc,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValParc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formImpressionVentes.calculeParc}" reRender="panelListeParc,idParc"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanParc')}.click()" />
                        <rich:hotKey key="return" handler="#{rich:element('idValParc')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false">
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>