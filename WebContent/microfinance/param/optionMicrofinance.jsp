<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configmicrofinance">
    <a4j:form id="form1" >

        <center> <h2><h:outputText value="OPTIONS DE LA MICROFINANCE" style="color:green;"/></h2></center>

        <center>
            <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

                <rich:tab label="Entete">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value = "Nombre ligne maximum des documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.nbLigneMax}" style="width:300px;">
                                <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid columns="2">
                            <h:outputText value="Libellé 1:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}"/>
                            <h:outputText value="Libellé 2:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}"/>
                            <h:outputText value="Libellé 3:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}"/>
                            <h:outputText value="Libellé 4:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}"/>
                            <h:outputText value="Libellé 5:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}"/>
                            <h:outputText value="Libellé 6:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}"/>
                            <h:outputText value="Libellé 7:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}"/>
                            <h:outputText value="Libellé 8:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}"/>
                            <h:outputText value="Libellé 9:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}"/>
                            <h:outputText value="Libellé 10:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}"/>
                        </h:panelGrid>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton styleClass="exp_lienmenu" value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.creerOptionsVentes}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
        <center>
            <h:panelGroup id="prgoutpmessage">
                <h:messages infoStyle="color: red;" errorStyle="color: red;" />
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>