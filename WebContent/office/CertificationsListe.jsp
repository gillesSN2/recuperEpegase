<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="officeCertification">

    <a4j:form>

        <center> <h2><h:outputText value="MES CERTIFICATIONS - Nombre Certifications restant(s) : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.nbRestant}" style="color:green;"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid  columns="9" styleClass="recherche" width="100%">
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.inpEtat}" style="width:150px;">
                        <f:selectItem itemLabel="Certifications Envoyés" itemValue="0"/>
                        <f:selectItem itemLabel="Certifications Initiaux" itemValue="1"/>
                        <f:selectItem itemLabel="Certifications Achetés" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.periode}" style="width:150px;">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesPeriodesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,lesBoutons,scrollTable,msg,corps"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>

            <h:panelGrid id="panelBouton" columns="4" width="200px" style="height:34px">
                <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.initGrapheur}"/>
                <a4j:commandButton title="Acheter pack SMS" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.sup}" reRender="panelAchat,formModalAchat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.achatCertificationDocument}"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.pageIndex}" reRender="msg" id="scrollTable" maxPages="20" align="left" for="msg"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.var_nb_max}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.dataModelCertificationDocument}" id="msg" styleClass="bg" activeClass="active-row" noDataLabel=" " headerClass="headerTab" border="0" style="max-height:100%" width="100%" rowClasses="rows1,rows2,rowsd" var="msg" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.visualisationLigne}" reRender="idSubView,panelBouton"/>
                        <rich:column  width="10%" sortable="true" sortBy="#{msg.cerDateCreat}" sortOrder="DESCENDING" label="Date/heure">
                            <f:facet name="header"><h:outputText value="Date/heure"/></f:facet>
                            <h:outputText value="#{msg.cerDateCreat}">
                                <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="20%" sortable="true" sortBy="#{msg.libelleNature}" label="Type de document">
                            <f:facet name="header"><h:outputText value="Type document"/></f:facet>
                            <h:outputText value="#{msg.libelleNature}"/>
                        </rich:column>
                        <rich:column  width="20%" sortBy="#{msg.cerNum}" sortable="true" label="N° de document">
                            <f:facet name="header"><h:outputText value="N°"/></f:facet>
                            <h:outputText value="#{msg.cerNum}"/>
                        </rich:column>
                        <rich:column  width="50%" sortable="true" sortBy="#{msg.users.usrPatronyme}" label="Nom créateur">
                            <f:facet name="header"><h:outputText value="Nom créateur"/></f:facet>
                            <h:outputText value="#{msg.users.usrPatronyme}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelAchat" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="450" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModalPanelAchat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModalPanelAchat}">
            <f:facet name="header"><h:outputText value="ACHAT PACK CERTIFICATION"/></f:facet>
            <a4j:form id="formModalActionNew">
                <h:panelGrid  width="100%">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" >
                        <h:column><h:outputText value="Type de pack:" /></h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.var_pack}" >
                            <f:selectItem itemLabel="Pack 5.000 sms => 400.000 Fcfa" itemValue="1"/>
                            <f:selectItem itemLabel="Pack 10.000 sms => 750.000 Fcfa" itemValue="2"/>
                            <f:selectItem itemLabel="Pack 50.000 sms => 3.250.000 Fcfa" itemValue="3"/>
                            <f:selectItem itemLabel="Pack 100.000 sms => 5.500.000 Fcfa" itemValue="4"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.fermerAchat}" reRender="panelAchat"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.valideAchat}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAchat"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.valQteGraph}" >
                                <f:selectItem itemLabel="En quantité" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par emetteur" itemValue="1"/>
                                <f:selectItem itemLabel="par tiers" itemValue="2"/>
                                <f:selectItem itemLabel="par contact" itemValue="3"/>
                                <f:selectItem itemLabel="par campagne" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formCertificationDocument.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
