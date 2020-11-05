<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressioncaisse">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS CAISSES" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3" id="panGlob">

            <rich:column  width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.recupererNomrep}" reRender="tableNomEtat,richPFiltre,panPrint"/>
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column  width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.recupererNomfich}" reRender="richPFiltre,panPrint"/>
                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Sélection modèle" /></f:facet>
                            <h:outputText  value="#{rapport}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column >

            <rich:column id="richPFiltre" width="100%">
                <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                    <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panFiltre">
                        <h:column><h:outputText value="Période:" /></h:column>
                        <h:column>
                            <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.periode}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.mesPeriodesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.calculeDates}" reRender="idD1,idD2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Du:" /></h:column>
                        <h:column><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                        <h:column><h:outputText value="Au:" /></h:column>
                        <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                        <h:column><h:outputText value="Sélection Caisse:" /></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.caisse}" >
                                <f:selectItem itemLabel="Toutes les caisses autorisées" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.mesCaissesAutorisees}"/>
                            </h:selectOneMenu>
                        </h:column>

                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.nomRepertoire=='mouvements'}"><h:outputText value="Sélection Tiers:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.nomRepertoire=='mouvements'}">
                            <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.nomTiers}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers" />
                            </h:inputText>
                        </h:column>

                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}"><h:outputText value="Activités:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.activite}" >
                                <f:selectItem itemLabel="Toutes les activités" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesActivitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_colonne1}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.laColonne1Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_colonne2}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.laColonne2Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_colonne3}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.laColonne3Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_parc}"><h:outputText value="Sélection parc:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_anal_parc}">
                            <h:inputText id="idParc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.parc}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeParc" />
                            </h:inputText>
                        </h:column>

                    </h:panelGrid>
                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <!-- modalPanel de selection des tiers -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.showModalPanelTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.datamodelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.selectionligneTiers}"/>
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
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.annuleTiers}" reRender="idTiers,panelListeTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.calculeTiers}" reRender="idTiers,panelListeTiers"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


   <!-- modalPanel de selection des parcs -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeParc" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.showModalPanelParc}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.showModalPanelParc}" var="prc">
            <f:facet name="header"><h:outputText value="Sélection du parc"/></f:facet>
            <a4j:form id="formModalListeParc">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableParc" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.datamodelParc}"  var="prc">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.selectionParc}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Immatriculation" sortable="true" sortBy="#{prc.prcImmatriculation}" width="20%">
                            <f:facet name="header"><h:outputText  value="Immatriculation" /></f:facet>
                            <h:outputText value="#{prc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" sortBy="#{prc.prcLibNature}" width="20%">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{prc.prcLibNature}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{prc.prcLibFamille}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prc.prcLibFamille}"/>
                        </rich:column>
                        <rich:column label="Sous Famille" sortable="true" sortBy="#{prc.prcLibSousFamille}" width="20%">
                            <f:facet name="header"><h:outputText  value="Sous Famille" /></f:facet>
                            <h:outputText value="#{prc.prcLibSousFamille}"/>
                        </rich:column>
                        <rich:column label="Marque" sortable="true" sortBy="#{prc.prcMarque}" width="20%">
                            <f:facet name="header"><h:outputText  value="Marque" /></f:facet>
                            <h:outputText value="#{prc.prcMarque}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprc">
                    <center>
                        <a4j:commandButton id="idCanParc" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.annuleParc}" reRender="panelListeParc,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValParc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.calculeParc}" reRender="panelListeParc,idParc"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanParc')}.click()" />
                        <rich:hotKey key="return" handler="#{rich:element('idValParc')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formImpressionCaisse.var_ctrl_imp}">
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>