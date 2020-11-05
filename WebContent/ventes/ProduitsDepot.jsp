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

        <center><h2><h:outputText value="FICHE PRODUIT (VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <h:panelGrid columns="4"  width="100%" style="background-color:#DAEECB;">
                <h:column><h:outputText value="Code produit:"/></h:column>
                <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCode}" style="width:200px;"/></h:column>
                <h:column><h:outputText value="Libellé client:"/></h:column>
                <h:column><h:inputText size="60" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLibClient}" /></h:column>
            </h:panelGrid>
            <br>
            <h:panelGroup id="tabDepot">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauDepot" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelDepot}" var="depotProd">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonDep"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectProduitDepot}"    />
                        <rich:column  width="10%" sortable="false" sortOrder="ASCENDING" sortBy="#{depotProd.depot.dpoCode}">
                            <f:facet name="header" > <h:outputText value="Dépot"  /></f:facet>
                            <h:outputText value="#{depotProd.depot.dpoCode}"  />
                        </rich:column>
                        <rich:column  width="20%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Localisation / Casier"  /></f:facet>
                            <h:outputText value="#{depotProd.prodepLocalisation} #{depotProd.prodepCasier}" />
                        </rich:column>
                        <rich:column  width="12%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte CMD Achat"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteCmdAch}" />
                        </rich:column>
                        <rich:column  width="12%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte ATT réception"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteAttAch}" />
                        </rich:column>
                        <rich:column  width="12%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte CMD vente"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteCmdVte}" />
                        </rich:column>
                        <rich:column  width="12%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte ATT livraison"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteAttVte}" />
                        </rich:column>
                        <rich:column  width="12%" sortable="false" style="text-align:right;" >
                            <f:facet name="header" ><h:outputText value="Qte physique"/></f:facet>
                            <h:outputText value="#{depotProd.prodepQteStk}" />
                        </rich:column>
                        <rich:column  width="10%" id="etatProdDep" sortable="false" style="text-align:center;" >
                            <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                            <h:commandButton image="#{depotProd.etat}" rendered="#{depotProd.inactif}" onclick="if (!confirm('Voulez-vous réactiver ce élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.reactiverProdDep}" title="Supprimer" style="text-align:right;">
                                <a4j:support eventsQueue="maQueue" reRender="etatProdDep,tableauDepot" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGroup>
            <br/>
            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleSaisie}" reRender="idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>
