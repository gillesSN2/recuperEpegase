<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeCheque">

    <a4j:form id="formModalListeCheque">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU CHEQUE"/></f:facet>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="listeCompte"/>
            <rich:extendedDataTable rows="200" id="listeCompte" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " enableContextMenu="true" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelReglements}" var="reg" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionCheque}" reRender="idVal,idAjout"/>
                 <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="ids60">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationCheque}" reRender="idSubView,idPan1"/>
                 </c:if>
                <rich:column  width="20%" sortable="true" sortBy="#{reg.rglNumChqBdx}">
                    <f:facet name="header"><h:outputText value="N° Chèque" /></f:facet>
                    <h:outputText value="#{reg.rglNumChqBdx}"/>
                </rich:column>
                <rich:column  width="20%"  sortable="true" sortBy="#{reg.rglBanqueTireur}">
                    <f:facet name="header"><h:outputText value="Banque" /></f:facet>
                    <h:outputText value="#{reg.rglBanqueTireur}" />
                </rich:column>
                <rich:column  width="10%" style="text-align:right;" sortable="true" sortBy="#{reg.rglRecette}">
                    <f:facet name="header"><h:outputText value="Montant" /></f:facet>
                    <h:outputText value="#{reg.rglRecette}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column  width="50%" sortable="true" sortBy="#{reg.rglNomTiers}">
                    <f:facet name="header"><h:outputText value="Nom client" /></f:facet>
                    <h:outputText value="#{reg.rglNomTiers}" />
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="id60">
                    <a4j:commandButton id="idCanObj60" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annuleCheque}" reRender="idSubView,idPan1"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj60" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationCheque}" reRender="idSubView,idPan1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectReglements}"/>
                </c:if>
            </center>
        </h:panelGroup>
    </a4j:form>

</f:subview>