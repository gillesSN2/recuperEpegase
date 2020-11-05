<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionpaye">

    <a4j:form target="_blank" >

        <center><h2><h:outputText value="IMPRESSIONS DES TEMPS" styleClass="titre"/></h2></center>

        <center><a4j:commandButton value="Bordereaux de versement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.openBordereau}" reRender="panelBordereaux"/></center>

        <h:panelGroup id="panGlobal">

            <h:panelGrid width="100%" columns="3"  id="panGlob">

                <rich:column width="300px" style="max-height:100%" >
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.dataModelImpgen}" var="repert">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.recupererNomrepTemps}" reRender="panGlobal,tableNomEtat,richPFiltre,panPrint,panLigne,panDocument,panExport"/>
                            <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                                <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                                <h:outputText value="#{repert}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:column>
                <rich:column width="300px" style="max-height:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.dataModelImpgenFichier}" var="rapport">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.recupererNomfichTemps}" reRender="richPFiltre,panPrint,panLigne,panDocument,panExport,panColonne"/>
                            <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText value="Sélection modèle" /></f:facet>
                                <h:outputText  value="#{rapport}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:column >
                <rich:column id="richPFiltre"  width="100%" >
                    <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                        <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panFiltre">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.calculeDates}" reRender="idD1,idD2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;" /></h:column>
                            <h:column><h:outputText value="Sélection tiers" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idTiers" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.idTiersRec}" >
                                    <f:selectItem itemLabel="Toutes les tiers" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesTiersItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.calculeMission}" reRender="idMission"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection mission" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idMission" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.missionRec}" >
                                    <f:selectItem itemLabel="Toutes les missions" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesMisisonsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection tache" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idTache" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.tacheRec}" >
                                    <f:selectItem itemLabel="Toutes les taches" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesTachesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection salarié" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idSalarie" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.salarieRec}" >
                                    <f:selectItem itemLabel="Toutes les salariés" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesSalarieItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:column >

            </h:panelGrid>

            <center>
                <br>
                <h:panelGroup id="panPrint" style="height:80px" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheExport}">
                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                    <h:panelGrid id="panMail" width="100%">
                        <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idEmetteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idDestinataire" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue=""/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panExport" style="height:80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheExport}">
                    <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerEXP}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                    <h:column id="idFichier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.afficheFichierExport}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomFichier}" title="Télécharger document"><img src="images/download.png" height="50px" width="50px" alt="télécharger"></a>
                        </h:column>
                    </h:panelGroup>
            </center>

        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelSalaries}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelSalaries}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.datamodelSalaries}" var="sal">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionSalarie}"/>
                    <rich:column label="Matricule" sortable="true" sortBy="#{sal.salMatricule}" width="15%">
                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                        <h:outputText value="#{sal.salMatricule}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{sal.salNom}" width="55%">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{sal.salNom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{sal.salPrenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{sal.salPrenom}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{sal.salCivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{sal.salCivilite}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.annuleSalarie}" reRender="idTiers,panelListeTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.calculeSalarie}" reRender="idTiers,panelListeTiers"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return" handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false">
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

    <rich:modalPanel domElementAttachment="parent"  id="panelBordereaux" width="700" height="550"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelBordereau}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelBordereau}" var="brd">
            <f:facet name="header"><h:outputText value="BORDEREAUX DE VERSEMENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.closeBordereaux}" image="/images/close.gif" styleClass="hidelink" reRender="panelBordereaux"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" style="text-align:left;">
                    <h:panelGrid width="100%" columns="5" border="0">
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="N° Bordereaux"/></h:column>
                        <h:column><h:outputText value="Date Versement (JJ/MM/AAAA)"/></h:column>
                        <h:column><h:outputText value="Montant"/></h:column>
                        <h:column><h:outputText value="Allocations fam."/></h:column>
                        <h:column><h:outputText value="Janvier"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd01}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd01}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd01}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll01}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Février"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd02}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd02}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd02}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll02}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mars"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd03}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd03}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd03}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll03}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Avril"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd04}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd04}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd04}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll04}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mai"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd05}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd05}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd05}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll05}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juin"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd06}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd06}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd06}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll06}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juillet"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd07}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd07}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd07}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll07}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Aout"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd08}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd08}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd08}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll08}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Septembre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd09}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd09}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd09}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll09}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Octobre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd10}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd10}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd10}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll10}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Novembre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd11}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd11}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd11}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll11}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Décembre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd12}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd12}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd12}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll12}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" columns="2">
                        <h:column><h:outputText value="Commissions honoraires Redevances versées"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayRedevance}" size="7" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.majBordereau}" reRender="panelBordereaux"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>