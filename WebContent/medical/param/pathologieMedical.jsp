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

        <center><h2><h:outputText value="LISTE DES TYPES DE PATHOLOGIES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelBouton">
            <a4j:commandButton image="/images/ajouter.png" title="ajouter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.chargerPanAdd}"  oncomplete="javascript:Richfaces.showModalPanel('panelAddFormAchats');" reRender="panelAddFormAchats,formulaireajt"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.afficheButtModif}" title="modifier" id="boutonModif" image="/images/modifier.png" oncomplete="javascript:Richfaces.showModalPanel('panelModifFormAchats');" reRender="panelModifFormAchats,formulairemod"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton id="boutonSupp" image="/images/supprimer.png"  title="supprimer"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.afficheButtModif}"   onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.deletePathologieMedical}" reRender="panelBouton,mytableau"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton image="/images/print.png"  title="imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
        </h:panelGroup>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.madatamodel}"  var="phl">
                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.confirmer}" reRender="panelBouton,panelModifFormAchats"/>
                <rich:column  width="15%">
                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                    <h:outputText  value="#{phl.phlCode}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="80%">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{phl.phlLibelle}">
                    </h:outputText>
                </rich:column>
                <rich:column width="5%">
                    <f:facet name="header"><h:outputText  value="Eat"  /></f:facet>
                    <h:commandButton image="#{phl.etat}" rendered="#{phl.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.reactiverPathologieMedical}" title="Supprimer" style="text-align:right;">
                        <a4j:support eventsQueue="maQueue" reRender="panelBouton,mytableau" event="onclick"/>
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



    <rich:modalPanel domElementAttachment="parent"  id="panelAddFormAchats" width="530" height="250"  headerClass="headerPanel" style="border:solid 0px black;background-color:white">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="AJOUT D'UNE PATHOLOGIE" /></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                <rich:componentControl for="panelAddFormAchats" attachTo="hidelink" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulaireajt">
            <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.pathologieMedical.phlCode}" maxlength="4" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText size="45" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.pathologieMedical.phlLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.savePathologieMedical}"  >
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelAddFormAchats,mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <!--**********************   Modal panel pour la modification **************************/-->
    <rich:modalPanel domElementAttachment="parent"  id="panelModifFormAchats"  width="530" height="250"   headerClass="headerPanel" style="border:solid 0px black;background-color:white">

        <f:facet name="header">
            <h:panelGroup><h:outputText value="MODIFICATION D'UNE PATHOLOGIE"/></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink21"/>
                <rich:componentControl for="panelModifFormAchats" attachTo="hidelink21" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulairemod">
            <h:panelGrid columns="2" columnClasses="clos25,clos75">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.pathologieMedical.phlCode}" maxlength="4" readonly="true"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText size="45" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.pathologieMedical.phlLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.inactifModif}"/></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPathologieMedical.upDatePathologieMedical}">
                        <a4j:support eventsQueue="maQueue" event="onclick"  reRender="mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
