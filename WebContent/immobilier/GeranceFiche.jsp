<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheGerance">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="DESCRIPTION GERANCE" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabIdentification" label="Identification">
                    <h:panelGrid width="100%" id="idProprietaire" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos85">
                        <h:column><h:outputText value="Nom Propiétaire"  style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:column>
                                <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_aff_detail_tiers&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_aff_action}" maxlength="100">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les propriétaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idProprietaire,panelValide"/>
                                </h:inputText>&nbsp;
                                <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                                <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_aff_detail_tiers&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_aff_action}" reRender="idTiers"/>
                            </h:column>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idFiche" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="N° contrat:"/></h:column>
                        <h:column><h:inputText size="10" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentNum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Série:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Valable du:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Jusqu'au:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Date signature:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentDateSignature}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idAdresseTiers" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tieadresse}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Rue N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tierue}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Quartier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tiequartier}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Commune:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tiecommune}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Zone:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tiezone}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tiedepart}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column>
                            <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tieville}" disabled="true"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                        <h:column id="idpays">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.tiers.tienompays}" disabled="true">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesPaysItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.selectionPays}" reRender="idpays"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabBiens" label="Liste des biens">
                    <h:panelGrid id="panBien" width="100%">
                        <jsp:include flush="true" page="/immobilier/GeranceFicheCommun.jsp" />
                        <h:panelGrid width="250px" id="panelBoutonBien" columns="4">
                            <a4j:commandButton title="Ajouter un nouveau bien" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.ajouterBien}" reRender="panelListe"/>
                            <a4j:commandButton title="Modifier le bien sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_affiche_bien&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.modifierBien}" reRender="panelBien"/>
                            <a4j:commandButton title="Consulter le bien sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_affiche_bien}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.consulterBien}" reRender="panelBien"/>
                            <a4j:commandButton title="Supprimer le bien sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_affiche_bien&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.supprimerBien}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonBien,tableBien"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableBien" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.datamodelDetail}" var="bien">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.selectionBien}" reRender="panelBoutonBien"/>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{bien.bien.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieNum}"/>
                                </rich:column>
                                <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{bien.bien.bieNom}">
                                    <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieNom}"/>
                                </rich:column>
                                <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{bien.bien.bieAdresse}">
                                    <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieAdresse}"/>
                                </rich:column>
                                <rich:column label="Quartier" sortable="true" width="100px" sortBy="#{bien.bien.bieQuartier}">
                                    <f:facet name="header"><h:outputText  value="Quartier" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieQuartier}"/>
                                </rich:column>
                                <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{bien.bien.bieModele}">
                                    <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieModele}"/>
                                </rich:column>
                                <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{bien.bien.bieSurperficie}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieSurperficie}" rendered="#{bien.bien.bieSurperficie!=0}" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{bien.bien.bieNbPiece}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                                    <h:outputText value="#{bien.bien.bieNbPiece}" rendered="#{bien.bien.bieNbPiece!=0}" />
                                </rich:column>
                                <rich:column label="Base Loyer" sortable="true" width="100px" sortBy="#{bien.biegerligLoyerBrut}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Base Loyer" /></f:facet>
                                    <h:outputText value="#{bien.biegerligLoyerBrut}" rendered="#{bien.biegerligLoyerBrut!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Loyer net" sortable="true" width="100px" sortBy="#{bien.biegerligLoyerNet}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Loyer Net" /></f:facet>
                                    <h:outputText value="#{bien.biegerligLoyerNet}" rendered="#{bien.biegerligLoyerNet!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabContrat" label="Contrat">
                    <h:panelGrid  width="100%" id="panTexte">
                        <jsp:include flush="true" page="/immobilier/GeranceFicheCommun.jsp" />
                        <h:panelGrid  width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentId==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.afficheTexteContrat}">
                                <h:selectOneMenu id="idModele" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_code_modele}">
                                    <f:selectItem itemLabel="Sélectionnez modèle contrat" itemValue="100" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.mesModelesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.rechercheTexteModeleContrat}" reRender="panTexte,panelTexteContrat"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" id="panelTexteContrat">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentContrat}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculeTexte}" reRender="panTexte,panelTexteContrat"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>


            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.annulerGerance}" />&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.validerGerance}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.tiers.tieid!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelListe" width="1100" height="440" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.showModalPanelListe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.showModalPanelListe}" var="lst">
            <f:facet name="header"><h:outputText value="SELECTION DES BIENS DU #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.fermerListe}" image="/images/close.gif" styleClass="hidelink" reRender="panelListe"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableBien" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.dataModelListe}" var="list">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.selectionList}" reRender="valideListe"/>
                            <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{list.bieNum}">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{list.bieNum}"/>
                            </rich:column>
                            <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{list.bieNom}">
                                <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                <h:outputText value="#{list.bieNom}"/>
                            </rich:column>
                            <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{list.bieAdresse}">
                                <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                <h:outputText value="#{list.bieAdresse}"/>
                            </rich:column>
                            <rich:column label="Quartier" sortable="true" width="100px" sortBy="#{list.bieQuartier}">
                                <f:facet name="header"><h:outputText  value="Quartier" /></f:facet>
                                <h:outputText value="#{list.bieQuartier}"/>
                            </rich:column>
                            <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{list.bieModele}">
                                <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                <h:outputText value="#{list.bieModele}"/>
                            </rich:column>
                            <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{list.bieSurperficie}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                <h:outputText value="#{list.bieSurperficie}" rendered="#{list.bieSurperficie!=0}" >
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{list.bieNbPiece}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                                <h:outputText value="#{list.bieNbPiece}" rendered="#{list.bieNbPiece!=0}" />
                            </rich:column>
                            <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{list.bieBaseLoyer}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                <h:outputText value="#{list.bieBaseLoyer}" rendered="#{list.bieBaseLoyer!=0}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Charges" sortable="true" width="100px" sortBy="#{list.bieCharges}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
                                <h:outputText value="#{list.bieCharges}" rendered="#{list.bieCharges!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup id="valideListe">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.validerListe}" reRender="panelListe,panelBien" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bien.bieId!=0}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelBien" width="800" height="650" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.showModalPanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.showModalPanelDetail}" var="moc">
            <f:facet name="header"><h:outputText value="GESTION DES BIENS DU #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.tiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.fermerBien}" image="/images/close.gif" styleClass="hidelink" reRender="panelBien"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabIdLoyer" label="Loyer">
                            <h:panelGrid width="100%" id="idInfo1" columns="2" columnClasses="clos15,clos35">
                                <h:column><h:outputText value="Période facturation:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
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
                                    <h:selectOneMenu style="border:0px;color:red;width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligUsage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <f:selectItem itemLabel="Habitation" itemValue="0"/>
                                        <f:selectItem itemLabel="Professionnel" itemValue="1"/>
                                        <f:selectItem itemLabel="Mixte" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Usage mixte montant loyer professionnel:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligLoyerProfessionnel}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Enregistrement/TLV:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligModeTlv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <f:selectItem itemLabel="Sans Enregistrement ni TLV" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec  Enregistrement" itemValue="1"/>
                                        <f:selectItem itemLabel="Avec TLV" itemValue="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="idInfo2" columns="2" columnClasses="clos15,clos35">
                                <h:column><h:outputText value="Loyer brut:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligLoyerBrut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Charges immeubles:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligChargesImmeuble}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="Ou"/>&nbsp;&nbsp;
                                    <h:inputText size="3" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxCharges}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column><h:outputText value="Eau:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligEau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Electricité:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligElectricite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Parking:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligParking}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Gardiennage:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligGardiennage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Jardinnier:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligJardinnier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Groupe Electrogène:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligGroupeElectro}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:inputText maxlength="20" size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligLibelleFrais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}" style="text-align:right;"/>
                                    <h:outputText value=":"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligFraisComplement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Divers frais:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligDiversFrais}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="idInfo3" columns="2" columnClasses="clos15,clos35">
                                <h:column>
                                    <h:outputText value="Enr./TLV:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxTlv}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTlv}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:outputText value="TOM:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxTom}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTom}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:outputText value="TVA:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxTva}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTva}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Loyer TTC:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligLoyerNet}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabIdProprietaire" label="Proprietaire">
                            <h:panelGrid width="100%" id="idInfo4" columns="2" columnClasses="clos15,clos35">
                                <h:column><h:outputText value="Mode Déclaration:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligDeclare}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <f:selectItem itemLabel="Bien non déclaré" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien Déclaré" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:outputText value="I.R.P.P.:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxIrpp}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTotalIrpp}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabIdagence" label="Agence">
                            <h:panelGrid width="100%" id="idInfo6" columns="2" columnClasses="clos15,clos35">
                                <h:column><h:outputText value="Montant Caution:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligMontantCaution}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais de déclaration:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligFraisDeclaration}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais état de compte:"/></h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligFraisEtatCompte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.var_action_detail>=20}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Commission:"/>&nbsp;&nbsp;
                                    <h:inputText  size="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxCommission}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.calculFormuleGerance}" reRender="idInfo1,idInfo2,idInfo3,idInfo4,idInfo5,idInfo6"/>
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTotalCommission}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <h:outputText value="TVA/Commission:"/>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTauxTva}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>&nbsp;
                                    <h:outputText value="%"/>
                                </h:column>
                                <h:column>
                                    <h:inputText size="10" style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceLigne.biegerligTvaCommission}" disabled="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup id="valideBien">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.validerBien}" reRender="panelBien,panBien,tableBien"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
