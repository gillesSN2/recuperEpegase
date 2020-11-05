<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="informations">

    <a4j:form id="informations">
        <center>

            <center> <h2><h:outputText value="LISTE DES INFOTRMATIONS" style="color:green;font-size:16px;"/></h2></center>

            <h:panelGroup id="butt">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une informations" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.ajouterInformations}" reRender="panelEvolution"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/modifier.png" title="Modifier l'information sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.afficheInformations}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.modifierInformations}" reRender="panelEvolution"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer l'information sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.afficheInformations}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.supprimerInformations}" reRender="butt,listeEvolution"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/transferer.png" title="Exporter la liste des informations" onclick="if (!confirm('Etes vous sur de vouloir exporter et mettre à jour le serveur epegase on-line?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.exporterInformations}" reRender="modAttente,pboard,modMessageCommun"/>
            </h:panelGroup>

            <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller reRender="listeEvolution" id="scrollTableEvolution" maxPages="20"align="left" for="listeEvolution"/>
                    <rich:extendedDataTable rows="200" style="max-height:100%;" border="0" styleClass="bg" id="listeEvolution" width="100%" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.dataModelInformations}" var="evo">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.selectionLigneInformation}" reRender="butt"/>
                        <rich:column label="Date" sortable="true" sortBy="#{evo.pegevoDate}" width="8%" sortOrder="DESCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{evo.pegevoDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Texte" width="90%" sortable="true" sortBy="#{evo.pegevoObject}">
                            <f:facet name="header" ><h:outputText value="Texte" /></f:facet>
                            <h:inputTextarea rows="3" value="#{evo.pegevoObject}" title="#{evo.pegevoObject}" readonly="true" style="width:100%"/>
                        </rich:column>                     
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelEvolution" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.showModalPanelInformations}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.showModalPanelInformations}" var="rub">
            <f:facet name="header"><h:outputText value="Gestion des informations"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.annulerInformations}" image="/images/close.gif" styleClass="hidelink" reRender="panelEvolution"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionRubrique" style="width:100%;">
                    <h:panelGrid id="panDescription" columns="2" columnClasses="clos20,clos80" style="width:100%;">
                        <h:column><h:outputText value="Date création:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegInformation.pegevoDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="Texte information:"/></h:column>
                        <h:column><h:inputTextarea rows="15" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegInformation.pegevoObject}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Image:"/></h:column>
                        <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegInformation.pegevoEcran}"/></h:column>
                        <h:column><h:outputText value="Position:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegInformation.pegevoModule}" style="width:100%;">
                                <f:selectItem itemLabel="Haut" itemValue="0"/>
                                <f:selectItem itemLabel="Bas" itemValue="1" itemDisabled="true"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Actif:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.pegInformation.pegevoType}" style="width:100%;">
                                <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                <f:selectItem itemLabel="Actif" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:column><h:outputText value="(Mettre # à la fin de chaque ligne. Le # sera considéré comme un Retour Chariot <br>)" style="color:red"/></h:column>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttonValid">
                        <a4j:commandButton title="Valider"style="margin-top:10px;" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEvolution.validerInformations}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEvolution,listeEvolution,scrollTableEvolution"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>