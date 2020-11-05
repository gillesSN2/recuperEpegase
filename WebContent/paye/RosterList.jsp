<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeroster">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DU ROSTER" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panelRecherche" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}"/>
                    <h:column><h:outputText value="Immat.:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_immat_rec}" style="width:100px"/></h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nom_rec}" style="width:100px"/></h:column>
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
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_pays_rec}">
                            <f:selectItem itemLabel="Tous Pays" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesPaysUtilItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_service}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_service_rec}">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_activite_rec}">
                            <f:selectItem itemLabel="Tous domaines expertises" itemValue="100"/>
                            <f:selectItem itemLabel="Communications" itemValue="1"/>
                            <f:selectItem itemLabel="Democratic Governance" itemValue="2"/>
                            <f:selectItem itemLabel="Disaster Risk Reduction" itemValue="3"/>
                            <f:selectItem itemLabel="EVAW/GBV" itemValue="4"/>
                            <f:selectItem itemLabel="Extractives" itemValue="5"/>
                            <f:selectItem itemLabel="Facilitation/Moderation" itemValue="6"/>
                            <f:selectItem itemLabel="Gender & Development" itemValue="7"/>
                            <f:selectItem itemLabel="Gender Responsive Budgeting" itemValue="8"/>
                            <f:selectItem itemLabel="Governance & Leadership" itemValue="9"/>
                            <f:selectItem itemLabel="Graphics" itemValue="10"/>
                            <f:selectItem itemLabel="HIV/AIDS" itemValue="11"/>
                            <f:selectItem itemLabel="Human Rights" itemValue="12"/>
                            <f:selectItem itemLabel="Humanitarian" itemValue="13"/>
                            <f:selectItem itemLabel="ICT" itemValue="14"/>
                            <f:selectItem itemLabel="Knowledge Management" itemValue="15"/>
                            <f:selectItem itemLabel="Monitoring & Evaluation" itemValue="16"/>
                            <f:selectItem itemLabel="Nutrition  specialist" itemValue="17"/>
                            <f:selectItem itemLabel="Operations" itemValue="18"/>
                            <f:selectItem itemLabel="Organizational Development" itemValue="19"/>
                            <f:selectItem itemLabel="Peace & Security" itemValue="20"/>
                            <f:selectItem itemLabel="Programme Management" itemValue="21"/>
                            <f:selectItem itemLabel="Rapporteur" itemValue="22"/>
                            <f:selectItem itemLabel="Resource Mobilization" itemValue="23"/>
                            <f:selectItem itemLabel="Rule of law and gender" itemValue="24"/>
                            <f:selectItem itemLabel="Strategic planning" itemValue="25"/>
                            <f:selectItem itemLabel="Translator/Interpreter" itemValue="26"/>
                            <f:selectItem itemLabel="Women Economic Empowerment" itemValue="27"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercherRoster}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panSuite" columns="12" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_more_search}">

                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonSalaries" columns="7" width="300px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouvel agent" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier l'agent sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'agent sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer l'agent sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerSalaries}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.initGrapheur}"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.pageIndex}" reRender="tableSalaries" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="120%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.datamodelSalaries}" var="salaries" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.simpleSelectionEnteteSal}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.extDTableSal}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionSalaries}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visualisationSalaries}" reRender="idSubView,boutonSalaries"/>
                <rich:column label="Matricule agent" sortable="true" width="100px" sortBy="#{salaries.salMatricule}">
                    <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                    <h:outputText value="#{salaries.salMatricule}"/>
                </rich:column>
                <rich:column label="Nature agent" sortable="true" width="120px" sortBy="#{salaries.lib_nature}">
                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                    <h:outputText value="#{salaries.lib_nature}"/>
                </rich:column>
                <rich:column label="Etat" sortable="true" width="60px" sortBy="#{salaries.lib_etat}">
                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                    <h:outputText value="#{salaries.lib_etat}"/>
                </rich:column>
                <rich:column label="Nom et prénom" sortable="true" width="300px" sortBy="#{salaries.salNom}  #{salaries.salPrenom}">
                    <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                    <h:outputText value="#{salaries.salNom}  #{salaries.salPrenom}"/>
                </rich:column>
                <rich:column label="Genre : Homme ou femme" sortable="true" width="60px" sortBy="#{salaries.lib_genre}">
                    <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                    <h:outputText value="#{salaries.lib_genre}"/>
                </rich:column>
                <rich:column label="Situation de famille" sortable="true" width="60px" sortBy="#{salaries.lib_sitfamille}">
                    <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                    <h:outputText value="#{salaries.lib_sitfamille}"/>
                </rich:column>
                <rich:column label="Pays de résidence" sortable="true" width="120px" sortBy="#{salaries.salNompays}">
                    <f:facet name="header"><h:outputText  value="Pays" /></f:facet>
                    <h:outputText value="#{salaries.salNompays}"/>
                </rich:column>
                <rich:column label="Service" sortable="true" width="120px" sortBy="#{salaries.salService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_service}">
                    <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                    <h:outputText value="#{salaries.salService}"/>
                </rich:column>
                <rich:column label="Domaine expertise" sortable="true" width="300px" sortBy="#{salaries.libActivite}">
                    <f:facet name="header"><h:outputText  value="Domaine expertise" /></f:facet>
                    <h:outputText value="#{salaries.libActivite}"/>
                </rich:column>
            </rich:extendedDataTable>
        </div>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationPaye.jsp"/>
        </c:if>
    </rich:modalPanel>
       
    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" sstyle="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelGraph}">
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
                                <f:selectItem itemLabel="par type de contrat" itemValue="5"/>
                                <f:selectItem itemLabel="par mode de paiement" itemValue="6"/>
                                <f:selectItem itemLabel="par activité" itemValue="7"/>
                                <f:selectItem itemLabel="par compétence" itemValue="8"/>
                                <f:selectItem itemLabel="par pays de résidence" itemValue="9"/>
                                <f:selectItem itemLabel="par nationnalité" itemValue="10"/>
                                <f:selectItem itemLabel="par feuille de calcul" itemValue="11"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.timeDecoupage}">
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

</f:subview>
