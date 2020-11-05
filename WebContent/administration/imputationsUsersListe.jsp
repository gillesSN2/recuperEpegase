<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="vutilimput">

    <a4j:form id="impututilisateur">

        <center> <h2><h:outputText value="IMPUTATION DES UTILISATEURS" style="color:green;"/></h2></center>

        <br>
        <center>
            <h:panelGrid columns="2" columnClasses="clos35,clos65g" width="100%">
                <h:column>
                    <center>
                        <h:panelGroup id="panelBouton1" style="height:50px">
                            <a4j:commandButton image="/images/detail.png" title="Voir propriété du groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifierGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.afficheGroupe}" reRender="panelGroupe,tableGroupe" />
                        </h:panelGroup>
                    </center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableGroupe" styleClass="bg" style="max-height:100%;border:1px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelGroupes}"  var="groupe">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionImputationGroupe}" reRender="pngBouton1,pngBouton2,tableuser"/>
                            <rich:column sortable="true" sortBy="#{groupe.grpCode}" sortOrder="ASCENDING">
                                <f:facet name="header"> <h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{groupe.grpCode}"/>
                            </rich:column >
                            <rich:column width="30%" sortable="true" sortBy="#{groupe.grpLibelle}">
                                <f:facet name="header"> <h:outputText value="Nom des Groupes"/></f:facet>
                                <h:outputText value="#{groupe.grpLibelle}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:column>
                <h:column>
                    <center>
                        <h:panelGroup id="panelBouton2" style="height:50px">
                            <a4j:commandButton title="Modifier l'utilisateur sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.changerGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_visibleBouton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        </h:panelGroup>
                    </center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableuser" styleClass="bg" style="max-height:100%;border:1px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUser}"  var="utilisateur">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionImputationUser}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton1,panelBouton2"/>
                            <rich:column label="Administrateur" width="7%" sortable="true" sortBy="#{utilisateur.usrSysteme}" style="text-align:center;">
                                <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
                                <h:graphicImage value="/images/co-chef.png" rendered="#{utilisateur.usrSysteme==1}" title="Co-administrateur"/>
                                <h:graphicImage value="/images/chef.png" rendered="#{utilisateur.usrSysteme==2}" title="Administrateur"/>
                                <h:graphicImage value="/images/configuration.png" rendered="#{utilisateur.usrSysteme==3}"/>
                                <h:graphicImage value="/images/tiers.png" height="15px" width="15px" rendered="#{utilisateur.usrIdSalarieGuest!=0}" title="Connexion Users/Salariés"/>
                                <h:graphicImage value="/images/dollar.png" height="15px" width="15px" rendered="#{utilisateur.usrCaissier!=0&&utilisateur.groupe.grpModuleCai==1}" title="Accès caisse complète"/>
                                <h:graphicImage value="/images/panier.png" height="15px" width="15px" rendered="#{utilisateur.usrCaissier!=0&&utilisateur.groupe.grpModuleCai==2}" title="Accès bon de sortie"/>
                            </rich:column>
                            <rich:column label="Etat" width="5%" sortable="true" sortBy="#{utilisateur.usrEtat}" style="text-align:center;">
                                <f:facet name="header"> <h:outputText value="Etat"/></f:facet>
                                <h:graphicImage value="/images/desactiver.png" rendered="#{utilisateur.usrEtat==0}"/>
                            </rich:column>
                            <rich:column label="Nom" width="30%" sortBy="#{utilisateur.usrNom}" sortable="true" sortOrder="ASCENDING">
                                <f:facet name="header"> <h:outputText value="Nom et prénom"/></f:facet>
                                <h:outputText value="#{utilisateur.usrNom}  #{utilisateur.usrPrenom}"/>
                            </rich:column>
                            <rich:column label="Service" width="10%" sortBy="#{utilisateur.usrService}" sortable="true">
                                <f:facet name="header"> <h:outputText value="Service"/></f:facet>
                                <h:outputText value="#{utilisateur.usrService}"/>
                            </rich:column>
                            <rich:column label="Fonction" width="10%" sortBy="#{utilisateur.var_fonction}" sortable="true">
                                <f:facet name="header"> <h:outputText value="Fonction"/></f:facet>
                                <h:outputText value="#{utilisateur.var_fonction}"/>
                            </rich:column>
                            <rich:column label="Options" width="10%" sortBy="#{utilisateur.var_options}" sortable="true">
                                <f:facet name="header"> <h:outputText value="Options"/></f:facet>
                                <h:outputText value="#{utilisateur.var_options}"/>
                            </rich:column>
                            <rich:column label="Equipe" width="10%" sortBy="#{utilisateur.usrNomEquipe}" sortable="true">
                                <f:facet name="header"> <h:outputText value="Equipe"/></f:facet>
                                <h:outputText value="#{utilisateur.usrNomEquipe}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:column>
            </h:panelGrid>
        </center>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdminstrationGenerale}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelChangeGroupe" width="600" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelChangeGroupe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelChangeGroupe}" var="chg">
            <f:facet name="header"><h:outputText value="CHANGE IMPUTATION pour #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.usersEnCours.usrPatronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annulerChangerGroupe}" image="/images/close.gif" styleClass="hidelink" reRender="panelChangeGroupe"/>
                </a4j:form>
            </f:facet>
            <a4j:form >

                <h:panelGrid width="100%" border="0" >
                    <rich:tabPanel switchType="client" immediate="true"  id="p1" style="height:300px;margin-top:0px;border:0;" width="100%">

                        <rich:tab name="imputation" label="Imputation">
                            <h:panelGrid id="panGrp" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos35,clos65g">
                                <h:column><h:outputText value="Nouveau groupe:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.nouveauGroupe}" >
                                        <f:selectItem itemLabel="Sélectionnez un groupe" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesGroupeChangeItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nouveau service:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.nouveauService}" >
                                        <f:selectItem itemLabel="Sélectionnez un service" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesServicesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nouvele équipe"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.nouvelleEquipe}" >
                                        <f:selectItem itemLabel="Sélectionnez une équipe" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesEquipesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="caisse" label="Caisses autorisées">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai!=0}"><h:outputText value="Accès aux éléments:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai!=0}">
                                <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.nouveauRecu}" >
                                    <f:selectItem itemLabel="Tous les éléments" itemValue="0"/>
                                    <f:selectItem itemLabel="Uniquement mes éléments (créateur)" itemValue="1"/>
                                    <f:selectItem itemLabel="Uniquement les éléments de mon groupe associé (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCode})" itemValue="2"/>
                                    <f:selectItem itemLabel="Eléments liés à ma caisse reçu par défaut" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai==0}"><h:outputText value="Gestion des encaissements:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai==0}">
                                <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.nouveauFactureCaisse}" >
                                    <f:selectItem itemLabel="Sans encaissement" itemValue="0"/>
                                    <f:selectItem itemLabel="Le user peut faire des bons d`encaissements" itemValue="1"/>
                                    <f:selectItem itemLabel="Le user peut faire des encaissements directs" itemValue="2"/>
                                    <f:selectItem itemLabel="Le user peut faire tous types d`encaissements" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tablecaisse" styleClass="bg" style="border:1px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" height="260px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelCaisses}" var="caisse">
                                    <rich:column label="Selection" width="15%" sortBy="#{caisse.caisseSelected}" sortable="true">
                                        <f:facet name="header"> <h:outputText value="Caisse"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{caisse.caisseSelected}"/>
                                    </rich:column>
                                    <rich:column label="Selection" width="15%" sortBy="#{caisse.recuSelected}" sortable="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai!=0}">
                                        <f:facet name="header"> <h:outputText value="Reçu"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{caisse.recuSelected}"/>
                                    </rich:column>
                                    <rich:column label="Code caisse" width="20%" sortBy="#{caisse.caiCode}" sortable="true" sortOrder="ASCENDING">
                                        <f:facet name="header"> <h:outputText value="Code"/></f:facet>
                                        <h:outputText value="#{caisse.caiCode}"/>
                                    </rich:column>
                                    <rich:column label="Libelé caisse" width="50%" sortBy="#{caisse.caiNom}" sortable="true">
                                        <f:facet name="header"> <h:outputText value="Caisse"/></f:facet>
                                        <h:outputText value="#{caisse.caiNom}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>

                <h:panelGroup>
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChangeGroupe}" image="/images/valider_big.png" reRender="panelChangeGroupe,tableuser"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   id="panelGroupe" width="500" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelGroupe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelGroupe}" var="grp">
            <f:facet name="header"><h:outputText value="GESTION DES GROUPES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleGroupe}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText disabled="true" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCode}" size="20" maxlength="10">
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText disabled="true" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLibelle}" size="35" maxlength="50"/></h:column>
                    <h:column><h:outputText value="Groupe lié:"/></h:column>
                    <h:column><h:inputText disabled="true" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLie}" size="20" maxlength="10"/></h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_office}">
                    <h:column><h:outputText value="Module Office:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleOff}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_tiers}">
                    <h:column><h:outputText value="Module Tiers:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleTie}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_achats}">
                    <h:column><h:outputText value="Module Achat:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleAch}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_stock}">
                    <h:column><h:outputText value="Module Stock:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleStk}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_ventes}">
                    <h:column><h:outputText value="Module Vente:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleVte}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_caisse}">
                    <h:column><h:outputText value="Module Trésorerie:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                            <f:selectItem itemValue="2" itemLabel="Limité"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_parc}">
                    <h:column><h:outputText value="Module Parc:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModulePrc}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_paye}">
                    <h:column><h:outputText value="Module Paye:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModulePay}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                            <f:selectItem itemValue="2" itemLabel="Limité"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_compta}">
                    <h:column><h:outputText value="Module Comptabilité:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCpt}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_medical}">
                    <h:column><h:outputText value="Module Médical:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleMed}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Module FREE:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleFree}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Module GUEST:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleGuest}" disabled="true" readonly="true">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
