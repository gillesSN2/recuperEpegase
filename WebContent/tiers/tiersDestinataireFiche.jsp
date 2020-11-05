<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="destinataireFiche">

    <a4j:form id="formDestinataireFiche">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre;" value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <h:panelGrid id="panelTabFrniss" width="100%" >

            <rich:tabPanel switchType="client" immediate="true"  id="tabPanelFrniss" style="border:0px;">

                <rich:tab label="Identité">
                    <h:panelGrid  columns="4"  style="background-color:#FFFFFF;width:100%;" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Civilité:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersCivilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItem itemLabel="Sans" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nom:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaNomFr}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Groupe:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersRegroupe}" maxlength="50" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                        <h:column><h:outputText value="Téléphone:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersTelephone}" style="width:100%;" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Fax:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersFax}" style="width:100%;" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersAdresse}" style="width:100%;" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value="B.P.:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersBp}" style="width:100%;" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column>
                            <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersVille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                        </h:column>
                        <h:column><h:outputText value="Pays:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersNompays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="eMail:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersMail}" style="width:100%;" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Devise:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersdevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesdevisesItem}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="4" style="background-color:#FFFFFF;width:100%;" columnClasses="clos15,clos35,clos15,clos35" >
                        <h:column><h:outputText value="Point de vente:" style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="pdv" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.codeAgence}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItem itemValue="" itemLabel="Sans point de vente"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPdvItems}"  />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Source:" style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTierssource}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSourceItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Appréciation:" style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersAppreciation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTiersObs}" style="width:100%;" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Langue:" style="text-decoration:underline"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.destinataires.anaTierslangue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>
            </rich:tabPanel>
            <br>
            <h:panelGroup id="panelButton">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.annuleSaisie}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.saveDestinataires}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers,tableTiers,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action!=3}"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>