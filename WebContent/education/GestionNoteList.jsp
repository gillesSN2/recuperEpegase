<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="elevelistenotes">

    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES NOTES, APPRECIATIONS ET UNITES DE VALEUR" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_more_search}"/>
                    <h:column><h:outputText value="N° matricule"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMatricule}" size="5"/></h:column>
                    <h:column><h:outputText value="Nom élève"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpNom}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpClasse}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Filières/Classes" itemValue="0"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.mesClasseItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.chargerMatieres}" reRender="panCtrl,idMatiere"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idMatiere" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMatiere}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}">
                            <f:selectItem itemLabel="Sélection Matière" itemValue="0"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesMatiereresItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.selectionMatiere}" reRender="panCtrl,idProfesseur"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Validé" itemValue="1"/>
                            <f:selectItem itemLabel="Annulé" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.executerRequeteNote}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="11" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_more_search}">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpDateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpDateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="11" width="450px" style="height:34px">
            <a4j:commandButton title="Ajouter des notes (Appréciations/Notes/U.V.)" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.ajouterNote}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier des notes (Appréciations/Notes/U.V.)" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.modifierNote}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter des notes (Appréciations/Notes/U.V.)" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.consulterAppels}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.elevesNote.elenotEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.supprimerDocumentNote}" reRender="table,panelBouton"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.elevesNote.elenotEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.annulerDocumentNote}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.initGrapheur}"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.elevesNote.elenotEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.valideDocumentNote}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.elevesNote.elenotEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.deValideDocumentNote}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Mise à jour des moyennes des filières" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.majMoyenneClasse}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les moyennes des filieres ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable groupingColumn="idDate" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.datamodelNote}" var="note" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.selectionLigneNote}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visualisationLigneNote}" reRender="idSubView,panelBouton,panCtrl"/>
                        <rich:column id="idDate" label="Date" sortable="true" sortBy="#{note.elenotDate} #{note.elenotMatiere}" width="8%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Date note"/></f:facet>
                            <h:outputText value="#{note.elenotDate}">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                         <rich:column label="Filière" sortable="true" sortBy="#{note.elenotFiliere}" width="7%">
                            <f:facet name="header" ><h:outputText value="Filière"/></f:facet>
                            <h:outputText value="#{note.elenotFiliere}"/>
                        </rich:column>
                         <rich:column label="Matière" sortable="true" sortBy="#{note.elenotMatiere}" width="7%">
                            <f:facet name="header" ><h:outputText value="Matière"/></f:facet>
                            <h:outputText value="#{note.elenotMatiere}"/>
                        </rich:column>
                        <rich:column label="N° note" sortable="true" sortBy="#{note.elenotNum}" width="7%">
                            <f:facet name="header" ><h:outputText value="N° note"/></f:facet>
                            <h:outputText value="#{note.elenotNum}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{note.libelleEtat}" width="5%">
                            <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                            <h:outputText value="#{note.libelleEtat}"/>
                        </rich:column>
                        <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{note.eleves.eleDossier}" width="9%">
                            <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                            <h:outputText value="#{note.eleves.eleDossier}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" sortBy="#{note.eleves.eleNom} #{note.eleves.elePrenom}" width="24%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                            <h:outputText value="#{note.eleves.eleNom} #{note.eleves.elePrenom}"/>
                        </rich:column>
                        <rich:column label="Appréciation/Note/Unité de valeur" sortable="true" sortBy="#{note.elenotValAppreciation} #{note.elenotValNote} #{note.elenotValUv}" width="8%"  style="text-align:right">
                            <f:facet name="header" ><h:outputText value="Note"/></f:facet>
                            <h:outputText value="#{note.elenotValAppreciation}" rendered="#{note.elenotMode==0}"/>
                            <h:outputText value="#{note.elenotValNote}" rendered="#{note.elenotMode==1}"  style="text-align:right"/>
                            <h:outputText value="#{note.elenotValUv}" rendered="#{note.elenotMode==2}"  style="text-align:right"/>
                        </rich:column>
                        <rich:column label="Coefficient" sortable="true" sortBy="#{note.elenotCoef}" width="5%"  style="text-align:right">
                            <f:facet name="header" ><h:outputText value="Coefficient"/></f:facet>
                            <h:outputText value="#{note.elenotCoef}"  style="text-align:right"/>
                        </rich:column>
                        <rich:column label="Observations" sortable="true" sortBy="#{note.elenotObservation}" width="15%">
                            <f:facet name="header"><h:outputText value="Observations"/></f:facet>
                            <h:outputText value="#{note.elenotObservation}"/>
                        </rich:column>
                        <rich:column  width="5%" sortable="true" sortBy="#{note.scanner}" label="Scan du courrier" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Scan"/></f:facet>
                            <h:graphicImage value="#{note.scanner}" height="20px" width="20px" rendered="#{note.scanner!=null}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="false">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Note"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.annuleAnnulationNote}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.dateAnnulation}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.motifAnnulation}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.miseajourAnnulerNote}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
