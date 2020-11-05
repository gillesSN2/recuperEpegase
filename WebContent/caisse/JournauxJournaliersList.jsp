<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview  id="cj">

    <center> <h2><h:outputText value="CAISSES JOURNALIERES" styleClass="titre"/></h2></center>

    <a4j:form style="width:100%" id="form">

        <h:panelGrid columns="3" width="100%"  id="pgrid" >

            <rich:column width="35%" id="g1">
                <rich:panel  style="width:100%;border:0px" id="pan1">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.datamodelJournaux}" var="jounaux" id="tableActif" style="max-height:100%;border:solid 0px green;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " border="0"  footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.simpleSelectionJournaux}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.extDTableJournaux}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJournalMensuel}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,g2,table2,g3,table3" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJournalMensuel}" reRender="modAttente,g2,table2,g3,table3" />
                            <rich:column label="Code journal" width="30%" sortable="true" sortBy="#{jounaux.caiCode}" sortOrder="ASCENDING" >
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText style="width:10px;" value="#{jounaux.caiCode}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Intitulé du journal" width="70%" sortable="true" sortBy="#{jounaux.caiNom}" >
                                <f:facet name="header"><h:outputText value="Intitulé" /></f:facet>
                                <h:outputText value= "#{jounaux.caiNom}">
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

            <rich:column  width="15%" id="g2">
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.ouvrirJourenCours}" styleClass="ouvrir" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.jourEnCours}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.afficheTJM}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pboardb,journauxcomptablesinit"/>
                <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.afficheTJM}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.dataModelMois}" var="mois" id="table2" style="max-height:100%;border:solid 0px black;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.simpleSelectionMois}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.extDTableMois}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJournalJour}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,g3,table3" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJournalJour}" reRender="modAttente,g3,table3" />
                            <rich:column width="100%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                                <h:outputText value= "#{mois.caimenPeriode}">
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

            <rich:column  width="50%" id="g3">
                <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.afficheTJJ}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.dataModelJour}" var="jour" id="table3" style="max-height:100%;border:solid 0px black;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.simpleSelectionJour}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.extDTableJour}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJourSaisieLight}" reRender="table3,idOpen"/>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value= "#{jour.caijouDate}">
                                    <f:convertDateTime dateStyle="full" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="8%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Clôt."/></f:facet>
                                <h:graphicImage rendered="#{((jour.caijouEtat==1)||(jour.caijouEtat==2))==true}" value="/images/cadenas_cl.png"/>
                            </rich:column>
                            <rich:column width="13%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="S. Espèces"/></f:facet>
                                <h:outputText value= "#{jour.caijouSoldeEspece}" rendered="#{jour.caijouSoldeEspece!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="13%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="S. Chèque"/></f:facet>
                                <h:outputText value= "#{jour.caijouSoldeCheque}" rendered="#{jour.caijouSoldeCheque!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="13%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Solde Fin"/></f:facet>
                                <h:outputText value= "#{jour.soldeFinal}" rendered="#{jour.soldeFinal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="15%" sortable="false">
                                <f:facet name="header"><h:outputText value="Ouverture"/></f:facet>
                                <a4j:commandButton immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJourSaisie}" rendered="#{jour.select&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.sansChrono}" styleClass="ouvrir" value="Ouvrir" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pboardb,journauxcomptablesinit"/>
                            </rich:column>
                            <rich:column width="8%" sortable="false" style="text-align:center">
                                <f:facet name="header"><h:outputText value="Sit."/></f:facet>
                                <a4j:commandButton id="idOpen" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.initImpressionSituationJournaliere}" rendered="#{(jour.caijouEtat==1||jour.caijouEtat==2)==true}" title="Imprimer" image="/images/print.png" style="width:20px;height:20px;" reRender="panelImp"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.showModalPanelPrint}" var="prt">
            <center>
                <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                            <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                        </a4j:commandButton>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalImp" target="_blank">
                    <center>
                        <h:outputText value="Choisissez un format d'Impression"  style="color:green;"/>
                    </center>
                    <br><br>
                    <h:panelGrid width="100%">
                        <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <h:panelGrid  width="100%" columns="9" style="height:80px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                    <center>
                                        <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerPRTSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                        <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                        </h:selectOneMenu>
                                    </center>
                                </h:panelGroup>
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerJRVSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerPDFSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerODTSituation}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerXLSSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerDOCSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerHTMLSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerXMLSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.envoieMAILSituation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue=""/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

</f:subview>
