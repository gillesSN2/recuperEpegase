<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="reacheminementfiche">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES REACHEMINEMENTS"  style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Annonces" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_document}" >
                        <h:panelGrid id="panDescription" width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid id="panelEnetete" width="100%" style="background-color:#DAEECB;height:110px">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_date}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateAch==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Type:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:35%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTypeMarchandise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}">
                                            <f:selectItem itemLabel="Vrac" itemValue="0"/>
                                            <f:selectItem itemLabel="Sac" itemValue="1"/>
                                            <f:selectItem itemLabel="Colis" itemValue="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelLigne"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom transporteur:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:70%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les fournisseurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="N° Annonce:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaNumAnnonce}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="Nom Navire:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaNomBateau}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}"/></h:column>
                                </h:panelGrid>
                                <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.informationsTiers!=null}">
                                    <center>
                                        <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                    </center>
                                </h:panelGroup>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="Contact:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversTiers!=99}"/>
                                        <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversTiers==99}"/>
                                    </h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}"/>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.mesUsersItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText id="idObjet" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelReception" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value=""/></h:column>
                                    <a4j:commandButton title="Sélectionnez Réception(s)" value="Réception(s)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.ouvrirSelection}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaId!=0}" reRender="panelReception,panelSelectionReception"/>
                                    <h:column><h:outputText value="N° Dossier:"/></h:column>
                                    <h:column><h:inputText id="idDossier" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaAnal4}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Nb Camions:"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCamion" style="width:100%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTotNbCamion}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTotNbCamion!=0}">
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.genereCamion}" reRender="panDescription,tableLigne,panelLigne,idCamion"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversTiers==99}">
                                    <h:column><h:outputText value="Adresse:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Mail:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:140px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Poids Brut:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.totauxBrut}" readonly="true"/>
                                </h:column>
                                <h:column><h:outputText value="Poids Net:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.totauxNet}" readonly="true"/>
                                </h:column>
                                <h:column><h:outputText value="Nb Sac:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.totauxSac}" readonly="true"/>
                                </h:column>
                                <h:column><h:outputText value="Nb Camion:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.totauxCamion}" readonly="true"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;height:40px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.affiche_ligne}">
                                <h:panelGrid width="100%" columns="7">
                                    <h:column>
                                        <h:outputText value="Date chargement:"/><br>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementLigneAchats.realigOrigDate}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Produit:"/><br>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementLigneAchats.realigIdRec}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}">
                                            <f:selectItem itemLabel="Sélectionnez produit" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.mesReceptionsLignesItems}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.calculeSelectionLigneReception}" reRender="panelLigne"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Dépôt:"/><br>
                                        <h:inputText size="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementLigneAchats.realigOrigDepot}" readonly="true" disabled="true"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Nb Sac:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTypeMarchandise!=2}"/>
                                        <h:outputText value="Nb Colis:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTypeMarchandise==2}"/><br>
                                        <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementLigneAchats.realigOrigNbSac}" style="text-align:right" >
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.calculPoidsNet}" reRender="panelLigne"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Poids Brut:"/><br>
                                        <h:inputText size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementLigneAchats.realigOrigPoidsBrut}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTypeMarchandise==1}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.calculPoidsNet}" reRender="panelLigne"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Poids Net:"/><br>
                                        <h:inputText size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementLigneAchats.realigOrigPoidsNet}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaTypeMarchandise!=1}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.calculPoidsNet}" reRender="panelLigne"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.saveOneLigneAnnonce}" reRender="panelPage,panelTotal,idPanelLigne,tableLigne"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigne" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="max-height:100%;margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.datamodelLigne}" var="doclig">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.selectionLigneDetail}" reRender="panelLigne"/>
                                    <rich:column label="N° réception" sortable="true" sortBy="#{doclig.realigOrdre}">
                                        <f:facet name="header"><h:outputText  value="N° ordre" /></f:facet>
                                        <h:outputText value="#{doclig.realigOrdre}"/>
                                    </rich:column>
                                    <rich:column label="Date chargement" sortable="true" sortBy="#{doclig.realigOrigDate}" width="100px">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{doclig.realigOrigDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Produits" sortable="true" sortBy="#{doclig.realigCode}" width="300px">
                                        <f:facet name="header"><h:outputText  value="Produit" /></f:facet>
                                        <h:outputText value="#{doclig.realigCode} #{doclig.realigLibelle}"/>
                                    </rich:column>
                                    <rich:column label="Dépôt" sortable="true" sortBy="#{doclig.realigOrigDepot}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Dépôt" /></f:facet>
                                        <h:outputText value="#{doclig.realigOrigDepot}"/>
                                    </rich:column>
                                    <rich:column label="Poids Brut" sortable="true" sortBy="#{doclig.realigOrigPoidsBrut}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Poids Brut" /></f:facet>
                                        <h:outputText value="#{doclig.realigOrigPoidsBrut}"/>
                                    </rich:column>
                                    <rich:column label="Nombre Sac" sortable="true" sortBy="#{doclig.realigOrigNbSac}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Sac" /></f:facet>
                                        <h:outputText value="#{doclig.realigOrigNbSac}"/>
                                    </rich:column>
                                    <rich:column label="Poids Net" sortable="true" sortBy="#{doclig.realigOrigPoidsNet}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Poids Net" /></f:facet>
                                        <h:outputText value="#{doclig.realigOrigPoidsNet}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_complement}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.autorisationComplement}" reRender="panCompl"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />

                    </rich:tab>

                    <rich:tab label="Frontière" id="tabFrontiere" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_special}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.autorisationSpecial}" reRender="panLivraison"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />

                    </rich:tab>

                    <rich:tab label="Livraison" id="tabLivraison" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_special}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.autorisationSpecial}" reRender="panLivraison"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />

                    </rich:tab>

                    <rich:tab label="Documents" id="tabScan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_special}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.autorisationSpecial}" reRender="panLivraison"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />

                    </rich:tab>

                    <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_habilitation}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.autorisationHabilitation}" reRender="panHabilitation"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid id="panHabilitation" style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser1Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser2Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser3Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser4Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser5Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser6Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_acc_etat}" >
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.autorisationEtat}" reRender="panEtat"/>
                        <jsp:include flush="true" page="/achats/ReceptionCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                            <h:column><h:outputText value="ID RECEPTION:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de relance:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateRelance}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de validité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateValidite}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                    <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                    <f:selectItem itemLabel="Correction" itemValue="6"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de transformation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateTransforme}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaMotifAnnule}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du fournisseur sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>

    <rich:modalPanel domElementAttachment="parent"  id="panelSelectionReception" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="490" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelReception}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelReception}" var="reclst">
            <f:facet name="header"><h:outputText value="Sélection des réceptions"/></f:facet>
            <a4j:form id="formModalReception">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" columns="5">
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.receptionDu}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.receptionAu}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                    <a4j:commandButton title="Rechercher Réception(s)" value="Rechercher Réception(s)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.selectionReception}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableReception"/>
                </h:panelGrid>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableReception" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.dataModelReceptions}" var="var">
                        <rich:column label="Sélection" sortable="true" sortBy="#{var.var_select_ligne}" width="50px">
                            <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}"/>
                        </rich:column>
                        <rich:column label="N° réception" sortable="true" sortBy="#{var.recNum}">
                            <f:facet name="header"><h:outputText  value="N° REC" /></f:facet>
                            <h:outputText value="#{var.recNum}"/>
                        </rich:column>
                        <rich:column label="N° dossier" sortable="true" sortBy="#{var.recAnal4}" filterBy="#{var.recAnal4}">
                            <f:facet name="header"><h:outputText  value="N° DOS." /></f:facet>
                            <h:outputText value="#{var.recAnal4}"/>
                        </rich:column>
                        <rich:column label="Date réception" sortable="true" sortBy="#{var.recDate} #{var.recNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.recDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Incoterm" sortable="true" sortBy="#{var.recIncoterm}" width="50px">
                            <f:facet name="header"><h:outputText  value="Inc." /></f:facet>
                            <h:outputText value="#{var.recIncoterm}"/>
                        </rich:column>
                        <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px" filterBy="#{var.var_nom_tiers}">
                            <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Quantité totale" sortable="true" sortBy="#{var.recTotQte}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                            <h:outputText value="#{var.recTotQte}" rendered="#{var.recTotQte!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.recObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText  value="#{var.recObject}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanReception" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.fermerSelection}" reRender="panelSelectionReception"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValReception" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.validerSelection}" reRender="panelSelectionReception,idDossier"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
