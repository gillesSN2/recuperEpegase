<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="affdepprod">

    <a4j:form>

        <center> <h2><h:outputText value="AFFECTATION TARIF PAR FAMILLES DE PRODUITS DE VENTE" style="color:green;"/></h2></center>

        <h:panelGrid  width="100%">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="2" columnClasses="clos50,clos50" width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTarif" border="0" enableContextMenu="false" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelTarif}" var="tar">
                            <rich:column width="10%">
                                <f:facet name="header"><h:outputText value="Sel."/></f:facet>
                                <h:selectBooleanCheckbox value="#{tar.selectFamille}"/>
                            </rich:column>
                            <rich:column width="10%" style="text-align:left;">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{tar.indice}"/>
                            </rich:column>
                            <rich:column width="80%" style="text-align:left;">
                                <f:facet name="header"><h:outputText value="Libellé Tarif" style="text-align:left;"/></f:facet>
                                <h:outputText value="#{tar.libelle}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableFamille" border="0" enableContextMenu="false" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelFamille}" var="fam">
                            <rich:column width="10%">
                                <f:facet name="header"><h:outputText value="Sel."/></f:facet>
                                <h:selectBooleanCheckbox value="#{fam.selectFamille}"/>
                            </rich:column>
                            <rich:column width="20%" style="text-align:left;">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{fam.famvteCode}"/>
                            </rich:column>
                            <rich:column width="70%" style="text-align:left;">
                                <f:facet name="header"><h:outputText value="Libellé famille"/></f:facet>
                                <h:outputText value="#{fam.famvteLibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="panelBoutonTrf">
            <center>
                <h:commandButton id="idAnnule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulePlansAnalytiques}" value="RETOUR" styleClass="exp_lienmenu"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton id="idValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.affectationTarifProduitVtes}" value="Affectation des tarifs par familles" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette opération ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

