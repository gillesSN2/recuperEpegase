<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="chargementfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES CHARGEMENTS" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ongletActif}" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Chargement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_document}" >
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationDocument}" reRender="panChargement"/>
                    <h:panelGrid id="panChargement" width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;
                                    <h:selectOneMenu style="width:60%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recupererEltCat}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Responsable:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesUsersItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_nom_commercial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesCommercialItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Dépôt char.:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_depot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichageDepot||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Dépôt" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesDepotChgItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.afficheValide}" reRender="panelPage,panelGlobal,tabDoc,panelPage,idSerie,panelValide,panelBoutonLigne,panelLigne" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>                                              
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="H.T.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taxe:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobTotTva}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="T.T.C.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobTotTtc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePump}"><h:outputText value="Marge:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePump}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_total_marge}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobTauxTc!=0}"><h:outputText value="Surtaxe:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobTauxTc!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_valide_chg&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelLigne,tableLigne,panelBoutonLigne"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_valide_chg&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_mod}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,inpCodDet,panelLigne,panelCdt,panelUnite"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}" style="width:100%" maxlength="500">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteCharg}" style="width:90px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrix}" reRender="panelPt,panelPu"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite" >
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_unite}" tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_unite}" tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup id="panelCdt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionConditionnement}" reRender="panelLigne,panelLigne2,panelPu,panelPt,panelLigne3"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup id="panelPump" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligPump}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRabais}">
                                    <h:outputText value="Rabais"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligRabais}" style="width:70px;text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrix}" reRender="panelPt,panelLigne2,idValLigne"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <a4j:commandButton tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserValider}"/>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=199}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=299}">
                                    <h:outputText value="Longueur"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=399}">
                                    <h:outputText value="Longueur"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Hauteur"/>
                                    <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligHaut}" style="width:60px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=499}">
                                    <h:outputText value="Longueur"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Diamêtre:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=849}">
                                    <h:outputText value="Nombre:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=899}">
                                    <h:outputText value="Pression"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                <rich:column sortable="false" width="3%">
                                    <f:facet name="header"><h:outputText value="His."/></f:facet>
                                    <a4j:commandButton image="/images/detail.png" style="width:15px;height:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.historiqueProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoriqueProduit" rendered="#{doclig.chaligGenerique!=5}"/>
                                </rich:column>
                                <rich:column sortable="true" width="10%" sortBy="#{doclig.chaligOrdre}">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.chaligCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="15%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.chaligLibelle}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.produitGenerique=='0'}">
                                    <f:facet name="header"><h:outputText value="Gen."/></f:facet>
                                    <h:selectBooleanCheckbox value="#{doclig.var_generique}" readonly="true" rendered="#{doclig.chaligGenerique==5}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="8%" >
                                    <f:facet name="header"><h:outputText value="Qté Dem."/></f:facet>
                                    <h:outputText value="#{doclig.chaligQteDem}" rendered="#{doclig.chaligQteDem!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="8%" >
                                    <f:facet name="header"><a4j:commandButton value="T.Liv." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.toutLivrer}" reRender="tableLigne,panelTotal"/></f:facet>
                                    <a4j:commandButton title="Livraison" value="Livraison" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.choixLivraison}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLivraisonDirecte,panelEclatement" immediate="true" style="width:90%" rendered="#{doclig.chaligQteDem!=0}"/>
                                </rich:column>
                                <rich:column id="idQteLiv" sortable="false" style="text-align:right" width="8%" >
                                    <f:facet name="header"><h:outputText value="Qté Liv."/></f:facet>
                                    <h:outputText value="#{doclig.chaligQteCharg}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="6%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.modeCalculDevis=='1'}">
                                    <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                    <h:outputText value="#{doclig.chaligLong}" rendered="#{doclig.chaligLong!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}"/>
                                    <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ouvertureLot}" rendered="#{doclig.chaligStock==2||doclig.chaligStock==3||doclig.chaligStock==4}" reRender="panelLot,formModalLot" style="width:100%"/>
                                    <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ouvertureSerie}" rendered="#{doclig.chaligStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.U.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.chaligPu}" rendered="#{doclig.chaligPu!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.U.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.chaligPuTtc}" rendered="#{doclig.chaligPuTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePump}">
                                    <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                    <h:outputText value="#{doclig.chaligPump}" rendered="#{doclig.chaligPump!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRemise}">
                                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                                    <h:outputText value="#{doclig.chaligTauxRemise}" rendered="#{doclig.chaligTauxRemise!=0}" />
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRabais}">
                                    <f:facet name="header"><h:outputText  value="Rabais"/></f:facet>
                                    <h:outputText value="#{doclig.chaligRabais}" rendered="#{doclig.chaligRabais!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.chaligPt}" rendered="#{doclig.chaligPt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.chaligTtc}" rendered="#{doclig.chaligTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_imputation}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationImputation}" reRender="panImputation"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Poids:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobPoids}" style="text-align:right;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.axeSite=='true'}" var="impt2">
                        <h:panelGrid id="idImput2" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobSite}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDepartement}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobService}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_activite}" var="impt4">
                        <h:panelGrid id="idImput4" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_parc}" var="impt5">
                        <h:panelGrid id="idImput5" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobAnal2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesParcsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_contener_parc}" var="impt6">
                            <h:panelGrid id="idImput6" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="N° Conteners:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:inputTextarea style="width:100%" rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobContener}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"/>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_dossier}" var="impt7">
                        <h:panelGrid id="idImput7" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_complement}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationComplement}" reRender="panComplement"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="panComplement" columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobObjet}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Poids:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobPoids}" style="text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Rechargement" id="tabRechargement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_complement}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationRechargement}" reRender="panRechargement"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="panRechargement" style="background-color:#DAEECB;text-align:left;" width="100%" >
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonLigneR" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau rechargement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.addLigneRechargement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_ajt}" reRender="panelLigneR,panelBoutonLigneR"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.deleteLigneSelectRechargement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelLigneR,tableLigneR,panelBoutonLigneR"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigneR" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_valide_rcg&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_mod}">
                                <h:panelGrid  columns="5" width="100%" id="panelLigne1R" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                    <h:column>
                                        <h:outputText value="Code" style="text-decoration:underline;"/>
                                        <h:inputText tabindex="1" id="inpCodDetR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechercheProduitsRechargement}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,inpCodDetR,panelLigneR,panelCdtR,panelUniteR"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Référence"/>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}" />
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé"/>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}" style="width:100%" maxlength="500">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculTvaRechargement}" reRender="panelLigneR,panelLigne1R,panelLigne2R,panelLigne3R"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="10" width="100%" id="panelLigne2R">
                                    <h:panelGroup>
                                        <h:outputText value="Qte"/>
                                        <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligQteCharg}" style="width:90px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrixRechargement}" reRender="panelPtR"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelUniteR" >
                                        <h:outputText value="Unité"/>
                                        <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_unite}" tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserchamps}" style="width:80px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesUnitesProduits}"/>
                                        </h:selectOneMenu>
                                        <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_unite}" tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligUnite}" style="width:80px;"/>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelCdtR" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_condit}">
                                        <h:outputText value="Cdt."/>
                                        <h:selectOneMenu tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligCondition}" style="width:100px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesConditionnementsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionConditionnement}" reRender="panelLigne,panelLigne2,panelPu,panelPt,panelLigne3"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPumpR" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePump}">
                                        <h:outputText value="PUMP"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligPump}" style="width:100px;text-align:right;" disabled="true" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPlancherR" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.prixPlancher!=0}">
                                        <h:outputText value="Plancher"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPuR">
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                            <h:outputText value="P.U.HT"/>
                                            <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrixRechargement}" reRender="panelPtR,panelLigne2R,idValLigneR"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                            <h:outputText value="P.U.TTC"/>
                                            <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouPrvente}" style="width:100px;text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrixRechargement}" reRender="panelPtR,panelLigne2R,idValLigneR"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRemise}">
                                        <h:outputText value="Remise %"/>
                                        <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligTauxRemise}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrixRechargement}" reRender="panelPtR,panelLigne2R,idValLigneR"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRabais}">
                                        <h:outputText value="Rabais"/>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligRabais}" style="width:70px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculPrixRechargement}" reRender="panelPtR,panelLigne2R,idValLigneR"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPtR">
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                            <h:outputText value="P.T.HT"/>
                                            <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligPt}" disabled="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                            <h:outputText value="P.T.TTC"/>
                                            <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligTtc}" disabled="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <a4j:commandButton tabindex="18" image="/images/valider_big.png" id="idValLigneR" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.saveOneLigneRechargement}" reRender="panelPage,panelTotal,panelLigneR,tableLigneR,panelBoutonLigneR" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.griserValider}"/>
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid columns="6" width="100%" id="panelLigne3R" style="margin-left:350px">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=199}">
                                        <h:outputText value="Longueur:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLong}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=299}">
                                        <h:outputText value="Longueur"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Largeur:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLarg}" style="width:70px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=399}">
                                        <h:outputText value="Longueur"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Largeur:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Hauteur"/>
                                        <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligHaut}" style="width:60px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=499}">
                                        <h:outputText value="Longueur"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="Diamêtre:"/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligLarg}" style="width:70px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=849}">
                                        <h:outputText value="Nombre:"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligNb}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=899}">
                                        <h:outputText value="Pression"/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechargementLigne.chaligNb}" style="width:90px;text-align:right;"/>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigneR" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelRechargement}" var="docrec">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionLigneDetailRechargement}" reRender="panelLigneR,panelBoutonLigneR"/>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText  value="#{docrec.chaligDateChargement}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%">
                                        <f:facet name="header"><h:outputText  value="Nb"/></f:facet>
                                        <h:outputText  value="#{docrec.chaligNombreRechargement}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{docrec.chaligCode}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="15%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{docrec.chaligLibelle}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="10%" >
                                        <f:facet name="header"><h:outputText  value="Qté Dem."/></f:facet>
                                        <h:outputText value="#{docrec.chaligQteCharg}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                        <h:outputText value="#{docrec.var_lib_uni_condit}"/>
                                        <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ouvertureLot}" rendered="#{docrec.chaligStock==2||docrec.chaligStock==3||docrec.chaligStock==4}" reRender="panelLot,formModalLot" style="width:100%"/>
                                        <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ouvertureSerie}" rendered="#{docrec.chaligStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                            <f:facet name="header"><h:outputText value="P.U.HT"  /></f:facet>
                                            <h:outputText value="#{docrec.chaligPu}" rendered="#{docrec.chaligPu!=0}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecPu}"/>
                                            </h:outputText>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                            <f:facet name="header"><h:outputText value="P.U.TTC"  /></f:facet>
                                            <h:outputText value="#{docrec.chaligPuTtc}" rendered="#{docrec.chaligPuTtc!=0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </c:if>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRemise}">
                                        <f:facet name="header"><h:outputText  value="Remise%"  /></f:facet>
                                        <h:outputText value="#{docrec.chaligTauxRemise}" rendered="#{docrec.chaligTauxRemise!=0}" />
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verrouRabais}">
                                        <f:facet name="header"><h:outputText  value="Rabais"  /></f:facet>
                                        <h:outputText value="#{docrec.chaligRabais}" rendered="#{docrec.chaligRabais!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="PRem.HT"  /></f:facet>
                                        <h:outputText value="#{docrec.chaligPuRem}" rendered="#{docrec.chaligPuRem!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='1'}">
                                            <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                            <h:outputText value="#{docrec.chaligPt}" rendered="#{docrec.chaligPt!=0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.decrmtPriVteStock=='2'}">
                                            <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                            <h:outputText value="#{docrec.chaligTtc}" rendered="#{docrec.chaligTtc!=0}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </c:if>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Facturation" id="tabFacturation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_complement&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==4)}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationFacturation}" reRender="panFacturation"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="panFacturation" style="background-color:#DAEECB;" width="100%" >
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonFacture">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle facture" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ajouterFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_ajt&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelFacturation,panelBoutonFacture" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/bonCaisse.png" title="Règlement ou acompte facture" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.payeDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_affiche_dollar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facId!=0}" reRender="panelPaye,formModalPaye"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la facture sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.supprimerFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_sup&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonFacture,tableFacture"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/print.png" title="Imprimer la facture sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.initImprimerFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facId!=0}" reRender="panelImpFacture,formModalImp,panchoixdoc,panelMail"/>
                            </h:panelGroup>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableFacture" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelFacture}" var="fac">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionnerFacture}" reRender="panelBoutonFacture"/>
                                    <rich:column label="N° facture" sortable="true" sortBy="#{fac.facNum}" width="7%">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{fac.facNum}"/>
                                    </rich:column>
                                    <rich:column label="Date facture" sortable="true" sortBy="#{fac.facDate} #{fac.facNum}" width="7%">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{fac.facDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{fac.facSerie}" style="text-align:center;" width="5%">
                                        <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                        <h:outputText value="#{fac.facSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{fac.facCat}" width="5%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                        <h:outputText value="#{fac.facCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{fac.facEtat}" width="5%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                        <h:outputText value="#{fac.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{fac.var_nom_tiers}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                        <h:outputText  value="#{fac.var_nom_tiers}  #{fac.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Objet" sortable="true" sortBy="#{fac.facObject}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Objet"  /></f:facet>
                                        <h:outputText  value="#{fac.facObject}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{fac.facTotHt}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                        <h:outputText  value="#{fac.facTotHt}" rendered="#{fac.facTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{fac.facTotTva}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{fac.facTotTva}" rendered="#{fac.facTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{fac.varTotTtcGlob}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{fac.varTotTtcGlob}" rendered="#{fac.varTotTtcGlob!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Règlements" sortable="true" sortBy="#{fac.facTotReglement}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                        <h:outputText  value="#{fac.facTotReglement}" rendered="#{fac.facTotReglement!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Avoir" id="tabAvoir" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_complement&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==4)}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationAvoir}" reRender="panAvoir"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="panAvoir" style="background-color:#DAEECB;" width="100%" >
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonAvoir">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvel avoir" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ajouterAvoir}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_ajt&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" reRender="panelAvoir,panelBoutonAvoir"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer l'avoir en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.supprimerAvoir}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_sup&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonAvoir,tableAvoir"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.initImprimerAvoir}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobId!=0}" reRender="panelImpAvoir,formModalImp,panchoixdoc,panelMail"/>
                            </h:panelGroup>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableAvoir" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelAvoir}" var="avr">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionnerAvoir}" reRender="panelBoutonAvoir"/>
                                    <rich:column label="N° avoir" sortable="true" sortBy="#{avr.avrNum}" width="10%">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{avr.avrNum}"/>
                                    </rich:column>
                                    <rich:column label="Date avoir" sortable="true" sortBy="#{avr.avrDate} #{avr.avrNum}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{avr.avrDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{avr.avrSerie}" style="text-align:center;" width="5%">
                                        <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                        <h:outputText value="#{avr.avrSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{avr.facCat}" width="5%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                        <h:outputText value="#{fac.avrCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{avr.avrEtat}" width="5%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                        <h:outputText value="#{avr.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{avr.var_nom_tiers}" width="25%">
                                        <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                        <h:outputText  value="#{avr.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{avr.avrTotHt}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                        <h:outputText  value="#{avr.avrTotHt}" rendered="#{avr.avrTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{avr.avrTotTva}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{avr.avrTotTva}" rendered="#{avr.avrTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{avr.varTotTtcGlob}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{avr.varTotTtcGlob}" rendered="#{avr.varTotTtcGlob!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Règlements" sortable="true" sortBy="#{avr.avrTotReglement}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                        <h:outputText  value="#{avr.avrTotReglement}" rendered="#{avr.avrTotReglement!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Déchargement" id="tabDechargement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_complement&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==4)}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeDechargement}" reRender="panDechargement" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp"/>
                    <h:panelGrid id="panDechargement" style="background-color:#DAEECB;" width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonDechargement" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouveau produit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ajouterProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_ajt}" reRender="panelNouveauProduit,panelBoutonDechargement"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.suppressionNouveauProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibiliteBtonDechargement}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableDechargement,panelBoutonDechargement"/>
                            </h:panelGroup>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableDechargement" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelDechargement}" var="ret">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionnerDechargement}" reRender="panelBoutonDechargement"/>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText value="#{ret.chaligCode}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{ret.chaligLibelle}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Qté Chargée"/></f:facet>
                                        <h:outputText value="#{ret.chaligQteCharg}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Qté Facturée"/></f:facet>
                                        <h:outputText value="#{ret.chaligQteFacture}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Qté Don"/></f:facet>
                                        <h:outputText value="#{ret.chaligQteDon}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Qté Avoir"/></f:facet>
                                        <h:outputText value="#{ret.chaligQteAvoir}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Ecart Usine"/></f:facet>
                                        <h:inputText value="#{ret.chaligQteManquant}" style="width:90%;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idEcart"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Qté Reprise"/></f:facet>
                                        <h:inputText value="#{ret.chaligQteReprise}" style="width:90%;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idEcart"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Défectueux"/></f:facet>
                                        <h:inputText value="#{ret.chaligQteDefectueux}" style="width:90%;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idEcart"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Non conforme"/></f:facet>
                                        <h:inputText value="#{ret.chaligQteNconforme}" style="width:90%;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idEcart"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Périmée"/></f:facet>
                                        <h:inputText value="#{ret.chaligQtePerime}" style="width:90%;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idEcart"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Qté Retour"/></f:facet>
                                        <h:inputText value="#{ret.chaligQteRetour}" style="width:90%;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idEcart"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column id="idEcart" sortable="false" style="text-align:right" width="7%" >
                                        <f:facet name="header"><h:outputText  value="Ecart final"/></f:facet>
                                        <h:outputText value="#{ret.chaligQteEcart}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Frais" id="tabFrais" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_etat&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==4)}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationDre}" reRender="panFrais"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="panFrais"  style="background-color:#DAEECB;" width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonFrais" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouveau frais" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.ajouterFrais}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_ajt}" reRender="panelFrais,panelBoutonFrais"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/modifier.png" title="Modifier le frais en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.modifierFrais}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementFrais.chafraId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_mod}" reRender="panelFrais,panelBoutonFrais"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer le frais en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.supprimerFrais}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementFrais.chafraId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelLigneR,tableLigneR,panelBoutonLigneR"/>
                            </h:panelGroup>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableFrais" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelFrais}" var="fra">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionnerFrais}" reRender="panelBoutonFrais"/>
                                    <rich:column label="Date frais" sortable="true" sortBy="#{fra.chafraDate}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{fra.chafraDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Code frais" sortable="true" sortBy="#{fra.chafraCode}" style="text-align:center;" width="10%">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{fra.chafraCode}"/>
                                    </rich:column>
                                    <rich:column label="Libellé frais" sortable="true" sortBy="#{fra.chafraLibelle}" width="20%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                        <h:outputText value="#{fra.chafraLibelle}"/>
                                    </rich:column>
                                    <rich:column label="N° pièce" sortable="true" sortBy="#{fra.chafraPiece}" width="20%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Pièce" /></f:facet>
                                        <h:outputText value="#{fra.chafraPiece}"/>
                                    </rich:column>
                                    <rich:column label="Description" sortable="true" sortBy="#{fra.chafraDescription}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Description"  /></f:facet>
                                        <h:outputText  value="#{fra.chafraDescription}"/>
                                    </rich:column>
                                    <rich:column label="Montant frais" sortable="true" sortBy="#{fra.chafraMontant}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                                        <h:outputText  value="#{fra.chafraMontant}" rendered="#{fra.chafraMontant!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Note débit" id="tabNoteDebit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_complement&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==4)}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationNoteDebit}" reRender="panNoteDebit"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="panNoteDebit" style="background-color:#DAEECB;" width="100%" >
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonNoteDebit">
                                <a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.initImprimerNoteDebit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.noteDebitEnteteVentes.ndbId!=0}" reRender="panelImpNoteDebit,formModalImp,panchoixdoc,panelMail"/>
                            </h:panelGroup>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableNoteDebit" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.dataModelNoteDebit}" var="ndb">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionnerNoteDebit}" reRender="panelBoutonNoteDebit"/>
                                    <rich:column label="N° facture" sortable="true" sortBy="#{ndb.ndbNum}" width="7%">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{ndb.ndbNum}"/>
                                    </rich:column>
                                    <rich:column label="Date facture" sortable="true" sortBy="#{ndb.ndbDate} #{ndb.ndbNum}" width="7%">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{ndb.ndbDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{ndb.ndbSerie}" style="text-align:center;" width="5%">
                                        <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                        <h:outputText value="#{ndb.ndbSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{ndb.ndbCat}" width="5%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                        <h:outputText value="#{ndb.ndbCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{ndb.ndbEtat}" width="5%" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                        <h:outputText value="#{ndb.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{ndb.var_nom_tiers}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                        <h:outputText  value="#{ndb.var_nom_tiers}  #{ndb.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Objet" sortable="true" sortBy="#{ndb.ndbObject}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Objet"  /></f:facet>
                                        <h:outputText  value="#{ndb.ndbObject}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{ndb.ndbTotHt}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotHt}" rendered="#{ndb.ndbTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{ndb.ndbTotTva}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotTva}" rendered="#{ndb.ndbTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{ndb.varTotTtcGlob}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{ndb.varTotTtcGlob}" rendered="#{ndb.varTotTtcGlob!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Règlements" sortable="true" sortBy="#{ndb.ndbTotReglement}" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotReglement}" rendered="#{ndb.ndbTotReglement!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_etat}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.autorisationEtat}" reRender="panEtat"/>
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <h:panelGrid id="idPanEtat" columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="ID CHARGEMENT:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobNomUserCreat}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobUserCreat}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobNomUserModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobUserModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="6"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_acc_tracabilite}">
                    <jsp:include flush="true" page="/ventes/ChargementCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargerDocumentTrace}" reRender="panTrace"/>
                    <a4j:region renderRegionOnly="false" id="panTrace">
                        <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
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
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annule}"  />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_valide_doc}" reRender="panelValidationDocument"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du commercial sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelHistoriqueProduit" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="990" height="560" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelHistorique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelHistorique}" var="his">
            <jsp:include flush="true" page="/ventes/ChargementHistorique.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelLot" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelLot}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelLot}" var="lot">
            <f:facet name="header"><h:outputText value="Sélection du lot"/></f:facet>
            <a4j:form id="formModalLot">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="4" columnClasses="clos30,clos70">
                        <h:column><h:outputText value="Quantité démandée:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQte}" style="text-align:right;" readonly="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Unité:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligUnite}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Conditionnement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligCondition}" readonly="true"/></h:column>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=199}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=299}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Largeur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLarg}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=399}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Largeur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLarg}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Hauteur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligHaut}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=499}">
                            <h:column><h:outputText value="Longueur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLong}" style="text-align:right;" size="8" readonly="true"/></h:column>
                            <h:column><h:outputText value="Diamêtre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligDiam}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=849}">
                            <h:column><h:outputText value="Nombre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligNb}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=899}">
                            <h:column><h:outputText value="Pression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligNb}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        </h:panelGroup>
                        <h:column><h:outputText value="Poids brut:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligPoidsBrut}" style="text-align:right;" size="8" readonly="true"/></h:column>
                        <h:column><h:outputText value="Poids net:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligPoidsNet}" style="text-align:right;" size="8" readonly="true"/></h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableLot" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.dataModelLot}" var="lot">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionLot}" reRender="vallot"/>
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
                            <rich:column label="Date de péremption" sortable="true" sortBy="#{lot.reclotDateValable}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligStock==5}">
                                <f:facet name="header"><h:outputText  value="Périme le" /></f:facet>
                                <h:outputText value="#{lot.reclotDateValable}"/>
                            </rich:column>
                            <rich:column label="Longueur" sortable="true" sortBy="#{prd.var_LongDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=499}">
                                <f:facet name="header"><h:outputText  value="Longueur" /></f:facet>
                                <h:outputText value="#{prd.var_LongDispo}"/>
                            </rich:column>
                            <rich:column label="Largeur" sortable="true" sortBy="#{prd.var_LargDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=499}">
                                <f:facet name="header"><h:outputText  value="Largeur" /></f:facet>
                                <h:outputText value="#{prd.var_LargDispo}"/>
                            </rich:column>
                            <rich:column label="Hauteur" sortable="true" sortBy="#{prd.var_HautDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=399}">
                                <f:facet name="header"><h:outputText  value="Hauteur" /></f:facet>
                                <h:outputText value="#{prd.var_HautDispo}"/>
                            </rich:column>
                            <rich:column label="Diamêtre" sortable="true" sortBy="#{prd.var_DiamDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=499}">
                                <f:facet name="header"><h:outputText  value="Diamêtre" /></f:facet>
                                <h:outputText value="#{prd.var_DiamDispo}"/>
                            </rich:column>
                            <rich:column label="Nombre" sortable="true" sortBy="#{prd.var_NbDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=849}">
                                <f:facet name="header"><h:outputText  value="Nombre" /></f:facet>
                                <h:outputText value="#{prd.var_NbDispo}"/>
                            </rich:column>
                            <rich:column label="Pression" sortable="true" sortBy="#{prd.var_NbDispo}" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_code_unite<=899}">
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
                        <a4j:commandButton id="idCanLot" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.fermetureLot}" reRender="panelLot"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValLot" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validationLot}" reRender="panelLot,tableLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_validation_lot}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelSerie" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="990" height="560" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelSerie}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelSerie}" var="ser">
            <f:facet name="header"><h:outputText value="Sélection du N° de série"/></f:facet>
            <a4j:form id="formModalSerie">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_select_type}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_type_serie}">
                            <f:selectItem itemLabel="Choisir le type de série" itemValue="0"/>
                            <f:selectItem itemLabel="Séries disponibles" itemValue="1"/>
                            <f:selectItem itemLabel="Séries disponibles par carton" itemValue="2"/>
                            <f:selectItem itemLabel="Séries disponibles par palette" itemValue="3"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.typeSerie}" reRender="idPanSerie,tableSerie,valSerie"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="idPanSerie" width="100%">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_type_serie==2}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_select_carton}">
                            <f:selectItem itemLabel="Sélectionnez le carton" itemValue="null"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesCartonsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargerSerieByCarton}" reRender="tableSerie,valSerie"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_type_serie==3}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_select_palette}">
                            <f:selectItem itemLabel="Sélectionnez la palette" itemValue="null"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesPalettesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargerSerieByPalette}" reRender="tableSerie,valSerie"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableSerie" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.dataModelSerie}" var="serie">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.selectionSerie}" reRender="valSerie"/>
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
                        <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.serieToutSelectionne}" reRender="tableSerie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_liste_vide}"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Rien sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.serieRienSelectionne}" reRender="tableSerie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_liste_vide}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idCanSerie" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.fermetureSerie}" reRender="panelSerie"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValSerie" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validationSerie}" reRender="panelSerie,tableLigne,panelLigne,panelBoutonLigne,panelTotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_liste_vide}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobActivite}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_parc}"><h:outputText value="Parc:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_anal_parc}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobAnal2}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesParcsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobObjet}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Poids:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobPoids}" style="text-align:right"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>

                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" id="idValdocument">

                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Modèle impression:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementEntete.chamobModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelFacturation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelFacturation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelFacturation}" var="docfac">
            <jsp:include flush="true" page="/ventes/ChargementFacture.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpFacture" headerClass="headerPanel"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPrintFacture}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPrintFacture}" var="prt">
            <jsp:include flush="true" page="/ventes/ChargementImpression.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="800" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="Paiement du document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalPaye">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.bonEncaissementVente.bonDate}" readonly="true"/></h:column>
                    <h:column><h:outputText value="N°:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facNum}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:panelGroup>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facSerie}" size="2" readonly="true"/>
                            <h:outputText value="Devise:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facDevise}" size="3" readonly="true"/>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Client:" style="text-decoration:underline;width:100%"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facNomTiers}" readonly="true"/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_verouxModReg}">
                            <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                            <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                            <f:selectItem itemLabel="Demande autorisation crédit" itemValue="5"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargerModReg}" reRender="firstgridd,colMontInput"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_inputCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_aff_action}">
                            <f:selectItem  itemValue="0" itemLabel="Sélectionnez une caisse"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCaissesItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.choixCaisse}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_affichMontant}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.verifBonEncaissement}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:outputText value="Echéance reliquat:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facEcheanceReliquat}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_verouxModReg}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:outputText value="Observation parapheur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facMotifRejetCredit}" readonly="true"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.factureEnteteVentes.facTypeReg==5}"><h:outputText value=""/></h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_affiche_valide}" reRender="panelPaye,panelBouton"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="../images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAvoir" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelAvoir}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelAvoir}" var="docavr">
            <jsp:include flush="true" page="/ventes/ChargementAvoir.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpAvoir" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPrintAvoir}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPrintAvoir}" var="prt">
            <jsp:include flush="true" page="/ventes/ChargementImpression.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpNoteDebit" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPrintNoteDebit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelPrintNoteDebit}" var="prt">
            <jsp:include flush="true" page="/ventes/ChargementImpression.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelFrais" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="350" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelFrais}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelFrais}" var="fra">
            <f:facet name="header"><h:outputText value="Gestion des frais"/></f:facet>
            <a4j:form id="formModalFrais">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="idFrais" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date frais:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementFrais.chafraDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Frais:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.var_frais}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.mesProduitsFrais}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Pièce:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementFrais.chafraPiece}" maxlength="20"/></h:column>
                    <h:column><h:outputText value="Description:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementFrais.chafraDescription}" maxlength="100" size="40"/></h:column>
                    <h:column><h:outputText value="Montant:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementFrais.chafraMontant}" style="width:150px;text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valfrais">
                    <center>
                        <a4j:commandButton id="idCanFrais" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annulerFrais}" reRender="panelFrais"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValFrais" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validerFrais}" reRender="panelFrais,tableFrais"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelLivraisonDirecte" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelLivraison}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelLivraison}" var="liv">
            <f:facet name="header"><h:outputText value="Livraison directe"/></f:facet>
            <a4j:form id="formModalLivraisonDirecte">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText value="Quantité demandée:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteDem}" readonly="true">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Quantité livrée:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteCharg}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanLiv" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.fermerLivriaison}" reRender="panelLivraisonDirecte"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValLiv" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validerLivraisonDirecte}" reRender="panelLivraisonDirecte,tableLigne,idQteLiv,panelTotal"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelEclatement" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelEclatement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelEclatement}" var="ecl">
            <f:facet name="header"><h:outputText value="Eclatement des produits génériques"/></f:facet>
            <a4j:form id="formModalEclatement">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" columnClasses="clos30,clos70" width="100%">
                    <h:column><h:outputText value="Produit générique:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLibelle}" readonly="true" style="width:100%"/></h:column>
                    <h:column><h:outputText value="Quantité demandée:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteDem}" readonly="true" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid id="idPanGlobalEclatement" width="100%">
                    <h:panelGrid width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable styleClass="bg" id="tableLigneEclatement" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.dataModelEclatement}" var="eclt">
                                <rich:column label="Code générique" sortable="true" sortBy="#{eclt.chaligReference}" width="20%">
                                    <f:facet name="header"><h:outputText value="Générique" /></f:facet>
                                    <h:outputText value="#{eclt.chaligReference}"/>
                                </rich:column>
                                <rich:column label="Code produit" sortable="true" sortBy="#{eclt.chaligCode}" width="20%">
                                    <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                    <h:outputText value="#{eclt.chaligCode}"/>
                                </rich:column>
                                <rich:column label="Libellé produit" sortable="true" sortBy="#{eclt.chaligLibelle}" width="40%">
                                    <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                                    <h:outputText value="#{eclt.chaligLibelle}"/>
                                </rich:column>
                                <rich:column label="Quantité chargée" sortable="true" sortBy="#{eclt.chaligQteCharg}" width="20%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Qte"/></f:facet>
                                    <h:inputText value="#{eclt.chaligQteCharg}" style="width:90%;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.totalEclatement}" reRender="idPanGlobalEclatement,idTotalEclatement,validationEclatement"/>
                                    </h:inputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <h:panelGrid id="idTotalEclatement" columns="2" columnClasses="clos30,clos70" width="100%">
                        <h:column><h:outputText value="Total chargé:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.total_eclatement}" readonly="true" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Ecart:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.total_ecart}" readonly="true" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup id="validationEclatement">
                        <center>
                            <a4j:commandButton id="idCanEcl" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.fermerLivriaison}" reRender="panelEclatement"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValEcl" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validerEclatement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEclatement,tableLigne,panelTotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.total_ecart>=0}"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelNouveauProduit" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="350" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelProduit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.showModalPanelProduit}" var="prd">
            <f:facet name="header"><h:outputText value="Nouveau produit"/></f:facet>
            <a4j:form id="formModalProduit">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="idProduit" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Code" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligCode}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idProduit"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libéllé"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligLibelle}" style="width:100%" readonly="true"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid id="idProduitSuite" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                    <h:column><h:outputText  value="Qté Reprise"/></h:column>
                    <h:column>
                        <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteReprise}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idProduitSuite,idEcart"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText  value="Défectueux"/></h:column>
                    <h:column>
                        <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteDefectueux}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idProduitSuite,idEcart"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText  value="Non conforme"/></h:column>
                    <h:column>
                        <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteNconforme}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idProduitSuite,idEcart"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText  value="Périmée"/></h:column>
                    <h:column>
                        <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQtePerime}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idProduitSuite,idEcart"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText  value="Qté Retour"/></h:column>
                    <h:column>
                        <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteRetour}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.calculeEcart}" reRender="idProduitSuite,idEcart"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText  value=""/></h:column>
                    <h:column><h:outputText  value=""/></h:column>
                    <h:column><h:outputText  value="Ecart final"/></h:column>
                    <h:column>
                        <h:inputText size="8" id="idEcart" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.chargementLigne.chaligQteEcart}" style="text-align:right;" readonly="true">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.optionsVentes.nbDecQte}"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valProduit">
                    <center>
                        <a4j:commandButton id="idCanProduit" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.fermerProduit}" reRender="panelNouveauProduit"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValProduit" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.validerProduit}" reRender="panelNouveauProduit,tableDechargement"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
