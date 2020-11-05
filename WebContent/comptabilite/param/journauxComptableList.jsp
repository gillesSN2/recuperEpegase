<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="jc">

    <a4j:form >

        <center>
            <h2>
                <h:outputText value="LISTE DES JOURNAUX COMPTABLES #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine==0}" style="color:green;font-size:16px;"/>
                <h:outputText value="LISTE DES JOURNAUX COMPTABLES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine!=0}" style="color:green;font-size:16px;"/>&nbsp;&nbsp;
                <h:commandButton title="Permutter la fiscalité des journaux comptables" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.chargerMesracines}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
            </h2>
        </center>

        <center>
            <h:panelGroup id="panGlobal">
                <h:panelGroup id="panelBouton">
                    <a4j:commandButton id="idAddDefault" value="Ajout par Défaut" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;" onclick="if (!confirm('Voulez-vous charger les journaux comptables par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,panelBouton,pan11,table"/>
                    <br>
                    <a4j:commandButton reRender="panel" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.addJournal}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheButtAjout}"  image="/images/ajouter.png"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton  id="boutonModif" reRender="panel" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.modifJournal}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheButtModif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheButtAjout)==true}" image="/images/modifier.png" />&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="boutonSupp" image="/images/supprimer.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheButtSupp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheButtAjout)==true}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.removeSelectedJC}" reRender="table" />&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton image="/images/print.png" onclick="javascript:Richfaces.showModalPanel('panelImp');"/>
                </h:panelGroup>
                <h:panelGrid id="pan11" style="max-height:100%;border:1px;" columns="1">
                    <h:panelGroup id="panexo">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.annee}" id="annee" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.lesAnneesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pan11,table,panelBouton,idAddDefault"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.selectionChargement}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                </h:panelGrid>
                <br>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="table" border="0" headerClass="headerTab" footerClass="bard" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.datamodel}" var="journaux">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.selectionLigne}" reRender="panelBouton"/>
                        <rich:column  width="10%" sortable="true" sortBy="#{journaux.pljCode}">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText style="size:5px;"value="#{journaux.pljCode}"/>
                        </rich:column>
                        <rich:column  width="30%" sortable="true" sortBy="#{journaux.pljLibelleFr}">
                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                            <h:outputText  value="#{journaux.pljLibelleFr}"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{journaux.libNature}" >
                            <f:facet name="header"><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{journaux.libNature}"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{journaux.pljCompteTreso}">
                            <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
                            <h:outputText value="#{journaux.pljCompteTreso}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine!=2}"/>
                            <h:outputText value="#{journaux.pljCompteTresoNew}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine==2}"/>
                        </rich:column>
                        <rich:column  width="15%" sortable="true" sortBy="#{journaux.libPiece}">
                            <f:facet name="header"><h:outputText  value="Pièce"/></f:facet>
                            <h:outputText value="#{journaux.libPiece}"/>
                        </rich:column>
                        <rich:column  width="15%" sortable="true" sortBy="#{journaux.libelleProjet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.projetActif}">
                            <f:facet name="header"><h:outputText  value="Projet"/></f:facet>
                            <h:outputText value="#{journaux.libelleProjet}"/>
                        </rich:column>
                        <rich:column width="5%" sortable="true" sortBy="#{journaux.pljChoixDevise}" >
                            <f:facet name="header"><h:outputText   value="Devise" /></f:facet>
                            <h:outputText style="size:5px;" value="#{journaux.pljChoixDevise}"/>
                        </rich:column >
                        <rich:column width="5%" sortable="true" sortBy="#{journaux.inactif}" style="text-align:center">
                            <f:facet name="header"><h:outputText  value="Inactif" /></f:facet>
                            <h:commandButton disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.disable}" image="#{journaux.etat}" rendered="#{journaux.inactif}"  onclick="if (!confirm('Voulez-vous réactiver ce journal ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.reactiverCompte}" title="Supprimer" style="text-align:center;">
                                <a4j:support eventsQueue="maQueue" reRender="table" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGroup>
            <br>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <!-- debut Modal panel pour ajout et modif -->
    <rich:modalPanel domElementAttachment="parent"   id="panel" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.modalPAjout}"  headerClass="headerPanel" width="650" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.modalPAjout}" var="plj">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.enteteModal}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.fermerModalPanelAjout}" styleClass="hidelink" id="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:tabPanel switchType="client" immediate="true"  style="width:100%;border:0px;" id="panGlob">

                    <rich:tab label="Identification">
                        <h:panelGrid columns="2" cellspacing="5" width="100%" columnClasses="clos30,clos70" id="panGrid">
                            <h:column><h:outputText value="Code:" /></h:column>
                            <h:column>
                                <h:inputText size="10" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCode}"  maxlength="6" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.estModalModif}">
                                    <a4j:support eventsQueue="maQueue"  event="onchange"  reRender="panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.verifierUniciterdecode}"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljLibelleFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                            <h:column><h:outputText value="Nature:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljNature}"  >
                                    <f:selectItem itemLabel="Général" itemValue="0"/>
                                    <f:selectItem itemLabel="Achats" itemValue="1"/>
                                    <f:selectItem itemLabel="Ventes" itemValue="2"/>
                                    <f:selectItem itemLabel="Paye" itemValue="3"/>
                                    <f:selectItem itemLabel="Loyer" itemValue="4"/>
                                    <f:selectItem itemLabel="Amortissements" itemValue="5"/>
                                    <f:selectItem itemLabel="Amortissements(virement de poste à poste)" itemValue="6"/>
                                    <f:selectItem itemLabel="Banque avec centralisation Automatique" itemValue="7"/>
                                    <f:selectItem itemLabel="Banque sans centralisation Automatique" itemValue="8"/>
                                    <f:selectItem itemLabel="Caisse avec centralisation Automatique" itemValue="9"/>
                                    <f:selectItem itemLabel="Caisse sans centralisation Automatique" itemValue="10"/>
                                    <f:selectItem itemLabel="Situation" itemValue="11"/>
                                    <f:selectItem itemLabel="Balance" itemValue="13"/>
                                    <f:selectItem itemLabel="Clôture" itemValue="14"/>
                                    <f:selectItem itemLabel="A nouveaux" itemValue="15"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.chargerLesComptesTreso}" reRender="panGlob,panGrid,inp1,idPanBanque"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheReserve}"><h:outputText value="Réservé:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheReserve}">
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljReserve}"  >
                                    <f:selectItem itemLabel="Public" itemValue="0"/>
                                    <f:selectItem itemLabel="Privé" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Imputation Analytique:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljAnalytique}"  >
                                    <f:selectItem itemLabel="Avec imputation analytique" itemValue="0"/>
                                    <f:selectItem itemLabel="Sans imputation analytique" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.testCompteTreso}"><h:outputText value="Compte trésorerie:" style="text-decoration:underline;" id="out1" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.testCompteTreso}">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine!=2}" var="oldFis">
                                    <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCompteTreso}" id="inp1">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.lesComptesTresoItem}"/>
                                    </h:selectOneMenu>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.choixRacine==2}" var="newFis">
                                    <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCompteTresoNew}" id="inp2">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.lesComptesTresoItem}"/>
                                    </h:selectOneMenu>
                                </c:if>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.testCompteTreso}"><h:outputText value="Mode:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.testCompteTreso}">
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljModeTreso}">
                                    <f:selectItem itemLabel="Mixte" itemValue="0"/>
                                    <f:selectItem itemLabel="Les Dépenses" itemValue="1"/>
                                    <f:selectItem itemLabel="Les Recettes" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mode Pièce:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljPiece}" >
                                    <f:selectItem itemLabel="Pièce manuelle" itemValue="0"/>
                                    <f:selectItem itemLabel="Automatique à chaque ligne" itemValue="1"/>
                                    <f:selectItem itemLabel="Automatique sur solde nul" itemValue="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="pgp2,out2,sel2,outp2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="false"><h:outputText value="Scénario:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="false">
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljScenario}">
                                    <f:selectItem itemLabel="Sans modèle" itemValue="0"/>
                                    <f:selectItem itemLabel="Modèle 1" itemValue="1"/>
                                    <f:selectItem itemLabel="Modèle 2" itemValue="2"/>
                                    <f:selectItem itemLabel="Modèle 3" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Devise:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljTypeDevise}">
                                    <f:selectItem itemLabel="Devise du pays" itemValue="0"/>
                                    <f:selectItem itemLabel="Devise choisie fixe" itemValue="1"/>
                                    <f:selectItem itemLabel="Devise choisie variable" itemValue="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.chargerDevise}" reRender="panGrid"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Devise choisie:"  style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheChoiDev}"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.libreChoiDev}"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljChoixDevise}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.afficheChoiDev}">
                                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.mesdevisesItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Budget:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljBudjet}" >
                                    <f:selectItem itemLabel="Sans" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec budget libre" itemValue="1"/>
                                    <f:selectItem itemLabel="Avec budget filtré" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.projetActif}"><h:outputText value="Projet:" style="text-decoration:underline;" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.projetActif}">
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljProjet}" >
                                    <f:selectItem itemLabel="Sans" itemValue=""/>
                                    <f:selectItem itemLabel="Tous Budgets" itemValue="99999"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.lesProjetsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mode saisie:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljSasieInterdite}" >
                                    <f:selectItem itemLabel="Configuration Par défaut" itemValue="0"/>
                                    <f:selectItem itemLabel="Sasie interdite" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inactif:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.inpInactifAj}"/></h:column>
                        </h:panelGrid>

                        <h:panelGroup id="panyas">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.existCod}">
                                <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;" />
                            </h:panelGroup>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="Option Banque" id="idPanBanque" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.testPljDv}">
                        <h:panelGrid columns="2" cellspacing="5" width="100%" columnClasses="clos30,clos70" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Définition Compte"/></f:facet>
                            <h:column><h:outputText value="Code Banque:"/></h:column>
                            <h:column><h:inputText maxlength="5"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCodeBanque}"/></h:column>
                            <h:column><h:outputText value="Code Guichet:"/></h:column>
                            <h:column><h:inputText maxlength="5"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCodeGuichet}"/></h:column>
                            <h:column><h:outputText value="Numero de compte:"/></h:column>
                            <h:column><h:inputText maxlength="12"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljNumeroCompte}"/></h:column>
                            <h:column><h:outputText value="Clé Rib:"/></h:column>
                            <h:column><h:inputText maxlength="5"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCleRib}"/></h:column>
                            <h:column><h:outputText value="IBAN:"/></h:column>
                            <h:column><h:inputText maxlength="30"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljIban}"/></h:column>
                            <h:column><h:outputText value="SWIFT:"/></h:column>
                            <h:column><h:inputText maxlength="20"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljSwift}"/></h:column>
                        </h:panelGrid>
                        <br/>
                        <h:panelGrid columns="2" cellspacing="5" width="100%" columnClasses="clos30,clos70" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Gestionnaire"/></f:facet>
                            <h:column><h:outputText value="Civilite:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljCiviliteGestionnaire}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.mesCivilitesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Nom:"/></h:column>
                            <h:column><h:inputText maxlength="100"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljNomGestionnaire}"/></h:column>
                            <h:column><h:outputText value="Prénom:"/></h:column>
                            <h:column><h:inputText maxlength="50"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljPrenomGestionnaire}"/></h:column>
                            <h:column><h:outputText value="Téléphone:"/></h:column>
                            <h:column><h:inputText maxlength="20"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljTelephoneGestionnaire}"/></h:column>
                            <h:column><h:outputText value="Mail:"/></h:column>
                            <h:column><h:inputText maxlength="50"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljMailGestionnaire}"/></h:column>
                        </h:panelGrid>
                        <br/>
                        <h:panelGrid columns="2" cellspacing="5" width="100%" columnClasses="clos30,clos70" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Jours de valeur"/></f:facet>
                            <h:column><h:outputText value="Date de valeur:"/></h:column>
                            <h:column><h:outputText value="(exprimée en nombre de jour(s))" /></h:column>
                            <h:column><h:outputText value="Même banque sur place:" /></h:column>
                            <h:column><h:inputText maxlength="2"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljDvMbsp}"/></h:column>
                            <h:column><h:outputText value="Même banque hors place:" /></h:column>
                            <h:column><h:inputText maxlength="2"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljDvMbhp}"/></h:column>
                            <h:column><h:outputText value="Autre banque sur place:" /></h:column>
                            <h:column><h:inputText maxlength="2"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljDvAbsp}"/></h:column>
                            <h:column><h:outputText value="Autre banque hors place:" /></h:column>
                            <h:column><h:inputText maxlength="2"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.journauxComptables.pljDvAbhp}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <br/><br/>
                <h:panelGrid  width="100%" style="border:1px solid green">
                    <h:outputText value="Pièce manuelle : La saisie des pièces est libre" />
                    <h:outputText value="Automatique à chaque ligne : Les numéros de pièce changent à chaque ligne" />
                    <h:outputText value="Automatique sur solde nul : Les numéros de pièce changent lorsque la pièce est équilibrée" />
                    <h:outputText value="Les pièces sont des chronos qui sont définis dans le paramêtrage du module comptable. Si le chrono n'est pas défini, alors les pièces sont manuelles quelque soit l'option choisie." />
                </h:panelGrid>
                <br/><br/>
                <h:panelGrid  width="100%" style="border:1px solid green" rendered="false">
                    <h:outputText value="Pas de scénario : chaque ligne est autonome" />
                    <h:outputText value="Scénario modèle 1 : Les références et le libellé sont mémorisés pour l'ensemble d'une pièce" />
                    <h:outputText value="Scénario modèle 2 : Les références et le libellé sont mémorisés pour l'ensemble d'une pièce + les calculs sont automatisés (Calcul TVA, Montant restant..." />
                    <h:outputText value="Scénario modèle 3 : La 2eme ligne d'une pièce est précalculée avec les élements de la 1ere ligne"/>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup id="buttGrp">
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.valider}" id="linkcom" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJournauxComptables.existCod}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
            <br/>
        </c:if>
    </rich:modalPanel>
    <!-- Fin Modal panel pour ajout et modif  -->


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
