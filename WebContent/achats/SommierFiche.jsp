<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="subdevajout">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES SOMMIERS" style="color:green;"/></h2></center>

            <h:panelGrid width="100%">
                <h:panelGrid width="100%" styleClass="fichefournisseur">
                    <jsp:include flush="true" page="SommierCommun.jsp"/>
                </h:panelGrid>
                <br>
                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabSynthese" label="Synthèse">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableSynthese" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.dataModelFusion}" var="fus">
                                <rich:column label="Code" sortable="true" sortBy="#{fus.recligCode}" width="150px" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{fus.recligCode}"/>
                                </rich:column>
                                <rich:column label="Libellé" sortable="true" sortBy="#{fus.recligLibelle}" width="250px">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{fus.recligLibelle}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="true" sortBy="#{fus.recligQte}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Qte Reçue"/></f:facet>
                                    <h:outputText value="#{fus.recligQte}" rendered="#{fus.recligQte!=0}"/>
                                </rich:column>
                                <rich:column label="Unité" sortable="true" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{fus.recligUnite}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="true" sortBy="#{fus.qte_cession}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Qte Sortie"/></f:facet>
                                    <h:outputText value="#{fus.qte_cession}" rendered="#{fus.qte_cession!=0}"/>
                                </rich:column>
                                <rich:column label="Unité" sortable="true" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{fus.unite_cession}"/>
                                </rich:column>
                                <rich:column label="Solde" sortable="true" sortBy="#{fus.qte_solde}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Solde"/></f:facet>
                                    <h:outputText value="#{fus.qte_solde}" rendered="#{fus.qte_solde!=0}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabDetail" label="Détail">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.dataModelDetail}" var="det">
                                <rich:column label="Dépôt" sortable="true" sortBy="#{det.recligDepot}">
                                    <f:facet name="header"><h:outputText value="Dépôt"/></f:facet>
                                    <h:outputText value="#{det.recligDepot}"/>
                                </rich:column>
                                <rich:column label="Code" sortable="true" sortBy="#{det.recligCode}" width="150px" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{det.recligCode}"/>
                                </rich:column>
                                <rich:column label="Libellé" sortable="true" sortBy="#{det.recligLibelle}" width="250px">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{det.recligLibelle}"/>
                                </rich:column>
                                <rich:column label="Date réception" sortable="true" sortBy="#{som.receptionEnteteAchats.recDate}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{det.receptionEnteteAchats.recDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="N° Réception" sortable="true" sortBy="#{det.receptionEnteteAchats.recNum}">
                                    <f:facet name="header"><h:outputText value="Réception"/></f:facet>
                                    <h:outputText value="#{det.receptionEnteteAchats.recNum}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="true" sortBy="#{det.recligQte}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                    <h:outputText value="#{det.recligQte}" rendered="#{det.recligQte!=0}"/>
                                </rich:column>
                                <rich:column label="Unité" sortable="true" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{det.recligUnite}"/>
                                    <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.ouvertureLot}" rendered="#{det.recligStock==2||det.recligStock==3||det.recligStock==4}" reRender="panelLot,formModalLot,panelDetailLot" style="width:100%"/>
                                    <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.ouvertureSerie}" rendered="#{det.recligStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                </rich:column>
                                <rich:column label="N° Cession" sortable="true" sortBy="#{det.num_cession}">
                                    <f:facet name="header"><h:outputText value="Cession"/></f:facet>
                                    <h:outputText value="#{det.num_cession}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="true" sortBy="#{det.qte_cession}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                    <h:outputText value="#{det.qte_cession}" rendered="#{det.qte_cession!=0}"/>
                                </rich:column>
                                <rich:column label="Unité" sortable="true" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{det.unite_cession}"/>
                                    <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.ouvertureLotCession}" rendered="#{det.stk_cession==2||det.stk_cession==3||det.stk_cession==4}" reRender="panelLot,formModalLot,panelDetailLot" style="width:100%"/>
                                    <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.ouvertureSerieCession}" rendered="#{det.stk_cession==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
            </h:panelGrid>
            <br/>
            <h:panelGrid columns="1" cellspacing="1" styleClass="recherche" width="100%">
                <h:panelGrid  columns="3" cellspacing="3" cellpadding="3">
                    <h:outputText value="Total quantité entrée: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.total_qte_recu}"/>
                    <h:outputText value="Total quantité sortie: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.total_qte_sortie}"/>
                    <h:outputText value="Solde quantité: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.solde_qte}"/>
                </h:panelGrid>
            </h:panelGrid>
            <br/>
            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSommierAchats.fermerDetail}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>

</f:subview>
