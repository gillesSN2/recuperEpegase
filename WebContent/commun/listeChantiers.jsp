<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeChantier">

    <a4j:form id="formModalListeChantier">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU CHANTIER/SERVICE"/></f:facet>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableDossier"/>
                <rich:extendedDataTable rows="200" id="tableDossier" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelDossier}" var="dos" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionChantier}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="ids34">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationChantiers}" reRender="idSubView,idDossier"/>
                    </c:if>
                    <rich:column label="Code" sortable="true" sortBy="#{dos.anaCode}" width="15%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{dos.anaCode}"/>
                    </rich:column>
                    <rich:column label="Libellé du dossier" sortable="true" sortBy="#{dos.anaNomFr}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                        <h:outputText value="#{dos.anaNomFr}"/>
                    </rich:column>
                    <rich:column label="Type" sortable="true" sortBy="#{dos.lib_dossier}" width="10%">
                        <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                        <h:outputText value="#{dos.lib_dossier}"/>
                    </rich:column>
                    <rich:column label="Devise" sortable="true" sortBy="#{dos.anaTypeDevise}" width="10%">
                        <f:facet name="header"><h:outputText  value="Devise" /></f:facet>
                        <h:outputText value="#{dos.anaTypeDevise}"/>
                    </rich:column>
                    <rich:column label="Année" sortable="true" sortBy="#{dos.anaAnnee}" width="10%">
                        <f:facet name="header"><h:outputText  value="Année" /></f:facet>
                        <h:outputText value="#{dos.anaAnnee}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="id34">
                        <a4j:commandButton id="idCanTiers34" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annuleChantiers}" reRender="idSubView,idDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers34" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationChantiers}" reRender="idSubView,idDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectChantier}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>