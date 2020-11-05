<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="caracteristique">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES CARACTERISTIQUES ET DES INVENTAIRES DES FAMILLES DES PARCS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid columns="3" width="100%">

                <h:panelGrid>
                    <h:panelGrid style="height:34px" width="300px"></h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableFamille" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.dataModelFamilles}"  var="famille">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.selectionFamille}" reRender="panBoutonCaracteristique,tableCaracteristique,panBoutonInventaire,tableInventaire" />
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{famille.famprc1Code}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                                <h:outputText value="#{famille.famprc1LibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <h:panelGrid>
                    <h:panelGrid columns="4" id="panBoutonCaracteristique" style="height:34px" width="300px">
                        <a4j:commandButton title="Nouvelle caractéristique" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.famillesParc1.famprc1Id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.ajouterCaracteristique}" oncomplete="javascript:Richfaces.showModalPanel('panelCaracteristique');" reRender="panelCaracteristique,saisieCaracteristique"/>
                        <a4j:commandButton title="Modifier la caractéristique sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.afficheBoutonCaracteristique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.modifierCaracteristique}" oncomplete="javascript:Richfaces.showModalPanel('panelCaracteristique');" reRender="panelCaracteristique,saisieCaracteristique"/>
                        <a4j:commandButton title="Supprimer la caractéristique sélectionnée" image="/images/supprimer.png" reRender="tableCaracteristique"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.afficheBoutonCaracteristique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.supprimerCaracteristique}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                        <a4j:commandButton title="Imprimer caractéristiques" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpCar');" reRender="panelImpCar"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableCaracteristique" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.dataModelCaracteristiques}"  var="carac">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.selectionCaracteristique}" reRender="panBoutonCaracteristique" />
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header"><h:outputText  value="Caractéristiques" /></f:facet>
                                <h:outputText value="#{carac.carLibelle}"/>
                            </rich:column>
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Organe" /></f:facet>
                                <h:outputText value="#{carac.libOrgane}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <h:panelGrid>
                    <h:panelGrid columns="4" id="panBoutonInventaire" style="height:34px" width="300px">
                        <a4j:commandButton title="Nouvel inventaire" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.famillesParc1.famprc1Id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.ajouterInventaire}" oncomplete="javascript:Richfaces.showModalPanel('panelInventaire');" reRender="panelInventaire,saisieInventaire"/>
                        <a4j:commandButton title="Modifier l'inventaire sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.afficheBoutonInventaire}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.modifierInventaire}" oncomplete="javascript:Richfaces.showModalPanel('panelInventaire');" reRender="panelInventaire,saisieInventaire"/>
                        <a4j:commandButton title="Supprimer l'inventaire sélectionné" image="/images/supprimer.png" reRender="tableInventaire"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.afficheBoutonInventaire}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.supprimerInventaire}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                        <a4j:commandButton title="Imprimer inventaires" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpInv');" reRender="panelImpInv"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableInventaire" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.dataModelInventaires}"  var="inv">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.selectionInventaire}" reRender="panBoutonInventaire" />
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header"><h:outputText  value="Inventaires" /></f:facet>
                                <h:outputText value="#{inv.carLibelle}"/>
                            </rich:column>
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                <h:outputText value="#{inv.libInventaire}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

            </h:panelGrid>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelCaracteristique" width="500" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.showModalPanelCaracteristique}">
        <f:facet name="header"><h:outputText value="GESTION DES CARACTERISTIQUES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif"  id="hideCaracteristique" style="cursor:pointer;margin-left:350px"/>
                <rich:componentControl for="panelCaracteristique" attachTo="hideCaracteristique" operation="hide" event="onclick">
                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.annulerCaracteristique}"/>
                </rich:componentControl>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" id="saisieCaracteristique" columnClasses="clos20,clos80" width="100%">
                <h:column><h:outputText value="Sous famille:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.sousFamille}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.mesSousFamillesItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.caracteristique.carLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Organe:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.caracteristique.carOrgane}">
                        <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                        <f:selectItem itemLabel="Mécanique" itemValue="1"/>
                        <f:selectItem itemLabel="Hydraulyque" itemValue="2"/>
                        <f:selectItem itemLabel="Electrique" itemValue="3"/>
                        <f:selectItem itemLabel="Pneumatique" itemValue="4"/>
                        <f:selectItem itemLabel="Equipement" itemValue="5"/>
                        <f:selectItem itemLabel="Cellerie" itemValue="6"/>
                        <f:selectItem itemLabel="Autre" itemValue="9"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.caracteristique.etat}"/></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup id="valCaracteristique">
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.saveCaracteristique}" style="margin-top:5px;" reRender="panelCaracteristique,tableCaracteristique,panBoutonCaracteristique"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelInventaire" width="500" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.showModalPanelInventaire}">
        <f:facet name="header"><h:outputText value="GESTION DES INVENTAIRES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif"  id="hideInventaire" style="cursor:pointer;margin-left:350px"/>
                <rich:componentControl for="panelInventaire" attachTo="hideInventaire" operation="hide" event="onclick">
                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.annulerInventaire}"/>
                </rich:componentControl>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" id="saisieInventaire" columnClasses="clos20,clos80" width="100%">
                <h:column><h:outputText value="Sous famille:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.sousFamille}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.mesSousFamillesItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.inventaire.carLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Type:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.inventaire.carInventaire}">
                        <f:selectItem itemLabel="Document Administratif" itemValue="0"/>
                        <f:selectItem itemLabel="Document Technique" itemValue="1"/>
                        <f:selectItem itemLabel="Outils" itemValue="2"/>
                        <f:selectItem itemLabel="Consommables" itemValue="3"/>
                        <f:selectItem itemLabel="Pièces de rechange" itemValue="4"/>
                        <f:selectItem itemLabel="Accessoires" itemValue="5"/>
                        <f:selectItem itemLabel="Autre" itemValue="9"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.inventaire.etat}"/></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup id="valInventaire">
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.saveInventaire}" style="margin-top:5px;" reRender="panelInventaire,tableInventaire,panBoutonInventaire"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImpCar" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelinkCar"/>
                    <rich:componentControl for="panelImpCar" attachTo="hidelinkCar" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpCar" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerCarXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImpInv" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelinkInv"/>
                    <rich:componentControl for="panelImpInv" attachTo="hidelinkInv" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpInv" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaracteristiquesParcs.imprimerInvXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
