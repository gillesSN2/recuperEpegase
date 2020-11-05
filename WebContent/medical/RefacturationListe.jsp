<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="medicrefacturation">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="REFACTURATION AUX TIERS PAYANTS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}"/>
                    <h:column><h:outputText value="N° Fac."/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNum}" size="5"/></h:column>
                    <h:column><h:outputText value="Tiers" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:inputText id="idTiers1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNomTiers}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers,formModalListeTiers,tableTiers,idTiers1"/>
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_more_search}">
                    <h:column><h:outputText value="N° Récap."/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNumRecap}" size="5"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNomTiers=='CNAMGS'}"><h:outputText value="Fonds:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNomTiers=='CNAMGS'}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fondsCnamgs}" style="width:150px;">
                            <f:selectItem itemLabel="Tous les Fonds" itemValue="99"/>
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
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="12" width="450px" style="height:34px">
            <a4j:commandButton title="Ajouter nouvelle facturation" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.ajoutDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier facture sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.modifDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter facture sélectionnée" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.consultDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer facture sélectionnée" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.supprimerDocument}" reRender="modAttente,panelBouton,table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}"/>
            <a4j:commandButton title="imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp,formModalImp,panchoixdoc,optionMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" reRender="panelGraph,formModalGraph,container"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.initGrapheur}"/>
            <a4j:commandButton title="Imputer la série" image="/images/boussole.png" oncomplete="javascript:Richfaces.showModalPanel('panelimpSerie');" reRender="panelimpSerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.accesImputSerie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facSerie=='X'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.clo}"/>
            <a4j:commandButton title="Paiement (direct) du document sélectionné" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.payeXDocumentRecu}" reRender="panelPayeXDoc,panelBouton,modMessage" />
            <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement,idformHisto,idRegBouton" />
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Imputer les règlements dans les documents médicaux" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.factureEnteteMedical.facTotReglement!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imputationReglement}" onclick="if (!confirm('Etes-vous sur de vouloir imputer les réglements dans les documents médicaux?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelBouton,table"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelEntete}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.visualisationLigne}" reRender="idSubView,panelBouton"/>
                        <rich:column label="N° Récapitulatif" sortable="true" sortBy="#{var.facNumRecap}" width="50px" >
                            <f:facet name="header"><h:outputText  value="Récap." /></f:facet>
                            <h:outputText value="#{var.facNumRecap}" rendered="#{var.facNumRecap!=0}"/>
                        </rich:column>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}" >
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.facNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.facDate}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.facDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date début période" sortable="true" sortBy="#{var.facDateDebut}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{var.facDateDebut}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin période" sortable="true" sortBy="#{var.facDateFin}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{var.facDateFin}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.facSerie}"/>
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.facCat}" width="70px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.facCat}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.facEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.trf}">
                            <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.facEtat==1||var.facEtat==4)&&var.facSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Tiers" sortable="true" sortBy="#{var.facNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="tiers"  /></f:facet>
                            <h:outputText  value="#{var.facNomTiers}" />
                        </rich:column>
                        <rich:column label="Adhérent" sortable="true" sortBy="#{var.facNomAdherent}" width="200px">
                            <f:facet name="header"><h:outputText  value="Adhérent/localisation"  /></f:facet>
                            <h:outputText  value="#{var.facNomAdherent}" rendered="#{var.facIdAdherent!=0}"/>
                            <h:outputText  value="#{var.facSecteurAgent}" rendered="#{var.facSecteurAgent!=null}"/>
                            <h:outputText  value="#{var.libelleFonds}" rendered="#{var.facFondCnamgs!=0}"/>
                        </rich:column>
                        <rich:column label="Total T.T.C." sortable="true" sortBy="#{var.facTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                            <h:outputText  value="#{var.facTotTtc}" rendered="#{var.facTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Reg. Tiers" sortable="true" sortBy="#{var.facTotReglement}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Réglement"/></f:facet>
                            <h:outputText  value="#{var.facTotReglement}" rendered="#{var.facTotReglement!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                            <f:facet name="header"><h:outputText value="Solde"/></f:facet>
                            <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.facObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText  value="#{var.facObject}"/>
                        </rich:column>
                        <rich:column label="Secteur Agent" sortable="true" sortBy="#{var.facSecteurAgent}" width="200px">
                            <f:facet name="header"><h:outputText value="Secteur"/></f:facet>
                            <h:outputText  value="#{var.facSecteurAgent}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%">
            <h:panelGrid columns="2" >
                <h:outputText value="Total Tiers" />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText  value="Réglements Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText value="Solde Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantSolde}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="1">
                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelAjouter" width="1200" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelAjouter}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelAjouter}" var="ajt">
            <f:facet name="header"><h:outputText value="REFACTURATION AUX TIERS PAYEURS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerAjout}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelAjouter"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idPannelGlobal">
                    <h:panelGrid  columns="6" style="width:100%;" styleClass="recherche" id="idRecherche">
                        <h:column><h:outputText value="Date début:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateDebut}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="Date fin:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateFin}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column rendered="false"><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpSerie}" style="width:100px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode regroupement:" style="color:red"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement}" >
                                <f:selectItem itemLabel="Par tiers" itemValue="0"/>
                                <f:selectItem itemLabel="Par assurances/adhérents ou sociétés/motifs entrée" itemValue="1"/>
                                <f:selectItem itemLabel="Par factures controlées" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.razListeRecherche}" reRender="idSelectionRegroupement,idRecherche"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Tiers payeurs:" style="color:red"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpTiersPayeurs}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.lesTiersPayeurs}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.razListeRecherche}" reRender="idSelectionRegroupement,idTiers2,idPannelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° Feuille:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement=='2'}"/></h:column>
                        <h:column id="idFeuille" >
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpFeuille}" size="6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement=='2'}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche N° feuille (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheFeuille}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers,idRecherche" />
                            </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Nom patient:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement=='2'}"/>&nbsp;&nbsp;
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nomPatientDocument}" size="6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement=='2'}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche patient...(puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recherchePatients}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListePatient,tableTiers,idRecherche" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nom du tier:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idTiers2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpNomTiers}" style="width:90%">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers,formModalListeTiers,tableTiers,idTiers2" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date Facture:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dateFacture}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="Nb lignes total:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nbLigneTotal}" style="text-align:center" readonly="true" disabled="true" size="4"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Nb lignes Sélect.:"/>&nbsp;&nbsp;
                            <h:inputText id="idNbLigSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nbLigneSelect}" style="text-align:center" readonly="true" disabled="true" size="4"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="Num. BC.:"/>&nbsp;&nbsp;
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.numBc}" style="text-align:center" size="4"/>
                        </h:column>
                        <h:column>
                            <a4j:commandButton title="Rechercher Tiers concernés" value="Rechercher documents" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheTiersConcernes}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers,idPannelGlobal,idRecherche"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Effacer Sélection" value="Effacer Sélection" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.razListeRecherche}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers,idPannelGlobal,idRecherche"/>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup id="idSelectionRegroupement">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement!=2}" var="gr1">
                                <h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pageIndex}" reRender="table" id="scrollTableTiers" maxPages="20"align="left" for="tableTiers"/>
                                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_max}" styleClass="bg" id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="95%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelTiersConcernes}"  var="tie">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionTiers}" reRender="idNbLigSel"/>
                                            <rich:column label="Sélection du tiers" sortable="true" sortBy="#{tie.docSelect}" width="10%">
                                                <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{tie.docSelect}"/>
                                            </rich:column>
                                            <rich:column label="Nom du tiers" sortable="true" sortBy="#{tie.docNomTiers}" width="30%" sortOrder="ASCENDING">
                                                <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                                <h:outputText value="#{tie.docNomTiers}" title="#{tie.docNomTiers}"/>
                                            </rich:column>
                                            <rich:column label="Nature du tiers" sortable="true" sortBy="#{tie.docLibelle}" style="text-align:center;" width="15%">
                                                <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                                <h:outputText value="#{tie.docLibelle}" title="#{tie.docLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Nom du tiers adhérent" sortable="true" sortBy="#{tie.docNomEquipe}" width="15%">
                                                <f:facet name="header"><h:outputText  value="Adhérent/Motif Entrée" /></f:facet>
                                                <h:outputText value="#{tie.docNomEquipe}#{tie.docEntree}" title="#{tie.docNomEquipe}#{tie.docEntree}"/>
                                            </rich:column>
                                            <rich:column label="Localisation" sortable="true" sortBy="#{tie.docSource}" width="15%">
                                                <f:facet name="header"><h:outputText  value="BC" /></f:facet>
                                                <h:outputText value="#{tie.docNumBon}" title="#{tie.docNumBon}"/>
                                            </rich:column>
                                            <rich:column label="Origine" sortable="true" sortBy="#{tie.docObject}" width="15%">
                                                <f:facet name="header"><h:outputText  value="Origine" /></f:facet>
                                                <h:outputText value="#{tie.docObject}" title="#{tie.docObject}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.inpRegroupement==2}" var="gr2">
                                <h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pageIndex}" reRender="table" id="scrollTableTiers" maxPages="20"align="left" for="tableTiers"/>
                                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_max}" styleClass="bg" id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="95%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelTiersConcernes}"  var="tie">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionTiers}" reRender="idNbLigSel"/>
                                            <rich:column label="Sélection facture" sortable="true" sortBy="#{tie.docSelect}" width="5%">
                                                <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{tie.docSelect}"/>
                                            </rich:column>
                                            <rich:column label="N° facture" sortable="true" sortBy="#{tie.docNum}" width="8%" sortOrder="ASCENDING">
                                                <f:facet name="header"><h:outputText  value="N° Fac." /></f:facet>
                                                <h:outputText value="#{tie.docNum}" title="#{tie.docNum}"/>
                                            </rich:column>
                                            <rich:column label="Nom du patient" sortable="true" sortBy="#{tie.docNomTiers}" width="15%">
                                                <f:facet name="header"><h:outputText  value="Nom Patient" /></f:facet>
                                                <h:outputText value="#{tie.docNomTiers}" title="#{tie.docNomTiers}"/>
                                            </rich:column>
                                            <rich:column label="Matricule" sortable="true" sortBy="#{tie.docCodeBanq}" width="10%">
                                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                                <h:outputText value="#{tie.docCodeBanq}" title="#{tie.docCodeBanq}"/>
                                            </rich:column>
                                            <rich:column label="Motif entrée" sortable="true" sortBy="#{tie.docEntree}" width="10%">
                                                <f:facet name="header"><h:outputText  value="Motif En." /></f:facet>
                                                <h:outputText value="#{tie.docEntree}" title="#{tie.docEntree}"/>
                                            </rich:column>
                                            <rich:column label="N° Feuille" sortable="true" sortBy="#{tie.docNumDocument}" width="10%">
                                                <f:facet name="header"><h:outputText  value="N° Feuille" /></f:facet>
                                                <h:outputText value="#{tie.docNumDocument}" title="#{tie.docNumDocument}"/>
                                            </rich:column>
                                            <rich:column label="Service" sortable="true" sortBy="#{tie.docService}" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                                <h:outputText value="#{tie.docService}" title="#{tie.docService}"/>
                                            </rich:column>
                                            <rich:column label="Nom du tiers adhérent" sortable="true" sortBy="#{tie.docNomContact} #{tie.docNomCommercial}" width="15%">
                                                <f:facet name="header"><h:outputText  value="Tiers/Adhérents" /></f:facet>
                                                <h:outputText value="#{tie.docNomContact}   #{tie.docNomCommercial}" title="#{tie.docNomContact} #{tie.docNomCommercial}"/>
                                            </rich:column>
                                            <rich:column label="Total facture" sortable="true" sortBy="#{tie.docTotTtx}" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Total factures" /></f:facet>
                                                <h:outputText value="#{tie.docTotTtc}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Total part du tier" sortable="true" sortBy="#{tie.docTotHt}" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Total tiers" /></f:facet>
                                                <h:outputText value="#{tie.docTotHt}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </c:if>
                        </h:panelGroup>
                    </center>
                </rich:panel>
                <br/>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton value="Sélectionner Assurances" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.toutSelectionnerAssurances}" reRender="tableTiers"/>&nbsp;&nbsp;
                        <a4j:commandButton value="Sélectionner Sociétés" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.toutSelectionnerSocietes}" reRender="tableTiers"/>&nbsp;&nbsp;
                        <a4j:commandButton value="Tout Désélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.toutDeselectionner}" reRender="tableTiers"/><br><br>
                        <a4j:commandButton value="Impression Simulation facture" title="Simulation facture" style="color:blue" reRender="panelImpSimulation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerSimulationPeriode}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Génération facturation" title="Génération facturation" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.generationPeriode}" onclick="if (!confirm('Etes-vous sur de vouloir générer les factures des éléments sélectionnés ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAjouter,panelPatientsRejetes,panelBouton,table,scrollTable"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelImpSimulation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPrintSimulation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPrintSimulation}" var="prt">
            <f:facet name="header"><h:outputText value="Impression : Choisissez un modèle et un format d'Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerSimulationPeriode}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpSimulation">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="idSelectionImpression">
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerJRVSimu}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerPDFSimu}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerODTSimu}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerXLSSimu}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerDOCSimu}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerHTMLSimu}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.imprimerXMLSimu}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par mèdecin" itemValue="1"/>
                                <f:selectItem itemLabel="par prescripteur" itemValue="2"/>
                                <f:selectItem itemLabel="par patient" itemValue="3"/>
                                <f:selectItem itemLabel="par assurance" itemValue="4"/>
                                <f:selectItem itemLabel="par complémentaire" itemValue="5"/>
                                <f:selectItem itemLabel="par société" itemValue="6"/>
                                <f:selectItem itemLabel="par motif entrée" itemValue="7"/>
                                <f:selectItem itemLabel="par protocole" itemValue="8"/>
                                <f:selectItem itemLabel="par pathologie" itemValue="9"/>
                                <f:selectItem itemLabel="par service" itemValue="10"/>
                                <f:selectItem itemLabel="par actes" itemValue="20"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelimpSerie"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelinkImput" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesSeriesUsersItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="serieimput"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesPecItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.miseajourImput}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPayeXDoc" width="1100" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelReglement}" var="pay">
            <f:facet name="header"><h:outputText value="Règlement direct de plusieurs documents"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerXReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelPayeXDoc"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPayeXDoc">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelGlobal" width="100%">
                    <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_date_trf}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_inputCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesCaissesSeriesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.choixCaisseXReglement}" reRender="panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_type_reg}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesTypeReglements}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.choixTypeReglement}" reRender="firstgridd,panelGlobal,bnqajt,idEncais2,idImp1,idImp2,table,idBnq1,idBnq2,idEcart3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.nomRepMod})" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_modele_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesModesleRecus}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_banque_destination}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_banque_destination}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.mesBanquesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Montant règlement:"/>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantElmTotBonEnc}" onkeypress="return scanToucheChiffre(event)">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.verifValide}" reRender="panelGlobal,ppgrp,idEcart0,idEcart1,idEcart2,idEcart3"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Net à payer:"/></h:column>
                        <h:column>
                            <h:inputText id="idNetPayer" style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_netAPayer}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_objet}" maxlength="50" style="width:50%;"/>&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.repartitionManuelle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelTransfert.rowCount>=2}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.controleEcartRepartitionManuelle}" reRender="ppgrp,table,firstgridd,idEcart1,idEcart2"/>
                            </h:selectBooleanCheckbox>&nbsp;
                            <h:outputText value="Répartition manuelle" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelTransfert.rowCount>=2}"/>
                        </h:column>
                        <h:column><h:outputText value="Ecart:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.repartitionManuelle}">
                            <h:inputText id="idEcart0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_ecart_reglement}" readonly="true" style="width:100%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.repartitionManuelle}">
                            <h:inputText id="idEcart1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_ecart_reglement}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;&nbsp;
                            <h:inputText id="idEcart2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.ecartManuel}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_banque}">
                        <h:column><h:outputText value="Banque du tireur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_num_cheque}" maxlength="50"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEcart3" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.varTypeReg==0}">
                        <h:column><h:outputText value="Montant timbre:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.val_timbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total dû (réglement + timbre)"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.totalPayerTimbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelTransfert}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calulNetPayer}" reRender="idNetPayer,panelGalobal"/>
                            <rich:column label="N° facture" sortable="false">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{var.facNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.facDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.facSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.facCat}"/>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant Timbre" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.varTypeReg==0}">
                                <f:facet name="header"><h:outputText  value="Timbre"/></f:facet>
                                <h:outputText  value="#{var.var_fac_timbre}" rendered="#{var.var_fac_timbre!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.facTotReglement}" rendered="#{var.facTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="false" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Répartition manuelle" sortable="false" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.repartitionManuelle}">
                                <f:facet name="header"> <h:outputText value="Règlement"/></f:facet>
                                <h:inputText  value="#{var.montantReglementManuel}" style="text-align:right;width:90%;" onkeypress="return scanToucheChiffre(event)">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.controleEcartRepartitionManuelle}" reRender="ppgrp,idEcart1,idEcart2"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Tiers" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Tiers"  /></f:facet>
                                <h:outputText  value="#{var.var_nom_tiers}"/>
                            </rich:column>
                            <rich:column label="Objet de la facture" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                <h:outputText  value="#{var.facObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                        <h:panelGroup id="ppgrp">
                            <center>
                                <br><br>
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerXreglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <br>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_affiche_valide}" style="margin-left:50px;">
                                    <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                    <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                                </h:panelGroup>
                            </center>
                        </h:panelGroup>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idformHisto">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/medical/RefactureCommun.jsp" />
                    <center>
                        <h:panelGroup id="idRegBouton">
                            <a4j:commandButton title="Changer la date ou la caisse du réglement sélectionné" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectPatient&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements.rglId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.reglements.rglDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectPatient&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.modifReglement}" reRender="panelModificationReglement"/>
                        </h:panelGroup>
                    </center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" id="idTableReglementCtrl" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelRecu}"  var="recu"  sortMode="multi">
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


    <rich:modalPanel domElementAttachment="parent" id="panelListeTiers" headerClass="headerPanel"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelListeTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelListeTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.datamodelListeTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionligneTiers}"/>
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
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleTiers}" reRender="panelListeTiers,idTiers1,idTiers2,panCtrl"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.calculeTiers}" reRender="panelListeTiers,idTiers1,idTiers2,panCtrl"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelListePatient" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPatients}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPatients}" var="pat">
            <f:facet name="header"><h:outputText value="Sélection du patient"/></f:facet>
            <a4j:form id="formModalListePatient">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:extendedDataTable id="tablePatient" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelPatients}" var="patient">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionlignePatients}"/>
                    <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{patient.patDossier}" width="10%">
                        <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                        <h:outputText value="#{patient.patDossier}"  style="#{patient.couleur}" title="#{patient.patDossier}"/>
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
                    <rich:column label="Mode de Prise en charge" sortable="true" sortBy="#{patient.libelleFamille}" width="5%">
                        <f:facet name="header" ><h:outputText value="Pec."/></f:facet>
                        <h:outputText value="#{patient.libelleFamille}"  style="#{patient.couleur}" title="#{patient.libelleFamille}"/>
                    </rich:column>
                    <rich:column label="N° Contrat ou matricule" sortable="true" sortBy="#{patient.patNumContrat} #{patient.patImmatriculation}" width="10%">
                        <f:facet name="header" ><h:outputText value="Contrat/Matric."/></f:facet>
                        <h:outputText value="#{patient.patNumContrat}"  style="#{patient.couleur}" title="#{patient.patNumContrat}" rendered="#{patient.patNumContrat!=null}"/>
                        <h:outputText value="#{patient.patImmatriculation}"  style="#{patient.couleur}" title="#{patient.patImmatriculation}" rendered="#{patient.patImmatriculation!=null}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Client Société" sortable="true" sortBy="#{patient.patSociete}" width="10%">
                        <f:facet name="header" ><h:outputText value="Société"/></f:facet>
                        <h:outputText value="#{patient.patSociete}"  style="#{patient.couleur}" title="#{patient.patSociete}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Assurance/IPM" sortable="true" sortBy="#{patient.patAssurance}" width="10%">
                        <f:facet name="header" ><h:outputText value="Assurance/IPM"/></f:facet>
                        <h:outputText value="#{patient.patAssurance}"  style="#{patient.couleur}" title="#{patient.patAssurance}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanPatient" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulePatients}" reRender="panelListePatient"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValPatient" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.rechercheByPatient}" reRender="idSelectionRegroupement,panelListePatient,tableTiers"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanPatient')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValPatient')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelPatientsRejetes" width="800" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPatientRejetes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelPatientRejetes}" var="rej">
            <f:facet name="header"><h:outputText value="Liste des patients rejetés lors de la refacuration"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.fermerPatientsRejetes}" image="/images/close.gif" styleClass="hidelink" reRender="panelPatientsRejetes"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelTiersRejetes}"  var="prj"  sortMode="multi">
                            <rich:column sortable="false" width="20%">
                                <f:facet name="header"><h:outputText  value="N° Dossier"/></f:facet>
                                <h:outputText value="#{prj.docLibelle}"/>
                            </rich:column>
                            <rich:column sortable="false" width="40%">
                                <f:facet name="header"><h:outputText  value="Nom ptient"/></f:facet>
                                <h:outputText  value="#{prj.docNomTiers}"/>
                            </rich:column>
                            <rich:column sortable="false" width="40%">
                                <f:facet name="header"><h:outputText  value="Document rejeté"/></f:facet>
                                <h:outputText  value="#{prj.docObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
