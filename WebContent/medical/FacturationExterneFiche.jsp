<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="notedebitmedicalfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES FACTURES EXTERNES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Facture Externe" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationDocument}">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:panelGrid width="100%" columns="4">
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.controleSaisie}"/>
                                    </rich:calendar>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                                <h:column><h:outputText value="N°:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbId!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesSerieUserItem}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText value="Devise:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesdevisesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                <h:column>
                                    <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                                    </h:inputText>&nbsp
                                    <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                    <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" reRender="panelTiers"/>
                                </h:column>
                                <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbCat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesFamilleClientsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idCat,idSerie,panelTotal,tableLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.recupererEltCat}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.informationsTiers!=null}">
                                <center>
                                    <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                </center>
                            </h:panelGroup>
                            <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="Contact:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversTiers==0}"/>
                                    <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversTiers==99}"/>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesContactItem}"/>
                                    </h:selectOneMenu>&nbsp;
                                    <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}"/>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversTiers==99}">
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversNom}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column id="idResponsable">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action)==true}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesUsersItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Objet:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversTiers==99}">
                                <h:column><h:outputText value="Adressé à:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversAdresse}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversVille}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Téléphone:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversTel}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="50"/></h:column>
                                <h:column><h:outputText value="Mail:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDiversMail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="H.T.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTotHt}" style="text-align:right;width:100%"  readonly="true" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taxe:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTotTva}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="T.T.C.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTotTtc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.affichagePump}"><h:outputText value="Marge:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.affichagePump}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_total_marge}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTauxTc!=0}"><h:outputText value="Surtaxe:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTauxTc!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTotTc}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligGroupe==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLigne,tableLigne,panelBoutonLigne"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_mod}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idDepot,inpCodDet,panelLigne"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" title="Fiche du produit" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrou_libelle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.griserchamps}" style="width:100%" maxlength="500">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculTva}" reRender="panelLigne,panelLigne1,panelLigne2,panelLigne3"/>
                                    </h:inputText>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:outputText rendered="false" value="Descriptif Complémentaire"/>
                            <h:inputTextarea rendered="false" tabindex="6" rows="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligComplement}" style="width:100%"/>
                            <h:panelGrid columns="10" width="100%" id="panelLigne2">
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligQte}" style="width:90px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecQte}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculPrix}" reRender="panelPt,panelPu,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite">
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_unite}" tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu id="idCondit" tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.selectionConditionnement}" reRender="panelLigne2,panelLigne3,panelPu,panelPt"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_sansstock}">
                                    <h:outputText value="Stock" />
                                    <h:selectOneMenu id="idDepot" tabindex="12" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_depotProd}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.mesProduitsDepotsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.selectionDepot}" reRender="panelPump" />
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligPump}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrouRabais}">
                                    <h:outputText value="Rabais"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligRabais}" style="width:70px;text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="18" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.plafondAutorise&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.griserValider}"/>
                                    <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="6" width="100%" id="panelLigne3" style="margin-left:350px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite<=199}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLong}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite<=299}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite<=399}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLong}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Largeur:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLarg}" style="width:60px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Hauteur:"/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligHaut}" style="width:60px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite<=499}">
                                    <h:outputText value="Longueur:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLong}" style="width:70px;text-align:right;"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Diamêtre:"/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligLarg}" style="width:70px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite<=849}">
                                    <h:outputText value="Nombre:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_code_unite<=899}">
                                    <h:outputText value="Pression:"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitLigneVentes.ndbligNb}" style="width:90px;text-align:right;"/>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                <rich:column width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_mod}">
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.datamodelLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.datamodelLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.datamodelLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableLigne"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.ndbligCode}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.ndbligLibelle}" style="#{doclig.styleLigne}"/><br>
                                    <h:outputText value="#{doclig.ndbligComplement}" rendered="#{doclig.ndbligComplement!=null}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva==0}">
                                    <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                    <h:outputText value="#{doclig.ndbligTaxe}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{doclig.ndbligQte}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecQte}"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                                        <h:outputText value="#{doclig.ndbligPu}" rendered="#{doclig.ndbligPu!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.U.TTC"/></f:facet>
                                        <h:outputText value="#{doclig.ndbligPuTtc}" rendered="#{doclig.ndbligPuTtc!=0}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.nbDecPu}"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.affichagePump}">
                                    <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                    <h:outputText value="#{doclig.ndbligPump}" rendered="#{doclig.ndbligPump!=0}" style="#{doclig.styleLigne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrouRemise}">
                                    <f:facet name="header"><h:outputText  value="Remise%"/></f:facet>
                                    <h:outputText value="#{doclig.ndbligTauxRemise}" rendered="#{doclig.ndbligTauxRemise!=0}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.verrouRabais}">
                                    <f:facet name="header"><h:outputText  value="Rabais"/></f:facet>
                                    <h:outputText value="#{doclig.ndbligRabais}" rendered="#{doclig.ndbligRabais!=0}" style="#{doclig.styleLigne}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="7%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="PRem.HT"  /></f:facet>
                                        <h:outputText value="#{dvslig.ndbligPuRem}" rendered="#{dvslig.ndbligPuRem!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="PRem.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.ndbligPuRemTtc}" rendered="#{doclig.ndbligPuRemTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='1'}">
                                        <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                        <h:outputText value="#{doclig.ndbligPt}" rendered="#{doclig.ndbligPt!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.decrmtPriVteStock=='2'}">
                                        <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                        <h:outputText value="#{doclig.ndbligTtc}" rendered="#{doclig.ndbligTtc!=0}" style="#{doclig.styleLigne}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </c:if>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationImputation}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid id="idImput0" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbObservation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Poids:"/></h:column>
                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTotRabais}" style="text-align:right;width:100%"  readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationComplement}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib1ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib2ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib3ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib4ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib5ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib6ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib7ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib8ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib9ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib10ENTETE}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.optionMedical.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbObservation}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbContrat}" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="20"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Lieu livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbLieuLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Date livraison:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Info livraison:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbInfoLivraison}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Remise globale (%):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTauxRemise}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculeRemiseGlobale}" reRender="panelPage,tableLigne,panelTotal"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Date impression:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateImp}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idModImp" style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Exonération" id="tabExo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_exoneration}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationExoneration}">
                    <h:panelGrid width="100%" id="idcommunExo">
                        <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idExo">
                        <h:column><h:outputText value="Exonération:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <f:selectItem itemLabel="Sans exonération" itemValue="0"/>
                                <f:selectItem itemLabel="Avec exonération" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.calculeExoneration}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTotal,tableLigne,idExo,idcommunExo"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Motif exonération:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbMotifExo}" maxlength="50" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.noteDebitEnteteVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="N° visa:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNumVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.noteDebitEnteteVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date visa:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateVisa}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"   disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.noteDebitEnteteVentes.majVisa}"/>
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Rangement visa:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbRangeVisa}" maxlength="20" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbExoTva==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.noteDebitEnteteVentes.majVisa}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" id="tabReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationReglement}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idTypReg" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbModeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,detmpdev,preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,idMode,panelNbjr,idBon,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelNbjr" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNbJourReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbArrondiReg}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><h:inputText id="idEcheance" readonly="true" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateEcheReg}" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idBon" columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_tot_bon_encaissement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbConditionReg}" style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_habilitation}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Utilisateur N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationEtat}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID NOTE DEBIT:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de relance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateRelance}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de validité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateValidite}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateTransfert}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateValide}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date de transformation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateTransforme}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_tracabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.autorisationTracabilite}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                    <h:panelGrid id="panTrace" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "   style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.datamodelDocumentTrace}"  var="trace"  sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.selectionTracabilite}"/>
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
                                    <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.voirOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNum!=trace.doctraOrgNum}"/>
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
                                    <h:commandButton title="Voir détail" image="/images/bulletin.png" style="height:20px;width:20px;text-align:center;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.voirDestination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNum!=trace.doctraDstNum}"/>
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

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_acc_reglement}">
                    <jsp:include flush="true" page="/ventes/NoteDebitCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.annule}"  />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.plafondAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" reRender="panelValidationDocument"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du client sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <!-- modalPanel de validation document -->
    <rich:modalPanel domElementAttachment="parent"  id="panelValidationDocument" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.showModalPanelValidationDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.showModalPanelValidationDocument}" var="val">
            <f:facet name="header"><h:outputText value="Validation document"/></f:facet>
            <a4j:form id="formModalValidation">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_aff_action}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Observations internes:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbObservation}" maxlength="100"/></h:column>
                    </h:panelGrid>

                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" id="idValdocument">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Type règlement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbModeReg}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesTypeReglements}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.chargerModeEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode échéance:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbTypeReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                                <f:selectItem itemLabel="Paiement arrivée/payé" itemValue="3"/>
                                <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.CalculDateEcheance}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibilitenbrjr}">
                        <h:column >
                            <h:outputText value="Nb jour:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbNbJourReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Arrondi:" /></h:column>
                        <h:column>
                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbArrondiReg}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValdocument" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.CalculDateEcheance}"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Date échéance:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbDateEcheReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.visibiliteencaissemt}">
                        <h:column ><h:outputText value="Montant du bon:" /></h:column>
                        <h:column ><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.var_tot_bon_encaissement}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Condition règlement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbConditionReg}" style="width:100%" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbBanque}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesBanquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Modèle impression:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.noteDebitEnteteVentes.ndbModeleImp}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.documentImpressionItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valDoc">
                    <center>
                        <h:commandButton id="idValDoc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.save}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValDoc')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
