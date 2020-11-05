<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="posdouane">

    <a4j:form id="form">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="LISTE DES POSITIONS TARIFAIRES DE LA DOUANE (zone : #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale})" style="color:green;"/></h2></center>

        <br>
        <h:commandButton value="Ajout par Défaut" onclick="if (!confirm('Voulez-vous charger le plan comptable par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;"/>
        <br>
        <h:panelGrid id="panelBouton" columns="9" width="350px">
            <a4j:commandButton title="Rechercher des positions" image="/images/jumelle.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.recherchePosition}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRecherche"/>
            <a4j:commandButton title="Cocher toutes les lignes du chapitre sélectionné" image="/images/valider.png" onclick="if (!confirm('Etes vous sur de vouloir cocher toutes les lignes?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheBoutonChapitre}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.cocherLigne}" reRender="tablePosition,modAttente"/>
            <a4j:commandButton title="Décocher toutes les lignes du chapitre sélectionné" image="/images/annuler.gif" onclick="if (!confirm('Etes vous sur de vouloir décocher toutes les lignes?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheBoutonChapitre}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.deCocherLigne}" reRender="tablePosition,modAttente"/>
            <a4j:commandButton title="Désélectionner toutes les positions de tous les chapitres" image="/images/annuler_big.png" onclick="if (!confirm('Etes vous sur de vouloir désélectionner toutes les positions tarifaires?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheBoutonChapitre}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.deSelectionnerPosition}" reRender="tablePosition,modAttente"/>
            <a4j:commandButton title="Ajouter position tarifaire" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheBoutonPosition}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.ajoutPosition}" reRender="panelPosition"/>
            <a4j:commandButton title="Modifier position tarifaire" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheBoutonPosition}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.modificationPosition}" reRender="panelPosition"/>
            <a4j:commandButton title="Imprimer la liste des positions du chapitre sélectioné" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.afficheBoutonChapitre}"/>
            <a4j:commandButton title="Liste des positions sélectionnées" image="/images/extrait.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.listePosition}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListe"/>
            <a4j:commandButton title="Recalculer les nom des chapitres" image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.recalculLibelleChapitre}" onclick="if (!confirm('Etes vous sur de vouloir recalculer les libellés des chapitres?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tablePosition,modAttente,tableChapitre"/>
        </h:panelGrid>
        <br>
        <h:panelGrid width="100%" columns="3" columnClasses="clos30,clos70">
            <h:panelGrid width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="tableChapitre"/>
                    <rich:extendedDataTable rows="100" id="tableChapitre" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.datamodelChapitre}" var="chap">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionChapitre}" reRender="panelBouton,tablePosition2,tablePosition3"/>
                        <rich:column sortable="true" width="15%" style="text-align:left;" sortBy="#{chap.code}">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText value="#{chap.code}"/>
                        </rich:column>
                        <rich:column sortable="true" width="85%" style="text-align:left;" sortBy="#{chap.nom_FR}">
                            <f:facet name="header"><h:outputText value="Chapitre"/></f:facet>
                            <h:outputText value="#{chap.nom_FR}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
            <h:panelGrid width="100%">
                <a4j:region renderRegionOnly="false">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='CEMAC'}" var="cemac">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tablePosition2"/>
                        <rich:extendedDataTable rows="100" id="tablePosition2" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.datamodelPosition}" var="pos">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionPosition}" reRender="panelBouton"/>
                            <rich:column sortable="true" width="17%" sortBy="#{pos.douposCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{pos.douposCode}"/>
                            </rich:column>
                            <rich:column width="45%" sortable="true" sortBy="#{pos.douposLibFR}">
                                <f:facet name="header"><h:outputText  value="Position tarifaire"/></f:facet>
                                <h:outputText value="#{pos.douposLibFR}"/>
                            </rich:column>
                            <rich:column width="3%" sortable="false">
                                <f:facet name="header"><h:outputText value="Un."/></f:facet>
                                <h:outputText value="#{pos.douposUnite}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="DDI"/></f:facet>
                                <h:outputText value="#{pos.douposDd}" rendered="#{pos.douposDd!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="TCI"/></f:facet>
                                <h:outputText value="#{pos.douposRs}" rendered="#{pos.douposRs!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                                <h:outputText value="#{pos.douposTva}" rendered="#{pos.douposTva!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="CCI"/></f:facet>
                                <h:outputText value="#{pos.douposPcs}" rendered="#{pos.douposPcs!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="OAD"/></f:facet>
                                <h:outputText value="#{pos.douposAd}" rendered="#{pos.douposAd!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="CSS"/></f:facet>
                                <h:outputText value="#{pos.douposDa}" rendered="#{pos.douposDa!=0}"/>
                            </rich:column>
                            <rich:column width="5%" sortable="false">
                                <f:facet name="header"><h:outputText value="Util."/></f:facet>
                                <h:selectBooleanCheckbox id="idUtil" value="#{pos.libUtil}" rendered="#{pos.chapitre}">
                                    <a4j:support eventsQueue="maQueue" immediate="true" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.miseAJour}" reRender="idUtil"/>
                                </h:selectBooleanCheckbox>
                            </rich:column>
                        </rich:extendedDataTable>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='UEMOA'}" var="uemoa">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable3" maxPages="20"align="left" for="tablePosition3"/>
                        <rich:extendedDataTable rows="100" id="tablePosition3" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.datamodelPosition}" var="pos">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionPosition}" reRender="panelBouton"/>
                            <rich:column sortable="true" width="17%" sortBy="#{pos.douposCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{pos.douposCode}"/>
                            </rich:column>
                            <rich:column width="45%" sortable="true" sortBy="#{pos.douposLibFR}">
                                <f:facet name="header"><h:outputText  value="Position tarifaire"/></f:facet>
                                <h:outputText value="#{pos.douposLibFR}"/>
                            </rich:column>
                            <rich:column width="3%" sortable="false">
                                <f:facet name="header"><h:outputText value="Un."/></f:facet>
                                <h:outputText value="#{pos.douposUnite}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="T1"/></f:facet>
                                <h:outputText value="#{pos.douposDd}" rendered="#{pos.douposDd!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="T3"/></f:facet>
                                <h:outputText value="#{pos.douposRs}" rendered="#{pos.douposRs!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="T5"/></f:facet>
                                <h:outputText value="#{pos.douposTva}" rendered="#{pos.douposTva!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="T10"/></f:facet>
                                <h:outputText value="#{pos.douposPcs}" rendered="#{pos.douposPcs!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="T30"/></f:facet>
                                <h:outputText value="#{pos.douposAd}" rendered="#{pos.douposAd!=0}"/>
                            </rich:column>
                            <rich:column width="5%" style="text-align:right;" sortable="false">
                                <f:facet name="header"><h:outputText value="T31"/></f:facet>
                                <h:outputText value="#{pos.douposDa}" rendered="#{pos.douposDa!=0}"/>
                            </rich:column>
                            <rich:column width="5%" sortable="false">
                                <f:facet name="header"><h:outputText value="Util."/></f:facet>
                                <h:selectBooleanCheckbox id="idUtil" value="#{pos.libUtil}" rendered="#{pos.chapitre}">
                                    <a4j:support eventsQueue="maQueue" immediate="true" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.miseAJour}" reRender="idUtil"/>
                                </h:selectBooleanCheckbox>
                            </rich:column>
                        </rich:extendedDataTable>
                    </c:if>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel id="panelPosition" width="550" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.showModalPanelPosition}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.showModalPanelPosition}" var="pos">
            <f:facet name="header"><h:outputText value="MODIFICATION DES POSITIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.annulerPosition}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelPosition"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='CEMAC'}" var="cemac">
                    <h:panelGrid columns="3" columnClasses="clos5c,clos75,clos20" width="100%">
                        <h:column><h:outputText value="Unité:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposUnite}" style="width:200Px" /></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposCode}" style="width:200Px" /></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposLibFR}" style="width:100%"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="DDI:"/></h:column>
                        <h:column><h:outputText value="Droit de douane"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposDd}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="TCI:"/></h:column>
                        <h:column><h:outputText value="Taxe communautaire d'intégration:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposRs}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="TVA:"/></h:column>
                        <h:column><h:outputText value="T.V.A."/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposTva}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="CCI:"/></h:column>
                        <h:column><h:outputText value="Contribution communautaire d'intégration:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposPcs}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="OAD:"/></h:column>
                        <h:column><h:outputText value="Taxe de financement OHADA:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposAd}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="CSS:"/></h:column>
                        <h:column><h:outputText value="Contribution spéciale de solidarité:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposDa}" style="text-align:right;"/></h:column>
                    </h:panelGrid>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='UEMOA'}" var="uemoa">
                    <h:panelGrid columns="3" columnClasses="clos5c,clos75,clos20" width="100%">
                        <h:column><h:outputText value="Unité:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposUnite}" style="width:200Px" /></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposCode}" style="width:200Px" /></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposLibFR}" style="width:100%"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="T1:"/></h:column>
                        <h:column><h:outputText value="Droit de douane"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposDd}" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T2:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Droit fiscal à l'importation:"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T3:"/></h:column>
                        <h:column><h:outputText value="Taxe statistique:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposRs}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T5:"/></h:column>
                        <h:column><h:outputText value="T.V.A."/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposTva}" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T7:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Taxe sur les tissus"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T8:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Taxe de coopération régionale"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T9:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Intérêt de retard"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T10:"/></h:column>
                        <h:column><h:outputText value="COSEC"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposPcs}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T11:"/></h:column>
                        <h:column><h:outputText value="Droit fiscal à l'exportation"/></h:column>
                        <h:column><h:inputText size="10" value="0" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T17:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Cotisation professionnelle"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T8:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Taxe professionnelle"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column rendered="false"><h:outputText value="T19:"/></h:column>
                        <h:column rendered="false"><h:outputText value="Péréquation sur les transports"/></h:column>
                        <h:column rendered="false"><h:inputText size="10" value="0" readonly="true" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T30:"/></h:column>
                        <h:column><h:outputText value="Prélèvement UEMOA:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposAd}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T31:"/></h:column>
                        <h:column><h:outputText value="Centimes additionnels CEDEAO:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.douposDa}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T46:"/></h:column>
                        <h:column><h:outputText value="BIC"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.doupos46}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="T53:"/></h:column>
                        <h:column><h:outputText value="Taxe intérieure"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.douanesPosition.doupos53}" style="text-align:right;"/></h:column>
                    </h:panelGrid>
                </c:if>
                <center>
                    <h:panelGroup  id="buttGrp">
                        <br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.validePosition}" reRender="panelPosition,scrollTable2,tablePosition,tableListe2,tableListe3,tableListe4,tableListe5"/>
                    </h:panelGroup>
                </center>
                <br/>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListe" width="1000" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.showModalPanelListe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.showModalPanelListe}" var="lst">
            <f:facet name="header"><h:outputText value="LISTE DES POSITIONS SELECTIONNEES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.fermerListe}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelListe"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton title="Modifier position tarifaire" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.modificationPosition}" reRender="panelPosition" id="panelBouton2"/>
                        </center>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='CEMAC'}" var="cemac">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable4" maxPages="20"align="left" for="tableListe4"/>
                            <rich:extendedDataTable rows="100" id="tableListe4" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.dataModelListe}" var="sel">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionPositionSelection}" reRender="panelBouton2"/>
                                <rich:column sortable="true" width="17%" sortBy="#{sel.douposCode}">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{sel.douposCode}"/>
                                </rich:column>
                                <rich:column sortable="true" width="40%" sortBy="#{sel.douposLibFR}">
                                    <f:facet name="header"><h:outputText  value="Position tarifaire"/></f:facet>
                                    <h:outputText value="#{sel.douposLibFR}"/>
                                </rich:column>
                                <rich:column width="3%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Un."/></f:facet>
                                    <h:outputText value="#{sel.douposUnite}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="DDI"/></f:facet>
                                    <h:outputText value="#{sel.douposDd}" rendered="#{sel.douposDd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="TCI"/></f:facet>
                                    <h:outputText value="#{sel.douposRs}" rendered="#{sel.douposRs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                                    <h:outputText value="#{sel.douposTva}" rendered="#{sel.douposTva!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="CCI"/></f:facet>
                                    <h:outputText value="#{sel.douposPcs}" rendered="#{sel.douposPcs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="OAD"/></f:facet>
                                    <h:outputText value="#{sel.douposAd}" rendered="#{sel.douposAd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="CSS"/></f:facet>
                                    <h:outputText value="#{sel.douposDa}" rendered="#{sel.douposDa!=0}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='UEMOA'}" var="uemoa">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable5" maxPages="20"align="left" for="tableListe5"/>
                            <rich:extendedDataTable rows="100" id="tableListe5" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.dataModelListe}" var="sel">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionPositionSelection}" reRender="panelBouton2"/>
                                <rich:column sortable="true" width="17%" sortBy="#{sel.douposCode}">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{sel.douposCode}"/>
                                </rich:column>
                                <rich:column sortable="true" width="40%" sortBy="#{sel.douposLibFR}">
                                    <f:facet name="header"><h:outputText  value="Position tarifaire"/></f:facet>
                                    <h:outputText value="#{sel.douposLibFR}"/>
                                </rich:column>
                                <rich:column width="3%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Un."/></f:facet>
                                    <h:outputText value="#{sel.douposUnite}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T1"/></f:facet>
                                    <h:outputText value="#{sel.douposDd}" rendered="#{sel.douposDd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T3"/></f:facet>
                                    <h:outputText value="#{sel.douposRs}" rendered="#{sel.douposRs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T5"/></f:facet>
                                    <h:outputText value="#{sel.douposTva}" rendered="#{sel.douposTva!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T10"/></f:facet>
                                    <h:outputText value="#{sel.douposPcs}" rendered="#{sel.douposPcs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T30"/></f:facet>
                                    <h:outputText value="#{sel.douposAd}" rendered="#{sel.douposAd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T31"/></f:facet>
                                    <h:outputText value="#{sel.douposDa}" rendered="#{sel.douposDa!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T46"/></f:facet>
                                    <h:outputText value="#{sel.doupos46}" rendered="#{sel.doupos46!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T53"/></f:facet>
                                    <h:outputText value="#{sel.doupos53}" rendered="#{sel.doupos53!=0}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </c:if>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelRecherche" width="900" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.showModalPanelRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.showModalPanelRecherche}" var="rec">
            <f:facet name="header"><h:outputText value="RECHERCHE POSITION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.fermerRecherche}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelRecherche"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" id="idPanelRecherche">
                    <h:panelGrid columns="2">
                        <h:column><h:outputText value="Recherche chaine:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.chaine}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.rechercheCode}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanelRecherche,scrollTable4,tableRecherche"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton title="Modifier position tarifaire" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.modificationPosition}" reRender="panelPosition" id="panelBouton3"/>
                        </center>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='UEMOA'}" var="uemoa">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable6" maxPages="20"align="left" for="tableRecherche6"/>
                            <rich:extendedDataTable rows="100" id="tableRecherche6" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.dataModelRecherche}" var="sel">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionCode}" reRender="panelBouton3"/>
                                <rich:column sortable="true" width="17%" sortBy="#{sel.douposCode}">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{sel.douposCode}"/>
                                </rich:column>
                                <rich:column sortable="true" width="45%" sortBy="#{sel.douposLibFR}">
                                    <f:facet name="header"><h:outputText  value="Position tarifaire"/></f:facet>
                                    <h:outputText value="#{sel.douposLibFR}"/>
                                </rich:column>
                                <rich:column width="3%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Un."/></f:facet>
                                    <h:outputText value="#{sel.douposUnite}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T1"/></f:facet>
                                    <h:outputText value="#{sel.douposDd}" rendered="#{sel.douposDd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T3"/></f:facet>
                                    <h:outputText value="#{sel.douposRs}" rendered="#{sel.douposRs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T5"/></f:facet>
                                    <h:outputText value="#{sel.douposTva}" rendered="#{sel.douposTva!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T10"/></f:facet>
                                    <h:outputText value="#{sel.douposPcs}" rendered="#{sel.douposPcs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T30"/></f:facet>
                                    <h:outputText value="#{sel.douposAd}" rendered="#{sel.douposAd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="T31"/></f:facet>
                                    <h:outputText value="#{sel.douposDa}" rendered="#{sel.douposDa!=0}"/>
                                </rich:column>
                                <rich:column width="5%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Util."/></f:facet>
                                    <h:selectBooleanCheckbox id="idUtil" value="#{sel.libUtil}" rendered="#{sel.chapitre}">
                                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.miseAJour}" reRender="idUtil"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                            </rich:extendedDataTable>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='CEMAC'}" var="cemac">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable7" maxPages="20"align="left" for="tableRecherche7"/>
                            <rich:extendedDataTable rows="100" id="tableRecherche7" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.dataModelRecherche}" var="sel">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.selectionCode}" reRender="panelBouton3"/>
                                <rich:column sortable="true" width="17%" sortBy="#{sel.douposCode}">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{sel.douposCode}"/>
                                </rich:column>
                                <rich:column sortable="true" width="45%" sortBy="#{sel.douposLibFR}">
                                    <f:facet name="header"><h:outputText  value="Position tarifaire"/></f:facet>
                                    <h:outputText value="#{sel.douposLibFR}"/>
                                </rich:column>
                                <rich:column width="3%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Un."/></f:facet>
                                    <h:outputText value="#{sel.douposUnite}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="DDI"/></f:facet>
                                    <h:outputText value="#{sel.douposDd}" rendered="#{sel.douposDd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="TCI"/></f:facet>
                                    <h:outputText value="#{sel.douposRs}" rendered="#{sel.douposRs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                                    <h:outputText value="#{sel.douposTva}" rendered="#{sel.douposTva!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="CCI"/></f:facet>
                                    <h:outputText value="#{sel.douposPcs}" rendered="#{sel.douposPcs!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="OAD"/></f:facet>
                                    <h:outputText value="#{sel.douposAd}" rendered="#{sel.douposAd!=0}"/>
                                </rich:column>
                                <rich:column width="5%" style="text-align:right;" sortable="false">
                                    <f:facet name="header"><h:outputText value="CSS"/></f:facet>
                                    <h:outputText value="#{sel.douposDa}" rendered="#{sel.douposDa!=0}"/>
                                </rich:column>
                                <rich:column width="5%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Util."/></f:facet>
                                    <h:selectBooleanCheckbox id="idUtil" value="#{sel.libUtil}" rendered="#{sel.chapitre}">
                                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDouanes.miseAJour}" reRender="idUtil"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                            </rich:extendedDataTable>
                        </c:if>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
