<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="caisseOperation">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES OPERATIONS DE CAISSES" style="color:green;"/></h2></center>

        <center>
            <h:commandButton id="idAddDefault" value="Ajout par Défaut" onclick="if (!confirm('Voulez-vous charger les opérations de caisse par défaut?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;"/>
            <br>
            <h:panelGrid id="pangrpVisbt" columns="4" width="250px">
                <a4j:commandButton title="Ajouter nouvelle opération" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.ajouterOperation}" rendered="false" reRender="panelCaisse"/>
                <a4j:commandButton title="Modifier l'opération sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.modifierOperation}" reRender="panelCaisse"/>
                <a4j:commandButton title="Supprimer l'opération sélectionnée" image="/images/supprimer.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.supprimerOperation}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" reRender="table,pangrpVisbt"/>
                <a4j:commandButton title="Imprimer les opérations" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" align="center" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.datamodelOperation}" var="caisse">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.selectionOperation}" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{caisse.caiopeCode}" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                        <h:outputText value="#{caisse.caiopeCode}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{caisse.caiopeNom}" width="300px">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText  value="#{caisse.caiopeNom}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{caisse.libType}" width="150px">
                        <f:facet name="header"><h:outputText  value="Type"/></f:facet>
                        <h:outputText  value="#{caisse.libType}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{caisse.libMode}" width="150px">
                        <f:facet name="header"><h:outputText  value="Mode"/></f:facet>
                        <h:outputText  value="#{caisse.libMode}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{caisse.libCategorie}" width="150px">
                        <f:facet name="header"><h:outputText  value="Catégorie"/></f:facet>
                        <h:outputText  value="#{caisse.libCategorie}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{caisse.etat}" width="50px">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:commandButton image="#{caisse.etat}" rendered="#{caisse.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.reactiverOperation}">
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


    <rich:modalPanel domElementAttachment="parent"  id="panelCaisse" width="700" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.showModalPanelOperation}">
        <f:facet name="header"><h:outputText value="GESTION DES OPERATIONS DE CAISSES"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelCaisse"/>
                <rich:componentControl for="panelCaisse" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;">
                <h:panelGrid columns="2" styleClass="fichefournisseur" width="100%" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText id="inptcodAjt" size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.caissesOperations.caiopeCode}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.caissesOperations.caiopeId!=0}" maxlength="20">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="ppgrp,outptcode,btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.doublonCode}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.caissesOperations.caiopeNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Type opération:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.caissesOperations.caiopeType}">
                            <f:selectItem itemLabel="Entrée" itemValue="0"/>
                            <f:selectItem itemLabel="Sortie" itemValue="1"/>
                            <f:selectItem itemLabel="Entrée/Sortie" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Transfert en comptabilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.caissesOperations.caiopeTransfert}">
                            <f:selectItem itemLabel="Transférable" itemValue="0"/>
                            <f:selectItem itemLabel="Non Transférable" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Catégorie:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.caissesOperations.caiopeCategorie}">
                            <f:selectItem itemLabel="Client" itemValue="0"/>
                            <f:selectItem itemLabel="Patient" itemValue="6"/>
                            <f:selectItem itemLabel="Elève" itemValue="7"/>
                            <f:selectItem itemLabel="Fournisseur" itemValue="1"/>
                            <f:selectItem itemLabel="Personnel/Agent" itemValue="2"/>
                            <f:selectItem itemLabel="Utilisateur" itemValue="5"/>
                            <f:selectItem itemLabel="Plan comptable" itemValue="4"/>
                            <f:selectItem itemLabel="Mouvement" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </h:panelGroup>

            <h:panelGroup id="ppgrp">
                <center>
                    <br><br>
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.saveOperation}"  rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.doublon}"/>
                </center>
                <center>
                    <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesOperations.doublon}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>