<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trfcaisse">

    <a4j:form>

        <center> <h2><h:outputText value="TRANSFERT DES OPERATIONS TRESORERIE EN COMPTABILITE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panGene">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="14" width="100%">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputSize="8"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpDu}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpAu}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpCaisse}">
                            <f:selectItem itemLabel="Toutes les caisses" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.mesCaissesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpOperation}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesOperationsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpMode}">
                            <f:selectItem itemLabel="Tous modes de paiement" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesTypeReglementsItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="De la pièce:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpPieceDeb}" size="8"/></h:column>
                    <h:column><h:outputText value="A la pièce:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpPieceFin}" size="8"/></h:column>
                    <h:column><h:outputText value="Documents jamais transférés:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.inpDocNonTrf}" /></h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panGene,modAttente,scrollTable,table,panelBoutonTrf"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
            <br>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.datamodelDocument}" var="doc">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.selectionLigne}"/>
                    <rich:column label="Selection" sortable="true" sortBy="#{doc.docSelect}" width="5%">
                        <f:facet name="header" ><h:outputText  value="Sel." /></f:facet>
                        <h:selectBooleanCheckbox value="#{doc.docSelect}"/>
                    </rich:column>
                    <rich:column label="Nature document" sortable="true" sortBy="#{doc.var_lib_nat}" width="10%">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{doc.docNature}:#{doc.var_lib_nat}"/>
                    </rich:column>
                    <rich:column label="N° document" sortable="true" sortBy="#{doc.docNum}" width="10%">
                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                        <h:outputText value="#{doc.docNum}"/>
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
                    <rich:column label="Nom du tiers" sortable="true" sortBy="#{doc.docNomTiers}" width="10%">
                        <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                        <h:outputText value="#{doc.docNomTiers}"/>
                    </rich:column>
                    <rich:column label="Objet" sortable="true" sortBy="#{doc.docLibelle}" width="15%">
                        <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                        <h:outputText value="#{doc.docLibelle}"/>
                    </rich:column>
                    <rich:column label="Caisse" sortable="true" sortBy="#{doc.docCodeCaiss}" width="5%">
                        <f:facet name="header"><h:outputText  value="Caisse" /></f:facet>
                        <h:outputText value="#{doc.docCodeCaiss}"/>
                    </rich:column>
                    <rich:column label="Emetteur" sortable="true" sortBy="#{doc.docCodeEmetrice}" width="5%">
                        <f:facet name="header"><h:outputText  value="Emetteur" /></f:facet>
                        <h:outputText value="#{doc.docCodeEmetrice}"/>
                    </rich:column>
                    <rich:column label="Récepteur" sortable="true" sortBy="#{doc.docCodeReceptrice}" width="5%">
                        <f:facet name="header"><h:outputText  value="Récepteur" /></f:facet>
                        <h:outputText value="#{doc.docCodeReceptrice}"/>
                    </rich:column>
                    <rich:column label="Recettes" sortable="true" sortBy="#{doc.docTotTva}" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Recettes" /></f:facet>
                        <h:outputText value="#{doc.docTotTva}" rendered="#{doc.docTotTva!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Dépenses" sortable="true" sortBy="#{doc.docTotTtc}" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Dépenses" /></f:facet>
                        <h:outputText value="#{doc.docTotTtc}" rendered="#{doc.docTotTtc!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.var_affiche_bouton}">
                <center>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.selectionAll}" value="Tout sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTransfertCaisse.deSelectionAll}" value="Tout dé-sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en comptabilité ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertComptaCaisse}" value="Transférer en comptabilité" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" />
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>

