<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="cmdMedical">

    <a4j:form id="cmdMedicalform">

        <center><h2><h:outputText value="CATEGORIE MAJEURE DES DIAGNOSTIQUES" style="color:green;"/></h2></center>
        <center>
            <a4j:commandButton title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>
            <br><br>
        </center>

        <h:panelGrid  id="panelGridcmdMed" width="100%" columns="1" style="border:1px solid green">

            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable width="100%" height="150px" id="extcmdMedical" style="cursor:pointer;"  headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCmdMedical.datamodel}" var="cmdmed">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCmdMedical.initCmdMedicalSelect}"  reRender="tabcmdMed" />
                        <rich:column width="5%" sortable="true" sortBy="#{cmdmed.cmdFamCode}">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{cmdmed.cmdFamCode}" />
                        </rich:column>
                        <rich:column width="95%" sortable="true" sortBy="#{cmdmed.cmdFamLibelleFr}">
                            <f:facet name="header"><h:outputText value="Libellé famille"/></f:facet>
                            <h:outputText value="#{cmdmed.cmdFamLibelleFr}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:column>

            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tabcmdMed" width="100%" height="340px" style="cursor:pointer;" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCmdMedical.datamodeldetail}" var="cmdmeddet">
                        <rich:column width="10%" sortable="true" sortBy="#{cmdmeddet.cmdDetCode}">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{cmdmeddet.cmdDetCode}" />
                        </rich:column>
                        <rich:column width="90%" sortable="true" sortBy="#{cmdmeddet.cmdDetLibelleFr}">
                            <f:facet name="header"><h:outputText value="Libellé catégorie"/></f:facet>
                            <h:outputText value="#{cmdmeddet.cmdDetLibelleFr}" />
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