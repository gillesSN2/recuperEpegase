<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="outilscorrectionJournaux">

    <a4j:form >
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="OUTILS DE CORRECTION DES PRODUITS" styleClass="titre"/></h2></center>

        <h:panelGrid  styleClass="fichefournisseur"columns="3">
            <rich:column width="20%">
                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.outilChoisi}" style="margin-left:90px;width:45%;">
                    <f:selectItem itemLabel="Sélectionner l'outil" itemValue="99"/>
                    <f:selectItem itemLabel="Changer Code" itemValue="5"/>
                    <f:selectItem itemLabel="Changer Dépot"itemValue="6"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="selectOutil,executer" />
                </h:selectOneMenu >
            </rich:column>

            <rich:column width="30%">
                <h:panelGrid id="selectOutil" columns="4">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.outilChoisi==5}">
                        <h:column><h:outputText value="Nouveau Code:"/></h:column>
                        <h:column>
                            <h:inputText id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.toolsCompteOld}" style="width:180px">
                                <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un coe produit ou un libelle produit" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.rechercheProduitsutils}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,compteId"/>
                            </h:inputText>
                        </h:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.outilChoisi==6}">
                        <h:column><h:outputText value="Nouveau Dépôt:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="depotId" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.toolsDepotOld}">
                                <f:selectItem itemLabel="Sans dépôt" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.mesProduitsDepotsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </c:if>
                </h:panelGrid>
            </rich:column>

            <h:panelGrid width="50%" id="executer" columns="4">
                <a4j:commandButton reRender="tableEcritures,scrollTable" value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectionAll}" />
                <a4j:commandButton reRender="tableEcritures,scrollTable" value="Tout dé-sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.deselectionAll}"/>
                <h:commandButton value="EXECUTER CORRECTION" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.validerInterchange}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.outilChoisi!=99}"  onclick="if (!confirm('Etes-vous sur de vouloir exécuter la mise à jour?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleInterchange}" styleClass="fermer"/>
            </h:panelGrid>

        </h:panelGrid>

        <br>

        <h:panelGrid width="100%" id="richpanlisteECR" styleClass="fichefournisseur1">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" reRender="tableEcritures" id="scrollTable" maxPages="20"align="left" for="tableEcritures"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_nb_max}" style="max-height:100%;border:solid 0px green;" id="tableEcritures" styleClass="bg" width="100%" border="0"  footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" sortMode="multi" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelMvt}" var="mvt">
                    <rich:column  width="5%" sortable="true" sortBy="#{mvt.stk_type}">
                        <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                        <h:selectBooleanCheckbox value="#{mvt.select}" />
                    </rich:column>
                    <rich:column  width="5%" sortable="true" sortBy="#{mvt.stk_type}">
                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                        <h:outputText value="#{mvt.stk_lib_type}" />
                    </rich:column>
                    <rich:column  width="5%" sortable="true" sortBy="#{mvt.stk_etat}">
                        <f:facet name="header">
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_lib_etat}"/>
                        </f:facet>
                        <h:outputText value="#{mvt.stk_etat}" />
                    </rich:column>
                    <rich:column  width="6%" sortable="true" sortBy="#{mvt.stk_code_depot}" >
                        <f:facet name="header" ><h:outputText value="Dépôt" /></f:facet>
                        <h:outputText value="#{mvt.stk_code_depot}" />
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_date_mvt}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Date" /></f:facet>
                        <h:outputText value="#{mvt.stk_date_mvt}">
                            <f:convertDateTime pattern="dd/MM/yy  HH:MM" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_numero}" >
                        <f:facet name="header" ><h:outputText value="Numéro" /></f:facet>
                        <h:outputText value="#{mvt.stk_numero}" />
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_qte_in}" style="text-align:right;">
                        <f:facet name="header" >
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_lib_qteIn}" />
                        </f:facet>
                        <h:outputText value="#{mvt.stk_qte_in}" rendered="#{mvt.stk_qte_in!=0}"/>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_qte_out}" style="text-align:right;">
                        <f:facet name="header" >
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_lib_qteOut}" />
                        </f:facet>
                        <h:outputText value="#{mvt.stk_qte_out}" rendered="#{mvt.stk_qte_out!=0}"/>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_qte_progress}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheProgress}">
                        <f:facet name="header" >
                            <h:outputText value="Progres." style="color:red"/>
                        </f:facet>
                        <h:outputText value="#{mvt.stk_qte_progress}" rendered="#{mvt.stk_qte_progress!=0}" style="color:red"/>
                    </rich:column>
                    <rich:column  width="3%" sortable="true" sortBy="#{mvt.stkDevise}">
                        <f:facet name="header" ><h:outputText value="Dev." /></f:facet>
                        <h:outputText value="#{mvt.stkDevise}"/>
                    </rich:column>
                    <rich:column  width="4%" sortable="true" sortBy="#{mvt.stk_devise}"  style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="ceof." /></f:facet>
                        <h:outputText value="#{mvt.stk_devise}" rendered="#{mvt.stk_devise!=0}"/>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_pa}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="P.R." /></f:facet>
                        <h:outputText value="#{mvt.stk_pa}" rendered="#{mvt.stk_pa!=0&&mvt.stk_format_devise==0}">
                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:outputText>
                        <h:outputText value="#{mvt.stk_pa}" rendered="#{mvt.stk_pa!=0&&mvt.stk_format_devise==1}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:outputText>
                        <h:outputText value="#{mvt.stk_pa}" rendered="#{mvt.stk_pa!=0&&mvt.stk_format_devise==2}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_pump}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="P.U.M.P." /></f:facet>
                        <h:outputText value="#{mvt.stk_pump}" rendered="#{mvt.stk_pump!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_pv}" style="text-align:right;">
                        <f:facet name="header" >
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_lib_pv}" />
                        </f:facet>
                        <h:outputText value="#{mvt.stk_pv}" rendered="#{mvt.stk_pv!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="3%" sortable="true" sortBy="#{mvt.stk_divers}" >
                        <f:facet name="header" ><h:outputText value="Type" /></f:facet>
                        <h:outputText value="#{mvt.stk_divers}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>

</f:subview>
