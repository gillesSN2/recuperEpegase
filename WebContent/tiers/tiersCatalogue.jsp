<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersCat">

    <a4j:form id="formCat" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="CATALOGUE DES PRODUITS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" /></h2></center>

        <h:panelGrid  id="cont1" width="100%" >          

            <h:panelGrid width="100%">
                <h:panelGroup>
                    <center>
                        <a4j:commandButton image="/images/print.png" title="Impression du catalogue des produits" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.initImpressionCatalogue}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>&nbsp;&nbsp;&nbsp;
                    </center>
                </h:panelGroup>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="elements"/>
                    <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="elements" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelCatalogue}" var="doc">
                        <rich:column width="10%" sortable="true" sortBy="#{doc.produits.proCode}">
                            <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{doc.produits.proCode}" />
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{doc.profouRef}">
                            <f:facet name="header" ><h:outputText value="Référence"/></f:facet>
                            <h:outputText value="#{doc.profouRef}" />
                        </rich:column>
                        <rich:column width="24%" sortable="true" sortBy="#{doc.produits.proLibClient}">
                            <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                            <h:outputText value="#{doc.produits.proLibClient}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{doc.produits.proAchCode}">
                            <f:facet name="header" ><h:outputText value="Fam. Ach."/></f:facet>
                            <h:outputText value="#{doc.produits.proAchCode}" />
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{doc.produits.proAchCode}">
                            <f:facet name="header" ><h:outputText value="Fam. Vte"/></f:facet>
                            <h:outputText value="#{doc.produits.proAchCode}" />
                        </rich:column>
                        <rich:column width="8%" sortable="true" style="text-align:right;" sortBy="#{doc.profouPa}">
                            <f:facet name="header" ><h:outputText value="P.A"/></f:facet>
                            <h:outputText value="#{doc.profouPa}" rendered="#{doc.profouPa!=0}">
                                <c:if test="${doc.profouFormat==0}">
                                    <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                </c:if>
                                <c:if test="${doc.profouFormat==1}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </c:if>
                                <c:if test="${doc.profouFormat==2}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </c:if>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{doc.profouDevise}">
                            <f:facet name="header" ><h:outputText value="Devise"/></f:facet>
                            <h:outputText value="#{doc.profouDevise}" />
                        </rich:column>
                        <rich:column width="8%" sortable="true" style="text-align:right;" sortBy="#{doc.profouPaEuro}">
                            <f:facet name="header" ><h:outputText value="P.A. (€)"/></f:facet>
                            <h:outputText value="#{doc.profouPaEuro}" rendered="#{doc.profouPaEuro!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="8%" sortable="true" style="text-align:right;" sortBy="#{doc.profouPaLocal}">
                            <f:facet name="header" ><h:outputText value="P.A. (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise})"/></f:facet>
                            <h:outputText value="#{doc.profouPaLocal}" rendered="#{doc.profouPaLocal!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="8%" sortable="true" style="text-align:right;" sortBy="#{doc.qteTotaleStock}">
                            <f:facet name="header" ><h:outputText value="Qte."/></f:facet>
                            <h:outputText value="#{doc.qteTotaleStock}" rendered="#{doc.qteTotaleStock!=0}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable styleClass="bg" id="idPj" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelCatalogueFichier}"  style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="fichier">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionnerCatalogue}"/>
                        <rich:column  width="70%" sortable="true"  sortOrder="DESCENDING" label="Acces catalogue">
                            <f:facet name="header"><h:outputText value="Catalogues des produits"/></f:facet>
                            <h:outputText value="#{fichier}" />
                        </rich:column>
                        <rich:column  width="10%" sortable="true" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                            <h:commandButton image="/images/detail.png"  style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterCatalogue}"/>
                        </rich:column >
                        <rich:column  width="10%" sortable="true" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Supprimer"/></f:facet>
                            <h:commandButton image="/images/supprimer.png"  style="height:15px;width:15px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce catalogue ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerCatalogue}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="Ajouter catalogue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterCatalogue}" reRender="panalAjoutFile"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourDocuments}" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton value="MAJ PRIX" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.recalculPrix}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,elements"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES CATALOGUES VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annulerCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.uploadedFile}" accept=".pdf,.PDF"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.validerCatalogue}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du catalogue (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerVisuCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPrintCatalogue}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPrintCatalogue}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
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
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomModeleListe}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.listeImpressionCatalogueItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCataloguePRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCataloguePDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoieCatalogueMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerCatalogueMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>