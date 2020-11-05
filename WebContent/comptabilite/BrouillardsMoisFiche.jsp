<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="sbMois">

    <a4j:form id="formsb">

        <center> <h2><h:outputText value="SAISIE DU BROUILLARD ( #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broCode} du #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broPeriode} saisie par #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.nomProprietaire} )" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" id="pnGlob">
            <h:panelGrid columns="2" width="100%" columnClasses="clos70d,clos30">
                <h:panelGrid id="png1"styleClass="fichefournisseur1" style="height:135px;" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText  value="DESCRIPTION DE LA PIECE"/></f:facet>
                    <h:panelGrid columns="6" width="100%" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Jour:" style="font-weight:bold"/></h:column>
                        <h:column>
                            <h:selectOneMenu tabindex="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broJour}" style="width:50px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesjoursItems}"  />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° Brouillard:" style="font-weight:bold"/></h:column>
                        <h:column><h:inputText disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broNum}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}"/></h:column>
                        <h:column><h:outputText value="N° Pièce:" style="font-weight:bold"/></h:column>
                        <h:column><h:inputText disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.verrouPiece}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broPiece}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testRef1Piece}"><h:outputText value="Référence 1:" style="font-weight:bold"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testRef1Piece}"><h:inputText tabindex="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broReference1}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testRef2Piece}"><h:outputText value="Référence 2:" style="font-weight:bold"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testRef2Piece}"><h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broReference2}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Devise:" style="font-weight:bold"/></h:column>
                        <h:column>
                            <h:selectOneMenu tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broDeviseSaisie}" style="width:100px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.lesDevises}"  />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos12d,clos88">
                        <h:column><h:outputText value="Libellé:" style="font-weight:bold"/> </h:column>
                        <h:column><h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.brouillard.broLibelle}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid id="pnlTotaux" columns="2" columnClasses="clos50d,clos50d" styleClass="fichefournisseur1" headerClass="headerTab" style="height:135px;" width="100%">
                    <f:facet name="header"><h:outputText  value="TOTAUX"/></f:facet>
                    <h:column><h:outputText value="Débit:" style="font-weight:bold"/></h:column>
                    <h:column>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.totalMvtsdebit}" style="margin-right:50px;text-align:right">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:column>
                    <h:column><h:outputText value="Crédit:" style="font-weight:bold"/></h:column>
                    <h:column>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.totalMvtscredit}" style="margin-right:50px;text-align:right">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:column>
                    <h:column><h:outputText value="Solde:" style="font-weight:bold"/></h:column>
                    <h:column>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.soldeMvts}" style="margin-right:50px;text-align:right">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:column>
                    <h:panelGroup>
                        <center>
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.annulerSaisie}" image="/images/annuler_big.png" style="width:30px;height:30px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testAnnulerSaisie||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==3}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        </center>
                    </h:panelGroup>
                    <h:panelGrid id="pngpbotonvAlider" columns="3">
                        <a4j:commandButton id="idPj" image="/images/mail_pj.png" style="height:28px;width:28px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ouvrirPj}" reRender="panelPJ,panalAjoutFile"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.conditionPj}"/>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.saveGlobalEtValideMois}" image="/images/valDoc.png" title="Valider la pièce" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testValiderSaisie&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action!=3}"/>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.saveGlobal}" value="FERMER" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testValiderSaisie&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action!=3}" styleClass="fermer"/>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid columns="2" width="100px" id="pngBtn" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action!=3}">
                <a4j:commandButton title="Ajouter ligne" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ajouterLigne}" reRender="pnSaisie,pngBtn"/>
                <a4j:commandButton title="Supprimer ligne" image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.supprimerLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.testAffMAjbrouillardLigne}" reRender="pnSaisie,pngBtn,tableLigne,pnlTotaux,pngpbotonvAlider"/>
            </h:panelGrid>

            <h:panelGrid id="pnSaisie" columns="7" width="100%" style="border:1px solid green;background-color:#FFF8D4;height:50px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action!=3}">
                <h:panelGroup id="compte">
                    <h:outputText value="N° de compte:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="6" id="compteId"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrCompte}"  size="10"  >
                        <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListePlanComptable,formModalListePlanComptable,compteId"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="contrePartie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testContrePartie}">
                    <h:outputText value="N°Contre Partie:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrContrePartie}"  size="10"  >
                        <rich:toolTip id="tooladdNUMPCP" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.rechercheContrePartie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListePlanComptable,formModalListePlanComptable,cpId"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Libellé:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrLibelle}" maxlength="100" size="30"/>
                </h:panelGroup>
                <h:panelGroup id="idDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_affiche_dossier}">
                    <h:outputText value="Dossier:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrDossier}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.nbrEcrLettrage}" onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdDossier" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un dossier ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDossier,idDossier"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="dateEcheance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrNature==7}">
                    <h:outputText value="Date échéance:" style="font-weight:bold"/><br>
                    <rich:calendar tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrDateEcheance}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                </h:panelGroup>
                <h:panelGroup id="origine" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrNature==11}">
                    <h:outputText value="Origine:" styleClass="textAligneOutTable"/><br>
                    <h:column>
                        <h:selectOneMenu tabindex="10" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrOrigineBanque}">
                            <f:selectItem itemLabel="Même bnq sur place" itemValue="0"/>
                            <f:selectItem itemLabel="Même bnq hors place" itemValue="1"/>
                            <f:selectItem itemLabel="Autre bnq sur place" itemValue="2"/>
                            <f:selectItem itemLabel="Autre bnq hors place" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGroup>
                <h:panelGroup id="dateValeur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrNature==11}">
                    <h:outputText value="Date valeur:" style="font-weight:bold"/><br>
                    <rich:calendar tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrDateValeurTheo}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                </h:panelGroup>
                <h:panelGroup id="mtdeb" style="text-align:right;">
                    <h:outputText  value="Debit:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.valindexD}" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrDebitSaisie}" size="14" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.calculTotalDebCredMvts}" reRender="pnlTotaux,pngpbotonvAlider" />
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="mtcred" style="text-align:right;">
                    <h:outputText value="Credit:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.valindexC}" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ecritures.ecrCreditSaisie}" size="14" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.calculTotalDebCredMvts}" reRender="pnlTotaux,pngpbotonvAlider" />
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="pngMaj" >
                    <h:commandButton tabindex="14" id="idValLigne" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.saveLigneEcriture}"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValLigne')}.click()" />
                </h:panelGroup>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableLigne" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="max-height:80%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.dataModelLesEcritures}" var="ecr" >
                    <a4j:support eventsQueue="maQueue" reRender="pnSaisie,pngBtn" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.selectionEcriture}" />
                    <rich:column  width="15%">
                        <f:facet name="header"><h:outputText  value="N°compte"/></f:facet>
                        <h:outputText  value="#{ecr.ecrCompte}"/>
                    </rich:column>
                    <rich:column  width="20%">
                        <f:facet name="header"><h:outputText  value="Intitulé compte"/></f:facet>
                        <h:outputText  value="#{ecr.ecrLibCompte}"/>
                    </rich:column>
                    <rich:column  width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.optionComptabilite.testContrePartie}">
                        <f:facet name="header"><h:outputText  value="ContrePartie"/></f:facet>
                        <h:outputText value="#{ecr.ecrContrePartie}"/>
                    </rich:column>
                    <rich:column  width="20%">
                        <f:facet name="header"><h:outputText  value="Libellé écriture"/></f:facet>
                        <h:outputText  value="#{ecr.ecrLibelle}"/>
                    </rich:column>
                    <rich:column label="Dossier"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_affiche_dossier}" sortable="true">
                        <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                        <h:outputText value="#{ecr.ecrDossier}" title="#{ecr.ecrDossier}"/>
                    </rich:column>
                    <rich:column  width="15%" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Débit "/></f:facet>
                        <h:outputText  value="#{ecr.ecrDebitSaisie}" rendered="#{ecr.ecrDebitSaisie!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="15%" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Crédit "/></f:facet>
                        <h:outputText  value="#{ecr.ecrCreditSaisie}" rendered="#{ecr.ecrCreditSaisie!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="idAnal" width="9%" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_affiche_analytique}">
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.ouvrirDetailsAnalytique}" reRender="modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{ecr.ecrAnaActif==1}" ></a4j:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>   


    <rich:modalPanel domElementAttachment="parent"  id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelPJ}">
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
            <a4j:form id="formPJ">
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.modePj==1}" var="pjcreat">
                    <h:panelGrid width="100%">
                        <center>
                            <select size="1" id="source" style="position: relative; width: 220px;"/>
                            <input type="button" value="Scan" onclick="AcquireImage();"/>
                            <div id="dwtcontrolContainer"></div>
                            <h:inputHidden id="idValScan" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.valueScanPj}"/>
                            <script type="text/javascript">
                                Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', Dynamsoft_OnReady);
                                var DWObject;
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
                                    document.getElementById("formPJ:idValScan").value = imagedata;
                                    alert(imagedata);
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
                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.reInitPj}"/>
                    </h:panelGrid>
                </c:if>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="900" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelAjoutPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.showModalPanelAjoutPJ}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PIECES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.fermerPj}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">

                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc1" label="Ajoutez un nouveau document">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.chargerDoc1}" reRender="panDoc1"/>
                        <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil" id="panDoc1">
                            <t:inputFileUpload id="idDoc" storage="file" accept=".png, .PNG, .pdf, .PDF" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.uploadedFile}"/>
                            <br>
                            <h:panelGroup>
                                <center>
                                    <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.validerPj}"/>
                                </center>
                            </h:panelGroup>
                            <br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabDoc2" label="Ajoutez un document du secrétariat">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.chargerDoc2}" reRender="panDoc2"/>
                        <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil" id="panDoc2">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableDossier" height="300px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.dataModelPjSecretariat}" var="dpj">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.selectionPj}" reRender="idValSelectPj"/>
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
                                    <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.validerPjSecretariat}"/>
                                </center>
                            </h:panelGroup>
                            <br>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
