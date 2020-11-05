<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="patientFiche">

    <a4j:form id="formPatientFiche" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText  styleClass="titre" value="FICHE : PATIENT" /></h2></center>

        <h:panelGrid id="panelTabFrniss" width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">

                <rich:tab label="Identité">
                    <h:panelGrid  width="100%" >
                        <h:panelGrid styleClass="fichefournisseur">
                            <h:panelGrid  width="100%">
                                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idPatIdent">
                                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCivilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.mesCivilitesItems}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.calculeGenre}" reRender="idPatIdent,idGenre,idjf1,idjf2"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Genre:"/></h:column>
                                    <h:panelGrid columns="3" width="100%" columnClasses="clos35,clos15g,clos50" id="idGenre">
                                        <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSexe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.verrouSexe}">
                                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPatIdent,idjf1,idjf2,idGenre"/>
                                        </h:selectOneRadio>
                                        <h:column>
                                            <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSexe==0}"/>
                                            <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSexe==1}"/>
                                        </h:column>
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patDossier}" readonly="true"/>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="Nom:" style="color:red"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Prénom:"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patPrenom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Surnom:"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSurnom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText id="idjf1" value="Nom jeune fille:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSexe==0}"/></h:column>
                                    <h:column><h:inputText id="idjf2" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patNomJf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSexe==0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Langue parlée:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patLangueParle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Site affecté:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"/></h:column>
                                    <h:column><h:inputText style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCommune}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Né(e) le (JJ/MM/AAAA):" style="color:red;"/></h:column>
                                    <h:column>
                                        <a4j:outputPanel layout="block" style="vertical-align:center;color:red;">
                                            <a4j:commandButton image="/images/dateNaissance.png" style="width:18px;height:18px;" title="Aide au calcul de la date naissance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.calculeDateNaissance}" reRender="panelDateNaissance"/>&nbsp;&nbsp;
                                            <rich:calendar id="idDateNaissance"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patDateNaissance}" popup="true"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/>
                                        </a4j:outputPanel>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu naissance:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patLieuNaissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                <h:column><h:outputText value="Adresse:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                                <h:column><h:outputText value="Rue N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patRue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ilot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Porte N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patPorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Quartier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patQuartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Bâtiment:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patBatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Escalier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patEtage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Boite Postale:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patBp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Cédex:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCedex}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patVille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                <h:column id="idpays">
                                    <h:selectOneMenu id="paysItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patPays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.mesPaysItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" width="100%">
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="N° C.I.:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="idCi" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCI}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCi"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="N° Passport:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="idPassport" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patPassport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUnicitePASSPORT}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idPassport"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Téléphone domicile:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText id="idDom" style="width:100%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patTelDom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteTelDom}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idDom"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Mobile 1:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText id="idCle1" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCel1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCle1"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 2:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText  id="idCle2" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCel2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCle2"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 3:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText  id="idCle3" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCel3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCle3"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Skype:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSkype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Mail 1:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patMail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:column><h:outputText style="width:100%;color:red;text-align:center" value="Les zones ROUGES sont obligatoires: le nom ET le genre ET la date de naissance ET (soit le téléphone domicile OU le mobile 1 OU le mobile 2 OU le mobile 3)"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Infos.complémentaires"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action>=1}"  >
                    <jsp:include flush="true" page="/medical/tiersPatientInfoComp.jsp" />
                </rich:tab>

                <rich:tab label="Prise en charge" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patIdCouvertPar==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action>=1}" reRender="pec,cs,ncs" >
                    <jsp:include flush="true" page="/medical/tiersPatientCommun.jsp" />
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}"><h:outputText value="N° de sécurité:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNSS:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSecu}" style="width:100%;" maxlength="20"/></h:column>
                        <h:column><h:outputText value="N° CNAMGS:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCnamgs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" style="width:95%;" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Utilisateur Payeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idUserPayeur" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patIdUserPaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                <f:selectItem itemLabel="Sans User payeur" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.mesUserItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Salarié Payeur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSalariePaiement}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid id="pec" width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid columns="2" width="60%" columnClasses="clos30,clo70d">
                            <h:column><h:outputText value="Mode prise en charge:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="pecItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patNomFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.mesPecItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectionTypePec}" reRender="pec,cs,ncs"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="cs" width="50%" columns="2" columnClasses="clos30,clo70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patNomFamille==-1}">
                            <h:column><h:outputText value="Cas social %:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patPourcentCasSocial}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="ncs" width="100%" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patNomFamille==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patNomFamille==-2)}">
                            <h:panelGrid  id="btnPec" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action!=3}">
                                <a4j:commandButton  image="/images/ajouter.png" title="Ajouter prise en charge"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.ajouterPec}" reRender="panelPec,btnPec"/>
                                <a4j:commandButton  image="/images/modifier.png" title="Modifier prise en charge"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.modifierPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.afficheButtPec}" reRender="panelPec,btnPec"/>
                                <a4j:commandButton  image="/images/detail.png" title="Consulter prise en charge"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consulterPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.afficheButtPec}" reRender="panelPec,btnPec"/>
                                <a4j:commandButton  image="/images/supprimer.png" title="Supprimer prise en charge" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.supprimerPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.afficheButtPec}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTablePec,btnPec"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTablePec" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.datamodelPec}" var="prisechge" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectionPec}" reRender="btnPec"/>
                                    <rich:column width="10%">
                                        <f:facet name="header"><h:outputText  value="Type"/></f:facet>
                                        <h:outputText value="#{prisechge.tiers.tiecategorie}"/>
                                    </rich:column>
                                    <rich:column width="16%">
                                        <f:facet name="header"><h:outputText value="Payeur"/></f:facet>
                                        <h:outputText  value="#{prisechge.tiers.tieraisonsocialenom}"/>
                                    </rich:column>
                                    <rich:column width="10%">
                                        <f:facet name="header"><h:outputText value="Employeur"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecNomEmployeur}"/>
                                    </rich:column>
                                    <rich:column width="7%">
                                        <f:facet name="header"><h:outputText  value="Du"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecDateDebut}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column width="7%">
                                        <f:facet name="header"><h:outputText  value="Au"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecDateFin}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column width="10%">
                                        <f:facet name="header"><h:outputText  value="N°Contrat"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecNumContrat}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText value="Heb1"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecHebergementPlaf}" rendered="#{prisechge.patpecHebergementPlaf!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText  value="Heb2"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecHebergementRep}" rendered="#{prisechge.patpecHebergementRep!=0}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText  value="Acte"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecSoins}" rendered="#{prisechge.patpecSoins!=0}"/><br>
                                        <h:outputText  value="#{prisechge.patpecSoinsHospit}" rendered="#{prisechge.patpecSoinsHospit!=0}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText value="Pha."/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecMedicament}" rendered="#{prisechge.patpecMedicament!=0}"/><br>
                                        <h:outputText  value="#{prisechge.patpecMedicamentHospit}" rendered="#{prisechge.patpecMedicamentHospit!=0}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText  value="Lab."/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecExamenss}" rendered="#{prisechge.patpecExamenss!=0}"/><br>
                                        <h:outputText  value="#{prisechge.patpecExamenssHospit}" rendered="#{prisechge.patpecExamenssHospit!=0}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"> <h:outputText  value="Pres."/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecPrestations}" rendered="#{prisechge.patpecPrestations!=0}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText  value="Hot."/></f:facet>
                                        <h:outputText  value="#{prisechge.patpacHotelerie}" rendered="#{prisechge.patpacHotelerie!=0}"/>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText value="Forf."/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecForfait}" rendered="#{prisechge.patpecForfait!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column width="5%">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText  value="#{prisechge.patpecInactif}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Ayants droit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patIdCouvertPar==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action>=1}">
                    <jsp:include flush="true" page="/medical/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid width="100%">
                            <h:panelGrid  id="btnAyantDroit" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action!=3}">
                                <a4j:commandButton  image="/images/ajouter.png" title="Ajouter un ayant droit"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.ajouterAyantDroit}" reRender="panelAyantDroit,btnAyantDroit"/>
                                <a4j:commandButton  image="/images/modifier.png" title="Modifier l'ayant droit sélectionné"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.modifierAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.afficheButtAyd}" reRender="panelAyantDroit,btnAyantDroit"/>
                                <a4j:commandButton  image="/images/detail.png" title="Consulter l'ayant droit sélectionné"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consulterAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.afficheButtAyd}" reRender="panelAyantDroit,btnAyantDroit"/>
                                <a4j:commandButton  image="/images/supprimer.png" title="Supprimer l'ayant droit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.supprimerAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.afficheButtAyd}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTableAyantDroit,btnAyantDroit"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTableAyantDroit" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.datamodelAyd}" var="ayd" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectionAyantDroit}" reRender="btnAyantDroit"/>
                                    <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{ayd.patDossier}" width="10%">
                                        <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                                        <h:outputText value="#{ayd.patDossier}" style="color:blue"/>
                                    </rich:column>
                                    <rich:column label="Civilité" sortable="true" sortBy="#{ayd.patCivilite}" width="5%">
                                        <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                        <h:outputText value="#{ayd.patCivilite}" style="color:blue"/>
                                    </rich:column>
                                    <rich:column label="Nom et prénom" sortable="true" sortBy="#{ayd.patNom} #{ayd.patPrenom}" width="25%" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                                        <h:outputText value="#{ayd.patNom} #{ayd.patPrenom}" title="#{ayd.patNom} #{ayd.patPrenom}" style="color:blue"/>
                                    </rich:column>
                                    <rich:column label="Date de naissance" sortable="true" sortBy="#{ayd.patDateNaissance}" width="10%">
                                        <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                                        <h:outputText value="#{ayd.patDateNaissance}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="N° C.I." sortable="true" sortBy="#{ayd.patCi}" width="10%">
                                        <f:facet name="header" ><h:outputText value="C.I."/></f:facet>
                                        <h:outputText value="#{ayd.patCi}" title="#{ayd.patCi}" style="color:blue"/>
                                    </rich:column>
                                    <rich:column label="N° mobile" sortable="true" sortBy="#{ayd.patCel1}" width="10%">
                                        <f:facet name="header" ><h:outputText value="Cellulaire"/></f:facet>
                                        <h:outputText value="#{ayd.patCel1}" title="#{ayd.patCel1}" style="color:blue"/>
                                    </rich:column>
                                    <rich:column label="Qualité" sortable="true" sortBy="#{ayd.patQualite}" width="20%">
                                        <f:facet name="header" ><h:outputText value="Qualité"/></f:facet>
                                        <h:outputText value="#{ayd.patQualite}" title="#{ayd.patQualite}" style="color:blue"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Assuré" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patIdCouvertPar!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action>=1}">
                    <jsp:include flush="true" page="/medical/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <jsp:include flush="true" page="/medical/tiersAssurePrincipal.jsp" />
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelButton">
                <center>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==71}">
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annuleDetailTiers}" reRender="idSubView"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.majPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_action!='3'}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==73}">
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.annuleDetailTiers}" reRender="idSubView"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.majPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_action!='3'}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==74||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==741}">
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annuleDetailTiers}" reRender="idSubView"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.majPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action!='3'}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==76}">
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.annuleDetailTiers}" reRender="idSubView"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.majPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_action!='3'}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==77}">
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annuleDetailTiers}" reRender="idSubView"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.majPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_action!='3'}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView"/>
                    </h:column>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelDateNaissance" headerClass="headerPanel" width="250" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelCalculDateNaissance}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelCalculDateNaissance}" var="pdn">
            <f:facet name="header"><h:outputText value="CALCUL DATE NAISSANCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.fermerCalculDateNaissance}" reRender="panelDateNaissance"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50d" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Né(e) vers:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nevers}" style="width:80px;"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50d" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Nombre années:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nbAnnee}" style="width:80px;"/></h:column>
                        <h:column><h:outputText value="Nombre mois"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nbMois}" style="width:80px;"/></h:column>
                        <h:column><h:outputText value="Nombre jours"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nbJours}" style="width:80px;"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valDateNaissance">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.valideCalculDateNaissance}" reRender="panelDateNaissance,idDateNaissance,idDateNaissanceAyantDoit"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAyantDroit" headerClass="headerPanel" width="1000" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelFicheAyantDroit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelFicheAyantDroit}" var="ayd">
            <f:facet name="header"><h:outputText value="AYANT DROIT de #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.fermerAyantDroit}" reRender="panelAyantDroit"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">
                    <rich:tab label="Identité">
                        <h:panelGrid  width="100%" >
                            <h:panelGrid styleClass="fichefournisseur">
                                <h:panelGrid  width="100%">
                                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idPatIdent">
                                        <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCivilite}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.mesCivilitesItems}" />
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.calculeGenreAyantDroit}" reRender="idPatIdent,idGenre,idjf1,idjf2"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Genre:"/></h:column>
                                        <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50d" id="idGenre">
                                            <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patSexe}" >
                                                <f:selectItem itemLabel="Femme" itemValue="0"/>
                                                <f:selectItem itemLabel="Homme" itemValue="1"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPatIdent,idaydjf1,idaydjf2"/>
                                            </h:selectOneRadio>
                                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patDossier}" readonly="true"/>
                                        </h:panelGrid>
                                        <h:column><h:outputText value="Nom:" style="color:red;"/></h:column>
                                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patNom}"/></h:column>
                                        <h:column><h:outputText value="Prénom:"/></h:column>
                                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPrenom}"/></h:column>
                                        <h:column><h:outputText value="Surnom:"/></h:column>
                                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patSurnom}"/></h:column>
                                        <h:column><h:outputText id="idaydjf1" value="Nom jeune fille:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patSexe==0}"/></h:column>
                                        <h:column><h:inputText id="idaydjf2" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patNomJf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patSexe==0}"/></h:column>
                                        <h:column><h:outputText value="Langue parlée:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patLangueParle}"/></h:column>
                                        <h:column><h:outputText value="Qualité"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patQualite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                                <f:selectItem itemLabel="Conjoint(e)" itemValue="Conjoint(e)"/>
                                                <f:selectItem itemLabel="Enfant" itemValue="Enfant"/>
                                                <f:selectItem itemLabel="Parent direct" itemValue="Parent direct"/>
                                                <f:selectItem itemLabel="Parent par alliance" itemValue="Parent par alliance"/>
                                                <f:selectItem itemLabel="Famille proche" itemValue="Famille proche"/>
                                                <f:selectItem itemLabel="Famille éloignée" itemValue="Famille éloignée"/>
                                                <f:selectItem itemLabel="Famille par alliance" itemValue="Famille par alliance"/>
                                                <f:selectItem itemLabel="Autre" itemValue="Autre"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Né(e) (JJ/MM/AAAA) le:" style="color:red;"/></h:column>
                                        <h:column>
                                            <a4j:outputPanel layout="block" style="vertical-align:center;">
                                                <a4j:commandButton image="/images/dateNaissance.png" style="width:18px;height:18px;color:red;" title="Aide au calcul de la date naissance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.calculeDateNaissance}" reRender="panelDateNaissance"/>&nbsp;&nbsp;
                                                <rich:calendar id="idDateNaissanceAyantDoit"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patDateNaissance}" popup="true" />
                                            </a4j:outputPanel>
                                        </h:column>
                                        <h:column><h:outputText value="Lieu naissance:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patLieuNaissance}"/></h:column>
                                        <h:column><h:outputText value="N° Immatriculation ayant droit:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patImmatriculation}"/></h:column>
                                        <h:column><h:outputText value="N° Immatriculation assuré:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patImmatriculation}" readonly="true" disabled="true"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}"><h:outputText value="N° SECURITE SOCIALE:"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNSS:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patSecu}"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNAMGS:"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCnamgs}"/></h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                                <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                    <h:column><h:outputText value="Adresse:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                                    <h:column><h:outputText value="Rue N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patRue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Lot N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patLot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Ilot N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Porte N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Quartier:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patQuartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Commune:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCommune}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Zone:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patZone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Département:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patDepart}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Bâtiment:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patBatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Escalier:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patEtage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Boite Postale:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patBp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Cédex:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCedex}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patVille}"/>&nbsp;&nbsp;
                                        <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                    <h:column id="idpays">
                                        <h:selectOneMenu id="paysItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.mesPaysItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" width="100%">
                                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="N° C.I.:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCi" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCI}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCi"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="N° Passport:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idPassport" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPassport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUnicitePASSPORT}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idPassport"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Téléphone domicile:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idDom" style="width:100%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patTelDom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteTelDom}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idDom"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Mobile 1:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCel1" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCel1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel1"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                    </h:column>
                                    <h:column><h:outputText value="Mobile 2:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCel2" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCel2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel2"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                    </h:column>
                                    <h:column><h:outputText value="Mobile 3:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCel3" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patCel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.testUniciteCel3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel3"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                    </h:column>
                                    <h:column><h:outputText value="Skype:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patSkype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Mail 1:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patMail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:column><h:outputText style="width:100%;color:red;text-align:center" value="Les zones ROUGES sont obligatoires: le nom ET le genre ET la date de naissance ET (soit le téléphone domicile OU le mobile 1 OU le mobile 2 OU le mobile 3)"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Photo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action>=2}" >
                        <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPhoto==null}">
                                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.uploadedFile}"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}">
                                    <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                                </h:commandButton>
                                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPhoto!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.urlphoto}" width="100px" height="100px"/>&nbsp;
                                    <h:commandButton image="/images/annuler.gif" title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_action==3}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsAyantDroit.patPhoto==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>

                <br/>
                <center>
                    <h:panelGroup id="valAyantDroit">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.valideAyantDroit}" reRender="panelAyantDroit,idTableAyantDroit"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPec" headerClass="headerPanel" width="950" height="580" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelPec}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelPec}" var="ppec">
            <f:facet name="header"><h:outputText value="GESTION DES PRISES EN CHARGES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.annulerPec}" reRender="panelPec"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>

                <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                    <rich:tab id="tabdescrip" label="Descriptif">
                        <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
                            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35"width="100%" styleClass="fichefournisseur" id="idPanelPec">
                                <h:column><h:outputText value="Choix Tiers" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecType}">
                                        <f:selectItem itemLabel="Assurance" itemValue="Assurance"/>
                                        <f:selectItem itemLabel="IPM" itemValue="IPM"/>
                                        <f:selectItem itemLabel="Mutuelle/Assurance" itemValue="Mutuelle/Assurance"/>
                                        <f:selectItem itemLabel="Mutuelle" itemValue="Mutuelle"/>
                                        <f:selectItem itemLabel="Complémentaire" itemValue="Complémentaire"/>
                                        <f:selectItem itemLabel="Programme Médical" itemValue="Programme Médical"/>
                                        <f:selectItem itemLabel="Client Société" itemValue="Client Société"/>
                                        <f:selectItem itemLabel="Ministère" itemValue="Ministère"/>
                                        <f:selectItem itemLabel="Direction" itemValue="Direction"/>
                                        <f:selectItem itemLabel="Mairie" itemValue="Mairie"/>
                                        <f:selectItem itemLabel="Hôpital" itemValue="Hôpital"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.changeTiersPayant}" reRender="idPanelPec,cltajt"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Tiers payeur" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="cltajt" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_tiers}">
                                        <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,cltajt,idAdherent,formModalListeTiers,panelListeTiers"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Employeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecType=='IPM'}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idAdherent" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecNomEmployeur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecType=='IPM'}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.lesEmployeursItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="false"><h:outputText value="Agent à refacturer:"/></h:column>
                                <h:column rendered="false"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecAgentRefact}"/></h:column>
                                <h:column><h:outputText value="N° contrat:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecNumContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecIdCouvert!=0}"/></h:column>
                                <h:column><h:outputText value="N° Immat. Assuré"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecMatricule}"/></h:column>
                                <h:column><h:outputText value="Date début"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecDateDebut}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"/></h:column>
                                <h:column><h:outputText value="Date fin"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecDateFin}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" styleClass="fichefournisseur1" columns="3" columnClasses="clos40c,clos30,clos30" border="0">
                                <h:column><h:outputText value="L I B E L L E " style="text-align:center"/></h:column>
                                <h:column><h:outputText value="E X T E R N E " style="text-align:center"/></h:column>
                                <h:column><h:outputText value="H O S P I T A L I S A T I O N " style="text-align:center"/></h:column>
                                <h:column><h:outputText value="1 - Frais d'hospitalisation hébergement:"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecHebergementPlaf}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(plafond #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                                    <br>
                                    <h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecHebergementRep}"/>%
                                </h:column>
                                <h:column><h:outputText value="2- Actes et examens (%):"/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecSoins}"/>%</h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecSoinsHospit}"/>%</h:column>
                                <h:column><h:outputText value="3 - Fourniture pharmacie (%):"/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecMedicament}"/>%</h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecMedicamentHospit}"/>%</h:column>
                                <h:column><h:outputText value="4 - Laboratoire et examens complémentaires (%):"/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecExamenss}"/>%</h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecExamenssHospit}"/>%</h:column>
                                <h:column><h:outputText value="5 - Autres préstations de soins fournies (%):"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecPrestations}"/>%</h:column>
                                <h:column><h:outputText value="6 - Autres préstations d'hotelière fournies (%):"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpacHotelerie}"/>%</h:column>
                                <h:column><h:outputText value="Forfait global:"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecForfait}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabdescan" label="Scan prise en charge">
                        <h:panelGrid style="width:100%;">
                            <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecScan==null}">
                                    <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.uploadedFile}" accept="image/*"/>
                                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.ajouterPhotoPec}">
                                        <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                                    </h:commandButton>
                                    <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                                </h:panelGroup>
                                <br/>
                                <h:panelGroup  id="grp3" style="tex-align:center">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecScan!=null}">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.urlphoto}" width="100%" height="800px"/>&nbsp;
                                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.supprimerPhotoPec}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientPec.patpecScan==null}">
                                        <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                    </c:if>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>                    

                </rich:tabPanel>
                <br/>
                <center>
                    <h:panelGroup id="valPec">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.savePec}" reRender="panelPec,idTablePec"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelTiers}" var="ltiers">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.datamodelTiers}"  var="tiers">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectionTiers}"/>
                            <f:facet name="header"></f:facet>
                            <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                                <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                                <h:outputText value="#{tiers.tiecategorie}"/>
                            </rich:column>
                            <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="55%">
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
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.annuleTiers}" reRender="panelListeTiers,cltajt,idAdherent,idPanelGlobal"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.calculeTiers}" reRender="panelListeTiers,cltajt,idAdherent,idPanelGlobal"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPatientDoublon" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelPatientDublon}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelPatientDublon}" var="ltiers">
            <f:facet name="header"><h:outputText value="Patients déjà existant(e)s"/></f:facet>
            <a4j:form id="formModalListePatient">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tablePatient" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelPatientDoublon}"  var="patient">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectionPatientDoublon}" reRender="valpatient"/>
                            <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{patient.patDossier}" width="10%">
                                <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                                <h:outputText value="#{patient.patDossier}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{patient.patCivilite}" width="5%">
                                <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                <h:outputText value="#{patient.patCivilite}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="true" sortBy="#{patient.patNom} #{patient.patPrenom}" width="25%" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                                <h:outputText value="#{patient.patNom} #{patient.patPrenom}" title="#{patient.patNom} #{patient.patPrenom}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Date de naissance" sortable="true" sortBy="#{patient.patDateNaissance}" width="10%">
                                <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                                <h:outputText value="#{patient.patDateNaissance}" style="#{patient.couleur}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="N° C.I." sortable="true" sortBy="#{patient.patCi}" width="10%">
                                <f:facet name="header" ><h:outputText value="C.I."/></f:facet>
                                <h:outputText value="#{patient.patCi}" title="#{patient.patCi}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="N° mobile" sortable="true" sortBy="#{patient.telephone}" width="10%">
                                <f:facet name="header" ><h:outputText value="Téléphone"/></f:facet>
                                <h:outputText value="#{patient.telephone}" title="#{patient.telephone}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Adresse" sortable="true" sortBy="#{patient.patAdresse}" width="10%">
                                <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                                <h:outputText value="#{patient.patAdresse}" title="#{patient.patAdresse}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Mode de Prise en charge" sortable="true" sortBy="#{patient.libelleFamille}" width="7%">
                                <f:facet name="header" ><h:outputText value="Pec."/></f:facet>
                                <h:outputText value="#{patient.libelleFamille}" title="#{patient.libelleFamille}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Prise en charge Tiers" sortable="true" sortBy="#{patient.patSociete}#{patient.patAssurance}" width="13%">
                                <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                                <h:outputText value="#{patient.patSociete}#{patient.patAssurance}" title="#{patient.patSociete}#{patient.patAssurance}" style="#{patient.couleur}"/>
                            </rich:column>
                            <rich:column label="Prise en charge Mutuelle/Complémentaire" sortable="true" sortBy="#{patient.patComplementaire}" width="13%">
                                <f:facet name="header" ><h:outputText value="Mutuelle/Complémentaire"/></f:facet>
                                <h:outputText value="#{patient.patComplementaire}" title="#{patient.patComplementaire}" style="#{patient.couleur}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valpatient">
                    <center>
                        <a4j:commandButton value="Garder la nouvelle saisie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.fermerPatientDoublon}" reRender="panelPatientDoublon"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Prendre le patient sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.valideDoublon}" reRender="panelPatientDoublon,panelTabFrniss" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patientsDouble.patId!=0}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>