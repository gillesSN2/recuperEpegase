<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="mail">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeDocument}" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" border="0">            

            <rich:tabPanel switchType="client" immediate="true" id="tabPanelMail" style="border:0px;">

                <rich:tab label="Entête document">
                    <h:panelGrid id="idEntete" width="100%" styleClass="fichefournisseur">
                        <h:panelGrid id="idDestinataire" width="100%" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Date élément:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiDateCreation}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==2&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='125'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='126')}"><h:outputText value="Structure:"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==2&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='125'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='126')}">
                                <h:selectOneMenu id="idStructureItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_structure}"  style="width:100%">
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesStructuresItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculeStructureChoisie}" reRender="idDestinataire,idUsersDiffusion"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:outputText value="De:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}">
                                <h:selectOneMenu id="idEmetteurItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiEmetteur}"  style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens!='125'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens!='126'}"><h:outputText value="Tiers:"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens!='125'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens!='126'}">
                                <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiTiersRs}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                    <rich:toolTip id="toolTiers" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les tiers" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idDestinataire,idTiers,panelListeTiers,formModalListeTiers,panelValidation,idStructureDiffusion,idTiersDivers1,idTiersDivers2"/>
                                </h:inputText>
                            </h:column>
                            <h:column id="idTiersDivers1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.tiersDivers}"><h:outputText value="Nom du Tiers (non référencé):"/></h:column>
                            <h:column id="idTiersDivers2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.tiersDivers}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiTiersDivers}" maxlength="100" style="width:100%"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.gestionAgent}"><h:outputText value="Agents:"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.gestionAgent}">
                                <h:inputText id="idAgents" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiAgentNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                    <rich:toolTip id="toolAgents" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les agents" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.rechercheAgents}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idDestnataire,idAgent,panelListeAgents,formModalListeAgents,panelValidation,idStructureDiffusion"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.gestionPatient}"><h:outputText value="Patient:"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.gestionPatient}">
                                <h:inputText id="idPatients" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiPatientNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                    <rich:toolTip id="toolPatient" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les patients" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.recherchePatients}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idDestinataire,idPatients,panelListePatients,formModalListePatients,panelValidation,idStructureDiffusion"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.autreMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><h:outputText value="Destinataire:"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.autreMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}">
                                <h:selectOneMenu id="idDestinataireItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiDestinataire}"  style="width:100%">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.lesDestinatairesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculeContactFinal}" reRender="tableContact"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column id="idAutreDestinataire1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.autreMail&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><h:outputText value="Autre Destinataire:"/></h:column>
                            <h:column id="idAutreDestinataire2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.autreMail&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiDestinataire}" style="width:100%">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculAutreMail}" reRender="panelValidation,idAutreDestinataire1,idAutreDestinataire2"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><h:outputText value="Ccc:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}">
                                <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableContact" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelContacts}" var="con" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.testValidation}" reRender="panelValidation"/>
                                    <rich:column width="40%"><h:outputText value="#{con.conpatronyme}"/></rich:column>
                                    <rich:column width="40%"><h:outputText value="#{con.conmail1}"/></rich:column>
                                    <rich:column width="20%"><h:selectBooleanCheckbox value="#{con.select}"/></rich:column>
                                </rich:extendedDataTable>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1}"><h:outputText value="Nature:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1}">
                                <h:selectOneMenu id="idNatureItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiNature}" style="width:100%">
                                    <f:selectItem itemLabel="Sélectionnez une nature" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesNaturesItem}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:outputText value="Cci:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiCci}" maxlength="200" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Nos Réf.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiNosRef}" maxlength="50" style="width:60%"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Vos Réf."/>&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiVosRef}" maxlength="100" style="width:200px"/>
                            </h:column>
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiObjet}" maxlength="100" style="width:60%"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Priorité:"/>&nbsp;
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiPriorite}" style="width:200px">
                                    <f:selectItem itemLabel="Normale" itemValue="0"/>
                                    <f:selectItem itemLabel="Importante" itemValue="1"/>
                                    <f:selectItem itemLabel="Prioritaire" itemValue="2"/>
                                    <f:selectItem itemLabel="Projet" itemValue="3"/>
                                    <f:selectItem itemLabel="Réunion" itemValue="4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Activité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idActiviteItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiActivite}" style="width:100%">
                                    <f:selectItem itemLabel="Sélectionnez une activité" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesActivitesItem}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idServiceItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiService}" style="width:100%">
                                    <f:selectItem itemLabel="Sélectionnez un service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesServicesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Corps document" reRender="corps">
                    <h:selectOneMenu id="idModele" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiModele}" style="width:100%">
                        <f:selectItem itemLabel="Sélectionnez un modèle" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesModelesItem}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculeModele}" reRender="idCorps"/>
                    </h:selectOneMenu>
                    <br><br>
                    <rich:editor id="idCorps" theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiCorps}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                    </rich:editor>
                </rich:tab>

                <rich:tab label="Piéce(s) jointe(s)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}">
                    <h:panelGrid width="200px" columns="3">
                        <a4j:commandButton title="Ajouter pièce" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.ajouterPj}" reRender="panalAjoutFile"/>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.viewerPdf}">
                            <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                            </h:column>
                            <a4j:commandButton title="Supprimer document" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichier}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;" reRender="colrep" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.supprimerPj}"/>
                        </h:panelGrid>
                        <rich:extendedDataTable styleClass="bg" id="idPj" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelLesPJ}"  style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="pj">
                            <rich:column  width="90%" sortable="true"  sortOrder="DESCENDING" label="Acces PJ">
                                <f:facet name="header"><h:outputText value="Pièces jointes"/></f:facet>
                                <h:outputText value="#{pj.malpjAcces}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </rich:tab>

                <rich:tab label="Liste de diffusion" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='125'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='126'}">
                    <h:panelGrid style="width:100%;">
                        <h:column>
                            <rich:extendedDataTable enableContextMenu="true" styleClass="bg" id="idUsersDiffusion" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelUsers}" style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="usr">
                                <rich:column  width="10%" sortable="true">
                                    <f:facet name="header"><h:outputText value="Sel."/></f:facet>
                                    <h:selectBooleanCheckbox value="#{usr.selectUser}" />
                                </rich:column>
                                <rich:column  width="90%" sortable="true"  sortOrder="ASCENDING" sortBy="#{usr.usrPatronyme}"  label="Utilisateurs">
                                    <f:facet name="header"><h:outputText value="Utilisateurs concernés"/></f:facet>
                                    <h:outputText value="#{usr.usrCivilite} #{usr.usrPatronyme}"  />
                                </rich:column>
                            </rich:extendedDataTable>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Scan du courrier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1}">
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiScanCourrier==null}">
                                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.uploadedFile}" accept="image/*"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_action>=50}">
                                    <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                                </h:commandButton>
                                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup  id="grp3" style="tex-align:center">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiScanCourrier!=null}">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeFichier==0}" var="sc1">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.urlphotoProd}" width="100%" height="800px"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeFichier==1}" var="sc2">
                                        <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierMine}" width="100%" height="550">
                                            <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}"></a>
                                        </object>
                                    </c:if>
                                    <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.reInitPhoto}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_action<50}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiScanCourrier==null}">
                                    <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGrid id="panelValidation" columns="3" styleClass="recherche"  width="100%">
                <a4j:commandButton value="Envoyer mail" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.disableBouton}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.envoyerMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton value="Enregistrer Document" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.disableBoutonEnregistrer}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.saveBrouillon}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/annuler_big.png" title="Fermer sans enregistrer"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.annuleNouveauMail}" reRender="modAttente,idSubView"/>
            </h:panelGrid>

        </h:panelGrid>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelTiers}" var="tiers" >
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.datamodelTiers}"  var="tiers">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.selectionTiers}"/>
                            <rich:column label="Structure" sortable="true" sortBy="#{tiers.nomGroupe}" width="8%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet=='2'}">
                                <f:facet name="header" ><h:outputText value="STR."/></f:facet>
                                <h:outputText value="#{tiers.nomGroupe}" style="#{tiers.styleCouleur}"/>
                            </rich:column>
                            <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                                <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                                <h:outputText value="#{tiers.tiecategorie}"/>
                            </rich:column>
                            <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="50%">
                                <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                                <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                            </rich:column>
                            <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                                <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                                <h:outputText value="#{tiers.tieprenom}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                                <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                                <h:outputText value="#{tiers.tiecivilite}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valtiers">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.annuleTiers}" reRender="panelListeTiers,idDestinataire,panelValidation,idStructureDiffusion"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculeTiers}" reRender="panelListeTiers,idDestinataire,panelValidation,idStructureDiffusion"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListePatients" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelPatients}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelPatients}" var="patients" >
            <f:facet name="header"><h:outputText value="Sélection du patient"/></f:facet>
            <a4j:form id="formModalListePatients">
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tablePatients" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.datamodelPatients}" var="pat">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.selectionPatients}"/>
                            <rich:column label="Civilité" sortable="true" sortBy="#{pat.patCivilite}" width="15%">
                                <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                                <h:outputText value="#{pat.patCivilite}"/>
                            </rich:column>
                            <rich:column label="Nom" sortable="true" sortBy="#{pat.patNom}" width="55%">
                                <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                <h:outputText value="#{pat.patNom}"/>
                            </rich:column>
                            <rich:column label="Prénom" sortable="true" sortBy="#{pat.patPrenom}" width="20%">
                                <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                                <h:outputText value="#{pat.patPrenom}"/>
                            </rich:column>
                            <rich:column label="Né(e)" sortable="true" sortBy="#{pat.patDateNaissance}" width="10%">
                                <f:facet name="header"><h:outputText  value="Né(e)" /></f:facet>
                                <h:outputText value="#{pat.patDateNaissance}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valpatients">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.annulePatients}" reRender="panelListePatients,idDestinataire,panelValidation,idStructureDiffusion"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculePatients}" reRender="panelListePatients,idDestinataire,panelValidation,idStructureDiffusion"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeAgents" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelAgents}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelAgents}" var="agents" >
            <f:facet name="header"><h:outputText value="Sélection de l'agent"/></f:facet>
            <a4j:form id="formModalListeAgents">
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableAgents" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.datamodelAgents}" var="agt">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.selectionAgents}"/>
                            <rich:column label="Structure" sortable="true" sortBy="#{agt.nomGroupe}" width="8%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet=='2'}">
                                <f:facet name="header" ><h:outputText value="STR."/></f:facet>
                                <h:outputText value="#{agt.nomGroupe}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{agt.salCivilite}" width="15%">
                                <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                                <h:outputText value="#{agt.salCivilite}"/>
                            </rich:column>
                            <rich:column label="Nom" sortable="true" sortBy="#{agt.salNom}" width="55%">
                                <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                <h:outputText value="#{agt.salNom}"/>
                            </rich:column>
                            <rich:column label="Prénom" sortable="true" sortBy="#{agt.salPrenom}" width="20%">
                                <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                                <h:outputText value="#{agt.salPrenom}"/>
                            </rich:column>
                            <rich:column label="Né(e)" sortable="true" sortBy="#{agt.salDateNaissance}" width="10%">
                                <f:facet name="header"><h:outputText  value="Né(e)" /></f:facet>
                                <h:outputText value="#{agt.salDateNaissance}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valagents">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.annuleAgents}" reRender="panelListeAgents,idDestinataire,panelValidation,idStructureDiffusion"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.calculeAgents}" reRender="panelListeAgents,idDestinataire,panelValidation,idStructureDiffusion"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nomRepertoire}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.annulerDocument}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.uploadedFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.validerPj}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
