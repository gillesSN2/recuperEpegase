<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natrh">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES NATURES R.H." style="color:green;font-size:16px;"/></h2></center>

        <center>
            <h:panelGrid id="panelBtnCtiers">
                <a4j:commandButton title="Imprimer les natures des éléments R.H." id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>

        <h:panelGrid width="100%">
            <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableConvention" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesRH.dataModelNature}" var="nat">
                        <rich:column style="text-align:left;" sortable="true" sortBy="#{nat.code}" width="10%">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText value="#{nat.code}" style="#{nat.style}"/>
                        </rich:column>
                        <rich:column style="text-align:center;" sortable="true" sortBy="#{nat.valide}" width="10%">
                            <f:facet name="header"><h:outputText  value="Utilisé"/></f:facet>
                            <h:selectBooleanCheckbox  value="#{nat.valide}" rendered="#{nat.demande}"/>
                        </rich:column>
                        <rich:column style="text-align:left;" sortable="true" sortBy="#{nat.nom_FR}" width="60%">
                            <f:facet name="header"><h:outputText  value="Libellé Nature"/></f:facet>
                            <h:outputText  value="#{nat.nom_FR}" style="#{nat.style}"/>
                        </rich:column>
                        <rich:column style="text-align:right;" sortable="true" sortBy="#{nat.lot}" width="10%">
                            <f:facet name="header"><h:outputText  value="Chrono lié"/></f:facet>
                            <h:outputText  value="#{nat.lot}" style="#{nat.style}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGroup>
        </h:panelGrid>

        <br>
        <center>
            <a4j:commandButton id="idAllSelect" value="Tout sélectionnez" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesRH.allSelect}" reRender="tableConvention"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <a4j:commandButton id="idAllDeSelect" value="Tout dé-sélectionnez" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesRH.allDeSelect}" reRender="tableConvention"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton value="VALIDER" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formNaturesRH.majNatureRh}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
