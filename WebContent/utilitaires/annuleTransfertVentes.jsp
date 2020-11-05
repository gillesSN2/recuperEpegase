<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="annultrfvte">

    <a4j:form>

        <center> <h2><h:outputText value="ANNULATION TRANSFERT DES VENTES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="7" width="100%">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}" popup="true"/>
                    </h:column>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.toutSelectionAnnulTrfVentes}" value="Tout Sél." style="color:white;background-color:green;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.rienSelectionAnnulTrfVentes}" value="Rien Sél." style="color:white;background-color:green;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.rechercherAnnulTrfVentes}" value="Rechercher" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
            </h:panelGrid>
            <br>
            <h:panelGrid id="listRecherche" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelDocumentEntete}" var="doc">
                        <rich:column label="Selection" sortable="true" sortBy="#{doc.docSelect}" width="5%">
                            <f:facet name="header" ><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{doc.docSelect}"/>
                        </rich:column>
                        <rich:column label="Nature document" sortable="true" sortBy="#{doc.var_lib_nat}" width="10%">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{doc.var_lib_nat}"/>
                        </rich:column>
                        <rich:column label="N° document" sortable="true" sortBy="#{doc.docNum}" width="10%">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{doc.docNum}"/>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{doc.docSerie}" width="5%">
                            <f:facet name="header"><h:outputText  value="Série" /></f:facet>
                            <h:outputText value="#{doc.docSerie}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{doc.docDate}" width="10%">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{doc.docDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Nom du tiers" sortable="true" sortBy="#{doc.docNomTiers}" width="20%">
                            <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                            <h:outputText value="#{doc.docNomTiers}"/>
                        </rich:column>
                        <rich:column label="Total HT" sortable="true" sortBy="#{doc.docTotHt}" width="10%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T." /></f:facet>
                            <h:outputText value="#{doc.docTotHt}" rendered="#{doc.docTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Total TVA" sortable="true" sortBy="#{doc.docTotTva}" width="10%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                            <h:outputText value="#{doc.docTotTva}" rendered="#{doc.docTotTva!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Total TTC" sortable="true" sortBy="#{doc.docTotTtc}" width="10%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C." /></f:facet>
                            <h:outputText value="#{doc.docTotTtc}" rendered="#{doc.docTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="panelBoutonTrf">
            <center>
                <h:commandButton id="idAnnule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulePlansAnalytiques}" value="RETOUR" styleClass="exp_lienmenu"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton id="idValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulTrfVentes}" value="Annulation transfert des ventes" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette opération ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

