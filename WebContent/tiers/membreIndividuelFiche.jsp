<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="individuelFiche">

    <a4j:form id="formIndividuelFiche"  enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">

            <rich:tab label="Identité">
                <h:panelGrid  width="100%" id="panGlobal">
                    <h:panelGrid  width="100%" styleClass="fichefournisseur1">
                        <h:panelGrid width="100%" columns="8" id="idNumCompteMF" style="color:red;text-align:center;">
                            <h:column><h:outputText value="CODE BANQUE:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.codeBanque}" size="5" disabled="true" readonly="true" style="color:red;text-align:center;"/></h:column>
                            <h:column><h:outputText value="CODE AGENCE:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.codeAgence}" style="color:red;text-align:center;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifAgence}">
                                    <f:selectItem itemLabel="Sélectionnez Agence" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPdvItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeNumCompteMF}" reRender="idnumCompteMF,idcleMF"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="NUMERO DE COMPTE:"/></h:column>
                            <h:column><h:inputText id="idnumCompteMF" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.numCompte}"  disabled="true" readonly="true" style="color:red;text-align:center;"/></h:column>
                            <h:column><h:outputText value="CLE CTRL:"/></h:column>
                            <h:column><h:inputText id="idcleMF" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.numCleCtrl}" size="2" disabled="true" readonly="true" style="color:red;text-align:center;"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                        <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecivilite}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeGenre}" reRender="idGenre"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Genre:"/></h:column>
                        <h:column>
                            <h:selectOneRadio id="idGenre"  style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesexe}" >
                                <f:selectItem itemLabel="Femme" itemValue="0"/>
                                <f:selectItem itemLabel="Homme" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Nom:"/></h:column>
                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h:column>
                        <h:column><h:outputText value="Prénom:"/></h:column>
                        <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieprenom}"/></h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCategoriesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculTiersdivers}" reRender="panGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tielangue}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}"><h:outputText value="Né(e) le:" /></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                            <a4j:outputPanel layout="block">
                                <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedatenaissance}" popup="true"/>
                            </a4j:outputPanel>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}"><h:outputText value="Lieu naissance:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}"><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tielieunaissance}"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}"><h:outputText value="Marié(e) le:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                            <a4j:outputPanel layout="block">
                                <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedatemariage}" popup="true"/>
                            </a4j:outputPanel>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}"><h:outputText value="Décédé(e) le:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                            <a4j:outputPanel layout="block">
                                <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedatedeces}" popup="true"/>
                            </a4j:outputPanel>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" styleClass="fichefournisseur1" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieadresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Rue N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tierue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Lot N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tielot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Ilot N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieilot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Porte N°:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieporte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Quartier:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiequartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Commune:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecommune}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Zone:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiezone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedepart}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Bâtiment:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Escalier:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieetage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Boite Postale:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Cédex:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecedex}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieville}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column id="idpays">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienompays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionPays}" reRender="idpays"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Longitude:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieX}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Latitude:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieY}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid styleClass="fichefournisseur" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Téléphone 1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieburtel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Téléphone 2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieburtel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Cellulaire:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieburtel3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieburfax}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieskype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Mail 1:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mail 2:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemail2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mail 3:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemail3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mail 4:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemail4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mail 5:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemail5}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Site Web:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieweb}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" styleClass="fichefournisseur1" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Observation:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieobservations}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column> <h:outputText style="text-decoration:underline;" value="Source:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesource}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSourceItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="1ère activité:"/></h:column>
                            <h:column id="idact1">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieactivite1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemValue="" itemLabel="Sélection 1ere activité" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPPItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText  value="2ème activité:"/></h:column>
                            <h:column id="idact2">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieactivite2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemValue="" itemLabel="Sélection 2eme activité" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPPItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Appréciation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienoteman}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Note automatique:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienoteauto} /20" readonly="true" style="width:100%;text-align:center;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value="ID STRUCTURE:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieIdStructure}" style="width:100%;text-align:center;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value=""/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value=""/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Complément" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid styleClass="fichefournisseur" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                    <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="N° Carte identté:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecinum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecidate}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Lieu:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecilieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Profession:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieprofession}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Habitation:"/></h:column>
                        <h:column>
                            <h:selectOneRadio style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiehabitation}" >
                                <f:selectItem itemLabel="Locataire" itemValue="0"/>
                                <f:selectItem itemLabel="Propriétaire" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Situation matrimoniale:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesitfam}" >
                                <f:selectItem itemLabel="Célibataire" itemValue="0"/>
                                <f:selectItem itemLabel="Concubin(e)" itemValue="1"/>
                                <f:selectItem itemLabel="Paxé(e)" itemValue="2"/>
                                <f:selectItem itemLabel="Marié(e)" itemValue="3"/>
                                <f:selectItem itemLabel="Divorcé(e)" itemValue="4"/>
                                <f:selectItem itemLabel="Veuf(ve)" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Niveau intruction:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieniveauetude}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Nb personne à charge:"/></h:column>
                        <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienbcharge}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Nb enfants à charge:"/></h:column>
                        <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienbenf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Nom du père:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienompere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Nom de la mère:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienommere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Photo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersPhotos.jsp" />
            </rich:tab>

            <rich:tab label="Immatriculation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}" >
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid columns ="2"  width="100%" columnClasses="cols,cols" styleClass="fichefournisseur1">
                    <h:column>
                        <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="cols,cols" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                            <f:facet name="header"><h:outputText value="Immatriculation"/></f:facet>
                            <h:column>
                                <h:panelGrid width="90%" columns="2" columnClasses="clos50d,clos50g">
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm01=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm01}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm01=='')==false}"><h:inputText id="num1" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm02=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm02}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm02=='')==false}"><h:inputText id="num2" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm03=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm03}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm03=='')==false}"><h:inputText id="num3" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm04=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm04}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm04=='')==false}"><h:inputText id="num4" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm05=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm05}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm05=='')==false}"><h:inputText id="num5" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum5}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm06=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm06}:" /></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm06=='')==false}"><h:inputText id="num6" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum6}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm07=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm07}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm07=='')==false}"><h:inputText id="num7" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum7}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm08=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm08}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm08=='')==false}"><h:inputText id="num8" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum8}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm09=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm09}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm09=='')==false}"><h:inputText id="num9" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum9}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm10=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm10}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm10=='')==false}"><h:inputText id="num10" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum10}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm11=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm11}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm11=='')==false}"><h:inputText id="num11" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum11}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm12=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm12}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm12=='')==false}"><h:inputText id="num12" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum12}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm13=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm13}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm13=='')==false}"><h:inputText id="num13" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum13}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm14=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm14}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm14=='')==false}"><h:inputText id="num14" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum14}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm15=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm15}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm15=='')==false}"><h:inputText id="num15" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum15}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm16=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm16}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm16=='')==false}"><h:inputText id="num16" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum16}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm17=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm17}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm17=='')==false}"><h:inputText id="num17" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum17}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm18=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm18}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm18=='')==false}"><h:inputText id="num18" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum18}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm19=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm19}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm19=='')==false}"><h:inputText id="num19" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum19}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm20=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm20}:"/></h:column>
                                    <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.objetImmatriculation.impm20=='')==false}"><h:inputText id="num20" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienum20}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                </h:panelGrid>
                            </h:column>
                        </h:panelGrid>
                    </h:column>
                    <h:column>
                        <h:panelGrid id="idCompte" width="100%" columns="2" headerClass="headerTab" columnClasses="cols,cols">
                            <f:facet name="header"><h:outputText value="Interface comptable"/></f:facet>
                            <h:column>
                                <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Compte principal:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="tiecompte0" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte0}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Compte principal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierCompte0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Enlever Compte principal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerCompte0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte0!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte principal?')) return false" reRender="idCompte"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Compte (avance, acompte):" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="tiecompte1" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte1}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Compte (avance, acompte)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierCompte1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte (avance, acompte)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerCompte1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte1!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte (avance, acompte)?')) return false" reRender="idCompte"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Compte (à parvenir):" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="tiecompte2" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte2}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Compte (à parvenir)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierCompte2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte (à parvenir)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerCompte2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte2!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte (à parvenir)?')) return false" reRender="idCompte"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Compte (douteux, litiges):" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="tiecompte3" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte3}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Compte (douteux, litiges)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierCompte3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte (douteux, litiges)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerCompte3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte3!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte (douteux, litiges)?')) return false" reRender="idCompte"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Compte rattaché:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText id="tiecompte4" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte4}" readonly="true"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Compte rattaché" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierCompte4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" reRender="panelCompte"/>&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Modifier Compte rattaché" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerCompte4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte4!=''}" onclick="if (!confirm('Etes-vous sur de vouloir enlever le Compte rattaché?')) return false" reRender="idCompte"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Interface SAGE:"/></h:column>
                                    <h:column>
                                        <h:inputText id="tiecompteSage" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompteSage}"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%"columns="2" columnClasses="clos50d,clos50g">
                                    <h:column><h:outputText value="Transfert en compta.:"/></h:column>
                                    <h:column>
                                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietransfertCpte}">
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

            <rich:tab label="Procuration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idProcuration">
                    <h:panelGrid  id="btnProcuration" columns="4" width="250px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter procuration"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutProcuration}" reRender="panelProcuration,btnProcuration"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier procuration"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifProcuration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelProcuration,btnProcuration"/>
                        <a4j:commandButton image="/images/detail.png" title="Consulter procuration"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consultProcuration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelProcuration,btnProcuration"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer procuration" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteProcuration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableProcuration,btnProcuration"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableProcuration" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel="PAS DE PROCURATION..." headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelProcuration}" var="contact" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulBanque}" reRender="btnProcuration"/>
                            <rich:column sortable="true" sortBy="#{contact.concivilite}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Civil."/></f:facet>
                                <h:outputText  value="#{contact.concivilite}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.connom}" width="40%">
                                <f:facet name="header" ><h:outputText  value="Nom"/></f:facet>
                                <h:outputText  value="#{contact.connom} #{contact.conprenom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conteldom}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Tél."/></f:facet>
                                <h:outputText  value="#{contact.conteldom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.concel1}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Cel."/></f:facet>
                                <h:outputText  value="#{contact.concel1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conmail1}" width="20%">
                                <f:facet name="header" ><h:outputText  value="Email"/></f:facet>
                                <h:outputText  value="#{contact.conmail1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.confonction}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Qualité"/></f:facet>
                                <h:outputText  value="#{contact.confonction}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Dispositons testamentaires" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idTestament">
                    <h:panelGrid  id="btnTestament" columns="4" width="250px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter disposition testamentaire"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutBanque}" reRender="panelBanque,btnTestament"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier disposition testamentaire"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifBanque}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelTestament,btnTestament"/>
                        <a4j:commandButton image="/images/detail.png" title="Consulter disposition testamentaire"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulBanque}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelTestament,btnTestament"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer disposition testamentaire" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTestament,btnTestament"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableTestament" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel="SANS DISPOSITION TESTAMENTAIRE..." headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelTestament}" var="contact" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulBanque}" reRender="btnTestament"/>
                            <rich:column sortable="true" sortBy="#{contact.concivilite}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Civil."/></f:facet>
                                <h:outputText  value="#{contact.concivilite}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.connom}" width="40%">
                                <f:facet name="header" ><h:outputText  value="Nom"/></f:facet>
                                <h:outputText  value="#{contact.connom} #{contact.conprenom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conteldom}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Tél."/></f:facet>
                                <h:outputText  value="#{contact.conteldom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.concel1}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Cel."/></f:facet>
                                <h:outputText  value="#{contact.concel1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conmail1}" width="20%">
                                <f:facet name="header" ><h:outputText  value="Email"/></f:facet>
                                <h:outputText  value="#{contact.conmail1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.confonction}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Qualité"/></f:facet>
                                <h:outputText  value="#{contact.confonction}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Conseillers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid  id="rep1" width="100%" columnClasses="cols" styleClass="fichefournisseur1">
                    <h:panelGrid  id="rep12"  headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                        <h:column>
                            <h:panelGrid  width="100%" id="responsable" styleClass="fichefournisseur1">
                                <h:panelGrid id="btnReponsable" columns="5" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" >
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterResponsable}" reRender="panelResponsable,btnReponsable"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modification Conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}" reRender="panelResponsable,btnReponsable"/>
                                    <a4j:commandButton image="/images/detail.png" title="Consultation Conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}" reRender="panelResponsable,btnReponsable"/>
                                    <a4j:commandButton image="/images/chef.png" title="Conseiller par défaut" onclick="if (!confirm('Voulez-vous le définir comme le Conseiller par défaut?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsableDefaut}" reRender="tableResponsable,btnReponsable" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Conseiller" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}" reRender="modAttente,tableResponsable,btnReponsable"/>
                                </h:panelGrid>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableResponsable" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelResponsable}" var="responsable" >
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" id="ajextFourniss" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterResponsable}" reRender="btnReponsable"/>
                                        <rich:column width="5%" >
                                            <f:facet name="header" ><h:outputText value="Déf."/></f:facet>
                                            <h:graphicImage  value="/images/chef.png" rendered="#{responsable.rpbdefaut==1}"/>
                                        </rich:column>
                                        <rich:column width="55%" >
                                            <f:facet name="header" ><h:outputText value="Conseiller"/></f:facet>
                                            <h:outputText value="#{responsable.rpbprenom}  #{responsable.rpbnom}"/>
                                        </rich:column>
                                        <rich:column width="20%" >
                                            <f:facet name="header" ><h:outputText value="Fonction"/></f:facet>
                                            <h:outputText value="#{responsable.rpbcategorie}"/>
                                        </rich:column>
                                        <rich:column width="10%"  >
                                            <f:facet name="header" ><h:outputText value="Du"/></f:facet>
                                            <h:outputText value="#{responsable.rpbdatedebut}"/>
                                        </rich:column>
                                        <rich:column width="10%" >
                                            <f:facet name="header" ><h:outputText value="Au"/></f:facet>
                                            <h:outputText value="#{responsable.rpbdatefin}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="tabScan" label="Scan documents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" id="idPanScan">
                    <h:panelGrid width="100%" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES"/></f:facet>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <h:panelGroup id="idScanGlobal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}">
                                <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterDocumentScan}" reRender="panalAjoutFile"/>
                            </h:panelGroup>
                            <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelDocumnts}" id="listeDoc" var="document" >
                                <f:facet name="header"></f:facet>
                                <rich:column>
                                    <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.lectureDoc}" reRender="panalVisuPj"/>
                                    <br>
                                    <h:outputText value="#{document}"/>
                                </rich:column>
                            </rich:dataGrid>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="tabCompte" label="Compte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" id="idPanCompte">
                    <h:panelGrid width="100%" headerClass="headerTab">

                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup id="panelButton">
            <center>
                <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleSaisie}" reRender="idSubView"/>&nbsp;&nbsp;
                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.majTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,btnTiers,tableTiers"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelCompte" width="700" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelImmatriculation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelImmatriculation}" var="cpte">
            <f:facet name="header"><h:outputText value="AFFECTATION D'UN COMPTE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleCompte}" image="/images/close.gif" styleClass="hidelink" reRender="panelCompte"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" style="background-color:#DAEECB;">
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte}">
                        <f:selectItem itemLabel="Utiliser le compte ci-après:" itemValue="0" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==3}"/>
                        <f:selectItem itemLabel="Créer un nouveau compte:" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==3}"/>
                        <f:selectItem itemLabel="Compte d'attente:" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==3}"/>
                        <f:selectItem itemLabel="Saisie directe:" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte!=3}"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.redessineChoixCompte}" reRender="panelCompte,panelCompte,selectCompte"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br>
                <center>
                    <h2>
                        <h:outputText value="PLAN COMPTABLE #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixRacine==0}" style="color:green;font-size:16px;"/>
                        <h:outputText value="PLAN COMPTABLE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixRacine!=0}" style="color:green;font-size:16px;"/>&nbsp;&nbsp;
                        <h:commandButton title="Permutter la fiscalité du plan comptable" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.permutterRacines}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                    </h2>
                </center>
                <br>
                <h:panelGrid id="selectCompte" style="border:1px solid green;" width="100%">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==0}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.compte}" style="width:90%">
                            <f:selectItem itemLabel="Sélectionner un compte" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectCompte}" reRender="buttCompte"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==2}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.maNature}"  style="width:90%">
                            <f:selectItem itemLabel="Sélectionner une nature" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesNatureCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chargeRacineCompte}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,racItem1" />
                        </h:selectOneMenu>
                        <h:selectOneMenu id="racItem1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.maRacine}"  style="width:90%">
                            <f:selectItem itemLabel="Sélectionner une racine" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesRacineCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeCompte}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,intRac,GrpMunCpt,pgNumCpt,buttCompte" />
                        </h:selectOneMenu>
                        <h:outputText value="Racine/Compte:"/>
                        <h:panelGroup id="intRac" >
                            <h:outputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.racinecle}" />
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.partieCompte}">
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="buttCompte,GrpMunCpt,pgNumCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.valideCompte}"/>
                            </h:inputText>
                        </h:panelGroup>
                        <h:outputText value="Numero compte:"/>
                        <h:panelGroup id="GrpMunCpt">
                            <h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.planComptable.plcCompte}" readonly="true" required="true"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="buttCompte,GrpMunCpt,pgNumCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.valideCompte}"/>
                        </h:panelGroup>
                        <h:outputText value="Intitulé Compte:"/>
                        <h:panelGroup id="pgNumCpt">
                            <h:inputText style="margin-left:25px;width:400px;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" readonly="true"/>
                        </h:panelGroup>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixCompte==3}">
                        <h:outputText value="N° compte:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.compte}" maxlength="20"/>
                    </c:if>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttCompte">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveCompte}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.existeCopteDeja}" reRender="panelCompte,idCompte"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelResponsable" headerClass="headerPanel" width="650" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelResponsable}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelResponsable}" var="resp">
            <f:facet name="header"><h:outputText value="GESTION DES CONSEILLERS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annulerResponsable}" image="/images/close.gif" styleClass="hidelink" reRender="panelResponsable"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid style="background-color:#DAEECB;" width="100%">
                    <h:panelGrid  columns="1" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbid==0}">
                        <h:column><h:outputText value="Nom : Prénom"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="userItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixUsers}">
                                <f:selectItem itemLabel="Sélectionnez votre conseiller" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionResponsable}" reRender="valResponsable,outpAjt,idpanAjt,idpanRespon"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" width="100%" id="idpanRespon">
                        <h:column><h:outputText value="Nom:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbnom}" readonly="true" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Prénom:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbprenom}" readonly="true" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Fonction:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbcategorie}" readonly="true" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Date début:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbdatedebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                        <h:column><h:outputText value="Date fin:"/></h:column>
                        <h:column><rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbdatefin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valResponsable">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testDoubleResponsable}" reRender="panelResponsable,responsable"/>
                        <h:outputText  id="outpAjt" style="color:red;" value="Votre responsable doit être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testDoubleResponsable}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelProcuration" headerClass="headerPanel" width="900" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelProcuration}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelProcuration}" var="prc">
            <f:facet name="header"><h:outputText value="GESTION DES PROCURATIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleProcuration}" image="/images/close.gif" styleClass="hidelink" reRender="panelProcuration"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.concivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Né(e) le (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar   style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.condatenaissance}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.connom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conprenom}"/></h:column>
                    <h:column><h:outputText value="Qualité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="qualiteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.confonction}">
                            <f:selectItem itemLabel="Conjoint(e)" itemValue="Conjoint(e)"/>
                            <f:selectItem itemLabel="Enfant" itemValue="Enfant"/>
                            <f:selectItem itemLabel="Parent" itemValue="Parent"/>
                            <f:selectItem itemLabel="Associé(e)" itemValue="Associé(e)"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conlangue}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Numéro CI:"/></h:column>
                    <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conCiNum}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Délivré par:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conCiPar}"/></h:column>
                    <h:column><h:outputText value="Valable du (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conCiDateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Au (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conCiDateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                    </h:column>
                </h:panelGrid>

                <rich:tabPanel switchType="client" immediate="true" id="tabPanelContact" style="border:0px;">
                    <rich:tab label="Adresse">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conadresse}"/></h:column>
                            <h:column><h:outputText value="Rue N°:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conrue}"/></h:column>
                            <h:column><h:outputText value="B.P.:"/></h:column>
                            <h:column><h:inputText maxlength="20" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conbp}"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conville}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.connompays}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Tél. bur.:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.contelbur}"/></h:column>
                            <h:column><h:outputText value="Tél. dom.:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conteldom}"/></h:column>
                            <h:column><h:outputText value="Cell. 1:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.concel1}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Cell. 2:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.concel2}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Cell. 3:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.concel3}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ4}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.confax}"/></h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conskype}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Mail 1:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conmail1}"/></h:column>
                            <h:column><h:outputText value="Mail 2:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conmail2}"/></h:column>
                            <h:column><h:outputText value="Site Web:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conweb}"/></h:column>
                            <h:column><h:outputText value="Blog:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conblog}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Photo">
                        <jsp:include flush="true" page="/tiers/membrePhotoProcuration.jsp" />
                    </rich:tab>

                    <rich:tab label="Signature">
                        <jsp:include flush="true" page="/tiers/membreSignatureProcuration.jsp" />
                    </rich:tab>

                </rich:tabPanel>

                <br/>
                <center>
                    <h:panelGroup id="valProcuration">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveProcuration}" reRender="panelProcuration,idContact"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelTestament" headerClass="headerPanel" width="900" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelTestament}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelTestament}" var="tes">
            <f:facet name="header"><h:outputText value="GESTION DES DISPOSTIONS TESTAMENTAIRES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleTestament}" image="/images/close.gif" styleClass="hidelink" reRender="panelTestament"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.concivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Né(e) le (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar   style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.condatenaissance}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.connom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conprenom}"/></h:column>
                    <h:column><h:outputText value="Qualité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="qualiteItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.confonction}">
                            <f:selectItem itemLabel="Conjoint(e)" itemValue="Conjoint(e)"/>
                            <f:selectItem itemLabel="Enfant" itemValue="Enfant"/>
                            <f:selectItem itemLabel="Parent" itemValue="Parent"/>
                            <f:selectItem itemLabel="Associé(e)" itemValue="Associé(e)"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conlangue}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Numéro CI:"/></h:column>
                    <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conCiNum}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Délivré par:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conCiPar}"/></h:column>
                    <h:column><h:outputText value="Valable du (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conCiDateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Au (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conCiDateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                    </h:column>
                </h:panelGrid>

                <rich:tabPanel switchType="client" immediate="true" id="tabPanelContact" style="border:0px;">
                    <rich:tab label="Adresse">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conadresse}"/></h:column>
                            <h:column><h:outputText value="Rue N°:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conrue}"/></h:column>
                            <h:column><h:outputText value="B.P.:"/></h:column>
                            <h:column><h:inputText maxlength="20" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conbp}"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conville}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.connompays}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Tél. bur.:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.contelbur}"/></h:column>
                            <h:column><h:outputText value="Tél. dom.:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conteldom}"/></h:column>
                            <h:column><h:outputText value="Cell. 1:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.concel1}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Cell. 2:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.concel2}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Cell. 3:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.concel3}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ4}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.confax}"/></h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conskype}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Mail 1:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conmail1}"/></h:column>
                            <h:column><h:outputText value="Mail 2:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conmail2}"/></h:column>
                            <h:column><h:outputText value="Site Web:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conweb}"/></h:column>
                            <h:column><h:outputText value="Blog:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsTestament.conblog}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <br/>
                <center>
                    <h:panelGroup id="valTestament">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveTestament}" reRender="panelTestament,idContact"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER DU MEMBRE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annulerDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:column><h:outputLabel value="Nom du document" /></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.validerDocumentScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <rich:hotKey key="return" handler="return false;"/>
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerDocumentScan}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPj,listeDoc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerVisuDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>