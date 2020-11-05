<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeSalaries">

    <a4j:form id="formModalListeSalaries">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU SALARIE"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                <rich:extendedDataTable rows="200" id="tableSalaries" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelSalaries}" var="sal" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionSalarie}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="ids60">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationSalarie}" reRender="idSubView,idSalarie"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="ids60">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationSalarie}" reRender="idSubView,idSalarie"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==88}" var="ids88">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche,panelValide,idPanGlobal"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==89}" var="ids89">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche,panelValide,idPanGlobal"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==810}" var="ids810">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==811}" var="ids811">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==812}" var="ids812">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==813}" var="ids813">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche,tabPanelsalaries"/>
                    </c:if>
                    <rich:column label="Matricule" sortable="true" sortBy="#{sal.salMatricule}" width="10%">
                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                        <h:outputText value="#{sal.salMatricule}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{sal.salCivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{sal.salCivilite}"/>
                    </rich:column>
                    <rich:column label="Nom" sortable="true" sortBy="#{sal.salNom}" width="30%" filterBy="#{sal.salNom}">
                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                        <h:outputText value="#{sal.salNom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{sal.salPrenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{sal.salPrenom}"/>
                    </rich:column>
                    <rich:column label="Service" sortable="true" sortBy="#{sal.salService}" width="15%">
                        <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                        <h:outputText value="#{sal.salService}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="id60">
                        <a4j:commandButton id="idCanTiers60" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annuleSalarie}" reRender="idSubView,idSalarie"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers60" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationSalarie}" reRender="idSubView,idSalarie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="id60">
                        <a4j:commandButton id="idCanTiers62" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.annuleSalarie}" reRender="idSubView,idSalarie"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers62" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationSalarie}" reRender="idSubView,idSalarie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==88}" var="id88">
                        <a4j:commandButton id="idCanTiers88" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.annuleSalarie}" reRender="idSubView,idSalarie,idRecherche,panelValide,idPanGlobal"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers88" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche,panelValide,idPanGlobal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==89}" var="id89">
                        <a4j:commandButton id="idCanTiers89" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.annuleSalarie}" reRender="idSubView,idSalarie,idRecherche,panelValide,idPanGlobal"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers89" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche,panelValide,idPanGlobal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==810}" var="id810">
                        <a4j:commandButton id="idCanTiers810" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.annuleSalarie}" reRender="idSubView,idSalarie,idRecherche"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers810" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==811}" var="id811">
                        <a4j:commandButton id="idCanTiers811" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.annuleSalarie}" reRender="idSubView,idSalarie,idRecherche"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers811" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==812}" var="id812">
                        <a4j:commandButton id="idCanTiers812" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.annuleSalarie}" reRender="idSubView,idSalarie,idRecherche"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers812" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==813}" var="id813">
                        <a4j:commandButton id="idCanTiers813" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annuleSalarie}" reRender="idSubView,idSalarie,idRecherche"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers813" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recuperationSalarie}" reRender="idSubView,idSalarie,idRecherche,tabPanelsalaries" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectSalaries}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>