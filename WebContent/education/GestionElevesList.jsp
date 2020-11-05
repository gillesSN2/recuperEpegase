<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="elevelistegestion">

    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES ELEVES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
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
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Inactif" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="11" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_more_search}">
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="4" width="200px" style="height:34px">
            <a4j:commandButton title="Gestion des notes" image="/images/tableau.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.gestionNotes}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelNote"/>
            <a4j:commandButton title="Gestion des absences" image="/images/absence.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.gestionPresence}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPresence"/>
            <a4j:commandButton title="Gestion des violences" image="/images/violence.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.gestionViolences}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelViolence"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.datamodelDocument}" var="elv" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{elv.eleves.eleDossier}" width="10%">
                            <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                            <h:outputText value="#{elv.eleves.eleDossier}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{elv.eleves.eleCivilite}" width="10%">
                            <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                            <h:outputText value="#{elv.eleves.eleCivilite}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{elv.eleves.eleNomFamille}" width="10%">
                            <f:facet name="header" ><h:outputText value="Famille"/></f:facet>
                            <h:outputText value="#{elv.eleves.eleNomFamille}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" sortBy="#{elv.eleves.eleNom} #{elv.eleves.elePrenom}" width="30%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                            <h:outputText value="#{elv.eleves.eleNom} #{elv.eleves.elePrenom}"/>
                        </rich:column>
                        <rich:column label="Année" sortable="true" sortBy="#{elv.eleinsAnnee}" width="10%">
                            <f:facet name="header" ><h:outputText value="Année"/></f:facet>
                            <h:outputText value="#{elv.eleinsAnnee}"/>
                        </rich:column>
                        <rich:column label="Filière/Classe" sortable="true" sortBy="#{elv.filieresEducation.filCode} #{elv.filieresEducation.filLibelle}" width="20%">
                            <f:facet name="header" ><h:outputText value="Filière/Classe"/></f:facet>
                            <h:outputText value="#{elv.filieresEducation.filCode} #{elv.filieresEducation.filLibelle}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
        </center>

    </a4j:form>


    <rich:modalPanel id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelGraph}">
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
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par famille produit" itemValue="5"/>
                                <f:selectItem itemLabel="par produit" itemValue="6"/>
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


    <rich:modalPanel id="panelNote" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="450" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelNote}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelNote}" var="not">
            <f:facet name="header"><h:outputText value="NOTES DE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.eleves.eleDossier} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.eleves.patronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.fermerGestionNotes}" image="/images/close.gif" styleClass="hidelink" reRender="panelNote"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalNote">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;" id="idPanelGlobalNote">
                    <h:panelGrid  columns="5" style="width:100%;">
                        <h:column><h:outputText value="Sélection annnée:"/></h:column>
                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.choixInscription}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesInscriptionsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.chargerMatieresByEleve}" reRender="idMatieres"/>
                        </h:selectOneMenu>
                        <h:column><h:outputText value="Sélection matières:"/></h:column>
                        <h:selectOneMenu id="idMatieres" style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.choixMatiere}" >
                            <f:selectItem itemLabel="Toutes les matières" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesMatiereresItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.chargerNotesByMatiere}" reRender="idPanelGlobalNote"/>
                        </h:selectOneMenu>
                        <a4j:commandButton title="Imprimer buletins" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid style="width:100%;">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable groupingColumn="idMat" styleClass="bg" id="tableNote" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.datamodelNote}" var="note">
                                <rich:column label="Date" sortable="true" sortBy="#{note.elenotDate}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Date note"/></f:facet>
                                    <h:outputText value="#{note.elenotDate}">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="N° note" sortable="true" sortBy="#{note.elenotNum}" width="8%">
                                    <f:facet name="header" ><h:outputText value="N° note"/></f:facet>
                                    <h:outputText value="#{note.elenotNum}"/>
                                </rich:column>
                                <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{note.libelleEtat}" width="5%">
                                    <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                                    <h:outputText value="#{note.libelleEtat}"/>
                                </rich:column>
                                <rich:column label="Matière"id="idMat" sortable="true" sortBy="#{note.filieresMatieres.filmatLibelle}" width="12%">
                                    <f:facet name="header" ><h:outputText value="Matière"/></f:facet>
                                    <h:outputText value="#{note.filieresMatieres.filmatLibelle}"/>
                                </rich:column>
                                <rich:column label="Type note" sortable="true" sortBy="#{note.libelleType}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{note.libelleType}"/>
                                </rich:column>
                                <rich:column label="Appréciation/Note/Unité de valeur" sortable="true" sortBy="#{note.elenotValAppreciation} #{note.elenotValNote} #{note.elenotValUv}" width="10%"  style="text-align:right">
                                    <f:facet name="header" ><h:outputText value="Note"/></f:facet>
                                    <h:outputText value="#{note.elenotValAppreciation}" rendered="#{note.elenotMode==0}"/>
                                    <h:outputText value="#{note.elenotValNote}" rendered="#{note.elenotMode==1}"  style="text-align:right"/>
                                    <h:outputText value="#{note.elenotValUv}" rendered="#{note.elenotMode==2}"  style="text-align:right"/>
                                </rich:column>
                                <rich:column label="Coefficient" sortable="true" sortBy="#{note.elenotCoef}" width="8%" style="text-align:right">
                                    <f:facet name="header" ><h:outputText value="Coefficient"/></f:facet>
                                    <h:outputText value="#{note.elenotCoef}" style="text-align:right"/>
                                </rich:column>
                                <rich:column label="Observations" sortable="true" sortBy="#{note.elenotObservation}" width="30%">
                                    <f:facet name="header"><h:outputText value="Observations"/></f:facet>
                                    <h:outputText value="#{note.elenotObservation}"/>
                                </rich:column>
                                <rich:column  width="5%" sortable="true" sortBy="#{note.scanner}" label="Scan le devoir" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Scan"/></f:facet>
                                    <h:graphicImage value="#{note.scanner}" height="20px" width="20px" rendered="#{note.scanner!=null}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <br>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelPresence" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="450" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelPresence}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.showModalPanelPresence}" var="pre">
            <f:facet name="header"><h:outputText value="PRESENCES/ABSENCES DE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.eleves.eleDossier} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.eleves.patronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.fermerGestionPresence}" image="/images/close.gif" styleClass="hidelink" reRender="panelPresence"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalresence">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;" id="idPanelGlobalPresence">
                    <h:panelGrid  columns="4" style="width:100%;">
                        <h:column><h:outputText value="Sélection annnée:"/></h:column>
                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.choixInscription}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesInscriptionsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.chargerMatieresByEleve}" reRender="idMatieres"/>
                        </h:selectOneMenu>
                        <h:column><h:outputText value="Sélection matières:"/></h:column>
                        <h:selectOneMenu id="idMatieres" style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.choixMatiere}" >
                            <f:selectItem itemLabel="Toutes les matières" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesMatiereresItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.chargerPresencesByMatiere}" reRender="idPanelGlobalPresence"/>
                        </h:selectOneMenu>
                        <a4j:commandButton title="Imprimer présences" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menueducation.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid style="width:100%;">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable groupingColumn="idMat" styleClass="bg" id="tablePresence" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.datamodelAppels}" var="app">
                                <rich:column label="Date" sortable="true" sortBy="#{app.eleappDate}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Date appel"/></f:facet>
                                    <h:outputText value="#{app.eleappDate}">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="N° appel" sortable="true" sortBy="#{app.eleappNum}" width="8%">
                                    <f:facet name="header" ><h:outputText value="N° appel"/></f:facet>
                                    <h:outputText value="#{app.eleappNum}"/>
                                </rich:column>
                                <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{app.libelleEtat}" width="5%">
                                    <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                                    <h:outputText value="#{app.libelleEtat}"/>
                                </rich:column>
                                <rich:column label="Matière" id="idMat" sortable="true" sortBy="#{app.filieresMatieres.filmatLibelle}" width="12%">
                                    <f:facet name="header" ><h:outputText value="Matière"/></f:facet>
                                    <h:outputText value="#{app.filieresMatieres.filmatLibelle}"/>
                                </rich:column>
                                <rich:column label="Présent/Absence/Retard" sortable="true" sortBy="#{app.libelleType}" width="20%">
                                    <f:facet name="header" ><h:outputText value="Présent/Absence/Retard"/></f:facet>
                                    <h:outputText value="#{app.libelleType}"/>
                                </rich:column>
                                <rich:column label="Motif absences" sortable="true" sortBy="#{app.eleappObservation}" width="20%">
                                    <f:facet name="header"><h:outputText value="Motif"/></f:facet>
                                    <h:outputText value="#{app.eleappObservation}" rendered="#{app.eleappType!=0}"/>
                                </rich:column>
                                <rich:column  width="5%" sortable="true" sortBy="#{app.scanner}" label="Scan du courrier" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Scan"/></f:facet>
                                    <h:graphicImage value="#{app.scanner}" height="20px" width="20px" rendered="#{app.scanner!=null}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <br>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
