<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="eduENcaissement">

    <center> <h2><h:outputText value="GESTION DES BONS D'ENCAISSEMENT" style="color:green;"/></h2></center>

    <a4j:form>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  columns="6" styleClass="recherche" width="100%" id="boutons">
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat}" style="width:100px;">
                        <f:selectItem itemLabel="A exécuter" itemValue="0"/>
                        <f:selectItem itemLabel="Déjà exécutés" itemValue="1"/>
                        <f:selectItem itemLabel="Annulés" itemValue="2"/>
                        <f:selectItem itemLabel="A générer" itemValue="3"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="boutons"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==2}"><h:outputText value="Du:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==2}"><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.dateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==2}"><h:outputText value="Au:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.inpEtat==2}"><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.dateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.chargerFind}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt,scrollTable,table,pnlgrttotal,panelGeneration"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="pangrpVisbt" style="height:34px" columns="6" width="300px">
            <a4j:commandButton title="Modifier l'encaissement sélectionné" image="/images/modifier.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.modifierBon}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonEtat==0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'encaissement sélectionné" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.consultBonEncaissement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.visibiliteBton}" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Annuler l'encaissement sélectionné" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.annulerBonEncaissement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonEtat==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.usersChrono.usrchrUpdate==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.usersChrono.usrchrUpdate==4)}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Supprimer l'encaissement sélectionné" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet encaissement ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.deleteBonEncaissement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonEtat==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.usersChrono.usrchrUpdate==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.usersChrono.usrchrUpdate==4)}" reRender="idSubView"/>
            <a4j:commandButton title="Imprimer reçu" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_nb_max}" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0"  width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.datamodelEncaiss}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.visualisationLigne}" reRender="idSubView,pangrpVisbt"/>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.var_lib_nat}" sortOrder="DESCENDING" width="200px">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{var.var_lib_nat}"/>
                        </rich:column>
                        <rich:column label="N°" sortable="true" sortBy="#{var.bonNum}" width="70px"  >
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.bonNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.bonDate}" width="70px" >
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.bonDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.bonSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.bonSerie}"/>
                        </rich:column>
                        <rich:column label="Réference" sortable="true" sortBy="#{var.bonRef}" width="110px">
                            <f:facet name="header"><h:outputText  value="Réference." /></f:facet>
                            <h:outputText value="#{var.bonRef}"/>
                        </rich:column>
                        <rich:column label="Tiers" sortable="true" sortBy="#{var.bonNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Elève"  /></f:facet>
                            <h:outputText  value="#{var.bonNomTiers}"/>
                        </rich:column>
                        <rich:column label="Règlements" sortable="true" sortBy="#{var.bonAPayer}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                            <h:outputText  value="#{var.bonAPayer}" rendered="#{var.bonAPayer!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.bonAPayer}" rendered="#{var.bonAPayer!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.bonAPayer}" rendered="#{var.bonAPayer!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Mode Paiement" sortable="true" sortBy="#{var.var_lib_mode_reg}" >
                            <f:facet name="header"><h:outputText value="Mode"  /></f:facet>
                            <h:outputText  value="#{var.var_lib_mode_reg}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.bonDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                            <h:outputText  value="#{var.bonDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.bonActivite}" >
                            <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                            <h:outputText  value="#{var.bonActivite}"/>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.bonObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.bonObject}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.bonNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Commercial"  /></f:facet>
                            <h:outputText  value="#{var.bonNomResponsable}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
            <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpTTCL" value="Total TTC" />
                <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.montantRecette}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_choix_modele}" >
                            <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.ListeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menuvente.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Bon Encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.fermerAnnulerBon}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonMotifAnnule}" maxlength="20"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.validerAnnulerBon}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGeneration" width="600" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.showModalPanelGeneration}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.showModalPanelGeneration}" var="gen">
            <f:facet name="header"><h:outputText value="Génération bons d`encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.fermerGeneration}" image="/images/close.gif" styleClass="hidelink" reRender="panelGeneration"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  style="width:100%;">
                        <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre0">
                            <h:column><h:outputText value="Echéances factures Du:"/></h:column>
                            <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.dateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Au:"/></h:column>
                            <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.dateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre1">
                            <h:column><h:outputText value="Sélection site:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.site}" >
                                    <f:selectItem itemLabel="Tous sites" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.chargerDepartement}" reRender="panFiltre1,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection département:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.departement}" >
                                    <f:selectItem itemLabel="Tous départements" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.chargerService}" reRender="panFiltre1,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection service:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.service}" >
                                    <f:selectItem itemLabel="Tous services" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre2">
                            <h:column><h:outputText value="Sélection région:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.region}" >
                                    <f:selectItem itemLabel="Toutes régions" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.mesRegionsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.chargerSecteur}" reRender="panFiltre2,idSecteur,idPdv" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection secteurs:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.secteur}" >
                                    <f:selectItem itemLabel="Tous secteurs" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.mesSecteursItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.chargerPdv}" reRender="panFiltre2,idPdv" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection points de vente:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.pdv}" >
                                    <f:selectItem itemLabel="Tous points de vente" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.mesPdvItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre3">
                            <h:column><h:outputText value="Sélection caisse exécutrice:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idCaisse" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_inputCaisse}" >
                                    <f:selectItem itemLabel="Toutes caisses" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.mesCaissesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection banque destination:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idBanque" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_banque_destination}" >
                                    <f:selectItem itemLabel="Toutes les banques" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.mesBanquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.validerGeneration}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
