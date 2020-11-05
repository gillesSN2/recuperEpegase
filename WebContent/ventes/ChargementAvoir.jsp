<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:facet name="header"><h:outputText value="Avoir chargement"/></f:facet>
<a4j:form id="formModalAvoir">
    <rich:hotKey key="return" handler="return false;"/>
    <h:panelGrid  width="100%">
        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px">
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:panelGrid width="100%" columns="4">
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_date_doc}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.controleSaisie}"/>
                    </rich:calendar>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_heure_doc}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"  style="width:45px">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                    </h:selectOneMenu>
                    <h:column><h:outputText value=":"/></h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_minute_doc}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"  style="width:45px">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrId!=0}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesSerieUserItem}"/>
                    </h:selectOneMenu>&nbsp;&nbsp;
                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesdevisesItem}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                <h:column>
                    <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers,valDoc"/>
                    </h:inputText>&nbsp;
                    <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                    <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" reRender="panelTiers"/>
                </h:column>
                <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,tableLigneAvoir" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recupererEltCatAvoir}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTiers==0}"/>
                    <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTiers==99}"/>
                </h:column>
                <h:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.contDest=='false'}">
                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesContactItem}"/>
                        </h:selectOneMenu>&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.contDest=='true'}">
                        <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrNomContact}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechercheDestinataire}" reRender="idSubView,panelListeDestinataire,formModalListeDestinataire,panelContact,idDestinataire" />
                        </h:inputText>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTiers==99}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                    </c:if>
                </h:column>
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column id="idResponsable">
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_nom_responsable}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesUsersItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_nom_commercial}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesCommercialItem}" />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="2" columnClasses="clos12d,clos83">
                <h:column><h:outputText value="Objet:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100"/></h:column>
            </h:panelGrid>
            <h:panelGrid id="idTiersDivers" columns="4" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTiers==99}">
                <h:column><h:outputText value="Adressé à:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100"/></h:column>
                <h:column><h:outputText value="Ville:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="50"/></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="50"/></h:column>
                <h:column><h:outputText value="Mail:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.avoirEnteteVentes.avrDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100"/></h:column>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable styleClass="bg" id="tableLigneAvoir" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelDispo}" var="dispo">
                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionnerAvoir}" reRender="panelBoutonAvoir"/>
                <rich:column label="Code produit" sortable="true" sortBy="#{dispo.stk_code_produit}" width="20%">
                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                    <h:outputText value="#{dispo.stk_code_produit}"/>
                </rich:column>
                <rich:column label="Libellé produit" sortable="true" sortBy="#{dispo.stkLibelle}" width="30%">
                    <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                    <h:outputText value="#{dispo.stkLibelle}"/>
                </rich:column>
                <rich:column label="Quantité facturée" sortable="true" sortBy="#{dispo.stk_qte_in}" width="10%" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Qte facturée" /></f:facet>
                    <h:outputText value="#{dispo.stk_qte_in}">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                    </h:outputText>
                </rich:column>
                <rich:column label="Quantité en avoir" sortable="true" sortBy="#{dispo.stk_qte_attRecAch}" width="10%">
                    <f:facet name="header"><h:outputText  value="Qte avoir"/></f:facet>
                    <h:inputText  value="#{dispo.stk_qte_attCmdVte}" style="width:90%;text-align:right;">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                    </h:inputText>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </h:panelGrid>
    <br>
    <h:panelGroup id="valDoc">
        <center>
            <a4j:commandButton id="idCancelAvr" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annulerAvoir}" reRender="panelAvoir"/>&nbsp;&nbsp;&nbsp;
            <a4j:commandButton id="idValAvr" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validerAvoir}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelAvoir,tableAvoir" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_detail_tiers}"/>
        </center>
    </h:panelGroup>
</a4j:form>