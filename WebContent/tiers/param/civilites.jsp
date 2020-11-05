
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="civilites">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES CIVILITES DES TIERS" style="color:green;"/></h2></center>

        <center>   <a4j:commandButton image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/></center><br/>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" width="100%" align="center" style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCivilites.dataModelCivilites}"  var="civilites" >
                <rich:column width="20%" sortable="false">
                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                    <h:outputText style="size:5px;margin-left:10px;" value="#{civilites.code}" id="cod" />
                </rich:column>
                <rich:column width="80%" sortable="false">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{civilites.nom_FR}" id="lib"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
