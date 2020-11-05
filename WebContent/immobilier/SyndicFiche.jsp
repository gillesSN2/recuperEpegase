<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheSyndic">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="DESCRIPTION CONTRAT SYNDIC" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabIdentification" label="Identification">
                    <h:panelGrid width="100%" id="idFiche" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="N° contrat:"/></h:column>
                        <h:column><h:inputText size="10" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentNum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Série:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Valable du:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Jusqu'au:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date signature:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentDateSignature}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Honoraires H.T.:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentHonoraireHt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Code TVA:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idTva" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentCodeTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sélectionnez TVA" itemValue="100" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesTaxesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.calculHonoraire}" reRender="idFiche"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Total TVA:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentHonoraireTaxe}" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Honoraires T.T.C.:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentHonoraireTtc}" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idBien" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Code bien:" style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentLocal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_bien||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_bien&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action>=20}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les biens (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.rechercheBiens}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,idBien,idTiers"/>
                            </h:inputText>&nbsp;
                            <a4j:commandButton image="/images/detail.png" title="Fiche du bien" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.detailBiens}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_bien}" reRender="idSubView,formModalDetailBien,panelDetailBien"/>&nbsp;
                            <a4j:commandButton image="/images/modifier.png" title="Changer le bien" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.modifBiens}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_bien&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_action<20}" reRender="idBien"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé bien:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieNom}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieAdresse}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Rue N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieRue}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Quartier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieQuartier}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Commune:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieCommune}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Zone:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieZone}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieDepart}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column>
                            <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieVille}" disabled="true"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Google Map" image="/images/googleMap.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.googleMapLocal}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                        </h:column>
                        <h:column><h:outputText value="Pays:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bien.bieNomPays}" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idProprietaire" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos85">
                        <h:column><h:outputText value="Nom Propiétaire"  style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:column>
                                <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_aff_detail_tiers&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_aff_action}" maxlength="100">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les propriétaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idProprietaire,panelValide"/>
                                </h:inputText>&nbsp;
                                <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_aff_detail_tiers&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_aff_action}" reRender="idTiers"/>
                            </h:column>
                        </h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tieadresse}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Rue N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tierue}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Quartier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tiequartier}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Commune:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tiecommune}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Zone:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tiezone}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tiedepart}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column>
                            <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tieville}" disabled="true"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.googleMapProprietaire}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                        <h:column id="idpays">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.tiers.tienompays}" disabled="true">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesPaysItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.selectionPays}" reRender="idpays"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabContrat" label="Contrat">
                    <h:panelGrid  width="100%" id="panTexte">
                        <jsp:include flush="true" page="/immobilier/SyndicFicheCommun.jsp" />
                        <h:panelGrid  width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentId==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.afficheTexteContrat}">
                                <h:selectOneMenu id="idModele" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_code_modele}">
                                    <f:selectItem itemLabel="Sélectionnez modèle contrat" itemValue="100" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.mesModelesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.rechercheTexteModeleContrat}" reRender="panTexte,panelTexteContrat"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" id="panelTexteContrat">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentContrat}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.calculeTexte}" reRender="panTexte,panelTexteContrat"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabBiens" label="Liste des annexes">
                    <h:panelGrid id="panAnnexe" width="100%">
                        <jsp:include flush="true" page="/immobilier/SyndicFicheCommun.jsp" />
                        <h:panelGrid width="250px" id="panelBoutonAnnexe" columns="4">
                            <a4j:commandButton title="Ajouter une nouvelle annexe" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.ajouterAnnexe}" reRender="panelAnnexe"/>
                            <a4j:commandButton title="Modifier l'annexe sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_annexe&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.modifierAnnexe}" reRender="panelAnnexe"/>
                            <a4j:commandButton title="Consulter l'annexe sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_annexe}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.consulterAnnexe}" reRender="panelAnnexe"/>
                            <a4j:commandButton title="Supprimer l'annexe sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.var_affiche_annexe&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.supprimerAnnexe}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonAnnexe,tableAnnexe"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableAnnexe" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.datamodelDetail}" var="anx">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.selectionAnnexe}" reRender="panelBoutonAnnexe"/>
                                <rich:column label="Libelle annexe" sortable="true" width="100%" sortBy="#{anx.biegerligNomContrat}">
                                    <f:facet name="header"><h:outputText  value="Annexe" /></f:facet>
                                    <h:outputText value="#{anx.biegerligNomContrat}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.annulerGerance}" />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.validerGerance}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.tiers.tieid!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentEtat==0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelAnnexe" width="1100" height="440" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.showModalPanelAnnexe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.showModalPanelAnnexe}" var="lst">
            <f:facet name="header"><h:outputText value="DESCRIPTION ANNEXE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.fermerAnnexe}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnexe"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Nom annexe:"/></h:column>
                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceLigne.biegerligNomContrat}"/></h:column>
                </h:panelGrid>
                <br/>
                <h:panelGrid style="width:100%;" id="panelTexteContrat">
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceLigne.biegerligContrat}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.calculeTexte}" reRender="panTexte,panelTexteContrat"/>
                    </rich:editor>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup id="valideListe" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.bienGeranceEntete.biegerentEtat==0}">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.validerAnnexe}" reRender="panelAnnexe,tableAnnexe"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
