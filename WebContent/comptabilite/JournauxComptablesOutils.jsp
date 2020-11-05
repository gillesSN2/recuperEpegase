<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="outilscorrectionJournaux">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="OUTILS DE CORRECTION DES JOURNAUX" styleClass="titre"/></h2></center>

        <h:panelGrid  styleClass="fichefournisseur"columns="3">
            <rich:column width="20%">
                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi}" style="margin-left:90px;width:45%;">
                    <f:selectItem itemLabel="Sélectionner l'outil" itemValue="99"/>
                    <f:selectItem itemLabel="Inverser Débits et crédits" itemValue="0"/>
                    <f:selectItem itemLabel="Inverser le sens des débits" itemValue="1"/>
                    <f:selectItem itemLabel="Inverser le sens des crédits" itemValue="2"/>
                    <f:selectItem itemLabel="Changer Journal" itemValue="3"/>
                    <f:selectItem itemLabel="Changer Période" itemValue="4"/>
                    <f:selectItem itemLabel="Changer Compte" itemValue="5"/>
                    <f:selectItem itemLabel="Changer Trésorerie"itemValue="6" itemDisabled="true"/>
                    <f:selectItem itemLabel="Changer Activité" itemValue="7" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Budget" itemValue="8" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.budget||true}"/>
                    <f:selectItem itemLabel="Changer Site" itemValue="9" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Département" itemValue="10" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Service" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Région" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Secteur" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Point de vente" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Parc" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Changer Dossier" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.analytique||true}"/>
                    <f:selectItem itemLabel="Calculer contrepartie du compte de trésorerie" itemValue="17"/>
                    <f:selectItem itemLabel="Duppliquer écritures vers autre période" itemValue="20"/>
                    <f:selectItem itemLabel="Duppliquer écritures vers autre journal" itemValue="21"/>
                    <f:selectItem itemLabel="Optimiser journal par pièces et comptes" itemValue="22"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="selectOutil,executer,tableEcritures" />
                </h:selectOneMenu >
            </rich:column>

            <rich:column width="30%">
                <h:panelGrid id="selectOutil" columns="4">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi==3}">
                        <h:column><h:outputText value="Journal Actuel:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljLibelleFr}" readonly="true" style="width:180px"/></h:column>
                        <h:column><h:outputText value="Nouveau Journal:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsCode}" style="width:180px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsLesJournauxComptables}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi==4}">
                        <h:column><h:outputText value="Période Actuelle:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxMois.joumenPeriode}" readonly="true" style="width:180px"/></h:column>
                        <h:column><h:outputText value="Nouvelle Période:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsPeriode}" style="width:150x;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsLesPeriode}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi==5}">
                        <h:column><h:outputText value="Compte Actuel:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsCompteOld}" style="width:180px"/></h:column>
                        <h:column><h:outputText value="Nouveau Compte:"/></h:column>
                        <h:column>
                            <h:inputText id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrCompte}" style="width:180px">
                                <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable,compteId"/>
                            </h:inputText>
                        </h:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi==20}">
                        <h:column><h:outputText value="Nouvelle Période:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsPeriode}" style="width:150x;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsLesPeriode}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi==21}">
                        <h:column><h:outputText value="Nouveau Journal:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsCode}" style="width:180px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.toolsLesJournauxComptables}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi==23}">
                        <h:column>
                            <rich:fileUpload id="upload" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.listenerComparatif}"/>
                        </h:column>
                    </c:if>
                </h:panelGrid>
            </rich:column>

            <h:panelGrid width="50%" id="executer" columns="6">
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.forceVerrou}" style="color:red"/></h:column>
                <h:column><h:outputText value="Prendre aussi les écritures verrouillées" style="color:red"/></h:column>
                <a4j:commandButton reRender="tableEcritures,scrollTable" value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionAll}" />
                <a4j:commandButton reRender="tableEcritures,scrollTable" value="Tout dé-sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.deselectionAll}"/>
                <h:commandButton value="EXECUTER CORRECTION" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.majCorrection}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.outilChoisi!=99}"  onclick="if (!confirm('Etes-vous sur de vouloir exécuter la mise à jour?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerCorrection}" styleClass="fermer"/>
            </h:panelGrid>
        </h:panelGrid>

        <br>

        <h:panelGrid width="100%" id="richpanlisteECR" styleClass="fichefournisseur1">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.pageIndex}" reRender="tableEcritures" id="scrollTable" maxPages="20"align="left" for="tableEcritures"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" sortMode="multi" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.datamodelEcritures}" var="table" id="tableEcritures" width="100%" style="max-height:100%;border: solid 1px">
                    <rich:column label="Sélection" width="3%" sortable="true" sortBy="#{table.sel_ecriture}"  >
                        <f:facet name="header"><h:outputText  value="Sél." /></f:facet>
                        <h:selectBooleanCheckbox value="#{table.sel_ecriture}" style="width:10px;"/>
                    </rich:column>
                    <rich:column label="Etat" width="3%" sortable="true" sortBy="#{table.ecrEtat}"  >
                        <f:facet name="header"><h:outputText  value="E." /></f:facet>
                        <h:outputText value="#{table.lib_etat}" style="width:10px;"/>
                    </rich:column>
                    <rich:column label="Jour" width="3%" sortable="true" sortBy="#{table.ecrJour}"  >
                        <f:facet name="header"><h:outputText  value="J." /></f:facet>
                        <h:outputText value="#{table.ecrJour}" style="width:10px;"/>
                    </rich:column>
                    <rich:column label="Journal"  width="5%" sortable="true" sortBy="#{table.ecrCode}" >
                        <f:facet name="header"><h:outputText value="Journal" /></f:facet>
                        <h:outputText value="#{table.ecrCode}" />
                    </rich:column>
                    <rich:column label="Compte" width="8%" sortable="true" sortBy="#{table.ecrCompte}" >
                        <f:facet name="header"><h:outputText  value="N° compte"  /></f:facet>
                        <h:outputText  value="#{table.ecrCompte}"/>
                    </rich:column>
                    <rich:column label="Contrepartie"  width="8%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testContrePartie}" sortable="true" sortBy="#{table.ecrContrePartie}" >
                        <f:facet name="header"><h:outputText value="Contrepartie" /></f:facet>
                        <h:outputText value="#{table.ecrContrePartie}" />
                    </rich:column>
                    <rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{table.ecrPiece}" sortOrder="DESCENDING" >
                        <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
                        <h:outputText value="#{table.ecrPiece}" />
                    </rich:column>
                    <rich:column label="Référence N°1"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" >
                        <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
                        <h:outputText value="#{table.ecrReference1}"/>
                    </rich:column>
                    <rich:column label="Référence n°2" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}">
                        <f:facet name="header"><h:outputText  value="Référence2"/></f:facet>
                        <h:outputText value="#{table.ecrReference2}"/>
                    </rich:column>
                    <rich:column label="Dossier" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier==3}" sortable="true" sortBy="#{table.ecrDossier}">
                        <f:facet name="header"><h:outputText  value="Dossier"/></f:facet>
                        <h:outputText value="#{table.ecrDossier}"/>
                    </rich:column>
                    <rich:column label="Date échéance"  width="10%" sortable="true" sortBy="#{table.ecrDateEcheance}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==2}">
                        <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                        <h:outputText value="#{table.ecrDateEcheance}" style="width:10px;">
                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date valeur" width="10%" sortable="true" sortBy="#{table.ecrDateValeurTheo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                        <f:facet name="header"><h:outputText  value="Date val."/></f:facet>
                        <h:outputText value="#{table.ecrDateValeurTheo}" style="width:10px;">
                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Lettrage/Pointage/Rapproc."  width="3%" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="LPR." /></f:facet>
                        <a4j:commandButton image="/images/cadenas_cl.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirLpr}" reRender="modalpanelLPR,formLpr" rendered="#{table.nbrEcrLettrage}"/>
                    </rich:column>
                    <rich:column label="Montant débit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitSaisie}" >
                        <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                        <h:outputText   value="#{table.ecrDebitSaisie}" rendered="#{table.ecrDebitSaisie!=0}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant crédit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditSaisie}" >
                        <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                        <h:outputText value="#{table.ecrCreditSaisie}"  style="text-align:right;" rendered="#{table.ecrCreditSaisie!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Libellé écriture"  width="15%"sortable="true" sortBy="#{table.ecrLibelle}"  >
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{table.ecrLibelle}" style="width:100px;"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnalytique" width="1100" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelCorrection}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelCorrection}" var="corret">
            <f:facet name="header"><h:outputText value="CORRECTION IMPUTATION ANALYTIQUE (Liste des écritures à réimputer)"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerAnalytique}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnalytique"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.pageIndex}" reRender="tableCorrection" id="scrollTableCorrection" maxPages="20"align="left" for="tableCorrection"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.dataModelEcritureAReimputer}" var="table" id="tableCorrection" width="100%" style="max-height:100%;border: solid 1px">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionLigneCorrection}"/>
                        <rich:column label="Jour" width="3%" sortable="true" sortBy="#{table.ecrJour}"  >
                            <f:facet name="header"><h:outputText  value="J." /></f:facet>
                            <h:outputText value="#{table.ecrJour}" style="width:10px;"/>
                        </rich:column>
                        <rich:column label="Compte" width="8%" sortable="true" sortBy="#{table.ecrCompte}" >
                            <f:facet name="header"><h:outputText  value="N° compte"  /></f:facet>
                            <h:outputText  value="#{table.ecrCompte}"/>
                        </rich:column>
                        <rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{table.ecrPiece}" sortOrder="DESCENDING" >
                            <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
                            <h:outputText value="#{table.ecrPiece}" />
                        </rich:column>
                        <rich:column label="Référence N°1"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" >
                            <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
                            <h:outputText value="#{table.ecrReference1}"/>
                        </rich:column>
                        <rich:column label="Référence n°2" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}">
                            <f:facet name="header"><h:outputText  value="Référence2"/></f:facet>
                            <h:outputText value="#{table.ecrReference2}"/>
                        </rich:column>
                        <rich:column label="Lettrage/Pointage/Rapproc."  width="3%" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="LPR." /></f:facet>
                            <a4j:commandButton image="/images/cadenas_cl.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirLpr}" reRender="modalpanelLPR,formLpr" rendered="#{table.nbrEcrLettrage}"/>
                        </rich:column>
                        <rich:column label="Montant débit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitSaisie}" >
                            <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                            <h:outputText   value="#{table.ecrDebitSaisie}" rendered="#{table.ecrDebitSaisie!=0}" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant crédit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditSaisie}" >
                            <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                            <h:outputText value="#{table.ecrCreditSaisie}"  style="text-align:right;" rendered="#{table.ecrCreditSaisie!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Libellé écriture"  width="20%"sortable="true" sortBy="#{table.ecrLibelle}"  >
                            <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                            <h:outputText value="#{table.ecrLibelle}" style="width:100px;"/>
                        </rich:column>
                        <rich:column width="4%" style="text-align:center;">
                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.saisieImputation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytiqueCorrection,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==false}" ></a4j:commandButton>
                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail_alerte.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.saisieImputation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytiqueCorrection,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==true}" ></a4j:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="modalpanelAnalytiqueCorrection" width="1100" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAnalytiqueCorrection}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAnalytiqueCorrection}" var="analCorrection">
            <f:facet name="header"><h:outputText value="CORRECION IMPUTATION ANALYTIQUE"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerAnalytique}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelAnalytiqueCorrection" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}"/>
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="../commun/analytiqueJournaux.jsp"/>
        </c:if>
    </rich:modalPanel>


</f:subview>
