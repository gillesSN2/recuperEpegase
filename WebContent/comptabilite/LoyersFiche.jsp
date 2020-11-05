<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>



<f:subview id="saisieloyerFiche">

    <a4j:form id="loyerAjout">

        <center> <h2><h:outputText styleClass="titre" value="GESTION DES LOYERS" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true" style="border:0px;">
            <rich:tab label="Descriptif">
                <h:panelGrid styleClass="fichefournisseur1" id="loyerPG" border="0" width="100%" columns="2">
                    <h:panelGrid  border="0" width="100%" columns="2" columnClasses="clos25,clos75">
                        <h:outputText value="Type de bail:"/>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyType}" >
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.activerLeSCptesChargesOrProd}" reRender="cpteLoyer,cpteTiers"/>
                            <f:selectItem itemLabel="loyer versé" itemValue="0"/>
                            <f:selectItem itemLabel="loyer encaissé" itemValue="1"/>
                        </h:selectOneRadio>
                        <h:outputText value="Type de taxe:"/>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyTypeTaxe}">
                            <f:selectItem itemLabel="Sans taxe" itemValue="0"/>
                            <f:selectItem itemLabel="Avec TVA" itemValue="1"/>
                            <f:selectItem itemLabel="Avec TSIL" itemValue="2"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true"  bypassUpdates="false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.activerLeSCptesTaxe}" reRender="cpteTaxe,pngTTC"/>
                        </h:selectOneRadio>
                        <h:outputText value="Type impôt:"/>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyTypeImpot}"  >
                            <f:selectItem itemLabel="Sans impôt" itemValue="0"/>
                            <f:selectItem itemLabel="Avec Tom" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.activerLeSCptesImpot}" reRender="cpteImpot,pngTTC"/>
                        </h:selectOneRadio>
                        <h:outputText value="Numéro du bail:"/>
                        <h:inputText disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.verrouNum}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyNumBail}" maxlength="20"/>
                        <h:outputText value="Numéro contribuable:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyNumContribuable}" maxlength="20"/>
                    </h:panelGrid>
                    <h:panelGrid  border="0" width="100%" columns="2" columnClasses="clos25,clos75"  >
                        <h:outputText value="Compte loyer: "/>
                        <h:panelGrid id="cpteLoyer" width="100%">
                            <h:selectOneMenu style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.typeLoyer}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.cpteLoyer}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.leSCptesChargesItems}" />
                            </h:selectOneMenu>
                            <h:selectOneMenu  style="width:100%;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.typeLoyer}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.cpteLoyer}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.leSCptesProdItems}" />
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:outputText value="Compte taxe:"/>
                        <h:panelGrid id="cpteTaxe" width="100%">
                            <h:selectOneMenu style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserTaxe}"  >
                            </h:selectOneMenu>
                            <h:selectOneMenu style="width:100%;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserTaxe}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.cpteTaxe}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesCptestaxesItems}" />
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:outputText value="Compte impôt:"/>
                        <h:panelGrid id="cpteImpot" width="100%">
                            <h:selectOneMenu style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserImpot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserImpot}"  >
                            </h:selectOneMenu>
                            <h:selectOneMenu style="width:100%;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserImpot}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.cpteImpot}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesCptesImpotsItems}" />
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:outputText value="Compte tiers:"/>
                        <h:selectOneMenu  id="cpteTiers" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.cpteTiers}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesCptesTiersItems}" />
                        </h:selectOneMenu>
                        <h:outputText value="Type contribuable:"/>
                        <h:selectOneMenu  style="width:147px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyCategorie}" >
                            <f:selectItem itemLabel="Particulier" itemValue="0"/>
                            <f:selectItem itemLabel="SCI locale" itemValue="1"/>
                            <f:selectItem itemLabel="SCI étrangère" itemValue="2"/>
                            <f:selectItem itemLabel="Administration" itemValue="3"/>
                            <f:selectItem itemLabel="Société étrangère" itemValue="4"/>
                        </h:selectOneMenu >
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur"  border="0" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:outputText value="Début du bail:"/>
                    <rich:calendar style="background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyDateDebut}"  locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8"/>
                    <h:outputText value="Fin du bail:"/>
                    <rich:calendar style="background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyDateFin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8"/>
                    <h:outputText value="Description:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyDescription}" style="width:100%" maxlength="100"/>
                    <h:outputText value="Usage:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyUsage}" style="width:100%" maxlength="20"/>
                    <h:outputText value="Adresse:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyAdresse}" style="width:100%" maxlength="100"/>
                    <h:outputText value="Périodicité:"/>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyMode}" style="width:100%">
                        <f:selectItem itemLabel="Mensuel"  itemValue="0"/>
                        <f:selectItem itemLabel="Trimestriel"  itemValue="1"/>
                        <f:selectItem itemLabel="Semestriel"  itemValue="2"/>
                        <f:selectItem itemLabel="Annuel"  itemValue="3"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur1" id="pngTTC"   border="0" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                    <h:outputText value="Loyer net(TTC):"/>
                    <h:inputText style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyMontantNet}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onblur" ajaxSingle="true"  bypassUpdates="false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.calculMontantImpot}" reRender="pngTTC"/>
                    </h:inputText>
                    <h:outputText value="Taux taxe:"/>
                    <h:inputText style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserTaxe}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyTauxTaxe}">
                        <a4j:support eventsQueue="maQueue" event="onblur" ajaxSingle="true" bypassUpdates="false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.calculMontantImpot}" reRender="pngTTC"/>
                    </h:inputText>
                    <h:outputText value="Taux impôt:"/>
                    <h:inputText  style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyTauxImpot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testgriserImpot}">
                        <a4j:support eventsQueue="maQueue" event="onblur" ajaxSingle="true" bypassUpdates="false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.calculMontantImpot}" reRender="pngTTC"/>
                    </h:inputText>
                    <h:outputText value="Montant taxe:" />
                    <h:inputText style="text-align:right;" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyMontantTaxe}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onblur" ajaxSingle="true" bypassUpdates="false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.calculMontantImpot}" reRender="pngTTC"/>
                    </h:inputText>
                    <h:outputText value="Montant impôt:"/>
                    <h:inputText style="text-align:right;" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyMontantImpot}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Loyer brut(HT):"/>
                    <h:inputText style="text-align:right;"  disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyMontantBrut}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.annulerSaisie}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.saveLoyer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.var_action<=2}"/>
                    </center>
                </h:panelGroup>

            </rich:tab>

            <rich:tab ajaxSingle="true" label="Analytique" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.analytique}">
                <h:panelGrid styleClass="fichefournisseur1"  border="0" width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.decoupageActivite}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyActiviteCode}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.var_action==3}">
                            <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.decoupageActivite}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.dataModelDecoupageActivtes}" var="saisieAnal">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.selectionAnalytique}"/>
                                <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.decoupageActivite}">
                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.laColonne1Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.valideColonne1}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.decoupageActivite}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.laColonne2Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.valideColonne2}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.decoupageActivite}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.laColonne3Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.valideColonne3}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="%"  width="15%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.controleEcartAnalytique}" reRender="idTableAnal" />
                                    </h:inputText>
                                </rich:column>
                                <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                    <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.supprimerAnalytique}" reRender="idTableAnal"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur1" border="0" width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:outputText  value="Site:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testsite}" />
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testsite}">
                        <h:selectOneMenu style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.site}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesSitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.chargerDepartement}"  reRender="dept"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Département:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testdept}"/>
                    <h:panelGroup id="dept"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testdept}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.dept}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesdepartements}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.chargerService}"  reRender="serv"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Service:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testservice}"/>
                    <h:panelGroup id="serv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testservice}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.service}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesServices}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Région:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testreg}"/>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testreg}">
                        <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.region}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesRegionsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.chargerSecteur}"  reRender="secteur"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Secteur:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testsecteur}"/>
                    <h:panelGroup id="secteur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testsecteur}">
                        <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.secteur}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesSecteur}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" ajaxSingle="true" bypassUpdates="false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.chargerSecteur}"  reRender="pdv"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="PDV:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testPVD}"/>
                    <h:panelGroup id="pdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testPVD}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.pdv}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.lesPointDeVente}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Dossier:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testDossier==1}"/>
                    <h:panelGroup id="dos" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testDossier==1}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.dossier}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesDossiersItems}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Mission:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testMission}"/>
                    <h:panelGroup id="mis" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testMission}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.mission}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesMissionsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Parc:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testParc}"/>
                    <h:panelGroup id="prc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testParc}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.parc}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesParcsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Agent:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testAgent}"/>
                    <h:panelGroup id="agt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testAgent}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.agent}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesAgentsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Clé répartition:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.analytique}"/>
                    <h:panelGroup id="cle" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.analytique}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.cle1}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesClesItems}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:outputText value="Budget:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.budget}"/>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.budget}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.budget}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesBudgetsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                </h:panelGrid>
            </rich:tab>
            
        </rich:tabPanel>

    </a4j:form>

</f:subview>