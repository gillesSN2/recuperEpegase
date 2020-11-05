<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="centreimpot">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES CONVENTIONS COLLECTIVES ET GRILLES DES SALAIRES" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g">

            <h:panelGrid width="100%">
                <h:panelGroup id="idButtonConvention">
                    <center>
                        <a4j:commandButton title="Ajouter une nouvelle convention" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.ajouterConvention}" reRender="panelConvention"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Modifier la convention sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.var_affiche_convention}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.modifierCnvention}" reRender="panelConvention"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Supprimer la convention sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.var_affiche_convention}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.supprimerConvention}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" reRender="tableConvention,tableGrille" />&nbsp;&nbsp;
                        <a4j:commandButton title="Impression des conventions collectives" image="/images/print.png" style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImpConv');"/>
                    </center>
                </h:panelGroup>
                <br/>
                <h:panelGroup>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableConvention" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="250%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.dataModelConvention}" var="conv">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.selectionConvention}" reRender="tableGrille,idButtonConvention,idButtonGrille"/>
                                <rich:column sortOrder="ASCENDING" sortBy="#{conv.code}" style="text-align:left;">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText style="size:5px;margin-left:10px;" value="#{conv.code}"/>
                                </rich:column>
                                <rich:column width="50px" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Utilisé"/></f:facet>
                                    <h:selectBooleanCheckbox  value="#{conv.valide}"/>
                                </rich:column>
                                <rich:column width="300px" style="text-align:left;">
                                    <f:facet name="header"><h:outputText  value="Libellé Convention"/></f:facet>
                                    <h:outputText  value="#{conv.lib_FR}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Nb.H./mois"/></f:facet>
                                    <h:outputText  value="#{conv.heure_mois}" rendered="#{conv.heure_mois!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Nb.H./semaine"/></f:facet>
                                    <h:outputText  value="#{conv.heure_semaine}" rendered="#{conv.heure_semaine!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Date maj"/></f:facet>
                                    <h:outputText  value="#{conv.date_maj}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="A.T."/></f:facet>
                                    <h:outputText  value="#{conv.at}" rendered="#{conv.at!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T1"/></f:facet>
                                    <h:outputText  value="#{conv.tranche1}" rendered="#{conv.tranche1!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T2"/></f:facet>
                                    <h:outputText  value="#{conv.tranche2}" rendered="#{conv.tranche2!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T3"/></f:facet>
                                    <h:outputText  value="#{conv.tranche3}" rendered="#{conv.tranche3!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T4"/></f:facet>
                                    <h:outputText  value="#{conv.tranche4}" rendered="#{conv.tranche4!=0}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T5"/></f:facet>
                                    <h:outputText  value="#{conv.tranche5}" rendered="#{conv.tranche5!=0}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </h:panelGroup>
            </h:panelGrid>

            <h:panelGrid width="100%">
                <h:panelGroup id="idButtonGrille">
                    <center>
                        <a4j:commandButton title="Ajouter une nouvelle grille" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.ajouterGrille}" reRender="panelGrille"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Modifier la grille sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.var_affiche_grille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.modifierGrille}" reRender="panelGrille"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Supprimer la grille sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.var_affiche_grille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.supprimerGrille}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" reRender="tableGrille" />&nbsp;&nbsp;
                        <a4j:commandButton title="Impression de la grille salariale" image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImpGril');"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Mise à jour des contrats des salariés" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.var_affiche_grille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.majContrat}" onclick="if (!confirm('Etes vous sur de vouloir affecté les barêmes de la convention sélectionnée aux contrats?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                    </center>
                </h:panelGroup>
                <br/>
                <h:panelGroup>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableGrille" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="340%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.dataModelGrilles}" var="grl">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.selectionGrille}" reRender="idButtonGrille"/>
                                <rich:column >
                                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                                    <h:outputText style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille};size:5px;margin-left:10px;" value="#{grl.code}"/>
                                </rich:column>
                                <rich:column width="200px">
                                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                                    <h:outputText  value="#{grl.lib_FR}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Valeur Mois"  /></f:facet>
                                    <h:outputText  value="#{grl.val_mois}" rendered="#{grl.val_mois!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Valeur heure"  /></f:facet>
                                    <h:outputText  value="#{grl.val_heure}" rendered="#{grl.val_heure!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}"/>
                                </rich:column>
                                <rich:column >
                                    <f:facet name="header"><h:outputText  value="Niveau"  /></f:facet>
                                    <h:outputText  value="#{grl.niveau}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}"/>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Rendement"  /></f:facet>
                                    <h:outputText  value="#{grl.rendement}" rendered="#{grl.rendement!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Responsabilite"  /></f:facet>
                                    <h:outputText  value="#{grl.responsabilite}" rendered="#{grl.responsabilite!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Fonction"  /></f:facet>
                                    <h:outputText  value="#{grl.fonction}" rendered="#{grl.fonction!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Caisse"  /></f:facet>
                                    <h:outputText  value="#{grl.caisse}" rendered="#{grl.caisse!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Transport"  /></f:facet>
                                    <h:outputText  value="#{grl.transport}" rendered="#{grl.transport!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Téléphone"  /></f:facet>
                                    <h:outputText  value="#{grl.telephone}" rendered="#{grl.telephone!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Logement"  /></f:facet>
                                    <h:outputText  value="#{grl.logement}" rendered="#{grl.logement!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Eau"  /></f:facet>
                                    <h:outputText  value="#{grl.eau}" rendered="#{grl.eau!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Electricité"  /></f:facet>
                                    <h:outputText  value="#{grl.electricite}" rendered="#{grl.electricite!=0}" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.colorGrille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </h:panelGroup>
            </h:panelGrid>
            <br>
            <h:panelGroup>
                <center>
                    <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Grille standard" style="color:black;"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Grille personnelle" style="color:red;"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton value="VALIDER" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.majConvention}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelImpConv" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelinkConv"/>
                    <rich:componentControl for="panelImpConv" attachTo="hidelinkConv" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpConv" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerConvXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImpGril" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelinkGril"/>
                    <rich:componentControl for="panelImpGril" attachTo="hidelinkGril" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpGril" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.imprimerGrilXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelConvention" width="600" height="480" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.showModalPanelConvention}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.showModalPanelConvention}" var="con">
            <f:facet name="header"><h:outputText value="GESTION DES CONVENTIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.fermerConvention}" image="/images/close.gif" styleClass="hidelink" reRender="panelConvention"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup  style="width:100%;">
                    <h:panelGrid id="panGlob" columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.code}" onkeypress="return scanToucheLettre(event)" style="width:200px"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.lib_FR}" onkeypress="return scanToucheLettre(event)" style="width:90%"/></h:column>
                        <h:column><h:outputText value="Nb heures/mois:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.heure_mois}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nb heures/semaine:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.heure_semaine}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date MAJ:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.date_maj}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Tranche 1:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.tranche1}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Tranche 2:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.tranche2}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Tranche 3:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.tranche3}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Tranche 4:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.tranche4}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Tranche 5:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.tranche5}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Inactif:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetConvention.inactif}" layout="pageDirection" style="width:400px" >
                                <f:selectItem itemLabel="Actif" itemValue="0"/>
                                <f:selectItem itemLabel="Inactif" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                    <center>
                        <br><br>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.validerConvention}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelGrille" width="600" height="480" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.showModalPanelGrille}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.showModalPanelGrille}" var="mod">
            <f:facet name="header"><h:outputText value="GESTION DES GRILLES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.fermerGrille}" image="/images/close.gif" styleClass="hidelink" reRender="panelGrille"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup  style="width:100%;">
                    <h:panelGrid id="panGlob" columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.code}" onkeypress="return scanToucheLettre(event)" style="width:200px"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.lib_FR}" onkeypress="return scanToucheLettre(event)" style="width:90%"/></h:column>
                        <h:column><h:outputText value="Niveau:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.niveau}">
                                <f:selectItem itemLabel="Non cadre" itemValue="0"/>
                                <f:selectItem itemLabel="Cadre" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Valeur mensuelle:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.val_mois}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Valeur horaire:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.val_heure}" style="text-align:right;width:100px;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="3" maxFractionDigits="3"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Rendement:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.rendement}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Responsabilité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.responsabilite}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Fonction:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.fonction}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Caisse:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.caisse}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Transport:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.transport}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Téléphone:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.telephone}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Logement:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.logement}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Eau:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.eau}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Electricité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.objetGrilleSalaire.electricite}" style="text-align:right;width:100px;">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                    <center>
                        <br><br>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConventionsCollectives.validerGrille}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
