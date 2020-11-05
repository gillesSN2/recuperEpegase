<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<h:panelGrid columns="5" id="pgrdacivite" styleClass="recherche"  width="100%" >
    <h:panelGroup>
        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une activité" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.ajoutActivite}" reRender="pgrdacivite"/>
    </h:panelGroup>
    <h:panelGroup id="pgDesign">
        <h:outputText styleClass="textAligneOutSimple" value="Désignation des activités"  /><br>
        <h:inputText maxlength="200" tabindex="1" size="36" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActivites.cplmenLibelle}" />
    </h:panelGroup>
    <h:panelGroup id="pgCodeDesign">
        <h:outputText styleClass="textAligneOutSimple" value="Code activités"  /><br>
        <h:inputText maxlength="200" tabindex="2" size="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActivites.cplmenCode}" />
    </h:panelGroup>
    <h:panelGroup id="pgChiffreAff">
        <h:outputText styleClass="textAligneOutSimple" value="Chiffre d'affaire"  /><br>
        <h:inputText maxlength="200" tabindex="3" size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActivites.cplmenTotal}" style="text-align:right"/>
    </h:panelGroup>
    <h:panelGroup id="pngMaj" >
        <a4j:commandButton tabindex="4" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.saveActivite}" reRender="tableActivites"/>
    </h:panelGroup>
</h:panelGrid>
<a4j:region renderRegionOnly="false">
    <rich:extendedDataTable id="tableActivites" height="400px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.datamodelactivites}" width="100%" border="0" var="activites">
        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionActivite}" reRender="pgrdacivite"/>
        <rich:column width="45%" sortable="false">
            <f:facet name="header" ><h:outputText value="Désignation des activités"/></f:facet>
            <h:outputText value="#{activites.cplmenLibelle}" />
        </rich:column >
        <rich:column width="20%" sortable="false" >
            <f:facet name="header" ><h:outputText value="Code activités"/></f:facet>
            <h:outputText value="#{activites.cplmenCode}"  />
        </rich:column >
        <rich:column width="20%" sortable="false" style="text-align:right;" >
            <f:facet name="header" ><h:outputText value="Chiffre d'affaire"/> </f:facet>
            <h:outputText value="#{activites.cplmenTotal}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
        </rich:column >
        <rich:column width="10%" sortable="false" style="text-align:right;">
            <f:facet name="header" ><h:outputText value="% répat."/></f:facet>
            <h:outputText value="#{activites.cplmenPourcentage}"  />
        </rich:column >
        <rich:column width="5%" style="text-align:center;">
            <a4j:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.supprimeActivite}" reRender="tableActivites,pgrdacivite"/>
        </rich:column>
    </rich:extendedDataTable>
</a4j:region>