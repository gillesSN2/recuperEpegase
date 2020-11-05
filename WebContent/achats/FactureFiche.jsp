<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="facturefiche">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES FACTURES D'ACHAT" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Facture" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationDocument}">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid id="panelEnetete" width="100%" style="background-color:#DAEECB;height:110px">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_date}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateAch==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesdevisesItem}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculDevise}" reRender="panelPage,tableLigne,tabDoc,panelTotal,panelEnetete" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom fournisseur:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:70%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les fournisseurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column id="idLibDossier">
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.libelleDossierFiche}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfCat=='Import'}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeDossier!='2'}" var="anal1">
                                            <h:inputText style="width:100%" id="idDossier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnal4}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers/affaires (puis tabuler) / ou nouveau Dossier" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelPage,panelListeDossier,formModalListeDossier,tabDoc,idDossier,panelTiers,idObjet,idLibDossier"/>
                                            </h:inputText>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeDossier=='2'}" var="anal2">
                                            <h:inputText style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAffaire}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche toutes les affaires (puis tabuler) / ou nouvelle affaire" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelPage,panelListeDossier,formModalListeDossier,tabDoc,idAffaire,panelTiers,idObjet,idLibDossier"/>
                                            </h:inputText>
                                        </c:if>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeDossier=='2'}">
                                        <h:outputText value="Analytique:"/>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeDossier=='2'}">
                                        <h:inputText id="idfacAnal4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnal4}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.controleNumeroAnalytique}" reRender="idfacAnal4"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelTiers,idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.informationsTiers!=null}">
                                    <center>
                                        <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                    </center>
                                </h:panelGroup>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="Contact:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversTiers!=99}"/>
                                        <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversTiers==99}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversTiers==0}">
                                            <h:column>
                                                <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.mesContactItem}" />
                                                </h:selectOneMenu>&nbsp;
                                                <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}"/>
                                            </h:column>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversTiers==99}">
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                        </c:if>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.mesUsersItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="N° Facture:"/></h:column>
                                    <h:column><h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNumFour}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="30"/></h:column>
                                    <h:column><h:outputText value="Date fac. Four.:" /></h:column>
                                    <h:column>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateLivraison}"   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8">
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,tabReglement,idEcheance"/>
                                        </rich:calendar>
                                    </h:column>
                                    <h:column><h:outputText value="" /></h:column>
                                    <h:column><h:outputText value="" /></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversTiers==99}">
                                    <h:column><h:outputText value="Adressé à:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Mail:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:130px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="H.T.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotHt}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Taxe:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotTva}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="T.T.C.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotTtc}" style="text-align:right;width:100%"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_mod}">
                                <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                    <h:column>
                                        <h:outputText value="Code" style="text-decoration:underline;"/>
                                        <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.griserchamps}">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,idDepot,inpCodDet,panelLigne"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <a4j:commandButton  tabindex="2" style="height:15px;width:15px" image="/images/detail.png" title="Fiche du produit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Référence"/>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.griserchamps}" />
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé"/>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.griserchamps}" style="width:100%" maxlength="500">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfExoTva==0}">
                                        <h:outputText value="Taxe" />
                                        <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligTaxe}" style="width:70px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.mesTaxesAchatsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid  width="100%" id="panelLigne11" columns="2" columnClasses="clos12d,clos88" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.descriptifComplementaire=='1'}">
                                    <h:outputText value="Descriptif Complémentaire"/>
                                    <h:inputTextarea tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligComplement}" style="width:100%"/>
                                </h:panelGrid>
                                <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                    <h:panelGroup>
                                        <h:outputText value="Qte"/>
                                        <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligQte}" style="width:90px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelUnite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_unite}">
                                        <h:outputText value="Unité"/>
                                        <h:selectOneMenu tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.griserchamps}" style="width:80px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.mesUnitesProduits}"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_condit}">
                                        <h:outputText value="Cdt."/>
                                        <h:selectOneMenu tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligCondition}" style="width:100px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.mesConditionnementsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelLigne2,panelLigne3,panelPu,panelPt"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_sansstock}">
                                        <h:outputText value="Stock" />
                                        <h:selectOneMenu id="idDepot" tabindex="12" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_depotProd}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.mesProduitsDepotsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.selectionDepot}" reRender="panelLigne,panelLigne2,panelLigne3"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.affichagePump}">
                                        <h:outputText value="PUMP"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPump}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouPump}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPu">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPu}" style="text-align:right;width:100px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouPrvente}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouRemise}">
                                        <h:outputText value="Remise %"/>
                                        <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligTauxRemise}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouRabais}">
                                        <h:outputText value="Rabais"/>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligRabais}" style="text-align:right;width:70px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPt">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPt}" style="text-align:right;width:100px"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPt}" style="text-align:right;width:100px"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligPt}" style="text-align:right;width:100px"  readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px" >
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite<=199}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLong}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite<=299}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Largeur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLarg}" style="width:70px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite<=399}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Largeur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Hauteur:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligHaut}" style="width:60px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite<=499}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Diamêtre:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligLarg}" style="width:70px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite<=849}">
                                        <h:outputText value="Nombre:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligNb}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_code_unite<=899}">
                                        <h:outputText value="Pression:"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureLigneAchats.fcfligNb}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.datamodelLigne}" var="doclig">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                    <rich:column sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{doclig.fcfligCode}"/>
                                    </rich:column>
                                    <rich:column label="Référence fournisseur" sortable="false" width="150px">
                                        <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                                        <h:outputText  value="#{doclig.fcfligReference}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="22%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{doclig.fcfligLibelle}"/><br>
                                        <h:outputText value="#{doclig.fcfligComplement}" rendered="#{doclig.fcfligComplement!=null}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfExoTva==0}">
                                        <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                        <h:outputText value="#{doclig.fcfligTaxe}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="10%" >
                                        <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                        <h:outputText value="#{doclig.fcfligQte}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                        <h:outputText value="#{doclig.var_lib_uni_condit}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="P.U.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.fcfligPu}" rendered="#{doclig.fcfligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.fcfligPu}" rendered="#{doclig.fcfligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.nbDecPu}"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.fcfligPu}" rendered="#{doclig.fcfligPu!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouRemise}">
                                        <f:facet name="header"><h:outputText  value="Remise%"  /></f:facet>
                                        <h:outputText value="#{doclig.fcfligTauxRemise}" rendered="#{doclig.fcfligTauxRemise!=0}" />
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.verrouRabais}">
                                        <f:facet name="header"><h:outputText  value="Rabais"  /></f:facet>
                                        <h:outputText value="#{doclig.fcfligRabais}" rendered="#{doclig.fcfligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.fcfligRabais}" rendered="#{doclig.fcfligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.fcfligRabais}" rendered="#{doclig.fcfligRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="P.U. net HT"  /></f:facet>
                                        <h:outputText value="#{doclig.fcfligPuRem}" rendered="#{doclig.fcfligPuRem!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.fcfligPt}" rendered="#{doclig.fcfligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.fcfligPt}" rendered="#{doclig.fcfligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText value="#{doclig.fcfligPt}" rendered="#{doclig.fcfligPt!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationImputation}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Campagne:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSourceItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Observations:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Poids:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotRabais}" style="text-align:right;width:100%"  readonly="true"/></h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeSite=='true'}" var="impt2">
                            <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Site:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfSite}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Département:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDepartement}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Service:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfService}" size="100" readonly="true"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.axeRegion=='true'}" var="impt3">
                            <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Région:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfRegion}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Secteur:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfSecteur}" size="100" readonly="true"/></h:column>
                                <h:column><h:outputText value="Point de vente:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfPdv}" size="100" readonly="true"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_anal_activite}" var="impt4">
                            <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.decoupageActivite}">
                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                        <f:selectItem itemLabel="" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recupererBudgetItem}" reRender="idBudget" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.decoupageActivite}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.dataModelDecoupageActivtes}" var="saisieAnal">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.selectionAnalytique}"/>
                                            <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.laColonne1Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.valideColonne1}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.laColonne2Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.valideColonne2}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.decoupageActivite}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                                <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.laColonne3Items}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.valideColonne3}" />
                                                </h:selectOneMenu>
                                            </rich:column>
                                            <rich:column label="%"  width="10%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                                <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Montant"  width="15%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                                <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.controleEcartAnalytique}" reRender="idTableAnal" />
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                                <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.supprimerAnalytique}" reRender="idTableAnal"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <h:panelGrid columns="2" id="panBudget" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Budget:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idBudget" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfBudget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem  itemValue="100" itemLabel="Sélectionnez le budget"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}" />
                                </h:selectOneMenu>&nbsp;&nbsp;
                                <h:commandButton value="Calcul dispo." onclick="if (!confirm('Voulez-vous calculer la disponibilité Budget et Tréso. pour ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.calculDisponibilite}" styleClass="exp_lienmenu"/>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité budget cumulé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfBudgetDispo}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité budget mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfBudgetDispoMois}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité trésorerie cumulé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfBudgetTreso}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Disponibilité trésorerie mensuel:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfBudgetTresoMois}" size="10" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_anal_parc}" var="impt5">
                            <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_anal_chantier}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Chantier:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Sélectionnez chantier" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesChantiersItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_anal_dossier}" var="impt7">
                            <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}"/>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </rich:tab>

                    <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationComplement}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Formule 1 (adresse livraison):" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFormulesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFormulesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Contrat:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="20"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.trfCompta=='1'}"><h:outputText value="N° Proforma fournisseur:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.optionAchats.trfCompta=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfProformaFour}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" maxlength="20"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="panComplement" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesIncotermesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panComplement,idIncoterm,idIncoterm2,idIncoterm2"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIncoterm=='CFR'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIncoterm=='CIF'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIncoterm=='CPT'}">
                                    <h:outputText value="Fret maritime (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotFretLocal}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIncoterm=='CIF'}">
                                    <h:outputText value="Assurance (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotAssuranceLocal}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>&nbsp;&nbsp;&nbsp;
                                <h:column id="idIncoterm3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIncoterm=='CPT'}">
                                    <h:outputText value="Fret terrestre (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDevise}):"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTotFret2Local}" size="5" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.cumulPrix}" reRender="panelTotal"/>
                                    </h:inputText>
                                </h:column>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Date impression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateImp}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.documentImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem itemLabel=" " itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.annexItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" >
                                    <f:selectItem itemLabel=" " itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.annexItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationReglement}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp"/>
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesTypeReglements}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.chargerModeEcheance}" reRender="panelGlobal,detmpdev,preg,idEcheance"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                    <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                    <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                    <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                    <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibilitenbrjr}">
                            <h:column >
                                <h:outputText value="Nb jour:" /></h:column>
                            <h:column>
                                <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:outputText value="Arrondi:" /></h:column>
                            <h:column>
                                <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Date échéance:" /></h:column>
                            <h:column><rich:calendar id="idEcheance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateEcheReg}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibiliteencaissemt}">
                            <h:column ><h:outputText value="Montant du bon:" /></h:column>
                            <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Condition règlement:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}">
                                    <f:selectItem  itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBanquesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.datamodelRecu}"  var="recu"  sortMode="multi">
                                <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab label="Références" id="tabReference" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_special}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationSpecial}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="N° Contrat:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNomContact}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="N° facture fournisseur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNumFour}" size="15" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="N° facture frais:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfFraisValo}" size="15" readonly="true"/></h:column>
                            <h:column><h:outputText value="Coefficient valorisation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfCoefValo}" size="15" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Pièces jointes" id="tabScan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_special}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <h:panelGrid id="panScan" width="100%">
                            <h:panelGrid id="panBoutonPj" width="300px" columns="4">
                                <a4j:commandButton value="Ajouter pièce jointe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.ajouterPieceJointe}" reRender="panalAjoutScan"/>
                                <h:commandButton image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.consulterPieceJointe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fileCtrl!=null&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.typeFichier=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.typeFichier=='7')}"/>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fileCtrl!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.typeFichier!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.typeFichier!='7'}">
                                    <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.nomPiecesJointes}" target="_blank" title="Télécharger fichier"><img src="images/download.png" alt="télécharger"></a>
                                    </h:column>
                                    <h:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette pièce jointe ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.supprimerPieceJointe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fileCtrl!=null}"/>
                                </h:panelGrid>
                                <rich:extendedDataTable id="ligneScan" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.dataModelPieceJointes}" var="fichier" sortMode="multi">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.selectionnerPieceJointe}" reRender="panBoutonPj"/>
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

                    <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_habilitation}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser1Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser2Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser3Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser4Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser5Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser6Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationEtat}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                            <h:column><h:outputText value="ID FACTURE:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de relance:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateRelance}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de validité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateValidite}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateTransfert}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                    <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                    <f:selectItem itemLabel="Correction" itemValue="6"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de transformation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateTransforme}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfMotifAnnule}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.autorisationTracabilite}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                        <h:panelGrid id="panTrace" width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.selectionTracabilite}"/>
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
                                        <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.voirOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNum!=trace.doctrfOrgNum}"/>
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
                                        <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.voirDestination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.factureEnteteAchats.fcfNum!=trace.doctrfDstNum}"/>
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

                    <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_acc_reglement}">
                        <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                        <h:panelGrid id="panEcritures" width="100%">
                            <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.dataModelEcriture}" var="ecr" sortMode="multi">
                                <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                            </rich:extendedDataTable>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du fournisseur sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutScan" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.showModalPanelAjoutScan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.showModalPanelAjoutScan}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PIECES JOINTES VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annulerPieceJointe}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutScan"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.uploadedFile}" accept=".pdf,.PDF,.doc,.DOC,.xls,.XLS,.ppt,.PPT,.odt,.ODT,.ods,.ODS,.jpg,.JPG"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.validerPieceJointe}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuScan" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.showModalPanelScan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.showModalPanelScan}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation de la pièce jointe (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fermerVisuPieceJointe}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuScan"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
