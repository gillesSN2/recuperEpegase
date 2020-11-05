<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="objectifs">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center><h2><h:outputText styleClass="titre" value="GESTION DES OBJECTIFS COMMERCIAUX" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="4" styleClass="recherche" width="100%">
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.anneeRec}" style="width:130px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.anneeItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec}" style="width:130px;">
                        <f:selectItem itemLabel="En valeur" itemValue="0"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="tableTiers"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.serviceRec}" style="width:130px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.serviceItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.chargerLesAgents}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="scrollTable,tableTiers"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid width="100%">
            <h:panelGrid columns="3" width="200" id="btnTiers" style="height:34">
                <a4j:commandButton image="/images/modifier.png" title="Modifier les objectifs de l'agent sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.modifierObjectif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.afficheButtOption}" reRender="panelObjectif"/>
                <a4j:commandButton image="/images/detail.png" title="Consulter les objectifs de l'agent sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.consulterObjectif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.afficheButtOption}" reRender="panelObjectif"/>
                <a4j:commandButton image="/images/print.png" title="Impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.afficheButtOption}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px black;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.pageIndex}" reRender="tableTiers" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.dataModelUser}" var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.selectionAgents}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.visualisationAgents}" reRender="idSubView,btnTiers"/>
                        <rich:column label="Administrateur" width="5%" sortable="true" sortBy="#{utilisateur.usrSysteme}" style="text-align:center;">
                            <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
                            <h:graphicImage value="/images/co-chef.png" rendered="#{utilisateur.usrSysteme==1}"/>
                            <h:graphicImage value="/images/chef.png" rendered="#{utilisateur.usrSysteme==2}"/>
                            <h:graphicImage value="/images/configuration.png" rendered="#{utilisateur.usrSysteme==3}"/>
                        </rich:column>
                        <rich:column label="Groupe" width="5%" sortBy="#{utilisateur.usrCollaboration}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Grp."/></f:facet>
                            <h:outputText value="#{utilisateur.usrCollaboration}"/>
                        </rich:column>
                        <rich:column label="Nom" width="20%" sortBy="#{utilisateur.usrNom}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header"> <h:outputText value="Nom et prénom"/></f:facet>
                            <h:outputText value="#{utilisateur.usrNom}  #{utilisateur.usrPrenom}"/>
                        </rich:column>
                        <rich:column label="Service" width="10%" sortBy="#{utilisateur.usrService}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Service"/></f:facet>
                            <h:outputText value="#{utilisateur.usrService}"/>
                        </rich:column>
                        <rich:column label="Fonction" width="10%" sortBy="#{utilisateur.var_fonction}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Fonction"/></f:facet>
                            <h:outputText value="#{utilisateur.var_fonction}"/>
                        </rich:column>
                        <rich:column label="Objectifs Année" width="5%" sortBy="#{utilisateur.objectifAnnee}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Année"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifAnnee}"/>
                        </rich:column>
                        <rich:column label="Objectifs Ca Devis" width="7%" sortBy="#{utilisateur.objectifDevis}" sortable="true" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="Devis"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifDevis}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec==0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objectifs Ca Bc" width="7%" sortBy="#{utilisateur.objectifBc}" sortable="true" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="BC"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifBc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec==0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objectifs Ca Bl" width="7%" sortBy="#{utilisateur.objectifBl}" sortable="true" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="BL"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifBl}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec==0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objectifs Ca Facture" width="7%" sortBy="#{utilisateur.objectifFacture}" sortable="true" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="Facture"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifFacture}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec==0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objectifs Ca Note débit" width="7%" sortBy="#{utilisateur.objectifNdb}" sortable="true" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="NDB"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifNdb}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec==0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objectifs NbRdv" width="7%" sortBy="#{utilisateur.objectifRdv}" sortable="true" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="Rdv"/></f:facet>
                            <h:outputText value="#{utilisateur.objectifRdv}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.choixRec==0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="500" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.nomModeleListe}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.lesmodelesImpressions}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelObjectif" width="1500" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.showModalPanelObjectif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.showModalPanelObjectif}" var="imp">
            <f:facet name="header"><h:outputText value="Définition des objectifs de #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.users.usrPatronyme} pour #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.anneeRec}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.fermerObjectif}" image="/images/close.gif" styleClass="hidelink" reRender="panelObjectif"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabValeur" label="Chiffre d'affaire">

                        <h:panelGrid width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable enableContextMenu="false" styleClass="bg" id="tableObjectif" border="0" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.dataModelObjectif}" var="obj">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.selectionObjectif}"/>
                                    <rich:column label="Nature" width="9%" sortable="false" sortBy="#{obj.usrobjNature}" sortOrder="ASCENDING">
                                        <f:facet name="header"> <h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{obj.libelleNature}"/>
                                    </rich:column>
                                    <rich:column label="Objectifs Janvier" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Janvier"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa01}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Février" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Février"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa02}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Mars" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Mars"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa03}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Avril" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Avril"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa04}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Mai" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Mai"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa05}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Juin" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Juin"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa06}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Juillet" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Juillet"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa07}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Aout" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Aout"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa08}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Septembre" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Septembre"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa09}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Octobre" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Octobre"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa10}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Novembre" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Novembre"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa11}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Objectifs Décembre" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Décembre"/></f:facet>
                                        <h:inputText value="#{obj.usrobjCa12}" style="width:90%;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.calculTotal}" reRender="idTotal"/>
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Total" width="7%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"> <h:outputText value="Total"/></f:facet>
                                        <h:outputText id="idTotal" value="#{obj.usrobjCaTotal}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>

                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formObjectifVentes.validerObjectif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>