
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="sourcestiers">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES SOURCES D'ORIGINES DES TIERS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="btnSource" width="200px" columns="4">
                <a4j:commandButton image="/images/ajouter.png" title="Ajout nouvelle source" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.ajouterSource}" reRender="panelSources"/>
                <a4j:commandButton image="/images/modifier.png" title="Modification source sélectionée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.afficherSource}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.modifierSource}" reRender="panelSources"/>
                <a4j:commandButton image="/images/supprimer.png" title="Suppression source" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.afficherSource}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.suprimerSource}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,tableSource,btnSource"/>
                <a4j:commandButton image="/images/print.png" title="Impression des sources" style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br/>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable headerClass="headerTab" id="tableSource" border="0" rowClasses="rows1,rows2,rowsd" width="100%" align="center" style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.dataModelSourcesTiers}"  var="sources" >
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.selectionSource}" reRender="btnSource"/>
                <rich:column width="80%" sortable="false">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{sources.nom_FR}"/>
                </rich:column>
                <rich:column width="20%" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Coefficient" /></f:facet>
                    <h:outputText  value="#{sources.centreId}"  style="text-align:right;" rendered="#{sources.centreId!=0}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelSources" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.showModalPanelsource}" width="400" height="200">
        <f:facet name="header"><h:outputText style="font-weight:bold;font-size:12px;"value="GESTION DES SOURCES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.fermerSource}" image="/images/close.gif" styleClass="hidelink" reRender="panelSources,btnSource"/>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form id="formfmtSource" style="width:100%;">
                <h:panelGrid columns="2" id="idPanel">
                    <h:column><h:outputText value="Nom source:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.objetCompte.nom_FR}"/></h:column>
                    <h:column><h:outputText value="Coefficient:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.objetCompte.centreId}"/></h:column>
                </h:panelGrid>
                <center>
                    <br>
                    <h:column>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSourcesTiers.validerSource}" reRender="panelSources,tableSource,btnSource"/>
                    </h:column>
                </center>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
