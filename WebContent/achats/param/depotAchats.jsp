<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">

    <a4j:form id="form">

        <center><h2><h:outputText value="LISTE DES DEPOTS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="4" width="200px">
                <a4j:commandButton title="Ajouter un nouveau dépôt" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.chargerPanAdd}" reRender="panelAdd"/>
                <a4j:commandButton title="Modfier le dépôt sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.afficheButtModif}" reRender="panelModif"/>
                <a4j:commandButton title="Supprimer le dépôt sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.afficheButtSupp}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.deletedepot}" reRender="panelBouton,myTableau"/>
                <a4j:commandButton title="Imprimer la liste des dépôts" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
            </h:panelGrid>
            <br>
            <h:panelGrid id="tableau" border="0" width="100%" style="text-align:center;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="myTableau" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.madatamodel}" var="depot">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.selectionDepot}" reRender="panelBouton,panelModif,richmodif1"/>
                        <f:facet name="header">
                        </f:facet>
                        <rich:column style="text-align:center;"sortable="true"  width="10%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText style="size:5px;"value="#{depot.dpoCode}" id="cod"/>
                        </rich:column>
                        <rich:column style="text-align:left;" width="15%">
                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                            <h:outputText value="#{depot.dpoLibelle}" id="lib"/>
                        </rich:column>
                        <rich:column style="text-align:left;" width="5%">
                            <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                            <h:outputText value="#{depot.dpoService}" id="ser"/>
                        </rich:column>
                        <rich:column style="text-align:left;" width="5%">
                            <f:facet name="header"><h:outputText  value="Type"/></f:facet>
                            <h:outputText value="#{depot.typLib}" id="typ"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Rec."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.reception}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Ret."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.retourAch}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Liv."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.livraison}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Ret."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.retourVent}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Cha."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.mobileVent}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Inv."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.inventaire}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="BIn"/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.bonEntree}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="BOut"/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.bonSortie}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Ces."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.cession}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Prd."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.fabrication}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Rea."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.reachmin}" disabled="true"/>
                        </rich:column>
                        <rich:column style="text-align:center;" width="5%">
                            <f:facet name="header"><h:outputText value="Car."/></f:facet>
                            <h:selectBooleanCheckbox value="#{depot.carburant}" disabled="true"/>
                        </rich:column>
                        <rich:column  style="text-align:center;" sortable="true" sortBy="#{depot.dpoInactif}" >
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:commandButton image="#{depot.etat}" rendered="#{depot.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.reactiverCompte}" title="Supprimer" style="text-align:right;">
                                <a4j:support eventsQueue="maQueue" reRender="myTableau" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
            <br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelAdd" width="525" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.showPanAdd}">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="AJOUT D'UN DEPOT"></h:outputText></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAdd,panelBouton"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column>
                    <h:panelGroup id="panyas" >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoCode}"style="width:70px"  maxlength="10">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.verifCode}"/>
                        </h:inputText>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.existCod}" style="margin-left:20px;">
                            <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;size:100;" />
                        </h:panelGroup>
                    </h:panelGroup>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoLibelle}" style="width:400px" maxlength="100"/></h:column>
                <h:column><h:outputText value="Type"/></h:column>
                <h:column>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoType}" layout="pageDirection" style="width:400px" >
                        <f:selectItem itemLabel="Standard fixe" itemValue="0"/>
                        <f:selectItem itemLabel="Fictif" itemValue="2"/>
                        <f:selectItem itemLabel="Déchet" itemValue="3"/>
                    </h:selectOneRadio>
                </h:column>
                <h:column><h:outputText value="Qte minimale:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoQteMin}" style="text-align:right;"/></h:column>
                <h:column><h:outputText value="Qte maximale:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoQteMax}" style="text-align:right;"/></h:column>
                <h:column><h:outputText value="Adresse:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoAdresse}" style="width:400px" maxlength="100"/></h:column>
                <h:column><h:outputText value="Responsable:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoResponsable}" style="width:400px" maxlength="100"/></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup  id="buttGrp">
                    <br>
                    <a4j:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.saveDepot}" reRender="tableau,panelAdd"/>
                </h:panelGroup>
            </center>
            <br/>
        </a4j:form>

    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  id="panelModif" width="550" height="600"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.showPanModif}">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="MODIFICATION D'UN DEPOT"></h:outputText></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelModif,panelBouton"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;" id="richmodif1">
                <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

                    <rich:tab label="Général">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Code:"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoCode}"/></h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoLibelle}" style="width:400px"/></h:column>
                            <h:column><h:outputText value="Type:"/></h:column>
                            <h:column>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoType}" layout="pageDirection">
                                    <f:selectItem itemLabel="Standard fixe" itemValue="0"/>
                                    <f:selectItem itemLabel="Fictif" itemValue="2"/>
                                    <f:selectItem itemLabel="Déchet" itemValue="3"/>
                                </h:selectOneRadio>
                            </h:column>
                            <h:column><h:outputText value="Qte minimale:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoQteMin}" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Qte maximale:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoQteMax}" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Inactif:"/></h:column>
                            <h:column>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.indpoInactif}"/>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Propriétés">
                        <h:panelGrid  width="100%">
                            <f:facet name="header"><h:outputText  value="Achats" /></f:facet>
                            <h:panelGrid columns="2" width="100%" columnClasses="clos35,clos65g" style="border:solid 0px black">
                                <h:outputText value="(13) Réceptions:"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoReception}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(14) Retours:"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoRetourAch}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText rendered="false" value="Collectes:"/>
                                <h:selectOneRadio rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoCollecteAch}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <f:facet name="header"><h:outputText  value="Ventes" /></f:facet>
                            <h:panelGrid columns="2" width="100%" columnClasses="clos35,clos65g" style="border:solid 0px black">
                                <h:outputText value="(23) Livraisons + tickets:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoLivraison}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(24) Retours:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoRetourVent}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(28) Chargements:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoMobileVent}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(73) Pharmacie:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoPharmacie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <f:facet name="header"><h:outputText  value="Stocks" /></f:facet>
                            <h:panelGrid columns="2" width="100%" columnClasses="clos35,clos65g" style="border:solid 0px black">
                                <h:outputText value="(30) Inventaires:"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoInventaire}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(31) Bons d'entrée:"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoBonEntree}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(32) Bons de sortie:"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoBonSortie}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(33) Cessions:"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoCession}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(34) Productions:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoFabrication}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(35) Réacheminements:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoReachmin}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleMedical}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:outputText value="(45) Carburant/Lubrifiant/Pneu:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleParc}"/>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.depotAchats.dpoCarburant}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.moduleParc}">
                                    <f:selectItem itemLabel="Inactif" itemValue="0"/>
                                    <f:selectItem itemLabel="Actif" itemValue="1"/>
                                </h:selectOneRadio>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Service">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="myService" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="350px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.dataModelServices}" var="serv">
                                <rich:column style="text-align:center;"sortable="true"  width="10%">
                                    <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                    <h:selectBooleanCheckbox style="size:5px;"value="#{serv.select}"/>
                                </rich:column>
                                <rich:column style="text-align:center;"sortable="true"  width="30%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText style="size:5px;"value="#{serv.serCode}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="70%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{serv.serNomFr}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
            </h:panelGroup>
            <center>
                <br>
                <h:panelGroup>
                    <a4j:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDepotAchats.saveDepot}" reRender="tableau,panelModif"/>
                </h:panelGroup>
            </center>
        </a4j:form>

    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
