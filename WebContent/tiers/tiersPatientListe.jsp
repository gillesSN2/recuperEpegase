<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tiersPatient">

    <a4j:form id="formTiersPatient" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==0}">

        <center><h2><h:outputText styleClass="titre" value="GESTION : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="10" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nom}" /></h:column>
                <h:column><h:outputText value="Prénom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.prenom}"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:outputText value="Dossier entrée:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:outputText value="Dossier/Matricule:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dossier}"/></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.telephone}"/></h:column>
                <h:column><h:outputText value="C.I./P.P./Sécu.:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.carteIdentite}"/></h:column>
                <h:column><h:outputText value="Société:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.societe}"/></h:column>
                <h:column><h:outputText value="Assurance/IPM:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.assurance}"/></h:column>
                <h:column><h:outputText value="Mutuelle/Complémentaire:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.complementaire}"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:outputText value="N° Contrat/Mat.:"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_contrat}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:outputText value="Site:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}">
                    <h:selectOneMenu style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.site}">
                        <f:selectItem itemLabel="Tous les sites" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesSitesItem}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.chargerLesPatients}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid width="100%">
            <h:panelGrid columns="15" width="600px" id="btnTiers" style="height:34">
                <a4j:commandButton image="/images/ajouter.png" title="Ajout fiche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier fiche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/detail.png" title="Consulter fiche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/supprimer.png" title="Suppression fiche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerTiers}" reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
                <a4j:commandButton image="/images/print.png" title="Impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton image="/images/imp_word.png" style="height:26px;width:26px" title="Lettres de garantie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.lettreGarantie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/mouvementstock.png" title="Activites médicales" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.accesDocuments}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/calendrier.png" title="Planning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.accesPlanning}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/mail.png" title="Messagerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.accesMessagerie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/consultation.png" title="Ajouter une consultation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ajouterConsultationDirecte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtConsultation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/pharmacie.png" title="Ajouter une pharmacie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ajouterPharmacieDirecte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtPharmacie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/laboratoire.png" title="Ajouter un laboratoire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ajouterLaboratoireDirecte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtLaboratoire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/hospital.png" title="Ajouter une hospitalisation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ajouterHospitalisationDirecte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtHospitalisation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,modMessageCommun"/>
                <a4j:commandButton image="/images/parametre.png" title="Transfert en Ayant-Droit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ouvrirTrfAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIdCouvertPar==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtOption}" onclick="if (!confirm('Etes-vous sur de vouloir transférer ce patient en Ayant-Droit')) return false;" reRender="panelTrfAyantDroit"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px black;"  width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.pageIndex}" reRender="tableTiers" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dataModelPatients}" var="patient" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionPatient}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visualisationPatient}" reRender="idSubView,btnTiers"/>
                        <rich:column label="Nature" sortable="true" sortBy="#{patient.patPorte}" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}">
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{patient.patPorte}"  style="#{patient.couleur}" title="#{patient.patPorte}"/>
                        </rich:column>
                        <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{patient.patDossier}" width="10%">
                            <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                            <h:outputText value="#{patient.patDossier}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{patient.patCivilite}" width="5%">
                            <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                            <h:outputText value="#{patient.patCivilite}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" sortBy="#{patient.patNom} #{patient.patPrenom}" width="25%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                            <h:outputText value="#{patient.patNom} #{patient.patPrenom}" title="#{patient.patNom} #{patient.patPrenom}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Date de naissance" sortable="true" sortBy="#{patient.patDateNaissance}" width="10%">
                            <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                            <h:outputText value="#{patient.patDateNaissance}" style="#{patient.couleur}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="N° C.I. ou N° Passport" sortable="true" sortBy="#{patient.cipasseport}" width="10%">
                            <f:facet name="header" ><h:outputText value="C.I./P.P."/></f:facet>
                            <h:outputText value="#{patient.cipasseport}" title="#{patient.cipasseport}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="N° téléphone domicile, mobile1, mobile2, mobile3" sortable="true" sortBy="#{patient.telephone}" width="10%">
                            <f:facet name="header" ><h:outputText value="Téléphone"/></f:facet>
                            <h:outputText value="#{patient.telephone}" title="#{patient.telephone}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Adresse" sortable="true" sortBy="#{patient.patAdresse}" width="10%">
                            <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                            <h:outputText value="#{patient.patAdresse}" title="#{patient.patAdresse}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Mode de Prise en charge" sortable="true" sortBy="#{patient.libelleFamille}" width="7%">
                            <f:facet name="header" ><h:outputText value="Pec."/></f:facet>
                            <h:outputText value="#{patient.libelleFamille}" title="#{patient.libelleFamille}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Prise en charge Tiers" sortable="true" sortBy="#{patient.patSociete}#{patient.patAssurance}" width="13%">
                            <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{patient.patSociete}#{patient.patAssurance}" title="#{patient.patSociete}#{patient.patAssurance}" style="#{patient.couleur}"/>
                        </rich:column>
                        <rich:column label="Prise en charge Mutuelle/Complémentaire" sortable="true" sortBy="#{patient.patComplementaire}" width="13%">
                            <f:facet name="header" ><h:outputText value="Mutuelle/Complémentaire"/></f:facet>
                            <h:outputText value="#{patient.patComplementaire}" title="#{patient.patComplementaire}" style="#{patient.couleur}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
            <br>
            <h:panelGroup>
                <center>
                    <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Assuré prinicpal" style="color:black;"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Ayant droit" style="color:blue;"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_choix_modele}" >
                            <f:selectItem itemLabel="Patient séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste des patients" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelTrfAyantDroit" headerClass="headerPanel" width="500" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelTrfAyantDroit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelTrfAyantDroit}" var="spt">
            <f:facet name="header"><h:outputText value="TRANSFERT EN AYANT DROIT: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patronyme} N°: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDossier}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerTrfAyantDroit}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrfAyantDroit"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" columns="2" columnClasses="clos50g,clos50d" styleClass="fichefournisseur" id="idPatient">
                    <h:column><h:outputText value="N° dossier ou N° matricule assuré principal:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.numeroAssure}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Rechercher patient par numéro dossier" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.recherchePatient}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPatient,panelListeAssure"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nom et prénom assuré principal:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nomAssure}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="En qualité de:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.qualite}">
                            <f:selectItem itemLabel="Conjoint(e)" itemValue="Conjoint(e)"/>
                            <f:selectItem itemLabel="Enfant" itemValue="Enfant"/>
                            <f:selectItem itemLabel="Parent direct" itemValue="Parent direct"/>
                            <f:selectItem itemLabel="Parent par alliance" itemValue="Parent par alliance"/>
                            <f:selectItem itemLabel="Famille proche" itemValue="Famille proche"/>
                            <f:selectItem itemLabel="Famille éloignée" itemValue="Famille éloignée"/>
                            <f:selectItem itemLabel="Famille par alliance" itemValue="Famille par alliance"/>
                            <f:selectItem itemLabel="Autre" itemValue="Autre"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.validerTrfAyantDroit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTrfAyantDroit,tableTiers"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeAssure" headerClass="headerPanel" width="900" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelListeAssure}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelListeAssure}" var="lst">
            <f:facet name="header"><h:outputText value="Liste des assurés"></h:outputText></f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tablePatient" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dataModelListAssure}"  var="patient">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionPatientAssure}" reRender="valpatient"/>
                            <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{patient.patient.patDossier}" width="10%">
                                <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                                <h:outputText value="#{patient.patient.patDossier}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{patient.patient.patCivilite}" width="10%">
                                <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                <h:outputText value="#{patient.patient.patCivilite}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="true" sortBy="#{patient.patient.patNom} #{patient.patient.patPrenom}" width="40%" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                                <h:outputText value="#{patient.patient.patNom} #{patient.patient.patPrenom}" title="#{patient.patient.patNom} #{patient.patient.patPrenom}"/>
                            </rich:column>
                            <rich:column label="Date de naissance" sortable="true" sortBy="#{patient.patient.patDateNaissance}" width="10%">
                                <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                                <h:outputText value="#{patient.patient.patDateNaissance}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="N° C.I." sortable="true" sortBy="#{patient.patient.patCi}" width="10%">
                                <f:facet name="header" ><h:outputText value="C.I."/></f:facet>
                                <h:outputText value="#{patient.patient.patCi}" title="#{patient.patient.patCi}"/>
                            </rich:column>
                            <rich:column label="N° mobile" sortable="true" sortBy="#{patient.patient.telephone}" width="10%">
                                <f:facet name="header" ><h:outputText value="Téléphone"/></f:facet>
                                <h:outputText value="#{patient.patient.telephone}" title="#{patient.patient.telephone}"/>
                            </rich:column>
                            <rich:column label="Adresse" sortable="true" sortBy="#{patient.patient.patAdresse}" width="10%">
                                <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                                <h:outputText value="#{patient.patient.patAdresse}" title="#{patient.patient.patAdresse}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermePatientAssure}" reRender="panelListeAssure,idPatient"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.validePatientAssure}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeAssure,idPatient"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>