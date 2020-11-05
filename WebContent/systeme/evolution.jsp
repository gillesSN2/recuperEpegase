<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="evolution">

    <a4j:form id="evolution">
        <center>

            <center> <h2><h:outputText value="LISTE DES EVOLUTONS, DEBUGAGES et AMELIORATIONS" style="color:green;font-size:16px;"/></h2></center>

            <h:panelGroup id="butt">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une évolution" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.ajouterRubrique}" reRender="panelEvolution"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/modifier.png" title="Modifier l'évolution sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.afficheEvolution}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.modifierRubrique}" reRender="panelEvolution"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer l'évolution sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.afficheEvolution}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.supprimerRubrique}" reRender="butt,listeEvolution"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/transferer.png" title="Exporter la liste des évolutions" onclick="if (!confirm('Etes vous sur de vouloir exporter et mettre à jour le serveur epegase on-line?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.exporterEpegase}" reRender="modAttente,pboard,modMessageCommun"/>
            </h:panelGroup>

            <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller reRender="listeEvolution" id="scrollTableEvolution" maxPages="20"align="left" for="listeEvolution"/>
                    <rich:extendedDataTable rows="200" style="max-height:100%;" border="0" styleClass="bg" id="listeEvolution" width="100%" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.dataModelEvolution}" var="evo">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.selectionLigne}" reRender="butt"/>
                        <rich:column label="Version" width="8%" sortable="true" sortBy="#{evo.pegevoVersion}">
                            <f:facet name="header" ><h:outputText value="Version" /></f:facet>
                            <h:outputText value="#{evo.pegevoVersion}" title="#{evo.pegevoVersion}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{evo.pegevoDate}" width="8%" sortOrder="DESCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{evo.pegevoDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Type" width="10%" sortable="true" sortBy="#{evo.libelleType}">
                            <f:facet name="header" ><h:outputText value="Type" /></f:facet>
                            <h:outputText value="#{evo.libelleType}" title="#{evo.libelleType}"/>
                        </rich:column>
                        <rich:column label="Module" width="10%" sortable="true" sortBy="#{evo.pegevoModule}">
                            <f:facet name="header" ><h:outputText value="Module" /></f:facet>
                            <h:outputText value="#{evo.pegevoModule}" title="#{evo.pegevoModule}"/>
                        </rich:column>
                        <rich:column label="Ecran ou état" width="10%" sortable="true" sortBy="#{evo.pegevoModule}">
                            <f:facet name="header" ><h:outputText value="Ecran/Etat" /></f:facet>
                            <h:outputText value="#{evo.pegevoModele}" title="#{evo.pegevoModele}" rendered="#{evo.pegevoModele!=null}"/>
                            <h:outputText value="#{evo.pegevoEcran}" title="#{evo.pegevoEcran}" rendered="#{evo.pegevoEcran!=null}"/>
                        </rich:column>
                        <rich:column label="Objet" width="34%" sortable="true" sortBy="#{evo.pegevoObject}">
                            <f:facet name="header" ><h:outputText value="Objet" /></f:facet>
                            <h:inputTextarea rows="3" value="#{evo.pegevoObject}" title="#{evo.pegevoObject}" readonly="true" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Détail ou Statut" width="20%" sortable="true" sortBy="#{evo.pegevoDetail}">
                            <f:facet name="header" ><h:outputText value="Détail/Statut" /></f:facet>
                            <h:inputTextarea rows="3" value="#{evo.pegevoDetail}" title="#{evo.pegevoDetail}" readonly="true" style="width:100%"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelEvolution" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.showModalPanelEvolution}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.showModalPanelEvolution}" var="rub">
            <f:facet name="header"><h:outputText value="Gestion des rubriques"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.annulerRubrique}" image="/images/close.gif" styleClass="hidelink" reRender="panelEvolution"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionRubrique" style="width:100%;">
                    <h:panelGrid id="panDescription" columns="2" columnClasses="clos20,clos80" style="width:100%;">
                        <h:column><h:outputText value="Version:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoVersion}"/></h:column>
                        <h:column><h:outputText value="Date compilation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="Type:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoType}" style="width:100%;">
                                <f:selectItem itemLabel="Nouvelle fonction" itemValue="0"/>
                                <f:selectItem itemLabel="Modification fonction" itemValue="1"/>
                                <f:selectItem itemLabel="Correction fonction" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Module concerné:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoModule}" style="width:100%;">
                                <f:selectItem itemLabel="Sélectionnez le module" itemValue=""/>
                                <f:selectItem itemLabel="Acceuil" itemValue="ACCEUIL"/>
                                <f:selectItem itemLabel="Achats" itemValue="ACHATS"/>
                                <f:selectItem itemLabel="Administration" itemValue="ADMINISTRATION"/>
                                <f:selectItem itemLabel="Androide" itemValue="ANDROIDE"/>
                                <f:selectItem itemLabel="Cabinet" itemValue="CABINET"/>
                                <f:selectItem itemLabel="Comptabilité" itemValue="COMPTA"/>
                                <f:selectItem itemLabel="Education" itemValue="EDUCATION"/>
                                <f:selectItem itemLabel="Exploitation" itemValue="EXPLOITATION"/>
                                <f:selectItem itemLabel="Fondation" itemValue="FONDATION"/>
                                <f:selectItem itemLabel="Forêt" itemValue="FORET"/>
                                <f:selectItem itemLabel="Guest" itemValue="GUEST"/>
                                <f:selectItem itemLabel="HelpDesk" itemValue="HELP-DESK"/>
                                <f:selectItem itemLabel="HighCharts" itemValue="HIGH-CHARTS"/>
                                <f:selectItem itemLabel="Immobilier" itemValue="IMMOBILIER"/>
                                <f:selectItem itemLabel="Interim" itemValue="INTERIM"/>
                                <f:selectItem itemLabel="Live-Chat" itemValue="LIVE-CHAT"/>
                                <f:selectItem itemLabel="Médical" itemValue="MEDICAL"/>
                                <f:selectItem itemLabel="Micro-finance" itemValue="MICRO-FINANCE"/>
                                <f:selectItem itemLabel="Office" itemValue="OFFICE"/>
                                <f:selectItem itemLabel="Parc" itemValue="PARC"/>
                                <f:selectItem itemLabel="Paye" itemValue="PAYE"/>
                                <f:selectItem itemLabel="Polit-bureau" itemValue="POLIT-BUREAU"/>
                                <f:selectItem itemLabel="Projets" itemValue="PROJETS"/>
                                <f:selectItem itemLabel="Production" itemValue="PRODUCTION"/>
                                <f:selectItem itemLabel="Reporting" itemValue="REPORTING"/>
                                <f:selectItem itemLabel="Responsive-Voice" itemValue="RESPONSIVE-VOICE"/>
                                <f:selectItem itemLabel="Script" itemValue="SCRIPT"/>
                                <f:selectItem itemLabel="Stock" itemValue="STOCK"/>
                                <f:selectItem itemLabel="Système" itemValue="SYSTEME"/>
                                <f:selectItem itemLabel="Temples" itemValue="TEMPLE"/>
                                <f:selectItem itemLabel="Temps" itemValue="TEMPS"/>
                                <f:selectItem itemLabel="Transit/Transport" itemValue="TRANSIT/TRANSPORT"/>
                                <f:selectItem itemLabel="Trésorerie" itemValue="TRESORERIE"/>
                                <f:selectItem itemLabel="Tiers" itemValue="TIERS"/>
                                <f:selectItem itemLabel="Update" itemValue="UPDATE"/>
                                <f:selectItem itemLabel="Utilitaires" itemValue="UTILITAIRES"/>
                                <f:selectItem itemLabel="Ventes" itemValue="VENTES"/>
                                <f:selectItem itemLabel="WebTwain" itemValue="WEBTWAIN"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Ecran/Etat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoEcran}"/></h:column>
                        <h:column><h:outputText value="Développeur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoNomDeveloppeur}"/></h:column>
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoObject}"/></h:column>
                        <h:column><h:outputText value="Détail/Statut:"/></h:column>
                        <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegEvolution.pegevoDetail}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttonValid">
                        <a4j:commandButton title="Valider"style="margin-top:10px;" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.validerRubrique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEvolution,listeEvolution,scrollTableEvolution"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>