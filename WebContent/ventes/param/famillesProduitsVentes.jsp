<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="famvte">

    <a4j:form>

        <center><h2><h:outputText value="LISTE DES FAMILLES DES PRODUITS DE VENTES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrdBton" columns="4" width="200px">
                <a4j:commandButton title="Ajouter une nouvelle famille" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.visibleAjt}" reRender="panelFamille"/>
                <a4j:commandButton title="Modifier la famille sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.visibleMod}" reRender="panelFamille"/>
                <a4j:commandButton title="Supprimer la famille sélectionnée" image="/images/supprimer.png" reRender="table,pangrdBton"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.removeCompte}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer la liste des familles" image="/images/print.png"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <h:panelGrid id="listFamille" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable border="0" id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.datamodel}"  var="famvte">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.selectionFamille}" reRender="pangrdBton"/>
                        <rich:column sortable="false" width="15%">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{famvte.famvteNature}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{famvte.famvteCode}" width="10%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{famvte.famvteCode}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="30%" >
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText  value="#{famvte.famvteLibelleFr}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                            <h:outputText  value="#{famvte.libCat}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Clé1" /></f:facet>
                            <h:outputText  value="#{famvte.famvteCle1}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Cle2" /></f:facet>
                            <h:outputText  value="#{famvte.famvteCle2}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText  value="#{famvte.famvteActivite}" style="#{famvte.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="5%" id="idEtat" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                            <a4j:commandButton image="#{famvte.etat}" rendered="#{famvte.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.reactiverCompte}" style="text-align:center;" reRender="idEtat"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelFamille" width="700" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.showModalPanel}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.showModalPanel}" var="fam" >
            <f:facet name="header"><h:outputText value="GESTION DES FAMILLES DE PRODUITS DE VENTES" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelFamille"/>
                </a4j:form>
            </f:facet>
            <a4j:form>

                <rich:tabPanel switchType="client" immediate="true"  style="border:0px" id="panGlob" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.var_onglet}">
                    <rich:tab label="Général" name="general">
                        <h:panelGrid id="idOnglet1" columns="2" columnClasses="clos30,clos70" width="100%">
                            <h:column><h:outputText value="Nature:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.inpNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteNature!='0000'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteId!=0}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesnaturesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>  <h:outputText value="Code:"/></h:column>
                            <h:column>
                                <h:panelGroup id="panyas" >
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCode}" onkeypress="return scanToucheLettre(event)" style="width:100px;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteId!=0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panGlob,panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.verifCode}"/>
                                    </h:inputText>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.existCod}" style="margin-left:20px;">
                                        <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                        <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;size:100;"/>
                                    </h:panelGroup>
                                </h:panelGroup>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteLibelleFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                            <h:column><h:outputText value="Catégorie:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCat}">
                                    <f:selectItem itemLabel="Standard" itemValue="0"/>
                                    <f:selectItem itemLabel="Consommables" itemValue="2"/>
                                    <f:selectItem itemLabel="Services" itemValue="3"/>
                                    <f:selectItem itemLabel="Famille Utilisable" itemValue="90"/>
                                    <f:selectItem itemLabel="Famille Titre" itemValue="99"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panGlob"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépot vente:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteDepotVte}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesDepotsVentes}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteService}"  style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Marques:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteMarque}"  style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesMarquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Coef. Plancher:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCoefPv}" style="text-align:right;width:100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.var_aff_maj}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.var_maj_prod}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.var_aff_maj}">
                                <h:outputText value="Mise à jour des produits:"/>
                                <br>
                                <h:outputText value="(Cette mise à jour va réinitialiser les informations des produits liées aux familles)"/>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Comptes" name="comptes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCat!='99'}">
                        <h:panelGrid columns="2" id="panComteAjt" columnClasses="clos30,clos70">
                            <h:column><h:outputText value="Code TVA:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteTaxe}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesTaxesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Position tarifaire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteDouane}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesDouanesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte vente local taxable:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteLocal}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteLocalItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte vente local non taxable:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteNonTaxable}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteLocalItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte vente zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteZone}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteZoneItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte vente hors zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteExterieur}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteHorsZoneItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte vente stock:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteStock}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteStockItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte vente produit:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteProduit}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteProduitItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='4'}"><h:outputText value="Cpte vente caisse:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='4'}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCompteCaisse}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesVteCaissesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Analytiques" name="analytiques" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCat!='99'}">
                        <h:panelGrid columns="2" id="panAddAnalytique" columnClasses="clos30,clos70" width="100%">
                            <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCle1}" >
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCle2}" >
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.optionVentes.axeParc=='1'}"><h:outputText value="Parc:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.optionVentes.axeParc=='1'}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteAnal2}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesParcsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.optionVentes.axeDossier=='1'}"><h:outputText value="Dossier:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.optionVentes.axeDossier=='1'}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteAnal4}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesDossiersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteActivite}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                            <h:column><h:outputText value="Budget:" style="text-decoration:underline;" rendered="false"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteBudget}" rendered="false">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.mesBudgetsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Liste Produits" name="liste" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.famillesProduitsVentes.famvteCat!='99'}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.listeProduit}" reRender="panProduit,idOnglet1"/>
                        <h:panelGrid id="panProduit" width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable border="0" id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.lesProduits}" var="prod">
                                    <rich:column sortable="true" sortBy="#{prod.proCode}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{prod.proCode}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{prod.proLibClient}" width="40%">
                                        <f:facet name="header"><h:outputText  value="Libellé commercial" /></f:facet>
                                        <h:outputText value="#{prod.proLibClient}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{prod.proLibTech}" width="40%" >
                                        <f:facet name="header"><h:outputText  value="Libellé technique" /></f:facet>
                                        <h:outputText  value="#{prod.proLibTech}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <br>
                        <h:commandButton value="Mise à jour mouvements" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.recalculMvts}" onclick="javascript:Richfaces.showModalPanel('modAttente');"></h:commandButton>
                    </rich:tab>
                </rich:tabPanel>

                <center>
                    <br><br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamillesProduitsVentes.saveFamilles}" reRender="panelFamille,listFamille,table,pangrdBton"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
