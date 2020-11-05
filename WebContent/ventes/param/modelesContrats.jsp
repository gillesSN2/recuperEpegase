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

        <center> <h2><h:outputText value="LISTE DES MODELES DE CONTRATS COMMERCIAUX" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <a4j:commandButton title="Ajouter un nouveau modèle" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.ajouterModeles}" reRender="panelAjt"/>
                <a4j:commandButton title="Modifier le modèle sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modifierModeles}" reRender="panelAjt"/>
                <a4j:commandButton title="Supprimer le modèle sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.supprimerModeles}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" reRender="table" />
                <a4j:commandButton title="Imprimer les modèles" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.datamodelModeles}"  var="modele">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.selectionModele}" reRender="pangrpVisbt"/>
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
                    <rich:column sortable="true" sortBy="#{modele.modNomFr}" width="55%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText  value="#{modele.modNomFr}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{modele.etat}" width="5%">
                        <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                        <h:commandButton image="#{modele.etat}"  id="inactif"  rendered="#{modele.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.reactiverModeles}">
                            <a4j:support eventsQueue="maQueue" reRender="table"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:column>
                Cliquez  <A target="_blank" HREF="http://www.documentissime.fr/modeles-de-lettres/entreprise-et-association/" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site deDocumentissime, pour ovoir des modèles de documents gratuits.
            </h:column>
            <br><br>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelAjt" width="880" height="700" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.showModalPanel}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.showModalPanel}" var="mod">
            <f:facet name="header"><h:outputText value="GESTION DES CONTRATS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAjt"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup  style="width:100%;" id="panGroup">
                    <h:panelGrid id="panGlob" columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Nature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modId!=0}">
                                <f:selectItem itemLabel="Contrat" itemValue="25"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.calculeMesTypes}" reRender="panGlob,panChoixDico,idType" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idType" style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modId!=0}">
                                <f:selectItem itemLabel="Contrat de vente" itemValue="0"/>
                                <f:selectItem itemLabel="Contrat de leasing" itemValue="1"/>
                                <f:selectItem itemLabel="Contrat de garantie" itemValue="2"/>
                                <f:selectItem itemLabel="Contrat de formation" itemValue="3"/>
                                <f:selectItem itemLabel="Contrat de location" itemValue="4"/>
                                <f:selectItem itemLabel="Contrat de gérance" itemValue="5"/>
                                <f:selectItem itemLabel="Contrat de syndic" itemValue="6"/>
                                <f:selectItem  itemLabel="Contrat de maintenance" itemValue="20"/>
                                <f:selectItem  itemLabel="Contrat d'assistance" itemValue="21"/>
                                <f:selectItem  itemLabel="Contrat d'abonnement" itemValue="22"/>
                                <f:selectItem  itemLabel="Contrat de sauvegarde" itemValue="23"/>
                                <f:selectItem itemLabel="Autre type de contrat" itemValue="99"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panGroup,panGlob,tabOption,panOptions" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modCode}" onkeypress="return scanToucheLettre(event)" style="width:200px;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modId!=0}">
                                <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp,outptcode" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.doublonCode}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modNomFr}" onkeypress="return scanToucheLettre(event)" style="width:390px;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Inactif:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.inactif}" /></h:column>
                    </h:panelGrid>

                    <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabTdt" label="Contrat">
                            <h:panelGrid  style="width:100%" columns="4" id="panChoixDico">
                                <h:column><h:commandButton value="Ex. modèles" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.ouvrirModelesExemples}"/></h:column>
                                <h:column><h:commandButton value="Tbl.: Utilisateurs" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.ouvrirDictUser}"/></h:column>
                                <h:column><h:commandButton value="Tbl.: Structure" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.ouvrirDictStructure}"/></h:column>
                                <h:column><h:commandButton value="Tbl.: Tiers" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.ouvrirDictTiers}"/></h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                            </h:panelGrid>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTexte}">
                                <jsp:include flush="true" page="../../css/tdt.jsp"/>
                            </rich:editor>
                            <h:column><h:outputText value="Les champs [ ] issus des dictionnaires (utilisateurs, structure, tiers..), seront interprétés lors de l'utilisation du modèle." style="color:red"/></h:column>
                        </rich:tab>

                        <rich:tab id="tabOption" label="Options">
                            <h:panelGrid id="panOptions" columns="4" style="width:100%;" columnClasses="clos30,clos30,clos20,clos20" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modType==1}">
                                <h:column><h:outputText value="Durée minimale:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modDureeMin}" style="text-align:right;width:100px;"/></h:column>
                                <h:column><h:outputText value="durée maximale:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modDureeMax}" style="text-align:right;width:100px;"/></h:column>
                                <h:column><h:outputText value="Accessoires:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAccessoire}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Acompte:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAcompte}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Plancher:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxAcompte}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAcompte==1}"/></h:column>
                                <h:column><h:outputText value="Amortissement:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAmortissement}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxAmortissement}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAmortissement==1}"/></h:column>
                                <h:column><h:outputText value="Frais financiers:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modFraisFinancier}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxFraisFinancier}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modFraisFinancier==1}"/></h:column>
                                <h:column><h:outputText value="Contrat entretien:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modContratEntretien}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxContratEntretien}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modContratEntretien==1}"/></h:column>
                                <h:column><h:outputText value="Assurances tous risques:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAssurance}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxAssurance}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modAssurance==1}"/></h:column>
                                <h:column><h:outputText value="Risques + franchises:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modFranchise}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxFranchise}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modFranchise==1}"/></h:column>
                                <h:column><h:outputText value="Frais structure:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modFraisStructure}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxFraisStructure}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modFraisStructure==1}"/></h:column>
                                <h:column><h:outputText value="Véhicule remplacement:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modRemplacement}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxRemplacement}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modRemplacement==1}"/></h:column>
                                <h:column><h:outputText value="Pondération taux remplissage:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modRemplissage}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxRemplissage}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modRemplissage==1}"/></h:column>
                                <h:column><h:outputText value="Marge:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modMarge}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxMarge}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modMarge==1}"/></h:column>
                                <h:column><h:outputText value="Valeur résiduelle:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modValeurResiduelle}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panOptions" />
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Taux:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modTauxValeurResiduelle}" style="text-align:right;width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modValeurResiduelle==1}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabAnn" label="Annexes">
                            <h:panelGrid  style="width:100%;" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Annexes:"/></h:column>
                                <h:inputTextarea id="idTexte2" rows="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modOption}" style="width:100%"/>
                                <h:column><h:outputText value="Condition règlement:"/></h:column>
                                <h:inputText id="idTexte3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.modelesCourriers.modConditionPaiement}" style="width:100%"/>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGroup>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.saveModeles}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.doublon}"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.doublon}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelDictionnaire"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.showModalPanelDictionnaire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.showModalPanelDictionnaire}" var="dic">
            <f:facet name="header"><h:outputText value="Sélection du champ de la table : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.var_nom_table}"/></f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDictionnaire" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.dataModelDictionnaire}" var="dic">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" id="idRowDictionnaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.selectionDictionnaire}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Nom" sortable="true" sortBy="#{dic.column_name}" width="30%">
                            <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                            <h:outputText value="#{dic.column_name}"/>
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
                        <a4j:commandButton id="idCanDictionnaire" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.annuleDictionnaire}" reRender="panelDictionnaire"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDictionnaire" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.calculeDictionnaire}" reRender="panelDictionnaire"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanDictionnaire')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValDictionnaire')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelModelesExemples"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="630" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.showModalPanelModelesExemples}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.showModalPanelModelesExemples}" var="ext">
            <f:facet name="header"><h:outputText value="Sélection des modèles de documents"/></f:facet>
            <a4j:form>
                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="panModExGlog">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableModelesExemples" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="500px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.dataModelModeleExemples}" var="modEx">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" id="idRowDictionnaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.selectionModelesExemples}" reRender="idTexteModele"/>
                            <rich:column label="Nom" sortable="false" width="100%">
                                <f:facet name="header"><h:outputText value="Nom modèle" /></f:facet>
                                <h:outputText value="#{modEx.column_name}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <rich:editor id="idTexteModele" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.var_texte_modele}" readonly="true">
                        <jsp:include flush="true" page="/css/tdt.jsp"/>
                        <f:param name="height" value="500"/>
                    </rich:editor>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanModelesExemples" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.annuleModelesExemples}" reRender="panelModelesExemples"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValModelesExemples" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesCourriersVentes.calculeModelesExemples}" reRender="panelModelesExemples,idTexte"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanModelesExemples')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValModelesExemples')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>

