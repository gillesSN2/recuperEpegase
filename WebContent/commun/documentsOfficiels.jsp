<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="panelListeDoOfficiel">

    <a4j:form id="formDoc" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center>
            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.nature=='50'}">
                <h2>
                    <h:outputText value="DOCUMENTS FISCAUX #{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.choixRacine!=0}" style="color:green;font-size:16px;"/>&nbsp;&nbsp;
                    <h:commandButton title="Permutter la fiscalité des documents" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.permutterDocuments}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                </h2>
            </h:panelGroup>
        </center>

        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS OFFICIELS"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.dataModelDocumnts}" id="listeDoc" var="document" >
                    <f:facet name="header"></f:facet>
                    <rich:column>
                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.lectureDoc}" reRender="panalVisuPj"/>
                        <br>
                        <h:outputText value="#{document}"/>
                    </rich:column>
                </rich:dataGrid>
            </a4j:region>
        </h:panelGrid>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="LISTE DES CODES GENERAUX DES IMPOTS"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.dataModelCGI}" id="listeDocCGI" var="cgi" >
                    <f:facet name="header"></f:facet>
                    <rich:column>
                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{cgi}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.lectureDocCGI}" reRender="panalVisuPj"/>
                        <br>
                        <h:outputText value="#{cgi}"/>
                    </rich:column>
                </rich:dataGrid>
            </a4j:region>
        </h:panelGrid>
        <br>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="LISTE DES SITES OFFICIELS"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable  style="background:transparent;border:0px;border:solid 1px green" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.dataModelSites}" id="listeSites" var="site" >
                    <rich:column  width="20%" sortable="false">
                        <h:outputText value="#{site.nom}"/>
                    </rich:column>
                    <rich:column width="80%" sortable="false">
                        <h:outputLink id="lien" value="#{site.url}" target="blank" onclick="true" style="text-decoration:none;">
                            <h:outputText value="#{site.url}" style="text-decoration:none;"/>
                        </h:outputLink>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du document (#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fermerVisuCatalogue}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formDocumentsOfficiels.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>