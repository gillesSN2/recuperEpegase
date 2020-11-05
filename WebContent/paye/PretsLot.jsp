<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheslotpret">

    <a4j:form>

        <center> <h2><h:outputText value="PRETS PAR LOT : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_lib_pret}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">
            <h:panelGrid id="tabPanelsalaries" width="100%">
                <h:panelGrid style="width:100%;" id="panConges">
                    <h:panelGrid columns="4" id="idConges" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<29}">
                        <h:column><h:outputText value="Nature du prêt:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.naturePret}">
                                <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                                <f:selectItem itemLabel="Avances exceptionnelles" itemValue="1"/>
                                <f:selectItem itemLabel="Soins Médicaux" itemValue="2"/>
                                <f:selectItem itemLabel="Cessions" itemValue="3"/>
                                <f:selectItem itemLabel="Traites" itemValue="4"/>
                                <f:selectItem itemLabel="Familiaux" itemValue="5" />
                                <f:selectItem itemLabel="Religieux" itemValue="6" />
                                <f:selectItem itemLabel="Avances étalées" itemValue="7" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date début Rmb. (JJ/MM/AAAA):"/></h:column>
                        <h:column>
                            <rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dateDebutPret}" popup="true">
                                <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.calculDureeCalculee}"/>
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Montant:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.montantPret}" size="5" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nombre échéance:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.nbEcheancePret}" size="5" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.observation}"/></h:column>
                        <h:column><h:outputText value="Responsable:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.responsable}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                    <h:panelGrid columns="11" width="100%">
                        <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_more_search}"/>
                        <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_more_search}"/>
                        <h:column>
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_nature_rec}">
                                <f:selectItem itemLabel="Toutes Natures agents" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesNatureAgentItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_feuille_rec}">
                                <f:selectItem itemLabel="Toutes Feuilles" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesFeuillesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.accesInterim}">
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_tiers_rec}">
                                <f:selectItem itemLabel="Tous tiers" itemValue="100"/>
                                <f:selectItem itemLabel="Sans tiers" itemValue="101"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesTiersItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_service_rec}">
                                <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesServiceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_activite_rec}">
                                <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesActiviteItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.rechercherSalarie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,scrollTable,tableSalaries"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panSuite" columns="7" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_more_search}">
                        <h:column>
                            <h:selectOneMenu id="conv" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_convention_rec}">
                                <f:selectItem itemLabel="Toutes Conventions" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesConventionsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="grille" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_grille_rec}">
                                <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesGrillesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="sit" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_site_rec}">
                                <f:selectItem itemLabel="Tous Sites" itemValue="100"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="dep" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_departement_rec}">
                                <f:selectItem itemLabel="Tous Départements" itemValue="100"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="niveau" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_niveau_rec}">
                                <f:selectItem itemLabel="Tous Niveaux" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesNiveauxEmploisItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="classement" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_classement_rec}">
                                <f:selectItem itemLabel="Tous Classements" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesClassementsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="centre" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_centre_rec}">
                                <f:selectItem itemLabel="Tous Centres" itemValue="100"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesCentresImpotsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                    <rich:extendedDataTable rows="200" id="tableSalaries" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelLotPret}" var="sal">
                        <rich:column id="idSaisie" label="Saisie" sortable="true" width="5%" sortBy="#{sal.select_agent}">
                            <f:facet name="header"><h:outputText  value="Saisie"/></f:facet>
                            <h:selectBooleanCheckbox value="#{sal.select_agent}"/>
                        </rich:column>
                        <rich:column label="Matricule" sortable="true" sortBy="#{sal.salMatricule}" width="10%">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{sal.salMatricule}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{sal.salCivilite}" width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{sal.salCivilite}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{sal.salNom}" width="30%">
                            <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                            <h:outputText value="#{sal.salNom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{sal.salPrenom}" width="15%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{sal.salPrenom}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{sal.salService}" width="15%">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{sal.salService}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{sal.salActivite}" width="15%">
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText value="#{sal.salActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>

            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.toutSelectionner}" reRender="tableSalaries"/>&nbsp;&nbsp;
                    <a4j:commandButton value="Rien Sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.rienSelectionner}"reRender="tableSalaries"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.annulerLotPret}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.validerLotPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>
