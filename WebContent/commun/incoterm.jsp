<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="viewIncoterm">

    <a4j:form id="formIncoterm">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="LISTE DES INCOTERMS" style="color:green;"/></h2></center>

        <center>
            <h:panelGroup id="panIncotem">
                <a4j:commandButton title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGroup>
            <br><br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableIncoterm" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formIncoterm.datamodel}" var="incoterms">
                    <rich:column sortable="true" width="10%" sortBy="#{incoterms.code}">
                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                        <h:outputText value="#{incoterms.code}"/>
                    </rich:column>
                    <rich:column width="20%" sortable="true" sortBy="#{incoterms.libelle}">
                        <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                        <h:outputText value="#{incoterms.libelle}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="true" sortBy="#{incoterms.groupe}">
                        <f:facet name="header"><h:outputText value="Groupe"/></f:facet>
                        <h:outputText value="#{incoterms.groupe}"/>
                    </rich:column>
                    <rich:column width="60%" sortable="true">
                        <f:facet name="header"><h:outputText value="Description"/></f:facet>
                        <h:outputText value="#{incoterms.nom}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="panAnnule">
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
                <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
            </h:panelGroup>
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
