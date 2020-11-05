<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="commissionliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="CALCUL DES COMMISSIONS" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Commissions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.autorisationDocument}">
                    <jsp:include flush="true" page="/ventes/CommissionsCommun.jsp" />
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.datamodelDetailCommission}" var="var">
                                <rich:column label="N° facture" sortable="true" sortBy="#{var.comligNum}">
                                    <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                    <h:outputText value="#{var.comligNum}"/>
                                </rich:column>
                                <rich:column label="Date facture" sortable="true" sortBy="#{var.comligDate} #{var.comligNum}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{var.comligDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date dernier réglement" sortable="true" sortBy="#{var.comligDateLastReg}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Réglement" /></f:facet>
                                    <h:outputText value="#{var.comligDateLastReg}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Nb Jour" sortable="true" sortBy="#{var.comligNbJour}" style="text-align:center;" width="40px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.modeCommission!='3'}">
                                    <f:facet name="header"><h:outputText  value="Nbj."/></f:facet>
                                    <h:outputText value="#{var.comligNbJour}"/>
                                </rich:column>
                                <rich:column label="Série" sortable="true" sortBy="#{var.comligSerie}" style="text-align:center;" width="40px">
                                    <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                    <h:outputText value="#{var.comligSerie}"/>
                                </rich:column>
                                <rich:column label="Catégorie client" sortable="true" sortBy="#{var.comligCat}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                    <h:outputText value="#{var.comligCat}"/>
                                </rich:column>
                                <rich:column label="Client" sortable="true" sortBy="#{var.comligNomTiers}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                    <h:outputText  value="#{var.comligNomTiers}"/>
                                </rich:column>
                                <rich:column label="Contact/destinataire" sortable="true" sortBy="#{var.comligNomContact}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Contact/destinataire"/></f:facet>
                                    <h:outputText  value="#{var.comligNomContact}"/>
                                </rich:column>
                                <rich:column label="Responsable" sortable="true" sortBy="#{var.comligNomResponsable}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Respponsable"/></f:facet>
                                    <h:outputText  value="#{var.comligNomResponsable}"/>
                                </rich:column>
                                <rich:column label="Commercial" sortable="true" sortBy="#{var.comligNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable=='1'}">
                                    <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                    <h:outputText  value="#{var.comligNomCommercial}"/>
                                </rich:column>
                                <rich:column label="Produit" sortable="true" sortBy="#{var.comligLibelle}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                    <h:outputText  value="#{var.comligLibelle}"/>
                                </rich:column>
                                <rich:column label="Quantité vendue" sortable="true" sortBy="#{var.comligQte}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                    <h:outputText  value="#{var.comligQte}" rendered="#{var.comligQte!=0}"/>
                                </rich:column>
                                <rich:column label="Total vente" sortable="true" sortBy="#{var.comligTotHt}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Total HT"/></f:facet>
                                    <h:outputText  value="#{var.comligTotHt}" rendered="#{var.comligTotHt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Nature commission" sortable="true" sortBy="#{var.comligComUnite}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Com."/></f:facet>
                                    <h:outputText  value="#{var.comligComUnite}" rendered="#{var.comligComUnite!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Nature commission" sortable="true" sortBy="#{var.comligComPourcentage}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="%Com."/></f:facet>
                                    <h:outputText  value="#{var.comligComPourcentage}" rendered="#{var.comligComPourcentage!=0}"/>
                                </rich:column>
                                <rich:column label="Total commission" sortable="true" sortBy="#{var.comligTotCommission}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Commission"/></f:facet>
                                    <h:outputText  value="#{var.comligTotCommission}" rendered="#{var.comligTotCommission!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </rich:tab>

                <rich:tab id="tabReg" label="Règlements" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.autorisationReglement}">
                    <jsp:include flush="true" page="/ventes/CommissionsCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.datamodelRecu}" var="recu" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annuleCommission}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

</f:subview>
