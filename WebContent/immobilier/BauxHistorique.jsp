<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="facturehistoriqueliste">

    <a4j:form>

        <center> <h2><h:outputText value="HISORIQUE DES FACTURES DU BAIL N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNum}" style="color:green;"/></h2></center>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.dataModelHistorique}" var="var">
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.biefacNum}">
                            <f:facet name="header"><h:outputText  value="N° FACTURE" /></f:facet>
                            <h:outputText value="#{var.biefacNum}"/>
                        </rich:column>
                        <rich:column label="Date facture" sortable="true" sortBy="#{var.biefacDate} #{var.biefacNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.biefacDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.biefacSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.biefacSerie}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.biefacEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Locataire" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Locataire"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Propriétaire" sortable="true" sortBy="#{var.var_nom_proprietaire}" width="200px">
                            <f:facet name="header"><h:outputText value="Propriétaire"/></f:facet>
                            <h:outputText  value="#{var.var_nom_proprietaire}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.biefacTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                            <h:outputText  value="#{var.biefacTotHt}" rendered="#{var.biefacTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.var_taxes}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                            <h:outputText  value="#{var.var_taxes}" rendered="#{var.var_taxes!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.biefacTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                            <h:outputText  value="#{var.biefacTotTtc}" rendered="#{var.biefacTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements" sortable="true" sortBy="#{var.biefacTotReglement}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                            <h:outputText  value="#{var.biefacTotReglement}" rendered="#{var.biefacTotReglement!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                            <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                            <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date dernier règlement" sortable="true" sortBy="#{var.biefacDateLastReg}" width="70px">
                            <f:facet name="header"><h:outputText value="Last.Reg." /></f:facet>
                            <h:outputText value="#{var.biefacDateLastReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="IRPP" sortable="true" sortBy="#{var.biefacTotalIrpp}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Irpp"  /></f:facet>
                            <h:outputText  value="#{var.biefacTotalIrpp}" rendered="#{var.biefacTotalIrpp!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Bien" sortable="true" sortBy="#{var.biefacBien}" >
                            <f:facet name="header"><h:outputText value="Bien"  /></f:facet>
                            <h:outputText  value="#{var.biefacBien}"/>
                        </rich:column>
                        <rich:column label="Bail" sortable="true" sortBy="#{var.biefacBail}" >
                            <f:facet name="header"><h:outputText value="Bail"  /></f:facet>
                            <h:outputText  value="#{var.biefacBail}"/>
                        </rich:column>
                        <rich:column label="Objet de la facture" sortable="true" sortBy="#{var.biefacObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.biefacObject}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.biefacDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                            <h:outputText  value="#{var.biefacDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.biefacNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.biefacNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.biefacNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.optionsVentes.responsable=='1'}">
                            <f:facet name="header"><h:outputText  value="Commercial"  /></f:facet>
                            <h:outputText  value="#{var.biefacNomCommercial}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_nb_ligne})" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

        <h:panelGroup id="panelValide">
            <center>
                <br><br>
                <h:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.retourListeBail}"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>
