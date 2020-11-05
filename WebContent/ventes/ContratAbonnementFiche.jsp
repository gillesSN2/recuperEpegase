<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="contratabnfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES CONTRATS DES ABONNEMENTS" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Contrat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationDocument}">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"  style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"  style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesdevisesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                <h:column>
                                    <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                    </h:inputText>&nbsp;
                                    <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                    <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" reRender="panelTiers"/>
                                </h:column>
                                <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recupererEltCat}" reRender="idCat,idSerie,panelTotal,tableLigne"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Nom contact:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contDest=='false'}">
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contDest=='true'}">
                                        <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNomContact}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeDestinataire,formModalListeDestinataire,panelContact,idDestinataire" />
                                        </h:inputText>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column id="idResponsable">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesUsersItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.responsable=='0'}">
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.responsable!='0'}">
                                    <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_nom_commercial}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesCommercialItem}" />
                                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculeResponsableLie}" reRender="panelContact,idResponsable"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </c:if>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="H.T.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taxe:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTotTva}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="T.T.C.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTotTtc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.affichagePump}"><h:outputText value="Marge:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.affichagePump}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_total_marge}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_tc_type!=0}" columns="2">
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_tc_calcul}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recupererEltCat}" reRender="panelTotal"/>
                                </h:selectBooleanCheckbox>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_tc_libelle}:"/>
                            </h:panelGrid>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_tc_type!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:70px" id="idpanel2">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" id="panelCrt">
                                <h:column><h:outputText value="Type contrat:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                        <f:selectItem  itemLabel="Contrat d'abonnement Compteur" itemValue="25"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelCrt"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Périodicité:" id="idper1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType>=20}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtPeriodicite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" id="idper2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType>=20}">
                                        <f:selectItem itemLabel="Mensuel" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType>=20&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType==25}"><h:outputText value="Facturation à compter du:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType>=20&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType<=25}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateDebut}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType==25}"><h:outputText value="Numéro compteur" /></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType==25}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNumCompteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" style="width:100%"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType==25}"><h:outputText value="Index initial" /></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType==25}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtIndexInitial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" style="width:100%"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibiliteBtonlig&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligGroupe==null||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligGroupe=='')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,panelLigne,tableLigne,panelBoutonLigne,panelTotal"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_mod}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idDepot,inpCodDet,panelLigne"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.griserchamps}" style="width:100%" maxlength="500">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPrix}" reRender="panelPt"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" id="panelLigne11" columns="2" columnClasses="clos12d,clos88" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.descriptifComplementaire=='1'}">
                                <h:outputText value="Descriptif Complémentaire"/>
                                <h:inputTextarea tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligComplement}" style="width:100%"/>
                            </h:panelGrid>
                            <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligQte}" style="width:90px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPrix}" reRender="panelPt,panelPu"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite">
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.selectionConditionnement}" reRender="panelLigne2,panelLigne3,panelPu,panelPt"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_sansstock}">
                                    <h:outputText value="Stock" />
                                    <h:selectOneMenu id="idDepot" tabindex="12" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_depotProd}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesProduitsDepotsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.selectionDepot}" reRender="panelPump" />
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligPump}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrouRabais}">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.libelleRabRis}"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligRabais}" style="width:70px;text-align:right;">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratLigneVentes.crtligTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.griserValider}"/>
                                    <rich:hotKey key="return"  handler="#{rich:element('idValLigne')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " enableContextMenu="false" styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                <rich:column width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_mod}">
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.datamodelLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.datamodelLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.datamodelLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.crtligCode}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.crtligLibelle}" style="#{doclig.styleLigne}"/><br>
                                    <h:outputText value="#{doclig.crtligComplement}" rendered="#{doclig.crtligComplement!=null}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="4%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva==0}">
                                    <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                    <h:outputText value="#{doclig.crtligTaxe}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_sansstock}">
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText value="#{doclig.crtligDepot}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{doclig.crtligQte}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="6%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.modeCalculDevis=='1'}">
                                    <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                    <h:outputText value="#{doclig.crtligLong}" rendered="#{doclig.crtligLong!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                                        <h:outputText value="#{doclig.crtligPu}" rendered="#{doclig.crtligPu!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.U.TTC"/></f:facet>
                                        <h:outputText value="#{doclig.crtligPuTtc}" rendered="#{doclig.crtligPuTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.affichagePump}">
                                    <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                    <h:outputText value="#{doclig.crtligPump}" rendered="#{doclig.crtligPump!=0}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrouRemise}">
                                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                                    <h:outputText value="#{doclig.crtligTauxRemise}" rendered="#{doclig.crtligTauxRemise!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.verrouRabais}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.libelleRabRis}"/></f:facet>
                                    <h:outputText value="#{doclig.crtligRabais}" rendered="#{doclig.crtligRabais!=0}" style="#{doclig.styleLigne}">
                                        <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ristourne}" var="rabais">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.ristourne}" var="ristourne">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </c:if>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="PRem.HT"  /></f:facet>
                                        <h:outputText value="#{dvslig.crtligPuRem}" rendered="#{dvslig.crtligPuRem!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="PRem.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.crtligPuRemTtc}" rendered="#{doclig.crtligPuRemTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.crtligPt}" rendered="#{doclig.crtligPt!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.crtligTtc}" rendered="#{doclig.crtligTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Texte" id="tabTexte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panTexte"/>
                    <h:panelGrid  width="100%" id="panTexte">
                        <h:panelGrid  width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtId==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.afficheTexteContrat}">
                                <h:selectOneMenu id="idModele" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_code_modele}">
                                    <f:selectItem itemLabel="Sélectionnez modèle contrat" itemValue="100" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesModelesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.rechercheTexteModeleContrat}" reRender="panTexte,panelTexteContrat"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" id="panelTexteContrat">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtText}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculeTexte}" reRender="panTexte,panelTexteContrat"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.axeSite=='true'}" var="impt2">
                        <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtSite}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDepartement}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtService}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.axeRegion=='true'}" var="impt3">
                        <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Région:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtRegion}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Secteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtSecteur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Point de vente:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtPdv}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_activite}" var="impt4">
                        <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_parc}" var="impt5">
                        <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesParcsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_dossier}" var="impt7">
                        <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationComplement}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Dernier index:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Formule 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Remise globale (%):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTauxRemise}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculeRemiseGlobale}" reRender="panelPage,tableLigne,panelTotal"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Exonération" id="tabExo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_exoneration}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationExoneration}">
                    <h:panelGrid width="100%" id="idcommunExo">
                        <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idExo">
                        <h:column><h:outputText value="Exonération:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItem itemLabel="AVEC TVA OU PRECOMPTE" itemValue="0"/>
                                <f:selectItem itemLabel="EXONERE TVA OU PRECOMPTE" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculeExoneration}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,tableLigne,idExo,idcommunExo"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Motif exonération:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtMotifExo}" maxlength="50" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="N° visa:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNumVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Date visa:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateVisa}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"   disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Rangement visa:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtRangeVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationReglement}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp"/>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.chargerModeEcheance}" reRender="panelGlobal,detmpdev,preg"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.CalculDateEcheance}" reRender="idEcheance"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.CalculDateEcheance}" reRender="idEcheance" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Factures" id="tabEchance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationReglement}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtEtat==0}">
                        <center>
                            <a4j:commandButton value="Calculer les échances" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.calculeEcheances}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtId!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableEcheance"/>
                        </center>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableEcheance" height="400px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.dataModelEcheance}" var="ech">
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="Date"  /></f:facet>
                                <h:outputText value="#{ech.facDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="N° FACTURE"/></f:facet>
                                <h:outputText value="#{ech.facNum}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="INDEX DEB"/></f:facet>
                                <h:outputText value="#{ech.facInfo2}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="INDEX FIN"/></f:facet>
                                <h:outputText value="#{ech.facInfo3}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="TOT INDEX"/></f:facet>
                                <h:outputText value="#{ech.facInfo4}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="H.T."  /></f:facet>
                                <h:outputText value="#{ech.facTotHt}" rendered="#{ech.facTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="TTC"  /></f:facet>
                                <h:outputText value="#{ech.facTotTtc}" rendered="#{ech.facTotTtc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText value="Regl."  /></f:facet>
                                <h:outputText value="#{ech.facTotReglement}" rendered="#{ech.facTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="50%">
                                <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                <h:outputText value="#{ech.facObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid width="90%" columns="4" columnClasses="clos12d,clos12d,clos12d,clos12d">
                        <h:column><h:outputText value="Nombre facture:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.nombreFacture}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Total facture HT:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.totalHt}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Total facture TTC:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.totalTtc}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Total réglement:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.totalReglement}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_habilitation}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.autorisationEtat}">
                    <jsp:include flush="true" page="/ventes/ContratCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID FACTURE:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent" id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtActivite}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_parc}"><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_parc}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtAnal2}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.mesParcsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_anal_dossier}">
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtAnal4}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.responsable!='0'}"><h:outputText value="Objet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.optionsVentes.responsable!='0'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtObservation}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtModeReg}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.chargerModeEcheance}" reRender="idValdocument"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTypeReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.CalculDateEcheance}" reRender="idValdocument"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNbJourReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.CalculDateEcheance}" reRender="idValdocument" />
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.CalculDateEcheance}" reRender="idValdocument" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtBanque}">
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
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
