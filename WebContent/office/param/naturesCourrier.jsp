<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natcou">
    <center>
        <a4j:form>

            <center> <h2><h:outputText value="NATURES DES COURRIERS" style="color:green;"/></h2></center>

            <h:commandButton value="Ajout par Défaut" onclick="if (!confirm('Voulez-vous charger les natrures de courriers par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;"/>
            <br>

            <h:panelGrid id="panelBtnCtiers" width="200px" columns="4">
                <h:commandButton image="/images/ajouter.png" title="Ajout nature courriers"id="AdfmtC" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.lanceAjouter}"/>
                <h:commandButton  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.btnModClient}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.lanceModif}" title="Modification nature" image="/images/modifier.png"/>
                <h:commandButton  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.btnModClient}" title="Suppression nature" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.supprimer}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <a4j:commandButton title="Imprimer les natures de courriers" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup >
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="fmtClt" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.dataModelNature}" var="fmttiersxml">
                            <a4j:support eventsQueue="maQueue" reRender="panelBtnCtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.selectionLigne}" event="onRowClick" />
                            <rich:column width="20%" sortable="false">
                                <f:facet name="header"><h:outputText value="Nature"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.nature}"></h:outputText>
                            </rich:column>
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="N."/> </f:facet>
                                <h:outputText value="#{fmttiersxml.code}"></h:outputText>
                            </rich:column>
                            <rich:column width="70%" sortable="false">
                                <f:facet name="header"><h:outputText value="Libellé"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.libelle}"></h:outputText>
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


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelfmtClients" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.afficheModePanelAjt}" width="900" height="300">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.afficheModePanelAjt}" var="ajt">
            <f:facet name="header">
                <h:panelGroup><h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT NATURE DE COURRIER"></h:outputText></h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelfmtclients"/>
                    <rich:componentControl for="panelfmtClients" attachTo="bpanelfmtclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClients" style="width:100%;">
                    <rich:hotKey key="return" handler="return false;"/>
                    <h:panelGrid columns="2" id="idPanel" width="100%">
                        <h:column><h:outputText value="Nature"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.codNat}" style="width:100%">
                                <f:selectItem itemLabel="Mails envoyés" itemValue="0"/>
                                <f:selectItem itemLabel="Mails reçus" itemValue="1"/>
                                <f:selectItem itemLabel="Mails brouillons" itemValue="2"/>
                                <f:selectItem itemLabel="Courriers envoyés" itemValue="3"/>
                                <f:selectItem itemLabel="Courriers reçus" itemValue="4"/>
                                <f:selectItem itemLabel="Notes de services" itemValue="125"/>
                                <f:selectItem itemLabel="Courriers internes reçus" itemValue="126"/>
                                <f:selectItem itemLabel="Corbeille" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Code"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.cod}"/></h:column>
                        <h:column><h:outputText value="Libellé"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.lib}" style="100%"/></h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.majAjout}"/>
                        </h:column>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.afficheModePanel}" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelfmtClientsModif" width="900" height="300">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.afficheModePanel}" var="ajt">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText style="font-weight:bold;font-size:12px;"value="MODIFICATION NATURE DE COURRIER"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelmodclients"/>
                    <rich:componentControl for="panelfmtClientsModif" attachTo="bpanelmodclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClientsModif"style="width:100%;">
                    <h:panelGrid columns="2" id="idPanel" width="100%">
                        <h:column><h:outputText value="Nature"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.codNat}" style="width:100%">
                                <f:selectItem itemLabel="Mails envoyés" itemValue="0"/>
                                <f:selectItem itemLabel="Mails reçus" itemValue="1"/>
                                <f:selectItem itemLabel="Mails brouillons" itemValue="2"/>
                                <f:selectItem itemLabel="Courriers envoyés" itemValue="3"/>
                                <f:selectItem itemLabel="Courriers reçus" itemValue="4"/>
                                <f:selectItem itemLabel="Notes de services" itemValue="125"/>
                                <f:selectItem itemLabel="Courriers internes reçus" itemValue="126"/>
                                <f:selectItem itemLabel="Corbeille" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Code"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.cod}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Libellé"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.lib}" style="100%"/></h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesCourrier.majModif}"/>
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