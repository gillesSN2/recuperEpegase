<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="entetebal">

    <a4j:form  id="styleBal">

        <br><br>
        <center> <h:outputText value="Boites Mails du groupe:  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLibelle}" style="color:green;font-size:16px;"/> </center>

        <h:panelGrid id="boutonBal" columns="3" width="150px">
            <h:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajouterBal}"/>
            <h:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifierBal}" />
            <h:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerBal}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
        </h:panelGrid>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable style="max-height:100%;border:1px" styleClass="bg" id="tableBal" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.dataModelBal}" var="bal">
                <a4j:support eventsQueue="maQueue" event="onRowClick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionBal}" reRender="boutonBal"/>
                <rich:column width="30%" sortable="true" sortBy="#{bal.balnomcompte}" >
                    <f:facet name="header">
                        <h:outputText value="Nom BAL"/>
                    </f:facet>
                    <h:outputText value="#{bal.balnomcompte}" />
                </rich:column >
                <rich:column width="60%" sortable="true" sortBy="#{bal.baladressemail}">
                    <f:facet name="header">
                        <h:outputText value="Adresse"/>
                    </f:facet>
                    <h:outputText  value="#{bal.baladressemail}" />
                </rich:column >
                <rich:column  width="5%" sortable="true" sortBy="#{bal.usrfavInactif}">
                    <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                    <h:commandButton image="#{bal.etat}"  rendered="#{bal.afficheImag}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigneGroupe}" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelBal" width="850" height="700" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelBal}">
        <f:facet name="header"><h:outputText value="GESTION DES BALS DU GROUPE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCode}"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton id="idCanBal" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annulerBal}" styleClass="hidelink" reRender="panelBal,boutonBal"/>
                <rich:hotKey key="esc" handler="#{rich:element('idCanBal')}.click()" />
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid width="100%" id="pngdCpte">
                <h:panelGrid columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="Identification compte groupe"/></f:facet>
                    <h:column><h:outputText value="Nom du compte:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balnomcompte}"/></h:column>
                    <h:column><h:outputText value="Email du compte:"/></h:column>
                    <h:column>
                        <h:inputText disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balid!=0}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.baladressemail}">
                            <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifExistMail}" event="onchange" reRender="idValBal,pngdCpte"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_existMail}"></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_existMail}"><h:outputText value="Ce mail existe déjà. Veuillez en saisir un autre!!!" style="color:red;"/></h:column>
                    <h:column><h:outputText value="Répondre à:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.baladressemailreponse}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balid==0}"><h:outputText value="Mot de passe:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balid==0}"><h:inputSecret size="30" id="pwpop" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balpw}"/></h:column>
                    <h:column><h:outputText value="Etat du compte:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balinactif}">
                            <f:selectItem itemValue="0" itemLabel="Actif"/>
                            <f:selectItem itemValue="1" itemLabel="Inactif"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column><h:outputText value="Connexion SSL:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balssl}">
                            <f:selectItem itemValue="0" itemLabel="Connexion sans SSL"/>
                            <f:selectItem itemValue="1" itemLabel="Connexion avec SSL"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid   columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="POP du groupe (Courriers entrants)"/></f:facet>
                    <h:column><h:outputText value="Serveur POP:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balpopserveur}"/></h:column>
                    <h:column><h:outputText value="Port:"/></h:column>
                    <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balpopport}"/></h:column>
                    <h:column><h:outputText value="Exemplaire des mails:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balpopexemplaire}">
                            <f:selectItem itemValue="0" itemLabel="Laisser un exemplaire sur le serveur d'origine"/>
                            <f:selectItem itemValue="1" itemLabel="Enlever du serveur d'origine"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Authentification:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balpopauthentification}">
                            <f:selectItem itemValue="0" itemLabel="Automatique"/>
                            <f:selectItem itemValue="1" itemLabel="AUTHCRAM-MDS"/>
                            <f:selectItem itemValue="2" itemLabel="AUTHLOGIN"/>
                            <f:selectItem itemValue="3" itemLabel="Text plain"/>
                            <f:selectItem itemValue="4" itemLabel="Aucune"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid   columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="IMAP du groupe (Courriers entrants)"/></f:facet>
                    <h:column><h:outputText value="Serveur IMAP:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balimapserveur}"/></h:column>
                    <h:column><h:outputText value="Port:"/></h:column>
                    <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balimapport}"/></h:column>
                </h:panelGrid>
                <h:panelGrid  columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="SMTP du groupe (Courriers sortants)"/></f:facet>
                    <h:column><h:outputText value="Serveur SMTP:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balsmtpserveur}"/></h:column>
                    <h:column><h:outputText value="Port:"/></h:column>
                    <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balsmtpport}"/></h:column>
                    <h:column><h:outputText value="Authentification:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balsmtauthentification}">
                            <f:selectItem itemValue="0" itemLabel="Sans Authentification"/>
                            <f:selectItem itemValue="1" itemLabel="Avec Authentification"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="Signature automatique"/></f:facet>
                    <h:column>
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.bal.balSignature}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idValBal" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.saveBal}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_valide_bal}" reRender="boutonBal,tableBal,panelBal"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValBal')}.click()" />
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


</f:subview>