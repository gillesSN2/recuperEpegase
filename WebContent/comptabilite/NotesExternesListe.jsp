<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="saisienotesexternes">

    <center> <h2><h:outputText value="LISTE DES NOTES EXTERNES" styleClass="titre"/></h2></center>

    <a4j:form id="notesExt">

        <h:panelGrid id="png1" columns="7" styleClass="recherche" width="100%" >
            <h:column><h:outputText value="N°"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.inpNum}" size="5"/></h:column>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.inpEtat}" style="width:150px;" >
                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.mesEtatsItems}"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.inpType}" style="width:150px;">
                    <f:selectItem itemLabel="Tous Types" itemValue="100"/>
                    <f:selectItem itemLabel="Notes de frais" itemValue="0"/>
                    <f:selectItem itemLabel="Pièces externes" itemValue="1"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.inpCategorie}" style="width:150px;">
                    <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                    <f:selectItem itemLabel="Carburant" itemValue="0"/>
                    <f:selectItem itemLabel="Amende" itemValue="1"/>
                    <f:selectItem itemLabel="Péage" itemValue="2"/>
                    <f:selectItem itemLabel="Taxi" itemValue="3"/>
                    <f:selectItem itemLabel="Transport Urbain" itemValue="4"/>
                    <f:selectItem itemLabel="Restaurant Seul" itemValue="5"/>
                    <f:selectItem itemLabel="Restaurant avec client" itemValue="6"/>
                    <f:selectItem itemLabel="Hébergement" itemValue="7"/>
                    <f:selectItem itemLabel="Entretien véhicule" itemValue="8"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.periode}" style="width:150px;">
                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.mesPeriodesItems}"/>
            </h:selectOneMenu>
            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.recherche}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBtn,scrollTable,tableNotes"/>
            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
        </h:panelGrid>

        <h:panelGrid id="panelBtn" columns="7" width="400px">
            <a4j:commandButton image="/images/ajouter.png" title="Ajouter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ajoutNotes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/modifier.png"  title="Modifier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.modifNotes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/detail.png"  title="Consulter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.consultNotes}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffModif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/supprimer.png" title="Supprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.removeSelectedNotes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotId!=0)==true}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBtn,scrollTable,tableNotes"/>
            <a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail,panCertification"/>
            <a4j:commandButton image="/images/transferer.png" title="Transférer" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.trf&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffAjout)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.openModalPanel}" oncomplete="javascript:Richfaces.showModalPanel('panelTransfert');" reRender="panelTransfert" />
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>
        <br>
        <h:panelGroup  id="table">
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.pageIndex}" reRender="tableNotes" id="scrollTable" maxPages="20"align="left" for="tableNotes"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_nb_max}" border="0" id="tableNotes" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" sortMode="multi" headerClass="headerTab" var="notes" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.dataModelLesNotes}"  width="100%" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.selectionNotes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBtn"/>
                        <rich:column label="N° de la note" sortable="true" sortOrder="ASCENDING" sortBy="#{notes.ecrnotId}">
                            <f:facet name="header"><h:outputText value="N° Note" /></f:facet>
                            <h:outputText  value="#{notes.ecrnotId}" rendered="#{notes.ecrnotNum==null||notes.ecrnotNum==''}"/>
                            <h:outputText  value="#{notes.ecrnotNum}" rendered="#{notes.ecrnotNum!=null&&notes.ecrnotNum!=''}"/>
                        </rich:column>
                        <rich:column label="Type de la note" sortable="true" sortBy="#{notes.libelleType}">
                            <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                            <h:outputText value="#{notes.libelleType}"  />
                        </rich:column>
                        <rich:column label="Date de la note" style="text-align:right" sortable="true" sortBy="#{notes.ecrnotDate}">
                            <f:facet name="header"><h:outputText value="Date" /></f:facet>
                            <h:outputText value="#{notes.ecrnotDate}" >
                                <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                            </h:outputText>
                        </rich:column>                       
                        <rich:column label="Libelle note" sortable="true" sortBy="#{notes.ecrnotLibelle}" width="200px">
                            <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                            <h:outputText  value="#{notes.ecrnotLibelle}"/>
                        </rich:column>
                        <rich:column label="Montant note" style="text-align:right" sortable="true" sortBy="#{notes.ecrnotMontant}">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:outputText value="#{notes.ecrnotMontant}" rendered="#{notes.ecrnotMontant!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Pièce" sortable="true" sortBy="#{notes.ecrnotPiece}">
                            <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                            <h:outputText  value="#{notes.ecrnotPiece}"/>
                        </rich:column>
                        <rich:column label="Catégorie" sortable="true" sortBy="#{notes.libelleCategorie}" width="200px">
                            <f:facet name="header"><h:outputText value="Catégorie" /></f:facet>
                            <h:outputText  value="#{notes.libelleCategorie}"/>
                        </rich:column>
                        <rich:column label="Pièce jointe" sortable="true" sortBy="#{notes.pj}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="PJ"/></f:facet>
                            <h:graphicImage value="#{notes.pj}" height="20px" width="20px" rendered="#{notes.pj!=null}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>


</f:subview>
