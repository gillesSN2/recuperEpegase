
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natfmprdvte">

    <a4j:form>

        <center><h2> <h:outputText value="LISTE DES PROVENANCES MEDICAUX" style="color:green;"/></h2></center>

        <h:panelGroup>
            <a4j:commandButton title="Imprimer" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
        </h:panelGroup><br/><br/>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProvenanceMedical.datamodel}"  var="nfmp">
                    <rich:column sortable="true"  width="20%"sortBy="#{nfmp.code}">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{nfmp.code}" id="cod" >
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="80%" sortable="true" sortBy="#{nfmp.nom_FR}"  >
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText  value="#{nfmp.nom_FR}" id="lib">
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
