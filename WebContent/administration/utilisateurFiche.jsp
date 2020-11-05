<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="vutil">

    <a4j:form id="utilisateurFiche">

        <h:column >
            <center> <h2><h:outputText value="GESTION DES UTILISATEURS" style="color:green;"/></h2></center>
        </h:column>

        <h:panelGrid width="100%" border="0" >
            <rich:tabPanel switchType="client" immediate="true"  id="p1" style="height:400px;margin-top:0px;border:0;" width="100%">

                <rich:tab name="identification" label="Identification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9}">
                    <h:panelGrid id="identification" styleClass="fichefournisseur" width="100%">
                        <h:panelGrid  columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                            <h:column><h:outputText style="text-decoration:underline;color:red;" value="Type user:"/></h:column>
                            <h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}" var="uc1">
                                    <h:selectOneMenu style="width:50%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme}">
                                        <f:selectItem itemLabel="Utilisateur" itemValue="0"/>
                                        <f:selectItem itemLabel="co-Administrateur" itemValue="1"/>
                                        <f:selectItem itemLabel="Administrateur principal" itemValue="2"/>
                                        <f:selectItem itemLabel="Maintenance" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid!=1}"/>
                                        <f:selectItem itemLabel="Guest" itemValue="4"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="identification,p1,idEtatUser"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:selectOneMenu style="width:45%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCabinet}">
                                        <f:selectItem itemLabel="Appartenant au Cabinet" itemValue="0"/>
                                        <f:selectItem itemLabel="Appartenant au Client" itemValue="1"/>
                                    </h:selectOneMenu>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==0||bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet>=2}" var="uc2">
                                    <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme}">
                                        <f:selectItem itemLabel="Utilisateur" itemValue="0"/>
                                        <f:selectItem itemLabel="co-Administrateur" itemValue="1"/>
                                        <f:selectItem itemLabel="Administrateur principal" itemValue="2"/>
                                        <f:selectItem itemLabel="Maintenance" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid!=1}"/>
                                        <f:selectItem itemLabel="Guest" itemValue="4"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="identification,p1,idEtatUser"/>
                                    </h:selectOneMenu>
                                </c:if>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;color:red;" value="Etat user:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idEtatUser" style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verif_admin}">
                                    <f:selectItem itemLabel="Accès interdit" itemValue="0"/>
                                    <f:selectItem itemLabel="Accès autorisé" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Civilité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="civilite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCivilite}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesCiviliteItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.chargerLesFonctions}" reRender="fonction"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Né(e) le:"/></h:column>
                            <h:column>
                                <a4j:outputPanel layout="block">
                                    <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateNaissance}" popup="true"/>
                                </a4j:outputPanel>
                            </h:column>
                            <h:column><h:outputText value="*" style="color:red"/><h:outputText value="Nom:"/></h:column>
                            <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrNom}"/></h:column>
                            <h:column><h:outputText value="Prénom:"/></h:column>
                            <h:column><h:inputText  onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPrenom}"/></h:column>
                            <h:column><h:outputText value="Fonction:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="fonction" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrFonction}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesFonctionsItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanelVte"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Langue:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="langue" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrLangue}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesLanguesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Métier:"/></h:column>
                            <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMetier}"/></h:column>
                            <h:column><h:outputText value="Initiales:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrInitiale}" maxlength="10"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAdresse}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="usrPanDroit" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText  value="Boite Postale:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrBp}"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column><h:inputText style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVille}"/></h:column>
                        <h:column><h:outputText value="Pays:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="pays" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrNomPays}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesPaysItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Numéro compte comptable:"/></h:column>
                        <h:column><h:inputText  size="15" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCompte}"/></h:column>
                        <h:column><h:outputText value="Tél domicile:"/></h:column>
                        <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrTelDomicile}"/></h:column>
                        <h:column><h:outputText value="Tél bureau:"/></h:column>
                        <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrTelBureau}"/></h:column>
                        <h:column><h:outputText value="Cellulaire 1:"/></h:column>
                        <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCel1}"/></h:column>
                        <h:column><h:outputText value="Cellulaire 2:"/></h:column>
                        <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCel2}"/></h:column>
                        <h:column><h:outputText value="Skype:"/></h:column>
                        <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSkype}"/></h:column>
                        <h:column><h:outputText value="N° Statistique"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrNumStat}"/></h:column>
                        <h:column><h:outputText value="*" style="color:red"/><h:outputText value="Email:"/></h:column>
                        <h:column><h:inputText  style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.testAffLogin}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMail}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="*" style="color:red"/><h:outputText value="Login:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.testAffLogin}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrLogin}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifLoginExiste}" reRender="identification,usrPanDroit"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Changement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrChange}" >
                                <f:selectItem itemLabel="Pas de changement" itemValue="0"/>
                                <f:selectItem itemLabel="Changement tous les mois" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg}"/></h:column>
                        <h:column><h:outputText style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg}" value="Cet login est deja utilisé !!"/></h:column>
                        <h:column><h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg}"/></h:column>
                        <h:column><h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg}"/></h:column>
                        <h:column  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.testAffPwdCS}"><h:outputText value="*" style="color:red"/><h:outputText value="Mot de passe:"/></h:column>
                        <h:column  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.testAffPwdCS}"><h:inputSecret style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPw}"/></h:column>
                        <h:column  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.testAffPwdCS}"><h:outputText value="*" style="color:red"/><h:outputText value="Code secret:"/></h:column>
                        <h:column  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.testAffPwdCS}"><h:inputSecret  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCodeSecret}"/></h:column>
                        <h:column><h:outputText value="GROUPE:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCollaboration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrid==0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesGroupesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.calculGroupe}" />
                            </h:selectOneMenu>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCollaboration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrid!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesGroupesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.calculGroupe}" reRender="utilisateurFiche,p1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="JSP startup:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrStartup}">
                                <f:selectItem itemLabel="Sans Startup" itemValue="Sans"/>
                                <f:selectItem itemLabel="Gestion Ticket" itemValue="TICKET"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid!=1}"><h:outputText value="ACCES ESPACE CLIENT:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid!=1}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPwEspaceClient}" style="width:100%;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid!=1}"><h:outputText value=""/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid!=1}"><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:outputText value="(*) les champs marqués sont obilgatoires pour être un utilisateur authentifié." style="color:red"/>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"/>&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='1')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideAjout}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.disablemail}" value="Regénérer Mot de passe et Code secret " style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.regenererPwd}" onclick="if (!confirm('Etes vous sur de vouloir regénérer le mot de passe de cet utilisateur?')) return false"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="administration" label="Co-Administrateur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column></h:column>
                        <h:column>
                            <h:panelGroup id="panelAdmin">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajout Fonction" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutFonction}" reRender="panelCoAdministration"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Suppression Fonction" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimeFonction}" reRender="p1,modAttente"/>
                            </h:panelGroup>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelCoAdministration}" styleClass="bg" style="margin-top:5px;border:1px solid green" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" height="250px" width="750px"  var="coadm">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionFonction}" reRender="panelAdmin"/>
                                    <rich:column width="100%" sortable="false" >
                                        <f:facet name="header" ><h:outputText value="Fonctions co-administratives" style="border:0px"/></f:facet>
                                        <h:outputText  value="#{coadm.libelle_FR}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="guest" label="Guest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme=='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Tiers concerné:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrIdTiersGuest}" >
                                <f:selectItem itemLabel="Aucun tiers" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.lesTiersItems}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Charger les tiers" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.chargerLesTiers}" onclick="if (!confirm('Etes vous sur de vouloir charger les tiers?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTiers"/>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='1')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideAjout}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="guestSalarie" label="Option User/Salarié" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModulePay=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModulePay=='2')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Salarié concerné:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" id="idSalarie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrIdSalarieGuest}" >
                                <f:selectItem itemLabel="Aucun salarié" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.lesSalariesItems}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Charger les salariés" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.chargerLesSalaries}" onclick="if (!confirm('Etes vous sur de vouloir charger les salariés?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSalarie"/>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"/>&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='1')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideAjout}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="commun" label="Commun" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35,clos15,clos35" id="idCommun">
                        <h:column><h:outputText value="Service prinicpal:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.libelleService}">
                                <f:selectItem itemLabel="Sélectionnez un service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesServicesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.calculSDS}" reRender="idCommun,idPanelAch,idPanelVte,idPanelMed"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Département affecté:"/></h:column>
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDepartement}"/></h:column>
                        <h:column><h:outputText value="Site affecté:"/></h:column>
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSite}"/></h:column>
                        <h:column><h:outputText value="Service secondaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.libelleServiceSecondaire}">
                                <f:selectItem itemLabel="Sélectionnez un service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesServicesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Taux horaire P.R.:"/></h:column>
                        <h:column><h:inputText  size="15" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPr}"/></h:column>
                        <h:column><h:outputText value="Taux horaire P.V.:"/></h:column>
                        <h:column><h:inputText  size="15"  style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPv}"/></h:column>

                        <h:column></h:column>
                        <h:column></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35,clos15,clos35" id="idCommun2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9}">
                        <h:column><h:outputText value="Accès aux tiers:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrTiers}" >
                                <f:selectItem itemLabel="Sans contrôle" itemValue="0"/>
                                <f:selectItem itemLabel="Tous les tiers" itemValue="1"/>
                                <f:selectItem itemLabel="Uniquement mes tiers (créateur)" itemValue="2"/>
                                <f:selectItem itemLabel="Uniquement mes tiers (responsable)" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Eléments privés:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve}" >
                                <f:selectItem itemLabel="Autorisé" itemValue="0"/>
                                <f:selectItem itemLabel="Interdit" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanelVte,idPanelAch,idPanelMed"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}"><h:outputText value="Création société:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCreationSociete}" >
                                <f:selectItem itemLabel="Autorisé" itemValue="0"/>
                                <f:selectItem itemLabel="Interdit" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Demandeur/Rapporteur (stocks):"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDemandeurAchats}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des bases copies:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrBaseCopie}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des habilitations:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSansHabilitation}" >
                                <f:selectItem itemLabel="Gestion par défaut" itemValue="0"/>
                                <f:selectItem itemLabel="Sans habilitation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des configurations des listes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrConfigListe}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion de l'assistant:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAssistant}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Assistante Femme" itemValue="1"/>
                                <f:selectItem itemLabel="Assistant Homme" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet>9}" var="grpusr">
                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35,clos15,clos35" id="idCommunGrp">
                            <h:column><h:outputText value="GROUPE:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCollaboration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrid==0}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesGroupesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.calculGroupe}" />
                                </h:selectOneMenu>
                                <h:selectOneMenu style="width:350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCollaboration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrid!=0}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesGroupesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.calculGroupe}" reRender="utilisateurFiche,p1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="office" label="Office" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleOff=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Accès aux mails:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAccesMail}" >
                                <f:selectItem itemLabel="Tous les mails" itemValue="0"/>
                                <f:selectItem itemLabel="Les mails collaboratifs" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Copie mail sur document:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMailCopie}" >
                                <f:selectItem itemLabel="Copie automatique" itemValue="0"/>
                                <f:selectItem itemLabel="Sans copie" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Copie mail sur parapheur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMailParapheur}" >
                                <f:selectItem itemLabel="Copie automatique" itemValue="0"/>
                                <f:selectItem itemLabel="Sans copie" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignatureOffice}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux plannings:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPlanningService}" >
                                <f:selectItem itemLabel="Tous les plannings" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mes plannings" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupOff" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserOff" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoOff}" reRender="panelChronoOff,serieoffice"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoOff}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieoffice"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoOff}" reRender="panelChronoOff,serieoffice"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserOff" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoOff}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonOff}" reRender="serieoffice"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="serieoffice" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoOff}" var="office">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersOffice}" reRender="grpuserajtsupOff,supserOff"/>
                                    <rich:column width="10%" sortable="true" sortBy="#{office.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{office.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="50%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{office.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{office.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{office.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{office.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{office.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="comptabilite" label="Comptabilité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCpt=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongCompta&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}" >
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Comptes interdits:"/></h:column>
                        <h:column><h:inputTextarea  rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptInterdit}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="(Inscrire les comptes comme suit : 'C1','C2','CX')" style="color:red"/></h:column>
                        <h:column><h:outputText value="Journaux interdits:"/></h:column>
                        <h:column><h:inputTextarea  rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxInterdit}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="(Inscrire les journaux comme suit : 'J1','J2','JX')" style="color:red"/></h:column>
                        <h:column><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignatureCompta}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupCpt" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoCpt}" reRender="panelChronoCpt,seriecpt"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoCpt}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,seriecpt"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoCpt}" reRender="panelChronoCpt,seriecpt"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserCpt" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoCpt}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonCpt}" reRender="seriecpt"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="seriecpt" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoCpt}" var="cpt">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersCpt}" reRender="grpuserajtsupCpt,supserCpt"/>
                                    <rich:column width="10%" sortable="true" sortBy="#{cpt.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{cpt.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="50%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{cpt.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" rendered="false">
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{cpt.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" rendered="false">
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{cpt.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" rendered="false">
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{cpt.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" rendered="false">
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{cpt.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value="Outils de correction des journaux:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAccesCorrection}" >
                                <f:selectItem itemLabel="Autorisé" itemValue="1"/>
                                <f:selectItem itemLabel="Interdit" itemValue="0"/>
                                <f:selectItem itemLabel="Modifier un exercice cloturé" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Liasses fiscales:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrModifLiasse}" >
                                <f:selectItem itemLabel="Modification Autorisée" itemValue="1"/>
                                <f:selectItem itemLabel="Mofication Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement consultation" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux brouillards:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAccesBrouillard}" >
                                <f:selectItem itemLabel="Pas d'accès aux brouillards" itemValue="0"/>
                                <f:selectItem itemLabel="Accès à tous les brouillards" itemValue="1"/>
                                <f:selectItem itemLabel="Accès uniquement mes brouillards" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Axe Budget non utilisé:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptProjet}"/></h:column>
                        <h:column><h:outputText value="Axe analytique dans les extraits:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrExtraitAnal}" >
                                <f:selectItem itemLabel="Tous les axes" itemValue="0"/>
                                <f:selectItem itemLabel="Axe Structure" itemValue="201" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strStructure}"/>
                                <f:selectItem itemLabel="Axe Site/Département/Service" itemValue="100" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}"/>
                                <f:selectItem itemLabel="Axe Région/Secteur/Pdv" itemValue="101" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}"/>
                                <f:selectItem itemLabel="Axe Site/Atelier/Ligne" itemValue="102" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strUsine}"/>
                                <f:selectItem itemLabel="Axe Activité" itemValue="110" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActivite}"/>
                                <f:selectItem itemLabel="Axe Agent" itemValue="122" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strAgent}"/>
                                <f:selectItem itemLabel="Axe Chantier" itemValue="7" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strChantier}"/>
                                <f:selectItem itemLabel="Axe Parc" itemValue="120" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strParc}"/>
                                <f:selectItem itemLabel="Axe Mission/Frais" itemValue="8" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMission}"/>
                                <f:selectItem itemLabel="Axe Clés" itemValue="9" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}"/>
                                <f:selectItem itemLabel="Axe Dossier" itemValue="6" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier==0}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strStructure}"><h:outputText value="Axe Structure non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strStructure}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptStructure}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}"><h:outputText value="Axe Site/Département/Service non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptSite}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}"><h:outputText value="Axe Région/Secteur/Pdv non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptRegion}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strUsine}"><h:outputText value="Axe Site/Atelier/Ligne non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strUsine}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptUsine}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActivite}"><h:outputText value="Axe Activité non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActivite}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptActivite}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strAgent}"><h:outputText value="Axe Agent non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strAgent}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptAgent}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strChantier}"><h:outputText value="Axe Chantier non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strChantier}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptChantier}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strParc}"><h:outputText value="Axe Parc non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strParc}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptParc}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMission}"><h:outputText value="Axe Mission/Frais non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMission}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptMission}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}"><h:outputText value="Axe Clés non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptCles}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier!=0}"><h:outputText value="Axe Dossier non utilisé:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier!=0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCptDossier}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="caisse" label="Caisse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='2')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongCaisse&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Caissier:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissier}" >
                                <f:selectItem itemLabel="Sans accès à la caisse" itemValue="0"/>
                                <f:selectItem itemLabel="Accès à la caisse" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux documents:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu id="selSerPre" style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierService}" >
                                <f:selectItem itemLabel="Tous les services" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mon service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService})" itemValue="1"  itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService==''}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux éléments:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrRecus}" >
                                <f:selectItem itemLabel="Tous les éléments" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mes éléments (créateur)" itemValue="1"/>
                                <f:selectItem itemLabel="Uniquement les éléments de mon groupe associé (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCollaboration})" itemValue="2"/>
                                <f:selectItem itemLabel="Eléments liés à ma caisse reçu par défaut" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Période des reçus:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrRecusJour}" >
                                <f:selectItem itemLabel="Toutes périodes" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement le jour en cours" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Choix Responsable:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrRespCaissier}" >
                                <f:selectItem itemLabel="Le user peut choisir le responsable" itemValue="0"/>
                                <f:selectItem itemLabel="Le responsable = user en cours" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignatureCaisse}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupCaiss" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoCaisse}" reRender="panelChronoCaisse,serieCaisse"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoCaisse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieCaisse"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoCaisse}" reRender="panelChronoCaisse,serieCaisse"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série"  id="supserCaiss" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoCaisse}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonCaiss}" reRender="serieCaisse"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="serieCaisse" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoCaiss}" var="caisse">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersCaisses}" reRender="grpuserajtsupVte,supserVte"/>
                                    <rich:column width="5%" sortable="true" sortBy="#{caisse.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{caisse.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="5%" >
                                        <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                        <h:outputText value="#{caisse.usrchrSerie}"/>
                                    </rich:column>
                                    <rich:column width="8%" >
                                        <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                        <h:outputText value="#{caisse.usrchrCodeCaisse}"/>
                                    </rich:column>
                                    <rich:column width="28%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{caisse.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="9%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{caisse.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="9%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{caisse.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="9%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{caisse.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="9%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{caisse.lib_dupplication}"/>
                                    </rich:column>
                                    <rich:column width="9%" >
                                        <f:facet name="header" ><h:outputText value="Exécution"/></f:facet>
                                        <h:outputText value="#{caisse.lib_execution}"/>
                                    </rich:column>
                                    <rich:column width="9%" >
                                        <f:facet name="header" ><h:outputText value="Journal"/></f:facet>
                                        <h:outputText value="#{caisse.lib_journal}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux Dates:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateCai}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux imputations:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrImputCai}" >
                                <f:selectItem itemLabel="Visibles et obligatoires" itemValue="0"/>
                                <f:selectItem itemLabel="Masquées" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux tiers (compte):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrTiersCai}" >
                                <f:selectItem itemLabel="Visibles et obligatoires" itemValue="0"/>
                                <f:selectItem itemLabel="Masquées" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux montants:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMontantCai}" >
                                <f:selectItem itemLabel="Modifiables" itemValue="0"/>
                                <f:selectItem itemLabel="Non modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Accès aux libelles:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrLibelleCai}">
                                <f:selectItem itemLabel="Modifiables" itemValue="0"/>
                                <f:selectItem itemLabel="Non modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRecette=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Recettes directes:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRecette=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierRecette}">
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieDepense=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Dépenses directes:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieDepense=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierDepense}">
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieTransfert=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Transferts directes:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieTransfert=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierTransfert}">
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRegularisation=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Modifications pièces:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRegularisation=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierModif}">
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieAnnulation=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Annulation reçus:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieAnnulation=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierAnnule}">
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieSuppression=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}"><h:outputText value="Suppressions reçus:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieSuppression=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleCai=='1'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCaissierDelete}">
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="achat" label="Achats" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleAch=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongAchat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid id="idPanelAch" columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService!=''}"><h:outputText value="Accès aux produits:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService!=''}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrProdServiceAch}" >
                                <f:selectItem itemLabel="Tous les produits" itemValue="0"/>
                                <f:selectItem itemLabel="Les produits du service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService})" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux achats:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAchats}" >
                                <f:selectItem itemLabel="Tous les éléments" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mes éléments (créateur)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Choix Commercial:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCommAchats}" >
                                <f:selectItem itemLabel="Le user peut choisir le responsable" itemValue="0"/>
                                <f:selectItem itemLabel="Le user peut choisir le responsable du client" itemValue="1"/>
                                <f:selectItem itemLabel="Le responsable = user en cours" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Liste commercial:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAcheteur}" >
                                <f:selectItem itemLabel="Ne peut pas faire d'achat" itemValue="0"/>
                                <f:selectItem itemLabel="Peut faire des achats (Acheteur)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des décaissements:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrFactureDeCaisse}" >
                                <f:selectItem itemLabel="Sans décaissement" itemValue="0"/>
                                <f:selectItem itemLabel="Le user peut faire des bons de décaissements" itemValue="1"/>
                                <f:selectItem itemLabel="Le user peut faire des décaissements directs" itemValue="2"/>
                                <f:selectItem itemLabel="Le user peut faire tous types décaissements" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignatureAchats}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupAch" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoAch}" reRender="panelChronoAch,idFormChronoAchat,serieachat"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoAch}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieachat"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoAch}" reRender="panelChronoAch,idFormChronoAchat,serieachat"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoAch}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonAch}" reRender="serieachat"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="serieachat" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoAch}" var="achat">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersAchats}" reRender="grpuserajtsupAch"/>
                                    <rich:column width="5%" sortable="true" sortBy="#{achat.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{achat.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="5%" >
                                        <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                        <h:outputText value="#{achat.usrchrSerie}"/>
                                    </rich:column>
                                    <rich:column width="50%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{achat.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{achat.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{achat.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{achat.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{achat.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value="Libellés des produits:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAchLibelle}" >
                                <f:selectItem itemLabel="Modification interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Modification autorisée si le produit l'autorise" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux Pump:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAchPump}" >
                                <f:selectItem itemLabel="Pump masqué" itemValue="0"/>
                                <f:selectItem itemLabel="Pump visible" itemValue="2"/>
                                <f:selectItem itemLabel="Pump modifiable" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux Dates achats:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateAch}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux Dates stocks:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateStk}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Remise:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerRemiseAch}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Rabais:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerRabaisAch}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Prix d'achat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerPaAch}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Dossier des frais:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrChgDosAchat}" >
                                <f:selectItem itemLabel="Modification des dossiers interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Modification des dossiers autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve==0}"><h:outputText value="Modification Série/N° Document:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve==0}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrModifSerieAch}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="depot" label="Dépôts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleAch=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongAchat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid id="idPanelStk" columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Accès aux dépôts:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDepotSel}" >
                                <f:selectItem itemLabel="Tous les dépôts" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement les dépôts cochés" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDepotHabilites" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.dataModelDepotHabilites}" var="dh">
                                <rich:column style="text-align:left;" width="10%">
                                    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                    <h:selectBooleanCheckbox  value="#{dh.selectDepot}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{dh.dpoCode}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="40%">
                                    <f:facet name="header"><h:outputText  value="Libellé dépôt"/></f:facet>
                                    <h:outputText  value="#{dh.dpoLibelle}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="40%">
                                    <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                    <h:outputText  value="#{dh.dpoService}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="process" label="Process" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleAch=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongAchat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableProcessHabilites" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.dataModelProcessHabilites}" var="ph">
                                <rich:column style="text-align:left;" width="10%">
                                    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                    <h:selectBooleanCheckbox  value="#{ph.selectProcess}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{ph.procesCode}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="40%">
                                    <f:facet name="header"><h:outputText  value="Libellé process"/></f:facet>
                                    <h:outputText  value="#{ph.procesLibClient}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="40%">
                                    <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                    <h:outputText  value="#{ph.procesService}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab  name="vente" label="Ventes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleVte=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleVte=='2')&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==16)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid id="idPanelVte" columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService!=''}"><h:outputText  value="Accès aux produits:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService!=''}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrProdService}" >
                                <f:selectItem itemLabel="Tous les produits" itemValue="0"/>
                                <f:selectItem itemLabel="Les produits du service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService})" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux ventes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVentes}" >
                                <f:selectItem itemLabel="Toutes les ventes" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mes ventes" itemValue="1"/>
                                <f:selectItem itemLabel="Uniquement mes ventes mais tous les devis (créateur)" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Choix Commercial:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCommVentes}" >
                                <f:selectItem itemLabel="Le user peut choisir le responsable" itemValue="0"/>
                                <f:selectItem itemLabel="Le user peut choisir le responsable du client" itemValue="1"/>
                                <f:selectItem itemLabel="Le responsable = user en cours" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Liste commercial:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVendeur}" >
                                <f:selectItem itemLabel="Ne peut pas faire de vente" itemValue="0"/>
                                <f:selectItem itemLabel="Peut faire des ventes (Commercial)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des encaissements:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrFactureCaisse}" >
                                <f:selectItem itemLabel="Sans encaissement" itemValue="0"/>
                                <f:selectItem itemLabel="Le user peut faire des bons d`encaissements" itemValue="1"/>
                                <f:selectItem itemLabel="Le user peut faire des encaissements directs" itemValue="2"/>
                                <f:selectItem itemLabel="Le user peut faire tous types d`encaissements" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignatureVentes}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.optionVentes.modeCommission=='3'}"><h:outputText value="Calcul de commission:"/></h:column>
                        <h:column id="idComm0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.optionVentes.modeCommission=='3'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCommType}" >
                                <f:selectItem itemLabel="Sans calcul de commission" itemValue="0"/>
                                <f:selectItem itemLabel="Sans calcul de commission, mais pris en compte pour d'autres users" itemValue="1"/>
                                <f:selectItem itemLabel="Calcul % sur le CA encaissé du user" itemValue="3"/>
                                <f:selectItem itemLabel="Calcul % sur le CA encaissé global" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanelVte,idComm0,idComm1,idComm2"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText id="idComm1" value="%:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCommType>=3}"/>&nbsp;
                            <h:inputText id="idComm2" style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCommPourcentage}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrCommType>=3}"/>
                        </h:column>
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupVte" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserVte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoVte}" reRender="panelChronoVte,idFormChronoVentes,serievente"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoVte}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serievente"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoVte}" reRender="panelChronoVte,idFormChronoVentes,serievente"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserVte" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoVte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonVte}" reRender="serievente"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="serievente" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoVte}" var="vente">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersVentes}" reRender="grpuserajtsupVte,supserVte"/>
                                    <rich:column width="5%" sortable="true" sortBy="#{vente.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{vente.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="5%" >
                                        <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                        <h:outputText value="#{vente.usrchrSerie}"/>
                                    </rich:column>
                                    <rich:column width="50%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{vente.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{vente.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{vente.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{vente.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{vente.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value="Libellés des produits:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVteLibelle}" >
                                <f:selectItem itemLabel="Modification interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Modification autorisée si le produit l'autorise" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage PUMP/Marge:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAffPump}" >
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage Prix Plancher:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAffPlancher}" >
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible bloquant" itemValue="1"/>
                                <f:selectItem itemLabel="Visible non bloquant" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage Prix Marché et Concurrent:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAffPvMarche}" >
                                <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                <f:selectItem itemLabel="Visible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage Totaux listes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVteTotaux}" >
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                                <f:selectItem itemLabel="Visible" itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux Dates:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateVte}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrFonction=='Livreur'}"><h:outputText value="Accès aux Dates de livraison:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrFonction=='Livreur'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateLivre}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve==0}"><h:outputText value="Lissage des factures:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve==0}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrLissage}" >
                                <f:selectItem itemLabel="Interdit" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Remise:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerRemise}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Rabais/Ristournes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerRabais}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Prix de vente:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerPv}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve==0}"><h:outputText value="Modification Série/N° Document:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrJrxReserve==0}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrModifSerieVte}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Alertes automatiques:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVteCtrAlerte}" >
                                <f:selectItem itemLabel="Aucune alerte" itemValue="0"/>
                                <f:selectItem itemLabel="Alerte sur les contrats" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="medic" label="Médical" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModuleMed=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongSuiviCom==15&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid id="idPanelMed" columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService!=''}"><h:outputText value="Accès aux produits:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService!=''}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrProdService}" >
                                <f:selectItem itemLabel="Tous les produits" itemValue="0"/>
                                <f:selectItem itemLabel="Les produits du service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService})" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès au médical:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMedical}" >
                                <f:selectItem itemLabel="Tout le médical" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mon médical (créateur)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode consultations générales:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVendeur}" >
                                <f:selectItem itemLabel="Mode facturation + médical" itemValue="0"/>
                                <f:selectItem itemLabel="Mode facturation" itemValue="1"/>
                                <f:selectItem itemLabel="Mode médical" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des encaissements:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrFactureCaisse}" >
                                <f:selectItem itemLabel="Sans encaissement" itemValue="0"/>
                                <f:selectItem itemLabel="Le user peut faire des bons d`encaissements" itemValue="1"/>
                                <f:selectItem itemLabel="Le user peut faire des encaissements directs" itemValue="2"/>
                                <f:selectItem itemLabel="Le user peut faire tous types d`encaissements" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des avoirs:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMedicalAvoir}" >
                                <f:selectItem itemLabel="Ne peux pas faire d'avoir" itemValue="0"/>
                                <f:selectItem itemLabel="Peux faire des avoirs" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignatureMedical}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupMed" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserMed" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoMed}" reRender="panelChronoMed,idFormChronoMedical,seriemedical"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoMed}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,seriemedical"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoMed}" reRender="panelChronoMed,idFormChronoMedical,seriemedical"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserMed" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoMed}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonVte}" reRender="seriemedical"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="seriemedical" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoMed}" var="medical">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersMedical}" reRender="grpuserajtsupMed,supserMed"/>
                                    <rich:column width="5%" sortable="true" sortBy="#{medical.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{medical.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="5%" >
                                        <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                        <h:outputText value="#{medical.usrchrSerie}"/>
                                    </rich:column>
                                    <rich:column width="50%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{medical.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{medical.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{medical.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{medical.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{medical.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value=" Accès aux Dates:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDateMed}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Remise:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerRemise}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Rabais:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerRabais}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Invisible" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Prix de vente:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrVerPv}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Prix CNAMGS:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAffPlancher}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Prix assurance:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrAffPvMarche}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Alertes automatiques:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrMedicalAlerte}" >
                                <f:selectItem itemLabel="Aucune alerte" itemValue="0"/>
                                <f:selectItem itemLabel="Alerte sur les vaccinations périmées (module infirmerie)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="paye" label="Paye et R.H." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModulePay=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongPay&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Accès agents:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPaye}" >
                                <f:selectItem itemLabel="Accès à tous les agents" itemValue="0"/>
                                <f:selectItem itemLabel="Accès uniquement aux agents non protégés + RH des protégés" itemValue="1"/>
                                <f:selectItem itemLabel="Accès uniquement aux agents non protégés + RH et Prêts des protégés" itemValue="2"/>
                                <f:selectItem itemLabel="Accès uniquement aux agents non protégés + RH, Prêts et Contrats des protégés" itemValue="3"/>
                                <f:selectItem itemLabel="Accès uniquement aux agents non protégés" itemValue="4"/>
                                <f:selectItem itemLabel="Accès uniquement aux agents protégés" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux services:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPayeService}" >
                                <f:selectItem itemLabel="Tous les services" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement mon service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService})" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrService==''}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion des décaissements:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPayeCaisse}" >
                                <f:selectItem itemLabel="Sans décaissement" itemValue="0"/>
                                <f:selectItem itemLabel="Le user peut indiquer le paiement des bulletins" itemValue="1"/>
                                <f:selectItem itemLabel="Le user peut faire des bons de décaissements" itemValue="2" itemDisabled="true"/>
                                <f:selectItem itemLabel="Le user peut faire des décaissements directs" itemValue="3" itemDisabled="true"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Responsable/Signature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSignaturePaye}" >
                                <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès aux natures agents:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupPaye" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Nature"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoPaye}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoPaye');" reRender="panelChronoPaye,seriePaye"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoPaye}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,seriePaye"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Nature" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoPaye}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoPaye');" reRender="panelChronoPaye,seriePaye"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Nature" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonPaye}" reRender="seriePaye"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="seriePaye" width="100%" height="200px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoPaye}" var="paye">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersPaye}" reRender="grpuserajtsupPaye"/>
                                    <rich:column width="5%" sortable="true" sortBy="#{paye.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{paye.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="15%" >
                                        <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                        <h:outputText value="#{paye.usrchrSerie}"/>
                                    </rich:column>
                                    <rich:column width="40%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{paye.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{paye.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{paye.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{paye.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{paye.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value="Bulletin salaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPayeBulletin}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat dans fiche de préparation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPayeContrat}" >
                                <f:selectItem itemLabel="Modifiable" itemValue="1"/>
                                <f:selectItem itemLabel="Verrouillée" itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Accès pointage:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPayPointage}" >
                                <f:selectItem itemLabel="Pointage individuel" itemValue="0"/>
                                <f:selectItem itemLabel="Accès à tous les pointages" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Alertes automatiques:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPayeAlerte}" >
                                <f:selectItem itemLabel="Aucune alerte" itemValue="0"/>
                                <f:selectItem itemLabel="Alerte des fins de contrats" itemValue="1"/>
                                <f:selectItem itemLabel="Alerte nouvelles demandes" itemValue="2"/>
                                <f:selectItem itemLabel="Alerte R.H." itemValue="3"/>
                                <f:selectItem itemLabel="Toutes les Alertes" itemValue="99"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab name="Parc" label="Parc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrSysteme!='4'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.ongParc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpModulePrc=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2'}">
                    <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                    <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Accès aux séries:"/></h:column>
                        <h:column>
                            <h:column>
                                <h:panelGrid id="grpuserajtsupParc" columns="4" style="width:200px">
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserPar" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutChronoPar}" reRender="panelChronoPar,serieparc"/>
                                    <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ajoutAutoChronoPar}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieparc"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.modifChronoPar}" reRender="panelChronoPar,serieparc"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserPar" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.supprimerChronoPar}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.visibiliteBtonPar}" reRender="serieparc"/>
                                </h:panelGrid>
                            </h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 1px green;" border="0" id="serieparc" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelUsersChronoPar}" var="parc">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionLesUsersParc}" reRender="grpuserajtsupPar,supserPar"/>
                                    <rich:column width="5%" sortable="true" sortBy="#{parc.usrchrNature}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                        <h:outputText value="#{parc.usrchrNature}"/>
                                    </rich:column>
                                    <rich:column width="5%" >
                                        <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                        <h:outputText value="#{parc.usrchrSerie}"/>
                                    </rich:column>
                                    <rich:column width="50%" >
                                        <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                        <h:outputText value="#{parc.usrchrLib}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                        <h:outputText value="#{parc.lib_update}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                        <h:outputText value="#{parc.lib_validation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                        <h:outputText value="#{parc.lib_devalidation}"/>
                                    </rich:column>
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                        <h:outputText value="#{parc.lib_dupplication}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value="Accès aux Dates:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrDatePrc}" >
                                <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Alertes automatiques:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrParcAlerte}" >
                                <f:selectItem itemLabel="Aucune alerte" itemValue="0"/>
                                <f:selectItem itemLabel="Alerte des fins d'assurances" itemValue="1"/>
                                <f:selectItem itemLabel="Alerte anniversaire achat" itemValue="2"/>
                                <f:selectItem itemLabel="Toutes les alertes" itemValue="99"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleUser}"  />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mail_Mesg==false)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action=='2')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.valideModif}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGroup>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelCoAdministration" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelFonction}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelFonction}" var="fon">
            <f:facet name="header"><h:outputText value="GESTION DES FONCTIONS CO-ADMINISTRATIVES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annulerFonction}" image="/images/close.gif" styleClass="hidelink" reRender="panelCoAdministration"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panCoAdministration" style="width:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.datamodelCoConfig}" styleClass="bg" style="margin-top:5px;border:1px solid green" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" height="250px" width="500px"  var="coadm">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.selectionCoConfig}"/>
                            <rich:column width="100%" sortable="false" >
                                <f:facet name="header" ><h:outputText value="Fonctions" style="border:0px"/></f:facet>
                                <h:outputText  value="#{coadm.libelle_FR}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <h:panelGroup id="btnCoAdministration">
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerFonction}" image="/images/valider_big.png" reRender="panelCoAdministration,p1"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoOff" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelOffice}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelOffice}" var="off">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS OFFICE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleOffice}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoOff"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoOffice" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtOff" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoOff}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoOfficeItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoOff}" reRender="seriAjtOff,inptlibeAjtOff,inptNatuAjtOff,btnChronoOff"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtOff" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtOff" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoOff">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoOff}" image="/images/valider_big.png" id="btvaldOff" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoOff}" reRender="panelChronoOff,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode6" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoCpt" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelCpt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelCpt}" var="cpt">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS COMPTABILITE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleCpt}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoCpt"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoCpt" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtCpt" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoCpt}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoComptaItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoCpt}" reRender="seriAjtCpt,inptlibeAjtCpt,inptNatuAjtCpt,btnChronoCpt"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtCpt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtCpt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoCpt">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoCpt}" image="/images/valider_big.png" id="btvaldCpt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoCpt}" reRender="panelChronoCpt,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode61" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoAch" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelAchat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelAchat}" var="ach">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS ACHATS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleAchat}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoAch"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormChronoAchat">
                <h:panelGrid id="panChronoAchat" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtAch" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoAch}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoAchatsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoAch}" reRender="seriAjtAch,inptlibeAjtAch,inptNatuAjtAch,inptserieAjtAch,btnChronoAch"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Maj autorisée sans annulation ni suppression" itemValue="0"/>
                            <f:selectItem itemLabel="Maj + Annulation Bon encaissement" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=19}"/>
                            <f:selectItem itemLabel="Maj + Suppression Bon encaissement" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=19}"/>
                            <f:selectItem itemLabel="Maj + Suppression et Annulation Bon encaissement" itemValue="4" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=19}"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoAchat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoAch">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoAch}" image="/images/valider_big.png" id="btvaldAjt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoAch}" reRender="panelChronoAch,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode2" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoVte" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelVente}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelVente}" var="vte">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS VENTES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleVente}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoVte"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormChronoVentes">
                <h:panelGrid id="panChronoVentes" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtVte" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoVte}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoVentesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoVte}" reRender="seriAjtVte,inptlibeAjtVte,inptNatuAjtVte,inptserieAjtVte,btnChronoVte"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Maj autorisée sans annulation ni suppression" itemValue="0"/>
                            <f:selectItem itemLabel="Maj + Annulation Bon encaissement" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=29}"/>
                            <f:selectItem itemLabel="Maj + Supression Bon encaissement" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=29}"/>
                            <f:selectItem itemLabel="Maj + Suppression et Annulation Bon encaissement" itemValue="4" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=29}"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoVentes" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column >
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoVte">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoVte}" image="/images/valider_big.png" id="btvaldVte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoVte}" reRender="panelChronoVte,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode3" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoCaisse" width="750" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelCaisse}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelCaisse}" var="cai">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS CAISSES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleCaisse}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoCaisse"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoCaisse" cellspacing="3"  cellpadding="3" style="width:100%;">
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Sélection:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="seriAjtCaisse" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoCaisse}" >
                                <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoCaisseItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoCaisse}" reRender="gridModalCaiss,inptserieAjtCaisse,inptlibeAjtCaisse,inptNatuAjtCaisse,btnChronoCaisse,idOpe,panChronoCaisse,idopCais1,idopCais2,idopCais3,idopCais4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Série:"/></h:column>
                        <h:column>
                            <h:inputText readonly="true" id="inptserieAjtCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrSerie}" size="10"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Code caisse:" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==61)}"/>&nbsp;&nbsp;
                            <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrCodeCaisse}" size="10" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==61)}"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText readonly="true" id="inptlibeAjtCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" style="width:100%;"/></h:column>
                        <h:column><h:outputText value="Nature:"/></h:column>
                        <h:column><h:inputText readonly="true" id="inptNatuAjtCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="4" style="width:100%;">
                        <h:column><h:outputText value="Mise à jour:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                                <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                                <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                                <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                                <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                                <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                                <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Dé-validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                                <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Duplicata:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                                <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idopCais1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60}"><h:outputText value="Exécution opérations:"/></h:column>
                        <h:column id="idopCais2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60}">
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrExecution}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                                <f:selectItem itemLabel="Exécution opérations interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Exécution opérations autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idopCais3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60}"><h:outputText value="Accès journal caisse:"/></h:column>
                        <h:column id="idopCais4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60}">
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrJournal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                                <f:selectItem itemLabel="Accès journal interdite" itemValue="0"/>
                                <f:selectItem itemLabel="Accès journal autorisée" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idOpe" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature==60}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieCaisse" width="100%" height="200px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.dataModelOperation}" var="ope">
                                <rich:column width="5%" sortable="true">
                                    <f:facet name="header" >
                                        <a4j:commandButton image="/images/allSelect.png" title="Tout/Rien sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.allSelect}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieCaisse"/>
                                    </f:facet>
                                    <h:selectBooleanCheckbox value="#{ope.select}"/>
                                </rich:column>
                                <rich:column width="10%" >
                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                    <h:outputText value="#{ope.caiopeCode}"/>
                                </rich:column>
                                <rich:column width="50%" >
                                    <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                    <h:outputText value="#{ope.caiopeNom}"/>
                                </rich:column>
                                <rich:column width="10%" >
                                    <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                                    <h:outputText value="#{ope.libMode}"/>
                                </rich:column>
                                <rich:column width="10%" >
                                    <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{ope.libType}"/>
                                </rich:column>
                                <rich:column width="15%" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Plafond"/></f:facet>
                                    <h:inputText id="idPlaf" value="#{ope.plafond}" style="width:90%;text-align:right;" disabled="#{!ope.select}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </rich:column>
                                <a4j:support event="onchange" reRender="idPlaf"/>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup id="btnChronoCaisse">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoCaisse}" image="/images/valider_big.png" id="btvaldCaisse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoCaisse}" reRender="panelChronoCaisse,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode4" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoPaye" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS PAYES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoPaye"  columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtPaye" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoPaye}" >
                            <f:selectItem itemLabel="Sélectionnez une nature" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoPayeItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoPaye}" reRender="panChronoPaye,inptserieAjtPaye,inptlibeAjtPaye,inptNatuAjtPaye,btnChronoPaye"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtPaye" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtPaye" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtPaye" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoPaye">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoPaye}" image="/images/valider_big.png" id="btvaldPaye" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoPaye}" reRender="panelChronoPaye,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode5" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoMed" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelMedical}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelMedical}" var="med">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS MEDICAUX"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleMedical}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoMed"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormChronoMedical">
                <h:panelGrid id="panChronoMedical" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtMed" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoMed}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoMedicalItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoMed}" reRender="seriAjtMed,inptlibeAjtMed,inptNatuAjtMed,inptserieAjtMed,btnChronoMed"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtMed" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtMed" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtMed" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Maj autorisée sans Annulation ni suppression" itemValue="0"/>
                            <f:selectItem itemLabel="Maj + Annulation Bon encaissement" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=79}"/>
                            <f:selectItem itemLabel="Maj + Suupression Bon encaissement" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=79}"/>
                            <f:selectItem itemLabel="Maj + Suppression et Annulation Bon encaissement" itemValue="4" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature!=79}"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoVentes" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column >
                        <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après enregistrement + paiement" itemValue="4"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoMed">
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoMed}" image="/images/valider_big.png" id="btvaldMed" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoMed}" reRender="panelChronoMed,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode7" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoPar" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelParc}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.showModalPanelParc}" var="prc">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS PARC"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.annuleParc}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoPar"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoParc" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Sélection:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="seriAjtPar" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.inputChronoPar}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.mesChronoParcItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.verifChronoPar}" reRender="seriAjtPar,inptlibeAjtPar,inptNatuAjtPar,inptserieAjtPar,btnChronoPar"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtPar" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtPar" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtPar" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoParc" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column >
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.usersChrono.usrchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoPar">
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.validerChronoPar}" image="/images/valider_big.png" id="btvaldPar" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_aff_val_chronoPar}" reRender="panelChronoPar,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode10" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>

