<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="vutil">

    <a4j:form id="utilisateur">

        <center> <h2><h:outputText value="GESTION DES UTILISATEURS" style="color:green;"/></h2></center>

        <center>
            <h:panelGroup id="panelBouton" style="height:50px">
                <a4j:commandButton title="Ajouter un nouvel utilisateur" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutUser}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Modifier l'utilisateur sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifUser}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Supprimer l'utilisateur sélectionné" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supUser}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet utilisateur?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme<='1')==true}" reRender="modAttente,p1,panelBouton"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Imprimer liste des utilisateurs" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton}"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Imprimer les droits d'accés" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpDroits');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton}"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Envoyer les identifiants à l'utilisateur sélectionné" image="/images/mail_envoie.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mailUser}" onclick="if (!confirm('Etes-vous sur de vouloir envoyer les identifiants par mail à cet utilisateur?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton}" reRender="modAttente,"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Modifier les identifiants à l'utilisateur sélectionné" image="/images/detail_alerte.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ouvrirChangeIdentifiant}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersLog.usrJrxReserve=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton}" reRender="panelIdentifiant"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Génération QRCODE" image="/images/qrcode.png" oncomplete="javascript:Richfaces.showModalPanel('panelQrCode');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_bouton}"/>
            </h:panelGroup>
        </center>
        <br>
        <center>
            <rich:tabPanel switchType="client" immediate="true" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ongletActif}" id="p1" style="height:400px;margin-top:0px;border:0;" width="100%">

                <rich:tab name="userSt" id="userSt" label="Utilisateurs">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.agentActif}"  reRender="iduserStr"/>
                    <h:panelGrid width="100%" id="iduserStr">
                        <rich:extendedDataTable id="tableuserSt" styleClass="bg" style="max-height:100%;border:0px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUserSt}" var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.simpleSelectionSt}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.extDTableSt}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionUtilisateurSt}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visualisationSt}" reRender="idSubView,panelBouton"/>
                            <jsp:include flush="true" page="utilisateurListeCommun.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="userCoAdm" id="userCoAdm" label="Co-Administrateurs">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.agentCoAdm}" reRender="iduserCoAdm"/>
                    <h:panelGrid width="100%" id="iduserCoAdm">
                        <rich:extendedDataTable id="tableuserCoAdm" styleClass="bg" style="max-height:100%;border:0px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUserCoAdm}"  var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.simpleSelectionCoAdm}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.extDTableCoAdm}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionUtilisateurCoAdm}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visualisationCoAdm}" reRender="idSubView,panelBouton"/>
                            <jsp:include flush="true" page="utilisateurListeCommun.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="userAdm" id="userAdm" label="Administrateurs">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.agentAdm}" reRender="iduserAdm"/>
                    <h:panelGrid width="100%" id="iduserAdm">
                        <rich:extendedDataTable id="tableuserAdm" styleClass="bg" style="max-height:100%;border:0px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUserAdm}"  var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.simpleSelectionAdm}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.extDTableAdm}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionUtilisateurAdm}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visualisationAdm}" reRender="idSubView,panelBouton"/>
                            <jsp:include flush="true" page="utilisateurListeCommun.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="userGu" id="userGu" label="Guest">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.agentGuest}" reRender="iduserGu"/>
                    <h:panelGrid width="100%" id="iduserGu">
                        <rich:extendedDataTable id="tableuserGu" styleClass="bg" style="max-height:100%;border:0px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUserGu}"  var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.simpleSelectionGu}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.extDTableGu}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionUtilisateurGu}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visualisationGu}" reRender="idSubView,panelBouton"/>
                            <rich:column label="Administrateur" width="7%" sortable="true" sortBy="#{utilisateur.usrSysteme}" style="text-align:center;">
                                <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
                                <h:graphicImage value="/images/co-chef.png" rendered="#{utilisateur.usrSysteme==1}" title="Co-administrateur"/>
                                <h:graphicImage value="/images/chef.png" rendered="#{utilisateur.usrSysteme==2}" title="Administrateur"/>
                                <h:graphicImage value="/images/configuration.png" rendered="#{utilisateur.usrSysteme==3}"/>
                                <h:graphicImage value="/images/tiers.png" height="15px" width="15px" rendered="#{utilisateur.usrIdSalarieGuest!=0}" title="Connexion Users/Salariés"/>
                                <h:graphicImage value="/images/dollar.png" height="15px" width="15px" rendered="#{utilisateur.usrCaissier!=0&&utilisateur.groupe.grpModuleCai==1}" title="Accès caisse complète"/>
                                <h:graphicImage value="/images/panier.png" height="15px" width="15px" rendered="#{utilisateur.usrCaissier!=0&&utilisateur.groupe.grpModuleCai==2}" title="Accès bon de sortie"/>
                            </rich:column >
                            <rich:column label="Etat" width="5%" sortable="true" sortBy="#{utilisateur.usrEtat}" style="text-align:center;">
                                <f:facet name="header"> <h:outputText value="Etat"/></f:facet>
                                <h:graphicImage value="/images/desactiver.png" rendered="#{utilisateur.usrEtat==0}"/>
                            </rich:column >
                            <rich:column label="Compte" width="10%" sortBy="#{utilisateur.usrCompte}" sortable="true">
                                <f:facet name="header"> <h:outputText value="Cpt."/></f:facet>
                                <h:outputText value="#{utilisateur.usrCompte}"/>
                            </rich:column>
                            <rich:column label="Groupe" width="10%" sortBy="#{utilisateur.groupe.grpCode}" sortable="true" filterBy="#{utilisateur.usrCollaboration}">
                                <f:facet name="header"> <h:outputText value="Grp."/></f:facet>
                                <h:outputText value="#{utilisateur.groupe.grpCode}"/>
                            </rich:column >
                            <rich:column label="Nom" width="30%" sortBy="#{utilisateur.usrNom}" sortable="true" sortOrder="ASCENDING" filterBy="#{utilisateur.usrNom}">
                                <f:facet name="header"> <h:outputText value="Nom et prénom"/></f:facet>
                                <h:outputText value="#{utilisateur.usrNom}  #{utilisateur.usrPrenom}"/>
                            </rich:column >
                            <rich:column label="Tiers" width="30%" sortBy="#{utilisateur.usrNomTiersGuest}" sortable="true" filterBy="#{utilisateur.usrNomTiersGuest}">
                                <f:facet name="header"> <h:outputText value="Tiers"/></f:facet>
                                <h:outputText value="#{utilisateur.usrNomTiersGuest}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="userMed" id="userMed" label="Médical" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==15}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.agentMed}" reRender="iduserMed"/>
                    <h:panelGrid width="100%" id="iduserMed">
                        <rich:extendedDataTable id="tableuserMed" styleClass="bg" style="max-height:100%;border:0px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUserMed}" var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.simpleSelectionMed}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.extDTableMed}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionUtilisateurMed}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visualisationMed}" reRender="idSubView,panelBouton"/>
                            <jsp:include flush="true" page="utilisateurListeCommun.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="userIn" id="userIn" label="Inactifs">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.agentInActif}" reRender="iduserIn"/>
                    <h:panelGrid width="100%" id="iduserIn">
                        <rich:extendedDataTable id="tableuserIn" styleClass="bg" style="max-height:100%;border:0px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUserIn}"  var="utilisateur" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.simpleSelectionIn}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.extDTableIn}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionUtilisateurIn}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visualisationIn}" reRender="idSubView,panelBouton"/>
                            <jsp:include flush="true" page="utilisateurListeCommun.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>
            <br>
            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}">
                <center>
                    <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="User appartenant au Cabinet" style="color:black;"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="User appartenant au Client" style="color:blue;"/>&nbsp;&nbsp;&nbsp;
                </center>
            </h:panelGroup>
        </center>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdminstrationGenerale}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelIdentifiant" width="600" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelChangeIdentifiant}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelChangeIdentifiant}" var="chg">
            <f:facet name="header"><h:outputText value="CHANGE IDENTIFIANT pour #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPatronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.fermerChangeIdentifiant}" image="/images/close.gif" styleClass="hidelink" reRender="panelIdentifiant"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid width="100%" headerClass="headerTab"columnClasses="colsAc,colsAc" id="cptesrp">
                    <f:facet name="header"><h:outputText value="SECURITE"/></f:facet>
                    <h:panelGrid columns="2" width="100%">
                        <h:column>
                            <h:graphicImage style="cursor:pointer;" alt="Modifier mon mot de passe " title="Modifier mon mot de passe " url="/images/modifier.png">
                                <a4j:support eventsQueue="maQueue" immediate="true" reRender="cptesrp,mdpsse" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.comptaLienMd}" />
                            </h:graphicImage>
                        </h:column>
                        <h:column><h:outputText styleClass="hcompte" value="Modifier mon de passe:"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="mdpsse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.md}" >
                        <h:column>
                            <h:outputText style="color:red;font-weight:bold;"value="Mot de passe:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.md}"/>
                        </h:column>
                        <h:column><h:inputSecret required="true" redisplay="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPw}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.md}"/></h:column>
                    </h:panelGrid>

                    <h:panelGrid columns="2"width="100%" >
                        <h:column>
                            <h:graphicImage style="cursor:pointer;" alt="Modifier mon code secret " title="Modifier mon code secret " url="/images/modifier.png">
                                <a4j:support eventsQueue="maQueue" reRender="cptesrp,mdcs" immediate="true" event="onclick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.comptaLienCs}" />
                            </h:graphicImage>
                        </h:column>
                        <h:column><h:outputText styleClass="hcompte" value="Modifier mon code secret:"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="mdcs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.cs}" >
                        <h:column>
                            <h:outputText style="color:red;font-weight:bold;" value="Code secret:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.cs}"/>
                        </h:column>
                        <h:column><h:inputSecret size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCodeSecret}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.cs}"/></h:column>
                    </h:panelGrid>

                    <h:panelGrid columns="2" width="100%">
                        <h:column>
                            <h:graphicImage style="cursor:pointer;" alt="Modifier mon mail " title="Modifier mon mail " url="/images/modifier.png">
                                <a4j:support eventsQueue="maQueue" immediate="true" reRender="cptesrp,mdmail" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.comptaLienMail}" />
                            </h:graphicImage>
                        </h:column>
                        <h:column><h:outputText styleClass="hcompte" value="Modifier mon mail:"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="mdmail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail}" >
                        <h:column>
                            <h:outputText style="color:red;font-weight:bold;"value="mail:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail}"/>
                        </h:column>
                        <h:column><h:inputText size="60" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail}"/></h:column>
                    </h:panelGrid>

                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideChangeIdentifiant}" image="/images/valider_big.png" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelIdentifiant"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelImpDroits" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionUserDroits.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelQrCode" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionUserQrCode.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelPermission" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelPermission}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelPermission}" var="per">
            <f:facet name="header"><h:outputText value="PERmission ANDroid pour #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPatronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.fermerPermission}" image="/images/close.gif" styleClass="hidelink" reRender="panelPermission"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid width="100%" headerClass="headerTab"columnClasses="colsAc,colsAc">
                    <h:column><h:outputText value="Cette zone est réservée aux personnels d'epegase SOLUTIONS, car elle permet la configuration des permissions des applications Android" style="color:red"/></h:column>
                    <br>
                    <h:panelGrid columns="2" width="100%">
                        <h:column><h:outputText value="Mot de passe:"/></h:column>
                        <h:column><h:inputSecret value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.saisiePermission}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifPermission}" image="/images/valider_big.png" reRender="panelPermission,panelPermissionSuite"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelPermissionSuite" width="400" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichagePermission}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichagePermission}" var="drp">
            <f:facet name="header"><h:outputText value="PERMISSION ANDROID pour #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPatronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.fermerPermission}" image="/images/close.gif" styleClass="hidelink" reRender="panelPermissionSuite"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid width="100%" headerClass="headerTab"columnClasses="colsAc,colsAc">
                    <h:panelGrid columns="2" width="100%">
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.permission01}"/></h:column>
                        <h:column><h:outputText value="Gestion des frais"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.permission02}"/></h:column>
                        <h:column><h:outputText value="Gestion des Rendez-vous"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.permission03}"/></h:column>
                        <h:column><h:outputText value="Gestion des Missions"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.permission04}"/></h:column>
                        <h:column><h:outputText value="Gestion des Actes à Domicile"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.permission05}"/></h:column>
                        <h:column><h:outputText value="Gestion des Inventaires Immobilisations"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.permission06}"/></h:column>
                        <h:column><h:outputText value="Gestion des Authentifications des documents"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerPermission}" image="/images/valider_big.png" reRender="panelPermissionSuite"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
