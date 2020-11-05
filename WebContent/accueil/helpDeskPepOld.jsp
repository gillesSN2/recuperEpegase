<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="helpDesk">

    <a4j:form id="formHelpDesk">

        <center>
            <h2>
                <h:outputText value="H E L P - D E S K  (SYSTEME)" style="color:green;font-size:16px;"/>&nbsp;&nbsp;&nbsp;
                <h:panelGroup>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.var_etatTicket}">
                        <f:selectItem itemLabel="Tous les tickets" itemValue="100"/>
                        <f:selectItem itemLabel="Tickets en cours" itemValue="0"/>
                        <f:selectItem itemLabel="Tickets reportés" itemValue="1"/>
                        <f:selectItem itemLabel="Tickets cloturés avec succés" itemValue="2"/>
                        <f:selectItem itemLabel="Tickets cloturés avec échec" itemValue="3"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="formHelpDesk,table,scrollTable,modAttente" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.rechercheTicketsPep}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
            </h2>
        </center>

        <center>
            <h:panelGrid id="butt" columns="4" width="200px">
                <a4j:commandButton title="Répondre au ticket sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.var_afficheBouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.modifierTicket}" reRender="panelTicket,panelGestionTicket"/>
                <a4j:commandButton title="Imprimer le ticket sélectionné" image="/images/print.png" rendered="false" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
            </h:panelGrid>
        </center>
        <br>
        <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.dataModelPegTicket}" var="tic" id="table" border="0" styleClass="bg" style="max-height:100%;border:solid 1px green" width="100%" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.selectionLigne}" reRender="butt"/>
                    <rich:column width="15%" sortable="true" sortBy="#{tic.pegticNomStructure}">
                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                        <h:outputText value="#{tic.pegticNomStructure}"/>
                    </rich:column>
                    <rich:column  width="10%" sortable="true" sortBy="#{tic.libelleEtat}">
                        <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                        <h:outputText value= "#{tic.libelleEtat}"/>
                    </rich:column>
                    <rich:column  width="10%" sortable="true" sortBy="#{tic.libelleType}">
                        <f:facet name="header"><h:outputText value="Type"/></f:facet>
                        <h:outputText value= "#{tic.libelleType}"/>
                    </rich:column>
                    <rich:column  width="10%" sortable="true" sortBy="#{tic.libelleMode}">
                        <f:facet name="header"><h:outputText value="Mode"/></f:facet>
                        <h:outputText value= "#{tic.libelleMode}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="true" sortBy="#{tic.pegticDate}" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText value="Date ticket"/></f:facet>
                        <h:outputText value="#{tic.pegticDate}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="10%" sortable="true" sortBy="#{tic.pegticModule}">
                        <f:facet name="header"><h:outputText value="Module"/></f:facet>
                        <h:outputText value="#{tic.pegticModule}"/>
                    </rich:column>
                    <rich:column width="15%" sortable="true" sortBy="#{tic.pegticObject}">
                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                        <h:outputText value="#{tic.pegticObject}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="true" sortBy="#{tic.pegticNomIntervenant}">
                        <f:facet name="header"><h:outputText value="Intervenant"/></f:facet>
                        <h:outputText value="#{tic.pegticNomIntervenant}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="true" sortBy="#{tic.pegticDateReponse}" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText value="Date Réponse"/></f:facet>
                        <h:outputText value="#{tic.pegticDateReponse}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelTicket" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.showModalPanelTicket}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.showModalPanelTicket}" var="tic">
            <f:facet name="header"><h:outputText value="Gestion des tickets (helpDesk)"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.fermerTicket}" image="/images/close.gif" styleClass="hidelink" reRender="panelTicket"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionTicket" style="width:100%;">
                    <center>
                        <rich:tabPanel switchType="client" immediate="true" style="border:0px">

                            <rich:tab label="Demande">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panDemande"/>
                                <h:panelGrid id="panDemande" columns="4" columnClasses="clos15,clos35,clos15,clos35" style="width:100%;">
                                    <h:column><h:outputText value="Type:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticType}" style="width:100%;" readonly="true">
                                            <f:selectItem itemLabel="Choisissez le type..." itemValue="100"/>
                                            <f:selectItem itemLabel="Nouvelle fonction" itemValue="0"/>
                                            <f:selectItem itemLabel="Modification fonction" itemValue="1"/>
                                            <f:selectItem itemLabel="Rapport disfonctionnement" itemValue="2"/>
                                            <f:selectItem itemLabel="Demande Formation" itemValue="3"/>
                                            <f:selectItem itemLabel="Facturation" itemValue="4"/>
                                            <f:selectItem itemLabel="Commercial" itemValue="5"/>
                                            <f:selectItem itemLabel="Administratif" itemValue="6"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Mode:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticMode}" style="width:100%;" readonly="true">
                                            <f:selectItem itemLabel="Choisissez le mode..." itemValue="100"/>
                                            <f:selectItem itemLabel="Intervention sur Site" itemValue="0"/>
                                            <f:selectItem itemLabel="Intervention par WEB" itemValue="1"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="true"/></h:column>
                                    <h:column><h:outputText value="N° ID:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticId}" style="width:100%;" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Module:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticModule}" style="width:100%;" readonly="true">
                                            <f:selectItem itemLabel="Choisissez le module..." itemValue="100"/>
                                            <f:selectItem itemLabel="Accueil" itemValue="Accueil"/>
                                            <f:selectItem itemLabel="Tiers" itemValue="Tiers"/>
                                            <f:selectItem itemLabel="Achat" itemValue="Achat"/>
                                            <f:selectItem itemLabel="Vente" itemValue="Vente"/>
                                            <f:selectItem itemLabel="Trésorerie" itemValue="Trésorerie"/>
                                            <f:selectItem itemLabel="Parc" itemValue="Parc"/>
                                            <f:selectItem itemLabel="Comptabilité" itemValue="Comptabilité"/>
                                            <f:selectItem itemLabel="Paye" itemValue="Paye"/>
                                            <f:selectItem itemLabel="Administration" itemValue="Administration"/>
                                            <f:selectItem itemLabel="Environement" itemValue="Environement"/>
                                            <f:selectItem itemLabel="Général" itemValue="Général"/>
                                            <f:selectItem itemLabel="Accès" itemValue="Accès"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Sous Module:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticSousModule}" style="width:100%;" maxlength="100" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Référence écran:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticEcran}" style="width:100%;" maxlength="100" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Référence état:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticModele}" style="width:100%;" maxlength="100" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticObject}" style="width:100%;" maxlength="100" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Invervenant:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idIntervenant" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticIdIntervenant}" readonly="true">
                                            <f:selectItem itemLabel="Choisissez votre intervenant" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.mesIntervenantsItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Problème/Question">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panProbleme"/>
                                <h:panelGrid id="txt1" width="100%" style="height:300;border:0px solid green" >
                                    <h:inputTextarea id="elm1" rows="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticProbleme}" style="width:100%" readonly="true"/>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Suggestion">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panSuggestion"/>
                                <h:panelGrid id="txt2" width="100%" style="height:300;border:0px solid green" >
                                    <h:inputTextarea id="elm2" rows="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticSuggestion}" style="width:100%" readonly="true"/>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Réponse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticEtat!=0}">
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticDateReponse}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticEcran!=0}"/></h:column>
                                <h:column><h:outputText value="Etat ticket:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticEtat}" style="width:200px;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticEcran!=0}">
                                        <f:selectItem itemLabel="Choisissez l'état..." itemValue="100"/>
                                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                                        <f:selectItem itemLabel="Reporté" itemValue="1"/>
                                        <f:selectItem itemLabel="Suspendu" itemValue="2"/>
                                        <f:selectItem itemLabel="Cloture succés" itemValue="3"/>
                                        <f:selectItem itemLabel="Cloturé échec" itemValue="4"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panReponse"/>
                                <h:panelGrid id="txt3" width="100%" style="height:300;border:0px solid green" >
                                    <h:inputTextarea id="elm3" rows="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticReponse}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.pegTicket.pegticEcran!=0}"/>
                                </h:panelGrid>
                            </rich:tab>

                        </rich:tabPanel>

                        <h:panelGroup id="buttonValid">
                            <a4j:commandButton title="Valider" image="/images/valider_big.png" style="margin-top:10px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.var_valide}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.validerReponse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelTicket,scrollTable,table,modAttente"/>
                        </h:panelGroup>

                    </center>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="200" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.showModalPanelPrint}" var="imp">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formHelpDesk.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
