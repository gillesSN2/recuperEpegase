<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h:panelGrid style="width:100%;" id="panMesCpngesPayes">

    <a4j:form>

        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay==2}">
            <center><h2><h:outputText value="MES CONGES PAYES (#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPatronyme})" style="color:green;" /></h2></center>
        </h:column>

        <h:panelGrid id="panConges" width="100%">
            <jsp:include flush="true" page="/paye/CongesPayesCommun.jsp"/>
            <h:panelGrid width="100%" columns="8" styleClass="fichefournisseur">
                <h:column><h:outputText value="Nb jour Initial:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbInit}"/></h:column>
                <h:column><h:outputText value="Nb jour Acquis:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbAcquis}"/></h:column>
                <h:column><h:outputText value="Nb jour Pris:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbPris}"/></h:column>
                <h:column><h:outputText value="Nb jour Restant:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbRestant}"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="250px" id="panelBoutonConges2" columns="5"  style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                <a4j:commandButton title="Ajouter une nouvelle demande de congé" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.ajouterDemandeConges}" reRender="panelDemandeConges"/>
                <a4j:commandButton title="Supprimer le congé sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_conges&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.supprimerConges}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonConges2,tableConges"/>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable border="0" enableContextMenu="false" id="tableConges" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.dataModelConges}" var="cp">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.selectionConges}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonConges,panelBoutonConges2"/>
                    <rich:column label="Nature du congé" sortable="true" width="20%" sortOrder="#{cp.lib_nature}">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{cp.lib_nature}"/>
                    </rich:column>
                    <rich:column label="Etat du congé" sortable="true" width="10%" sortOrder="#{cp.salgrhEtat}">
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:outputText value="#{cp.libelleEtat}" id="idEtatConge"/>
                    </rich:column>
                    <rich:column label="Date départ en congé" sortable="true" width="10%" sortOrder="#{cp.salcngDateDebut}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Départ" /></f:facet>
                        <h:outputText value="#{cp.salcngDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date retour de congé" sortable="true" width="10%" sortOrder="#{cp.salcngDateFin}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Retour" /></f:facet>
                        <h:outputText value="#{cp.salcngDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Durée" sortable="true" width="10%" sortOrder="#{cp.salcngDuree}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Durée" /></f:facet>
                        <h:outputText value="#{cp.salcngDuree}"/>
                    </rich:column>
                    <rich:column label="Description" sortable="true" width="20%" sortOrder="#{cp.salcngObjet}">
                        <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                        <h:outputText value="#{cp.salcngObjet}"/>
                    </rich:column>
                    <rich:column label="Nature" sortable="true" width="20%" sortOrder="#{cp.lib_nature}">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{cp.lib_nature}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelDemandeConges" width="800" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelDemandeConges}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelDemandeConges}" var="gcp">
            <f:facet name="header"><h:outputText value="DEMANDE DE CONGES PAYES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanConges" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.annulerElementCp}" styleClass="hidelink" reRender="panelDemandeConges"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanConges')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panConges">
                    <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Nature des Congés:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <f:selectItem itemLabel="Demande de Congés" itemValue="0" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" id="idConges" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Date départ:"/></h:column>
                        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                        <h:column><h:outputText value="Date retour:"/></h:column>
                        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                        <h:column><h:outputText value="Lieu congés:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                    </h:panelGrid>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValConges" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.saveConges}" reRender="panelBoutonConges2,tableConges,panelDemandeConges"/>
                        </center>
                        <rich:hotKey key="return"  handler="#{rich:element('idValConges')}.click()" />
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</h:panelGrid>

