<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="anarepecranal">

    <a4j:form>

        <center> <h2><h:outputText value="ANALYSE DES ECRITURES ANALYTIQUES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="4" width="100%">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}" popup="true"/>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid id="select" columns="3" width="100%" columnClasses="clos30g,clos30g,clos30g">
                <a4j:commandButton value="Rechercher Ecritures" title="Recherche les écritures analytiques" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.rechercheAnalyseReparationEcrAnal}" style="width:100%" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="panelBarProg,tableExtrait,scrollTable"/>
                <a4j:commandButton value="Tout sélec." title="Sélectionne toutes les écritures de la liste" reRender="tableExtrait,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.toutSelectionnerEcritureGene}" style="width:100%"/>
                <a4j:commandButton value="Rien sélec." title="Dé-sélectionne toutes les écritures de la liste" reRender="tableExtrait,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.toutDeSelectionnerEcritureGene}" style="width:100%"/>
            </h:panelGrid>
            <h:panelGrid width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableExtrait"/>
                    <rich:extendedDataTable rows="300" border="0" width="100%" noDataLabel="il n'y a aucune erreur référencée..." styleClass="bg" headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="tableExtrait" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelEcrituresDetruites}" var="table" rowClasses="rows1,rows2,rowsd">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.selectionEcrituresGene}"/>
                        <rich:column width="5%"  sortable="true" sortBy="#{table.sel_ecriture}" label="Sélection pour restautation">
                            <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox value="#{table.sel_ecriture}"/>
                        </rich:column>
                        <rich:column id="c1" width="5%" sortable="true" sortBy="#{table.ecrCode}" label="Journal">
                            <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                            <h:outputText value="#{table.ecrCode}">
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c2" width="7%" sortable="true" sortBy="#{table.ecrDateSaisie}" label="Date de saisie">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{table.ecrDateSaisie}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c3" width="9%" sortable="true" sortBy="#{table.ecrCompte}" label="N° compte" >
                            <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                            <h:outputText value="#{table.ecrCompte}">
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c4" width="9%" sortable="true" sortBy="#{table.ecrPiece}" label="N° Pièce">
                            <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                            <h:outputText value="#{table.ecrPiece}">
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c5" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitPays}" label="Débit">
                            <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                            <h:outputText   value="#{table.ecrDebitPays}" rendered="#{table.ecrDebitPays!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c6" width="10%"  style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditPays}"label="Crédit">
                            <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                            <h:outputText value="#{table.ecrCreditPays}" rendered="#{table.ecrCreditPays!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c7" width="26%" sortable="true" sortBy="#{table.ecrLibelle}" label="Libellé">
                            <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                            <h:outputText value="#{table.ecrLibelle}">
                            </h:outputText>
                        </rich:column>
                        <rich:column id="c8" width="20%" sortable="true" sortBy="#{table.erreurLettrage}" label="Observation">
                            <f:facet name="header"><h:outputText  value="Observation"/></f:facet>
                            <h:outputText value="#{table.erreurLettrage}">
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
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

