<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeBien">

    <a4j:form id="formModalListeBien">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU BIEN"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableBien"/>
                <rich:extendedDataTable rows="200" id="tableBien" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelBiens}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionBiens}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==162}" var="ids162">
                         <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.recuperationBiens}" reRender="idSubView,idBien,idProduit,idLibelleBien"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==163}" var="ids163">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationBiens}" reRender="idSubView,idBien,idProduit,idLibelleBien"/> 
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==164}" var="ids164">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationBiens}" reRender="idSubView,idBien"/> 
                    </c:if>
                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                        <h:outputText value="#{var.bieNum}"/>
                    </rich:column>
                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                        <h:outputText value="#{var.bieNom}"/>
                    </rich:column>
                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                        <h:outputText value="#{var.bieNomTiers}"/>
                    </rich:column>
                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                        <h:outputText value="#{var.bieAdresse}"/>
                    </rich:column>
                    <rich:column label="Quartier" sortable="true" width="100px" sortBy="#{var.bieGroupe}">
                        <f:facet name="header"><h:outputText  value="Groupe" /></f:facet>
                        <h:outputText value="#{var.bieGroupe}"/>
                    </rich:column>
                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                        <h:outputText value="#{var.bieModele}"/>
                    </rich:column>
                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{var.bieNbPiece}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                        <h:outputText value="#{var.bieNbPiece}" rendered="#{var.bieNbPiece!=0}" />
                    </rich:column>
                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Charges" sortable="true" width="100px" sortBy="#{var.bieCharges}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
                        <h:outputText value="#{var.bieCharges}" rendered="#{var.bieCharges!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==162}" var="id162">
                        <a4j:commandButton id="idCanTiers162" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annuleBiens}" reRender="idSubView,idBien,idProduit,idLibelleBien"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers162" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.recuperationBiens}" reRender="idSubView,idBien,idProduit,idLibelleBien" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectBien}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==163}" var="id163">
                        <a4j:commandButton id="idCanTiers163" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleBiens}" reRender="idSubView,idBien,idProduit,idLibelleBien"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers163" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationBiens}" reRender="idSubView,idBien,idProduit,idLibelleBien" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectBien}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==164}" var="id164">
                        <a4j:commandButton id="idCanTiers164" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleBiens}" reRender="idSubView,idBien"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers164" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationBiens}" reRender="idSubView,idBien" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectBien}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>