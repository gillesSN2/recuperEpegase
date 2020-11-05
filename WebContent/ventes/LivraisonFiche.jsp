<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="blfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES BONS DE LIVRAISON" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Livraison" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationDocument}">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesdevisesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.accesAffaires}" var="aff">
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.accesAffaires}" var="aff1">
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="N° Affaire:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAffaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesAffairesItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="N° Analytique:"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recupererEltCat}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.informationsTiers!=null}">
                                <center>
                                    <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                </center>
                            </h:panelGroup>
                            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTiers==0}"/>
                                    <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTiers==99}"/>
                                </h:column>
                                <h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.contDest=='false'}">
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.contDest=='true'}">
                                        <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomContact}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeDestinataire,formModalListeDestinataire,panelContact,idDestinataire" />
                                        </h:inputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTiers==99}">
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column id="idResponsable">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesUsersItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.responsable=='0'}">
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.responsable!='0'}">
                                    <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_nom_commercial}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesCommercialItem}" />
                                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculeResponsableLie}" reRender="panelContact,idResponsable"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </c:if>
                            </h:panelGrid>
                            <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTiers==99}">
                                <h:column><h:outputText value="Adressé à:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Téléphone:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Mail:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="H.T.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taxe:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTotTva}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="T.T.C.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTotTtc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.affichagePump}"><h:outputText value="Marge:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.affichagePump}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_total_marge}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tc_type!=0}" columns="2">
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tc_calcul}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recupererEltCat}" reRender="panelTotal"/>
                                </h:selectBooleanCheckbox>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tc_libelle}:"/>
                            </h:panelGrid>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tc_type!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBtonlig&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligGroupe==null||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligGroupe=='')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_mod}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idDepot,inpCodDet,panelLigne,panelCdt,panelUnite,panelLigne4"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.griserchamps}" style="width:100%" maxlength="500">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                    </h:inputText>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" id="panelLigne11" columns="2" columnClasses="clos12d,clos88" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.descriptifComplementaire=='1'}">
                                <h:outputText value="Descriptif Complémentaire"/>
                                <h:inputTextarea tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligComplement}" style="width:100%"/>
                            </h:panelGrid>
                            <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_sansstock}">
                                    <h:outputText value="Stock" />
                                    <h:selectOneMenu id="idDepot" tabindex="6" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_depotProd}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesProduitsDepotsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionDepot}" reRender="panelLigne,panelPump,panelLigne4"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligQte}" style="width:90px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPrix}" reRender="panelLigne,panelPt,panelPu,panelLigne4,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite" >
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_unite}" tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_unite}" tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup id="panelCdt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionConditionnement}" reRender="panelLigne,panelLigne2,panelPu,panelPt,panelLigne3"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup id="panelPump" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligPump}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrouRabais}">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.libelleRabRis}"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligRabais}" style="width:70px;text-align:right;">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.validationLigne<=1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.griserValider}"/>
                                    <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=199}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=299}">
                                    <h:outputText value="Longueur"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=399}">
                                    <h:outputText value="Longueur"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Hauteur"/>
                                    <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligHaut}" style="width:60px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=499}">
                                    <h:outputText value="Longueur"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Diamêtre:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=849}">
                                    <h:outputText value="Nombre:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=899}">
                                    <h:outputText value="Pression"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="panelLigne4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.validationLigne==1}">
                                <h:graphicImage value="/images/actif.gif" />
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.messageStockNegatif}" style="color:red"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                <rich:column width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_mod}">
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                </rich:column>
                                <rich:column sortable="false" width="12%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.blvligCode}" style="#{doclig.styleLigne}"/>&nbsp;&nbsp;
                                    <h:outputText value="PROCESS" style="color:red;#{doclig.styleLigne}" rendered="#{doclig.blvligProcess==1}"/>&nbsp;&nbsp;
                                    <h:outputText  value="#{doclig.blvligGroupe}" style="#{doclig.styleLigne}" rendered="#{doclig.blvligModeGroupe==1||doclig.blvligModeGroupe==2}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.blvligLibelle} #{doclig.blvligLot}#{doclig.blvligNumSerie}" style="#{doclig.styleLigne}"/><br>
                                    <h:outputText value="#{doclig.blvligComplement}" rendered="#{doclig.blvligComplement!=null}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="4%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvExoTva==0}">
                                    <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                    <h:outputText value="#{doclig.blvligTaxe}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_sansstock}">
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText value="#{doclig.blvligDepot}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté Tot."/></f:facet>
                                    <h:outputText value="#{doclig.blvligQte}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté Liv."/></f:facet>
                                    <h:outputText value="#{doclig.blvligQteStock}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="6%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.modeCalculDevis=='1'}">
                                    <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                    <h:outputText value="#{doclig.blvligLong}" rendered="#{doclig.blvligLong!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                    <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ouvertureLot}" rendered="#{doclig.blvligStock==2||doclig.blvligStock==3||doclig.blvligStock==4}" reRender="panelLot,formModalLot" style="width:100%"/>
                                    <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ouvertureSerie}" rendered="#{doclig.blvligStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.U.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.blvligPu}" rendered="#{doclig.blvligPu!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.U.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.blvligPuTtc}" rendered="#{doclig.blvligPuTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.affichagePump}">
                                    <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                    <h:outputText value="#{doclig.blvligPump}" rendered="#{doclig.blvligPump!=0}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrouRemise}">
                                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                                    <h:outputText value="#{doclig.blvligTauxRemise}" rendered="#{doclig.blvligTauxRemise!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verrouRabais}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.libelleRabRis}"/></f:facet>
                                    <h:outputText value="#{doclig.blvligRabais}" rendered="#{doclig.blvligRabais!=0}" style="#{doclig.styleLigne}">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <f:facet name="header"><h:outputText value="PRem.HT"  /></f:facet>
                                    <h:outputText value="#{doclig.blvligPuRem}" rendered="#{doclig.blvligPuRem!=0}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.blvligPt}" rendered="#{doclig.blvligPt!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.blvligTtc}" rendered="#{doclig.blvligTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Poids:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvPoids}" style="text-align:right"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.axeSite=='true'}" var="impt2">
                        <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvSite}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDepartement}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvService}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.axeRegion=='true'}" var="impt3">
                        <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Région:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvRegion}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Secteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvSecteur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Point de vente:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvPdv}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}" var="impt4">
                        <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_parc}" var="impt5">
                        <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesParcsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_contener_parc}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="N° Conteners:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:inputTextarea style="width:100%" rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvContener}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_dossier}" var="impt7">
                        <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationComplement}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Numéro bon commande client:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNumClient}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.uniciteNumBcclient}" reRender="modMessageCommun,idSuivi"/>
                            </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Date bon commande client:"/>&nbsp;&nbsp;
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateClient}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib3ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Formule 1 (adresse livraison):" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesIncotermesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Lieu livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Date livraison:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Info livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Remise globale (%):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTauxRemise}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculeRemiseGlobale}" reRender="panelPage,tableLigne,panelTotal"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Lettre accompagnement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvGarde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.pageGardeItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" >
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Exonération" id="tabExo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_exoneration}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationExoneration}">
                    <h:panelGrid width="100%" id="idcommunExo">
                        <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idExo">
                        <h:column><h:outputText value="Exonération:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}">
                                <f:selectItem itemLabel="AVEC TVA OU PRECOMPTE" itemValue="0"/>
                                <f:selectItem itemLabel="EXONERE TVA OU PRECOMPTE" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calculeExoneration}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,tableLigne,idExo,idcommunExo"/>
                            </h:selectOneRadio>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtRabais=='3'}">
                        <h:column><h:outputText value="Ristourne bloquée:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvRistourneBloquee}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Livraison" id="tabPreparation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.gestionLivreur=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_dre}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationDre}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " groupingColumn="#{livre.blvlivDate}"  style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelLivraison}"  var="livre"  sortMode="multi">
                            <rich:column sortable="false" width="15%">
                                <f:facet name="header"><h:outputText  value="Date Liv."/></f:facet>
                                <h:outputText value="#{livre.blvlivDate}">
                                    <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="20%">
                                <f:facet name="header"><h:outputText  value="Chauffeur"/></f:facet>
                                <h:outputText  value="#{livre.blvlivChauffeur}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Véhicule"/></f:facet>
                                <h:outputText value="#{livre.blvlivVehicule}"/>
                            </rich:column>
                            <rich:column sortable="false" width="20%">
                                <f:facet name="header"><h:outputText  value="Préparateur"/></f:facet>
                                <h:outputText  value="#{livre.blvlivPreparateur}"/>
                            </rich:column>
                            <rich:column sortable="false" width="15%">
                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                <h:outputText value="#{livre.blvlivCode}"/>
                            </rich:column>
                            <rich:column sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:outputText  value="#{livre.blvlivDepot}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Qte Livrée"/></f:facet>
                                <h:outputText value="#{livre.blvlivQteLivree}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Pièces jointes" id="tabScan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_dre}">
                    <jsp:include flush="true" page="../ventes/CommandeCommun.jsp" />
                    <h:panelGrid id="panCatalogue" width="100%">
                        <h:panelGrid id="panBoutonPj" width="300px" columns="4">
                            <a4j:commandButton value="Ajouter pièce jointe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ajouterPieceJointe}" reRender="panalAjoutFile"/>
                            <h:commandButton image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.consulterPieceJointe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fileCtrl!=null&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.typeFichier=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.typeFichier=='7')}"/>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fileCtrl!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.typeFichier!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.typeFichier!='7'}">
                                <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.nomPiecesJointes}" target="_blank" title="Télécharger fichier"><img src="images/download.png" alt="télécharger"></a>
                                </h:column>
                                <h:commandButton image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette pièce jointe ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.supprimerPieceJointe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fileCtrl!=null}"/>
                            </h:panelGrid>
                            <rich:extendedDataTable id="ligneCatalogue" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelPieceJointes}" var="fichier" sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionnerPieceJointe}" reRender="panBoutonPj"/>
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

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_habilitation}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationEtat}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID BON LIVRAISON:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.autorisationTracabilite}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                    <h:panelGrid id="panTrace" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionTracabilite}"/>
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
                                    <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.voirOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNum!=trace.doctraOrgNum}"/>
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
                                    <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.voirDestination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNum!=trace.doctraDstNum}"/>
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

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.paiementAVOIR=='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_acc_reglement}">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annule}"  />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" reRender="panelValidationDocument"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelLot" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelLot}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelLot}" var="lot">
            <f:facet name="header"><h:outputText value="Sélection du lot"/></f:facet>
            <a4j:form id="formModalLot">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="4" columnClasses="clos30,clos70">
                        <h:column><h:outputText value="Quantité démandée:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligQte}" style="text-align:right;" readonly="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Unité:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligUnite}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Conditionnement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligCondition}" readonly="true"/></h:column>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=199}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=299}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Largeur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLarg}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=399}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Largeur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLarg}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Hauteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligHaut}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=499}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Diamêtre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligDiam}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=849}">
                            <h:column><h:outputText value="Nombre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligNb}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=899}">
                            <h:column><h:outputText value="Pression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligNb}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:column><h:outputText value="Poids brut:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligPoidsBrut}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        <h:column><h:outputText value="Poids net:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligPoidsNet}" style="text-align:right;" size="8" readonly="true"/></h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableLot" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelLot}" var="lot">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionLot}" reRender="vallot"/>
                            <f:facet name="header"></f:facet>
                            <rich:column label="N° Réception" sortable="true" sortBy="#{lot.reclotNum}" width="100px">
                                <f:facet name="header"><h:outputText  value="N° réception" /></f:facet>
                                <h:outputText value="#{lot.reclotNum}"/>
                            </rich:column>
                            <rich:column label="N° lot" sortable="true" sortBy="#{lot.reclotNumero}" width="100px">
                                <f:facet name="header"><h:outputText  value="N° lot" /></f:facet>
                                <h:outputText value="#{lot.reclotNumero}"/>
                            </rich:column>
                            <rich:column label="Date entrée" sortable="true" sortBy="#{lot.reclotDateAchat}" width="100px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Date Entrée" /></f:facet>
                                <h:outputText value="#{lot.reclotDateAchat}"/>
                            </rich:column>
                            <rich:column label="Quantité disponible" sortable="true" sortBy="#{lot.var_qteDispo}" width="100px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Qte Dispo." /></f:facet>
                                <h:outputText value="#{lot.var_qteDispo}"/>
                            </rich:column>
                            <rich:column label="Volume disponible" sortable="true" sortBy="#{lot.var_volumeDispo}" width="100px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Vol. Dispo." /></f:facet>
                                <h:outputText value="#{lot.var_volumeDispo}"/>
                            </rich:column>
                            <rich:column label="Date de péremption" sortable="true" sortBy="#{lot.reclotDateValable}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonLigneVentes.blvligStock==5}">
                                <f:facet name="header"><h:outputText  value="Périme le" /></f:facet>
                                <h:outputText value="#{lot.reclotDateValable}"/>
                            </rich:column>
                            <rich:column label="Longueur" sortable="true" sortBy="#{prd.var_LongDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=499}">
                                <f:facet name="header"><h:outputText  value="Longueur" /></f:facet>
                                <h:outputText value="#{prd.var_LongDispo}"/>
                            </rich:column>
                            <rich:column label="Largeur" sortable="true" sortBy="#{prd.var_LargDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=499}">
                                <f:facet name="header"><h:outputText  value="Largeur" /></f:facet>
                                <h:outputText value="#{prd.var_LargDispo}"/>
                            </rich:column>
                            <rich:column label="Hauteur" sortable="true" sortBy="#{prd.var_HautDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=399}">
                                <f:facet name="header"><h:outputText  value="Hauteur" /></f:facet>
                                <h:outputText value="#{prd.var_HautDispo}"/>
                            </rich:column>
                            <rich:column label="Diamêtre" sortable="true" sortBy="#{prd.var_DiamDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=499}">
                                <f:facet name="header"><h:outputText  value="Diamêtre" /></f:facet>
                                <h:outputText value="#{prd.var_DiamDispo}"/>
                            </rich:column>
                            <rich:column label="Nombre" sortable="true" sortBy="#{prd.var_NbDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=849}">
                                <f:facet name="header"><h:outputText  value="Nombre" /></f:facet>
                                <h:outputText value="#{prd.var_NbDispo}"/>
                            </rich:column>
                            <rich:column label="Pression" sortable="true" sortBy="#{prd.var_NbDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_code_unite<=899}">
                                <f:facet name="header"><h:outputText  value="Pression" /></f:facet>
                                <h:outputText value="#{prd.var_NbDispo}"/>
                            </rich:column>
                            <rich:column label="Poids brut" sortable="true" sortBy="#{prd.var_PoidsBrutDispo}" width="100px" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="P.brut" /></f:facet>
                                <h:outputText value="#{prd.var_PoidsBrutDispo}"/>
                            </rich:column>
                            <rich:column label="Poids net" sortable="true" sortBy="#{prd.var_PoidsNetDispo}" width="100px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.net" /></f:facet>
                                <h:outputText value="#{prd.var_PoidsNetDispo}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="vallot">
                    <center>
                        <a4j:commandButton id="idCanLot" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermetureLot}" reRender="panelLot"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValLot" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.validationLot}" reRender="panelLot,tableLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_validation_lot}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanLot')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValLot')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelSerie" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="990" height="560" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelSerie}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelSerie}" var="ser">
            <f:facet name="header"><h:outputText value="Sélection du N° de série"/></f:facet>
            <a4j:form id="formModalSerie">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_select_type}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_serie}">
                            <f:selectItem itemLabel="Choisir le type de série" itemValue="0"/>
                            <f:selectItem itemLabel="Séries disponibles" itemValue="1"/>
                            <f:selectItem itemLabel="Séries disponibles par carton" itemValue="2"/>
                            <f:selectItem itemLabel="Séries disponibles par palette" itemValue="3"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.typeSerie}" reRender="idPanSerie,tableSerie,valSerie"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="idPanSerie" width="100%">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_serie==2}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_select_carton}">
                            <f:selectItem itemLabel="Sélectionnez le carton" itemValue="null"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesCartonsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerSerieByCarton}" reRender="tableSerie,valSerie"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_serie==3}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_select_palette}">
                            <f:selectItem itemLabel="Sélectionnez la palette" itemValue="null"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesPalettesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerSerieByPalette}" reRender="tableSerie,valSerie"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableSerie" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelSerie}" var="serie">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionSerie}" reRender="valSerie"/>
                            <f:facet name="header"></f:facet>
                            <rich:column label="N° Réception" sortable="true" sortBy="#{serie.recserNum}" width="100px">
                                <f:facet name="header"><h:outputText  value="N° réception" /></f:facet>
                                <h:outputText value="#{serie.recserNum}"/>
                            </rich:column>
                            <rich:column label="Date entrée" sortable="true" sortBy="#{serie.recserDateIn}" width="100px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Date Entrée" /></f:facet>
                                <h:outputText value="#{serie.recserDateIn}"/>
                            </rich:column>
                            <rich:column label="N° Palette" sortable="true" sortBy="#{serie.recserNum}" width="200px">
                                <f:facet name="header"><h:outputText  value="N° Palette" /></f:facet>
                                <h:outputText value="#{serie.recserPalette}"/>
                            </rich:column>
                            <rich:column label="N° Carton" sortable="true" sortBy="#{serie.recserNum}" width="200px">
                                <f:facet name="header"><h:outputText  value="N° Carton" /></f:facet>
                                <h:outputText value="#{serie.recserCarton}"/>
                            </rich:column>
                            <rich:column label="Sélection" sortable="true" sortBy="#{serie.select_serie}" width="50px">
                                <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                <h:selectBooleanCheckbox value="#{serie.select_serie}"/>
                            </rich:column>
                            <rich:column label="N° Série" sortable="true" sortBy="#{serie.recserSerie}" width="300px">
                                <f:facet name="header"><h:outputText  value="N° Série" /></f:facet>
                                <h:outputText value="#{serie.recserSerie}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valSerie">
                    <center>
                        <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.serieToutSelectionne}" reRender="tableSerie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_liste_vide}"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Rien sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.serieRienSelectionne}" reRender="tableSerie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_liste_vide}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idCanSerie" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermetureSerie}" reRender="panelSerie"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValSerie" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.validationSerie}" reRender="panelSerie,tableLigne,panelLigne,panelBoutonLigne,panelTotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_liste_vide}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanSerie')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValSerie')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvActivite}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_parc}"><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_parc}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnal2}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesParcsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_dossier}">
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvAnal4}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.responsable!='0'}"><h:outputText value="Objet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.responsable!='0'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvObservation}" maxlength="100"/></h:column>
                    </h:panelGrid>

                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvModeReg}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNbJourReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateEcheReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvBanque}">
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
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PIECES JOINTES VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annulerPieceJointe}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.uploadedFile}" accept=".pdf,.PDF,.doc,.DOC,.xls,.XLS,.ppt,.PPT,.odt,.ODT,.ods,.ODS,.jpg,.JPG"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.validerPieceJointe}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation de la pièce jointe (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermerVisuPieceJointe}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
