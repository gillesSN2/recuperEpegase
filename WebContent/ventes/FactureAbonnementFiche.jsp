<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="factureabnfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES FACTURES D'ABONNEMENT" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Facture" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationDocument}">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"  style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"  style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesdevisesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.accesAffaires}" var="aff">
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.accesAffaires}" var="aff1">
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="N° Affaire:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesAffairesItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.informationsTiers!=null}">
                                <center>
                                    <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                </center>
                            </h:panelGroup>
                            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTiers==0}"/>
                                    <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTiers==99}"/>
                                </h:column>
                                <h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.contDest=='false'}">
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.contDest=='true'}">
                                        <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNomContact}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeDestinataire,formModalListeDestinataire,panelContact,idDestinataire" />
                                        </h:inputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTiers==99}">
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column id="idResponsable">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesUsersItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.responsable=='0'}">
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.responsable!='0'}">
                                    <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_nom_commercial}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesCommercialItem}" />
                                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculeResponsableLie}" reRender="panelContact,idResponsable"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </c:if>
                            </h:panelGrid>
                            <h:panelGrid id="idTiersDivers" columns="4" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTiers==99}">
                                <h:column><h:outputText value="Adressé à:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Téléphone:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Mail:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="H.T.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taxe:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTotTva}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="T.T.C.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTotTtc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.affichagePump}"><h:outputText value="Marge:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.affichagePump}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_total_marge}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_type!=0}" columns="2">
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_calcul}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recupererEltCat}" reRender="panelTotal"/>
                                </h:selectBooleanCheckbox>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_libelle}:"/>
                            </h:panelGrid>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_type!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteBtonlig&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligGroupe==null||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligGroupe=='')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_mod}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idDepot,inpCodDet,panelLigne,panelLigne4"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.griserchamps}" style="width:100%" maxlength="500">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                    </h:inputText>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" id="panelLigne11" columns="2" columnClasses="clos12d,clos88" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.descriptifComplementaire=='1'}">
                                <h:outputText value="Descriptif Complémentaire"/>
                                <h:inputTextarea tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligComplement}" style="width:100%"/>
                            </h:panelGrid>
                            <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligQte}" style="width:90px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPrix}" reRender="panelLigne,panelPt,panelPu,panelLigne4,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite">
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionConditionnement}" reRender="panelLigne2,panelLigne3,panelPu,panelPt"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_sansstock}">
                                    <h:outputText value="Stock" />
                                    <h:selectOneMenu id="idDepot" tabindex="12" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_depotProd}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesProduitsDepotsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionDepot}" reRender="panelLigne,panelPump,panelLigne4" />
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligPump}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrouRabais}">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.libelleRabRis}"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligRabais}" style="width:70px;text-align:right;">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.plafondAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.validationLigne<=1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.griserValider}"/>
                                    <rich:hotKey key="return"  handler="#{rich:element('idValLigne')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite<=199}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLong}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite<=299}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite<=399}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Hauteur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligHaut}" style="width:60px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite<=499}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Diamêtre:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite<=849}">
                                    <h:outputText value="Nombre:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_code_unite<=899}">
                                    <h:outputText value="Pression:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureLigneVentes.facligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="panelLigne4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.validationLigne>=1}">
                                <h:graphicImage value="/images/actif.gif" />
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.messageStockNegatif}" style="color:red"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                <rich:column width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_mod}">
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.facligCode}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.facligLibelle}" style="#{doclig.styleLigne}"/><br>
                                    <h:outputText value="#{doclig.facligComplement}" rendered="#{doclig.facligComplement!=null}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="4%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva==0}">
                                    <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                    <h:outputText value="#{doclig.facligTaxe}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_sansstock}">
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText value="#{doclig.facligDepot}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{doclig.facligQte}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="6%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.modeCalculDevis=='1'}">
                                    <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                    <h:outputText value="#{doclig.facligLong}" rendered="#{doclig.facligLong!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                                        <h:outputText value="#{doclig.facligPu}" rendered="#{doclig.facligPu!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.U.TTC"/></f:facet>
                                        <h:outputText value="#{doclig.facligPuTtc}" rendered="#{doclig.facligPuTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.affichagePump}">
                                    <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                    <h:outputText value="#{doclig.facligPump}" rendered="#{doclig.facligPump!=0}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrouRemise}">
                                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                                    <h:outputText value="#{doclig.facligTauxRemise}" rendered="#{doclig.facligTauxRemise!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verrouRabais}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.libelleRabRis}"/></f:facet>
                                    <h:outputText value="#{doclig.facligRabais}" rendered="#{doclig.facligRabais!=0}" style="#{doclig.styleLigne}">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="PRem.HT"  /></f:facet>
                                        <h:outputText value="#{dvslig.facligPuRem}" rendered="#{dvslig.facligPuRem!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="PRem.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.facligPuRemTtc}" rendered="#{doclig.facligPuRemTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.facligPt}" rendered="#{doclig.facligPt!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.facligTtc}" rendered="#{doclig.facligTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Poids:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facPoids}" style="text-align:right"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.axeSite=='true'}" var="impt2">
                        <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facSite}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDepartement}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facService}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.axeRegion=='true'}" var="impt3">
                        <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Région:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facRegion}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Secteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facSecteur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Point de vente:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facPdv}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_activite}" var="impt4">
                        <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_parc}" var="impt5">
                        <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesParcsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_contener_parc}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="N° Conteners:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:inputTextarea style="width:100%" rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facContener}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_dossier}" var="impt7">
                        <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationComplement}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Numéro bon commande client:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNumClient}" disabled="true">
                            </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Date bon commande client:"/>&nbsp;&nbsp;
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateClient}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="true"/>
                        </h:column>
                        <h:column><h:outputText value="Numéro de compteur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo1}" size="15" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Index début:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo2}"  size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Index fin:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo3}"  size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculIndex}" reRender="idNbIndex"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nb index total:"/></h:column>
                        <h:column><h:inputText id="idNbIndex" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo4}"  size="10" readonly="true" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Formule 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesIncotermesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Lieu livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Date livraison:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Info livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Remise globale (%):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTauxRemise}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculeRemiseGlobale}" reRender="panelPage,tableLigne,panelTotal"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Facture d'acompte (%):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTauxAcompte}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculeAcompteGlobal}" reRender="panelPage,tableLigne,panelTotal"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Lettre accompagnement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facGarde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.pageGardeItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" >
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Exonération" id="tabExo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_exoneration}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationExoneration}">
                    <h:panelGrid width="100%" id="idcommunExo">
                        <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idExo">
                        <h:column><h:outputText value="Exonération:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem itemLabel="AVEC TVA OU PRECOMPTE" itemValue="0"/>
                                <f:selectItem itemLabel="EXONERE TVA OU PRECOMPTE" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculeExoneration}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,tableLigne,idExo,idcommunExo"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Motif exonération:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facMotifExo}" maxlength="50" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="N° visa:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNumVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date visa:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateVisa}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"   disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.majVisa}"/>
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Rangement visa:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facRangeVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.decrmtRabais=='3'}">
                        <h:column><h:outputText value="Ristourne bloquée:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facRistourneBloquee}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationReglement}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp"/>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.chargerModeEcheance}" reRender="panelGlobal,detmpdev,preg"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.CalculDateEcheance}" reRender="idEcheance"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.CalculDateEcheance}" reRender="idEcheance" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><h:inputText id="idEcheance" readonly="true" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateEcheReg}" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_habilitation}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationEtat}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID FACTURE:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateTransfert}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.autorisationTracabilite}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                    <h:panelGrid id="panTrace" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionTracabilite}"/>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Date Trf."/></f:facet>
                                    <h:outputText value="#{trace.doctraDateCreat}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="18%">
                                    <f:facet name="header"><h:outputText  value="Agent"/></f:facet>
                                    <h:outputText value="#{trace.doctraUserNom}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Type origine"/></f:facet>
                                    <h:outputText  value="#{trace.var_lib_org}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                    <h:outputText value="#{trace.doctraOrgSerie}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="N° Orgine"/></f:facet>
                                    <h:outputText  value="#{trace.doctraOrgNum}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                                    <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.voirOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNum!=trace.doctraOrgNum}"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{trace.doctraOrgDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Type destination"/></f:facet>
                                    <h:outputText  value="#{trace.var_lib_dst}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                    <h:outputText value="#{trace.doctraDstSerie}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="N° destination"/></f:facet>
                                    <h:outputText  value="#{trace.doctraDstNum}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="Voir"/></f:facet>
                                    <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.voirDestination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNum!=trace.doctraDstNum}"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{trace.doctraDstDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.paiementAVOIR=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_acc_reglement}">
                    <jsp:include flush="true" page="/ventes/FactureCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annule}"  />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.plafondAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" reRender="panelValidationDocument"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facActivite}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_parc}"><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_parc}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnal2}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesParcsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_dossier}">
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facAnal4}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.responsable!='0'}"><h:outputText value="Objet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.responsable!='0'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facObservation}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facModeReg}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.chargerModeEcheance}" reRender="idValdocument"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facTypeReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.CalculDateEcheance}" reRender="idValdocument"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNbJourReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.CalculDateEcheance}" reRender="idValdocument" />
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.CalculDateEcheance}" reRender="idValdocument" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facDateEcheReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facBanque}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Modèle impression:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
