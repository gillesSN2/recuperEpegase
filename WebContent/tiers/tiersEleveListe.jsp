<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tiersEleve">

    <a4j:form id="formTiersEleve" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==0}">

        <center><h2><h:outputText styleClass="titre" value="GESTION : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="12" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nom}" /></h:column>
                <h:column><h:outputText value="Prénom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.prenom}"/></h:column>
                <h:column><h:outputText value="Matricule:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.dossier}"/></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.telephone}"/></h:column>
                <h:column><h:outputText value="N° C.I.:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.carteIdentite}"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.filiere}" style="width:150px;">
                        <f:selectItem itemLabel="Toutes Filières/Classes" itemValue="0"/>
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesFiliairesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeFiliereRecherche}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerLesEleves}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid width="100%">
            <h:panelGrid columns="9" width="400px" id="btnTiers" style="height:34">
                <a4j:commandButton image="/images/ajouter.png" title="Ajout fiche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ajouterTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier fiche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/detail.png" title="Consulter fiche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.consulterTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/supprimer.png" title="Suppression fiche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
                <a4j:commandButton image="/images/print.png" title="Impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton image="/images/calendrier.png" title="Planning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.accesPlanning}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/mail.png" title="Messagerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ajoutElement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/histoPaiement.png" title="Situation financière" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.accesSituation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrFactureCaisse!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px black;"  width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.pageIndex}" reRender="tableTiers" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.dataModelEleves}" var="eleve" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selectionEleve}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.visualisationEleve}" reRender="idSubView,btnTiers"/>
                        <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{eleve.eleDossier}" width="10%">
                            <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                            <h:outputText value="#{eleve.eleDossier}"/>
                        </rich:column>
                        <rich:column label="N° Compte" sortable="true" sortBy="#{eleve.eleCompte0}" width="10%">
                            <f:facet name="header" ><h:outputText value="Compte"/></f:facet>
                            <h:outputText value="#{eleve.eleCompte0}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{eleve.eleCivilite}" width="10%">
                            <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                            <h:outputText value="#{eleve.eleCivilite}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{eleve.eleNomFamille}" width="10%">
                            <f:facet name="header" ><h:outputText value="Famille"/></f:facet>
                            <h:outputText value="#{eleve.eleNomFamille}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" sortBy="#{eleve.eleNom} #{eleve.elePrenom}" width="30%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                            <h:outputText value="#{eleve.eleNom} #{eleve.elePrenom}"/>
                        </rich:column>
                        <rich:column label="Date de naissance" sortable="true" sortBy="#{eleve.eleDateNaissance}" width="10%">
                            <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                            <h:outputText value="#{eleve.eleDateNaissance}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="N° mobile" sortable="true" sortBy="#{eleve.eleCel1}" width="10%">
                            <f:facet name="header" ><h:outputText value="Cellulaire"/></f:facet>
                            <h:outputText value="#{eleve.eleCel1}"/>
                        </rich:column>
                        <rich:column label="Adresse" sortable="true" sortBy="#{eleve.eleAdresse}" width="10%">
                            <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                            <h:outputText value="#{eleve.eleAdresse}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele}" >
                            <f:selectItem itemLabel="Elève séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste des élèves" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affListeDoc}">
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
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>