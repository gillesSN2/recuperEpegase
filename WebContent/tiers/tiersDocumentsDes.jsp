<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="destiantaireDoc">

    <a4j:form id="formDocDes">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="DOCUMENTS VENTES : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaNomFr}" /></h2></center>

        <h:panelGrid  id="cont1" width="100%" >          

            <h:panelGrid width="100%">
                <h:panelGrid columns="12" styleClass="recherche" width="100%" >
                    <h:column> <h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.choixDocument}" >
                            <f:selectItem itemLabel="Sélectionnez documents" itemValue="99"/>
                            <f:selectItem itemLabel="Devis" itemValue="21"/>
                            <f:selectItem itemLabel="Bons de commande" itemValue="22"/>
                            <f:selectItem itemLabel="Bons de livraison" itemValue="23"/>
                            <f:selectItem itemLabel="Retour" itemValue="24"/>
                            <f:selectItem itemLabel="Factures + Avoirs + note débit" itemValue="25"/>
                            <f:selectItem itemLabel="Factures + Avoirs + note débit (non soldées)" itemValue="251"/>
                            <f:selectItem itemLabel="Règlements + Avoirs" itemValue="60"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Familles:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.choixFamilles}" >
                            <f:selectItem itemLabel="Toutes les familles" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.mesFamilles}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Produits:"/></h:column>
                    <h:column> <h:inputText style="width:100px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.choixProduit}"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.rechercherLesDocuments}" reRender="docmentEntete,scrollTable1,elements,scrollTable2,modAttente,paneltotal" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>

                <h:panelGrid id="pangrpVisbtMod" columns="4" width="200px" >
                </h:panelGrid>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Document">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="docmentEntete"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="docmentEntete" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.dataModelDocumentsEntete}" var="ent">
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.selectionDocument}" reRender="elements"/>
                                <rich:column width="5%" sortable="true" sortBy="#{ent.var_lib_nat}">
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{ent.var_lib_nat}" />
                                </rich:column>
                                <rich:column width="5%" sortable="true" sortBy="#{ent.docDate}">
                                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{ent.docDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                    <h:outputText value="#{ent.docNum}" />
                                </rich:column>
                                <rich:column width="18%" sortable="true" sortBy="#{ent.docObject}">
                                    <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                                    <h:outputText value="#{ent.docObject}" />
                                </rich:column>
                                <rich:column width="11%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="Tiers/Type Doc."/></f:facet>
                                    <h:outputText value="#{ent.docNomTiers}" />
                                </rich:column>
                                <rich:column width="11%" sortable="true" sortBy="#{ent.docNomCaissier}">
                                    <f:facet name="header" ><h:outputText value="Commercial/N° Doc."/></f:facet>
                                    <h:outputText value="#{ent.docNomCaissier}" />
                                </rich:column>
                                <rich:column width="11%" sortable="true" sortBy="#{ent.docNomResponsable}">
                                    <f:facet name="header" ><h:outputText value="Responsable/Mode Reg."/></f:facet>
                                    <h:outputText value="#{ent.docNomResponsable}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total H.T."/></f:facet>
                                    <h:outputText value="#{ent.docTotHt}" rendered="#{ent.docTotHt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total T.T.C."/></f:facet>
                                    <h:outputText value="#{ent.docTotTtc}" rendered="#{ent.docTotTtc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Réglement"/></f:facet>
                                    <h:outputText value="#{ent.docTotReglement}" rendered="#{ent.docTotReglement!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Solde"/></f:facet>
                                    <h:outputText value="#{ent.docAPayer}" rendered="#{ent.docAPayer!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabDet" label="Détail">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="elements"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="elements" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" selectionMode="multiple" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.dataModelDocuments}" var="doc">
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
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.optionVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.optionVentes.nbDecPu}"/>
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
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.optionVentes.nbDecQte}"/>
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

                </rich:tabPanel>
            </h:panelGrid>

            <h:panelGrid id="paneltotal" columns="2" columnClasses="clos50d,clos50d" width="50%" border="0">
                <h:column><h:outputText value="Total quantité:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_qte}" style="text-align:right;">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.optionVentes.nbDecQte}"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total ventes (TTC):"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_total}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total règlements:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_reglement}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Solde:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_solde}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.retourDocuments}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>