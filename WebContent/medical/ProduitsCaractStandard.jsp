<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid width="100%"id="prodcarteristique" >
    <h:panelGrid columns="3" width="100%" style="background-color:#DAEECB;" >
        <h:outputText value="Option du produit:"/>
        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
            <f:selectItem itemLabel="Simple" itemValue="0"/>
            <f:selectItem itemLabel="Groupe visible" itemValue="1"/>
            <f:selectItem itemLabel="Groupe invisible" itemValue="2"/>
            <f:selectItem itemLabel="Forfait" itemValue="3"/>
            <f:selectItem itemLabel="Calcul automatique" itemValue="4"/>
            <a4j:support eventsQueue="maQueue" event="onclick" reRender="prodcarteristique,caracteristique,grpButt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.recupererCalc}" />
        </h:selectOneRadio>
        <h:panelGroup id="grpButt">
            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proFormule}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheFormule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
        </h:panelGroup>
    </h:panelGrid>
    <br>
    <h:panelGrid columnClasses="clos50g,clos50g" id="caracteristique" columns="2" width="100%">
        <h:column>
            <h:panelGrid id="caract" columns="2" columnClasses="clos50d,clos50g">
                <h:column><h:outputText value="Etat (Liquide ...):"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <rich:spacer height="10px"/><rich:spacer height="10px"/>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:outputText value="Longueur:" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proLongueur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:outputText value="Largeur:" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proLargeur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:outputText value="épaisseur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proEpaisseur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:outputText value="Volume:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVolume}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <rich:spacer height="10px"/><rich:spacer height="10px"/>
                <h:column><h:outputText value="Poids brut:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPoidsBrut}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column><h:outputText value="Poids net:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPoidsNet}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <rich:spacer height="10px"/><rich:spacer height="10px"/>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:outputText value="Diamètre interne:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proDiamInt}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:outputText value="Diamètre externe:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proDiamExt}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='5'}"><h:outputText value="Densité (Kg/L):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='5'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proDensite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='5'}"><h:outputText value="Pression (B):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_aff_carac=='5'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPression}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
            </h:panelGrid>
        </h:column>

        <h:column>
            <h:panelGrid id="pantableauGrp" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.existGrp}">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauGrp"footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelGrp}" var="depotgrp">
                        <rich:column sortable="false" sortBy="#{depotgrp.progrpCode}" sortOrder="ASCENDING" width="20%">
                            <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{depotgrp.progrpCode}"/>
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{depotgrp.progrpLibelle}"  width="30%">
                            <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                            <h:outputText value="#{depotgrp.progrpLibelle}"/>
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{depotgrp.progrpQte}"  width="20%">
                            <f:facet name="header" ><h:outputText value="Quantité"/></f:facet>
                            <h:outputText value="#{depotgrp.progrpQte}"/>
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{depotgrp.progrpUnite}"  width="15%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Unité"/></f:facet>
                            <h:outputText value="#{depotgrp.progrpUnite}"  />
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{depotgrp.progrpDepot}"  width="15%">
                            <f:facet name="header" ><h:outputText value="Dépot"/></f:facet>
                            <h:outputText value="#{depotgrp.progrpDepot}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="pantableauGrpbis" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.existGrpCode}">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauGrpbis" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelCode}" var="depotgrp">
                        <rich:column sortable="false" sortBy="#{depotgrp.proCode}" sortOrder="ASCENDING" width="30%">
                            <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{depotgrp.proCode}"/>
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{depotgrp.proLibClient}"  width="70%">
                            <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                            <h:outputText value="#{depotgrp.proLibClient}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

        </h:column>
    </h:panelGrid>
</h:panelGrid>
