<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fusionTiers">

    <a4j:form>

        <center> <h2><h:outputText value="FUSION DES TIERS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="2" columnClasses="clos50g,clos50g" width="100%">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableOrigine" maxPages="20" align="left" for="tableOrigine"/>
                <rich:extendedDataTable rows="300" style="max-height:100%" styleClass="bg" id="tableOrigine" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelTiersOrigines}" selectionMode="single" var="org" >
                    <a4j:support eventsQueue="maQueue1" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.selectionTiersOrigine}" reRender="panelBoutonTrf"/>
                    <rich:column label="Identification" sortable="true" sortBy="#{org.tieid}" width="5%">
                        <f:facet name="header" ><h:outputText  value="Id" /></f:facet>
                        <h:outputText value="#{org.tieid}"/>
                    </rich:column>
                    <rich:column label="Compte" sortable="true" sortBy="#{org.comptePrincipal}" width="15%">
                        <f:facet name="header" ><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{org.comptePrincipal}"/>
                    </rich:column>
                    <rich:column label="Compte" sortable="true" sortBy="#{org.tiegenre}" width="10%">
                        <f:facet name="header" ><h:outputText  value="Genre" /></f:facet>
                        <h:outputText value="#{org.tiegenre}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{org.tieraisonsocialenom}" width="60%">
                        <f:facet name="header" ><h:outputText  value="Nom tiers ORIGINE" /></f:facet>
                        <h:outputText value="#{org.tieraisonsocialenom}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableDestination" maxPages="20" align="left" for="tableDestination"/>
                <rich:extendedDataTable rows="300" style="max-height:100%" styleClass="bg" id="tableDestination" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelTiersDestinataires}" selectionMode="single" var="dst">
                    <a4j:support eventsQueue="maQueue2" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.selectionTiersDestination}" reRender="panelBoutonTrf"/>
                    <rich:column label="Identification" sortable="true" sortBy="#{dst.tieid}" width="5%">
                        <f:facet name="header" ><h:outputText  value="Id" /></f:facet>
                        <h:outputText value="#{dst.tieid}"/>
                    </rich:column>
                    <rich:column label="Compte" sortable="true" sortBy="#{dst.comptePrincipal}" width="15%">
                        <f:facet name="header" ><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{dst.comptePrincipal}"/>
                    </rich:column>
                    <rich:column label="Compte" sortable="true" sortBy="#{dst.tiegenre}" width="10%">
                        <f:facet name="header" ><h:outputText  value="Genre" /></f:facet>
                        <h:outputText value="#{dst.tiegenre}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{dst.tieraisonsocialenom}" width="60%">
                        <f:facet name="header" ><h:outputText  value="Nom tiers DESTINATION" /></f:facet>
                        <h:outputText value="#{dst.tieraisonsocialenom}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
        <br>
        <h:panelGroup id="panelBoutonTrf">
            <center>
                <h:commandButton id="idAnnule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulePlansAnalytiques}" value="RETOUR" styleClass="exp_lienmenu"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton id="idValide" onclick="if (!confirm('Etes-vous sur de vouloir transférer (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.idOrigine}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.compteOrigine} vers (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.idDestinataire}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.compteDestinataire} ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.fusionTiers}" value="Fusion tiers" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" />
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

