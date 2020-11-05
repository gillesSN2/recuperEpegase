<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">

    <a4j:form>

        <center><h2><h:outputText value="LISTE DES MOTIFS D'ENTREE DU PARC" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="4" width="200px">
            <a4j:commandButton title="Ajouter une nouveau motif d'entrée" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.chargerPanAdd}" reRender="panelAddFormAchats,formulaireajt"/>
            <a4j:commandButton title="Modifier le motif sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.afficheButtModif}" reRender="panelAddFormAchats,formulaireajt"/>
            <a4j:commandButton title="Supprimer le motif sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.afficheButtModif}"   onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.deleteUnite}" reRender="panelBouton,mytableau"/>
            <a4j:commandButton title="Imprimer les motifs d'entrée" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.madatamodel}"  var="unite">
                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.selectionUnite}" reRender="panelBouton"/>
                <rich:column  width="10%">
                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                    <h:outputText  value="#{unite.mtpCode}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="40%">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{unite.mtpLibelle}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="20%">
                    <f:facet name="header"><h:outputText  value="Famille"  /></f:facet>
                    <h:outputText  value="#{unite.mtpFamille}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="30%">
                    <f:facet name="header"><h:outputText  value="Type"  /></f:facet>
                    <h:outputText  value="#{unite.mtpType}">
                    </h:outputText>
                </rich:column>
                <rich:column width="5%">
                    <f:facet name="header"><h:outputText  value="Eat"  /></f:facet>
                    <h:commandButton image="#{unite.etat}" rendered="#{unite.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.reactiverUnite}" title="Supprimer" style="text-align:right;">
                        <a4j:support eventsQueue="maQueue" reRender="pan elBouton,mytableau" event="onclick"/>
                    </h:commandButton>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br/>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAddFormAchats" width="530" height="250"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.showPanel}">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="GESTION DES MOTIFS D'ENTREE" /></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAddFormAchats"/>
                <rich:componentControl for="panelAddFormAchats" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>

        <a4j:form id="formulaireajt">
            <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.motifEntreeParc.mtpCode}" style="width:100px;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.motifEntreeParc.mtpId!=0}">
                        <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp,outptcode,btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.doublonCode}"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.motifEntreeParc.mtpLibelle}" style="width:100%;" maxlength="100"/></h:column>
                <h:column><h:outputText value="Famille:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.motifEntreeParc.mtpFamille}" style="width:100%;" maxlength="10"/></h:column>
                <h:column><h:outputText value="Type:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.motifEntreeParc.mtpCodeType}" style="width:100%;">
                        <f:selectItem itemLabel="Diagnostic" itemValue="0"/>
                        <f:selectItem itemLabel="Maintenance" itemValue="1"/>
                        <f:selectItem itemLabel="Réparation" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup id="ppgrp">
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.saveUnite}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.doublon}">
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelAddFormAchats,mytableau"/>
                    </h:commandButton >
                    <center>
                        <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifEntreeParc.doublon}"/>
                    </center>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
