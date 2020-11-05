<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="mayite">
    <a4j:form>

        <center><h2><h:outputText value="LISTE DES MEDICAMENTS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="8" styleClass="recherche" width="100%">
                <h:column>
                    <h:selectOneMenu id="itemType" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.var_typeFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Sélection Type" itemValue="100"/>
                        <f:selectItem itemLabel="Médicaments" itemValue="0"/>
                        <f:selectItem itemLabel="Compléments Alimentaires" itemValue="1"/>
                        <f:selectItem itemLabel="Médicaments à base de plantes" itemValue="2"/>
                        <f:selectItem itemLabel="Hydratants Cutanés" itemValue="3"/>
                        <f:selectItem itemLabel="Homéopathie" itemValue="4"/>
                        <f:selectItem itemLabel="Produits Vétérinaires" itemValue="5"/>
                        <f:selectItem itemLabel="Para-Pharmacie" itemValue="6"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.calculeSelectItem}" reRender="recherche,mytableau,scrollTable,panelBouton"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Code CIP"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.var_cipFind}" style="width:60px;"/></h:column>
                <h:column><h:outputText  value="Spécialité"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.var_speFind}" style="width:100px;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="itemDci" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.var_dciFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes DCI" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.mesdciItems}" />
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.effaceRecherche}" reRender="mytableau,scrollTable,panelBouton"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="itemClasse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.var_classeFind}" style="width:130px;">
                        <f:selectItem itemLabel="Toutes Classes" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.mesclasseItems}" />
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.effaceRecherche}" reRender="mytableau,scrollTable,panelBouton"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.rechercherProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,mytableau,scrollTable" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="6">
            <a4j:commandButton image="/images/modifier.png"  title="Consulter le produit" oncomplete="javascript:Richfaces.showModalPanel('panelMedicamment');" reRender="panelMedicamment" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.afficheButtModif}"/>
            <a4j:commandButton image="/images/detail.png"  title="Information sur la DCI" oncomplete="javascript:Richfaces.showModalPanel('panelDci');" reRender="panelDci,formulairedci" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.affiche_dci}"/>
            <a4j:commandButton image="/images/print.png"  title="imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.afficheButtModif}"/>
            <a4j:commandButton value="Trf. en Produits" styleClass="exp_lienmenu" title="Convertir le Mayité en produits" onclick="if (!confirm('Etes-vous sur de vouloir transférer la liste en cours du Mayité en produit?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.transfMedicammentProduit}" reRender="modAttente"/>
            <a4j:commandButton rendered="false" value="Import Mayité" styleClass="exp_lienmenu" title="Importer le Mayité" onclick="if (!confirm('Etes-vous sur de vouloir importer le Mayité par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.importerMayite}" reRender="modAttente,recherche"/>
            <a4j:commandButton value="Import Base Publique" styleClass="exp_lienmenu" title="Importer la base publique" onclick="if (!confirm('Etes-vous sur de vouloir importer la base publique?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.importerBasePublique}" reRender="modAttente,recherche,panalAjoutFile"/>
        </h:panelGrid>

        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="mytableau"/>
            <rich:extendedDataTable rows="200" border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.madatamodel}"  var="med">
                <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.selectionMedicamment}" reRender="panelBouton"/>
                <rich:column label="Code CIS" width="10%" sortable="true" sortBy="#{med.promdcCodeCis}" sortOrder="ASCENDING">
                    <f:facet name="header"><h:outputText  value="Code CIS"  /></f:facet>
                    <h:outputText  value="#{med.promdcCodeCis}"/>
                </rich:column>
                <rich:column label="Code CIP" width="10%" sortable="true" sortBy="#{med.promdcCodeCip}">
                    <f:facet name="header"><h:outputText  value="Code CIP"  /></f:facet>
                    <h:outputText  value="#{med.promdcCodeCip}"/>
                </rich:column>
                <rich:column label="D.C.I." width="20%" sortable="true" sortBy="#{med.promdcCodeDci}">
                    <f:facet name="header"><h:outputText  value="DCI"  /></f:facet>
                    <h:inputTextarea  value="#{med.promdcCodeDci}" rows="1" style="width:100%" readonly="true"/>
                </rich:column>
                <rich:column label="Nom du spécialité" width="20%" sortable="true" sortBy="#{med.promdcSpecialite}">
                    <f:facet name="header"><h:outputText  value="Spécialité"  /></f:facet>
                    <h:inputTextarea value="#{med.promdcSpecialite}" rows="1" style="width:100%" readonly="true"/>
                </rich:column>
                <rich:column label="Dosage" width="5%" sortable="true" sortBy="#{med.promdcDosage}">
                    <f:facet name="header"><h:outputText  value="Dosage"  /></f:facet>
                    <h:inputTextarea value="#{med.promdcDosage}" rows="1" style="width:100%" readonly="true"/>
                </rich:column>
                <rich:column label="forme galénique" width="15%" sortable="true" sortBy="#{med.promdcForme}">
                    <f:facet name="header"><h:outputText  value="Forme"  /></f:facet>
                    <h:inputTextarea value="#{med.promdcForme}" rows="1" style="width:100%" readonly="true"/>
                </rich:column>
                <rich:column label="Classe thérapeutique" width="15%" sortable="true" sortBy="#{med.promdcClasse}">
                    <f:facet name="header"><h:outputText  value="Classe"  /></f:facet>
                    <h:inputTextarea value="#{med.promdcClasse}" rows="1" style="width:100%" readonly="true"/>
                </rich:column>
                <rich:column label="Liste d'appartenance" width="5%" sortable="true" sortBy="#{med.promdcListe}">
                    <f:facet name="header"><h:outputText  value="Liste"/></f:facet>
                    <h:outputText value="#{med.promdcListe}" />
                </rich:column>
                <rich:column label="Laboratoire" width="10%" sortable="true" sortBy="#{med.promdcLaboratoire}">
                    <f:facet name="header"><h:outputText  value="Laboratoire"  /></f:facet>
                    <h:inputTextarea value="#{med.promdcLaboratoire}" rows="1" style="width:100%" readonly="true"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br/>
        <center>
            Cliquez  <A target="_blank" HREF="http://www.mayite-service.com/" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site du Mayité.
            <br/><br/>
            Cliquez  <A target="_blank" HREF="http://base-donnees-publique.medicaments.gouv.fr/telechargement.php" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site de la base des médicamments publics.
            <br/><br/>
            Cliquez  <A target="_blank" HREF="http://www.esculape.com/DFM/index-DFM.html" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site d'ESCULAPE.
            <br/><br/>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelMedicamment" width="800" height="330"  headerClass="headerPanel" style="border:solid 0px black;background-color:white">
        <f:facet name="header"><h:outputText value="INFORMATIONS SUR LE MEDICAMMENT" /></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                <rich:componentControl for="panelMedicamment" attachTo="hidelink" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulaireajt">
            <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                <h:column><h:outputText value="Code CIP:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcCodeCip}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Code COPHASE:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcCodeCophase}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="DCI:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcCodeDci}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Spécialité:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcSpecialite}"readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Dosage:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcDosage}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Forme galénique:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcForme}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Classe thérapeutique:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcClasse}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Prix:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcPrix}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Liste:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcListe}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Laboratoire:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsMedicamment.promdcLaboratoire}" readonly="true" style="width:100%"/></h:column>
            </h:panelGrid>         
        </a4j:form>
    </rich:modalPanel>


     <rich:modalPanel domElementAttachment="parent"  id="panelDci" width="800" height="450"  headerClass="headerPanel" style="border:solid 0px black;background-color:white;overflow:auto;">
        <f:facet name="header"><h:outputText value="D.C.I. du médicamment" /></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkdci"/>
                <rich:componentControl for="panelDci" attachTo="hidelinkdci" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulairedci">
            <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                <h:column><h:outputText value="DCI:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsDci.prodciCode}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Forme:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsDci.prodciForme}"readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Indication:"/></h:column>
                <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsDci.prodciIndication}" readonly="true" rows="4" style="width:100%" /></h:column>
                <h:column><h:outputText value="Posologie:"/></h:column>
                <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsDci.prodciPosologie}" readonly="true" rows="4" style="width:100%" /></h:column>
                <h:column><h:outputText value="Contre indication:"/></h:column>
                <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsDci.prodciContreIndic}" readonly="true" rows="4" style="width:100%" /></h:column>
                <h:column><h:outputText value="Effet secondaire:"/></h:column>
                <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.produitsDci.prodciEffetSecond}" readonly="true" rows="4" style="width:100%" /></h:column>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="300" headerClass="headerPanel" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.showModalPanelBasePublique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.showModalPanelBasePublique}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="IMPORTER BASE PUBLIQUE DE MEDICAMMENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.fermerBasePublique}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <rich:fileUpload id="upload1" acceptedTypes="txt,TXT" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.listener}">
                            <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                        </rich:fileUpload>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Importer fichier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMedicamment.validerBasePublique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
