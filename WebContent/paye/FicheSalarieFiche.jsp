<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichesalaries">

    <a4j:form id="agentFiche" enctype="multipart/form-data">

        <center><h2><h:outputText value="FICHE INDIVIDUELLE D'UN AGENT" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanelGlobal" width="100%" >

            <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

                <rich:tab name="identification" label="Identification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_identification}">

                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationIdentification}" reRender="panDescription"/>
                    <h:panelGrid id="panDescription" width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="panelId1">
                                <h:column><h:outputText style="border:0px;color:red;text-decoration:underline;" value="Nature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="border:0px;color:red;width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature}" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!=null)||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="border:0px;color:red" value="Matricule:"/></h:column>
                                <h:column>
                                    <h:inputText style="border:0px;color:red;width:40%;text-align:center" id="idMatricule" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMatricule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMatricule==''}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.optionPaye.chronoMatricule!='1'}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeUnicite}" reRender="panelValide,idMatricule"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:graphicImage  value="/images/cadenas_op.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege==0}"/>
                                    <h:graphicImage  value="/images/cadenas_cl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege==1}"/>&nbsp;
                                    <a4j:commandButton style="border:0px;color:red;width:40%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.lib_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visuEtat}" reRender="panelVisuEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPaye==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPaye==5)}"/>
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
                                <h:column><h:outputText value="Rue N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salRue}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Lot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLot}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Localisation:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <f:selectItem itemLabel="Quartier" itemValue="0"/>
                                        <f:selectItem itemLabel="Centre ville" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Porte N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPorte}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Quartier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salQuartier}" maxlength="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Commune:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCommune}" maxlength="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Zone:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salZone}" maxlength="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Département:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDeparte}" maxlength="30" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Bâtiment:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salBatiment}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Escalier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salEscalier}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Boite Postale:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salBp}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Etage:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salEtage}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salVille}"  maxlength="50"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNompays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesPaysItems}" />
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
                                <h:column>
                                    <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCel1}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 2:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCel2}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 3:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCel3}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
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
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="complement" label="Complément" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_complement}" >
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationComplement}" reRender="panComplement"/>
                    <h:panelGrid id="panComplement" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                            <h:column><h:outputText value="Né(e) le:"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateNaissance}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Lieu naissance:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLieuNaissance}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Pays naissance:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPaysNaissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesPaysItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeNationPays}" reRender="idNation" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Nationnalité:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idNation" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNationnalite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNationnalitesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'}">
                            <h:column><h:outputText value="Groupe Ethnique:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salEthnie}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Nom du père:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPere}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Nom J.F. mère:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMere}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="N° carte identité:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumCi}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Délivrée à:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salLieuCi}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Par:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDelivreCi}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Date délivrance (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateCi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Approbation inspection travail:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salApprobInsp}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Visa enregistrement:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salVisaEnreg}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Date d'entrée au pays (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateEntreePays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Profession:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProfession}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Date début impôt (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateImpot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Date 1ere embauche (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateEntreeInitial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur1" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column><h:outputText value="Identification fiscale:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumFiscal}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.libelle_securite}:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumSecu}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Date affiliation (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateSecu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° C.N.A.M.G.S.:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumCnamgs}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Date affiliation (JJ/MM/AAAA):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.libelle_retraite}:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumRetraite}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Date affiliation (JJ/MM/AAAA):"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateRetraite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value="N° A.M.O.:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumAmo}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value="Date affiliation (JJ/MM/AAAA):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateAmo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value="N° Allocataire:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumAllocataire}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><h:outputText value="Date affiliation (JJ/MM/AAAA):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0138'}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateAllocataire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'}">
                            <h:column><h:outputText value="Classe recrutement:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salClasseRecrut}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Service militaire effctué:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salServiceMil}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Corps d'appartenance:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCoprsApp}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Grade réserviste:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salGrade}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idDispoMobile" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'}">
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

                <rich:tab name="paiement" label="Paiement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_complement}" >
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationComplement}" reRender="panPaiement"/>
                    <h:panelGrid id="panPaiement" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column><h:outputText value="Mode de paiement:"/></h:column>
                            <h:column>
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                    <f:selectItem itemLabel="Espèce" itemValue="0"/>
                                    <f:selectItem itemLabel="Cheque" itemValue="1"/>
                                    <f:selectItem itemLabel="Virement" itemValue="2"/>
                                    <f:selectItem itemLabel="Carte pré-payée" itemValue="3"/>
                                    <f:selectItem itemLabel="Miro-finance" itemValue="4"/>
                                    <f:selectItem itemLabel="Mobile" itemValue="5" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesOrange}"/>
                                    <f:selectItem itemLabel="Autre" itemValue="9"/>
                                    <a4j:support eventsQueue="maQueue" event="onclick" reRender="panPaiement"/>
                                </h:selectOneRadio>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="8" styleClass="fichefournisseur"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement==4}">
                            <h:column><h:outputText value="Code banque:"/></h:column>
                            <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Code guichet:"/></h:column>
                            <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salGuichetBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="N° compte:"/></h:column>
                            <h:column><h:inputText size="12" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Clé Ctrl:"/></h:column>
                            <h:column><h:inputText size="2" maxlength="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCleBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement==2}">
                            <h:column><h:outputText value="IBAN:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salIban}" maxlength="34" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="SWIFT:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSwift}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement==3}">
                            <h:column><h:outputText value="Code banque:"/></h:column>
                            <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                            <h:column><h:outputText value="N° carte:"/></h:column>
                            <h:column><h:inputText size="15" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement==4}">
                            <h:column><h:outputText value="N° compte du membre:"/></h:column>
                            <h:column><h:inputText size="20" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteMembre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salModeReglement==5}">
                            <h:column><h:outputText value="N° téléphone mobile:"/></h:column>
                            <h:column><h:inputText size="15" maxlength="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="familial" label="Familial" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_familial}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationFamilial}" reRender="panFamilial"/>
                    <h:panelGrid id="panFamilial" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                        <h:panelGrid columns="4" id="idSitFam" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column><h:outputText value="Situation matrimoniale:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}">
                                    <f:selectItem itemLabel="Célibataire" itemValue="0" />
                                    <f:selectItem itemLabel="Marié(e)" itemValue="1" />
                                    <f:selectItem itemLabel="Concubin(e)" itemValue="2" />
                                    <f:selectItem itemLabel="Pacsé(e)" itemValue="3" />
                                    <f:selectItem itemLabel="Divorcé(e)" itemValue="4" />
                                    <f:selectItem itemLabel="Veuf(ve)" itemValue="5" />
                                    <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculNbParts}" reRender="idSitFam,idNbEnfants,idNbFemme,nbPartFiscal,idNbpartTrimf,idD0,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMiseRelation}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==0}"><h:outputText id="idD0" value="Participe au programme de mise en relation"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille>=1}"><h:outputText id="idD1" value="Date (JJ/MM/AAAA)"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==1}"><rich:calendar id="idD2"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateMarie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==2}"><rich:calendar id="idD3"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateConcubinage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==3}"><rich:calendar id="idD4"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDatePacs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==4}"><rich:calendar id="idD5"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateDivorce}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salSitFamille==5}"><rich:calendar id="idD6"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateVeuf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Nb Enfants:"/></h:column>
                            <h:column>
                                <h:inputText id="idNbEnfants" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbEnfant}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}">
                                    <a4j:support eventsQueue="maQeueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculNbParts}" reRender="idSitFam,idNbEnfants,idNbFemme,nbPartFiscal,idNbpartTrimf,idD0,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb Parts:"/></h:column>
                            <h:column><h:inputText id="nbPartFiscal" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbPartFiscal}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}"/></h:column>
                            <h:column><h:outputText value="Nb Parts TRIMF:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}"/></h:column>
                            <h:column>
                                <h:inputText id="idNbpartTrimf" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbPartTrimf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}">
                                    <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculNbParts}" reRender="idSitFam,idNbEnfants,idNbFemme,nbPartFiscal,idNbpartTrimf,idD0,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Nb Femmes:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salGenre==1}"/></h:column>
                            <h:column>
                                <h:inputText id="idNbFemme" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbFemme}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salGenre==1}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}">
                                    <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculNbParts}" reRender="idSitFam,idNbEnfants,idNbFemme,nbPartFiscal,idNbpartTrimf,idD0,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Régime congés:"/></h:column>
                            <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbJourCp}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                            <h:column><h:outputText value="Nb jours travail:"/></h:column>
                            <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNbJourTr}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nouvelleCreation}"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
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

                <rich:tab name="contratSt" label="Contrat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesContrats&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesContratsProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_contrat}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationContrat}" reRender="panContrat"/>
                    <jsp:include flush="true" page="/paye/MesContrats.jsp"/>
                </rich:tab>

                <rich:tab name="contratJr" label="Contrat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature=='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesContrats&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesContratsProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_contrat}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationContrat}" reRender="panContrat"/>
                    <jsp:include flush="true" page="/paye/MesContratsJournalier.jsp"/>
                </rich:tab>

                <rich:tab name="compta" label="Comptabilité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_familial}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationFamilial}" reRender="panComptablite"/>
                    <h:panelGrid id="panComptabilite" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                        <h:panelGrid columns="4" id="idCpte" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column><h:outputText value="Compte Net à payer:"/></h:column>
                            <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteNet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Compte Acomptes:"/></h:column>
                            <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteAcompte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Compte Avances:"/></h:column>
                            <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteAvance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Compte Prêts Internes:"/></h:column>
                            <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salComptePretInt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Compte Prêts Externes:"/></h:column>
                            <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salComptePretExt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Compte SAGE"/></h:column>
                            <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCompteSage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="grh" label="G.R.H" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesRhProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_grh}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationGrh}" reRender="panGrh"/>
                    <h:panelGrid id="panGrh" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                        <h:panelGrid width="250px" id="panelBoutonRh" columns="4"  style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Ajouter un nouveau élément R.H." image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterRh}" reRender="panelRh"/>
                            <a4j:commandButton title="Modifier l'élément R.H. sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_rh&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierRh}" reRender="panelRh"/>
                            <a4j:commandButton title="Consulter l'élément R.H. sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_rh}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterRh}" reRender="panelRh"/>
                            <a4j:commandButton title="Supprimer l'élément R.H. sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_rh&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerRh}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonRh,tableRh"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableRh" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelGrh}" var="rh" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.simpleSelectionEnteteGrh}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.extDTableGrh}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionRh}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonRh,panelRh"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visualisationFicheRh}" reRender="panelBoutonRh,panelRh"/>
                                <rich:column label="Nature de l'élément R.H." sortable="true" width="10%" sortBy="#{rh.lib_nature} #{rh.lib_type} #{rh.salgrhDate}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                    <h:outputText value="#{rh.lib_nature}"/>
                                </rich:column>
                                <rich:column label="Type de l'élément R.H." sortable="true" width="20%" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                    <h:outputText value="#{rh.lib_type}"/>
                                </rich:column>
                                <rich:column label="Date de l'élément R.H." sortable="true" width="15%" sortOrder="#{rh.salgrhDate}">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{rh.salgrhDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="N° identification" sortable="true" width="15%" sortOrder="#{rh.libReference}">
                                    <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                    <h:outputText value="#{rh.libReference}"/>
                                </rich:column>
                                <rich:column label="Visualisation document" id="idVisu" width="3%" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Doc." /></f:facet>
                                    <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.voirPdf}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panalVisuPj" rendered="#{rh.salgrhDocument!=null}" ></a4j:commandButton>
                                </rich:column>
                                <rich:column label="Description" sortable="true" width="60%" sortOrder="#{rh.libDescription}">
                                    <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                                    <h:outputText value="(P.Fis.)  " style="#{rh.protege}" rendered="#{rh.salgrhFiscal==0&&rh.salgrhType==15}"/>
                                    <h:outputText value="(Trav.)  " style="#{rh.protege}" rendered="#{rh.salgrhTravail==0&&rh.salgrhType==16}"/>
                                    <h:outputText value="#{rh.libDescription}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="conges" label="Congés" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesConges&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_conges}">
                    <h:panelGrid id="panConges" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                        <h:panelGrid width="100%" columns="8" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Nb jour Initial:"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nbInit}"/></h:column>
                            <h:column><h:outputText value="Nb jour Acquis:"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nbAcquis}"/></h:column>
                            <h:column><h:outputText value="Nb jour Pris:"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nbPris}"/></h:column>
                            <h:column><h:outputText value="Nb jour Restant:"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nbRestant}"/></h:column>
                        </h:panelGrid>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableConges" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelConges}" var="cp">
                                <rich:column label="Nature du congé" sortable="true" width="20%" sortOrder="#{cp.lib_nature}">
                                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                    <h:outputText value="#{cp.lib_nature}"/>
                                </rich:column>
                                <rich:column label="Etat du congé" sortable="true" width="10%" sortOrder="#{cp.salgrhEtat}">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:outputText value="#{cp.libelleEtat}" id="idEtatConge"/>
                                </rich:column>
                                <rich:column label="Date départ en congé" sortable="true" width="10%" sortOrder="#{cp.salcngDateDebut}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Départ" /></f:facet>
                                    <h:outputText value="#{cp.salcngDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date retour de congé" sortable="true" width="10%" sortOrder="#{cp.salcngDateFin}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Retour" /></f:facet>
                                    <h:outputText value="#{cp.salcngDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Durée" sortable="true" width="10%" sortOrder="#{cp.salcngDuree}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Durée" /></f:facet>
                                    <h:outputText value="#{cp.salcngDuree}"/>
                                </rich:column>
                                <rich:column label="Description" sortable="true" width="20%" sortOrder="#{cp.salcngObjet}">
                                    <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                                    <h:outputText value="#{cp.salcngObjet}"/>
                                </rich:column>
                                <rich:column label="Nature" sortable="true" width="20%" sortOrder="#{cp.lib_nature}">
                                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                    <h:outputText value="#{cp.lib_nature}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="absences" label="Absences" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAbsences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_absences}">
                    <h:panelGrid id="panAbsences" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableAbsences" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelAbsences}" var="abs">
                                <rich:column label="Nature de l'absence" sortable="true" width="20%" sortOrder="#{abs.lib_nature}">
                                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                    <h:outputText value="#{abs.lib_nature}"/>
                                </rich:column>
                                <rich:column label="Etat de l'absence" sortable="true" width="10%" sortOrder="#{abs.salgrhEtat}">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:outputText value="#{abs.libelleEtat}" id="idEtatAbsence"/>
                                </rich:column>
                                <rich:column label="Date de l'absence" sortable="true" width="10%" sortOrder="#{abs.salcngDateDebut}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{abs.salcngDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date retour de l'absence" sortable="true" width="10%" sortOrder="#{abs.salcngDateFin}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Retour" /></f:facet>
                                    <h:outputText value="#{abs.salcngDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Durée" sortable="true" width="10%" sortOrder="#{abs.salcngDuree}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Durée" /></f:facet>
                                    <h:outputText value="#{abs.salcngDuree}"/>
                                </rich:column>
                                <rich:column label="Description" sortable="true" width="30%" sortOrder="#{abs.salcngObjet}">
                                    <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                                    <h:outputText value="#{abs.salcngObjet}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="prets internes" label="Prêts int." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPrets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPretsProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_prets}">
                    <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                    <br>
                    <h:panelGrid id="panPretInt" width="100%" columns="2" columnClasses="clos50d,clos50g">
                        <h:panelGroup>
                            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsInternes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="230%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelPretsInternes}" var="prInt">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionPretsInternes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsInternes,tablePretsInternesLignes,idTotalInterne,panelBoutonPretsInternesLignes"/>
                                        <jsp:include flush="true" page="/paye/FicheSalariePretEnteteCommun.jsp"/>
                                    </rich:extendedDataTable>
                                    <h:panelGrid width="100%" style="height:35px"></h:panelGrid>
                                </a4j:region>
                            </div>
                        </h:panelGroup>
                        <h:panelGroup>
                            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsInternesLignes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="150%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelPretsLignes}" var="prLig1">
                                        <jsp:include flush="true" page="/paye/FicheSalariePretLigneCommun.jsp"/>
                                    </rich:extendedDataTable>
                                    <h:panelGrid columns="6" width="100%" id="idTotalInterne" style="height:35px">
                                        <h:column><h:outputText value="Total prêt:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_pret_interne}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Total remboursé:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_rmb_interne}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Reste dû:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.solde_pret_interne}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </a4j:region>
                            </div>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="prets externes" label="Prêts ext." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPrets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPretsProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_prets}">
                    <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                    <br>
                    <h:panelGrid id="panPretExt" width="100%" columns="2" columnClasses="clos50d,clos50g">
                        <h:panelGroup>
                            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsExternes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="230%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelPretsExternes}" var="prInt">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionPretsExternes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsExternes,tablePretsExternesLignes,idTotalExterne,panelBoutonPretsExternesLignes"/>
                                        <jsp:include flush="true" page="/paye/FicheSalariePretEnteteCommun.jsp"/>
                                    </rich:extendedDataTable>
                                    <h:panelGrid width="100%" style="height:35px"></h:panelGrid>
                                </a4j:region>
                            </div>
                        </h:panelGroup>
                        <h:panelGroup>
                            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsExternesLignes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="150%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelPretsLignes}" var="prLig1">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionPretsLignes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsExternesLigne"/>
                                        <jsp:include flush="true" page="/paye/FicheSalariePretLigneCommun.jsp"/>
                                    </rich:extendedDataTable>
                                    <h:panelGrid columns="6" width="100%" id="idTotalExterne" style="height:35px">
                                        <h:column><h:outputText value="Total prêt:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_pret_externe}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Total remboursé:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_rmb_externe}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Reste dû:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.solde_pret_externe}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </a4j:region>
                            </div>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="prets manuels" label="Prêts man." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPrets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPretsProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_prets}">
                    <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                    <br>
                    <h:panelGrid id="panPretMan" width="100%" columns="2" columnClasses="clos50d,clos50g">
                        <h:panelGroup>
                            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsManuels" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="230%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelPretsManuels}" var="prInt">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionPretsManuels}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsManuels,tablePretsManuelsLignes,idTotalManuel,panelBoutonPretsManuelsLignes"/>
                                        <jsp:include flush="true" page="/paye/FicheSalariePretEnteteCommun.jsp"/>
                                    </rich:extendedDataTable>
                                    <h:panelGrid width="100%" style="height:35px"></h:panelGrid>
                                </a4j:region>
                            </div>
                        </h:panelGroup>
                        <h:panelGroup>
                            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsManuelsLignes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="150%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelPretsLignes}" var="prLig1">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionPretsLignes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsManuelsLigne"/>
                                        <jsp:include flush="true" page="/paye/FicheSalariePretLigneCommun.jsp"/>
                                    </rich:extendedDataTable>
                                    <h:panelGrid columns="6" width="100%" id="idTotalManuel" style="height:35px">
                                        <h:column><h:outputText value="Total prêt:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_pret_manuel}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Total remboursé:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_rmb_manuel}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Reste dû:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.solde_pret_manuel}" readonly="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </a4j:region>
                            </div>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="capitalisation" label="Epargne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.capitalisationActive&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPrets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesPretsProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_prets}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationPrets}" reRender="panCapitalisation"/>
                    <h:panelGrid id="panCapitalisation" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
                        <h:panelGroup>
                            <h:panelGrid width="150px" id="panelBoutonCapitalisation" columns="3" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                                <a4j:commandButton title="Ajouter une nouvelle capitalisation" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapId==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterCapitalisation}" reRender="panCapitalisation,panelCapitalisation,idlisteCapitalisation"/>
                                <a4j:commandButton title="Modifier la capitalisation" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierCapitalisation}" reRender="panCapitalisation,panelCapitalisation,idlisteCapitalisation"/>
                                <a4j:commandButton title="Supprimer la capitalisation" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerCapitalisation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonCapitalisation,panelCapitalisation,tableCapitalisation,panCapitalisation,idlisteCapitalisation"/>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapId!=0}">
                                <h:column><h:outputText value="Montant initial:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapInitial}" size="5" style="text-align:right" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Montant Versement:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapMontant}" size="5" style="text-align:right" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGroup id="idlisteCapitalisation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapId!=0}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable border="0" enableContextMenu="false" id="tableCapitalisation" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelCapitalisation}" var="cap">
                                    <rich:column label="N° Contrat" sortable="false" width="80px">
                                        <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                                        <h:outputText value="#{cap.bulletinSalaire.bulsalContrat}"/>
                                    </rich:column>
                                    <rich:column label="Date opération" sortable="false" width="100px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{cap.bulletinSalaire.bulsalDateDebut}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant versement" sortable="false" width="120px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Versements" /></f:facet>
                                        <h:outputText value="#{cap.recette}" rendered="#{cap.recette!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant retrait" sortable="false" width="120px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Retraits" /></f:facet>
                                        <h:outputText value="#{cap.depense}" rendered="#{cap.depense!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                                <h:panelGrid columns="6" width="100%" id="idTotalCapitalisation" style="height:35px">
                                    <h:column><h:outputText value="Total versement:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_versement}" readonly="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Total retrait:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.total_retrait}" readonly="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Solde:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.solde_capitalisation}" readonly="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </a4j:region>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="mission" label="Missions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesMissions&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_bulletins}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationBulletins}" reRender="panMissions"/>
                    <h:panelGrid id="panMissions" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="historique" label="Historique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature!='04'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_bulletins}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationBulletins}" reRender="panHistorique"/>
                    <h:panelGrid id="panHistorique" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                        <h:panelGrid width="250px" id="panelBoutonHistorique" columns="4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Ajouter un nouvel historique" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterHistorique}" reRender="panelHistorique"/>
                            <a4j:commandButton title="Modifier l'historique sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_historique&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierHistorique}" reRender="panelHistorique"/>
                            <a4j:commandButton title="Consulter l'historique sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_historique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterHistorique}" reRender="panelHistorique"/>
                            <a4j:commandButton title="Supprimer l'historique sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_historique&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerHistorique}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonHistorique,tableHistorique"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableHistorique" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelHistorique}" var="histo">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionHistorique}" reRender="panelBoutonHistorique"/>
                                <rich:column label="Date historique" sortable="true" width="10%" sortOrder="#{histo.salhisDate}">
                                    <f:facet name="header"><h:outputText  value="Historique" /></f:facet>
                                    <h:outputText value="#{histo.salhisDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Contrat" sortable="true" width="10%" sortOrder="#{histo.salhisContrat}">
                                    <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                                    <h:outputText value="#{histo.salhisContrat}"/>
                                </rich:column>
                                <rich:column label="Code" sortable="true" width="10%" sortOrder="#{histo.salhisCode}">
                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                    <h:outputText value="#{histo.salhisCode}"/>
                                </rich:column>
                                <rich:column label="Libellé" sortable="true" width="60%" sortOrder="#{histo.salhisLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                    <h:outputText value="#{histo.salhisLibelle}"/>
                                </rich:column>
                                <rich:column label="Valeur" sortable="true" width="10%" sortOrder="#{histo.salhisValeurColE}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Valeur" /></f:facet>
                                    <h:outputText value="#{histo.salhisValeurColE}" style="text-align:right;" rendered="#{histo.salhisCode=='BRUT'||histo.salhisCode=='CP'||histo.salhisCode=='ADM'||histo.salhisCode=='PRDCP'}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{histo.salhisValeurColE}" style="text-align:right;" rendered="#{histo.salhisCode=='NBJS'}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="bulletin" label="Bulletins" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesBulletins&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesAutreProtege&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_acc_bulletins}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.autorisationBulletins}" reRender="panBulletins"/>
                    <h:panelGrid id="panBulletins" width="100%">
                        <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                        <h:panelGrid width="350px" id="panelBoutonBulletin" columns="4" style="height:34px">
                            <a4j:commandButton title="Consulter le bulletin généré" image="/images/bulletin.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.consulterBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
                            <a4j:commandButton title="Historique par rubriques du salarié sélectionné" image="/images/tableau.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.historiqueRubrique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelListeRubrique"/>
                            <a4j:commandButton title="Actualise les compteurs des congés et la base des congés" image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.actualiseCompteursConges}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,listeBulletin"/>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_num_contrat}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesContratsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.chargerBulletins}" reRender="panBulletins,listeBulletin"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelBulletin}" enableContextMenu="false" var="liste" id="listeBulletin" border="0" styleClass="bg" style="border:solid 0px green" width="100%" height="400px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.selectionBulletin}" reRender="panelBoutonBulletin"/>
                                <rich:column width="8%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Période"/></f:facet>
                                    <h:outputText value="#{liste.bulsalPeriode}"/>
                                </rich:column>
                                <rich:column width="8%" sortable="false">
                                    <f:facet name="header"><h:outputText value="Contrat"/></f:facet>
                                    <h:outputText value="#{liste.bulsalContrat}"/>
                                </rich:column>
                                <rich:column width="8%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Date début"/></f:facet>
                                    <h:outputText value="#{liste.bulsalDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="8%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Date fin"/></f:facet>
                                    <h:outputText value="#{liste.bulsalDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="9%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                                    <h:outputText value="#{liste.bulsalActivite}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Av. Nat."/></f:facet>
                                    <h:outputText value="#{liste.bulsalAvNat}" rendered="#{liste.bulsalAvNat!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="7%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="J.Acquis"/></f:facet>
                                    <h:inputText value="#{liste.bulsalNbCpAcquis}" rendered="#{liste.bulsalNbCpAcquis!=0}" style="text-align:right;width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <f:convertNumber groupingUsed="true" minFractionDigits="3" maxFractionDigits="3"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.recalculNbJourCP}" reRender="listeBulletin"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column width="7%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="J.Pris"/></f:facet>
                                    <h:inputText value="#{liste.bulsalNbCpPris}" rendered="#{liste.bulsalNbCpPris!=0}" style="text-align:right;width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <f:convertNumber groupingUsed="true" minFractionDigits="3" maxFractionDigits="3"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.recalculNbJourCP}" reRender="listeBulletin"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column width="7%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="J.Dispo."/></f:facet>
                                    <h:inputText value="#{liste.bulsalNbDispo}" rendered="#{liste.bulsalNbDispo!=0}" style="text-align:right;width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <f:convertNumber groupingUsed="true" minFractionDigits="3" maxFractionDigits="3"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.recalculNbJourCP}" reRender="listeBulletin"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column width="10%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Base Congés"/></f:facet>
                                    <h:inputText value="#{liste.bulsalBrut}" rendered="#{liste.bulsalBrut!=0}" style="text-align:right;width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.recalculBaseCP}" reRender="listeBulletin"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column width="10%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="C.P."/></f:facet>
                                    <h:outputText value="#{liste.bulsalCP}" rendered="#{liste.bulsalCP!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="10%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText value="Net"/></f:facet>
                                    <h:outputText value="#{liste.bulsalNetPayer}" rendered="#{liste.bulsalNetPayer!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annuler}" reRender="modAttente,idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveSalaries}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valideSalarie&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action!=3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanelGlobal,tabPanelsalaries,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelVisuEtat" width="400" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalVisuEtat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalVisuEtat}" var="vet">
            <f:facet name="header"><h:outputText value="VISUALISATION PROTECTION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanVisu" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerVisuEtat}" styleClass="hidelink" reRender="panelVisuEtat"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanVisu')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid columns="2" width="100%">
                    <h:outputText value="Mode protection"/>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege}">
                            <f:selectItem itemLabel="Sans protection" itemValue="0" />
                            <f:selectItem itemLabel="Avec protection" itemValue="1" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idCanVisu" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveProtectionSalaries}" reRender="panelVisuEtat,panelId1,tabPanelsalaries"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanVisu')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelContrat" width="1000" height="600"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelContrat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelContrat}" var="ctr">
            <f:facet name="header"><h:outputText value="GESTION DES CONTRATS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanContrat" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annulerContrat}" styleClass="hidelink" reRender="panelBoutonContrat,panelContrat"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanContrat')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <jsp:include flush="true" page="/paye/FicheSalarieContrat.jsp"/>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idValContrat" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveContrat}" reRender="panelBoutonContrat,tableContrat,panelContrat"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValContrat')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelRh" width="1000" height="600" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelRh}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelRh}" var="erh">
            <f:facet name="header"><h:outputText value="GESTION DES ELEMENTS R.H."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanRh" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annulerRh}" styleClass="hidelink" reRender="panelRh"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanRh')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid style="width:100%;" id="panRh">
                    <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Nature Elément R.H.:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                                <f:selectItem itemLabel="Sélectionnez type d'élément" itemValue="100" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesElementRhItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.chargerModeleSpe}" reRender="panRh,idRh,panelTexteRh" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <jsp:include flush="true" page="/paye/FicheSalarieRh.jsp" />
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValRh" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveRh}" reRender="panelBoutonRh,tableRh,panelRh"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRh')}.click()" />
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelHistorique" width="500" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelHistorique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelHistorique}" var="his">
            <f:facet name="header"><h:outputText value="GESTION DES HISTORIQUES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanHistorique" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annulerHistorique}" styleClass="hidelink" reRender="panelHistorique"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanHistorique')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" id="panHisto">
                    <jsp:include flush="true" page="/paye/FicheSalarieHistorique.jsp"/>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValHistorique" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveHistorique}" reRender="panelBoutonHistorique,tableHistorique,panelHistorique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_valide_historique}"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValHistorique')}.click()" />
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBulletin" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}" var="bul">
            <f:facet name="header"><h:outputText value="BULLETIN DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalPeriode} POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerConsulterBulletin}" styleClass="hidelink" reRender="panelBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieBulletins.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelListeRubrique" width="1350" height="520" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelListeRubrique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelListeRubrique}" var="rub">
            <f:facet name="header"><h:outputText value="LISTE DES RUBRIQUES POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom} - Exercice : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.exoselectionne.exepayId}"></h:outputText></f:facet>
            <f:facet name="controls">
                <h:form>
                    <a4j:commandButton id="idCanListeRubrique" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerlisteRubrique}" styleClass="hidelink" reRender="panelListeRubrique"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanListeRubrique')}.click()" />
                </h:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieRubriques.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPdf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPdf}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerVisuPdf}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelCapitalisation" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelCapitalisation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelCapitalisation}" var="capit">
            <f:facet name="header"><h:outputText value="CAPITALISATION POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanCapitalisation" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerCapitalisation}" styleClass="hidelink" reRender="panelCapitalisation"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanCapitalisation')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <jsp:include flush="true" page="/paye/FicheSalarieCapitalisation.jsp" />
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idValCapitalisation" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.validerCapitalisation}" reRender="panelBoutonCapitalisation,tableCapitalisation,panelCapitalisation,panCapitalisation,idlisteCapitalisation"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValCapitalisation')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
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

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
