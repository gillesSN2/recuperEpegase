<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="mod">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES MODELES DE DOCUMENTS R.H." style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <a4j:commandButton title="Ajouter un nouveau modèle" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.ajouterModeles}" reRender="panelAjt"/>
                <a4j:commandButton title="Modifier le modèle sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modifierModeles}" reRender="panelAjt"/>
                <a4j:commandButton title="Supprimer le modèle sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.supprimerModeles}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" reRender="table" />
                <a4j:commandButton title="Imprimer les modèles" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.datamodelModeles}"  var="modele">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.selectionModele}" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{modele.lib_nature}" width="10%">
                        <f:facet name="header"><h:outputText  value="Nature"  /></f:facet>
                        <h:outputText  value="#{modele.lib_nature}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{modele.lib_type}"  width="15%">
                        <f:facet name="header"><h:outputText  value="Type"  /></f:facet>
                        <h:outputText  value="#{modele.lib_type}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{modele.modCode}" width="10%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{modele.modCode}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{modele.modNomFr}" width="60%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText  value="#{modele.modNomFr}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{modele.etat}" width="5%">
                        <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                        <h:commandButton image="#{modele.etat}"  id="inactif"  rendered="#{modele.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.reactiverModeles}">
                            <a4j:support eventsQueue="maQueue" reRender="table"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:column>
                Cliquez  <A target="_blank" HREF="http://www.documentissime.fr/modeles-de-lettres/emploi-et-vie-professionnelle/" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site deDocumentissime, pour ovoir des modèles de documents gratuits.
            </h:column>
            <br><br>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent" id="panelAjt" width="1000" height="700" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.showModalPanel}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.showModalPanel}" var="mod">
            <f:facet name="header"><h:outputText value="GESTION DES MODELES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAjt"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup  style="width:100%;">
                    <h:panelGrid id="panGlob" columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Nature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature}">
                                <f:selectItem itemLabel="Sélectionnez un type" itemValue=""/>
                                <f:selectItem itemLabel="Contrat" itemValue="82"/>
                                <f:selectItem itemLabel="Attestation" itemValue="83"/>
                                <f:selectItem itemLabel="Certificat" itemValue="85"/>
                                <f:selectItem itemLabel="Correspondance" itemValue="86"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.calculeMesTypes}" reRender="panGlob,idType,panChoixDico,idT1,idT2" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idT1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='82'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='83'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='85'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='86'}"><h:outputText value="Type:"/></h:column>
                        <h:column id="idT2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='82'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='83'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='85'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNature=='86'}">
                            <h:selectOneMenu id="idType" style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modType}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.mesTypesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modCode}" onkeypress="return scanToucheLettre(event)" style="width:200px;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modId!=0}">
                                <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp,outptcode" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.doublonCode}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modNomFr}" onkeypress="return scanToucheLettre(event)" style="width:390px;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Inactif:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.inactif}" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%" columns="5" id="panChoixDico">
                        <h:column><a4j:commandButton value="Ex. modèles" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.ouvrirModelesExemples}" reRender="panelModelesExemples"/></h:column>
                        <h:column><a4j:commandButton value="Tbl.: Utilisateurs" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.ouvrirDictUser}" reRender="panelDictionnaire"/></h:column>
                        <h:column><a4j:commandButton value="Tbl.: Structure" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.ouvrirDictStructure}" reRender="panelDictionnaire"/></h:column>
                        <h:column><a4j:commandButton value="Tbl.: Agents" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.ouvrirDictAgent}" reRender="panelDictionnaire"/></h:column>
                        <h:column><a4j:commandButton value="Tbl.: Contrats" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.ouvrirDictContrat}" reRender="panelDictionnaire"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" id="idTexte">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.modelesCourriers.modTexte}">
                            <jsp:include flush="true" page="/css/tdt.jsp"/>
                        </rich:editor>
                        <h:column><h:outputText value="Les champs [ ] issus des dictionnaires (utilisateurs, structure, agents..), seront interprétés lors de l'utilisation du modèle." style="color:red"/></h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.saveModeles}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.doublon}"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.doublon}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelDictionnaire"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.showModalPanelDictionnaire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.showModalPanelDictionnaire}" var="dic">
            <f:facet name="header"><h:outputText value="Sélection du champ de la table : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.var_nom_table}"/></f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDictionnaire" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.dataModelDictionnaire}" var="dic">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" id="idRowDictionnaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.selectionDictionnaire}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Nom" sortable="true" sortBy="#{dic.column_name}" width="30%">
                            <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                            <h:outputText value="[#{dic.column_name}]"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{dic.column_comment}" width="70%">
                            <f:facet name="header"><h:outputText  value="Explication champ" /></f:facet>
                            <h:outputText value="#{dic.column_comment}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanDictionnaire" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.annuleDictionnaire}" reRender="panelDictionnaire"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDictionnaire" image="/images/copier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.calculeDictionnaire}" reRender="panelDictionnaire"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanDictionnaire')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValDictionnaire')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent" id="panelModelesExemples" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1100" height="630" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.showModalPanelModelesExemples}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.showModalPanelModelesExemples}" var="ext">
            <f:facet name="header"><h:outputText value="Sélection des modèles de documents"/></f:facet>
            <a4j:form>
                <h:panelGrid width="100%" columns="2" id="panModExGlog" columnClasses="clos20g,clos80">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableModelesExemples" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="300px" height="500px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.dataModelModeleExemples}" var="modEx">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" id="idRowDictionnaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.selectionModelesExemples}" reRender="idTexteModele"/>
                            <rich:column label="Nom" sortable="false" width="100%">
                                <f:facet name="header"><h:outputText value="Nom modèle" /></f:facet>
                                <h:outputText value="#{modEx.column_name}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <rich:editor id="idTexteModele" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.var_texte_modele}" readonly="true">
                        <jsp:include flush="true" page="/css/tdt.jsp"/>
                        <f:param name="height" value="500"/>
                    </rich:editor>
                </h:panelGrid>
                <br>
                <h:panelGroup >
                    <center>
                        <a4j:commandButton id="idCanModelesExemples" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.annuleModelesExemples}" reRender="panelModelesExemples"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValModelesExemples" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersPaye.calculeModelesExemples}" reRender="panelModelesExemples,idTexte"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanModelesExemples')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

                
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>

