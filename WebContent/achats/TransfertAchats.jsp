<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trfachats">

    <a4j:form>

        <center> <h2><h:outputText value="TRANSFERT DES ACHATS EN COMPTABILITE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panGene">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.inpDu}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.inpAu}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="De la pièce:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.inpPieceDeb}" size="10"/></h:column>
                    <h:column><h:outputText value="A la pièce:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.inpPieceFin}" size="10"/></h:column>
                    <h:column><h:outputText value="Documents jamais transférés:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.inpDocNonTrf}" /></h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panGene,modAttente,table,scrollTable,panelBoutonTrf"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
            <br>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.datamodelDocument}" var="doc">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.selectionLigne}"/>
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
                    <rich:column label="N° dossier" sortable="true" sortBy="#{doc.docAnal4}" width="10%">
                        <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                        <h:outputText value="#{doc.docAnal4}"/>
                    </rich:column>
                    <rich:column label="Série" sortable="true" sortBy="#{doc.docNum}" width="5%">
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
            <br>
            <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.var_affiche_bouton}">
                <center>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.selectionAll}" value="Tout sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formTransfertAchats.deSelectionAll}" value="Tout dé-sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en comptabilité ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertComptaAchats}" value="Transférer en comptabilité" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" />
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>

