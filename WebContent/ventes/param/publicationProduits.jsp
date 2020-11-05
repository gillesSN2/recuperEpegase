<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="vteproduitspublic">

    <a4j:form id="produitformvte" enctype="multipart/form-data">

        <center><h2><h:outputText value="PUBLICATION DES PRODUITS (VENTE)" style="color:green;"/></h2></center>

        <center>
            <h:panelGroup>
                <a4j:commandButton id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');">
                    <rich:toolTip id="toolprint" followMouse="true" direction="top-right" showDelay="500" value="Imprimer">
                    </rich:toolTip>
                </a4j:commandButton>
            </h:panelGroup>
        </center>
        <br>

        <h:panelGrid   width="100%" >
            <h:panelGrid  columns="1" width="100%" id="recherche" >
                <h:panelGrid  columns="9" styleClass="recherche" width="100%">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.var_CodFind}" style="width:60px;"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.var_LibFind}" style="width:100px;"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.var_FamilleFind}"  style="width:130px;">
                            <f:selectItem itemLabel="Toutes familles" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.mesFamillesVentesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.var_NatureFind}"  style="width:130px;">
                            <f:selectItem itemLabel="Toutes natures" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.mesnaturesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.var_ActiviteFind}" style="width:130px;">
                            <f:selectItem itemLabel="Toutes activités" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.var_ServiceFind}" style="width:130px;">
                            <f:selectItem itemLabel="Tous services" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.rechercherProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="grpProd">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;"  border="0" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" id="extPresVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.datamodelProduit}" var="leproduit">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"  id="a4jpres"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.initPublicSelect}"  />
                        <rich:column sortable="true" sortBy="#{leproduit.proCode}"  width="20%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText id="codprod" value="Code"  /></f:facet>
                            <h:outputText value="#{leproduit.proCode}" />
                        </rich:column>
                        <rich:column  sortable="true" sortBy="#{leproduit.proLibClient}" width="50%">
                            <f:facet name="header" ><h:outputText id="libbelleCod" value="Libellé"  /></f:facet>
                            <h:outputText value="#{leproduit.proLibClient}"/>
                        </rich:column>
                        <rich:column  sortable="true" sortBy="#{leproduit.proVteCode}" width="10%">
                            <f:facet name="header" ><h:outputText id="famille" value="Familles"  /></f:facet>
                            <h:outputText value="#{leproduit.proVteCode}"/>
                        </rich:column>
                        <rich:column  sortable="true" sortBy="#{leproduit.proVteNat}" width="10%">
                            <f:facet name="header" ><h:outputText id="nature" value="Nature"  /></f:facet>
                            <h:outputText value="#{leproduit.proVteNat}"/>
                        </rich:column>
                        <rich:column  sortable="true" sortBy="#{leproduit.publicBool}" width="10%">
                            <f:facet name="header" ><h:outputText id="public" value="Public"  /></f:facet>
                            <h:selectBooleanCheckbox value="#{leproduit.publicBool}">
                                <a4j:support eventsQueue="maQueue" event="onchange"  id="a4jpub"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.changerVersion}"  />
                            </h:selectBooleanCheckbox>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGroup>
        </h:panelGrid>

        <br>
        <center>
            <h:panelGroup>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton id="maj" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:350px;" value="Appliquer les modifications au site e-Commerce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.publierProduit}" >
                    <a4j:support eventsQueue="maQueue" reRender="panelError"/>
                </h:commandButton>
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </h:panelGroup>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelError" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="450" height="150" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.errorConnection}" >
        <center>
            <f:facet name="header"><h:outputText value="Erreur de connexion"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelink1Error"/>
                    <rich:componentControl for="panelError" attachTo="hidelink1Error" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalError" >
                <h:panelGrid id="grpError" columns="1" >
                    <center> <h:outputText value="E-pegase ne parvient pas à se connecter à la base de données de votre site " style="color:red;"/></center>
                    <center> <h:outputText value="Vérifier vos paramêtres de connexion" style=""/></center>
                    <br/>
                    <h:panelGroup id="buton">
                        <center>
                            <h:commandButton id="cancel"  value="Annuler" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.annulerPublier}">
                                <rich:componentControl for="panelError" attachTo="cancel" operation="hide" event="onclick"/>
                            </h:commandButton>
                            &nbsp;&nbsp;&nbsp;
                            <a4j:commandButton   value="Reessayer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPublicationProduits.publierProduit}" reRender="panelError" />
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
