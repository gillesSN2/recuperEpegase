<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="organisationproduction">

    <a4j:form id="orgprd">

        <center> <h2><h:outputText value="ORGANISATION PRODUCTION" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" columnClasses="clos33g,clos33g,clos33g" columns="3">

            <h:panelGrid id="idPanSite" width="100%">
                <h:panelGrid id="boutonSite" width="200px" columnClasses="top" columns="4" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout site" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.ajouterSite}" reRender="modalPanelSite"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Site" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.modifierSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.site.sitId!=0}" reRender="modalPanelSite"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Modification Site" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.supprimerSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.site.sitId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.dataModelProductionLigne.rowCount==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.dataModelDepartementigne.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonSite,tableSite"/>
                    <a4j:commandButton image="/images/print.png" title="Imprimer l'organisation Production" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                </h:panelGrid>
                <h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  id="tableSite" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="300px" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.dataModelSite}" var="sit">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSite,idPanProductionLigne,idPanProductionAtelier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.selectionSite}"/>
                            <rich:column sortable="true" sortBy="#{sit.sitCode}" width="30%" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{sit.sitCode}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{sit.sitNomFr}" width="70%">
                                <f:facet name="header"><h:outputText value="Nom Site"/></f:facet>
                                <h:outputText value="#{sit.sitNomFr}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="idPanProductionLigne" width="100%">
                <h:panelGrid  id="boutonProductionLigne" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.ajouterProductionLigne}" reRender="modalPanelProductionLigne"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.modifierProductionLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionLigne.ligId!=0}" reRender="modalPanelProductionLigne"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.supprimerProductionLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionLigne.ligId!=0&& bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.dataModelProductionAtelier.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonSite,boutonProductionLigne,tableProductionLigne"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableProductionLigne" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="300px" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.dataModelProductionLigne}" var="lig"  >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonProductionLigne,idPanProductionAtelier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.selectionProductionLigne}"/>
                        <rich:column sortable="true" sortBy="#{lig.ligCode}" width="30%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText  value="#{lig.ligCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{lig.ligNomFr}" width="70%">
                            <f:facet name="header"><h:outputText value="Nom Ligne"/></f:facet>
                            <h:outputText  value="#{lig.ligNomFr}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="idPanProductionAtelier" width="100%">
                <h:panelGrid id="boutonProductionAtelier" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Atelier"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.ajouterProductionAtelier}" reRender="modalPanelProductionAtelier"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Atelier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.modifierProductionAtelier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionAtelier.ateId!=0}" reRender="modalPanelProductionAtelier"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Atelier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.supprimerProductionAtelier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionAtelier.ateId!=0}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonProductionLigne,boutonProductionAtelier,tableProductionAtelier"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableProductionAtelier" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="300px" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.dataModelProductionAtelier}" var="ate"   >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonProductionAtelier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.selectionProductionAtelier}"/>
                        <rich:column sortable="true" sortBy="#{ate.ateCode}" width="30%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{ate.ateCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{ate.ateNomFr}" width="70%">
                            <f:facet name="header"><h:outputText value="Nom Atelier"/></f:facet>
                            <h:outputText value="#{ate.ateNomFr}"/>
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


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelSite" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.showmodelPanelSite}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="380" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des sites"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.annulerSite}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelSite"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.site.sitCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.site.sitId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelSite,idSiteExiste,valideSite" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.verifierCodeSite}"/>
                        </h:inputText>
                        <h:outputText id="idSiteExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.site.sitNomFr}" size="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.var_site_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideSite" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.validerSite}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelProductionLigne" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.showmodelPanelProductionLigne}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="380" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des lignes de production"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.annulerProductionLigne}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelProductionLigne"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionLigne.ligCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionLigne.ligId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelProductionLigne,idProductionLigneExiste,valideProductionLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.verifierCodeProductionLigne}"/>
                        </h:inputText>
                        <h:outputText id="idProductionLigneExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionLigne.ligNomFr}" size="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.var_productionLigne_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideProductionLigne" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.validerProductionLigne}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelProductionAtelier" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.showmodelPanelProductionAtelier}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="380" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des ateliers de production"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.annulerProductionAtelier}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelProductionAtelier"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionAtelier.ateCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionAtelier.ateId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelProductionAtelier,idProductionAtelierExiste,valideProductionAtelier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.verifierCodeProductionAtelier}"/>
                        </h:inputText>
                        <h:outputText id="idProductionAtelierExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.productionAtelier.ateNomFr}" size="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.var_productionAtelier_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideProductionAtelier" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.validerProductionAtelier}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationProduction.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
