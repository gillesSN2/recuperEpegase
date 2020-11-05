<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="sm">

    <center> <h2><h:outputText value="SAISIE MENSUELLE DES OPERATIONS COMPTABLES" styleClass="titre"/></h2></center>

    <a4j:form id="formsm" enctype="multipart/form-data">
        <h:panelGrid  width="100%" id="pngGlobal">
            <h:panelGrid  columns="2"  width="100%" id="pngGlob" columnClasses="clos50d;clos50g">
                <h:panelGrid  style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_hauteur}" width="100%" styleClass="fichefournisseur1" >
                    <b><h:outputText value="Journal : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljCode} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljLibelleFr}  (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.devise}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.cpTreso}" styleClass="titre" /></b>
                    <b><h:outputText value="Période : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxMois.joumenPeriode}" styleClass="titre"/></b>
                    <h:panelGrid id="fermer" columns="2">
                        <h:commandButton value="FERMER" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_acces_direct==true&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testfermerleJournal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerLeJournalEncours}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <h:commandButton value="RETOUR EXTRAIT" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_acces_direct==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testfermerleJournal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.fermerJournauxExtrait}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <h:panelGrid columns="14" width="500px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Nouvelle écriture" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ajouterLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAccesCorrection==2||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" reRender="pngMaj,pngPj,pnSaisie,fermer,compteId,libNumcpte" focus="formsm:jourId"/>
                            <a4j:commandButton title="Nouvelle pièce" image="/images/ajouterPiece.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ajouterPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAccesCorrection==2||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" onclick="if (!confirm('Etes-vous sur de vouloir changer de pièce ?')) return false" reRender="pngMaj,pngPj,pnSaisie,fermer,compteId,libNumcpte"/>
                            <a4j:commandButton title="Dupliquer écriture" image="/images/duplicate.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.duppliquerLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecr_id!=0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffSuppImpList&& bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" reRender="pngMaj,pngPj,pnSaisie,fermer,compteId,libNumcpte,alerteM" focus="formsm:idDebit"/>
                            <a4j:commandButton title="Suppression" image="/images/supprimer.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.supprimerLigne}" reRender="pngGlobal,pngMaj,pngPj,panelSuppression,richsupp1,alerteM" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAccesCorrection==2||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffSuppImpList&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}"/>
                            <a4j:commandButton title="Imprimer" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail,solde"/>
                            <a4j:commandButton title="Change N° de pièce" image="/images/changePiece.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.changerNumPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAccesCorrection==2||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffSuppImpList&& bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" reRender="panelPiece"/>
                            <a4j:commandButton title="Consultation brouillard" image="/images/brouillard.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.chargerBrouillard}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffBrouillard}" reRender="panelBrouillard"/>
                            <a4j:commandButton title="Extrait du compte" image="/images/extrait.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.extraitCompte}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffSuppImpList)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,formModalDetailTiers,panelDetailTiers"/>
                            <a4j:commandButton title="Consultation fiche tiers" image="/images/tiers.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==7}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>
                            <a4j:commandButton title="Validation des écritures" image="/images/valDoc.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.validationLignes}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.clo&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" reRender="panelValidation"/>
                            <a4j:commandButton title="Ecritures en attente" image="/images/att.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.attenteLignes}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature>=7&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature<=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrEtat!=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.clo&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" onclick="if (!confirm('Etes-vous sur de vouloir changer l`état de la ligne sélectionnée ?')) return false" reRender="tableEcritures,solde,fermer,alerteM"/>
                            <h:commandButton title="Interchange écritures"  image="/images/parametre.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.interchangeEcritures}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffOutilsCorr&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" onclick="if (!confirm('Etes-vous sur de vouloir effectuer un inter-change des écritures?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                            <a4j:commandButton title="Informations sur l'écriture" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testAffSuppImpList}" reRender="panelInformation"/>
                            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="solde" styleClass="fichefournisseur1" columns="3" width="100%" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_hauteur}" columnClasses="cols,cols,cols" >
                    <h:panelGrid width="100%" style="text-align:right;font-weight:bold;margin-top:25px;" cellpadding="2px" >
                        <f:facet name="header"><h:outputText value=""/></f:facet>
                        <h:column><h:outputText value= "" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                            <h:outputText value="Antérieur:"   />
                        </h:column>
                        <h:column><h:outputText value= "Mouvements:" /></h:column>
                        <h:column><h:outputText value= "Solde:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                            <h:outputText value="Solde final:" />
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" style="border:1px solid black;" headerClass="headerTab">
                        <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.debitAnterieur}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column >
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.totalMvtsdebit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"   id="totalMvtDebID" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.soldeDeb}" id="soldedebId" readonly="true"  style="color:red;width:90%;text-align:right;background:transparent;border:0px;"  >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.soldefinalDeb}" style="width:90%;text-align:right;background:transparent;border:0px;" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" style="border:1px solid black;" headerClass="headerTab">
                        <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.creditAnterieur}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.totalMvtscredit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;" id="totalMvtCredID" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.soldeCred}" readonly="true" style="color:red;width:90%;text-align:right;background:transparent;border:0px;" id="soldecredID">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.soldefinalCred}" style="width:90%;text-align:right;background:transparent;border:0px;" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="alerteM" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.testfermerleJournal}">
                <h:graphicImage value="/images/actif.gif" />
                <h:outputText style="color:green;margin-left:50px" value="Journal non équilibré, veuillez équilibrer le journal !"/>
            </h:panelGroup>

            <h:panelGrid columns="17" id="pnSaisie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAccesCorrection==2||(bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" styleClass="refbarre"  width="100%" >
                <h:panelGroup id="jour">
                    <h:outputText value="Jour:" styleClass="textAligneOutTable"/><br>
                    <h:selectOneMenu  tabindex="1" id="jourId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrJour}"  style="width:50px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesjoursItems}"  />
                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.calculDateEcheance}" reRender="pnSaisie,idEcheance" immediate="true" focus="sm:formsm:compteId"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup id="compte">
                    <h:outputText value="N° de compte:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="2" id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrCompte}" onfocus="compteId.focus()" onkeypress="return scanToucheLettre(event)" size="6" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" maxlength="20">
                        <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez soit le début d'un numéro de compte ou d'un libellé de compte soit # pour accéder aux modèles d`écrtitures." style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');$('#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nom_champ}').focus();"  reRender="modAttente,pnSaisie,idSubView,panelListePlanComptable,formModalListePlanComptable,compteId,libNumcpte"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="comtePartie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testContrePartie}">
                    <h:outputText  value="Contrepartie:" styleClass="textAligneOutTable" /><br>
                    <h:inputText tabindex="3" id="cpId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrContrePartie}" onkeypress="return scanToucheLettre(event)" size="6" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" maxlength="20">
                        <rich:toolTip id="tooladdCP" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheContrePartie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListePlanComptable,formModalListePlanComptable,cpId,libNumcpte"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="piece">
                    <h:outputText value="N° de pièce:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="4" id="pieceId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPiece}" size="9" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.verrouNum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.verrouNum}"/>
                </h:panelGroup>
                <h:panelGroup id="ref1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}">
                    <h:outputText value="Référence1:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="5" id="ref1Id" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrReference1}" size="9" maxlength="30" onkeypress="return scanToucheLettre(event)"/>
                </h:panelGroup>
                <h:panelGroup id="ref2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}">
                    <h:outputText value="Référence2:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrReference2}" size="9" maxlength="30" onkeypress="return scanToucheLettre(event)"/>
                </h:panelGroup>
                <h:panelGroup id="idBudgetTresoProjet" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.tresorerie=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.afficheBudgetTresoProjet}">
                    <h:outputText value="Poste/Budget:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPosteTreso}" size="7" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdBudgetProjet" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un poste de budget de trésorerie ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheBudgetTresorerie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeBudgetTresorerie,formModalListeBudgetTresorerie,idBudgetTresoProjet"/>
                    </h:inputText>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrBudgetTreso}" size="7" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="idBudgetTresoStandard" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.tresorerie=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.afficheBudgetTresoStandard}">
                    <h:outputText value="Tréso.:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrTreso}" size="10"  onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdBudgetStandard" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un poste de budget de trésorerie ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheBudgetTresorerie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeBudgetTresorerie,formModalListeBudgetTresorerie,idBudgetTresoStandard"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="idDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_affiche_dossier}">
                    <h:outputText value="Dossier:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDossier}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdDossier" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un dossier ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDossier,idDossier"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="dateEcheance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==7}">
                    <h:outputText id="idEcheance" value="Echéance:" style="font-weight:bold"/><br>
                    <rich:calendar tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDateEcheance}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8"/>
                </h:panelGroup>
                <h:panelGroup id="origine" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==11)}">
                    <h:outputText value="Origine:" styleClass="textAligneOutTable"/><br>
                    <h:column>
                        <h:selectOneMenu tabindex="9" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrOrigineBanque}">
                            <f:selectItem itemLabel="Même bnq sur place" itemValue="0"/>
                            <f:selectItem itemLabel="Même bnq hors place" itemValue="1"/>
                            <f:selectItem itemLabel="Autre bnq sur place" itemValue="2"/>
                            <f:selectItem itemLabel="Autre bnq hors place" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGroup>
                <h:panelGroup id="dateValeur" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==11)}">
                    <h:outputText value="Date val.:" style="font-weight:bold"/><br>
                    <rich:calendar tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDateValeurTheo}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8"/>
                </h:panelGroup>
                <h:panelGroup id="debit">
                    <h:outputText value="Débit:" style="font-weight:bold"/><br>
                    <h:inputText id="idDebit" tabindex="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valindexD}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDebitSaisie}" style="text-align:right" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="credit">
                    <h:outputText value="Crédit:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valindexC}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrCreditSaisie}"  style="text-align:right" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.nbrEcrLettrage}" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="libelle">
                    <h:outputText value="Libellé:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLibelle}" size="30" id="ecrLibelleid"maxlength="100" onkeypress="return scanToucheLettre(event)"/>
                </h:panelGroup>
                <h:panelGroup id="pngPj" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.planComptable.plcId!=0}">
                    <a4j:commandButton tabindex="14" id="idPj" image="/images/mail_pj.png" style="height:28px;width:28px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirPj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.conditionPj}" reRender="panelPJ,panalAjoutFile"/>
                </h:panelGroup>
                <h:panelGroup id="pngMaj" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.planComptable.plcId!=0}">
                    <a4j:commandButton tabindex="15" id="idValLigne" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.saveEcritureComptable}" focus="sm:formsm:compteId" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="pngGlobal,alerteM,pngGlob,solde,pnSaisie,richpanlisteECR,tableEcritures,idAnal,modalpanelAnalytique,modAttente"/>
                    <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                </h:panelGroup>
            </h:panelGrid>
            <h:outputText id="libNumcpte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLibCompte}"/>
        </h:panelGrid>

        <h:panelGrid width="100%" id="richpanlisteECR" styleClass="fichefournisseur1">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.pageIndex}" reRender="tableEcritures" id="scrollTable" maxPages="20"align="left" for="tableEcritures"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " sortMode="multi" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.datamodelEcritures}" var="table" id="tableEcritures"  width="100%"  style="max-height:100%;" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionEcriture}" reRender="pnSaisie,libNumcpte,alerteM,fermer"/>
                    <rich:column label="Etat" width="3%" sortable="true" sortBy="#{table.ecrEtat}"  >
                        <f:facet name="header"><h:outputText  value="E."/></f:facet>
                        <h:outputText value="#{table.lib_etat}" style="width:10px;color:#{table.couleur};"/>
                    </rich:column>
                    <rich:column label="Jour" width="3%" sortable="true" sortBy="#{table.ecrJour}"  >
                        <f:facet name="header"><h:outputText  value="J."/></f:facet>
                        <h:outputText value="#{table.ecrJour}" style="width:10px;color:#{table.couleur};"/>
                    </rich:column>
                    <rich:column label="Compte" width="8%" sortable="true" sortBy="#{table.ecrCompte}" >
                        <f:facet name="header"><h:outputText  value="N° compte" /></f:facet>
                        <h:outputText value="#{table.ecrCompte}" style="color:#{table.couleur}" title="#{table.ecrCompte}"/>
                    </rich:column>
                    <rich:column label="Ititulé du Compte" width="8%" sortable="true" sortBy="#{table.ecrLibCompte}" >
                        <f:facet name="header"><h:outputText  value="Intitulé" /></f:facet>
                        <h:outputText value="#{table.ecrLibCompte}" style="color:#{table.couleur}" title="#{table.ecrLibCompte}"/>
                    </rich:column>
                    <rich:column label="Contrepartie"  width="8%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testContrePartie}" sortable="true" sortBy="#{table.ecrContrePartie}" >
                        <f:facet name="header"><h:outputText value="Contrepartie"/></f:facet>
                        <h:outputText value="#{table.ecrContrePartie}" style="color:#{table.couleur}" title="#{table.ecrContrePartie}"/>
                    </rich:column>
                    <rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{table.ecrPiece}" sortOrder="DESCENDING" >
                        <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
                        <h:outputText value="#{table.ecrPiece}" style="color:#{table.couleur}" title="#{table.ecrPiece}"/>
                    </rich:column>
                    <rich:column label="Référence N°1"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" >
                        <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
                        <h:outputText value="#{table.ecrReference1}" style="color:#{table.couleur}" title="#{table.ecrReference1}"/>
                    </rich:column>
                    <rich:column label="Référence n°2" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}">
                        <f:facet name="header"><h:outputText  value="Référence2"/></f:facet>
                        <h:outputText value="#{table.ecrReference2}" style="color:#{table.couleur}" title="#{table.ecrReference2}"/>
                    </rich:column>
                    <rich:column label="Date échéance"  width="10%" sortable="true" sortBy="#{table.ecrDateEcheance}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==2}">
                        <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                        <h:outputText value="#{table.ecrDateEcheance}" style="width:10px;color:#{table.couleur};">
                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Lettrage/Pointage/Rapproc."  width="3%" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="LPR." /></f:facet>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Etat de la pièce" image="/images/cadenas_cl.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirLpr}" reRender="modalpanelLPR,formLpr" rendered="#{table.nbrEcrLettrage}"/>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Visualisation pièce scannée" image="/images/mail_pj.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirPjConsultation}" reRender="panelPJ,formPJ" rendered="#{table.ecrPj}"/>
                    </rich:column>
                    <rich:column label="Dossier"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_affiche_dossier}" sortable="true" sortBy="#{table.ecrDossier}" >
                        <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                        <h:outputText value="#{table.ecrDossier}" style="color:#{table.couleur}" title="#{table.ecrDossier}"/>
                    </rich:column>
                    <rich:column id="idAnal" width="3%" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_affiche_analytique}">
                        <f:facet name="header"><h:outputText  value="A."/></f:facet>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirDetailsAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1}" ></a4j:commandButton>
                    </rich:column>
                    <rich:column label="Montant débit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitSaisie}" >
                        <f:facet name="header"><h:outputText  value="Débit"/></f:facet>
                        <h:outputText value="#{table.ecrDebitSaisie}" rendered="#{table.ecrDebitSaisie!=0}" style="color:#{table.couleur}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant crédit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditSaisie}" >
                        <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                        <h:outputText value="#{table.ecrCreditSaisie}" rendered="#{table.ecrCreditSaisie!=0}" style="color:#{table.couleur}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Libellé écriture"  width="20%"sortable="true" sortBy="#{table.ecrLibelle}"  >
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{table.ecrLibelle}" style="width:100px;color:#{table.couleur};" title="#{table.ecrLibelle}"/>
                    </rich:column>
                    <rich:column label="Budget Trésorerie ou imputation de trésoreie" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.tresorerie=='true'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature>=7&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature<=11)}" sortable="true" sortBy="#{table.ecrTreso} #{table.ecrPosteTreso} #{table.ecrBudgetTreso}">
                        <f:facet name="header"><h:outputText  value="Poste/Budget"/></f:facet>
                        <h:outputText value="#{table.ecrPosteTreso} #{table.ecrBudgetTreso}" style="color:#{table.couleur}" rendered="#{table.ecrPosteTreso!=null}"/>
                        <h:outputText value="#{table.ecrTreso}" style="color:#{table.couleur}" rendered="#{table.ecrTreso!=null}"/>
                    </rich:column>
                    <rich:column label="Date valeur" width="10%" sortable="true" sortBy="#{table.ecrDateValeurTheo}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10)}">
                        <f:facet name="header"><h:outputText  value="Date val."/></f:facet>
                        <h:outputText value="#{table.ecrDateValeurTheo}" style="width:10px;color:#{table.couleur};">
                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="modalpanelLPR" width="300" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelLpr}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelLpr}" var="lpr">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LE L.P.R."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerLpr}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelLPR"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Lettrage, pointage, rapprochement"/></f:facet>
                    <h:outputText value="Lettrage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLettrage}" id="outLPRlett"/>
                    <h:outputText value="Pointage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPointage}" id="outLPRpoint"/>
                    <h:outputText value="Rapprochement :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrRapprochement}" id="outLPRrapp"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Etat écriture"/></f:facet>
                    <h:outputText value="Statut :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.lib_etat}"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Information sur l'origine"/></f:facet>
                    <h:outputText value="Nature Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrTypeOrigine}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.libelleOrigine}" id="outImport1"/>
                    <h:outputText value="ID Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrIdOrigine}" id="outImport2"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelSuppression" headerClass="headerPanel" width="400" height="280" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelSupprimer}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelSupprimer}" var="sup">
            <f:facet name="header"><h:outputText value="Suppression élément:"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annulerSuppression}" image="/images/close.gif" styleClass="hidelink" reRender="panelSuppression"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:panel id="richsupp1"  style="width:100%;height:90%;border:0px;">
                    <h:panelGrid border="0" columns="2" width="75%" style="text-align:left;" id="pgrdLPR">
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.modeSupp}"  layout="pageDirection">
                            <f:selectItem itemLabel="Supprimer la ligne sélectionnée" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ligneSel}" itemValue="0"/>
                            <f:selectItem itemLabel="Supprimer la pièce :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPiece}" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.pieceVide}" itemValue="1"/>
                            <f:selectItem itemLabel="Supprimer tout le journal" itemValue="2"/>
                        </h:selectOneRadio>
                    </h:panelGrid>
                </rich:panel>
                <br><br><br><br>
                <center>
                    <h:panelGroup >
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.removeSelectedEC}" image="/images/valider_big.png" styleClass="hidelink" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBrouillard"  width="900" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelBrouillard}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelBrouillard}" var="brl">
            <f:facet name="header"><h:outputText value="BROUILLARD DE LA PIECE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerBrouillard}" image="/images/close.gif" styleClass="hidelink" reRender="panelBrouillard"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid  width="100%"  styleClass="fichefournisseur1" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="N° Brouillard:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broNum}" style="width:100%"  readonly="true"/></h:column>
                    <h:column><h:outputText value="N° Pièce:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broPiece}" style="width:100%"  readonly="true"/></h:column>
                    <h:column><h:outputText value="Date création:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broDateCreat}" style="width:100%" readonly="true"/></h:column>
                    <h:column><h:outputText value="Propriétaire:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.userBrouillard}" style="width:100%" readonly="true"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}"><h:outputText value="Référence1:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broReference1}" style="width:100%" readonly="true"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}"><h:outputText value="Référence2:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broReference2}" style="width:100%" readonly="true"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broLibelle}" style="width:100%" readonly="true"/></h:column>
                    <h:column><h:outputText value="Devise:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broDeviseSaisie}" style="width:100%"  readonly="true"/></h:column>
                    <h:column><h:outputText value="Débit:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broDebitSaisie}" style="width:100%" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Crédit:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.broCreditSaisie}" style="width:100%" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Etat:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.brouillard.lib_etat}" style="width:100%"  readonly="true"/></h:column>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelValidation" width="400" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelValidation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelValidation}" var="val">
            <f:facet name="header"><h:outputText value="Validation des écritures saisies"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annulerValidationLignes}" image="/images/close.gif" styleClass="hidelink" reRender="panelValidation"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formValidation">
                <h:panelGrid width="100%" >
                    <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_choix_validation}">
                        <f:selectItem itemValue="0" itemLabel="Validation par Jour"/>
                        <f:selectItem itemValue="1" itemLabel="Validation par pièces"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="formValidation,panValJour,panValPiece"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br>
                <h:panelGrid id="panValJour" width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_choix_validation==0}">
                    <h:column><h:outputText value="Jour début:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_jourDebut}"  style="width:80px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesjoursItems}"  />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Jour fin:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_jourFin}"  style="width:80px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesjoursItems}"  />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panValPiece" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_choix_validation==1}">
                    <h:column>
                        <a4j:commandButton value="SEL./DESEL."  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionToutesPieces}" reRender="listeTableau"/>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="listeTableau" height="200px" width="100%" enableContextMenu="false" headerClass="headerTab" selectedClass="active-row" var="pcs" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesPiecesSelectionnes}">
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
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.saveValidationLignes}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelValidation,tableEcritures,scrollTable"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPiece" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPiece}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPiece}" var="pie">
            <f:facet name="header"><h:outputText value="Change le Numéro de pièce"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerNumPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelPiece"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPiece">
                <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                    <h:column><h:outputText value="Changement:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_mode_chg}">
                            <f:selectItem itemValue="0" itemLabel="de la pièce"/>
                            <f:selectItem itemValue="1" itemLabel="de la ligne"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_ancien_numero}" style="width:200px;" readonly="true"/></h:column>
                    <h:column><h:outputText value="Nouveau Numéro:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nouveau_numero}" maxlength="20" style="width:200px;"/></h:column>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valideNumPiece}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelPiece,tableEcritures,pngGlob,pnSaisie"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalpanelAnalytique" width="1100" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAnalytique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAnalytique}" var="anal1">
            <f:facet name="header"><h:outputText value="IMPUTATION ANALYTIQUE"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerAnalytique}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelAnalytique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}"/>
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="../commun/analytiqueJournaux.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelRecherche" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.showModalPanelRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.showModalPanelRecherche}" var="rec">
            <f:facet name="header"><h:outputText value="LISTE DES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.libelleRecherche}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.annulerRecherche}" image="/images/close.gif" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRecherche"  height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.dataModelRecherche}" var="rec">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.selectionRecherche}" reRender="idValSelectObjet"/>
                        <rich:column  width="20%" >
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{rec.code}"/>
                        </rich:column>
                        <rich:column  width="80%"  >
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{rec.nom_FR}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectObjet">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.valideRecherche}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelRecherche,idActivite1,idActivite2,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.selectObjet}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelDossier" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelDossier}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelDossier}" var="dos">
            <f:facet name="header"><h:outputText value="LISTE DES DOSSIERS TRANSITS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annuleDossier}" image="/images/close.gif" styleClass="hidelink" reRender="panelDossier,idDossier"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDossier" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.datamodelDossier}" var="dos">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionRecherche}" reRender="idValSelectDossier"/>
                        <rich:column label="Code" sortable="true" sortBy="#{dos.anaCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{dos.anaCode}"/>
                        </rich:column>
                        <rich:column label="Libellé du dossier" sortable="true" sortBy="#{dos.anaNomFr}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{dos.anaNomFr}"/>
                        </rich:column>
                        <rich:column label="Type" sortable="true" sortBy="#{dos.lib_dossier}" width="10%">
                            <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                            <h:outputText value="#{dos.lib_dossier}"/>
                        </rich:column>
                        <rich:column label="Devise" sortable="true" sortBy="#{dos.anaTypeDevise}" width="10%">
                            <f:facet name="header"><h:outputText  value="Devise" /></f:facet>
                            <h:outputText value="#{dos.anaTypeDevise}"/>
                        </rich:column>
                        <rich:column label="Année" sortable="true" sortBy="#{dos.anaAnnee}" width="10%">
                            <f:facet name="header"><h:outputText  value="Année" /></f:facet>
                            <h:outputText value="#{dos.anaAnnee}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectDossier">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valideDossier}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelDossier,idDossier"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" onbeforeshow="LoadControl();" onbeforehide="UnloadControl();" id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPJ}" var="pie">
            <f:facet name="header"><h:outputText value="Pièce jointe"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.modePj==2}">
                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.reInitPj}"/>
                    </h:column>&nbsp;&nbsp;
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.modePj==2}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerPj}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <h:form id="formPJ" enctype="multipart/form-data">
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.modePj==1}" var="pjcreat">
                    <h:panelGrid width="100%">
                        <center>
                            <select size="1" id="source" style="position: relative; width: 220px;"/>
                            <input type="button" value="Scan" onclick="AcquireImage();"/>
                            <div id="dwtcontrolContainer"></div>
                            <h:inputHidden id="idValScan" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valueScanPj}"  immediate="true"/>
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
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.validerPj}" onclick="LireValeur();" image="/images/valider_big.png" styleClass="hidelink"/>
                        </h:panelGroup>
                    </center>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.modePj==2}" var="pjvisu">
                    <h:panelGrid width="100%">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.typeFichier==0}" var="sc1">
                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.urlphotoProd}" width="100%" height="800px"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.typeFichier==1}" var="sc2">
                            <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fichierMine}" width="100%" height="550">
                                <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fichierUrl}"></a>
                            </object>
                        </c:if>
                    </h:panelGrid>
                </c:if>
            </h:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="900" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAjoutPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAjoutPJ}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PIECES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerPj}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">

                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc1" label="Ajoutez un nouveau document">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.chargerDoc1}" reRender="panDoc1"/>
                        <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil" id="panDoc1">
                            <t:inputFileUpload id="idDoc" storage="file" accept=".png, .PNG, .pdf, .PDF" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.uploadedFile}"/>
                            <br>
                            <h:panelGroup>
                                <center>
                                    <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.validerPj}"/>
                                </center>
                            </h:panelGroup>
                            <br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabDoc2" label="Ajoutez un document du secrétariat">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.chargerDoc2}" reRender="panDoc2"/>
                        <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil" id="panDoc2">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableDossier" height="300px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.dataModelPjSecretariat}" var="dpj">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionPj}" reRender="idValSelectPj"/>
                                    <rich:column label="Nature" sortable="true" sortBy="#{dpj.maiNature}" width="15%">
                                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                        <h:outputText value="#{dpj.maiNature}" title="#{dpj.maiNature}"/>
                                    </rich:column>
                                    <rich:column label="Code" sortable="true" sortBy="#{dpj.maiDateCreation}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{dpj.maiDateCreation}" title="#{dpj.maiDateCreation}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Nom du tiers" sortable="true" sortBy="#{dpj.maiTiersRs}" width="25%">
                                        <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                                        <h:outputText value="#{dpj.maiTiersRs}" title="#{dpj.maiTiersRs}"/>
                                    </rich:column>
                                    <rich:column label="Références de la pièce" sortable="true" sortBy="#{dpj.maiNosRef}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Références" /></f:facet>
                                        <h:outputText value="#{dpj.maiNosRef}" title="#{dpj.maiNosRef}"/>
                                    </rich:column>
                                    <rich:column label="Objet de la pièce" sortable="true" sortBy="#{dpj.maiObjet}" width="30%">
                                        <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                                        <h:outputText value="#{dpj.maiObjet}" title="#{dpj.maiObjet}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                            <br>
                            <h:panelGroup id="idValSelectPj">
                                <center>
                                    <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.validerPjSecretariat}"/>
                                </center>
                            </h:panelGroup>
                            <br>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L'ECRITURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Créée et/ou modifiée..."/></f:facet>
                    <h:outputText value="ID écriture:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecr_id}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrUserModif})"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Lettrage, pointage, rapprochement"/></f:facet>
                    <h:outputText value="Lettrage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLettrage}" id="outLPRlett"/>
                    <h:outputText value="Pointage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPointage}" id="outLPRpoint"/>
                    <h:outputText value="Rapprochement :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrRapprochement}" id="outLPRrapp"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Etat écriture"/></f:facet>
                    <h:outputText value="Statut :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.lib_etat}"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Information sur l'origine"/></f:facet>
                    <h:outputText value="Nature Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrTypeOrigine}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.libelleOrigine}" id="outImport1"/>
                    <h:outputText value="ID Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrIdOrigine}" id="outImport2"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelAxe04" width="600" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.showModalPanelAxe04}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.showModalPanelAxe04}" var="pieAX4">
            <f:facet name="header"><h:outputText value="Imputation axe04"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.panelFermerAxe04}" image="/images/close.gif" styleClass="hidelink" reRender="panelAxe04,idBoutonAxe04,idTable04,idEcar04,idPanValAnal"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formAxe04">
                <h:panelGrid width="100%" id="idpanelAxe04">
                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActiviteModeSasie==0}" var="dec">
                        <h:panelGrid  width="20%">
                            <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                            <h:selectOneMenu id="idAa00" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.zoneCol1}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.mesColonnes1Items}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.chargerActiviteCol1Items}" reRender="idActivite2,idActivite3"/>
                            </h:selectOneMenu>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaActivite}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaActiviteLib}"/>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActiviteModeSasie==1}" var="dec">
                        <h:panelGrid width="20%">
                            <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                            <h:inputText id="idActivite1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaActivite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.rechercherActivite}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid  width="20%">
                            <f:facet name="header"><h:outputText value="Libellé activité"/></f:facet>
                            <h:outputText id="idActivite2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaActiviteLib}"/>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.decoupageActivite}" var="dec">
                        <h:panelGrid width="100%" columns="3" columnClasses="clos30g,clos30g,clos30g" style="text-align:center;">
                            <h:panelGrid width="100%" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1!='')}">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}"/></f:facet>
                                <h:selectOneMenu id="idAa01" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.zoneCol1}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                    <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.mesColonnes1Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.chargerActiviteCol1Items}" reRender="idActivite2,idActivite3"/>
                                </h:selectOneMenu>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaActivite}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaActiviteLib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}"/>
                            </h:panelGrid>
                            <h:panelGrid id="idActivite2" width="100%" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2!='')}">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}"/></f:facet>
                                <h:selectOneMenu id="idAa02" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.zoneCol2}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                    <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.mesColonnes2Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.chargerActiviteCol2Items}" reRender="idActivite3"/>
                                </h:selectOneMenu>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaAnal1}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaAnal1Lib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}"/>
                            </h:panelGrid>
                            <h:panelGrid id="idActivite3" width="100%" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3!='')}">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}"/></f:facet>
                                <h:selectOneMenu id="idAa03" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.zoneCol3}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                    <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.mesColonnes3Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.chargerActiviteCol3Items}"/>
                                </h:selectOneMenu>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaAnal3}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaAnal3Lib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </c:if>

                    <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50" id="idMontantAxe04">
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.calculLigne04}" reRender="idpanelAxe04,idMontantAxe04,idMontant04,idEcar04,idPanAnal,idPanValAnal"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid width="100%" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:inputText id="idMontant04" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.analytiqueCtrl04.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.panelValiderAxe04}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelAxe04,idBoutonAxe04,idTable04,idEcar04,idPanValAnal"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelListeCompte" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelListeCompte}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelListeCompte}" var="lpc">
            <f:facet name="header"><h:outputText value="LISTE DES COMPTES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerPlanComptable}" image="/images/close.gif" styleClass="hidelink" reRender="panelListeCompte"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableCompte" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.dataModelListeCompte}" var="cpte">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionnerPlanComptable}" reRender="idValSelectCompte"/>
                        <rich:column  width="20%" sortable="true" sortBy="#{cpte.plcCompte}" >
                            <f:facet name="header"><h:outputText value="N° Compte" /></f:facet>
                            <h:outputText value="#{cpte.plcCompte}"/>
                        </rich:column>
                        <rich:column  width="60%" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" filterBy="#{cpte.plcLibelleCpteFR}">
                            <f:facet name="header"><h:outputText value="Libellé du compte" /></f:facet>
                            <h:outputText value="#{cpte.plcLibelleCpteFR}" />
                        </rich:column>
                        <rich:column  width="20%" sortable="true" sortBy="#{cpte.plcLibelleNatureFR}">
                            <f:facet name="header"><h:outputText value="Nature du compte" /></f:facet>
                            <h:outputText value="#{cpte.plcLibelleNatureFR}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectCompte">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.validerPlanComptable}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelListeCompte,pnSaisie,compte,libNumcpte,pngMaj,pngPj"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelModele" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelModele}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelModele}" var="mod">
            <f:facet name="header"><h:outputText value="MODELE ECRITURES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerModele}" image="/images/close.gif" styleClass="hidelink" reRender="panelModele"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" id="idModeleGlobal">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="idSaisieModele">
                        <h:column><h:outputText value="Jour:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.jourModele}" style="width:50px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesjoursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.verrouNum}"><h:outputText value="N° Pièce:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.verrouNum}"><h:inputText maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.pieceModele}" onkeypress="return scanToucheLettre(event)"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}"><h:outputText value="N° Référence:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}"><h:inputText maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.referenceModele}" onkeypress="return scanToucheLettre(event)"/></h:column>
                        <h:column><h:outputText value="Libéllé:"/></h:column>
                        <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.libelleModele}" style="width:100%" onkeypress="return scanToucheLettre(event)"/></h:column>
                        <h:column><h:outputText value="Montant:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.montantModele}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modèle:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.codeModele}" style="width:100%;">
                                <f:selectItem itemLabel="Sélectionnez Modéle" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.mesModelesItems}"  />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionModele}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,idModeleGlobal,tableModele,idValSelectModele,idSaisieModele"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableModele" height="250px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.dataModelEcrituresModele}" var="mdl">
                            <rich:column label="Jour" width="5%" sortable="true" sortBy="#{mdl.ecrJour}"  >
                                <f:facet name="header"><h:outputText  value="J."/></f:facet>
                                <h:outputText value="#{mdl.ecrJour}" style="width:10px;color:#{mdl.couleur};"/>
                            </rich:column>
                            <rich:column label="Compte" width="10%" sortable="true" sortBy="#{mdl.ecrCompte}" >
                                <f:facet name="header"><h:outputText  value="N° compte" /></f:facet>
                                <h:outputText value="#{mdl.ecrCompte}" style="color:#{mdl.couleur}" title="#{mdl.ecrCompte}"/>
                            </rich:column>
                            <rich:column label="Ititulé du Compte" width="15%" sortable="true" sortBy="#{mdl.ecrLibCompte}" >
                                <f:facet name="header"><h:outputText  value="Intitulé" /></f:facet>
                                <h:outputText value="#{mdl.ecrLibCompte}" style="color:#{mdl.couleur}" title="#{mdl.ecrLibCompte}"/>
                            </rich:column>
                            <rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{mdl.ecrPiece}" sortOrder="DESCENDING" >
                                <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
                                <h:outputText value="#{mdl.ecrPiece}" style="color:#{mdl.couleur}" title="#{mdl.ecrPiece}"/>
                            </rich:column>
                            <rich:column label="Référence N°1"  width="10%" sortable="true" sortBy="#{mdl.ecrReference1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}">
                                <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
                                <h:outputText value="#{mdl.ecrReference1}" style="color:#{mdl.couleur}" title="#{mdl.ecrReference1}"/>
                            </rich:column>
                            <rich:column label="Montant débit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{mdl.ecrDebitSaisie}" >
                                <f:facet name="header"><h:outputText  value="Débit"/></f:facet>
                                <h:outputText value="#{mdl.ecrDebitSaisie}" rendered="#{mdl.ecrDebitSaisie!=0}" style="color:#{mdl.couleur}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant crédit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{mdl.ecrCreditSaisie}" >
                                <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                                <h:outputText value="#{mdl.ecrCreditSaisie}" rendered="#{mdl.ecrCreditSaisie!=0}" style="color:#{mdl.couleur}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Libellé écriture"  width="30%"sortable="true" sortBy="#{mdl.ecrLibelle}"  >
                                <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                                <h:outputText value="#{mdl.ecrLibelle}" style="width:100px;color:#{mdl.couleur};" title="#{mdl.ecrLibelle}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br>
                    <h:panelGroup id="idValSelectModele">
                        <center>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.validerModele}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelModele,tableEcritures,pnSaisie,libNumcpte,alerteM" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecrituresModeles.modId!=0}"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>

