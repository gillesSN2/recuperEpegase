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

        <center><h2><h:outputText styleClass="titre" value="DOCUMENTS COMMERCIAUX : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.users.usrPatronyme}" /></h2></center>

        <h:panelGrid  id="cont1" width="100%" >          

            <h:panelGrid width="100%">
                <h:panelGrid columns="12" styleClass="recherche" width="100%" >
                    <h:column> <h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.choixDocument}" >
                            <f:selectItem itemLabel="Sélectionnez documents" itemValue="99"/>
                            <f:selectItem itemLabel="Cotation" itemValue="11"/>
                            <f:selectItem itemLabel="Bons de commande" itemValue="12"/>
                            <f:selectItem itemLabel="Réception" itemValue="13"/>
                            <f:selectItem itemLabel="Retour" itemValue="14"/>
                            <f:selectItem itemLabel="Facture + Avoir + Note débit" itemValue="15"/>
                            <f:selectItem itemLabel="Frais" itemValue="18"/>
                            <f:selectItem itemLabel="Devis" itemValue="21"/>
                            <f:selectItem itemLabel="Bons de commande" itemValue="22"/>
                            <f:selectItem itemLabel="Bons de livraison" itemValue="23"/>
                            <f:selectItem itemLabel="Retour" itemValue="24"/>
                            <f:selectItem itemLabel="Facture + Avoir + Note débit" itemValue="25"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Produits:"/></h:column>
                    <h:column> <h:inputText style="width:100px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.choixProduit}"/></h:column>
                    <h:column> <h:outputText value="Familles:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.choixFamilles}" >
                            <f:selectItem itemLabel="Toutes les familles" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.mesFamilles}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <a4j:commandButton  value="RECHERCHER"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.rechercherLesDocuments}" reRender="docmentEntete,scrollTable1,elements,scrollTable2,modAttente,paneltotal,idTotal" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>

                <h:panelGrid id="pangrpVisbtMod" columns="4" width="200px" >
                </h:panelGrid>


                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Document">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="docmentEntete"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="docmentEntete" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.dataModelDocumentsEntete}" var="entUsr">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.selectionDocument}" reRender="elements"/>
                                <rich:column width="5%" sortable="true" sortBy="#{entUsr.var_lib_nat}">
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{entUsr.var_lib_nat}" />
                                </rich:column>
                                <rich:column width="5%" sortable="true" sortBy="#{entUsr.docDate}">
                                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{entUsr.docDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                    <h:outputText value="#{entUsr.docNum}" />
                                </rich:column>
                                <rich:column width="18%" sortable="true" sortBy="#{entUsr.docNomTiers}">
                                    <f:facet name="header" ><h:outputText value="Client"/></f:facet>
                                    <h:outputText value="#{entUsr.docNomTiers}" />
                                </rich:column>
                                <rich:column width="11%" sortable="true" sortBy="#{entUsr.docNomContact}">
                                    <f:facet name="header" ><h:outputText value="Contact"/></f:facet>
                                    <h:outputText value="#{entUsr.docNomContact}" />
                                </rich:column>
                                <rich:column width="11%" sortable="true" sortBy="#{entUsr.docNomCaissier}">
                                    <f:facet name="header" ><h:outputText value="Commercial"/></f:facet>
                                    <h:outputText value="#{entUsr.docNomCaissier}" />
                                </rich:column>
                                <rich:column width="11%" sortable="true" sortBy="#{entUsr.docNomResponsable}">
                                    <f:facet name="header" ><h:outputText value="Responsable"/></f:facet>
                                    <h:outputText value="#{entUsr.docNomResponsable}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total H.T."/></f:facet>
                                    <h:outputText value="#{entUsr.docTotHt}" rendered="#{entUsr.docTotHt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total T.T.C."/></f:facet>
                                    <h:outputText value="#{entUsr.docTotTtc}" rendered="#{entUsr.docTotTtc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Réglement"/></f:facet>
                                    <h:outputText value="#{entUsr.docTotReglement}" rendered="#{entUsr.docTotReglement!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Solde"/></f:facet>
                                    <h:outputText value="#{entUsr.docAPayer}" rendered="#{entUsr.docAPayer!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabDet" label="Détail">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="elements"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="elements" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.dataModelDocuments}" var="docUsr">
                                <rich:column width="10%" sortable="true" sortBy="#{docUsr.stk_lib_type}">
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_lib_type}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" sortBy="#{docUsr.stk_date_mvt}">
                                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_date_mvt}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true">
                                    <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_numero}" />
                                </rich:column>
                                <rich:column width="12%" sortable="true" sortBy="#{docUsr.stk_code_produit}">
                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_code_produit}" />
                                </rich:column>
                                <rich:column width="25%" sortable="true" sortBy="#{docUsr.stkLibelle}">
                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{docUsr.stkLibelle}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" sortBy="#{docUsr.stk_code_depot}">
                                    <f:facet name="header" ><h:outputText value="Dépôt"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_code_depot}" />
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="P.U"/></f:facet>
                                    <h:outputText value="#{docUsr.stkPuRem}" rendered="#{docUsr.stkPuRem!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="P.U.M.P"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_pump}" rendered="#{docUsr.stk_pump!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="5%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Qte"/></f:facet>
                                    <h:outputText value="#{docUsr.stk_qte_progress}"/>
                                </rich:column>
                                <rich:column width="8%" sortable="true" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Total H.T."/></f:facet>
                                    <h:outputText value="#{docUsr.stkPt}" rendered="#{docUsr.stkPt!=0}">
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
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.caHt}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb document(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nbDoc}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="C.A. Moyen"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.caMoyen}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Sans source"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.sansSources}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Total C.A. Transformé"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.caTrf}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb document(s) transformé(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nbTrf}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Taux transformation"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.tauxTrf}" readonly="true" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total Nb jour(s) ouvré(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nbJour}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Total moyen jour"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.caJour}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taux jour"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.tauxJour}" readonly="true" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nombre de tiers"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nbTiers}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Total moyen tiers"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.caTiers}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taux tiers"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.tauxTiers}" readonly="true" style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total nb produit(s)"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nbProduit}" readonly="true" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Total moyen produit"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.prixMoyen}" readonly="true" style="text-align:right;">
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
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_qte}" style="text-align:right;">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <h:outputText value="Total ventes:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_total}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.retourDocuments}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>