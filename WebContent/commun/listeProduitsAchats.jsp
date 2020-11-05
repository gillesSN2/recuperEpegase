<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeProduit">

    <a4j:form id="formModalListeProduit">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU PRODUIT (ACHAT)"/></f:facet>
        </h:panelGrid>
        <br>
        <h:panelGroup id="idAjout" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature<=20}" style="height:35px">
            <center>
                <a4j:commandButton id="idDup" title="Duppliquer Produit" image="/images/duplicate.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.duppliquerProduit}" reRender="panelProduit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
            </center>
        </h:panelGroup>
        <br>
        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableProd"/>
                <rich:extendedDataTable rows="200" id="tableProd" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="130%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelProduits}" var="prd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionProduit}" reRender="idVal,idAjout"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==10}" var="ids10">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="ids11">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="ids12">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="ids13">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="ids14">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="ids15">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="ids16">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="ids17">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="ids18">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==30}" var="ids30">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==31}" var="ids31">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==32}" var="ids32">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonSortie.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==33}" var="ids33">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="ids34">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="ids35">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==46}" var="ids46">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.recuperationProduit}" reRender="idSubView,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==100}" var="ids100">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recuperationProduitOutils}" reRender="idSubView,compteId"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==341}" var="ids341">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.recuperationProduit}" reRender="idSubView,idProcessProduit"/>
                    </c:if>
                    <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{prd.proCode}"/>
                    </rich:column>
                    <rich:column label="Photo Produit" width="35px" sortable="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.photosProduit=='1'}">
                        <f:facet name="header" ><h:outputText value="Pho."/></f:facet>
                        <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/produits/photo/#{prd.proPhoto}" alt="pho" height="30px" width="30px" style="text-align:center" rendered="#{prd.proPhoto!=null}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="30%" filterBy="#{prd.proLibClient}">
                        <f:facet name="header"><h:outputText  value="Libellé commercial" /></f:facet>
                        <h:outputText value="#{prd.proLibClient}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibTech}" width="20%">
                        <f:facet name="header"><h:outputText  value="Libellé technique" /></f:facet>
                        <h:outputText value="#{prd.proLibTech}"/>
                    </rich:column>
                    <rich:column label="Longueur produit" sortable="true" sortBy="#{prd.proLongueur}" style="text-align:right;" width="50px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.optionAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.optionAchats.modeCalculDevis=='1'}">
                        <f:facet name="header"><h:outputText  value="Lg" /></f:facet>
                        <h:outputText value="#{prd.proLongueur}" style="text-align:right;"/>
                    </rich:column>
                    <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="15%">
                        <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                        <h:outputText value="#{prd.proVteLib}"/>
                    </rich:column>
                    <rich:column label="Contionnement" sortable="true" sortBy="#{prd.proCondition1}" width="10%">
                        <f:facet name="header"><h:outputText  value="Condit." /></f:facet>
                        <h:outputText value="#{prd.proCondition1}"/>
                    </rich:column>
                    <rich:column label="Gestion stock" sortable="true" sortBy="#{prd.proStock}" width="10%">
                        <f:facet name="header"><h:outputText  value="Stock" /></f:facet>
                        <h:outputText value="#{prd.lib_stock}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==10}" var="id10">
                    <a4j:commandButton id="idCanTiers10" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers10" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="id11">
                    <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers11" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                    <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers12" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="id13">
                    <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers13" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="id14">
                    <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers14" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="id15">
                    <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers15" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="id16">
                    <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers16" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="id17">
                    <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers17" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="id18">
                    <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers18" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==30}" var="id30">
                    <a4j:commandButton id="idCanTiers30" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers30" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==31}" var="id31">
                    <a4j:commandButton id="idCanTiers31" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers31" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==32}" var="id32">
                    <a4j:commandButton id="idCanTiers32" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonSortie.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers32" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonSortie.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==33}" var="id33">
                    <a4j:commandButton id="idCanTiers33" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers33" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}" var="id34">
                    <a4j:commandButton id="idCanTiers34" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers34" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="id35">
                    <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers35" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==46}" var="id46">
                    <a4j:commandButton id="idCanTiers46" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.annuleProduits}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers46" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.recuperationProduit}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==100}" var="id100">
                    <a4j:commandButton id="idCanTiers100" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleProduitsOutils}" reRender="idSubView,compteId"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers100" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recuperationProduitOutils}" reRender="idSubView,compteId" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==341}" var="id341">
                    <a4j:commandButton id="idCanTiers341" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.annuleProduits}" reRender="idSubView,idProcessProduit"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers341" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.recuperationProduit}" reRender="idSubView,idProcessProduit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectProduits}"/>
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