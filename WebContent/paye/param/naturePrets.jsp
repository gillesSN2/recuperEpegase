<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natpret">
    <center>
        <a4j:form>

            <center> <h2><h:outputText value="NATURE DES PRETS" style="color:green;"/></h2></center>

            <h:panelGrid id="panelBtnCtiers" width="200px" columns="4">
                <h:commandButton image="/images/ajouter.png" title="Ajout Nature Prêt"id="AdfmtC" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.lanceAjouter}"/>
                <h:commandButton  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.btnModNature}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.lanceModif}" title="Modification Nature"image="/images/modifier.png"/>
                <h:commandButton  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.btnModNature}" title="Suppression famille"image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.supprimer}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <a4j:commandButton title="Imprimer les familles de clients" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup >
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="fmtClt" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.dataModelNaturePret}" var="natprt">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBtnCtiers"/>
                            <rich:column width="20%" sortable="false">
                                <f:facet name="header"><h:outputText value="Code"/> </f:facet>
                                <h:outputText value="#{natprt.code}"></h:outputText>
                            </rich:column>
                            <rich:column width="80%" sortable="false">
                                <f:facet name="header"><h:outputText value="Libellé"/> </f:facet>
                                <h:outputText value="#{natprt.libelle}"></h:outputText>
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


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelfmtClients" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.afficheModePanelAjt}" width="500" height="300">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.afficheModePanelAjt}" var="ajt">
            <f:facet name="header">
                <h:panelGroup><h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT DE FAMILLE DE CLIENTS"></h:outputText></h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelfmtclients"/>
                    <rich:componentControl for="panelfmtClients" attachTo="bpanelfmtclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClients" style="width:100%;">
                    <h:panelGrid columns="2" id="idPanel">
                        <h:column><h:outputText value="Code"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.cod}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Libellé"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.lib}"/></h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.majAjout}"/>
                        </h:column>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.afficheModePanel}" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelfmtClientsModif" autosized="true" width="900" height="400">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.afficheModePanel}" var="ajt">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText style="font-weight:bold;font-size:12px;"value="MODIFICATION DE FAMILLE DE CLIENTS"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelmodclients"/>
                    <rich:componentControl for="panelfmtClientsModif" attachTo="bpanelmodclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClientsModif"style="width:100%;">

                    <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabDoc" label="Famille Client">
                            <h:panelGrid columns="2" id="idPanel">
                                <h:column><h:outputText value="Code"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.cod}" disabled="true" readonly="true"/></h:column>
                                <h:column><h:outputText value="Libellé"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.lib}"/></h:column>
                            </h:panelGrid>
                            <center>
                                <br>
                                <h:column>
                                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesPrets.majModif}"/>
                                </h:column>
                            </center>
                        </rich:tab>

                    </rich:tabPanel>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>