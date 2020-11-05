<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

    <rich:tab label="Dirigeants">
        <h:panelGrid id="tabDirigeant" width="100%">
            <h:panelGrid columns="7" id="pgrdirigeant" styleClass="recherche" width="100%">
                <h:panelGroup>
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter un dirigeant" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.ajoutDirigeant}" reRender="pgrdirigeant"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Nom dirigeant"/><br>
                    <h:inputText maxlength="200" tabindex="1" size="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementDirigeants.cplmenNom}"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Prénom"/><br>
                    <h:inputText maxlength="200" tabindex="2" size="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementDirigeants.cplmenPrenom}"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Qualité"/><br>
                    <h:inputText maxlength="200" tabindex="3" size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementDirigeants.cplmenQualite}"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="ID Fiscale"/><br>
                    <h:inputText maxlength="200" tabindex="4" size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementDirigeants.cplmenFiscal}"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Adresse"/><br>
                    <h:inputText maxlength="200" tabindex="5" size="22" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementDirigeants.cplmenAdresse}"/>
                </h:panelGroup>
                <h:panelGroup>
                    <a4j:commandButton image="/images/valider_big.png" title="Valider le dirigeant" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.saveDirigeant}" reRender="pgrdirigeant,tableDirigeants"/>
                </h:panelGroup>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable height="400px" id="tableDirigeants" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.datamodeldirigeants}" width="100%" border="0" var="dirigeants">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionDirigeant}" reRender="pgrdirigeant"/>
                    <rich:column width="25%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Noms dirigeants"/></f:facet>
                        <h:outputText value="#{dirigeants.cplmenNom}" />
                    </rich:column >
                    <rich:column width="20%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Prénoms"/></f:facet>
                        <h:outputText value="#{dirigeants.cplmenPrenom}"  />
                    </rich:column >
                    <rich:column width="10%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Qualité"/></f:facet>
                        <h:outputText value="#{dirigeants.cplmenQualite}"  />
                    </rich:column >
                    <rich:column width="10%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="ID fiscale"/></f:facet>
                        <h:outputText value="#{dirigeants.cplmenFiscal}"  />
                    </rich:column >
                    <rich:column width="30%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                        <h:outputText value="#{dirigeants.cplmenAdresse}"  />
                    </rich:column >
                    <rich:column width="5%" style="text-align:center;">
                        <a4j:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.supprimeDirigeant}" reRender="tableDirigeants,pgrdirigeant"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </rich:tab>

    <rich:tab label="Actionnaires">
        <h:panelGrid id="tabActionnaire" width="100%">
            <h:panelGrid columns="6" id="pgrdActionaire" styleClass="recherche" width="100%" >
                <h:panelGroup>
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter un actionnaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.ajoutActionnaire}" reRender="pgrdActionaire"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Nom actionnaire"  /><br>
                    <h:inputText maxlength="200" tabindex="1"size="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActionnaires.cplmenNom}" />
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Prénom"  /><br>
                    <h:inputText maxlength="200" tabindex="2" size="22" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActionnaires.cplmenPrenom}" />
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Nationnalité"  /><br>
                    <h:inputText maxlength="200" tabindex="3" size="13"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActionnaires.cplmenNation}" />
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText styleClass="textAligneOutSimple" value="Capital"  /><br>
                    <h:inputText maxlength="200" tabindex="4" size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementActionnaires.cplmenTotal}" style="text-align:right"/>
                </h:panelGroup>
                <h:panelGroup>
                    <a4j:commandButton tabindex="5" image="/images/valider_big.png" title="Valider le actionnaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.saveActionnaire}" reRender="pgrdActionaire,tableActionnaire"/>
                </h:panelGroup>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableActionnaire" height="400px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.datamodelactionnaires}" width="100%" border="0" var="actionnaires">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionActionnaire}" reRender="pgrdActionaire"/>
                    <rich:column width="25%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Noms actionnaires"/></f:facet>
                        <h:outputText value="#{actionnaires.cplmenNom}" />
                    </rich:column >
                    <rich:column width="30%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Prénoms"/></f:facet>
                        <h:outputText value="#{actionnaires.cplmenPrenom}"  />
                    </rich:column >
                    <rich:column width="20%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Nationnalité"/></f:facet>
                        <h:outputText value="#{actionnaires.cplmenNation}"  />
                    </rich:column >
                    <rich:column width="10%" sortable="false" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Capital"/></f:facet>
                        <h:outputText value="#{actionnaires.cplmenTotal}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column >
                    <rich:column width="10%" sortable="false" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="%"/></f:facet>
                        <h:outputText value="#{actionnaires.cplmenPourcentage}"  />
                    </rich:column >
                    <rich:column width="5%" style="text-align:center;">
                        <a4j:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.supprimeActionnaire}" reRender="tableActionnaire,pgrdActionaire"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </rich:tab>

    <rich:tab label="Membres Conseils Administration">
        <h:panelGrid id="tabMca" width="100%">
            <h:panelGrid columns="6" id="pgrdMCA" styleClass="recherche"  width="100%" >
                <h:panelGroup  >
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter un membre du conseil d'administration" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.ajoutMca}" reRender="pgrdMCA"/>
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Nom M.C.A"  /><br>
                    <h:inputText maxlength="200" tabindex="1"size="22" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementMca.cplmenNom}" />
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Prénom"  /><br>
                    <h:inputText maxlength="200" tabindex="2" size="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementMca.cplmenPrenom}" />
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Qualité"  /><br>
                    <h:inputText maxlength="200" tabindex="3" size="15"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementMca.cplmenQualite}"/>
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Adresse"  /><br>
                    <h:inputText maxlength="200" tabindex="5" size="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementMca.cplmenAdresse}" />
                </h:panelGroup>
                <h:panelGroup  >
                    <a4j:commandButton tabindex="6" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.saveMca}" reRender="pgrdMCA,tableMca"/>
                </h:panelGroup>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableMca" height="400px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.datamodelmca}" width="100%" border="0" var="mca">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionMca}" reRender="pgrdMCA"/>
                    <rich:column width="30%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Noms M.C.A."/></f:facet>
                        <h:outputText value="#{mca.cplmenNom}" />
                    </rich:column >
                    <rich:column width="25%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Prénoms"/></f:facet>
                        <h:outputText value="#{mca.cplmenPrenom}"  />
                    </rich:column >
                    <rich:column width="20%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Qualité"/></f:facet>
                        <h:outputText value="#{mca.cplmenQualite}"  />
                    </rich:column >
                    <rich:column width="20%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                        <h:outputText value="#{mca.cplmenAdresse}"  />
                    </rich:column >
                    <rich:column width="5%" style="text-align:center;">
                        <a4j:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.supprimeMca}" reRender="tableMca,pgrdMCA"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </rich:tab>

    <rich:tab label="Filiales">
        <h:panelGrid id="tabFiliale" width="100%">
            <h:panelGrid columns="5" id="pgrdFiliale" styleClass="recherche"  width="100%" >
                <h:panelGroup  >
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter une filiale" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.ajoutFiliale}" reRender="pgrdFiliale"/>
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Désignation Filiale"  /><br>
                    <h:inputText maxlength="200" tabindex="1"size="25" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementFiliales.cplmenDesignation}" />
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Pays"  /><br>
                    <h:inputText maxlength="200" tabindex="2" size="22" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementFiliales.cplmenNation}" />
                </h:panelGroup>
                <h:panelGroup >
                    <h:outputText styleClass="textAligneOutSimple" value="Capital"  /><br>
                    <h:inputText maxlength="200" tabindex="3" size="22"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.complementFiliales.cplmenTotal}" style="text-align:right"/>
                </h:panelGroup>
                <h:panelGroup  >
                    <a4j:commandButton tabindex="4" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.saveFiliale}" reRender="pgrdFiliale,tableFiliale"/>
                </h:panelGroup>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableFiliale" height="400px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.datamodelfiliales}" width="100%" border="0" var="filiales">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionFiliale}" reRender="pgrdFiliale"/>
                    <rich:column width="30%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Désignations filiales"/></f:facet>
                        <h:outputText value="#{filiales.cplmenDesignation}" />
                    </rich:column >
                    <rich:column width="25%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Pays"/></f:facet>
                        <h:outputText value="#{filiales.cplmenNation}"  />
                    </rich:column >
                    <rich:column width="20%" sortable="false" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Capital"/></f:facet>
                        <h:outputText value="#{filiales.cplmenTotal}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column >
                    <rich:column width="20%" sortable="false" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="%"/></f:facet>
                        <h:outputText value="#{filiales.cplmenPourcentage}"  />
                    </rich:column >
                    <rich:column width="5%" style="text-align:center;">
                        <a4j:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.supprimeFiliale}" reRender="tableFiliale,pgrdFiliale"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </rich:tab>

</rich:tabPanel>