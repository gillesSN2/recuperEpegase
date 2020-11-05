<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="commandefiche">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES COMMANDES D'ACHAT" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Commande" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationDocument}">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid id="panelEnetete" width="100%" style="background-color:#DAEECB;height:110px">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_date}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateAch==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesdevisesItem}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculDevise}" reRender="panelPage,tableLigne,tabDoc,panelTotal,panelEnetete,idCoefDev" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom fournisseur:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:70%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les fournisseurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,idCoefDev,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers,idCat"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column id="idLibDossier">
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.libelleDossierFiche}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdCat=='Import'}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier!='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdCat=='Import'}" var="anal1">
                                            <h:inputText style="width:100%" id="idDossier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAnal4}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers (puis tabuler) / ou nouveau Dossier" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelPage,panelListeDossier,formModalListeDossier,tabDoc,idDossier,panelTiers,idObjet,idLibDossier"/>
                                            </h:inputText>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'}" var="anal2">
                                            <h:inputText style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAffaire}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche toutes les affaires (puis tabuler) / ou nouvelle affaire" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelPage,panelListeDossier,formModalListeDossier,tabDoc,idAffaire,panelTiers,idObjet,idLibDossier"/>
                                            </h:inputText>
                                        </c:if>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'}">
                                        <h:outputText value="Analytique:"/>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'}">
                                        <h:inputText id="idCmdAnal" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAnal4}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <a4j:support eventsQueue="MaQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.controleNumeroAnalytique}" reRender="idCmdAnal"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne,panelTiers,idCoefDev" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.informationsTiers!=null}">
                                    <center>
                                        <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                    </center>
                                </h:panelGroup>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="Contact:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversTiers!=99}"/>
                                        <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversTiers==99}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversTiers==0}">
                                            <h:column>
                                                <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesContactItem}" />
                                                </h:selectOneMenu>&nbsp;
                                                <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/>
                                            </h:column>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversTiers==99}">
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                        </c:if>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesUsersItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText id="idObjet" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelBudget" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.budgetCOM=='1'}">
                                    <h:column><h:outputText value="Budget:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idBudget" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetProjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <f:selectItem  itemValue="" itemLabel="Sélectionnez le budget"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculeEntite}" reRender="panelBudget,idBudgetEntiten,idBudgetPoste"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.afficheEntite}"><h:outputText value="Entités:"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.afficheEntite}">
                                        <h:selectOneMenu id="idBudgetEntite" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetEntite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <f:selectItem  itemValue="" itemLabel="Sélectionnez l'entité"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesEntites}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculePoste}" reRender="panBudget,idBudgetPoste"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversTiers==99}">
                                    <h:column><h:outputText value="Adressé à:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Mail:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="H.T.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Taxe:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="T.T.C.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTtc}" style="text-align:right;width:100%" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==1}"><h:outputText value="Qte.:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==1}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotQte}" style="text-align:right;width:100%" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==2}"><h:outputText value="Poids:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==2}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotPoidsBrut}" style="text-align:right;width:100%" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_mod}">
                                <h:panelGrid columns="7" width="100%" id="panelLigne1" columnClasses="clos15g,clos5g,clos5g,clos5g,clos45,clos5g,clos20g">
                                    <h:column>
                                        <h:outputText value="Code" style="text-decoration:underline;"/>
                                        <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligCode}">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,idDepot,inpCodDet,panelLigne"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <a4j:commandButton  tabindex="2" style="height:15px;width:15px" image="/images/detail.png" title="Fiche du produit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Pos. Douane" style="text-decoration:underline;"/><br>
                                        <h:inputText tabindex="2" id="idDouane" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligDouane}" maxlength="20" style="width:100px;">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.rechercheDouane}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouane"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Référence"/><br>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligReference}" maxlength="20"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé"/><br>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.griserchamps}" style="width:100%" maxlength="500">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdExoTva!=1}">
                                        <h:outputText value="Taxe" /><br>
                                        <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligTaxe}" style="width:70px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesTaxesAchatsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichePoste}">
                                        <h:outputText value="Poste:"/><br>
                                        <h:selectOneMenu id="idBudgetPoste" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligBudgetPoste}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <f:selectItem  itemValue="" itemLabel="Sélectionnez le poste"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesPostes}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid  width="100%" id="panelLigne11" columns="2" columnClasses="clos12d,clos88" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.descriptifComplementaire=='1'}">
                                    <h:outputText value="Descriptif Complémentaire"/>
                                    <h:inputTextarea tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligComplement}" style="width:100%"/>
                                </h:panelGrid>
                                <h:panelGrid columns="11" width="100%" id="panelLigne2">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_sansstock}">
                                        <h:outputText value="Stock" />
                                        <h:selectOneMenu id="idDepot" tabindex="6" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_depotProd}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesProduitsDepotsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionDepot}" reRender="panelPump" />
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.qteDejaCOM!='0'}">
                                        <h:outputText value="Qte déjà Cmd"/>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligQteCmd}" style="width:90px;text-align:right;" disabled="true" readonly="true">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="Qte"/>
                                        <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligQte}" style="width:90px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelUnite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_unite}">
                                        <h:outputText value="Unité"/>
                                        <h:selectOneMenu tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.griserchamps}" style="width:80px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesUnitesProduits}"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_condit}">
                                        <h:outputText value="Cdt."/>
                                        <h:selectOneMenu tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligCondition}" style="width:100px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesConditionnementsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelLigne2,panelLigne3,panelPu,panelPt"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPump" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichagePump}">
                                        <h:outputText value="PUMP"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPump}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouPump}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPu">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouRemise}">
                                        <h:outputText value="Remise %"/>
                                        <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligTauxRemise}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouRabais}">
                                        <h:outputText value="Rabais"/>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPt">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPt}" style="text-align:right;width:100px"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPt}" style="text-align:right;width:100px"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligPt}" style="text-align:right;width:100px"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px" >
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite<=199}">
                                        <h:outputText value="Longeueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLong}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite<=299}">
                                        <h:outputText value="Longeueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Largeur:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLarg}" style="width:70px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite<=399}">
                                        <h:outputText value="Longeueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Largeur"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Hauteur"/>
                                        <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligHaut}" style="width:60px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite<=499}">
                                        <h:outputText value="Longeueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Diamêtre:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligLarg}" style="width:70px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite<=849}">
                                        <h:outputText value="Nombre:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligNb}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_code_unite<=899}">
                                        <h:outputText value="Pression:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeLigneAchats.cmdligNb}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelLigne}" var="doclig">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                    <rich:column title="Tri des colonnes" width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_mod}">
                                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                    </rich:column>
                                    <rich:column title="Code produit" sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{doclig.cmdligCode}"/>
                                    </rich:column>
                                    <rich:column title="Réf. Fournisseur" sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Réf."/></f:facet>
                                        <h:outputText  value="#{doclig.cmdligReference}"/>
                                    </rich:column>
                                    <rich:column title="Libellé" sortable="false" width="20%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{doclig.cmdligLibelle}"/><br>
                                        <h:outputText value="#{doclig.cmdligComplement}" rendered="#{doclig.cmdligComplement!=null}"/>
                                    </rich:column>
                                    <rich:column title="Code taxe" sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdExoTva!=1}">
                                        <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                        <h:outputText value="#{doclig.cmdligTaxe}"/>
                                    </rich:column>
                                    <rich:column title="Dépot" sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_sansstock}">
                                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                        <h:outputText value="#{doclig.cmdligDepot}"/>
                                    </rich:column>
                                    <rich:column title="Quantité déja commandée" sortable="false" style="text-align:right" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.qteDejaCOM!='0'}">
                                        <f:facet name="header"><h:outputText  value="Déjà Cmd"/></f:facet>
                                        <h:outputText value="#{doclig.cmdligQteCmd}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column title="Quantité commandée" sortable="false" style="text-align:right" width="10%" >
                                        <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                        <h:outputText value="#{doclig.cmdligQte}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column title="Unité" sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                        <h:outputText value="#{doclig.var_lib_uni_condit}"/>
                                    </rich:column>
                                    <rich:column title="Prix unitaire" sortable="false" style="text-align:right;" width="7%">
                                        <f:facet name="header"><h:outputText value="P.U.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.cmdligPu}" rendered="#{doclig.cmdligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.cmdligPu}" rendered="#{doclig.cmdligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.cmdligPu}" rendered="#{doclig.cmdligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column title="Remise" sortable="false" style="text-align:right;" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouRemise}">
                                        <f:facet name="header"><h:outputText  value="Remise%"  /></f:facet>
                                        <h:outputText value="#{doclig.cmdligTauxRemise}" rendered="#{doclig.cmdligTauxRemise!=0}" />
                                    </rich:column>
                                    <rich:column title="Rabais" sortable="false" style="text-align:right;" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verrouRabais}">
                                        <f:facet name="header"><h:outputText  value="Rabais"  /></f:facet>
                                        <h:outputText value="#{doclig.cmdligRabais}" rendered="#{doclig.cmdligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.cmdligRabais}" rendered="#{doclig.cmdligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.cmdligRabais}" rendered="#{doclig.cmdligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column title="Prix net" sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="P.U. net HT"  /></f:facet>
                                        <h:outputText value="#{doclig.cmdligPuRem}" rendered="#{doclig.cmdligPuRem!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column title="Prix total" sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.cmdligPt}" rendered="#{doclig.cmdligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.cmdligPt}" rendered="#{doclig.cmdligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.cmdligPt}" rendered="#{doclig.cmdligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationImputation}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Campagne:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSourceItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Observations:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Poids:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotPoidsBrut}" style="text-align:right;width:100%"  readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idImput1" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.moduleImmobilier}">
                            <h:column><h:outputText value="Phase construction:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdPhase}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Terrassement" itemValue="0"/>
                                    <f:selectItem itemLabel="Fondations" itemValue="1"/>
                                    <f:selectItem itemLabel="Gros Oeuvres" itemValue="2"/>
                                    <f:selectItem itemLabel="Finitions" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeSite=='true'}" var="impt2">
                            <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Site:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdSite}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Département:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDepartement}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Service:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdService}" size="100" readonly="true"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeRegion=='true'}" var="impt3">
                            <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Région:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdRegion}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Secteur:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdSecteur}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Point de vente:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdPdv}" size="100" readonly="true"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_activite}" var="impt4">
                            <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.decoupageActivite}">
                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem itemLabel="" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recupererBudgetItem}" reRender="idBudget" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.decoupageActivite}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.dataModelDecoupageActivtes}" var="saisieAnal">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionAnalytique}"/>
                                            <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.laColonne1Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valideColonne1}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.laColonne2Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valideColonne2}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.laColonne3Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valideColonne3}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="%"  width="10%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                                <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Montant"  width="15%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                                <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.controleEcartAnalytique}" reRender="idTableAnal" />
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                                <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.supprimerAnalytique}" reRender="idTableAnal"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.budgetCOM=='0'}" var="impt8">
                            <h:panelGrid columns="2" id="panBudget" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Budget:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idBudget2" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetProjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem  itemValue="" itemLabel="Sélectionnez le budget"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculeEntite}" reRender="panBudget,idBudgetEntite1,idBudgetPoste1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.afficheEntite}"><h:outputText value="Entités:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.afficheEntite}">
                                    <h:selectOneMenu id="idBudgetEntite1" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetEntite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem  itemValue="" itemLabel="Sélectionnez l'entité"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesEntites}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculePoste}" reRender="panBudget,idBudgetPoste1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichePoste}"><h:outputText value="Poste:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichePoste}">
                                    <h:selectOneMenu id="idBudgetPoste1" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetPoste}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem  itemValue="" itemLabel="Sélectionnez le poste"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesPostes}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:commandButton value="Calcul dispo." onclick="if (!confirm('Voulez-vous calculer la disponibilité Budget et Tréso. pour ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculDisponibilite}" styleClass="exp_lienmenu"/>
                                </h:column>
                                <h:column><h:outputText value="Disponibilité budget cumulé:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetDispo}" size="10" readonly="true" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Disponibilité budget mensuel:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetDispoMois}" size="10" readonly="true" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Disponibilité trésorerie cumulé:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetTreso}" size="10" readonly="true" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Disponibilité trésorerie mensuel:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBudgetTresoMois}" size="10" readonly="true" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_parc}" var="impt5">
                            <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Sélectionnez parc" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_chantier}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Chantier:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Sélectionnez chantier" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesChantiersItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </rich:tab>

                    <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationComplement}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Formule 1 (adresse livraison):" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFormulesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFormulesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Contrat:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="20"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.trfCompta=='1'}"><h:outputText value="N° proforma fournisseur:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.trfCompta=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNumProforma}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="20"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid style="background-color:white;" width="100%" id="idComplement">
                            <h:panelGrid id="panComplement" columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Méthode importation:"/></h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Sans" itemValue="100"/>
                                    <f:selectItem itemLabel="Maritime" itemValue="0"/>
                                    <f:selectItem itemLabel="Aérien" itemValue="1"/>
                                    <f:selectItem itemLabel="Express" itemValue="2"/>
                                    <f:selectItem itemLabel="Route" itemValue="3"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panComplement,idComplement"/>
                                </h:selectOneMenu>
                                <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem  itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesIncotermesItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panComplement,idIncoterm,idIncoterm2,idIncoterm2"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                    <h:column id="idIncoterm" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm=='CFR'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm=='CIF'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm=='CPT'}">
                                        <h:outputText value="Fret maritime (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}):"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotFret}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                        </h:inputText>
                                    </h:column>&nbsp;&nbsp;&nbsp;
                                    <h:column id="idIncoterm2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm=='CIF'}">
                                        <h:outputText value="Assurance (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}):"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotAssurance}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                        </h:inputText>
                                    </h:column>&nbsp;&nbsp;&nbsp;
                                    <h:column id="idIncoterm3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm=='CPT'}">
                                        <h:outputText value="Fret terrestre (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}):"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotFret2}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                        </h:inputText>
                                    </h:column>
                                </h:column>
                                <h:column><h:outputText value="Certificat d'origine:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotCertificat}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotCertificat}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotCertificat}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Certificat de conformité:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotCertificatConformite}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotCertificatConformite}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotCertificatConformite}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais administratifs:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotFraisAdm}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotFraisAdm}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecPu}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotFraisAdm}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Lieu livraison:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Date Livraison Théorique:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateLivraison}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                <h:column><h:outputText value="Info livraison:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Date Départ Usine:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateDepartUsine}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Arrivée Transitaire:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveeTransit}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><h:outputText value="Date Embarquement Théorique:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEmbarquementTheo}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><h:outputText value="Date Embarquement Réel:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEmbarquementReel}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><h:outputText value="Date Arrivée Port Théorique:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveePortTheo}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><h:outputText value="Date Arrivée Port Réel:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode=='0'}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveePortReel}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Livraison Réelle:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateLivreDepot}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Date impression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateImp}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.documentImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel=" " itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.annexItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" >
                                    <f:selectItem itemLabel=" " itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.annexItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Taux devise (comptable):"/></h:column>
                            <h:inputText size="6" id="idCoefDev" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdCoefDevise}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}"/>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationReglement}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid width="100%">
                            <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                                <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesTypeReglements}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,detmpdev,preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.chargerModeEcheance}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                        <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                        <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                        <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                        <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.CalculDateEcheance}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibilitenbrjr}">
                                <h:column >
                                    <h:outputText value="Nb jour:" /></h:column>
                                <h:column>
                                    <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.CalculDateEcheance}"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Arrondi:" /></h:column>
                                <h:column>
                                    <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.CalculDateEcheance}"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Date échéance théo.:" /></h:column>
                                <h:column><h:inputText id="idEcheance" readonly="true" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEcheReg}" /></h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteencaissemt}">
                                <h:column ><h:outputText value="Montant du bon:" /></h:column>
                                <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Condition règlement:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem  itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBanquesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="false">
                            <h:column><h:outputText value="Date Paiement réel:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDatePaiement}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Moyen Paiement réel:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMoyenPaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Sélectionnez moyen de paiement" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.lesMoyensPaiements}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Observation Paiement réel:"/></h:column>
                            <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdObsPaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelRecu}"  var="recu"  sortMode="multi">
                                <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab label="Préparation" id="tabPreparation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_special}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationSpecial}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Priorité:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdPriorite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Basse" itemValue="0"/>
                                    <f:selectItem itemLabel="Normale" itemValue="1"/>
                                    <f:selectItem itemLabel="Urgente" itemValue="2"/>
                                    <f:selectItem itemLabel="Prioritaire" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Commande:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIntOut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Interne" itemValue="0"/>
                                    <f:selectItem itemLabel="Externe" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Commentaire:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdCommentaire}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="N° production:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdProduction}" size="15" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Préparateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdPreparateur}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_habilitation}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser1Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser2Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser3Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser4Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser5Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser6Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationEtat}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                            <h:column><h:outputText value="ID COMMANDE:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de relance:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateRelance}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de validité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateValidite}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                    <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                    <f:selectItem itemLabel="Correction" itemValue="6"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==3)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de transformation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateTransforme}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMotifAnnule}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de facturation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateFacture}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.autorisationTracabilite}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                        <h:panelGrid id="panTrace" width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionTracabilite}"/>
                                    <rich:column sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Date Trf."/></f:facet>
                                        <h:outputText value="#{trace.doctrfDateCreat}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="18%">
                                        <f:facet name="header"><h:outputText  value="Agent"/></f:facet>
                                        <h:outputText value="#{trace.doctrfUserNom}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Type origine"/></f:facet>
                                        <h:outputText  value="#{trace.var_lib_org}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                        <h:outputText value="#{trace.doctrfOrgSerie}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="N° Orgine"/></f:facet>
                                        <h:outputText  value="#{trace.doctrfOrgNum}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                                        <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.voirOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNum!=trace.doctrfOrgNum}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{trace.doctrfOrgDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Type destination"/></f:facet>
                                        <h:outputText  value="#{trace.var_lib_dst}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                        <h:outputText value="#{trace.doctrfDstSerie}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="N° destination"/></f:facet>
                                        <h:outputText  value="#{trace.doctrfDstNum}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:center">
                                        <f:facet name="header"><h:outputText  value="Voir"/></f:facet>
                                        <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.voirDestination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNum!=trace.doctrfDstNum}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{trace.doctrfDstDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Suivi Commande Import" id="tabSuivi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat>=4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdCat=='Import'}">
                        <jsp:include flush="true" page="/achats/CommandeCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Méthode importation:"/></h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode}" disabled="true" readonly="true">
                                <f:selectItem itemLabel="Sans" itemValue="100"/>
                                <f:selectItem itemLabel="Maritime" itemValue="0"/>
                                <f:selectItem itemLabel="Aérien" itemValue="1"/>
                                <f:selectItem itemLabel="Express" itemValue="2"/>
                                <f:selectItem itemLabel="Route" itemValue="3"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm}" disabled="true" readonly="true">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesIncotermesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Lieu livraison:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdLieuLivraison}" style="width:100%" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date Livraison Théorique:"/></h:column>
                            <h:column>
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateLivraison}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"></rich:calendar>
                            </h:column>
                            <h:column><h:outputText value="Info livraison:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfoLivraison}" style="width:100%" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos50d,clos50g">
                            <h:column><h:outputText value="Date Paiement:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDatePaiement}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Moyen Paiement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMoyenPaiement}" disabled="true" readonly="true">
                                    <f:selectItem itemLabel="Sélectionnez moyen de paiement" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.lesMoyensPaiements}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Observation Paiement:"/></h:column>
                            <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdObsPaiement}" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos50d,clos50g" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Date Départ Usine:" style="color:blue"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateDepartUsine}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date Arrivée Transitaire:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveeTransit}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date Embarquement Théorique:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEmbarquementTheo}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date Embarquement Réel:" style="color:blue"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEmbarquementReel}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos50d,clos50g">
                            <h:column><h:outputText value="Date Arrivée Port Théorique:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveePortTheo}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date Arrivée Port Réel:" style="color:blue"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveePortReel}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date Livraison Réelle:" style="color:blue"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateLivreDepot}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Catalogue" id="tabCatalogue" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibleOnglet}">
                        <jsp:include flush="true" page="/achats/CotationCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.accesCatalogue}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCatalogue,ligneCatalogue"/>
                        <h:panelGrid id="panCatalogue" width="100%">
                            <a4j:commandButton value="Ajouter catalogue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.ajouterCatalogue}" reRender="panalAjoutFile"/>
                            <rich:extendedDataTable id="ligneCatalogue" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.dataModelCatalogueFichier}" var="fichier" sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionnerCatalogue}"/>
                                <rich:column  width="70%" sortable="true"  sortOrder="DESCENDING" label="Acces catalogue">
                                    <f:facet name="header"><h:outputText value="Catalogues des produits"/></f:facet>
                                    <h:outputText value="#{fichier}" />
                                </rich:column>
                                <rich:column  width="10%" sortable="true" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                                    <h:commandButton image="/images/detail.png"  style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.consulterCatalogue}"/>
                                </rich:column >
                                <rich:column  width="10%" sortable="true" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Supprimer"/></f:facet>
                                    <h:commandButton image="/images/supprimer.png"  style="height:15px;width:15px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce catalogue ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.supprimerCatalogue}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du fournisseur sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES CATALOGUES VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annulerCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.uploadedFile}" accept=".pdf,.PDF"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.validerCatalogue}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du catalogue (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerVisuCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
