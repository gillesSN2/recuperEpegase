<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeParc">

    <a4j:form id="formModalListeParc">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU PARC"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                <rich:extendedDataTable rows="200" id="tableParc" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelParc}" var="prc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionParc}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="ids43">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==45}" var="ids45">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.recuperationParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==46}" var="ids46">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.recuperationParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="ids62">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationParc}" reRender="idSubView,idParc"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==63}" var="ids63">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.recuperationParc}" reRender="idSubView,idParc"/>
                    </c:if>
                    <rich:column  width="20%" >
                        <f:facet name="header"><h:outputText  value="IMMATRICULATION" /></f:facet>
                        <h:outputText value="#{prc.prcImmatriculation}"/>
                    </rich:column>
                    <rich:column  width="40%"  >
                        <f:facet name="header"><h:outputText  value="FAMILLE" /></f:facet>
                        <h:outputText value="#{prc.prcLibFamille}" />
                    </rich:column>
                    <rich:column  width="40%"  >
                        <f:facet name="header"><h:outputText  value="SOUS FAMILLE" /></f:facet>
                        <h:outputText value="#{prc.prcLibSousFamille}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="id43">
                        <a4j:commandButton id="idCanTiers43" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.annuleParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers43" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectParc}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==45}" var="id45">
                        <a4j:commandButton id="idCanTiers45" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.annuleParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers45" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.recuperationParc}" reRender="idSubView,idParc,idProduit,idLibelleParc,idDepot" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectParc}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==46}" var="id46">
                        <a4j:commandButton id="idCanTiers46" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.annuleParc}" reRender="idSubView,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers46" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.recuperationParc}" reRender="idSubView,idParc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectParc}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="id62">
                        <a4j:commandButton id="idCanTiers62" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.annuleParc}" reRender="idSubView,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers62" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationParc}" reRender="idSubView,idParc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectParc}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==63}" var="id63">
                        <a4j:commandButton id="idCanTiers63" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.annuleParc}" reRender="idSubView,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers63" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.recuperationParc}" reRender="idSubView,idParc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectParc}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>