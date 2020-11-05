<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="SaisieBrouillardJ">

    <a4j:form >

        <center> <h2><h:outputText value="SAISIE DES BROUILLARDS (JOURNALIERS)" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGlobal" width="100%" >
            <h:panelGrid id="panelRecherche" columns="6" styleClass="recherche" width="100%" >
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.code}" style="width:180px;" >
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesJournauxComptables}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,idPeriode,panelRecherche,panelBouton,tableEcriture,panelSolde" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.chargerLesPeriodesJournal}"/>
                </h:selectOneMenu>
                <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.periode}" style="width:150x;" >
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesPeriodes}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde,idJour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.calculLesJourDunMois}"/>
                </h:selectOneMenu>
                <h:selectOneMenu id="idJour" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.jour}" style="width:80px;" >
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesjoursItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.razBrouillard}"/>
                </h:selectOneMenu>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.propritaire}" style="width:247px;" >
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesuserItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.razBrouillard}"/>
                </h:selectOneMenu>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.etat}" style="width:100px;" >
                    <f:selectItem itemLabel="Tous les états" itemValue="100"/>
                    <f:selectItem itemLabel="En Cours" itemValue="0"/>
                    <f:selectItem itemLabel="Validés" itemValue="1"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.razBrouillard}"/>
                </h:selectOneMenu>
                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.chargerLesBrouillardsJour}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,panelBouton,scrollTable,tableEcriture"/>
                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
            </h:panelGrid>
            <h:panelGrid id="panelBouton" columns="8" width="350px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testsaisibrouillard}">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle pièce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ajouterPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_saisieProprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier la pièce sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.modifierPiece}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_saisieProprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testAffMAjbrouillard&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broEtat==0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/detail.png" title="Consulter la pièce sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.consulterPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testAffMAjbrouillard}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la pièce sélectionnée" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_saisieProprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testAffSupbrouillard&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broEtat==0)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.supprimerPiece}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette pièce?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableEcriture,panelSolde,panelBouton,modAttente"/>
                <a4j:commandButton image="/images/print.png"title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton image="/images/valDoc.png" title="Valider dans les journaux" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.validationLignes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_saisieProprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.trf}" reRender="panelValidation"/>
                <a4j:commandButton image="/images/changePiece.png" title="Changer le Numéro de pièce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.changerNumPiece}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_saisieProprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testAffMAjbrouillard&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broEtat==0)==true}" reRender="panelPiece"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>
        </h:panelGrid>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableEcriture"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_nb_max}" id="tableEcriture" width="100%" styleClass="bg" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.dataModelLesBrouillards}" var="brouillard" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                <a4j:support eventsQueue="maQueue" reRender="panelBouton" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.selctionPiece}"/>
                <rich:column style="text-align:center;" width="5%" sortable="true" sortBy="#{brouillard.broCloture}">
                    <f:facet name="header"><h:outputText  value="Clot"/></f:facet>
                    <h:graphicImage rendered="#{brouillard.broCloture!=0}"  value="/images/cadenas_cl.png" id="imcadenas"/>
                </rich:column>
                <rich:column style="text-align:center;" width="5%" sortable="true" sortBy="#{brouillard.broEtat}">
                    <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                    <h:outputText value="#{brouillard.lib_etat}"/>
                </rich:column>
                <rich:column style="text-align:right;" width="10%" sortable="true" sortBy="#{brouillard.broDateSaisie}">
                    <f:facet name="header"><h:outputText  value="Date "/></f:facet>
                    <h:outputText value="#{brouillard.broDateSaisie}">
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
                </rich:column>
                <rich:column  width="10%"  sortable="true" sortBy="#{brouillard.broNum}" sortOrder="ASCENDING">
                    <f:facet name="header"><h:outputText value="N° Brouil." /></f:facet>
                    <h:outputText value="#{brouillard.broNum}"/>
                </rich:column>
                <rich:column  width="10%"  sortable="true" sortBy="#{brouillard.broPiece}">
                    <f:facet name="header"><h:outputText value="N° Pièce" /></f:facet>
                    <h:outputText value="#{brouillard.broPiece}" title="#{brouillard.broPiece}"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{brouillard.broReference1}">
                    <f:facet name="header"><h:outputText value="Référence 1" /></f:facet>
                    <h:outputText value="#{brouillard.broReference1}" title="#{brouillard.broReference1}"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{brouillard.broReference2}">
                    <f:facet name="header"><h:outputText value="Référence 2" /></f:facet>
                    <h:outputText value="#{brouillard.broReference2}" title="#{brouillard.broReference2}"/>
                </rich:column>
                <rich:column  width="20%" sortable="true" sortBy="#{brouillard.broLibelle}">
                    <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                    <h:outputText value="#{brouillard.broLibelle}" title="#{brouillard.broLibelle}"/>
                </rich:column >
                <rich:column  width="10%" style="text-align:right;" sortable="true" sortBy="#{brouillard.broDebitSaisie}" >
                    <f:facet name="header"><h:outputText value="Débit"/></f:facet>
                    <h:outputText value="#{brouillard.broDebitSaisie}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column >
                <rich:column width="10%" style="text-align:right;"  sortable="true" sortBy="#{brouillard.broCreditSaisie}">
                    <f:facet name="header"><h:outputText value="crédit"/></f:facet>
                    <h:outputText value="#{brouillard.broCreditSaisie}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column label="Piece jointe"  width="3%" style="text-align:center;">
                    <f:facet name="header"><h:outputText  value="Pj." /></f:facet>
                    <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Visualisation pièce scannée" image="/images/mail_pj.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ouvrirPjConsultation}" reRender="panelPJ,formPJ" rendered="#{brouillard.broPj}"/>
                </rich:column>
                <rich:column  width="10%"  sortable="true" sortBy="#{brouillard.broNomResponsable}">
                    <f:facet name="header"><h:outputText  value="Responsable" /></f:facet>
                    <h:outputText value="#{brouillard.broNomResponsable}" title="#{brouillard.broNomResponsable}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br><br>
        <h:panelGrid id="panelSolde" columns="6"  styleClass="recherche"  width="100%" >
            <h:outputText value="Total Débit:"/>
            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.totalBroDeb}" style=" font-weight:bold">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
            <h:outputText value="Total Crédit:"/>
            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.totalBroCred}" style=" font-weight:bold">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
            <h:outputText value="Solde brouillard:"/>
            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.soldeTotal}" style=" font-weight:bold">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPrint}">
       <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>


    <!--debut modalPanel validation des ecritures  -->
    <rich:modalPanel domElementAttachment="parent"  id="panelValidation" width="400" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelValidation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelValidation}" var="val">
            <f:facet name="header"><h:outputText value="Validation des écritures saisies"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.annulerValidationLignes}" image="/images/close.gif" styleClass="hidelink" reRender="panelValidation"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formValidation">
                <h:panelGrid width="100%" >
                    <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_choix_validation}">
                        <f:selectItem itemValue="0" itemLabel="Validation par Jour"/>
                        <f:selectItem itemValue="1" itemLabel="Validation par pièces"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="formValidation,panValJour,panValPiece"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br>
                <h:panelGrid id="panValJour" width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_choix_validation==0}">
                    <h:column><h:outputText value="Jour début:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_jourDebut}"  style="width:80px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesjoursItems}"  />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Jour fin:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_jourFin}"  style="width:80px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesjoursItems}"  />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panValPiece" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_choix_validation==1}">
                    <h:column>
                        <a4j:commandButton value="SEL./DESEL."  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.selectionToutesPieces}" reRender="listeTableau"/>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="listeTableau" height="200px" width="100%" enableContextMenu="false" headerClass="headerTab" selectedClass="active-row" var="pcs" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesPiecesSelectionnes}">
                                <rich:column  width="30%" style="text-align:center;" >
                                    <f:facet name="header" >
                                        <f:facet name="header"><h:outputText  value="SELECTION" /></f:facet>
                                    </f:facet>
                                    <h:selectBooleanCheckbox value="#{pcs.select}" />
                                </rich:column>
                                <rich:column  width="70%"  sortable="true" sortBy="#{pcs.ecrPiece}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="PIECE" /></f:facet>
                                    <h:outputText value="#{pcs.ecrPiece}" />
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.saveValidationLignes}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelValidation,tableEcriture"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!--debut change numero de piece  -->
    <rich:modalPanel domElementAttachment="parent"  id="panelPiece" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPiece}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPiece}" var="pic">
            <f:facet name="header"><h:outputText value="Change le Numéro de pièce"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fermerNumPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelPiece"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPiece">
                <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                    <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_ancien_numero}" style="width:200px;" readonly="true"/></h:column>
                    <h:column><h:outputText value="Nouveau Numéro:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_nouveau_numero}" maxlength="20" style="width:200px;"/></h:column>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.valideNumPiece}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelPiece,tableEcriture"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" onbeforeshow="LoadControl();" onbeforehide="UnloadControl();" id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPJ}" var="pie">
            <f:facet name="header"><h:outputText value="Pièce jointe"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.modePj==2}">
                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.reInitPj}"/>
                    </h:column>&nbsp;&nbsp;
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.modePj==2}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fermerPj}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <h:form id="formPJ" enctype="multipart/form-data">
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.modePj==1}" var="pjcreat">
                    <h:panelGrid width="100%">
                        <center>
                            <select size="1" id="source" style="position: relative; width: 220px;"/>
                            <input type="button" value="Scan" onclick="AcquireImage();"/>
                            <div id="dwtcontrolContainer"></div>
                            <h:inputHidden id="idValScan" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.valueScanPj}"  immediate="true"/>
                            <script type="text/javascript">
                                Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', Dynamsoft_OnReady);
                                var DWObject;
                                function LoadControl() {
                                    Dynamsoft.WebTwainEnv.Load();
                                }
                                function UnloadControl() {
                                    Dynamsoft.WebTwainEnv.Unload();
                                }
                                function Dynamsoft_OnReady() {
                                    DWObject = Dynamsoft.WebTwainEnv.GetWebTwain('dwtcontrolContainer');
                                    if (DWObject) {
                                        var count = DWObject.SourceCount;
                                        if(count == 0 && Dynamsoft.Lib.env.bMac)
                                        {
                                            DWObject.CloseSourceManager();
                                            DWObject.ImageCaptureDriverType = 0;
                                            DWObject.OpenSourceManager();
                                            count = DWObject.SourceCount;
                                        }
                                        for (var i = 0; i < count; i++)
                                            document.getElementById("source").options.add(new Option(DWObject.GetSourceNameItems(i), i));
                                    }
                                }
                                function AcquireImage() {
                                    if (DWObject) {
                                        var OnAcquireImageSuccess, OnAcquireImageFailure;
                                        OnAcquireImageSuccess = OnAcquireImageFailure = function (){
                                            DWObject.CloseSource();
                                        };
                                        DWObject.SelectSourceByIndex(document.getElementById("source").selectedIndex);
                                        DWObject.OpenSource();
                                        DWObject.IfDisableSourceAfterAcquire = true;
                                        DWObject.AcquireImage(OnAcquireImageSuccess, OnAcquireImageFailure);
                                    }
                                }
                                function LireValeur(){
                                    var imagedata;
                                    DWObject.SelectedImagesCount = 1;
                                    DWObject.SetSelectedImageIndex(0,0);
                                    DWObject.GetSelectedImagesSize(EnumDWT_ImageType.IT_JPG);
                                    imagedata = DWObject.SaveSelectedImagesToBase64Binary();
                                    var newImage = document.createElement('img');
                                    newImage.onload = function () {
                                        document.getElementsByTagName('body')[0].appendChild(this);
                                    };
                                    newImage.src = "data:image/png;base64," + imagedata;
                                    document.getElementById("sm:formPJ:idValScan").value = newImage.src;
                                }
                            </script>
                        </center>
                    </h:panelGrid>
                    <br><br>
                    <center>
                        <h:panelGroup >
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.validerPj}" onclick="LireValeur();" image="/images/valider_big.png" styleClass="hidelink"/>
                        </h:panelGroup>
                    </center>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.modePj==2}" var="pjvisu">
                    <h:panelGrid width="100%">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.typeFichier==0}" var="sc1">
                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.urlphotoProd}" width="100%" height="800px"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.typeFichier==1}" var="sc2">
                            <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fichierMine}" width="100%" height="550">
                                <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fichierUrl}"></a>
                            </object>
                        </c:if>
                    </h:panelGrid>
                </c:if>
            </h:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
