<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ficheRecapAjout">
    
    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="AJOUTER UN NOUVEAU RECAP DE REFACTURATION" style="color:green;"/></h2></center>
        <h:panelGrid  id="panGlobal" width="100%">
            <h:panelGrid  id="panCtrlRecap" styleClass="recherche" width="100%">
                <h:panelGroup>
                    <h:column><h:outputText value="Factures du:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateDebut}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateFin}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton value="RECH. ELEMENTS A REFACTURER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheFactureRecap}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panCtrlRecap,idCat1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:selectOneMenu id="idCat1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNomTiersPayeurs}" style="width:200px;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.facturesChargee}">
                        <f:selectItem itemLabel="Sélectionnez un tier" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.lesTiersPayeurs}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheFactureTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,panCtrlRecap,idTable,pnlgrttotal,table,scrollTable"/>
                    </h:selectOneMenu>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:column><h:outputText value="Date Récap.:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.facturesChargee}"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateFacture}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.facturesChargee}"/></h:column>
                </h:panelGroup>
            </h:panelGrid>

            <center>
                <a4j:region id="idTable" renderRegionOnly="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.tiersChargee}">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelFactureLibre}"  var="var" activeRowKey="true" rowKeyVar="rkv" sortMode="multi" selectionMode="single">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calculeTotalRecap}" reRender="pnlgrttotal"/>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}"/>
                        </rich:column>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.facNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.facDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.facDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date début période" sortable="true" sortBy="#{var.facDateDebut}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{var.facDateDebut}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin période" sortable="true" sortBy="#{var.facDateFin}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{var.facDateFin}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.facSerie}"/>
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.facCat}" width="100px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.facCat}"/>
                        </rich:column>
                        <rich:column label="Tiers" sortable="true" sortBy="#{var.facNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="tiers"  /></f:facet>
                            <h:outputText  value="#{var.facNomTiers}" />
                        </rich:column>
                        <rich:column label="Adhérent" sortable="true" sortBy="#{var.facNomAdherent}" width="200px">
                            <f:facet name="header"><h:outputText  value="Adhérent/localisation"  /></f:facet>
                            <h:outputText  value="#{var.facNomAdherent}" rendered="#{var.facIdAdherent!=0}"/>
                            <h:outputText  value="#{var.facSecteurAgent}" rendered="#{var.facSecteurAgent!=null}"/>
                            <h:outputText  value="#{var.libelleFonds}" rendered="#{var.facFondCnamgs!=0}"/>
                        </rich:column>
                        <rich:column label="Total T.T.C." sortable="true" sortBy="#{var.facTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                            <h:outputText  value="#{var.facTotTtc}" rendered="#{var.facTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </center>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.tiersChargee}">
                <h:panelGrid columns="2" >
                    <h:outputText value="Total HT" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" >
                    <h:outputText  value="Total TVA" />
                    <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" >
                    <h:outputText value="Total TTC" />
                    <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantSolde}" style="width:100%;text-align:right;color:red" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="1">
                    <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_ligne})" />
                </h:panelGrid>
            </h:panelGrid>
            <br/>
            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulerRecap}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.saveRecap}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>
