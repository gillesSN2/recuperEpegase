<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="organisationadmin">

    <a4j:form id="orgadmin">

        <center> <h2><h:outputText value="ORGANISATION ADMINISTRATIVE" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" columnClasses="clos33g,clos33g,clos33g" columns="3">

            <h:panelGrid id="idPanSite" width="100%">
                <h:panelGrid id="boutonSite" width="200px" columnClasses="top" columns="4" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout site" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.ajouterSite}" reRender="modalPanelSite"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification site" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.modifierSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.site.sitId!=0}" reRender="modalPanelSite"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Modification site" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.supprimerSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.site.sitId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.dataModelDepartement.rowCount==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.dataModelProductionLigne.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonSite,tableSite"/>
                    <a4j:commandButton image="/images/print.png" title="Imprimer l'organisation Administrative" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                </h:panelGrid>
                <h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  id="tableSite" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="400px" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.dataModelSite}" var="sit">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSite,idPanDepartement,idPanService" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.selectionSite}"/>
                            <rich:column sortable="true" sortBy="#{sit.sitCode}" width="20%" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{sit.sitCode}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{sit.sitNomFr}" width="40%">
                                <f:facet name="header"><h:outputText value="Nom Site"/></f:facet>
                                <h:outputText value="#{sit.sitNomFr}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{sit.sitNomResponsable}" width="40%">
                                <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                                <h:outputText value="#{sit.sitNomResponsable}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="idPanDepartement" width="100%">
                <h:panelGrid  id="boutonDepartement" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Département" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.ajouterDepartement}" reRender="modalPanelDepartement"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Département" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.modifierDepartement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.departement.depId!=0}" reRender="modalPanelDepartement"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Département" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.supprimerDepartement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.departement.depId!=0&& bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.dataModelService.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonSite,boutonDepartement,tableDepartement"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDepartement" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="400px" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.dataModelDepartement}" var="dep"  >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  immediate="true"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonDepartement,idPanService" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.selectionDepartement}"/>
                        <rich:column sortable="true" sortBy="#{dep.depCode}" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText  value="#{dep.depCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{dep.depNomFr}" width="40%">
                            <f:facet name="header"><h:outputText value="Nom Département"/></f:facet>
                            <h:outputText  value="#{dep.depNomFr}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{dep.depNomResponsable}" width="40%">
                            <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{dep.depNomResponsable}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="idPanService" width="100%">
                <h:panelGrid id="boutonService" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout service"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.ajouterService}" reRender="modalPanelService"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification service" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.modifierService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.service.serId!=0}" reRender="modalPanelService"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression service" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.supprimerService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.service.serId!=0}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonDepartement,boutonService,tableService"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableService" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="400px" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.dataModelService}" var="ser"   >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonService" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.selectionService}"/>
                        <rich:column sortable="true" sortBy="#{ser.serCode}" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{ser.serCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{ser.serNomFr}" width="40%">
                            <f:facet name="header"><h:outputText value="Nom Service"/></f:facet>
                            <h:outputText value="#{ser.serNomFr}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{ser.serNomResponsable}" width="40%">
                            <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{ser.serNomResponsable}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

        </h:panelGrid>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdminstrationGenerale}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelSite" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.showmodelPanelSite}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des sites"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.annulerSite}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelSite"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.site.sitCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.site.sitId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelSite,idSiteExiste,valideSite" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.verifierCodeSite}"/>
                        </h:inputText>
                        <h:outputText id="idSiteExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.site.sitNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.site.sitIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.var_site_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideSite" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.validerSite}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelDepartement" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.showmodelPanelDepartement}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des départements"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.annulerDepartement}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelDepartement"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.departement.depCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.departement.depId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelDepartement,idDepartementExiste,valideDepartement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.verifierCodeDepartement}"/>
                        </h:inputText>
                        <h:outputText id="idDepartementExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.departement.depNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.departement.depIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.var_departement_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideDepartement" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.validerDepartement}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelService" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.showmodelPanelService}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des services"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.annulerService}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelService"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.service.serCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.service.serId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelService,idServiceExiste,valideService" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.verifierCodeService}"/>
                        </h:inputText>
                        <h:outputText id="idServiceExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.service.serNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.service.serIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.var_service_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideService" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.validerService}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationAdministrative.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
