<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="demandefiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES DEMANDES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Demande" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationDocument}">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesdevisesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.accesAffaires}" var="aff">
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="Type:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idType" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesTypesDemandestems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.accesAffaires}" var="aff1">
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="N° Affaire:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idAffaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesAffairesItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Type:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idType" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesTypesDemandestems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </c:if>
                            <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.informationsTiers!=null}">
                                <center>
                                    <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                </center>
                            </h:panelGroup>
                            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversTiers==0}"/>
                                    <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversTiers==99}"/>
                                </h:column>
                                <h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversTiers==0}">
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversTiers==99}">
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column id="idResponsable">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesUsersItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.responsable=='0'}">
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.responsable!='0'}">
                                    <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_nom_commercial}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesCommercialItem}" />
                                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.calculeResponsableLie}" reRender="panelContact,idResponsable"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </c:if>
                            </h:panelGrid>
                            <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversTiers==99}">
                                <h:column><h:outputText value="Adressé à:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Téléphone:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Mail:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Montant demandé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotDemande}" style="text-align:right;width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Montant accordé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotAccorde}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Montant débloqué:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotDebloque}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTauxTc!=0}"><h:outputText value="Surtaxe:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTauxTc!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_mod}">
                        <f:facet name="header"><h:outputText value="Description du demandeur"/></f:facet>
                        <rich:editor id="idCorps1" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDescription}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Observations receveur" id="tabObsReceveur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationComplement}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid width="100%" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Observation du receveur"/></f:facet>
                        <rich:editor id="idCorps2" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Scan Demandeur" id="tabSacnDemandeur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationComplement}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanScanDemandeur">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES DU DEMANDEUR"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobalDemandeur" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.ajouterDocumentScanDemandeur}" reRender="panalAjoutFileDemandeur"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.dataModelDocumntsDemandeur}" id="listeDocDemandeur" var="documentDemandeur" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{documentDemandeur}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.lectureDocDemandeur}" reRender="panalVisuPjDemandeur"/>
                                        <br>
                                        <h:outputText value="#{documentDemandeur}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>     

                <rich:tab label="Observations du Comité" id="tabObsComite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationComplement}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid width="100%" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Observation de la validation"/></f:facet>
                        <rich:editor id="idCorps3" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemValidation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idConclusion">
                        <h:column><h:outputText value="Conclusion finale:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeConclusion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat>=2}">
                                <f:selectItem itemLabel="En attente de décision" itemValue="0"/>
                                <f:selectItem itemLabel="Acceptation par le comité" itemValue="1"/>
                                <f:selectItem itemLabel="Refus par le comité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idConclusion"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observation finale:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemConclusion}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat>=2}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeConclusion==1}"><h:outputText value="Montant accordé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeConclusion==1}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotAccorde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat>=2}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelTotal"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Scan Comité" id="tabSacnComite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationComplement}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanScanComite">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES DU COMITE"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobalComite" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.ajouterDocumentScanComite}" reRender="panalAjoutFileComite"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.dataModelDocumntsComite}" id="listeDocComite" var="documentComite" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{documentComite}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.lectureDocComite}" reRender="panalVisuPjComite"/>
                                        <br>
                                        <h:outputText value="#{documentComite}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationImputation}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.axeSite=='true'}" var="impt2">
                        <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemSite}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDepartement}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemService}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.axeRegion=='true'}" var="impt3">
                        <h:panelGrid id="idImput3" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Région:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemRegion}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Secteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemSecteur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Point de vente:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemPdv}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}" var="impt4">
                        <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_dossier}" var="impt7">
                        <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationComplement}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib3ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Lettre accompagnement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemGarde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.pageGardeItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" >
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationReglement}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,detmpdev,preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItem itemLabel="Sélection condition paiement" itemValue="99"/>
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement comptant, 50% à l'acceptation, le solde au controle final" itemValue="5"/>
                                <f:selectItem itemLabel="Paiement à terme par tranche" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><h:inputText id="idEcheance" readonly="true" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateEcheReg}" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_habilitation}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.autorisationEtat}">
                    <jsp:include flush="true" page="/fondation/DemandeCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID du devis:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==3)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annule}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" reRender="panelValidationDocument"/>
                </center>
                <center>
                    <h:outputText id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <!-- modalPanel de validation document -->
    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 0px black;background-color:white;overflow:auto" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemActivite}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_dossier}">
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemAnal4}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.responsable!='0'}"><h:outputText value="Objet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.responsable!='0'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeReg}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTypeReg}">
                                <f:selectItem itemLabel="Sélection condition paiement" itemValue="99"/>
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement comptant, 50% à la commande, le solde à la livraison" itemValue="5"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNbJourReg}" >
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateEcheReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemBanque}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Modèle impression:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.save}" title="Enregistrement du devis" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.habilitation!=null}" id="idValDocAttente" image="/images/valider_attente.png" title="Mise en attente du devis" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.saveAttente}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPjDemandeur" width="1100" height="600" headerClass="headerPanel" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelPjDemandeur}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelPjDemandeur}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF Demandeur"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.supprimerDocumentScanDemandeur}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPjDemandeur,listeDocDemandeur" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fermerVisuDocumentScanDemandeur}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPjDemandeur"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFileDemandeur" width="500" height="250" headerClass="headerPanel" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelAjoutFileDemandeur}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelAjoutFileDemandeur}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER DEMANDEUR"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annulerDocumentScanDemandeur}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFileDemandeur"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.validerDocumentScanDemandeur}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPjComite" width="1100" height="600" headerClass="headerPanel" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelPjComite}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelPjComite}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF du Comite"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.supprimerDocumentScanComite}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPjComite,listeDocComite" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_aff_action}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fermerVisuDocumentScanComite}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPjComite"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFileComite" width="500" height="250" headerClass="headerPanel" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelAjoutFileComite}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelAjoutFileComite}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER DU COMITE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annulerDocumentScanComite}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFileComite"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.validerDocumentScanComite}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
