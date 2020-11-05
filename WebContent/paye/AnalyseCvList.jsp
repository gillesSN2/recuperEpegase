<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="Listeanacv">

    <a4j:form >

        <center> <h2><h:outputText value="GESTION DES ANALYSES DES CV" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGlobal" width="100%" >
            <h:panelGrid id="panelRecherche" columns="5"  styleClass="recherche" width="100%" >
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.etat}" style="width:100px;" >
                    <f:selectItem itemLabel="Tous les états" itemValue="100"/>
                    <f:selectItem itemLabel="En Cours" itemValue="0"/>
                    <f:selectItem itemLabel="Validés" itemValue="1"/>
                </h:selectOneMenu>
                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.chargerLesAnalyses}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,panelBouton,scrollTable,tableEcriture"/>
                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
            </h:panelGrid>

            <h:panelGrid id="panelBouton" columns="8" width="350px">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle analyse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.ajouterAnalyseCv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier l`analyse sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.modifierAnalyseCv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_bouton)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/detail.png" title="Consulter l`analyse sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.consulterAnalyseCv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_bouton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer l'analyse sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_bouton)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.supprimerAnalyseCv}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette pièce?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableEcriture,panelSolde,panelBouton,modAttente,scrollTable"/>
                <a4j:commandButton image="/images/print.png"title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>
        </h:panelGrid>

        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.pageIndex}" reRender="tableEcriture" id="scrollTable" maxPages="20"align="left" for="tableEcriture"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_nb_max}" id="tableEcriture" width="100%" styleClass="bg" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.dataModelAnalyseCv}" var="cv" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.extDTable}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.selectionAnalyse}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.visualisationAnalyse}" reRender="idSubView,panelBouton"/>
                <rich:column  width="10%" sortable="false" sortBy="#{cv.cvsCode}" >
                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                    <h:outputText value="#{cv.cvsCode}"/>
                </rich:column>
                <rich:column style="text-align:right;" width="10%"  sortable="false" sortBy="#{cv.cvsDateDebut}">
                    <f:facet name="header"><h:outputText value="Début "/></f:facet>
                    <h:outputText value="#{cv.cvsDateDebut}"  >
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
                </rich:column>
                <rich:column style="text-align:right;" width="10%"  sortable="false" sortBy="#{cv.cvsDateFin}">
                    <f:facet name="header"><h:outputText value="fin "/></f:facet>
                    <h:outputText value="#{cv.cvsDateFin}"  >
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
                </rich:column>
                <rich:column  width="25%" sortable="false" sortBy="#{cv.cvsOrganisme}" >
                    <f:facet name="header"><h:outputText value="Organisme"/></f:facet>
                    <h:outputText value="#{cv.cvsOrganisme}"/>
                </rich:column >
                <rich:column  width="10%" sortable="false" sortBy="#{cv.cvsLangue}" >
                    <f:facet name="header"><h:outputText value="Langue"/></f:facet>
                    <h:outputText value="#{cv.cvsLangue}"/>
                </rich:column>
                <rich:column  width="10%" sortable="false" sortBy="#{cv.cvsReference}" >
                    <f:facet name="header"><h:outputText value="Référence"/></f:facet>
                    <h:outputText value="#{cv.cvsReference}"/>
                </rich:column>
                <rich:column  width="10%" sortable="false" sortBy="#{cv.cvsObjet}">
                    <f:facet name="header"><h:outputText value="Observation"/></f:facet>
                    <h:outputText value="#{cv.cvsObjet}"/>
                </rich:column >
            </rich:extendedDataTable>
        </a4j:region>
        <br><br>
        <h:panelGrid id="panelSolde" columns="6"  styleClass="recherche"  width="100%" >

        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationTemps.jsp"/>
        </c:if>
    </rich:modalPanel>

</f:subview>
