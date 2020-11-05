<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="Vide">

    <h:panelGrid  width="100%" headerClass="headerTab" columnClasses="cols" style="border:solid 0px green;" >
        <f:facet name="header"><h:outputText value="Répertoire des tiers"></h:outputText></f:facet>
        <a4j:form enctype="multipart/form-data">
            <h:panelGroup id="panelGlobal" style="border:solid 0px green;" >
                <h:panelGrid id="panelBouton" columns="28" styleClass="recherche" width="100%">
                    <a4j:commandButton title="Recherche les tiers qui commencent par A" value="A" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreA}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par B" value="B" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreB}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par C" value="C" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreC}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par D" value="D" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreD}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par E" value="E" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreE}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par F" value="F" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreF}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par G" value="G" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreG}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par H" value="H" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreH}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par I" value="I" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreI}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par J" value="J" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreJ}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par K" value="K" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreK}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par L" value="L" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreL}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par M" value="M" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreM}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par N" value="N" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreN}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par O" value="O" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreO}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par P" value="P" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreP}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par Q" value="Q" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreQ}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par R" value="R" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreR}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par S" value="S" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreS}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par T" value="T" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreT}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par U" value="U" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreU}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par V" value="V" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreV}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par W" value="W" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreW}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par X" value="X" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreX}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par Y" value="Y" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreY}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <a4j:commandButton title="Recherche les tiers qui commencent par Z" value="Z" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettreZ}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                    <h:column><h:inputText style="width:80px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.lettre}" /></h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" title="Recherche les tiers qui commencent par ..." value="Recherche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.rechercheLettre}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                        <rich:hotKey key="return" handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <br>
                <center>
                    <a4j:commandButton title="Calculer les statistiques" value="Calculer les statistiques" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.debutStatistiques}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,scrollTable,idlistetiers,panelStatistique"/>
                </center>
                <br>
                <h:panelGroup id="idResultat" styleClass="recherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.afficheStatistique}">
                    <center>
                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.modeGraph}">
                            <f:selectItem itemLabel="par Fournisseur/Suspect/Prospect/Client" itemValue="0"/>
                            <f:selectItem itemLabel="par Catégorie de Fourniseurs" itemValue="1"/>
                            <f:selectItem itemLabel="par Catégorie de clients" itemValue="2"/>
                            <f:selectItem itemLabel="par Litiges" itemValue="3"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.hideModele}" reRender="idResultat"/>
                        </h:selectOneMenu>
                        <br/><br/>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="idlistetiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.afficheStatistique}"/>
                <rich:dataGrid value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.dataModelTiers}" id="idlistetiers" var="repTers" columns="4" elements="12" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.afficheStatistique}">
                    <rich:panel bodyClass="pbody">
                        <f:facet name="header">
                            <a4j:commandLink value="#{repTers.tieraisonsocialenom} #{repTers.tieprenom}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.accesTiers}" style="text-decoration:none;"  reRender="panelTiers"></a4j:commandLink>
                        </f:facet>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:outputText value="Société:" style="font-weight:bold;" rendered="#{repTers.tietype=='90'}" ></h:outputText>
                            <h:outputText value="#{repTers.tieemployeur}" rendered="#{repTers.tietype=='90'}"/>
                            <h:outputText value="Type:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="#{repTers.libelle_typeTiers}" />
                            <h:outputText value="Adresse:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="#{repTers.tieadresse}" />
                            <h:outputText value="Tél.:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="#{repTers.tieburtel1}" />
                            <h:outputText value="Fax:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="#{repTers.tieburfax}" />
                            <h:outputText value="Mail:" style="font-weight:bold;"></h:outputText>
                            <h:outputLink value="mailto:#{repTers.tiemail1}">
                                <h:outputText value="#{repTers.tiemail1}" />
                            </h:outputLink>
                            <h:panelGrid width="100%">
                                <center>
                                    <h:column rendered="#{repTers.tiePhoto!=null}">
                                        <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.urlIpProd}/epegase/imageServlet/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.urlphoto}#{repTers.tiePhoto}" width="50px" height="50px" />
                                    </h:column>
                                    <h:column rendered="#{repTers.tietype=='90'&&repTers.tiePhoto==null}">
                                        <img alt="" src="images/no_photo.jpeg" width="50px" height="50px" />
                                    </h:column>
                                    <h:column rendered="#{repTers.tietype!='90'&&repTers.tiePhoto==null}">
                                        <img alt="" src="images/no_image.jpeg" width="50px" height="50px" />
                                    </h:column>
                                </center>
                            </h:panelGrid>
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                                <h:outputText value="Web:" style="font-weight:bold;"></h:outputText>
                                <h:outputLink id="lien" value="#{repTers.accesSite}" target="blank" onclick="true" style="text-decoration:none;">
                                    <h:outputText value="#{repTers.tieweb}" style="text-decoration:none;"/>
                                </h:outputLink>
                                <h:outputText value="Ville:" style="font-weight:bold;"></h:outputText>
                                <h:outputText value="#{repTers.tieville}" />
                                <h:outputText value="Pays:" style="font-weight:bold;"></h:outputText>
                                <h:outputText value="#{repTers.tienompays}" />
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:panel>
                </rich:dataGrid>
            </h:panelGroup>
        </a4j:form>
    </h:panelGrid>


    <rich:modalPanel domElementAttachment="parent"  id="panelTiers" headerClass="headerPanel" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;"width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.showModalPanelTiers}" var="tie">
            <jsp:include flush="true" page="/commun/ficheTiers.jsp"/>
        </c:if>
    </rich:modalPanel>


</f:subview>
