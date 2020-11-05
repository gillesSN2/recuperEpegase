<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="etatBilanSocial">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value="BILAN SOCIAL (CLIENT) : Zone #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.structureLog.strbilansocial}" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;"  columns="2">

            <rich:column id="rchpbListTab" width="25%" style="border:1px solid green;">

                <rich:panel id="rcolbListTab" >
                    <a4j:commandButton title="Imprimer" id="boutonImprimer" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.testImprimer}" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                </rich:panel>

                <rich:extendedDataTable id="tabletabnom" height="300px" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" width="100%" border="0" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.datamodeltabNom}" var="tableau">
                    <a4j:support eventsQueue="maQueue"  reRender="rcolbListTab,pngdElement,panelNombredecol" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.selectionTableau}"   event="onRowClick"  />
                    <rich:column width="100%" sortBy="#{tableau.tablisNum}" sortOrder="ASCENDING" sortable="false">
                        <f:facet name="header" ><h:outputText value="LISTE DES TABLEAUX" /></f:facet>
                        <h:outputText  value="#{tableau.tablisLibFR}"/>
                    </rich:column >
                </rich:extendedDataTable>

                <h:panelGroup id="panelNombredecol" >
                    <rich:extendedDataTable id="tableColonne"height="250px" activeClass="active-row" noDataLabel=" "  footerClass="bard" headerClass="headerTab" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.dataModelLesNomsCol}"   width="100%" border="0"   var="Nomcol">
                        <a4j:support eventsQueue="maQueue" oncomplete="changeColor(this)"  reRender="tabletabformule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.selectionColonne}"   event="onRowClick"  />
                        <rich:column width="30%" sortable="false">
                            <f:facet name="header" ><h:outputText value="C°" /></f:facet>
                            <h:outputText value="#{Nomcol.numCol}" />
                        </rich:column >
                        <rich:column width="35%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Période" /></f:facet>
                            <h:outputText value="#{Nomcol.libPeriodeCol}"  />
                        </rich:column >
                        <rich:column width="35%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Libellé" /></f:facet>
                            <h:outputText value="#{Nomcol.nomCol}"  />
                        </rich:column >
                    </rich:extendedDataTable>
                </h:panelGroup>
            </rich:column>

            <rich:column  width="75%" id="pngdElement" style="border:1px solid green;width:100%">

                <rich:extendedDataTable  id="tabelement" height="300px"  activeClass="active-row" noDataLabel=" "  footerClass="bard" headerClass="headerTab"  styleClass="bg" width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.datamodeltabElement}" var="element">
                    <a4j:support eventsQueue="maQueue" oncomplete="changeColor(this)" reRender="tabletabformule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.selectionElement}"   event="onRowClick"  />
                    <rich:column width="10%" sortable="false" sortBy="#{element.tabeleNum}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Ord."/></f:facet>
                        <h:outputText  value="#{element.tabeleNum}"/>
                    </rich:column >
                    <rich:column width="10%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Réf."/></f:facet>
                        <h:outputText  value="#{element.tabeleReference}"/>
                    </rich:column >
                    <rich:column width="80%" sortable="false">
                        <f:facet name="header" ><h:outputText value="LISTE DES POSTES "/></f:facet>
                        <h:outputText value="#{element.tabeleLibFR}"/>
                    </rich:column >
                </rich:extendedDataTable>

                <rich:extendedDataTable id="tabletabformule"height="250px"  activeClass="active-row" noDataLabel=" "  footerClass="bard"headerClass="headerTab" styleClass="bg"  width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.datamodeltabFormule}" var="formule">
                    <a4j:support eventsQueue="maQueue" oncomplete="changeColor(this)" reRender="rchpbFormule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.selectionFormule}"   event="onRowClick"  />
                    <rich:column width="20%" sortable="false" sortBy="#{formule.tabfor_id}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                        <h:outputText value="#{formule.var_sens}" />
                    </rich:column >
                    <rich:column width="80%" sortable="false">
                        <f:facet name="header" ><h:outputText value="FORMULE"/></f:facet>
                        <h:outputText value="#{formule.tabforFormule}" />
                    </rich:column >
                </rich:extendedDataTable>

            </rich:column>

        </h:panelGrid>
        <br>
        <center> 
            <h:commandButton id="idCancel" styleClass="exp_lienmenu" value="R E T O U R" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;
            <a4j:commandButton value="ETAT PAR DEFAUT" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBilanSocialConfigClient.genererDefautConfig}" onclick="if (!confirm('Etes-vous sur de vouloir charger les bilans sociaux par défaut ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="impgenPG,modAttente"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


     <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
         <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
