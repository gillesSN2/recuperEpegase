<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="listeusers">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value="LISTE DES UTILISATEURS (SYSTEME)" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;"  columns="2">

            <rich:column id="user" width="100%" style="border:1px solid green;">

                <h:panelGrid id="panuser" columns="6" width="100%" style="height:34px">
                    <h:commandButton image="/images/modifier.png" onclick="javascript:Richfaces.showModalPanel('panelUsers');" rendered="false"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.etat}" style="width:130px;">
                        <f:selectItem itemLabel="Tous Etats" itemValue="9"/>
                        <f:selectItem itemLabel="Aurorisé" itemValue="1"/>
                        <f:selectItem itemLabel="Interdit" itemValue="0"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.mode}" style="width:130px;">
                        <f:selectItem itemLabel="Tous Modes" itemValue="9"/>
                        <f:selectItem itemLabel="Utilisateur" itemValue="0"/>
                        <f:selectItem itemLabel="Administrateur" itemValue="1"/>
                        <f:selectItem itemLabel="Système" itemValue="2"/>
                        <f:selectItem itemLabel="Maintenance" itemValue="3"/>
                        <f:selectItem itemLabel="Spécial" itemValue="4"/>
                    </h:selectOneMenu>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.chargerLesUsers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableuser"/>
                    <a4j:commandButton title="Supprimer l'agent sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.usersPeg.usrid!=0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet agent ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.supprimerAgent}" reRender="panuser,tableuser"/>
                    <h:commandButton value="RECUP USERS DES BASES" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.recupererLesUsers}" onclick="if (!confirm('Etes-vous sur de vouloir récupérer les users des bases clientes?')) return false;javascript:Richfaces.showModalPanel('panelBarUser');" style="color:red"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableuser" groupingColumn="idStr" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" styleClass="bg" style="max-height:100%" border="0" rowClasses="rows1,rows2,rowsd" var="user" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.dataModelLesUsersPeg}">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.selectionUser}" reRender="panuser"/>
                        <rich:column width="5%" sortable="true" sortBy="#{user.usrid}">
                            <f:facet name="header" ><h:outputText value="Id"/></f:facet>
                            <h:outputText  value="#{user.usrid}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{user.usrnom} #{user.usrprenom}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                            <h:outputText  value="#{user.usrnom} #{user.usrprenom}"/>
                        </rich:column>
                        <rich:column width="25%" sortable="true" sortBy="#{user.usrmail}" >
                            <f:facet name="header" ><h:outputText value="Mail user"/></f:facet>
                            <h:outputText  value="#{user.usrmail}"/>
                        </rich:column>
                        <rich:column id="idMail" width="5%" sortable="true" sortBy="#{user.usrconnexion}">
                            <f:facet name="header" ><h:outputText value="Infos"/></f:facet>
                            <a4j:commandButton immediate="true" style="height:20px;width:20px" image="/images/mail_marque_lu.png" rendered="#{user.usrconnexion==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.activeInformations}" reRender="idMail"/>
                            <a4j:commandButton immediate="true" style="height:20px;width:20px" image="/images/mail_marque_spam.png" rendered="#{user.usrconnexion==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.activeInformations}" reRender="idMail"/>
                        </rich:column>
                        <rich:column label="Administrateur" width="5%" sortable="true" sortBy="#{user.usrsysteme}" style="text-align:center;">
                            <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
                            <h:graphicImage value="/images/co-chef.png" rendered="#{user.usrsysteme==1}" title="Co-Admin"/>
                            <h:graphicImage value="/images/chef.png" rendered="#{user.usrsysteme==2}" title="Admin"/>
                            <h:graphicImage value="/images/configuration.png" rendered="#{user.usrsysteme==3}" title="Configuration"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{user.usrlogin}">
                            <f:facet name="header" ><h:outputText value="Login"/></f:facet>
                            <h:outputText  value="#{user.usrlogin}"/>
                        </rich:column>
                        <rich:column width="10%" id="idStr" sortable="true" sortBy="#{user.structurePeg.strId}">
                            <f:facet name="header" ><h:outputText value="Id société"/></f:facet>
                            <h:outputText  value="#{user.structurePeg.strId}"/>
                        </rich:column>
                        <rich:column width="25%" sortable="true" sortBy="#{user.structurePeg.strraisonsociale}">
                            <f:facet name="header" ><h:outputText value="Raison sociale"/></f:facet>
                            <h:outputText  value="#{user.structurePeg.strraisonsociale}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>

            </rich:column>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBarUser" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement des utilitaires en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" reRenderAfterComplete="panelBarUser,progressPanel">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemUsers.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
