<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="centresecurite">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES CENTRES DE SECURITES SOCIALES" style="color:green;font-size:16px;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="3" width="150px">
                <a4j:commandButton title="Modifier la référence sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.modifierCentre}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.visibiliteBton}" reRender="panelCentre"/>
                <a4j:commandButton title="Supprimer la référence sélectionné" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.effacerCentre}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.visibiliteBton}" reRender="modAttente,tableCentre"/>
                <a4j:commandButton title="Imprimer la liste des centres" image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br/>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" id="tableCentre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.dataModel}"  var="nature" >
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.selectionLigne}" reRender="panelBouton"/>
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                    <h:outputText value="#{nature.code}"/>
                </rich:column>
                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.largeurColonne}%">
                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                    <h:outputText  value="#{nature.nom_FR}"/>
                </rich:column>
                <rich:column width="30%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}">
                    <f:facet name="header"><h:outputText  value="Adresse"/></f:facet>
                    <h:outputText value="#{nature.centreAdresse}"/>
                </rich:column>
                <rich:column width="20%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}">
                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetImmatriculation.impm05}"/></f:facet>
                    <h:outputText value="#{nature.centreNumeroImmatriculation}"/>
                </rich:column>
                <rich:column width="20%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}">
                    <f:facet name="header"><h:outputText  value="Téléphones"/></f:facet>
                    <h:outputText value="#{nature.centreTel1} #{nature.centreTel2}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelCentre" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.showModalPanelCentre}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.showModalPanelCentre}" var="rub">
            <f:facet name="header"><h:outputText value="Gestion des centres"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.fermerCentre}" image="/images/close.gif" styleClass="hidelink" reRender="panelCentre"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionCentre" style="width:100%;">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" style="width:100%;" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Code centre:"/></h:column>
                        <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.code}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nom du entre:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.nom_FR}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" style="width:100%;" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Adresse centre:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreAdresse}"/></h:column>
                        <h:column><h:outputText value="Boite Postal:"/></h:column>
                        <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreBP}"/></h:column>
                         <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreVille}"/></h:column>
                        <h:column><h:outputText value="Téléphone 1:"/></h:column>
                        <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreTel1}"/></h:column>
                        <h:column><h:outputText value="Téléphone 2:"/></h:column>
                        <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreTel2}"/></h:column>
                        <h:column><h:outputText value="Fax:"/></h:column>
                        <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreFax}"/></h:column>
                        <h:column><h:outputText value="Nm responsable:"/></h:column>
                        <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreNomResponsable}"/></h:column>
                        <h:column><h:outputText value="Mail responsable:"/></h:column>
                        <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreMail}"/></h:column>
                        <h:column><h:outputText style="color:red" value="Numéro #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetImmatriculation.impm05}:"/></h:column>
                        <h:column><h:inputText maxlength="20" style="color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.objetCompte.centreNumeroImmatriculation}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttonValid">
                        <h:commandButton title="Valider"style="margin-top:10px;" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCentresSecuriteSociale.validerCentre}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
