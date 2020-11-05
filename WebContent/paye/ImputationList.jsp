<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeimputations">

    <a4j:form>

        <center> <h2><h:outputText value="IMPUTATION DES SALARIES (CONTRATS)" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panelRecherche" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="8" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}"/>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_tiers_rec}">
                            <f:selectItem itemLabel="Tous tiers" itemValue="100"/>
                            <f:selectItem itemLabel="Sans tiers" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTiersItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_service_rec}">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItem itemLabel="Sans Service" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_activite_rec}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItem itemLabel="Sans Activité" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_localisation_rec}">
                            <f:selectItem itemLabel="Toutes Localisations" itemValue="100"/>
                            <f:selectItem itemLabel="Sans Localisation" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesLocalisationItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_budget_rec}">
                            <f:selectItem itemLabel="Tous budgets" itemValue="100"/>
                            <f:selectItem itemLabel="Sans budgets" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.mesBudgetsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_projet_rec}">
                            <f:selectItem itemLabel="Tous Projets" itemValue="100"/>
                            <f:selectItem itemLabel="Sans Projets" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesProjetItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercherSalarieImputation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panSuite" columns="10" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}">
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nature_rec}">
                            <f:selectItem itemLabel="Sélectionnez type de contrat" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeElementContrat}" reRender="tableSalaries,scrollTable,boutonSalaries"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_etat_rec}">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="Actif" itemValue="0"/>
                            <f:selectItem itemLabel="En congès" itemValue="1"/>
                            <f:selectItem itemLabel="Licencié" itemValue="2"/>
                            <f:selectItem itemLabel="Démissioné" itemValue="3"/>
                            <f:selectItem itemLabel="Décédé" itemValue="4"/>
                            <f:selectItem itemLabel="Retraité" itemValue="5"/>
                            <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                            <f:selectItem itemLabel="Arret/Suspendu" itemValue="7"/>
                            <f:selectItem itemLabel="Mutation" itemValue="8"/>
                            <f:selectItem itemLabel="Geler" itemValue="9"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_feuille_rec}">
                            <f:selectItem itemLabel="Toutes Feuilles" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="conv" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_convention_rec}">
                            <f:selectItem itemLabel="Toutes Conventions" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesConventionsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="grille" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_grille_rec}">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesGrillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="sit" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_site_rec}">
                            <f:selectItem itemLabel="Tous Sites" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesSitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculDepartement}" reRender="dep"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="dep" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_departement_rec}">
                            <f:selectItem itemLabel="Tous Départements" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesDepartementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="niveau" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_niveau_rec}">
                            <f:selectItem itemLabel="Tous Niveaux" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNiveauxEmploisItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="classement" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_classement_rec}">
                            <f:selectItem itemLabel="Tous Classements" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClassementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="centre" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_centre_rec}">
                            <f:selectItem itemLabel="Tous Centres" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresImpotsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonSalaries" columns="6" width="250px" style="height:34px">
            <a4j:commandButton title="Modifier le contrat sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat<=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierImputationContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panalImputation"/>
            <a4j:commandButton title="Consulter le contrat sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterImputationContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panalImputation"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            <a4j:commandButton title="Geler le contrat sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat<=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.gelerImputationContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idEtatCrt,tableSalaries,scrollTable,boutonSalaries"/>
            <a4j:commandButton title="Réactiver le contrat sélectionné" image="/images/degeler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat==9}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.degelerImputationContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idEtatCrt,tableSalaries,scrollTable,boutonSalaries"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.pageIndex}" reRender="tableSalaries" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="130%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelContrat}" var="contrat" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.simpleSelectionEnteteCrt}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.extDTableCrt}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionContrat}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visualisationModificationCrt}" reRender="panalImputation"/>
                    <rich:column label="N° contrat" sortable="true" width="70px" sortBy="#{contrat.salconNum}">
                        <f:facet name="header"><h:outputText  value="N° crt" /></f:facet>
                        <h:outputText value="#{contrat.salconNum}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Matricule agent" sortable="true" width="70px" sortBy="#{contrat.salaries.salMatricule}">
                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                        <h:outputText value="#{contrat.salaries.salMatricule}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Nom et prénom" sortable="true" width="200px" sortBy="#{contrat.salaries.patronyme}">
                        <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                        <h:outputText value="#{contrat.salaries.patronyme}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Genre : Homme ou femme" sortable="true" width="70px" sortBy="#{contrat.salaries.lib_genre}">
                        <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                        <h:outputText value="#{contrat.salaries.lib_genre}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Nature du contrat" sortable="true" width="10%" sortBy="#{contrat.lib_nature}">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{contrat.lib_nature}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column id="idEtatCrt" label="Etat du contrat" sortable="true" width="3%" sortBy="#{contrat.salconEtatH}">
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:outputText value="#{contrat.libelleEtat}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Feuille" sortable="true" width="3%" sortBy="#{contrat.salconFeuille}">
                        <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                        <h:outputText value="#{contrat.salconFeuille}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Statut du contrat" sortable="true" width="5%" sortBy="#{contrat.lib_etat}">
                        <f:facet name="header"><h:outputText  value="Statut" /></f:facet>
                        <h:outputText value="#{contrat.lib_etat}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Tiers" sortable="true" width="10%" sortBy="#{contrat.salconNomTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                        <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                        <h:outputText value="#{contrat.salconNomTiers}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Service" sortable="true" width="10%" sortBy="#{contrat.salconService}">
                        <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                        <h:outputText value="#{contrat.salconService}:#{contrat.salconLibService}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Activite" sortable="true" width="10%" sortBy="#{contrat.salconActivite}">
                        <f:facet name="header"><h:outputText  value="Activite" /></f:facet>
                        <h:outputText value="#{contrat.salconActivite}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Localisation" sortable="true" width="10%" sortBy="#{contrat.salconLocalisation}">
                        <f:facet name="header"><h:outputText  value="Localisation" /></f:facet>
                        <h:outputText value="#{contrat.salconLocalisation}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Projet" sortable="true" width="10%" sortBy="#{contrat.salconProjet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                        <f:facet name="header"><h:outputText  value="Projet" /></f:facet>
                        <h:outputText value="#{contrat.salconProjet} #{contrat.salconLibProjet}" style="#{contrat.protege}"/>
                    </rich:column>
                    <rich:column label="Fonction" sortable="true" width="10%" sortBy="#{contrat.salconFonction}">
                        <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                        <h:outputText value="#{contrat.salconFonction}" style="#{contrat.protege}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationPaye.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalImputation" width="700" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelImputation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelImputation}" var="crtImp" >
            <f:facet name="header"><h:outputText value="Imputations"></h:outputText></f:facet>
            <a4j:form>
                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}"><h:outputText value="Tiers:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIdTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans tiers" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTiersItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculServiceInterim}" reRender="idService"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Feuille:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idFeuille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_feuille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Feuille" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Site:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_site}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Site" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesSitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculDepartementImputation}" reRender="idDepartement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Département:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idDepartement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_departement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Département" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesDepartementsImputationItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Service:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idService" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_service}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Service" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Activité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_activite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Localisation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_localisation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Localisation" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesLocalisationItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}"><h:outputText value="Projet:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_projet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Projet" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesProjetItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Budget:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_budget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans budget" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.mesBudgetsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idcle1" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Cle1" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idcle2" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sans Cle2" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Nature salarié:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nature}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br><br>
                <h:panelGroup id="idValide">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerImputation}" reRender="panalImputation"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.validerImputation}" reRender="panalImputation,tableSalaries" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat!=3}"/>
                    </center>
                </h:panelGroup>

            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
