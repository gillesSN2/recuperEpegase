<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersCadeaux">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="CADEAUX : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableCadeaux" maxPages="20" align="left" for="tableCadeaux"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" styleClass="bg" id="tableCadeaux" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" style="max-height:100%"  width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelCadeaux}" var="cad">
                        <rich:column label="Date visite" sortable="true" sortBy="#{cad.cadDate}" width="10%">
                            <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                            <h:outputText value="#{par.camparDate}">
                                <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Campagne" sortable="true" sortBy="#{cad.cadCampagne}" width="10%">
                            <f:facet name="header"><h:outputText  value="Campagne"/></f:facet>
                            <h:outputText value="#{cad.cadCampagne}"/>
                        </rich:column>
                        <rich:column label="Nom prénom du participant" sortable="true" sortBy="#{cad.cadNomContact}" width="20%">
                            <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                            <h:outputText value="#{cad.cadNomContact}"/>
                        </rich:column>
                        <rich:column label="Code prouit" sortable="true" sortBy="#{cad.cadCode}" width="10%">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText value="#{cad.cadCode}"/>
                        </rich:column>
                        <rich:column label="Libelle produit" sortable="true" sortBy="#{cad.cadLibelle}" width="30%">
                            <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                            <h:outputText  value="#{cad.cadLibelle}"/>
                        </rich:column>
                        <rich:column label="Dépôt" sortable="true" sortBy="#{cad.cadDepot}" width="10%">
                            <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                            <h:outputText  value="#{cad.cadDepot}"/>
                        </rich:column>
                        <rich:column label="Quantité" sortable="true" sortBy="#{cad.cadQte}" width="10%">
                            <f:facet name="header"><h:outputText  value="Qte."/></f:facet>
                            <h:outputText  value="#{cad.cadQte}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourCadeaux}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>
