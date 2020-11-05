<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="ccamMedical">

    <a4j:form id="accl">

        <center><h2><h:outputText value="CODIFICATION COMMUNE DES ACTES MEDICAUX (CCAM)" style="color:green;"/></h2></center>
        <center>
            <a4j:commandButton title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp')"/>&nbsp;&nbsp;&nbsp;
            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.transfCcamProduit}" onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments CCAM en produit?')) return false;javascript:Richfaces.showModalPanel('modAttente');" value="Conversion en Produits" styleClass="exp_lienmenu"/>
            <br><br>
        </center>

        <h:panelGrid  columns="2" style="height:100%;"  width="100%">

            <h:column>
                <t:div style="cursor:pointer;border:solid 0px green;overflow:auto;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="500px" height="150px"  id="extccamMedicalRacine" rowClasses="rowsT1,rowsT2,rowstd" activeClass="active-row" noDataLabel=" "  style="cursor:pointer;border:solid 0px green;"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodel}" var="ccam">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  id="idrowcmdMedical"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.initCcamMedicalSelect}"  reRender="tdivccamMedicalSF" />
                            <rich:column width="10%">
                                <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{ccam.ccamFamCode}" />
                            </rich:column>
                            <rich:column width="90%">
                                <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                <h:outputText value="#{ccam.ccamFamLibFr}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </t:div>
            </h:column>

            <h:column >
                <t:div id="tdivccamMedicalSF" style="cursor:pointer;border:solid 0px green;overflow:auto;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="extccamMedicalSF" height="150px" width="500px" rowClasses="rowsT1,rowsT2,rowstd" activeClass="active-row" noDataLabel=" " style="cursor:pointer;border:solid 0px green;"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodelSniv}" var="ccamsf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodelSniv.rowCount>0}">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  id="idrowcmdMedical"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.initCcamMedicalSelectSF}"  reRender="tdivccamMedicalSSF"/>
                            <rich:column width="10%">
                                <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{ccamsf.ccamSfamCode}" />
                            </rich:column>
                            <rich:column width="90%">
                                <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                <h:outputText value="#{ccamsf.ccamSfamLibFr}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </t:div>
            </h:column>

            <h:column >
                <t:div id="tdivccamMedicalSSF" style="cursor:pointer;border:solid 0px green;overflow:auto;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="extccamMedicalSSF" height="150px" width="500px" rowClasses="rowsT1,rowsT2,rowstd" activeClass="active-row" noDataLabel=" " style="cursor:pointer;border:solid 0px green;"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodelSsniv}" var="ccamssf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodelSsniv.rowCount>0}">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  id="idrowcmdMedical"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.initCcamMedicalSelectSsF}"  reRender="tdivccamMedicalSSSF" />
                            <rich:column width="20%">
                                <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{ccamssf.ccamSsfamCode}" />
                            </rich:column>
                            <rich:column width="80%">
                                <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                <h:outputText value="#{ccamssf.ccamSsfamLibFr}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </t:div>
            </h:column>

            <h:column>
                <t:div id="tdivccamMedicalSSSF" style="cursor:pointer;border:solid 0px green;overflow:auto;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="extccamMedicalSSSF" height="150px" width="500px" rowClasses="rowsT1,rowsT2,rowstd" activeClass="active-row" noDataLabel=" " style="cursor:pointer;border:solid 0px green;"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodelSsniv}" var="ccamsssf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodelSssniv.rowCount>0}">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  id="idrowcmdMedical"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.initCcamMedicalSelectSssF}"  reRender="tdivccamMedicalDetF,accl" />
                            <rich:column width="20%">
                                <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{ccamsssf.ccamSssfamCode}" />
                            </rich:column>
                            <rich:column width="80%">
                                <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                <h:outputText id="ccamsssfamlibout"value="#{ccamsssf.ccamSssfamLibFr}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </t:div>
            </h:column>

        </h:panelGrid>

        <h:panelGrid  width="100%" id="tdivccamMedicalDetF">
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="extccamMedicalDetF" height="150px" width="100%" rowClasses="rowsT1,rowsT2,rowstd" activeClass="active-row" noDataLabel=" " style="cursor:pointer;border:solid 0px green;overflow:auto;"  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodeldetail}" var="ccamdetailf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCcamMedical.datamodeldetail.rowCount>0}">
                    <rich:column width="20%">
                        <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                        <h:outputText value="#{ccamdetailf.ccamDetCode}" />
                    </rich:column>
                    <rich:column width="80%">
                        <f:facet name="header" ><h:outputText value="Libelé"/></f:facet>
                        <h:outputText value="#{ccamdetailf.ccamDetLibFr}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
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