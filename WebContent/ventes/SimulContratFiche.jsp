<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="simulfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES SIMULATIONS DES CONTRATS" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Simulation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.autorisationDocument}">
                    <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                        <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:panelGrid width="100%" columns="4">
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.controleSaisie}"/>
                                </rich:calendar>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_heure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" style="width:45px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                </h:selectOneMenu>
                                <h:column><h:outputText value=":"/></h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_minute}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" style="width:45px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                            <h:column><h:outputText value="N°:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtNum}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtId!=0}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesSerieUserItem}"/>
                                </h:selectOneMenu>&nbsp;&nbsp;
                                <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesdevisesItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                            <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                            <h:column>
                                <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelLigne"/>
                                </h:inputText>&nbsp;
                                <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" reRender="panelTiers"/>
                            </h:column>
                            <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,idCat,idSerie,panelTotal,tableLigne,panelLigne2,panelTiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recupererEltCat}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.informationsTiers!=null}">
                                <center>
                                    <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                </center>
                            </h:panelGroup>
                        <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                            <h:column>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTiers==0}"/>
                                <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTiers==99}"/>
                            </h:column>
                            <h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.contDest=='false'}">
                                    <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesContactItem}"/>
                                    </h:selectOneMenu>&nbsp;
                                    <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.contDest=='true'}">
                                    <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtNomContact}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeDestinataire,formModalListeDestinataire,panelContact,idDestinataire" />
                                    </h:inputText>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTiers==99}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                </c:if>
                            </h:column>
                            <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                            <h:column id="idResponsable">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action)==true}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesUsersItem}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTiers==99}">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Téléphone:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Mail:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>

                    </h:panelGrid>
                    <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_mod}">
                        <h:panelGrid  columns="6" width="100%" id="panelLigne1" columnClasses="clos15g,clos15g,clos15g,clos35,clos5c,clos15g">
                            <h:column id="panelcontrat">
                                <h:outputText value="Contrat"/>
                                <h:selectOneMenu tabindex="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTypeContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.griserchamps}" style="width:100%">
                                    <f:selectItem itemLabel="Sélection Contrat" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesTypeContratItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculContrat}" reRender="panelLigne"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:outputText value="Marque"/>
                                <h:selectOneMenu tabindex="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtMarque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.griserchamps}" style="width:100%">
                                    <f:selectItem itemLabel="Sélection Marque" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesMarquesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recupererGamme}" reRender="panelLigne"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:outputText value="Gamme"/>
                                <h:selectOneMenu tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtGamme}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.griserchamps}" style="width:100%">
                                    <f:selectItem itemLabel="Sélection Gamme" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesGammesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recupererProduit}" reRender="panelLigne"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:outputText value="Modèle"/>
                                <h:selectOneMenu tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_code_produit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.griserchamps}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesProduitsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculProduit}" reRender="panelLigne"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column id="idTva" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtExoTva==0}">
                                <h:outputText value="Taxe"/>
                                <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.griserchamps}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesTaxesVentesProduits}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtId==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_sansstock}">
                                <h:outputText value="Stock"/>
                                <h:selectOneMenu id="idDepot" tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_depotProd}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.mesProduitsDepotsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" width="100%" id="panelLigne2" columnClasses="clos50d,clos50d">
                            <h:panelGrid columns="3" width="100%" id="panelLigne3" columnClasses="clos50d,clos30,clos20" border="0">
                                <h:column><h:outputText value="Coef. Remise"/></h:column>
                                <h:column><h:outputText value="%"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxRemise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.verrouRemRab}" style="width:80%;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modAccessoire=='1'}"><h:outputText value="Accessoires:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modAccessoire=='1'}"><h:outputText value="(montant des accessoires)"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modAccessoire=='1'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAccessoire}" style="width:98%;text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modAcompte=='1'}"><h:outputText value="Acompte:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modAcompte=='1'}"><h:outputText value="(acompte versé)"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modAcompte=='1'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAcompte}" style="width:98%;text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modValeurResiduelle=='1'}"><h:outputText value="Valeur résiduelle:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modValeurResiduelle=='1'}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtValeurResiduelleTheo} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxValeurResiduelle} %)"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.modelesCourriers.modValeurResiduelle=='1'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtValeurResiduelleReelle}" style="width:98%;text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Durée du crédit:"/></h:column>
                                <h:column><h:outputText value="( nb mois mini. #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDureeMin} maxi. #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDureeMax})"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtNbMois}" style="width:80%;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Cumul des échéances:"/></h:column>
                                <h:column><h:outputText value="(total des échéances)"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtCumulEcheance}" style="width:98%;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prix de vente véhicule:"/></h:column>
                                <h:column><h:outputText value="(H.T.)"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTotHt}" style="width:98%;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prix de vente véhicule:"/></h:column>
                                <h:column><h:outputText value="(H.T.)"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTotHt}" style="width:98%;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="T.V.A:"/></h:column>
                                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxTaxe} %"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTotTva}" style="width:98%;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Loyer mensuel H.T.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtThMois}" style="width:98%;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Loyer mensuel T.T.C.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTtMois}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="panelLigne4" columns="3" columnClasses="clos50d,clos12d,clos35" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAffPump !=0}">
                                <h:column rendered="false"><h:outputText value="Prix de revient comptable (PRC):"/></h:column>
                                <h:column rendered="false"><h:outputText value=""/></h:column>
                                <h:column rendered="false">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtPrc}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prix de revient global (PRG):"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtPrg}" style="width:98%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Amortissement:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxAmortissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2,panelLigne4"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAmortissement}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais financiers:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxFraisFinancier}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtFraisFinancier}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Contrat entretien:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxEntretien}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtEntretien}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Assurance tous risques:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxAssurance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAssurance}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Risque + franchise:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxFranchise}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtFranchise}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais structure:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxFraisStructure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtFraisStructure}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Véhicule remplacement:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxRemplacement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtRemplacement}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Pondération taux remplissage:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxRemplissage}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtRemplissage}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prix de revient:"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtPr}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Valeur résiduelle client"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtTauxValeurResiduelle}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump==1}" style="width:100px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.calculSimulation}" reRender="panelLigne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtValeurResiduelleReelle}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Valeur dossier:"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtValeurRachat}" style="width:98%;text-align:right;"readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/SimulContratCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Site:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtSite}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDepartement}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Service:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtService}" size="100" readonly="true"/></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Région:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtRegion}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Secteur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtSecteur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Point de vente:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtPdv}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_anal_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.contDest=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_anal_dossier}">
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAnal4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}"/>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.autorisationComplement}">
                    <jsp:include flush="true" page="/ventes/SimulContratCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib3ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Formule 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesIncotermesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Lieu livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Date livraison:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Info livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Lettre accompagnement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtGarde}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.pageGardeItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Annexe 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAnnexe1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}">
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Annexe 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtAnnexe2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" >
                                <f:selectItem itemLabel=" " itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.annexItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_acc_habilitation}">
                    <jsp:include flush="true" page="/ventes/SimulContratCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.autorisationEtat}">
                    <jsp:include flush="true" page="/ventes/SimulContratCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID simulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé" itemValue="4"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.simulationEnteteVentes.simcrtMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.autorisationTracabilite}">
                    <jsp:include flush="true" page="/ventes/SimulContratCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
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
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annule}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_aff_action}" />
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

</f:subview>
