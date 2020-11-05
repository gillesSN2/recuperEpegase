<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="toutclient">

    <a4j:form id="formToutClient"  enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">

            <rich:tab label="Identité">
                <h:panelGrid  width="100%" id="panGlobal">
                    <h:panelGrid width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='010'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='020'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='030'}">
                                <h:column><h:outputText value="Raison sociale:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Sigle/Appartenance:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesigle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chronoActif||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCategoriesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculTiersdivers}" reRender="panGlobal"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tielangue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='010'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='020'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='030'}">
                                <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecivilite}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Genre:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesexe}" >
                                        <f:selectItem itemLabel="Femme" itemValue="0"/>
                                        <f:selectItem itemLabel="Homme" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Nom:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h:column>
                                <h:column><h:outputText value="Prénom:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieprenom}"/></h:column>
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
                        </h:panelGrid>
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
                                <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieville}"/>&nbsp;&nbsp;&nbsp;
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
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='010'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='020'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='030'}" var="ppm">
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieactivite1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItem itemValue="" itemLabel="Sélection 1ere activité" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPMItems}" />
                                    </h:selectOneMenu>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='010'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='020'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='030'}" var="pph">
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieactivite1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItem itemValue="" itemLabel="Sélection 1ere activité" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPPItems}" />
                                    </h:selectOneMenu>
                                </c:if>
                            </h:column>
                            <h:column><h:outputText  value="2ème activité:"/></h:column>
                            <h:column id="idact2">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='010'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='020'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre!='030'}" var="ppm">
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieactivite2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItem itemValue="" itemLabel="Sélection 2eme activité" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPMItems}" />
                                    </h:selectOneMenu>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='010'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='020'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiegenre=='030'}" var="pph">
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieactivite2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItem itemValue="" itemLabel="Sélection 2eme activité" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPPItems}" />
                                    </h:selectOneMenu>
                                </c:if>
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

            <rich:tab label="Immatriculation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}" >
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeImmatriculation}" reRender="panIdentification"/>
                <h:panelGrid columns ="2"  width="100%" columnClasses="cols,cols" styleClass="fichefournisseur1" id="panIdentification">
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

            <rich:tab  label="Contacts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idContact">
                    <h:panelGrid  id="btnContact" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutContact}" reRender="panelContact,btnContact" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}" reRender="panelContact,btnContact"/>
                        <a4j:commandButton image="/images/detail.png" title="Consulter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelContact,btnContact"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer contact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableContact,btnContact"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;" styleClass="fichefournisseur1" border="0" id="tableContact" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelContact}" var="contact" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulContact}" reRender="btnContact"/>
                            <rich:column sortable="true" sortBy="#{contact.concivilite}" width="5%">
                                <f:facet name="header" ><h:outputText  value="Civil."/></f:facet>
                                <h:outputText  value="#{contact.concivilite}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.connom}" width="20%">
                                <f:facet name="header" ><h:outputText  value="Nom"/></f:facet>
                                <h:outputText  value="#{contact.connom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conprenom}" width="15%">
                                <f:facet name="header" ><h:outputText  value="Prénom"/></f:facet>
                                <h:outputText  value="#{contact.conprenom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.contelbur}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Tél.Bur."/></f:facet>
                                <h:outputText  value="#{contact.contelbur}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conteldom}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Tel.Dom."/></f:facet>
                                <h:outputText  value="#{contact.conteldom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.concel1}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Cel."/></f:facet>
                                <h:outputText  value="#{contact.concel1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conmail1}" width="15%">
                                <f:facet name="header" ><h:outputText  value="Email"/></f:facet>
                                <h:outputText  value="#{contact.conmail1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.confonction}" width="15%">
                                <f:facet name="header" ><h:outputText  value="Fonction"/></f:facet>
                                <h:outputText  value="#{contact.confonction}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Conseillers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid  id="rep1" width="100%" columnClasses="cols" styleClass="fichefournisseur1">
                    <h:panelGrid  id="rep11"  headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="Visibilité du tiers"/></f:facet>
                        <h:column>
                            <h:panelGrid  width="100%" columns="1" >
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tievisibilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItem itemLabel="Public" itemValue="0"/>
                                        <f:selectItem itemLabel="Collaborateur" itemValue="1"/>
                                        <f:selectItem itemLabel="Privé" itemValue="2"/>
                                    </h:selectOneRadio>
                                </h:column>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  id="rep12"  headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                        <f:facet name="header"><h:outputText value="Conseillers du tiers"/></f:facet>
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

            <rich:tab label="Facturation"  rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.venteExist&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers)==true}"  >
                <jsp:include flush="true" page="/tiers/tiersFacturation.jsp" />
            </rich:tab>

            <rich:tab label="Règlement" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.venteExist&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.griserModeCalcul}">
                <jsp:include flush="true" page="/tiers/tiersReglement.jsp" />
            </rich:tab>

            <rich:tab label="Remise" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='3'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.venteExist&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.griserModeCalcul}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idRemise">
                    <h:panelGrid  width="100%">
                        <h:panelGrid  id="btnRemise" columns="3" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter remise" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterRemise}" reRender="panelRemise,btnRemise"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier remise" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierRemise}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testRemise}" reRender="panelRemise,btnRemise"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer remise" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteRemise}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testRemise}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRemise,btnRemise"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="400px" width="100%" enableContextMenu="false" headerClass="headerTab" id="tableRemise" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelBaremes}" var="bar">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionRemise}" reRender="btnRemise"/>
                                <rich:column  width="10%" sortBy="#{bar.barCategorieTiers}">
                                    <f:facet name="header"><h:outputText  value="Famille tiers"/></f:facet>
                                    <h:outputText value="#{bar.barCategorieTiers}"/>
                                </rich:column>
                                <rich:column  width="10%" sortBy="#{bar.barCodeProduit}">
                                    <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                                    <h:outputText value="#{bar.barCodeProduit}"/>
                                </rich:column>
                                <rich:column  width="30%" sortBy="#{bar.barLibelleProduit}">
                                    <f:facet name="header"><h:outputText  value="Libelle produit"/></f:facet>
                                    <h:outputText value="#{bar.barLibelleProduit}"/>
                                </rich:column>
                                <rich:column  width="10%" sortBy="#{bar.barCodeVte}">
                                    <f:facet name="header"><h:outputText  value="Code famille"/></f:facet>
                                    <h:outputText value="#{bar.barCodeVte}"/>
                                </rich:column>
                                <rich:column  width="20%" sortBy="#{bar.barLibelleVte}">
                                    <f:facet name="header"><h:outputText  value="Libellé famille"/></f:facet>
                                    <h:outputText value="#{bar.barLibelleVte}"/>
                                </rich:column>
                                <rich:column  width="10%"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Remise" /></f:facet>
                                    <h:outputText value="#{bar.barRemise}" rendered="#{bar.barRemise!=0}" style="text-align:right"/>
                                </rich:column>
                                <rich:column  width="10%"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.libelleRabRis}" /></f:facet>
                                    <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ristourne}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ristourne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column  width="10%"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Prix" /></f:facet>
                                    <h:outputText value="#{bar.barPrix}" rendered="#{bar.barPrix!=0}" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Produit Exo TVA" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='3'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.venteExist&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.griserModeCalcul}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idExoTva">
                    <h:panelGrid  width="100%">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout produits" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterProduitExo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableExoTva"/>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="400px" width="100%" enableContextMenu="false" headerClass="headerTab" id="tableExoTva" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelProdExoTva}" var="exo">
                                <rich:column  width="10%" sortBy="#{exo.exoTva}">
                                    <f:facet name="header"><h:outputText  value="Exonéré"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{exo.exoTva}"/>
                                </rich:column>
                                <rich:column  width="10%" sortBy="#{exo.code}">
                                    <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                                    <h:outputText value="#{exo.code}"/>
                                </rich:column>
                                <rich:column  width="80%" sortBy="#{exo.libelle}">
                                    <f:facet name="header"><h:outputText  value="Libelle produit"/></f:facet>
                                    <h:outputText value="#{exo.libelle}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
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
                
</f:subview>