<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listemissions">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES MISSIONS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panelRecherche" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="8" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_num_rec}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_type_rec}">
                            <f:selectItem itemLabel="Toutes les natures" itemValue="100"/>
                            <f:selectItem itemLabel="Formations" itemValue="0"/>
                            <f:selectItem itemLabel="Réunions" itemValue="1"/>
                            <f:selectItem itemLabel="Séminaires" itemValue="2"/>
                            <f:selectItem itemLabel="Terrains" itemValue="3"/>
                            <f:selectItem itemLabel="Visites" itemValue="4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_etat_rec}">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Approuvé" itemValue="1"/>
                            <f:selectItem itemLabel="En exécution" itemValue="2"/>
                            <f:selectItem itemLabel="Retour" itemValue="3"/>
                            <f:selectItem itemLabel="Cloture" itemValue="4"/>
                            <f:selectItem itemLabel="Annulé" itemValue="5"/>
                            <f:selectItem itemLabel="Gelé" itemValue="6"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_service_rec}">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_activite_rec}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesActiviteItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.rechercherMissions}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableMissions"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panSuite" columns="12" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_more_search}">
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonSalaries" columns="6" width="300px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouvelle Mission" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.ajouterMissions}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier la mission sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.modifierMissions}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter la mission sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.consulterMissions}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer la mission sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.supprimerMissions}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Informations sur la mission" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_bouton}" reRender="panelInformation"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.pageIndex}" reRender="tableMissions" id="scrollTable" maxPages="20"align="left" for="tableMissions"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_nb_max}" border="0" enableContextMenu="true" id="tableMissions" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="130%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.datamodelMissions}" var="mis" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.selectionMissions}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                <rich:column label="N° mission" sortable="true" width="70px" sortBy="#{mis.misNum}">
                    <f:facet name="header"><h:outputText  value="N° Mission" /></f:facet>
                    <h:outputText value="#{mis.misNum}"/>
                </rich:column>
                <rich:column label="Type" sortable="true" width="100px" sortBy="#{mis.lib_nature}">
                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                    <h:outputText value="#{mis.lib_nature}"/>
                </rich:column>
                <rich:column label="Etat" sortable="true" width="70px" sortBy="#{mis.lib_etat}">
                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                    <h:outputText value="#{mis.lib_etat}"/>
                </rich:column>
                <rich:column  label="Mode" sortable="true" width="100px" sortBy="#{mis.lib_mode}">
                    <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                    <h:outputText value="#{mis.lib_mode}"/>
                </rich:column>
                <rich:column  label="Pays" sortable="true" width="200px" sortBy="#{mis.misPays}">
                    <f:facet name="header"><h:outputText  value="Pays" /></f:facet>
                    <h:outputText value="#{mis.misPays}"/>
                </rich:column>
                <rich:column label="Date début" sortable="true" sortBy="#{mis.misDateDebut}" width="70px">
                    <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                    <h:outputText value="#{mis.misDateDebut}">
                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                    </h:outputText>
                </rich:column>
                <rich:column label="Date fin" sortable="true" sortBy="#{mis.misDateFin}" width="70px">
                    <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                    <h:outputText value="#{mis.misDateFin}">
                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                    </h:outputText>
                </rich:column>
                <rich:column  label="Objectif" sortable="true" width="300px" sortBy="#{mis.misObjectif}">
                    <f:facet name="header"><h:outputText  value="Objectif" /></f:facet>
                    <h:outputText value="#{mis.misObjectif}"/>
                </rich:column>
                <rich:column  label="Total Perdiem" sortable="true" width="90px" sortBy="#{mis.misTotalPerdiem}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Perdiem" /></f:facet>
                    <h:outputText value="#{mis.misTotalPerdiem}" style="text-align:right;" rendered="#{mis.misTotalPerdiem!=0}"/>
                </rich:column>
                <rich:column  label="Total visa" sortable="true" width="90px" sortBy="#{mis.misTotalVisa}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Visa" /></f:facet>
                    <h:outputText value="#{mis.misTotalVisa}" style="text-align:right;" rendered="#{mis.misTotalVisa!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column  label="Total transport" sortable="true" width="90px" sortBy="#{mis.misTotalTransport}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Transport" /></f:facet>
                    <h:outputText value="#{mis.misTotalTransport}" style="text-align:right;" rendered="#{mis.misTotalTransport!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column  label="Total hébergement" sortable="true" width="90px" sortBy="#{mis.misTotalHebergement}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Hébergement" /></f:facet>
                    <h:outputText value="#{mis.misTotalHebergement}" style="text-align:right;" rendered="#{mis.misTotalHebergement!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column  label="Total restauration" sortable="true" width="90px" sortBy="#{mis.misTotalRestauration}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Restauration" /></f:facet>
                    <h:outputText value="#{mis.misTotalRestauration}" style="text-align:right;" rendered="#{mis.misTotalRestauration!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column  label="Total Divers" sortable="true" width="90px" sortBy="#{mis.misTotalDivers}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Divers" /></f:facet>
                    <h:outputText value="#{mis.misTotalDivers}" style="text-align:right;" rendered="#{mis.misTotalDivers!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column  label="Cout Total" sortable="true" width="90px" sortBy="#{mis.misTotalCout}" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Total" /></f:facet>
                    <h:outputText value="#{mis.misTotalCout}" style="text-align:right;" rendered="#{mis.misTotalCout!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
            </rich:extendedDataTable>
        </div>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationPaye.jsp"/>
        </c:if>
    </rich:modalPanel>

   <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LA MISSION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID pointage:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misId}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
