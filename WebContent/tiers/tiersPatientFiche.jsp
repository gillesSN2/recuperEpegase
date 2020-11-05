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

        <center><h2><h:outputText  styleClass="titre" value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <h:panelGrid id="panelTabFrniss" width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">

                <rich:tab label="Identité">
                    <h:panelGrid  width="100%" >
                        <h:panelGrid styleClass="fichefournisseur">
                            <h:panelGrid  width="100%">
                                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idPatIdent">
                                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCivilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesCivilitesItems}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.calculeGenre}" reRender="idPatIdent,idGenre,idjf1,idjf2"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Genre:"/></h:column>
                                    <h:panelGrid columns="3" width="100%" columnClasses="clos35,clos15g,clos50" id="idGenre">
                                        <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSexe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.verrouSexe}">
                                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPatIdent,idjf1,idjf2,idGenre"/>
                                        </h:selectOneRadio>
                                        <h:column>
                                            <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSexe==0}"/>
                                            <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSexe==1}"/>
                                        </h:column>
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDossier}" readonly="true"/>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="Nom:" style="color:red"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Prénom:"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPrenom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Surnom:"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSurnom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText id="idjf1" value="Nom jeune fille:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSexe==0}"/></h:column>
                                    <h:column><h:inputText id="idjf2" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomJf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSexe==0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Langue parlée:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patLangueParle}"/></h:column>
                                    <h:column><h:outputText value="Site affecté:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="siteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCommune}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesSitesItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Né(e) le (JJ/MM/AAAA):" style="color:red;"/></h:column>
                                    <h:column>
                                        <a4j:outputPanel layout="block" style="vertical-align:center;">
                                            <a4j:commandButton image="/images/dateNaissance.png" style="width:18px;height:18px;color:red;" title="Aide au calcul de la date naissance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.calculeDateNaissance}" reRender="panelDateNaissance"/>&nbsp;&nbsp;
                                            <rich:calendar id="idDateNaissance" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDateNaissance}" popup="true" />
                                        </a4j:outputPanel>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu naissance:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patLieuNaissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                <h:column><h:outputText value="Adresse:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                                <h:column><h:outputText value="Rue N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patRue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ilot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Porte N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Quartier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patQuartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Bâtiment:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patBatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Escalier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patEtage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Boite Postale:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patBp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Cédex:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCedex}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patVille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                <h:column id="idpays">
                                    <h:selectOneMenu id="paysItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" width="100%">
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="N° C.I.:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="idCi" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCI}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCi"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="N° Passport:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="idPassport" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPassport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUnicitePASSPORT}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idPassport"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Téléphone domicile:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText id="idDom" style="width:100%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patTelDom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteTelDom}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idDom"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Mobile 1:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText id="idCel1" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCel1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel1"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 2:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText id="idCel2" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCel2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel2"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 3:" style="text-decoration:underline;color:red;"/></h:column>
                                <h:column>
                                    <h:inputText id="idCel3" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCel3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel3"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Skype:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSkype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Mail 1:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patMail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:column><h:outputText style="width:100%;color:red;text-align:center" value="Les zones ROUGES sont obligatoires: le nom ET le genre ET la date de naissance ET (soit le téléphone domicile OU le mobile 1 OU le mobile 2 OU le mobile 3)"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Infos.complémentaires"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}"  >
                    <jsp:include flush="true" page="/tiers/tiersPatientInfoComp.jsp" />
                </rich:tab>

                <rich:tab label="Photo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPhoto==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.uploadedFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPhoto!=null}">
                                <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlphoto}" width="100px" height="100px"/>&nbsp;
                                <h:commandButton image="/images/annuler.gif" title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPhoto==null}">
                                <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                            </c:if>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Prise en charge" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIdCouvertPar==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}" reRender="pec,cs,ncs" >
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}"><h:outputText value="N° de sécurité:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNSS:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSecu}" style="width:100%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                        <h:column><h:outputText value="N° CNAMGS:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCnamgs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Utilisateur Payeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idUserPayeur" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIdUserPaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                <f:selectItem itemLabel="Sans User payeur" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Salarié Payeur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSalariePaiement}" style="width:95%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid id="pec" width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid columns="2" width="60%" columnClasses="clos30,clo70d">
                            <h:column><h:outputText value="Mode prise en charge:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="pecItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPecItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionTypePec}" reRender="pec,ncs,fda"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="fda" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomFamille==-1}">
                            <h:panelGrid  id="btnFda" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter fiche droit à l'assistance"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterFda}" reRender="panelFda,btnFda"/>
                                <a4j:commandButton image="/images/modifier.png" title="Modifier fiche droit à l'assistance"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierFda}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtFda}" reRender="panelFda,btnFda"/>
                                <a4j:commandButton image="/images/detail.png" title="Consulter fiche droit à l'assistance"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterFda}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtFda}" reRender="panelFda,btnFda"/>
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer fiche droit à l'assistance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerFda}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtFda}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTableFda,btnFda"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTableFda" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelFda}" var="fda" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionFda}" reRender="btnFda"/>
                                    <rich:column label="Référence de la fiche" sortable="true" sortBy="#{fda.patlgaReference}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                                        <h:outputText value="#{fda.patlgaReference}"/>
                                    </rich:column>
                                    <rich:column label="Date de la fiche" sortable="true" sortBy="#{fda.patlgaDate}" width="10%">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{fda.patlgaDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Nature acte" sortable="true" sortBy="#{fda.patlgaNatureActe}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                                        <h:outputText value="#{fda.patlgaNatureActe}"/>
                                    </rich:column>
                                    <rich:column label="Nom acte" sortable="true" sortBy="#{fda.patlgaNomActe}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Nom"/></f:facet>
                                        <h:outputText value="#{fda.patlgaNomActe}"/>
                                    </rich:column>
                                    <rich:column label="Critère de sélection" sortable="true" sortBy="#{fda.patlgaCriteres}" width="20%">
                                        <f:facet name="header"><h:outputText  value="Critères"/></f:facet>
                                        <h:outputText value="#{fda.patlgaCriteres}"/>
                                    </rich:column>
                                    <rich:column label="Taux réduction" sortable="true" sortBy="#{fda.patlgaTauxReduction}" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Taux réduction"/></f:facet>
                                        <h:outputText value="#{fda.patlgaTauxReduction}" style="text-align:right">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Scan de la lettre" sortable="false" width="10%" style="text-align:center">
                                        <f:facet name="header"><h:outputText  value="Scan"/></f:facet>
                                        <a4j:commandButton title="Afficher Scan" image="#{fda.pj}" style="height:20px;width:20px" rendered="#{lga.pj!=null}" reRender="panelScan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficherScan}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid id="ncs" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomFamille==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomFamille==-2}">
                            <h:panelGrid  id="btnPec" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}">
                                <a4j:commandButton  image="/images/ajouter.png" title="Ajouter prise en charge"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterPec}" reRender="panelPec,btnPec"/>
                                <a4j:commandButton  image="/images/modifier.png" title="Modifier prise en charge"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtPec}" reRender="panelPec,btnPec"/>
                                <a4j:commandButton  image="/images/detail.png" title="Consulter prise en charge"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtPec}" reRender="panelPec,btnPec"/>
                                <a4j:commandButton  image="/images/supprimer.png" title="Supprimer prise en charge" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtPec}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTablePec,btnPec"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTablePec" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelPec}" var="prisechge" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionPec}" reRender="btnPec"/>
                                    <rich:column width="10%">
                                        <f:facet name="header"><h:outputText  value="Type"/></f:facet>
                                        <h:outputText value="#{prisechge.patpecType}"/>
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

                <rich:tab label="Ayants droit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIdCouvertPar==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}">
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid width="100%">
                            <h:panelGrid  id="btnAyantDroit" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}">
                                <a4j:commandButton  image="/images/ajouter.png" title="Ajouter un ayant droit"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterAyantDroit}" reRender="panelAyantDroit,btnAyantDroit"/>
                                <a4j:commandButton  image="/images/modifier.png" title="Modifier l'ayant droit sélectionné"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtAyd}" reRender="panelAyantDroit,btnAyantDroit"/>
                                <a4j:commandButton  image="/images/detail.png" title="Consulter l'ayant droit sélectionné"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtAyd}" reRender="panelAyantDroit,btnAyantDroit"/>
                                <a4j:commandButton  image="/images/supprimer.png" title="Supprimer l'ayant droit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerAyantDroit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtAyd}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTableAyantDroit,btnAyantDroit"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTableAyantDroit" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelAyd}" var="ayd" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionAyantDroit}" reRender="btnAyantDroit"/>
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

                <rich:tab label="Assuré" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIdCouvertPar!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}">
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <jsp:include flush="true" page="/tiers/tiersAssurePrincipal.jsp" />
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.griserModeCalcul}">
                    <jsp:include flush="true" page="/tiers/tiersPatientReglement.jsp" />
                </rich:tab>

                <rich:tab  label="Contacts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}">
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid  id="btnContact" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterContact}" reRender="panelContact,btnContact"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtContact}" reRender="panelContact,btnContact"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtContact}" reRender="panelContact,btnContact"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer contact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtContact}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableContact,btnContact"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableContact" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelContact}" var="contact" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionContact}" reRender="btnContact"/>
                                <rich:column sortable="true" sortBy="#{contact.patconCivilite}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Civil."/></f:facet>
                                    <h:outputText  value="#{contact.patconCivilite}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.patconNom}" width="40%">
                                    <f:facet name="header" ><h:outputText  value="Nom"/></f:facet>
                                    <h:outputText  value="#{contact.patconNom} #{contact.patconPrenom}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.patconTelDom}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Tél."/></f:facet>
                                    <h:outputText  value="#{contact.patconTelDom}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.patconCel}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Cel."/></f:facet>
                                    <h:outputText  value="#{contact.patconCel}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.patconMail}" width="20%">
                                    <f:facet name="header" ><h:outputText  value="Email"/></f:facet>
                                    <h:outputText  value="#{contact.patconMail}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.patconQualite}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Qualité"/></f:facet>
                                    <h:outputText  value="#{contact.patconQualite}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Groupe sanguin"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}"  >
                    <jsp:include flush="true" page="/tiers/tiersPatientGrSanguin.jsp" />
                </rich:tab>

                <rich:tab label="Dentition"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.optionMedical.dent!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}"  >
                    <jsp:include flush="true" page="/tiers/tiersPatientDentition.jsp" />
                </rich:tab>

                <rich:tab label="Protocoles"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}"  >
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid id="btnProtocole" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter un protocole"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterProtocole}" oncomplete="javascript:Richfaces.showModalPanel('panelProtocole');" reRender="panelProtocole,btnProtocole"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier un protocole"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtProtocole}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierProtocole}" reRender="panelProtocole,btnProtocole"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter un protocole"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtProtocole}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterProtocole}" reRender="panelProtocole,btnProtocole"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer un protocole" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtProtocole}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerProtocole}" reRender="modAttente,idTableProtocole,btnProtocole"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="idTableProtocole" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 0px green;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelProtocole}" var="protocoles" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionProtocole}" reRender="btnProtocole"/>
                                <rich:column  sortable="true"  width="40%"sortBy="#{protocoles.patprtCode}" >
                                    <f:facet name="header"><h:outputText  value="Protocoles" /></f:facet>
                                    <h:outputText value="#{protocoles.patprtCode} #{protocoles.patprtLibelle}"/>
                                </rich:column>
                                <rich:column  width="30%" sortable="true" sortBy="#{protocoles.patprtDateDebut}" >
                                    <f:facet name="header"><h:outputText  value="Du"/></f:facet>
                                    <h:outputText  value="#{protocoles.patprtDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="30%" sortable="true" sortBy="#{protocoles.patprtDatefin}">
                                    <f:facet name="header"><h:outputText  value="Au"/></f:facet>
                                    <h:outputText  value="#{protocoles.patprtDatefin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Antécédents"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}"  >
                    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid id="btnAntecedent" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter antécédent"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterAntecedent}" oncomplete="javascript:Richfaces.showModalPanel('panelAntecedent');" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier antécédent"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtAntecedent}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter antécédent"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtAntecedent}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficheButtAntecedent}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerAntecedent}" reRender="modAttente,idTableAntecedent,btnAntecedent"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="idTableAntecedent" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelAntecedent}" var="antec" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionAntedent}" reRender="btnAntecedent"/>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.patantCode}" >
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{antec.patantCode}"/>
                                </rich:column>
                                <rich:column  width="30%" sortable="true" sortBy="#{antec.patantFamille}" >
                                    <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                    <h:outputText value="#{antec.patantFamille}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.patantDate}" >
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{antec.patantDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="10%" sortable="true" sortBy="#{antec.patantEtat}">
                                    <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                    <h:outputText  value="#{antec.patantEtat}"/>
                                </rich:column>
                                <rich:column width="40%" sortable="true" sortBy="#{antec.patantObservation}">
                                    <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                    <h:outputText  value="#{antec.patantObservation}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelButton">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annuleSaisie}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.majPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action!=3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelContact" headerClass="headerPanel" width="800" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelCnt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelCnt}" var="pcnt">
            <f:facet name="header"><h:outputText value="GESTION DES CONTACTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annuleContact}" reRender="panelContact"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconCivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconPrenom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                    <h:column><h:outputText value="Qualité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="qualiteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconQualite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesQualiteItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                    <h:column><h:outputText value="Adresse:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconAdresse}"/></h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Tél. bur.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconTelBur}"/></h:column>
                    <h:column><h:outputText value="Tél. dom.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconTelDom}"/></h:column>
                    <h:column><h:outputText value="Cell.:"/></h:column>
                    <h:column>
                        <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconCel}"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ4}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                    </h:column>
                    <h:column><h:outputText value="Mail 1:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconMail}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                    <h:column><h:outputText value="Obs.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientContact.patconObs}"/></h:column>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valContact">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.saveContact}" reRender="panelContact,tableContact,btnContact"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelProtocole" headerClass="headerPanel" width="400" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPrt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPrt}" var="ppro">
            <f:facet name="header"><h:outputText value="GESTION DES PROTOCOLES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annuleProtocole}" reRender="panelProtocole"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" styleClass="fichefournisseur">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value = "Protocole:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="protocoleItem" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_protocole}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientProt.patprtId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesProtocoleItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Date début:"/></h:column>
                        <h:column>
                            <rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientProt.patprtDateDebut}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"  inputSize="8"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Date fin:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientProt.patprtDatefin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"  inputSize="8"></rich:calendar>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valProtocole">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanPro" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.saveProtocole}" reRender="panelProtocole,idTableProtocole,btnProtocole"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAntecedent" headerClass="headerPanel" width="600" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelAnt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelAnt}" var="pant">
            <f:facet name="header"><h:outputText value="GESTION DES ANTECEDENTS (codage (CDA)"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annuleAntecedent}" reRender="panelAntecedent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" styleClass="fichefournisseur">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Type antécédents:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="anteItem" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_antecedent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientAnt.patantId!=0}">
                                <f:selectItem itemLabel="Sélection nature antécédent" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAntecedentItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Date évènement:"/></h:column>
                        <h:column>
                            <rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientAnt.patantDate}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"  inputSize="8"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientAnt.patantEtat}">
                                <f:selectItem itemLabel="En cours" itemValue="En cours"/>
                                <f:selectItem itemLabel="Résolu" itemValue="Résolu"/>
                                <f:selectItem itemLabel="Non Résolu" itemValue="Non résolu"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Description:"/></h:column>
                        <h:column><h:inputTextarea style="width:100%" rows="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientAnt.patantObservation}"/></h:column>
                        <h:column><h:outputText value="Médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientAnt.patantMedecin}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valAntecedent">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAnt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.saveAntecedent}" reRender="panelAntecedent,idTableAntecedent,btnAntecedent"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelDateNaissance" headerClass="headerPanel" width="250" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelCalculDateNaissance}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelCalculDateNaissance}" var="pdn">
            <f:facet name="header"><h:outputText value="CALCUL DATE NAISSANCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerCalculDateNaissance}" reRender="panelDateNaissance"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50d" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Né(e) vers:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nevers}" style="width:80px;"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50d" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Nombre années:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nbAnnee}" style="width:80px;"/></h:column>
                        <h:column><h:outputText value="Nombre mois"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nbMois}" style="width:80px;"/></h:column>
                        <h:column><h:outputText value="Nombre jours"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.nbJours}" style="width:80px;"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valDateNaissance">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.valideCalculDateNaissance}" reRender="panelDateNaissance,idDateNaissance,idDateNaissanceAyantDoit"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAyantDroit" headerClass="headerPanel" width="1000" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelFicheAyantDroit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelFicheAyantDroit}" var="ayd">
            <f:facet name="header"><h:outputText value="AYANT DROIT de #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerAyantDroit}" reRender="panelAyantDroit"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">
                    <rich:tab label="Identité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}" >
                        <h:panelGrid  width="100%" >
                            <h:panelGrid styleClass="fichefournisseur">
                                <h:panelGrid  width="100%">
                                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="idPatIdent">
                                        <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCivilite}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesCivilitesItems}" />
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.calculeGenreAyantDroit}" reRender="idPatIdent,idGenre,idjf1,idjf2"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Genre:"/></h:column>
                                        <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50d" id="idGenre">
                                            <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patSexe}" >
                                                <f:selectItem itemLabel="Femme" itemValue="0"/>
                                                <f:selectItem itemLabel="Homme" itemValue="1"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPatIdent,idaydjf1,idaydjf2"/>
                                            </h:selectOneRadio>
                                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patDossier}" readonly="true"/>
                                        </h:panelGrid>
                                        <h:column><h:outputText value="Nom:" style="color:red;"/></h:column>
                                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patNom}"/></h:column>
                                        <h:column><h:outputText value="Prénom:"/></h:column>
                                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPrenom}"/></h:column>
                                        <h:column><h:outputText value="Surnom:"/></h:column>
                                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patSurnom}"/></h:column>
                                        <h:column><h:outputText id="idaydjf1" value="Nom jeune fille:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patSexe==0}"/></h:column>
                                        <h:column><h:inputText id="idaydjf2" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patNomJf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patSexe==0}"/></h:column>
                                        <h:column><h:outputText value="Langue parlée:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patLangueParle}"/></h:column>
                                        <h:column><h:outputText value="Qualité"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patQualite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
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
                                                <a4j:commandButton image="/images/dateNaissance.png" style="width:18px;height:18px;color:red;" title="Aide au calcul de la date naissance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.calculeDateNaissance}" reRender="panelDateNaissance"/>&nbsp;&nbsp;
                                                <rich:calendar id="idDateNaissanceAyantDoit"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patDateNaissance}" popup="true" />
                                            </a4j:outputPanel>
                                        </h:column>
                                        <h:column><h:outputText value="Lieu naissance:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patLieuNaissance}"/></h:column>
                                        <h:column><h:outputText value="N° Immatriculation ayant droit:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patImmatriculation}"/></h:column>
                                        <h:column><h:outputText value="N° Immatriculation assuré:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patImmatriculation}" readonly="true" disabled="true"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}"><h:outputText value="N° SECURITE SOCIALE:"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNSS:"/></h:column>
                                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patSecu}"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNAMGS:"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCnamgs}"/></h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                                <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                    <h:column><h:outputText value="Adresse:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                                    <h:column><h:outputText value="Rue N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patRue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Lot N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patLot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Ilot N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Porte N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Quartier:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patQuartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:outputText value="Commune:"/></h:column>
                                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCommune}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Zone:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patZone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Département:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patDepart}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Bâtiment:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patBatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Escalier:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patEtage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Boite Postale:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patBp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Cédex:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCedex}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patVille}"/>&nbsp;&nbsp;
                                        <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                    <h:column id="idpays">
                                        <h:selectOneMenu id="paysItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" width="100%">
                                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="N° C.I.:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCi" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCI}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCi"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="N° Passport:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idPassport" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPassport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUnicitePASSPORT}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idPassport"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Téléphone domicile:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idDom" style="width:100%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patTelDom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteTelDom}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idDom"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Mobile 1:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCel1" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCel1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel1"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                    </h:column>
                                    <h:column><h:outputText value="Mobile 2:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCel2" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCel2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel2"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                    </h:column>
                                    <h:column><h:outputText value="Mobile 3:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:inputText id="idCel3" style="width:85%;color:red;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patCel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testUniciteCel3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPatientDoublon,idCel3"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                    </h:column>
                                    <h:column><h:outputText value="Skype:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patSkype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Mail 1:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patMail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:column><h:outputText style="width:100%;color:red;text-align:center" value="Les zones ROUGES sont obligatoires: le nom ET le genre ET la date de naissance ET (soit le téléphone domicile OU le mobile 1 OU le mobile 2 OU le mobile 3)"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Photo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=2}" >
                        <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPhoto==null}">
                                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.uploadedFile}"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                                    <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                                </h:commandButton>
                                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPhoto!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlphoto}" width="100px" height="100px"/>&nbsp;
                                    <h:commandButton image="/images/annuler.gif" title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAyantDroit.patPhoto==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>

                <br/>
                <center>
                    <h:panelGroup id="valAyantDroit">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.valideAyantDroit}" reRender="panelAyantDroit,idTableAyantDroit"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPec" headerClass="headerPanel" width="950" height="580" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPec}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPec}" var="ppec">
            <f:facet name="header"><h:outputText value="GESTION DES PRISES EN CHARGES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annulerPec}" reRender="panelPec"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                    <rich:tab id="tabdescrip" label="Descriptif">
                        <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
                            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur" id="idPanelPec">
                                <h:column><h:outputText value="Choix Tiers" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}">
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
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.changeTiersPayant}" reRender="idPanelPec,cltajt"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Tiers payeur" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="cltajt" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_tiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}">
                                        <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,cltajt,idAdherent,formModalListeTiers,panelListeTiers"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Employeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='IPM'}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idAdherent" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecNomEmployeur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='IPM'}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.lesEmployeursItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="false"><h:outputText value="Agent à refacturer:"/></h:column>
                                <h:column rendered="false"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecAgentRefact}"/></h:column>
                                <h:column><h:outputText value="N° contrat:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecNumContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecIdCouvert!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/></h:column>
                                <h:column><h:outputText value="N° Immat. Assuré"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecMatricule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/></h:column>
                                <h:column><h:outputText value="Date début"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecDateDebut}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/></h:column>
                                <h:column><h:outputText value="Date fin"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecDateFin}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" styleClass="fichefournisseur1" columns="3" columnClasses="clos40c,clos30,clos30" border="0">
                                <h:column><h:outputText value="L I B E L L E " style="text-align:center"/></h:column>
                                <h:column><h:outputText value="E X T E R N E " style="text-align:center"/></h:column>
                                <h:column><h:outputText value="H O S P I T A L I S A T I O N " style="text-align:center"/></h:column>
                                <h:column><h:outputText value="1 - Frais d'hospitalisation hébergement:"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecHebergementPlaf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(plafond #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.structureLog.strdevise})"/>
                                    <br>
                                    <h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecHebergementRep}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%
                                </h:column>
                                <h:column><h:outputText value="2- Actes et examens (%):"/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecSoins}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecSoinsHospit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:outputText value="3 - Fourniture pharmacie (%):"/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecMedicament}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecMedicamentHospit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:outputText value="4 - Laboratoire et examens complémentaires (%):"/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecExamenss}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecExamenssHospit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:outputText value="5 - Autres préstations de soins fournies (%):"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecPrestations}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:outputText value="6 - Autres préstations d'hotelière fournies (%):"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpacHotelerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}"/>%</h:column>
                                <h:column><h:outputText value="Forfait global:"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column>
                                    <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecForfait}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.structureLog.strdevise})"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabdescan" label="Scan prise en charge">
                        <h:panelGrid style="width:100%;">
                            <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecScan==null}">
                                    <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.uploadedFile}" accept="image/*" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec!=3}"/>
                                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterPhotoPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec!=3}">
                                        <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                                    </h:commandButton>
                                    <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                                </h:panelGroup>
                                <br/>
                                <h:panelGroup  id="grp3" style="tex-align:center">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecScan!=null}">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlphoto}" width="100%" height="800px"/>&nbsp;
                                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerPhotoPec}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionPec!=3}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecScan==null}">
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
                        <a4j:commandButton image="/images/valider_big.png" id="idpanPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.savePec}" reRender="panelPec,idTablePec"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelFda" headerClass="headerPanel" width="950" height="580" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelFda}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelFda}" var="pfda">
            <f:facet name="header"><h:outputText value="GESTION DES FICHES DE DROIT A L'ASSISTANCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annulerFda}" reRender="panelFda"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                    <rich:tab id="tabdescrip" label="Descriptif">
                        <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur" id="idPanelPec">
                                <h:column><h:outputText value="Date de la fiche:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda==3}"/></h:column>
                                <h:column><h:outputText value="Référence de la fiche:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaReference}" maxlength="20"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda==3}"/></h:column>
                                <h:column><h:outputText value="Nature de l'acte:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaNatureActe}" maxlength="100" style="width:100%"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda==3}"/></h:column>
                                <h:column><h:outputText value="Nom de l'acte:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaNomActe}" maxlength="100" style="width:100%"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda==3}"/></h:column>
                                <h:column><h:outputText value="Taux réduction (%):"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaTauxReduction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda==3}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Critères de sélection:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaCriteres}" maxlength="100" style="width:100%"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda==3}"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabdescanFda" label="Scan fiche">
                        <h:panelGrid style="width:100%;">
                            <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaPhoto==null}">
                                    <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.uploadedFile}" accept="image/*" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda!=3}"/>
                                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterPhotoFda}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda!=3}">
                                        <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                                    </h:commandButton>
                                    <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                                </h:panelGroup>
                                <br/>
                                <h:panelGroup  id="grp3" style="tex-align:center">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaPhoto!=null}">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlphoto}" width="100%" height="800px"/>&nbsp;
                                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerPhotoFda}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionFda!=3}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaPhoto==null}">
                                        <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                    </c:if>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <br/>
                <center>
                    <h:panelGroup id="valFda">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanFda" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.saveFda}" reRender="panelFda,idTableFda"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelTiers}" var="ltiers">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.datamodelTiers}"  var="tiers">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionTiers}"/>
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
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annuleTiers}" reRender="panelListeTiers,cltajt,idAdherent,idPanelGlobal"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.calculeTiers}" reRender="panelListeTiers,cltajt,idAdherent,idPanelGlobal"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPatientDoublon" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPatientDublon}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelPatientDublon}" var="ltiers">
            <f:facet name="header"><h:outputText value="Patients déjà existant(e)s"/></f:facet>
            <a4j:form id="formModalListePatient">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tablePatient" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dataModelPatientDoublon}"  var="patient">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionPatientDoublon}" reRender="valpatient"/>
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
                        <a4j:commandButton value="Garder la nouvelle saisie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerPatientDoublon}" reRender="panelPatientDoublon"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Prendre le patient sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.valideDoublon}" reRender="panelPatientDoublon,panelTabFrniss" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsDouble.patId!=0}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>