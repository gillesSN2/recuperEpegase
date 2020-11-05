<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="saisieTurboBul">

    <a4j:form>

        <center> <h2><h:outputText value="SAISIE TURBO DES BULLETINS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="9" width="100%" id="recherche">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column>
                        <rich:calendar inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}"/>
                    </h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column>
                        <rich:calendar inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}"/>
                    </h:column>
                    <h:column><h:outputText value="Salarié:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_salarie}" style="width:300px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}">
                            <f:selectItem itemLabel="Sélection salarié" itemValue="0"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.lesSalarieItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.contratsSalaries}" reRender="recherche,idContrat"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Contrat:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idContrat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_contrat}" style="width:100px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.lesContratItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.rechercherBulletin}" value="Rechercher" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,table,panelBoutonTrf" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}"/>
                </h:panelGrid>
            </h:panelGrid>
            <br>
            <h:panelGrid id="listRecherche" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelBulletinsLigne}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                        <a4j:support eventsQueue="maQueue" event="onRowclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.selectionligneBulletin}"/>
                        <rich:column  width="10%" sortable="false">
                            <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                            <h:outputText value= "#{plan.bulligNature} : #{plan.libNature}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{plan.bulligRubrique}" sortOrder="ASCENDING" >
                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                            <h:outputText value="#{plan.bulligRubrique}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="24%" sortable="false" >
                            <f:facet name="header"><h:outputText value="Libellé rubrique"/></f:facet>
                            <h:outputText value="#{plan.bulligLibelle}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                            <h:inputText value="#{plan.bulligValColA}" rendered="#{plan.bulligAffColA&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89}" style="#{plan.espaceFamille}text-align:right;width:95%;"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                            <h:inputText value="#{plan.bulligValColB}" rendered="#{plan.bulligAffColB&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89}" style="#{plan.espaceFamille}text-align:right;width:95%;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column width="8%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                            <h:inputText value="#{plan.bulligValColC}" rendered="#{plan.bulligAffColC&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89}" style="#{plan.espaceFamille}text-align:right;width:95%;"/>
                        </rich:column>
                        <rich:column width="8%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                            <h:inputText value="#{plan.bulligValColD}" rendered="#{plan.bulligAffColD&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89}" style="#{plan.espaceFamille}text-align:right;width:95%;"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                            <h:inputText value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89}" style="#{plan.espaceFamille}text-align:right;width:95%;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                            <h:outputText id="idResultat" value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE}" style="#{plan.espaceFamille}text-align:right;width:95%;">                              
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
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
                <a4j:commandButton id="idTotal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.calculeTotaux}" value="Calcul Totaux" reRender="table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton id="idValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.enregistrerBulletin}" value="Validez saisie du bulletin" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette opération ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panCtrl,table,panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.valideBulletin}"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

