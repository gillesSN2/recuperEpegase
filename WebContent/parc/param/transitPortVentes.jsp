<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="traprt">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES PORTS, AEROPORTS, GARES, AGENCES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <h:commandButton title="Ajouter un nouvel élément" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.visibleAjt}"/>
                <h:commandButton title="Modifier l'élément sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.visibleMod}"/>
                <a4j:commandButton title="Supprimer l'élément sélectionné" image="/images/supprimer.png" reRender="table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.removeCompte}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer les éléments" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable footerClass="bard" headerClass="headerTab" border="0" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" id="table" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.datamodel}"  var="forvte">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.selectionFormule}" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{forvte.traprtNature}" width="15%" >
                        <f:facet name="header"><h:outputText  value="Nature"  /></f:facet>
                        <h:outputText  value="#{forvte.libelleNature}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{forvte.traprtCode}" width="15%" >
                        <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                        <h:outputText  value="#{forvte.traprtCode}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{forvte.traprtLibelleFr}" width="40%" >
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText  value="#{forvte.traprtLibelleFr}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{forvte.traprtKms}" width="15%;" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Distance"/></f:facet>
                        <h:outputText  value="#{forvte.traprtKms}" rendered="#{forvte.traprtKms!=0}" style="text-align:right"/>
                    </rich:column>
                    <rich:column width="5%">
                        <f:facet name="header"><h:outputText value="Etat"  /></f:facet>
                        <h:commandButton image="#{forvte.etat}"  id="inactif"  rendered="#{forvte.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.reactiverCompte}">
                            <a4j:support eventsQueue="maQueue" reRender="table"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAjt" width="800" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION DES PORTS, AEROPORTS, GARES, AGENCES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAjt"/>
                <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;">
                <h:panelGrid  columns="2" style="width:100%;">
                    <h:outputText value="Nature:"/>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.transitPortVentes.traprtNature}">
                        <f:selectItem itemLabel="Sélectionnez une nature" itemValue=""/>
                        <f:selectItem itemLabel="Maritime" itemValue="1"/>
                        <f:selectItem itemLabel="Fluvial" itemValue="2"/>
                        <f:selectItem itemLabel="Aérien" itemValue="3"/>
                        <f:selectItem itemLabel="Routier" itemValue="4"/>
                        <f:selectItem itemLabel="Ferrovier" itemValue="5"/>
                        <f:selectItem itemLabel="Agence" itemValue="6"/>
                    </h:selectOneMenu>
                    <h:outputText value="Code:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.transitPortVentes.traprtCode}" size="10" maxlength="20"/>
                    <h:outputText value="Libellé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.transitPortVentes.traprtLibelleFr}" style="width:90%;" maxlength="100"/>
                    <h:outputText value="Distance (kms):"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.transitPortVentes.traprtKms}" size="10"/>
                </h:panelGrid>
            </h:panelGroup>
            <center>
                <br><br>
                <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTransitPortVentes.saveFormules}"/>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
