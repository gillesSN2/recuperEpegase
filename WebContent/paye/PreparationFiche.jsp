<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichepreparation">

    <a4j:form>

        <center>
            <h2>
                <h:outputText id="idTitre" value="PREPARATION DE LA PAYE POUR LA PERIODE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenPeriode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.libelleRepartition} N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.feuilleCalcul.feuCode}" style="color:green;"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerPeriode}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
            </h2>
        </center>

        <h:panelGrid width="100%">

            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%" columns="7">
                <h:panelGrid columns="2">
                    <h:outputText value="Salarié:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_agent_rec}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=0}">
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_feuille_rec}">
                        <f:selectItem itemLabel="Toutes les Feuilles" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesFeuillesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionMode==4}">
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_idclient_rec}">
                        <f:selectItem itemLabel="Tous les clients" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClientsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation,idService"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.afficheService}">
                    <h:selectOneMenu id="idService" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_service_rec}">
                        <f:selectItem itemLabel="Tous les Services" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesServiceItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Service" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.afficheDepartement}">
                    <h:selectOneMenu id="idDepartement" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_departement_rec}">
                        <f:selectItem itemLabel="Tous les Départements" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesDepartementItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Département" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.afficheActivite}">
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_activite_rec}">
                        <f:selectItem itemLabel="Toutes les Activités" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesActivitesItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Activité" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid>
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_localisation_rec}">
                        <f:selectItem itemLabel="Toutes les Localisations" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesLocalisationItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Localisation" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeRepartition!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionMode==3}">
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_projet_rec}">
                        <f:selectItem itemLabel="Tous les Pojets" itemValue=""/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesProjetItems}"/>
                        <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                        <f:selectItem itemLabel="Sans Projet" itemValue="*****"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalariePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                    </h:selectOneMenu>
                </h:panelGrid>
            </h:panelGrid>

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabSalarie" label="Sur Salarié" >
                    <h:panelGrid  id="boutonSalaries" columns="10" width="400px" style="height:34px">
                        <a4j:commandButton title="Saisie des variables" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saisieVariables}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelVariable,tableSalaries"/>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.initImpressionPrep}" reRender="panelImpPrepa,formModalImpPrepa,panelMailPrepa"/>
                        <a4j:commandButton title="Historique par rubriques du salarié sélectionné" image="/images/tableau.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.historiqueSalarie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelListeRubrique"/>
                        <a4j:commandButton title="Historique des bulletins du salarié sélectionné" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.historiqueSalarieBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelListeBulletin"/>
                        <a4j:commandButton title="Génération des variables pour tous les salariés" image="/images/executer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.generationVariables}" onclick="if (!confirm('Etes-vous sur de vouloir générer les varaibles et les éléments des salariés de toute la liste ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="panelBarProg,tableSalaries"/>
                        <a4j:commandButton title="Recopier les variables vers un autre mois" image="/images/parametre.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.recopierVariables}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelRecopierVariables"/>
                        <a4j:commandButton title="Geler le contrat sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salEtat<=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.gelerImputationContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSalaries,boutonSalaries"/>
                        <a4j:commandButton title="Réactiver le contrat sélectionné" image="/images/degeler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salEtat==9}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.degelerImputationContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSalaries,boutonSalaries"/>
                        <a4j:commandButton title="Informations sur la préparation" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.informationPiecePRE}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton}" reRender="panelInformation"/>
                        <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.pageIndex}" reRender="tableSalaries" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelContrats}" var="salfic" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.extDTable}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionSalaries}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.visualisationLigne}" reRender="idSubView,boutonSalaries"/>
                            <rich:column id="idSaisie" label="Saisie" sortable="false" width="5%" sortBy="#{salfic.effectue}">
                                <f:facet name="header"><h:outputText  value="Saisie"/></f:facet>
                                <h:selectBooleanCheckbox id="idEffectue" value="#{salfic.effectue}" disabled="true" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{salfic.salaries.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText id="idSaisie1" value="#{salfic.salaries.salMatricule}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Nature agent" sortable="false" width="10%" sortBy="#{salfic.salaries.lib_nature}">
                                <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                <h:outputText id="idSaisie2" value="#{salfic.salaries.lib_nature}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{salfic.salconFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText id="idSaisie3" value="#{salfic.salconFeuille}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{salfic.salaries.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText id="idSaisie4" value="#{salfic.salaries.lib_etat}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="20%" sortBy="#{salfic.salaries.salNom}  #{salfic.salaries.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText id="idSaisie5" value="#{salfic.salaries.salNom}  #{salfic.salaries.salPrenom}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="true" width="5%" sortBy="#{salfic.salaries.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText id="idSaisie6" value="#{salfic.salaries.lib_genre}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Situation de famille" sortable="false" width="5%" sortBy="#{salfic.salaries.lib_sitfamille}">
                                <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                                <h:outputText id="idSaisie7" value="#{salfic.salaries.lib_sitfamille}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Contrat" sortable="false" width="7%" sortBy="#{salfic.salconNum}">
                                <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                                <h:outputText value="#{salfic.salconNum}"/>
                            </rich:column>
                            <rich:column label="Service" sortable="false" width="7%" sortBy="#{salfic.salconService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionMode!=2}">
                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                <h:outputText id="idSaisie9" value="#{salfic.salconService}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Projet" sortable="false" width="7%" sortBy="#{salfic.salconProjet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionMode==2}">
                                <f:facet name="header"><h:outputText  value="Projet" /></f:facet>
                                <h:outputText id="idSaisie8" value="#{salfic.salconProjet}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Activité" sortable="false" width="7%" sortBy="#{salfic.salconActivite}">
                                <f:facet name="header"><h:outputText  value="Activite" /></f:facet>
                                <h:outputText id="idSaisie10" value="#{salfic.salconActivite}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                            <rich:column label="Focntion actuelle" sortable="false" width="10%" sortBy="#{salfic.salconFonction}">
                                <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                                <h:outputText id="idSaisie11" value="#{salfic.salconFonction}" style="#{salfic.styleEffectue}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabRubrique" label="Sur Rubrique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razSaisieRubrique}" reRender="boutonRubriques,tableRubriques"/>
                    <h:panelGrid  id="boutonRubriques" columns="5" width="400px" style="height:34px">
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.variableSaisie}">
                            <f:selectItem itemLabel="Sélectionnez Variable" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.lesVariablesItems}"/>
                            <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheVariables}" reRender="tableRubriques,scrollTable2" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/>
                        </h:selectOneMenu>
                        <a4j:commandButton title="Recharger les variables de la liste" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheVariables}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRubriques,scrollTable2"/>
                        <a4j:commandButton title="Effacer les variables de la liste" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razRubriques}" onclick="if (!confirm('Etes-vous sur de vouloir effacer les valeurs de la liste?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRubriques"/>
                        <a4j:commandButton title="Enregistrer les variables de la liste" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveRubriques}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.initImpressionRub}" reRender="panelImpRub,formModalImpRub,panelMailRub"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableRubriques" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.datamodelRubriques}" var="rub">
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{rub.salaries.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{rub.salaries.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{rub.salaries.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{rub.salaries.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{rub.salaries.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{rub.salaries.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="15%" sortBy="#{rub.salaries.salNom}  #{rub.salaries.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{rub.salaries.salNom}  #{rub.salaries.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="5%" sortBy="#{rub.salaries.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{rub.salaries.lib_genre}"/>
                            </rich:column>
                            <rich:column label="Situation de famille" sortable="false" width="5%" sortBy="#{rub.salaries.lib_sitfamille}">
                                <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                                <h:outputText value="#{rub.salaries.lib_sitfamille}"/>
                            </rich:column>
                            <rich:column id="idColA" width="10%" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColA}">
                                <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColA}" rendered="#{rub.salvarVariableA}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColA"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColB" width="10%" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColB}">
                                <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColB}" rendered="#{rub.salvarVariableB}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColB"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColC" width="10%" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColC}">
                                <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColC}" rendered="#{rub.salvarVariableC}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColC"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColD" width="10%" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColD}">
                                <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColD}" rendered="#{rub.salvarVariableD}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColD"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idColE" width="10%" sortable="false" style="text-align:right;" sortBy="#{rub.salvarValeurColE}">
                                <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                                <h:inputText value="#{rub.salvarValeurColE}" rendered="#{rub.salvarVariableE}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColE"/>
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabHistorique" label="Sur Historique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.premierMois&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razSaisieHistorique}" reRender="boutonHistorique,tableHistorique"/>
                    <h:panelGrid  id="boutonHistorique" columns="2" width="200px" style="height:34px">
                        <a4j:commandButton title="Recharger les historiques" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheHistoriques}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableHistorique,scrollTable3"/>
                        <a4j:commandButton title="Enregistrer les historiques" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveHistoriques}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableHistorique" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelSasiesHistoriques}" var="his">
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{his.salaries.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{his.salaries.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{his.salaries.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{his.salaries.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{his.salaries.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{his.salaries.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="15%" sortBy="#{his.salaries.salNom}  #{his.salaries.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{his.salaries.salNom}  #{his.salaries.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="5%" sortBy="#{his.salaries.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{his.salaries.lib_genre}"/>
                            </rich:column>
                            <rich:column label="Situation de famille" sortable="false" width="5%" sortBy="#{his.salaries.lib_sitfamille}">
                                <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                                <h:outputText value="#{his.salaries.lib_sitfamille}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:right;" title="Dernier appoint mensuel">
                                <f:facet name="header"><h:outputText value="ADM"/></f:facet>
                                <h:inputText value="#{his.histoAdm}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:right;" title="Cumul brut acquis au dernier jour de l'exercice précédent">
                                <f:facet name="header"><h:outputText value="Brut"/></f:facet>
                                <h:inputText value="#{his.histoBrut}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:right;" title="Nb de jours acquis au dernier jour de l'exercice précédent">
                                <f:facet name="header"><h:outputText value="Nb jours"/></f:facet>
                                <h:inputText value="#{his.histoNbjs}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:right;" title="Dernier congés payés">
                                <f:facet name="header"><h:outputText value="Congés"/></f:facet>
                                <h:inputText value="#{his.histoCp}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabVrt" label="Mode Paiement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razSaisieCompteVrt}" reRender="boutonCompteVrt,tableCompteVrt"/>
                    <h:panelGrid  id="boutonCompteVrt" columns="3" width="200px" style="height:34px">
                        <a4j:commandButton title="Recharger les comptes Vrt" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheCompteVrt}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableCompteVrt,scrollTable4"/>
                        <a4j:commandButton value="Recopier infos salariés dans préparation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.recopieCompteVrtPreparation}" onclick="if (!confirm('Etes-vous sur de vouloir recopier les modes de paiements des salariés dans les modes de paiements des préparations?')) return false;javascript:Richfaces.showModalPanel('modAttente');"  oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableCompteVrt"/>
                        <a4j:commandButton title="Enregistrer les comptes Vrt" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveCompteVrt}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableCompteVrt" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelComptesVrt}" var="cvt">
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{cvt.salaries.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{cvt.salaries.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{cvt.salaries.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{cvt.salaries.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{cvt.salaries.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{cvt.salaries.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="15%" sortBy="#{cvt.salaries.salNom}  #{cvt.salaries.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{cvt.salaries.salNom}  #{cvt.salaries.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="5%" sortBy="#{cvt.salaries.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{cvt.salaries.lib_genre}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" title="Mode paiement" sortBy="#{cvt.saleleModeReglement}">
                                <f:facet name="header"><h:outputText value="Mode"/></f:facet>
                                <h:selectOneMenu value="#{cvt.saleleModeReglement}" style="width:95%">
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
                            <rich:column id="id1" width="6%" sortable="false" title="Code Banque" sortBy="#{cvt.saleleNumBanque}">
                                <f:facet name="header"><h:outputText value="Banque"/></f:facet>
                                <h:inputText value="#{cvt.saleleNumBanque}" maxlength="5" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==2||cvt.saleleModeReglement==3||cvt.saleleModeReglement==4}"/>
                            </rich:column>
                            <rich:column id="id2" width="6%" sortable="false" title="Code Guichet" sortBy="#{cvt.saleleGuichetBanque}">
                                <f:facet name="header"><h:outputText value="Guichet"/></f:facet>
                                <h:inputText value="#{cvt.saleleGuichetBanque}" maxlength="5" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==2||cvt.saleleModeReglement==4}"/>
                            </rich:column>
                            <rich:column id="id3" width="12%" sortable="false" title="Compte" sortBy="#{cvt.saleleCompteBanque}">
                                <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                                <h:inputText value="#{cvt.saleleCompteBanque}" maxlength="12" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==2||cvt.saleleModeReglement==4}"/>
                            </rich:column>
                            <rich:column id="id4" width="5%" sortable="false" title="Clé" sortBy="#{cvt.saleleCleBanque}">
                                <f:facet name="header"><h:outputText value="Clé"/></f:facet>
                                <h:inputText value="#{cvt.saleleCleBanque}" maxlength="2" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==2||cvt.saleleModeReglement==4}"/>
                            </rich:column>
                            <rich:column id="id5" width="12%" sortable="false" title="N° Carte" sortBy="#{cvt.saleleCompteBanque}">
                                <f:facet name="header"><h:outputText value="N° Carte"/></f:facet>
                                <h:inputText value="#{cvt.saleleCompteBanque}" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==3}"/>
                            </rich:column>
                            <rich:column id="id6" width="12%" sortable="false" title="N° Membre" sortBy="#{cvt.saleleCompteMembre}">
                                <f:facet name="header"><h:outputText value="N° Membre"/></f:facet>
                                <h:inputText value="#{cvt.saleleCompteMembre}" maxlength="30" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==4}"/>
                            </rich:column>
                            <rich:column id="id7" width="10%" sortable="false" title="N° téléphone" sortBy="#{cvt.saleleCompteBanque}">
                                <f:facet name="header"><h:outputText value="Téléphone"/></f:facet>
                                <h:inputText value="#{cvt.saleleCompteBanque}" maxlength="12" onkeypress="return scanToucheLettre(event)" style="width:90%;text-transform:uppercase" rendered="#{cvt.saleleModeReglement==5}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabImmatriculation" label="Immatriculation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razSaisieImmatriculation}" reRender="boutonImmatriculation,tableImmatriculation"/>
                    <h:panelGrid  id="boutonImmatriculation" columns="2" width="200px" style="height:34px">
                        <a4j:commandButton title="Recharger les immatriculations" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheImmatriculation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableImmatriculation,scrollTable5"/>
                        <a4j:commandButton title="Enregistrer les immatriculations" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveImmatriculation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableImmatriculation" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelImmatriculation}" var="imm">
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{imm.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{imm.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{imm.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{imm.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{imm.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{imm.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="15%" sortBy="#{imm.salNom}  #{imm.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{imm.salNom}  #{imm.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="5%" sortBy="#{imm.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{imm.lib_genre}"/>
                            </rich:column>
                            <rich:column label="Carte d'identité" sortable="false" width="15%" sortBy="#{imm.salNumCi}">
                                <f:facet name="header"><h:outputText  value="C.I." /></f:facet>
                                <h:inputText value="#{imm.salNumCi}"/>
                            </rich:column>
                            <rich:column label="Sécurité sociale" sortable="false" width="10%" sortBy="#{imm.salNumSecu}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.libelle_securite}:" /></f:facet>
                                <h:inputText value="#{imm.salNumSecu}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{imm.salNumCnamgs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                <f:facet name="header"><h:outputText  value="CNAMGS" /></f:facet>
                                <h:inputText value="#{imm.salNumCnamgs}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{imm.salNumRetraite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.libelle_retraite}:" /></f:facet>
                                <h:inputText value="#{imm.salNumRetraite}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{imm.salNumAmo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}">
                                <f:facet name="header"><h:outputText  value="AMO" /></f:facet>
                                <h:inputText value="#{imm.salNumAmo}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{imm.salNumAllocataire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}">
                                <f:facet name="header"><h:outputText  value="Allocataire" /></f:facet>
                                <h:inputText value="#{imm.salNumAllocataire}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabEnfant" label="Elements familiaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razSaisieNb}" reRender="boutonNb,tableNb"/>
                    <h:panelGrid  id="boutonNb" columns="2" width="200px" style="height:34px">
                        <a4j:commandButton title="Recharger les agents concernés" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheNb}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableNb,scrollTable6"/>
                        <a4j:commandButton title="Enregistrer les nombres" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveNb}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableNb" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelNb}" var="nb">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionAgentNb}"/>
                            <rich:column label="Feuille de calcul" sortable="false" width="5%" sortBy="#{nb.salFeuille}">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{nb.salFeuille}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="false" width="5%" sortBy="#{nb.lib_etat}">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{nb.lib_etat}"/>
                            </rich:column>
                            <rich:column label="Matricule agent" sortable="false" width="10%" sortBy="#{nb.salMatricule}">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{nb.salMatricule}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="false" width="20%" sortBy="#{nb.salNom}  #{nb.salPrenom}">
                                <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                <h:outputText value="#{nb.salNom}  #{nb.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Genre : Homme ou femme" sortable="false" width="5%" sortBy="#{nb.lib_genre}">
                                <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                                <h:outputText value="#{nb.lib_genre}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" title="Sit. Fam." sortBy="#{nb.salSitFamille}">
                                <f:facet name="header"><h:outputText value="Sit.Fam."/></f:facet>
                                <h:selectOneMenu value="#{nb.salSitFamille}" style="width:95%">
                                    <f:selectItem itemLabel="Célibataire" itemValue="0" />
                                    <f:selectItem itemLabel="Marié(e)" itemValue="1" />
                                    <f:selectItem itemLabel="Concubin(e)" itemValue="2" />
                                    <f:selectItem itemLabel="Pacsé(e)" itemValue="3" />
                                    <f:selectItem itemLabel="Divorcé(e)" itemValue="4" />
                                    <f:selectItem itemLabel="Veuf(ve)" itemValue="5" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbPartsPreparation}" reRender="idNbF,idNbPT,idNbPF"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Nombre d'enfants" sortable="false" width="10%" sortBy="#{nb.salNbEnfant}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.nbEnfantsFiscaux=='1'}" style="text-align:center">
                                <f:facet name="header"><h:outputText  value="Nb Enfant" /></f:facet>
                                <h:inputText value="#{nb.salNbEnfant}" style="width:60%;text-align:center">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbPartsPreparation}" reRender="idNbF,idNbPT,idNbPF"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Nombre d'enfants" sortable="false" width="10%" sortBy="#{nb.salNbEnfant}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.nbEnfantsFiscaux=='0'}">
                                <f:facet name="header"><h:outputText  value="Nb Enfant" /></f:facet>
                                <a4j:commandButton value="#{nb.salNbEnfant}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.ouvrePanelEnfant}" reRender="panelenfant" style="width:80%;text-align:center"/>
                            </rich:column>
                            <rich:column id="idNbF" label="Nombre Epouse" sortable="false" width="10%" sortBy="#{nb.salNbFemme}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}" style="text-align:center">
                                <f:facet name="header"><h:outputText  value="Nb Epouse" /></f:facet>
                                <a4j:commandButton value="#{nb.salNbFemme}" rendered="#{nb.salGenre==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.ouvrePanelFemme}" reRender="panelFemme" style="width:80%;text-align:center"/>
                            </rich:column>
                            <rich:column id="idNbPT" label="Nombre part TRIMF" sortable="false" width="10%" sortBy="#{nb.salNbPartTrimf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}" style="text-align:center">
                                <f:facet name="header"><h:outputText  value="Nb TRIMF" /></f:facet>
                                <h:outputText value="#{nb.salNbPartTrimf}" style="text-align:center"/>
                            </rich:column>
                            <rich:column id="idNbPF" label="Nombre de parts fiscales" sortable="false" width="10%" sortBy="#{nb.salNbPartFiscal}" style="text-align:center">
                                <f:facet name="header"><h:outputText  value="Nb Parts" /></f:facet>
                                <h:outputText value="#{nb.salNbPartFiscal}" style="text-align:center"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabProdution" label="Production mensuelle" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}">
                    <h:panelGrid columns="2" width="100%">
                        <h:column><h:outputText value="Production théorique (m3):"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenProductionTheo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/></h:column>
                        <h:column><h:outputText value="Production réelle (m3):"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenProductionReelle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/></h:column>
                        <h:column><h:outputText value="Nombre d'heures réelles du mois:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenNbHeureRelle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat>=3}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelVariable" width="900" height="700" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelVariable}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelVariable}" var="varb">
            <f:facet name="header"><h:outputText value="GESTION DES VARIABLES POUR LA PERIODE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenPeriode}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanVariable" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerVariables}" styleClass="hidelink" reRender="panelVariable"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanVariable')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panVariable">

                    <rich:tabPanel switchType="client" immediate="true" id="tabPanelsalaries" style="border:0px;">

                        <rich:tab name="variable" label="Variables mensuelles">
                            <jsp:include flush="true" page="/paye/PreparationCommun.jsp" />
                            <a4j:commandButton title="Recharger les variables" image="/images/actualiser.png" style="height:15px;width:15px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechargeVariable}" onclick="if (!confirm('Etes-vous sur de vouloir recharger les variables de la liste?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table"/>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelVariables}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionVariable}" reRender="butt"/>
                                    <rich:column  width="12%" sortable="false">
                                        <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                                        <h:outputText value= "#{plan.planPaye.libelleNature}"/>
                                    </rich:column>
                                    <rich:column width="8%" sortable="false" sortBy="#{plan.salvarCode}" sortOrder="ASCENDING">
                                        <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                        <h:outputText value="#{plan.salvarCode}"/>
                                    </rich:column>
                                    <rich:column width="30%" sortable="false" >
                                        <f:facet name="header">
                                            <h:outputText value="Libellé rubrique"/>
                                        </f:facet>
                                        <h:outputText value="#{plan.planPaye.plpLibelleFR}"/>
                                    </rich:column>
                                    <rich:column id="idColA" width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColA}" rendered="#{plan.salvarVariableA}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{plan.griseVariableA}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColA"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column id="idColB" width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColB}" rendered="#{plan.salvarVariableB}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{plan.griseVariableB}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColB"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column id="idColC" width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColC}" rendered="#{plan.salvarVariableC}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{plan.griseVariableC}">
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColC"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column id="idColD" width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColD}" rendered="#{plan.salvarVariableD}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{plan.griseVariableD}">
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColD"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column id="idColE" width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                                        <h:inputText  value="#{plan.salvarValeurColE}" rendered="#{plan.salvarVariableE}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" disabled="#{plan.griseVariableE}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idColE"/>
                                        </h:inputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                        <rich:tab name="elements" label="Elements salariés">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="idSitFam,idAnalytique,idPaiement,idEtat"/>
                            <jsp:include flush="true" page="/paye/PreparationCommun.jsp" />
                            <h:panelGrid columns="4" id="idSitFam" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Genre:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio id="idGenre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGenre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}" style="width:200px">
                                        <f:selectItem itemLabel="Femme" itemValue="0"/>
                                        <f:selectItem itemLabel="Homme" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Situation matrimoniale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}">
                                        <f:selectItem itemLabel="Célibataire" itemValue="0" />
                                        <f:selectItem itemLabel="Marié(e)" itemValue="1" />
                                        <f:selectItem itemLabel="Concubin(e)" itemValue="2" />
                                        <f:selectItem itemLabel="Pacsé(e)" itemValue="3" />
                                        <f:selectItem itemLabel="Divorcé(e)" itemValue="4" />
                                        <f:selectItem itemLabel="Veuf(ve)" itemValue="5" />
                                        <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbParts}" reRender="idSitFam,idNbEnfant,idNbFemme,nbPartFiscal,idNbpartTrimf,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText id="idD1" value="Date (JJ/MM/AAAA)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille>=1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==0}"></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==1}"><rich:calendar id="idD2"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateMarie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==2}"><rich:calendar id="idD3"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateConcubinage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==3}"><rich:calendar id="idD4"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDatePacs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==4}"><rich:calendar id="idD5"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateDivorce}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==5}"><rich:calendar id="idD6"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateVeuf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Nb Enfants:"/></h:column>
                                <h:column>
                                    <h:inputText id="idNbEnfant" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbEnfant}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <a4j:support eventsQueue="maQeueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbParts}" reRender="idSitFam,idNbEnfant,idNbFemme,nbPartFiscal,idNbpartTrimf,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Nb Parts:"/></h:column>
                                <h:column><h:inputText id="nbPartFiscal" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbPartFiscal}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}"/></h:column>
                                <h:column><h:outputText value="Nb Parts TRIMF:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}"/></h:column>
                                <h:column>
                                    <h:inputText id="idNbpartTrimf" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbPartTrimf}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}">
                                        <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbParts}" reRender="idSitFam,idNbEnfant,idNbFemme,nbPartFiscal,idNbpartTrimf,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Nb Femmes:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGenre==1}"/></h:column>
                                <h:column>
                                    <h:inputText id="idNbFemme" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbFemme}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGenre==1}">
                                        <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbParts}" reRender="idSitFam,idNbEnfant,idNbFemme,nbPartFiscal,idNbpartTrimf,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" id="idPaiement" styleClass="fichefournisseur">
                                <h:panelGrid columns="4"  columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                    <h:column><h:outputText value="Mode de paiement:"/></h:column>
                                    <h:column>
                                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}">
                                            <f:selectItem itemLabel="Espèce" itemValue="0"/>
                                            <f:selectItem itemLabel="Cheque" itemValue="1"/>
                                            <f:selectItem itemLabel="Virement" itemValue="2"/>
                                            <f:selectItem itemLabel="Carte pré-payée" itemValue="3"/>
                                            <f:selectItem itemLabel="Micro-finance" itemValue="4"/>
                                            <f:selectItem itemLabel="Mobile" itemValue="5" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.accesOrange}"/>
                                            <f:selectItem itemLabel="Autre" itemValue="9"/>
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeCalculPaiement}" reRender="panPaiement,idPaiement"/>
                                        </h:selectOneRadio>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="8" id="panPaiement" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==4}">
                                    <h:column><h:outputText value="Code banque:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Code guichet:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGuichetBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="N° compte:"/></h:column>
                                    <h:column><h:inputText size="12" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Clé Ctrl:"/></h:column>
                                    <h:column><h:inputText size="2" maxlength="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCleBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==2}">
                                    <h:column><h:outputText value="IBAN:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleIban}" maxlength="34" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="SWIFT:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSwift}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==3}">
                                    <h:column><h:outputText value="Code banque:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="N° carte:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==4}">
                                    <h:column><h:outputText value="N° compte du membre:"/></h:column>
                                    <h:column><h:inputText size="20" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCompteMembre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==5}">
                                    <h:column><h:outputText value="N° téléphone mobile:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid columns="4" id="idEtat" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Etat:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}">
                                        <f:selectItem itemLabel="En cours" itemValue="0" />
                                        <f:selectItem itemLabel="En conges" itemValue="1" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Licencié(e)" itemValue="2" />
                                        <f:selectItem itemLabel="Démissionné(e)" itemValue="3" />
                                        <f:selectItem itemLabel="Décédé(e)" itemValue="4" />
                                        <f:selectItem itemLabel="Retraité(e)" itemValue="5" />
                                        <f:selectItem itemLabel="Fin de contrat" itemValue="6" />
                                        <f:selectItem itemLabel="Arrêt ou Suspension" itemValue="7" />
                                        <f:selectItem itemLabel="Mutation" itemValue="8" itemDisabled="true"/>
                                        <f:selectItem itemLabel="BULLETIN GELE" itemValue="9" />
                                        <f:selectItem itemLabel="Départ négocié" itemValue="10" />
                                        <a4j:support eventsQueue="maQeueue" event="onchange" reRender="idEtat,idD11,idD12,idD13,idD14,idD15,idD16"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText id="idD11" value="Date de départ (JJ/MM/AAAA):" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column><rich:calendar id="idD12"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateSortie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat<=7}" /></h:column>
                                <h:column><h:outputText id="idD13" value="Motif:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column><h:inputText id="idD14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleMotifSortie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column><h:outputText id="idD15" value="Solde des prêts:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idD16" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeSolde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleEtat<=7}">
                                        <f:selectItem itemLabel="Oui" itemValue="0" />
                                        <f:selectItem itemLabel="Nom" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="contrat" label="Contrat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.accesContrats&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_acc_contrat}">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="idSitFam,idAnalytique,idPaiement,idEtat"/>
                            <jsp:include flush="true" page="/paye/PreparationCommun.jsp" />
                            <h:panelGrid columns="4" id="idConvention" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='04'}">
                                <h:column><h:outputText value="Date Embauche:"/></h:column>
                                <h:column>
                                    <rich:calendar datePattern="dd/MM/yyyy"  inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconDateDebut}" popup="true" disabled="true"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:170px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconEssai}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Contrat normal" itemValue="0" />
                                        <f:selectItem itemLabel="Période d`essai" itemValue="1" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Fonction:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Véhicule:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sans véhicule" itemValue="0"/>
                                        <f:selectItem itemLabel="Véhicule personnel au forfait" itemValue="1"/>
                                        <f:selectItem itemLabel="Véhicule personnel au Km" itemValue="2"/>
                                        <f:selectItem itemLabel="Véhicule entreprise" itemValue="3"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idConvention,v0,v1,v2,v3,v4,v5,v6;v7"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column id="v0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==0}"></h:column>
                                <h:column id="v1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==0}"></h:column>
                                <h:column id="v3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==1}"><h:outputText value="Montant remboursé au forfait:"/></h:column>
                                <h:column id="v4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==2}"><h:outputText value="Montant remboursé au Km:"/></h:column>
                                <h:column id="v5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==3}"><h:outputText value="Parc N°:"/></h:column>
                                <h:column id="v6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==2}">
                                    <h:inputText style="width:50%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconRbmKms}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column id="v7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconVehicule==3}">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_option_parc}" var="pac1">
                                        <h:selectOneMenu id="idparc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconParc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesParcItems}" />
                                        </h:selectOneMenu>
                                    </c:if>
                                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_option_parc}" var="pac1">
                                        <h:inputText id="idparc2" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconParc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Niveau emploi (cadre?):"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idniveau" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_niveau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sélectionnez Niveau emploi" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesNiveauxEmploisItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Classement:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idclassement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_classement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sélectionnez Classement" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClassementsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Centre Impôt:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_centre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesCentresImpotsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Centre Sécurité Sociale:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idsecuriSoc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_securite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}">
                                        <f:selectItem itemLabel="Sélectionnez Centre sécurité sociale" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesCentresSecuritesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Convention:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_convention}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesConventionsItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chargerGrille}" reRender="idConfig,idgrille"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_grille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesGrillesItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculGrillePreparation}" reRender="idContrat0,idContrat1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nb heures mois:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconNbHeureMois}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}"/>&nbsp;&nbsp;<h:outputText value="(Si vide alors heures convention)"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Régime congés:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconNbJourCp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                                <h:column><h:outputText value="Nb jours travail:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconNbJourTr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid columns="4" id="idAnalytique" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Clé 1 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_cle1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Clé 2 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_cle2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='1'}"><h:outputText value="Activité:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='1'}">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_activite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesActivitesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='2'}"><h:outputText value="Service:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='2'}">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_service}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesServiceItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Localisation:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleLocalisation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesLocalisationItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Taux prorata salaire (%):"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconTaux}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <br>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='13'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='14'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='15'}" var="ctr0">
                                <h:panelGrid id="idContrat0" styleClass="fichefournisseur"  width="100%">
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%">
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_forfaitPrestataire}"><h:outputText value="Forfait:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_forfaitPrestataire}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconBase}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_redement}"><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_redement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeRendement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_responsbilite}"><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_responsbilite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeResponsabilite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_fonction}"><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_fonction}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeFonction}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>

                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_prm_transport}"><h:outputText value="Prime Transport:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_prm_transport}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeTransport}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_prm_logement}"><h:outputText value="Prime Logement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_prm_logement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeLogement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>

                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_deplacement}"><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_deplacement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteDeplacement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_kilometre}"><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_kilometre}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteKilometrique}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_salissure}"><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_salissure}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteSalissure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_representation}"><h:outputText value="Indemnité de représentation:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_representation}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteRepresentation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_diverse}"><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_diverse}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteDiverse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_indemResons}"><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_indemResons}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteResponsabilite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nourriture}"><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nourriture}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteNourriture}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='04'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='12'}" var="ctr1">
                                <h:panelGrid id="idContrat1" styleClass="fichefournisseur"  width="100%">
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='05'}"><h:outputText value="Base mensuelle conventionnée:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='05'}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconBase}" disabled="true">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03I'}"><h:outputText value="Base horaire conventionnée:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03I'}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconBase}" disabled="true">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='05')}"><h:outputText value="Sursalaire mensuel:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='05')}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconSursalaire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03I')}"><h:outputText value="Sursalaire mensuel:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconType=='03I')}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconSursalaire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_forfaitHeureSup}"><h:outputText value="Forfait heures sup.:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_forfaitHeureSup}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconForfaitSup}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_outillage}"><h:outputText value="Prime outillage:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_outillage}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeOutillage}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_astreinte}"><h:outputText value="Prime d'astreinte:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_astreinte}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeAstreinte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_redement}"><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_redement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeRendement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_responsbilite}"><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_responsbilite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeResponsabilite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_fonction}"><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_fonction}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeFonction}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_sujetion}"><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_sujetion}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeSujetion}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_exceptionnel}"><h:outputText value="Prime Exceptionnelle fixe:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_exceptionnel}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconPrimeExceptionnelle}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_caisse}"><h:outputText value="Indemnité Caisse:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_caisse}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteCaisse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_transport}"><h:outputText value="Indemnité Transport:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_transport}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteTransport}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_logement}"><h:outputText value="Indemnité Logement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_logement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteLogement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_deplacement}"><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_deplacement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteDeplacement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_kilometre}"><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_kilometre}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteKilometrique}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_salissure}"><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_salissure}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteSalissure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_representation}"><h:outputText value="Indemnité de représentation:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_representation}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteRepresentation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_diverse}"><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_diverse}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteDiverse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_indemResons}"><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_indemResons}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteResponsabilite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nourriture}"><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nourriture}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconIndemniteNourriture}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_logement}"><h:outputText value="Avt. nat. logement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_logement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnLogement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_domesticite}"><h:outputText value="Avt. nat. Domesticité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_domesticite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnDomesticite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_eau}"><h:outputText value="Avt. nat. Eau:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_eau}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnEau}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_electricite}"><h:outputText value="Avt. nat. Electricité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_electricite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnElectricite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_nourriture}"><h:outputText value="Avt. nat. nourriture:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_nourriture}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnNourriture}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_vehicule}"><h:outputText value="Avt. nat. véhicule :" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_vehicule}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnVehicule}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_telephone}"><h:outputText value="Avt. nat. Téléphone:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_avn_telephone}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesContrats.salconAvnTelephone}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </c:if>
                        </rich:tab>

                        <rich:tab name="prets" label="Prêts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.accesPrets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_acc_prets}">
                            <jsp:include flush="true" page="/paye/PreparationCommun.jsp" />
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelEcheances}" enableContextMenu="false" var="eche" id="tableEcheance" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="415px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                    <rich:column label="Nature du prêt" sortable="false" width="150px">
                                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                        <h:outputText value="#{eche.salariesPrets.lib_nature}"/>
                                    </rich:column>
                                    <rich:column label="N° du prêt" sortable="false" width="60px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{eche.salariesPrets.salpreNum}"/>
                                    </rich:column>
                                    <rich:column label="Description" sortable="false" width="300px">
                                        <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                                        <h:outputText value="#{eche.salariesPrets.salpreObjet}"/>
                                    </rich:column>
                                    <rich:column label="Date théorique" sortable="false" width="80px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Date Théo." /></f:facet>
                                        <h:outputText value="#{eche.salpreligDateTheo}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant théorique" sortable="false" width="100px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Montant Théo." /></f:facet>
                                        <h:outputText value="#{eche.salpreligMontantTheo}" rendered="#{eche.salpreligMontantTheo!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Référence" sortable="false" width="200px">
                                        <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                        <h:outputText value="#{eche.salpreligReference}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                            <br>
                            <h:panelGrid width="50%" columns="2">
                                <h:column><h:outputText value="Total des échéances"/></h:column>
                                <h:column>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.totalPret}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="absences" label="Absences" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.accesAbsences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_acc_absences}">
                            <jsp:include flush="true" page="/paye/PreparationCommun.jsp" />
                            <h:panelGrid width="200px" id="panelBoutonAbsences" columns="4">
                                <a4j:commandButton title="Ajouter une nouvelle absence" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.ajouterAbsences}" reRender="panelAbsences"/>
                                <a4j:commandButton title="Modifier l'absence sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modifierAbsences}" reRender="panelAbsences"/>
                                <a4j:commandButton title="Supprimer l'absence sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.supprimerAbsences}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonAbsences,tableAbsences"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelAbsences}" enableContextMenu="false" var="abs" id="tableAbsences" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="380px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionAbsences}" reRender="panelBoutonAbsences"/>
                                    <rich:column label="Nature de l'absence" sortable="true" width="20%" sortOrder="#{abs.lib_nature}">
                                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                        <h:outputText value="#{abs.lib_nature}"/>
                                    </rich:column>
                                    <rich:column label="Etat de l'absence" sortable="true" width="10%" sortOrder="#{abs.salgrhEtat}">
                                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                        <h:outputText value="#{abs.libelleEtat}"/>
                                    </rich:column>
                                    <rich:column label="Date de l'absence" sortable="true" width="10%" sortOrder="#{abs.salcngDateDebut}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{abs.salcngDateDebut}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date retour de l'absence" sortable="true" width="10%" sortOrder="#{abs.salcngDateFin}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Retour" /></f:facet>
                                        <h:outputText value="#{abs.salcngDateFin}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Durée" sortable="true" width="10%" sortOrder="#{abs.salcngDuree}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Durée" /></f:facet>
                                        <h:outputText value="#{abs.salcngDuree}"/>
                                    </rich:column>
                                    <rich:column label="Description" sortable="true" width="30%" sortOrder="#{abs.salcngObjet}">
                                        <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                                        <h:outputText value="#{abs.salcngObjet}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                            <br>
                            <h:panelGrid width="50%" columns="2" id="idTotalNbJour">
                                <h:column><h:outputText value="Total des jours d'absences"/></h:column>
                                <h:column>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nbJourAbs}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>

                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValVariable" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveVariables}" reRender="panelVariable,idEffectue,idSaisie1,idSaisie2,idSaisie3,idSaisie4,idSaisie5,idSaisie6,idSaisie7,idSaisie8,idSaisie9,idSaisie10,idSaisie11,idSaisie12"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValVariable')}.click()" />
                        </center>
                    </h:panelGroup>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpPrepa" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintPrep}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintPrep}" var="prtprp">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.closeImpressionPrep}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpPrepa"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpPrepa" target="_blank">
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nomModeleListe}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.listeImpressionItems}"/>
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

    <rich:modalPanel domElementAttachment="parent"  id="panelImpRub" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintRub}">
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

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelAbsences" width="800" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelAbsences}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelAbsences}" var="abr">
            <f:facet name="header"><h:outputText value="GESTION DES ABSENCES ET RETARDS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanAbsences" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.annulerAbsences}" styleClass="hidelink" reRender="panelAbsences"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanAbsences')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panAbsences">
                    <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Nature Absence ou retard:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}">
                                <f:selectItem itemLabel="Absence payées" itemValue="11" />
                                <f:selectItem itemLabel="Absence non payées" itemValue="12" />
                                <f:selectItem itemLabel="Absence payées à déduire sur CP" itemValue="13" />
                                <f:selectItem itemLabel="Retard non payé" itemValue="14" />
                                <f:selectItem itemLabel="Retard payé" itemValue="15" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panAbsences,idAbsences" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" id="idAbsences" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                        <h:column>
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}"/>&nbsp;&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngAm}"/>&nbsp;&nbsp;
                            <h:outputText value="Absent à partir du matin"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature!=15}"><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature!=15}">
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}"/>&nbsp;&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngPm}"/>&nbsp;&nbsp;
                            <h:outputText value="Absent jusqu'au soir"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature==15}"><h:outputText value="Nombre heures retard:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNature==15}"><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngNbHeure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}"/></h:column>
                        <h:column><h:outputText value="Motif/objet:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}"/></h:column>
                        <h:column><h:outputText value="Responsable:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesAbsences.salcngResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}"/></h:column>
                    </h:panelGrid>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValAbsences" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveAbsences}" reRender="panelBoutonAbsences,tableAbsences,panelAbsences,idTotalNbJour"/>
                        </center>
                        <rich:hotKey key="return"  handler="#{rich:element('idValAbsences')}.click()" />
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeBulletin" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelListeBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelListeBulletin}" var="lst">
            <f:facet name="header"><h:outputText value="LISTE DES BULLETINS POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanListeBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerListeBulletin}" styleClass="hidelink" reRender="panelListeBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanListeBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup>
                    <center>
                        <a4j:commandButton title="Consulter le bulletin généré" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.consulterBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
                    </center>
                </h:panelGroup>
                <h:panelGrid style="width:100%;" id="panListeBulletin">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelListeBulletins}" enableContextMenu="false" var="liste" id="listeBulletin" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="400px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionBulletin}"/>
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="Période"/></f:facet>
                                <h:outputText value="#{liste.bulsalPeriode}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" >
                                <f:facet name="header"><h:outputText value="Date début"/></f:facet>
                                <h:outputText value="#{liste.bulsalDateDebut}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Date début"/></f:facet>
                                <h:outputText value="#{liste.bulsalDateFin}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                                <h:outputText value="#{liste.bulsalActivite}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Av. Nat."/></f:facet>
                                <h:outputText value="#{liste.bulsalAvNat}" rendered="#{liste.bulsalAvNat!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="C.P."/></f:facet>
                                <h:outputText value="#{liste.bulsalCP}" rendered="#{liste.bulsalCP!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Net"/></f:facet>
                                <h:outputText value="#{liste.bulsalNetPayer}" rendered="#{liste.bulsalNetPayer!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeRubrique" width="1350" height="520" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelListeRubrique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelListeRubrique}" var="rub">
            <f:facet name="header"><h:outputText value="LISTE DES RUBRIQUES POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanListeRubrique" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerlisteRubrique}" styleClass="hidelink" reRender="panelListeRubrique"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanListeRubrique')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieRubriques.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBulletin" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}" var="bul">
            <f:facet name="header"><h:outputText value="BULLETIN DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalPeriode} POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerConsulterBulletin}" styleClass="hidelink" reRender="panelBulletin,panelImpBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieBulletins.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelRecopierVariables" width="500" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelRecopierVariables}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelRecopierVariables}" var="cop">
            <f:facet name="header"><h:outputText value="RECOPIER VARIABLES VERS UN AUTRE MOIS NON CLOTURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanRecopie" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerRecopierVariables}" styleClass="hidelink" reRender="panelRecopierVariables"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanRecopie')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panRecopie">
                    <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Mois non cloturés:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.moisChoisi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_absences==3}">
                                <f:selectItem itemLabel="Sélection mois" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesMoisNonclotures}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValRecopie" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.validerRecopierVariables}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRecopierVariables"/>
                        </center>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecopie')}.click()" />
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_showBarProg}">
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

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LA PREPARATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID congés:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleId}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
