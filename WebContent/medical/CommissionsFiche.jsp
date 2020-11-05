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

                <rich:tab id="tabDoc" label="Commissions">
                    <jsp:include flush="true" page="/medical/CommissionsCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.datamodelDetailCommission}" var="var">
                            <rich:column label="Nature" sortable="true" sortBy="#{var.comligNature}" width="5%">
                                <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                                <h:outputText value="#{var.comligNature}"/>
                            </rich:column>
                            <rich:column label="N° facture" sortable="true" sortBy="#{var.comligNum}" width="10%">
                                <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                <h:outputText value="#{var.comligNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="true" sortBy="#{var.comligDate} #{var.comligNum}" width="10%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.comligDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Prise en charge" sortable="true" sortBy="#{var.comligNomEquipe}" width="10%">
                                <f:facet name="header"><h:outputText  value="PEC"/></f:facet>
                                <h:outputText value="#{var.comligNomEquipe}"/>
                            </rich:column>
                            <rich:column label="Patient" sortable="true" sortBy="#{var.comligNomTiers}" width="20%">
                                <f:facet name="header"><h:outputText  value="Patient"/></f:facet>
                                <h:outputText  value="#{var.comligNomTiers}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="true" sortBy="#{var.comligLibelle}" width="12%">
                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                <h:outputText  value="#{var.comligLibelle}"/>
                            </rich:column>
                            <rich:column label="Quantité vendue" sortable="true" sortBy="#{var.comligQte}" style="text-align:right" width="5%">
                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                <h:outputText  value="#{var.comligQte}" rendered="#{var.comligQte!=0}"/>
                            </rich:column>
                            <rich:column label="Total vente" sortable="true" sortBy="#{var.comligTotHt}" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="P.U."/></f:facet>
                                <h:outputText  value="#{var.comligTotHt}" rendered="#{var.comligTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="% commission" sortable="true" sortBy="#{var.comligComPourcentage}" style="text-align:right" width="8%">
                                <f:facet name="header"><h:outputText  value="%"/></f:facet>
                                <h:outputText  value="#{var.comligComPourcentage}" rendered="#{var.comligComPourcentage!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total commission" sortable="true" sortBy="#{var.comligTotCommission}" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Commission"/></f:facet>
                                <h:outputText  value="#{var.comligTotCommission}" rendered="#{var.comligTotCommission!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabReg" label="Règlements">
                    <jsp:include flush="true" page="/medical/CommissionsCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.datamodelRecu}" var="recu" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.annuleCommission}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


</f:subview>
