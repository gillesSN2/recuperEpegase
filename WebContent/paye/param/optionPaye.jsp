<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configPaye">
    
    <a4j:form id="form1" >

        <center><h2><h:outputText value="OPTIONS DES PAYES" style="color:green;"/></h2></center>

        <a4j:commandButton value="Configuration par Défaut" onclick="if (!confirm('Voulez-vous charger la configuration par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;" reRender="pan1,modAttente"/>
        <br>

        <rich:panel id="rich2" style="border:0px solid green;width:100%;">
            <h:panelGrid  columns="1" id="pan1" style="border:0px solid green;width:100%;">

                <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">               

                    <rich:tab label="Analytiques" >
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" style="width:100%" id="idGeneral">
                            <f:facet name="header"><h:outputText value="Axes Analytiques"/></f:facet>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleStructure}"><h:outputText value="Axe Structure:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleStructure}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeStructure}"/></h:column>
                            <h:column><h:outputText value="Axe Site/Département/Service:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeSite}"/></h:column>
                            <h:column><h:outputText value="Axe Région/Secteur/Pdv:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeRegion}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleUsine}"><h:outputText value="Axe Site/Atelier/Ligne:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleUsine}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeUsine}"/></h:column>
                            <h:column><h:outputText value="Axe Activité:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeActivite}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.modulePaye}"><h:outputText value="Axe Agent:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.modulePaye}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeAgent}"/></h:column>
                            <h:column rendered="false"><h:outputText value="Axe Chantier:"/></h:column>
                            <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeChantier}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleParc}"><h:outputText value="Axe Parc:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleParc}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeParc}"/></h:column>
                            <h:column rendered="false"><h:outputText value="Axe Mission:"/></h:column>
                            <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeMission}"/></h:column>
                            <h:column><h:outputText value="Axe Clés répartition:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeCles}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleProjet}"><h:outputText value="Axe Projet:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleProjet}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeProjet}"/></h:column>
                            <h:column><h:outputText value="Axe Dossier/Affaire:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.axeDossier}" style="width:300px;">
                                    <f:selectItem itemLabel="Sans Dossier" itemValue="0"/>
                                    <f:selectItem itemLabel="Dossier" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Gestion Centralisation Paye:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye}"style="width:300px;">
                                    <f:selectItem itemLabel="Gérée par la comptabilité" itemValue="0"/>
                                    <f:selectItem itemLabel="Centralisation optimisée (compte, date, journal, libellé, référence, activité)" itemValue="1"/>
                                    <f:selectItem itemLabel="Centralisation optimisée (compte, journal, département)" itemValue="2"/>
                                    <f:selectItem itemLabel="Centralisation optimisée (compte, journal, activité et retenues)" itemValue="8"/>
                                    <f:selectItem itemLabel="Centralisation optimisée (compte, journal, activité et retenues et 4478)" itemValue="9"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idGeneral,idExport0,idExport1"/>
                                </h:selectOneMenu>
                            </h:column>
                        <h:column id="idExport0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'}"><h:outputText value="Exportation des OD (modules):"/></h:column>
                        <h:column id="idExport1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'}">
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd}"style="width:300px;" >
                                <f:selectItem itemLabel="Export modèle epegase" itemValue="0"/>
                                <f:selectItem itemLabel="Export modèle autre logiciel" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idGeneral,idExport2,idExport3,idExport4,idExport5,idExport6,idExport7"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idExport2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd=='1'}"><h:outputText value="Longueurs des comptes Exportés:"/></h:column>
                        <h:column id="idExport3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.nbcrExport}" style="width:300px;"/></h:column>
                        <h:column id="idExport4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd=='1'}"><h:outputText value="Longueurs des Tiers Exportés:"/></h:column>
                        <h:column id="idExport5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.nbcrTiersExport}" style="width:300px;"/></h:column>
                        <h:column id="idExport6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd=='1'}"><h:outputText value="Préfixe Tiers:"/></h:column>
                        <h:column id="idExport7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trfCptePaye!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.exportOd=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.prefixeTiersExport}" style="width:300px;"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Paye" >
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:outputText value = "Nombre ligne maximum des documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.nbLigneMax}" style="width:300px;">
                                <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Chargement des listes:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.chargementListe}" style="width:300px;">
                                <f:selectItem itemLabel="Manuel" itemValue="0" />
                                <f:selectItem itemLabel="Automatique" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Chrono matricule:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" id="idchrono" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.chronoMatricule}">
                                    <f:selectItem itemLabel="Automatique par feuille" itemValue="0" />
                                    <f:selectItem itemLabel="Automatique pour tous les agents" itemValue="2"/>
                                    <f:selectItem itemLabel="Automatique par nature (Embauchés et autres)" itemValue="3"/>
                                    <f:selectItem itemLabel="Manuel" itemValue="1" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Calcul de régularisation:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.calculRegularisation}" style="width:300px;">
                                <f:selectItem itemLabel="Calcul à partir des éléments des bruts" itemValue="0" />
                                <f:selectItem itemLabel="Calcul à partir des bases mensuelles calculées" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode de plafond (si congés):"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.plafond}" style="width:300px;">
                                <f:selectItem itemLabel="Plafond simple" itemValue="0" />
                                <f:selectItem itemLabel="Double le plafond" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Arrondir Net sur les modes de paiement:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.arrondiNet}" style="width:300px;">
                                <f:selectItem itemLabel="Espèces" itemValue="0" />
                                <f:selectItem itemLabel="Espéces + Chéques" itemValue="1"/>
                                <f:selectItem itemLabel="Espéces + Chéques + Transfert" itemValue="2"/>
                                <f:selectItem itemLabel="Espéces + Chéques + Transferts + Virements" itemValue="3"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Tri des agents dans les listes:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.triAgents}" style="width:300px;">
                                <f:selectItem itemLabel="Par Matricule" itemValue="0" />
                                <f:selectItem itemLabel="Par Nom et Prénom" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Rub. Versement Auto.:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.rubVersement}">
                                    <f:selectItem itemLabel="Sélectionnez un rubrique" itemValue="" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.lesVersementsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Rub. Versement Manuel:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.rubSpontanee}">
                                    <f:selectItem itemLabel="Sélectionnez un rubrique" itemValue="" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.lesVersementsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Rub. Retrait:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.rubRetrait}">
                                    <f:selectItem itemLabel="Sélectionnez un rubrique" itemValue="" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.lesRetraitsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Gestion des échéances des prêts:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.echeanceprets}" style="width:300px;">
                                <f:selectItem itemLabel="Uniquement l'échéance en cours" itemValue="0" />
                                <f:selectItem itemLabel="Toutes les échéances non payées" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Gestion base des congés:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.baseconges}" style="width:300px;">
                                <f:selectItem itemLabel="Calcul sur base brute" itemValue="0" />
                                <f:selectItem itemLabel="Calcul sur base brute + dernier CP" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode travail:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.modeTravail}" style="width:300px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.lesModeTravailItems}"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Tri liste Mode travail:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.triModeTravail}" style="width:300px;">
                                <f:selectItem itemLabel="Tri par code" itemValue="0"/>
                                <f:selectItem itemLabel="Tri par libellé" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Nb enfants fiscaux:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.nbEnfantsFiscaux}" style="width:300px;">
                                <f:selectItem itemLabel="Synchroniser avec liste des enfants à charge" itemValue="0" />
                                <f:selectItem itemLabel="Saisie manuelle" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Gestion quinzaine:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.rubQuinzaine}">
                                    <f:selectItem itemLabel="Sélectionnez un rubrique" itemValue="" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.lesVersementsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleInterim}"><h:outputText value="Désignation société intérim:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.moduleInterim}">
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.societeInterim}">
                                    <f:selectItem itemLabel="Sélectionnez une société" itemValue="" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.lesSocietesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <!-- BENIN -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0029'}">
                    </rich:tab>

                    <!-- CAMEROUN -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0041'}">
                    </rich:tab>

                    <!-- CONGO -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0050'}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "CNSS : Plafond mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS : Taux part salarié:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnssPS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnssPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Prestations familiales et Accident travail : Plafond mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeCadre}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Prestations familiales : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxPf}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Accident de travail : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxAt}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "TUS : Taux part patronale"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxtusPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "TOL : Taxe centre ville"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.taxeTolCv}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "TOL : Taxe périphérie"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.taxeTolPeriph}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Taux Eloignement Expatrié:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.eloignementExpat}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Forfait Eloignement Local:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.eloignementLocal}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "SMIG:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.smig}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <!-- COTE IVOIRE -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0056'}">
                    </rich:tab>

                    <!-- GABON -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "CNSS : Plafond mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS : Taux part salarié:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnssPS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnssPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "FNH : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxfnhPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CFP : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcfpPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNAMGS : Plafond mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.cnamgs}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNAMGS : Taux part salarié:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnamgsPS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNAMGS : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnamgsPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "SMIG:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.smig}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <!-- GAMBI -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0078'}">
                    </rich:tab>

                    <!-- GUINEE EQUATORIALE -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0088'}">
                    </rich:tab>
                    
                    <!-- GUINEE CONAKRY -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0089'}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "CNSS : Plafond mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS Assurance maladie: Taux part salarié:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnssPS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS Assurance maladie: Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnssPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS Retraite-Deces-Invalidité : Taux part salariale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnamgsPS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CNSS Retraite-Déces-Invalidité : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcnamgsPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Accident de travail : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxAt}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Prestations familiales : Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxPf}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Versements forfaitaires (VF): Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxVf}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Taxe d`apprentissage (TA): Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxTa}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Contribution à la Formation Professionnelle et à l`Apprentissage (CFPA): Taux part patronale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxCfpa}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <!-- GUINEE BISSAU -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0090'}">
                    </rich:tab>

                    <!-- MALI -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "Plafond Sécurité sociale (régime général):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Plafond Sécurité sociale (régime cadre):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeCadre}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Plafond Cotisation sociale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.cotisationSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Plafond Prestation médicale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.prestationMedicaleGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "SMIG:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.smig}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Nb enfants pris en charge pour l'allocation familliale:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.nbEnfantAllocation}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <!-- MAURITANIE -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0142'}">
                    </rich:tab>

                    <!-- SENEGAL -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "Plafond IPRESS (régime général):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "IPRESS : Taux part salariale (regime général):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxipressGenePS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "IPRESS : Taux part patronale (regime général):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxipressGenePP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Plafond IPRESS (régime cadre):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.securiteSocialeCadre}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "IPRESS : Taux part salariale (regime cadre):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxipressCadrePS}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "IPRESS : Taux part patronale (regime cadre):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxipressCadrePP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Plafond Cotisation sociale (CSS):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.cotisationSocialeGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Plafond Prestation médicale (IPM):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.prestationMedicaleGene}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CSS : Taux prestation de famille:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcsspfPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CSS : Taux accident de travail:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcssatPP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "CFCE : Taux:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.tauxcfcePP}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "SMIG:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.smig}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Calcul TRIMF:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.trimf}" style="width:300px;">
                                    <f:selectItem itemLabel="sur barême annuel" itemValue="0" />
                                    <f:selectItem itemLabel="sur barême mensuel" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <!-- GUINEE TOGO -->
                    <rich:tab label="Valeurs base" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0222'}">
                    </rich:tab>

                    <rich:tab label="Valeurs journaliers" >
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "Nombre d'heures journée complète:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.heurejournee}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value = "Nombre d'heures demi-journée:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.heuredemijournee}" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="pointage" label="Pointage et temps">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value = "Pointage salarié:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.pointage}" style="width:300px;">
                                    <f:selectItem itemLabel="Pointage journalier en durée" itemValue="0" />
                                    <f:selectItem itemLabel="Pointage journalier avec heure début et heure fin" itemValue="1" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value = "Gestion des temps:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.temps}" style="width:300px;">
                                    <f:selectItem itemLabel="Mode salarié (pointage horaire)" itemValue="0" />
                                    <f:selectItem itemLabel="Mode cabinet (feuille des temps)" itemValue="1" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="fpt" label="Liaison externe" rendered="false">
                        <h:panelGrid  columns="2" columnClasses="clos30,clos70d" width="100%" id="idpanExt">
                            <h:column><h:outputText value="Fichier d'export des virements:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.optionPaye.dossierExport}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>
            <center>
                <br>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton styleClass="exp_lienmenu"  value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsPaye.creerOptionPaye}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </rich:panel>

    </a4j:form>

</f:subview>