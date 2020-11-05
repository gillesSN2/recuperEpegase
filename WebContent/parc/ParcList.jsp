<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeparc">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DU PARC" style="color:green;"/></h2></center>

        <h:panelGrid  columns="8" styleClass="recherche"  width="100%" id="panelRecherche">
            <h:column><h:outputText value="Immat.:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_immat_rec}" style="width:100px"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_nature_rec}">
                    <f:selectItem itemLabel="Toutes natures" itemValue="100"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesNatureItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_famille_rec}">
                    <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesFamilleItems_rec}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_origine_rec}">
                    <f:selectItem itemLabel="Toutes origines" itemValue="100"/>
                    <f:selectItem itemLabel="Interne" itemValue="0"/>
                    <f:selectItem itemLabel="Externe" itemValue="1"/>
                    <f:selectItem itemLabel="Fabriqué" itemValue="2"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_mode_rec}">
                    <f:selectItem itemLabel="Tous modes" itemValue="100"/>
                    <f:selectItem itemLabel="En Fonction" itemValue="0"/>
                    <f:selectItem itemLabel="En Arrêt" itemValue="1"/>
                    <f:selectItem itemLabel="En Panne" itemValue="2"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_service_rec}">
                    <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesServiceItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.rechercherParc}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,scrollTable,boutonParc,tableParc"/>
                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
            </h:column>
        </h:panelGrid>

        <h:panelGrid  id="boutonParc" columns="6" width="300px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouveau parc" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.ajouterParc}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le parc sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.modifierParc}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter la parc sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.consulterParc}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le parc sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.supprimerParc}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.pageIndex}" reRender="tableParc" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_nb_max}" border="0" id="tableParc" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="150%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelParc}" var="parc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.visualisationLigne}" reRender="idSubView,boutonParc"/>
                        <rich:column label="Nature" sortable="true" sortOrder="#{parc.prcLibNature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{parc.prcLibNature}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortOrder="#{parc.prcLibFamille}">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{parc.prcLibFamille}"/>
                        </rich:column>
                        <rich:column label="Sous famille" sortable="true" sortOrder="#{parc.prcLibSousFamille}">
                            <f:facet name="header"><h:outputText  value="S.Famille" /></f:facet>
                            <h:outputText value="#{parc.prcLibSousFamille}"/>
                        </rich:column>
                        <rich:column label="Immatriculation ou identification" sortable="true" sortOrder="#{parc.prcImmatriculation}">
                            <f:facet name="header"><h:outputText  value="Immat." /></f:facet>
                            <h:outputText value="#{parc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Marque" sortable="true" sortOrder="#{parc.prcMarque}">
                            <f:facet name="header"><h:outputText  value="Marque" /></f:facet>
                            <h:outputText value="#{parc.prcMarque}"/>
                        </rich:column>
                        <rich:column label="Libellé" sortable="true" sortOrder="#{parc.prcNomFr}">
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{parc.prcNomFr}"/>
                        </rich:column>
                        <rich:column label="Mode de fonctionnement" sortable="true" sortOrder="#{parc.libFonction}">
                            <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                            <h:outputText value="#{parc.libFonction}"/>
                        </rich:column>
                        <rich:column label="Agent imputé" sortable="true" width="200px" sortOrder="#{parc.prcNomSalarie}">
                            <f:facet name="header"><h:outputText  value="Agent" /></f:facet>
                            <h:outputText value="#{parc.prcNomSalarie}"/>
                        </rich:column>
                        <rich:column label="Service d'affectation" sortable="true"  sortOrder="#{parc.prcService}">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{parc.prcService}"/>
                        </rich:column>
                        <rich:column label="Propriétaire" sortable="true" width="200px" sortOrder="#{parc.prcNomTiers}">
                            <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                            <h:outputText value="#{parc.prcNomTiers}"/>
                        </rich:column>
                        <rich:column label="Date d'achat" sortable="true" sortOrder="#{parc.prcDateAchat}">
                            <f:facet name="header"><h:outputText  value="Achat" /></f:facet>
                            <h:outputText value="#{parc.prcDateAchat}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelPrint}">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_choix_modele}" >
                            <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
