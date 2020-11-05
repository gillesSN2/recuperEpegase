<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="listesocietes">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value="LISTE DES SOCIETES (SYSTEME)" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;"  columns="2">

            <rich:column id="soc" width="70%" style="border:1px solid green;">

                <h:panelGrid id="pansoc" columns="10" width="100%">
                    <h:commandButton image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.gestModifEntete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.testBoutonModif}"/>
                    <h:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.testBouton}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.deleteStructureSel}"/>
                    <a4j:commandButton image="/images/mail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.taillelistSociete!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.initInformationsclients}" onclick="if (!confirm('Etes-vous sur de vouloir informer les clients ?')) return false" reRender="panelInformations"/>
                    <a4j:commandButton image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.taillelistSociete!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.etat}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Etats" itemValue="9"/>
                        <f:selectItem itemLabel="Non actif" itemValue="0"/>
                        <f:selectItem itemLabel="Actif" itemValue="1"/>
                        <f:selectItem itemLabel="Bloqué" itemValue="2"/>
                        <f:selectItem itemLabel="Cloturé" itemValue="3"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.mode}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Modes" itemValue="9"/>
                        <f:selectItem itemLabel="Full internet" itemValue="0"/>
                        <f:selectItem itemLabel="Full intranet" itemValue="1"/>
                        <f:selectItem itemLabel="Mixte" itemValue="2"/>
                        <f:selectItem itemLabel="Spécial" itemValue="3"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.module}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Modules" itemValue=""/>
                        <f:selectItem itemLabel="Tiers" itemValue="30000"/>
                        <f:selectItem itemLabel="Compta. libérale" itemValue="401"/>
                        <f:selectItem itemLabel="Compta. Societe" itemValue="402"/>
                        <f:selectItem itemLabel="Compta. Projet" itemValue="403"/>
                        <f:selectItem itemLabel="Paye" itemValue="500"/>
                        <f:selectItem itemLabel="Achats" itemValue="600"/>
                        <f:selectItem itemLabel="Parc" itemValue="700"/>
                        <f:selectItem itemLabel="Ventes Standards" itemValue="801"/>
                        <f:selectItem itemLabel="Ventes + Caisses" itemValue="802"/>
                        <f:selectItem itemLabel="Fondation" itemValue="803"/>
                        <f:selectItem itemLabel="Interim" itemValue="804"/>
                        <f:selectItem itemLabel="Cabinet" itemValue="805"/>
                        <f:selectItem itemLabel="Transport" itemValue="806"/>
                        <f:selectItem itemLabel="MicroFinance" itemValue="807"/>
                        <f:selectItem itemLabel="Change monetaire" itemValue="808"/>
                        <f:selectItem itemLabel="Education" itemValue="809"/>
                        <f:selectItem itemLabel="Ventes + Abonnement" itemValue="810"/>
                        <f:selectItem itemLabel="Pecherie" itemValue="811"/>
                        <f:selectItem itemLabel="Temple" itemValue="812"/>
                        <f:selectItem itemLabel="Polit-Buro" itemValue="813"/>
                        <f:selectItem itemLabel="Forêt" itemValue="814"/>
                        <f:selectItem itemLabel="Médical" itemValue="815"/>
                        <f:selectItem itemLabel="Immobilier" itemValue="816"/>
                        <f:selectItem itemLabel="Hotel/Restaurant" itemValue="817"/>
                        <f:selectItem itemLabel="Trésorerie" itemValue="900"/>
                        <f:selectItem itemLabel="Repporting" itemValue="910"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.pays}">
                        <f:selectItem itemLabel="Tous pays" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesPaysItem}" />
                    </h:selectOneMenu>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.chargerLesSocietes}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tablesoc"/>
                    <a4j:commandButton value="Tout Sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.toutSelectionner}" reRender="tablesoc"/>
                    <a4j:commandButton value="Rien Sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.rienSelectionner}" reRender="tablesoc"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tablesoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.dataModelLesSocites}" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" styleClass="bg" style="max-height:100%" border="0" rowClasses="rows1,rows2,rowsd" var="societe">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.recupererlesUsers}" reRender="user,pansoc" />
                        <rich:column width="5%" sortable="true" sortBy="#{societe.selectStructure}">
                            <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox value="#{societe.selectStructure}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{societe.strId}">
                            <f:facet name="header" ><h:outputText value="ID"/></f:facet>
                            <h:outputText  value="#{societe.strId}"  />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{societe.strdtecreat}">
                            <f:facet name="header" ><h:outputText value="Création"/></f:facet>
                            <h:outputText  value="#{societe.strdtecreat}" >
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column >
                        <rich:column width="5%" sortable="true" sortBy="#{societe.libetat}">
                            <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                            <h:outputText  value="#{societe.libetat}" />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{societe.libmode}">
                            <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                            <h:outputText  value="#{societe.libmode}"  />
                        </rich:column >
                        <rich:column width="40%" sortable="true" sortBy="#{societe.strraisonsociale}">
                            <f:facet name="header" ><h:outputText value="Raison sociale"/></f:facet>
                            <h:outputText  value="#{societe.strraisonsociale}" />
                        </rich:column >
                        <rich:column width="15%" sortable="true" sortBy="#{societe.strtel1}" >
                            <f:facet name="header" ><h:outputText value="Téléphone"/></f:facet>
                            <h:outputText  value="#{societe.strtel1}"  />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{societe.strnompays}" >
                            <f:facet name="header" ><h:outputText value="Pays"/></f:facet>
                            <h:outputText  value="#{societe.strnompays}"  />
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column id="user" width="30%" style="border:1px solid green;">
                <h:panelGrid id="panuser" columns="4" width="100%">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.ajouterUser}" reRender="panelUser"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.modifierUser}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.testBoutonSuppUser}" reRender="panelUser"/>
                    <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.testBoutonSuppUser}" reRender="user" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.supprimerUser}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.dataModelLesUsersPeg}"  id="tableuser" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" border="0" styleClass="bg" style="max-height:100%" rowClasses="rows1,rows2,rowsd" var="users">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.recupererUser}" reRender="panuser" />
                        <rich:column width="100%">
                            <f:facet name="header" ><h:outputText value="LISTE UTILISATEURS"/></f:facet>
                            <h:outputText value="#{users.usrprenom}  #{users.usrnom} : #{users.usrlogin}" style="width:100%"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelUser" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="250" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.showModalPanelUser}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION UTILISATEUR" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.fermerUser}" image="/images/close.gif" styleClass="hidelink" reRender="panelUser"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalModif" >
                <h:panelGrid  width="100%">
                    <h:panelGrid  columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                        <h:column><h:outputText value="Nom:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrnom}"/></h:column>
                        <h:column><h:outputText value="Prénom:"/></h:column>
                        <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrprenom}" size="30"/></h:column>
                        <h:column><h:outputText value="Login:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrlogin}" size="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrid!=0}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrid==0}"><h:outputText value="Mot de passe:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrid==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrpw}" size="30"/></h:column>
                        <h:column><h:outputText value="Mail:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrmail}" size="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrid!=0}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrid==0}"><h:outputText value="Code secret:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrid==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrcodesecret}" size="30"/></h:column>
                        <h:column><h:outputText style="text-decoration:underline;color:red;" value="Type user:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usrsysteme}">
                                <f:selectItem itemLabel="Utilisateur" itemValue="0"/>
                                <f:selectItem itemLabel="Administrateur" itemValue="1"/>
                                <f:selectItem itemLabel="Maintenance" itemValue="2" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;color:red;" value="Etat user:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.usersPeg.usretat}">
                                <f:selectItem itemLabel="Accès interdit" itemValue="0"/>
                                <f:selectItem itemLabel="Accès autorisé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <a4j:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.saveUser}" id="val" reRender="panelUser"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformations" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="600" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.showModalPanelInfoClients}">
        <center>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.showModalPanelInfoClients}" var="inf">
                <f:facet name="header"><h:outputText value="Génération mails aux clients sélectionnés" style="color:white;"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.fermerInformationsclients}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformations"/>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalInformations" >
                    <h:panelGrid width="100%" columns="2" columnClasses="clos70d,clos30g">
                        <h:panelGrid width="100%" id="idMail">
                            <h:panelGrid width="100%" columns="2">
                                <h:column><h:outputText value="N° référence:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.numOrigine}" size="10" readonly="true" disabled="true"/></h:column>
                                <h:column><h:outputText value="Date envoie:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.dateOrigine}" size="10" readonly="true" disabled="true"/></h:column>
                                <h:column><h:outputText value="Destinataires:"/></h:column>
                                <h:column><h:inputTextarea rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.destinataireOrigine}" readonly="true" disabled="true" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Objet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.objetOrigine}" maxlength="100" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.pegEnvoieMail.pegmaiId!=0}"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%">
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.texteInformations}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.pegEnvoieMail.pegmaiId!=0}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" reRender="tablemail" id="scrollTable" maxPages="20"align="left" for="tablemail"/>
                                <rich:extendedDataTable rows="200" id="tablemail" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.dataModelLesMails}" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" styleClass="bg" style="max-height:100%" border="0" rowClasses="rows1,rows2,rowsd" var="mail">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.recupererLeMail}" reRender="idMail" />
                                    <rich:column width="10%" sortable="true" sortBy="#{mail.pegmaiNum}">
                                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                        <h:outputText  value="#{mail.pegmaiNum}"  />
                                    </rich:column >
                                    <rich:column width="10%" sortable="true" sortBy="#{mail.pegmaiDateCreat}">
                                        <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                        <h:outputText  value="#{mail.pegmaiDateCreat}" >
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column >
                                    <rich:column width="80%" sortable="true" sortBy="#{mail.pegmaiObjet}">
                                        <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{mail.pegmaiObjet}" />
                                    </rich:column >
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="text-align:center;">
                        <a4j:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.informerLesClients}" id="valInformations" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelInformations"/>
                    </h:panelGrid>
                </a4j:form>
            </c:if>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.valQteGraph}" >
                                <f:selectItem itemLabel="En quantité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par pays" itemValue="1"/>
                                <f:selectItem itemLabel="par mode (internet, intranet, mixte, spécial)" itemValue="2"/>
                                <f:selectItem itemLabel="par nature (autonome, cabinet, groupe, franchise, distributeur, formation)" itemValue="3"/>
                                <f:selectItem itemLabel="par module (compta, paye, achat, vente, tréso, parc, médical)" itemValue="4"/>
                                <f:selectItem itemLabel="par etat (inactive, en cours, perdu, cloturé, faillite)" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.timeDecoupage}">
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="évolution" itemValue="6"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
