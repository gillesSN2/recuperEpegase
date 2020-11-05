<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionanalytiques">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS ANALYTIQUES" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3" id="panGlob">

            <rich:column  width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" reRender="tableNomEtat,richPFiltre,panPrint" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.recupererNomrep}" />
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column  width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.recupererNomfich}" reRender="richPFiltre,panPrint"/>
                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Sélection modèle" /></f:facet>
                            <h:outputText  value="#{rapport}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column >

            <rich:column id="richPFiltre" width="100%">
                <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                    <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                    <h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%" id="panFiltre">

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='balance'}">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeDates}" reRender="idD1,idD2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Du Compte:" style="text-decoration:underline"/></h:column>
                            <h:column>
                                <h:inputText id="ducomptebalance"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreCompteDebut}">
                                    <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.rechercheComptesDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,formModalListeComptes,ducomptebalance,aucomptebalance"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Au Compte:" style="text-decoration:underline"/></h:column>
                            <h:column>
                                <h:inputText id="aucomptebalance"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreCompteFin}">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.rechercheComptesFin}" reRender="panelListeComptes" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb car. Sous total:" /></h:column>
                            <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.nbreCaractere}"/></h:column>
                            <h:column><h:outputText value="Type Ecriture:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.typeEcriture}">
                                    <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                                    <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                                    <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                                    <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                                    <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                                    <f:selectItem itemLabel="Ecritures non lettrées et pointées" itemValue="5"/>
                                    <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                                    <f:selectItem itemLabel="Sans les comptes soldés" itemValue="7"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection Journal:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.journal}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.touslesjournauxComptablesItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection agent:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.createur}" >
                                    <f:selectItem itemLabel="Tous les agents" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesUsersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxS}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxR}" /></h:column>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='brouillard'}">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeDates}" reRender="idD3,idD4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Du Compte:" style="text-decoration:underline"/></h:column>
                            <h:column>
                                <h:inputText id="ducomptebrouillard" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreCompteDebut}">
                                    <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.rechercheComptesDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,formModalListeComptes,ducomptebrouillard,aucomptebrouillard" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Au Compte:" style="text-decoration:underline" /></h:column>
                            <h:column>
                                <h:inputText id="aucomptebrouillard" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreCompteFin}">
                                    <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.rechercheComptesFin}" reRender="panelListeComptes" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb car. Sous total:" /></h:column>
                            <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.nbreCaractere}"/></h:column>
                            <h:column><h:outputText value="Sélection agent:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.createur}">
                                    <f:selectItem itemLabel="Tous les agents" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesUsersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxS}" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxR}"/></h:column>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='budget'}">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeDates}" reRender="idD5,idD6"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Sélection budget:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.budgetSelect}">
                                    <f:selectItem itemLabel="Ventes" itemValue="1"/>
                                    <f:selectItem itemLabel="Achats" itemValue="2"/>
                                    <f:selectItem itemLabel="Production" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise!='2'}"/>
                                    <f:selectItem itemLabel="Frais généraux" itemValue="4"/>
                                    <f:selectItem itemLabel="Investissements" itemValue="5"/>
                                    <f:selectItem itemLabel="TVA" itemValue="6"/>
                                    <f:selectItem itemLabel="Impôts et Taxes" itemValue="7"/>
                                    <f:selectItem itemLabel="Personnels" itemValue="8"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Type budget:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.budgetMode}">
                                    <f:selectItem itemLabel="Initial" itemValue="0"/>
                                    <f:selectItem itemLabel="Réaménagement 1" itemValue="1"/>
                                    <f:selectItem itemLabel="Réaménagement 2" itemValue="2"/>
                                    <f:selectItem itemLabel="Réaménagement 3" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxS}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxR}"/></h:column>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='amortissement'}">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeDates}" reRender="idD7,idD8"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Mode de calcul:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculAmortissement}">
                                    <f:selectItem itemLabel="taux comptable" itemValue="0"/>
                                    <f:selectItem itemLabel="taux fiscal" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='loyer'}">
                            <h:column><h:outputText value="Sélection Mois:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mois}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.touslesMoisItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>        

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='bilan'}">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeDates}" reRender="idD9,idD10"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxS}" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxR}" /></h:column>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.testaffiche=='journal'}">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeDates}" reRender="idD11,idD12"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Type Ecriture:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.typeEcriture}">
                                    <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                                    <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                                    <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                                    <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                                    <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                                    <f:selectItem itemLabel="Ecritures non lettrées et pointées" itemValue="5"/>
                                    <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                                    <f:selectItem itemLabel="Sans les comptes soldés" itemValue="7"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection Journal:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.journal}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.touslesjournauxComptablesItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxS}" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.inclureJournauxR}" /></h:column>
                        </c:if>

                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_activite}"><h:outputText value="Activités:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.activite}" >
                                <f:selectItem itemLabel="Toutes les activités" itemValue=""/>
                                <f:selectItem itemLabel="==> Sur fourchette, du.. au .." itemValue="*"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesActivitesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panFiltre,idFourAct1,idFourAct2,idFourAct3,idFourAct4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idFourAct1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.activite=='*'}"><h:outputText value="Du Code activité:"/></h:column>
                        <h:column id="idFourAct2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.activite=='*'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreActiviteDebut}"/></h:column>
                        <h:column id="idFourAct3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.activite=='*'}"><h:outputText value="Au Code activité:"/></h:column>
                        <h:column id="idFourAct4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.activite=='*'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreActiviteFin}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_axe1}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_axe1}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_colonne1}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.laColonne1Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_axe2}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_axe2}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_colonne2}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.laColonne2Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_axe3}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_axe3}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_colonne3}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.laColonne3Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_site}"><h:outputText value="Sites:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_site}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.site}" >
                                <f:selectItem itemLabel="Tous les sites" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesSitesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chargerDepartement}" reRender="idDep,idSer"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_departement}"><h:outputText value="Départements:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_departement}">
                            <h:selectOneMenu id="ideDep" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.departement}" >
                                <f:selectItem itemLabel="Toutes les départements" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesDepartementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chargerService}" reRender="idSer"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_service}"><h:outputText value="Services:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_service}">
                            <h:selectOneMenu id="idSer" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.service}" >
                                <f:selectItem itemLabel="Tous les services" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesServicesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_region}"><h:outputText value="Régions:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_region}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.region}" >
                                <f:selectItem itemLabel="Toutes les régions" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesRegionsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chargerSecteur}" reRender="idSec,idPdv"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_secteur}"><h:outputText value="Secteurs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_secteur}">
                            <h:selectOneMenu id="idSec" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.secteur}" >
                                <f:selectItem itemLabel="Tous les secteurs" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesSecteursItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chargerPdv}" reRender="idPdv"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_pdv}"><h:outputText value="Pdv:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_pdv}">
                            <h:selectOneMenu id="idPdv" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.pdv}" >
                                <f:selectItem itemLabel="Tous les pdv" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mesPdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_dossier>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_dossier<=2}"><h:outputText value="Dossiers:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_dossier>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_dossier<=2}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.dossier}" >
                                <f:selectItem itemLabel="Tous les dossiers" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesDossiersItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_dossier==3}"><h:outputText value="Dossiers:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_dossier==3}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.dossier}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_mission}"><h:outputText value="Missions/Frais:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_mission}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.mission}" >
                                <f:selectItem itemLabel="Toutes les missions/frais" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesMissionsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_chantier}"><h:outputText value="Chantiers:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_chantier}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chantier}" >
                                <f:selectItem itemLabel="Tous les chantiers" itemValue=""/>
                                <f:selectItem itemLabel="==> Sur fourchette, du.. au .." itemValue="*"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesChantiersItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panFiltre,idFourCha1,idFourCha2,idFourCha3,idFourCha4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idFourCha1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chantier=='*'}"><h:outputText value="Du Code chantier:"/></h:column>
                        <h:column id="idFourCha2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chantier=='*'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreChantierDebut}"/></h:column>
                        <h:column id="idFourCha3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chantier=='*'}"><h:outputText value="Au Code chantier:"/></h:column>
                        <h:column id="idFourCha4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.chantier=='*'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.filtreChantierFin}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_parc}"><h:outputText value="Parcs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_parc}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.parc}" >
                                <f:selectItem itemLabel="Tous les parcs" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesParcsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_agent}"><h:outputText value="Salariés:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_agent}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.salarie}" >
                                <f:selectItem itemLabel="Tous les salariés" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesAgentsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_str}"><h:outputText value="Structures:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_anal_str}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.structure}" >
                                <f:selectItem itemLabel="Toutes les Structures" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesStructuresItems}"/>
                            </h:selectOneMenu>
                        </h:column>

                    </h:panelGrid>
                </h:panelGrid>
            </rich:column >
        </h:panelGrid>
        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <!-- modalPanel de selection des comptes -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeComptes" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.showModalPanelComptes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.showModalPanelComptes}" var="imp">
            <f:facet name="header"><h:outputText value="Sélection du compte"/></f:facet>
            <a4j:form id="formModalListeComptes">
                <rich:extendedDataTable id="tableCompte" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.datamodelComptes}" var="cpte">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.selectionligneCompte}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="N° Compte" sortable="true" sortBy="#{cpte.plcCompte}" width="15%">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{cpte.plcCompte}"/>
                    </rich:column>
                    <rich:column label="Libellé compte" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé compte" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleCpteFR}"/>
                    </rich:column>
                    <rich:column label="Racine" sortable="true" sortBy="#{cpte.plcLibelleRacineFR}" width="30%">
                        <f:facet name="header"><h:outputText  value="Racine" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleRacineFR}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valcompte">
                    <center>
                        <h:commandButton id="idCanCompte" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.annuleCompte}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton id="idValCompte" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.calculeCompte}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanCompte')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValCompte')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="350" height="80" resizeable="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionAnalytique.var_ctrl_imp}">
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