<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="eleveFiche">

    <a4j:form id="formEleveFiche" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText  styleClass="titre" value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <h:panelGrid id="panelTabFrniss" width="100%">

            <rich:tabPanel switchType="client" immediate="true"  id="tabPanelEleve" style="border:0px;">

                <rich:tab label="Identité">
                    <h:panelGrid  width="100%" >
                        <h:panelGrid styleClass="fichefournisseur">
                            <h:panelGrid  width="100%">
                                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%"  id="idEleIdent">
                                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCivilite}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeGenre}" reRender="idEleIdent,idGenre,idjf1,idjf2"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Genre:"/></h:column>
                                    <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50d" id="idGenre">
                                        <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleSexe}" >
                                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEleIdent,idjf1,idjf2,idGenre"/>
                                        </h:selectOneRadio>
                                        <h:column>
                                            <h:outputText value="Dossier:"/>
                                            <h:inputText style="border:0px;color:red;width:70%;text-align:center" id="idMatricule" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleDossier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleId!=0}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.optionVentes.chronoMatricule!='1'}">
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeUnicite}" reRender="panelButton,idGenre,idMatricule"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="Nom:"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleNom}"/></h:column>
                                    <h:column><h:outputText value="Prénom:"/></h:column>
                                    <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.elePrenom}"/></h:column>
                                    <h:column><h:outputText id="idjf1" value="Nom jeune fille:"/></h:column>
                                    <h:column><h:inputText id="idjf2" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleNomJf}"/></h:column>
                                    <h:column><h:outputText value="Famille:"/></h:column>
                                    <h:column><h:inputText id="familleItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleNomFamille}"/></h:column>
                                    <h:column><h:outputText value="Né(e) le:"/></h:column>
                                    <h:column>
                                        <a4j:outputPanel layout="block">
                                            <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleDateNaissance}" popup="true"/>
                                        </a4j:outputPanel>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu naissance:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleLieuNaissance}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                <h:column><h:outputText value="Adresse:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                                <h:column><h:outputText value="Rue N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleRue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Lot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleLot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ilot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Porte N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.elePorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Quartier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleQuartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Commune:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCommune}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Zone:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleZone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Département:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleDepart}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Bâtiment:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleBatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Escalier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleEtage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Boite Postale:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleBp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Cédex:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCedex}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleVille}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                <h:column id="idpays">
                                    <h:selectOneMenu id="paysItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.elePays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" width="100%">
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Téléphone domicile:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleTelDom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Mobile 1:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 2:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Mobile 3:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/>&nbsp;&nbsp;
                                    <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                                </h:column>
                                <h:column><h:outputText value="Skype:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleSkype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Yahoo:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleYahoo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Msn:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleMsn}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Mail 1:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleMail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Annnée du Bac:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleAnneeBac}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Centre du Bac:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCentreBac}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Derniers Diplômes:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleDernierDiplome}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Statut Bourse:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleStatutBourse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Photo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
                    <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.elePhoto==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.uploadedFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.elePhoto!=null}">
                                <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.urlphoto}" width="100px" height="100px"/>&nbsp;
                                <h:commandButton image="/images/annuler.gif" title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==3}"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.elePhoto==null}">
                                <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                            </c:if>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Immatriculation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
                    <h:panelGrid columns ="2"  width="100%" columnClasses="cols,cols" styleClass="fichefournisseur1" >
                        <h:column>
                            <h:panelGrid id="idCompte" width="100%" columns="2" headerClass="headerTab" columnClasses="cols,cols">
                                <f:facet name="header"><h:outputText value="Interface comptable"/></f:facet>
                                <h:column>
                                    <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Compte principal:" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="tiecompte0" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte0}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Compte principal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierCompte0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Enlever Compte principal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerCompte0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte0!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte principal?')) return false" reRender="idCompte"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Compte (avance, acompte):" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="tiecompte1" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte1}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Compte (avance, acompte)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierCompte1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte (avance, acompte)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerCompte1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte1!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte (avance, acompte)?')) return false" reRender="idCompte"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Compte (à parvenir):" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="tiecompte2" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte2}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Compte (à parvenir)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierCompte2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte (à parvenir)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerCompte2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte2!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte (à parvenir)?')) return false" reRender="idCompte"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Compte (douteux, litiges):" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="tiecompte3" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte3}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Compte (douteux, litiges)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierCompte3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte (douteux, litiges)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerCompte3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte3!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte (douteux, litiges)?')) return false" reRender="idCompte"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Compte rattaché:" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="tiecompte4" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte4}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Compte rattaché" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierCompte4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte rattaché" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerCompte4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompte4!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte rattaché?')) return false" reRender="idCompte"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Interface SAGE:"/></h:column>
                                        <h:column>
                                            <h:inputText id="tiecompteSage" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleCompteSage}"/>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Transfert en compta.:"/></h:column>
                                        <h:column>
                                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleTransfertCpte}">
                                                <f:selectItem itemLabel="Oui" itemValue="0"/>
                                                <f:selectItem itemLabel="Non" itemValue="1"/>
                                            </h:selectOneRadio>
                                        </h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Contacts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid  id="btnContact" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ajouterContact}" reRender="panelContact,btnContact"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtContact}" reRender="panelContact,btnContact"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.consulterContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtContact}" reRender="panelContact,btnContact"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer contact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtContact}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableContact,btnContact"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableContact" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelContact}" var="contact" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selectionContact}" reRender="btnContact"/>
                                <rich:column sortable="true" sortBy="#{contact.eleconCivilite}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Civil."/></f:facet>
                                    <h:outputText  value="#{contact.eleconCivilite}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconNom}" width="30%">
                                    <f:facet name="header" ><h:outputText  value="Nom"/></f:facet>
                                    <h:outputText  value="#{contact.eleconNom} #{contact.eleconPrenom}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconFacture}" width="5%" style="text-align:center">
                                    <f:facet name="header" ><h:outputText  value="Facture"/></f:facet>
                                    <h:graphicImage value="/images/dollar.png" rendered="#{contact.eleconFacture==1}" style="text-align:center" height="20px" width="20px"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconNote}" width="5%"  style="text-align:center">
                                    <f:facet name="header" ><h:outputText  value="Note"/></f:facet>
                                    <h:graphicImage value="/images/bulletin.png" rendered="#{contact.eleconNote==1}" style="text-align:center"  height="20px" width="20px"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconTelDom}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Tél."/></f:facet>
                                    <h:outputText  value="#{contact.eleconTelDom}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconCel}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Cel."/></f:facet>
                                    <h:outputText  value="#{contact.eleconCel}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconMail}" width="20%">
                                    <f:facet name="header" ><h:outputText  value="Email"/></f:facet>
                                    <h:outputText  value="#{contact.eleconMail}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{contact.eleconQualite}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Qualité"/></f:facet>
                                    <h:outputText  value="#{contact.eleconQualite}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Scan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanScan">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ajouterDocumentScan}" reRender="panalAjoutFile"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.dataModelDocumnts}" id="listeDoc" var="document" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.lectureDoc}" reRender="panalVisuPj"/>
                                        <br>
                                        <h:outputText value="#{document}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Inscriptions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
                    <h:panelGrid width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid  id="btnInscription" columns="5" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter inscription"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ajouterInscription}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.autorisationInscription}" reRender="panelInscription,btnInscription"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier inscription"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.modifierInscription}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtInscription&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.autorisationInscription}" reRender="panelInscription,btnInscription"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter inscription"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.consulterInscription}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtInscription}" reRender="panelInscription,btnInscription"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer incription" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerInscription}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtInscription&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.autorisationInscription}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableInscription,btnInscription"/>
                            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtInscription&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.autorisationInscription}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.validerInscription}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="btnInscription,idEtat,idSit,tableFacture"/>
                            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtInscription&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.autorisationInscription}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.devaliderInscription}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="btnInscription,idEtat"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableInscription" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelInscription}" var="inscription" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selectionInscription}" reRender="btnInscription"/>
                                <rich:column sortable="true" sortBy="#{inscription.eleinsAnnee}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Année"/></f:facet>
                                    <h:outputText  value="#{inscription.eleinsAnnee}"/>
                                </rich:column>
                                <rich:column id="idEtat" sortable="true" sortBy="#{inscription.libelleEtat}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Etat"/></f:facet>
                                    <h:outputText  value="#{inscription.libelleEtat}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{inscription.filieresEducation.filCode}" width="40%">
                                    <f:facet name="header" ><h:outputText  value="Classe/Filière"/></f:facet>
                                    <h:outputText  value="#{inscription.filieresEducation.filCode} #{inscription.filieresEducation.filLibelle}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{inscription.eleinsTarifInscription}" width="10%"  style="text-align:right;">
                                    <f:facet name="header" ><h:outputText  value="Inscription"/></f:facet>
                                    <h:outputText  value="#{inscription.eleinsTarifInscription}" rendered="#{inscription.eleinsTarifInscription!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{inscription.eleinsTarifScolarite}" width="10%"  style="text-align:right;">
                                    <f:facet name="header" ><h:outputText  value="Scolarité"/></f:facet>
                                    <h:outputText  value="#{inscription.eleinsTarifScolarite}" rendered="#{inscription.eleinsTarifScolarite!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{inscription.libelleMode}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Mode"/></f:facet>
                                    <h:outputText  value="#{inscription.libelleMode}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Situation Elève" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrFactureCaisse!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=2}" >
                    <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="idSit"/>
                    <h:panelGrid id="idSit" width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid  id="btnFacture" columns="5" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}">
                            <a4j:commandButton image="/images/detail.png" title="Consulter facture/règlement"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.consulterFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture}" reRender="panelFacture,btnFacture"/>
                            <a4j:commandButton image="/images/print.png" title="Imprimer facture/Reçu"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.initImprimerFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture}" reRender="panelImpressionSituation"/>
                            <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacEtat==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableFacture" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelFacturation}" var="facture" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selectionFacture}" reRender="btnFacture"/>
                                <rich:column sortable="true" sortBy="#{facture.elefacAnnee}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Année"/></f:facet>
                                    <h:outputText  value="#{facture.elefacAnnee}"/>
                                </rich:column>
                                <rich:column id="idEtat" sortable="true" sortBy="#{facture.libelleEtat}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Etat"/></f:facet>
                                    <h:outputText  value="#{facture.libelleEtat}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.elefacNum}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="N° Facture"/></f:facet>
                                    <h:outputText  value="#{facture.elefacNum}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.elefacDate}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Date"/></f:facet>
                                    <h:outputText  value="#{facture.elefacDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.libelleMode}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Mode"/></f:facet>
                                    <h:outputText  value="#{facture.libelleMode}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.libelleType}" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Type"/></f:facet>
                                    <h:outputText  value="#{facture.libelleType}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.total}" width="10%" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText  value="Total"/></f:facet>
                                    <h:outputText  value="#{facture.total}" rendered="#{facture.total!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.elefacReglement}" width="10%" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText  value="Réglements"/></f:facet>
                                    <h:outputText  value="#{facture.elefacReglement}" rendered="#{facture.elefacReglement!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{facture.solde}" width="10%" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText  value="Solde"/></f:facet>
                                    <h:outputText  value="#{facture.solde}" rendered="#{facture.solde!=0}" style="text-align:right;">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid id="idSitTot" width="90%" styleClass="fichefournisseur1" columns="6">
                            <h:column><h:outputText value="Total factures:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.totalFacture}" disabled="true" readonly="true" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total règlements:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.totalReglement}" disabled="true" readonly="true" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Solde:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.sode}" disabled="true" readonly="true" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelButton">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annuleSaisie}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.majEleve}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.valideEleves&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,btnTiers,tableTiers"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.supprimerDocumentScan}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPj,listeDoc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerVisuDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER DE L'ELEVE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annulerDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.validerDocumentScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelContact" headerClass="headerPanel" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelCnt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelCnt}" var="pcnt">
            <f:facet name="header"><h:outputText value="GESTION DES CONTACTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annuleContact}" reRender="panelContact"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="civiliteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconPrenom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                    <h:column><h:outputText value="Qualité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="qualiteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconQualite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesQualiteItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Factures:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconFacture}">
                            <f:selectItem itemLabel="Ne reçoit pas les factures" itemValue="0"/>
                            <f:selectItem itemLabel="Reçoit les factures" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Notes:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconNote}">
                            <f:selectItem itemLabel="Ne reçoit pas les notes" itemValue="0"/>
                            <f:selectItem itemLabel="Reçoit les notes" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" styleClass="fichefournisseur1" width="100%" columnClasses="clos15,clos85">
                    <h:column><h:outputText value="Adresse:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconAdresse}"/></h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Tél. bur.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconTelBur}"/></h:column>
                    <h:column><h:outputText value="Tél. dom.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconTelDom}"/></h:column>
                    <h:column><h:outputText value="Cell.:"/></h:column>
                    <h:column>
                        <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCel}"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoiSmsZ4}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                    </h:column>
                    <h:column><h:outputText value="Mail 1:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconMail}"/></h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur1" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Employeur:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconEmployeur}"/></h:column>
                    <h:column><h:outputText value="Adresse:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconAdresseEmployeur}"/></h:column>
                    <h:column><h:outputText value="Téhéphone.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconTelBur}"/></h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Code banque:"/></h:column>
                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCodeBanque}"/></h:column>
                    <h:column><h:outputText value="Code Guichet:"/></h:column>
                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCodeGuichet}"/></h:column>
                    <h:column><h:outputText value="N° Compte:"/></h:column>
                    <h:column><h:inputText size="8" maxlength="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCompteBanque}"/></h:column>
                    <h:column><h:outputText value="N° Clé:"/></h:column>
                    <h:column><h:inputText size="3" maxlength="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCleRib}"/></h:column>
                    <h:column><h:outputText value="Code IBN:"/></h:column>
                    <h:column><h:inputText size="12" maxlength="34" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCodeIban}"/></h:column>
                    <h:column><h:outputText value="Code SWIFT:"/></h:column>
                    <h:column><h:inputText size="8" maxlength="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconCodeSwift}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                    <h:column><h:outputText value="Obs.:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesContact.eleconObs}"/></h:column>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valContact">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.saveContact}" reRender="panelContact,tableContact,btnContact"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInscription" headerClass="headerPanel" width="800" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelInscription}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelInscription}" var="ins">
            <f:facet name="header"><h:outputText value="GESTION DES INSCRIPTIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annuleInscription}" reRender="panelInscription"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>

                <h:panelGrid width="100%">
                    <rich:tabPanel switchType="client" immediate="true" id="tabPanelInscriptionEleve" style="border:0px;">

                        <rich:tab label="Inscription">
                            <h:panelGrid id="idMontant" width="100%">
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant1" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText style="text-decoration:underline;" value="Classe ou filière:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idClasseItem" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_filiere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <f:selectItem itemLabel="Sélection classe ou filière" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesFiliairesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeFiliere}" reRender="idMontant,idMontantEcheance"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Année scolaire"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsAnnee}" style="width:85%;color:red;text-align:center"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}"/></h:column>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <h:column><h:outputText value="Date inscription:"/></h:column>
                                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDate}" popup="true"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}"/></h:column>
                                    <h:column><h:outputText value="Date facturation:"/></h:column>
                                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateFacturation}" popup="true"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}"/></h:column>
                                    <h:column><h:outputText value="Frais inscription:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifInscription}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais ré-inscription:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifReinscription}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais dossier:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifDossier}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais assurance:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifAssurance}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant2" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Frais scolarité:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifScolarite}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Périodicité:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="civiliteItem" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsModeScolarite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <f:selectItem itemLabel="Mensuel" itemValue="0"/>
                                            <f:selectItem itemLabel="Trimestriel" itemValue="1"/>
                                            <f:selectItem itemLabel="Semestriel" itemValue="2"/>
                                            <f:selectItem itemLabel="Annuel" itemValue="3"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculDecoupage}" reRender="idMontantEcheance"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Frais transport:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifTransport}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais restauration/cantine:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifCantine}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant3" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Frais tenue:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifTenue}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais examens:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifExamens}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais association étudiante:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifAssociation}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais divers:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTarifDivers}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Imputations">
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre1">
                                <h:column><h:outputText value="Sélection site:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.site}" >
                                        <f:selectItem itemLabel="Tous sites" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerDepartement}" reRender="panFiltre1,idDepartement,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection département:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.departement}" >
                                        <f:selectItem itemLabel="Tous départements" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesDepartementsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerService}" reRender="panFiltre1,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection service:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.service}" >
                                        <f:selectItem itemLabel="Tous services" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesServicesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre2">
                                <h:column><h:outputText value="Sélection région:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.region}" >
                                        <f:selectItem itemLabel="Toutes régions" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesRegionsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerSecteur}" reRender="panFiltre2,idSecteur,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection secteurs:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.secteur}" >
                                        <f:selectItem itemLabel="Tous secteurs" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesSecteursItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerPdv}" reRender="panFiltre2,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection points de vente:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.pdv}" >
                                        <f:selectItem itemLabel="Tous points de vente" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesPdvItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre3">
                                <h:column><h:outputText value="Sélection Responsable:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idResponsable" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.responsable}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection Commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idCommercial" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.commercial}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Echéances">
                            <h:panelGrid styleClass="fichefournisseur" id="idMontantEcheance" width="100%" columns="1">
                                <h:panelGrid id="idTitre" columns="4" columnClasses="cols,cols,cols,cols" width="100%" style="text-align:center;font-weight:bold;" border="0">
                                    <h:column><h:outputText value="Date"/></h:column>
                                    <h:column><h:outputText value="Scolarité"/></h:column>
                                    <h:column><h:outputText value="Transport"/></h:column>
                                    <h:column><h:outputText value="Cantine"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance01" headerClass="headerTab" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche01!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche01}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style="background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance02" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche02!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche02}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance03" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche03!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche03}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance04" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche04!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche04}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance05" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche05!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche05}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance06" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche06!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche06}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance07" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche07!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche07}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance08" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche08!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche08}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance09" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche09!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche09}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance10" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche10!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche10}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance11" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche11!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche11}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance12" columns="4" columnClasses="cols,cols,cols,cols" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche12!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche12}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsScolarite12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsTransport12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsCantine12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription=='3'}" readonly="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valInscription">
                        <a4j:commandButton title="Recalcul des échéances" image="/images/actualiser.png" style="height:20px;width;20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculDecoupage}" reRender="idMontant,idMontantEcheance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription!='3'}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.saveInscription}" reRender="panelInscription,tableInscription,btnInscription,tableFacture" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionInscription!='3'}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelFacture" headerClass="headerPanel" width="800" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelFacture}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelFacture}" var="fac">
            <f:facet name="header"><h:outputText value="GESTION FACTURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerFacture}" reRender="panelFacture"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>

                <h:panelGrid width="100%">
                    <rich:tabPanel switchType="client" immediate="true"  id="tabPanelFactureEleve" style="border:0px;">

                        <rich:tab label="Facture">
                            <h:panelGrid id="idMontant" width="100%">
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant1" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText style="text-decoration:underline;" value="Classe ou filière:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idClasseItem" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_filiere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <f:selectItem itemLabel="Sélection classe ou filière" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesFiliairesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeFiliereFacture}" reRender="idMontant,idMontantEcheance"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Année scolaire"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacAnnee}" style="width:85%;color:red;text-align:center"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}"/></h:column>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <h:column><h:outputText value="Date facturation:"/></h:column>
                                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDate}" popup="true"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}"/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value="Frais inscription:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifInscription}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais ré-inscription:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifReinscription}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais dossier:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifDossier}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                     <h:column><h:outputText value="Frais assurance:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifAssurance}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant2" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Frais scolarité:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifScolarite}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Périodicité:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="civiliteItem" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacModeScolarite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <f:selectItem itemLabel="Mensuel" itemValue="0"/>
                                            <f:selectItem itemLabel="Trimestriel" itemValue="1"/>
                                            <f:selectItem itemLabel="Semestriel" itemValue="2"/>
                                            <f:selectItem itemLabel="Annuel" itemValue="3"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculDecoupageFacture}" reRender="idMontantEcheance"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Frais transport:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifTransport}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais restauration/cantine:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifCantine}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant3" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Frais tenue:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifTenue}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais examens:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifExamens}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais association étudiante:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifAssociation}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais divers:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifDivers}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Imputations">
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre">
                                <h:column><h:outputText value="Sélection site:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.site}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous sites" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection département:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.departement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous départements" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesDepartementsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerService}" reRender="panFiltre,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection service:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.service}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous services" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesServicesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection région:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.region}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Toutes régions" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesRegionsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection secteurs:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.secteur}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous secteurs" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesSecteursItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerPdv}" reRender="panFiltre,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection points de vente:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.pdv}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous points de vente" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesPdvItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre3">
                                <h:column><h:outputText value="Sélection Responsable:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idResponsable" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.responsable}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection Commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idCommercial" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.commercial}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Echéances" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacType==2}">
                            <h:panelGrid styleClass="fichefournisseur" id="idMontantEcheance" width="100%" columns="1">
                                <h:panelGrid id="idTitre" columns="4" width="100%" style="text-align:center;font-weight:bold;" border="0">
                                    <h:column><h:outputText value="Date"/></h:column>
                                    <h:column><h:outputText value="Scolarité"/></h:column>
                                    <h:column><h:outputText value="Transport"/></h:column>
                                    <h:column><h:outputText value="Cantine"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance01" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche01!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche01}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance02" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche02!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche02}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance03" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche03!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche03}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance04" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche04!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche04}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance05" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche05!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche05}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance06" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche06!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche06}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance07" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche07!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche07}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance08" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche08!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche08}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance09" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche09!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche09}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance10" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche10!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche10}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance11" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche11!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche11}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance12" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche12!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche12}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valFacture">
                        <a4j:commandButton title="Recalcul des échéances" image="/images/actualiser.png" style="height:20px;width;20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculDecoupageFacture}" reRender="idMontant,idMontantEcheance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture!='3'}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.saveInscription}" reRender="panelInscription,tableInscription,btnInscription" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture!='3'}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpressionSituation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintSituation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintSituation}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.closeImpressionSituation}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpressionSituation">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpSituation" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panelchoixDoc" width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele}" >
                            <f:selectItem itemLabel="Facture séléctionnée" itemValue="0"/>
                            <f:selectItem itemLabel="Situation de l`élève" itemValue="1"/>
                            <f:selectItem itemLabel="Reçu facture" itemValue="2"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelchoixDoc,choixDoc,docSelect,listeSelect"/>
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele==0}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele==1}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.listeImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="recuSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleRecu}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele==2}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.listeRecuItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerJRVSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerPDFSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerODTSituation}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerXLSSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerDOCSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerHTMLSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerXMLSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoieMAILSituation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelCompte" width="700" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelImmatriculation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelImmatriculation}" var="cpte">
            <f:facet name="header"><h:outputText value="AFFECTATION D'UN COMPTE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annuleCompte}" image="/images/close.gif" styleClass="hidelink" reRender="panelCompte"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" style="background-color:#DAEECB;">
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte}">
                        <f:selectItem itemLabel="Utiliser le compte ci-après:" itemValue="0" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==3}"/>
                        <f:selectItem itemLabel="Créer un nouveau compte:" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==3}"/>
                        <f:selectItem itemLabel="Compte d'attente:" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==3}"/>
                        <f:selectItem itemLabel="Saisie directe:" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte!=3}"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.redessineChoixCompte}" reRender="panelCompte,panelCompte,selectCompte"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br>
                <center>
                    <h2>
                        <h:outputText value="PLAN COMPTABLE #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixRacine==0}" style="color:green;font-size:16px;"/>
                        <h:outputText value="PLAN COMPTABLE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixRacine!=0}" style="color:green;font-size:16px;"/>&nbsp;&nbsp;
                        <h:commandButton title="Permutter la fiscalité du plan comptable" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.permutterRacines}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                    </h2>
                </center>
                <br>
                <h:panelGrid id="selectCompte" style="border:1px solid green;" width="100%">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==0}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.compte}" style="width:90%">
                            <f:selectItem itemLabel="Sélectionner un compte" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selectCompte}" reRender="buttCompte"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==2}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.maNature}"  style="width:90%">
                            <f:selectItem itemLabel="Sélectionner une nature" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesNatureCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargeRacineCompte}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,racItem1" />
                        </h:selectOneMenu>
                        <h:selectOneMenu id="racItem1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.maRacine}"  style="width:90%">
                            <f:selectItem itemLabel="Sélectionner une racine" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesRacineCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeCompte}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,intRac,GrpMunCpt,pgNumCpt,buttCompte" />
                        </h:selectOneMenu>
                        <h:outputText value="Racine/Compte:"/>
                        <h:panelGroup id="intRac" >
                            <h:outputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.racinecle}" />
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.partieCompte}">
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="buttCompte,GrpMunCpt,pgNumCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.valideCompte}"/>
                            </h:inputText>
                        </h:panelGroup>
                        <h:outputText value="Numero compte:"/>
                        <h:panelGroup id="GrpMunCpt">
                            <h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.planComptable.plcCompte}" readonly="true" required="true"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="buttCompte,GrpMunCpt,pgNumCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.valideCompte}"/>
                        </h:panelGroup>
                        <h:outputText value="Intitulé Compte:"/>
                        <h:panelGroup id="pgNumCpt">
                            <h:inputText style="margin-left:25px;width:400px;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleraisonsocialenom}" readonly="true"/>
                        </h:panelGroup>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCompte==3}">
                        <h:outputText value="N° compte:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.compte}" maxlength="20"/>
                    </c:if>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttCompte">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.saveCompte}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.existeCopteDeja}" reRender="panelCompte,idCompte"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpRecu" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintRecu}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintRecu}" var="prtrec">
            <f:facet name="header"><h:outputText value="Impression du reçu d'encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerImpressionRecu}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpRecu"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un format d'Impression" style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/tiers/EleveFactureCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelReglement}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>