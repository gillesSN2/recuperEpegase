<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="medicENcaissement">

    <center> <h2><h:outputText value="GESTION DES BONS D'ENCAISSEMENT" style="color:green;"/></h2></center>

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  columns="6" styleClass="recherche" width="100%" id="boutons">
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.inpEtat}" style="width:100px;">
                        <f:selectItem itemLabel="A exécuter" itemValue="0"/>
                        <f:selectItem itemLabel="Déjà exécutés" itemValue="1"/>
                        <f:selectItem itemLabel="Annulés" itemValue="2"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="boutons"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.inpEtat!=0}"><h:outputText value="Du:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.inpEtat!=0}"><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.dateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.inpEtat!=0}"><h:outputText value="Au:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.inpEtat!=0}"><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.dateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.chargerFind}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt,scrollTable,table,pnlgrttotal"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="pangrpVisbt" style="height:34px" columns="6" width="300px">
            <a4j:commandButton title="Modifier l'encaissement sélectionné" image="/images/modifier.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.modifierBon}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonEtat==0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'encaissement sélectionné" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.consultBonEncaissement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.visibiliteBton}" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Annuler l'encaissement sélectionné" image="/images/annuler_big.png"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.annulerBonEncaissement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonEtat==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.usersChrono.usrchrUpdate==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.usersChrono.usrchrUpdate==4)}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Supprimer l'encaissement sélectionné" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet encaissement ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.deleteBonEncaissement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonEtat==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.usersChrono.usrchrUpdate==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.usersChrono.usrchrUpdate==4)}" reRender="idSubView"/>
            <a4j:commandButton title="Imprimer reçu" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_nb_max}" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0"  width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.datamodelEncaiss}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.visualisationLigne}" reRender="idSubView,pangrpVisbt"/>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.var_lib_nat}" sortOrder="DESCENDING" width="150px">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{var.var_lib_nat}"/>
                        </rich:column>
                        <rich:column label="Numéro document" sortable="true" sortBy="#{var.bonRef}" width="110px">
                            <f:facet name="header"><h:outputText  value="Num." /></f:facet>
                            <h:outputText value="#{var.bonRef}"/>
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
                        <rich:column label="Tiers" sortable="true" sortBy="#{var.bonNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
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
                        <rich:column label="Caisse" sortable="true" sortBy="#{var.bonCodeCaisse}" style="text-align:center;" width="100px">
                            <f:facet name="header"><h:outputText  value="Caisse" /></f:facet>
                            <h:outputText value="#{var.bonCodeCaisse}"/>
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
                            <h:outputText  value="#{var.bonService} #{var.bonObject}"/>
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
                <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.montantRecette}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_choix_modele}" >
                            <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.ListeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menuvente.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Bon Encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.fermerAnnulerBon}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonMotifAnnule}" maxlength="20"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.validerAnnulerBon}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
