<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="taxach">
    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES TAXES DES ACHATS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <h:commandButton title="Ajouter une nouvelle taxe" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.visibleAjt}"/>
                <h:commandButton title="Modifier la taxe sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.visibleMod}"/>
                <a4j:commandButton title="Supprimer la taxe sélectionnée" image="/images/supprimer.png" reRender="table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.removeCompte}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer les taxes" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.datamodel}"  var="taxach">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.selectionTaxe}" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{taxach.taxachCode}" width="10%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{taxach.taxachCode}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxach.taxachLibelleFr}" width="60%">
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText  value="#{taxach.taxachLibelleFr}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxach.taxachTaux}" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Taux"  /></f:facet>
                        <h:outputText  value="#{taxach.taxachTaux}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxach.taxachCompte}"  width="15%">
                        <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                        <h:outputText  value="#{taxach.taxachCompte}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{taxach.etat}" width="5%">
                        <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                        <h:commandButton image="#{taxach.etat}"  id="inactif"  rendered="#{taxach.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.reactiverCompte}">
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



    <rich:modalPanel domElementAttachment="parent"  id="panelAjt" width="500" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION DES TAXES D'ACHATS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAjt"/>
                <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText id="inptcodAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachCode}" size="5" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachId!=0}">
                            <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp,outptcode,btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.doublonCode}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachLibelleFr}" size="30"  onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Taux:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachTaux}" size="5"/></h:column>
                    <h:column><h:outputText value="Numéro Compte:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachCompte}">
                            <f:selectItem itemLabel=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.mesComptesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachType}">
                            <f:selectItem itemLabel="TVA sur biens" itemValue="0"/>
                            <f:selectItem itemLabel="TVA sur prestation" itemValue="1"/>
                            <f:selectItem itemLabel="PRECOMPTE LOCAL" itemValue="2"/>
                            <f:selectItem itemLabel="PRECOMPTE ETRANGER" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Timbre:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachTimbre}">
                            <f:selectItem itemLabel="Sans timbre" itemValue="0"/>
                            <f:selectItem itemLabel="Timbre payé par le fournisseur" itemValue="1"/>
                            <f:selectItem itemLabel="Timbre non payé" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Compléments:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.taxesAchats.taxachTc}">
                            <f:selectItem itemLabel="Sans taxes complémentaires" itemValue="0"/>
                            <f:selectItem itemLabel="Centimes additionnels" itemValue="1"/>
                            <f:selectItem itemLabel="Taxe d'égalisation" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup id="ppgrp">
                <center>
                    <br><br>
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.saveTaxesAchats}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.doublon}"/>
                </center>
                <center>
                    <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTaxesAchat.doublon}"/>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
