<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="contratabnauto">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="FACTURATION DES CONTRATS DES ABONNEMENTS" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" id="panelBoutonGene">
            <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                <h:column><h:outputText value="Région:" /></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.region}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesRegionsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Modèle facture:" /></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.modeleFacture}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesImpressionsFacturesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Période:" /></h:column>
                <h:column>
                    <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.periode}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesPeriodesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculeDates}" reRender="idD1,idD2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Du "/></h:column>
                <h:column><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.inpDu}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column><h:outputText value="au "/></h:column>
                <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.inpAu}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup >
                    <center>
                        <a4j:commandButton id="idValRechercheGene" title="Facturation automatique" value="RECHERHCER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.rechercheContratAbonnement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonGene,tableGene,scrollTableGene"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <rich:hotKey key="return" handler="#{rich:element('idValRechercheGene')}.click()" />
                        <a4j:commandButton title="Imprimer" image="/images/print.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.ouvrirImpressionAbn}" reRender="panelImpReleve"/>
                    </center>
                </h:panelGroup>
            </center>
        </h:panelGrid>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.pageIndex}" reRender="tableGene" id="scrollTableGene" maxPages="20"align="left" for="tableGene"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableGene" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelEnteteGene}" var="var" activeRowKey="true" rowKeyVar="rkv" sortMode="multi" selectionMode="single">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionLigneGene}"/>
                    <rich:column label="N° contrat" sortable="true" sortBy="#{var.facContrat}">
                        <f:facet name="header"><h:outputText  value="N° CONTRAT" /></f:facet>
                        <h:outputText value="#{var.facContrat}"/>
                    </rich:column>
                    <rich:column label="Date facture" sortable="true" sortBy="#{var.facDate}" width="70px">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{var.facDate}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                        <f:facet name="header"><h:outputText  value="S." /></f:facet>
                        <h:outputText value="#{var.facSerie}"/>
                    </rich:column>
                    <rich:column label="Catégorie client" sortable="true" sortBy="#{var.facCat}" width="70px">
                        <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                        <h:outputText value="#{var.facCat}"/>
                    </rich:column>
                    <rich:column label="Client" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                        <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                        <h:outputText  value="#{var.var_nom_tiers}"/>
                    </rich:column>
                    <rich:column label="N° Compteur" sortable="true" sortBy="#{var.facInfo1}">
                        <f:facet name="header"><h:outputText  value="N° Compteur" /></f:facet>
                        <h:outputText value="#{var.facInfo1}"/>
                    </rich:column>
                    <rich:column label="Ancien index" sortable="true" sortBy="#{var.facInfo2}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Ancien index" /></f:facet>
                        <h:outputText value="#{var.facInfo2}" style="text-align:right"/>
                    </rich:column>
                    <rich:column label="Nouvel index" sortable="true" sortBy="#{var.facInfo3}">
                        <f:facet name="header"><h:outputText  value="Nouvel index" /></f:facet>
                        <h:inputText value="#{var.facInfo3}" disabled="#{var.var_select_ligne}">
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.calculIndex}" reRender="idNbIndex"/>
                        </h:inputText>
                    </rich:column>
                    <rich:column id="idNbIndex" label="Nb index" sortable="true" sortBy="#{var.facInfo4}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Nb index" /></f:facet>
                        <h:outputText value="#{var.facInfo4}" style="text-align:right"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>

        <h:panelGroup>
            <center>
                <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annulerGene}"/>&nbsp;&nbsp;
                <h:commandButton id="idValGene" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.validerGene}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpReleve" headerClass="headerPanel"  width="650" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelPrintReleve}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelPrintReleve}" var="prtrec">
            <f:facet name="header"><h:outputText value="Impression du relevé des index"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.fermerImpressionAbn}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpReleve"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un format d'Impression" style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.imprimerAbnXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
