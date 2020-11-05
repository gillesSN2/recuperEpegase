<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trfventes">

    <a4j:form>

        <center> <h2><h:outputText value="TRANSFERT DES VENTES EN COMPTABILITE ou IMPORTATION DES ELEMENTS DE GESTCOM" style="color:green;"/></h2></center>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px black;">

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==0}" var="odpaye">
                <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                    <h:panelGrid columns="11" width="100%">
                        <h:column><h:outputText value="Du:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="De la pièce:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.inpPieceDeb}" size="10"/></h:column>
                        <h:column><h:outputText value="A la pièce:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.inpPieceFin}" size="10"/></h:column>
                        <h:column><h:outputText value="Documents jamais transférés:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.inpDocNonTrf}" /></h:column>
                        <h:column>
                            <h:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>

                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.datamodelDocument}" var="doc">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.selectionLigne}"/>
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
                        <rich:column label="Compte Tiers" sortable="true" sortBy="#{doc.numComptetier}" width="10%">
                            <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                            <h:outputText value="#{doc.numComptetier}"/>
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
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==2}" var="impvar">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.datamodelDocument}" var="doc">
                        <rich:column label="Description erreur" sortable="true" sortBy="#{doc.trfNomFeuille}" width="100%">
                            <f:facet name="header"><h:outputText  value="Erreur" /></f:facet>
                            <h:outputText value="#{doc.trfNomFeuille}" title="#{doc.trfNomFeuille}" style="#{doc.stylePolice}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==6}" var="impvar">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                    <rich:extendedDataTable rows="300" enableContextMenu="false" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="150%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.datamodelDocument}" var="doc">
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT00}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT01}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT02}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT03}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT04}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT05}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT06}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT07}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT08}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT09}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT10}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT11}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT12}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT13}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT14}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT15}" style="#{doc.stylePolice}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

        </div>

        <br>
        <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_affiche_bouton}">
            <center>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.selectionAll}" value="Tout sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==0}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.deSelectionAll}" value="Tout dé-sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==0}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en comptabilité ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertComptaVentes}" value="Transférer en comptabilité" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==0}"/>
                <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir importer ces informations ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertImportLibreVentes}" value="Import libre" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.balance==6}"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_showBarProgMaj}">
        <f:facet name="header"><h:outputText value="Traitement des utilitaires en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" reRenderAfterComplete="panelBarProg,progressPanel">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>

