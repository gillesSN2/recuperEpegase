<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="factureimmobilierfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES FACTURES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Facture" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationDocument}">
                    <h:panelGrid width="100%" id="idFactureComplete">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"  style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"  style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.mesSerieUserItem}"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesdevisesItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom locataire:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_detail_locataire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                        </h:inputText>&nbsp;
                                        <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.detailTiersLocataire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_detail_locataire}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                        <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_detail_locataire&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" reRender="panelTiers"/>
                                    </h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesFamilleClientsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.recupererEltCat}" reRender="idCat,idSerie,panelTotal,tableLigne"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Contact:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.mesContactItem}"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.mesUsersItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Recalcul"/></h:column>
                                    <h:column>
                                        <a4j:commandButton  image="/images/actualiser.png" title="Recalcul facture à partir du contrat" style="height:15px;width:15px" onclick="if (!confirm('Etes-vous sur de vouloir recalculer cette facture ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.recalculFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action<20}" reRender="modAttente,idFactureComplete"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelObjet" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Période du:"/></h:column>
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateDebut}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}"/>
                                    <h:column><h:outputText value="au:"/></h:column>
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}"/>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacObject}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}" maxlength="100"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="H.T.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Taxe:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotTva}" style="text-align:right;width:100%"  readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="T.T.C.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotTtc}" style="text-align:right;width:100%" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.affichagePump}"><h:outputText value="Commissions:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.affichagePump}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotalCom}" style="text-align:right;width:100%" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Com.Agence:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotalCom}" style="text-align:right;width:100%" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="I.R.P.P.:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotalIrpp}" style="text-align:right;width:100%" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGrid width="100%" id="idChiffre" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                                <h:column><h:outputText value="Loyer Brut:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacLoyerBrut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Charges Immeubles:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacChargesImmeuble}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="Ou"/>&nbsp;&nbsp;
                                    <h:inputText size="3" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxCharges}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column><h:outputText value="Eau:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacEau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Electricité:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacElectricite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Parking:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacParking}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Gardiennage:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacGardiennage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Jardinnier:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacJardinnier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Groupe électrogène:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacGroupeElectro}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText maxlength="20" size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacLibelleFrais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}" style="text-align:right;"/>
                                    <h:outputText value=":"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacFraisComplement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Divers Frais:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDiversFrais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.calculFacture}" reRender="idChiffre,idResultat,idAgence"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="idResultat" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                                <h:column>
                                    <h:outputText value="Enr./T.L.V.:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxTlv}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTlv}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = loyer brut + charges immeubles)"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="T.O.M.:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxTom}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTom}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = loyer brut)"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="T.V.A.:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxTva}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotTva}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = brut + charges immeubles)"/>
                                </h:column>
                                <h:column><h:outputText value="Loyer Net:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacLoyerNet}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = brut + charges imm. + eau + élec. + parking + gardien. + jardin. + grp électro. + autre + divers + tva + tlv + tom)"/>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="idAgence" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                                <h:column><h:outputText value="Base Agence:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.baseAgence}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = loyer brut)"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Commission Agence:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxCom}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotalCom}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = base agence)"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="T.V.A./Com.:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxTva}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTvaCom}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = commission agence)"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="I.R.P.P.:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTauxIrpp}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTotalIrpp}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(base = loyer brut)"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationImputation}">
                    <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Site:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacSite}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDepartement}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Service:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacService}" size="100" readonly="true"/></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Région:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacRegion}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Secteur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacSecteur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="Point de vente:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacPdv}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idBail" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos85">
                        <h:column><h:outputText value="Bail N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacBail}" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idProprietaire" styleClass="fichefournisseur">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Nom Propiétaire:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNomProprietaire}" disabled="true" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="idFicheProprietaire" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tieadresse}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Rue:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tierue}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Tel.1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tieburtel1}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Tel.2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tieburtel2}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tieburfax}" disabled="true"/></h:column>
                            <h:column><h:outputText value="eMail:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tiemail1}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tieville}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Pays:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.proprietaire.tienompays}" disabled="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idFiche" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Code bien:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieNum}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Libellé bien:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieNom}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieAdresse}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Rue N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieRue}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Quartier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieQuartier}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Commune:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieCommune}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Zone:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieZone}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieDepart}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieVille}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Pays:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bien.bieNomPays}" disabled="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Bail" id="tabBail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationImputation}">
                    <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    <h:panelGrid styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35" width="100%">
                        <h:column><h:outputText value="N° Contrat:"/></h:column>
                        <h:column><h:inputText size="10" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiNum}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Etabli le:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiDate}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date Début:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiDateDebut}"  inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date Fin:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiDateFin}"  inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Période facturation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiMode}" disabled="true">
                                <f:selectItem itemLabel="Jour" itemValue="0"/>
                                <f:selectItem itemLabel="Semaine" itemValue="1"/>
                                <f:selectItem itemLabel="Mois" itemValue="2"/>
                                <f:selectItem itemLabel="Trimestre" itemValue="3"/>
                                <f:selectItem itemLabel="Semestre" itemValue="4"/>
                                <f:selectItem itemLabel="Annuel" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Usage location:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiUsage}" disabled="true">
                                <f:selectItem itemLabel="Habitation" itemValue="0"/>
                                <f:selectItem itemLabel="Professionnel" itemValue="1"/>
                                <f:selectItem itemLabel="Mixte" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="TOM:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiExoTom}" disabled="true">
                                <f:selectItem itemLabel="Sans TOM" itemValue="1"/>
                                <f:selectItem itemLabel="Avec TOM" itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="TVA:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiExoTva}" disabled="true">
                                <f:selectItem itemLabel="Sans TVA" itemValue="1"/>
                                <f:selectItem itemLabel="Avec TVA" itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Enregistrement ou TLV:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiModeTlv}" disabled="true">
                                <f:selectItem itemLabel="Sans Enregistrement ni TLV" itemValue="0"/>
                                <f:selectItem itemLabel="Avec Enregistrement" itemValue="1"/>
                                <f:selectItem itemLabel="Avec TLV" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="IRPP Propriétaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTypeProprietaire}" disabled="true" readonly="true">
                                <f:selectItem itemLabel="Sans IRPP" itemValue="0"/>
                                <f:selectItem itemLabel="Avec IRPP" itemValue="1"/>
                                <f:selectItem itemLabel="Avec IS" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Loyer Brut:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiLoyerBrut}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Charges Immeubles:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiCharges}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="Ou"/>&nbsp;&nbsp;
                            <h:inputText size="3" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxCharges}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column><h:outputText value="Eau:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiEau}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Electricité:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiElectricite}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Parking:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiParking}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Gardiennage:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiGardiennage}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Jardinnier:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiJardinier}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Groupe électrogène:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiGroupeElectro}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText maxlength="20" size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiLibelleFrais}" disabled="true" style="text-align:right;"/>
                            <h:outputText value=":"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiFraisComplement}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Divers Frais:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiDiversFrais}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Enr./T.L.V.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxTlv}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTlv}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut + charges immeubles)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="T.O.M.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxTom}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTom}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="T.V.A.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxTva}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTva}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = brut + charges immeubles)"/>
                        </h:column>
                        <h:column><h:outputText value="Loyer Net:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiLoyerNet}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = brut + charges imm. + eau + élec. + parking + gardien. + jardin. + grp électro. + autre + divers + tva + tlv + tom)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="Commission Gérance:"/>&nbsp;&nbsp;
                            <h:inputText size="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxGerance}" style="text-align:right;" disabled="true">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiComGerance}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = base agence)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="T.V.A./Com.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxTva}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTvaGerance}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = commission agence)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="I.R.P.P.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiTauxIrpp}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienBail.biebaiIrpp}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut)"/>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationComplement}">
                    <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib3ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Formule 1:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacFormule1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Formule 2:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacFormule2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItem  itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesFormulesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Exonération" id="tabExo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_exoneration}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationExoneration}">
                    <h:panelGrid width="100%" id="idcommunExo">
                        <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idDescription2" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                        <h:column><h:outputText value="Période facturation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Jour" itemValue="0"/>
                                <f:selectItem itemLabel="Semaine" itemValue="1"/>
                                <f:selectItem itemLabel="Mois" itemValue="2"/>
                                <f:selectItem itemLabel="Trimestre" itemValue="3"/>
                                <f:selectItem itemLabel="Semestre" itemValue="4"/>
                                <f:selectItem itemLabel="Annuel" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Usage location:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacUsage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Habitation" itemValue="0"/>
                                <f:selectItem itemLabel="Professionnel" itemValue="1"/>
                                <f:selectItem itemLabel="Mixte" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="TOM Exonérée:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacExoTom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItem itemLabel="Sans exonération" itemValue="0"/>
                                <f:selectItem itemLabel="Avec exonération" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="TVA Exonérée:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItem itemLabel="Sans exonération" itemValue="0"/>
                                <f:selectItem itemLabel="Avec exonération" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Motif exonération:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacMotifExo}" maxlength="50" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="N° visa:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNumVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Date visa:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateVisa}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"   disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Rangement visa:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacRangeVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacExoTva==0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Mode Enr./TLV:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacModeTlv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans Enregistrement ni TLV" itemValue="0"/>
                                <f:selectItem itemLabel="Avec Enregistrement" itemValue="1"/>
                                <f:selectItem itemLabel="Avec TLV" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationReglement}">
                    <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.chargerModeEcheance}" reRender="panelGlobal,detmpdev,preg"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.CalculDateEcheance}" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.CalculDateEcheance}" reRender="idEcheance"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.CalculDateEcheance}" reRender="idEcheance" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><h:inputText id="idEcheance" readonly="true" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateEcheReg}" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.autorisationEtat}">
                    <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="ID FACTURE:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateTransfert}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_acc_reglement}">
                    <jsp:include flush="true" page="/immobilier/FactureLocationCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.annulerFacture}"  />&nbsp;&nbsp;
                    <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.saveRefacturation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <!-- modalPanel de validation document -->
    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_anal_activite}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacActivite}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.responsable=='1'}"><h:outputText value="Objet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.optionsVentes.responsable=='1'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacObservation}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacModeReg}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.chargerModeEcheance}" reRender="idValdocument"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacTypeReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.CalculDateEcheance}" reRender="idValdocument"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacNbJourReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.CalculDateEcheance}" reRender="idValdocument" />
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.CalculDateEcheance}" reRender="idValdocument" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacDateEcheReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacBanque}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Modèle impression:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.bienFacture.biefacModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formFactureImmobilier.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
