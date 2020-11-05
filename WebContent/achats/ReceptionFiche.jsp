<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="receptionfiche">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES RECEPTIONS D'ACHAT"  style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Réception" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_document}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationDocument}" reRender="panDescription"/>
                        <h:panelGrid id="panDescription" width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid id="panelEnetete" width="100%" style="background-color:#DAEECB;height:110px">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_date}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateAch==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesdevisesItem}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculDevise}" reRender="panelPage,tableLigne,tabDoc,panelTotal,panelEnetete,idCoefDev" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom fournisseur:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:70%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les fournisseurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column id="idLibDossier">
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.libelleDossierFiche}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recCat=='Import'}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier!='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recCat=='Import'}" var="anal1">
                                            <h:inputText style="width:100%" id="idDossier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnal4}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers/affaires (puis tabuler) / ou nouveau Dossier" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelPage,panelListeDossier,formModalListeDossier,tabDoc,idDossier,panelTiers,idObjet,idLibDossier,idListFrais"/>
                                            </h:inputText>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'}" var="anal2">
                                            <h:inputText style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAffaire}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche toutes les affaires (puis tabuler) / ou nouvelle affaire" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelPage,panelListeDossier,formModalListeDossier,tabDoc,idAffaire,panelTiers,idObjet,idLibDossier"/>
                                            </h:inputText>
                                        </c:if>
                                    </h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'}" var="analSaisie">
                                        <h:column>
                                            <h:outputText value="Analytique:"/>
                                        </h:column>
                                        <h:column>
                                            <h:inputText id="idrecAnal4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnal4}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.controleNumeroAnalytique}" reRender="idrecAnal4"/>
                                            </h:inputText>
                                        </h:column>
                                    </c:if>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:30%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne,panelTiers,idZoneCoef,idCoefDev,idCoef" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recupererEltCat}"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Coef.Pr:" style="text-decoration:underline;"/>&nbsp;
                                        <h:selectOneMenu id="idZoneCoef1" style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recValorisation}" readonly="true">
                                            <f:selectItem itemValue="0" itemLabel="Réception"/>
                                            <f:selectItem itemValue="1" itemLabel="Frais Saisie"/>
                                            <f:selectItem itemValue="2" itemLabel="Famille"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCoef,idZoneCoef1,idZoneCoef2"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.informationsTiers!=null}">
                                    <center>
                                        <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                    </center>
                                </h:panelGroup>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="Contact:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversTiers!=99}"/>
                                        <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversTiers==99}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversTiers==0}">
                                            <h:column>
                                                <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesContactItem}" />
                                                </h:selectOneMenu>&nbsp;
                                                <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/>
                                            </h:column>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversTiers==99}">
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                        </c:if>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesUsersItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText id="idObjet" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversTiers==99}">
                                    <h:column><h:outputText value="Adressé à:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Mail:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="H.T.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Taxe:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="T.T.C.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotTtc}" style="text-align:right;width:100%" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichageQtePoids==1}"><h:outputText value="Qte.:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichageQtePoids==1}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotQte}" style="text-align:right;width:100%" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichageQtePoids==2}"><h:outputText value="Poids:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichageQtePoids==2}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotPoidsBrut}" style="text-align:right;width:100%" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_mod}">
                                <h:panelGrid  columns="6" width="100%" id="panelLigne1" columnClasses="clos20g,clos5g,clos5g,clos10g,clos55g,clos5g">
                                    <h:column>
                                        <h:outputText value="Code" style="text-decoration:underline;"/>
                                        <h:inputText tabindex="1" id="inpCodDet" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.griserchamps}">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,idDepot,inpCodDet,panelLigne,panelLigne2,panelLigne3,idDouane"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton tabindex="2" style="height:15px;width:15px" image="/images/detail.png" title="Fiche du produit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Pos. Douane" style="text-decoration:underline;"/><br>
                                        <h:inputText tabindex="3" id="idDouane" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligDouane}" maxlength="20" style="width:100px;">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.rechercheDouane}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouane"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Sommier"/><br>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligSommier}" maxlength="20"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Référence"/><br>
                                        <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.griserchamps}" />
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé"/><br>
                                        <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.griserchamps}" style="width:100%" maxlength="500">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recExoTva==0}">
                                        <h:outputText value="Taxe" /><br>
                                        <h:selectOneMenu tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligTaxe}" style="width:70px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesTaxesAchatsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid columns="11" width="100%" id="panelLigne2">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_sansstock}">
                                        <h:outputText value="Stock" />
                                        <h:selectOneMenu id="idDepot" tabindex="6" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_depotProd}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesProduitsDepotsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionDepot}" reRender="panelLigne,panelLigne2,panelLigne3"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="Qte"/>
                                        <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligQte}" style="width:90px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelUnite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_unite}">
                                        <h:outputText value="Unité"/>
                                        <h:selectOneMenu tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.griserchamps}" style="width:80px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesUnitesProduits}"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_condit}">
                                        <h:outputText value="Cdt."/>
                                        <h:selectOneMenu tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligCondition}" style="width:100px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesConditionnementsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelLigne,panelLigne2,panelPu,panelPt,panelPtLoc"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPump" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichagePump}">
                                        <h:outputText value="PUMP"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPump}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouPump}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPu">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouRemise}">
                                        <h:outputText value="Remise %"/>
                                        <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligTauxRemise}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouRabais}">
                                        <h:outputText value="Rabais"/>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt,panelPtLoc"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPt">
                                        <h:outputText value="P.T.HT (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise})"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPt}" style="text-align:right;width:100px" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPu"/>
                                        </h:inputText>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPt}" style="text-align:right;width:100px" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPu"/>
                                        </h:inputText>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPt}" style="text-align:right;width:100px" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPu"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPtLoc">
                                        <h:outputText value="P.T.HT (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise})"/>
                                        <h:inputText tabindex="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPtDev}" style="text-align:right;width:100px" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                        <h:inputText tabindex="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPtDev}" style="text-align:right;width:100px" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                        <h:inputText tabindex="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligPtDev}" style="text-align:right;width:100px" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <a4j:commandButton  tabindex="19" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px" >
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=199}">
                                        <h:outputText value="Lonueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLong}" style="width:90px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=299}">
                                        <h:outputText value="Longeur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="largeur:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLarg}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="largeur:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Hauteur:"/>
                                        <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligHaut}" style="width:60px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=499}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Diamêtre:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLarg}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=849}">
                                        <h:outputText value="Nombre:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligNb}" style="width:90px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=899}">
                                        <h:outputText value="Pression:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligNb}" style="width:90px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGroup>
                                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableLigne" height="300px" width="154%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.datamodelLigne}" var="doclig">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                            <rich:column label="Code produit" sortable="false" width="150px">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{doclig.recligCode}"/>
                                            </rich:column>
                                            <rich:column label="Référence fournisseur" sortable="false" width="150px">
                                                <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                                                <h:outputText  value="#{doclig.recligReference}"/>
                                            </rich:column>
                                            <rich:column label="Position tarifaire" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Douane"/></f:facet>
                                                <h:outputText value="#{doclig.recligDouane}"/>
                                            </rich:column>
                                            <rich:column label="Sommier douane" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sommier"/></f:facet>
                                                <h:outputText value="#{doclig.recligSommier}"/>
                                            </rich:column>
                                            <rich:column label="Libellé produit" sortable="false" width="300px" >
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:outputText value="#{doclig.recligLibelle}"/><br>
                                                <h:outputText value="#{doclig.recligComplement}" rendered="#{doclig.recligComplement!=null}"/>
                                            </rich:column>
                                            <rich:column label="Code taxe" sortable="false" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recExoTva==0}">
                                                <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                                <h:outputText value="#{doclig.recligTaxe}"/>
                                            </rich:column>
                                            <rich:column label="Code dépôt" sortable="false" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_sansstock}">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText value="#{doclig.recligDepot}"/>
                                            </rich:column>
                                            <rich:column label="Quantité achat" sortable="false" style="text-align:right" width="100px">
                                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                                <h:outputText value="#{doclig.recligQte}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecQte}"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Conditionnement de stockage" sortable="false" width="100px">
                                                <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                                <h:outputText value="#{doclig.var_lib_uni_condit}" rendered="#{doclig.recligStock<=1}"/>
                                                <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.ouvertureLot}" rendered="#{doclig.recligStock==2||doclig.recligStock==3||doclig.recligStock==4}" reRender="panelLot,formModalLot,panelDetailLot" style="width:100%"/>
                                                <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.ouvertureSerie}" rendered="#{doclig.recligStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                            </rich:column>
                                            <rich:column label="Prix unitaire H.T." sortable="false" style="text-align:right;">
                                                <f:facet name="header"><h:outputText value="P.U.HT"  /></f:facet>
                                                <h:outputText value="#{doclig.recligPu}" rendered="#{doclig.recligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==0}">
                                                    <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                                <h:outputText value="#{doclig.recligPu}" rendered="#{doclig.recligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==1}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecPu}"/>
                                                </h:outputText>
                                                <h:outputText value="#{doclig.recligPu}" rendered="#{doclig.recligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==2}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Remise (%)" sortable="false" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouRemise}">
                                                <f:facet name="header"><h:outputText  value="Remise%"  /></f:facet>
                                                <h:outputText value="#{doclig.recligTauxRemise}" rendered="#{doclig.recligTauxRemise!=0}" />
                                            </rich:column>
                                            <rich:column label="Rabais (monnaie)" sortable="false" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.verrouRabais}">
                                                <f:facet name="header"><h:outputText  value="Rabais"  /></f:facet>
                                                <h:outputText value="#{doclig.recligRabais}" rendered="#{doclig.recligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==0}">
                                                    <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                                <h:outputText value="#{doclig.recligRabais}" rendered="#{doclig.recligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==1}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                                <h:outputText value="#{doclig.recligRabais}" rendered="#{doclig.recligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_format_devise==2}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Prix unitaire remisé par unité de stockage" sortable="false" style="text-align:right;">
                                                <f:facet name="header"><h:outputText value="P.U. net HT"  /></f:facet>
                                                <h:outputText value="#{doclig.recligPuRem}" rendered="#{doclig.recligPuRem!=0}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Prix total H.T." sortable="false" style="text-align:right;">
                                                <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                                <h:outputText value="#{doclig.recligPt}" rendered="#{doclig.recligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==0}">
                                                    <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                                <h:outputText value="#{doclig.recligPt}" rendered="#{doclig.recligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==1}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                                <h:outputText value="#{doclig.recligPt}" rendered="#{doclig.recligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.var_format_devise==2}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Prix total local" sortable="false" style="text-align:right;">
                                                <f:facet name="header"><h:outputText value="Tot.Loc."/></f:facet>
                                                <h:outputText value="#{doclig.recligPtDev}" rendered="#{doclig.recligPtDev!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Coefficient de revient" sortable="false" style="text-align:right;" width="80px">
                                                <f:facet name="header"><h:outputText value="Coef.Pr"/></f:facet>
                                                <h:outputText value="#{doclig.recligCoefPr}" rendered="#{doclig.recligCoefPr!=0}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Prix de revient" sortable="false" style="text-align:right;">
                                                <f:facet name="header"><h:outputText value="PR."/></f:facet>
                                                <h:outputText value="#{doclig.recligPr}" rendered="#{doclig.recligPr!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Prix unitaire moyen pondéré" sortable="false" style="text-align:right;">
                                                <f:facet name="header"><h:outputText value="PUMP"/></f:facet>
                                                <h:outputText value="#{doclig.recligPump}" rendered="#{doclig.recligPump!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </div>
                            </h:panelGroup>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_imputation}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationImputation}" reRender="panImputation"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Campagne:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSourceItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Observations:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Poids:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotPoidsBrut}" style="text-align:right;width:100%"  readonly="true"/></h:column>
                        </h:panelGrid>
                         <h:panelGrid id="idImput1" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.moduleImmobilier}">
                            <h:column><h:outputText value="Phase construction:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recPhase}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Terrassement" itemValue="0"/>
                                    <f:selectItem itemLabel="Fondations" itemValue="1"/>
                                    <f:selectItem itemLabel="Gros Oeuvres" itemValue="2"/>
                                    <f:selectItem itemLabel="Finitions" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeSite=='true'}" var="impt2">
                            <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Site:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recSite}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Département:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDepartement}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Service:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recService}" size="100" readonly="true"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeRegion=='true'}" var="impt3">
                            <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Région:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recRegion}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Secteur:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recSecteur}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Point de vente:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recPdv}" size="100" readonly="true"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_activite}" var="impt4">
                            <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.decoupageActivite}">
                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <f:selectItem itemLabel="" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recupererBudgetItem}" reRender="idBudget" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.decoupageActivite}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelDecoupageActivtes}" var="saisieAnal">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionAnalytique}"/>
                                            <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.laColonne1Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valideColonne1}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.laColonne2Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valideColonne2}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.laColonne3Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valideColonne3}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="%"  width="10%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                                <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Montant"  width="15%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                                <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.controleEcartAnalytique}" reRender="idTableAnal" />
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                                <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.supprimerAnalytique}" reRender="idTableAnal"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <h:panelGrid columns="2" id="panBudget" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Budget:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idBudget" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recBudget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem  itemValue="100" itemLabel="Sélectionnez le budget"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}" />
                                </h:selectOneMenu>&nbsp;&nbsp;
                                <h:commandButton value="Calcul dispo." onclick="if (!confirm('Voulez-vous calculer la disponibilité Budget et Tréso. pour ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculDisponibilite}" styleClass="exp_lienmenu"/>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité budget cumulé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recBudgetDispo}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité budget mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recBudgetDispoMois}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité trésorerie cumulé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recBudgetTreso}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité trésorerie mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recBudgetTresoMois}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_parc}" var="impt5">
                            <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_chantier}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Chantier:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Sélectionnez chantier" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesChantiersItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>       
                    </rich:tab>

                    <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_complement}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationComplement}" reRender="panCompl"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid id="panCompl" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Formule 1 (adresse livraison):" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFormulesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFormulesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Contrat:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="20"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="panComplement" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesIncotermesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panComplement,idIncoterm,idIncoterm2,idIncoterm3,idIncoterm4"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm=='CFR'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm=='CIF'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm=='CPT'}">
                                    <h:outputText value="Fret maritime (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotFret}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm=='CIF'}">
                                    <h:outputText value="Assurance (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotAssurance}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm=='CPT'}">
                                    <h:outputText value="Fret terrestre (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotFret2}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIncoterm=='EXW'}">
                                    <h:outputText value="Livraison (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotFret2}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>
                            </h:column>
                            <h:column><h:outputText value="Certificat d'origine (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotCertificat}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Certificat de conformité (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotCertificatConformite}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Frais administratif (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recTotFraisAdm}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.cumulPrix}" reRender="panelTotal"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nom transitaire:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNomTransitaire}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Lieu livraison:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Date livraison:"/></h:column>
                            <h:column>
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateLivraison}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"></rich:calendar>
                            </h:column>
                            <h:column><h:outputText value="Info livraison:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Date impression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateImp}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.documentImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem itemLabel=" " itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.annexItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" >
                                    <f:selectItem itemLabel=" " itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.annexItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"  columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Taux devise (comptable):"/></h:column>
                            <h:inputText size="6" id="idCoefDev" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recCoefDevise}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDevise}"/>
                            <h:column><h:outputText value="Mode valorisation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idZoneCoef2" style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recValorisation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                    <f:selectItem itemValue="0" itemLabel="Valorisation sur coefficient de réception"/>
                                    <f:selectItem itemValue="1" itemLabel="Valorisation sur frais"/>
                                    <f:selectItem itemValue="2" itemLabel="Valorisation sur coefficient famille de produit"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCoef,idZoneCoef1,idZoneCoef2"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Coefficient PR:"/>&nbsp;&nbsp;
                                <h:inputText id="idCoef" size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recCoefValo}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recValorisation>=1}"/>
                            </h:column>
                            <h:column><h:outputText value="Facture fournisseur:"/></h:column>
                            <h:column>
                                <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNumFature}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Date Facture:"/>&nbsp;&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateFacture}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8"></rich:calendar>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Livraison" id="tabLivraison" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_special}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationSpecial}" reRender="panLivraison"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid id="panLivraison" columns="2" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="N° production:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recProduction}" size="15" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Nom Livreur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recLivreurNom}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Commentaires:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recCommentaire}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Pièces jointes" id="tabScan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_special}">
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid id="panScan" width="100%">
                            <h:panelGrid id="panBoutonPj" width="300px" columns="4">
                                <a4j:commandButton value="Ajouter pièce jointe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.ajouterPieceJointe}" reRender="panalAjoutScan"/>
                                <h:commandButton image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.consulterPieceJointe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fileCtrl!=null&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.typeFichier=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.typeFichier=='7')}"/>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fileCtrl!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.typeFichier!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.typeFichier!='7'}">
                                    <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.nomPiecesJointes}" target="_blank" title="Télécharger fichier"><img src="images/download.png" alt="télécharger"></a>
                                    </h:column>
                                    <h:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette pièce jointe ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.supprimerPieceJointe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fileCtrl!=null}"/>
                                </h:panelGrid>
                                <rich:extendedDataTable id="ligneScan" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelPieceJointes}" var="fichier" sortMode="multi">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionnerPieceJointe}" reRender="panBoutonPj"/>
                                    <rich:column  width="10%" sortable="true" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Type"/></f:facet>
                                        <h:graphicImage value="/images/imp_reader.png" rendered="#{fichier.typeFichier=='0'}" title="fichier PDF"/>
                                        <h:graphicImage value="/images/imp_word.png" rendered="#{fichier.typeFichier=='1'}" title="Fichier Word"/>
                                        <h:graphicImage value="/images/imp_excel.png" rendered="#{fichier.typeFichier=='2'}" title="Fichier Excel"/>
                                        <h:graphicImage value="/images/imp_ppt.png" rendered="#{fichier.typeFichier=='3'}" title="Fichier PowerPoint"/>
                                        <h:graphicImage value="/images/imp_openOffice.png" rendered="#{fichier.typeFichier=='4'}" title="Fichier OpenOffice Writer"/>
                                        <h:graphicImage value="/images/imp_openOffice.png" rendered="#{fichier.typeFichier=='5'}" title="Fichier OpenOffice Calc"/>
                                        <h:graphicImage value="/images/imp_openOffice.png" rendered="#{fichier.typeFichier=='6'}" title="Fichier OpenOffice Présentation"/>
                                        <h:graphicImage value="/images/imp_jpg.jpeg" rendered="#{fichier.typeFichier=='7'}" title="Fichier Image (JPG)"/>
                                        <h:graphicImage value="/images/imp_nonReconnu.png" rendered="#{fichier.typeFichier=='8'}" title="Fichier non reconnu"/>
                                    </rich:column>
                                    <rich:column  width="90%" sortable="true" label="Acces pièces jointes">
                                        <f:facet name="header"><h:outputText value="Liste des pièces jointes"/></f:facet>
                                        <h:outputText value="#{fichier.name}" />
                                    </rich:column>
                                </rich:extendedDataTable>
                            </h:panelGrid>
                        </rich:tab>

                    <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_habilitation}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationHabilitation}" reRender="panHabilitation"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid id="panHabilitation" style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser1Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser2Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser3Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser4Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser5Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser6Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_etat}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationEtat}" reRender="panEtat"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                            <h:column><h:outputText value="ID RECEPTION:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de relance:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateRelance}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de validité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateValidite}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                    <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                    <f:selectItem itemLabel="Correction" itemValue="6"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de transformation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateTransforme}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recMotifAnnule}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_tracabilite}" >
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                        <h:panelGrid id="panTrace" width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionTracabilite}"/>
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
                                        <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.voirOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNum!=trace.doctrfOrgNum}"/>
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
                                        <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.voirDestination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNum!=trace.doctrfDstNum}"/>
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

                    <rich:tab label="Frais" id="tabFrais" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_acc_tracabilite}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.autorisationTracabilite}"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:column id="idListFrais" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnal4!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recAnal4!=''}">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.chargerFRA=='0'}" var="fr0">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelFrais}" var="frais" sortMode="multi">
                                        <rich:column sortable="false" width="10%">
                                            <f:facet name="header"><h:outputText value="N° Valo"/></f:facet>
                                            <h:outputText value="#{frais.fsfValo}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="8%">
                                            <f:facet name="header"><h:outputText value="Date"/></f:facet>
                                            <h:outputText value="#{frais.fsfDate}">
                                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="5%" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                            <h:outputText value="#{frais.fsfSerie}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%">
                                            <f:facet name="header"><h:outputText value="N°"/></f:facet>
                                            <h:outputText  value="#{frais.fsfNum}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="37%">
                                            <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                            <h:outputText  value="#{frais.fsfNomTiers}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                            <h:outputText value="#{frais.fsfTotHt}" rendered="#{frais.fsfTotHt!=0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="T.V.A."/></f:facet>
                                            <h:outputText value="#{frais.fsfTotTva}" rendered="#{frais.fsfTotTva!=0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                                            <h:outputText value="#{frais.fsfTotTtc}" rendered="#{frais.fsfTotTtc!=0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.chargerFRA=='1'}" var="fr1">
                                <a4j:region renderRegionOnly="true">
                                    <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelFrais}" var="frais" sortMode="multi">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionLigneFrais}" reRender="idTotalFrais"/>
                                        <rich:column sortable="false" width="9%">
                                            <f:facet name="header"><h:outputText value="N° Valo"/></f:facet>
                                            <h:outputText value="#{frais.fraisEnteteAchats.fsfAnal4}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="9%">
                                            <f:facet name="header"><h:outputText value="N° Frais"/></f:facet>
                                            <h:outputText  value="#{frais.fraisEnteteAchats.fsfNum}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="5%">
                                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                            <h:outputText  value="#{frais.fsfligCode}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="20%">
                                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                            <h:outputText  value="#{frais.fsfligLibelle}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="H.T. Devise"/></f:facet>
                                            <h:inputText value="#{frais.fsfligPu}" style="text-align:right;width:85%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculprixLocalFrais}" reRender="idPtLocal,idTotalFrais"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="8%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Devise"/></f:facet>
                                            <h:selectOneMenu value="#{frais.fsfligDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesdevisesItem}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculprixLocalFrais}" reRender="idPtLocal,idTotalFrais"/>
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column id="idPtLocal" sortable="false" width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="H.T. Local"/></f:facet>
                                            <h:outputText value="#{frais.fsfligPtLocal}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="15%">
                                            <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                            <h:inputText  value="#{frais.fsfligNomFournisseur2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%">
                                            <f:facet name="header"><h:outputText  value="N° facture"/></f:facet>
                                            <h:inputText  value="#{frais.fsfligNunFactureFour2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                    <h:panelGrid id="idTotalFrais" width="40%" columns="2">
                                        <h:column><h:outputText value="Total des frais:"/></h:column>
                                        <h:column>
                                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.totalFrais}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </h:column>
                                    </h:panelGrid>
                                </a4j:region>
                            </c:if>
                        </h:column>
                    </rich:tab>

                    <rich:tab label="Catalogue" id="tabCatalogue" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibleOnglet}">
                        <jsp:include flush="true" page="/achats/CotationCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.accesCatalogue}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCatalogue,ligneCatalogue"/>
                        <h:panelGrid id="panCatalogue" width="100%">
                            <a4j:commandButton value="Ajouter catalogue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.ajouterCatalogue}" reRender="panalAjoutFile"/>
                            <rich:extendedDataTable id="ligneCatalogue" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelCatalogueFichier}" var="fichier" sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionnerCatalogue}"/>
                                <rich:column  width="70%" sortable="true"  sortOrder="DESCENDING" label="Acces catalogue">
                                    <f:facet name="header"><h:outputText value="Catalogues des produits"/></f:facet>
                                    <h:outputText value="#{fichier}" />
                                </rich:column>
                                <rich:column  width="10%" sortable="true" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                                    <h:commandButton image="/images/detail.png"  style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.consulterCatalogue}"/>
                                </rich:column >
                                <rich:column  width="10%" sortable="true" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Supprimer"/></f:facet>
                                    <h:commandButton image="/images/supprimer.png"  style="height:15px;width:15px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce catalogue ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.supprimerCatalogue}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du fournisseur sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>


    <!-- modalPanel de gestion des series -->
    <rich:modalPanel domElementAttachment="parent"  id="panelSerie" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="490" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelSerie}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelSerie}" var="ser">
            <f:facet name="header"><h:outputText value="Gestion des Séries"/></f:facet>
            <a4j:form id="formModalSerie">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableSerie" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelSerie}" var="serie">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionSerie}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="N°" sortable="true" width="10%">
                            <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.dataModelSerie.rowIndex+1}"/>
                        </rich:column>
                        <rich:column label="N° Série" sortable="true" sortBy="#{serie.recserSerie}" width="40%">
                            <f:facet name="header"><h:outputText  value="N° Série" /></f:facet>
                            <h:inputText value="#{serie.recserSerie}" style="width:95%" maxlength="30"/>
                        </rich:column>
                        <rich:column label="Carton" sortable="true" sortBy="#{serie.recserSerie}" width="25%">
                            <f:facet name="header"><h:outputText  value="Carton" /></f:facet>
                            <h:inputText value="#{serie.recserCarton}" style="width:95%" maxlength="30"/>
                        </rich:column>
                        <rich:column label="Palette" sortable="true" sortBy="#{serie.recserPalette}" width="25%">
                            <f:facet name="header"><h:outputText  value="Palette" /></f:facet>
                            <h:inputText value="#{serie.recserPalette}" style="width:95%" maxlength="30"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanSerie" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fermetureSerie}" reRender="panelSerie"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValSerie" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valideSerie}" reRender="panelSerie"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de gestion des lots -->
    <rich:modalPanel domElementAttachment="parent"  id="panelLot" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelLot}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelLot}" var="lot">
            <f:facet name="header"><h:outputText value="Gestion des Lots"/></f:facet>
            <a4j:form id="formModalLot">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" columns="2" columnClasses="clos30,clos70d" id="panelDetailLot" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date achat:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDate}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Produit:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligLibelle}" readonly="true" disabled="true" style="width:100%"/></h:column>
                    <h:column><h:outputText value="Unité de stockage:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligUnite}" readonly="true" disabled="true" style="width:100%"/></h:column>
                    <h:column><h:outputText value="Unité de Conditionnement:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_lib_condit}" readonly="true" disabled="true"style="width:100%"/></h:column>
                    <h:column><h:outputText value="Quantité:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotQte}" readonly="true" disabled="true" style="text-align:right;" size="8"/></h:column>
                    <h:column><h:outputText value="N° du lot:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotNumero}" size="8" maxlength="30" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.accesLot}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligStock==4}"><h:outputText value="Date péremption:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLigneAchats.recligStock==4}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotDateValable}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=199}"><h:outputText value="Longueur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=199}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotLong}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=299}"><h:outputText value="Longueur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=299}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotLong}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=299}"><h:outputText value="Largeur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=299}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotLarg}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}"><h:outputText value="Longueur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotLong}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}"><h:outputText value="Largeur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotLarg}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}"><h:outputText value="Hauteur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=399}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotHaut}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=499}"><h:outputText value="Longueur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=499}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotLong}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=499}"><h:outputText value="Diamêtre:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=499}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotDiam}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=849}"><h:outputText value="Nombre:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=849}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotNb}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=899}"><h:outputText value="Pression:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=899}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotNb}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=250&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=300}"><h:outputText value="Surface:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=350&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=500}"><h:outputText value="Volume:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite>=250&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_code_unite<=500}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotQteUtil}" style="text-align:right;" readonly="true" size="8"/></h:column>
                    <h:column><h:outputText value="Poids brut:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotPoidsBrut}" readonly="true" style="text-align:right;" size="8"/></h:column>
                    <h:column><h:outputText value="Tare:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotPoidsTare}" readonly="true" style="text-align:right;" size="8"/></h:column>
                    <h:column><h:outputText value="Poids net:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionLotAchats.reclotPoidsNet}" readonly="true" style="text-align:right;" size="8"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanLot" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fermetureLot}" reRender="panelLot"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValLot" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valideLot}" reRender="panelLot"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des positions tarifaires -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeDouane" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelDouane}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelDouane}" var="dou">
            <f:facet name="header"><h:outputText value="Sélection de la position tarifaire"/></f:facet>
            <a4j:form id="formModalListeDossier">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDouane" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.datamodelDouane}" var="dou">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionDouane}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Code" sortable="true" sortBy="#{dou.douposCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{dou.douposCode}"/>
                        </rich:column>
                        <rich:column label="Taux Douanes" sortable="true" sortBy="#{dou.douposDd}" width="10%">
                            <f:facet name="header"><h:outputText  value="Taux" /></f:facet>
                            <h:outputText value="#{dou.douposDd}"/>
                        </rich:column>
                        <rich:column label="Libellé du dossier" sortable="true" sortBy="#{dou.douposLibFR}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{dou.douposLibFR}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanDouane" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleDouane}" reRender="panelPage,panelListeDouane,idDouane"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDouane" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.calculeDouane}" reRender="panelPage,panelListeDouane,idDouane"/>
                    </center>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanDouane')}.click()" />
                    <rich:hotKey key="return" handler="#{rich:element('idValDouane')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES CATALOGUES VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annulerCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.uploadedFile}" accept=".pdf,.PDF"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.validerCatalogue}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du catalogue (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fermerVisuCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutScan" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelAjoutScan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelAjoutScan}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PIECES JOINTES VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annulerPieceJointe}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutScan"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.uploadedFile}" accept=".pdf,.PDF,.doc,.DOC,.xls,.XLS,.ppt,.PPT,.odt,.ODT,.ods,.ODS,.jpg,.JPG"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.validerPieceJointe}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuScan" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation de la pièce jointe (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fermerVisuPieceJointe}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuScan"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
