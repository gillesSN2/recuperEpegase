<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="mailTiers">

    <a4j:form enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.typeDocument} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.tiers.tieraisonsocialenom}" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" border="0">            

            <rich:tabPanel switchType="client" immediate="true" id="tabPanelMail" style="border:0px;">

                <rich:tab label="Entete">
                    <h:panelGrid id="idEntete" width="100%" styleClass="fichefournisseur">
                        <h:panelGrid id="idDestinataire" width="100%" columns="2" columnClasses="clos20,clos80">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}"><h:outputText value="De:"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}">
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiEmetteur}"  style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Tiers:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiTiersRs}" readonly="true"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.gestionPatient}"><h:outputText value="Patient:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.gestionPatient}"><h:inputText style="width:100%" id="idPatients" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiPatientNom}" readonly="true"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.autreMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}"><h:outputText value="Destinataire:"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.autreMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}">
                                <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableContact" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.dataModelContacts}" var="con" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.testValidation}" reRender="panelValidation"/>
                                    <rich:column width="40%">
                                        <h:outputText value="#{con.conpatronyme}"/>
                                    </rich:column>
                                    <rich:column width="40%">
                                        <h:outputText value="#{con.mailCumul}"/>
                                    </rich:column>
                                    <rich:column width="20%">
                                        <h:selectBooleanCheckbox value="#{con.select}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </h:column>
                            <h:column id="idAutreDestinataire1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.autreMail}"><h:outputText value="Autre Destinataire:"/></h:column>
                            <h:column id="idAutreDestinataire2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.autreMail}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiDestinataire}" style="width:100%">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.calculAutreMail}" reRender="panelValidation,idAutreDestinataire1,idAutreDestinataire2"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}"><h:outputText value="Ccc:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiCc}" maxlength="200" style="width:100%"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}"><h:outputText value="Cci:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiCci}" maxlength="200" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Nos Réf.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiNosRef}" maxlength="50" style="width:60%"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Priorité:"/>&nbsp;
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiPriorite}" style="width:200px">
                                    <f:selectItem itemLabel="Normale" itemValue="0"/>
                                    <f:selectItem itemLabel="Importante" itemValue="1"/>
                                    <f:selectItem itemLabel="Prioritaire" itemValue="2"/>
                                    <f:selectItem itemLabel="Projet" itemValue="3"/>
                                    <f:selectItem itemLabel="Réunion" itemValue="4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiObjet}" maxlength="100" style="width:60%"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Vos Réf."/>&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiVosRef}" maxlength="100" style="width:200px"/>
                            </h:column>
                            <h:column><h:outputText value="Activité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiActivite}" style="width:100%">
                                    <f:selectItem itemLabel="Sélectionnez une activité" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mesActivitesItem}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiService}" style="width:100%">
                                    <f:selectItem itemLabel="Sélectionnez un service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mesServicesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Corps" reRender="corps">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiModele}" style="width:100%">
                        <f:selectItem itemLabel="Sélectionnez un modèle" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mesModelesItem}"/>
                    </h:selectOneMenu>
                    <br><br>
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiCorps}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                    </rich:editor>
                </rich:tab>

                <rich:tab label="Piéce(s) jointe(s)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0}">
                </rich:tab>

            </rich:tabPanel>

            <h:panelGrid id="panelValidation" columns="3" styleClass="recherche"  width="100%">
                <a4j:commandButton value="Envoyer mail" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.disableBouton}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.mails.maiType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.envoyerMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton value="Enregistrer Document" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.disableBoutonEnregistrer}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.saveDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/annuler_big.png" title="Fermer sans enregistrer"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.formMessagerie.annuleNouveauMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            </h:panelGrid>

        </h:panelGrid>

    </a4j:form>

</f:subview>
