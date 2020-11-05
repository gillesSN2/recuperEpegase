<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tierscontact">

    <a4j:form id="formTiersContact" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==0}">

        <center><h2><h:outputText styleClass="titre" value="GESTION DES CONTACTS" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" styleClass="recherche">
            <h:panelGrid  columns="12" width="100%">
                <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.moreSearch}" reRender="recherche" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_more_search}"/>
                <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.moreSearch}" reRender="recherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_more_search}"/>
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomRec}" /></h:column>
                <h:column><h:outputText value="Prénom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.prenomRec}" /></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.telRec}"/></h:column>
                <h:column><h:outputText value="Mail:"/></h:column>
                <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mailRec}" /></h:column>
                <h:column>
                    <h:selectOneMenu id="typeItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRec}" style="width:130px;">
                        <f:selectItem itemLabel="Tous types" itemValue="100"/>
                        <f:selectItem itemLabel="Type fournisseurs" itemValue="0"/>
                        <f:selectItem itemLabel="Tous clients" itemValue="1"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="aciviteItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.activitesRec}" style="width:130px;">
                        <f:selectItem  itemLabel="Toutes activités" itemValue="100"/>
                        <f:selectItem  itemLabel="Sans activité" itemValue="****"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesActivitesSocietesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chargerLesContacts}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
            <h:panelGrid  columns="10" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_more_search}">
                <h:column>
                    <h:selectOneMenu id="conseillersItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conseillersRec}" style="width:130px;">
                        <f:selectItem itemLabel="Tous conseillers" itemValue="0"/>
                        <f:selectItem itemLabel="Sans conseiller" itemValue="99999999"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="inactifItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.inpInactif}" style="width:130px;">
                        <f:selectItem itemLabel="Actif" itemValue="0"/>
                        <f:selectItem itemLabel="Inactif" itemValue="1"/>
                        <f:selectItem itemLabel="Supprimer" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Fonction:"/></h:column>
                <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fonctionRec}" /></h:column>
                <h:column><h:outputText value="Société:"/></h:column>
                <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.villeRec}"/></h:column>
                <h:column><h:outputText value="Service:"/></h:column>
                <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.serviceRec}" /></h:column>
                <h:column>
                    <h:selectOneMenu id="paysItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.paysRec}" style="width:130px;">
                        <f:selectItem  itemLabel="Tous pays" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesPaysItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="appreciationItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.appreciationRec}" style="width:130px;">
                        <f:selectItem itemLabel="Toutes appréciations" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}" />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid width="100%">
            <h:panelGrid columns="5" width="200px" id="btnTiers" style="height:34">
                <h:panelGrid  id="btnContact" columns="6" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactBanque}">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutContact}" reRender="panelContact,btnContact" rendered="false"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelContact,btnContact"/>
                    <a4j:commandButton image="/images/detail.png" title="Consulter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelContact,btnContact"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer contact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers,btnContact"/>
                    <a4j:commandButton image="/images/print.png" title="Impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.initImpressionContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>
                <h:panelGrid  id="btnBanque" columns="6" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactBanque}">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter compte en banque"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutBanque}" reRender="panelBanque,btnBanque" rendered="false"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier compte en banque"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifBanque}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelBanque,btnBanque"/>
                    <a4j:commandButton image="/images/detail.png" title="Consulter compte en banque"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulBanque}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelBanque,btnBanque"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer compte en banque" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers,btnBanque"/>
                    <a4j:commandButton image="/images/print.png" title="Impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.initImpressionContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px black;"  width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.pageIndex}" reRender="tableTiers" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelContact}" var="societe" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.configListeEntete}">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionContact}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,btnBanque"/>
                        <rich:column label="Société" sortable="true" sortBy="#{societe.tiers.tieraisonsocialenom}" width="18%">
                            <f:facet name="header" ><h:outputText value="Société"/></f:facet>
                            <h:outputText value="#{societe.tiers.tieraisonsocialenom}"/>
                        </rich:column>
                        <rich:column label="Catégorie des tiers" sortable="true" sortBy="#{societe.tiers.tiecategorie}" width="7%">
                            <f:facet name="header" ><h:outputText value="Catégorie"/></f:facet>
                            <h:outputText value="#{societe.tiers.tiecategorie}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{societe.concivilite}" width="5%">
                            <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                            <h:outputText value="#{societe.concivilite}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{societe.connom}" width="15%" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Nom"/></f:facet>
                            <h:outputText value="#{societe.connom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{societe.conprenom}" width="15%">
                            <f:facet name="header" ><h:outputText value="Prénom"/></f:facet>
                            <h:outputText value="#{societe.conprenom}"/>
                        </rich:column>
                        <rich:column label="N° téléphone" sortable="true" sortBy="#{societe.concel1}" width="10%">
                            <f:facet name="header" ><h:outputText value="Mobile"/></f:facet>
                            <h:outputText value="#{societe.concel1}"/>
                        </rich:column>
                        <rich:column label="Email" sortable="true" sortBy="#{societe.conmail1}" width="10%">
                            <f:facet name="header" ><h:outputText value="Mail"/></f:facet>
                            <h:outputText value="#{societe.conmail1}"/>
                        </rich:column>
                        <rich:column label="Fonction" sortable="true" sortBy="#{societe.confonction}" width="10%">
                            <f:facet name="header" ><h:outputText value="Fonction"/></f:facet>
                            <h:outputText value="#{societe.confonction}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{societe.conservice}" width="10%">
                            <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                            <h:outputText value="#{societe.conservice}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPrintContact}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPrintContact}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomModeleListe}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.listeImpressionContactItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerContactXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelContact" headerClass="headerPanel" width="900" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelContact}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelContact}" var="ctc">
            <f:facet name="header"><h:outputText value="GESTION DES CONTACTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleContact}" image="/images/close.gif" styleClass="hidelink" reRender="panelContact"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Né(e) le:"/></h:column>
                    <h:column>
                        <a4j:outputPanel layout="block">
                            <rich:calendar   style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.condatenaissance}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                        </a4j:outputPanel>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.connom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conprenom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.confonction}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conlangue}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <rich:tabPanel switchType="client" immediate="true" id="tabPanelContact" style="border:0px;">
                    <rich:tab label="Identité">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conservice}"/></h:column>
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conadresse}"/></h:column>
                            <h:column><h:outputText value="Rue N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conrue}"/></h:column>
                            <h:column><h:outputText value="Lot N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conlot}"/></h:column>
                            <h:column><h:outputText value="Ilot N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conilot}"/></h:column>
                            <h:column><h:outputText value="Porte N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conporte}"/></h:column>
                            <h:column><h:outputText value="Quartier:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conquartier}"/></h:column>
                            <h:column><h:outputText value="Commune:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concommune}"/></h:column>
                            <h:column><h:outputText value="Zone:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conzone}"/></h:column>
                            <h:column><h:outputText value="Départ.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.condeparte}"/></h:column>
                            <h:column><h:outputText value="Bâtiment:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conbatiment}"/></h:column>
                            <h:column><h:outputText value="Escalier:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conescalier}"/></h:column>
                            <h:column><h:outputText value="B.P.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conbp}"/></h:column>
                            <h:column><h:outputText value="Cédex:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concedex}"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conville}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.connompays}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Tél. bur.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.contelbur}"/></h:column>
                            <h:column><h:outputText value="Tél. dom.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conteldom}"/></h:column>
                            <h:column><h:outputText value="Cell. 1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel1}"/></h:column>
                            <h:column><h:outputText value="Cell. 2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel2}"/></h:column>
                            <h:column><h:outputText value="Cell. 3:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel3}"/></h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.confax}"/></h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conskype}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Mail 1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail1}"/></h:column>
                            <h:column><h:outputText value="Mail 2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail2}"/></h:column>
                            <h:column><h:outputText value="Mail 3:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail3}"/></h:column>
                            <h:column><h:outputText value="Mail 4:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail4}"/></h:column>
                            <h:column><h:outputText value="Mail 5:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail5}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Site Web:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conweb}"/></h:column>
                            <h:column><h:outputText value="Blog:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conblog}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>
                    <rich:tab label="Campagne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.tiers.tietype=='3'}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableParticipantContact" maxPages="20" align="left" for="tableParticipantContact"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableParticipantContact" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelParticipantsContact}" var="par">
                                <rich:column label="Date visite" sortable="true" sortBy="#{par.camparDate}" width="15%">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{par.camparDate}">
                                        <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Campagne" sortable="true" sortBy="#{par.campagneEnteteVentes.camObjet}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Campagne"/></f:facet>
                                    <h:outputText value="#{par.campagneEnteteVentes.camObjet}"/>
                                </rich:column>
                                <rich:column label="Nom prénom du participant" sortable="true" sortBy="#{par.contacts.conpatronyme}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                                    <h:outputText value="#{par.contacts.conpatronyme}"/>
                                </rich:column>
                                <rich:column label="Fonction" sortable="true" sortBy="#{par.contacts.confonction}" width="15%">
                                    <f:facet name="header"><h:outputText  value="Fonction"/></f:facet>
                                    <h:outputText  value="#{par.contacts.confonction}"/>
                                </rich:column>
                                <rich:column label="Téléphone" sortable="true" sortBy="#{par.contacts.concel1}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Téléphne"/></f:facet>
                                    <h:outputText  value="#{par.contacts.concel1}"/>
                                </rich:column>
                                <rich:column label="eMail" sortable="true" sortBy="#{par.contacts.mailCumul}" width="20%">
                                    <f:facet name="header"><h:outputText  value="eMail"/></f:facet>
                                    <h:outputText  value="#{par.contacts.mailCumul}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>
                </rich:tabPanel>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Obs.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conobservation}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Appréc.:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conappreciation}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value="ACCES ESPACE CLIENT:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conPwEspaceClient}" style="width:100%;text-align:center;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value=""/></h:column>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valContact">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveContact}" reRender="panelContact,idContact,tableTiers"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelBanque" headerClass="headerPanel" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelBanque}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelBanque}" var="bnq">
            <f:facet name="header"><h:outputText value="GESTION DES COMPTES BANCAIRES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleContact}" image="/images/close.gif" styleClass="hidelink" reRender="panelBanque"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code Banque:"/></h:column>
                    <h:column><h:inputText maxlength="5" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.connumbanque}"/></h:column>
                    <h:column><h:outputText value="Code Guichet:"/></h:column>
                    <h:column><h:inputText  maxlength="5" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conguichetbanque}"/></h:column>
                    <h:column><h:outputText value="Numéro Compte:"/></h:column>
                    <h:column><h:inputText maxlength="20" size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concomptebanque}"/></h:column>
                    <h:column><h:outputText value="Clé RIB:"/></h:column>
                    <h:column><h:inputText maxlength="2" size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conclebanque}"/></h:column>
                    <h:column><h:outputText value="IBAN:"/></h:column>
                    <h:column><h:inputText maxlength="34" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.coniban}"/></h:column>
                    <h:column><h:outputText value="SWIFT:"/></h:column>
                    <h:column><h:inputText maxlength="20" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conswift}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Né(e) le:"/></h:column>
                    <h:column>
                        <a4j:outputPanel layout="block">
                            <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.condatenaissance}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                        </a4j:outputPanel>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.connom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conprenom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.confonction}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conlangue}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Tél. bur.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.contelbur}"/></h:column>
                    <h:column><h:outputText value="Tél. dom.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conteldom}"/></h:column>
                    <h:column><h:outputText value="Cell. 1:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel1}"/></h:column>
                    <h:column><h:outputText value="Cell. 2:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel2}"/></h:column>
                    <h:column><h:outputText value="Cell. 3:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel3}"/></h:column>
                    <h:column><h:outputText value="Fax:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.confax}"/></h:column>
                    <h:column><h:outputText value="Aol:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conaol}"/></h:column>
                    <h:column><h:outputText value="Skype:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conskype}"/></h:column>
                    <h:column><h:outputText value="Yahoo:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conyahoo}"/></h:column>
                    <h:column><h:outputText value="Msn:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmsn}"/></h:column>
                    <h:column><h:outputText value="Mail 1:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail1}"/></h:column>
                    <h:column><h:outputText value="Mail 2:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail2}"/></h:column>
                    <h:column><h:outputText value="Mail 3:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail3}"/></h:column>
                    <h:column><h:outputText value="Mail 4:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail4}"/></h:column>
                    <h:column><h:outputText value="Site Web:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conweb}"/></h:column>
                    <h:column><h:outputText value="Blog:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conblog}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Obs.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conobservation}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Appréc.:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conappreciation}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valBanque">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanBnq" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveContact}" reRender="panelBanque,idBanque,tableTiers"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>