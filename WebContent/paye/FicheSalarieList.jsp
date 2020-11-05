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

        <center> <h2><h:outputText value="LISTE DES AGENTS" style="color:green;"/></h2></center>

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
                            <f:selectItem itemLabel="Sans nature" itemValue="20"/>
                            <f:selectItem itemLabel="Sans matricule" itemValue="21"/>
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

        <h:panelGrid  id="boutonSalaries" columns="12" width="500px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouvel agent" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier l'agent sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'agent sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Voir le dernier contrat" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterDernierContrat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelContrat"/>
            <a4j:commandButton title="Supprimer l'agent sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerSalaries}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,tableSalaries,scrollTable,boutonSalaries"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Changer Matricule" image="/images/parametre.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.changerMatricule}" onclick="if (!confirm('Etes-vous sur de vouloir changer de matricule?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelChangeMatricule"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.initGrapheur}"/>
            <a4j:commandButton title="Informations sur l'agent" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton}" reRender="panelInformation"/>
            <a4j:commandButton title="Protéger les tous salariés de la liste" style="width:20px;height:20px" image="/images/cadenas_cl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPaye==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPaye==5)}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.protegerSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSalaries,boutonSalaries"/>
            <a4j:commandButton title="Dé-protéger tous les salariés de la liste"  style="width:20px;height:20px" image="/images/cadenas_op.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPaye==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPaye==5)}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.deprotegerSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSalaries,boutonSalaries"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
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
                <rich:column label="Feuille de calcul" sortable="true" width="60px" sortBy="#{salaries.salFeuille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_feuille_rec=='100'}">
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

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationPaye.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelContrat" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="700" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelContrat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelContrat}" var="ctn">
            <f:facet name="header"><h:outputText value="Contrat" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.closeContrat}" image="/images/close.gif" styleClass="hidelink" reRender="panelContrat"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalContrat">
                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabContrat" label="Contrat">
                        <h:panelGrid id="idConfig0" width="100%" >
                            <h:panelGrid id="idConfig1" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Nature contrat:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez type contrat" itemValue="100" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Feuille calcul:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idfeuille" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconFeuille}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez Feuille" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateDebut}" popup="true" disabled="true" readonly="true"/></h:column>
                                <h:column><h:outputText value="Date fin (JJ/MM/AAAA):" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'}"/></h:column>
                                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateFin}" popup="true" disabled="true" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'}"/></h:column>
                                <h:column><h:outputText value="Fonction:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconFonction}" disabled="true" readonly="true"/></h:column>
                                <h:column><h:outputText value="Lieu travail:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconLieuTravail}" disabled="true" readonly="true"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idConfig2" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType!='13'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType!='14'}">
                                <h:column><h:outputText value="Niveau emploi:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idniveau" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_niveau}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez Niveau emploi" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNiveauxEmploisItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Classement:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idclassement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_classement}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez Classement" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClassementsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Centre Impôt:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_centre}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresImpotsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Convention:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_convention}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesConventionsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_grille}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesGrillesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idConfig3" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Régime congés:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbJourCp}" disabled="true" readonly="true"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                                <h:column><h:outputText value="Nb jours travail:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbJourTr}" disabled="true" readonly="true"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                                <h:column><h:outputText value="Activité:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idactivete" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_activite}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sans Activité" itemValue="100" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Budget:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idbuget" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_budget}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sans Budget" itemValue="100" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesBudgetItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Clé 1 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idcle1" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle1}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sans Cle1" itemValue="100" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Clé 2 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idcle2" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle2}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sans Cle2" itemValue="100" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Véhicule:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule}" disabled="true" readonly="true">
                                        <f:selectItem itemLabel="Sans véhicule" itemValue="0"/>
                                        <f:selectItem itemLabel="Véhicule personnel au forfait" itemValue="1"/>
                                        <f:selectItem itemLabel="Véhicule personnel au Km" itemValue="2"/>
                                        <f:selectItem itemLabel="Véhicule entreprise" itemValue="3"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column id="v0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==0}"></h:column>
                                <h:column id="v1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==0}"></h:column>
                                <h:column id="v3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==1}"><h:outputText value="Montant remboursé au forfait:"/></h:column>
                                <h:column id="v4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==2}"><h:outputText value="Montant remboursé au Km:"/></h:column>
                                <h:column id="v5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==3}"><h:outputText value="Parc N°:"/></h:column>
                                <h:column id="v6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==2}">
                                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconRbmKms}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column id="v7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==3}">
                                    <h:selectOneMenu id="idparc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconParc}" disabled="true" readonly="true">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesParcItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idValeurs" columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%" >
                                <h:column><h:outputText value="Base conventionnée:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconBase}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Sursalaire:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconSursalaire}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeRendement}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeResponsabilite}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeFonction}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeSujetion}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité Caisse:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteCaisse}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité Transport:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteTransport}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité Logement:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteLogement}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDeplacement}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteKilometrique}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteSalissure}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité de Représentation:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteRepresentation}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDiverse}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteResponsabilite}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteNourriture}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. logement:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnLogement}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. Domesticité:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnDomesticite}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. Eau:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnEau}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. Electricité:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnElectricite}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. nourriture:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnNourriture}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. véhicule :" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnVehicule}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Avt. nat. Téléphone:" style="text-align:right;"/></h:column>
                                <h:column>
                                    <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnTelephone}" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabTexte" label="Texte">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panTexte"/>
                        <h:panelGrid  width="100%" id="panTexte">
                            <h:panelGrid style="width:100%;" id="panelTexteContrat">
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconTexte}" readonly="true">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabSignature" label="Signature">
                        <h:panelGrid columns="4" id="panFin" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column><h:outputText value="Fin contrat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat}" disabled="true" readonly="true">
                                    <f:selectItem itemLabel="Contrat Actif" itemValue="0"/>
                                    <f:selectItem itemLabel="Licenciement" itemValue="2"/>
                                    <f:selectItem itemLabel="Démission" itemValue="3"/>
                                    <f:selectItem itemLabel="Décés" itemValue="4"/>
                                    <f:selectItem itemLabel="Retraite" itemValue="5"/>
                                    <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                                    <f:selectItem itemLabel="Arrêt ou suspension" itemValue="7"/>
                                    <f:selectItem itemLabel="Départ négocié" itemValue="10" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:outputText value="Date fin (JJ/MM/AAAA):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateFin}" popup="true" disabled="true" readonly="true"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:outputText value="Observations:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconMotifSortie}" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur1" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column><h:outputText value="Responsable:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNomRepresentant}" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Qualité:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconQualite}" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date remise (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateRemise}" popup="true" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateRetour}" popup="true" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="modMessage" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="200" resizeable="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.bulletinExiste}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.bulletinExiste}" var="msg">
            <f:facet name="header"><h:outputText value="Message..."/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanMessage" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerSuppresion}" styleClass="hidelink" reRender="modMessage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanMessage')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form >
                    <br>
                    <a4j:outputPanel><h:graphicImage width="50px" height="50px" value="/images/Warning.png"/></a4j:outputPanel>
                    <br><br>
                    <h:inputTextarea rows="3" value="Il existe des bulletins de salaire. La suppression est impossible..." style="width:100%" readonly="true"/>
                    <br><br>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelChangeMatricule" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="250" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelChangerMatricule}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelChangerMatricule}" var="trf">
            <f:facet name="header"><h:outputText value="Change Matricule"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerChangerMatricule}" image="/images/close.gif" styleClass="hidelink" reRender="panelChangeMatricule"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:panel  style="width:100%">
                    <h:panelGrid  columns="2" style="width:100%">
                        <h:column><h:outputText value="Nom et Prénom:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.patronyme}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Catégorie:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.lib_nature}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Matricule actuel:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMatricule}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Matricule:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nouveau_matricule}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.verificationUnicite}" reRender="idValideChangeMAtricule"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="idValideChangeMAtricule">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.validerChangerMatricule}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_unicite}" reRender="panelChangeMatricule,tableSalaries"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valQteGraph}" >
                                <f:selectItem itemLabel="En nombre d'agents" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modeGraph}">
                                <f:selectItem itemLabel="par genre" itemValue="0"/>
                                <f:selectItem itemLabel="par tranche d'age" itemValue="1"/>
                                <f:selectItem itemLabel="par servcice" itemValue="3"/>
                                <f:selectItem itemLabel="par fonction" itemValue="4"/>
                                <f:selectItem itemLabel="par type de contrat (nature)" itemValue="5"/>
                                <f:selectItem itemLabel="par mode de paiement" itemValue="6"/>
                                <f:selectItem itemLabel="par pays de résidence" itemValue="9"/>
                                <f:selectItem itemLabel="par nationnalité" itemValue="10"/>
                                <f:selectItem itemLabel="par feuille de calcul" itemValue="11"/>
                                <f:selectItem itemLabel="par clients interim" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}"/>
                                <f:selectItem itemLabel="par classement" itemValue="13"/>
                                <f:selectItem itemLabel="par niveau emploi" itemValue="14"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.timeDecoupage}">
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="global" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L'AGENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID salarié:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
