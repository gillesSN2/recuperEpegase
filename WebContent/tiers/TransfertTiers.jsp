<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trftiers">

    <a4j:form>

        <center> <h2><h:outputText value="IMPORTATION DES TIERS" style="color:green;"/></h2></center>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px black;">

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.balance==0}" var="odpaye">
               
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.balance==2}" var="impvar">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.datamodelDocument}" var="doc">
                        <rich:column label="Description erreur" sortable="true" sortBy="#{doc.trfNomFeuille}" width="100%">
                            <f:facet name="header"><h:outputText  value="Erreur" /></f:facet>
                            <h:outputText value="#{doc.trfNomFeuille}" title="#{doc.trfNomFeuille}" style="#{doc.stylePolice}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.balance==6}" var="impvar">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_nb_max}" enableContextMenu="false" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="300%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.datamodelDocument}" var="doc">
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
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT16}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT17}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT18}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT19}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT20}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT21}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT22}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT23}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT24}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT25}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT26}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT27}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT28}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT29}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT30}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT31}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT32}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT33}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT34}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT35}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT36}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT37}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT38}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT39}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column sortable="false">
                            <h:outputText value="#{doc.trfColT40}" style="#{doc.stylePolice}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

        </div>

        <br>
        <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_affiche_bouton}">
            <center>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.selectionAll}" value="Tout sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.balance==0}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.deSelectionAll}" value="Tout dé-sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.balance==0}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir importer ces informations ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertImportTiersLibre}" value="Import libre" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.balance==6}"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_showBarProgMaj}">
        <f:facet name="header"><h:outputText value="Traitement des utilitaires en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" reRenderAfterComplete="panelBarProg,progressPanel">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTransfertTiers.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>

