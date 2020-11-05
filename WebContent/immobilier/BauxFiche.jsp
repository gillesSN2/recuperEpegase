<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheBail">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="DESCRIPTION DU BAIL" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabIdentification" label="Identification">
                    <h:panelGrid width="100%" id="idContrat" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="N° Contrat:"/></h:column>
                        <h:column><h:inputText size="10" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Série:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Etabli le:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesEtatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idFiche" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Code bien:" style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiLocal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_local&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les biens (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.rechercheBiens}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                            </h:inputText>&nbsp;
                            <a4j:commandButton image="/images/detail.png" title="Fiche du bien" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.detailBiens}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_local}" reRender="idSubView,formModalDetailBien,panelDetailBien"/>&nbsp;
                            <a4j:commandButton image="/images/modifier.png" title="Changer le bien" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.modifBiens}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_local&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action<20}" reRender="idFiche"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé bien:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieNom}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieAdresse}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Rue N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieRue}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Quartier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieQuartier}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Commune:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieCommune}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Zone:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieZone}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieDepart}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column>
                            <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieVille}" disabled="true"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Google Map" image="/images/googleMap.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.googleMapLocal}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                        </h:column>
                        <h:column><h:outputText value="Pays:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieNomPays}" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idProprietaire" styleClass="fichefournisseur">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Nom Propiétaire:" style="text-decoration:underline"/></h:column>
                            <h:column>
                                <h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNomProprietaire}" disabled="true" readonly="true"/>&nbsp;
                                <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.detailTiersProprietaire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_proprietaire}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="idFicheProprietaire" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tieadresse}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Rue:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tierue}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Tel.1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tieburtel1}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Tel.2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tieburtel2}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tieburfax}" disabled="true"/></h:column>
                            <h:column><h:outputText value="eMail:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tiemail1}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tieville}" disabled="true"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.googleMapProprietaire}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                            </h:column>
                            <h:column><h:outputText value="Pays:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.proprietaire.tienompays}" disabled="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idLocataire" styleClass="fichefournisseur">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Nom Locataire:" style="text-decoration:underline"/></h:column>
                            <h:column>
                                <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_locataire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_locataire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}" maxlength="100">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les locataires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idProprietaire,panelValide"/>
                                </h:inputText>&nbsp;
                                <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.detailTiersLocataire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_locataire}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_aff_detail_locataire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action<20}" reRender="idTiers"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="idFicheLocataire" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tieadresse}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Rue:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tierue}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Tel.1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tieburtel1}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Tel.2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tieburtel2}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tieburfax}" disabled="true"/></h:column>
                            <h:column><h:outputText value="eMail:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tiemail1}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tieville}" disabled="true"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.googleMapLocataire}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}"  reRender="modalGoogleMap"/>
                            </h:column>
                            <h:column><h:outputText value="Pays:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tienompays}" disabled="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabDescription" label="Description">
                    <jsp:include flush="true" page="/immobilier/BauxFicheCommun.jsp" />
                    <h:panelGrid width="100%" id="idDescription1" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date Début:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date Fin:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date Signature:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateSignature}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Date bail remise:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateADeposer}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Remis à (nom/prenom):"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.locataire.tieadresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date dépôt bail:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateDepot}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date retour enregistrement:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateEnregistrement}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date Dernière Révision:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDerniereRevision}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date Prochaine Révision:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiProchaineRevision}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date Fin de facturation:" style="color:red"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateFinFacture}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;color:red"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:commandButton title="Réactiver Bail" value="Réactiver Bail" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce bail ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.reactiverDocument}" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateFinFacture!=null}"/>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idDescription2" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                        <h:column><h:outputText value="Période facturation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
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
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiUsage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Habitation" itemValue="0"/>
                                <f:selectItem itemLabel="Professionnel" itemValue="1"/>
                                <f:selectItem itemLabel="Mixte" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Si usage mixte montant loyer prof.:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiLoyerProf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Sans TOM:"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_exo_tom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.exoTom}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:selectBooleanCheckbox>
                        </h:column>
                        <h:column><h:outputText value="TVA Exonérée:"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_exo_tva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.exoTva}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:selectBooleanCheckbox>
                        </h:column>
                        <h:column><h:outputText value="Enregistrement ou TLV:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiModeTlv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans Enregistrement ni TLV" itemValue="0"/>
                                <f:selectItem itemLabel="Avec Enregistrement" itemValue="1"/>
                                <f:selectItem itemLabel="Avec TLV" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="IRPP Propriétaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTypeProprietaire}" disabled="true" readonly="true">
                                <f:selectItem itemLabel="Sans IRPP" itemValue="0"/>
                                <f:selectItem itemLabel="Avec IRPP" itemValue="1"/>
                                <f:selectItem itemLabel="Avec IS" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabValeur" label="Valeur">
                    <jsp:include flush="true" page="/immobilier/BauxFicheCommun.jsp" />
                    <h:panelGrid width="100%" id="idChiffre" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                        <h:column><h:outputText value="Loyer Brut:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiLoyerBrut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Charges Immeubles:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiCharges}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="Ou"/>&nbsp;&nbsp;
                            <h:inputText size="3" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxCharges}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column><h:outputText value="Eau:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Electricité:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiElectricite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Parking:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiParking}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Gardiennage:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiGardiennage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Jardinnier:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiJardinier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Groupe électrogène:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiGroupeElectro}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText maxlength="20" size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiLibelleFrais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}" style="text-align:right;"/>
                            <h:outputText value=":"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiFraisComplement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Divers Frais:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDiversFrais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idResultat" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                        <h:column>
                            <h:outputText value="Enr./T.L.V.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxTlv}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTlv}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut + charges immeubles)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="T.O.M.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxTom}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTom}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="T.V.A.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxTva}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTva}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = brut + charges immeubles)"/>
                        </h:column>
                        <h:column><h:outputText value="Loyer Net:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiLoyerNet}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = brut + charges imm. + eau + élec. + parking + gardien. + jardin. + grp électro. + autre + divers + tva + tlv + tom)"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idCaution" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                        <h:column><h:outputText value="Montant Caution:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiMontantCaution}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date Encaissement:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateCaution}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idAgence" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos35">
                        <h:column><h:outputText value="Base Agence:"/></h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.baseAgence}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="Commission Gérance:"/>&nbsp;&nbsp;
                            <h:inputText size="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxGerance}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiComGerance}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = base agence)"/>
                        </h:column>
                        <h:column><h:outputText value="Forfait Commission Gérance:"/></h:column>
                        <h:column>
                            <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiForfaitGerance}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculBail}" reRender="idChiffre,idResultat,idAgence"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="T.V.A./Com.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxTva}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTvaGerance}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = commission agence)"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="I.R.P.P.:"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiTauxIrpp}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>&nbsp;
                            <h:outputText value="%"/>
                        </h:column>
                        <h:column>
                            <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIrpp}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(base = loyer brut)"/>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabContrat" label="Contrat">
                    <h:panelGrid  width="100%" id="panTexte">
                        <jsp:include flush="true" page="/immobilier/BauxFicheCommun.jsp" />
                        <h:panelGrid  width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiId==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.afficheTexteContrat}">
                                <h:selectOneMenu id="idModele" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_code_modele}">
                                    <f:selectItem itemLabel="Sélectionnez modèle contrat" itemValue="100" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.mesModelesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.rechercheTexteModeleContrat}" reRender="panTexte,panelTexteContrat"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" id="panelTexteContrat">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiContrat}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculeTexte}" reRender="panTexte,panelTexteContrat"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabEtatIn" label="Etat des lieux Entrée">
                    <h:panelGrid  width="100%" id="panTexteIn">
                        <jsp:include flush="true" page="/immobilier/BauxFicheCommun.jsp" />
                        <h:panelGrid style="width:100%;" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Date état des lieux entrée:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateEtatIn}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                            <h:column><h:outputText value="Date Remise clé:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="true"/></h:column>
                            <h:column><h:outputText value="Index Electricité:"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIndexElectriciteIn}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Police Electricité:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiPoliceElectricite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                            <h:column><h:outputText value="Index Eau:"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIndexEauIn}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Police Eau:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiPoliceEau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                            <h:column rendered="false"><h:outputText value="Index Gaz:"/></h:column>
                            <h:column rendered="false">
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIndexGazIn}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="false"><h:outputText value="Police Gaz:"/></h:column>
                            <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiPoliceGaz}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                            <h:column><h:outputText value="Nom Assureur:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNomAssureur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                            <h:column><h:outputText value="Police Assurance:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiContratAssurance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" id="panelTexteEtatIn">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtatIn}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabEtatOut" label="Etat des lieux Sortie">
                    <h:panelGrid  width="100%" id="panTexteOut">
                        <jsp:include flush="true" page="/immobilier/BauxFicheCommun.jsp" />
                        <h:panelGrid style="width:100%;" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Date état des lieux sortie:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateEtatOut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Index Electricité:"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIndexElectriciteOut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Index Eau:"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIndexEauOut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column rendered="false"><h:outputText value="Index Gaz:"/></h:column>
                            <h:column rendered="false">
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiIndexGazOut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" id="panelTexteEtatOut">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtatOut}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>


            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annulerBail}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.validerBail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_action<=20}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
