<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natBiens">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES NATURES DES BIENS" style="color:green;font-size:16px;"/></h2></center>

        <center>
            <a4j:commandButton image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');" />
        </center>
        <br/>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesBiens.dataModel}" width="100%" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" style="max-height:100%;border:solid 0px green;cursor:pointer;" var="nature" >
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                    <h:outputText  value="#{nature.code}"/>
                </rich:column>
                <rich:column width="50%">
                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                    <h:outputText  value="#{nature.nom_FR}"/>
                </rich:column>
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Location"/></f:facet>
                    <h:selectBooleanCheckbox  value="#{nature.valideLocation}"/>
                </rich:column>
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Syndic"/></f:facet>
                    <h:selectBooleanCheckbox  value="#{nature.valideSyndic}"/>
                </rich:column>
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Négoce"/></f:facet>
                    <h:selectBooleanCheckbox  value="#{nature.valideNegoce}"/>
                </rich:column>
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Promoteur"/></f:facet>
                    <h:selectBooleanCheckbox  value="#{nature.validePromoteur}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton value="VALIDER" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesBiens.majNatureBiens}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
