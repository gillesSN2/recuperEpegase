<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tiersAgents">

    <a4j:form id="formAgentsAgents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_action==0}">

        <center><h2><h:outputText styleClass="titre" value="GESTION : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="9" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nomRec}" /></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.groupeRec}" style="width:130px;">
                        <f:selectItem  itemLabel="Tous groupes" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.groupeItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.fonctionRec}" style="width:130px;">
                        <f:selectItem  itemLabel="Toutes fonctions" itemValue="100"/>
                        <f:selectItem  itemLabel="Les vendeurs" itemValue="VENDEURS"/>
                        <f:selectItem  itemLabel="Les caissiers" itemValue="CAISSIERS"/>
                        <f:selectItem  itemLabel="Les signataires" itemValue="SIGNATAIRES"/>
                        <f:selectItem  itemLabel="" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesFonctionsItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.serviceRec}" style="width:130px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.serviceItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.chargerLesAgents}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="btnTiers,scrollTable,tableTiers"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid width="100%">
            <h:panelGrid columns="7" width="300" id="btnTiers" style="height:34">
                <a4j:commandButton image="/images/print.png" title="Impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.afficheButtOption}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton image="/images/mouvementstock.png" title="Documents commerciaux" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.accesDocuments}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/calendrier.png" title="Planning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.accesPlanning}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/mail.png" title="Messagerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.accesMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/sms.png" title="Envoi SMS" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                <a4j:commandButton image="/images/groupes.png" title="liste des tiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.listeTiers}" style="width:28px;height:28px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.afficheButtOption}" reRender="modalListeTiers"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px black;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.pageIndex}" reRender="tableTiers" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.dataModelUser}" var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.selectionAgents}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.visualisationAgents}" reRender="idSubView,btnTiers"/>
                        <rich:column label="Administrateur" width="5%" sortable="true" sortBy="#{utilisateur.usrSysteme}" style="text-align:center;">
                            <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
                            <h:graphicImage value="/images/co-chef.png" rendered="#{utilisateur.usrSysteme==1}"/>
                            <h:graphicImage value="/images/chef.png" rendered="#{utilisateur.usrSysteme==2}"/>
                            <h:graphicImage value="/images/configuration.png" rendered="#{utilisateur.usrSysteme==3}"/>
                        </rich:column >
                        <rich:column label="Etat" width="5%" sortable="true" sortBy="#{utilisateur.usrEtat}" style="text-align:center;">
                            <f:facet name="header"> <h:outputText value="Etat"/></f:facet>
                            <h:graphicImage value="/images/desactiver.png" rendered="#{utilisateur.usrEtat==0}"/>
                        </rich:column >
                        <rich:column label="Compte" width="8%" sortBy="#{utilisateur.usrCompte}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Cpt."/></f:facet>
                            <h:outputText value="#{utilisateur.usrCompte}"/>
                        </rich:column >
                        <rich:column label="Groupe" width="7%" sortBy="#{utilisateur.usrCollaboration}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Grp."/></f:facet>
                            <h:outputText value="#{utilisateur.usrCollaboration}"/>
                        </rich:column >
                        <rich:column label="Nom" width="25%" sortBy="#{utilisateur.usrNom}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header"> <h:outputText value="Nom et prénom"/></f:facet>
                            <h:outputText value="#{utilisateur.usrNom}  #{utilisateur.usrPrenom}"/>
                        </rich:column >
                        <rich:column label="Mobile" width="10%" sortBy="#{utilisateur.usrCel1}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Mobile"/></f:facet>
                            <h:outputText value="#{utilisateur.usrCel1}"/>
                        </rich:column >
                        <rich:column label="Service" width="10%" sortBy="#{utilisateur.usrService}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Service"/></f:facet>
                            <h:outputText value="#{utilisateur.usrService}"/>
                        </rich:column >
                        <rich:column label="Fonction" width="10%" sortBy="#{utilisateur.var_fonction}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Fonction"/></f:facet>
                            <h:outputText value="#{utilisateur.var_fonction}"/>
                        </rich:column >
                        <rich:column label="Options" width="10%" sortBy="#{utilisateur.var_options}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Options"/></f:facet>
                            <h:outputText value="#{utilisateur.var_options}"/>
                        </rich:column >
                        <rich:column label="Equipe" width="10%" sortBy="#{utilisateur.usrNomEquipe}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Equipe"/></f:facet>
                            <h:outputText value="#{utilisateur.usrNomEquipe}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_choix_modele}" >
                            <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="modalListeTiers" headerClass="headerPanel" width="1100" height="600" autosized="true" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalPanelListeTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.showModalPanelListeTiers}" var="lst">
            <f:facet name="header"><h:outputText value="Liste des tiers du conseiller"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.fermerTiers}" image="/images/close.gif" styleClass="hidelink" reRender="modalListeTiers"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <center>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.pageIndex}" reRender="tableTiers" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="160%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.dataModelListeTiers}" var="societe" activeRowKey="true" rowKeyVar="rkv" sortMode="multi" selectionMode="single">
                                <rich:column label="Sélection" sortable="true" sortBy="#{societe.nomGroupe}" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet=='2'}">
                                    <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                                    <h:selectBooleanCheckbox value="#{societe.selectionTiers}" style="#{societe.styleCouleur}"/>
                                </rich:column>
                                <rich:column label="N° Compte" sortable="true" sortBy="#{societe.comptePrincipal}" width="100px">
                                    <f:facet name="header" ><h:outputText value="Compte"/></f:facet>
                                    <h:outputText value="#{societe.comptePrincipal}" style="#{societe.styleCouleur}" title="#{societe.comptePrincipal}"/>
                                </rich:column>
                                <rich:column label="Date de création" sortable="true" sortBy="#{societe.tiedatecreat}" width="80px">
                                    <f:facet name="header" ><h:outputText value="Crée le"/></f:facet>
                                    <h:outputText value="#{societe.tiedatecreat}" style="#{societe.styleCouleur}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Catégorie des tiers" sortable="true" sortBy="#{societe.tiecategorie}" width="100px">
                                    <f:facet name="header" ><h:outputText value="Catégorie"/></f:facet>
                                    <h:outputText value="#{societe.tiecategorie}" style="#{societe.styleCouleur}" title="#{societe.tiecategorie}"/>
                                </rich:column>
                                <rich:column label="Civilité" sortable="true" sortBy="#{societe.tiecivilite}" width="100px">
                                    <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                    <h:outputText value="#{societe.tiecivilite}" style="#{societe.styleCouleur}" title="#{societe.tiecivilite}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{societe.tieraisonsocialenom}" width="300px" sortOrder="ASCENDING">
                                    <f:facet name="header" ><h:outputText value="Nom"/></f:facet>
                                    <h:outputText value="#{societe.tieraisonsocialenom}" style="#{societe.styleCouleur}" title="#{societe.tieraisonsocialenom}"/>
                                </rich:column>
                                <rich:column label="Prénom" sortable="true" sortBy="#{societe.tieprenom}" width="200px">
                                    <f:facet name="header" ><h:outputText value="Prénom"/></f:facet>
                                    <h:outputText value="#{societe.tieprenom}" style="#{societe.styleCouleur}" title="#{societe.tieprenom}"/>
                                </rich:column>
                                <rich:column label="N° téléphone" sortable="true" sortBy="#{societe.tieburtel1}" width="100px">
                                    <f:facet name="header" ><h:outputText value="Téléphone"/></f:facet>
                                    <h:outputText value="#{societe.tieburtel1}" style="#{societe.styleCouleur}" title="#{societe.tieburtel1}"/>
                                </rich:column>
                                <rich:column label="Ville" sortable="true" sortBy="#{societe.tieville}" width="100px">
                                    <f:facet name="header" ><h:outputText value="Ville"/></f:facet>
                                    <h:outputText value="#{societe.tieville}" style="#{societe.styleCouleur}" title="#{societe.tieville}"/>
                                </rich:column>
                                <rich:column label="Pays" sortable="true" sortBy="#{societe.tienompays}" width="100px">
                                    <f:facet name="header" ><h:outputText value="Pays"/></f:facet>
                                    <h:outputText value="#{societe.tienompays}" style="#{societe.styleCouleur}" title="#{societe.tienompays}"/>
                                </rich:column>
                                <rich:column label="Email" sortable="true" sortBy="#{societe.tiemail1}" width="200px">
                                    <f:facet name="header" ><h:outputText value="Mail"/></f:facet>
                                    <h:outputText value="#{societe.tiemail1}" style="#{societe.styleCouleur}" title="#{societe.tiemail1}"/>
                                </rich:column>
                                <rich:column label="Observations" sortable="true" sortBy="#{societe.tieobservations}" width="300px">
                                    <f:facet name="header" ><h:outputText value="Observations"/></f:facet>
                                    <h:outputText value="#{societe.tieobservations}" style="#{societe.styleCouleur}" title="#{societe.tieobservations}"/>
                                </rich:column>
                                <rich:column label="Famille" sortable="true" sortBy="#{societe.tienomfamille}" width="80px">
                                    <f:facet name="header" ><h:outputText value="Famille"/></f:facet>
                                    <h:outputText value="#{societe.tienomfamille}" style="#{societe.styleCouleur}" title="#{societe.tienomfamille}"/>
                                </rich:column>
                                <rich:column label="Centre dintéret" sortable="true" sortBy="#{societe.tieinteret}" width="150px">
                                    <f:facet name="header" ><h:outputText value="Centres intérêts"/></f:facet>
                                    <h:outputText value="#{societe.tieinteret}" style="#{societe.styleCouleur}" title="#{societe.tieinteret}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </center>
                <br>
                <h:panelGrid columns="6" width="100%" styleClass="recherche">
                    <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.toutSelectionner}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers"/>
                    <a4j:commandButton value="Rien sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.rienSelectionner}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTiers"/>
                    <h:column><h:outputText value="Sélection conseiller"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.idConseiller}" style="width:200px;">
                            <f:selectItem  itemLabel="Sélectionnez conseiller" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.mesConseillersItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <a4j:commandButton value="Duppliquer vers un autre conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.duppliquerVers}" onclick="if (!confirm('Etes-vous sur de vouloir DUPPLIQUER les tiers sélectionnés vers un autre conseiller ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalListeTiers"/>
                    <a4j:commandButton value="Transférer vers un autre conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.envoyerVers}" onclick="if (!confirm('Etes-vous sur de vouloir TRANSFERER les tiers sélectionnés vers un autre conseiller ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalListeTiers"/>
                </h:panelGrid>
                <br>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>