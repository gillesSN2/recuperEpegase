<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="taxvte">
    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES TAXES MEDICALES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <h:commandButton title="Ajouter une nouvelle taxe" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.visibleAjt}"/>
                <h:commandButton title="Modifier la taxe sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.visibleMod}"/>
                <a4j:commandButton title="Supprimer la taxe sélectionnée" image="/images/supprimer.png" reRender="table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.removeCompte}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer les taxes" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.datamodel}"  var="taxvte">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.selectionTaxe}" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{taxvte.taxvteCode}" width="10%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{taxvte.taxvteCode}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxvte.taxvteLibelleFr}" width="60%">
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText  value="#{taxvte.taxvteLibelleFr}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxvte.taxvteTaux}" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Taux"  /></f:facet>
                        <h:outputText  value="#{taxvte.taxvteTaux}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxvte.taxvteCompte}"  width="15%">
                        <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                        <h:outputText  value="#{taxvte.taxvteCompte}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxvte.etat}" width="5%">
                        <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                        <h:commandButton image="#{taxvte.etat}"  id="inactif"  rendered="#{taxvte.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.reactiverCompte}">
                            <a4j:support eventsQueue="maQueue" reRender="table"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAjt" width="500" height="450" headerClass="headerPanel" style="border:solid 0px black;background-color:white;overflow:auto"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION DES TAXES DE VENTES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAjt"/>
                <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText id="inptcodAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteCode}" size="5" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteId!=0}">
                            <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp,outptcode,btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.doublonCode}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteLibelleFr}" size="30" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Taux:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteTaux}" size="5"/></h:column>
                    <h:column><h:outputText value="Numéro Compte:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteCompte}">
                            <f:selectItem itemLabel=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.mesComptesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteType}">
                            <f:selectItem itemLabel="TVA sur biens" itemValue="0"/>
                            <f:selectItem itemLabel="TVA sur prestation" itemValue="1"/>
                            <f:selectItem itemLabel="PRECOMPTE (BRS/TPS)" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Timbre:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteTimbre}">
                            <f:selectItem itemLabel="Sans timbre" itemValue="0"/>
                            <f:selectItem itemLabel="Timbre payé par le client" itemValue="1"/>
                            <f:selectItem itemLabel="Timbre non payé" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Compléments:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.taxesVentes.taxvteTc}">
                            <f:selectItem itemLabel="Sans taxes complémentaires" itemValue="0"/>
                            <f:selectItem itemLabel="Centimes additionnels" itemValue="1"/>
                            <f:selectItem itemLabel="Taxe d'égalisation" itemValue="2"/>
                            <f:selectItem itemLabel="Taxe des ordures ménagères" itemValue="3"/>
                            <f:selectItem itemLabel="Taxe d'enregistrement" itemValue="4"/>
                            <f:selectItem itemLabel="IRPP" itemValue="5"/>
                            <f:selectItem itemLabel="Autre Taxe" itemValue="99"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup id="ppgrp">
                <center>
                    <br><br>
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.saveTaxesVentes}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.doublon}"/>
                </center>
                <center>
                    <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesVentes.doublon}"/>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
