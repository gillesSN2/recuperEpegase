<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ctrlfacturation">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="CONTROLE DE LA REFACTURATION" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="7" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}"/>
                    <h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" var="gab">
                            <h:selectOneMenu id="idCat1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpCat}" style="width:150px;">
                                <f:selectItem itemLabel="Toutes les catégories" itemValue="0"/>
                                <f:selectItem itemLabel="Les Privés" itemValue="1"/>
                                <f:selectItem itemLabel="Les Assurés" itemValue="2"/>
                                <f:selectItem itemLabel="CNAMGS" itemValue="3"/>
                            </h:selectOneMenu>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}" var="aut">
                            <h:selectOneMenu id="idCat2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpCat}" style="width:150px;">
                                <f:selectItem itemLabel="Toutes les catégories" itemValue="0"/>
                                <f:selectItem itemLabel="Les Privés" itemValue="1"/>
                                <f:selectItem itemLabel="Les Assurés" itemValue="2"/>
                                <f:selectItem itemLabel="Les Soins Externes" itemValue="4"/>
                                <f:selectItem itemLabel="Les Hospitalisations" itemValue="5"/>
                            </h:selectOneMenu>
                        </c:if>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpEtat}" style="width:150px;">
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Validation Agent" itemValue="1"/>
                            <f:selectItem itemLabel="Gelé (Bloque la refacturation)" itemValue="2"/>
                            <f:selectItem itemLabel="Annulé (Supprimer)" itemValue="3"/>
                            <f:selectItem itemLabel="Validation Controleur" itemValue="5"/>
                            <f:selectItem itemLabel="Déjà refacturé (Ass./Soc./Compl.)" itemValue="6"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}">
                            <f:selectItem itemLabel="Jour en cours" itemValue="0"/>
                            <f:selectItem itemLabel="Mois en cours" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idFacturier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpFacturier}" style="width:150px;">
                            <f:selectItem itemLabel="Tous les créateurs" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCreateursItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.controlePeriode}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBouton,tableCtrl,scrollTableCtrl,panCtrl,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="13" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}">
                    <h:column><h:outputText value="Patient:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpPatient}" size="10"/></h:column>
                    <h:column><h:outputText value="Tiers:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:inputText id="idTiers1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpClient}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheTiersCtrl}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="12" width="450px" style="height:34px">
            <a4j:commandButton title="Valider (Agent) le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.valideDocumentAgt}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document (Agent)?')) return false" reRender="panelBouton,tableCtrl"/>
            <a4j:commandButton title="Dé-Valider (Agent) le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.deValideDocumentAgt}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document (Agent)?')) return false" reRender="panelBouton,tableCtrl"/>
            <a4j:commandButton title="Geler le document sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=4&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docBloqueRefacturation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.geleDocumentCtrl}" onclick="if (!confirm('Etes-vous sur de vouloir geler ce document ?')) return false" reRender="panelBouton,tableCtrl"/>
            <a4j:commandButton title="Dé-Geler le document sélectionné" image="/images/degeler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docBloqueRefacturation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.degeleDocumentCtrl}" onclick="if (!confirm('Etes-vous sur de vouloir dé-geler ce document ?')) return false" reRender="panelBouton,tableCtrl"/>
            <a4j:commandButton title="Annuler le document sélectionné (Avoir) uniquement si validé" image="/images/annuler_big.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document (transformer en avoir) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulerDocumentCtrl}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Changer le nom du patient du document sélectionné" image="/images/tiers.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=6&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.changerPatientCtrl}" reRender="panelChangerNomPatient"/>
            <a4j:commandButton title="Changer le motif d'entrée ou le service ou le médecin du document sélectionné" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.changerServiceCtrl}" reRender="panelChangerService"/>
            <a4j:commandButton title="Changer la date du document sélectionné" style="height:22px;width:22px" image="/images/calendrier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.changerDateCtrl}" reRender="panelChangerDate"/>
            <a4j:commandButton title="Visualisation du document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=6&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.changerDocumentCtrl}" reRender="panelChangerDocument"/>
            <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=6&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docTotPatient!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.historiquePaiementCtrl}" reRender="panelHistoReglement,idformHisto,idRegBouton"/>
            <a4j:commandButton title="Visualisation de la facture du tiers payeur" image="/images/tableau.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat==6&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visuFactureTiers}" reRender="panelVisuFactureTier"/>
            <a4j:commandButton title="Valider (Contrôleur) le document sélectionné" image="/images/valDocCtrl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.valideDocumentCtrl}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document (Controleur)?')) return false" reRender="panelBouton,tableCtrl"/>
            <a4j:commandButton title="Dé-Valider (Contrôleur) le document sélectionné" image="/images/deValDocCtrl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat==5&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.deValideDocumentCtrl}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document (Controleur)?')) return false" reRender="panelBouton,tableCtrl"/>
            <a4j:commandButton title="Mettre une note d'incident" image="/images/detail_alerte.png" style="width:25px;height:25px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.noteIncidentCtrl}" reRender="panelNoteIncident"/>
            <a4j:commandButton title="imprimer liste des documents" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp,formModalImp,panchoixdoc,optionMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.ouvrirImpressionCtrl}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBtonCtrl&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pageIndex}" reRender="tableCtrl" id="scrollTableCtrl" maxPages="20"align="left" for="tableCtrl"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_max}" style="max-height:100%" styleClass="bg" id="tableCtrl" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="250%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelEntetesCtrl}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.simpleSelectionEnteteCtrl}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.extDTableCtrl}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionCrtl}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visualisationCtrl}" reRender="idSubView,panelBouton"/>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.libelleNature}" >
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{var.libelleNature}" title="#{var.libelleNature}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{var.docService}" width="200px">
                            <f:facet name="header"><h:outputText  value="Service"  /></f:facet>
                            <h:outputText  value="#{var.docService}" title="#{var.docService}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="N° Dossier patient du malade" sortable="true" sortBy="#{var.docDossier}" >
                            <f:facet name="header"><h:outputText  value="N° Dossier" /></f:facet>
                            <h:outputText value="#{var.docDossier}" title="#{var.docDossier}" style="#{var.styleCouleur}"/>
                        </rich:column>
                         <rich:column label="N° Dossier patient assuré principal" sortable="true" sortBy="#{var.docDossierAssure}" >
                            <f:facet name="header"><h:outputText  value="N° Assuré" /></f:facet>
                            <h:outputText value="#{var.docDossierAssure}" title="#{var.docDossierAssure}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="N° Document" sortable="true" sortBy="#{var.docNum}" >
                            <f:facet name="header"><h:outputText  value="N° Doc." /></f:facet>
                            <h:outputText value="#{var.docNum}" title="#{var.docNum}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.docDate}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.docDate}" title="#{var.docDate}" style="#{var.styleCouleur}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Prise en charge" sortable="true" sortBy="#{var.docPecCnamgs}" width="50px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <f:facet name="header"><h:outputText  value="Pec" /></f:facet>
                            <h:outputText value="#{var.docPecCnamgs}" rendered="#{var.docPecCnamgs!=0}" style="text-align:right;#{var.styleCouleur}" title="#{var.docPecCnamgs}" />
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.libelleFond}#{var.libelleFamille}#{var.libelleTiers}" width="120px">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.libelleFond}" rendered="#{var.docPecCnamgs!=0}" style="#{var.styleCouleur}" title="#{var.libelleFond}" />
                            <h:outputText value="#{var.libelleFamille}" rendered="#{var.docPecCnamgs==0&&var.docIdAssurance==0&&var.docIdSociete==0&&var.docIdComplementaire==0}" title="#{var.libelleFamille}" style="#{var.styleCouleur}"/>
                            <h:outputText value="#{var.libelleTiers}" rendered="#{var.docPecCnamgs==0&&(var.docIdAssurance!=0||var.docIdSociete!=0||var.docIdComplementaire!=0)}" title="#{var.libelleTiers}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.docEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}" title="#{var.libelleEta}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Motif d`entrée" sortable="true" sortBy="#{var.docEntree}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Ent." /></f:facet>
                            <h:outputText value="#{var.docEntree}" title="#{var.docEntree}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Patient" sortable="true" sortBy="#{var.docNomPatient}" width="200px">
                            <f:facet name="header"><h:outputText  value="Patient"  /></f:facet>
                            <h:outputText value="#{var.docNomPatient} (#{var.docCivilite})" title="#{var.docNomPatient}" style="#{var.styleCouleur}"/><br>
                            <h:outputText value="#{var.docObs}" title="#{var.docObs}" style="color:red"/>
                        </rich:column>
                        <rich:column label="Matricule" sortable="true" sortBy="#{var.docMatriculeSociete}" width="100px">
                            <f:facet name="header"><h:outputText  value="Matricule"  /></f:facet>
                            <h:outputText  value="#{var.docMatriculeSociete}" title="#{var.docMatriculeSociete}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Total facture" sortable="true" sortBy="#{var.docTotFacture}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Total fac."/></f:facet>
                            <h:outputText  value="#{var.docTotFacture}" rendered="#{var.docTotFacture!=0}" title="#{var.docTotFacture}" style="#{var.styleCouleur}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Tiers" sortable="true" sortBy="#{var.docTotTiers}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.Tiers"/></f:facet>
                            <h:outputText  value="#{var.docTotTiers}" rendered="#{var.docTotTiers!=0}" title="#{var.docTotTiers}" style="#{var.styleCouleur}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Patient" sortable="true" sortBy="#{var.docTotPatient}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.Patient"  /></f:facet>
                            <h:outputText  value="#{var.docTotPatient}" rendered="#{var.docTotPatient!=0}" title="#{var.docTotPatient}" style="#{var.styleCouleur}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Mèdecin" sortable="true" sortBy="#{var.docNomMedecin}" width="200px">
                            <f:facet name="header"><h:outputText  value="Mèdecin"/></f:facet>
                            <h:outputText  value="#{var.docNomMedecin}" title="#{var.docNomMedecin}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Bon de commande" sortable="true" sortBy="#{var.docNumBc}" width="100px">
                            <f:facet name="header"><h:outputText  value="N° BC"/></f:facet>
                            <h:outputText  value="#{var.docNumBc}" title="#{var.docNumBc}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="N° feuille" sortable="true" sortBy="#{var.docFeuille}" width="100px">
                            <f:facet name="header"><h:outputText  value="N° Feuille"/></f:facet>
                            <h:outputText  value="#{var.docFeuille}" title="#{var.docFeuille}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Nom tiers" sortable="true" sortBy="#{var.docNomTiersAssurance}" width="200px">
                            <f:facet name="header"><h:outputText value="Nom tiers"/></f:facet>
                            <h:outputText  value="#{var.docNomTiersAssurance}#{var.docNomTiersSociete}#{var.docNomTiersComplementaire}" title="#{var.docNomTiersAssurance}#{var.docNomTiersSociete}#{var.docNomTiersComplementaire}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Nom employeur" sortable="true" sortBy="#{var.docNomEmployeur}" width="200px">
                            <f:facet name="header"><h:outputText value="Nom employeur"/></f:facet>
                            <h:outputText  value="#{var.docNomEmployeur}" title="#{var.docNomEmployeur}" style="#{var.styleCouleur}"/>
                        </rich:column>
                        <rich:column label="Nom agent de facturation" sortable="true" sortBy="#{var.docNomCreateur}" width="200px">
                            <f:facet name="header"><h:outputText value="Nom agent facturation"/></f:facet>
                            <h:outputText  value="#{var.docNomCreateur}" title="#{var.docNomCreateur}" style="#{var.styleCouleur}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%">
            <h:panelGrid columns="2" >
                <h:outputText value="Total Facturation" />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText  value="Total Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText value="Total Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantSolde}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="1">
                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>
        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Document gelé ou désactivé" style="color:grey;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Document annulé" style="color:red;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Document validé par le contrôleur" style="color:blue;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Document en cours de statut" style="color:black;"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelChangerService" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelChangerService}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelChangerService}" var="chs">
            <f:facet name="header"><h:outputText value="Change Motif d'entrée, Service, Médecin"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulerChangerServiceCtrl}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerService"/>
                    <rich:componentControl for="panelChangerService" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien motif:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.actuelMotif}"/></h:column>
                        <h:column><h:outputText value="Nouveau motif:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nouveauMotif}" >
                                <f:selectItem itemLabel="Sélectionner un motif" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMotifEntreeItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien service:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.actuelService}"/></h:column>
                        <h:column><h:outputText value="Nouveau service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nouveauService}" >
                                <f:selectItem itemLabel="Sélectionner un service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServices2Items}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.chargerMedecinService}" reRender="idNewMedecin"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.actuelMedecin}"/></h:column>
                        <h:column><h:outputText value="Nouveau médecin:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idNewMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nouveauMedecin}" >
                                <f:selectItem itemLabel="Sélectionner un médecin" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesMedecinsItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerChangerServiceCtrl}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelChangerDate" width="400" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelChangerDate}">
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelChangerDate}" var="chd">
            <f:facet name="header"><h:outputText value="Change Date document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerChangerDateCtrl}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerDate"/>
                    <rich:componentControl for="panelChangerDate" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancienne date:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.ancienneDate}"/></h:column>
                        <h:column><h:outputText value="Nouvelle date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nouvelleDate}"  inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" popup="false"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerChangerDateCtrl}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelChangerNomPatient" width="1000" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelChangerNomPatient}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelChangerNomPatient}" var="chp">
            <f:facet name="header"><h:outputText value="Change Identitié patient"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerChangerPatientCtrl}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerNomPatient"/>
                    <rich:componentControl for="panelChangerNomPatient" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idPatIdent">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patCivilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesCivilitesItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calculeGenre}" reRender="idPatIdent,idGenre"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Genre:"/></h:column>
                    <h:panelGrid columns="3" width="100%" columnClasses="clos35,clos15g,clos50" id="idGenre">
                        <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patSexe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.verrouSexe}">
                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPatIdent,idGenre"/>
                        </h:selectOneRadio>
                        <h:column>
                            <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patSexe==0}"/>
                            <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patSexe==1}"/>
                        </h:column>
                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patDossier}" readonly="true"/>
                    </h:panelGrid>
                    <h:column><h:outputText value="Nom:" style="color:red"/></h:column>
                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patPrenom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Né(e) le (JJ/MM/AAAA):" style="color:red;"/></h:column>
                    <h:column>
                        <a4j:outputPanel layout="block" style="vertical-align:center;color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action!=3}">
                            <a4j:commandButton image="/images/dateNaissance.png" style="width:18px;height:18px;" title="Aide au calcul de la date naissance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calculeDateNaissance}" reRender="panelDateNaissance" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/>&nbsp;&nbsp;
                            <rich:calendar id="idDateNaissance"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patDateNaissance}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/>
                        </a4j:outputPanel>
                    </h:column>
                    <h:column><h:outputText value="Lieu naissance:"/></h:column>
                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patLieuNaissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                    <h:column><h:outputText value="Adresse:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Ville:"/></h:column>
                    <h:column>
                        <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patVille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}"><h:outputText value="N° de sécurité:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNSS:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patSecu}" style="width:100%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="N° CNAMGS (patient):" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patCnamgs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.assurePrincipal}"><h:outputText value="Nom Assuré principal:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.assurePrincipal}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nomCnamgsAssure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.assurePrincipal}"><h:outputText value="N° CNAMGS (Assuré):" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.assurePrincipal}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.numCnamgsAssure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docIdAssurance!=0}">
                    <h:column><h:outputText value="Assurance:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docNomTiersAssurance}" style="width:100%;" maxlength="20" disabled="true"/></h:column>
                    <h:column><h:outputText value="Employeur:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idAdherent" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docNomEmployeur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.lesEmployeursItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="N° contrat:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docContratAssurance}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docIdSociete!=0}">
                    <h:column><h:outputText value="Société:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docNomTiersSociete}" style="width:100%;" maxlength="20" disabled="true"/></h:column>
                    <h:column><h:outputText value="N° matricule:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docMatriculeSociete}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docIdComplementaire!=0}">
                    <h:column><h:outputText value="Complémentaire:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docNomTiersComplementaire}" style="width:100%;" maxlength="20" disabled="true"/></h:column>
                    <h:column><h:outputText value="N° contrat:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docContratComplementaire}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="N° C.I.:"/></h:column>
                    <h:column><h:inputText id="idCi" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patCi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="N° Passport:"/></h:column>
                    <h:column><h:inputText id="idPassport" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patPassport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Téléphone domicile:" style="color:red;"/></h:column>
                    <h:column><h:inputText id="idDom" style="width:100%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patTelDom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Mobile 1:" style="red;"/></h:column>
                    <h:column><h:inputText id="idCle1" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patCel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Mobile 2:" style="color:red;"/></h:column>
                    <h:column><h:inputText  id="idCle2" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patCel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Mobile 3:" style="color:red;"/></h:column>
                    <h:column><h:inputText  id="idCle3" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patCel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Skype:"/></h:column>
                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patSkype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                    <h:column><h:outputText value="Mail 1:"/></h:column>
                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.patients.patMail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerChangerPatientCtrl}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=4}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelDateNaissance" headerClass="headerPanel" width="250" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelCalculDateNaissance}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelCalculDateNaissance}" var="pdn">
            <f:facet name="header"><h:outputText value="CALCUL DATE NAISSANCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerCalculDateNaissance}" reRender="panelDateNaissance"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50d" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Né(e) vers:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nevers}" style="width:80px;"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50d" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Nombre années:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nbAnnee}" style="width:80px;"/></h:column>
                        <h:column><h:outputText value="Nombre mois"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nbMois}" style="width:80px;"/></h:column>
                        <h:column><h:outputText value="Nombre jours"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nbJours}" style="width:80px;"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valDateNaissance">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.valideCalculDateNaissance}" reRender="panelDateNaissance,idDateNaissance,idDateNaissanceAyantDoit"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=4}"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <center>
                        <h:panelGroup id="idRegBouton">
                            <a4j:commandButton title="Changer la date ou la caisse du réglement sélectionné" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectPatient&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements.rglId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements.rglDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectPatient&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.modifReglement}" reRender="panelModificationReglement"/>
                        </h:panelGroup>
                    </center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" id="idTableReglementCtrl" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelRecu}"  var="recu"  sortMode="multi">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionLigneReglement}" reRender="idRegBouton"/>
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelModificationReglement" width="600" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelReglementCtrl}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelReglementCtrl}" var="ser">
            <f:facet name="header"><h:outputText value="Modification règlement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerModifReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelModificationReglement,idRegBouton"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;" headerClass="headerTab" >
                        <f:facet name="header"><h:outputText value="Ancien mode paiement"/></f:facet>
                        <h:column><h:outputText value="Date réglement:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements.rglDateReg}"  inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Caisse opération:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements.rglCodeCaiss}" style="width:100%;" disabled="true" readonly="true">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesCaissesSeriesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  columns="2" style="width:100%;" headerClass="headerTab" >
                        <f:facet name="header"><h:outputText value="Nouveau mode paiement"/></f:facet>
                        <h:column><h:outputText value="Date réglement:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateDocument}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="Caisse opération:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_inputCaisse}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesCaissesSeriesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerModifReglement}" reRender="panelModificationReglement,idRegBouton,idTableReglementCtrl"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Consultation"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateAnnulation}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.motifAnnulation}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerAnnulerCtrl}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelNoteIncident" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelNoteIncident}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelNoteIncident}" var="ser">
            <f:facet name="header"><h:outputText value="NOTE D`INCIDENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleNoteIncident}" image="/images/close.gif" styleClass="hidelink" reRender="panelNoteIncident,tableCtrl"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Note incident:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docObs}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerNoteIncident}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelNoteIncident,tableCtrl"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelChangerDocument" width="1200" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelDocument}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelDocument}" var="chd">
            <f:facet name="header"><h:outputText value="Consultation document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerChangerdocumentCtrl}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerDocument"/>
                    <rich:componentControl for="panelChangerDocument" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <h:panelGrid width="100%" columns="6">
                        <h:column><h:outputText value="N° Document:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.numDocument}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date Document:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateDocument}" inputSize="20" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" disabled="true"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="HH:mm #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_heure}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_minute}"/>
                        </h:column>
                        <h:column><h:outputText value="Nom patient:"/></h:column>
                        <h:column>
                            <h:inputText id="idPatients" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nomPatientDocument}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recherchePatients}" reRender="panelListePatients,formModalListePatients"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Agent de facturation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nomAgentFacturation}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Numéro feuille:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.numFeuille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                        <h:column><h:outputText value="N° BC:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.numBc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}"/></h:column>
                        <h:column><h:outputText value="Total Facture:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.totalFacture}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Part Patient:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.partPatient}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Part Tiers:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.partTiers}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Part Assurance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.partTiersAssurance}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Part Société:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.partTiersSociete}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Part Complémentaire :"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.partTiersComplementaire}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="PEC Cnamgs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pecCnamgs}" style="text-align:right" readonly="true" disabled="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Fonds:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fondsCnamgs}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat>=5}">
                                <f:selectItem itemLabel="Sans Fonds" itemValue="0"/>
                                <f:selectItem itemLabel="Fonds 1 + Consultations (SP)" itemValue="1"/>
                                <f:selectItem itemLabel="Fonds 2 + Consultations (AP)" itemValue="2"/>
                                <f:selectItem itemLabel="Fonds 3 + Consultations (GEF)" itemValue="3"/>
                                <f:selectItem itemLabel="--------------------------------------" itemValue="0"/>
                                <f:selectItem itemLabel="Fonds 1 + Examens (SP)" itemValue="11"/>
                                <f:selectItem itemLabel="Fonds 2 + Examens (AP)" itemValue="12"/>
                                <f:selectItem itemLabel="Fonds 3 + Examens (GEF)" itemValue="13"/>
                                <f:selectItem itemLabel="--------------------------------------" itemValue="0"/>
                                <f:selectItem itemLabel="Fonds 1 + Pharmacie (SP)" itemValue="21"/>
                                <f:selectItem itemLabel="Fonds 2 + Pharmacie (AP)" itemValue="22"/>
                                <f:selectItem itemLabel="Fonds 3 + Pharmacie (GEF)" itemValue="23"/>
                                <f:selectItem itemLabel="--------------------------------------" itemValue="0"/>
                                <f:selectItem itemLabel="Fonds 1 + Hospitalisation (SP)" itemValue="31"/>
                                <f:selectItem itemLabel="Fonds 2 + Hospitalisation (AP)" itemValue="32"/>
                                <f:selectItem itemLabel="Fonds 3 + Hospitalisation (GEF)" itemValue="33"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Prix CNAMGS:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.prixCnamgs}" style="text-align:right" readonly="true" disabled="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelLigne}" var="acte" >
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText  value="#{acte.ligProduit}"/>
                            </rich:column>
                            <rich:column sortable="false" width="22%">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:inputTextarea rows="1" value="#{acte.ligLibelle}" readonly="true" style="width:95%"/>
                            </rich:column>
                            <rich:column label="Code lettre" sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                <h:outputText value="#{acte.ligLettre}: #{acte.ligNb}*#{acte.ligValeur}" rendered="#{acte.ligNb!=0}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right" width="5%" >
                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                <h:outputText value="#{acte.ligQte}" />
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%">
                                <f:facet name="header"><h:outputText value="P.U. ST"/></f:facet>
                                <h:outputText value="#{acte.ligPuRem}" rendered="#{acte.ligPuRem!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                <f:facet name="header"><h:outputText value="P.U.CNAMGS"/></f:facet>
                                <h:outputText value="#{acte.ligPuCnamgs}" rendered="#{acte.ligPuCnamgs!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%">
                                <f:facet name="header"><h:outputText value="P.U.ASSUR."/></f:facet>
                                <h:outputText value="#{acte.ligPuAssurance}" rendered="#{acte.ligPuAssurance!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="5%">
                                <f:facet name="header"><h:outputText  value="R/R"/></f:facet>
                                <h:outputText value="#{acte.ligRemise}" rendered="#{acte.ligRemise!=0}" />
                                <h:outputText value="#{acte.ligRabais}" rendered="#{acte.ligRabais!=0}" />
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%">
                                <f:facet name="header"><h:outputText value="Assur."/></f:facet>
                                <h:outputText value="#{acte.ligAssuranceHt}" rendered="#{acte.ligAssuranceHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%">
                                <f:facet name="header"><h:outputText value="Soc."/></f:facet>
                                <h:outputText value="#{acte.ligSocieteHt}" rendered="#{acte.ligSocieteHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%">
                                <f:facet name="header"><h:outputText value="Compl."/></f:facet>
                                <h:outputText value="#{acte.ligComplementaireHt}" rendered="#{acte.ligComplementaireHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="7%">
                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                <h:outputText value="#{acte.ligPatientHt}" rendered="#{acte.ligPatientHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerChangerDocumentCtrl}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.documentMedical.docEtat<=4}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelListeTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelListeTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelListeTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionligneTiers}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                        <h:outputText value="#{tiers.tiecategorie}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="55%">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{tiers.tieprenom}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{tiers.tiecivilite}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleTiers}" reRender="panelListeTiers,idTiers1,idTiers2"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calculeTiers}" reRender="panelListeTiers,idTiers1,idTiers2"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelListePatients" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPatients}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPatients}" var="pat">
            <f:facet name="header"><h:outputText value="Sélection du patient"/></f:facet>
            <a4j:form id="formModalListePatients">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:extendedDataTable id="tablePatients" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelPatients}" var="patient">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionlignePatients}"/>
                    <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{patient.patDossier}" width="10%">
                        <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                        <h:outputText value="#{patient.patDossier}"  style="#{patient.couleur}" title="#{patient.patDossier}"/>
                    </rich:column>
                    <rich:column label="Nature" sortable="true" sortBy="#{patient.patPorte}" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                        <h:outputText value="#{patient.patPorte}"  style="#{patient.couleur}" title="#{patient.patPorte}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{patient.patCivilite}" width="5%">
                        <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                        <h:outputText value="#{patient.patCivilite}"  style="#{patient.couleur}" title="#{patient.patCivilite}"/>
                    </rich:column>
                    <rich:column label="Nom et prénom" sortable="true" sortBy="#{patient.patNom} #{patient.patPrenom}" width="16%" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                        <h:outputText value="#{patient.patNom} #{patient.patPrenom}"  style="#{patient.couleur}" title="#{patient.patNom} #{patient.patPrenom}"/>
                    </rich:column>
                    <rich:column label="Date de naissance" sortable="true" sortBy="#{patient.patDateNaissance}" width="7%">
                        <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                        <h:outputText value="#{patient.patDateNaissance}"  style="#{patient.couleur}" title="#{patient.patDateNaissance}">
                            <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="N° C.I. ou N° Passport" sortable="true" sortBy="#{patient.cipasseport}" width="10%">
                        <f:facet name="header" ><h:outputText value="C.I./P.P."/></f:facet>
                        <h:outputText value="#{patient.cipasseport}" title="#{patient.cipasseport}" style="#{patient.couleur}"/>
                    </rich:column>
                    <rich:column label="N° téléphone domicile, mobile1, mobile2, mobile3" sortable="true" sortBy="#{patient.telephone}" width="7%">
                        <f:facet name="header" ><h:outputText value="Cellulaire"/></f:facet>
                        <h:outputText value="#{patient.telephone}"  style="#{patient.couleur}" title="#{patient.telephone}"/>
                    </rich:column>
                    <rich:column label="Adresse" sortable="true" sortBy="#{patient.patAdresse}" width="10%">
                        <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                        <h:outputText value="#{patient.patAdresse}"  style="#{patient.couleur}" title="#{patient.patAdresse}"/>
                    </rich:column>
                    <rich:column label="Mode de Prise en charge" sortable="true" sortBy="#{patient.libelleFamille}" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Pec."/></f:facet>
                        <h:outputText value="#{patient.libelleFamille}"  style="#{patient.couleur}" title="#{patient.libelleFamille}"/>
                    </rich:column>
                    <rich:column label="N° Contrat ou matricule" sortable="true" sortBy="#{patient.patNumContrat} #{patient.patImmatriculation}" width="10%">
                        <f:facet name="header" ><h:outputText value="Contrat/Matric."/></f:facet>
                        <h:outputText value="#{patient.patNumContrat}"  style="#{patient.couleur}" title="#{patient.patNumContrat}" rendered="#{patient.patNumContrat!=null}"/>
                        <h:outputText value="#{patient.patImmatriculation}"  style="#{patient.couleur}" title="#{patient.patImmatriculation}" rendered="#{patient.patImmatriculation!=null}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Client Société" sortable="true" sortBy="#{patient.patSociete}" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Société"/></f:facet>
                        <h:outputText value="#{patient.patSociete}"  style="#{patient.couleur}" title="#{patient.patSociete}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Assurance/IPM" sortable="true" sortBy="#{patient.patAssurance}" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Assurance/IPM"/></f:facet>
                        <h:outputText value="#{patient.patAssurance}"  style="#{patient.couleur}" title="#{patient.patAssurance}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Mutuelle/Complémentaire" sortable="true" sortBy="#{patient.patComplementaire}" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Mutuelle/Complémentaire"/></f:facet>
                        <h:outputText value="#{patient.patComplementaire}"  style="#{patient.couleur}" title="#{patient.patComplementaire}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanPatient" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulePatients}" reRender="panelListePatients,idPatients"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValPatient" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calculePatients}" reRender="panelListePatients,idPatients"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanPatient')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValPatient')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelVisuFactureTier" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelFactureTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelFactureTiers}" var="fac">
            <f:facet name="header"><h:outputText value="Facture tier payeur"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerFactureTiers}" image="/images/close.gif" styleClass="hidelink" reRender="panelVisuFactureTier,tableCtrl"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <h:panelGrid  style="width:100%;">
                        <h:column><h:outputText value="N° facture:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facNum}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date facture:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facDate}" readonly="true" disabled="true"  inputSize="8" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="Tier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facNomTiers}" readonly="true" disabled="true"/></h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelDocumentTrace}" var="doclig">
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText  value="#{doclig.facligCode}" style="#{doclig.styleLigne}"/>
                            </rich:column>
                            <rich:column sortable="false" width="20%">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:outputText value="#{doclig.facligLibelle}" style="#{doclig.styleLigne}"/><br>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.optionMedical.decrmtPriVteStock=='1'}">
                                    <f:facet name="header"><h:outputText value="P.T.HT"  /></f:facet>
                                    <h:outputText value="#{doclig.facligPt}" rendered="#{doclig.facligPt!=0}" style="#{doclig.styleLigne}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.optionMedical.decrmtPriVteStock=='2'}">
                                    <f:facet name="header"><h:outputText value="P.T.TTC"  /></f:facet>
                                    <h:outputText value="#{doclig.facligTtc}" rendered="#{doclig.facligTtc!=0}" style="#{doclig.styleLigne}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </c:if>
                            </rich:column>
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Patient"/></f:facet>
                                <h:outputText value="#{doclig.facligDossier}: #{doclig.facligNom} #{doclig.facligPrenom}" style="#{doclig.styleLigne}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="N° document"/></f:facet>
                                <h:outputText value="#{doclig.facligNumConsultation}" style="#{doclig.styleLigne}" rendered="#{doclig.facligNumConsultation!=null}"/>
                                <h:outputText value="#{doclig.facligNumLaboratoire}" style="#{doclig.styleLigne}" rendered="#{doclig.facligNumLaboratoire!=null}"/>
                                <h:outputText value="#{doclig.facligNumPharmacie}" style="#{doclig.styleLigne}" rendered="#{doclig.facligNumPharmacie!=null}"/>
                                <h:outputText value="#{doclig.facligNumHospitalisation}" style="#{doclig.styleLigne}" rendered="#{doclig.facligNumHospitalisation!=null}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{doclig.facligDateVisite}" style="#{doclig.styleLigne}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                <h:outputText value="#{doclig.facligService}" style="#{doclig.styleLigne}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPrintRecu}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPrintRecu}" var="prt">
            <f:facet name="header"><h:outputText value="Impression : Choisissez un modèle et un format d'Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerImpressionCtrl}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="idSelectionImpression">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 0px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_modele_trf}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.modeleTrfItems}"/>
                        </h:selectOneMenu>
                        <br>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe  (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                                    <h:selectOneMenu id="impSelect4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerCtrlXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
