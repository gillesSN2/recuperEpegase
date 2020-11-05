<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeSommier">

    <a4j:form id="formModalListeSommier">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU SOMMIER"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableDossier"/>
                <rich:extendedDataTable rows="200" id="tableDossier" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelSommiers}" var="som" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionSommiers}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==33}" var="ids33">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.recuperationSommiers}" reRender="idSubView,idSommier"/>
                    </c:if>
                    <rich:column label="N° sommier" sortable="true" sortBy="#{som.somNum}" width="20%">
                        <f:facet name="header"><h:outputText  value="N° sommier" /></f:facet>
                        <h:outputText value="#{som.somNum}"/>
                    </rich:column>
                    <rich:column label="N° réception" sortable="true" sortBy="#{som.somReception}" width="20%">
                        <f:facet name="header"><h:outputText  value="N° réception" /></f:facet>
                        <h:outputText value="#{som.somReception}"/>
                    </rich:column>
                    <rich:column label="N° dossier transit" sortable="true" sortBy="#{som.somDossierTransit}" width="20%">
                        <f:facet name="header"><h:outputText  value="Dossier transit" /></f:facet>
                        <h:outputText value="#{som.somDossierTransit}"/>
                    </rich:column>
                    <rich:column label="Date d'expiration" sortable="true" sortBy="#{som.somDateExpiration}" width="20%">
                        <f:facet name="header"><h:outputText  value="Expiration" /></f:facet>
                        <h:outputText value="#{som.somDateExpiration}"/>
                    </rich:column>
                    <rich:column label="Responsable" sortable="true" sortBy="#{som.somNomResponsable}" width="20%">
                        <f:facet name="header"><h:outputText  value="Responsable" /></f:facet>
                        <h:outputText value="#{som.somNomResponsable}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==33}" var="id33">
                        <a4j:commandButton id="idCanTiers33" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.annuleSommiers}" reRender="idSubView,idSommier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers33" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.recuperationSommiers}" reRender="idSubView,idSommier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSommier}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>