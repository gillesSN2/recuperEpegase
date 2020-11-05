<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natfmprdvte">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES NATURES DES FAMILLES DES PRODUITS DE VENTES" style="color:green;"/></h2></center>

        <center>
            <h:panelGroup>
                <a4j:commandButton id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');">
                    <rich:toolTip id="toolprint" followMouse="true" direction="top-right" showDelay="500" value="Imprimer">
                    </rich:toolTip>
                </a4j:commandButton>
            </h:panelGroup>
        </center>
        <br>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesFamillesProduits.dataModel}"  var="nfmp" >
                <rich:column sortable="true" sortBy="#{nfmp.code}" width="20%">
                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                    <h:outputText value="#{nfmp.code}" id="cod" />
                </rich:column>
                <rich:column sortable="true" sortBy="#{nfmp.nom_FR}" width="80%">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText value="#{nfmp.nom_FR}" id="lib"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
