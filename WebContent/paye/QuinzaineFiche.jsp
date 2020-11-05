<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichequinzaine">

    <a4j:form>

        <center>
            <h2>
                <h:outputText id="idTitre" value="PREPARATION DE LA QINZAINE POUR LA PERIODE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenPeriode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.libelleRepartition} N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.feuilleCalcul.feuCode}" style="color:green;"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerPeriode}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
            </h2>
        </center>

        <h:panelGrid width="100%">

            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%" columns="7">
                <h:panelGrid columns="2">
                    <h:outputText value="Recherche salarié:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_agent_rec}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=0}">
                    <h:outputText value="Recherche feuille:"/>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_feuille_rec}">
                        <f:selectItem itemLabel="Toutes les Feuilles" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesFeuillesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=1}">
                    <h:outputText value="Recherche activité:"/>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_activite_rec}">
                        <f:selectItem itemLabel="Toutes les Activités" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesActivitesItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Activité" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=2}">
                    <h:outputText value="Recherche service:"/>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_service_rec}">
                        <f:selectItem itemLabel="Tous les Services" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesServiceItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Service" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid columns="2">
                    <h:outputText value="Recherche localisation:"/>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_localisation_rec}">
                        <f:selectItem itemLabel="Toutes les Localisations" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesLocalisationItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Localisation" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionMode==3}">
                    <h:outputText value="Recherche projet:"/>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_projet_rec}">
                        <f:selectItem itemLabel="Tous les Pojets" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesProjetItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Projet" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionMode==4}">
                    <h:outputText value="Recherche client:"/>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_idclient_rec}">
                        <f:selectItem itemLabel="Tous les clients" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClientsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
            </h:panelGrid>

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabRubrique" label="Sur Rubrique" >
                    <h:panelGrid  id="boutonRubriques" columns="3" width="250px" style="height:34px">
                        <a4j:commandButton title="Effacer les variables de la liste" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razRubriques}" onclick="if (!confirm('Etes-vous sur de vouloir effacer les valeurs de la liste?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRubriques"/>
                        <a4j:commandButton title="Enregistrer les variables de la liste" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveRubriques}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.initImpressionAcompte}" reRender="panelImpRub,formModalImpRub,panelMailRub"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableRubriques" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.datamodelRubriques}" var="rub">
                            <rich:column label="Contrat" sortable="false" width="80px" sortBy="#{rub.salvarContrat}">
                                <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                                <h:outputText value="#{rub.salvarContrat}"/>
                            </rich:column>
                            <rich:column label="Feuille de calcul" sortable="false" width="50px" sortBy="#{rub.salaries.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{rub.salaries.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="50px" sortBy="#{rub.salaries.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{rub.salaries.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="80px" sortBy="#{rub.salaries.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{rub.salaries.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="120px" sortBy="#{rub.salaries.salNom}  #{rub.salaries.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{rub.salaries.salNom}  #{rub.salaries.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="80px" sortBy="#{rub.salaries.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{rub.salaries.lib_genre}"/>
                            </rich:column>
                            <rich:column label="Situation de famille" sortable="false" width="80px" sortBy="#{rub.salaries.lib_sitfamille}">
                                <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                                <h:outputText value="#{rub.salaries.lib_sitfamille}"/>
                            </rich:column>
                            <rich:column label="Rubrique" sortable="false" width="80px" sortBy="#{rub.salvarCode}">
                                <f:facet name="header"><h:outputText  value="Rubrique" /></f:facet>
                                <h:outputText value="#{rub.salvarCode}"/>
                            </rich:column>
                            <rich:column id="idColA" width="100px" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColA}" rendered="#{rub.salvarVariableA}">
                                <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColA}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColA"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColB" width="100px" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColB}" rendered="#{rub.salvarVariableB}">
                                <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColB}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColB"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColC" width="100px" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColC}" rendered="#{rub.salvarVariableC}">
                                <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColC}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColC"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColD" width="100px" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColD}" rendered="#{rub.salvarVariableD}">
                                <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColD}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColD"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColE" width="100px" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColE}" rendered="#{rub.salvarVariableE}">
                                <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColE}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColE"/>
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabVrt" label="Mode Paiement">
                    <h:panelGrid  id="boutonCompteVrt" columns="2" width="200px" style="height:34px">
                        <a4j:commandButton value="Recopier modes mensuels dans modes Quinzaines" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.recopieCompteVrtQuinzaine}" onclick="if (!confirm('Etes-vous sur de vouloir recopier les modes de paiements mensuels dans les modes de paiements des quinzaines?')) return false;javascript:Richfaces.showModalPanel('modAttente');"  oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableCompteVrt"/>
                        <a4j:commandButton title="Enregistrer les comptes Vrt" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveCompteVrtQuinzaine}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableCompteVrt" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelComptesVrt}" var="cvt">
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{cvt.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{cvt.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{cvt.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{cvt.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{cvt.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{cvt.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="15%" sortBy="#{cvt.salNom}  #{cvt.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{cvt.salNom}  #{cvt.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="5%" sortBy="#{cvt.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{cvt.lib_genre}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" title="Mode paiement" sortBy="#{cvt.salModeReglement15}">
                                <f:facet name="header"><h:outputText value="Mode"/></f:facet>
                                <h:selectOneMenu value="#{cvt.salModeReglement15}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}">
                                    <f:selectItem itemLabel="Espèce" itemValue="0"/>
                                    <f:selectItem itemLabel="Cheque" itemValue="1"/>
                                    <f:selectItem itemLabel="Virement" itemValue="2"/>
                                    <f:selectItem itemLabel="Carte pré-payée" itemValue="3"/>
                                    <f:selectItem itemLabel="Micro-finance" itemValue="4"/>
                                    <f:selectItem itemLabel="Mobile" itemValue="5" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.accesOrange}"/>
                                    <f:selectItem itemLabel="Autre" itemValue="9"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="tableCompteVrt,id1,id2,id3,id4,id5,id6"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column id="id1" width="6%" sortable="false" title="Code Banque" sortBy="#{cvt.saleNumBanque15}">
                                <f:facet name="header"><h:outputText value="Banque"/></f:facet>
                                <h:inputText value="#{cvt.salNumBanque15}" maxlength="5" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==2||cvt.salModeReglement==3||cvt.salModeReglement==4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                            <rich:column id="id2" width="6%" sortable="false" title="Code Guichet" sortBy="#{cvt.salGuichetBanque15}">
                                <f:facet name="header"><h:outputText value="Guichet"/></f:facet>
                                <h:inputText value="#{cvt.salGuichetBanque15}" maxlength="5" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==2||cvt.salModeReglement==4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                            <rich:column id="id3" width="12%" sortable="false" title="Compte" sortBy="#{cvt.salCompteBanque15}">
                                <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                                <h:inputText value="#{cvt.salCompteBanque15}" maxlength="12" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==2||cvt.salModeReglement==4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                            <rich:column id="id4" width="5%" sortable="false" title="Clé" sortBy="#{cvt.salCleBanque15}">
                                <f:facet name="header"><h:outputText value="Clé"/></f:facet>
                                <h:inputText value="#{cvt.salCleBanque15}" maxlength="2" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==2||cvt.salModeReglement==4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                            <rich:column id="id5" width="12%" sortable="false" title="N° Carte" sortBy="#{cvt.salCompteBanque15}">
                                <f:facet name="header"><h:outputText value="N° Carte"/></f:facet>
                                <h:inputText value="#{cvt.salCompteBanque15}" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                            <rich:column id="id6" width="12%" sortable="false" title="N° Membre" sortBy="#{cvt.salCompteMembre15}">
                                <f:facet name="header"><h:outputText value="N° Membre"/></f:facet>
                                <h:inputText value="#{cvt.salCompteMembre15}" maxlength="12" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                            <rich:column id="id7" width="10%" sortable="false" title="N° téléphone" sortBy="#{cvt.salCompteBanque15}">
                                <f:facet name="header"><h:outputText value="Téléphone"/></f:facet>
                                <h:inputText value="#{cvt.salCompteBanque15}" maxlength="12" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.salModeReglement==5}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpRub" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintRub}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintRub}" var="prtrub">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.closeImpressionRub}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpRub"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpRub" target="_blank">
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nomModeleListe}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.listeImpressionItems}"/>
                        </h:selectOneMenu>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modePaiementFiltre}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.listeModePaiementItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                    <h:selectOneMenu id="impSelectPrepa" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMailPrepa" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.affMail}" id="printPrepa" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
