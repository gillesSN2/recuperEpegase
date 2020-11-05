<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersDoc">

    <a4j:form id="formDoc">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="DOCUMENTS VENTES : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" /></h2></center>

        <h:panelGrid  id="cont1" width="100%" >          

            <h:panelGrid width="100%">
                <h:panelGrid columns="14" styleClass="recherche" width="100%" >
                    <h:column> <h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixDocument}" >
                            <f:selectItem itemLabel="Sélectionnez documents" itemValue="99"/>
                            <f:selectItem itemLabel="Devis" itemValue="21"/>
                            <f:selectItem itemLabel="Bons de commande" itemValue="22"/>
                            <f:selectItem itemLabel="Bons de livraison" itemValue="23"/>
                            <f:selectItem itemLabel="Bons de livraison (non facturés)" itemValue="231"/>
                            <f:selectItem itemLabel="Retour" itemValue="24"/>
                            <f:selectItem itemLabel="Factures + Avoirs + note débit" itemValue="25"/>
                            <f:selectItem itemLabel="Factures + Avoirs + note débit (non soldées)" itemValue="251"/>
                            <f:selectItem itemLabel="Règlements + Avoirs" itemValue="60"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixSeries}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesSeries}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="false"><h:outputText value="Familles:"/></h:column>
                    <h:column rendered="false">
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixFamilles}" >
                            <f:selectItem itemLabel="Toutes les familles" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesFamilles}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="false"><h:outputText value="Produits:"/></h:column>
                    <h:column rendered="false"><h:inputText style="width:100px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixProduit}"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.rechercherLesDocuments}" reRender="docmentEntete,scrollTable1,elements,scrollTable2,modAttente,paneltotal,idTotal" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>

                <h:panelGrid id="pangrpVisbtMod" columns="4" width="200px" >
                </h:panelGrid>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Document">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="docmentEntete"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="docmentEntete" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" selectionMode="single" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelDocumentsEntete}" var="ent">
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionDocument}" reRender="elements"/>
                                <rich:column width="5%" sortable="true" sortBy="#{ent.var_lib_nat}">
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{ent.var_lib_nat}" title="#{ent.var_lib_nat}"/>
                                </rich:column>
                                <rich:column width="8%" sortable="true" sortBy="#{ent.docDate}">
                                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{ent.docDate}" title="#{ent.docDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                    <h:outputText value="#{ent.docNum}" title="#{ent.docNum}"/>
                                </rich:column>
                                <rich:column width="5%" sortable="true" style="text-align:center">
                                    <f:facet name="header" ><h:outputText value="S."/></f:facet>
                                    <h:outputText value="#{ent.docSerie}" title="#{ent.docSerie}" style="text-align:center"/>
                                </rich:column>
                                <rich:column width="10%" sortable="true" sortBy="#{ent.docObject}">
                                    <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                                    <h:outputText value="#{ent.docObject}" title="#{ent.docObject}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="true" sortBy="#{ent.docNomContact}">
                                    <f:facet name="header" ><h:outputText value="Contact/Type Doc."/></f:facet>
                                    <h:outputText value="#{ent.docNomContact}" title="#{ent.docNomContact}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="true" sortBy="#{ent.docNomCaissier}">
                                    <f:facet name="header" ><h:outputText value="Commercial/N° Doc."/></f:facet>
                                    <h:outputText value="#{ent.docNomCaissier}" title="#{ent.docNomCaissier}"/>
                                </rich:column>
                                <rich:column width="11%" sortable="true" sortBy="#{ent.docNomResponsable}">
                                    <f:facet name="header" ><h:outputText value="Responsable/Mode Reg."/></f:facet>
                                    <h:outputText value="#{ent.docNomResponsable}" title="#{ent.docNomResponsable}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total T.T.C."/></f:facet>
                                    <h:outputText value="#{ent.docTotTtc}" rendered="#{ent.docTotTtc!=0}" title="#{ent.docTotTtc}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="10%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Réglement"/></f:facet>
                                    <h:outputText value="#{ent.docTotReglement}" rendered="#{ent.docTotReglement!=0}" title="#{ent.docTotReglement}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="10%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Solde"/></f:facet>
                                    <h:outputText value="#{ent.docAPayer}" rendered="#{ent.docAPayer!=0}" title="#{ent.docAPayer}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabDet" label="Détail">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="elements"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="elements" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" selectionMode="multiple" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelDocuments}" var="doc">
                                <rich:column width="10%" sortable="true" sortBy="#{doc.stk_lib_type}">
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{doc.stk_lib_type}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" sortBy="#{doc.stk_date_mvt}">
                                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{doc.stk_date_mvt}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                    <h:outputText value="#{doc.stk_numero}" />
                                </rich:column>
                                <rich:column width="12%" sortable="true" sortBy="#{doc.stk_code_produit}">
                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                    <h:outputText value="#{doc.stk_code_produit}" />
                                </rich:column>
                                <rich:column width="25%" sortable="true" sortBy="#{doc.stkLibelle}">
                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{doc.stkLibelle}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" sortBy="#{doc.stk_code_depot}">
                                    <f:facet name="header" ><h:outputText value="Dépôt"/></f:facet>
                                    <h:outputText value="#{doc.stk_code_depot}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="P.U"/></f:facet>
                                    <h:outputText value="#{doc.stkPuRem}" rendered="#{doc.stkPuRem!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.nbDecPu}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="P.U.M.P"/></f:facet>
                                    <h:outputText value="#{doc.stk_pump}" rendered="#{doc.stk_pump!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="5%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Qte"/></f:facet>
                                    <h:outputText value="#{doc.stk_qte_progress}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total H.T."/></f:facet>
                                    <h:outputText value="#{doc.stkPt}" rendered="#{doc.stkPt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabStat" label="Statistiques">
                        <h:panelGrid id="idTotal" width="100%" columns="6" style="text-align:right;" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Total C.A. H.T."/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.caHt}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb document(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nbDoc}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="C.A. Moyen"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.caMoyen}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Sans source"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.sansSources}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Total C.A. Transformé"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.caTrf}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb document(s) transformé(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nbTrf}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Taux transformation"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.tauxTrf}" readonly="true" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total Nb jour(s) ouvré(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nbJour}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Total moyen jour"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.caJour}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taux jour"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.tauxJour}" readonly="true" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total nb produit(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nbProduit}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Total moyen produit"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.prixMoyen}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
            </h:panelGrid>

            <h:panelGrid id="paneltotal" columns="2" columnClasses="clos50d,clos50d" width="50%" border="0">
                <h:column><h:outputText value="Total quantité:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_qte}" style="text-align:right;">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.nbDecQte}"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total ventes (TTC):"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_total}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total règlements:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_reglement}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Solde:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_solde}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourDocuments}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>