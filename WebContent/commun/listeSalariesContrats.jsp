<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeSalariesContrat">

    <a4j:form id="formModalListeSalariesContrat">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU SALARIE"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                <rich:extendedDataTable rows="200" id="tableSalaries" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelSalariesContrats}" var="scrt" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionSalarieContrat}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==820}" var="ids820">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.recuperationSalarieContrat}" reRender="idSubView,idSalarie,idRecherche"/>
                    </c:if>
                    <rich:column label="Type de Contrat" sortable="true" sortBy="#{scrt.salconNum}" width="10%">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{scrt.salconType}"/>
                    </rich:column>
                    <rich:column label="N° de Contrat" sortable="true" sortBy="#{scrt.salconNum}" width="10%">
                        <f:facet name="header"><h:outputText  value="N° contrat" /></f:facet>
                        <h:outputText value="#{scrt.salconNum}"/>
                    </rich:column>
                    <rich:column label="Matricule" sortable="true" sortBy="#{scrt.salaries.salMatricule}" width="10%">
                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                        <h:outputText value="#{scrt.salaries.salMatricule}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{scrt.salaries.salCivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{scrt.salaries.salCivilite}"/>
                    </rich:column>
                    <rich:column label="Nom et prénom" sortable="true" sortBy="#{scrt.salaries.salNom}" width="30%">
                        <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                        <h:outputText value="#{scrt.salaries.salNom} #{scrt.salaries.salPrenom}"/>
                    </rich:column>
                    <rich:column label="Service" sortable="true" sortBy="#{scrt.salaries.salService}" width="15%">
                        <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                        <h:outputText value="#{scrt.salaries.salService}"/>
                    </rich:column>
                    <rich:column label="Activite" sortable="true" sortBy="#{scrt.salaries.salActivite}" width="15%">
                        <f:facet name="header"><h:outputText  value="Activite" /></f:facet>
                        <h:outputText value="#{scrt.salaries.salActivite}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==820}" var="id820">
                        <a4j:commandButton id="idCanTiers810" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.annuleSalarieContrat}" reRender="idSubView,idSalarie,idRecherche"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers810" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.recuperationSalarieContrat}" reRender="idSubView,idSalarie,idRecherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalariesContrat}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>