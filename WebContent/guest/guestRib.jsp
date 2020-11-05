<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="guestrib">

    <center><h2><h:outputText value="R.I.B" style="color:green;"/></h2></center>

    <a4j:form id="rib" >

        <h:panelGrid width="100%">
            <h:panelGroup>
                <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.visibiliteBton}" reRender="panelImp,formModalImp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableBanque" width="100%" height="500px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.datamodelContact}" var="contact" >
                    <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.selectionRib}" reRender="btnBanque"/>
                    <rich:column sortable="true" sortBy="#{contact.tiers.tieraisonsocialenom}" width="30%">
                        <f:facet name="header" ><h:outputText  value="Nom Banque"/></f:facet>
                        <h:outputText  value="#{contact.tiers.tieraisonsocialenom}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{contact.connumbanque}" width="8%">
                        <f:facet name="header" ><h:outputText  value="Baque"/></f:facet>
                        <h:outputText  value="#{contact.connumbanque}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{contact.conguichetbanque}" width="8%">
                        <f:facet name="header" ><h:outputText  value="Guichet"/></f:facet>
                        <h:outputText  value="#{contact.conguichetbanque}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{contact.concomptebanque}" width="15%">
                        <f:facet name="header" ><h:outputText  value="Compte"/></f:facet>
                        <h:outputText  value="#{contact.concomptebanque}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{contact.conclebanque}" width="5%">
                        <f:facet name="header" ><h:outputText  value="Rib"/></f:facet>
                        <h:outputText  value="#{contact.conclebanque}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{contact.coniban}" width="15%">
                        <f:facet name="header" ><h:outputText  value="Iban"/></f:facet>
                        <h:outputText  value="#{contact.coniban}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{contact.conswift}" width="15%">
                        <f:facet name="header" ><h:outputText  value="Swift"/></f:facet>
                        <h:outputText  value="#{contact.conswift}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.showModalPanelPrint}" var="prt">
            <center>
                <f:facet name="header"><h:outputText value="Impression"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.fermerImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp"/>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalImp" target="_blank">
                    <h:panelGrid width="100%" >
                        <h:panelGrid width="100%" style="border:solid 1px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <h:panelGrid  width="100%" columns="8" style="height:80px">
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.imprimerJRV}" onclick="javascript:Richfaces.hideModalPanel('panelImp');"/>
                                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            </h:panelGrid>
                            <br>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


</f:subview>