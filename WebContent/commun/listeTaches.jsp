<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeTaches">

    <a4j:form id="formModalListeTaches">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DE LA TACHE"/></f:facet>
        </h:panelGrid>
        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableTaches"/>
                <rich:extendedDataTable rows="200" id="tableTaches" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="130%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelTaches}" var="ta" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue"  event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionTaches}" reRender="idVal,idAjout"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="ids34">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationTaches}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <rich:column style="text-align:left;" width="10%">
                        <f:facet name="header"><h:outputText  value="Code tache"/></f:facet>
                        <h:outputText  value="#{ta.procesligCode}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="40%">
                        <f:facet name="header"><h:outputText  value="Libellé tache"/></f:facet>
                        <h:outputText  value="#{ta.procesligLibClient}"/>
                    </rich:column>
                    <rich:column style="text-align:right;" width="10%">
                        <f:facet name="header"><h:outputText  value="P.R. HT"/></f:facet>
                        <h:outputText  value="#{ta.procesligPrht}" rendered="#{ta.procesligPrht!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="10%">
                        <f:facet name="header"><h:outputText  value="P.V. HT"/></f:facet>
                        <h:outputText  value="#{ta.procesligPvht}" rendered="#{ta.procesligPvht!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="JJ"/></f:facet>
                        <h:outputText  value="#{ta.procesligJj}" rendered="#{ta.procesligJj!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="HH"/></f:facet>
                        <h:outputText  value="#{ta.procesligHh}" rendered="#{ta.procesligHh!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="MM"/></f:facet>
                        <h:outputText  value="#{ta.procesligMm}" rendered="#{ta.procesligMm!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="SS"/></f:facet>
                        <h:outputText  value="#{ta.procesligSs}" rendered="#{ta.procesligSs!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="id34">
                    <a4j:commandButton id="idCanTache34" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annuleTaches}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTache34" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationTaches}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTaches}"/>
                </c:if>
            </center>
        </h:panelGroup>
    </a4j:form>

</f:subview>