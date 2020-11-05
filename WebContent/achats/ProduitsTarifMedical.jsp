<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tarifMed">

    <center>
        <h:panelGroup id="panelBoutonTarif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action!=3}">
            <a4j:commandButton title="Ajouter tarif" oncomplete="javascript:Richfaces.showModalPanel('panelAddTrif');"  image="/images/ajouter.png" reRender="panelAddTrif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.chargeModalTarifAjt}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}"/>&nbsp; &nbsp;&nbsp;
            <a4j:commandButton title="Modifier tarif" oncomplete="javascript:Richfaces.showModalPanel('panelModifTarif');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.chargeModalTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" image="/images/modifier.png" reRender="panelModifTarif"/>&nbsp; &nbsp;&nbsp;
            <a4j:commandButton title="Supprimer tarif"  image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtSuppProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.deleteProduitTarif}" reRender="tableauTarif"/>
        </h:panelGroup>
    </center>
    <br>

    <a4j:form id="tableTarif">
        <rich:hotKey key="return" handler="return false;"/>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauTarif" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelTarif}" var="tarif">
                <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonTarif"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.initProduitTarifSelected}"    />
                <rich:column sortable="false" sortBy="#{tarif.protarOrdre}" sortOrder="ASCENDING" width="5%" style="text-align:center;">
                    <f:facet name="header" ><h:outputText value="Ord."  /></f:facet>
                    <h:outputText value="#{tarif.protarOrdre}" />
                </rich:column>
                <rich:column sortable="false" width="30%">
                    <f:facet name="header" ><h:outputText value="Famille medical"/></f:facet>
                    <h:outputText value="#{tarif.protarClient}"/>
                </rich:column>
                <rich:column sortable="false" width="20%">
                    <f:facet name="header" ><h:outputText value="Condtionnement"/></f:facet>
                    <h:outputText value="#{tarif.protarCondit}"/>
                </rich:column>
                <rich:column sortable="false" width="15%" style="text-align:right;">
                    <f:facet name="header" ><h:outputText value="Coéfficient"/></f:facet>
                    <h:outputText value="#{tarif.protarCoef}" />
                </rich:column>
                <rich:column sortable="false" width="25%" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Prix de vente#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.htTtc}"/></f:facet>
                    <h:outputText value="#{tarif.protarPv}" >
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column sortable="false" width="5%" id="etatProdTar" style="text-align:center;">
                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                    <h:commandButton image="#{tarif.etat}" rendered="#{tarif.inactif}" onclick="if (!confirm('Voulez-vous réactiver ce journal ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reactiverProdTarif}" title="Supprimer" style="text-align:right;">
                        <a4j:support eventsQueue="maQueue" reRender="etatProdTar,tableauTarif" event="onclick"/>
                    </h:commandButton>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelAddTrif" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" >
        <f:facet name="header">
            <h:panelGroup><h:outputText value="AJOUT DE TARIF"></h:outputText></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkAddTarif">
                </h:graphicImage>
                <rich:componentControl for="panelAddTrif" attachTo="hidelinkAddTarif" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGrid columns="2" columnClasses="clos35,clos65g" width="100%">
                <h:column><h:outputText value="Famille client:"/></h:column>
                <h:column>
                    <h:selectOneMenu id="depIDord" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarClient}">
                        <f:selectItem itemLabel="Sélectionnez la famille"  itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesNaturesClientItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="depIDord,buttGrpProdFour,bbbbbSaveTar,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decouperMesTarifItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Conditionnement:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarCondit}">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="depIDord,buttGrpProdFour,bbbbbSaveTar,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decouperMesTarifItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
                <h:column><h:outputText value="Coéfficient:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarCoef}"  style="width:60px"/></h:column>
                <h:column><h:outputText value="Prix de vente:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPv}"/></h:column>
            </h:panelGrid>
            <br/>  <br/>
            <center>
                <h:panelGroup  id="buttGrpProdFour">
                    <h:commandButton image="/images/valider_big.png" id="bbbbbSaveTar" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.saveProduitsTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.testDoubleProduitsTarif}">
                        <rich:componentControl for="panelAddTrif" attachTo="bbbbbSaveTar" operation="hide" event="onclick"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="tableauTarif"/>
                    </h:commandButton >
                    <h:outputText  id="outpAjt" style="color:red;" value="La famille et le conditionnement doivent être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.testDoubleProduitsTarif}"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelModifTarif" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" >
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="MODIFICATION DE TARIF"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkModTarif">
                </h:graphicImage>
                <rich:componentControl for="panelModifTarif" attachTo="hidelinkModTarif" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGrid columns="2" columnClasses="clos35,clos65g" width="100%">
                <h:outputText value="Famille client:"/>
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarClient}"></h:outputText>
                <h:outputText value="Coéfficient:"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarCoef}"  style="width:60px"/>
                <h:outputText value="Prix de vente:"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPv}"/>
                <h:panelGroup>
                    <h:outputText value="Inactif:"/>
                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpInactifProdTarif}"/>
                </h:panelGroup>
            </h:panelGrid>
            <br/><br/>
            <center>
                <h:panelGroup>
                    <a4j:commandButton image="/images/valider_big.png" id="bUpdatTar">
                        <rich:componentControl for="panelModifTarif" attachTo="bUpdatTar" operation="hide" event="onclick"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.updateProduitsTarif}" reRender="tableTarif"/>
                    </a4j:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>

    </rich:modalPanel>
            
</f:subview>