<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeActivites">

    <a4j:form id="formModalListeActivites">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DE L'ACTIVITE"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableActivite"/>
                <rich:extendedDataTable rows="200" id="tableActivite" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelActivites}" var="act" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionActivite}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="ids34">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationActivites}" reRender="idSubView,idActivite"/>
                    </c:if>
                    <rich:column label="Code" sortable="true" sortBy="#{act.actCode}" width="15%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{act.actCode}"/>
                    </rich:column>
                    <rich:column label="Libellé du l'activité" sortable="true" sortBy="#{act.actNomFr}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                        <h:outputText value="#{act.actNomFr}"/>
                    </rich:column>
                    <rich:column label="Option activité" sortable="true" sortBy="#{act.libOptions}" width="30%">
                        <f:facet name="header"><h:outputText  value="Option" /></f:facet>
                        <h:outputText value="#{act.libOptions}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="id34">
                        <a4j:commandButton id="idCanTiers34" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annuleActivites}" reRender="idSubView,idActivite"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers34" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationActivites}" reRender="idSubView,idActivite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectActivites}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==535}" var="id535">
                        <a4j:commandButton id="idCanTiers535" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.annuleActivite}" reRender="idSubView,idActivite"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers535" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recuperationActivite}" reRender="idSubView,idActivite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectActivites}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>