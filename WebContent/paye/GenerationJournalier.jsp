<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="journaliergeneration">

    <a4j:form>

        <center><h2>
                <h:outputText id="idTitre" value="GENERATION DES JOURNALIERS POUR LE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenJour} DE LA FEUILLE N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.feuilleCalcul.feuCode}" style="color:green;"/>&nbsp;&nbsp;
                <h:selectOneMenu style="width:150px;color:green;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_service_rec}">
                    <f:selectItem itemLabel="Tous les Services" itemValue=""/>
                    <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesServiceItems}"/>
                    <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                    <f:selectItem itemLabel="Sans Service" itemValue="*****"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.chagerSalarieServiceGeneration}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                </h:selectOneMenu>
            </h2></center>

        <h:panelGrid width="100%">

            <h:panelGroup>
                <center>
                    <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.fermerPeriodeGeneration}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

            <h:panelGrid  id="boutonSalaries" columns="15" width="550px" style="height:34px">
                <a4j:commandButton title="Génération Globale" image="/images/executer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nouvelleGenerationJournalier}" onclick="if (!confirm('Etes-vous sur de vouloir générer les bulletins de cette feuille de cette période?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="panelBarProg,tableBulletins,boutonSalaries"/>
                <a4j:commandButton title="Génération individuelle" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionRegenerationJournalier}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelListeSalaries"/>
                <a4j:commandButton title="Consulter le bulletin sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.consulterBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
                <a4j:commandButton title="Supprimer le(s) bulletin(s)" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionSuppressionBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelListeSalaries"/>
                <a4j:commandButton title="Historique des bulletins du salarié sélectionné" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.historiqueBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelListeBulletin"/>
                <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.initImpressionGeneJournalier}" reRender="panelImpGene,formModalImpGene,panchoixdoc,panelMail"/>
                <h:commandButton title="Cloturer période" image="/images/lock.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.clo}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.cloturePeriodeJournalier}" onclick="if (!confirm('Etes-vous sur de vouloir cloturer les bulletins de cette feuille de cette période?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                <a4j:commandButton title="Verrouiller bulletins" image="/images/cadenas_cl.png" style="height:26px;width:20px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.clo}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.verrouillerBulletin}" onclick="if (!confirm('Etes-vous sur de vouloir verrouiller les bulletins de cette feuille de cette période?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="panelBarProg,tableBulletins"/>
                <a4j:commandButton title="Dé-verrouiller bulletins" image="/images/cadenas_op.png" style="height:26px;width:20px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.clo}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.deVerrouillerBulletin}" onclick="if (!confirm('Etes-vous sur de vouloir dé-verrouiller les bulletins de cette feuille de cette période?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="panelBarProg,tableBulletins"/>
                <a4j:commandButton title="Envoyer le sms de paiement" image="/images/sms.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinMois.bulmenEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="if (!confirm('Etes-vous sur de vouloir envoyer cet sms à tous les salariés?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.envoyerSms}" reRender="modAttente"/>
                <a4j:commandButton title="Paiement du bulletin" image="/images/dollar.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.paiementBulletin}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_dollar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton}" reRender="tableBulletins,panelPaiement"/>
                <a4j:commandButton title="Bon des décaissements" image="/images/bonCaisse.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.decaissementBulletin}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bd&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton}" reRender="tableBulletins,panelPaiement"/>
                <a4j:commandButton title="Actualiser la liste" image="/images/actualiser.png" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionPeriodeGeneration}" reRender="modAttente,tableBulletins,scrollTable"/>
                <a4j:commandButton title="Informations sur le bulletin" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_affiche_bouton}" reRender="panelInformation"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.pageIndex}" reRender="tableBulletins" id="scrollTable" maxPages="20"align="left" for="tableBulletins"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_nb_max}" border="0" enableContextMenu="true" id="tableBulletins" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.dataModelLesBulletins}" var="bul">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionLigneGeneree}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                    <rich:column id="c1" label="Matricule agent" sortable="true" width="8%" sortBy="#{bul.bulsalMatricule}">
                        <f:facet name="header"><h:outputText  value="Matricule"/></f:facet>
                        <h:outputText value="#{bul.salaries.salMatricule}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c2" label="Nom et prénom" sortable="true" width="15%" sortBy="#{bul.salaries.salNom}  #{bul.salaries.salPrenom}">
                        <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                        <h:outputText value="#{bul.salaries.salNom}  #{bul.salaries.salPrenom}" title="#{bul.salaries.salNom}  #{bul.salaries.salPrenom}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c3" label="Etat" sortable="true" width="5%" sortBy="#{bul.libEtat}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{bul.libEtat}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c4" label="Feuille" sortable="true" width="5%" sortBy="#{bul.bulsalFeuille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.modeRepartition!=0}">
                        <f:facet name="header"><h:outputText  value="Feuille"/></f:facet>
                        <h:outputText value="#{bul.bulsalFeuille}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c5" label="Service" sortable="true" width="7%" sortBy="#{bul.bulsalService}">
                        <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                        <h:outputText value="#{bul.bulsalService} #{bul.bulsalLibService}" title="#{bul.bulsalLibService}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c6" label="Activite" sortable="true" width="7%" sortBy="#{bul.bulsalActivite}">
                        <f:facet name="header"><h:outputText  value="Activite"/></f:facet>
                        <h:outputText value="#{bul.bulsalActivite}" title="#{bul.bulsalActivite}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c7" label="Localisation" sortable="true" width="7%" sortBy="#{bul.bulsalLocalisation}">
                        <f:facet name="header"><h:outputText  value="Localis."/></f:facet>
                        <h:outputText value="#{bul.bulsalLocalisation}" title="#{bul.bulsalLocalisation}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c8" label="Contrat / Projet" sortable="true" width="8%" sortBy="#{bul.bulsalProjet}">
                        <f:facet name="header"><h:outputText  value="Contrat"/></f:facet>
                        <h:outputText value="#{bul.bulsalContrat}" style="#{bul.colorPaiement}"/>&nbsp;&nbsp;
                        <h:outputText value="#{bul.bulsalProjet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                    <rich:column id="c9" label="Net à payer" sortable="true" width="8%" sortBy="#{bul.bulsalNetPayer}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Net à Payer"/></f:facet>
                        <h:outputText value="#{bul.bulsalNetPayer}" rendered="#{bul.bulsalNetPayer!=0}" style="#{bul.colorPaiement}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c10" label="Congés payés" sortable="true" width="8%" sortBy="#{bul.bulsalCP}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="C.P."/></f:facet>
                        <h:outputText value="#{bul.bulsalCP}" rendered="#{bul.bulsalCP!=0}" style="#{bul.colorPaiement}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c11" label="Observations" sortable="true" width="8%" sortBy="#{bul.observations}">
                        <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                        <h:outputText value="#{bul.observations}" style="color:red;" title="#{bul.observations}"/>
                    </rich:column>
                    <rich:column id="idPrintBulletin" label="Impression bulletin" sortable="true" width="5%" sortBy="#{bul.bulsalDateImpression}" style="text-align:center">
                        <f:facet name="header"><h:outputText  value="Imp."/></f:facet>
                        <a4j:commandButton rendered="#{bul.bulsalDateImpression==null}" immediate="true" image="/images/annuler.gif" title="Bulletin jamais imprimé" style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.selectionBulletinImpression}" reRender="idSubView,panelImpBulletinOne,formModalImpOne,panchoixdocOne,panelMailOne,idPrintBulletin"/>
                        <a4j:commandButton rendered="#{bul.bulsalDateImpression!=null}" immediate="true" image="/images/print.png" title="Bulletin imprimé le #{bul.bulsalDateImpression}" style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.selectionBulletinImpression}" reRender="idSubView,panelImpBulletinOne,formModalImpOne,panchoixdocOne,panelMailOne,idPrintBulletin"/>
                    </rich:column>
                    <rich:column id="idVerrouBulletin" label="Verrouillage bulletin" sortable="true" width="5%" sortBy="#{bul.bulsalDateImpression}" style="text-align:center">
                        <f:facet name="header"><h:outputText  value="Ver."/></f:facet>
                        <a4j:commandButton rendered="#{!bul.bulsalEtatBulletin}" immediate="true" image="/images/cadenas_op.png" title="Bulletin non verrouillé" style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.verrouilleBulletin}" reRender="idVerrouBulletin"/>
                        <a4j:commandButton rendered="#{bul.bulsalEtatBulletin}" immediate="true" image="/images/cadenas_cl.png" title="Bulletin verrouillé" style="height:15px;width:20px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.deVerrouilleBulletin}" reRender="idVerrouBulletin"/>
                    </rich:column>
                    <rich:column id="c12" label="N° lot paiement" sortable="true" width="5%" sortBy="#{bul.bulsalLot}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.lotActif}">
                        <f:facet name="header"><h:outputText  value="Lot"/></f:facet>
                        <h:outputText value="#{bul.bulsalLot}" title="#{bul.bulsalLot}" rendered="#{bul.bulsalLot!=0}" style="#{bul.colorPaiement}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeBulletin" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelListeBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelListeBulletin}" var="lst">
            <f:facet name="header"><h:outputText value="LISTE DES BULLETINS POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanListeBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.fermerListeBulletin}" styleClass="hidelink" reRender="panelListeBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanListeBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup>
                    <center>
                        <a4j:commandButton title="Consulter le bulletin généré" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.consulterBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
                    </center>
                </h:panelGroup>
                <h:panelGrid style="width:100%;" id="panListeBulletin">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.dataModelListeBulletins}" enableContextMenu="false" var="liste" id="listeBulletin" border="0" styleClass="bg" style="border:solid 0px green" width="100%" height="400px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionBulletin}"/>
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="Période"/></f:facet>
                                <h:outputText value="#{liste.bulsalPeriode}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" >
                                <f:facet name="header"><h:outputText value="Jour"/></f:facet>
                                <h:outputText value="#{liste.bulsalDateDebut}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Service"/></f:facet>
                                <h:outputText value="#{liste.bulsalService}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Fonction"/></f:facet>
                                <h:outputText value="#{liste.bulsalFonction}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Net"/></f:facet>
                                <h:outputText value="#{liste.bulsalNetPayer}" rendered="#{liste.bulsalNetPayer!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Convention"/></f:facet>
                                <h:outputText value="#{liste.bulsalConvention}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Grille"/></f:facet>
                                <h:outputText value="#{liste.bulsalGrille}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBulletin" width="1200" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}" var="bul">
            <f:facet name="header"><h:outputText value="BULLETIN DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalPeriode} POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerConsulterBulletin}" styleClass="hidelink" reRender="panelBulletin,panelImpBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieBulletins.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeSalaries" width="1000" height="520" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelSalaries}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelSalaries}" var="sal">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.libelleSelection}"></h:outputText></f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="400px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.datamodelSalaries}" var="salSel">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionSalarie}" reRender="panelValide"/>
                        <rich:column label="Sélection agent" sortable="true" width="5%" sortBy="#{salSel.select_agent}">
                            <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox value="#{salSel.select_agent}"/>
                        </rich:column>
                        <rich:column label="Matricule agent" sortable="true" width="10%" sortBy="#{salSel.salMatricule}">
                            <f:facet name="header"><h:outputText  value="Matricule"/></f:facet>
                            <h:outputText value="#{salSel.salMatricule}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" width="10%" sortBy="#{salSel.salCivilite}">
                            <f:facet name="header"><h:outputText  value="Civilité"/></f:facet>
                            <h:outputText value="#{salSel.salCivilite}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="30%" sortBy="#{salSel.salNom}  #{salSel.salPrenom}">
                            <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                            <h:outputText value="#{salSel.salNom}  #{salSel.salPrenom}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" width="10%" sortBy="#{salSel.lib_etat}">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:outputText value="#{salSel.lib_etat}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" width="10%" sortBy="#{salSel.salService}">
                            <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                            <h:outputText value="#{salSel.salService}"/>
                        </rich:column>
                        <rich:column label="Activite" sortable="true" width="10%" sortBy="#{salSel.salActivite}">
                            <f:facet name="header"><h:outputText  value="Activite"/></f:facet>
                            <h:outputText value="#{salSel.salActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup id="panelValide">
                    <center>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.fermerRegeneration}"/>&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.regenerationSurListeJournalier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.modeSelection==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salaries.salId!=0}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');"/>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.validerSuppressionBulletin}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.modeSelection==1}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpGene" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelPrintGene}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelPrintGene}" var="prtgen">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.closeImpressionGene}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpGene,tableBulletins,idLot"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpGene" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGroup>
                </h:panelGroup>
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_choix_modele}" >
                            <f:selectItem itemLabel="Impressions bulletins" itemValue="0"/>
                            <f:selectItem itemLabel="Impressions contrôles" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.chargerLesModelesImpresion}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nomModeleDocument}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_choix_modele==0)==true}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nomModeleListe}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_choix_modele==1)==true}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.listeImpressionItems}"/>
                        </h:selectOneMenu>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.utilPrint.etat_init}" >
                            <f:selectItem itemLabel="Sans les charges patronales" itemValue="0"/>
                            <f:selectItem itemLabel="Avec les charges patronales" itemValue="1"/>
                            <f:selectItem itemLabel="Modèle Archive" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                    <h:selectOneMenu id="impSelectGene" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImpGene,modAttente,panelMailGene"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMailGene" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.affMail}" id="printGene" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LE BULLETIN"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID bulletin:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.bulsalId}"/>
                    <h:outputText value="Créé Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.bulsalUserCreat})"/>
                    <h:outputText value="Modifié Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.bulsalUserModif})"/>
                </h:panelGrid>
                <br>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="Banque de paiement:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.bulsalPayeBnq}"/>
                    <h:outputText value="N° Chéque ou bordereau:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.bulsalPayeChq}"/>
                    <h:outputText value="Nom caissier:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nomCaissier}"/>
                    <h:outputText value="Date paiement:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.bulletinSalaire.bulsalPayeDate}"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
