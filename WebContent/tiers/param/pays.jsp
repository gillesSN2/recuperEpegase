<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="pays">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES PAYS" style="color:green;"/></h2></center>

        <center>   <a4j:commandButton image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/></center><br/>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" width="100%" align="center" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPays.dataModelPays}"  var="pays" >
                <rich:column width="5%" sortable="true" sortBy="#{pays.identification}">
                    <f:facet name="header"><h:outputText  value="Id."/></f:facet>
                    <h:outputText  value="#{pays.identification}"/>
                </rich:column>
                 <rich:column width="5%" sortable="true" sortBy="#{pays.iso}">
                    <f:facet name="header"><h:outputText  value="ISO"/></f:facet>
                    <h:outputText  value="#{pays.iso}"/>
                </rich:column>
                <rich:column width="25%" sortable="true" sortBy="#{pays.nom_FR}" sortOrder="ASCENDING">
                    <f:facet name="header"><h:outputText  value="Nom"/></f:facet>
                    <h:outputText style="size:5px;margin-left:10px;" value="#{pays.nom_FR}" />
                </rich:column>
                <rich:column width="25%" sortable="true" sortBy="#{pays.nationnalite_FR}">
                    <f:facet name="header"><h:outputText  value="Nationnalité"/></f:facet>
                    <h:outputText  value="#{pays.nationnalite_FR}"/>
                </rich:column>
                <rich:column width="5%" sortable="true" sortBy="#{pays.indicatif}">
                    <f:facet name="header"><h:outputText  value="Ind."/></f:facet>
                    <h:outputText  value="#{pays.indicatif}"/>
                </rich:column>
                <rich:column width="15%" sortable="true" sortBy="#{pays.fiscalite}">
                    <f:facet name="header"><h:outputText  value="Z.Fiscale"/></f:facet>
                    <h:outputText  value="#{pays.fiscalite}"/>
                </rich:column>
                <rich:column width="15%" sortable="true" sortBy="#{pays.zone}">
                    <f:facet name="header"><h:outputText  value="Z.Comm."/></f:facet>
                    <h:outputText  value="#{pays.zone}"/>
                </rich:column>
                <rich:column width="5%" sortable="true" sortBy="#{pays.devise}">
                    <f:facet name="header"><h:outputText  value="Devise"/></f:facet>
                    <h:outputText  value="#{pays.devise}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
