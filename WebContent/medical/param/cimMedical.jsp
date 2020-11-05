<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="cimMedical">

    <a4j:form id="cimMedicalform">

        <center><h2><h:outputText value="CLASSIFICATION INTERNATIONALE DES MALADIES (CIM)" style="color:green;"/></h2></center>
        <center>
            <a4j:commandButton id="btpanelImp" title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>
            <br><br>
        </center>

        <h:panelGrid id="panelGridcmdMed" width="100%" columns="1" style="border:1px solid green">

            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" height="150px" id="extcimMedical" style="cursor:pointer;"  headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCimMedical.datamodel}" var="cimmedcmd">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"  id="idrowcmdMedical"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCimMedical.initCimMedicalSelect}"  reRender="tabcimMed" />
                        <rich:column width="5%" sortable="true" sortBy="#{cimmedcmd.cimCodeCmd}">
                            <f:facet name="header" ><h:outputText value="Code CMD"/></f:facet>
                            <h:outputText value="#{cimmedcmd.cimCodeCmd}" />
                        </rich:column>
                        <rich:column width="95%" sortable="true" sortBy="#{cimmedcmd.cimLibCmd}">
                            <f:facet name="header" ><h:outputText value="Libellé CMD"/></f:facet>
                            <h:outputText value="#{cimmedcmd.cimLibCmd}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:column>

            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" height="340px" id="tabcimMed" style="cursor:pointer;" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCimMedical.datamodeldetail}" var="cimmeddet">
                        <rich:column width="10%" sortable="true" sortBy="#{cimmeddet.cimCode}">
                            <f:facet name="header" ><h:outputText value="Code CIM"/></f:facet>
                            <h:outputText value="#{cimmeddet.cimCode}" />
                        </rich:column>
                        <rich:column width="90%" sortable="true" sortBy="#{cimmeddet.cimLibelleFR}">
                            <f:facet name="header" ><h:outputText value="Libellé CIM"/></f:facet>
                            <h:outputText value="#{cimmeddet.cimLibelleFR}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <center>
                    <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
                    <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
                </center>
            </h:column>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>