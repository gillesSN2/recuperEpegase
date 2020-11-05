<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeBudgetTresorerie">

    <a4j:form id="formModalListeBudgetTresorerie">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU BUDGET DE TRESORERIE"/></f:facet>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="listeCompte"/>
            <rich:extendedDataTable rows="200" id="listeCompte" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelBudgetTresorerie}" var="cpte" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionBudgetTresorerie}" reRender="idVal"/>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}"  var="ids62">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationBudgetTresorerie}" reRender="idSubView,idBudgetTreso"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==533}" var="ids533">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.recuperationBudgetTresorerie}" reRender="idSubView,idBudgetTreso"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==534}" var="ids534">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.recuperationBudgetTresorerie}" reRender="idSubView,idBudgetTreso"/>
                </c:if>
                <rich:column  width="30%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.projetPresent}">
                    <f:facet name="header"><h:outputText value="Projet" /></f:facet>
                    <h:outputText value="#{cpte.treProjet}" style="#{cpte.espaceFamille}"/>
                </rich:column>
                <rich:column  width="20%" >
                    <f:facet name="header"><h:outputText value="Poste" /></f:facet>
                    <h:outputText value="#{cpte.treCode}" style="#{cpte.espaceFamille}"/>
                </rich:column>
                <rich:column  width="50%"  >
                    <f:facet name="header"><h:outputText value="Libellé du poste" /></f:facet>
                    <h:outputText value="#{cpte.treLibelleFr}" style="#{cpte.espaceFamille}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}"  var="id62">
                    <a4j:commandButton id="idCanObj62" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.annuleBudgetTresorerie}" reRender="idSubView,idBudgetTreso"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj62" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationBudgetTresorerie}" reRender="idSubView,idBudgetTreso" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectBudgetTresorerie}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==533}" var="id533">
                    <a4j:commandButton id="idCanObj533" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annuleBudgetTresorerie}" reRender="idSubView,idBudgetTreso"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj533" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.recuperationBudgetTresorerie}" reRender="idSubView,idBudgetTreso" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectBudgetTresorerie}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==534}" var="id534">
                    <a4j:commandButton id="idCanObj534" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.annuleBudgetTresorerie}" reRender="idSubView,idBudgetTreso"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj534" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.recuperationBudgetTresorerie}" reRender="idSubView,idBudgetTreso" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectBudgetTresorerie}"/>
                </c:if>
            </center>
        </h:panelGroup>
    </a4j:form>

</f:subview>