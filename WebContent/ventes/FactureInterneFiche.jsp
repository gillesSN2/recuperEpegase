<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="factureinternefiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES FACTURES INTERNES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Facture interne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationDocument}">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesdevisesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.accesAffaires}" var="aff">
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.accesAffaires}" var="aff1">
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="N° Affaire:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesAffairesItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.informationsTiers!=null}">
                                <center>
                                    <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                </center>
                            </h:panelGroup>
                            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTiers==0}"/>
                                    <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTiers==99}"/>
                                </h:column>
                                <h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.contDest=='false'}">
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.contDest=='true'}">
                                        <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNomContact}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeDestinataire,formModalListeDestinataire,panelContact,idDestinataire" />
                                        </h:inputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTiers==99}">
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column id="idResponsable">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesUsersItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.responsable=='0'}">
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.responsable!='0'}">
                                    <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_nom_commercial}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesCommercialItem}" />
                                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculeResponsableLie}" reRender="panelContact,idResponsable"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </c:if>
                            </h:panelGrid>
                            <h:panelGrid id="idTiersDivers" columns="4" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTiers==99}">
                                <h:column><h:outputText value="N° Id. fiscale:"/></h:column>
                                <h:column><h:inputText size="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversNif}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="20"/></h:column>
                                <h:column><h:outputText value="Adressé à:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Téléphone:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Mail:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="H.T.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taxe:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTotTva}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="T.T.C.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTotTtc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.affichagePump}"><h:outputText value="Marge:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.affichagePump}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_total_marge}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_tc_type!=0}" columns="2">
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_tc_calcul}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recupererEltCat}" reRender="panelTotal"/>
                                </h:selectBooleanCheckbox>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_tc_libelle}:"/>
                            </h:panelGrid>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_tc_type!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibiliteBtonlig&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligGroupe==null||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligGroupe=='')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_mod}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idDepot,inpCodDet,panelLigne"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.griserchamps}" style="width:100%" maxlength="500">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                    </h:inputText>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" id="panelLigne11" columns="2" columnClasses="clos12d,clos88" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.descriptifComplementaire=='1'}">
                                <h:outputText value="Descriptif Complémentaire"/>
                                <h:inputTextarea tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligComplement}" style="width:100%"/>
                            </h:panelGrid>
                            <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligQte}" style="width:90px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,panelPu,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite">
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.selectionConditionnement}" reRender="panelLigne2,panelLigne3,panelPu,panelPt"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_sansstock}">
                                    <h:outputText value="Stock" />
                                    <h:selectOneMenu id="idDepot" tabindex="12" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_depotProd}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesProduitsDepotsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.selectionDepot}" reRender="panelPump" />
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligPump}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup id="panelManquant">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_transit}">
                                        <h:outputText value="Manquant"/>
                                        <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligManquant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>&nbsp;&nbsp;
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_transit}">
                                        <h:outputText value="MQts"/>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligQteManquant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouPrvente}" style="width:100px;text-align:right;"/>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouRabais}">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.libelleRabRis}"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligRabais}" style="width:70px;text-align:right;">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.griserValider}"/>
                                    <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite<=199}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLong}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite<=299}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite<=399}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Hauteur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligHaut}" style="width:60px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite<=499}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Diamêtre:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite<=849}">
                                    <h:outputText value="Nombre:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_code_unite<=899}">
                                    <h:outputText value="Pression:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneLigneVentes.fitligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                <rich:column width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_mod}">
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.datamodelLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.datamodelLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.datamodelLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.fitligCode}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.fitligLibelle}" style="#{doclig.styleLigne}"/><br>
                                    <h:outputText value="#{doclig.fitligComplement}" rendered="#{doclig.fitligComplement!=null}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva==0}">
                                    <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                    <h:outputText value="#{doclig.fitligTaxe}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{doclig.fitligQte}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="6%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.modeCalculDevis=='1'}">
                                    <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                    <h:outputText value="#{doclig.fitligLong}" rendered="#{doclig.fitligLong!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                                        <h:outputText value="#{doclig.fitligPu}" rendered="#{doclig.fitligPu!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.U.TTC"/></f:facet>
                                        <h:outputText value="#{doclig.fitligPuTtc}" rendered="#{doclig.fitligPuTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.affichagePump}">
                                    <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                    <h:outputText value="#{doclig.fitligPump}" rendered="#{doclig.fitligPump!=0}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouRemise}">
                                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                                    <h:outputText value="#{doclig.fitligTauxRemise}" rendered="#{doclig.fitligTauxRemise!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.verrouRabais}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.libelleRabRis}"/></f:facet>
                                    <h:outputText value="#{doclig.fitligRabais}" rendered="#{doclig.fitligRabais!=0}" style="#{doclig.styleLigne}">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="PRem.HT"  /></f:facet>
                                        <h:outputText value="#{dvslig.fitligPuRem}" rendered="#{dvslig.fitligPuRem!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="PRem.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.fitligPuRemTtc}" rendered="#{doclig.fitligPuRemTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.fitligPt}" rendered="#{doclig.fitligPt!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.fitligTtc}" rendered="#{doclig.fitligTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.axeSite=='true'}" var="impt2">
                        <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitSite}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDepartement}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitService}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.axeRegion=='true'}" var="impt3">
                        <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Région:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitRegion}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Secteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitSecteur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Point de vente:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitPdv}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_activite}" var="impt4">
                        <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_parc}" var="impt5">
                        <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesParcsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_contener_parc}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="N° Conteners:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:inputTextarea style="width:100%" rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitContener}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}"/>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_dossier}" var="impt7">
                        <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationComplement}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib3ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Formule 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesIncotermesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Lieu livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Date livraison:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Info livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Remise globale (%):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTauxRemise}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculeRemiseGlobale}" reRender="panelPage,tableLigne,panelTotal"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Lettre accompagnement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitGarde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.pageGardeItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" >
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Exonération" id="tabExo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_exoneration}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationExoneration}">
                    <h:panelGrid width="100%" id="idcommunExo">
                        <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idExo">
                        <h:column><h:outputText value="Exonération:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem itemLabel="AVEC TVA OU PRECOMPTE" itemValue="0"/>
                                <f:selectItem itemLabel="EXONERE TVA OU PRECOMPTE" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.calculeExoneration}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,tableLigne,idExo,idcommunExo"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Motif exonération:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitMotifExo}" maxlength="50" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.noteDebitEnteteVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="N° visa:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNumVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.noteDebitEnteteVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date visa:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateVisa}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"   disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.noteDebitEnteteVentes.majVisa}"/>
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Rangement visa:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitRangeVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.noteDebitEnteteVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationReglement}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,detmpdev,preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><h:inputText id="idEcheance" readonly="true" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateEcheReg}" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_habilitation}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationEtat}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID NOTE DEBIT:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateTransfert}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.autorisationTracabilite}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                    <h:panelGrid id="panTrace" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Date Trf."/></f:facet>
                                    <h:outputText value="#{trace.doctraDateCreat}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="26%">
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

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_acc_reglement}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.annule}"  />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" reRender="panelValidationDocument"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitActivite}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_parc}"><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_parc}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnal2}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.mesParcsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_anal_dossier}">
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitAnal4}"/>
                        </h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.optionsVentes.responsable!='0'}">
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_aff_action}" maxlength="100"/></h:column>
                        </c:if>
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitObservation}" maxlength="100"/></h:column>
                    </h:panelGrid>

                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitModeReg}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitTypeReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitNbJourReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitDateEcheReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitBanque}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Modèle impression:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.factureInterneEnteteVentes.fitModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
