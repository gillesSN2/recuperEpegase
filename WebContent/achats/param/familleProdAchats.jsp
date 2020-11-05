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

        <center><h2><h:outputText value="LISTE DES FAMILLES DE PRODUITS D'ACHATS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrdBton" columns="4" width="200px">
                <a4j:commandButton title="Ajouter une nouvelle famille" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.visibleAjt}" reRender="panelFamille"/>
                <a4j:commandButton title="Modifier la famille sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.visibleMod}" reRender="panelFamille"/>
                <a4j:commandButton title="Supprimer la famille sélectionnée" image="/images/supprimer.png" reRender="pangrdBton,table"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.removeCompte}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer la liste des familles" image="/images/print.png"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <h:panelGrid id="listFamille" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable border="0" id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.datamodel}"  var="famach">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.selectionFamille}" reRender="pangrdBton"/>
                        <rich:column sortable="false" width="10%">
                            <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                            <h:outputText value="#{famach.famachNature}" style="#{famach.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" sortBy="#{famach.famachCode}" width="10%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText value="#{famach.famachCode}" style="#{famach.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="25%" >
                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                            <h:outputText value="#{famach.famachLibelleFr}" style="#{famach.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Catégorie"/></f:facet>
                            <h:outputText value="#{famach.libCat}" style="#{famach.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="5%" >
                            <f:facet name="header"><h:outputText  value="Vte"/></f:facet>
                            <h:outputText value="VTE" style="#{famach.espaceFamille}" rendered="#{famach.famachLieeVte}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Marque"/></f:facet>
                            <h:outputText value="#{famach.famachMarque}" style="#{famach.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" >
                            <f:facet name="header"><h:outputText  value="Stock"/></f:facet>
                            <h:outputText value="#{famach.libStock}" style="#{famach.espaceFamille}"/>
                        </rich:column>
                        <rich:column sortable="false" width="5%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="%P.R.C."/></f:facet>
                            <h:outputText  value="#{famach.famachCoefValDefaut}" style="#{famach.espaceFamille}" rendered="#{famach.famachCoefValDefaut!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="5%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="%P.R.G"/></f:facet>
                            <h:outputText value="#{famach.famachCoefPrg}" style="#{famach.espaceFamille}" rendered="#{famach.famachCoefPrg!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="5%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Fictif"/></f:facet>
                            <h:outputText value="#{famach.famachCoefFictif}" style="#{famach.espaceFamille}" rendered="#{famach.famachCoefFictif!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="5%" id="idEtat" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <a4j:commandButton image="#{famach.etat}" rendered="#{famach.afficheImag}" onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.reactiverCompte}" style="text-align:center;" reRender="idEtat"/>
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



    <rich:modalPanel domElementAttachment="parent"  id="panelFamille" width="700" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.showModalPanel}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.showModalPanel}" var="fam">
            <f:facet name="header"><h:outputText value="GESTION DES FAMILLES DE PRODUITS D'ACHAT" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelFamille"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:tabPanel switchType="client" immediate="true" style="border:0px" id="panGlob" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.var_onglet}">

                    <rich:tab label="Général" name="general">
                        <h:panelGrid id="idOnglet1" columns="2" columnClasses="clos30,clos70" width="100%">
                            <h:column><h:outputText value="Nature:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.inpNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachNature!='0000'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachId!=0}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesnaturesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Code:"/></h:column>
                            <h:column>
                                <h:panelGroup id="panyas" >
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCode}" style="width:100px;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachId!=0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panGlob,panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.verifCode}"/>
                                    </h:inputText>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.existCod}" style="margin-left:20px;">
                                        <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                        <h:outputText value="Ce code est vide ou existe déja" style="color:red;size:100;"/>
                                    </h:panelGroup>
                                </h:panelGroup>&nbsp;&nbsp;
                                <h:outputText value="Liaison famille vente:"/>&nbsp;
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachLieeVte}"/>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachLibelleFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                            <h:column><h:outputText value="Catégorie:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCat}">
                                    <f:selectItem itemLabel="Standard" itemValue="0"/>
                                    <f:selectItem itemLabel="Production" itemValue="1"/>
                                    <f:selectItem itemLabel="Consommables" itemValue="2"/>
                                    <f:selectItem itemLabel="Services" itemValue="3"/>
                                    <f:selectItem itemLabel="Immobilisation" itemValue="4"/>
                                    <f:selectItem itemLabel="Famille Utilisable" itemValue="90"/>
                                    <f:selectItem itemLabel="Famille Titre" itemValue="99"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panGlob"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value="Stock:"/>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachStock}">
                                <f:selectItem itemLabel="Sans stock" itemValue="0"/>
                                <f:selectItem itemLabel="Stock simple" itemValue="1"/>
                                <f:selectItem itemLabel="LIFO (lot)" itemValue="2"/>
                                <f:selectItem itemLabel="FIFO (lot)" itemValue="3"/>
                                <f:selectItem itemLabel="Péremption (lot)" itemValue="4"/>
                                <f:selectItem itemLabel="Sérialisé" itemValue="5"/>
                                <f:selectItem itemLabel="Consigne" itemValue="6" itemDisabled="true"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Dépot achat:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachDepotAch}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesDepotsAchats}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépot production:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachDepotPrd}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesDepotsProduction}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachService}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Marques:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachMarque}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesMarquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="%P.R.C.(valorisation défaut):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCoefValDefaut}" size="10" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="% P.R.G.:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCoefPrg}" size="10" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="% Fictif.:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCoefFictif}" size="10" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.var_aff_maj}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.var_maj_prod}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.var_aff_maj}">
                                <h:outputText value="Mise à jour des produits:"/>
                                <br>
                                <h:outputText value="(Cette mise à jour va réinitialiser les informations des produits liées aux familles)"/>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Conditionnements" name="conditionnements" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCat!='99'}">
                        <h:panelGrid columns="2" id="four" columnClasses="clos30,clos70" width="100%">
                            <h:column><h:outputText value="Unité de stockage:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachUnite}" style="width:100%;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesUnitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement1:"/></h:column>
                            <h:column id="cdt1">
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCondition1}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.verifFouConditionnement1}" reRender="cdt1,four"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement2:"/></h:column>
                            <h:column id="cdt2">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCondition2}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.verifFouConditionnement2}" reRender="cdt2,four"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement3:"/></h:column>
                            <h:column id="cdt3">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCondition3}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.verifFouConditionnement3}" reRender="cdt3,four"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement4:"/></h:column>
                            <h:column id="cdt4">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCondition4}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.verifFouConditionnement4}" reRender="cdt4,four"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement5:"/></h:column>
                            <h:column id="cdt5">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCondition5}" style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.verifFouConditionnement5}" reRender="cdt5,four"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Comptes" name="compte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCat!='99'}">
                        <h:panelGrid columns="2" columnClasses="clos30,clos70" width="100%">
                            <h:column><h:outputText value="Code TVA:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachTaxe}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesTaxesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value="Position tarifaire:"  style="text-decoration:underline;"/>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachDouane}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesDouanesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte achat local:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCompteLocal}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesAchLocalItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte achat zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCompteZone}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesAchZoneItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte achat hors zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCompteExterieur}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesAchHorsZoneItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte achat variation" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCompteCharge}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesAchProduitItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Cpte achat stock:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCompteStock}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesAchStockItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.optionAchats.trfCompta=='1'}"><h:outputText value="Cpte achat en cours:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.optionAchats.trfCompta=='1'}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCompteEncours}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesAchStockItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Analytiques" name="analytique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCat!='99'}">
                        <h:panelGrid columns="2" columnClasses="clos30,clos70" width="100%">
                            <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCle1}" >
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCle2}" >
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.optionAchats.axeParc=='1'}"><h:outputText value="Parc:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.optionAchats.axeParc=='1'}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachAnal2}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesParcsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.optionAchats.axeDossier=='1'}"><h:outputText value="Dossier:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.optionAchats.axeDossier=='1'}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachAnal4}">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesDossiersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachActivite}" style="width:100%">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                            <h:column><h:outputText value="Budget:" style="text-decoration:underline;" rendered="false"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachBudget}" rendered="false">
                                    <f:selectItem itemLabel=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesBudgetsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Liste Produits" name="liste" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.famillesProduitsAchats.famachCat!='99'}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.listeProduit}" reRender="panProduit,idOnglet1"/>
                        <h:panelGrid id="panProduit" width="100%">
                            <a4j:region renderRegionOnly="false" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.chgFamille}">
                                <rich:extendedDataTable border="0" id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.lesProduits}"  var="prod">
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
                            <a4j:region renderRegionOnly="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.chgFamille}">
                                <rich:extendedDataTable border="0" id="tableChg" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.lesProduits}"  var="prod">
                                    <rich:column sortable="true" sortBy="#{prod.var_select}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{prod.var_select}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{prod.proCode}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{prod.proCode}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{prod.proLibClient}" width="70%">
                                        <f:facet name="header"><h:outputText  value="Libellé commercial" /></f:facet>
                                        <h:outputText value="#{prod.proLibClient}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <br>
                        <h:commandButton value="Mise à jour mouvements" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.recalculMvts}" onclick="javascript:Richfaces.showModalPanel('modAttente');"></h:commandButton>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:commandButton value="Changement de famille" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.chgFamille}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.chgFamille}"></h:commandButton>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.newFamille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.chgFamille}">
                            <f:selectItem itemLabel="Sélectionnez nouvelle famille" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.mesFamillesAchats}"/>
                        </h:selectOneMenu>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:commandButton value="Appliquer Changement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.valideFamille}" onclick="if (!confirm('Etes-vous sur de vouloir effectuer ce famille?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.chgFamille}"></h:commandButton>
                    </rich:tab>

                </rich:tabPanel>
                <center>
                    <br><br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleProdAchats.saveFamilles}" reRender="panelFamille,listFamille,table,pangrdBton"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
