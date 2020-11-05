<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trfParapheur">

    <a4j:form>

        <center> <h2><h:outputText value="TRANSFERT PARAPHEUR" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%">
            <h:panelGrid columns="8" width="100%">
                <h:column><h:outputText style="text-decoration:underline;" value="User Origine:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.userIdOrigine}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.mesUsersOriginesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText style="text-decoration:underline;" value="User Destination:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.userIdDestinataire}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.mesUsersDestinataresItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Du:"/></h:column>
                <h:column>
                    <rich:calendar inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}" popup="true"/>
                </h:column>
                <h:column><h:outputText value="Au:"/></h:column>
                <h:column>
                    <rich:calendar inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}" popup="true"/>
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="select" columns="3" width="100%" columnClasses="clos30g,clos30g,clos30g">
                <a4j:commandButton value="Rechercher Parapheur" title="Recherche les éléments du parapheur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.rechercherParapheur}" style="width:100%" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableExtrait,scrollTable"/>
                <a4j:commandButton value="Tout sélec." title="Sélectionne tous les éléments de la liste" reRender="tableExtrait,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.toutElementSelectionner}" style="width:100%"/>
                <a4j:commandButton value="Rien sélec." title="Dé-sélectionne tous les éléments de la liste" reRender="tableExtrait,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.toutELementDeSelectionner}" style="width:100%"/>
            </h:panelGrid>
            <br>
            <h:panelGrid width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableExtrait"/>
                    <rich:extendedDataTable rows="300" border="0" width="100%" noDataLabel=" " styleClass="bg" headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="tableExtrait" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelParapheur}" var="table" rowClasses="rows1,rows2,rowsd">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.selectionElement}"/>
                        <rich:column width="5%"  sortable="true" sortBy="#{table.select}" label="Sélection pour le transfert">
                            <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox value="#{table.select}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{table.libNature}" label="Nature Pièce">
                            <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                            <h:outputText value="#{table.libNature}">
                            </h:outputText>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{table.phrDate}" label="Date de saisie">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{table.phrDate}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{table.phrNum}" label="N° Pièce" >
                            <f:facet name="header"><h:outputText  value="N° Pièce"  /></f:facet>
                            <h:outputText value="#{table.phrNum}">
                            </h:outputText>
                        </rich:column>
                        <rich:column width="55%" sortable="true" sortBy="#{table.phrNomTiers}" label="Nom du Tiers">
                            <f:facet name="header"><h:outputText value="Nom Tiers" /></f:facet>
                            <h:outputText value="#{table.phrNomTiers}">
                            </h:outputText>
                        </rich:column>

                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="panelBoutonTrf">
            <center>
                <h:commandButton id="idAnnule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulePlansAnalytiques}" value="RETOUR" styleClass="exp_lienmenu"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton id="idValide" onclick="if (!confirm('Etes-vous sur de vouloir transférer le parapheur de #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.userIdOrigine} vers #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.userIdDestinataire} ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.transfertParapheur}" value="Transfert parapheur" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" />
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

