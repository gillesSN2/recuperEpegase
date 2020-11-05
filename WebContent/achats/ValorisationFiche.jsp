<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="subdevajout">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES VALORISATIONS DES DOSSIERS" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true"  id="rtabpanel" style="border:0px;">

                <rich:tab id="tabdescrip" label="Valorisation">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationDocument}" reRender="panelGlobal"/>
                    <h:panelGrid id="panelGlobal" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column>
                            <rich:calendar id="datajt"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateAch==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange"  reRender="prgtpAjt,outptcltAjt,link8Ajt,inptdatechce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.controleSaisie}"/>
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNum}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText value="Mode:" style="text-decoration:underline;"/>&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valMode}">
                                <f:selectItem itemLabel="Maritime" itemValue="0"/>
                                <f:selectItem itemLabel="Aérien" itemValue="1"/>
                                <f:selectItem itemLabel="Express" itemValue="2"/>
                                <f:selectItem itemLabel="Routier" itemValue="3"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="grpCnt"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Dossier transit:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDossierTransit}"/></h:column>
                        <h:column><h:outputText value="N° D.P.I.:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDpi}" maxlength="50"/></h:column>
                        <h:column><h:outputText value="Devise (douane)" style="text-decoration:underline;"/></h:column>
                        <h:column>               
                            <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesdevisesItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.calculDevise}" reRender="idCoefDev" />
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText value="Coef."/>&nbsp;
                            <h:inputText id="idCoefDev" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valCoefDeviseDouane}" style="text-align:right;width:30%"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Réf. Crédoc:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valRefCredoc}"/></h:column>
                        <h:column><h:outputText value="Date intention:"/></h:column>
                        <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDateIntention}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Péremption intention:"/></h:column>
                        <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDateIntentionFin}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="grpCnt" style="background-color:#DAEECB;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Lieu chargement:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPortChargement}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valMode==0}"><h:outputText value="Bateau:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valMode==0}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNomBateau}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valMode!=0}"><h:outputText value="L.T.A."/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valMode!=0}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valLta}" maxlength="50"/></h:column>
                        <h:column><h:outputText value="Date chargement:"/></h:column>
                        <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDateChargement}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Lieu déchargement:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPortDechargement}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Coef. forfait transport:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valCoefForfaitTransport}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Date déchargement:"/></h:column>
                        <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDateDechargement}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panTiers" style="background-color:white;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Assureur:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%" id="idAssureur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNomAssureur}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les assureurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheAssureur}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,panTiers,idAssureur"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Transitaire:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%" id="idTransitaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNomTransitaire}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les transitaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheTransitaire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,panTiers,idTransitaire"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Transporteur:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%" id="idtransporteur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNomTransporteur}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les transporteurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheTransporteur}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,panTiers,idtransporteur"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:white;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Date arrivée:"/></h:column>
                        <h:column>
                            <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDateArrivee}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/>
                        </h:column>
                        <h:column><h:outputText value="Bureau douane:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valBureauDouane}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="N° manifeste:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valManifeste}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:white;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%" id="idBanque" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valBanque}" maxlength="100">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche toutes les banques (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheBanque}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,panTiers,idBanque"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nombre de virements:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNbVirement}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="N° déclaration:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDeclaration}" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Valeur référence:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalReference}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Valeur expertise:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalExpert}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:white;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Poids brut:"/></h:column>
                        <h:column><h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPoidsBrut}"/></h:column>
                        <h:column><h:outputText value="Poids net:"/></h:column>
                        <h:column><h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPoidsNet}"/></h:column>
                        <h:column><h:outputText value="Unité:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPoidsUnite}" style="width:200px;">
                                <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                                <f:selectItem itemLabel="Kilo" itemValue="1"/>
                                <f:selectItem itemLabel="Tonne" itemValue="2"/>
                                <f:selectItem itemLabel="Litre" itemValue="3"/>
                                <f:selectItem itemLabel="Hecto-litre" itemValue="4"/>
                                <f:selectItem itemLabel="Autre" itemValue="9"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nb colis:"/></h:column>
                        <h:column><h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNbColis}"/></h:column>
                        <h:column><h:outputText value="Nb contener:"/></h:column>
                        <h:column><h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNbContener}"/></h:column>
                        <h:column><h:outputText value="Nb camion:"/></h:column>
                        <h:column><h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNbCamion}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Commandes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationImputation}" reRender="panelBoutonLigneCmd"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <h:panelGroup id="panelBoutonLigneCmd" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une commande" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.addCmd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_ajt}" reRender="panelListeDocument"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la commande en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.deleteCmd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonLigneCmd,commandeListe"/>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="commandeListe" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelCommande}"  var="doc"  sortMode="multi">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionRec}" reRender="panelBoutonLigneRec" />
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° CMD"/></f:facet>
                                <h:outputText  value="#{doc.cmdNum}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° DOS."/></f:facet>
                                <h:outputText  value="#{doc.cmdAnal4}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{doc.cmdDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="40%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                <h:outputText value="#{doc.cmdNomTiers}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                <h:outputText value="#{doc.cmdSerie}"/>
                            </rich:column>
                            <rich:column label="Montant T.T.C. local" sortable="true" sortBy="#{doc.cmdTotTtcLocal}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C. Local"  /></f:facet>
                                <h:outputText  value="#{doc.cmdTotTtcLocal}" rendered="#{doc.cmdTotTtcLocal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText value="#{doc.cmdObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Réceptions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationImputation}" reRender="panelBoutonLigneRec"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <h:panelGroup id="panelBoutonLigneRec" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une réception" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.addRec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_ajt}" reRender="panelListeDocument"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la réception en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.deleteRec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonLigneRec,receptionListe"/>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="receptionListe"  height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelReception}"  var="doc"  sortMode="multi">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionRec}" reRender="panelBoutonLigneRec" />
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° REC."/></f:facet>
                                <h:outputText  value="#{doc.recNum}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° DOS."/></f:facet>
                                <h:outputText  value="#{doc.recAnal4}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{doc.recDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                <h:outputText value="#{doc.recNomTiers}"/>
                            </rich:column>
                            <rich:column sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                <h:outputText value="#{doc.recSerie}"/>
                            </rich:column>
                            <rich:column sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Exclu"/></f:facet>
                                <h:outputText value="#{doc.excluValo}"/>
                            </rich:column>
                            <rich:column sortable="false" width="5%" >
                                <f:facet name="header"><h:outputText  value="Incoterm"/></f:facet>
                                <h:outputText value="#{doc.recIncoterm}"/>
                            </rich:column>
                            <rich:column sortable="false" width="5%" >
                                <f:facet name="header"><h:outputText  value="Devise"/></f:facet>
                                <h:outputText value="#{doc.recDevise}"/>
                            </rich:column>
                            <rich:column label="Montant Local" sortable="true" sortBy="#{doc.recTotTtcLocal}" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText  value="H.T. Devise"  /></f:facet>
                                <h:outputText  value="#{doc.recTotTtcLocal}" rendered="#{doc.recTotTtcLocal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Fret" sortable="true" sortBy="#{doc.recTotFretLocal}" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText  value="Fret"  /></f:facet>
                                <h:outputText  value="#{doc.recTotFretLocal}" rendered="#{doc.recTotFretLocal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Assurance au départ" sortable="true" sortBy="#{doc.recTotAssuranceLocal}" style="text-align:right;" width="10%">
                                <f:facet name="header"><h:outputText  value="Assur.Dep."  /></f:facet>
                                <h:outputText  value="#{doc.recTotAssuranceLocal}" rendered="#{doc.recTotAssuranceLocal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText value="#{doc.recObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Note de débit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}" >
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationFrais}" reRender="panelBoutonLigneNdb"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <h:panelGroup id="panelBoutonLigneNdb" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une note de débit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.addNdb}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_ajt}" reRender="panelListeDocument"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la note de débit en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.deleteNdb}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonLigneNdb,ndbListe"/>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="ndbListe" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelNdb}" var="doc" sortMode="multi">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionNdb}" reRender="panelBoutonLigneNdb"/>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° NDB"/></f:facet>
                                <h:outputText value="#{doc.ndfNum}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° DOS."/></f:facet>
                                <h:outputText value="#{doc.ndfAnal4}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{doc.ndfDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="25%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                <h:outputText value="#{doc.ndfNomTiers}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                <h:outputText value="#{doc.ndfSerie}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." width="10%" sortable="true" sortBy="#{doc.ndfTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{doc.ndfTotHt}" rendered="#{doc.ndfTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="20%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText value="#{doc.ndfObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Frais" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}" >
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationFrais}" reRender="panelBoutonLigneFra"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <h:panelGroup id="panelBoutonLigneFra" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                        <a4j:commandButton image="/images/rechercher.png" title="Rechercher frais" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.addFra}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_ajt}" reRender="panelBoutonLigneFra,fraisListe"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer le frais en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.deleteFra}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonLigneFra,fraisListe"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Consulter le frais sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.consultFra}" reRender="panelFrais"/>
                    </h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="fraisListe"  height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelFrais}"  var="doc"  sortMode="multi">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionFra}" reRender="panelBoutonLigneFra" />
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° FRAIS"/></f:facet>
                                <h:outputText value="#{doc.fsfNum}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° DOS."/></f:facet>
                                <h:outputText value="#{doc.fsfAnal4}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{doc.fsfDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="25%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                <h:outputText value="#{doc.fsfNomTiers}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                <h:outputText value="#{doc.fsfSerie}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." width="10%" sortable="true" sortBy="#{doc.fsfTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{doc.fsfTotHt}" rendered="#{doc.fsfTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant TTC" width="10%" sortable="true" sortBy="#{doc.fsfTotTtc}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"  /></f:facet>
                                <h:outputText  value="#{doc.fsfTotTtc}" rendered="#{doc.fsfTotTtc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText value="#{doc.fsfObject}"/>
                            </rich:column>
                            <rich:column sortable="false" width="15%">
                                <f:facet name="header"><h:outputText  value="Utilisation"/></f:facet>
                                <h:outputText value="#{doc.libelleTypeValo}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Calcul valorisation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationCalcul}" reRender="panelCalcul"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <h:column id="panelCalcul">

                        <h:panelGrid columns="2" width="100%" style="border:solid 1px green" headerClass="headerTab" columnClasses="clos40,clos60g">
                            <f:facet name="header"><h:outputText value="Calcul sur Achat"/></f:facet>
                            <h:panelGrid id="panCoef1" width="100%" style="border:solid 1px green" headerClass="headerTab" columns="2" columnClasses="clos50d,clos50d">
                                <h:column><h:outputText value="Type 1:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNature1}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                                        <f:selectItem itemLabel="Commande" itemValue="12"/>
                                        <f:selectItem itemLabel="Réception" itemValue="13"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Mode:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valFictif}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Calcul sur le réel" itemValue="0"/>
                                        <f:selectItem itemLabel="Calcul sur le théorique" itemValue="1"/>
                                        <f:selectItem itemLabel="Calcul provision" itemValue="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTransit,idAutrefrais"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:outputText value = "Calcul du P.R.:" />
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valCalculPr}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                    <f:selectItem itemLabel="A partir du poids" itemValue="0"/>
                                    <f:selectItem itemLabel="A partir du prix d’achat" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:column><h:outputText value="Total Commandes:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalCommande}" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Réceptions (FOB):"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFob}" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Frais 1:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFrais1}" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Prix de revient 1:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPr1}" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Coefficient 1:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valCoef1}" style="text-align:right"/>
                                </h:column>
                                <h:column><h:outputText value="Exonérations:"/></h:column>
                                <h:column>
                                    <h:outputText value="TVA"/>&nbsp;
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Douanes"/>&nbsp;
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valExoDouane}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:commandButton styleClass="exp_lienmenu" value="Calcul Valo." title="Calculer Valo." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.calculValo1}" onclick="if (!confirm('Etes-vous sur de vouloir valoriser ce dossier ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}"/>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="panCoef3" width="100%" style="border:solid 1px green" headerClass="headerTab" columns="4" columnClasses="clos25,clos25,clos25,clos25">
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Montants Réels" style="text-align:center;border:solid 0px green;width:200px;"/></h:column>
                                <h:column><h:outputText value="Montants Théoriques:" style="text-align:center;border:solid 0px green;width:200px;"/></h:column>
                                <h:column><h:outputText value="Montants Provisionnés:" style="text-align:center;border:solid 0px green;width:200px;"/></h:column>
                                <h:column><h:outputText value="Montant FOB:" /></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFob}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Montant Fret:" /></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFret}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Montant Assurance:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalAssuranceReelle}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalAssuranceTheo}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalAssuranceProv}" style="text-align:right;width:150px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value="Forfait transport  (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valCoefForfaitTransport}):"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valForfaitTransport}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value=""/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Valeur Douane:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valValeurDouane}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Droits de douane:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalDouaneReelle}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalDouaneTheo}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalDouaneProv}" style="text-align:right;width:150px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="TVA douane:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalTvaDouaneReelle}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalTvaDouaneTheo}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalTvaDouaneProv}" style="text-align:right;width:150px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Transit:"/></h:column>
                                <h:column>
                                    <h:inputText id="idTransit" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valFictif!='2'}"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalTransit}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Frais financiers:"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFinancierReelle}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFinancierTheo}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFinancierProv}" style="text-align:right;width:150px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total autres frais:"/></h:column>
                                <h:column>
                                    <h:inputText id="idAutrefrais" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valFictif!='2'}"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalDebours}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText id="idAutrefraisProv" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFraisProv}" style="text-align:right;width:150px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>

                        <div style="overflow:scroll;width:100%;border:solid 0px green;">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='UEMOA'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNature1==13}" var="valrec">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableDetail" footerClass="bard" headerClass="headerTab" activeClass="active-row" width="220%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.dataModelDetailValo}" var="detVal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionLigneDetailValo}"/>
                                        <rich:column label="Code produit" sortable="true" sortBy="#{detVal.recligCode}">
                                            <f:facet name="header"><h:outputText  value="Produit" /></f:facet>
                                            <h:outputText value="#{detVal.recligCode}"/>
                                        </rich:column>
                                        <rich:column label="Réf. fournisseur" sortable="true" sortBy="#{detVal.recligReference}">
                                            <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                            <h:outputText value="#{detVal.recligReference}"/>
                                        </rich:column>
                                        <rich:column label="Position tarifaire" sortable="true" sortBy="#{detVal.recligDouane}" sortOrder="ASCENDING">
                                            <f:facet name="header"><h:outputText  value="Douane" /></f:facet>
                                            <h:inputText id="idDouane" value="#{detVal.recligDouane}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheDouaneRec}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouane"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Sommier" sortable="true" sortBy="#{detVal.recligSommier}">
                                            <f:facet name="header"><h:outputText  value="Sommier" /></f:facet>
                                            <h:outputText value="#{detVal.recligSommier}"/>
                                        </rich:column>
                                        <rich:column label="Fob" sortable="true" sortBy="#{detVal.recligFob}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fob" /></f:facet>
                                            <h:outputText value="#{detVal.recligFob}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Fret" sortable="true" sortBy="#{detVal.recligFret}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fret" /></f:facet>
                                            <h:outputText value="#{detVal.recligFret}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Assurance" sortable="true" sortBy="#{detVal.recligAssurance}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Assur." /></f:facet>
                                            <h:outputText value="#{detVal.recligAssurance}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T1" sortable="true" sortBy="#{detVal.recligT1}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T1" /></f:facet>
                                            <h:outputText value="#{detVal.recligT1}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T3" sortable="true" sortBy="#{detVal.recligT3}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T3" /></f:facet>
                                            <h:outputText value="#{detVal.recligT3}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T5" sortable="true" sortBy="#{detVal.recligT5}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T5" /></f:facet>
                                            <h:outputText value="#{detVal.recligT5}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T10" sortable="true" sortBy="#{detVal.recligT10}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T10" /></f:facet>
                                            <h:outputText value="#{detVal.recligT10}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T30" sortable="true" sortBy="#{detVal.recligT30}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T30" /></f:facet>
                                            <h:outputText value="#{detVal.recligT30}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T31" sortable="true" sortBy="#{detVal.recligT31}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T31" /></f:facet>
                                            <h:outputText value="#{detVal.recligT31}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T46 + T56" sortable="true" sortBy="#{detVal.autreTaxe}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Autres" /></f:facet>
                                            <h:outputText value="#{detVal.autreTaxe}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Total frais" sortable="true" sortBy="#{detVal.recligFrais}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Frais" /></f:facet>
                                            <h:outputText value="#{detVal.recligFrais}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Frais Financiers" sortable="true" sortBy="#{detVal.recligFinancier}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Finance" /></f:facet>
                                            <h:outputText value="#{detVal.recligFinancier}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R." sortable="true" sortBy="#{detVal.recligPr}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Total" /></f:facet>
                                            <h:outputText value="#{detVal.recligPr}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Poids" sortable="true" sortBy="#{detVal.recligPoidsNet}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                                            <h:outputText value="#{detVal.recligPoidsNet}"/>
                                        </rich:column>
                                        <rich:column label="P.R. poids" sortable="true" sortBy="#{detVal.recligPrKg}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Kg" /></f:facet>
                                            <h:outputText value="#{detVal.recligPrKg}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Quantité" sortable="true" sortBy="#{detVal.recligQteUtil}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                                            <h:outputText value="#{detVal.recligQteUtil}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.optionAchats.nbDecQte}"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire" sortable="true" sortBy="#{detVal.recligPrU}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit." /></f:facet>
                                            <h:outputText value="#{detVal.recligPrU}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire TTC" sortable="true" sortBy="#{detVal.recligPrUTtc}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit. TTC" /></f:facet>
                                            <h:outputText value="#{detVal.recligPrUTtc}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='UEMOA'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNature1==12}" var="valcmd">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableDetailCmd" footerClass="bard" headerClass="headerTab" activeClass="active-row" width="220%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.dataModelDetailValo}" var="detVal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionLigneDetailValo}"/>
                                        <rich:column label="Code produit" sortable="true" sortBy="#{detVal.cmdligCode}">
                                            <f:facet name="header"><h:outputText  value="Produit" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligCode}"/>
                                        </rich:column>
                                        <rich:column label="Réf. fournisseur" sortable="true" sortBy="#{detVal.cmdligReference}">
                                            <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligReference}"/>
                                        </rich:column>
                                        <rich:column label="Position tarifaire" sortable="true" sortBy="#{detVal.cmdligDouane}" sortOrder="ASCENDING">
                                            <f:facet name="header"><h:outputText  value="Douane" /></f:facet>
                                            <h:inputText id="idDouaneCmd" value="#{detVal.cmdligDouane}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheDouaneCmd}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouaneCmd"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Fob" sortable="true" sortBy="#{detVal.cmdligFob}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fob" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFob}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Fret" sortable="true" sortBy="#{detVal.cmdligFret}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fret" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFret}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Assurance" sortable="true" sortBy="#{detVal.cmdligAssurance}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Assur." /></f:facet>
                                            <h:outputText value="#{detVal.cmdligAssurance}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T1" sortable="true" sortBy="#{detVal.cmdligT1}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T1" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT1}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T3" sortable="true" sortBy="#{detVal.cmdligT3}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T3" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT3}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T5" sortable="true" sortBy="#{detVal.cmdligT5}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T5" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT5}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T10" sortable="true" sortBy="#{detVal.cmdligT10}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T10" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT10}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T30" sortable="true" sortBy="#{detVal.cmdligT30}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T30" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT30}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T31" sortable="true" sortBy="#{detVal.cmdligT31}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="T31" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT31}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="T46 + T53" sortable="true" sortBy="#{detVal.autreTaxe}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Autres" /></f:facet>
                                            <h:outputText value="#{detVal.autreTaxe}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Total frais" sortable="true" sortBy="#{detVal.cmdligFrais}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Frais" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFrais}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Frais Financiers" sortable="true" sortBy="#{detVal.cmdligFinancier}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Finance" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFinancier}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R." sortable="true" sortBy="#{detVal.cmdligPr}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Total" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPr}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Poids" sortable="true" sortBy="#{detVal.cmdligPoidsNet}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPoidsNet}"/>
                                        </rich:column>
                                        <rich:column label="P.R. poids" sortable="true" sortBy="#{detVal.cmdligPrKg}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Kg" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPrKg}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Quantité" sortable="true" sortBy="#{detVal.cmdligQteUtil}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligQteUtil}"/>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire" sortable="true" sortBy="#{detVal.cmdligPrU}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit." /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPrU}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire TTC" sortable="true" sortBy="#{detVal.cmdligPrUTtc}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit. TTC" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPrUTtc}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='CEMAC'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNature1==13}" var="valrec">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableDetail2" footerClass="bard" headerClass="headerTab" activeClass="active-row" width="220%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.dataModelDetailValo}" var="detVal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionLigneDetailValo}"/>
                                        <rich:column label="Code produit" sortable="true" sortBy="#{detVal.recligCode}">
                                            <f:facet name="header"><h:outputText  value="Produit" /></f:facet>
                                            <h:outputText value="#{detVal.recligCode}"/>
                                        </rich:column>
                                        <rich:column label="Réf. fournisseur" sortable="true" sortBy="#{detVal.recligReference}">
                                            <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                            <h:outputText value="#{detVal.recligReference}"/>
                                        </rich:column>
                                        <rich:column label="Position tarifaire" sortable="true" sortBy="#{detVal.recligDouane}" sortOrder="ASCENDING">
                                            <f:facet name="header"><h:outputText  value="Douane" /></f:facet>
                                            <h:inputText id="idDouane" value="#{detVal.recligDouane}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheDouaneRec}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouane"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Sommier" sortable="true" sortBy="#{detVal.recligSommier}">
                                            <f:facet name="header"><h:outputText  value="Sommier" /></f:facet>
                                            <h:outputText value="#{detVal.recligSommier}"/>
                                        </rich:column>
                                        <rich:column label="Fob" sortable="true" sortBy="#{detVal.recligFob}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fob" /></f:facet>
                                            <h:outputText value="#{detVal.recligFob}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Fret" sortable="true" sortBy="#{detVal.recligFret}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fret" /></f:facet>
                                            <h:outputText value="#{detVal.recligFret}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Assurance" sortable="true" sortBy="#{detVal.recligAssurance}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Assur." /></f:facet>
                                            <h:outputText value="#{detVal.recligAssurance}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="DDI" sortable="true" sortBy="#{detVal.recligT1}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="DDI" /></f:facet>
                                            <h:outputText value="#{detVal.recligT1}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="TCI" sortable="true" sortBy="#{detVal.recligT3}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="TCI" /></f:facet>
                                            <h:outputText value="#{detVal.recligT3}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="TVA" sortable="true" sortBy="#{detVal.recligT5}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                                            <h:outputText value="#{detVal.recligT5}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="CCI" sortable="true" sortBy="#{detVal.recligT10}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="CCI" /></f:facet>
                                            <h:outputText value="#{detVal.recligT10}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="OAD" sortable="true" sortBy="#{detVal.recligT30}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="OAD" /></f:facet>
                                            <h:outputText value="#{detVal.recligT30}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="CSS" sortable="true" sortBy="#{detVal.recligT31}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="CSS" /></f:facet>
                                            <h:outputText value="#{detVal.recligT31}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Total frais" sortable="true" sortBy="#{detVal.recligFrais}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Frais" /></f:facet>
                                            <h:outputText value="#{detVal.recligFrais}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Frais Financiers" sortable="true" sortBy="#{detVal.recligFinancier}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Finance" /></f:facet>
                                            <h:outputText value="#{detVal.recligFinancier}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R." sortable="true" sortBy="#{detVal.recligPr}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Total" /></f:facet>
                                            <h:outputText value="#{detVal.recligPr}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Poids" sortable="true" sortBy="#{detVal.recligPoidsNet}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                                            <h:outputText value="#{detVal.recligPoidsNet}"/>
                                        </rich:column>
                                        <rich:column label="P.R. poids" sortable="true" sortBy="#{detVal.recligPrKg}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Kg" /></f:facet>
                                            <h:outputText value="#{detVal.recligPrKg}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Quantité" sortable="true" sortBy="#{detVal.recligQteUtil}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                                            <h:outputText value="#{detVal.recligQteUtil}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.optionAchats.nbDecQte}"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire" sortable="true" sortBy="#{detVal.recligPrU}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit." /></f:facet>
                                            <h:outputText value="#{detVal.recligPrU}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire TTC" sortable="true" sortBy="#{detVal.recligPrUTtc}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit. TTC" /></f:facet>
                                            <h:outputText value="#{detVal.recligPrUTtc}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale=='CEMAC'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNature1==12}" var="valcmd">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableDetailCmd2" footerClass="bard" headerClass="headerTab" activeClass="active-row" width="220%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.dataModelDetailValo}" var="detVal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionLigneDetailValo}"/>
                                        <rich:column label="Code produit" sortable="true" sortBy="#{detVal.cmdligCode}">
                                            <f:facet name="header"><h:outputText  value="Produit" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligCode}"/>
                                        </rich:column>
                                        <rich:column label="Réf. fournisseur" sortable="true" sortBy="#{detVal.cmdligReference}">
                                            <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligReference}"/>
                                        </rich:column>
                                        <rich:column label="Position tarifaire" sortable="true" sortBy="#{detVal.cmdligDouane}" sortOrder="ASCENDING">
                                            <f:facet name="header"><h:outputText  value="Douane" /></f:facet>
                                            <h:inputText id="idDouaneCmd" value="#{detVal.cmdligDouane}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.rechercheDouaneCmd}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouaneCmd"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Fob" sortable="true" sortBy="#{detVal.cmdligFob}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fob" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFob}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Fret" sortable="true" sortBy="#{detVal.cmdligFret}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Fret" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFret}" style="text-align:right">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Assurance" sortable="true" sortBy="#{detVal.cmdligAssurance}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Assur." /></f:facet>
                                            <h:outputText value="#{detVal.cmdligAssurance}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="DDI" sortable="true" sortBy="#{detVal.cmdligT1}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="DDI" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT1}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="TCI" sortable="true" sortBy="#{detVal.cmdligT3}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="TCI" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT3}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="TVA" sortable="true" sortBy="#{detVal.cmdligT5}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT5}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="CCI" sortable="true" sortBy="#{detVal.cmdligT10}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="CCI" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT10}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="OAD" sortable="true" sortBy="#{detVal.cmdligT30}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="OAD" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT30}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="CSS" sortable="true" sortBy="#{detVal.cmdligT31}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="CSS" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligT31}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Total frais" sortable="true" sortBy="#{detVal.cmdligFrais}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Frais" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFrais}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Frais Financiers" sortable="true" sortBy="#{detVal.cmdligFinancier}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Finance" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligFinancier}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R." sortable="true" sortBy="#{detVal.cmdligPr}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Total" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPr}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Poids" sortable="true" sortBy="#{detVal.cmdligPoidsNet}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPoidsNet}"/>
                                        </rich:column>
                                        <rich:column label="P.R. poids" sortable="true" sortBy="#{detVal.cmdligPrKg}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Kg" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPrKg}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="Quantité" sortable="true" sortBy="#{detVal.cmdligQteUtil}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligQteUtil}"/>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire" sortable="true" sortBy="#{detVal.cmdligPrU}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit." /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPrU}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column label="P.R. unitaire TTC" sortable="true" sortBy="#{detVal.cmdligPrUTtc}" style="text-align:right">
                                            <f:facet name="header"><h:outputText  value="P.R. Unit. TTC" /></f:facet>
                                            <h:outputText value="#{detVal.cmdligPrUTtc}">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            </h:outputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </c:if>
                        </div>

                    </h:column>
                </rich:tab>

                <rich:tab label="Réacheminements" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationImputation}" reRender="panelReexp"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <h:panelGroup id="panelReexp">
                    </h:panelGroup>
                </rich:tab>

                <rich:tab label="Valo. Réacheminement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.autorisationCalcul}" reRender="panelValRexep"/>
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <center>
                        <h:panelGroup id="panelValRexep">
                            <h:panelGrid columns="1" width="900px" style="border:solid 1px green" headerClass="headerTab">
                                <h:panelGrid id="panCoef2" style="background-color:#DAEECB;border:solid 1px green" width="400px" columns="2" headerClass="headerTab" columnClasses="clos50d,clos50d">
                                    <f:facet name="header"><h:outputText  value="Calcul sur Réexpédition"/></f:facet>
                                    <h:column><h:outputText value="Type 2:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNature2}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}">
                                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                                            <f:selectItem itemLabel="Réexpédition" itemValue="47"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.calculValo2}" reRender="panCoef2" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Total Réexpéditions:"/></h:column>
                                    <h:column>
                                        <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalReexpedition}" style="text-align:right">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Total Frais 2:"/></h:column>
                                    <h:column>
                                        <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valTotalFrais2}" style="text-align:right">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Prix de revient 2:"/></h:column>
                                    <h:column>
                                        <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valPr2}" style="text-align:right">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Coefficient 2:"/></h:column>
                                    <h:column>
                                        <h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valCoef2}" style="text-align:right"/>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab label="Factures ventes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.optionAchats.axeDossier=='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}" >
                    <jsp:include page="/achats/ValorisationCommun.jsp" flush="true"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="facListe" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelFactureVentes}" var="fac" sortMode="multi">
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° FAC."/></f:facet>
                                <h:outputText value="#{fac.facNum}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° DOS."/></f:facet>
                                <h:outputText value="#{fac.facAnal4}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{fac.facDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="25%">
                                <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                <h:outputText value="#{fac.facNomTiers}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                                <h:outputText value="#{fac.facSerie}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." width="10%" sortable="true" sortBy="#{fac.facTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{fac.facTotHt}" rendered="#{fac.facTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="20%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText value="#{fac.facObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.optionAchats.trfCompta=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valId!=0}">
                    <jsp:include flush="true" page="/achats/FactureCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" id="link8Ajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
                <center>
                    <h:outputText  id="outptcltAjt" style="color:red;" value="la date et le N° du dossier sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>


    <!-- modalPanel de selection des dossier -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="950" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.showModalPanelNonValo}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.showModalPanelNonValo}" var="nvl">
            <f:facet name="header"><h:outputText value="Sélection du document à intégrer"/></f:facet>
            <a4j:form id="formModalListeDocument">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDocument" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelElementNonValo}" var="doc">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionNonValo}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="N°" sortable="true" sortBy="#{doc.docNum}" width="15%">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{doc.docNum}"/>
                        </rich:column>
                        <rich:column label="N°" sortable="true" sortBy="#{doc.docAnal4}" width="15%">
                            <f:facet name="header"><h:outputText  value="N° DOS." /></f:facet>
                            <h:outputText value="#{doc.docAnal4}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{doc.docDate}" width="15%">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{doc.docDate}"/>
                        </rich:column>
                        <rich:column label="Nom du tiers" sortable="true" sortBy="#{dos.docNomTiers}" width="55%">
                            <f:facet name="header"><h:outputText  value="Nom tiers" /></f:facet>
                            <h:outputText value="#{doc.docNomTiers}"/>
                        </rich:column>
                        <rich:column label="Montant HT" sortable="true" sortBy="#{dos.docTotHt}" width="30%" style="text-align:right,">
                            <f:facet name="header"><h:outputText  value="Montant HT" /></f:facet>
                            <h:outputText value="#{doc.docTotHt}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanDossier" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleNonValo}" reRender="rtabpanel,panelListeDocument,panelBoutonLigneCmd,commandeListe,receptionListe,retourListe,noteDebitListe"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDossier" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valideNonValo}" reRender="rtabpanel,panelListeDocument,panelBoutonLigneCmd,commandeListe,receptionListe,retourListe,noteDebitListe"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanDossier')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValDossier')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel detail frais -->
    <rich:modalPanel domElementAttachment="parent"  id="panelFrais" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="950" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.showModalPanelFais}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.showModalPanelFais}" var="fra">
            <f:facet name="header"><h:outputText value="Détail de la facture frais n° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.fraisEnteteAchats.fsfNumFour}"/></f:facet>
            <a4j:form id="formModalListeDocument">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDocument" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelDetailFrais}" var="detFra">
                        <rich:column sortable="false" width="10%">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText  value="#{detFra.fsfligCode}"/>
                        </rich:column>
                        <rich:column sortable="false" width="38%">
                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                            <h:outputText value="#{detFra.fsfligLibelle}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%">
                            <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                            <h:outputText value="#{detFra.libelle_nature}"/>
                        </rich:column>
                        <rich:column sortable="false" width="5%">
                            <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                            <h:outputText value="#{detFra.fsfligTaxe}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%">
                            <f:facet name="header"><h:outputText  value="Sous traitant"/></f:facet>
                            <h:outputText value="#{detFra.fsfligNomFournisseur2}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%">
                            <f:facet name="header"><h:outputText  value="N°Facture"/></f:facet>
                            <h:outputText value="#{doclig.fsfligNunFactureFour2}"/>
                        </rich:column>
                        <rich:column sortable="false" style="text-align:right;" width="12%">
                            <f:facet name="header"><h:outputText  value="PT (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise})"  /></f:facet>
                            <h:outputText value="#{detFra.fsfligPtLocal}" rendered="#{detFra.fsfligPtLocal!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText value="#{detFra.fsfligPtLocal}" rendered="#{detFra.fsfligPtLocal!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText value="#{detFra.fsfligPtLocal}" rendered="#{detFra.fsfligPtLocal!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanFrais" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleFra}" reRender="panelFrais"/>&nbsp;&nbsp;&nbsp;
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanFrais')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des positions tarifaires -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeDouane" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.showModalPanelDouane}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.showModalPanelDouane}" var="dou">
            <f:facet name="header"><h:outputText value="Sélection de la position tarifaire"/></f:facet>
            <a4j:form id="formModalListeDossier">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDouane" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.datamodelDouane}" var="dou">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.selectionDouane}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Code" sortable="true" sortBy="#{dou.douposCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{dou.douposCode}"/>
                        </rich:column>
                        <rich:column label="Taux Douanes" sortable="true" sortBy="#{dou.douposDd}" width="10%">
                            <f:facet name="header"><h:outputText  value="Taux" /></f:facet>
                            <h:outputText value="#{dou.douposDd}"/>
                        </rich:column>
                        <rich:column label="Libellé du dossier" sortable="true" sortBy="#{dou.douposLibFR}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{dou.douposLibFR}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanDouane" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleDouane}" reRender="panelPage,panelListeDouane,idDouane,idDouaneCmd"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDouane" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.calculeDouane}" reRender="panelPage,panelListeDouane,idDouane,idDouaneCmd"/>
                    </center>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanDouane')}.click()" />
                    <rich:hotKey key="return" handler="#{rich:element('idValDouane')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
