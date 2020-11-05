<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="cmaMedical">

    <a4j:form id="cmaMedicalform">

        <center><h2><h:outputText value="COMPLICATION OU MORBIDITE ASSOCIEE (CMA)" style="color:green;"/></h2></center>
        <center>
            <a4j:commandButton title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>
            <br><br>
        </center>

        <h:panelGrid  id="panelGridcmdMed" width="100%" columns="1" style="border:1px solid green">

            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="extcmdMedical"/>
                    <rich:extendedDataTable rows="200" width="100%" id="extcmdMedical" style="max-height:100%;cursor:pointer;"  headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCmaMedical.datamodel}" var="varmedCma">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCmaMedical.initCmaMedicalSelect}"  reRender="tabcmdMed" />
                        <rich:column sortable="true"  width="10%" sortBy="#{varmedCma.cmaCode}">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{varmedCma.cmaCode}"/>
                        </rich:column>
                        <rich:column  width="60%" sortable="true" sortBy="#{varmedCma.cmaLibelleFr}">
                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                            <h:outputText  value="#{varmedCma.cmaLibelleFr}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{varmedCma.cmaCma}" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cma"/></f:facet>
                            <h:graphicImage url="#{varmedCma.etat}" rendered="#{varmedCma.inactifcma}">
                            </h:graphicImage>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{varmedCma.cmaCmas}" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cmas"/></f:facet>
                            <h:graphicImage url="#{varmedCma.etat}" rendered="#{varmedCma.inactifcmas}">
                            </h:graphicImage>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{varmedCma.cmaCmasnt}" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cmasnt"/></f:facet>
                            <h:graphicImage url="#{varmedCma.etat}" rendered="#{varmedCma.inactifcmasnt}">
                            </h:graphicImage>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:column>

        </h:panelGrid>

        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>