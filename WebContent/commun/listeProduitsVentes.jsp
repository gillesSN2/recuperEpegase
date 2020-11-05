<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeProduitVente">

    <a4j:form id="formModalListeProduitVente">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU PRODUIT (VENTE)"/></f:facet>
        </h:panelGrid>
        <br>
        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <center>
                <h:panelGroup id="panelBouton" style="height:34px">
                    <a4j:commandButton id="idDup" title="Duppliquer Produit" image="/images/duplicate.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.duppliquerProduit}" reRender="panelProduit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGroup>
            </center>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="listeProd"/>
                <rich:extendedDataTable rows="200" id="listeProd" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="110%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelProduits}" var="prd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.configListeEntete}" >
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionProduit}" reRender="idVal,panelBouton"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==1}" var="ids1">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.recuperationProduit}" reRender="idSubView,idpanRemisen"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==2}" var="ids2">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.recuperationProduit}" reRender="idSubView,idpanRemisen"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==6}" var="ids6">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==20}" var="ids20">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="ids21">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="ids22">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="ids23">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="ids24">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="ids25">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="ids26">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="ids27">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="ids28">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="ids43">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==46}" var="ids46">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==77}" var="ids77">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==100}" var="ids00">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.recuperationProduit}" reRender="idSubView,idPanGlobal,panelButton"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="ids140">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==142}" var="ids142">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==281}" var="ids281">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationProduitRechargement}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}"width="100px">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{prd.proCode}"/>
                    </rich:column>
                    <rich:column label="Photo Produit" width="35px" sortable="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.photosProduit=='1'}">
                        <f:facet name="header" ><h:outputText value="Pho."/></f:facet>
                        <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/produits/photo/#{prd.proPhoto}" alt="pho" height="30px" width="30px" style="text-align:center" rendered="#{prd.proPhoto!=null}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="300px" filterBy="#{prd.proLibClient}">
                        <f:facet name="header"><h:outputText  value="Libellé commercial" /></f:facet>
                        <h:outputText value="#{prd.proLibClient}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibTech}" width="200px">
                        <f:facet name="header"><h:outputText  value="Libellé technique" /></f:facet>
                        <h:outputText value="#{prd.proLibTech}"/>
                    </rich:column>
                    <rich:column label="Longueur produit" sortable="true" sortBy="#{prd.proLongueur}" style="text-align:right;" width="50px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.optionsVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.optionsVentes.modeCalculDevis=='1'}">
                        <f:facet name="header"><h:outputText  value="Lg" /></f:facet>
                        <h:outputText value="#{prd.proLongueur}" style="text-align:right;"/>
                    </rich:column>
                    <rich:column label="Code T.V.A." sortable="true" sortBy="#{prd.proVteTva}" style="text-align:center;" width="50px">
                        <f:facet name="header"><h:outputText  value="Tva" /></f:facet>
                        <h:outputText value="#{prd.proVteTva}" style="text-align:center;"/>
                    </rich:column>
                    <rich:column label="PV 1" width="100px" sortable="true" sortBy="#{prd.pv1}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_aff_tarif1}">
                        <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tarif1}"/></f:facet>
                        <h:outputText value="#{prd.pv1}" rendered="#{prd.pv1!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="PV 2" width="100px" sortable="true" sortBy="#{prd.pv2}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_aff_tarif2}">
                        <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tarif2}"/></f:facet>
                        <h:outputText value="#{prd.pv2}" rendered="#{prd.pv2!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="PV 3" width="100px" sortable="true" sortBy="#{prd.pv3}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_aff_tarif3}">
                        <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tarif3}"/></f:facet>
                        <h:outputText value="#{prd.pv3}" rendered="#{prd.pv3!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="PV 4" width="100px" sortable="true" sortBy="#{prd.pv4}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_aff_tarif4}">
                        <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tarif4}"/></f:facet>
                        <h:outputText value="#{prd.pv4}" rendered="#{prd.pv4!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="PV 5" width="100px" sortable="true" sortBy="#{prd.pv5}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_aff_tarif5}">
                        <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tarif5}"/></f:facet>
                        <h:outputText value="#{prd.pv5}" rendered="#{prd.pv5!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Qte Stock" width="100px" sortable="true" sortBy="#{prd.proQteStock}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Qte Stock"/></f:facet>
                        <h:outputText value="#{prd.proQteStock}" rendered="#{prd.proQteStock!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.nbDecQte}"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Qte Stock" width="100px" sortable="true" sortBy="#{prd.proQteCmdFournisseur}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Cmd Four."/></f:facet>
                        <h:outputText value="#{prd.proQteCmdFournisseur}" rendered="#{prd.proQteCmdFournisseur!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.nbDecQte}"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Qte Stock" width="100px" sortable="true" sortBy="#{prd.proQteCmdClient}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Cmd Client"/></f:facet>
                        <h:outputText value="#{prd.proQteCmdClient}" rendered="#{prd.proQteCmdClient!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.optionVentes.nbDecQte}"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Activité" width="100px" sortable="true" sortBy="#{prd.proActivite}" >
                        <f:facet name="header" ><h:outputText value="Activité"  /></f:facet>
                        <h:outputText value="#{prd.proActivite}"/>
                    </rich:column>
                    <rich:column label="Conditionnement" width="100px" sortable="true" sortBy="#{prd.proCondition1}" >
                        <f:facet name="header" ><h:outputText value="Condit."  /></f:facet>
                        <h:outputText value="#{prd.proCondition1}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==1}" var="id1">
                    <a4j:commandButton id="idCanTiers1" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers1" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.recuperationProduit}" reRender="idSubView,idpanRemisen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==2}" var="id2">
                    <a4j:commandButton id="idCanTiers2" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.annuleProduits}" reRender="idSubView,idpanRemisen"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers2" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.recuperationProduit}" reRender="idSubView,idpanRemisen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==6}" var="id6">
                    <a4j:commandButton id="idCanTiers6" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers6" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==20}" var="id20">
                    <a4j:commandButton id="idCanTiers20" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers20" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                    <a4j:commandButton id="idCanTiers21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers21" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                    <a4j:commandButton id="idCanTiers22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                    <a4j:commandButton id="idCanTiers23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers23" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                    <a4j:commandButton id="idCanTiers24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers24" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                    <a4j:commandButton id="idCanTiers25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers25" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                    <a4j:commandButton id="idCanTiers26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                    <a4j:commandButton id="idCanTiers27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers27" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="id28">
                    <a4j:commandButton id="idCanTiers28" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers28" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="id43">
                    <a4j:commandButton id="idCanTiers43" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers43" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==46}" var="id46">
                    <a4j:commandButton id="idCanTiers46" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers46" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==77}" var="id77">
                    <a4j:commandButton id="idCanTiers77" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers77" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==100}" var="id00">
                    <a4j:commandButton id="idCanTiers100" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.annuleProduits}" reRender="idSubView,idPanGlobal,panelButton"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers100" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.recuperationProduit}" reRender="idSubView,idPanGlobal,panelButton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                    <a4j:commandButton id="idCanTiers140" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers140" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==142}" var="id142">
                    <a4j:commandButton id="idCanTiers142" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers142" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==281}" var="id281">
                    <a4j:commandButton id="idCanTiers281" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleProduitsRechargement}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers281" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationProduitRechargement}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
            </center>
        </h:panelGroup>
    </a4j:form>


   <rich:modalPanel domElementAttachment="parent"  id="panelProduit" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelDupProduit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelDupProduit}" var="dup">
            <f:facet name="header"><h:outputText value="Dupplication du produit à partir #{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produitsDuppliquer.proCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produitsDuppliquer.proLibClient}"/></f:facet>
            <a4j:form id="formModalDupProd">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" columns="2" columnClasses="clos30,clos70d" id="panelDupProd">
                    <h:column><h:outputText value="Code Produit:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proCode}" maxlength="20" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase" size="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.verouxCod}">
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.testUniciteProduit}" reRender="idpanval,idValDup"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libéllé commercial:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proLibClient}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Libelle technique:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proLibTech}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idpanval">
                    <center>
                        <a4j:commandButton id="idCanDup" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.annuleDuppliquerProduit}" reRender="panelProduit"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDup" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.valideDuppliquerProduit}" reRender="panelProduit,tableProd,scrollTable" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>