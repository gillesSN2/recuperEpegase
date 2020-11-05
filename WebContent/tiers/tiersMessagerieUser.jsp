<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="userMessagerie">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="MESSAGERIE/COURRIER : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.usersLog.usrPatronyme}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid  columns="6" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Objet/Corps"/></h:column>
                <h:column><h:inputText style="width:90px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.filtre2}"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.sens}" style="width:150px">
                        <f:selectItem itemLabel="Tous mouvements" itemValue="99"/>
                        <f:selectItem itemLabel="Mails envoyés" itemValue="0" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <f:selectItem itemLabel="Mails reçus" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <f:selectItem itemLabel="Mails brouillons" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <f:selectItem itemLabel="Courriers encoyés" itemValue="3"/>
                        <f:selectItem itemLabel="Courriers recus" itemValue="4"/>
                        <f:selectItem itemLabel="Corbeille" itemValue="5"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.periode}" style="width:150px">
                        <f:selectItem itemLabel="Toutes périodes" itemValue="99"/>
                        <f:selectItem itemLabel="Jour en cours" itemValue="0"/>
                        <f:selectItem itemLabel="Semaine en cours" itemValue="1"/>
                        <f:selectItem itemLabel="Mois en cours" itemValue="2"/>
                        <f:selectItem itemLabel="Trimestre en cours" itemValue="3"/>
                        <f:selectItem itemLabel="Semestre en cours" itemValue="4"/>
                        <f:selectItem itemLabel="Année en cours" itemValue="5"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.priorite}"  style="width:150px">
                        <f:selectItem itemLabel="Toutes priorités" itemValue="99"/>
                        <f:selectItem itemLabel="Normale" itemValue="0"/>
                        <f:selectItem itemLabel="Importante" itemValue="1"/>
                        <f:selectItem itemLabel="Prioritaire" itemValue="2"/>
                        <f:selectItem itemLabel="Projet" itemValue="3"/>
                        <f:selectItem itemLabel="Réunion" itemValue="4"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.executerRequeteUsers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,lesBoutons,scrollTable,msg"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>

            <h:panelGrid id="lesBoutons" columns="10" width="400px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                <h:column><a4j:commandButton image="/images/mail_nouveau.png" title="Nouveau Mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.nouveauMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens<='2'}"><a4j:commandButton image="/images/mail_repondre.png" title="Répondre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.repondreUnique}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens<='2'}"><a4j:commandButton image="/images/mail_repondre_multiple.png" title="Répondre à tous" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.repondreTous}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens<='2'}"><a4j:commandButton image="/images/mail_faire_suivre.png" title="Faire suivre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.transfererMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column><a4j:commandButton image="/images/courrier_nouveau_envoye.png" title="Nouveau Courrier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.nouveauCourrierEnvoi}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column><a4j:commandButton image="/images/courrier_nouveau_recu.png" title="Nouveau Courrier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.nouveauCourrierRecu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens=='4')}"><a4j:commandButton image="/images/modifier.png" title="Modifier courrier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.modifierDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens<='4'}"><a4j:commandButton image="/images/mail_marque_lu.png" title="Marquer Lu/non Lu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.marquerLuNonLu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idLu,idPj,msg,scrollTable"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens<='6'}"><a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerMail}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiSens<='6'}"><a4j:commandButton image="/images/supprimer.png" title="Supprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.supprimerMail}" onclick="if (!confirm('Etes vous sur de vouloir supprimer le mail sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idLu,idPj,msg,scrollTable"/></h:column>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="msg"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.var_nb_max}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.dataModelLesMails}" id="msg" styleClass="bg" activeClass="active-row" noDataLabel=" " headerClass="headerTab" border="0" height="300px"  width="100%" rowClasses="rows1,rows2,rowsd" var="msg">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.selectionMail}" reRender="panelDetails,lesBoutons"/>
                        <rich:column width="4%" sortable="true" sortBy="#{msg.maiSens}" label="Sens" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Sens"/></f:facet>
                            <h:graphicImage value="#{msg.sens}" height="15px" width="15px"/>
                        </rich:column>
                        <rich:column width="4%" sortable="true" sortBy="#{msg.maiType}" label="Type" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="T."/></f:facet>
                            <h:graphicImage value="#{msg.type}" height="15px" width="15px"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{msg.maiDateCreation}" sortOrder="DESCENDING" label="Date/heure">
                            <f:facet name="header"><h:outputText value="Date/heure"/></f:facet>
                            <h:outputText value="#{msg.maiDateCreation}" style="color:#{msg.color}">
                                <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="5%" sortable="true" sortBy="#{msg.maiNum}" label="N°">
                            <f:facet name="header"><h:outputText value="N°"/></f:facet>
                            <h:outputText value="#{msg.maiNum}" style="color:#{msg.color}"/>
                        </rich:column>
                        <rich:column  width="10%" sortBy="#{msg.maiEmetteur}" sortable="true" label="Emetteur">
                            <f:facet name="header"><h:outputText value="Emetteur"/></f:facet>
                            <h:outputText value="#{msg.maiEmetteur}" style="color:#{msg.color}"/>
                        </rich:column>
                        <rich:column  width="13%" sortBy="#{msg.maiTiersRs}" sortable="true" label="Tiers">
                            <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{msg.maiTiersRs}" style="color:#{msg.color}"/>
                        </rich:column>
                        <rich:column  width="15%" sortBy="#{msg.maiDestinataire}" sortable="true" label="Destinataire">
                            <f:facet name="header"><h:outputText value="Destinataire"/></f:facet>
                            <h:outputText value="#{msg.maiDestinataire}" style="color:#{msg.color}"/>
                        </rich:column>
                        <rich:column  width="28%" sortBy="#{msg.maiObjet}" sortable="true" label="Objet">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{msg.maiObjet}" style="color:#{msg.color}"/>
                        </rich:column>
                        <rich:column  width="6%" sortable="true" sortBy="#{msg.prioriteLib}" label="Prioritaire">
                            <f:facet name="header"><h:outputText value="Priorité"/></f:facet>
                            <h:outputText value="#{msg.prioriteLib}" style="color:#{msg.color}"/>
                        </rich:column>
                        <rich:column  width="4%" sortable="true" sortBy="#{msg.pj}" label="Pièces jointes" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="PJ"/></f:facet>
                            <h:graphicImage value="#{msg.pj}" height="15px" width="15px" rendered="#{msg.pj!=null}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="panelDetails" width="100%">
                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;">

                    <rich:tab id="tabCorps" label="Corps">
                        <rich:editor id="corps" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiCorps}" readonly="true">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab id="tabEntete" label="Entete">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><rich:calendar readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiDateCreation}" datePattern="dd/MM/yy HH:00" inputSize="8"/></h:column>
                            <h:column><h:outputText value="Numéro:"/></h:column>
                            <h:column><h:inputText size="30" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiNum}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:outputText value="Emetteur:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiEmetteur}"/></h:column>
                            <h:column><h:outputText value="Tiers:"/></h:column>
                            <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiTiersRs}"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.autreMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:outputText value="Destinataire:"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.autreMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}">
                                <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableContact" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.dataModelContacts}" var="con" >
                                    <rich:column width="50%">
                                        <h:outputText value="#{con.conpatronyme}"/>
                                    </rich:column>
                                    <rich:column width="50%">
                                        <h:outputText value="#{con.mailCumul}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </h:column>
                            <h:column id="idAutreDestinataire1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.autreMail}"><h:outputText value="Autre Destinataire:"/></h:column>
                            <h:column id="idAutreDestinataire2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.autreMail}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiDestinataire}" style="width:100%"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:outputText value="Ccc:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiCc}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:outputText value="Cci:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiCci}"/></h:column>
                            <h:column><h:outputText value="Nos Réf.:"/></h:column>
                            <h:column>
                                <h:inputText style="width:60%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiNosRef}"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Priorité:"/>&nbsp;
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiPriorite}" style="width:200px" disabled="true">
                                    <f:selectItem itemLabel="Normale" itemValue="0"/>
                                    <f:selectItem itemLabel="Importante" itemValue="1"/>
                                    <f:selectItem itemLabel="Prioritaire" itemValue="2"/>
                                    <f:selectItem itemLabel="Projet" itemValue="3"/>
                                    <f:selectItem itemLabel="Réunion" itemValue="4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column>
                                <h:inputText style="width:60%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiObjet}"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Vos Réf.:"/>&nbsp;
                                <h:inputText style="width:200px" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiVosRef}"/>
                            </h:column>
                            <h:column><h:outputText value="Activité:"/></h:column>
                            <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiActivite}"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiService}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiErreur}"><h:outputText value="ERREUR ENVOI:" style="color:red"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiErreur}"><h:inputText style="width:100%;color:red;" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiStatut}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabPJ" label="P.J." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable styleClass="bg" id="idPj" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.dataModelLesPJ}"  style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="pj">
                                <rich:column  width="90%" sortable="true"  sortOrder="DESCENDING" label="Acces PJ">
                                    <f:facet name="header"><h:outputText value="Pièces jointes"/></f:facet>
                                    <h:outputText value="#{pj.malpjAcces}" />
                                </rich:column >
                                <rich:column  width="10%" sortable="true" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                                    <h:commandButton image="/images/detail.png"  style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.voirPj}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabLu" label="Lecture" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable styleClass="bg" id="idLu" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.dataModelLesmailsLus}"  style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="lu">
                                <rich:column  width="30%" sortable="true"  sortOrder="DESCENDING" label="Acces Mail">
                                    <f:facet name="header"><h:outputText value="User"/></f:facet>
                                    <h:outputText value="#{lu.malluUser}" />
                                </rich:column >
                                <rich:column  width="30%" sortable="true"  label="Date">
                                    <f:facet name="header"><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{lu.malluDateLecture}" >
                                        <f:convertDateTime pattern="dd/MM/yy:HH.mm.ss" locale="fr" />
                                    </h:outputText>
                                </rich:column >
                                <rich:column  width="40%" sortable="true"  label="Note">
                                    <f:facet name="header"><h:outputText value="Note"/></f:facet>
                                    <h:inputText readonly="#{(lu.users.usrid==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.usersLog.usrid)==false}" size="10" value="#{lu.malluNote}" />
                                    &nbsp;<a4j:commandButton reRender="panelDetails" rendered="#{(lu.users.usrid==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.usersLog.usrid)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.majMailNote}"  image="/images/valider.png"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.retourMessagerie}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation de la P.J."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.fermerVisuPj}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%" id="idGlobale">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.var_choix_modele}" >
                            <f:selectItem itemLabel="Mail/Courrier séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste des Mails/Courriers" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect1,docSelect2,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect1" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.nomModeleDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mailImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="docSelect2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.nomModeleDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.mails.maiType==1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idGlobale,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.formMessagerie.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
