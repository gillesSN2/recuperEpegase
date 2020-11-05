<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficproduitsdepot">

    <a4j:form id="produitformach" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="FICHE PRODUIT (ACHAT/VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
            
            <h:panelGroup id="tabDepot">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauDepot" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelDepot}" var="depotProd">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectProduitDepot}"/>
                        <rich:column  width="7%" sortable="false" sortOrder="ASCENDING" sortBy="#{depotProd.depot.dpoCode}">
                            <f:facet name="header" > <h:outputText value="Dépot"  /></f:facet>
                            <h:outputText value="#{depotProd.depot.dpoCode}"  />
                        </rich:column>
                        <rich:column  width="5%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Group."  /></f:facet>
                            <h:outputText value="#{depotProd.prodepGroupe}" />
                        </rich:column>
                        <rich:column  width="5%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Casier"  /></f:facet>
                            <h:outputText value="#{depotProd.prodepCasier}" />
                        </rich:column>
                        <rich:column  width="6%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                            <f:facet name="header" ><h:outputText value="Coef PR"/></f:facet>
                            <h:outputText value="#{depotProd.prodepCoefPr}" rendered="#{depotProd.prodepCoefPr!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="7%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                            <f:facet name="header" ><h:outputText value="P.R.U"/></f:facet>
                            <h:outputText value="#{depotProd.prodepPr}" rendered="#{depotProd.prodepPr!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="7%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                            <f:facet name="header" ><h:outputText value="P.R.KG"/></f:facet>
                            <h:outputText value="#{depotProd.prodepPrKg}" rendered="#{depotProd.prodepPrKg!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="7%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                            <f:facet name="header" ><h:outputText value="PUMP"/></f:facet>
                            <h:outputText value="#{depotProd.prodepPump}" rendered="#{depotProd.prodepPump!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="6%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Unité"/></f:facet>
                            <h:outputText value="#{depotProd.prodepUnite}" />
                        </rich:column>
                        <rich:column  width="9%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte CMD Achat"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteCmdAch}" rendered="#{depotProd.prodepQteCmdAch!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="9%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte ATT réception"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteAttAch}" rendered="#{depotProd.prodepQteAttAch!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="9%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte CMD vente"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteCmdVte}" rendered="#{depotProd.prodepQteCmdVte!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="9%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte ATT livraison"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteAttVte}" rendered="#{depotProd.prodepQteAttVte!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="10%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte physique"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteStk}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}"/>
                            </h:outputText>
                            <h:outputText value=" soit " rendered="#{depotProd.qteConditionne!=0}"/>
                            <h:outputText value="#{depotProd.qteConditionne}" rendered="#{depotProd.qteConditionne!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="4%" id="etatProdDep" sortable="false" style="text-align:center;" >
                            <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                            <h:commandButton image="#{depotProd.etat}" rendered="#{depotProd.inactif}" onclick="if (!confirm('Voulez-vous réactiver ce élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reactiverProdDep}" title="Supprimer" style="text-align:right;">
                                <a4j:support eventsQueue="maQueue" reRender="etatProdDep,tableauDepot" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGroup>
            <br/>
            <h:panelGroup>
                <center>
                    <h:commandButton value="Recalcul des stocks" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recalculStock}" onclick="if (!confirm('Voulez-vous recalculer les stocks de ce produit ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" title="Recalcul des stocks"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton value="Recalcul des PUMP" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recalculPumpInitProduit}" onclick="if (!confirm('Voulez-vous recalculer les PUMP de ce produit ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" title="Recalcul des PUMP" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"/>
                    <br><br><br>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleSaisie}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>
