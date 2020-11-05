<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="listesalaries">

    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES TACHES DES AGENTS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panelRecherche" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}"/>
                    <h:column><h:outputText value="Immat.:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_immat_rec}" style="width:100px"/></h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nom_rec}" style="width:100px"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_tiers_rec}">
                            <f:selectItem itemLabel="Tous tiers" itemValue="100"/>
                            <f:selectItem itemLabel="Sans tiers" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTiersItems}"/>
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
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nature_rec}">
                            <f:selectItem itemLabel="Toutes Natures agents" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_feuille_rec}">
                            <f:selectItem itemLabel="Toutes Feuilles" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_service}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_service_rec}">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_activite}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_activite_rec}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercherSalarie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panSuite" columns="7" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}">
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
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="dep" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_departement_rec}">
                            <f:selectItem itemLabel="Tous Départements" itemValue="100"/>
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

        <h:panelGrid  id="boutonSalaries" columns="1" width="100px" style="height:34px">
            <a4j:commandButton title="Taches" image="/images/dateNaissance.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.gestionTache}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListTache"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.pageIndex}" reRender="tableSalaries" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="120%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.datamodelSalaries}" var="salaries" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.simpleSelectionEnteteSal}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.extDTableSal}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionSalaries}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visualisationSalaries}" reRender="idSubView,boutonSalaries"/>
                <rich:column label="Matricule agent" sortable="true" width="100px" sortBy="#{salaries.salMatricule}">
                    <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                    <h:outputText value="#{salaries.salMatricule}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Nature agent" sortable="true" width="120px" sortBy="#{salaries.lib_nature}">
                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                    <h:outputText value="#{salaries.lib_nature}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Feuille de calcul" sortable="true" width="60px" sortBy="#{salaries.salFeuille}">
                    <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                    <h:outputText value="#{salaries.salFeuille}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Etat" sortable="true" width="60px" sortBy="#{salaries.lib_etat}">
                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                    <h:outputText value="#{salaries.lib_etat}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Nom et prénom" sortable="true" width="300px" sortBy="#{salaries.patronyme}">
                    <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                    <h:outputText value="#{salaries.patronyme}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Genre : Homme ou femme" sortable="true" width="60px" sortBy="#{salaries.lib_genre}">
                    <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                    <h:outputText value="#{salaries.lib_genre}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Situation de famille" sortable="true" width="60px" sortBy="#{salaries.lib_sitfamille}">
                    <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                    <h:outputText value="#{salaries.lib_sitfamille}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Service actuel" sortable="true" width="80px" sortBy="#{salaries.salService}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_service}">
                    <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                    <h:outputText value="#{salaries.salService} #{salaries.salLibService}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Client actuel" sortable="true" width="80px" sortBy="#{salaries.salNomTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                    <f:facet name="header"><h:outputText  value="Client" /></f:facet>
                    <h:outputText value="#{salaries.salNomTiers}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Activite actuelle" sortable="true" width="80px" sortBy="#{salaries.salActivite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_activite}">
                    <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                    <h:outputText value="#{salaries.salActivite}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="Focntion actuelle" sortable="true" width="150px" sortBy="#{salaries.salFonction}">
                    <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                    <h:outputText value="#{salaries.salFonction}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="N° Sécurité sociale" sortable="true" width="120px" sortBy="#{salaries.salNumSecu}">
                    <f:facet name="header"><h:outputText  value="N° Sécu." /></f:facet>
                    <h:outputText value="#{salaries.salNumSecu}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="N° CNAMGS" sortable="true" width="120px" sortBy="#{salaries.salNumCnamgs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                    <f:facet name="header"><h:outputText  value="N° CNAMGS" /></f:facet>
                    <h:outputText value="#{salaries.salNumCnamgs}" style="#{salaries.protege}"/>
                </rich:column>
                <rich:column label="N° AMO" sortable="true" width="120px" sortBy="#{salaries.salNumAmo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}">
                    <f:facet name="header"><h:outputText  value="N° AMO" /></f:facet>
                    <h:outputText value="#{salaries.salNumAmo}" style="#{salaries.protege}"/>
                </rich:column>
            </rich:extendedDataTable>
        </div>
    </a4j:form>

    <rich:modalPanel id="panelListTache" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelListeTache}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelListeTache}" var="trf">
            <f:facet name="header"><h:outputText value="Liste des taches de l'agent"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerTache}" image="/images/close.gif" styleClass="hidelink" reRender="panelListTache"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  style="width:100%">
                    <h:panelGrid width="200px" id="panelBouton" columns="3" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton title="Ajouter un nouvelle tache" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterTache}" reRender="panelTache"/>
                        <a4j:commandButton title="Modifier la tache sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectTache}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierTache}" reRender="panelTache"/>
                        <a4j:commandButton title="Supprimer la tache sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectTache}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerTache}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBouton,tableTaches"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableTaches" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelTachesAgents}" var="tac" activeRowKey="true" rowKeyVar="rkv" sortMode="multi" selectionMode="single">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionTache}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <rich:column label="Code" sortable="true" width="10%" sortBy="#{tac.saltacMission}" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{tac.saltacMission}"/>
                            </rich:column>
                            <rich:column label="Code" sortable="true" width="10%" sortBy="#{tac.saltacCode}" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{tac.saltacCode}"/>
                            </rich:column>
                            <rich:column label="Libellé" sortable="true" width="50%" sortBy="#{tac.saltacLib}">
                                <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                <h:outputText value="#{tac.saltacLib}"/>
                            </rich:column>
                            <rich:column label="Prix de revient" sortable="true" width="15%" sortOrder="#{tac.saltacValPr}">
                                <f:facet name="header"><h:outputText  value="P.R." /></f:facet>
                                <h:outputText value="#{tac.saltacValPr}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Prix de vente" sortable="true" width="15%" sortOrder="#{tac.saltacValPv}">
                                <f:facet name="header"><h:outputText  value="P.V." /></f:facet>
                                <h:outputText value="#{tac.saltacValPv}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelTache" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="250" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelTache}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelTache}" var="tac">
            <f:facet name="header"><h:outputText value="Gestion Tache"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annulerTache}" image="/images/close.gif" styleClass="hidelink" reRender="panelTache"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:panel  style="width:100%">
                    <h:panelGrid  columns="2" style="width:100%" id="idTache">
                        <h:column><h:outputText value="Tache:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesTaches.saltacCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                <f:selectItem itemLabel="Sélectionnez tache" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTachesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculTache}" reRender="idTache"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Prix de revient:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesTaches.saltacValPr}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Prix de vente:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesTaches.saltacValPv}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="idValide">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.validerTache}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelTache,tableTaches"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
