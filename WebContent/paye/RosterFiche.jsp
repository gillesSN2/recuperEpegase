<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheroster">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="FICHE INDIVIDUELLE D'UN ROSTER" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

            <rich:tab name="identification" label="Identification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_identification}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationIdentification}" reRender="panDescription"/>
                <h:panelGrid id="panDescription" width="100%">
                    <h:panelGrid width="100%">
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="panelId1">
                            <h:column><h:outputText style="border:0px;color:red;text-decoration:underline;" value="Nature:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="border:0px;color:red;width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="border:0px;color:red" value="Matricule:"/></h:column>
                            <h:column>
                                <h:inputText style="border:0px;color:red;width:40%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMatricule}" readonly="true"/>&nbsp;&nbsp;
                                <h:graphicImage  value="/images/cadenas_op.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege==0}"/>
                                <h:graphicImage  value="/images/cadenas_cl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege==1}"/>&nbsp;
                                <a4j:commandButton style="border:0px;color:red;width:40%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.lib_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visuEtat}" reRender="panelVisuEtat"/>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCivilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCiviliteItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeGenreCivil}" reRender="panelId1,idGenre,idLjf,idSjf"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Genre:"/></h:column>
                            <h:column>
                                <h:selectOneRadio id="idGenre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salGenre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}" style="width:200px">
                                    <f:selectItem itemLabel="Femme" itemValue="0"/>
                                    <f:selectItem itemLabel="Homme" itemValue="1"/>
                                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.afficheNomJf}" reRender="panelId1,idLjf,idSjf"/>
                                </h:selectOneRadio>
                            </h:column>
                            <h:column><h:outputText value="Nom:"/></h:column>
                            <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNom}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Prénom:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPrenom}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                            <h:column><h:outputText id="idLjf" value="Nom Jeune fille:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_nomJf}"/></h:column>
                            <h:column><h:inputText id="idSjf" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNomJf}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_nomJf}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLangue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesLanguesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salAdresse}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Boite Postale:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salBp}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salVille}"  maxlength="50"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays de résidence:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNompays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesPaysItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Nationnalité:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idNation" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNationnalite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNationnalitesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid styleClass="fichefournisseur" width="100%">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Téléphone bur.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salTelBur}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Téléphone dom.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salTelDom}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mobile 1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCel1}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mobile 2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCel2}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mobile 3:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCel3}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Aol:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salAol}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Yahoo:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salYahoo}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Msn:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMsn}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSkype}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mail:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMail1}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idDispoMobile">
                        <h:column><h:outputText value="Disponible:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDisponible}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                <f:selectItem itemLabel="Disponible" itemValue="0"/>
                                <f:selectItem itemLabel="Non disponible" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText id="idDispo1" value="Période A partir du:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDisponible==1}"/></h:column>
                        <h:column>
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" inputSize="8" style="background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDispoDu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/>&nbsp;&nbsp;
                            <h:outputText value="Jusqu'au:"/>&nbsp;
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" inputSize="8" style="background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDispoAu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/>
                        </h:column>
                        <h:column><h:outputText value="Mobile:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMobile}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                <f:selectItem itemLabel="Mobile" itemValue="0"/>
                                <f:selectItem itemLabel="Mobile sauf" itemValue="1"/>
                                <f:selectItem itemLabel="Non Mobile" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idDispoMobile,idExcep1,idExcep2"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText id="idExcep1" value="Exception:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMobile!=0}"/></h:column>
                        <h:column><h:inputText id="idExcep2" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMobileSauf}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMobile!=0}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab name="familial" label="Familial" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_familial}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationFamilial}" reRender="panFamilial"/>
                <h:panelGrid id="panFamilial" width="100%">
                    <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                    <h:panelGrid columns="4" id="idSitFam" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                        <h:column><h:outputText value="Situation matrimoniale:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                <f:selectItem itemLabel="Célibataire" itemValue="0" />
                                <f:selectItem itemLabel="Marié(e)" itemValue="1" />
                                <f:selectItem itemLabel="Concubin(e)" itemValue="2" />
                                <f:selectItem itemLabel="Pacsé(e)" itemValue="3" />
                                <f:selectItem itemLabel="Divorcé(e)" itemValue="4" />
                                <f:selectItem itemLabel="Veuf(ve)" itemValue="5" />
                                <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculNbParts}" reRender="idSitFam,idNbEnfants,idNbFemme,nbPartFiscal,idNbpartTrimf,idD0,idD1,idD2,idD3,idD4,idD5,idD6"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid styleClass="fichefournisseur1" width="100%" >
                        <h:panelGroup id="gridTof" >
                            <f:facet name="header"><h:outputText style="color:green;" value="Photo:"/></f:facet>
                            <center>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPhoto!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.urlIp}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.urlphotoAgent}" width="100px" height="100px"/>
                                    <a4j:commandButton image="/images/annuler.gif" title="Supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.reInitPhoto}" reRender="gridTof" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo?')) return false" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPhoto==null}">
                                    <img alt="" src="images/no_photo.jpeg" width="100px" height="100px" />
                                </c:if>
                            </center>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <center>
                                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.uploadedFile}" accept="image/*"/>
                                <h:commandButton  value="Sauvegarder" styleClass="retour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajoutPhoto}" />
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab name="activite" label="Domaine expertise" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_identification}">
                <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                <h:panelGrid width="80%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Communications."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Democratic Governance."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Disaster Risk Reduction."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="EVAW/GBV."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct5}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Extractives."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct6}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Facilitation/Moderation."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct7}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Gender & Development."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct8}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Gender Responsive Budgeting."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct9}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Governance & Leadership."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct10}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Graphics."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct11}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="HIV/AIDS."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct12}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Human Rights."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct13}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Humanitarian."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct14}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="ICT."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct15}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Knowledge Management."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct16}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Monitoring & Evaluation."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct17}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Nutrition  specialist."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct18}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Operations."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct19}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Organizational Development."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct20}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Peace & Security."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct21}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Programme Management."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct22}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Rapporteur."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct23}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Resource Mobilization."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct24}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Rule of law and gender."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct25}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Strategic planning."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct26}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Translator/Interpreter."/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDomAct27}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Women Economic Empowerment."/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_service}"><h:outputText value="Service."/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.affiche_service}">
                        <h:selectOneMenu id="idProgramme" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Profession."/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProfession}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="panPdf" columns="2" styleClass="fichefournisseur1" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0}">
                    <f:facet name="header"><h:outputText value="Curriculum Vitae"/></f:facet>
                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affFicPdf}">
                        <t:inputFileUpload id="filePdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.uploadedPDFFile}"/>
                        <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.submitCV}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                            <a4j:support eventsQueue="maQueue"  immediate="true"/>
                        </h:commandButton>
                        <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                    </h:panelGroup>
                    <br/>
                    <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affFicPdf}">
                        <h:outputText value="C.V.:"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDocument}" />&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/download.png" style="height:15px;width:15px;" title="Télécharger le document" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.downloadCV}" />&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/detail.png" style="height:15px;width:15px;" title="Lire le document" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.voirCV}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/annuler.gif" style="height:15px;width:15px;" title="Supprimer le document" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce CV?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.reInitCV}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/>
                    </h:panelGroup>
                </h:panelGrid>
            </rich:tab>

            <rich:tab name="expérience" label="Expériences" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_identification}">
                <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                    <h:column><h:outputText value="Nombre d'année d'expérience:"/></h:column>
                    <h:column>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbAnnee}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="de 0 à 2 ans" itemValue="0"/>
                            <f:selectItem itemLabel="de 5 à 10 ans" itemValue="1"/>
                            <f:selectItem itemLabel="Au-delà de 10 ans" itemValue="2"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid style="width:100%;" id="panelTexteContrat">
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salActivite}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                    </rich:editor>
                </h:panelGrid>
            </rich:tab>

            <rich:tab name="langues" label="Langues" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_identification}">
                <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="ANGLAIS"/></f:facet>
                    <h:column><h:outputText value="Lecture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salUsLire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Ecriture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salUsEcrire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dialogue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salUsParler}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="FRANCAIS"/></f:facet>
                    <h:column><h:outputText value="Lecture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salFrLire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Ecriture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salFrEcrire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dialogue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salFrParler}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="LANGUE LOCALE"/></f:facet>
                    <h:column><h:outputText value="Lecture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLocLire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Ecriture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLocEcrire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dialogue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLocParler}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                            <f:selectItem itemLabel="Non" itemValue="0" />
                            <f:selectItem itemLabel="Passable" itemValue="1" />
                            <f:selectItem itemLabel="Correct" itemValue="2" />
                            <f:selectItem itemLabel="Excellent" itemValue="3" />
                            <f:selectItem itemLabel="Interprête" itemValue="4" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </rich:tab>

            <rich:tab name="mission" label="Missions" rendered="false">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationBulletins}" reRender="panMissions"/>
                <h:panelGrid id="panMissions" width="100%">
                    <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup id="panelValide">
            <center>
                <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annuler}" reRender="idSubView"/>&nbsp;&nbsp;
                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveSalaries}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action!=3}" reRender="idSubView"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelVisuEtat" width="800" height="600" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalVisuEtat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalVisuEtat}" var="vet">
            <f:facet name="header"><h:outputText value="VISUALISATION ETAT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanVisuEtat" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerVisuEtat}" styleClass="hidelink" reRender="panelVisuEtat"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanVisuEtat')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:outputText value="Etat"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.lib_etat}" readonly="" style="width:100%"/>
                <h:outputText value="Date de sortie (JJ/MM/AAAA)"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateSortie}" readonly="true"/>
                <h:outputText value="Motif"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMotifSortie}" readonly="true" style="width:100%"/>
            </a4j:form>
        </c:if>
    </rich:modalPanel>
                        
    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>  

   <rich:modalPanel domElementAttachment="parent"  id="panalVisuCV" width="800" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPdf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPdf}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du CV"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerVisuPdf}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuCV"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" width="800" height="600">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
