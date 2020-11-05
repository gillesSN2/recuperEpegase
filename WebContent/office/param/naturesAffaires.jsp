<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="nataffaire">
    <center>
        <a4j:form>

            <center> <h2><h:outputText value="NATURES DES PORTE-FEUILLES D`AFFAIRES" style="color:green;"/></h2></center>

            <h:panelGrid id="panelBtnObjet" width="200px" columns="4">
                <a4j:commandButton image="/images/ajouter.png" title="Ajout nature affaires"id="AdfmtC" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.lanceAjouter}" reRender="panelAjoutObjet"/>
                <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.btnModClient}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.lanceModif}" title="Modification nature" image="/images/modifier.png" reRender="panelModifObjet"/>
                <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.btnModClient}" title="Suppression nature" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.supprimer}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableObjet,panelBtnObjet"/>
                <a4j:commandButton title="Imprimer les natures d`affaires" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup >
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableObjet" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.dataModelNature}" var="fmttiersxml">
                            <a4j:support eventsQueue="maQueue" reRender="panelBtnObjet" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.selectionLigne}" event="onRowClick" />
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="N."/> </f:facet>
                                <h:outputText value="#{fmttiersxml.code}"></h:outputText>
                            </rich:column>
                            <rich:column width="50%" sortable="false">
                                <f:facet name="header"><h:outputText value="Libellé"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.libelle}"></h:outputText>
                            </rich:column>
                            <rich:column width="40%" sortable="false">
                                <f:facet name="header"><h:outputText value="Analytique"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.lib_analytique}"></h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </center>
            </h:panelGroup>
            <br>
            <center>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelAjoutObjet" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.afficheModePanelAjt}" width="500" height="300">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.afficheModePanelAjt}" var="ajt">
            <f:facet name="header">
                <h:panelGroup><h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT NATURE DE PORTE-FEUILLE D`AFFAIRE"></h:outputText></h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelfmtclients"/>
                    <rich:componentControl for="panelAjoutObjet" attachTo="bpanelfmtclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClients" style="width:100%;">
                    <rich:hotKey key="return" handler="return false;"/>
                    <h:panelGrid columns="2" id="idPanel">
                        <h:column><h:outputText value="Code"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.cod}"/></h:column>
                        <h:column><h:outputText value="Libellé"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.lib}"/></h:column>
                        <h:column><h:outputText value = "Analytique liée:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.anal}" style="width:300px;">
                                <f:selectItem itemLabel="Sans analytique" itemValue="" />
                                <f:selectItem itemLabel="Dossier" itemValue="6"/>
                                <f:selectItem itemLabel="Chantier" itemValue="7"/>
                                <f:selectItem itemLabel="Mission/Frais" itemValue="8"/>
                                <f:selectItem itemLabel="Activité" itemValue="99"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.majAjout}" reRender="tableObjet,panelAjoutObjet,panelBtnObjet"/>
                        </h:column>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.afficheModePanel}" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelModifObjet" width="500" height="300">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.afficheModePanel}" var="ajt">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText style="font-weight:bold;font-size:12px;"value="MODIFICATION NATURE DE PORTE-FEUILLE D`AFFAIRE"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelmodclients"/>
                    <rich:componentControl for="panelModifObjet" attachTo="bpanelmodclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClientsModif"style="width:100%;">
                    <h:panelGrid columns="2" id="idPanel">
                        <h:column><h:outputText value="Code"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.cod}"/></h:column>
                        <h:column><h:outputText value="Libellé"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.lib}"/></h:column>
                        <h:column><h:outputText value = "Analytique liée:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.anal}" style="width:300px;">
                                <f:selectItem itemLabel="Sans analytique" itemValue="" />
                                <f:selectItem itemLabel="Dossier" itemValue="6"/>
                                <f:selectItem itemLabel="Chantier" itemValue="7"/>
                                <f:selectItem itemLabel="Mission/Frais" itemValue="8"/>
                                <f:selectItem itemLabel="Activité" itemValue="99"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesAffaires.majModif}" reRender="tableObjet,panelModifObjet,panelBtnObjet"/>
                        </h:column>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>