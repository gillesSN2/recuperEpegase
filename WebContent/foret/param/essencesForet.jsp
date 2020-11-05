<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="essences">
    <center>
        <a4j:form>

            <center> <h2><h:outputText value="LISTE DES ESSENCES" style="color:green;"/></h2></center>

            <h:panelGrid id="panelBtnObjet" width="200px" columns="4">
                <a4j:commandButton image="/images/ajouter.png" title="Ajout essences" id="AdfmtC" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.lanceAjouter}" reRender="panelAjoutObjet"/>
                <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.btnModClient}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.lanceModif}" title="Modification essences" image="/images/modifier.png" reRender="panelModifObjet"/>
                <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.btnModClient}" title="Suppression" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.supprimer}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableObjet,panelBtnObjet"/>
                <a4j:commandButton title="Imprimer" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup >
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableObjet" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.dataModelElement}" var="ess">
                            <a4j:support eventsQueue="maQueue" reRender="panelBtnObjet" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.selectionLigne}" event="onRowClick" />
                            <rich:column width="5%" sortable="false">
                                <f:facet name="header"><h:outputText value="Code"/> </f:facet>
                                <h:outputText value="#{ess.code}"></h:outputText>
                            </rich:column>
                            <rich:column width="15%" sortable="false">
                                <f:facet name="header"><h:outputText value="Libellé"/> </f:facet>
                                <h:outputText value="#{ess.libelle}"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="ATIBT"/> </f:facet>
                                <h:outputText value="#{ess.atibt}" style="text-align:right"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="OCTRA"/> </f:facet>
                                <h:outputText value="#{ess.octra}" style="text-align:right"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="EXPORT"/> </f:facet>
                                <h:outputText value="#{ess.export}" style="text-align:right"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Maretalge"/> </f:facet>
                                <h:outputText value="#{ess.martelage}" style="text-align:right"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Janv."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_01}" style="text-align:right" rendered="#{ess.prx_plage_01!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_01}" style="text-align:right" rendered="#{ess.prx_cession_01!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_01}" style="text-align:right" rendered="#{ess.val_douane_01!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Fév."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_02}" style="text-align:right" rendered="#{ess.prx_plage_02!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_02}" style="text-align:right" rendered="#{ess.prx_cession_02!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_02}" style="text-align:right" rendered="#{ess.val_douane_02!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Mars"/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_03}" style="text-align:right" rendered="#{ess.prx_plage_03!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_03}" style="text-align:right" rendered="#{ess.prx_cession_03!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_03}" style="text-align:right" rendered="#{ess.val_douane_03!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Avril"/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_04}" style="text-align:right" rendered="#{ess.prx_plage_04!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_04}" style="text-align:right" rendered="#{ess.prx_cession_04!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_04}" style="text-align:right" rendered="#{ess.val_douane_04!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Mai"/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_05}" style="text-align:right" rendered="#{ess.prx_plage_05!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_05}" style="text-align:right" rendered="#{ess.prx_cession_05!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_05}" style="text-align:right" rendered="#{ess.val_douane_05!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Juin"/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_06}" style="text-align:right" rendered="#{ess.prx_plage_06!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_06}" style="text-align:right" rendered="#{ess.prx_cession_06!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_06}" style="text-align:right" rendered="#{ess.val_douane_06!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Juil."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_07}" style="text-align:right" rendered="#{ess.prx_plage_07!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_07}" style="text-align:right" rendered="#{ess.prx_cession_07!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_07}" style="text-align:right" rendered="#{ess.val_douane_07!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Aout"/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_08}" style="text-align:right" rendered="#{ess.prx_plage_08!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_08}" style="text-align:right" rendered="#{ess.prx_cession_08!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_08}" style="text-align:right" rendered="#{ess.val_douane_08!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Sept."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_09}" style="text-align:right" rendered="#{ess.prx_plage_09!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_09}" style="text-align:right" rendered="#{ess.prx_cession_09!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_09}" style="text-align:right" rendered="#{ess.val_douane_09!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Oct."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_10}" style="text-align:right" rendered="#{ess.prx_plage_10!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_10}" style="text-align:right" rendered="#{ess.prx_cession_10!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_10}" style="text-align:right" rendered="#{ess.val_douane_10!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Nov."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_11}" style="text-align:right" rendered="#{ess.prx_plage_11!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_11}" style="text-align:right" rendered="#{ess.prx_cession_11!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_11}" style="text-align:right" rendered="#{ess.val_douane_11!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Déc."/> </f:facet>
                                <h:outputText value="#{ess.prx_plage_12}" style="text-align:right" rendered="#{ess.prx_plage_12!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.prx_cession_12}" style="text-align:right" rendered="#{ess.prx_cession_12!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText><br>
                                <h:outputText value="#{ess.val_douane_12}" style="text-align:right" rendered="#{ess.val_douane_12!=0}">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
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


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelAjoutObjet" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.afficheModePanelAjt}" width="500" height="200">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.afficheModePanelAjt}" var="ajt">
            <f:facet name="header">
                <h:panelGroup><h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT ESSENCE"></h:outputText></h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.closeModif}" image="/images/close.gif" styleClass="hidelink" id="bpanelfmtclients" reRender="panelAjoutObjet"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClients" style="width:100%;">
                    <rich:hotKey key="return" handler="return false;"/>
                    <h:panelGrid columns="2" id="idPanel" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.cod}" style="width:30%" maxlength="10"/></h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.lib}" style="width:100%" maxlength="50"/></h:column>
                        <h:column><h:outputText value="ATIBT:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.atibt}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="OCTRA:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.octra}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="EXPORT:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.export}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Martelage:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.martelage}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid border="0" columns="4">
                        <h:column><h:outputText value="Mois" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Prix Plage" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Prix Cession" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Valeur douane" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Janvier"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_01}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_01}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_01}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Février"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_02}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_02}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_02}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mars"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_03}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_03}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_03}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Avril"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_04}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_04}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_04}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mai"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_05}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_05}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_05}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juin"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_06}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_06}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_06}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juillet"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_07}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_07}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_07}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Aout"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_08}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_08}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_08}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Septembre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_09}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_09}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_09}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Octobre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_10}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_10}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_10}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Novembre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_11}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_11}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_11}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Décembre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_12}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_12}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_12}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.majAjout}" reRender="tableObjet,panelAjoutObjet,panelBtnObjet"/>
                        </h:column>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.afficheModePanel}" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelModifObjet" width="700" height="600">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.afficheModePanel}" var="ajt">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText style="font-weight:bold;font-size:12px;"value="MODIFICATION ESSENCE"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelmodclients" reRender="panelModifObjet"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formfmtAClientsModif" style="width:100%;">
                    <h:panelGrid columns="2" id="idPanel" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.cod}" style="width:30%" maxlength="10" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.lib}" style="width:100%" maxlength="50"/></h:column>
                        <h:column><h:outputText value="ATIBT:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.atibt}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="OCTRA:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.octra}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="EXPORT:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.export}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Martelage:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.martelage}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid border="0" columns="4">
                        <h:column><h:outputText value="Mois" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Prix Plage" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Prix Cession" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Valeur douane" style="text-align:center"/></h:column>
                        <h:column><h:outputText value="Janvier"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_01}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_01}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_01}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Février"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_02}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_02}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_02}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mars"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_03}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_03}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_03}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Avril"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_04}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_04}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_04}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mai"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_05}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_05}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_05}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juin"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_06}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_06}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_06}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juillet"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_07}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_07}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_07}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Aout"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_08}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_08}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_08}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Septembre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_09}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_09}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_09}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Octobre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_10}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_10}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_10}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Novembre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_11}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_11}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_11}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Décembre"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_plage_12}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.prx_cession_12}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.val_douane_12}" style="text-align:right">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:column>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEssenceForet.majModif}" reRender="tableObjet,panelModifObjet,panelBtnObjet"/>
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