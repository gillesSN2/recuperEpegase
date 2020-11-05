<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="mediathequeliste">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES DOCUMENTS DE LA MEDIATHEQUE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_more_search}"/>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpClasse}" style="width:100px;">
                            <f:selectItem itemLabel="Toutes Classes" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.mesClasseItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpDivision}" style="width:100px;">
                            <f:selectItem itemLabel="Toutes Divisions" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpMesDivisionItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpType}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Types" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpMesTypeItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpSupport}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Supports" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpMesSupportItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpContenant}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Contenants" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.inpMesContenantItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table,scrollTable,panelBouton"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="14" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_more_search}">

                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="7" width="350px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.ajouterDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.modifierDocument}" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.consulterDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le(s) document(s) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Prêter le document sélectionné" image="/images/panier.png" style="width:25px;height:30px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.preterDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.datamodelDocument}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.visualisationLigne}" reRender="idSubView,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° Document" sortable="true" sortBy="#{var.docmedNum}" width="100px">
                            <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                            <h:outputText value="#{var.docmedNum}"/>
                        </rich:column>
                        <rich:column label="Titre" sortable="true" sortBy="#{var.docmedTitre}" width="200px">
                            <f:facet name="header"><h:outputText  value="Titre"/></f:facet>
                            <h:outputText  value="#{var.docmedTitre}" title="#{var.docmedTitre}"/>
                        </rich:column>
                        <rich:column label="Auteur" sortable="true" sortBy="#{var.docmedAuteur}" width="200px">
                            <f:facet name="header"><h:outputText  value="Auteur"/></f:facet>
                            <h:outputText  value="#{var.docmedAuteur}" title="#{var.docmedAuteur}"/>
                        </rich:column>
                        <rich:column label="Sujet" sortable="true" sortBy="#{var.docmedCommentaire}" width="200px">
                            <f:facet name="header"><h:outputText  value="Sujet"/></f:facet>
                            <h:outputText  value="#{var.docmedCommentaire}" title="#{var.docmedCommentaire}"/>
                        </rich:column>
                        <rich:column label="Classe" sortable="true" sortBy="#{var.docmedClasse}" width="200px">
                            <f:facet name="header"><h:outputText  value="Classe"/></f:facet>
                            <h:outputText  value="#{var.docmedClasse}" title="#{var.docmedClasse}"/>
                        </rich:column>
                        <rich:column label="Division" sortable="true" sortBy="#{var.docmedDivision}" width="200px">
                            <f:facet name="header"><h:outputText  value="Division"/></f:facet>
                            <h:outputText  value="#{var.docmedDivision}" title="#{var.docmedDivision}"/>
                        </rich:column>
                        <rich:column label="Support" sortable="true" sortBy="#{var.docmedSupport}" width="100px">
                            <f:facet name="header"><h:outputText  value="Support"/></f:facet>
                            <h:outputText  value="#{var.docmedSupport}" title="#{var.docmedSupport}"/>
                        </rich:column>
                        <rich:column label="Contenant" sortable="true" sortBy="#{var.docmedContenant}" width="100px">
                            <f:facet name="header"><h:outputText  value="Contenant"/></f:facet>
                            <h:outputText  value="#{var.docmedContenant}" title="#{var.docmedContenant}"/>
                        </rich:column>
                        <rich:column label="Nb Exemplaire" sortable="true" sortBy="#{var.docmedNbExemplaire}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nb"/></f:facet>
                            <h:outputText  value="#{var.docmedNbExemplaire}" rendered="#{var.docmedNbExemplaire!=0}">
                                 <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


</f:subview>
