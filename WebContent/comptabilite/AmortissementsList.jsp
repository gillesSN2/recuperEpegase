<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fmrjamr">

    <center> <h2><h:outputText value="LISTE DES IMMOBILISATIONS" styleClass="titre"/></h2></center>

    <a4j:form >

        <h:panelGrid id="png1" columns="10"  styleClass="recherche"  width="100%" >
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_periode}" style="width:120px;" >
                    <f:selectItem itemLabel="Toutes Périodes" itemValue="0"/>
                    <f:selectItem itemLabel="Année en cours" itemValue="1"/>
                    <f:selectItem itemLabel="Années antérieures" itemValue="2"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesPeriodesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.razListe}" reRender="table,scrollTable,panelBtn"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_etat}" style="width:120px;" >
                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                    <f:selectItem itemLabel="Cessions" itemValue="1"/>
                    <f:selectItem itemLabel="Rebuts" itemValue="2"/>
                    <f:selectItem itemLabel="Tous les Amortis" itemValue="3"/>
                    <f:selectItem itemLabel="Amortis non sortis" itemValue="5"/>
                    <f:selectItem itemLabel="Amortis sortis" itemValue="6"/>
                    <f:selectItem itemLabel="En cours + Sortis de la période" itemValue="7"/>
                    <f:selectItem itemLabel="Tous sauf les sortis avant période" itemValue="8"/>
                    <f:selectItem itemLabel="Désactivé" itemValue="4"/>
                    <f:selectItem itemLabel="Sans date d'achat" itemValue="9"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.razListe}" reRender="table,scrollTable,panelBtn"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_nat_bien}" style="width:120px;">
                    <f:selectItem itemLabel="Toutes Natures" itemValue="100"/>
                    <f:selectItem itemLabel="Immobilier" itemValue="0"/>
                    <f:selectItem itemLabel="Mobilier" itemValue="1"/>
                    <f:selectItem itemLabel="Autre" itemValue="2"/>
                    <f:selectItem itemLabel="Caution" itemValue="3"/>
                    <f:selectItem itemLabel="Frais de constitution" itemValue="4"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.razListe}" reRender="table,scrollTable,panelBtn"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testactivite}">
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_activite}" style="width:120px;">
                    <f:selectItem itemLabel="Toutes activités" itemValue=""/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesActivitesItems}"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_localisation}" style="width:120px;" >
                    <f:selectItem itemLabel="Toutes localisations" itemValue=""/>
                    <f:selectItem itemLabel="Sans localisation" itemValue="****"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.meslocalisationsItems}"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_compte}" style="width:120px;" >
                    <f:selectItem itemLabel="Tous comptes" itemValue=""/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.lesComptesUtilisesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.razListe}" reRender="table,scrollTable,panelBtn"/>
                </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="N°"/>&nbsp;
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_numero}" size="5" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0"/>
            </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="Filtre"/>&nbsp;
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_filtretsd}" size="10"/>
            </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="Chassis"/>&nbsp;
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_chassis}" size="10"/>
            </h:panelGroup>
            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.recherche}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBtn,scrollTable,table,pngTotal"/>
            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
        </h:panelGrid>

        <h:panelGrid id="panelBtn" columns="9" width="500px" style="height:34px">
            <a4j:commandButton image="/images/ajouter.png" title="Ajouter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.ajoutImmo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffAjout)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/modifier.png" title="Modifier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.modifImmo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffModif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoId!=0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/detail.png" title="Consulter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.consultImmo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoId!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <h:commandButton image="/images/supprimer.png" title="Supprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.removeSelectedImmo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffSupp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoId!=0)==true}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
            <a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton image="/images/grapheur.png" title="Graphe Immobilisations" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.initGrapheur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelGraph"/>
            <a4j:commandButton image="/images/transferer.png" title="Transférer" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.trf&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffAjout)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.openModalPanel}" oncomplete="javascript:Richfaces.showModalPanel('panelTransfert');" reRender="panelTransfert"/>
            <a4j:commandButton title="Génération QRCODE" image="/images/qrcode.png" style="height:26px;width:26px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.printQrCode}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoId!=0}" reRender="panelQrCode"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.datamodelAmortissement}" var="amortis" id="table" rowClasses="rows1,rows2,rowsd" width="180%"  activeRowKey="true" rowKeyVar="rkv" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.simpleSelectionEntete}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.selectionAmortissement}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBtn"/>
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.visualisationLigne}" reRender="idSubView,panelBtn"/>
                    <rich:column width="40px"  sortable="true" sortBy="#{amortis.select}" label="Sélection pour impression">
                        <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                        <h:selectBooleanCheckbox value="#{amortis.select}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="N° amortissement" width="50px" sortable="true" sortOrder="ASCENDING" sortBy="#{amortis.amoNum}" >
                        <f:facet name="header"><h:outputText value="Num." /></f:facet>
                        <h:outputText value="#{amortis.amoNum}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Désignation" width="200px" sortable="true" sortBy="#{amortis.amoLibelle}">
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{amortis.amoLibelle}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Date d'achat" style="text-align:right;" sortable="true" sortBy="#{amortis.amoDateAchat}">
                        <f:facet name="header"><h:outputText  value="Date d'achat" /></f:facet>
                        <h:outputText value="#{amortis.amoDateAchat}" style="color:#{amortis.couleur}">
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Photo Produit" width="35px" sortable="true">
                        <f:facet name="header" ><h:outputText value="Pho."/></f:facet>
                        <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/amortissement/photo/#{amortis.amoPhoto}" alt="pho" height="30px" width="30px" style="text-align:center" rendered="#{amortis.amoPhoto!=null}"/>
                    </rich:column>
                    <rich:column label="Scan Facture" width="35px" sortable="true">
                        <f:facet name="header" ><h:outputText value="Scan"/></f:facet>
                        <a4j:commandButton title="Afficher Scan" image="#{amortis.pj}" style="height:20px;width:20px" rendered="#{amortis.pj!=null}" reRender="panelScan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.afficherScan}"/>
                    </rich:column>
                    <rich:column label="Date de mise en service" style="text-align:right;" sortable="true" sortBy="#{amortis.amoDateService}">
                        <f:facet name="header"><h:outputText  value="Mise en service" /></f:facet>
                        <h:outputText value="#{amortis.amoDateService}" style="color:#{amortis.couleur}">
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column >
                    <rich:column label="Valeur d'achat" style="text-align:right;" sortable="true" sortBy="#{amortis.amoValeurAchat}">
                        <f:facet name="header"><h:outputText value="Val. achat" /></f:facet>
                        <h:outputText value="#{amortis.amoValeurAchat}" rendered="#{amortis.amoValeurAchat!=0}" style="color:#{amortis.couleur}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Taux comptable d'amortissement" style="text-align:right;" sortable="true" sortBy="#{amortis.amoTauxComptable}">
                        <f:facet name="header"><h:outputText  value="Taux comptable" /></f:facet>
                        <h:outputText value="#{amortis.amoTauxComptable}" rendered="#{amortis.amoTauxComptable!=0}" style="color:#{amortis.couleur}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:outputText>
                    </rich:column >
                    <rich:column label="Mode amortissement (Normal, Accéléré, Dégressif)" width="50px" style="text-align:center" sortable="true" sortBy="#{amortis.convertAmoMode}">
                        <f:facet name="header"><h:outputText value="NAD" /></f:facet>
                        <h:outputText value="#{amortis.convertAmoMode}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="N° compte immobilisation" sortable="true" sortBy="#{amortis.amoCompteImmo}" >
                        <f:facet name="header"><h:outputText value="Immob." /></f:facet>
                        <h:outputText value="#{amortis.amoCompteImmo}" rendered="#{amortis.amoCompteImmo!='null'}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="N° compte amortissement" sortable="true" sortBy="#{amortis.amoCompteAmo}" >
                        <f:facet name="header"><h:outputText value="Amort." /></f:facet>
                        <h:outputText value="#{amortis.amoCompteAmo}" rendered="#{amortis.amoCompteAmo!='null'}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="N° compte dotation" sortable="true" sortBy="#{amortis.amoCompteDotation}" >
                        <f:facet name="header"><h:outputText value="Dot." /></f:facet>
                        <h:outputText value="#{amortis.amoCompteDotation}" rendered="#{amortis.amoCompteDotation!='null'}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="N° compte cession" sortable="true" sortBy="#{amortis.amoCompteCes}" >
                        <f:facet name="header"><h:outputText value="Cession" /></f:facet>
                        <h:outputText value="#{amortis.amoCompteCes}" rendered="#{amortis.amoCompteCes!='null'}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Localisation amortissement" sortable="true" sortBy="#{amortis.amoLocalisation}">
                        <f:facet name="header"><h:outputText  value="Localisation"/></f:facet>
                        <h:outputText value="#{amortis.amoLocalisation}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Référence amortissement" sortable="true" sortBy="#{amortis.amoReference}">
                        <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                        <h:outputText value="#{amortis.amoReference}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="N° de série ou de chassis" sortable="true" sortBy="#{amortis.amoChassis}">
                        <f:facet name="header"><h:outputText value="N°sér. chas." /></f:facet>
                        <h:outputText value="#{amortis.amoChassis}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Etat" width="40px" style="text-align:center;" sortable="true" sortBy="#{amortis.etat}">
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:commandButton image="#{amortis.etat}"  id="inactifetat"  rendered="#{amortis.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver ce compte ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.reactiverCompte}">
                            <a4j:support eventsQueue="maQueue" reRender="table,scrollTable"/>
                        </h:commandButton>
                    </rich:column>
                    <rich:column label="Activité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testactivite}" sortable="true" sortBy="#{amortis.amoActivite}">
                        <f:facet name="header" ><h:outputText  value="Activité" /></f:facet>
                        <h:outputText value="#{amortis.amoActivite}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Site" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testsite}" sortable="true" sortBy="#{amortis.amoSite}">
                        <f:facet name="header" ><h:outputText  value="Site" /></f:facet>
                        <h:outputText value="#{amortis.amoSite}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Département" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testdept}" sortable="true" sortBy="#{amortis.amoDepartement}">
                        <f:facet name="header"><h:outputText value="Département" /></f:facet>
                        <h:outputText value="#{amortis.amoDepartement}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Service" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testservice}" sortable="true" sortBy="#{amortis.amoService}">
                        <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                        <h:outputText value="#{amortis.amoService}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Région" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testreg}" sortable="true" sortBy="#{amortis.amoRegion}">
                        <f:facet name="header"><h:outputText value="Région" /></f:facet>
                        <h:outputText value="#{amortis.amoRegion}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Secteur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testsecteur}" sortable="true" sortBy="#{amortis.amoSecteur}">
                        <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                        <h:outputText value="#{amortis.amoSecteur}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Point de vente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testPVD}" sortable="true" sortBy="#{amortis.amoPdv}">
                        <f:facet name="header"><h:outputText  value="P. de vente" /></f:facet>
                        <h:outputText value="#{amortis.amoPdv}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Dossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testDossier==1}" sortable="true" sortBy="#{amortis.amoDossier}">
                        <f:facet name="header"><h:outputText value="Dossier"/></f:facet>
                        <h:outputText value="#{amortis.amoDossier}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Parc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testParc}" sortable="true" sortBy="#{amortis.amoParc}">
                        <f:facet name="header"><h:outputText  value="Parc"/></f:facet>
                        <h:outputText value="#{amortis.amoParc}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Agent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.testagent}" sortable="true" sortBy="#{amortis.amoAgent}">
                        <f:facet name="header"><h:outputText  value="Agent"/></f:facet>
                        <h:outputText value="#{amortis.amoAgent}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Clé répartition"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.lireLesoptionsCompta.optionComptabilite.analytique}" sortable="true" sortBy="#{amortis.amoCle1}">
                        <f:facet name="header"><h:outputText value="Clé"/></f:facet>
                        <h:outputText value="#{amortis.amoCle1}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                    <rich:column label="Date de sortie" sortable="true" sortBy="#{amortis.amoDateSortie}">
                        <f:facet name="header"><h:outputText value="Date sortie" /></f:facet>
                        <h:outputText value="#{amortis.amoDateSortie}" style="color:#{amortis.couleur}">
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Valeur de sortie" style="text-align:right;" sortable="true" sortBy="#{amortis.amoValeurCession}">
                        <f:facet name="header"><h:outputText value="Val. cession" /></f:facet>
                        <h:outputText value="#{amortis.amoValeurCession}" rendered="#{amortis.amoValeurCession!=0}" style="color:#{amortis.couleur}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Informations complémentaires" width="200px" sortable="true" sortBy="#{amortis.amoInfosCpl}">
                        <f:facet name="header"><h:outputText value="Info. complémentaires" /></f:facet>
                        <h:outputText value="#{amortis.amoInfosCpl}" style="color:#{amortis.couleur}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>
        <br>
        <h:panelGroup>
            <center>
                <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.toutSelectionner}" reRender="table"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton value="Rien sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.rienSelectionner}" reRender="table"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton value="Inverser sélection" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.inverserSelection}" reRender="table"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="En cours" style="color:black;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Cession" style="color:blue;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Rebut" style="color:grey;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Complétement amorti" style="color:brown;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Désactivé" style="color:red;"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>
        <br>
        <h:panelGrid id="pngTotal" columns="3"  styleClass="recherche"  width="100%">
            <h:outputText value="[Nb ligne(s) : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.nbLigne}]   - TOTAL VALEUR DES ACHATS"  style=" font-weight:bold"/>
            <h:outputText  style=" font-weight:bold" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.totalValeurAchat}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
            <h:outputText value="( #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise} )" style=" font-weight:bold"/>
        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent" id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelQrCode" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelPrintQrCode}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelPrintQrCode}" var="qrc">
            <jsp:include flush="true" page="/commun/impressionUserQrCode.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelTransfert" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelTransfert}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelTransfert}" var="trf">
            <f:facet name="header"><h:outputText value="TRANSFERT AMORTISSEMENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton reRender="panelTransfert" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.closeModalPanel}"  image="/images/close.gif" styleClass="hidelink" id="hidelinkperd"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form>
                    <h:panelGrid columns="2">
                        <h:outputText value="Date de Debut"/>
                        <rich:calendar id="datedeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dateDebut}"  locale="fr"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"/>
                        <h:outputText value="Date de Fin"/>
                        <rich:calendar id="datefin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dateFin}"  locale="fr"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"/>
                    </h:panelGrid>
                    <center>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.preparationTransfertAmortissement}" style="margin-top:15px;" image="/images/valider_big.png" title="Valider" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.controleTransfertAmortissement}" style="margin-top:15px;" value="Contrôler Dotations/Ecritures" title="Controler le transfert" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTransfert,panelControle"/>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelControle" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="630" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelControle}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelControle}" var="crt">
            <f:facet name="header"><h:outputText value="CONTROLE AMORTISSEMENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton reRender="panelControle" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.fermerControle}"  image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.pageIndex}" reRender="tableCtrl" id="scrollTable" maxPages="20"align="left" for="tableCtrl"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.dataModelControle}" var="ctrl" id="tableCtrl" rowClasses="rows1,rows2,rowsd" width="100%">
                            <rich:column label="N° amortissement" width="50px" sortable="true" sortOrder="ASCENDING" sortBy="#{ctrl.docId}" >
                                <f:facet name="header"><h:outputText value="Num." /></f:facet>
                                <h:outputText value="#{ctrl.docId}"/>
                            </rich:column>
                            <rich:column label="Valeur dotation" style="text-align:right;" sortable="true" sortBy="#{ctrl.docTotHt}">
                                <f:facet name="header"><h:outputText value="Dotation" /></f:facet>
                                <h:outputText value="#{ctrl.docTotHt}" rendered="#{ctrl.docTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Valeur écriture" style="text-align:right;" sortable="true" sortBy="#{ctrl.docTotTva}">
                                <f:facet name="header"><h:outputText value="Ecriture" /></f:facet>
                                <h:outputText value="#{ctrl.docTotTva}" rendered="#{ctrl.docTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Valeur écart" style="text-align:right;" sortable="true" sortBy="#{ctrl.docTotTtc}">
                                <f:facet name="header"><h:outputText value="Ecart" /></f:facet>
                                <h:outputText value="#{ctrl.docTotTtc}" rendered="#{ctrl.docTotTtc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid width="100%" columns="2">
                        <h:column><h:outputText value="Tot. Dotation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.totDotation}" disabled="true" readonly="true" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Tot. Ecriture:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.totEcritures}" disabled="true" readonly="true" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Ecart:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.totEcart}" disabled="true" readonly="true" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelScan" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="900" autosized="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelScan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelScan}" var="trf">
            <f:facet name="header"><h:outputText value="Scan facture #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.amortissements.amoScan}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.fermerScan}" image="/images/close.gif" styleClass="hidelink" reRender="panelScan"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.typeFichier==0}" var="sc1">
                        <img alt="scan" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.urlphotoProd}" width="100%" height="800px"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.typeFichier==1}" var="sc2">
                        <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.fichierMine}" width="100%" height="550">
                            <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.fichierUrl}"></a>
                        </object>
                    </c:if>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="En nombre de biens" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par compte immobilisation" itemValue="1"/>
                                <f:selectItem itemLabel="par compte amortissement" itemValue="2"/>
                                <f:selectItem itemLabel="par compte dotation" itemValue="3"/>
                                <f:selectItem itemLabel="par nature" itemValue="4"/>
                                <f:selectItem itemLabel="par état" itemValue="5"/>
                                <f:selectItem itemLabel="par activité" itemValue="6"/>
                                <f:selectItem itemLabel="par localisation" itemValue="7"/>
                                <f:selectItem itemLabel="par site" itemValue="12"/>
                                <f:selectItem itemLabel="par département" itemValue="13"/>
                                <f:selectItem itemLabel="par service" itemValue="14"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.timeDecoupage}">
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>                

</f:subview>
