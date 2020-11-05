<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:facet name="header"><h:outputText value="Historique produit #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligCode} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLibelle}"/></f:facet>
<f:facet name="controls">
    <a4j:form>
        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.fermerHistorique}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoriqueProduit"/>
    </a4j:form>
</f:facet>
<a4j:form id="formModalHistorique">
    <rich:hotKey key="return" handler="return false;"/>
    <h:panelGrid id="idPanHistorique" width="100%" >
        <h:panelGrid  columns="2" columnClasses="clos30,clos70d" styleClass="fichefournisseur" border="0">
            <h:outputText value="Qte demandée:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteDem}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte chargée:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteCharg}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte facturée:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteFacture}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte don:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteDon}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte avoir:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteAvoir}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte écart usine:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteManquant}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte reprise:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteReprise}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte défecteuse:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteDefectueux}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte non conforme:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteNconforme}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte périmée:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQtePerime}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Qte retournée:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteRetour}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
            <h:outputText value="Ecart final:"/>
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteEcart}" readonly="true" style="width:100px;text-align:right;">
                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
            </h:inputText>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable id="tableHistorique" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.dataModelDetailFacture}" var="histo">
                <rich:column sortable="false" width="10%">
                    <f:facet name="header"><h:outputText  value="N° Facture"/></f:facet>
                    <h:outputText value="#{histo.factureEnteteVentes.facNum}"/>
                </rich:column>
                <rich:column sortable="false" width="10%">
                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                    <h:outputText value="#{histo.factureEnteteVentes.facDate}"/>
                </rich:column>
                <rich:column sortable="false" width="30%">
                    <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                    <h:outputText value="#{histo.factureEnteteVentes.facNomTiers}"/>
                </rich:column>
                <rich:column sortable="false" style="text-align:right" width="10%" >
                    <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                    <h:outputText value="#{histo.facligQte}">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                    </h:outputText>
                </rich:column>
                <rich:column sortable="false" style="text-align:right;" width="10%">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                        <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                        <h:outputText value="#{histo.facligPu}" rendered="#{histo.facligPu!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                        </h:outputText>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                        <f:facet name="header"><h:outputText value="P.U.TTC"/></f:facet>
                        <h:outputText value="#{histo.facligPuTtc}" rendered="#{histo.facligPuTtc!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                        </h:outputText>
                    </c:if>
                </rich:column>
                <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRemise}">
                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                    <h:outputText value="#{histo.facligTauxRemise}" rendered="#{histo.facligTauxRemise!=0}" />
                </rich:column>
                <rich:column sortable="false" style="text-align:right;" width="10%">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                        <h:outputText value="#{histo.facligPt}" rendered="#{histo.facligPt!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                        <h:outputText value="#{histo.facligTtc}" rendered="#{histo.facligTtc!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </c:if>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </h:panelGrid>
</a4j:form>