<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<center>
    <f:facet name="header"><h:outputText value="Génération QRCODE"/></f:facet>
    <f:facet name="controls">
        <h:panelGroup>
            <h:graphicImage value="/images/close.gif" id="hideQrCode"/>
            <rich:componentControl for="panelQrCode" attachTo="hideQrCode" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <a4j:form id="formModalQrCode" target="_blank">
        <h:panelGrid width="100%" >
            <h:panelGrid width="100%" style="border:solid 0px green;background-color:white;">
                <f:facet name="header"><h:outputText value="Format"/></f:facet>
                <br>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers!=null}" var="qUser">
                    <h:panelGrid  width="100%" columns="3" style="height:80px">
                        <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.imprimerQrJRV}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                        <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.imprimerQrPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        <a4j:commandButton image="/images/configuration.png" style="width:30px;height:30px" title="Configuration Permissions Android" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.ouvrirPermission}" reRender="panelPermission"/>
                    </h:panelGrid>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers!=null}" var="qTiers">
                    <h:panelGrid  width="100%" columns="2" style="height:80px">
                        <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerQrJRV}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                        <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerQrPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                    </h:panelGrid>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements!=null}" var="qImmolb">
                    <h:panelGrid  width="100%" columns="2" style="height:80px">
                        <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.imprimerQrJRV}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                        <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formAmortissements.imprimerQrPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menucompta.imp}"/>
                    </h:panelGrid>
                </c:if>
                <br>
            </h:panelGrid>
        </h:panelGrid>
    </a4j:form>
</center>